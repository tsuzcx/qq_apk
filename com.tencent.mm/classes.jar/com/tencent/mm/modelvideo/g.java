package com.tencent.mm.modelvideo;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.protocal.protobuf.dnq;
import com.tencent.mm.protocal.protobuf.dnr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.Vector;
import junit.framework.Assert;

public final class g
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  private static int hZl = 32000;
  private final int MAX_TIMES;
  boolean cTq;
  private com.tencent.mm.ak.g callback;
  private String dwi;
  public String fileName;
  f.a gma;
  private boolean hIH;
  private String hIq;
  private g.a hIz;
  public s hYO;
  private int hYQ;
  private boolean hYR;
  private final long hZm;
  private int hZn;
  private boolean hZo;
  private boolean hZp;
  private int hZq;
  private int hZr;
  int hZs;
  au htR;
  int retCode;
  private com.tencent.mm.ak.b rr;
  private long startTime;
  
  public g(String paramString)
  {
    AppMethodBeat.i(126858);
    this.dwi = "";
    this.hZm = 1800000L;
    this.retCode = 0;
    this.hYR = false;
    this.cTq = false;
    this.gma = null;
    this.hIH = true;
    this.hIq = "";
    this.startTime = 0L;
    this.hZn = -1;
    this.hYQ = com.tencent.mm.i.a.MediaType_VIDEO;
    this.hZo = false;
    this.hZp = false;
    this.hZq = 0;
    this.hZr = 0;
    this.hIz = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(126854);
        ac.d("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { g.a(g.this), g.b(g.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          ac.d("MicroMsg.NetSceneUploadVideo", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { g.b(g.this) });
          AppMethodBeat.o(126854);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          u.Ea(g.c(g.this));
          new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(g.d(g.this)), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(com.tencent.mm.sdk.platformtools.ai.getContext())), Integer.valueOf(g.e(g.this)), Integer.valueOf(0), "" })).aHZ();
          g.f(g.this).onSceneEnd(3, paramAnonymousInt, "", g.this);
          AppMethodBeat.o(126854);
          return 0;
        }
        g.a(g.this, u.Ej(g.c(g.this)));
        if ((g.g(g.this) == null) || (g.g(g.this).status == 105))
        {
          if (g.g(g.this) == null) {}
          for (int i = -1;; i = g.g(g.this).status)
          {
            ac.i("MicroMsg.NetSceneUploadVideo", "%s info is null or has paused, status:%d", new Object[] { g.a(g.this), Integer.valueOf(i) });
            com.tencent.mm.an.f.aDD().BQ(g.b(g.this));
            g.f(g.this).onSceneEnd(3, paramAnonymousInt, "info is null or has paused, status".concat(String.valueOf(i)), g.this);
            AppMethodBeat.o(126854);
            return 0;
          }
        }
        if (paramAnonymousc != null)
        {
          if (g.g(g.this).hZn > paramAnonymousc.field_finishedLength)
          {
            ac.w("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnEndProc error oldpos:%d newpos:%d", new Object[] { g.a(g.this), Integer.valueOf(g.g(g.this).hZn), Long.valueOf(paramAnonymousc.field_finishedLength) });
            AppMethodBeat.o(126854);
            return 0;
          }
          g.g(g.this).iaH = bs.aNx();
          g.g(g.this).hZn = ((int)paramAnonymousc.field_finishedLength);
          g.g(g.this).drx = 1032;
          u.f(g.g(g.this));
          AppMethodBeat.o(126854);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode != 0)
          {
            ac.e("MicroMsg.NetSceneUploadVideo", "%s cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { g.a(g.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo });
            u.Ea(g.c(g.this));
            paramAnonymousString = com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(1), Long.valueOf(g.d(g.this)), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(com.tencent.mm.sdk.platformtools.ai.getContext())), Integer.valueOf(g.e(g.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fqM });
            new com.tencent.mm.g.b.a.h(paramAnonymousString).aHZ();
            new com.tencent.mm.g.b.a.f(paramAnonymousString).aHZ();
            g.f(g.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", g.this);
          }
        }
        else
        {
          AppMethodBeat.o(126854);
          return 0;
        }
        ac.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn uploadvideo by cdn, videohash isHitCacheUpload: %d, enableHitcheck:%b", new Object[] { g.a(g.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(g.h(g.this)) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.wUl;
        if (g.i(g.this))
        {
          paramAnonymousInt = 810;
          label844:
          paramAnonymousString.f(12696, new Object[] { Integer.valueOf(paramAnonymousInt + paramAnonymousd.field_UploadHitCacheType), Integer.valueOf(g.g(g.this).hux) });
          paramAnonymousBoolean = paramAnonymousd.field_isVideoReduced;
          ac.i("MicroMsg.NetSceneUploadVideo", "%s it video was reduced by cdn %b %s", new Object[] { g.a(g.this), Boolean.valueOf(paramAnonymousBoolean), g.c(g.this) });
          if (paramAnonymousBoolean) {
            break label1604;
          }
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(106L, 205L, 1L, false);
          if ((g.k(g.this) > 0) && (paramAnonymousd.field_thumbimgLength > 0))
          {
            ac.i("MicroMsg.NetSceneUploadVideo", "%s send video thumb too big thumb length [%d, %d] ", new Object[] { g.a(g.this), Integer.valueOf(g.k(g.this)), Integer.valueOf(paramAnonymousd.field_thumbimgLength) });
            if (g.k(g.this) * 2 <= paramAnonymousd.field_thumbimgLength) {
              break label1570;
            }
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(106L, 206L, 1L, false);
          }
          label1044:
          o.aJy();
          paramAnonymousInt = (int)com.tencent.mm.vfs.i.aSp(t.DV(g.c(g.this)));
          ac.i("MicroMsg.NetSceneUploadVideo", "%s send video too big thumb length [%d, %d] ", new Object[] { g.a(g.this), Integer.valueOf(g.g(g.this).hux), Integer.valueOf(paramAnonymousInt) });
          if (g.g(g.this).hux == paramAnonymousInt) {
            break label1587;
          }
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(106L, 208L, 1L, false);
          label1136:
          g.a(g.this, u.Ej(g.c(g.this)));
          if (bs.isNullOrNil(g.g(g.this).aJK()))
          {
            paramAnonymousString = "<msg><videomsg aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnvideourl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "length=\"" + paramAnonymousd.field_fileLength + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\"/></msg>";
            ac.i("MicroMsg.NetSceneUploadVideo", "%s cdn callback new build cdnInfo:%s", new Object[] { g.a(g.this), paramAnonymousString });
            g.g(g.this).iaO = paramAnonymousString;
            u.f(g.g(g.this));
          }
          paramAnonymousString = bv.L(g.g(g.this).aJK(), "msg");
          if (paramAnonymousString != null)
          {
            paramAnonymousc = o.aJy();
            o.aJy();
            boolean bool = paramAnonymousc.r(t.DV(g.c(g.this)), (String)paramAnonymousString.get(".msg.videomsg.$cdnvideourl"), (String)paramAnonymousString.get(".msg.videomsg.$aeskey"));
            paramAnonymousString = com.tencent.mm.plugin.report.service.h.wUl;
            if (!bool) {
              break label1621;
            }
            paramAnonymousInt = 1;
            label1459:
            paramAnonymousString.f(12696, new Object[] { Integer.valueOf(paramAnonymousInt + 900), Integer.valueOf(g.g(g.this).hux) });
          }
          paramAnonymousString = com.tencent.mm.kernel.g.agi();
          paramAnonymousc = g.c(g.this);
          if (!paramAnonymousBoolean) {
            break label1626;
          }
        }
        label1570:
        label1587:
        label1604:
        label1621:
        label1626:
        for (paramAnonymousInt = 0;; paramAnonymousInt = g.l(g.this))
        {
          paramAnonymousString.a(new h(paramAnonymousc, paramAnonymousInt, paramAnonymousd, new h.a()
          {
            public final void dm(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(126853);
              if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == 102))
              {
                com.tencent.mm.kernel.g.agU().az(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(126852);
                    g.m(g.this);
                    g.g(g.this).status = 104;
                    g.g(g.this).createTime = bs.aNx();
                    g.g(g.this).iaH = bs.aNx();
                    g.g(g.this).hZn = 0;
                    g.g(g.this).drx = 1800;
                    boolean bool = u.f(g.g(g.this));
                    ac.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { g.a(g.this), Boolean.valueOf(g.h(g.this)), Boolean.valueOf(bool), Long.valueOf(g.g(g.this).createTime) });
                    g.this.doScene(g.n(g.this), g.f(g.this));
                    AppMethodBeat.o(126852);
                  }
                });
                AppMethodBeat.o(126853);
                return;
              }
              new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(1), Long.valueOf(g.d(g.this)), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(com.tencent.mm.sdk.platformtools.ai.getContext())), Integer.valueOf(g.e(g.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fqM })).aHZ();
              a.a(g.g(g.this), 0);
              g.a(g.this, paramAnonymousd);
              g.f(g.this).onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", g.this);
              AppMethodBeat.o(126853);
            }
          }), 0);
          break;
          if (g.j(g.this))
          {
            paramAnonymousInt = 820;
            break label844;
          }
          paramAnonymousInt = 830;
          break label844;
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(106L, 207L, 1L, false);
          break label1044;
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(106L, 209L, 1L, false);
          break label1136;
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(106L, 200L, 1L, false);
          break label1136;
          paramAnonymousInt = 2;
          break label1459;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.hZs = 0;
    this.htR = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(126855);
        if (g.this.doScene(g.o(g.this), g.f(g.this)) == -1)
        {
          g.a(g.this, 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          g.f(g.this).onSceneEnd(3, -1, "doScene failed", g.this);
        }
        AppMethodBeat.o(126855);
        return false;
      }
    }, true);
    boolean bool;
    if (paramString != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      ac.d("MicroMsg.NetSceneUploadVideo", "NetSceneUploadVideo:  file:".concat(String.valueOf(paramString)));
      this.fileName = paramString;
      this.hYO = u.Ej(paramString);
      if (this.hYO == null) {
        break label253;
      }
    }
    label253:
    for (this.MAX_TIMES = 2500;; this.MAX_TIMES = 0)
    {
      this.gma = new f.a();
      if ((this.hYO != null) && (3 == this.hYO.iaP)) {
        this.hYQ = com.tencent.mm.i.a.MediaType_TinyVideo;
      }
      ac.i("MicroMsg.NetSceneUploadVideo", "%s NetSceneUploadVideo:  videoType:[%d]", new Object[] { aJp(), Integer.valueOf(this.hYQ) });
      AppMethodBeat.o(126858);
      return;
      bool = false;
      break;
    }
  }
  
  /* Error */
  private String DL(String paramString)
  {
    // Byte code:
    //   0: ldc 192
    //   2: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 194	com/tencent/mm/vfs/e
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 196	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   13: astore 9
    //   15: new 194	com/tencent/mm/vfs/e
    //   18: dup
    //   19: aload 9
    //   21: invokevirtual 200	com/tencent/mm/vfs/e:fxU	()Lcom/tencent/mm/vfs/e;
    //   24: new 202	java/lang/StringBuilder
    //   27: dup
    //   28: ldc 204
    //   30: invokespecial 205	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload 9
    //   35: invokevirtual 208	com/tencent/mm/vfs/e:getName	()Ljava/lang/String;
    //   38: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 218	com/tencent/mm/vfs/e:<init>	(Lcom/tencent/mm/vfs/e;Ljava/lang/String;)V
    //   47: astore 10
    //   49: aconst_null
    //   50: astore 7
    //   52: aconst_null
    //   53: astore 8
    //   55: aconst_null
    //   56: astore 5
    //   58: aconst_null
    //   59: astore 6
    //   61: ldc 126
    //   63: ldc 220
    //   65: iconst_1
    //   66: anewarray 171	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload 9
    //   73: invokevirtual 224	com/tencent/mm/vfs/e:length	()J
    //   76: invokestatic 229	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   79: aastore
    //   80: invokestatic 231	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload 9
    //   85: invokevirtual 224	com/tencent/mm/vfs/e:length	()J
    //   88: ldc2_w 232
    //   91: lcmp
    //   92: ifle +580 -> 672
    //   95: aload 10
    //   97: invokevirtual 237	com/tencent/mm/vfs/e:exists	()Z
    //   100: ifeq +120 -> 220
    //   103: ldc 126
    //   105: ldc 239
    //   107: iconst_1
    //   108: anewarray 171	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload 10
    //   115: invokevirtual 243	com/tencent/mm/vfs/e:fxV	()Landroid/net/Uri;
    //   118: invokestatic 249	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   121: aastore
    //   122: invokestatic 231	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   125: iconst_1
    //   126: istore_2
    //   127: aload 8
    //   129: astore 4
    //   131: aload 6
    //   133: astore 5
    //   135: aload 4
    //   137: ifnull +8 -> 145
    //   140: aload 4
    //   142: invokevirtual 254	java/io/InputStream:close	()V
    //   145: iload_2
    //   146: istore_3
    //   147: aload 5
    //   149: ifnull +10 -> 159
    //   152: aload 5
    //   154: invokevirtual 257	java/io/OutputStream:close	()V
    //   157: iload_2
    //   158: istore_3
    //   159: iload_3
    //   160: ifeq +394 -> 554
    //   163: ldc 126
    //   165: ldc_w 259
    //   168: iconst_3
    //   169: anewarray 171	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: aload_0
    //   175: invokespecial 175	com/tencent/mm/modelvideo/g:aJp	()Ljava/lang/String;
    //   178: aastore
    //   179: dup
    //   180: iconst_1
    //   181: aload 10
    //   183: invokevirtual 224	com/tencent/mm/vfs/e:length	()J
    //   186: invokestatic 229	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   189: aastore
    //   190: dup
    //   191: iconst_2
    //   192: aload 10
    //   194: invokevirtual 243	com/tencent/mm/vfs/e:fxV	()Landroid/net/Uri;
    //   197: invokestatic 249	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   200: aastore
    //   201: invokestatic 183	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: aload 10
    //   206: invokevirtual 243	com/tencent/mm/vfs/e:fxV	()Landroid/net/Uri;
    //   209: invokestatic 249	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   212: astore_1
    //   213: ldc 192
    //   215: invokestatic 186	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: aload_1
    //   219: areturn
    //   220: aload 9
    //   222: invokevirtual 243	com/tencent/mm/vfs/e:fxV	()Landroid/net/Uri;
    //   225: invokestatic 249	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   228: invokestatic 265	com/tencent/mm/sdk/platformtools/f:aKw	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   231: astore 11
    //   233: aload 11
    //   235: ifnonnull +121 -> 356
    //   238: ldc_w 267
    //   241: astore 4
    //   243: ldc 126
    //   245: ldc_w 269
    //   248: iconst_1
    //   249: anewarray 171	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: aload 4
    //   256: aastore
    //   257: invokestatic 183	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: aload 11
    //   262: ifnull +131 -> 393
    //   265: aload 11
    //   267: getfield 274	android/graphics/BitmapFactory$Options:outWidth	I
    //   270: sipush 288
    //   273: if_icmpgt +14 -> 287
    //   276: aload 11
    //   278: getfield 277	android/graphics/BitmapFactory$Options:outHeight	I
    //   281: sipush 288
    //   284: if_icmple +109 -> 393
    //   287: aload 9
    //   289: invokevirtual 243	com/tencent/mm/vfs/e:fxV	()Landroid/net/Uri;
    //   292: invokestatic 249	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   295: sipush 288
    //   298: sipush 288
    //   301: getstatic 283	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   304: bipush 60
    //   306: new 202	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   313: aload 10
    //   315: invokevirtual 200	com/tencent/mm/vfs/e:fxU	()Lcom/tencent/mm/vfs/e;
    //   318: invokevirtual 243	com/tencent/mm/vfs/e:fxV	()Landroid/net/Uri;
    //   321: invokestatic 249	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   324: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: ldc_w 286
    //   330: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: aload 10
    //   338: invokevirtual 208	com/tencent/mm/vfs/e:getName	()Ljava/lang/String;
    //   341: invokestatic 290	com/tencent/mm/sdk/platformtools/f:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;)Z
    //   344: istore_2
    //   345: aload 6
    //   347: astore 5
    //   349: aload 8
    //   351: astore 4
    //   353: goto -218 -> 135
    //   356: new 202	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   363: aload 11
    //   365: getfield 274	android/graphics/BitmapFactory$Options:outWidth	I
    //   368: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   371: ldc_w 295
    //   374: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: aload 11
    //   379: getfield 277	android/graphics/BitmapFactory$Options:outHeight	I
    //   382: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   385: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: astore 4
    //   390: goto -147 -> 243
    //   393: aload 9
    //   395: invokestatic 301	com/tencent/mm/vfs/i:ag	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   398: astore 4
    //   400: aload 4
    //   402: fconst_0
    //   403: sipush 288
    //   406: sipush 288
    //   409: invokestatic 304	com/tencent/mm/sdk/platformtools/f:a	(Ljava/io/InputStream;FII)Landroid/graphics/Bitmap;
    //   412: astore 8
    //   414: aload 8
    //   416: ifnull +247 -> 663
    //   419: aload 10
    //   421: invokestatic 308	com/tencent/mm/vfs/i:ah	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   424: astore 6
    //   426: aload 6
    //   428: astore 5
    //   430: aload 5
    //   432: astore 7
    //   434: aload 4
    //   436: astore 6
    //   438: aload 8
    //   440: getstatic 283	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   443: bipush 60
    //   445: aload 5
    //   447: invokevirtual 314	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   450: istore_2
    //   451: goto -316 -> 135
    //   454: astore 8
    //   456: aconst_null
    //   457: astore 5
    //   459: aconst_null
    //   460: astore 4
    //   462: aload 5
    //   464: astore 7
    //   466: aload 4
    //   468: astore 6
    //   470: ldc 126
    //   472: ldc_w 316
    //   475: iconst_1
    //   476: anewarray 171	java/lang/Object
    //   479: dup
    //   480: iconst_0
    //   481: aload 8
    //   483: invokestatic 322	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   486: aastore
    //   487: invokestatic 325	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   490: aload 4
    //   492: ifnull +8 -> 500
    //   495: aload 4
    //   497: invokevirtual 254	java/io/InputStream:close	()V
    //   500: aload 5
    //   502: ifnull +156 -> 658
    //   505: aload 5
    //   507: invokevirtual 257	java/io/OutputStream:close	()V
    //   510: iconst_0
    //   511: istore_3
    //   512: goto -353 -> 159
    //   515: astore 4
    //   517: iconst_0
    //   518: istore_3
    //   519: goto -360 -> 159
    //   522: astore_1
    //   523: aload 7
    //   525: astore 4
    //   527: aload 4
    //   529: ifnull +8 -> 537
    //   532: aload 4
    //   534: invokevirtual 254	java/io/InputStream:close	()V
    //   537: aload 5
    //   539: ifnull +8 -> 547
    //   542: aload 5
    //   544: invokevirtual 257	java/io/OutputStream:close	()V
    //   547: ldc 192
    //   549: invokestatic 186	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   552: aload_1
    //   553: athrow
    //   554: ldc 126
    //   556: ldc_w 327
    //   559: iconst_3
    //   560: anewarray 171	java/lang/Object
    //   563: dup
    //   564: iconst_0
    //   565: aload_0
    //   566: invokespecial 175	com/tencent/mm/modelvideo/g:aJp	()Ljava/lang/String;
    //   569: aastore
    //   570: dup
    //   571: iconst_1
    //   572: aload 9
    //   574: invokevirtual 224	com/tencent/mm/vfs/e:length	()J
    //   577: invokestatic 229	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   580: aastore
    //   581: dup
    //   582: iconst_2
    //   583: aload 9
    //   585: invokevirtual 243	com/tencent/mm/vfs/e:fxV	()Landroid/net/Uri;
    //   588: invokestatic 249	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   591: aastore
    //   592: invokestatic 183	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   595: ldc 192
    //   597: invokestatic 186	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   600: aload_1
    //   601: areturn
    //   602: astore 4
    //   604: goto -459 -> 145
    //   607: astore 4
    //   609: iload_2
    //   610: istore_3
    //   611: goto -452 -> 159
    //   614: astore 4
    //   616: goto -116 -> 500
    //   619: astore 4
    //   621: goto -84 -> 537
    //   624: astore 4
    //   626: goto -79 -> 547
    //   629: astore_1
    //   630: goto -103 -> 527
    //   633: astore_1
    //   634: aload 7
    //   636: astore 5
    //   638: aload 6
    //   640: astore 4
    //   642: goto -115 -> 527
    //   645: astore 8
    //   647: aconst_null
    //   648: astore 5
    //   650: goto -188 -> 462
    //   653: astore 8
    //   655: goto -193 -> 462
    //   658: iconst_0
    //   659: istore_3
    //   660: goto -501 -> 159
    //   663: iconst_0
    //   664: istore_2
    //   665: aload 6
    //   667: astore 5
    //   669: goto -534 -> 135
    //   672: iconst_0
    //   673: istore_2
    //   674: aload 6
    //   676: astore 5
    //   678: aload 8
    //   680: astore 4
    //   682: goto -547 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	685	0	this	g
    //   0	685	1	paramString	String
    //   126	548	2	bool1	boolean
    //   146	514	3	bool2	boolean
    //   129	367	4	localObject1	Object
    //   515	1	4	localIOException1	java.io.IOException
    //   525	8	4	localObject2	Object
    //   602	1	4	localIOException2	java.io.IOException
    //   607	1	4	localIOException3	java.io.IOException
    //   614	1	4	localIOException4	java.io.IOException
    //   619	1	4	localIOException5	java.io.IOException
    //   624	1	4	localIOException6	java.io.IOException
    //   640	41	4	localObject3	Object
    //   56	621	5	localObject4	Object
    //   59	616	6	localObject5	Object
    //   50	585	7	localObject6	Object
    //   53	386	8	localBitmap	android.graphics.Bitmap
    //   454	28	8	localException1	Exception
    //   645	1	8	localException2	Exception
    //   653	26	8	localException3	Exception
    //   13	571	9	locale1	com.tencent.mm.vfs.e
    //   47	373	10	locale2	com.tencent.mm.vfs.e
    //   231	147	11	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   83	125	454	java/lang/Exception
    //   220	233	454	java/lang/Exception
    //   243	260	454	java/lang/Exception
    //   265	287	454	java/lang/Exception
    //   287	345	454	java/lang/Exception
    //   356	390	454	java/lang/Exception
    //   393	400	454	java/lang/Exception
    //   505	510	515	java/io/IOException
    //   83	125	522	finally
    //   220	233	522	finally
    //   243	260	522	finally
    //   265	287	522	finally
    //   287	345	522	finally
    //   356	390	522	finally
    //   393	400	522	finally
    //   140	145	602	java/io/IOException
    //   152	157	607	java/io/IOException
    //   495	500	614	java/io/IOException
    //   532	537	619	java/io/IOException
    //   542	547	624	java/io/IOException
    //   400	414	629	finally
    //   419	426	629	finally
    //   438	451	633	finally
    //   470	490	633	finally
    //   400	414	645	java/lang/Exception
    //   419	426	645	java/lang/Exception
    //   438	451	653	java/lang/Exception
  }
  
  private boolean aJo()
  {
    AppMethodBeat.i(126857);
    if (w.xs(this.hYO.getUser()))
    {
      ac.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn user:%s", new Object[] { aJp(), this.hYO.getUser() });
      AppMethodBeat.o(126857);
      return false;
    }
    com.tencent.mm.an.f.aDD();
    if ((!com.tencent.mm.an.b.oz(2)) && (this.hYO.iaN != 1))
    {
      localObject1 = aJp();
      com.tencent.mm.an.f.aDD();
      ac.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { localObject1, Boolean.valueOf(com.tencent.mm.an.b.oz(2)), Integer.valueOf(this.hYO.iaN) });
      AppMethodBeat.o(126857);
      return false;
    }
    this.hIq = com.tencent.mm.an.c.a("upvideo", this.hYO.createTime, this.hYO.getUser(), this.hYO.getFileName());
    if (bs.isNullOrNil(this.hIq))
    {
      ac.w("MicroMsg.NetSceneUploadVideo", "%s cdntra genClientId failed not use cdn file:%s", new Object[] { aJp(), this.hYO.getFileName() });
      AppMethodBeat.o(126857);
      return false;
    }
    o.aJy();
    Object localObject1 = t.DW(this.fileName);
    o.aJy();
    String str2 = t.DV(this.fileName);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.frb = this.hIz;
    localg.field_mediaId = this.hIq;
    localg.field_fullpath = str2;
    localg.field_thumbpath = DL((String)localObject1);
    localg.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
    localg.field_enable_hitcheck = this.hIH;
    boolean bool1;
    label364:
    String str1;
    Object localObject3;
    if (com.tencent.mm.modelcontrol.d.aDL().BW(str2))
    {
      i = 1;
      localg.field_largesvideo = i;
      if ((this.hYO != null) && (3 == this.hYO.iaP)) {
        localg.field_smallVideoFlag = 1;
      }
      localObject1 = aJp();
      if (this.hYO.iaS != null) {
        break label726;
      }
      bool1 = true;
      ac.i("MicroMsg.NetSceneUploadVideo", "%s upload video MMSightExtInfo is null? %b %s", new Object[] { localObject1, Boolean.valueOf(bool1), this.fileName });
      if ((this.hYO.iaS != null) && (this.hYO.iaS.FhZ))
      {
        ac.i("MicroMsg.NetSceneUploadVideo", "%s local capture video, mark use large video", new Object[] { aJp() });
        localObject1 = n.aJw();
        o.aJy();
        ((n)localObject1).a("", t.DV(this.fileName), this.hYO.getUser(), "", "", 2, 2);
        com.tencent.mm.modelcontrol.d.aDL();
        localg.field_largesvideo = com.tencent.mm.modelcontrol.d.b(com.tencent.mm.modelcontrol.d.aDL().aDM());
      }
      str1 = aJp();
      localObject3 = this.hYO.getFileName();
      if (this.hYO.iaR != null) {
        break label732;
      }
      localObject1 = "null";
      label522:
      ac.i("MicroMsg.NetSceneUploadVideo", "%s checkAD file:%s adinfo:%s", new Object[] { str1, localObject3, localObject1 });
      if ((this.hYO.iaR != null) && (!bs.isNullOrNil(this.hYO.iaR.hkb))) {
        localg.field_advideoflag = 1;
      }
      localg.field_talker = this.hYO.getUser();
      if (!w.sQ(this.hYO.getUser())) {
        break label747;
      }
    }
    label726:
    label732:
    label747:
    for (int i = 1;; i = 0)
    {
      localg.field_chattype = i;
      localg.field_priority = com.tencent.mm.i.a.fqp;
      localg.field_needStorage = false;
      localg.field_isStreamMedia = false;
      localg.field_trysafecdn = true;
      this.hZr = ((int)com.tencent.mm.vfs.i.aSp(localg.field_fullpath));
      this.hZq = ((int)com.tencent.mm.vfs.i.aSp(localg.field_thumbpath));
      if (this.hZq < com.tencent.mm.i.a.fqK) {
        break label752;
      }
      ac.w("MicroMsg.NetSceneUploadVideo", "%s cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { aJp(), localg.field_thumbpath, Integer.valueOf(this.hZq) });
      AppMethodBeat.o(126857);
      return false;
      i = 0;
      break;
      bool1 = false;
      break label364;
      localObject1 = this.hYO.iaR.hkb;
      break label522;
    }
    label752:
    localObject1 = bv.L(this.hYO.aJK(), "msg");
    boolean bool2;
    label1188:
    int m;
    long l1;
    label1275:
    Object localObject2;
    label1293:
    label1448:
    label1454:
    label1460:
    label1466:
    label1472:
    label1478:
    label1484:
    Object localObject5;
    Object localObject4;
    label1894:
    int k;
    int j;
    label1957:
    int i2;
    if (localObject1 != null)
    {
      localg.field_fileId = ((String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"));
      localg.field_aesKey = ((String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
      this.hZp = true;
      localObject1 = com.tencent.mm.plugin.report.service.h.wUl;
      if (this.hZo)
      {
        i = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject1).f(12696, new Object[] { Integer.valueOf(i + 700), Integer.valueOf(this.hYO.hux) });
        if ((bs.isNullOrNil(localg.field_aesKey)) || (bs.isNullOrNil(localg.field_aesKey)))
        {
          localg.field_aesKey = "";
          localg.field_fileId = "";
        }
        ac.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn check hit cache VideoHash :%s %s %s %b %d", new Object[] { aJp(), localg.field_mediaId, localg.field_fileId, localg.field_aesKey, Boolean.valueOf(this.hIH), Integer.valueOf(localg.field_largesvideo) });
        if (com.tencent.mm.an.f.aDD().f(localg)) {
          break label2875;
        }
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 226L, 1L, false);
        ac.e("MicroMsg.NetSceneUploadVideo", "%s cdntra addSendTask failed.", new Object[] { aJp() });
        this.hIq = "";
        AppMethodBeat.o(126857);
        return false;
      }
    }
    else
    {
      ac.i("MicroMsg.NetSceneUploadVideo", "%s cdntra parse video recv xml failed", new Object[] { aJp() });
      int n;
      int i1;
      Vector localVector2;
      for (;;)
      {
        try
        {
          str1 = bs.nullAsNil(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("UseVideoHash"));
          localObject1 = str1.split(",");
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agP();
          i = com.tencent.mm.b.i.cc(com.tencent.mm.kernel.a.getUin(), 100);
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break label1454;
          }
          if (bs.getInt(localObject1[0], 0) < i) {
            break label1448;
          }
          bool1 = true;
          if ((localObject1 == null) || (localObject1.length < 2)) {
            break label1466;
          }
          if (bs.getInt(localObject1[1], 0) < i) {
            break label1460;
          }
          bool2 = true;
          if ((localObject1 == null) || (localObject1.length < 3)) {
            break label1478;
          }
          if (bs.getInt(localObject1[2], 0) < i) {
            break label1472;
          }
          bool3 = true;
          if (!com.tencent.mm.sdk.a.b.eUk()) {
            break label2949;
          }
          bool1 = true;
          bool2 = true;
          bool3 = true;
          if (!bool2) {
            break label2852;
          }
          localObject3 = o.aJy();
          m = bs.getInt(localObject1[2], 0);
          ac.i("MicroMsg.VideoInfoStorage", "checkVideoHash in fullCheckRatio:%s path:%s stack:%s", new Object[] { Integer.valueOf(m), str2, bs.eWi() });
          l1 = bs.eWj();
          if (!bs.isNullOrNil(str2)) {
            break label1484;
          }
          ac.e("MicroMsg.VideoInfoStorage", "checkVideoHash failed , path:%s ", new Object[] { str2 });
          localObject1 = "";
          if (bs.isNullOrNil((String)localObject1)) {
            break label2852;
          }
          localObject1 = ((String)localObject1).split("##");
          if ((bool1) && (localObject1 != null) && (localObject1.length == 2))
          {
            localg.field_fileId = localObject1[0];
            localg.field_aesKey = localObject1[1];
            this.hZo = true;
          }
          ac.i("MicroMsg.NetSceneUploadVideo", "%s CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", new Object[] { aJp(), Boolean.valueOf(com.tencent.mm.sdk.a.b.eUk()), str1, Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(this.hZo), localg.field_fileId, localg.field_aesKey });
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.NetSceneUploadVideo", "Check use videohash :%s", new Object[] { bs.m(localException) });
        }
        break;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool2 = false;
        continue;
        bool2 = false;
        continue;
        boolean bool3 = false;
        continue;
        bool3 = false;
        continue;
        localObject2 = t.DY(str2);
        if ((localObject2 == null) || (localObject2.length < 33))
        {
          ac.e("MicroMsg.VideoInfoStorage", "checkVideoHash  readHash failed :%s", new Object[] { str2 });
          localObject2 = "";
        }
        else
        {
          ((t)localObject3).hpA.execSQL("VideoHash", "delete from VideoHash where CreateTime < " + (bs.aNx() - 432000L));
          n = localObject2[32];
          StringBuffer localStringBuffer = new StringBuffer();
          i = 0;
          while (i < 32)
          {
            localStringBuffer.append(Integer.toHexString(localObject2[i]));
            i += 1;
          }
          i1 = localStringBuffer.length();
          localObject5 = new Vector();
          localObject4 = new Vector();
          Vector localVector1 = new Vector();
          localVector2 = new Vector();
          i = -1;
          Cursor localCursor = ((t)localObject3).hpA.a("select size, CreateTime, hash, cdnxml, orgpath from VideoHash where size = ".concat(String.valueOf(n)), null, 0);
          while (localCursor.moveToNext())
          {
            l2 = localCursor.getLong(1);
            String str3 = localCursor.getString(2);
            String str4 = localCursor.getString(3);
            String str5 = localCursor.getString(4);
            ac.v("MicroMsg.VideoInfoStorage", "checkVideoHash select [%s][%s]", new Object[] { str3, str4 });
            if ((bs.isNullOrNil(str3)) || (bs.isNullOrNil(str4)))
            {
              com.tencent.mm.plugin.report.service.h.wUl.f(12696, new Object[] { Integer.valueOf(104), Integer.valueOf(n) });
              ac.w("MicroMsg.VideoInfoStorage", "checkVideoHash select error [%s][%s]", new Object[] { str3, str4 });
            }
            else
            {
              if (i1 == str3.length()) {
                break label2964;
              }
              com.tencent.mm.plugin.report.service.h.wUl.f(12696, new Object[] { Integer.valueOf(105), Integer.valueOf(n) });
              ac.w("MicroMsg.VideoInfoStorage", "checkVideoHash err length file:%d cursor:%d", new Object[] { Integer.valueOf(i1), Integer.valueOf(str3.length()) });
              continue;
              if (k < i1)
              {
                if (localStringBuffer.charAt(k) != str3.charAt(k)) {
                  break label2946;
                }
                j += 1;
                break label2971;
              }
              if ((i >= 0) && (localVector1.size() > i) && (((Integer)localVector1.get(i)).intValue() >= j)) {
                break label2943;
              }
              i = localVector1.size();
              localVector1.add(Integer.valueOf(j));
              ((Vector)localObject5).add(str4);
              ((Vector)localObject4).add(str5);
              localVector2.add(Long.valueOf(l2));
              ac.d("MicroMsg.VideoInfoStorage", "checkVideoHash cursor hitCount:%d/%d ,max:%d vector:%d/%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i1), localVector1.get(i), Integer.valueOf(i), Integer.valueOf(localVector1.size()) });
            }
          }
          localCursor.close();
          if ((i < 0) || (localVector1.size() <= 0))
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(12696, new Object[] { Integer.valueOf(201), Integer.valueOf(n) });
            ac.w("MicroMsg.VideoInfoStorage", "checkVideoHash cursor empty maxHitIndex:%d vector:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localVector1.size()) });
            localObject2 = "";
          }
          else
          {
            i1 = ((Integer)localVector1.get(i)).intValue();
            i2 = i1 * 100 / 256;
            if (i2 < 77)
            {
              com.tencent.mm.plugin.report.service.h.wUl.f(12696, new Object[] { Integer.valueOf(202), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(0), Integer.valueOf(localVector2.size()) });
              ac.w("MicroMsg.VideoInfoStorage", "checkVideoHash NotEnoughHit. time:%d hit:%d percentMatch:%s arr:%d path:%s", new Object[] { Long.valueOf(bs.Ap(l1)), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(localObject2.length - 1), str2 });
              localObject2 = "";
            }
            else
            {
              localObject2 = bs.nullAsNil((String)((Vector)localObject5).get(i));
              j = 0;
              k = 0;
              label2308:
              if (k < localVector1.size())
              {
                if ((k == i) || (((Integer)localVector1.get(k)).intValue() < i1) || (((String)localObject2).hashCode() == ((String)((Vector)localObject5).get(k)).hashCode())) {
                  break label2940;
                }
                j += 1;
                break label2978;
              }
              if (j <= 0) {
                break label2515;
              }
              ((t)localObject3).hpA.execSQL("VideoHash", "delete from VideoHash where size = ".concat(String.valueOf(n)));
              com.tencent.mm.plugin.report.service.h.wUl.f(12696, new Object[] { Integer.valueOf(203), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(0), Integer.valueOf(localVector2.size()), Integer.valueOf(0), "", "", "", Integer.valueOf(j) });
              ac.e("MicroMsg.VideoInfoStorage", "checkVideoHash Not ONE hash hit this path, give up duplicate:%s path:%s", new Object[] { Integer.valueOf(j), str2 });
              localObject2 = "";
            }
          }
        }
      }
      label2515:
      l1 = bs.Ap(l1);
      long l2 = bs.a((Long)localVector2.get(i), 0L);
      localObject5 = String.format("%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(n), Integer.valueOf(i1), Long.valueOf(l2), Integer.valueOf(localVector2.size()), Long.valueOf(l1) });
      com.tencent.mm.plugin.report.service.h.wUl.f(12696, new Object[] { Integer.valueOf(300), localObject5 });
      com.tencent.mm.plugin.report.service.h.wUl.f(12696, new Object[] { Integer.valueOf(i2 + 3000), localObject5 });
      ac.i("MicroMsg.VideoInfoStorage", "checkVideoHash Succ time:%s hit:%s match:%s%% savetime:%s path:%s xml:%s orgpath:%s", new Object[] { Long.valueOf(l1), Integer.valueOf(i1), Integer.valueOf(i2), Long.valueOf(l2), str2, localObject2, ((Vector)localObject4).get(i) });
      localObject4 = (String)((Vector)localObject4).get(i);
      l1 = bs.eWj() % 1000L;
      if (l1 < m * 10) {
        break label2985;
      }
      if (i2 < 90) {
        break label2985;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff should:%s now:%s ratio:%s percentMatch:%s debuger:%s", new Object[] { Boolean.valueOf(bool4), Long.valueOf(l1), Integer.valueOf(m), Integer.valueOf(i2), Boolean.valueOf(com.tencent.mm.sdk.a.b.eUk()) });
      if ((bool4) || (com.tencent.mm.sdk.a.b.eUk())) {
        com.tencent.mm.sdk.g.b.d(new t.2((t)localObject3, str2, (String)localObject4, (String)localObject5), "checkVideoHashByteDiff");
      }
      break label1275;
      boolean bool4 = false;
      continue;
      label2852:
      localObject2 = null;
      break label1293;
      if (this.hZp)
      {
        i = 2;
        break;
      }
      i = 0;
      break;
      label2875:
      if (this.hYO.iaN != 1)
      {
        this.hYO.iaN = 1;
        this.hYO.status = 104;
        this.hYO.clientId = this.hIq;
        this.hYO.drx = 524544;
        u.f(this.hYO);
      }
      AppMethodBeat.o(126857);
      return true;
      label2940:
      break label2978;
      label2943:
      break label1957;
      label2946:
      break label2971;
      label2949:
      bool4 = bool1;
      bool1 = bool2;
      bool2 = bool4;
      break label1188;
      label2964:
      j = 0;
      k = 0;
      break label1894;
      label2971:
      k += 1;
      break label1894;
      label2978:
      k += 1;
      break label2308;
      label2985:
      bool4 = true;
    }
  }
  
  private String aJp()
  {
    AppMethodBeat.i(126865);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(126865);
    return str;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(126856);
    ac.i("MicroMsg.NetSceneUploadVideo", "%s stop %s", new Object[] { aJp(), this.hIq });
    if (!bs.isNullOrNil(this.hIq)) {
      com.tencent.mm.an.f.aDD().BQ(this.hIq);
    }
    this.hYR = true;
    super.cancel();
    AppMethodBeat.o(126856);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(126859);
    this.callback = paramg;
    this.hYO = u.Ej(this.fileName);
    if ((this.hYO == null) || ((this.hYO.status != 104) && (this.hYO.status != 103)))
    {
      ac.e("MicroMsg.NetSceneUploadVideo", "%s Get info Failed file:", new Object[] { aJp(), this.fileName });
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(126859);
      return -1;
    }
    paramg = new StringBuilder("doscene file:").append(this.fileName).append(" stat:").append(this.hYO.status).append(" [").append(this.hYO.iaF).append(",").append(this.hYO.iaG).append("] [").append(this.hYO.hZn).append(",").append(this.hYO.hux).append("]  netTimes:").append(this.hYO.iaK).append(" times:");
    int i = this.hZs;
    this.hZs = (i + 1);
    ac.d("MicroMsg.NetSceneUploadVideo", i);
    if (this.startTime == 0L)
    {
      this.startTime = bs.eWj();
      this.hZn = this.hYO.hZn;
    }
    o.aJy();
    if (r.DQ(t.DV(this.fileName)))
    {
      ac.w("MicroMsg.NetSceneUploadVideo", "%s it is mm h265 video xml[%s]", new Object[] { aJp(), this.hYO.aJK() });
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 139L, 1L, false);
    }
    if (aJo())
    {
      ac.d("MicroMsg.NetSceneUploadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { this.fileName });
      AppMethodBeat.o(126859);
      return 0;
    }
    dnq localdnq;
    if (this.hYO.iaM == 1)
    {
      this.cTq = true;
      paramg = new b.a();
      paramg.hvt = new dnq();
      paramg.hvu = new dnr();
      paramg.uri = "/cgi-bin/micromsg-bin/uploadvideo";
      paramg.funcId = 149;
      paramg.reqCmdId = 39;
      paramg.respCmdId = 1000000039;
      this.rr = paramg.aAz();
      localdnq = (dnq)this.rr.hvr.hvw;
      localdnq.tlK = ((String)com.tencent.mm.kernel.g.agR().agA().get(2, ""));
      localdnq.tlJ = this.hYO.getUser();
      localdnq.DRb = this.fileName;
      if (this.cTq) {
        localdnq.Ebf = 2;
      }
      if (this.hYO.iaP == 3) {
        localdnq.Ebf = 3;
      }
      localdnq.FHv = this.hYO.hpy;
      localdnq.FiE = this.hYO.iaG;
      localdnq.FVh = this.hYO.hux;
      if (!com.tencent.mm.network.ae.cS(com.tencent.mm.sdk.platformtools.ai.getContext())) {
        break label1299;
      }
      i = 1;
      label583:
      localdnq.EvT = i;
      localdnq.FiH = 2;
      localdnq.FVi = 0;
      localdnq.FVj = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      localdnq.FiG = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      if (!bs.isNullOrNil(this.dwi)) {
        break label1304;
      }
      o.aJy();
      paramg = com.tencent.mm.vfs.i.aKe(t.DV(this.fileName));
      this.dwi = paramg;
      label667:
      localdnq.FVm = paramg;
      if (bs.isNullOrNil(this.hYO.iaU)) {
        break label1312;
      }
      paramg = bk.yv(this.hYO.iaU);
      label697:
      localObject = paramg;
      if (bs.isNullOrNil(paramg)) {
        localObject = bk.TG();
      }
      ac.i("MicroMsg.NetSceneUploadVideo", "video msg source is %s".concat(String.valueOf(localObject)));
      localdnq.DPY = ((String)localObject);
      localdnq.FVv = this.hYO.dvs;
      paramg = this.hYO.iaR;
      if ((paramg == null) || (bs.isNullOrNil(paramg.hjV))) {
        break label1389;
      }
      localdnq.FVn = bs.bG(paramg.hjV, "");
      localdnq.FVo = paramg.EBs;
      localdnq.FVp = bs.bG(paramg.hjX, "");
      localdnq.FVr = bs.bG(paramg.hjZ, "");
      localdnq.FVq = bs.bG(paramg.hjY, "");
      localdnq.FVs = bs.bG(paramg.hka, "");
    }
    for (;;)
    {
      if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(this.hYO.getUser())) {
        localdnq.EhE = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aND(this.hYO.getUser());
      }
      if (paramg != null)
      {
        localdnq.FVu = bs.bG(paramg.hkb, "");
        localdnq.FVt = bs.bG(paramg.hkc, "");
      }
      ac.d("MicroMsg.NetSceneUploadVideo", "upload video: play length %d, thumb totalLen %d, video totalLen %d, funcFlag %d, videoMd5: %s stream %s streamtime: %d title %s thumburl %s", new Object[] { Integer.valueOf(localdnq.FHv), Integer.valueOf(localdnq.FiF), Integer.valueOf(localdnq.FVh), Integer.valueOf(localdnq.Ebf), localdnq.FVm, localdnq.FVn, Integer.valueOf(localdnq.FVo), localdnq.FVp, localdnq.FVs });
      if (this.hYO.status != 103) {
        break label1682;
      }
      o.aJy();
      paramg = t.r(t.DW(this.fileName), this.hYO.iaF, hZl);
      if ((paramg.ret >= 0) && (paramg.cWy != 0)) {
        break label1434;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 225L, 1L, false);
      u.Ea(this.fileName);
      ac.e("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "]  Error ");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(126859);
      return -1;
      if (this.hYO.createTime + 600L < bs.aNx())
      {
        ac.e("MicroMsg.NetSceneUploadVideo", "create time check error:" + this.fileName);
        u.Ea(this.fileName);
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        AppMethodBeat.o(126859);
        return -1;
      }
      if (u.DZ(this.fileName)) {
        break;
      }
      ac.e("MicroMsg.NetSceneUploadVideo", "checkVoiceNetTimes Failed file:" + this.fileName);
      u.Ea(this.fileName);
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(126859);
      return -1;
      label1299:
      i = 2;
      break label583;
      label1304:
      paramg = this.dwi;
      break label667;
      label1312:
      if (this.hYO.iaT > 0)
      {
        paramg = bk.yv(bk.yu(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(this.hYO.iaT).eul));
        break label697;
      }
      paramg = com.tencent.mm.vfs.i.aKe(this.hYO.aJJ());
      localObject = v.iuG;
      paramg = bk.yv(v.FG(paramg));
      break label697;
      label1389:
      if ((paramg != null) && (!bs.isNullOrNil(paramg.hjZ)) && (!bs.isNullOrNil(paramg.hjY)))
      {
        localdnq.FVr = paramg.hjZ;
        localdnq.FVq = paramg.hjY;
      }
    }
    label1434:
    ac.d("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "] read ret:" + paramg.ret + " readlen:" + paramg.cWy + " newOff:" + paramg.ibm + " netOff:" + this.hYO.iaF);
    if (paramg.ibm < this.hYO.iaF)
    {
      ac.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ THUMB[" + this.fileName + "] newOff:" + paramg.ibm + " OldtOff:" + this.hYO.iaF);
      u.Ea(this.fileName);
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(126859);
      return -1;
    }
    Object localObject = new byte[paramg.cWy];
    System.arraycopy(paramg.buf, 0, localObject, 0, paramg.cWy);
    localdnq.FiF = this.hYO.iaF;
    localdnq.FiG = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
    for (;;)
    {
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(126859);
      return i;
      label1682:
      o.aJy();
      paramg = t.r(t.DV(this.fileName), this.hYO.hZn, hZl);
      if ((paramg.ret < 0) || (paramg.cWy == 0))
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 224L, 1L, false);
        u.Ea(this.fileName);
        ac.e("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "]  Error ");
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        AppMethodBeat.o(126859);
        return -1;
      }
      ac.d("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "] read ret:" + paramg.ret + " readlen:" + paramg.cWy + " newOff:" + paramg.ibm + " netOff:" + this.hYO.hZn);
      if (paramg.ibm < this.hYO.hZn)
      {
        ac.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] newOff:" + paramg.ibm + " OldtOff:" + this.hYO.hZn);
        u.Ea(this.fileName);
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        AppMethodBeat.o(126859);
        return -1;
      }
      if (paramg.ibm >= c.hYk)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 222L, 1L, false);
        ac.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] maxsize:" + c.hYk);
        u.Ea(this.fileName);
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        AppMethodBeat.o(126859);
        return -1;
      }
      localObject = new byte[paramg.cWy];
      System.arraycopy(paramg.buf, 0, localObject, 0, paramg.cWy);
      localdnq.FVi = this.hYO.hZn;
      localdnq.FiF = this.hYO.iaF;
      localdnq.FVj = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
    }
  }
  
  public final long getReturnTimeout()
  {
    return 1800000L;
  }
  
  public final int getType()
  {
    return 149;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126863);
    ac.i("MicroMsg.NetSceneUploadVideo", "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.hIq);
    if (this.hYR)
    {
      ac.d("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Call Stop by Service   file:" + this.fileName + " user:" + this.hYO.getUser());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    paramArrayOfByte = (dnr)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    paramq = (dnq)((com.tencent.mm.ak.b)paramq).hvr.hvw;
    if ((paramArrayOfByte != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(paramArrayOfByte.EhF);
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bs.isNullOrNil(this.hIq)))
    {
      ac.w("MicroMsg.NetSceneUploadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.hIq });
      AppMethodBeat.o(126863);
      return;
    }
    this.hYO = u.Ej(this.fileName);
    if (this.hYO == null)
    {
      ac.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if (this.hYO.status == 105)
    {
      ac.w("MicroMsg.NetSceneUploadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.hYO.dpl + "," + this.hYO.aJH() + "," + this.hYO.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((this.hYO.status != 104) && (this.hYO.status != 103))
    {
      ac.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.hYO.status + " [" + this.fileName + "," + this.hYO.dpl + "," + this.hYO.aJH() + "," + this.hYO.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      ac.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd BLACK  errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.hYO.getUser());
      u.Eb(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 220L, 1L, false);
      ac.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.hYO.getUser());
      u.Ea(this.fileName);
      com.tencent.mm.plugin.report.service.h.wUl.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(com.tencent.mm.sdk.platformtools.ai.getContext())), Integer.valueOf(this.hYQ), Integer.valueOf(0) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 219L, 1L, false);
      ac.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.hYO.getUser());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((!bs.cv(paramq.FiG.getBuffer().xy)) && (paramq.FiF != paramArrayOfByte.FiF - paramq.FiG.getILen()))
    {
      ac.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + paramq.FiF + "," + paramq.FiG.getILen() + "," + paramArrayOfByte.FiF + "] file:" + this.fileName + " user:" + paramq.tlJ);
      u.Ea(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((!bs.cv(paramq.FVj.getBuffer().xy)) && (paramq.FVi != paramArrayOfByte.FVi - paramq.FVj.getILen()))
    {
      ac.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + paramq.FVi + "," + paramq.FVj.getILen() + "," + paramArrayOfByte.FVi + "] file:" + this.fileName + " user:" + paramq.tlJ);
      u.Ea(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    this.hYO.iaH = bs.aNx();
    this.hYO.dpl = paramArrayOfByte.vTQ;
    this.hYO.drx = 1028;
    ac.d("MicroMsg.NetSceneUploadVideo", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(this.hYO.dpl), Integer.valueOf(ab.ivH) });
    if ((10007 == ab.ivG) && (ab.ivH != 0) && (this.hYO.dpl != 0L))
    {
      this.hYO.dpl = ab.ivH;
      ab.ivH = 0;
    }
    paramInt1 = this.hYO.status;
    s locals;
    if (paramInt1 == 103)
    {
      locals = this.hYO;
      paramInt1 = paramq.FiF;
      locals.iaF = (paramq.FiG.getILen() + paramInt1);
      this.hYO.drx |= 0x40;
      if (this.hYO.iaF < this.hYO.iaG) {
        break label2369;
      }
      this.hYO.status = 104;
      this.hYO.drx |= 0x100;
      paramInt1 = 0;
    }
    for (;;)
    {
      u.f(this.hYO);
      if (this.hYR)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(126863);
        return;
        if (paramInt1 == 104)
        {
          locals = this.hYO;
          paramInt1 = paramq.FVi;
          locals.hZn = (paramq.FVj.getILen() + paramInt1);
          this.hYO.drx |= 0x8;
          if (this.hYO.hZn >= this.hYO.hux)
          {
            this.hYO.status = 199;
            this.hYO.drx |= 0x100;
            u.d(this.hYO);
            paramInt1 = 1;
          }
        }
        else
        {
          ac.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd ERROR STATUS:" + paramInt1 + " file:" + this.fileName + " user:" + paramq.tlJ);
          u.Ea(this.fileName);
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(126863);
        }
      }
      else
      {
        if (paramInt1 == 0)
        {
          this.htR.au(10L, 10L);
          AppMethodBeat.o(126863);
          return;
        }
        paramq = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(this.hYO.iaJ);
        paramq.qf(paramArrayOfByte.DPY);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(paramq.field_msgId, paramq);
        com.tencent.mm.modelstat.b.hUE.q(paramq);
        com.tencent.mm.plugin.report.service.h.wUl.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(com.tencent.mm.sdk.platformtools.ai.getContext())), Integer.valueOf(this.hYQ), Integer.valueOf(this.hYO.hux - this.hZn) });
        boolean bool;
        if (this.hYO == null)
        {
          bool = false;
          if ((!bool) && (!w.wT(this.hYO.getUser()))) {
            break label2275;
          }
          ac.i("MicroMsg.NetSceneUploadVideo", "upload to biz :%s", new Object[] { this.hYO.getUser() });
          if (this.hYO.dpl < 0L)
          {
            ac.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.hYO.dpl + " file:" + this.fileName + " toUser:" + this.hYO.getUser());
            u.Ea(this.fileName);
          }
          label2008:
          if (this.gma == null) {
            break label2363;
          }
        }
        label2363:
        for (long l = this.gma.YH();; l = 0L)
        {
          ac.d("MicroMsg.NetSceneUploadVideo", "!!!FIN: file:" + this.fileName + " toUser:" + this.hYO.getUser() + " msgsvrid:" + this.hYO.dpl + " thumbsize:" + this.hYO.iaG + " videosize:" + this.hYO.hux + " useTime:" + l);
          ac.d("MicroMsg.NetSceneUploadVideo", "FinishLogForTime file:" + this.fileName + " packSize:" + hZl + " filesize:" + this.hYO.hux + " useTime:" + l);
          a.a(this.hYO, 0);
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(126863);
          return;
          paramq = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.hYO.getUser());
          if ((paramq == null) || ((int)paramq.fLJ <= 0))
          {
            bool = false;
            break;
          }
          bool = paramq.fad();
          break;
          label2275:
          ac.i("MicroMsg.NetSceneUploadVideo", "not upload to biz");
          if (this.hYO.dpl > 0L) {
            break label2008;
          }
          ac.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.hYO.dpl + " file:" + this.fileName + " toUser:" + this.hYO.getUser());
          u.Ea(this.fileName);
          break label2008;
        }
      }
      label2369:
      paramInt1 = 0;
    }
  }
  
  public final int securityLimitCount()
  {
    return this.MAX_TIMES;
  }
  
  public final boolean securityLimitCountReach()
  {
    AppMethodBeat.i(126862);
    boolean bool = super.securityLimitCountReach();
    if (bool) {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 210L, 1L, false);
    }
    AppMethodBeat.o(126862);
    return bool;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    AppMethodBeat.i(126860);
    paramq = (dnq)((com.tencent.mm.ak.b)paramq).hvr.hvw;
    if ((bs.isNullOrNil(paramq.DRb)) || (paramq.FiH <= 0) || (bs.isNullOrNil(paramq.tlK)) || (bs.isNullOrNil(paramq.tlJ)) || (paramq.EvT <= 0) || (paramq.FiF > paramq.FiE) || (paramq.FiF < 0) || (paramq.FVi > paramq.FVh) || (paramq.FVi < 0) || ((paramq.FVi == paramq.FVh) && (paramq.FiF == paramq.FiE)) || (paramq.FiE <= 0) || (paramq.FVh <= 0) || ((paramq.FVj.getILen() <= 0) && (paramq.FiG.getILen() <= 0)))
    {
      ac.e("MicroMsg.NetSceneUploadVideo", "ERR: Security Check Failed file:" + this.fileName + " user:" + paramq.tlJ);
      paramq = n.b.hwb;
      AppMethodBeat.o(126860);
      return paramq;
    }
    paramq = n.b.hwa;
    AppMethodBeat.o(126860);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(126861);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 221L, 1L, false);
    u.Ea(this.fileName);
    AppMethodBeat.o(126861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.g
 * JD-Core Version:    0.7.0.1
 */