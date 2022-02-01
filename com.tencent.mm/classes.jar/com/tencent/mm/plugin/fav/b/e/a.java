package com.tencent.mm.plugin.fav.b.e;

import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.f;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.o;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class a
  implements o
{
  private Queue<com.tencent.mm.plugin.fav.a.c> dim;
  private Map<String, f.a> dio;
  boolean diq;
  public int dis;
  long dit;
  public av dix;
  public n hTD;
  private g.a ibn;
  Map<String, a> rum;
  Set<String> run;
  boolean running;
  boolean ruo;
  int rup;
  boolean ruq;
  private Runnable rur;
  
  public a()
  {
    AppMethodBeat.i(101592);
    this.running = false;
    this.dis = 0;
    this.dit = 0L;
    this.diq = false;
    this.dim = new LinkedList();
    this.dio = new HashMap();
    this.rum = new HashMap();
    this.run = new HashSet();
    this.rup = 0;
    this.ruq = true;
    this.hTD = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(101584);
        boolean bool;
        com.tencent.mm.plugin.fav.a.c localc;
        try
        {
          bool = ay.isWifi(aj.getContext());
          ad.i("MicroMsg.Fav.FavCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(bool), Boolean.valueOf(a.this.ruo) });
          if ((paramAnonymousInt != 4) && (paramAnonymousInt != 6))
          {
            a.this.ruo = bool;
            AppMethodBeat.o(101584);
            return;
          }
          if ((!a.this.ruo) || (bool)) {
            break label471;
          }
          a locala1 = a.this;
          ad.i("MicroMsg.Fav.FavCdnService", "pauseAll");
          localCursor = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().cvg();
          if ((localCursor != null) && (localCursor.moveToFirst()))
          {
            while (localCursor.moveToNext())
            {
              localc = new com.tencent.mm.plugin.fav.a.c();
              localc.convertFrom(localCursor);
              ad.i("MicroMsg.Fav.FavCdnService", "pauseAll, pauseUpload dataId:%s", new Object[] { localc.field_dataId });
              localc.field_status = 4;
              ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
              f.aGI().EP(localc.field_dataId);
              a.h(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(localc.field_dataId));
              locala1.agz(localc.field_dataId);
            }
            localCursor.close();
          }
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.Fav.FavCdnService", localException, "", new Object[0]);
          AppMethodBeat.o(101584);
          return;
        }
        Cursor localCursor = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().cvh();
        if ((localCursor != null) && (localCursor.moveToFirst())) {
          while (localCursor.moveToNext())
          {
            localc = new com.tencent.mm.plugin.fav.a.c();
            localc.convertFrom(localCursor);
            ad.i("MicroMsg.Fav.FavCdnService", "pauseAll, pauseDownload dataId:%s", new Object[] { localc.field_dataId });
            localc.field_status = 4;
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
            f.aGI().EQ(localc.field_dataId);
            a.h(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(localc.field_dataId));
            localException.agz(localc.field_dataId);
          }
        }
        if (localCursor != null) {
          localCursor.close();
        }
        label471:
        if ((!a.this.ruo) && (bool))
        {
          a locala2 = a.this;
          ad.i("MicroMsg.Fav.FavCdnService", "startAll");
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().startAll();
          locala2.run();
        }
        a.this.ruo = bool;
        AppMethodBeat.o(101584);
      }
    };
    this.rur = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101587);
        long l = System.currentTimeMillis() - a.this.dit;
        if (a.this.running)
        {
          if (l < 300000L)
          {
            AppMethodBeat.o(101587);
            return;
          }
          ad.e("MicroMsg.Fav.FavCdnService", "klem ERR: Try Run service runningFlag:" + a.this.running + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + a.this.running);
        }
        ad.i("MicroMsg.Fav.FavCdnService", "do run cdn job, wait time %d", new Object[] { Long.valueOf(l) });
        a.this.diq = false;
        a.this.running = true;
        a.this.rup = 0;
        a.this.dis = 3;
        a.this.dix.az(100L, 100L);
        AppMethodBeat.o(101587);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(101588);
        String str = super.toString() + "|run";
        AppMethodBeat.o(101588);
        return str;
      }
    };
    this.dix = new av(com.tencent.mm.kernel.g.ajF().IdO.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(101589);
        try
        {
          a.this.aHZ();
          AppMethodBeat.o(101589);
          return false;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.Fav.FavCdnService", localException, "", new Object[0]);
          }
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(101590);
        String str = super.toString() + "|scenePusher";
        AppMethodBeat.o(101590);
        return str;
      }
    }, false);
    this.ibn = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(101591);
        if (paramAnonymousc != null) {
          ad.i("MicroMsg.Fav.FavCdnService", "cdn transfer callback, mediaid=%s, totallen=%d, offset=%d", new Object[] { paramAnonymousc.mediaId, Long.valueOf(paramAnonymousc.field_toltalLength), Long.valueOf(paramAnonymousc.field_finishedLength) });
        }
        Object localObject1 = "";
        if (paramAnonymousc != null) {
          localObject1 = paramAnonymousc.mediaId;
        }
        while ((paramAnonymousInt == -21006) || (paramAnonymousInt == -21005))
        {
          a.this.agz((String)localObject1);
          AppMethodBeat.o(101591);
          return 0;
          if (paramAnonymousd != null) {
            localObject1 = paramAnonymousd.mediaId;
          }
        }
        if (bt.isNullOrNil((String)localObject1)) {}
        for (;;)
        {
          localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(paramAnonymousString);
          if (localObject1 == null)
          {
            ad.e("MicroMsg.Fav.FavCdnService", "klem onCdnCallback info null");
            a.this.agz(paramAnonymousString);
            AppMethodBeat.o(101591);
            return 0;
          }
          if (paramAnonymousInt != 0)
          {
            ad.w("MicroMsg.Fav.FavCdnService", "cdn transfer callback, startRet=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.plugin.report.service.g.yhR.f(10660, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_type), Integer.valueOf(paramAnonymousInt) });
            ((com.tencent.mm.plugin.fav.a.c)localObject1).field_status = 4;
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a((com.tencent.mm.plugin.fav.a.c)localObject1, new String[0]);
            a.h((com.tencent.mm.plugin.fav.a.c)localObject1);
            a.this.agz(paramAnonymousString);
          }
          do
          {
            for (;;)
            {
              AppMethodBeat.o(101591);
              return 0;
              if (paramAnonymousc == null) {
                break;
              }
              ((com.tencent.mm.plugin.fav.a.c)localObject1).field_offset = ((int)paramAnonymousc.field_finishedLength);
              ((com.tencent.mm.plugin.fav.a.c)localObject1).field_totalLen = ((int)paramAnonymousc.field_toltalLength);
              ((com.tencent.mm.plugin.fav.a.c)localObject1).field_status = 1;
              ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a((com.tencent.mm.plugin.fav.a.c)localObject1, new String[0]);
            }
          } while (paramAnonymousd == null);
          Object localObject2;
          if (paramAnonymousd.field_retCode >= 0)
          {
            ((com.tencent.mm.plugin.fav.a.c)localObject1).field_status = 3;
            Object localObject3;
            if (1 == ((com.tencent.mm.plugin.fav.a.c)localObject1).field_type)
            {
              paramAnonymousc = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_path + ".temp";
              localObject3 = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_path;
              paramAnonymousInt = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataType;
              if ((paramAnonymousc != null) && (localObject3 != null)) {}
            }
            for (;;)
            {
              ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a((com.tencent.mm.plugin.fav.a.c)localObject1, new String[0]);
              a.a((com.tencent.mm.plugin.fav.a.c)localObject1, paramAnonymousd);
              ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().b((com.tencent.mm.plugin.fav.a.c)localObject1, new String[] { "dataId" });
              a.this.rum.remove(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId);
              ad.i("MicroMsg.Fav.FavCdnService", "transfer done, mediaid=%s, md5=%s aeskey=%s completeInfo=%s", new Object[] { paramAnonymousd.mediaId, paramAnonymousString, paramAnonymousd.field_aesKey, paramAnonymousd.toString() });
              a.a(a.this, paramAnonymousString);
              com.tencent.mm.plugin.report.service.g.yhR.f(10625, new Object[] { Integer.valueOf(1), paramAnonymousd.field_fileId, "", paramAnonymousd.field_transInfo });
              break;
              if ((paramAnonymousInt == -2) && (!a.aaK(paramAnonymousc)) && (a.fn(paramAnonymousc, (String)localObject3)))
              {
                ad.i("MicroMsg.Fav.FavCdnService", "renameAndCopyFile write amr head ok!");
              }
              else
              {
                localObject2 = new com.tencent.mm.vfs.e(paramAnonymousc);
                localObject3 = new com.tencent.mm.vfs.e((String)localObject3);
                if (((com.tencent.mm.vfs.e)localObject2).exists())
                {
                  ad.i("MicroMsg.Fav.FavCdnService", "rename file suc:%b, old:%s, new:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.vfs.e)localObject2).ag((com.tencent.mm.vfs.e)localObject3)), paramAnonymousc, localObject3 });
                  continue;
                  ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnKey = paramAnonymousd.field_aesKey;
                  ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnUrl = paramAnonymousd.field_fileId;
                }
              }
            }
          }
          ad.e("MicroMsg.Fav.FavCdnService", "transfer error, mediaid=%s, retCode:%d", new Object[] { paramAnonymousd.mediaId, Integer.valueOf(paramAnonymousd.field_retCode) });
          paramAnonymousc = (a.a)a.this.rum.get(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId);
          if (paramAnonymousc != null) {
            paramAnonymousc.errCode = paramAnonymousd.field_retCode;
          }
          if (-6101 == paramAnonymousd.field_retCode)
          {
            ((com.tencent.mm.plugin.fav.a.c)localObject1).field_extFlag |= 0x1;
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(141L, 1L, 1L, true);
            localObject2 = paramAnonymousd.mediaId;
            if (paramAnonymousc != null)
            {
              paramAnonymousInt = paramAnonymousc.iNG;
              label804:
              ad.e("MicroMsg.Fav.FavCdnService", "transfer error, mediaid=%s, retCode:-6101,try time = %d,info.field_type: %d , info.field_dataType: %d", new Object[] { localObject2, Integer.valueOf(paramAnonymousInt), Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_type), Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataType) });
            }
          }
          for (;;)
          {
            ((com.tencent.mm.plugin.fav.a.c)localObject1).field_status = 4;
            com.tencent.mm.plugin.report.service.g.yhR.f(10660, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_type), Integer.valueOf(paramAnonymousd.field_retCode) });
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a((com.tencent.mm.plugin.fav.a.c)localObject1, new String[0]);
            a.h((com.tencent.mm.plugin.fav.a.c)localObject1);
            break;
            paramAnonymousInt = 1;
            break label804;
            switch (paramAnonymousd.field_retCode)
            {
            default: 
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(141L, 0L, 1L, true);
              break;
            case -10003: 
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(141L, 2L, 1L, true);
              break;
            case -10005: 
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(141L, 3L, 1L, true);
              break;
            case -21000: 
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(141L, 4L, 1L, true);
              break;
            case -21009: 
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(141L, 5L, 1L, true);
              break;
            case -21014: 
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(141L, 6L, 1L, true);
              break;
            case -21020: 
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(141L, 7L, 1L, true);
              break;
            case -5103015: 
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(141L, 8L, 1L, true);
            }
          }
          paramAnonymousString = (String)localObject1;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.ruo = ay.isWifi(aj.getContext());
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().a(this.hTD);
    AppMethodBeat.o(101592);
  }
  
  private static int a(com.tencent.mm.plugin.fav.a.c paramc, int paramInt)
  {
    AppMethodBeat.i(101601);
    if (paramc.field_totalLen > 26214400)
    {
      paramInt = com.tencent.mm.i.a.fIB;
      AppMethodBeat.o(101601);
      return paramInt;
    }
    if ((paramc.field_extFlag & 0x1) == 0)
    {
      AppMethodBeat.o(101601);
      return paramInt;
    }
    ad.w("MicroMsg.Fav.FavCdnService", "NEED To Exchange Type, defType %d", new Object[] { Integer.valueOf(paramInt) });
    if (com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO == paramInt)
    {
      paramInt = com.tencent.mm.i.a.MediaType_FAVORITE_FILE;
      AppMethodBeat.o(101601);
      return paramInt;
    }
    paramInt = com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO;
    AppMethodBeat.o(101601);
    return paramInt;
  }
  
  static boolean aaK(String paramString)
  {
    AppMethodBeat.i(101603);
    localObject1 = null;
    String str = null;
    try
    {
      paramString = i.dd(paramString, false);
      str = paramString;
      localObject1 = paramString;
      Object localObject2 = new byte[6];
      str = paramString;
      localObject1 = paramString;
      int i = paramString.read((byte[])localObject2, 0, 6);
      if (i == -1)
      {
        if (paramString != null) {}
        try
        {
          paramString.close();
          AppMethodBeat.o(101603);
          return false;
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.Fav.FavCdnService", paramString, "", new Object[0]);
          }
        }
      }
      str = paramString;
      localObject1 = paramString;
      localObject2 = new String((byte[])localObject2);
      str = paramString;
      localObject1 = paramString;
      ad.i("MicroMsg.Fav.FavCdnService", "head " + (String)localObject2 + "   AmrFileOperator.AMR_NB_HEAD #!AMR\n");
      str = paramString;
      localObject1 = paramString;
      boolean bool = ((String)localObject2).endsWith("#!AMR\n");
      if (paramString != null) {}
      try
      {
        paramString.close();
        AppMethodBeat.o(101603);
        return bool;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.Fav.FavCdnService", paramString, "", new Object[0]);
        }
      }
      try
      {
        ((RandomAccessFile)localObject1).close();
        AppMethodBeat.o(101603);
        throw paramString;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.Fav.FavCdnService", localIOException, "", new Object[0]);
        }
      }
    }
    catch (Exception paramString)
    {
      localObject1 = str;
      ad.printErrStackTrace("MicroMsg.Fav.FavCdnService", paramString, "", new Object[0]);
      if (str != null) {}
      try
      {
        str.close();
        AppMethodBeat.o(101603);
        return false;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.Fav.FavCdnService", paramString, "", new Object[0]);
        }
      }
    }
    finally
    {
      if (localObject1 == null) {}
    }
  }
  
  /* Error */
  static boolean fn(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 392
    //   3: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 396	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: aload_1
    //   12: iconst_0
    //   13: invokestatic 400	com/tencent/mm/vfs/i:cX	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   16: astore_1
    //   17: aload_1
    //   18: astore 6
    //   20: aload_0
    //   21: astore 5
    //   23: sipush 16384
    //   26: newarray byte
    //   28: astore 7
    //   30: aload_1
    //   31: astore 6
    //   33: aload_0
    //   34: astore 5
    //   36: aload_1
    //   37: ldc_w 386
    //   40: invokevirtual 404	java/lang/String:getBytes	()[B
    //   43: invokevirtual 409	java/io/OutputStream:write	([B)V
    //   46: aload_1
    //   47: astore 6
    //   49: aload_0
    //   50: astore 5
    //   52: aload_0
    //   53: aload 7
    //   55: invokevirtual 414	java/io/InputStream:read	([B)I
    //   58: istore_2
    //   59: iload_2
    //   60: iconst_m1
    //   61: if_icmpeq +68 -> 129
    //   64: aload_1
    //   65: astore 6
    //   67: aload_0
    //   68: astore 5
    //   70: aload_1
    //   71: aload 7
    //   73: iconst_0
    //   74: iload_2
    //   75: invokevirtual 417	java/io/OutputStream:write	([BII)V
    //   78: goto -32 -> 46
    //   81: astore 7
    //   83: aload_1
    //   84: astore 6
    //   86: aload_0
    //   87: astore 5
    //   89: ldc 176
    //   91: aload 7
    //   93: ldc_w 359
    //   96: iconst_0
    //   97: anewarray 4	java/lang/Object
    //   100: invokestatic 363	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aload_0
    //   104: ifnull +7 -> 111
    //   107: aload_0
    //   108: invokevirtual 418	java/io/InputStream:close	()V
    //   111: aload_1
    //   112: ifnull +221 -> 333
    //   115: aload_1
    //   116: invokevirtual 419	java/io/OutputStream:close	()V
    //   119: iconst_0
    //   120: istore_3
    //   121: ldc_w 392
    //   124: invokestatic 157	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: iload_3
    //   128: ireturn
    //   129: iconst_1
    //   130: istore_3
    //   131: iload_3
    //   132: istore 4
    //   134: aload_0
    //   135: ifnull +10 -> 145
    //   138: aload_0
    //   139: invokevirtual 418	java/io/InputStream:close	()V
    //   142: iload_3
    //   143: istore 4
    //   145: iload 4
    //   147: istore_3
    //   148: aload_1
    //   149: ifnull -28 -> 121
    //   152: aload_1
    //   153: invokevirtual 419	java/io/OutputStream:close	()V
    //   156: iload 4
    //   158: istore_3
    //   159: goto -38 -> 121
    //   162: astore_0
    //   163: ldc 176
    //   165: aload_0
    //   166: ldc_w 359
    //   169: iconst_0
    //   170: anewarray 4	java/lang/Object
    //   173: invokestatic 363	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: iconst_0
    //   177: istore_3
    //   178: goto -57 -> 121
    //   181: astore_0
    //   182: ldc 176
    //   184: aload_0
    //   185: ldc_w 359
    //   188: iconst_0
    //   189: anewarray 4	java/lang/Object
    //   192: invokestatic 363	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: iconst_0
    //   196: istore 4
    //   198: goto -53 -> 145
    //   201: astore_0
    //   202: ldc 176
    //   204: aload_0
    //   205: ldc_w 359
    //   208: iconst_0
    //   209: anewarray 4	java/lang/Object
    //   212: invokestatic 363	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: goto -104 -> 111
    //   218: astore_0
    //   219: ldc 176
    //   221: aload_0
    //   222: ldc_w 359
    //   225: iconst_0
    //   226: anewarray 4	java/lang/Object
    //   229: invokestatic 363	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: iconst_0
    //   233: istore_3
    //   234: goto -113 -> 121
    //   237: astore_1
    //   238: aconst_null
    //   239: astore 6
    //   241: aconst_null
    //   242: astore_0
    //   243: aload_0
    //   244: ifnull +7 -> 251
    //   247: aload_0
    //   248: invokevirtual 418	java/io/InputStream:close	()V
    //   251: aload 6
    //   253: ifnull +8 -> 261
    //   256: aload 6
    //   258: invokevirtual 419	java/io/OutputStream:close	()V
    //   261: ldc_w 392
    //   264: invokestatic 157	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   267: aload_1
    //   268: athrow
    //   269: astore_0
    //   270: ldc 176
    //   272: aload_0
    //   273: ldc_w 359
    //   276: iconst_0
    //   277: anewarray 4	java/lang/Object
    //   280: invokestatic 363	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   283: goto -32 -> 251
    //   286: astore_0
    //   287: ldc 176
    //   289: aload_0
    //   290: ldc_w 359
    //   293: iconst_0
    //   294: anewarray 4	java/lang/Object
    //   297: invokestatic 363	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: goto -39 -> 261
    //   303: astore_1
    //   304: aconst_null
    //   305: astore 6
    //   307: goto -64 -> 243
    //   310: astore_1
    //   311: aload 5
    //   313: astore_0
    //   314: goto -71 -> 243
    //   317: astore 7
    //   319: aconst_null
    //   320: astore_1
    //   321: aconst_null
    //   322: astore_0
    //   323: goto -240 -> 83
    //   326: astore 7
    //   328: aconst_null
    //   329: astore_1
    //   330: goto -247 -> 83
    //   333: iconst_0
    //   334: istore_3
    //   335: goto -214 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	paramString1	String
    //   0	338	1	paramString2	String
    //   58	17	2	i	int
    //   120	215	3	bool1	boolean
    //   132	65	4	bool2	boolean
    //   21	291	5	str1	String
    //   18	288	6	str2	String
    //   28	44	7	arrayOfByte	byte[]
    //   81	11	7	localException1	Exception
    //   317	1	7	localException2	Exception
    //   326	1	7	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   23	30	81	java/lang/Exception
    //   36	46	81	java/lang/Exception
    //   52	59	81	java/lang/Exception
    //   70	78	81	java/lang/Exception
    //   152	156	162	java/io/IOException
    //   138	142	181	java/io/IOException
    //   107	111	201	java/io/IOException
    //   115	119	218	java/io/IOException
    //   6	11	237	finally
    //   247	251	269	java/io/IOException
    //   256	261	286	java/io/IOException
    //   11	17	303	finally
    //   23	30	310	finally
    //   36	46	310	finally
    //   52	59	310	finally
    //   70	78	310	finally
    //   89	103	310	finally
    //   6	11	317	java/lang/Exception
    //   11	17	326	java/lang/Exception
  }
  
  private static void g(com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(101597);
    if (1 == paramc.field_type) {}
    for (paramc.field_status = 2;; paramc.field_status = 4)
    {
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(paramc, new String[] { "dataId" });
      h(paramc);
      AppMethodBeat.o(101597);
      return;
    }
  }
  
  static void h(com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(101605);
    if (paramc.field_type == 0)
    {
      com.tencent.mm.plugin.fav.a.b.b(paramc);
      AppMethodBeat.o(101605);
      return;
    }
    if (paramc.field_type == 1)
    {
      com.tencent.mm.plugin.fav.a.b.c(paramc);
      AppMethodBeat.o(101605);
      return;
    }
    AppMethodBeat.o(101605);
  }
  
  public final void Qe()
  {
    AppMethodBeat.i(101600);
    this.dim.clear();
    this.dio.clear();
    this.running = false;
    this.diq = false;
    AppMethodBeat.o(101600);
  }
  
  final void aHZ()
  {
    AppMethodBeat.i(101596);
    this.dit = System.currentTimeMillis();
    if ((!this.diq) && (this.dim.size() == 0))
    {
      if (com.tencent.mm.compatible.util.e.abf()) {
        break label88;
      }
      ad.e("MicroMsg.Fav.FavCdnService", "klem getNeedRunInfo sdcard not available");
      Qe();
    }
    label88:
    Object localObject1;
    Object localObject2;
    while ((!this.diq) && (this.dim.size() <= 0))
    {
      Qe();
      ad.i("MicroMsg.Fav.FavCdnService", "klem No Data Any More , Stop Service");
      AppMethodBeat.o(101596);
      return;
      if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage() != null)
      {
        localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().cvf();
        if ((localObject1 != null) && (((List)localObject1).size() != 0))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (com.tencent.mm.plugin.fav.a.c)((Iterator)localObject1).next();
            if (this.dio.containsKey(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId))
            {
              ad.d("MicroMsg.Fav.FavCdnService", "File is Already running:" + ((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId);
            }
            else
            {
              this.dim.add(localObject2);
              this.dio.put(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId, null);
            }
          }
          ad.i("MicroMsg.Fav.FavCdnService", "klem GetNeedRun procing:" + this.dio.size() + ",send:" + this.dim.size() + "]");
          this.dim.size();
        }
      }
    }
    if ((!this.diq) && (this.dim.size() > 0)) {
      try
      {
        localObject1 = (com.tencent.mm.plugin.fav.a.c)this.dim.poll();
        if ((localObject1 != null) && (!bt.isNullOrNil(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId)))
        {
          localObject2 = (a)this.rum.get(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId);
          if (localObject2 == null)
          {
            localObject2 = new a((byte)0);
            ((a)localObject2).iNG = 1;
            ((a)localObject2).ruv = bt.flT();
            this.rum.put(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId, localObject2);
            if (((com.tencent.mm.plugin.fav.a.c)localObject1).field_type != 0) {
              break label850;
            }
            ad.i("MicroMsg.Fav.FavCdnService", "check favCDN:force job[can upload], localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_favLocalId), ((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId, Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_type), Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataType) });
            i = 1;
            if (i == 0) {
              break label1402;
            }
            this.diq = true;
            if (localObject1 == null) {
              break label1381;
            }
            ad.i("MicroMsg.Fav.FavCdnService", "doTransfer, md5:%s", new Object[] { ((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId });
            localObject2 = new com.tencent.mm.i.g();
            ((com.tencent.mm.i.g)localObject2).fJi = "task_FavCdnService";
            ((com.tencent.mm.i.g)localObject2).fJj = this.ibn;
            ((com.tencent.mm.i.g)localObject2).field_mediaId = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId;
            if (((com.tencent.mm.plugin.fav.a.c)localObject1).field_type != 0) {
              break label1266;
            }
            ((com.tencent.mm.i.g)localObject2).dNR = true;
            ((com.tencent.mm.i.g)localObject2).field_priority = com.tencent.mm.i.a.fIv;
            ((com.tencent.mm.i.g)localObject2).field_needStorage = true;
            ((com.tencent.mm.i.g)localObject2).field_totalLen = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_totalLen;
            ((com.tencent.mm.i.g)localObject2).field_aesKey = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnKey;
            ((com.tencent.mm.i.g)localObject2).field_fileId = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnUrl;
            ((com.tencent.mm.i.g)localObject2).field_isStreamMedia = ((com.tencent.mm.plugin.fav.a.c)localObject1).cuN();
            ((com.tencent.mm.i.g)localObject2).field_fullpath = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_path;
            if (!i.fv(((com.tencent.mm.i.g)localObject2).field_fullpath)) {
              ad.e("MicroMsg.Fav.FavCdnService", "favcdnservice upload, but file not exsit,filePath = %s ", new Object[] { ((com.tencent.mm.plugin.fav.a.c)localObject1).field_path });
            }
            if (!((com.tencent.mm.plugin.fav.a.c)localObject1).cuN()) {
              break label1252;
            }
            ((com.tencent.mm.i.g)localObject2).field_fileType = a((com.tencent.mm.plugin.fav.a.c)localObject1, com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO);
            ((com.tencent.mm.i.g)localObject2).field_force_aeskeycdn = true;
            ((com.tencent.mm.i.g)localObject2).field_trysafecdn = false;
            ad.i("MicroMsg.Fav.FavCdnService", "summersafecdn send force_aeskeycdn[%b] trysafecdn[%b]", new Object[] { Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_force_aeskeycdn), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_trysafecdn) });
            f.aGI().f((com.tencent.mm.i.g)localObject2);
            AppMethodBeat.o(101596);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.plugin.fav.a.c localc;
        for (;;)
        {
          int i;
          localc = null;
          continue;
          if ((bt.flT() - ((a)localObject2).ruv > 180000L) && (((a)localObject2).errCode != -6101))
          {
            ((a)localObject2).iNG = 1;
            ((a)localObject2).ruv = bt.flT();
            this.rum.put(localc.field_dataId, localObject2);
          }
          else if (((a)localObject2).iNG <= 3)
          {
            ((a)localObject2).iNG += 1;
            this.rum.put(localc.field_dataId, localObject2);
          }
          else
          {
            ad.e("MicroMsg.Fav.FavCdnService", "check favCDN:match transfer limit 3times , localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
            g(localc);
            i = 0;
            continue;
            label850:
            if ((this.run.contains(localc.field_dataId)) || (com.tencent.mm.plugin.fav.a.b.age(localc.field_dataId)))
            {
              ad.i("MicroMsg.Fav.FavCdnService", "check favCDN:force job[normal], localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
            }
            else if (!ay.isWifi(aj.getContext()))
            {
              ad.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, NOT WIFI, pause it, localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
              g(localc);
              i = 0;
            }
            else if (localc.field_type == 0)
            {
              ad.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI & SENDING, not auto limit, localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
            }
            else if (!this.ruq)
            {
              ad.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, not auto limit, localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
              this.rup = 0;
            }
            else if (this.rup < 10)
            {
              ad.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, auto limit %d, current index %d, retryTimes %dlocalid %d, dataid %s, type %d, dataType %d", new Object[] { Integer.valueOf(10), Integer.valueOf(this.rup), Integer.valueOf(((a)localObject2).iNG), Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
              if (((a)localObject2).iNG == 1) {
                this.rup += 1;
              }
            }
            else
            {
              ad.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, match auto limit %d", new Object[] { Integer.valueOf(10) });
              i = 0;
              continue;
              label1252:
              ((com.tencent.mm.i.g)localObject2).field_fileType = a(localc, com.tencent.mm.i.a.MediaType_FAVORITE_FILE);
            }
          }
        }
        label1266:
        ((com.tencent.mm.i.g)localObject2).dNR = false;
        ((com.tencent.mm.i.g)localObject2).field_totalLen = localc.field_totalLen;
        ((com.tencent.mm.i.g)localObject2).field_aesKey = localc.field_cdnKey;
        ((com.tencent.mm.i.g)localObject2).field_fileId = localc.field_cdnUrl;
        ((com.tencent.mm.i.g)localObject2).field_priority = com.tencent.mm.i.a.fIw;
        ((com.tencent.mm.i.g)localObject2).fJj = this.ibn;
        ((com.tencent.mm.i.g)localObject2).field_fullpath = (localc.field_path + ".temp");
        ((com.tencent.mm.i.g)localObject2).field_needStorage = true;
        ((com.tencent.mm.i.g)localObject2).field_isStreamMedia = localc.cuN();
        if (localc.cuN()) {}
        for (((com.tencent.mm.i.g)localObject2).field_fileType = a(localc, com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO);; ((com.tencent.mm.i.g)localObject2).field_fileType = a(localc, com.tencent.mm.i.a.MediaType_FAVORITE_FILE))
        {
          f.aGI().b((com.tencent.mm.i.g)localObject2, -1);
          h(localc);
          label1381:
          AppMethodBeat.o(101596);
          return;
        }
        label1402:
        if (this.rup >= 10)
        {
          Qe();
          AppMethodBeat.o(101596);
          return;
        }
        this.dix.az(500L, 500L);
      }
    }
    AppMethodBeat.o(101596);
  }
  
  public final void agt(final String paramString)
  {
    AppMethodBeat.i(101594);
    ad.i("MicroMsg.Fav.FavCdnService", "add force job %s", new Object[] { paramString });
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101586);
        a.this.run.add(paramString);
        AppMethodBeat.o(101586);
      }
    });
    AppMethodBeat.o(101594);
  }
  
  public final void agu(String paramString)
  {
    AppMethodBeat.i(101599);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(101599);
      return;
    }
    f.aGI().EP(paramString);
    ad.i("MicroMsg.Fav.FavCdnService", "pause upload md5%s", new Object[] { paramString });
    h(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(paramString));
    agz(paramString);
    AppMethodBeat.o(101599);
  }
  
  final void agz(String paramString)
  {
    AppMethodBeat.i(101604);
    this.diq = false;
    this.dio.remove(paramString);
    pauseDownload(paramString);
    if (this.dis > 0)
    {
      aHZ();
      AppMethodBeat.o(101604);
      return;
    }
    ad.i("MicroMsg.Fav.FavCdnService", "klem stopFlag <= 0 , Stop Service");
    Qe();
    AppMethodBeat.o(101604);
  }
  
  public final void d(com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(101606);
    if (paramc != null) {
      this.dim.add(paramc);
    }
    AppMethodBeat.o(101606);
  }
  
  public final void lv(final boolean paramBoolean)
  {
    AppMethodBeat.i(101593);
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101585);
        a.this.ruq = paramBoolean;
        a.this.rup = 0;
        AppMethodBeat.o(101585);
      }
    });
    AppMethodBeat.o(101593);
  }
  
  public final void pauseDownload(String paramString)
  {
    AppMethodBeat.i(101598);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(101598);
      return;
    }
    if (this.dio.containsKey(paramString))
    {
      f.aGI().EQ(paramString);
      ad.i("MicroMsg.Fav.FavCdnService", "pause download md5%s", new Object[] { paramString });
      h(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(paramString));
      agz(paramString);
    }
    AppMethodBeat.o(101598);
  }
  
  public final void run()
  {
    AppMethodBeat.i(101595);
    ad.i("MicroMsg.Fav.FavCdnService", "run fav cdn server");
    com.tencent.mm.kernel.g.ajF().cWY().removeCallbacks(this.rur);
    com.tencent.mm.kernel.g.ajF().ay(this.rur);
    AppMethodBeat.o(101595);
  }
  
  final class a
  {
    int errCode = 0;
    int iNG;
    long ruv;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.a
 * JD-Core Version:    0.7.0.1
 */