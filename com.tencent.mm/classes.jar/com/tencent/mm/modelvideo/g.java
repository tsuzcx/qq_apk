package com.tencent.mm.modelvideo;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.x;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.f.d.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.protocal.protobuf.due;
import com.tencent.mm.protocal.protobuf.duf;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.Vector;
import junit.framework.Assert;

public final class g
  extends com.tencent.mm.ak.n
  implements k
{
  private static int ivB = 32000;
  private final int MAX_TIMES;
  private com.tencent.mm.ak.f callback;
  private String dJw;
  boolean dfI;
  public String fileName;
  f.a gIr;
  int gwU;
  aw hPc;
  private String idX;
  private d.a ieB;
  private com.tencent.mm.i.g.a ieg;
  private boolean ieo;
  private final long ivC;
  private int ivD;
  private boolean ivE;
  private boolean ivF;
  private int ivG;
  private int ivH;
  public s ive;
  private int ivg;
  private boolean ivh;
  int retCode;
  private com.tencent.mm.ak.b rr;
  private long startTime;
  
  public g(String paramString)
  {
    AppMethodBeat.i(126858);
    this.dJw = "";
    this.ivC = 1800000L;
    this.retCode = 0;
    this.ivh = false;
    this.dfI = false;
    this.gIr = null;
    this.ieo = true;
    this.idX = "";
    this.startTime = 0L;
    this.ivD = -1;
    this.ivg = com.tencent.mm.i.a.MediaType_VIDEO;
    this.ivE = false;
    this.ivF = false;
    this.ivG = 0;
    this.ivH = 0;
    this.ieB = new d.a()
    {
      public final void J(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(217463);
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(g.a(g.this)), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(g.b(g.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "onUploadFailure, uploadId:%s", new Object[] { paramAnonymousString });
        u.HR(g.c(g.this));
        g.j(g.this).onSceneEnd(3, paramAnonymousInt, "", g.this);
        AppMethodBeat.o(217463);
      }
      
      public final void a(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(217464);
        s locals = u.Ia(g.c(g.this));
        if (locals == null)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "%s info is null", new Object[] { g.e(g.this) });
          AppMethodBeat.o(217464);
          return;
        }
        if (locals.ivD > paramAnonymousLong)
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnEndProc error oldpos:%d newpos:%d", new Object[] { g.e(g.this), Integer.valueOf(locals.ivD), Long.valueOf(paramAnonymousLong) });
          AppMethodBeat.o(217464);
          return;
        }
        locals.iwX = bu.aRi();
        locals.ivD = ((int)paramAnonymousLong);
        locals.dEu = 1032;
        u.f(locals);
        AppMethodBeat.o(217464);
      }
      
      public final void a(final com.tencent.mm.pluginsdk.f.g.a paramAnonymousa)
      {
        AppMethodBeat.i(217462);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.gmb, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.iTe) });
        long l1 = bu.fpO();
        long l2 = g.a(g.this);
        long l3 = paramAnonymousa.iTe;
        com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(g.a(g.this)), Long.valueOf(l1), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(g.b(g.this)), Long.valueOf(l3), Long.valueOf(l3 / (l1 - l2)), Integer.valueOf(1) });
        com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
        locald.field_aesKey = paramAnonymousa.gmb;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.nZM;
        locald.field_fileLength = paramAnonymousa.iTe;
        o.aNh();
        paramAnonymousa = t.HJ(g.c(g.this));
        o.aNh();
        Object localObject = t.HK(g.c(g.this));
        locald.field_thumbimgLength = ((int)com.tencent.mm.vfs.o.aZR(g.a(g.this, (String)localObject)));
        com.tencent.mm.an.f.aHa();
        locald.field_filecrc = com.tencent.mm.an.a.Fm(paramAnonymousa);
        locald.field_toUser = g.d(g.this).getUser();
        paramAnonymousa = u.Ia(g.c(g.this));
        if (bu.isNullOrNil(paramAnonymousa.aNt()))
        {
          localObject = "<msg><videomsg aeskey=\"" + locald.field_aesKey + "\" cdnthumbaeskey=\"" + locald.field_aesKey + "\" cdnvideourl=\"" + locald.field_fileId + "\" ";
          localObject = (String)localObject + "cdnthumburl=\"" + locald.field_fileId + "\" ";
          localObject = (String)localObject + "length=\"" + locald.field_fileLength + "\" ";
          localObject = (String)localObject + "cdnthumblength=\"" + locald.field_thumbimgLength + "\"/></msg>";
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "%s cdn callback new build cdnInfo:%s", new Object[] { g.e(g.this), localObject });
          paramAnonymousa.ixe = ((String)localObject);
          u.f(paramAnonymousa);
        }
        localObject = bx.M(paramAnonymousa.aNt(), "msg");
        if (localObject != null)
        {
          t localt = o.aNh();
          o.aNh();
          localt.q(t.HJ(g.c(g.this)), (String)((Map)localObject).get(".msg.videomsg.$cdnvideourl"), (String)((Map)localObject).get(".msg.videomsg.$aeskey"));
        }
        com.tencent.mm.kernel.g.ajj().a(new h(g.c(g.this), g.f(g.this), locald, new com.tencent.mm.av.f()
        {
          public final void dg(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(126853);
            if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == 102))
            {
              com.tencent.mm.kernel.g.ajU().aw(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(126852);
                  g.g(g.this);
                  g.1.1.this.ivJ.status = 104;
                  g.1.1.this.ivJ.createTime = bu.aRi();
                  g.1.1.this.ivJ.iwX = bu.aRi();
                  g.1.1.this.ivJ.ivD = 0;
                  g.1.1.this.ivJ.dEu = 1800;
                  boolean bool = u.f(g.1.1.this.ivJ);
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { g.e(g.this), Boolean.valueOf(g.h(g.this)), Boolean.valueOf(bool), Long.valueOf(g.1.1.this.ivJ.createTime) });
                  g.this.doScene(g.i(g.this), g.j(g.this));
                  AppMethodBeat.o(126852);
                }
              });
              AppMethodBeat.o(126853);
              return;
            }
            g.j(g.this).onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", g.this);
            AppMethodBeat.o(126853);
          }
        }), 0);
        AppMethodBeat.o(217462);
      }
    };
    this.ieg = new com.tencent.mm.i.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(217467);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { g.e(g.this), g.k(g.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneUploadVideo", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { g.k(g.this) });
          AppMethodBeat.o(217467);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          u.HR(g.c(g.this));
          new j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(g.a(g.this)), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(g.b(g.this)), Integer.valueOf(0), "" })).aLH();
          g.j(g.this).onSceneEnd(3, paramAnonymousInt, "", g.this);
          AppMethodBeat.o(217467);
          return 0;
        }
        g.a(g.this, u.Ia(g.c(g.this)));
        if ((g.d(g.this) == null) || (g.d(g.this).status == 105))
        {
          if (g.d(g.this) == null) {}
          for (int i = -1;; i = g.d(g.this).status)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "%s info is null or has paused, status:%d", new Object[] { g.e(g.this), Integer.valueOf(i) });
            com.tencent.mm.an.f.aGZ().Fr(g.k(g.this));
            g.j(g.this).onSceneEnd(3, paramAnonymousInt, "info is null or has paused, status".concat(String.valueOf(i)), g.this);
            AppMethodBeat.o(217467);
            return 0;
          }
        }
        if (paramAnonymousc != null)
        {
          if (g.d(g.this).ivD > paramAnonymousc.field_finishedLength)
          {
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnEndProc error oldpos:%d newpos:%d", new Object[] { g.e(g.this), Integer.valueOf(g.d(g.this).ivD), Long.valueOf(paramAnonymousc.field_finishedLength) });
            AppMethodBeat.o(217467);
            return 0;
          }
          g.d(g.this).iwX = bu.aRi();
          g.d(g.this).ivD = ((int)paramAnonymousc.field_finishedLength);
          g.d(g.this).dEu = 1032;
          u.f(g.d(g.this));
          AppMethodBeat.o(217467);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode != 0)
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "%s cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { g.e(g.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo });
            u.HR(g.c(g.this));
            paramAnonymousString = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(1), Long.valueOf(g.a(g.this)), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(g.b(g.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fKX });
            new j(paramAnonymousString).aLH();
            new com.tencent.mm.g.b.a.h(paramAnonymousString).aLH();
            g.j(g.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", g.this);
          }
        }
        else
        {
          AppMethodBeat.o(217467);
          return 0;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn uploadvideo by cdn, videohash isHitCacheUpload: %d, enableHitcheck:%b", new Object[] { g.e(g.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(g.h(g.this)) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.g.yxI;
        if (g.l(g.this))
        {
          paramAnonymousInt = 810;
          label844:
          paramAnonymousString.f(12696, new Object[] { Integer.valueOf(paramAnonymousInt + paramAnonymousd.field_UploadHitCacheType), Integer.valueOf(g.d(g.this).hPI) });
          paramAnonymousBoolean = paramAnonymousd.field_isVideoReduced;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "%s it video was reduced by cdn %b %s", new Object[] { g.e(g.this), Boolean.valueOf(paramAnonymousBoolean), g.c(g.this) });
          if (paramAnonymousBoolean) {
            break label1618;
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(106L, 205L, 1L, false);
          if ((g.n(g.this) > 0) && (paramAnonymousd.field_thumbimgLength > 0))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "%s send video thumb too big thumb length [%d, %d] ", new Object[] { g.e(g.this), Integer.valueOf(g.n(g.this)), Integer.valueOf(paramAnonymousd.field_thumbimgLength) });
            if (g.n(g.this) * 2 <= paramAnonymousd.field_thumbimgLength) {
              break label1584;
            }
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(106L, 206L, 1L, false);
          }
          label1044:
          o.aNh();
          paramAnonymousInt = (int)com.tencent.mm.vfs.o.aZR(t.HJ(g.c(g.this)));
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "%s send video too big thumb length [%d, %d] ", new Object[] { g.e(g.this), Integer.valueOf(g.d(g.this).hPI), Integer.valueOf(paramAnonymousInt) });
          if (g.d(g.this).hPI == paramAnonymousInt) {
            break label1601;
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(106L, 208L, 1L, false);
          label1136:
          g.a(g.this, u.Ia(g.c(g.this)));
          if (bu.isNullOrNil(g.d(g.this).aNt()))
          {
            paramAnonymousString = "<msg><videomsg aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnvideourl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "length=\"" + paramAnonymousd.field_fileLength + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\"/></msg>";
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "%s cdn callback new build cdnInfo:%s", new Object[] { g.e(g.this), paramAnonymousString });
            g.d(g.this).ixe = paramAnonymousString;
            u.f(g.d(g.this));
          }
          paramAnonymousString = bx.M(g.d(g.this).aNt(), "msg");
          if (paramAnonymousString != null)
          {
            paramAnonymousc = o.aNh();
            o.aNh();
            boolean bool = paramAnonymousc.q(t.HJ(g.c(g.this)), (String)paramAnonymousString.get(".msg.videomsg.$cdnvideourl"), (String)paramAnonymousString.get(".msg.videomsg.$aeskey"));
            paramAnonymousString = com.tencent.mm.plugin.report.service.g.yxI;
            if (!bool) {
              break label1635;
            }
            paramAnonymousInt = 1;
            label1459:
            paramAnonymousString.f(12696, new Object[] { Integer.valueOf(paramAnonymousInt + 900), Integer.valueOf(g.d(g.this).hPI) });
          }
          paramAnonymousString = com.tencent.mm.av.s.aJe();
          paramAnonymousString.fileName = g.c(g.this);
          if (!paramAnonymousBoolean) {
            break label1640;
          }
        }
        label1584:
        label1601:
        label1618:
        label1635:
        label1640:
        for (paramAnonymousInt = 0;; paramAnonymousInt = g.f(g.this))
        {
          paramAnonymousString.ifG = paramAnonymousInt;
          paramAnonymousString.ifH = paramAnonymousd;
          paramAnonymousString.ifI = new com.tencent.mm.av.f()
          {
            public final void dg(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(217466);
              if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == 102))
              {
                com.tencent.mm.kernel.g.ajU().aw(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(217465);
                    g.g(g.this);
                    g.d(g.this).status = 104;
                    g.d(g.this).createTime = bu.aRi();
                    g.d(g.this).iwX = bu.aRi();
                    g.d(g.this).ivD = 0;
                    g.d(g.this).dEu = 1800;
                    boolean bool = u.f(g.d(g.this));
                    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { g.e(g.this), Boolean.valueOf(g.h(g.this)), Boolean.valueOf(bool), Long.valueOf(g.d(g.this).createTime) });
                    g.this.doScene(g.o(g.this), g.j(g.this));
                    AppMethodBeat.o(217465);
                  }
                });
                AppMethodBeat.o(217466);
                return;
              }
              new j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(1), Long.valueOf(g.a(g.this)), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(g.b(g.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fKX })).aLH();
              a.a(g.d(g.this), 0);
              g.a(g.this, paramAnonymousd);
              g.j(g.this).onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", g.this);
              AppMethodBeat.o(217466);
            }
          };
          paramAnonymousString.iiV = 4;
          paramAnonymousString.aJO().execute();
          break;
          if (g.m(g.this))
          {
            paramAnonymousInt = 820;
            break label844;
          }
          paramAnonymousInt = 830;
          break label844;
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(106L, 207L, 1L, false);
          break label1044;
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(106L, 209L, 1L, false);
          break label1136;
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(106L, 200L, 1L, false);
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
    this.gwU = 0;
    this.hPc = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(217468);
        if (g.this.doScene(g.p(g.this), g.j(g.this)) == -1)
        {
          g.a(g.this, 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          g.j(g.this).onSceneEnd(3, -1, "doScene failed", g.this);
        }
        AppMethodBeat.o(217468);
        return false;
      }
    }, true);
    boolean bool;
    if (paramString != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneUploadVideo", "NetSceneUploadVideo:  file:".concat(String.valueOf(paramString)));
      this.fileName = paramString;
      this.ive = u.Ia(paramString);
      if (this.ive == null) {
        break label265;
      }
    }
    label265:
    for (this.MAX_TIMES = 2500;; this.MAX_TIMES = 0)
    {
      this.gIr = new f.a();
      if ((this.ive != null) && (3 == this.ive.ixf)) {
        this.ivg = com.tencent.mm.i.a.MediaType_TinyVideo;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "%s NetSceneUploadVideo:  videoType:[%d]", new Object[] { aMX(), Integer.valueOf(this.ivg) });
      AppMethodBeat.o(126858);
      return;
      bool = false;
      break;
    }
  }
  
  /* Error */
  private String Hs(String paramString)
  {
    // Byte code:
    //   0: ldc 203
    //   2: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 205	com/tencent/mm/vfs/k
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 207	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   13: astore 9
    //   15: new 205	com/tencent/mm/vfs/k
    //   18: dup
    //   19: aload 9
    //   21: invokevirtual 211	com/tencent/mm/vfs/k:fTg	()Lcom/tencent/mm/vfs/k;
    //   24: new 213	java/lang/StringBuilder
    //   27: dup
    //   28: ldc 215
    //   30: invokespecial 216	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload 9
    //   35: invokevirtual 219	com/tencent/mm/vfs/k:getName	()Ljava/lang/String;
    //   38: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 229	com/tencent/mm/vfs/k:<init>	(Lcom/tencent/mm/vfs/k;Ljava/lang/String;)V
    //   47: astore 10
    //   49: aconst_null
    //   50: astore 7
    //   52: aconst_null
    //   53: astore 8
    //   55: aconst_null
    //   56: astore 5
    //   58: aconst_null
    //   59: astore 6
    //   61: ldc 137
    //   63: ldc 231
    //   65: iconst_1
    //   66: anewarray 182	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload 9
    //   73: invokevirtual 235	com/tencent/mm/vfs/k:length	()J
    //   76: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   79: aastore
    //   80: invokestatic 242	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload 9
    //   85: invokevirtual 235	com/tencent/mm/vfs/k:length	()J
    //   88: ldc2_w 243
    //   91: lcmp
    //   92: ifle +580 -> 672
    //   95: aload 10
    //   97: invokevirtual 248	com/tencent/mm/vfs/k:exists	()Z
    //   100: ifeq +120 -> 220
    //   103: ldc 137
    //   105: ldc 250
    //   107: iconst_1
    //   108: anewarray 182	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload 10
    //   115: invokevirtual 254	com/tencent/mm/vfs/k:fTh	()Landroid/net/Uri;
    //   118: invokestatic 260	com/tencent/mm/vfs/w:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   121: aastore
    //   122: invokestatic 242	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   125: iconst_1
    //   126: istore_2
    //   127: aload 8
    //   129: astore 4
    //   131: aload 6
    //   133: astore 5
    //   135: aload 4
    //   137: ifnull +8 -> 145
    //   140: aload 4
    //   142: invokevirtual 265	java/io/InputStream:close	()V
    //   145: iload_2
    //   146: istore_3
    //   147: aload 5
    //   149: ifnull +10 -> 159
    //   152: aload 5
    //   154: invokevirtual 268	java/io/OutputStream:close	()V
    //   157: iload_2
    //   158: istore_3
    //   159: iload_3
    //   160: ifeq +394 -> 554
    //   163: ldc 137
    //   165: ldc_w 270
    //   168: iconst_3
    //   169: anewarray 182	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: aload_0
    //   175: invokespecial 186	com/tencent/mm/modelvideo/g:aMX	()Ljava/lang/String;
    //   178: aastore
    //   179: dup
    //   180: iconst_1
    //   181: aload 10
    //   183: invokevirtual 235	com/tencent/mm/vfs/k:length	()J
    //   186: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   189: aastore
    //   190: dup
    //   191: iconst_2
    //   192: aload 10
    //   194: invokevirtual 254	com/tencent/mm/vfs/k:fTh	()Landroid/net/Uri;
    //   197: invokestatic 260	com/tencent/mm/vfs/w:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   200: aastore
    //   201: invokestatic 194	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: aload 10
    //   206: invokevirtual 254	com/tencent/mm/vfs/k:fTh	()Landroid/net/Uri;
    //   209: invokestatic 260	com/tencent/mm/vfs/w:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   212: astore_1
    //   213: ldc 203
    //   215: invokestatic 197	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: aload_1
    //   219: areturn
    //   220: aload 9
    //   222: invokevirtual 254	com/tencent/mm/vfs/k:fTh	()Landroid/net/Uri;
    //   225: invokestatic 260	com/tencent/mm/vfs/w:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   228: invokestatic 276	com/tencent/mm/sdk/platformtools/h:aRz	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   231: astore 11
    //   233: aload 11
    //   235: ifnonnull +121 -> 356
    //   238: ldc_w 278
    //   241: astore 4
    //   243: ldc 137
    //   245: ldc_w 280
    //   248: iconst_1
    //   249: anewarray 182	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: aload 4
    //   256: aastore
    //   257: invokestatic 194	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: aload 11
    //   262: ifnull +131 -> 393
    //   265: aload 11
    //   267: getfield 285	android/graphics/BitmapFactory$Options:outWidth	I
    //   270: sipush 288
    //   273: if_icmpgt +14 -> 287
    //   276: aload 11
    //   278: getfield 288	android/graphics/BitmapFactory$Options:outHeight	I
    //   281: sipush 288
    //   284: if_icmple +109 -> 393
    //   287: aload 9
    //   289: invokevirtual 254	com/tencent/mm/vfs/k:fTh	()Landroid/net/Uri;
    //   292: invokestatic 260	com/tencent/mm/vfs/w:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   295: sipush 288
    //   298: sipush 288
    //   301: getstatic 294	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   304: bipush 60
    //   306: new 213	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 295	java/lang/StringBuilder:<init>	()V
    //   313: aload 10
    //   315: invokevirtual 211	com/tencent/mm/vfs/k:fTg	()Lcom/tencent/mm/vfs/k;
    //   318: invokevirtual 254	com/tencent/mm/vfs/k:fTh	()Landroid/net/Uri;
    //   321: invokestatic 260	com/tencent/mm/vfs/w:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   324: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: ldc_w 297
    //   330: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: aload 10
    //   338: invokevirtual 219	com/tencent/mm/vfs/k:getName	()Ljava/lang/String;
    //   341: invokestatic 301	com/tencent/mm/sdk/platformtools/h:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;)Z
    //   344: istore_2
    //   345: aload 6
    //   347: astore 5
    //   349: aload 8
    //   351: astore 4
    //   353: goto -218 -> 135
    //   356: new 213	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 295	java/lang/StringBuilder:<init>	()V
    //   363: aload 11
    //   365: getfield 285	android/graphics/BitmapFactory$Options:outWidth	I
    //   368: invokevirtual 304	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   371: ldc_w 306
    //   374: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: aload 11
    //   379: getfield 288	android/graphics/BitmapFactory$Options:outHeight	I
    //   382: invokevirtual 304	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   385: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: astore 4
    //   390: goto -147 -> 243
    //   393: aload 9
    //   395: invokestatic 312	com/tencent/mm/vfs/o:ai	(Lcom/tencent/mm/vfs/k;)Ljava/io/InputStream;
    //   398: astore 4
    //   400: aload 4
    //   402: fconst_0
    //   403: sipush 288
    //   406: sipush 288
    //   409: invokestatic 315	com/tencent/mm/sdk/platformtools/h:a	(Ljava/io/InputStream;FII)Landroid/graphics/Bitmap;
    //   412: astore 8
    //   414: aload 8
    //   416: ifnull +247 -> 663
    //   419: aload 10
    //   421: invokestatic 319	com/tencent/mm/vfs/o:aj	(Lcom/tencent/mm/vfs/k;)Ljava/io/OutputStream;
    //   424: astore 6
    //   426: aload 6
    //   428: astore 5
    //   430: aload 5
    //   432: astore 7
    //   434: aload 4
    //   436: astore 6
    //   438: aload 8
    //   440: getstatic 294	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   443: bipush 60
    //   445: aload 5
    //   447: invokevirtual 325	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
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
    //   470: ldc 137
    //   472: ldc_w 327
    //   475: iconst_1
    //   476: anewarray 182	java/lang/Object
    //   479: dup
    //   480: iconst_0
    //   481: aload 8
    //   483: invokestatic 332	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   486: aastore
    //   487: invokestatic 335	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   490: aload 4
    //   492: ifnull +8 -> 500
    //   495: aload 4
    //   497: invokevirtual 265	java/io/InputStream:close	()V
    //   500: aload 5
    //   502: ifnull +156 -> 658
    //   505: aload 5
    //   507: invokevirtual 268	java/io/OutputStream:close	()V
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
    //   534: invokevirtual 265	java/io/InputStream:close	()V
    //   537: aload 5
    //   539: ifnull +8 -> 547
    //   542: aload 5
    //   544: invokevirtual 268	java/io/OutputStream:close	()V
    //   547: ldc 203
    //   549: invokestatic 197	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   552: aload_1
    //   553: athrow
    //   554: ldc 137
    //   556: ldc_w 337
    //   559: iconst_3
    //   560: anewarray 182	java/lang/Object
    //   563: dup
    //   564: iconst_0
    //   565: aload_0
    //   566: invokespecial 186	com/tencent/mm/modelvideo/g:aMX	()Ljava/lang/String;
    //   569: aastore
    //   570: dup
    //   571: iconst_1
    //   572: aload 9
    //   574: invokevirtual 235	com/tencent/mm/vfs/k:length	()J
    //   577: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   580: aastore
    //   581: dup
    //   582: iconst_2
    //   583: aload 9
    //   585: invokevirtual 254	com/tencent/mm/vfs/k:fTh	()Landroid/net/Uri;
    //   588: invokestatic 260	com/tencent/mm/vfs/w:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   591: aastore
    //   592: invokestatic 194	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   595: ldc 203
    //   597: invokestatic 197	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   13	571	9	localk1	com.tencent.mm.vfs.k
    //   47	373	10	localk2	com.tencent.mm.vfs.k
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
  
  private boolean aMW()
  {
    AppMethodBeat.i(126857);
    String str2 = this.ive.getUser();
    if (x.Ba(str2))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn user:%s", new Object[] { aMX(), str2 });
      AppMethodBeat.o(126857);
      return false;
    }
    if (!com.tencent.mm.pluginsdk.f.b.fcW())
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "isAllow2UseCdnWithXLab = false");
      AppMethodBeat.o(126857);
      return false;
    }
    com.tencent.mm.an.f.aGZ();
    if ((!com.tencent.mm.an.b.pd(2)) && (this.ive.ixd != 1))
    {
      localObject1 = aMX();
      com.tencent.mm.an.f.aGZ();
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { localObject1, Boolean.valueOf(com.tencent.mm.an.b.pd(2)), Integer.valueOf(this.ive.ixd) });
      AppMethodBeat.o(126857);
      return false;
    }
    this.idX = com.tencent.mm.an.c.a("upvideo", this.ive.createTime, str2, this.ive.getFileName());
    if (bu.isNullOrNil(this.idX))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NetSceneUploadVideo", "%s cdntra genClientId failed not use cdn file:%s", new Object[] { aMX(), this.ive.getFileName() });
      AppMethodBeat.o(126857);
      return false;
    }
    o.aNh();
    Object localObject1 = t.HK(this.fileName);
    o.aNh();
    String str1 = t.HJ(this.fileName);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fLl = "task_NetSceneUploadVideo_1";
    localg.fLm = this.ieg;
    localg.field_mediaId = this.idX;
    localg.field_fullpath = str1;
    localg.field_thumbpath = Hs((String)localObject1);
    localg.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
    boolean bool1;
    label359:
    label379:
    Object localObject3;
    label428:
    Object localObject4;
    if (an.aUx(this.ive.getUser()))
    {
      localg.field_sendmsg_viacdn = false;
      if ((an.aUx(this.ive.getUser())) || (!this.ieo)) {
        break label864;
      }
      bool1 = true;
      localg.field_enable_hitcheck = bool1;
      if (!com.tencent.mm.modelcontrol.d.aHh().Fx(str1)) {
        break label870;
      }
      i = 1;
      localg.field_largesvideo = i;
      if ((this.ive != null) && (3 == this.ive.ixf)) {
        localg.field_smallVideoFlag = 1;
      }
      localObject1 = aMX();
      if (this.ive.ixi != null) {
        break label875;
      }
      bool1 = true;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "%s upload video MMSightExtInfo is null? %b %s", new Object[] { localObject1, Boolean.valueOf(bool1), this.fileName });
      if ((this.ive.ixi != null) && (this.ive.ixi.Hlb))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "%s local capture video, mark use large video", new Object[] { aMX() });
        localObject1 = n.aNf();
        o.aNh();
        ((n)localObject1).a("", t.HJ(this.fileName), this.ive.getUser(), "", "", 2, 2);
        com.tencent.mm.modelcontrol.d.aHh();
        localg.field_largesvideo = com.tencent.mm.modelcontrol.d.b(com.tencent.mm.modelcontrol.d.aHh().aHi());
      }
      localObject3 = aMX();
      localObject4 = this.ive.getFileName();
      if (this.ive.ixh != null) {
        break label881;
      }
      localObject1 = "null";
      label586:
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "%s checkAD file:%s adinfo:%s", new Object[] { localObject3, localObject4, localObject1 });
      if ((this.ive.ixh != null) && (!bu.isNullOrNil(this.ive.ixh.hEZ))) {
        localg.field_advideoflag = 1;
      }
      localg.field_talker = str2;
      if (!x.wb(str2)) {
        break label896;
      }
    }
    long l1;
    label896:
    for (int i = 1;; i = 0)
    {
      localg.field_chattype = i;
      localg.field_priority = com.tencent.mm.i.a.fKA;
      localg.field_needStorage = false;
      localg.field_isStreamMedia = false;
      localg.field_trysafecdn = true;
      this.ivH = ((int)com.tencent.mm.vfs.o.aZR(localg.field_fullpath));
      this.ivG = ((int)com.tencent.mm.vfs.o.aZR(localg.field_thumbpath));
      if (this.ivG < com.tencent.mm.i.a.fKV) {
        break label901;
      }
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NetSceneUploadVideo", "%s cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { aMX(), localg.field_thumbpath, Integer.valueOf(this.ivG) });
      AppMethodBeat.o(126857);
      return false;
      l1 = com.tencent.mm.vfs.o.aZR(str1);
      bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qxQ, false);
      if ((l1 < 25165824L) || (!bool1)) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "send big file:%s  size:%s", new Object[] { str1, Long.valueOf(l1) });
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(106L, 30L, 1L, false);
      localg.field_use_multithread = true;
      break;
      label864:
      bool1 = false;
      break label359;
      label870:
      i = 0;
      break label379;
      label875:
      bool1 = false;
      break label428;
      label881:
      localObject1 = this.ive.ixh.hEZ;
      break label586;
    }
    label901:
    localObject1 = bx.M(this.ive.aNt(), "msg");
    boolean bool2;
    label1337:
    int m;
    label1424:
    label1442:
    label1597:
    label1603:
    label1609:
    label1615:
    label1621:
    label1627:
    label1633:
    Object localObject2;
    Object localObject5;
    label2043:
    int k;
    int j;
    label2106:
    int i2;
    if (localObject1 != null)
    {
      localg.field_fileId = ((String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"));
      localg.field_aesKey = ((String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
      this.ivF = true;
      localObject1 = com.tencent.mm.plugin.report.service.g.yxI;
      if (this.ivE)
      {
        i = 1;
        ((com.tencent.mm.plugin.report.service.g)localObject1).f(12696, new Object[] { Integer.valueOf(i + 700), Integer.valueOf(this.ive.hPI) });
        if ((bu.isNullOrNil(localg.field_aesKey)) || (bu.isNullOrNil(localg.field_aesKey)))
        {
          localg.field_aesKey = "";
          localg.field_fileId = "";
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn check hit cache VideoHash :%s %s %s %b %d", new Object[] { aMX(), localg.field_mediaId, localg.field_fileId, localg.field_aesKey, Boolean.valueOf(this.ieo), Integer.valueOf(localg.field_largesvideo) });
        if (com.tencent.mm.an.f.aGZ().f(localg)) {
          break label3024;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 226L, 1L, false);
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "%s cdntra addSendTask failed.", new Object[] { aMX() });
        this.idX = "";
        AppMethodBeat.o(126857);
        return false;
      }
    }
    else
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "%s cdntra parse video recv xml failed", new Object[] { aMX() });
      int n;
      int i1;
      Vector localVector2;
      for (;;)
      {
        try
        {
          str2 = bu.nullAsNil(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("UseVideoHash"));
          localObject1 = str2.split(",");
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajP();
          i = com.tencent.mm.b.i.cf(com.tencent.mm.kernel.a.getUin(), 100);
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break label1603;
          }
          if (bu.getInt(localObject1[0], 0) < i) {
            break label1597;
          }
          bool1 = true;
          if ((localObject1 == null) || (localObject1.length < 2)) {
            break label1615;
          }
          if (bu.getInt(localObject1[1], 0) < i) {
            break label1609;
          }
          bool2 = true;
          if ((localObject1 == null) || (localObject1.length < 3)) {
            break label1627;
          }
          if (bu.getInt(localObject1[2], 0) < i) {
            break label1621;
          }
          bool3 = true;
          if (!com.tencent.mm.sdk.a.b.fnF()) {
            break label3098;
          }
          bool1 = true;
          bool2 = true;
          bool3 = true;
          if (!bool2) {
            break label3001;
          }
          localObject3 = o.aNh();
          m = bu.getInt(localObject1[2], 0);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoInfoStorage", "checkVideoHash in fullCheckRatio:%s path:%s stack:%s", new Object[] { Integer.valueOf(m), str1, bu.fpN() });
          l1 = bu.fpO();
          if (!bu.isNullOrNil(str1)) {
            break label1633;
          }
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VideoInfoStorage", "checkVideoHash failed , path:%s ", new Object[] { str1 });
          localObject1 = "";
          if (bu.isNullOrNil((String)localObject1)) {
            break label3001;
          }
          localObject1 = ((String)localObject1).split("##");
          if ((bool1) && (localObject1 != null) && (localObject1.length == 2))
          {
            localg.field_fileId = localObject1[0];
            localg.field_aesKey = localObject1[1];
            this.ivE = true;
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "%s CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", new Object[] { aMX(), Boolean.valueOf(com.tencent.mm.sdk.a.b.fnF()), str2, Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(this.ivE), localg.field_fileId, localg.field_aesKey });
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "Check use videohash :%s", new Object[] { bu.o(localException) });
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
        localObject2 = t.HM(str1);
        if ((localObject2 == null) || (localObject2.length < 33))
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VideoInfoStorage", "checkVideoHash  readHash failed :%s", new Object[] { str1 });
          localObject2 = "";
        }
        else
        {
          ((t)localObject3).hKK.execSQL("VideoHash", "delete from VideoHash where CreateTime < " + (bu.aRi() - 432000L));
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
          Cursor localCursor = ((t)localObject3).hKK.a("select size, CreateTime, hash, cdnxml, orgpath from VideoHash where size = ".concat(String.valueOf(n)), null, 0);
          while (localCursor.moveToNext())
          {
            l2 = localCursor.getLong(1);
            String str3 = localCursor.getString(2);
            String str4 = localCursor.getString(3);
            String str5 = localCursor.getString(4);
            com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.VideoInfoStorage", "checkVideoHash select [%s][%s]", new Object[] { str3, str4 });
            if ((bu.isNullOrNil(str3)) || (bu.isNullOrNil(str4)))
            {
              com.tencent.mm.plugin.report.service.g.yxI.f(12696, new Object[] { Integer.valueOf(104), Integer.valueOf(n) });
              com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.VideoInfoStorage", "checkVideoHash select error [%s][%s]", new Object[] { str3, str4 });
            }
            else
            {
              if (i1 == str3.length()) {
                break label3113;
              }
              com.tencent.mm.plugin.report.service.g.yxI.f(12696, new Object[] { Integer.valueOf(105), Integer.valueOf(n) });
              com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.VideoInfoStorage", "checkVideoHash err length file:%d cursor:%d", new Object[] { Integer.valueOf(i1), Integer.valueOf(str3.length()) });
              continue;
              if (k < i1)
              {
                if (localStringBuffer.charAt(k) != str3.charAt(k)) {
                  break label3095;
                }
                j += 1;
                break label3120;
              }
              if ((i >= 0) && (localVector1.size() > i) && (((Integer)localVector1.get(i)).intValue() >= j)) {
                break label3092;
              }
              i = localVector1.size();
              localVector1.add(Integer.valueOf(j));
              ((Vector)localObject5).add(str4);
              ((Vector)localObject4).add(str5);
              localVector2.add(Long.valueOf(l2));
              com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VideoInfoStorage", "checkVideoHash cursor hitCount:%d/%d ,max:%d vector:%d/%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i1), localVector1.get(i), Integer.valueOf(i), Integer.valueOf(localVector1.size()) });
            }
          }
          localCursor.close();
          if ((i < 0) || (localVector1.size() <= 0))
          {
            com.tencent.mm.plugin.report.service.g.yxI.f(12696, new Object[] { Integer.valueOf(201), Integer.valueOf(n) });
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.VideoInfoStorage", "checkVideoHash cursor empty maxHitIndex:%d vector:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localVector1.size()) });
            localObject2 = "";
          }
          else
          {
            i1 = ((Integer)localVector1.get(i)).intValue();
            i2 = i1 * 100 / 256;
            if (i2 < 77)
            {
              com.tencent.mm.plugin.report.service.g.yxI.f(12696, new Object[] { Integer.valueOf(202), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(0), Integer.valueOf(localVector2.size()) });
              com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.VideoInfoStorage", "checkVideoHash NotEnoughHit. time:%d hit:%d percentMatch:%s arr:%d path:%s", new Object[] { Long.valueOf(bu.DD(l1)), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(localObject2.length - 1), str1 });
              localObject2 = "";
            }
            else
            {
              localObject2 = bu.nullAsNil((String)((Vector)localObject5).get(i));
              j = 0;
              k = 0;
              label2457:
              if (k < localVector1.size())
              {
                if ((k == i) || (((Integer)localVector1.get(k)).intValue() < i1) || (((String)localObject2).hashCode() == ((String)((Vector)localObject5).get(k)).hashCode())) {
                  break label3089;
                }
                j += 1;
                break label3127;
              }
              if (j <= 0) {
                break label2664;
              }
              ((t)localObject3).hKK.execSQL("VideoHash", "delete from VideoHash where size = ".concat(String.valueOf(n)));
              com.tencent.mm.plugin.report.service.g.yxI.f(12696, new Object[] { Integer.valueOf(203), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(0), Integer.valueOf(localVector2.size()), Integer.valueOf(0), "", "", "", Integer.valueOf(j) });
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VideoInfoStorage", "checkVideoHash Not ONE hash hit this path, give up duplicate:%s path:%s", new Object[] { Integer.valueOf(j), str1 });
              localObject2 = "";
            }
          }
        }
      }
      label2664:
      l1 = bu.DD(l1);
      long l2 = bu.a((Long)localVector2.get(i), 0L);
      localObject5 = String.format("%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(n), Integer.valueOf(i1), Long.valueOf(l2), Integer.valueOf(localVector2.size()), Long.valueOf(l1) });
      com.tencent.mm.plugin.report.service.g.yxI.f(12696, new Object[] { Integer.valueOf(300), localObject5 });
      com.tencent.mm.plugin.report.service.g.yxI.f(12696, new Object[] { Integer.valueOf(i2 + 3000), localObject5 });
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoInfoStorage", "checkVideoHash Succ time:%s hit:%s match:%s%% savetime:%s path:%s xml:%s orgpath:%s", new Object[] { Long.valueOf(l1), Integer.valueOf(i1), Integer.valueOf(i2), Long.valueOf(l2), str1, localObject2, ((Vector)localObject4).get(i) });
      localObject4 = (String)((Vector)localObject4).get(i);
      l1 = bu.fpO() % 1000L;
      if (l1 < m * 10) {
        break label3134;
      }
      if (i2 < 90) {
        break label3134;
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff should:%s now:%s ratio:%s percentMatch:%s debuger:%s", new Object[] { Boolean.valueOf(bool4), Long.valueOf(l1), Integer.valueOf(m), Integer.valueOf(i2), Boolean.valueOf(com.tencent.mm.sdk.a.b.fnF()) });
      if ((bool4) || (com.tencent.mm.sdk.a.b.fnF())) {
        com.tencent.mm.sdk.g.b.d(new t.2((t)localObject3, str1, (String)localObject4, (String)localObject5), "checkVideoHashByteDiff");
      }
      break label1424;
      boolean bool4 = false;
      continue;
      label3001:
      localObject2 = null;
      break label1442;
      if (this.ivF)
      {
        i = 2;
        break;
      }
      i = 0;
      break;
      label3024:
      if (this.ive.ixd != 1)
      {
        this.ive.ixd = 1;
        this.ive.status = 104;
        this.ive.clientId = this.idX;
        this.ive.dEu = 524544;
        u.f(this.ive);
      }
      AppMethodBeat.o(126857);
      return true;
      label3089:
      break label3127;
      label3092:
      break label2106;
      label3095:
      break label3120;
      label3098:
      bool4 = bool1;
      bool1 = bool2;
      bool2 = bool4;
      break label1337;
      label3113:
      j = 0;
      k = 0;
      break label2043;
      label3120:
      k += 1;
      break label2043;
      label3127:
      k += 1;
      break label2457;
      label3134:
      bool4 = true;
    }
  }
  
  private String aMX()
  {
    AppMethodBeat.i(126865);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(126865);
    return str;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(126856);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "%s stop %s", new Object[] { aMX(), this.idX });
    if (!bu.isNullOrNil(this.idX)) {
      com.tencent.mm.an.f.aGZ().Fr(this.idX);
    }
    this.ivh = true;
    super.cancel();
    AppMethodBeat.o(126856);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(126859);
    this.callback = paramf;
    this.ive = u.Ia(this.fileName);
    if ((this.ive == null) || ((this.ive.status != 104) && (this.ive.status != 103)))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "%s Get info Failed file:", new Object[] { aMX(), this.fileName });
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(126859);
      return -1;
    }
    paramf = new StringBuilder("doscene file:").append(this.fileName).append(" stat:").append(this.ive.status).append(" [").append(this.ive.iwV).append(",").append(this.ive.iwW).append("] [").append(this.ive.ivD).append(",").append(this.ive.hPI).append("]  netTimes:").append(this.ive.ixa).append(" times:");
    int i = this.gwU;
    this.gwU = (i + 1);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneUploadVideo", i);
    if (this.startTime == 0L)
    {
      this.startTime = bu.fpO();
      this.ivD = this.ive.ivD;
    }
    o.aNh();
    if (r.Hz(t.HJ(this.fileName)))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NetSceneUploadVideo", "%s it is mm h265 video xml[%s]", new Object[] { aMX(), this.ive.aNt() });
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 139L, 1L, false);
    }
    if (aMW())
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneUploadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { this.fileName });
      AppMethodBeat.o(126859);
      return 0;
    }
    if (x.Ba(this.ive.getUser()))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use parallel-upload user:%s", new Object[] { aMX(), this.ive.getUser() });
      i = 0;
    }
    label487:
    Object localObject2;
    while (i != 0)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneUploadVideo", "cdntra use parallel-upload return -1 for onGYNetEnd clientid:%s", new Object[] { this.fileName });
      AppMethodBeat.o(126859);
      return 0;
      if (1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qPa, 1)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label487;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "NOT ALLOW USE PARALLEL UPLOAD VIDEO");
        i = 0;
        break;
      }
      o.aNh();
      localObject1 = t.HK(this.fileName);
      o.aNh();
      paramf = t.HJ(this.fileName);
      localObject1 = Hs((String)localObject1);
      localObject2 = new com.tencent.mm.pluginsdk.f.d();
      ((com.tencent.mm.pluginsdk.f.d)localObject2).icx = this.ive.iwZ;
      ((com.tencent.mm.pluginsdk.f.d)localObject2).Fdc = this.ieB;
      ((com.tencent.mm.pluginsdk.f.d)localObject2).scene = 2;
      ((com.tencent.mm.pluginsdk.f.d)localObject2).fileType = 4;
      ((com.tencent.mm.pluginsdk.f.d)localObject2).thumbPath = ((String)localObject1);
      ((com.tencent.mm.pluginsdk.f.d)localObject2).hgD = paramf;
      new com.tencent.mm.pluginsdk.f.c().a((com.tencent.mm.pluginsdk.f.d)localObject2);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "use ParallelUploader, filename:%s", new Object[] { this.fileName });
      i = 1;
    }
    if (this.ive.ixc == 1)
    {
      this.dfI = true;
      paramf = new com.tencent.mm.ak.b.a();
      paramf.hQF = new due();
      paramf.hQG = new duf();
      paramf.uri = "/cgi-bin/micromsg-bin/uploadvideo";
      paramf.funcId = 149;
      paramf.hQH = 39;
      paramf.respCmdId = 1000000039;
      this.rr = paramf.aDS();
      localObject2 = (due)this.rr.hQD.hQJ;
      ((due)localObject2).uvG = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(2, ""));
      ((due)localObject2).uvF = this.ive.getUser();
      ((due)localObject2).FOR = this.fileName;
      if (this.dfI) {
        ((due)localObject2).FZk = 2;
      }
      if (this.ive.ixf == 3) {
        ((due)localObject2).FZk = 3;
      }
      ((due)localObject2).HLF = this.ive.hKI;
      ((due)localObject2).HlG = this.ive.iwW;
      ((due)localObject2).HZI = this.ive.hPI;
      if (!com.tencent.mm.network.ae.cR(ak.getContext())) {
        break label1546;
      }
      i = 1;
      label830:
      ((due)localObject2).GvW = i;
      ((due)localObject2).HlJ = 2;
      ((due)localObject2).HZJ = 0;
      ((due)localObject2).HZK = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      ((due)localObject2).HlI = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      if (!bu.isNullOrNil(this.dJw)) {
        break label1551;
      }
      o.aNh();
      paramf = com.tencent.mm.vfs.o.aRh(t.HJ(this.fileName));
      this.dJw = paramf;
      label914:
      ((due)localObject2).HZN = paramf;
      if (bu.isNullOrNil(this.ive.ixk)) {
        break label1559;
      }
      paramf = bn.BW(this.ive.ixk);
      label944:
      localObject1 = paramf;
      if (bu.isNullOrNil(paramf)) {
        localObject1 = bn.We();
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "video msg source is %s".concat(String.valueOf(localObject1)));
      ((due)localObject2).FNL = ((String)localObject1);
      ((due)localObject2).HZW = this.ive.dIA;
      paramf = this.ive.ixh;
      if ((paramf == null) || (bu.isNullOrNil(paramf.hET))) {
        break label1636;
      }
      ((due)localObject2).HZO = bu.bI(paramf.hET, "");
      ((due)localObject2).HZP = paramf.GBN;
      ((due)localObject2).HZQ = bu.bI(paramf.hEV, "");
      ((due)localObject2).HZS = bu.bI(paramf.hEX, "");
      ((due)localObject2).HZR = bu.bI(paramf.hEW, "");
      ((due)localObject2).HZT = bu.bI(paramf.hEY, "");
    }
    for (;;)
    {
      if (((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(this.ive.getUser())) {
        ((due)localObject2).Ghk = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUV(this.ive.getUser());
      }
      if (paramf != null)
      {
        ((due)localObject2).HZV = bu.bI(paramf.hEZ, "");
        ((due)localObject2).HZU = bu.bI(paramf.hFa, "");
      }
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneUploadVideo", "upload video: play length %d, thumb totalLen %d, video totalLen %d, funcFlag %d, videoMd5: %s stream %s streamtime: %d title %s thumburl %s", new Object[] { Integer.valueOf(((due)localObject2).HLF), Integer.valueOf(((due)localObject2).HlH), Integer.valueOf(((due)localObject2).HZI), Integer.valueOf(((due)localObject2).FZk), ((due)localObject2).HZN, ((due)localObject2).HZO, Integer.valueOf(((due)localObject2).HZP), ((due)localObject2).HZQ, ((due)localObject2).HZT });
      if (this.ive.status != 103) {
        break label1929;
      }
      o.aNh();
      paramf = t.t(t.HK(this.fileName), this.ive.iwV, ivB);
      if ((paramf.ret >= 0) && (paramf.diR != 0)) {
        break label1681;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 225L, 1L, false);
      u.HR(this.fileName);
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "]  Error ");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(126859);
      return -1;
      if (this.ive.createTime + 600L < bu.aRi())
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "create time check error:" + this.fileName);
        u.HR(this.fileName);
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        AppMethodBeat.o(126859);
        return -1;
      }
      if (u.HQ(this.fileName)) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "checkVoiceNetTimes Failed file:" + this.fileName);
      u.HR(this.fileName);
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(126859);
      return -1;
      label1546:
      i = 2;
      break label830;
      label1551:
      paramf = this.dJw;
      break label914;
      label1559:
      if (this.ive.ixj > 0)
      {
        paramf = bn.BW(bn.BV(((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(this.ive.ixj).eNd));
        break label944;
      }
      paramf = com.tencent.mm.vfs.o.aRh(this.ive.aNs());
      localObject1 = v.iQD;
      paramf = bn.BW(v.Ju(paramf));
      break label944;
      label1636:
      if ((paramf != null) && (!bu.isNullOrNil(paramf.hEX)) && (!bu.isNullOrNil(paramf.hEW)))
      {
        ((due)localObject2).HZS = paramf.hEX;
        ((due)localObject2).HZR = paramf.hEW;
      }
    }
    label1681:
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "] read ret:" + paramf.ret + " readlen:" + paramf.diR + " newOff:" + paramf.ixC + " netOff:" + this.ive.iwV);
    if (paramf.ixC < this.ive.iwV)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ THUMB[" + this.fileName + "] newOff:" + paramf.ixC + " OldtOff:" + this.ive.iwV);
      u.HR(this.fileName);
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(126859);
      return -1;
    }
    Object localObject1 = new byte[paramf.diR];
    System.arraycopy(paramf.buf, 0, localObject1, 0, paramf.diR);
    ((due)localObject2).HlH = this.ive.iwV;
    ((due)localObject2).HlI = new SKBuiltinBuffer_t().setBuffer((byte[])localObject1);
    for (;;)
    {
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(126859);
      return i;
      label1929:
      o.aNh();
      paramf = t.t(t.HJ(this.fileName), this.ive.ivD, ivB);
      if ((paramf.ret < 0) || (paramf.diR == 0))
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 224L, 1L, false);
        u.HR(this.fileName);
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "]  Error ");
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        AppMethodBeat.o(126859);
        return -1;
      }
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "] read ret:" + paramf.ret + " readlen:" + paramf.diR + " newOff:" + paramf.ixC + " netOff:" + this.ive.ivD);
      if (paramf.ixC < this.ive.ivD)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] newOff:" + paramf.ixC + " OldtOff:" + this.ive.ivD);
        u.HR(this.fileName);
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        AppMethodBeat.o(126859);
        return -1;
      }
      if (paramf.ixC >= c.iuA)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 222L, 1L, false);
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] maxsize:" + c.iuA);
        u.HR(this.fileName);
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        AppMethodBeat.o(126859);
        return -1;
      }
      localObject1 = new byte[paramf.diR];
      System.arraycopy(paramf.buf, 0, localObject1, 0, paramf.diR);
      ((due)localObject2).HZJ = this.ive.ivD;
      ((due)localObject2).HlH = this.ive.iwV;
      ((due)localObject2).HZK = new SKBuiltinBuffer_t().setBuffer((byte[])localObject1);
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.idX);
    if (this.ivh)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Call Stop by Service   file:" + this.fileName + " user:" + this.ive.getUser());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    paramArrayOfByte = (duf)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    paramq = (due)((com.tencent.mm.ak.b)paramq).hQD.hQJ;
    if ((paramArrayOfByte != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(paramArrayOfByte.Ghl);
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bu.isNullOrNil(this.idX)))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NetSceneUploadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.idX });
      AppMethodBeat.o(126863);
      return;
    }
    this.ive = u.Ia(this.fileName);
    if (this.ive == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if (this.ive.status == 105)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NetSceneUploadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.ive.dCd + "," + this.ive.aNq() + "," + this.ive.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((this.ive.status != 104) && (this.ive.status != 103))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.ive.status + " [" + this.fileName + "," + this.ive.dCd + "," + this.ive.aNq() + "," + this.ive.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd BLACK  errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.ive.getUser());
      u.HS(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 220L, 1L, false);
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.ive.getUser());
      u.HR(this.fileName);
      com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(this.ivg), Integer.valueOf(0) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 219L, 1L, false);
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.ive.getUser());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((!bu.cF(paramq.HlI.getBuffer().zr)) && (paramq.HlH != paramArrayOfByte.HlH - paramq.HlI.getILen()))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + paramq.HlH + "," + paramq.HlI.getILen() + "," + paramArrayOfByte.HlH + "] file:" + this.fileName + " user:" + paramq.uvF);
      u.HR(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((!bu.cF(paramq.HZK.getBuffer().zr)) && (paramq.HZJ != paramArrayOfByte.HZJ - paramq.HZK.getILen()))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + paramq.HZJ + "," + paramq.HZK.getILen() + "," + paramArrayOfByte.HZJ + "] file:" + this.fileName + " user:" + paramq.uvF);
      u.HR(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    this.ive.iwX = bu.aRi();
    this.ive.dCd = paramArrayOfByte.xrk;
    this.ive.dEu = 1028;
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneUploadVideo", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(this.ive.dCd), Integer.valueOf(ac.iRI) });
    if ((10007 == ac.iRH) && (ac.iRI != 0) && (this.ive.dCd != 0L))
    {
      this.ive.dCd = ac.iRI;
      ac.iRI = 0;
    }
    paramInt1 = this.ive.status;
    s locals;
    if (paramInt1 == 103)
    {
      locals = this.ive;
      paramInt1 = paramq.HlH;
      locals.iwV = (paramq.HlI.getILen() + paramInt1);
      this.ive.dEu |= 0x40;
      if (this.ive.iwV < this.ive.iwW) {
        break label2369;
      }
      this.ive.status = 104;
      this.ive.dEu |= 0x100;
      paramInt1 = 0;
    }
    for (;;)
    {
      u.f(this.ive);
      if (this.ivh)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(126863);
        return;
        if (paramInt1 == 104)
        {
          locals = this.ive;
          paramInt1 = paramq.HZJ;
          locals.ivD = (paramq.HZK.getILen() + paramInt1);
          this.ive.dEu |= 0x8;
          if (this.ive.ivD >= this.ive.hPI)
          {
            this.ive.status = 199;
            this.ive.dEu |= 0x100;
            u.d(this.ive);
            paramInt1 = 1;
          }
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd ERROR STATUS:" + paramInt1 + " file:" + this.fileName + " user:" + paramq.uvF);
          u.HR(this.fileName);
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(126863);
        }
      }
      else
      {
        if (paramInt1 == 0)
        {
          this.hPc.ay(10L, 10L);
          AppMethodBeat.o(126863);
          return;
        }
        paramq = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(this.ive.iwZ);
        paramq.tk(paramArrayOfByte.FNL);
        ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(paramq.field_msgId, paramq);
        com.tencent.mm.modelstat.b.iqT.q(paramq);
        com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(this.ivg), Integer.valueOf(this.ive.hPI - this.ivD) });
        boolean bool;
        if (this.ive == null)
        {
          bool = false;
          if ((!bool) && (!x.AA(this.ive.getUser()))) {
            break label2275;
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "upload to biz :%s", new Object[] { this.ive.getUser() });
          if (this.ive.dCd < 0L)
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.ive.dCd + " file:" + this.fileName + " toUser:" + this.ive.getUser());
            u.HR(this.fileName);
          }
          label2008:
          if (this.gIr == null) {
            break label2363;
          }
        }
        label2363:
        for (long l = this.gIr.abs();; l = 0L)
        {
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneUploadVideo", "!!!FIN: file:" + this.fileName + " toUser:" + this.ive.getUser() + " msgsvrid:" + this.ive.dCd + " thumbsize:" + this.ive.iwW + " videosize:" + this.ive.hPI + " useTime:" + l);
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneUploadVideo", "FinishLogForTime file:" + this.fileName + " packSize:" + ivB + " filesize:" + this.ive.hPI + " useTime:" + l);
          a.a(this.ive, 0);
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(126863);
          return;
          paramq = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(this.ive.getUser());
          if ((paramq == null) || ((int)paramq.ght <= 0))
          {
            bool = false;
            break;
          }
          bool = paramq.fug();
          break;
          label2275:
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideo", "not upload to biz");
          if (this.ive.dCd > 0L) {
            break label2008;
          }
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.ive.dCd + " file:" + this.fileName + " toUser:" + this.ive.getUser());
          u.HR(this.fileName);
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
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 210L, 1L, false);
    }
    AppMethodBeat.o(126862);
    return bool;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    AppMethodBeat.i(126860);
    paramq = (due)((com.tencent.mm.ak.b)paramq).hQD.hQJ;
    if ((bu.isNullOrNil(paramq.FOR)) || (paramq.HlJ <= 0) || (bu.isNullOrNil(paramq.uvG)) || (bu.isNullOrNil(paramq.uvF)) || (paramq.GvW <= 0) || (paramq.HlH > paramq.HlG) || (paramq.HlH < 0) || (paramq.HZJ > paramq.HZI) || (paramq.HZJ < 0) || ((paramq.HZJ == paramq.HZI) && (paramq.HlH == paramq.HlG)) || (paramq.HlG <= 0) || (paramq.HZI <= 0) || ((paramq.HZK.getILen() <= 0) && (paramq.HlI.getILen() <= 0)))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideo", "ERR: Security Check Failed file:" + this.fileName + " user:" + paramq.uvF);
      paramq = n.b.hRj;
      AppMethodBeat.o(126860);
      return paramq;
    }
    paramq = n.b.hRi;
    AppMethodBeat.o(126860);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(126861);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 221L, 1L, false);
    u.HR(this.fileName);
    AppMethodBeat.o(126861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.g
 * JD-Core Version:    0.7.0.1
 */