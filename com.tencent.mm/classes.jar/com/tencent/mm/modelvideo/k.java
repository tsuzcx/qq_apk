package com.tencent.mm.modelvideo;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.a;
import com.tencent.mm.an.q.b;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.f.b.a.ae;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bs;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.model.ad;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.protocal.protobuf.eyk;
import com.tencent.mm.protocal.protobuf.eyl;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.Vector;
import junit.framework.Assert;

public final class k
  extends q
  implements m
{
  private static int mgo = 32000;
  private final int MAX_TIMES;
  private com.tencent.mm.an.i callback;
  private String fVg;
  public String fileName;
  boolean fpE;
  f.a khd;
  MTimerHandler lAo;
  private boolean lPF;
  private com.tencent.mm.pluginsdk.g.d.a lPR;
  private String lPn;
  private com.tencent.mm.i.g.a lPx;
  public w mfR;
  private int mfT;
  private boolean mfU;
  private final long mgp;
  private int mgq;
  private boolean mgs;
  private boolean mgt;
  private int mgu;
  private int mgv;
  int mgw;
  int retCode;
  private com.tencent.mm.an.d rr;
  private long startTime;
  
  public k(String paramString)
  {
    AppMethodBeat.i(126858);
    this.fVg = "";
    this.mgp = 1800000L;
    this.retCode = 0;
    this.mfU = false;
    this.fpE = false;
    this.khd = null;
    this.lPF = true;
    this.lPn = "";
    this.startTime = 0L;
    this.mgq = -1;
    this.mfT = com.tencent.mm.i.a.MediaType_VIDEO;
    this.mgs = false;
    this.mgt = false;
    this.mgu = 0;
    this.mgv = 0;
    this.lPR = new com.tencent.mm.pluginsdk.g.d.a()
    {
      public final void O(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(216888);
        Log.e("MicroMsg.NetSceneUploadVideo", "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(k.a(k.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(k.b(k.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        Log.e("MicroMsg.NetSceneUploadVideo", "onUploadFailure, uploadId:%s", new Object[] { paramAnonymousString });
        y.Yb(k.c(k.this));
        k.j(k.this).onSceneEnd(3, paramAnonymousInt, "", k.this);
        AppMethodBeat.o(216888);
      }
      
      public final void a(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(216892);
        w localw = y.Yk(k.c(k.this));
        if (localw == null)
        {
          Log.e("MicroMsg.NetSceneUploadVideo", "%s info is null", new Object[] { k.e(k.this) });
          AppMethodBeat.o(216892);
          return;
        }
        if (localw.mgq > paramAnonymousLong)
        {
          Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnEndProc error oldpos:%d newpos:%d", new Object[] { k.e(k.this), Integer.valueOf(localw.mgq), Long.valueOf(paramAnonymousLong) });
          AppMethodBeat.o(216892);
          return;
        }
        localw.mhP = Util.nowSecond();
        localw.mgq = ((int)paramAnonymousLong);
        localw.cUP = 1032;
        y.f(localw);
        AppMethodBeat.o(216892);
      }
      
      public final void a(final com.tencent.mm.pluginsdk.g.g.a paramAnonymousa)
      {
        AppMethodBeat.i(216883);
        Log.i("MicroMsg.NetSceneUploadVideo", "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.aesKey, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.mHi) });
        long l1 = Util.nowMilliSecond();
        long l2 = k.a(k.this);
        long l3 = paramAnonymousa.mHi;
        com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(k.a(k.this)), Long.valueOf(l1), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(k.b(k.this)), Long.valueOf(l3), Long.valueOf(l3 / (l1 - l2)), Integer.valueOf(1) });
        com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
        locald.field_aesKey = paramAnonymousa.aesKey;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.smU;
        locald.field_fileLength = paramAnonymousa.mHi;
        s.bqB();
        paramAnonymousa = x.XT(k.c(k.this));
        s.bqB();
        Object localObject = x.XU(k.c(k.this));
        locald.field_thumbimgLength = ((int)u.bBQ(k.a(k.this, (String)localObject)));
        com.tencent.mm.aq.f.bkh();
        locald.field_filecrc = com.tencent.mm.aq.a.Vt(paramAnonymousa);
        locald.field_toUser = k.d(k.this).bqM();
        com.tencent.e.h.ZvG.be(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(215675);
            if (!k.a(k.this, this.lOQ).equals(this.lOQ))
            {
              u.deleteFile(k.a(k.this, this.lOQ));
              Log.i("MicroMsg.NetSceneUploadVideo", "delete thumbPath %s", new Object[] { this.lOQ });
            }
            AppMethodBeat.o(215675);
          }
        });
        paramAnonymousa = y.Yk(k.c(k.this));
        if (Util.isNullOrNil(paramAnonymousa.bqO()))
        {
          localObject = "<msg><videomsg aeskey=\"" + locald.field_aesKey + "\" cdnthumbaeskey=\"" + locald.field_aesKey + "\" cdnvideourl=\"" + locald.field_fileId + "\" ";
          localObject = (String)localObject + "cdnthumburl=\"" + locald.field_fileId + "\" ";
          localObject = (String)localObject + "length=\"" + locald.field_fileLength + "\" ";
          localObject = (String)localObject + "cdnthumblength=\"" + locald.field_thumbimgLength + "\"/></msg>";
          Log.i("MicroMsg.NetSceneUploadVideo", "%s cdn callback new build cdnInfo:%s", new Object[] { k.e(k.this), localObject });
          paramAnonymousa.mhW = ((String)localObject);
          y.f(paramAnonymousa);
        }
        localObject = XmlParser.parseXml(paramAnonymousa.bqO(), "msg", null);
        if (localObject != null)
        {
          x localx = s.bqB();
          s.bqB();
          localx.t(x.XT(k.c(k.this)), (String)((Map)localObject).get(".msg.videomsg.$cdnvideourl"), (String)((Map)localObject).get(".msg.videomsg.$aeskey"));
        }
        com.tencent.mm.kernel.h.aGY().a(new l(k.c(k.this), k.f(k.this), locald, new com.tencent.mm.ay.f()
        {
          public final void dN(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(216863);
            if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == 102))
            {
              com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(216440);
                  k.g(k.this);
                  k.1.2.this.mgz.status = 104;
                  k.1.2.this.mgz.createTime = Util.nowSecond();
                  k.1.2.this.mgz.mhP = Util.nowSecond();
                  k.1.2.this.mgz.mgq = 0;
                  k.1.2.this.mgz.cUP = 1800;
                  boolean bool = y.f(k.1.2.this.mgz);
                  Log.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { k.e(k.this), Boolean.valueOf(k.h(k.this)), Boolean.valueOf(bool), Long.valueOf(k.1.2.this.mgz.createTime) });
                  k.this.doScene(k.i(k.this), k.j(k.this));
                  AppMethodBeat.o(216440);
                }
              });
              AppMethodBeat.o(216863);
              return;
            }
            k.j(k.this).onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", k.this);
            AppMethodBeat.o(216863);
          }
        }), 0);
        AppMethodBeat.o(216883);
      }
    };
    this.lPx = new com.tencent.mm.i.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(216283);
        Log.d("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { k.e(k.this), k.k(k.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          Log.d("MicroMsg.NetSceneUploadVideo", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { k.k(k.this) });
          AppMethodBeat.o(216283);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          y.Yb(k.c(k.this));
          new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(k.a(k.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(k.b(k.this)), Integer.valueOf(0), "" })).bpa();
          k.j(k.this).onSceneEnd(3, paramAnonymousInt, "", k.this);
          AppMethodBeat.o(216283);
          return 0;
        }
        k.a(k.this, y.Yk(k.c(k.this)));
        if ((k.d(k.this) == null) || (k.d(k.this).status == 105))
        {
          if (k.d(k.this) == null) {}
          for (int i = -1;; i = k.d(k.this).status)
          {
            Log.i("MicroMsg.NetSceneUploadVideo", "%s info is null or has paused, status:%d", new Object[] { k.e(k.this), Integer.valueOf(i) });
            com.tencent.mm.aq.f.bkg().Vy(k.k(k.this));
            k.j(k.this).onSceneEnd(3, paramAnonymousInt, "info is null or has paused, status".concat(String.valueOf(i)), k.this);
            AppMethodBeat.o(216283);
            return 0;
          }
        }
        if (paramAnonymousc != null)
        {
          if (k.d(k.this).mgq > paramAnonymousc.field_finishedLength)
          {
            Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnEndProc error oldpos:%d newpos:%d", new Object[] { k.e(k.this), Integer.valueOf(k.d(k.this).mgq), Long.valueOf(paramAnonymousc.field_finishedLength) });
            AppMethodBeat.o(216283);
            return 0;
          }
          k.d(k.this).mhP = Util.nowSecond();
          k.d(k.this).mgq = ((int)paramAnonymousc.field_finishedLength);
          k.d(k.this).cUP = 1032;
          y.f(k.d(k.this));
          AppMethodBeat.o(216283);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode != 0)
          {
            Log.e("MicroMsg.NetSceneUploadVideo", "%s cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { k.e(k.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo });
            y.Yb(k.c(k.this));
            paramAnonymousString = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(1), Long.valueOf(k.a(k.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(k.b(k.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.iUs });
            new ae(paramAnonymousString).bpa();
            new com.tencent.mm.f.b.a.ac(paramAnonymousString).bpa();
            k.j(k.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", k.this);
          }
        }
        else
        {
          AppMethodBeat.o(216283);
          return 0;
        }
        Log.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn uploadvideo by cdn, videohash isHitCacheUpload: %d, enableHitcheck:%b", new Object[] { k.e(k.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(k.h(k.this)) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.IzE;
        if (k.l(k.this))
        {
          paramAnonymousInt = 810;
          label844:
          paramAnonymousString.a(12696, new Object[] { Integer.valueOf(paramAnonymousInt + paramAnonymousd.field_UploadHitCacheType), Integer.valueOf(k.d(k.this).lAW) });
          paramAnonymousBoolean = paramAnonymousd.field_isVideoReduced;
          Log.i("MicroMsg.NetSceneUploadVideo", "%s it video was reduced by cdn %b %s", new Object[] { k.e(k.this), Boolean.valueOf(paramAnonymousBoolean), k.c(k.this) });
          if (paramAnonymousBoolean) {
            break label1619;
          }
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(106L, 205L, 1L, false);
          if ((k.n(k.this) > 0) && (paramAnonymousd.field_thumbimgLength > 0))
          {
            Log.i("MicroMsg.NetSceneUploadVideo", "%s send video thumb too big thumb length [%d, %d] ", new Object[] { k.e(k.this), Integer.valueOf(k.n(k.this)), Integer.valueOf(paramAnonymousd.field_thumbimgLength) });
            if (k.n(k.this) * 2 <= paramAnonymousd.field_thumbimgLength) {
              break label1585;
            }
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(106L, 206L, 1L, false);
          }
          label1044:
          s.bqB();
          paramAnonymousInt = (int)u.bBQ(x.XT(k.c(k.this)));
          Log.i("MicroMsg.NetSceneUploadVideo", "%s send video too big thumb length [%d, %d] ", new Object[] { k.e(k.this), Integer.valueOf(k.d(k.this).lAW), Integer.valueOf(paramAnonymousInt) });
          if (k.d(k.this).lAW == paramAnonymousInt) {
            break label1602;
          }
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(106L, 208L, 1L, false);
          label1136:
          k.a(k.this, y.Yk(k.c(k.this)));
          if (Util.isNullOrNil(k.d(k.this).bqO()))
          {
            paramAnonymousString = "<msg><videomsg aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnvideourl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "length=\"" + paramAnonymousd.field_fileLength + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\"/></msg>";
            Log.i("MicroMsg.NetSceneUploadVideo", "%s cdn callback new build cdnInfo:%s", new Object[] { k.e(k.this), paramAnonymousString });
            k.d(k.this).mhW = paramAnonymousString;
            y.f(k.d(k.this));
          }
          paramAnonymousString = XmlParser.parseXml(k.d(k.this).bqO(), "msg", null);
          if (paramAnonymousString != null)
          {
            paramAnonymousc = s.bqB();
            s.bqB();
            boolean bool = paramAnonymousc.t(x.XT(k.c(k.this)), (String)paramAnonymousString.get(".msg.videomsg.$cdnvideourl"), (String)paramAnonymousString.get(".msg.videomsg.$aeskey"));
            paramAnonymousString = com.tencent.mm.plugin.report.service.h.IzE;
            if (!bool) {
              break label1636;
            }
            paramAnonymousInt = 1;
            label1460:
            paramAnonymousString.a(12696, new Object[] { Integer.valueOf(paramAnonymousInt + 900), Integer.valueOf(k.d(k.this).lAW) });
          }
          paramAnonymousString = com.tencent.mm.ay.s.bmp();
          paramAnonymousString.fileName = k.c(k.this);
          if (!paramAnonymousBoolean) {
            break label1641;
          }
        }
        label1585:
        label1602:
        label1619:
        label1636:
        label1641:
        for (paramAnonymousInt = 0;; paramAnonymousInt = k.f(k.this))
        {
          paramAnonymousString.lQY = paramAnonymousInt;
          paramAnonymousString.lQZ = paramAnonymousd;
          paramAnonymousString.lRa = new com.tencent.mm.ay.f()
          {
            public final void dN(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(216596);
              if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == 102))
              {
                com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(215854);
                    k.g(k.this);
                    k.d(k.this).status = 104;
                    k.d(k.this).createTime = Util.nowSecond();
                    k.d(k.this).mhP = Util.nowSecond();
                    k.d(k.this).mgq = 0;
                    k.d(k.this).cUP = 1800;
                    boolean bool = y.f(k.d(k.this));
                    Log.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { k.e(k.this), Boolean.valueOf(k.h(k.this)), Boolean.valueOf(bool), Long.valueOf(k.d(k.this).createTime) });
                    k.this.doScene(k.o(k.this), k.j(k.this));
                    AppMethodBeat.o(215854);
                  }
                });
                AppMethodBeat.o(216596);
                return;
              }
              new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(1), Long.valueOf(k.a(k.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(k.b(k.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.iUs })).bpa();
              a.a(k.d(k.this), 0);
              k.a(k.this, paramAnonymousd);
              k.j(k.this).onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", k.this);
              AppMethodBeat.o(216596);
            }
          };
          paramAnonymousString.lUq = 4;
          paramAnonymousString.bnl().aEv();
          break;
          if (k.m(k.this))
          {
            paramAnonymousInt = 820;
            break label844;
          }
          paramAnonymousInt = 830;
          break label844;
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(106L, 207L, 1L, false);
          break label1044;
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(106L, 209L, 1L, false);
          break label1136;
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(106L, 200L, 1L, false);
          break label1136;
          paramAnonymousInt = 2;
          break label1460;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.mgw = 0;
    this.lAo = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(215721);
        if (k.this.doScene(k.p(k.this), k.j(k.this)) == -1)
        {
          k.a(k.this, 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          k.j(k.this).onSceneEnd(3, -1, "doScene failed", k.this);
        }
        AppMethodBeat.o(215721);
        return false;
      }
    }, true);
    boolean bool;
    if (paramString != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      Log.d("MicroMsg.NetSceneUploadVideo", "NetSceneUploadVideo:  file:".concat(String.valueOf(paramString)));
      this.fileName = paramString;
      this.mfR = y.Yk(paramString);
      if (this.mfR == null) {
        break label265;
      }
    }
    label265:
    for (this.MAX_TIMES = 2500;; this.MAX_TIMES = 0)
    {
      this.khd = new f.a();
      if ((this.mfR != null) && (3 == this.mfR.mhX)) {
        this.mfT = com.tencent.mm.i.a.MediaType_TinyVideo;
      }
      Log.i("MicroMsg.NetSceneUploadVideo", "%s NetSceneUploadVideo:  videoType:[%d]", new Object[] { bqr(), Integer.valueOf(this.mfT) });
      AppMethodBeat.o(126858);
      return;
      bool = false;
      break;
    }
  }
  
  /* Error */
  private String XC(String paramString)
  {
    // Byte code:
    //   0: ldc 205
    //   2: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 207	com/tencent/mm/vfs/q
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 209	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   13: astore 9
    //   15: new 207	com/tencent/mm/vfs/q
    //   18: dup
    //   19: aload 9
    //   21: invokevirtual 213	com/tencent/mm/vfs/q:ifB	()Lcom/tencent/mm/vfs/q;
    //   24: new 215	java/lang/StringBuilder
    //   27: dup
    //   28: ldc 217
    //   30: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload 9
    //   35: invokevirtual 221	com/tencent/mm/vfs/q:getName	()Ljava/lang/String;
    //   38: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 231	com/tencent/mm/vfs/q:<init>	(Lcom/tencent/mm/vfs/q;Ljava/lang/String;)V
    //   47: astore 10
    //   49: aconst_null
    //   50: astore 7
    //   52: aconst_null
    //   53: astore 8
    //   55: aconst_null
    //   56: astore 5
    //   58: aconst_null
    //   59: astore 6
    //   61: ldc 139
    //   63: ldc 233
    //   65: iconst_1
    //   66: anewarray 184	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload 9
    //   73: invokevirtual 237	com/tencent/mm/vfs/q:length	()J
    //   76: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   79: aastore
    //   80: invokestatic 244	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload 9
    //   85: invokevirtual 237	com/tencent/mm/vfs/q:length	()J
    //   88: ldc2_w 245
    //   91: lcmp
    //   92: ifle +559 -> 651
    //   95: aload 10
    //   97: invokevirtual 250	com/tencent/mm/vfs/q:ifE	()Z
    //   100: ifeq +111 -> 211
    //   103: ldc 139
    //   105: ldc 252
    //   107: iconst_1
    //   108: anewarray 184	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload 10
    //   115: invokevirtual 255	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   118: aastore
    //   119: invokestatic 244	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: iconst_1
    //   123: istore_2
    //   124: aload 8
    //   126: astore 4
    //   128: aload 6
    //   130: astore 5
    //   132: aload 4
    //   134: ifnull +8 -> 142
    //   137: aload 4
    //   139: invokevirtual 260	java/io/InputStream:close	()V
    //   142: iload_2
    //   143: istore_3
    //   144: aload 5
    //   146: ifnull +10 -> 156
    //   149: aload 5
    //   151: invokevirtual 263	java/io/OutputStream:close	()V
    //   154: iload_2
    //   155: istore_3
    //   156: iload_3
    //   157: ifeq +379 -> 536
    //   160: ldc 139
    //   162: ldc_w 265
    //   165: iconst_3
    //   166: anewarray 184	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: aload_0
    //   172: invokespecial 188	com/tencent/mm/modelvideo/k:bqr	()Ljava/lang/String;
    //   175: aastore
    //   176: dup
    //   177: iconst_1
    //   178: aload 10
    //   180: invokevirtual 237	com/tencent/mm/vfs/q:length	()J
    //   183: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   186: aastore
    //   187: dup
    //   188: iconst_2
    //   189: aload 10
    //   191: invokevirtual 255	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   194: aastore
    //   195: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: aload 10
    //   200: invokevirtual 255	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   203: astore_1
    //   204: ldc 205
    //   206: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: aload_1
    //   210: areturn
    //   211: aload 9
    //   213: invokevirtual 255	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   216: invokestatic 271	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   219: astore 11
    //   221: aload 11
    //   223: ifnonnull +115 -> 338
    //   226: ldc_w 273
    //   229: astore 4
    //   231: ldc 139
    //   233: ldc_w 275
    //   236: iconst_1
    //   237: anewarray 184	java/lang/Object
    //   240: dup
    //   241: iconst_0
    //   242: aload 4
    //   244: aastore
    //   245: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   248: aload 11
    //   250: ifnull +125 -> 375
    //   253: aload 11
    //   255: getfield 280	android/graphics/BitmapFactory$Options:outWidth	I
    //   258: sipush 288
    //   261: if_icmpgt +14 -> 275
    //   264: aload 11
    //   266: getfield 283	android/graphics/BitmapFactory$Options:outHeight	I
    //   269: sipush 288
    //   272: if_icmple +103 -> 375
    //   275: aload 9
    //   277: invokevirtual 255	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   280: sipush 288
    //   283: sipush 288
    //   286: getstatic 289	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   289: bipush 60
    //   291: new 215	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   298: aload 10
    //   300: invokevirtual 213	com/tencent/mm/vfs/q:ifB	()Lcom/tencent/mm/vfs/q;
    //   303: invokevirtual 255	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   306: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc_w 292
    //   312: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: aload 10
    //   320: invokevirtual 221	com/tencent/mm/vfs/q:getName	()Ljava/lang/String;
    //   323: invokestatic 296	com/tencent/mm/sdk/platformtools/BitmapUtil:createThumbNail	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;)Z
    //   326: istore_2
    //   327: aload 6
    //   329: astore 5
    //   331: aload 8
    //   333: astore 4
    //   335: goto -203 -> 132
    //   338: new 215	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   345: aload 11
    //   347: getfield 280	android/graphics/BitmapFactory$Options:outWidth	I
    //   350: invokevirtual 299	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   353: ldc_w 301
    //   356: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload 11
    //   361: getfield 283	android/graphics/BitmapFactory$Options:outHeight	I
    //   364: invokevirtual 299	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   367: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: astore 4
    //   372: goto -141 -> 231
    //   375: aload 9
    //   377: invokestatic 307	com/tencent/mm/vfs/u:al	(Lcom/tencent/mm/vfs/q;)Ljava/io/InputStream;
    //   380: astore 4
    //   382: aload 4
    //   384: fconst_0
    //   385: sipush 288
    //   388: sipush 288
    //   391: invokestatic 311	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeStream	(Ljava/io/InputStream;FII)Landroid/graphics/Bitmap;
    //   394: astore 8
    //   396: aload 8
    //   398: ifnull +244 -> 642
    //   401: aload 10
    //   403: invokestatic 315	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   406: astore 6
    //   408: aload 6
    //   410: astore 5
    //   412: aload 5
    //   414: astore 7
    //   416: aload 4
    //   418: astore 6
    //   420: aload 8
    //   422: getstatic 289	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   425: bipush 60
    //   427: aload 5
    //   429: invokevirtual 321	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   432: istore_2
    //   433: goto -301 -> 132
    //   436: astore 8
    //   438: aconst_null
    //   439: astore 5
    //   441: aconst_null
    //   442: astore 4
    //   444: aload 5
    //   446: astore 7
    //   448: aload 4
    //   450: astore 6
    //   452: ldc 139
    //   454: ldc_w 323
    //   457: iconst_1
    //   458: anewarray 184	java/lang/Object
    //   461: dup
    //   462: iconst_0
    //   463: aload 8
    //   465: invokestatic 329	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   468: aastore
    //   469: invokestatic 332	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   472: aload 4
    //   474: ifnull +8 -> 482
    //   477: aload 4
    //   479: invokevirtual 260	java/io/InputStream:close	()V
    //   482: aload 5
    //   484: ifnull +153 -> 637
    //   487: aload 5
    //   489: invokevirtual 263	java/io/OutputStream:close	()V
    //   492: iconst_0
    //   493: istore_3
    //   494: goto -338 -> 156
    //   497: astore 4
    //   499: iconst_0
    //   500: istore_3
    //   501: goto -345 -> 156
    //   504: astore_1
    //   505: aload 7
    //   507: astore 4
    //   509: aload 4
    //   511: ifnull +8 -> 519
    //   514: aload 4
    //   516: invokevirtual 260	java/io/InputStream:close	()V
    //   519: aload 5
    //   521: ifnull +8 -> 529
    //   524: aload 5
    //   526: invokevirtual 263	java/io/OutputStream:close	()V
    //   529: ldc 205
    //   531: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   534: aload_1
    //   535: athrow
    //   536: ldc 139
    //   538: ldc_w 334
    //   541: iconst_3
    //   542: anewarray 184	java/lang/Object
    //   545: dup
    //   546: iconst_0
    //   547: aload_0
    //   548: invokespecial 188	com/tencent/mm/modelvideo/k:bqr	()Ljava/lang/String;
    //   551: aastore
    //   552: dup
    //   553: iconst_1
    //   554: aload 9
    //   556: invokevirtual 237	com/tencent/mm/vfs/q:length	()J
    //   559: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   562: aastore
    //   563: dup
    //   564: iconst_2
    //   565: aload 9
    //   567: invokevirtual 255	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   570: aastore
    //   571: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   574: ldc 205
    //   576: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   579: aload_1
    //   580: areturn
    //   581: astore 4
    //   583: goto -441 -> 142
    //   586: astore 4
    //   588: iload_2
    //   589: istore_3
    //   590: goto -434 -> 156
    //   593: astore 4
    //   595: goto -113 -> 482
    //   598: astore 4
    //   600: goto -81 -> 519
    //   603: astore 4
    //   605: goto -76 -> 529
    //   608: astore_1
    //   609: goto -100 -> 509
    //   612: astore_1
    //   613: aload 7
    //   615: astore 5
    //   617: aload 6
    //   619: astore 4
    //   621: goto -112 -> 509
    //   624: astore 8
    //   626: aconst_null
    //   627: astore 5
    //   629: goto -185 -> 444
    //   632: astore 8
    //   634: goto -190 -> 444
    //   637: iconst_0
    //   638: istore_3
    //   639: goto -483 -> 156
    //   642: iconst_0
    //   643: istore_2
    //   644: aload 6
    //   646: astore 5
    //   648: goto -516 -> 132
    //   651: iconst_0
    //   652: istore_2
    //   653: aload 6
    //   655: astore 5
    //   657: aload 8
    //   659: astore 4
    //   661: goto -529 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	664	0	this	k
    //   0	664	1	paramString	String
    //   123	530	2	bool1	boolean
    //   143	496	3	bool2	boolean
    //   126	352	4	localObject1	Object
    //   497	1	4	localIOException1	java.io.IOException
    //   507	8	4	localObject2	Object
    //   581	1	4	localIOException2	java.io.IOException
    //   586	1	4	localIOException3	java.io.IOException
    //   593	1	4	localIOException4	java.io.IOException
    //   598	1	4	localIOException5	java.io.IOException
    //   603	1	4	localIOException6	java.io.IOException
    //   619	41	4	localObject3	Object
    //   56	600	5	localObject4	Object
    //   59	595	6	localObject5	Object
    //   50	564	7	localObject6	Object
    //   53	368	8	localBitmap	android.graphics.Bitmap
    //   436	28	8	localException1	Exception
    //   624	1	8	localException2	Exception
    //   632	26	8	localException3	Exception
    //   13	553	9	localq1	com.tencent.mm.vfs.q
    //   47	355	10	localq2	com.tencent.mm.vfs.q
    //   219	141	11	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   83	122	436	java/lang/Exception
    //   211	221	436	java/lang/Exception
    //   231	248	436	java/lang/Exception
    //   253	275	436	java/lang/Exception
    //   275	327	436	java/lang/Exception
    //   338	372	436	java/lang/Exception
    //   375	382	436	java/lang/Exception
    //   487	492	497	java/io/IOException
    //   83	122	504	finally
    //   211	221	504	finally
    //   231	248	504	finally
    //   253	275	504	finally
    //   275	327	504	finally
    //   338	372	504	finally
    //   375	382	504	finally
    //   137	142	581	java/io/IOException
    //   149	154	586	java/io/IOException
    //   477	482	593	java/io/IOException
    //   514	519	598	java/io/IOException
    //   524	529	603	java/io/IOException
    //   382	396	608	finally
    //   401	408	608	finally
    //   420	433	612	finally
    //   452	472	612	finally
    //   382	396	624	java/lang/Exception
    //   401	408	624	java/lang/Exception
    //   420	433	632	java/lang/Exception
  }
  
  private boolean bqq()
  {
    AppMethodBeat.i(126857);
    String str2 = this.mfR.bqM();
    if (ab.QY(str2))
    {
      Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn user:%s", new Object[] { bqr(), str2 });
      AppMethodBeat.o(126857);
      return false;
    }
    if (!com.tencent.mm.pluginsdk.g.b.hfX())
    {
      Log.i("MicroMsg.NetSceneUploadVideo", "isAllow2UseCdnWithXLab = false");
      AppMethodBeat.o(126857);
      return false;
    }
    com.tencent.mm.aq.f.bkg();
    if ((!com.tencent.mm.aq.b.vQ(2)) && (this.mfR.mhV != 1))
    {
      localObject1 = bqr();
      com.tencent.mm.aq.f.bkg();
      Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { localObject1, Boolean.valueOf(com.tencent.mm.aq.b.vQ(2)), Integer.valueOf(this.mfR.mhV) });
      AppMethodBeat.o(126857);
      return false;
    }
    this.lPn = com.tencent.mm.aq.c.a("upvideo", this.mfR.createTime, str2, this.mfR.getFileName());
    if (Util.isNullOrNil(this.lPn))
    {
      Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra genClientId failed not use cdn file:%s", new Object[] { bqr(), this.mfR.getFileName() });
      AppMethodBeat.o(126857);
      return false;
    }
    s.bqB();
    Object localObject1 = x.XU(this.fileName);
    s.bqB();
    String str1 = x.XT(this.fileName);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.taskName = "task_NetSceneUploadVideo_1";
    localg.iUG = this.lPx;
    localg.field_mediaId = this.lPn;
    localg.field_fullpath = str1;
    localg.field_thumbpath = XC((String)localObject1);
    localg.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
    boolean bool1;
    label359:
    label379:
    Object localObject3;
    label428:
    Object localObject4;
    if (as.bvS(this.mfR.bqM()))
    {
      localg.field_sendmsg_viacdn = false;
      if ((as.bvS(this.mfR.bqM())) || (!this.lPF)) {
        break label806;
      }
      bool1 = true;
      localg.field_enable_hitcheck = bool1;
      if (!e.bkp().VE(str1)) {
        break label812;
      }
      i = 1;
      localg.field_largesvideo = i;
      if ((this.mfR != null) && (3 == this.mfR.mhX)) {
        localg.field_smallVideoFlag = 1;
      }
      localObject1 = bqr();
      if (this.mfR.mia != null) {
        break label817;
      }
      bool1 = true;
      Log.i("MicroMsg.NetSceneUploadVideo", "%s upload video MMSightExtInfo is null? %b %s", new Object[] { localObject1, Boolean.valueOf(bool1), this.fileName });
      if ((this.mfR.mia != null) && (this.mfR.mia.TCA))
      {
        Log.i("MicroMsg.NetSceneUploadVideo", "%s local capture video, mark use large video", new Object[] { bqr() });
        e.bkp();
        localg.field_largesvideo = e.b(e.bkp().bkq());
      }
      localObject1 = r.bqz();
      s.bqB();
      ((r)localObject1).a("", x.XT(this.fileName), this.mfR.bqM(), "", "", 2, 2);
      localObject3 = bqr();
      localObject4 = this.mfR.getFileName();
      if (this.mfR.mhZ != null) {
        break label823;
      }
      localObject1 = "null";
      label586:
      Log.i("MicroMsg.NetSceneUploadVideo", "%s checkAD file:%s adinfo:%s", new Object[] { localObject3, localObject4, localObject1 });
      if ((this.mfR.mhZ != null) && (!Util.isNullOrNil(this.mfR.mhZ.lox))) {
        localg.field_advideoflag = 1;
      }
      localg.field_talker = str2;
      if (!ab.Lj(str2)) {
        break label838;
      }
    }
    label806:
    label812:
    label817:
    label823:
    label838:
    for (int i = 1;; i = 0)
    {
      localg.field_chattype = i;
      localg.field_priority = com.tencent.mm.i.a.iTU;
      localg.field_needStorage = false;
      localg.field_isStreamMedia = false;
      localg.field_trysafecdn = true;
      this.mgv = ((int)u.bBQ(localg.field_fullpath));
      this.mgu = ((int)u.bBQ(localg.field_thumbpath));
      if (this.mgu < com.tencent.mm.i.a.iUq) {
        break label843;
      }
      Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { bqr(), localg.field_thumbpath, Integer.valueOf(this.mgu) });
      AppMethodBeat.o(126857);
      return false;
      if (!ad.bpP(str1)) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(106L, 30L, 1L, false);
      localg.field_use_multithread = true;
      break;
      bool1 = false;
      break label359;
      i = 0;
      break label379;
      bool1 = false;
      break label428;
      localObject1 = this.mfR.mhZ.lox;
      break label586;
    }
    label843:
    localObject1 = XmlParser.parseXml(this.mfR.bqO(), "msg", null);
    boolean bool2;
    label1280:
    int m;
    long l1;
    label1367:
    label1385:
    Object localObject2;
    label1540:
    label1546:
    label1552:
    label1558:
    label1564:
    label1570:
    label1576:
    Object localObject5;
    label1985:
    int k;
    int j;
    label2048:
    int i2;
    if (localObject1 != null)
    {
      localg.field_fileId = ((String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"));
      localg.field_aesKey = ((String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
      this.mgt = true;
      localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
      if (this.mgs)
      {
        i = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject1).a(12696, new Object[] { Integer.valueOf(i + 700), Integer.valueOf(this.mfR.lAW) });
        if ((Util.isNullOrNil(localg.field_aesKey)) || (Util.isNullOrNil(localg.field_aesKey)))
        {
          localg.field_aesKey = "";
          localg.field_fileId = "";
        }
        Log.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn check hit cache VideoHash :%s %s %s %b %d", new Object[] { bqr(), localg.field_mediaId, localg.field_fileId, localg.field_aesKey, Boolean.valueOf(this.lPF), Integer.valueOf(localg.field_largesvideo) });
        if (com.tencent.mm.aq.f.bkg().f(localg)) {
          break label2967;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 226L, 1L, false);
        Log.e("MicroMsg.NetSceneUploadVideo", "%s cdntra addSendTask failed.", new Object[] { bqr() });
        this.lPn = "";
        AppMethodBeat.o(126857);
        return false;
      }
    }
    else
    {
      Log.i("MicroMsg.NetSceneUploadVideo", "%s cdntra parse video recv xml failed", new Object[] { bqr() });
      int n;
      int i1;
      Vector localVector2;
      for (;;)
      {
        try
        {
          str2 = Util.nullAsNil(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("UseVideoHash"));
          localObject1 = str2.split(",");
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHE();
          i = com.tencent.mm.b.i.cA(com.tencent.mm.kernel.b.getUin(), 100);
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break label1546;
          }
          if (Util.getInt(localObject1[0], 0) < i) {
            break label1540;
          }
          bool1 = true;
          if ((localObject1 == null) || (localObject1.length < 2)) {
            break label1558;
          }
          if (Util.getInt(localObject1[1], 0) < i) {
            break label1552;
          }
          bool2 = true;
          if ((localObject1 == null) || (localObject1.length < 3)) {
            break label1570;
          }
          if (Util.getInt(localObject1[2], 0) < i) {
            break label1564;
          }
          bool3 = true;
          if (!CrashReportFactory.hasDebuger()) {
            break label3041;
          }
          bool1 = true;
          bool2 = true;
          bool3 = true;
          if (!bool2) {
            break label2944;
          }
          localObject3 = s.bqB();
          m = Util.getInt(localObject1[2], 0);
          Log.i("MicroMsg.VideoInfoStorage", "checkVideoHash in fullCheckRatio:%s path:%s stack:%s", new Object[] { Integer.valueOf(m), str1, Util.getStack() });
          l1 = Util.nowMilliSecond();
          if (!Util.isNullOrNil(str1)) {
            break label1576;
          }
          Log.e("MicroMsg.VideoInfoStorage", "checkVideoHash failed , path:%s ", new Object[] { str1 });
          localObject1 = "";
          if (Util.isNullOrNil((String)localObject1)) {
            break label2944;
          }
          localObject1 = ((String)localObject1).split("##");
          if ((bool1) && (localObject1 != null) && (localObject1.length == 2))
          {
            localg.field_fileId = localObject1[0];
            localg.field_aesKey = localObject1[1];
            this.mgs = true;
          }
          Log.i("MicroMsg.NetSceneUploadVideo", "%s CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", new Object[] { bqr(), Boolean.valueOf(CrashReportFactory.hasDebuger()), str2, Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(this.mgs), localg.field_fileId, localg.field_aesKey });
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.NetSceneUploadVideo", "Check use videohash :%s", new Object[] { Util.stackTraceToString(localException) });
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
        localObject2 = x.XW(str1);
        if ((localObject2 == null) || (localObject2.length < 33))
        {
          Log.e("MicroMsg.VideoInfoStorage", "checkVideoHash  readHash failed :%s", new Object[] { str1 });
          localObject2 = "";
        }
        else
        {
          ((x)localObject3).lvy.execSQL("VideoHash", "delete from VideoHash where CreateTime < " + (Util.nowSecond() - 432000L));
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
          Cursor localCursor = ((x)localObject3).lvy.rawQuery("select size, CreateTime, hash, cdnxml, orgpath from VideoHash where size = ".concat(String.valueOf(n)), null);
          while (localCursor.moveToNext())
          {
            l2 = localCursor.getLong(1);
            String str3 = localCursor.getString(2);
            String str4 = localCursor.getString(3);
            String str5 = localCursor.getString(4);
            Log.v("MicroMsg.VideoInfoStorage", "checkVideoHash select [%s][%s]", new Object[] { str3, str4 });
            if ((Util.isNullOrNil(str3)) || (Util.isNullOrNil(str4)))
            {
              com.tencent.mm.plugin.report.service.h.IzE.a(12696, new Object[] { Integer.valueOf(104), Integer.valueOf(n) });
              Log.w("MicroMsg.VideoInfoStorage", "checkVideoHash select error [%s][%s]", new Object[] { str3, str4 });
            }
            else
            {
              if (i1 == str3.length()) {
                break label3056;
              }
              com.tencent.mm.plugin.report.service.h.IzE.a(12696, new Object[] { Integer.valueOf(105), Integer.valueOf(n) });
              Log.w("MicroMsg.VideoInfoStorage", "checkVideoHash err length file:%d cursor:%d", new Object[] { Integer.valueOf(i1), Integer.valueOf(str3.length()) });
              continue;
              if (k < i1)
              {
                if (localStringBuffer.charAt(k) != str3.charAt(k)) {
                  break label3038;
                }
                j += 1;
                break label3063;
              }
              if ((i >= 0) && (localVector1.size() > i) && (((Integer)localVector1.get(i)).intValue() >= j)) {
                break label3035;
              }
              i = localVector1.size();
              localVector1.add(Integer.valueOf(j));
              ((Vector)localObject5).add(str4);
              ((Vector)localObject4).add(str5);
              localVector2.add(Long.valueOf(l2));
              Log.d("MicroMsg.VideoInfoStorage", "checkVideoHash cursor hitCount:%d/%d ,max:%d vector:%d/%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i1), localVector1.get(i), Integer.valueOf(i), Integer.valueOf(localVector1.size()) });
            }
          }
          localCursor.close();
          if ((i < 0) || (localVector1.size() <= 0))
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(12696, new Object[] { Integer.valueOf(201), Integer.valueOf(n) });
            Log.w("MicroMsg.VideoInfoStorage", "checkVideoHash cursor empty maxHitIndex:%d vector:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localVector1.size()) });
            localObject2 = "";
          }
          else
          {
            i1 = ((Integer)localVector1.get(i)).intValue();
            i2 = i1 * 100 / 256;
            if (i2 < 77)
            {
              com.tencent.mm.plugin.report.service.h.IzE.a(12696, new Object[] { Integer.valueOf(202), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(0), Integer.valueOf(localVector2.size()) });
              Log.w("MicroMsg.VideoInfoStorage", "checkVideoHash NotEnoughHit. time:%d hit:%d percentMatch:%s arr:%d path:%s", new Object[] { Long.valueOf(Util.milliSecondsToNow(l1)), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(localObject2.length - 1), str1 });
              localObject2 = "";
            }
            else
            {
              localObject2 = Util.nullAsNil((String)((Vector)localObject5).get(i));
              j = 0;
              k = 0;
              label2399:
              if (k < localVector1.size())
              {
                if ((k == i) || (((Integer)localVector1.get(k)).intValue() < i1) || (((String)localObject2).hashCode() == ((String)((Vector)localObject5).get(k)).hashCode())) {
                  break label3032;
                }
                j += 1;
                break label3070;
              }
              if (j <= 0) {
                break label2606;
              }
              ((x)localObject3).lvy.execSQL("VideoHash", "delete from VideoHash where size = ".concat(String.valueOf(n)));
              com.tencent.mm.plugin.report.service.h.IzE.a(12696, new Object[] { Integer.valueOf(203), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(0), Integer.valueOf(localVector2.size()), Integer.valueOf(0), "", "", "", Integer.valueOf(j) });
              Log.e("MicroMsg.VideoInfoStorage", "checkVideoHash Not ONE hash hit this path, give up duplicate:%s path:%s", new Object[] { Integer.valueOf(j), str1 });
              localObject2 = "";
            }
          }
        }
      }
      label2606:
      l1 = Util.milliSecondsToNow(l1);
      long l2 = Util.nullAs((Long)localVector2.get(i), 0L);
      localObject5 = String.format("%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(n), Integer.valueOf(i1), Long.valueOf(l2), Integer.valueOf(localVector2.size()), Long.valueOf(l1) });
      com.tencent.mm.plugin.report.service.h.IzE.a(12696, new Object[] { Integer.valueOf(300), localObject5 });
      com.tencent.mm.plugin.report.service.h.IzE.a(12696, new Object[] { Integer.valueOf(i2 + 3000), localObject5 });
      Log.i("MicroMsg.VideoInfoStorage", "checkVideoHash Succ time:%s hit:%s match:%s%% savetime:%s path:%s xml:%s orgpath:%s", new Object[] { Long.valueOf(l1), Integer.valueOf(i1), Integer.valueOf(i2), Long.valueOf(l2), str1, localObject2, ((Vector)localObject4).get(i) });
      localObject4 = (String)((Vector)localObject4).get(i);
      l1 = Util.nowMilliSecond() % 1000L;
      if (l1 < m * 10) {
        break label3077;
      }
      if (i2 < 90) {
        break label3077;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff should:%s now:%s ratio:%s percentMatch:%s debuger:%s", new Object[] { Boolean.valueOf(bool4), Long.valueOf(l1), Integer.valueOf(m), Integer.valueOf(i2), Boolean.valueOf(CrashReportFactory.hasDebuger()) });
      if ((bool4) || (CrashReportFactory.hasDebuger())) {
        ThreadPool.post(new x.2((x)localObject3, str1, (String)localObject4, (String)localObject5), "checkVideoHashByteDiff", 1);
      }
      break label1367;
      boolean bool4 = false;
      continue;
      label2944:
      localObject2 = null;
      break label1385;
      if (this.mgt)
      {
        i = 2;
        break;
      }
      i = 0;
      break;
      label2967:
      if (this.mfR.mhV != 1)
      {
        this.mfR.mhV = 1;
        this.mfR.status = 104;
        this.mfR.clientId = this.lPn;
        this.mfR.cUP = 524544;
        y.f(this.mfR);
      }
      AppMethodBeat.o(126857);
      return true;
      label3032:
      break label3070;
      label3035:
      break label2048;
      label3038:
      break label3063;
      label3041:
      bool4 = bool1;
      bool1 = bool2;
      bool2 = bool4;
      break label1280;
      label3056:
      j = 0;
      k = 0;
      break label1985;
      label3063:
      k += 1;
      break label1985;
      label3070:
      k += 1;
      break label2399;
      label3077:
      bool4 = true;
    }
  }
  
  private String bqr()
  {
    AppMethodBeat.i(126865);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(126865);
    return str;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(126856);
    Log.i("MicroMsg.NetSceneUploadVideo", "%s stop %s", new Object[] { bqr(), this.lPn });
    if (!Util.isNullOrNil(this.lPn)) {
      com.tencent.mm.aq.f.bkg().Vy(this.lPn);
    }
    this.mfU = true;
    super.cancel();
    AppMethodBeat.o(126856);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(126859);
    this.callback = parami;
    this.mfR = y.Yk(this.fileName);
    if ((this.mfR == null) || ((this.mfR.status != 104) && (this.mfR.status != 103)))
    {
      Log.e("MicroMsg.NetSceneUploadVideo", "%s Get info Failed file:", new Object[] { bqr(), this.fileName });
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(126859);
      return -1;
    }
    parami = new StringBuilder("doscene file:").append(this.fileName).append(" stat:").append(this.mfR.status).append(" [").append(this.mfR.mhN).append(",").append(this.mfR.mhO).append("] [").append(this.mfR.mgq).append(",").append(this.mfR.lAW).append("]  netTimes:").append(this.mfR.mhS).append(" times:");
    int i = this.mgw;
    this.mgw = (i + 1);
    Log.d("MicroMsg.NetSceneUploadVideo", i);
    if (this.startTime == 0L)
    {
      this.startTime = Util.nowMilliSecond();
      this.mgq = this.mfR.mgq;
    }
    s.bqB();
    if (v.XJ(x.XT(this.fileName)))
    {
      Log.w("MicroMsg.NetSceneUploadVideo", "%s it is mm h265 video xml[%s]", new Object[] { bqr(), this.mfR.bqO() });
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 139L, 1L, false);
    }
    if (bqq())
    {
      Log.d("MicroMsg.NetSceneUploadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { this.fileName });
      AppMethodBeat.o(126859);
      return 0;
    }
    if (ab.QY(this.mfR.bqM()))
    {
      Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use parallel-upload user:%s", new Object[] { bqr(), this.mfR.bqM() });
      i = 0;
    }
    label487:
    Object localObject2;
    while (i != 0)
    {
      Log.d("MicroMsg.NetSceneUploadVideo", "cdntra use parallel-upload return -1 for onGYNetEnd clientid:%s", new Object[] { this.fileName });
      AppMethodBeat.o(126859);
      return 0;
      if (1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWW, 0)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label487;
        }
        Log.i("MicroMsg.NetSceneUploadVideo", "NOT ALLOW USE PARALLEL UPLOAD VIDEO");
        i = 0;
        break;
      }
      s.bqB();
      localObject1 = x.XU(this.fileName);
      s.bqB();
      parami = x.XT(this.fileName);
      localObject1 = XC((String)localObject1);
      localObject2 = new com.tencent.mm.pluginsdk.g.d();
      ((com.tencent.mm.pluginsdk.g.d)localObject2).lNP = this.mfR.mhR;
      ((com.tencent.mm.pluginsdk.g.d)localObject2).QSZ = this.lPR;
      ((com.tencent.mm.pluginsdk.g.d)localObject2).scene = 2;
      ((com.tencent.mm.pluginsdk.g.d)localObject2).fileType = 4;
      ((com.tencent.mm.pluginsdk.g.d)localObject2).thumbPath = ((String)localObject1);
      ((com.tencent.mm.pluginsdk.g.d)localObject2).fullPath = parami;
      new com.tencent.mm.pluginsdk.g.c().a((com.tencent.mm.pluginsdk.g.d)localObject2);
      Log.i("MicroMsg.NetSceneUploadVideo", "use ParallelUploader, filename:%s", new Object[] { this.fileName });
      i = 1;
    }
    if (this.mfR.mhU == 1)
    {
      this.fpE = true;
      parami = new com.tencent.mm.an.d.a();
      parami.lBU = new eyk();
      parami.lBV = new eyl();
      parami.uri = "/cgi-bin/micromsg-bin/uploadvideo";
      parami.funcId = 149;
      parami.lBW = 39;
      parami.respCmdId = 1000000039;
      this.rr = parami.bgN();
      localObject2 = (eyk)d.b.b(this.rr.lBR);
      ((eyk)localObject2).CRR = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(2, ""));
      ((eyk)localObject2).CRQ = this.mfR.bqM();
      ((eyk)localObject2).RJQ = this.fileName;
      if (this.fpE) {
        ((eyk)localObject2).RUc = 2;
      }
      if (this.mfR.mhX == 3) {
        ((eyk)localObject2).RUc = 3;
      }
      ((eyk)localObject2).UjJ = this.mfR.lvw;
      ((eyk)localObject2).TCZ = this.mfR.mhO;
      ((eyk)localObject2).UyB = this.mfR.lAW;
      if (!ag.dj(MMApplicationContext.getContext())) {
        break label1546;
      }
      i = 1;
      label830:
      ((eyk)localObject2).SsZ = i;
      ((eyk)localObject2).TDc = 2;
      ((eyk)localObject2).UyC = 0;
      ((eyk)localObject2).UyD = new eae().dc(new byte[0]);
      ((eyk)localObject2).TDb = new eae().dc(new byte[0]);
      if (!Util.isNullOrNil(this.fVg)) {
        break label1551;
      }
      s.bqB();
      parami = u.buc(x.XT(this.fileName));
      this.fVg = parami;
      label914:
      ((eyk)localObject2).UyG = parami;
      if (Util.isNullOrNil(this.mfR.mic)) {
        break label1559;
      }
      parami = bs.RV(this.mfR.mic);
      label944:
      localObject1 = parami;
      if (Util.isNullOrNil(parami)) {
        localObject1 = bs.apc();
      }
      Log.i("MicroMsg.NetSceneUploadVideo", "video msg source is %s".concat(String.valueOf(localObject1)));
      ((eyk)localObject2).RII = ((String)localObject1);
      ((eyk)localObject2).UyP = this.mfR.fUk;
      parami = this.mfR.mhZ;
      if ((parami == null) || (Util.isNullOrNil(parami.lor))) {
        break label1636;
      }
      ((eyk)localObject2).UyH = Util.nullAs(parami.lor, "");
      ((eyk)localObject2).UyI = parami.SAk;
      ((eyk)localObject2).UyJ = Util.nullAs(parami.lot, "");
      ((eyk)localObject2).UyL = Util.nullAs(parami.lov, "");
      ((eyk)localObject2).UyK = Util.nullAs(parami.lou, "");
      ((eyk)localObject2).UyM = Util.nullAs(parami.low, "");
    }
    for (;;)
    {
      if (((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).ifAddTicketByActionFlag(this.mfR.bqM())) {
        ((eyk)localObject2).ScZ = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bws(this.mfR.bqM());
      }
      if (parami != null)
      {
        ((eyk)localObject2).UyO = Util.nullAs(parami.lox, "");
        ((eyk)localObject2).UyN = Util.nullAs(parami.loy, "");
      }
      Log.d("MicroMsg.NetSceneUploadVideo", "upload video: play length %d, thumb totalLen %d, video totalLen %d, funcFlag %d, videoMd5: %s stream %s streamtime: %d title %s thumburl %s", new Object[] { Integer.valueOf(((eyk)localObject2).UjJ), Integer.valueOf(((eyk)localObject2).TDa), Integer.valueOf(((eyk)localObject2).UyB), Integer.valueOf(((eyk)localObject2).RUc), ((eyk)localObject2).UyG, ((eyk)localObject2).UyH, Integer.valueOf(((eyk)localObject2).UyI), ((eyk)localObject2).UyJ, ((eyk)localObject2).UyM });
      if (this.mfR.status != 103) {
        break label1929;
      }
      s.bqB();
      parami = x.u(x.XU(this.fileName), this.mfR.mhN, mgo);
      if ((parami.ret >= 0) && (parami.fsR != 0)) {
        break label1681;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 225L, 1L, false);
      y.Yb(this.fileName);
      Log.e("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "]  Error ");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(126859);
      return -1;
      if (this.mfR.createTime + 600L < Util.nowSecond())
      {
        Log.e("MicroMsg.NetSceneUploadVideo", "create time check error:" + this.fileName);
        y.Yb(this.fileName);
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        AppMethodBeat.o(126859);
        return -1;
      }
      if (y.Ya(this.fileName)) {
        break;
      }
      Log.e("MicroMsg.NetSceneUploadVideo", "checkVoiceNetTimes Failed file:" + this.fileName);
      y.Yb(this.fileName);
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(126859);
      return -1;
      label1546:
      i = 2;
      break label830;
      label1551:
      parami = this.fVg;
      break label914;
      label1559:
      if (this.mfR.mib > 0)
      {
        parami = bs.RV(bs.RU(((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(this.mfR.mib).hxy));
        break label944;
      }
      parami = u.buc(this.mfR.bqN());
      localObject1 = com.tencent.mm.platformtools.v.mEG;
      parami = bs.RV(com.tencent.mm.platformtools.v.ZU(parami));
      break label944;
      label1636:
      if ((parami != null) && (!Util.isNullOrNil(parami.lov)) && (!Util.isNullOrNil(parami.lou)))
      {
        ((eyk)localObject2).UyL = parami.lov;
        ((eyk)localObject2).UyK = parami.lou;
      }
    }
    label1681:
    Log.d("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "] read ret:" + parami.ret + " readlen:" + parami.fsR + " newOff:" + parami.miv + " netOff:" + this.mfR.mhN);
    if (parami.miv < this.mfR.mhN)
    {
      Log.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ THUMB[" + this.fileName + "] newOff:" + parami.miv + " OldtOff:" + this.mfR.mhN);
      y.Yb(this.fileName);
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(126859);
      return -1;
    }
    Object localObject1 = new byte[parami.fsR];
    System.arraycopy(parami.buf, 0, localObject1, 0, parami.fsR);
    ((eyk)localObject2).TDa = this.mfR.mhN;
    ((eyk)localObject2).TDb = new eae().dc((byte[])localObject1);
    for (;;)
    {
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(126859);
      return i;
      label1929:
      s.bqB();
      parami = x.u(x.XT(this.fileName), this.mfR.mgq, mgo);
      if ((parami.ret < 0) || (parami.fsR == 0))
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 224L, 1L, false);
        y.Yb(this.fileName);
        Log.e("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "]  Error ");
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        AppMethodBeat.o(126859);
        return -1;
      }
      Log.d("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "] read ret:" + parami.ret + " readlen:" + parami.fsR + " newOff:" + parami.miv + " netOff:" + this.mfR.mgq);
      if (parami.miv < this.mfR.mgq)
      {
        Log.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] newOff:" + parami.miv + " OldtOff:" + this.mfR.mgq);
        y.Yb(this.fileName);
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        AppMethodBeat.o(126859);
        return -1;
      }
      if (parami.miv >= g.mfo)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 222L, 1L, false);
        Log.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] maxsize:" + g.mfo);
        y.Yb(this.fileName);
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        AppMethodBeat.o(126859);
        return -1;
      }
      localObject1 = new byte[parami.fsR];
      System.arraycopy(parami.buf, 0, localObject1, 0, parami.fsR);
      ((eyk)localObject2).UyC = this.mfR.mgq;
      ((eyk)localObject2).TDa = this.mfR.mhN;
      ((eyk)localObject2).UyD = new eae().dc((byte[])localObject1);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126863);
    Log.i("MicroMsg.NetSceneUploadVideo", "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.lPn);
    if (this.mfU)
    {
      Log.d("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Call Stop by Service   file:" + this.fileName + " user:" + this.mfR.bqM());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    paramArrayOfByte = (eyl)d.c.b(((com.tencent.mm.an.d)params).lBS);
    params = (eyk)d.b.b(((com.tencent.mm.an.d)params).lBR);
    if ((paramArrayOfByte != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).setEnSendMsgActionFlag(paramArrayOfByte.Sda);
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!Util.isNullOrNil(this.lPn)))
    {
      Log.w("MicroMsg.NetSceneUploadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.lPn });
      AppMethodBeat.o(126863);
      return;
    }
    this.mfR = y.Yk(this.fileName);
    if (this.mfR == null)
    {
      Log.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if (this.mfR.status == 105)
    {
      Log.w("MicroMsg.NetSceneUploadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.mfR.fNu + "," + this.mfR.bqK() + "," + this.mfR.bqM() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((this.mfR.status != 104) && (this.mfR.status != 103))
    {
      Log.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.mfR.status + " [" + this.fileName + "," + this.mfR.fNu + "," + this.mfR.bqK() + "," + this.mfR.bqM() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      Log.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd BLACK  errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.mfR.bqM());
      y.Yc(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 220L, 1L, false);
      Log.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.mfR.bqM());
      y.Yb(this.fileName);
      com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(this.mfT), Integer.valueOf(0) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 219L, 1L, false);
      Log.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.mfR.bqM());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((!Util.isNullOrNil(params.TDb.Tkb.UH)) && (params.TDa != paramArrayOfByte.TDa - params.TDb.Ufv))
    {
      Log.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + params.TDa + "," + params.TDb.Ufv + "," + paramArrayOfByte.TDa + "] file:" + this.fileName + " user:" + params.CRQ);
      y.Yb(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((!Util.isNullOrNil(params.UyD.Tkb.UH)) && (params.UyC != paramArrayOfByte.UyC - params.UyD.Ufv))
    {
      Log.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + params.UyC + "," + params.UyD.Ufv + "," + paramArrayOfByte.UyC + "] file:" + this.fileName + " user:" + params.CRQ);
      y.Yb(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    this.mfR.mhP = Util.nowSecond();
    this.mfR.fNu = paramArrayOfByte.HlH;
    this.mfR.cUP = 1028;
    Log.d("MicroMsg.NetSceneUploadVideo", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(this.mfR.fNu), Integer.valueOf(com.tencent.mm.platformtools.ac.mFN) });
    if ((10007 == com.tencent.mm.platformtools.ac.mFM) && (com.tencent.mm.platformtools.ac.mFN != 0) && (this.mfR.fNu != 0L))
    {
      this.mfR.fNu = com.tencent.mm.platformtools.ac.mFN;
      com.tencent.mm.platformtools.ac.mFN = 0;
    }
    paramInt1 = this.mfR.status;
    w localw;
    if (paramInt1 == 103)
    {
      localw = this.mfR;
      paramInt1 = params.TDa;
      localw.mhN = (params.TDb.Ufv + paramInt1);
      this.mfR.cUP |= 0x40;
      if (this.mfR.mhN < this.mfR.mhO) {
        break label2366;
      }
      this.mfR.status = 104;
      this.mfR.cUP |= 0x100;
      paramInt1 = 0;
    }
    for (;;)
    {
      y.f(this.mfR);
      if (this.mfU)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(126863);
        return;
        if (paramInt1 == 104)
        {
          localw = this.mfR;
          paramInt1 = params.UyC;
          localw.mgq = (params.UyD.Ufv + paramInt1);
          this.mfR.cUP |= 0x8;
          if (this.mfR.mgq >= this.mfR.lAW)
          {
            this.mfR.status = 199;
            this.mfR.cUP |= 0x100;
            y.d(this.mfR);
            paramInt1 = 1;
          }
        }
        else
        {
          Log.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd ERROR STATUS:" + paramInt1 + " file:" + this.fileName + " user:" + params.CRQ);
          y.Yb(this.fileName);
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(126863);
        }
      }
      else
      {
        if (paramInt1 == 0)
        {
          this.lAo.startTimer(10L);
          AppMethodBeat.o(126863);
          return;
        }
        params = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(this.mfR.mhR);
        params.Ip(paramArrayOfByte.RII);
        ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(params.field_msgId, params);
        com.tencent.mm.modelstat.b.mcf.u(params);
        com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(this.mfT), Integer.valueOf(this.mfR.lAW - this.mgq) });
        boolean bool;
        if (this.mfR == null)
        {
          bool = false;
          if ((!bool) && (!ab.Qy(this.mfR.bqM()))) {
            break label2272;
          }
          Log.i("MicroMsg.NetSceneUploadVideo", "upload to biz :%s", new Object[] { this.mfR.bqM() });
          if (this.mfR.fNu < 0L)
          {
            Log.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.mfR.fNu + " file:" + this.fileName + " toUser:" + this.mfR.bqM());
            y.Yb(this.fileName);
          }
          label2005:
          if (this.khd == null) {
            break label2360;
          }
        }
        label2360:
        for (long l = this.khd.avE();; l = 0L)
        {
          Log.d("MicroMsg.NetSceneUploadVideo", "!!!FIN: file:" + this.fileName + " toUser:" + this.mfR.bqM() + " msgsvrid:" + this.mfR.fNu + " thumbsize:" + this.mfR.mhO + " videosize:" + this.mfR.lAW + " useTime:" + l);
          Log.d("MicroMsg.NetSceneUploadVideo", "FinishLogForTime file:" + this.fileName + " packSize:" + mgo + " filesize:" + this.mfR.lAW + " useTime:" + l);
          a.a(this.mfR, 0);
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(126863);
          return;
          params = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(this.mfR.bqM());
          if ((params == null) || ((int)params.jxt <= 0))
          {
            bool = false;
            break;
          }
          bool = params.hxX();
          break;
          label2272:
          Log.i("MicroMsg.NetSceneUploadVideo", "not upload to biz");
          if (this.mfR.fNu > 0L) {
            break label2005;
          }
          Log.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.mfR.fNu + " file:" + this.fileName + " toUser:" + this.mfR.bqM());
          y.Yb(this.fileName);
          break label2005;
        }
      }
      label2366:
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
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 210L, 1L, false);
    }
    AppMethodBeat.o(126862);
    return bool;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(126860);
    params = (eyk)d.b.b(((com.tencent.mm.an.d)params).lBR);
    if ((Util.isNullOrNil(params.RJQ)) || (params.TDc <= 0) || (Util.isNullOrNil(params.CRR)) || (Util.isNullOrNil(params.CRQ)) || (params.SsZ <= 0) || (params.TDa > params.TCZ) || (params.TDa < 0) || (params.UyC > params.UyB) || (params.UyC < 0) || ((params.UyC == params.UyB) && (params.TDa == params.TCZ)) || (params.TCZ <= 0) || (params.UyB <= 0) || ((params.UyD.Ufv <= 0) && (params.TDb.Ufv <= 0)))
    {
      Log.e("MicroMsg.NetSceneUploadVideo", "ERR: Security Check Failed file:" + this.fileName + " user:" + params.CRQ);
      params = q.b.lCy;
      AppMethodBeat.o(126860);
      return params;
    }
    params = q.b.lCx;
    AppMethodBeat.o(126860);
    return params;
  }
  
  public final void setSecurityCheckError(q.a parama)
  {
    AppMethodBeat.i(126861);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 221L, 1L, false);
    y.Yb(this.fileName);
    AppMethodBeat.o(126861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.k
 * JD-Core Version:    0.7.0.1
 */