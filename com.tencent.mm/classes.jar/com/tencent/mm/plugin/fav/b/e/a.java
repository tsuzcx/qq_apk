package com.tencent.mm.plugin.fav.b.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
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
  implements com.tencent.mm.plugin.fav.a.o
{
  private Queue<com.tencent.mm.plugin.fav.a.c> dAA;
  private Map<String, f.a> dAC;
  boolean dAE;
  public int dAF;
  long dAG;
  public MTimerHandler dAJ;
  public p iRt;
  private g.a iZc;
  boolean running;
  Map<String, a> tcd;
  Set<String> tce;
  boolean tcf;
  int tcg;
  boolean tch;
  private Runnable tci;
  
  public a()
  {
    AppMethodBeat.i(101592);
    this.running = false;
    this.dAF = 0;
    this.dAG = 0L;
    this.dAE = false;
    this.dAA = new LinkedList();
    this.dAC = new HashMap();
    this.tcd = new HashMap();
    this.tce = new HashSet();
    this.tcg = 0;
    this.tch = true;
    this.iRt = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(101584);
        boolean bool;
        com.tencent.mm.plugin.fav.a.c localc;
        try
        {
          bool = NetStatusUtil.isWifi(MMApplicationContext.getContext());
          Log.i("MicroMsg.Fav.FavCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(bool), Boolean.valueOf(a.this.tcf) });
          if ((paramAnonymousInt != 4) && (paramAnonymousInt != 6))
          {
            a.this.tcf = bool;
            AppMethodBeat.o(101584);
            return;
          }
          if ((!a.this.tcf) || (bool)) {
            break label471;
          }
          a locala1 = a.this;
          Log.i("MicroMsg.Fav.FavCdnService", "pauseAll");
          localCursor = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().cUL();
          if ((localCursor != null) && (localCursor.moveToFirst()))
          {
            while (localCursor.moveToNext())
            {
              localc = new com.tencent.mm.plugin.fav.a.c();
              localc.convertFrom(localCursor);
              Log.i("MicroMsg.Fav.FavCdnService", "pauseAll, pauseUpload dataId:%s", new Object[] { localc.field_dataId });
              localc.field_status = 4;
              ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
              f.baQ().Ob(localc.field_dataId);
              a.h(((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(localc.field_dataId));
              locala1.ase(localc.field_dataId);
            }
            localCursor.close();
          }
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.Fav.FavCdnService", localException, "", new Object[0]);
          AppMethodBeat.o(101584);
          return;
        }
        Cursor localCursor = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().cUM();
        if ((localCursor != null) && (localCursor.moveToFirst())) {
          while (localCursor.moveToNext())
          {
            localc = new com.tencent.mm.plugin.fav.a.c();
            localc.convertFrom(localCursor);
            Log.i("MicroMsg.Fav.FavCdnService", "pauseAll, pauseDownload dataId:%s", new Object[] { localc.field_dataId });
            localc.field_status = 4;
            ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(localc, new String[] { "dataId" });
            f.baQ().Oc(localc.field_dataId);
            a.h(((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(localc.field_dataId));
            localException.ase(localc.field_dataId);
          }
        }
        if (localCursor != null) {
          localCursor.close();
        }
        label471:
        if ((!a.this.tcf) && (bool))
        {
          a locala2 = a.this;
          Log.i("MicroMsg.Fav.FavCdnService", "startAll");
          ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().startAll();
          locala2.run();
        }
        a.this.tcf = bool;
        AppMethodBeat.o(101584);
      }
    };
    this.tci = new a.4(this);
    this.dAJ = new MTimerHandler(com.tencent.mm.kernel.g.aAk().getLooper(), new a.5(this), false);
    this.iZc = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(101591);
        if (paramAnonymousc != null) {
          Log.i("MicroMsg.Fav.FavCdnService", "cdn transfer callback, mediaid=%s, totallen=%d, offset=%d", new Object[] { paramAnonymousc.mediaId, Long.valueOf(paramAnonymousc.field_toltalLength), Long.valueOf(paramAnonymousc.field_finishedLength) });
        }
        Object localObject1 = "";
        if (paramAnonymousc != null) {
          localObject1 = paramAnonymousc.mediaId;
        }
        while ((paramAnonymousInt == -21006) || (paramAnonymousInt == -21005))
        {
          a.this.ase((String)localObject1);
          AppMethodBeat.o(101591);
          return 0;
          if (paramAnonymousd != null) {
            localObject1 = paramAnonymousd.mediaId;
          }
        }
        if (Util.isNullOrNil((String)localObject1)) {}
        for (;;)
        {
          localObject1 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(paramAnonymousString);
          if (localObject1 == null)
          {
            Log.e("MicroMsg.Fav.FavCdnService", "klem onCdnCallback info null");
            a.this.ase(paramAnonymousString);
            AppMethodBeat.o(101591);
            return 0;
          }
          if (paramAnonymousInt != 0)
          {
            Log.w("MicroMsg.Fav.FavCdnService", "cdn transfer callback, startRet=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            h.CyF.a(10660, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_type), Integer.valueOf(paramAnonymousInt) });
            ((com.tencent.mm.plugin.fav.a.c)localObject1).field_status = 4;
            ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a((com.tencent.mm.plugin.fav.a.c)localObject1, new String[0]);
            a.h((com.tencent.mm.plugin.fav.a.c)localObject1);
            a.this.ase(paramAnonymousString);
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
              ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a((com.tencent.mm.plugin.fav.a.c)localObject1, new String[0]);
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
              ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a((com.tencent.mm.plugin.fav.a.c)localObject1, new String[0]);
              a.a((com.tencent.mm.plugin.fav.a.c)localObject1, paramAnonymousd);
              ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().b((com.tencent.mm.plugin.fav.a.c)localObject1, new String[] { "dataId" });
              a.this.tcd.remove(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId);
              Log.i("MicroMsg.Fav.FavCdnService", "transfer done, mediaid=%s, md5=%s aeskey=%s completeInfo=%s", new Object[] { paramAnonymousd.mediaId, paramAnonymousString, paramAnonymousd.field_aesKey, paramAnonymousd.toString() });
              a.a(a.this, paramAnonymousString);
              h.CyF.a(10625, new Object[] { Integer.valueOf(1), paramAnonymousd.field_fileId, "", paramAnonymousd.field_transInfo });
              break;
              if ((paramAnonymousInt == -2) && (!a.alH(paramAnonymousc)) && (a.fI(paramAnonymousc, (String)localObject3)))
              {
                Log.i("MicroMsg.Fav.FavCdnService", "renameAndCopyFile write amr head ok!");
              }
              else
              {
                localObject2 = new com.tencent.mm.vfs.o(paramAnonymousc);
                localObject3 = new com.tencent.mm.vfs.o((String)localObject3);
                if (((com.tencent.mm.vfs.o)localObject2).exists())
                {
                  Log.i("MicroMsg.Fav.FavCdnService", "rename file suc:%b, old:%s, new:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.vfs.o)localObject2).am((com.tencent.mm.vfs.o)localObject3)), paramAnonymousc, localObject3 });
                  continue;
                  ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnKey = paramAnonymousd.field_aesKey;
                  ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnUrl = paramAnonymousd.field_fileId;
                }
              }
            }
          }
          Log.e("MicroMsg.Fav.FavCdnService", "transfer error, mediaid=%s, retCode:%d", new Object[] { paramAnonymousd.mediaId, Integer.valueOf(paramAnonymousd.field_retCode) });
          paramAnonymousc = (a.a)a.this.tcd.get(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId);
          if (paramAnonymousc != null) {
            paramAnonymousc.errCode = paramAnonymousd.field_retCode;
          }
          if (-6101 == paramAnonymousd.field_retCode)
          {
            ((com.tencent.mm.plugin.fav.a.c)localObject1).field_extFlag |= 0x1;
            h.CyF.idkeyStat(141L, 1L, 1L, true);
            localObject2 = paramAnonymousd.mediaId;
            if (paramAnonymousc != null)
            {
              paramAnonymousInt = paramAnonymousc.jNv;
              label804:
              Log.e("MicroMsg.Fav.FavCdnService", "transfer error, mediaid=%s, retCode:-6101,try time = %d,info.field_type: %d , info.field_dataType: %d", new Object[] { localObject2, Integer.valueOf(paramAnonymousInt), Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_type), Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataType) });
            }
          }
          for (;;)
          {
            ((com.tencent.mm.plugin.fav.a.c)localObject1).field_status = 4;
            h.CyF.a(10660, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_type), Integer.valueOf(paramAnonymousd.field_retCode) });
            ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a((com.tencent.mm.plugin.fav.a.c)localObject1, new String[0]);
            a.h((com.tencent.mm.plugin.fav.a.c)localObject1);
            break;
            paramAnonymousInt = 1;
            break label804;
            switch (paramAnonymousd.field_retCode)
            {
            default: 
              h.CyF.idkeyStat(141L, 0L, 1L, true);
              break;
            case -10003: 
              h.CyF.idkeyStat(141L, 2L, 1L, true);
              break;
            case -10005: 
              h.CyF.idkeyStat(141L, 3L, 1L, true);
              break;
            case -21000: 
              h.CyF.idkeyStat(141L, 4L, 1L, true);
              break;
            case -21009: 
              h.CyF.idkeyStat(141L, 5L, 1L, true);
              break;
            case -21014: 
              h.CyF.idkeyStat(141L, 6L, 1L, true);
              break;
            case -21020: 
              h.CyF.idkeyStat(141L, 7L, 1L, true);
              break;
            case -5103015: 
              h.CyF.idkeyStat(141L, 8L, 1L, true);
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
    this.tcf = NetStatusUtil.isWifi(MMApplicationContext.getContext());
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().a(this.iRt);
    AppMethodBeat.o(101592);
  }
  
  private static int a(com.tencent.mm.plugin.fav.a.c paramc, int paramInt)
  {
    AppMethodBeat.i(101601);
    if (paramc.field_totalLen > 26214400)
    {
      paramInt = com.tencent.mm.i.a.gpR;
      AppMethodBeat.o(101601);
      return paramInt;
    }
    if ((paramc.field_extFlag & 0x1) == 0)
    {
      AppMethodBeat.o(101601);
      return paramInt;
    }
    Log.w("MicroMsg.Fav.FavCdnService", "NEED To Exchange Type, defType %d", new Object[] { Integer.valueOf(paramInt) });
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
  
  static boolean alH(String paramString)
  {
    AppMethodBeat.i(101603);
    localObject1 = null;
    String str = null;
    try
    {
      paramString = s.dB(paramString, false);
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
            Log.printErrStackTrace("MicroMsg.Fav.FavCdnService", paramString, "", new Object[0]);
          }
        }
      }
      str = paramString;
      localObject1 = paramString;
      localObject2 = new String((byte[])localObject2);
      str = paramString;
      localObject1 = paramString;
      Log.i("MicroMsg.Fav.FavCdnService", "head " + (String)localObject2 + "   AmrFileOperator.AMR_NB_HEAD #!AMR\n");
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
          Log.printErrStackTrace("MicroMsg.Fav.FavCdnService", paramString, "", new Object[0]);
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
          Log.printErrStackTrace("MicroMsg.Fav.FavCdnService", localIOException, "", new Object[0]);
        }
      }
    }
    catch (Exception paramString)
    {
      localObject1 = str;
      Log.printErrStackTrace("MicroMsg.Fav.FavCdnService", paramString, "", new Object[0]);
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
          Log.printErrStackTrace("MicroMsg.Fav.FavCdnService", paramString, "", new Object[0]);
        }
      }
    }
    finally
    {
      if (localObject1 == null) {}
    }
  }
  
  /* Error */
  static boolean fI(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 382
    //   3: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 386	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: aload_1
    //   12: iconst_0
    //   13: invokestatic 390	com/tencent/mm/vfs/s:dw	(Ljava/lang/String;Z)Ljava/io/OutputStream;
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
    //   37: ldc_w 376
    //   40: invokevirtual 394	java/lang/String:getBytes	()[B
    //   43: invokevirtual 399	java/io/OutputStream:write	([B)V
    //   46: aload_1
    //   47: astore 6
    //   49: aload_0
    //   50: astore 5
    //   52: aload_0
    //   53: aload 7
    //   55: invokevirtual 404	java/io/InputStream:read	([B)I
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
    //   75: invokevirtual 407	java/io/OutputStream:write	([BII)V
    //   78: goto -32 -> 46
    //   81: astore 7
    //   83: aload_1
    //   84: astore 6
    //   86: aload_0
    //   87: astore 5
    //   89: ldc 166
    //   91: aload 7
    //   93: ldc_w 349
    //   96: iconst_0
    //   97: anewarray 4	java/lang/Object
    //   100: invokestatic 353	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aload_0
    //   104: ifnull +7 -> 111
    //   107: aload_0
    //   108: invokevirtual 408	java/io/InputStream:close	()V
    //   111: aload_1
    //   112: ifnull +221 -> 333
    //   115: aload_1
    //   116: invokevirtual 409	java/io/OutputStream:close	()V
    //   119: iconst_0
    //   120: istore_3
    //   121: ldc_w 382
    //   124: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: iload_3
    //   128: ireturn
    //   129: iconst_1
    //   130: istore_3
    //   131: iload_3
    //   132: istore 4
    //   134: aload_0
    //   135: ifnull +10 -> 145
    //   138: aload_0
    //   139: invokevirtual 408	java/io/InputStream:close	()V
    //   142: iload_3
    //   143: istore 4
    //   145: iload 4
    //   147: istore_3
    //   148: aload_1
    //   149: ifnull -28 -> 121
    //   152: aload_1
    //   153: invokevirtual 409	java/io/OutputStream:close	()V
    //   156: iload 4
    //   158: istore_3
    //   159: goto -38 -> 121
    //   162: astore_0
    //   163: ldc 166
    //   165: aload_0
    //   166: ldc_w 349
    //   169: iconst_0
    //   170: anewarray 4	java/lang/Object
    //   173: invokestatic 353	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: iconst_0
    //   177: istore_3
    //   178: goto -57 -> 121
    //   181: astore_0
    //   182: ldc 166
    //   184: aload_0
    //   185: ldc_w 349
    //   188: iconst_0
    //   189: anewarray 4	java/lang/Object
    //   192: invokestatic 353	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: iconst_0
    //   196: istore 4
    //   198: goto -53 -> 145
    //   201: astore_0
    //   202: ldc 166
    //   204: aload_0
    //   205: ldc_w 349
    //   208: iconst_0
    //   209: anewarray 4	java/lang/Object
    //   212: invokestatic 353	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: goto -104 -> 111
    //   218: astore_0
    //   219: ldc 166
    //   221: aload_0
    //   222: ldc_w 349
    //   225: iconst_0
    //   226: anewarray 4	java/lang/Object
    //   229: invokestatic 353	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   248: invokevirtual 408	java/io/InputStream:close	()V
    //   251: aload 6
    //   253: ifnull +8 -> 261
    //   256: aload 6
    //   258: invokevirtual 409	java/io/OutputStream:close	()V
    //   261: ldc_w 382
    //   264: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   267: aload_1
    //   268: athrow
    //   269: astore_0
    //   270: ldc 166
    //   272: aload_0
    //   273: ldc_w 349
    //   276: iconst_0
    //   277: anewarray 4	java/lang/Object
    //   280: invokestatic 353	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   283: goto -32 -> 251
    //   286: astore_0
    //   287: ldc 166
    //   289: aload_0
    //   290: ldc_w 349
    //   293: iconst_0
    //   294: anewarray 4	java/lang/Object
    //   297: invokestatic 353	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(paramc, new String[] { "dataId" });
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
  
  public final void aax()
  {
    AppMethodBeat.i(101600);
    this.dAA.clear();
    this.dAC.clear();
    this.running = false;
    this.dAE = false;
    AppMethodBeat.o(101600);
  }
  
  public final void arY(String paramString)
  {
    AppMethodBeat.i(101594);
    Log.i("MicroMsg.Fav.FavCdnService", "add force job %s", new Object[] { paramString });
    com.tencent.mm.kernel.g.aAk().postToWorker(new a.3(this, paramString));
    AppMethodBeat.o(101594);
  }
  
  public final void arZ(String paramString)
  {
    AppMethodBeat.i(101599);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(101599);
      return;
    }
    f.baQ().Ob(paramString);
    Log.i("MicroMsg.Fav.FavCdnService", "pause upload md5%s", new Object[] { paramString });
    h(((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(paramString));
    ase(paramString);
    AppMethodBeat.o(101599);
  }
  
  final void ase(String paramString)
  {
    AppMethodBeat.i(101604);
    this.dAE = false;
    this.dAC.remove(paramString);
    pauseDownload(paramString);
    if (this.dAF > 0)
    {
      bck();
      AppMethodBeat.o(101604);
      return;
    }
    Log.i("MicroMsg.Fav.FavCdnService", "klem stopFlag <= 0 , Stop Service");
    aax();
    AppMethodBeat.o(101604);
  }
  
  final void bck()
  {
    AppMethodBeat.i(101596);
    this.dAG = System.currentTimeMillis();
    if ((!this.dAE) && (this.dAA.size() == 0))
    {
      if (e.apn()) {
        break label88;
      }
      Log.e("MicroMsg.Fav.FavCdnService", "klem getNeedRunInfo sdcard not available");
      aax();
    }
    label88:
    Object localObject1;
    Object localObject2;
    while ((!this.dAE) && (this.dAA.size() <= 0))
    {
      aax();
      Log.i("MicroMsg.Fav.FavCdnService", "klem No Data Any More , Stop Service");
      AppMethodBeat.o(101596);
      return;
      if (((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage() != null)
      {
        localObject1 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().cUK();
        if ((localObject1 != null) && (((List)localObject1).size() != 0))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (com.tencent.mm.plugin.fav.a.c)((Iterator)localObject1).next();
            if (this.dAC.containsKey(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId))
            {
              Log.d("MicroMsg.Fav.FavCdnService", "File is Already running:" + ((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId);
            }
            else
            {
              this.dAA.add(localObject2);
              this.dAC.put(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId, null);
            }
          }
          Log.i("MicroMsg.Fav.FavCdnService", "klem GetNeedRun procing:" + this.dAC.size() + ",send:" + this.dAA.size() + "]");
          this.dAA.size();
        }
      }
    }
    if ((!this.dAE) && (this.dAA.size() > 0)) {
      try
      {
        localObject1 = (com.tencent.mm.plugin.fav.a.c)this.dAA.poll();
        if ((localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId)))
        {
          localObject2 = (a)this.tcd.get(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId);
          if (localObject2 == null)
          {
            localObject2 = new a((byte)0);
            ((a)localObject2).jNv = 1;
            ((a)localObject2).tcm = Util.nowMilliSecond();
            this.tcd.put(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId, localObject2);
            if (((com.tencent.mm.plugin.fav.a.c)localObject1).field_type != 0) {
              break label855;
            }
            Log.i("MicroMsg.Fav.FavCdnService", "check favCDN:force job[can upload], localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_favLocalId), ((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId, Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_type), Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataType) });
            i = 1;
            if (i == 0) {
              break label1412;
            }
            this.dAE = true;
            if (localObject1 == null) {
              break label1391;
            }
            Log.i("MicroMsg.Fav.FavCdnService", "doTransfer, md5:%s", new Object[] { ((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId });
            localObject2 = new com.tencent.mm.i.g();
            ((com.tencent.mm.i.g)localObject2).taskName = "task_FavCdnService";
            ((com.tencent.mm.i.g)localObject2).gqy = this.iZc;
            ((com.tencent.mm.i.g)localObject2).field_mediaId = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId;
            if (((com.tencent.mm.plugin.fav.a.c)localObject1).field_type != 0) {
              break label1271;
            }
            ((com.tencent.mm.i.g)localObject2).ehd = true;
            ((com.tencent.mm.i.g)localObject2).field_priority = com.tencent.mm.i.a.gpL;
            ((com.tencent.mm.i.g)localObject2).field_needStorage = true;
            ((com.tencent.mm.i.g)localObject2).field_totalLen = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_totalLen;
            ((com.tencent.mm.i.g)localObject2).field_aesKey = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnKey;
            ((com.tencent.mm.i.g)localObject2).field_fileId = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnUrl;
            ((com.tencent.mm.i.g)localObject2).field_isStreamMedia = ((com.tencent.mm.plugin.fav.a.c)localObject1).cUr();
            ((com.tencent.mm.i.g)localObject2).field_fullpath = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_path;
            ((com.tencent.mm.i.g)localObject2).field_use_multithread = false;
            if (!s.YS(((com.tencent.mm.i.g)localObject2).field_fullpath)) {
              Log.e("MicroMsg.Fav.FavCdnService", "favcdnservice upload, but file not exsit,filePath = %s ", new Object[] { ((com.tencent.mm.plugin.fav.a.c)localObject1).field_path });
            }
            if (!((com.tencent.mm.plugin.fav.a.c)localObject1).cUr()) {
              break label1257;
            }
            ((com.tencent.mm.i.g)localObject2).field_fileType = a((com.tencent.mm.plugin.fav.a.c)localObject1, com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO);
            ((com.tencent.mm.i.g)localObject2).field_force_aeskeycdn = true;
            ((com.tencent.mm.i.g)localObject2).field_trysafecdn = false;
            Log.i("MicroMsg.Fav.FavCdnService", "summersafecdn send force_aeskeycdn[%b] trysafecdn[%b]", new Object[] { Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_force_aeskeycdn), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_trysafecdn) });
            f.baQ().f((com.tencent.mm.i.g)localObject2);
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
          if ((Util.nowMilliSecond() - ((a)localObject2).tcm > 180000L) && (((a)localObject2).errCode != -6101))
          {
            ((a)localObject2).jNv = 1;
            ((a)localObject2).tcm = Util.nowMilliSecond();
            this.tcd.put(localc.field_dataId, localObject2);
          }
          else if (((a)localObject2).jNv <= 3)
          {
            ((a)localObject2).jNv += 1;
            this.tcd.put(localc.field_dataId, localObject2);
          }
          else
          {
            Log.e("MicroMsg.Fav.FavCdnService", "check favCDN:match transfer limit 3times , localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
            g(localc);
            i = 0;
            continue;
            label855:
            if ((this.tce.contains(localc.field_dataId)) || (com.tencent.mm.plugin.fav.a.b.arJ(localc.field_dataId)))
            {
              Log.i("MicroMsg.Fav.FavCdnService", "check favCDN:force job[normal], localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
            }
            else if (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))
            {
              Log.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, NOT WIFI, pause it, localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
              g(localc);
              i = 0;
            }
            else if (localc.field_type == 0)
            {
              Log.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI & SENDING, not auto limit, localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
            }
            else if (!this.tch)
            {
              Log.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, not auto limit, localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
              this.tcg = 0;
            }
            else if (this.tcg < 10)
            {
              Log.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, auto limit %d, current index %d, retryTimes %dlocalid %d, dataid %s, type %d, dataType %d", new Object[] { Integer.valueOf(10), Integer.valueOf(this.tcg), Integer.valueOf(((a)localObject2).jNv), Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
              if (((a)localObject2).jNv == 1) {
                this.tcg += 1;
              }
            }
            else
            {
              Log.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, match auto limit %d", new Object[] { Integer.valueOf(10) });
              i = 0;
              continue;
              label1257:
              ((com.tencent.mm.i.g)localObject2).field_fileType = a(localc, com.tencent.mm.i.a.MediaType_FAVORITE_FILE);
            }
          }
        }
        label1271:
        ((com.tencent.mm.i.g)localObject2).ehd = false;
        ((com.tencent.mm.i.g)localObject2).field_totalLen = localc.field_totalLen;
        ((com.tencent.mm.i.g)localObject2).field_aesKey = localc.field_cdnKey;
        ((com.tencent.mm.i.g)localObject2).field_fileId = localc.field_cdnUrl;
        ((com.tencent.mm.i.g)localObject2).field_priority = com.tencent.mm.i.a.gpM;
        ((com.tencent.mm.i.g)localObject2).gqy = this.iZc;
        ((com.tencent.mm.i.g)localObject2).field_fullpath = (localc.field_path + ".temp");
        ((com.tencent.mm.i.g)localObject2).field_needStorage = true;
        ((com.tencent.mm.i.g)localObject2).field_isStreamMedia = localc.cUr();
        ((com.tencent.mm.i.g)localObject2).field_use_multithread = false;
        if (localc.cUr()) {}
        for (((com.tencent.mm.i.g)localObject2).field_fileType = a(localc, com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO);; ((com.tencent.mm.i.g)localObject2).field_fileType = a(localc, com.tencent.mm.i.a.MediaType_FAVORITE_FILE))
        {
          f.baQ().b((com.tencent.mm.i.g)localObject2, -1);
          h(localc);
          label1391:
          AppMethodBeat.o(101596);
          return;
        }
        label1412:
        if (this.tcg >= 10)
        {
          aax();
          AppMethodBeat.o(101596);
          return;
        }
        this.dAJ.startTimer(500L);
      }
    }
    AppMethodBeat.o(101596);
  }
  
  public final void d(com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(101606);
    if (paramc != null) {
      this.dAA.add(paramc);
    }
    AppMethodBeat.o(101606);
  }
  
  public final void mx(boolean paramBoolean)
  {
    AppMethodBeat.i(101593);
    com.tencent.mm.kernel.g.aAk().postToWorker(new a.2(this, paramBoolean));
    AppMethodBeat.o(101593);
  }
  
  public final void pauseDownload(String paramString)
  {
    AppMethodBeat.i(101598);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(101598);
      return;
    }
    if (this.dAC.containsKey(paramString))
    {
      f.baQ().Oc(paramString);
      Log.i("MicroMsg.Fav.FavCdnService", "pause download md5%s", new Object[] { paramString });
      h(((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(paramString));
      ase(paramString);
    }
    AppMethodBeat.o(101598);
  }
  
  public final void run()
  {
    AppMethodBeat.i(101595);
    Log.i("MicroMsg.Fav.FavCdnService", "run fav cdn server");
    com.tencent.mm.kernel.g.aAk().getWorkerHandler().removeCallbacks(this.tci);
    com.tencent.mm.kernel.g.aAk().postToWorker(this.tci);
    AppMethodBeat.o(101595);
  }
  
  final class a
  {
    int errCode = 0;
    int jNv;
    long tcm;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.a
 * JD-Core Version:    0.7.0.1
 */