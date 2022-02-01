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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
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
  private Queue<com.tencent.mm.plugin.fav.a.c> cZA;
  private Map<String, f.a> cZC;
  boolean cZE;
  public int cZF;
  long cZG;
  public av cZK;
  public n haH;
  private g.a hhW;
  Map<String, a> qbE;
  Set<String> qbF;
  boolean qbG;
  int qbH;
  boolean qbI;
  private Runnable qbJ;
  boolean running;
  
  public a()
  {
    AppMethodBeat.i(101592);
    this.running = false;
    this.cZF = 0;
    this.cZG = 0L;
    this.cZE = false;
    this.cZA = new LinkedList();
    this.cZC = new HashMap();
    this.qbE = new HashMap();
    this.qbF = new HashSet();
    this.qbH = 0;
    this.qbI = true;
    this.haH = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(101584);
        boolean bool;
        com.tencent.mm.plugin.fav.a.c localc;
        try
        {
          bool = ay.isWifi(aj.getContext());
          ad.i("MicroMsg.Fav.FavCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(bool), Boolean.valueOf(a.this.qbG) });
          if ((paramAnonymousInt != 4) && (paramAnonymousInt != 6))
          {
            a.this.qbG = bool;
            AppMethodBeat.o(101584);
            return;
          }
          if ((!a.this.qbG) || (bool)) {
            break label471;
          }
          a locala1 = a.this;
          ad.i("MicroMsg.Fav.FavCdnService", "pauseAll");
          localCursor = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().chU();
          if ((localCursor != null) && (localCursor.moveToFirst()))
          {
            while (localCursor.moveToNext())
            {
              localc = new com.tencent.mm.plugin.fav.a.c();
              localc.convertFrom(localCursor);
              ad.i("MicroMsg.Fav.FavCdnService", "pauseAll, pauseUpload dataId:%s", new Object[] { localc.field_dataId });
              localc.field_status = 4;
              ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
              f.awL().xK(localc.field_dataId);
              a.h(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().Yk(localc.field_dataId));
              locala1.Yo(localc.field_dataId);
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
        Cursor localCursor = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().chV();
        if ((localCursor != null) && (localCursor.moveToFirst())) {
          while (localCursor.moveToNext())
          {
            localc = new com.tencent.mm.plugin.fav.a.c();
            localc.convertFrom(localCursor);
            ad.i("MicroMsg.Fav.FavCdnService", "pauseAll, pauseDownload dataId:%s", new Object[] { localc.field_dataId });
            localc.field_status = 4;
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
            f.awL().xL(localc.field_dataId);
            a.h(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().Yk(localc.field_dataId));
            localException.Yo(localc.field_dataId);
          }
        }
        if (localCursor != null) {
          localCursor.close();
        }
        label471:
        if ((!a.this.qbG) && (bool))
        {
          a locala2 = a.this;
          ad.i("MicroMsg.Fav.FavCdnService", "startAll");
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().startAll();
          locala2.run();
        }
        a.this.qbG = bool;
        AppMethodBeat.o(101584);
      }
    };
    this.qbJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101587);
        long l = System.currentTimeMillis() - a.this.cZG;
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
        a.this.cZE = false;
        a.this.running = true;
        a.this.qbH = 0;
        a.this.cZF = 3;
        a.this.cZK.av(100L, 100L);
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
    this.cZK = new av(com.tencent.mm.kernel.g.afE().EUN.getLooper(), new a.5(this), false);
    this.hhW = new g.a()
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
          a.this.Yo((String)localObject1);
          AppMethodBeat.o(101591);
          return 0;
          if (paramAnonymousd != null) {
            localObject1 = paramAnonymousd.mediaId;
          }
        }
        if (bt.isNullOrNil((String)localObject1)) {}
        for (;;)
        {
          localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().Yk(paramAnonymousString);
          if (localObject1 == null)
          {
            ad.e("MicroMsg.Fav.FavCdnService", "klem onCdnCallback info null");
            a.this.Yo(paramAnonymousString);
            AppMethodBeat.o(101591);
            return 0;
          }
          if (paramAnonymousInt != 0)
          {
            ad.w("MicroMsg.Fav.FavCdnService", "cdn transfer callback, startRet=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            h.vKh.f(10660, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_type), Integer.valueOf(paramAnonymousInt) });
            ((com.tencent.mm.plugin.fav.a.c)localObject1).field_status = 4;
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a((com.tencent.mm.plugin.fav.a.c)localObject1, new String[0]);
            a.h((com.tencent.mm.plugin.fav.a.c)localObject1);
            a.this.Yo(paramAnonymousString);
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
              a.this.qbE.remove(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId);
              ad.i("MicroMsg.Fav.FavCdnService", "transfer done, mediaid=%s, md5=%s aeskey=%s completeInfo=%s", new Object[] { paramAnonymousd.mediaId, paramAnonymousString, paramAnonymousd.field_aesKey, paramAnonymousd.toString() });
              a.a(a.this, paramAnonymousString);
              h.vKh.f(10625, new Object[] { Integer.valueOf(1), paramAnonymousd.field_fileId, "", paramAnonymousd.field_transInfo });
              break;
              if ((paramAnonymousInt == -2) && (!a.SR(paramAnonymousc)) && (a.eQ(paramAnonymousc, (String)localObject3)))
              {
                ad.i("MicroMsg.Fav.FavCdnService", "renameAndCopyFile write amr head ok!");
              }
              else
              {
                localObject2 = new com.tencent.mm.vfs.e(paramAnonymousc);
                localObject3 = new com.tencent.mm.vfs.e((String)localObject3);
                if (((com.tencent.mm.vfs.e)localObject2).exists())
                {
                  ad.i("MicroMsg.Fav.FavCdnService", "rename file suc:%b, old:%s, new:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.vfs.e)localObject2).af((com.tencent.mm.vfs.e)localObject3)), paramAnonymousc, localObject3 });
                  continue;
                  ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnKey = paramAnonymousd.field_aesKey;
                  ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnUrl = paramAnonymousd.field_fileId;
                }
              }
            }
          }
          ad.e("MicroMsg.Fav.FavCdnService", "transfer error, mediaid=%s, retCode:%d", new Object[] { paramAnonymousd.mediaId, Integer.valueOf(paramAnonymousd.field_retCode) });
          paramAnonymousc = (a.a)a.this.qbE.get(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId);
          if (paramAnonymousc != null) {
            paramAnonymousc.errCode = paramAnonymousd.field_retCode;
          }
          if (-6101 == paramAnonymousd.field_retCode)
          {
            ((com.tencent.mm.plugin.fav.a.c)localObject1).field_extFlag |= 0x1;
            h.vKh.idkeyStat(141L, 1L, 1L, true);
            localObject2 = paramAnonymousd.mediaId;
            if (paramAnonymousc != null)
            {
              paramAnonymousInt = paramAnonymousc.hUz;
              label804:
              ad.e("MicroMsg.Fav.FavCdnService", "transfer error, mediaid=%s, retCode:-6101,try time = %d,info.field_type: %d , info.field_dataType: %d", new Object[] { localObject2, Integer.valueOf(paramAnonymousInt), Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_type), Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataType) });
            }
          }
          for (;;)
          {
            ((com.tencent.mm.plugin.fav.a.c)localObject1).field_status = 4;
            h.vKh.f(10660, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_type), Integer.valueOf(paramAnonymousd.field_retCode) });
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a((com.tencent.mm.plugin.fav.a.c)localObject1, new String[0]);
            a.h((com.tencent.mm.plugin.fav.a.c)localObject1);
            break;
            paramAnonymousInt = 1;
            break label804;
            switch (paramAnonymousd.field_retCode)
            {
            default: 
              h.vKh.idkeyStat(141L, 0L, 1L, true);
              break;
            case -10003: 
              h.vKh.idkeyStat(141L, 2L, 1L, true);
              break;
            case -10005: 
              h.vKh.idkeyStat(141L, 3L, 1L, true);
              break;
            case -21000: 
              h.vKh.idkeyStat(141L, 4L, 1L, true);
              break;
            case -21009: 
              h.vKh.idkeyStat(141L, 5L, 1L, true);
              break;
            case -21014: 
              h.vKh.idkeyStat(141L, 6L, 1L, true);
              break;
            case -21020: 
              h.vKh.idkeyStat(141L, 7L, 1L, true);
              break;
            case -5103015: 
              h.vKh.idkeyStat(141L, 8L, 1L, true);
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
    this.qbG = ay.isWifi(aj.getContext());
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().a(this.haH);
    AppMethodBeat.o(101592);
  }
  
  static boolean SR(String paramString)
  {
    AppMethodBeat.i(101603);
    localObject1 = null;
    String str = null;
    try
    {
      paramString = i.cS(paramString, false);
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
  
  private static int a(com.tencent.mm.plugin.fav.a.c paramc, int paramInt)
  {
    AppMethodBeat.i(101601);
    if (paramc.field_totalLen > 26214400)
    {
      paramInt = com.tencent.mm.i.a.fna;
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
  
  /* Error */
  static boolean eQ(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 392
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 396	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: aload_1
    //   12: iconst_0
    //   13: invokestatic 400	com/tencent/mm/vfs/i:cM	(Ljava/lang/String;Z)Ljava/io/OutputStream;
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
    //   37: ldc 217
    //   39: invokevirtual 404	java/lang/String:getBytes	()[B
    //   42: invokevirtual 409	java/io/OutputStream:write	([B)V
    //   45: aload_1
    //   46: astore 6
    //   48: aload_0
    //   49: astore 5
    //   51: aload_0
    //   52: aload 7
    //   54: invokevirtual 414	java/io/InputStream:read	([B)I
    //   57: istore_2
    //   58: iload_2
    //   59: iconst_m1
    //   60: if_icmpeq +67 -> 127
    //   63: aload_1
    //   64: astore 6
    //   66: aload_0
    //   67: astore 5
    //   69: aload_1
    //   70: aload 7
    //   72: iconst_0
    //   73: iload_2
    //   74: invokevirtual 417	java/io/OutputStream:write	([BII)V
    //   77: goto -32 -> 45
    //   80: astore 7
    //   82: aload_1
    //   83: astore 6
    //   85: aload_0
    //   86: astore 5
    //   88: ldc 182
    //   90: aload 7
    //   92: ldc 184
    //   94: iconst_0
    //   95: anewarray 4	java/lang/Object
    //   98: invokestatic 190	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: aload_0
    //   102: ifnull +7 -> 109
    //   105: aload_0
    //   106: invokevirtual 418	java/io/InputStream:close	()V
    //   109: aload_1
    //   110: ifnull +215 -> 325
    //   113: aload_1
    //   114: invokevirtual 419	java/io/OutputStream:close	()V
    //   117: iconst_0
    //   118: istore_3
    //   119: ldc_w 392
    //   122: invokestatic 157	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: iload_3
    //   126: ireturn
    //   127: iconst_1
    //   128: istore_3
    //   129: iload_3
    //   130: istore 4
    //   132: aload_0
    //   133: ifnull +10 -> 143
    //   136: aload_0
    //   137: invokevirtual 418	java/io/InputStream:close	()V
    //   140: iload_3
    //   141: istore 4
    //   143: iload 4
    //   145: istore_3
    //   146: aload_1
    //   147: ifnull -28 -> 119
    //   150: aload_1
    //   151: invokevirtual 419	java/io/OutputStream:close	()V
    //   154: iload 4
    //   156: istore_3
    //   157: goto -38 -> 119
    //   160: astore_0
    //   161: ldc 182
    //   163: aload_0
    //   164: ldc 184
    //   166: iconst_0
    //   167: anewarray 4	java/lang/Object
    //   170: invokestatic 190	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: iconst_0
    //   174: istore_3
    //   175: goto -56 -> 119
    //   178: astore_0
    //   179: ldc 182
    //   181: aload_0
    //   182: ldc 184
    //   184: iconst_0
    //   185: anewarray 4	java/lang/Object
    //   188: invokestatic 190	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: iconst_0
    //   192: istore 4
    //   194: goto -51 -> 143
    //   197: astore_0
    //   198: ldc 182
    //   200: aload_0
    //   201: ldc 184
    //   203: iconst_0
    //   204: anewarray 4	java/lang/Object
    //   207: invokestatic 190	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   210: goto -101 -> 109
    //   213: astore_0
    //   214: ldc 182
    //   216: aload_0
    //   217: ldc 184
    //   219: iconst_0
    //   220: anewarray 4	java/lang/Object
    //   223: invokestatic 190	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   226: iconst_0
    //   227: istore_3
    //   228: goto -109 -> 119
    //   231: astore_1
    //   232: aconst_null
    //   233: astore 6
    //   235: aconst_null
    //   236: astore_0
    //   237: aload_0
    //   238: ifnull +7 -> 245
    //   241: aload_0
    //   242: invokevirtual 418	java/io/InputStream:close	()V
    //   245: aload 6
    //   247: ifnull +8 -> 255
    //   250: aload 6
    //   252: invokevirtual 419	java/io/OutputStream:close	()V
    //   255: ldc_w 392
    //   258: invokestatic 157	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   261: aload_1
    //   262: athrow
    //   263: astore_0
    //   264: ldc 182
    //   266: aload_0
    //   267: ldc 184
    //   269: iconst_0
    //   270: anewarray 4	java/lang/Object
    //   273: invokestatic 190	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   276: goto -31 -> 245
    //   279: astore_0
    //   280: ldc 182
    //   282: aload_0
    //   283: ldc 184
    //   285: iconst_0
    //   286: anewarray 4	java/lang/Object
    //   289: invokestatic 190	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   292: goto -37 -> 255
    //   295: astore_1
    //   296: aconst_null
    //   297: astore 6
    //   299: goto -62 -> 237
    //   302: astore_1
    //   303: aload 5
    //   305: astore_0
    //   306: goto -69 -> 237
    //   309: astore 7
    //   311: aconst_null
    //   312: astore_1
    //   313: aconst_null
    //   314: astore_0
    //   315: goto -233 -> 82
    //   318: astore 7
    //   320: aconst_null
    //   321: astore_1
    //   322: goto -240 -> 82
    //   325: iconst_0
    //   326: istore_3
    //   327: goto -208 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	paramString1	String
    //   0	330	1	paramString2	String
    //   57	17	2	i	int
    //   118	209	3	bool1	boolean
    //   130	63	4	bool2	boolean
    //   21	283	5	str1	String
    //   18	280	6	str2	String
    //   28	43	7	arrayOfByte	byte[]
    //   80	11	7	localException1	Exception
    //   309	1	7	localException2	Exception
    //   318	1	7	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   23	30	80	java/lang/Exception
    //   36	45	80	java/lang/Exception
    //   51	58	80	java/lang/Exception
    //   69	77	80	java/lang/Exception
    //   150	154	160	java/io/IOException
    //   136	140	178	java/io/IOException
    //   105	109	197	java/io/IOException
    //   113	117	213	java/io/IOException
    //   6	11	231	finally
    //   241	245	263	java/io/IOException
    //   250	255	279	java/io/IOException
    //   11	17	295	finally
    //   23	30	302	finally
    //   36	45	302	finally
    //   51	58	302	finally
    //   69	77	302	finally
    //   88	101	302	finally
    //   6	11	309	java/lang/Exception
    //   11	17	318	java/lang/Exception
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
  
  public final void Oy()
  {
    AppMethodBeat.i(101600);
    this.cZA.clear();
    this.cZC.clear();
    this.running = false;
    this.cZE = false;
    AppMethodBeat.o(101600);
  }
  
  public final void Yi(final String paramString)
  {
    AppMethodBeat.i(101594);
    ad.i("MicroMsg.Fav.FavCdnService", "add force job %s", new Object[] { paramString });
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101586);
        a.this.qbF.add(paramString);
        AppMethodBeat.o(101586);
      }
    });
    AppMethodBeat.o(101594);
  }
  
  public final void Yj(String paramString)
  {
    AppMethodBeat.i(101599);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(101599);
      return;
    }
    f.awL().xK(paramString);
    ad.i("MicroMsg.Fav.FavCdnService", "pause upload md5%s", new Object[] { paramString });
    h(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().Yk(paramString));
    Yo(paramString);
    AppMethodBeat.o(101599);
  }
  
  final void Yo(String paramString)
  {
    AppMethodBeat.i(101604);
    this.cZE = false;
    this.cZC.remove(paramString);
    pauseDownload(paramString);
    if (this.cZF > 0)
    {
      ayc();
      AppMethodBeat.o(101604);
      return;
    }
    ad.i("MicroMsg.Fav.FavCdnService", "klem stopFlag <= 0 , Stop Service");
    Oy();
    AppMethodBeat.o(101604);
  }
  
  final void ayc()
  {
    AppMethodBeat.i(101596);
    this.cZG = System.currentTimeMillis();
    if ((!this.cZE) && (this.cZA.size() == 0))
    {
      if (com.tencent.mm.compatible.util.e.XG()) {
        break label88;
      }
      ad.e("MicroMsg.Fav.FavCdnService", "klem getNeedRunInfo sdcard not available");
      Oy();
    }
    label88:
    Object localObject1;
    Object localObject2;
    while ((!this.cZE) && (this.cZA.size() <= 0))
    {
      Oy();
      ad.i("MicroMsg.Fav.FavCdnService", "klem No Data Any More , Stop Service");
      AppMethodBeat.o(101596);
      return;
      if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage() != null)
      {
        localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().chT();
        if ((localObject1 != null) && (((List)localObject1).size() != 0))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (com.tencent.mm.plugin.fav.a.c)((Iterator)localObject1).next();
            if (this.cZC.containsKey(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId))
            {
              ad.d("MicroMsg.Fav.FavCdnService", "File is Already running:" + ((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId);
            }
            else
            {
              this.cZA.add(localObject2);
              this.cZC.put(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId, null);
            }
          }
          ad.i("MicroMsg.Fav.FavCdnService", "klem GetNeedRun procing:" + this.cZC.size() + ",send:" + this.cZA.size() + "]");
          this.cZA.size();
        }
      }
    }
    if ((!this.cZE) && (this.cZA.size() > 0)) {
      try
      {
        localObject1 = (com.tencent.mm.plugin.fav.a.c)this.cZA.poll();
        if ((localObject1 != null) && (!bt.isNullOrNil(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId)))
        {
          localObject2 = (a)this.qbE.get(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId);
          if (localObject2 == null)
          {
            localObject2 = new a((byte)0);
            ((a)localObject2).hUz = 1;
            ((a)localObject2).qbN = bt.eGO();
            this.qbE.put(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId, localObject2);
            if (((com.tencent.mm.plugin.fav.a.c)localObject1).field_type != 0) {
              break label845;
            }
            ad.i("MicroMsg.Fav.FavCdnService", "check favCDN:force job[can upload], localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_favLocalId), ((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId, Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_type), Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataType) });
            i = 1;
            if (i == 0) {
              break label1397;
            }
            this.cZE = true;
            if (localObject1 == null) {
              break label1376;
            }
            ad.i("MicroMsg.Fav.FavCdnService", "doTransfer, md5:%s", new Object[] { ((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId });
            localObject2 = new com.tencent.mm.i.g();
            ((com.tencent.mm.i.g)localObject2).fnH = this.hhW;
            ((com.tencent.mm.i.g)localObject2).field_mediaId = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId;
            if (((com.tencent.mm.plugin.fav.a.c)localObject1).field_type != 0) {
              break label1261;
            }
            ((com.tencent.mm.i.g)localObject2).dDS = true;
            ((com.tencent.mm.i.g)localObject2).field_priority = com.tencent.mm.i.a.fmU;
            ((com.tencent.mm.i.g)localObject2).field_needStorage = true;
            ((com.tencent.mm.i.g)localObject2).field_totalLen = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_totalLen;
            ((com.tencent.mm.i.g)localObject2).field_aesKey = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnKey;
            ((com.tencent.mm.i.g)localObject2).field_fileId = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnUrl;
            ((com.tencent.mm.i.g)localObject2).field_isStreamMedia = ((com.tencent.mm.plugin.fav.a.c)localObject1).chB();
            ((com.tencent.mm.i.g)localObject2).field_fullpath = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_path;
            if (!i.eK(((com.tencent.mm.i.g)localObject2).field_fullpath)) {
              ad.e("MicroMsg.Fav.FavCdnService", "favcdnservice upload, but file not exsit,filePath = %s ", new Object[] { ((com.tencent.mm.plugin.fav.a.c)localObject1).field_path });
            }
            if (!((com.tencent.mm.plugin.fav.a.c)localObject1).chB()) {
              break label1247;
            }
            ((com.tencent.mm.i.g)localObject2).field_fileType = a((com.tencent.mm.plugin.fav.a.c)localObject1, com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO);
            ((com.tencent.mm.i.g)localObject2).field_force_aeskeycdn = true;
            ((com.tencent.mm.i.g)localObject2).field_trysafecdn = false;
            ad.i("MicroMsg.Fav.FavCdnService", "summersafecdn send force_aeskeycdn[%b] trysafecdn[%b]", new Object[] { Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_force_aeskeycdn), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_trysafecdn) });
            f.awL().e((com.tencent.mm.i.g)localObject2);
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
          if ((bt.eGO() - ((a)localObject2).qbN > 180000L) && (((a)localObject2).errCode != -6101))
          {
            ((a)localObject2).hUz = 1;
            ((a)localObject2).qbN = bt.eGO();
            this.qbE.put(localc.field_dataId, localObject2);
          }
          else if (((a)localObject2).hUz <= 3)
          {
            ((a)localObject2).hUz += 1;
            this.qbE.put(localc.field_dataId, localObject2);
          }
          else
          {
            ad.e("MicroMsg.Fav.FavCdnService", "check favCDN:match transfer limit 3times , localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
            g(localc);
            i = 0;
            continue;
            label845:
            if ((this.qbF.contains(localc.field_dataId)) || (com.tencent.mm.plugin.fav.a.b.XT(localc.field_dataId)))
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
            else if (!this.qbI)
            {
              ad.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, not auto limit, localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
              this.qbH = 0;
            }
            else if (this.qbH < 10)
            {
              ad.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, auto limit %d, current index %d, retryTimes %dlocalid %d, dataid %s, type %d, dataType %d", new Object[] { Integer.valueOf(10), Integer.valueOf(this.qbH), Integer.valueOf(((a)localObject2).hUz), Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
              if (((a)localObject2).hUz == 1) {
                this.qbH += 1;
              }
            }
            else
            {
              ad.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, match auto limit %d", new Object[] { Integer.valueOf(10) });
              i = 0;
              continue;
              label1247:
              ((com.tencent.mm.i.g)localObject2).field_fileType = a(localc, com.tencent.mm.i.a.MediaType_FAVORITE_FILE);
            }
          }
        }
        label1261:
        ((com.tencent.mm.i.g)localObject2).dDS = false;
        ((com.tencent.mm.i.g)localObject2).field_totalLen = localc.field_totalLen;
        ((com.tencent.mm.i.g)localObject2).field_aesKey = localc.field_cdnKey;
        ((com.tencent.mm.i.g)localObject2).field_fileId = localc.field_cdnUrl;
        ((com.tencent.mm.i.g)localObject2).field_priority = com.tencent.mm.i.a.fmV;
        ((com.tencent.mm.i.g)localObject2).fnH = this.hhW;
        ((com.tencent.mm.i.g)localObject2).field_fullpath = (localc.field_path + ".temp");
        ((com.tencent.mm.i.g)localObject2).field_needStorage = true;
        ((com.tencent.mm.i.g)localObject2).field_isStreamMedia = localc.chB();
        if (localc.chB()) {}
        for (((com.tencent.mm.i.g)localObject2).field_fileType = a(localc, com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO);; ((com.tencent.mm.i.g)localObject2).field_fileType = a(localc, com.tencent.mm.i.a.MediaType_FAVORITE_FILE))
        {
          f.awL().b((com.tencent.mm.i.g)localObject2, -1);
          h(localc);
          label1376:
          AppMethodBeat.o(101596);
          return;
        }
        label1397:
        if (this.qbH >= 10)
        {
          Oy();
          AppMethodBeat.o(101596);
          return;
        }
        this.cZK.av(500L, 500L);
      }
    }
    AppMethodBeat.o(101596);
  }
  
  public final void d(com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(101606);
    if (paramc != null) {
      this.cZA.add(paramc);
    }
    AppMethodBeat.o(101606);
  }
  
  public final void ky(final boolean paramBoolean)
  {
    AppMethodBeat.i(101593);
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101585);
        a.this.qbI = paramBoolean;
        a.this.qbH = 0;
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
    if (this.cZC.containsKey(paramString))
    {
      f.awL().xL(paramString);
      ad.i("MicroMsg.Fav.FavCdnService", "pause download md5%s", new Object[] { paramString });
      h(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().Yk(paramString));
      Yo(paramString);
    }
    AppMethodBeat.o(101598);
  }
  
  public final void run()
  {
    AppMethodBeat.i(101595);
    ad.i("MicroMsg.Fav.FavCdnService", "run fav cdn server");
    com.tencent.mm.kernel.g.afE().cBt().removeCallbacks(this.qbJ);
    com.tencent.mm.kernel.g.afE().ax(this.qbJ);
    AppMethodBeat.o(101595);
  }
  
  final class a
  {
    int errCode = 0;
    int hUz;
    long qbN;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.a
 * JD-Core Version:    0.7.0.1
 */