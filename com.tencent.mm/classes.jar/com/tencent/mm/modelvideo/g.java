package com.tencent.mm.modelvideo;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.br;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.protocal.protobuf.eoc;
import com.tencent.mm.protocal.protobuf.eod;
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
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.Vector;
import junit.framework.Assert;

public final class g
  extends q
  implements m
{
  private static int jqN = 32000;
  private final int MAX_TIMES;
  private com.tencent.mm.ak.i callback;
  boolean dwS;
  private String ebj;
  public String fileName;
  int hjI;
  f.a hvh;
  MTimerHandler iKj;
  private String iYT;
  private com.tencent.mm.i.g.a iZc;
  private boolean iZk;
  private com.tencent.mm.pluginsdk.f.d.a iZw;
  private final long jqO;
  private int jqP;
  private boolean jqQ;
  private boolean jqR;
  private int jqS;
  private int jqT;
  public s jqq;
  private int jqs;
  private boolean jqt;
  int retCode;
  private com.tencent.mm.ak.d rr;
  private long startTime;
  
  public g(String paramString)
  {
    AppMethodBeat.i(126858);
    this.ebj = "";
    this.jqO = 1800000L;
    this.retCode = 0;
    this.jqt = false;
    this.dwS = false;
    this.hvh = null;
    this.iZk = true;
    this.iYT = "";
    this.startTime = 0L;
    this.jqP = -1;
    this.jqs = com.tencent.mm.i.a.MediaType_VIDEO;
    this.jqQ = false;
    this.jqR = false;
    this.jqS = 0;
    this.jqT = 0;
    this.iZw = new com.tencent.mm.pluginsdk.f.d.a()
    {
      public final void M(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(240855);
        Log.e("MicroMsg.NetSceneUploadVideo", "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.h.CyF.a(10420, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(g.a(g.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(g.b(g.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        Log.e("MicroMsg.NetSceneUploadVideo", "onUploadFailure, uploadId:%s", new Object[] { paramAnonymousString });
        u.QE(g.c(g.this));
        g.j(g.this).onSceneEnd(3, paramAnonymousInt, "", g.this);
        AppMethodBeat.o(240855);
      }
      
      public final void a(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(240856);
        s locals = u.QN(g.c(g.this));
        if (locals == null)
        {
          Log.e("MicroMsg.NetSceneUploadVideo", "%s info is null", new Object[] { g.e(g.this) });
          AppMethodBeat.o(240856);
          return;
        }
        if (locals.jqP > paramAnonymousLong)
        {
          Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnEndProc error oldpos:%d newpos:%d", new Object[] { g.e(g.this), Integer.valueOf(locals.jqP), Long.valueOf(paramAnonymousLong) });
          AppMethodBeat.o(240856);
          return;
        }
        locals.jsm = Util.nowSecond();
        locals.jqP = ((int)paramAnonymousLong);
        locals.cSx = 1032;
        u.f(locals);
        AppMethodBeat.o(240856);
      }
      
      public final void a(final com.tencent.mm.pluginsdk.f.g.a paramAnonymousa)
      {
        AppMethodBeat.i(240854);
        Log.i("MicroMsg.NetSceneUploadVideo", "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.aesKey, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.jPY) });
        long l1 = Util.nowMilliSecond();
        long l2 = g.a(g.this);
        long l3 = paramAnonymousa.jPY;
        com.tencent.mm.plugin.report.service.h.CyF.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(g.a(g.this)), Long.valueOf(l1), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(g.b(g.this)), Long.valueOf(l3), Long.valueOf(l3 / (l1 - l2)), Integer.valueOf(1) });
        com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
        locald.field_aesKey = paramAnonymousa.aesKey;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.pkL;
        locald.field_fileLength = paramAnonymousa.jPY;
        o.bhj();
        paramAnonymousa = t.Qw(g.c(g.this));
        o.bhj();
        Object localObject = t.Qx(g.c(g.this));
        locald.field_thumbimgLength = ((int)com.tencent.mm.vfs.s.boW(g.a(g.this, (String)localObject)));
        com.tencent.mm.an.f.baR();
        locald.field_filecrc = com.tencent.mm.an.a.NW(paramAnonymousa);
        locald.field_toUser = g.d(g.this).getUser();
        com.tencent.f.h.RTc.aX(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(240851);
            if (!g.a(g.this, this.iYw).equals(this.iYw))
            {
              com.tencent.mm.vfs.s.deleteFile(g.a(g.this, this.iYw));
              Log.i("MicroMsg.NetSceneUploadVideo", "delete thumbPath %s", new Object[] { this.iYw });
            }
            AppMethodBeat.o(240851);
          }
        });
        paramAnonymousa = u.QN(g.c(g.this));
        if (Util.isNullOrNil(paramAnonymousa.bhv()))
        {
          localObject = "<msg><videomsg aeskey=\"" + locald.field_aesKey + "\" cdnthumbaeskey=\"" + locald.field_aesKey + "\" cdnvideourl=\"" + locald.field_fileId + "\" ";
          localObject = (String)localObject + "cdnthumburl=\"" + locald.field_fileId + "\" ";
          localObject = (String)localObject + "length=\"" + locald.field_fileLength + "\" ";
          localObject = (String)localObject + "cdnthumblength=\"" + locald.field_thumbimgLength + "\"/></msg>";
          Log.i("MicroMsg.NetSceneUploadVideo", "%s cdn callback new build cdnInfo:%s", new Object[] { g.e(g.this), localObject });
          paramAnonymousa.jst = ((String)localObject);
          u.f(paramAnonymousa);
        }
        localObject = XmlParser.parseXml(paramAnonymousa.bhv(), "msg", null);
        if (localObject != null)
        {
          t localt = o.bhj();
          o.bhj();
          localt.q(t.Qw(g.c(g.this)), (String)((Map)localObject).get(".msg.videomsg.$cdnvideourl"), (String)((Map)localObject).get(".msg.videomsg.$aeskey"));
        }
        com.tencent.mm.kernel.g.azz().a(new h(g.c(g.this), g.f(g.this), locald, new com.tencent.mm.av.f()
        {
          public final void dq(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(240853);
            if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == 102))
            {
              com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(240852);
                  g.g(g.this);
                  g.1.2.this.jqW.status = 104;
                  g.1.2.this.jqW.createTime = Util.nowSecond();
                  g.1.2.this.jqW.jsm = Util.nowSecond();
                  g.1.2.this.jqW.jqP = 0;
                  g.1.2.this.jqW.cSx = 1800;
                  boolean bool = u.f(g.1.2.this.jqW);
                  Log.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { g.e(g.this), Boolean.valueOf(g.h(g.this)), Boolean.valueOf(bool), Long.valueOf(g.1.2.this.jqW.createTime) });
                  g.this.doScene(g.i(g.this), g.j(g.this));
                  AppMethodBeat.o(240852);
                }
              });
              AppMethodBeat.o(240853);
              return;
            }
            g.j(g.this).onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", g.this);
            AppMethodBeat.o(240853);
          }
        }), 0);
        AppMethodBeat.o(240854);
      }
    };
    this.iZc = new com.tencent.mm.i.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(240859);
        Log.d("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { g.e(g.this), g.k(g.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          Log.d("MicroMsg.NetSceneUploadVideo", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { g.k(g.this) });
          AppMethodBeat.o(240859);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          u.QE(g.c(g.this));
          new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(g.a(g.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(g.b(g.this)), Integer.valueOf(0), "" })).bfK();
          g.j(g.this).onSceneEnd(3, paramAnonymousInt, "", g.this);
          AppMethodBeat.o(240859);
          return 0;
        }
        g.a(g.this, u.QN(g.c(g.this)));
        if ((g.d(g.this) == null) || (g.d(g.this).status == 105))
        {
          if (g.d(g.this) == null) {}
          for (int i = -1;; i = g.d(g.this).status)
          {
            Log.i("MicroMsg.NetSceneUploadVideo", "%s info is null or has paused, status:%d", new Object[] { g.e(g.this), Integer.valueOf(i) });
            com.tencent.mm.an.f.baQ().Ob(g.k(g.this));
            g.j(g.this).onSceneEnd(3, paramAnonymousInt, "info is null or has paused, status".concat(String.valueOf(i)), g.this);
            AppMethodBeat.o(240859);
            return 0;
          }
        }
        if (paramAnonymousc != null)
        {
          if (g.d(g.this).jqP > paramAnonymousc.field_finishedLength)
          {
            Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnEndProc error oldpos:%d newpos:%d", new Object[] { g.e(g.this), Integer.valueOf(g.d(g.this).jqP), Long.valueOf(paramAnonymousc.field_finishedLength) });
            AppMethodBeat.o(240859);
            return 0;
          }
          g.d(g.this).jsm = Util.nowSecond();
          g.d(g.this).jqP = ((int)paramAnonymousc.field_finishedLength);
          g.d(g.this).cSx = 1032;
          u.f(g.d(g.this));
          AppMethodBeat.o(240859);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode != 0)
          {
            Log.e("MicroMsg.NetSceneUploadVideo", "%s cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { g.e(g.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo });
            u.QE(g.c(g.this));
            paramAnonymousString = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(1), Long.valueOf(g.a(g.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(g.b(g.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.gqk });
            new y(paramAnonymousString).bfK();
            new w(paramAnonymousString).bfK();
            g.j(g.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", g.this);
          }
        }
        else
        {
          AppMethodBeat.o(240859);
          return 0;
        }
        Log.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn uploadvideo by cdn, videohash isHitCacheUpload: %d, enableHitcheck:%b", new Object[] { g.e(g.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(g.h(g.this)) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.CyF;
        if (g.l(g.this))
        {
          paramAnonymousInt = 810;
          label844:
          paramAnonymousString.a(12696, new Object[] { Integer.valueOf(paramAnonymousInt + paramAnonymousd.field_UploadHitCacheType), Integer.valueOf(g.d(g.this).iKP) });
          paramAnonymousBoolean = paramAnonymousd.field_isVideoReduced;
          Log.i("MicroMsg.NetSceneUploadVideo", "%s it video was reduced by cdn %b %s", new Object[] { g.e(g.this), Boolean.valueOf(paramAnonymousBoolean), g.c(g.this) });
          if (paramAnonymousBoolean) {
            break label1619;
          }
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(106L, 205L, 1L, false);
          if ((g.n(g.this) > 0) && (paramAnonymousd.field_thumbimgLength > 0))
          {
            Log.i("MicroMsg.NetSceneUploadVideo", "%s send video thumb too big thumb length [%d, %d] ", new Object[] { g.e(g.this), Integer.valueOf(g.n(g.this)), Integer.valueOf(paramAnonymousd.field_thumbimgLength) });
            if (g.n(g.this) * 2 <= paramAnonymousd.field_thumbimgLength) {
              break label1585;
            }
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(106L, 206L, 1L, false);
          }
          label1044:
          o.bhj();
          paramAnonymousInt = (int)com.tencent.mm.vfs.s.boW(t.Qw(g.c(g.this)));
          Log.i("MicroMsg.NetSceneUploadVideo", "%s send video too big thumb length [%d, %d] ", new Object[] { g.e(g.this), Integer.valueOf(g.d(g.this).iKP), Integer.valueOf(paramAnonymousInt) });
          if (g.d(g.this).iKP == paramAnonymousInt) {
            break label1602;
          }
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(106L, 208L, 1L, false);
          label1136:
          g.a(g.this, u.QN(g.c(g.this)));
          if (Util.isNullOrNil(g.d(g.this).bhv()))
          {
            paramAnonymousString = "<msg><videomsg aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnvideourl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "length=\"" + paramAnonymousd.field_fileLength + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\"/></msg>";
            Log.i("MicroMsg.NetSceneUploadVideo", "%s cdn callback new build cdnInfo:%s", new Object[] { g.e(g.this), paramAnonymousString });
            g.d(g.this).jst = paramAnonymousString;
            u.f(g.d(g.this));
          }
          paramAnonymousString = XmlParser.parseXml(g.d(g.this).bhv(), "msg", null);
          if (paramAnonymousString != null)
          {
            paramAnonymousc = o.bhj();
            o.bhj();
            boolean bool = paramAnonymousc.q(t.Qw(g.c(g.this)), (String)paramAnonymousString.get(".msg.videomsg.$cdnvideourl"), (String)paramAnonymousString.get(".msg.videomsg.$aeskey"));
            paramAnonymousString = com.tencent.mm.plugin.report.service.h.CyF;
            if (!bool) {
              break label1636;
            }
            paramAnonymousInt = 1;
            label1460:
            paramAnonymousString.a(12696, new Object[] { Integer.valueOf(paramAnonymousInt + 900), Integer.valueOf(g.d(g.this).iKP) });
          }
          paramAnonymousString = com.tencent.mm.av.s.bcY();
          paramAnonymousString.fileName = g.c(g.this);
          if (!paramAnonymousBoolean) {
            break label1641;
          }
        }
        label1585:
        label1602:
        label1619:
        label1636:
        label1641:
        for (paramAnonymousInt = 0;; paramAnonymousInt = g.f(g.this))
        {
          paramAnonymousString.jaB = paramAnonymousInt;
          paramAnonymousString.jaC = paramAnonymousd;
          paramAnonymousString.jaD = new com.tencent.mm.av.f()
          {
            public final void dq(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(240858);
              if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == 102))
              {
                com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(240857);
                    g.g(g.this);
                    g.d(g.this).status = 104;
                    g.d(g.this).createTime = Util.nowSecond();
                    g.d(g.this).jsm = Util.nowSecond();
                    g.d(g.this).jqP = 0;
                    g.d(g.this).cSx = 1800;
                    boolean bool = u.f(g.d(g.this));
                    Log.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { g.e(g.this), Boolean.valueOf(g.h(g.this)), Boolean.valueOf(bool), Long.valueOf(g.d(g.this).createTime) });
                    g.this.doScene(g.o(g.this), g.j(g.this));
                    AppMethodBeat.o(240857);
                  }
                });
                AppMethodBeat.o(240858);
                return;
              }
              new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(1), Long.valueOf(g.a(g.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(g.b(g.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.gqk })).bfK();
              a.a(g.d(g.this), 0);
              g.a(g.this, paramAnonymousd);
              g.j(g.this).onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", g.this);
              AppMethodBeat.o(240858);
            }
          };
          paramAnonymousString.jdR = 4;
          paramAnonymousString.bdQ().execute();
          break;
          if (g.m(g.this))
          {
            paramAnonymousInt = 820;
            break label844;
          }
          paramAnonymousInt = 830;
          break label844;
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(106L, 207L, 1L, false);
          break label1044;
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(106L, 209L, 1L, false);
          break label1136;
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(106L, 200L, 1L, false);
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
    this.hjI = 0;
    this.iKj = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(240860);
        if (g.this.doScene(g.p(g.this), g.j(g.this)) == -1)
        {
          g.a(g.this, 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          g.j(g.this).onSceneEnd(3, -1, "doScene failed", g.this);
        }
        AppMethodBeat.o(240860);
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
      this.jqq = u.QN(paramString);
      if (this.jqq == null) {
        break label265;
      }
    }
    label265:
    for (this.MAX_TIMES = 2500;; this.MAX_TIMES = 0)
    {
      this.hvh = new f.a();
      if ((this.jqq != null) && (3 == this.jqq.jsu)) {
        this.jqs = com.tencent.mm.i.a.MediaType_TinyVideo;
      }
      Log.i("MicroMsg.NetSceneUploadVideo", "%s NetSceneUploadVideo:  videoType:[%d]", new Object[] { bgZ(), Integer.valueOf(this.jqs) });
      AppMethodBeat.o(126858);
      return;
      bool = false;
      break;
    }
  }
  
  /* Error */
  private String Qf(String paramString)
  {
    // Byte code:
    //   0: ldc 205
    //   2: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 207	com/tencent/mm/vfs/o
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 209	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   13: astore 9
    //   15: new 207	com/tencent/mm/vfs/o
    //   18: dup
    //   19: aload 9
    //   21: invokevirtual 213	com/tencent/mm/vfs/o:heq	()Lcom/tencent/mm/vfs/o;
    //   24: new 215	java/lang/StringBuilder
    //   27: dup
    //   28: ldc 217
    //   30: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload 9
    //   35: invokevirtual 221	com/tencent/mm/vfs/o:getName	()Ljava/lang/String;
    //   38: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 231	com/tencent/mm/vfs/o:<init>	(Lcom/tencent/mm/vfs/o;Ljava/lang/String;)V
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
    //   73: invokevirtual 237	com/tencent/mm/vfs/o:length	()J
    //   76: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   79: aastore
    //   80: invokestatic 244	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload 9
    //   85: invokevirtual 237	com/tencent/mm/vfs/o:length	()J
    //   88: ldc2_w 245
    //   91: lcmp
    //   92: ifle +580 -> 672
    //   95: aload 10
    //   97: invokevirtual 250	com/tencent/mm/vfs/o:exists	()Z
    //   100: ifeq +120 -> 220
    //   103: ldc 139
    //   105: ldc 252
    //   107: iconst_1
    //   108: anewarray 184	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload 10
    //   115: invokevirtual 256	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
    //   118: invokestatic 262	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   121: aastore
    //   122: invokestatic 244	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   125: iconst_1
    //   126: istore_2
    //   127: aload 8
    //   129: astore 4
    //   131: aload 6
    //   133: astore 5
    //   135: aload 4
    //   137: ifnull +8 -> 145
    //   140: aload 4
    //   142: invokevirtual 267	java/io/InputStream:close	()V
    //   145: iload_2
    //   146: istore_3
    //   147: aload 5
    //   149: ifnull +10 -> 159
    //   152: aload 5
    //   154: invokevirtual 270	java/io/OutputStream:close	()V
    //   157: iload_2
    //   158: istore_3
    //   159: iload_3
    //   160: ifeq +394 -> 554
    //   163: ldc 139
    //   165: ldc_w 272
    //   168: iconst_3
    //   169: anewarray 184	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: aload_0
    //   175: invokespecial 188	com/tencent/mm/modelvideo/g:bgZ	()Ljava/lang/String;
    //   178: aastore
    //   179: dup
    //   180: iconst_1
    //   181: aload 10
    //   183: invokevirtual 237	com/tencent/mm/vfs/o:length	()J
    //   186: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   189: aastore
    //   190: dup
    //   191: iconst_2
    //   192: aload 10
    //   194: invokevirtual 256	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
    //   197: invokestatic 262	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   200: aastore
    //   201: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: aload 10
    //   206: invokevirtual 256	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
    //   209: invokestatic 262	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   212: astore_1
    //   213: ldc 205
    //   215: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: aload_1
    //   219: areturn
    //   220: aload 9
    //   222: invokevirtual 256	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
    //   225: invokestatic 262	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   228: invokestatic 278	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   231: astore 11
    //   233: aload 11
    //   235: ifnonnull +121 -> 356
    //   238: ldc_w 280
    //   241: astore 4
    //   243: ldc 139
    //   245: ldc_w 282
    //   248: iconst_1
    //   249: anewarray 184	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: aload 4
    //   256: aastore
    //   257: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: aload 11
    //   262: ifnull +131 -> 393
    //   265: aload 11
    //   267: getfield 287	android/graphics/BitmapFactory$Options:outWidth	I
    //   270: sipush 288
    //   273: if_icmpgt +14 -> 287
    //   276: aload 11
    //   278: getfield 290	android/graphics/BitmapFactory$Options:outHeight	I
    //   281: sipush 288
    //   284: if_icmple +109 -> 393
    //   287: aload 9
    //   289: invokevirtual 256	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
    //   292: invokestatic 262	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   295: sipush 288
    //   298: sipush 288
    //   301: getstatic 296	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   304: bipush 60
    //   306: new 215	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   313: aload 10
    //   315: invokevirtual 213	com/tencent/mm/vfs/o:heq	()Lcom/tencent/mm/vfs/o;
    //   318: invokevirtual 256	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
    //   321: invokestatic 262	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   324: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: ldc_w 299
    //   330: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: aload 10
    //   338: invokevirtual 221	com/tencent/mm/vfs/o:getName	()Ljava/lang/String;
    //   341: invokestatic 303	com/tencent/mm/sdk/platformtools/BitmapUtil:createThumbNail	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;)Z
    //   344: istore_2
    //   345: aload 6
    //   347: astore 5
    //   349: aload 8
    //   351: astore 4
    //   353: goto -218 -> 135
    //   356: new 215	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   363: aload 11
    //   365: getfield 287	android/graphics/BitmapFactory$Options:outWidth	I
    //   368: invokevirtual 306	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   371: ldc_w 308
    //   374: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: aload 11
    //   379: getfield 290	android/graphics/BitmapFactory$Options:outHeight	I
    //   382: invokevirtual 306	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   385: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: astore 4
    //   390: goto -147 -> 243
    //   393: aload 9
    //   395: invokestatic 314	com/tencent/mm/vfs/s:ao	(Lcom/tencent/mm/vfs/o;)Ljava/io/InputStream;
    //   398: astore 4
    //   400: aload 4
    //   402: fconst_0
    //   403: sipush 288
    //   406: sipush 288
    //   409: invokestatic 318	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeStream	(Ljava/io/InputStream;FII)Landroid/graphics/Bitmap;
    //   412: astore 8
    //   414: aload 8
    //   416: ifnull +247 -> 663
    //   419: aload 10
    //   421: invokestatic 322	com/tencent/mm/vfs/s:ap	(Lcom/tencent/mm/vfs/o;)Ljava/io/OutputStream;
    //   424: astore 6
    //   426: aload 6
    //   428: astore 5
    //   430: aload 5
    //   432: astore 7
    //   434: aload 4
    //   436: astore 6
    //   438: aload 8
    //   440: getstatic 296	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   443: bipush 60
    //   445: aload 5
    //   447: invokevirtual 328	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
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
    //   470: ldc 139
    //   472: ldc_w 330
    //   475: iconst_1
    //   476: anewarray 184	java/lang/Object
    //   479: dup
    //   480: iconst_0
    //   481: aload 8
    //   483: invokestatic 336	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   486: aastore
    //   487: invokestatic 339	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   490: aload 4
    //   492: ifnull +8 -> 500
    //   495: aload 4
    //   497: invokevirtual 267	java/io/InputStream:close	()V
    //   500: aload 5
    //   502: ifnull +156 -> 658
    //   505: aload 5
    //   507: invokevirtual 270	java/io/OutputStream:close	()V
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
    //   534: invokevirtual 267	java/io/InputStream:close	()V
    //   537: aload 5
    //   539: ifnull +8 -> 547
    //   542: aload 5
    //   544: invokevirtual 270	java/io/OutputStream:close	()V
    //   547: ldc 205
    //   549: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   552: aload_1
    //   553: athrow
    //   554: ldc 139
    //   556: ldc_w 341
    //   559: iconst_3
    //   560: anewarray 184	java/lang/Object
    //   563: dup
    //   564: iconst_0
    //   565: aload_0
    //   566: invokespecial 188	com/tencent/mm/modelvideo/g:bgZ	()Ljava/lang/String;
    //   569: aastore
    //   570: dup
    //   571: iconst_1
    //   572: aload 9
    //   574: invokevirtual 237	com/tencent/mm/vfs/o:length	()J
    //   577: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   580: aastore
    //   581: dup
    //   582: iconst_2
    //   583: aload 9
    //   585: invokevirtual 256	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
    //   588: invokestatic 262	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   591: aastore
    //   592: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   595: ldc 205
    //   597: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   13	571	9	localo1	com.tencent.mm.vfs.o
    //   47	373	10	localo2	com.tencent.mm.vfs.o
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
  
  private boolean bgY()
  {
    AppMethodBeat.i(126857);
    String str2 = this.jqq.getUser();
    if (ab.JF(str2))
    {
      Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn user:%s", new Object[] { bgZ(), str2 });
      AppMethodBeat.o(126857);
      return false;
    }
    if (!com.tencent.mm.pluginsdk.f.b.gmg())
    {
      Log.i("MicroMsg.NetSceneUploadVideo", "isAllow2UseCdnWithXLab = false");
      AppMethodBeat.o(126857);
      return false;
    }
    com.tencent.mm.an.f.baQ();
    if ((!com.tencent.mm.an.b.sS(2)) && (this.jqq.jss != 1))
    {
      localObject1 = bgZ();
      com.tencent.mm.an.f.baQ();
      Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { localObject1, Boolean.valueOf(com.tencent.mm.an.b.sS(2)), Integer.valueOf(this.jqq.jss) });
      AppMethodBeat.o(126857);
      return false;
    }
    this.iYT = com.tencent.mm.an.c.a("upvideo", this.jqq.createTime, str2, this.jqq.getFileName());
    if (Util.isNullOrNil(this.iYT))
    {
      Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra genClientId failed not use cdn file:%s", new Object[] { bgZ(), this.jqq.getFileName() });
      AppMethodBeat.o(126857);
      return false;
    }
    o.bhj();
    Object localObject1 = t.Qx(this.fileName);
    o.bhj();
    String str1 = t.Qw(this.fileName);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.taskName = "task_NetSceneUploadVideo_1";
    localg.gqy = this.iZc;
    localg.field_mediaId = this.iYT;
    localg.field_fullpath = str1;
    localg.field_thumbpath = Qf((String)localObject1);
    localg.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
    boolean bool1;
    label359:
    label379:
    Object localObject3;
    label428:
    Object localObject4;
    if (as.bjw(this.jqq.getUser()))
    {
      localg.field_sendmsg_viacdn = false;
      if ((as.bjw(this.jqq.getUser())) || (!this.iZk)) {
        break label806;
      }
      bool1 = true;
      localg.field_enable_hitcheck = bool1;
      if (!com.tencent.mm.modelcontrol.e.baZ().Oh(str1)) {
        break label812;
      }
      i = 1;
      localg.field_largesvideo = i;
      if ((this.jqq != null) && (3 == this.jqq.jsu)) {
        localg.field_smallVideoFlag = 1;
      }
      localObject1 = bgZ();
      if (this.jqq.jsx != null) {
        break label817;
      }
      bool1 = true;
      Log.i("MicroMsg.NetSceneUploadVideo", "%s upload video MMSightExtInfo is null? %b %s", new Object[] { localObject1, Boolean.valueOf(bool1), this.fileName });
      if ((this.jqq.jsx != null) && (this.jqq.jsx.Mrn))
      {
        Log.i("MicroMsg.NetSceneUploadVideo", "%s local capture video, mark use large video", new Object[] { bgZ() });
        com.tencent.mm.modelcontrol.e.baZ();
        localg.field_largesvideo = com.tencent.mm.modelcontrol.e.b(com.tencent.mm.modelcontrol.e.baZ().bba());
      }
      localObject1 = n.bhh();
      o.bhj();
      ((n)localObject1).a("", t.Qw(this.fileName), this.jqq.getUser(), "", "", 2, 2);
      localObject3 = bgZ();
      localObject4 = this.jqq.getFileName();
      if (this.jqq.jsw != null) {
        break label823;
      }
      localObject1 = "null";
      label586:
      Log.i("MicroMsg.NetSceneUploadVideo", "%s checkAD file:%s adinfo:%s", new Object[] { localObject3, localObject4, localObject1 });
      if ((this.jqq.jsw != null) && (!Util.isNullOrNil(this.jqq.jsw.izf))) {
        localg.field_advideoflag = 1;
      }
      localg.field_talker = str2;
      if (!ab.Eq(str2)) {
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
      localg.field_priority = com.tencent.mm.i.a.gpM;
      localg.field_needStorage = false;
      localg.field_isStreamMedia = false;
      localg.field_trysafecdn = true;
      this.jqT = ((int)com.tencent.mm.vfs.s.boW(localg.field_fullpath));
      this.jqS = ((int)com.tencent.mm.vfs.s.boW(localg.field_thumbpath));
      if (this.jqS < com.tencent.mm.i.a.gqi) {
        break label843;
      }
      Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { bgZ(), localg.field_thumbpath, Integer.valueOf(this.jqS) });
      AppMethodBeat.o(126857);
      return false;
      if (!z.bdv(str1)) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(106L, 30L, 1L, false);
      localg.field_use_multithread = true;
      break;
      bool1 = false;
      break label359;
      i = 0;
      break label379;
      bool1 = false;
      break label428;
      localObject1 = this.jqq.jsw.izf;
      break label586;
    }
    label843:
    localObject1 = XmlParser.parseXml(this.jqq.bhv(), "msg", null);
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
      this.jqR = true;
      localObject1 = com.tencent.mm.plugin.report.service.h.CyF;
      if (this.jqQ)
      {
        i = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject1).a(12696, new Object[] { Integer.valueOf(i + 700), Integer.valueOf(this.jqq.iKP) });
        if ((Util.isNullOrNil(localg.field_aesKey)) || (Util.isNullOrNil(localg.field_aesKey)))
        {
          localg.field_aesKey = "";
          localg.field_fileId = "";
        }
        Log.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn check hit cache VideoHash :%s %s %s %b %d", new Object[] { bgZ(), localg.field_mediaId, localg.field_fileId, localg.field_aesKey, Boolean.valueOf(this.iZk), Integer.valueOf(localg.field_largesvideo) });
        if (com.tencent.mm.an.f.baQ().f(localg)) {
          break label2967;
        }
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 226L, 1L, false);
        Log.e("MicroMsg.NetSceneUploadVideo", "%s cdntra addSendTask failed.", new Object[] { bgZ() });
        this.iYT = "";
        AppMethodBeat.o(126857);
        return false;
      }
    }
    else
    {
      Log.i("MicroMsg.NetSceneUploadVideo", "%s cdntra parse video recv xml failed", new Object[] { bgZ() });
      int n;
      int i1;
      Vector localVector2;
      for (;;)
      {
        try
        {
          str2 = Util.nullAsNil(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("UseVideoHash"));
          localObject1 = str2.split(",");
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAf();
          i = com.tencent.mm.b.i.ch(com.tencent.mm.kernel.a.getUin(), 100);
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
          localObject3 = o.bhj();
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
            this.jqQ = true;
          }
          Log.i("MicroMsg.NetSceneUploadVideo", "%s CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", new Object[] { bgZ(), Boolean.valueOf(CrashReportFactory.hasDebuger()), str2, Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(this.jqQ), localg.field_fileId, localg.field_aesKey });
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
        localObject2 = t.Qz(str1);
        if ((localObject2 == null) || (localObject2.length < 33))
        {
          Log.e("MicroMsg.VideoInfoStorage", "checkVideoHash  readHash failed :%s", new Object[] { str1 });
          localObject2 = "";
        }
        else
        {
          ((t)localObject3).iFy.execSQL("VideoHash", "delete from VideoHash where CreateTime < " + (Util.nowSecond() - 432000L));
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
          Cursor localCursor = ((t)localObject3).iFy.rawQuery("select size, CreateTime, hash, cdnxml, orgpath from VideoHash where size = ".concat(String.valueOf(n)), null);
          while (localCursor.moveToNext())
          {
            l2 = localCursor.getLong(1);
            String str3 = localCursor.getString(2);
            String str4 = localCursor.getString(3);
            String str5 = localCursor.getString(4);
            Log.v("MicroMsg.VideoInfoStorage", "checkVideoHash select [%s][%s]", new Object[] { str3, str4 });
            if ((Util.isNullOrNil(str3)) || (Util.isNullOrNil(str4)))
            {
              com.tencent.mm.plugin.report.service.h.CyF.a(12696, new Object[] { Integer.valueOf(104), Integer.valueOf(n) });
              Log.w("MicroMsg.VideoInfoStorage", "checkVideoHash select error [%s][%s]", new Object[] { str3, str4 });
            }
            else
            {
              if (i1 == str3.length()) {
                break label3056;
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(12696, new Object[] { Integer.valueOf(105), Integer.valueOf(n) });
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
            com.tencent.mm.plugin.report.service.h.CyF.a(12696, new Object[] { Integer.valueOf(201), Integer.valueOf(n) });
            Log.w("MicroMsg.VideoInfoStorage", "checkVideoHash cursor empty maxHitIndex:%d vector:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localVector1.size()) });
            localObject2 = "";
          }
          else
          {
            i1 = ((Integer)localVector1.get(i)).intValue();
            i2 = i1 * 100 / 256;
            if (i2 < 77)
            {
              com.tencent.mm.plugin.report.service.h.CyF.a(12696, new Object[] { Integer.valueOf(202), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(0), Integer.valueOf(localVector2.size()) });
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
              ((t)localObject3).iFy.execSQL("VideoHash", "delete from VideoHash where size = ".concat(String.valueOf(n)));
              com.tencent.mm.plugin.report.service.h.CyF.a(12696, new Object[] { Integer.valueOf(203), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(0), Integer.valueOf(localVector2.size()), Integer.valueOf(0), "", "", "", Integer.valueOf(j) });
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
      com.tencent.mm.plugin.report.service.h.CyF.a(12696, new Object[] { Integer.valueOf(300), localObject5 });
      com.tencent.mm.plugin.report.service.h.CyF.a(12696, new Object[] { Integer.valueOf(i2 + 3000), localObject5 });
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
        ThreadPool.post(new t.2((t)localObject3, str1, (String)localObject4, (String)localObject5), "checkVideoHashByteDiff", 1);
      }
      break label1367;
      boolean bool4 = false;
      continue;
      label2944:
      localObject2 = null;
      break label1385;
      if (this.jqR)
      {
        i = 2;
        break;
      }
      i = 0;
      break;
      label2967:
      if (this.jqq.jss != 1)
      {
        this.jqq.jss = 1;
        this.jqq.status = 104;
        this.jqq.clientId = this.iYT;
        this.jqq.cSx = 524544;
        u.f(this.jqq);
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
  
  private String bgZ()
  {
    AppMethodBeat.i(126865);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(126865);
    return str;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(126856);
    Log.i("MicroMsg.NetSceneUploadVideo", "%s stop %s", new Object[] { bgZ(), this.iYT });
    if (!Util.isNullOrNil(this.iYT)) {
      com.tencent.mm.an.f.baQ().Ob(this.iYT);
    }
    this.jqt = true;
    super.cancel();
    AppMethodBeat.o(126856);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(126859);
    this.callback = parami;
    this.jqq = u.QN(this.fileName);
    if ((this.jqq == null) || ((this.jqq.status != 104) && (this.jqq.status != 103)))
    {
      Log.e("MicroMsg.NetSceneUploadVideo", "%s Get info Failed file:", new Object[] { bgZ(), this.fileName });
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(126859);
      return -1;
    }
    parami = new StringBuilder("doscene file:").append(this.fileName).append(" stat:").append(this.jqq.status).append(" [").append(this.jqq.jsk).append(",").append(this.jqq.jsl).append("] [").append(this.jqq.jqP).append(",").append(this.jqq.iKP).append("]  netTimes:").append(this.jqq.jsp).append(" times:");
    int i = this.hjI;
    this.hjI = (i + 1);
    Log.d("MicroMsg.NetSceneUploadVideo", i);
    if (this.startTime == 0L)
    {
      this.startTime = Util.nowMilliSecond();
      this.jqP = this.jqq.jqP;
    }
    o.bhj();
    if (r.Qm(t.Qw(this.fileName)))
    {
      Log.w("MicroMsg.NetSceneUploadVideo", "%s it is mm h265 video xml[%s]", new Object[] { bgZ(), this.jqq.bhv() });
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 139L, 1L, false);
    }
    if (bgY())
    {
      Log.d("MicroMsg.NetSceneUploadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { this.fileName });
      AppMethodBeat.o(126859);
      return 0;
    }
    if (ab.JF(this.jqq.getUser()))
    {
      Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use parallel-upload user:%s", new Object[] { bgZ(), this.jqq.getUser() });
      i = 0;
    }
    label487:
    Object localObject2;
    while (i != 0)
    {
      Log.d("MicroMsg.NetSceneUploadVideo", "cdntra use parallel-upload return -1 for onGYNetEnd clientid:%s", new Object[] { this.fileName });
      AppMethodBeat.o(126859);
      return 0;
      if (1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smh, 0)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label487;
        }
        Log.i("MicroMsg.NetSceneUploadVideo", "NOT ALLOW USE PARALLEL UPLOAD VIDEO");
        i = 0;
        break;
      }
      o.bhj();
      localObject1 = t.Qx(this.fileName);
      o.bhj();
      parami = t.Qw(this.fileName);
      localObject1 = Qf((String)localObject1);
      localObject2 = new com.tencent.mm.pluginsdk.f.d();
      ((com.tencent.mm.pluginsdk.f.d)localObject2).iXv = this.jqq.jso;
      ((com.tencent.mm.pluginsdk.f.d)localObject2).JTT = this.iZw;
      ((com.tencent.mm.pluginsdk.f.d)localObject2).scene = 2;
      ((com.tencent.mm.pluginsdk.f.d)localObject2).fileType = 4;
      ((com.tencent.mm.pluginsdk.f.d)localObject2).thumbPath = ((String)localObject1);
      ((com.tencent.mm.pluginsdk.f.d)localObject2).fullPath = parami;
      new com.tencent.mm.pluginsdk.f.c().a((com.tencent.mm.pluginsdk.f.d)localObject2);
      Log.i("MicroMsg.NetSceneUploadVideo", "use ParallelUploader, filename:%s", new Object[] { this.fileName });
      i = 1;
    }
    if (this.jqq.jsr == 1)
    {
      this.dwS = true;
      parami = new com.tencent.mm.ak.d.a();
      parami.iLN = new eoc();
      parami.iLO = new eod();
      parami.uri = "/cgi-bin/micromsg-bin/uploadvideo";
      parami.funcId = 149;
      parami.iLP = 39;
      parami.respCmdId = 1000000039;
      this.rr = parami.aXF();
      localObject2 = (eoc)this.rr.iLK.iLR;
      ((eoc)localObject2).xNH = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(2, ""));
      ((eoc)localObject2).xNG = this.jqq.getUser();
      ((eoc)localObject2).KIz = this.fileName;
      if (this.dwS) {
        ((eoc)localObject2).KTf = 2;
      }
      if (this.jqq.jsu == 3) {
        ((eoc)localObject2).KTf = 3;
      }
      ((eoc)localObject2).MXo = this.jqq.iFw;
      ((eoc)localObject2).MrT = this.jqq.jsl;
      ((eoc)localObject2).NlP = this.jqq.iKP;
      if (!ag.dm(MMApplicationContext.getContext())) {
        break label1546;
      }
      i = 1;
      label830:
      ((eoc)localObject2).LrC = i;
      ((eoc)localObject2).MrW = 2;
      ((eoc)localObject2).NlQ = 0;
      ((eoc)localObject2).NlR = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      ((eoc)localObject2).MrV = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      if (!Util.isNullOrNil(this.ebj)) {
        break label1551;
      }
      o.bhj();
      parami = com.tencent.mm.vfs.s.bhK(t.Qw(this.fileName));
      this.ebj = parami;
      label914:
      ((eoc)localObject2).NlU = parami;
      if (Util.isNullOrNil(this.jqq.jsz)) {
        break label1559;
      }
      parami = br.KC(this.jqq.jsz);
      label944:
      localObject1 = parami;
      if (Util.isNullOrNil(parami)) {
        localObject1 = br.ajw();
      }
      Log.i("MicroMsg.NetSceneUploadVideo", "video msg source is %s".concat(String.valueOf(localObject1)));
      ((eoc)localObject2).KHq = ((String)localObject1);
      ((eoc)localObject2).Nmd = this.jqq.ean;
      parami = this.jqq.jsw;
      if ((parami == null) || (Util.isNullOrNil(parami.iyZ))) {
        break label1636;
      }
      ((eoc)localObject2).NlV = Util.nullAs(parami.iyZ, "");
      ((eoc)localObject2).NlW = parami.LxJ;
      ((eoc)localObject2).NlX = Util.nullAs(parami.izb, "");
      ((eoc)localObject2).NlZ = Util.nullAs(parami.izd, "");
      ((eoc)localObject2).NlY = Util.nullAs(parami.izc, "");
      ((eoc)localObject2).Nma = Util.nullAs(parami.ize, "");
    }
    for (;;)
    {
      if (((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(this.jqq.getUser())) {
        ((eoc)localObject2).LbN = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().bjT(this.jqq.getUser());
      }
      if (parami != null)
      {
        ((eoc)localObject2).Nmc = Util.nullAs(parami.izf, "");
        ((eoc)localObject2).Nmb = Util.nullAs(parami.izg, "");
      }
      Log.d("MicroMsg.NetSceneUploadVideo", "upload video: play length %d, thumb totalLen %d, video totalLen %d, funcFlag %d, videoMd5: %s stream %s streamtime: %d title %s thumburl %s", new Object[] { Integer.valueOf(((eoc)localObject2).MXo), Integer.valueOf(((eoc)localObject2).MrU), Integer.valueOf(((eoc)localObject2).NlP), Integer.valueOf(((eoc)localObject2).KTf), ((eoc)localObject2).NlU, ((eoc)localObject2).NlV, Integer.valueOf(((eoc)localObject2).NlW), ((eoc)localObject2).NlX, ((eoc)localObject2).Nma });
      if (this.jqq.status != 103) {
        break label1929;
      }
      o.bhj();
      parami = t.t(t.Qx(this.fileName), this.jqq.jsk, jqN);
      if ((parami.ret >= 0) && (parami.dAc != 0)) {
        break label1681;
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 225L, 1L, false);
      u.QE(this.fileName);
      Log.e("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "]  Error ");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(126859);
      return -1;
      if (this.jqq.createTime + 600L < Util.nowSecond())
      {
        Log.e("MicroMsg.NetSceneUploadVideo", "create time check error:" + this.fileName);
        u.QE(this.fileName);
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        AppMethodBeat.o(126859);
        return -1;
      }
      if (u.QD(this.fileName)) {
        break;
      }
      Log.e("MicroMsg.NetSceneUploadVideo", "checkVoiceNetTimes Failed file:" + this.fileName);
      u.QE(this.fileName);
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(126859);
      return -1;
      label1546:
      i = 2;
      break label830;
      label1551:
      parami = this.ebj;
      break label914;
      label1559:
      if (this.jqq.jsy > 0)
      {
        parami = br.KC(br.KB(((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(this.jqq.jsy).fqK));
        break label944;
      }
      parami = com.tencent.mm.vfs.s.bhK(this.jqq.bhu());
      localObject1 = v.jNy;
      parami = br.KC(v.Ss(parami));
      break label944;
      label1636:
      if ((parami != null) && (!Util.isNullOrNil(parami.izd)) && (!Util.isNullOrNil(parami.izc)))
      {
        ((eoc)localObject2).NlZ = parami.izd;
        ((eoc)localObject2).NlY = parami.izc;
      }
    }
    label1681:
    Log.d("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "] read ret:" + parami.ret + " readlen:" + parami.dAc + " newOff:" + parami.jsR + " netOff:" + this.jqq.jsk);
    if (parami.jsR < this.jqq.jsk)
    {
      Log.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ THUMB[" + this.fileName + "] newOff:" + parami.jsR + " OldtOff:" + this.jqq.jsk);
      u.QE(this.fileName);
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(126859);
      return -1;
    }
    Object localObject1 = new byte[parami.dAc];
    System.arraycopy(parami.buf, 0, localObject1, 0, parami.dAc);
    ((eoc)localObject2).MrU = this.jqq.jsk;
    ((eoc)localObject2).MrV = new SKBuiltinBuffer_t().setBuffer((byte[])localObject1);
    for (;;)
    {
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(126859);
      return i;
      label1929:
      o.bhj();
      parami = t.t(t.Qw(this.fileName), this.jqq.jqP, jqN);
      if ((parami.ret < 0) || (parami.dAc == 0))
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 224L, 1L, false);
        u.QE(this.fileName);
        Log.e("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "]  Error ");
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        AppMethodBeat.o(126859);
        return -1;
      }
      Log.d("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "] read ret:" + parami.ret + " readlen:" + parami.dAc + " newOff:" + parami.jsR + " netOff:" + this.jqq.jqP);
      if (parami.jsR < this.jqq.jqP)
      {
        Log.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] newOff:" + parami.jsR + " OldtOff:" + this.jqq.jqP);
        u.QE(this.fileName);
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        AppMethodBeat.o(126859);
        return -1;
      }
      if (parami.jsR >= c.jpN)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 222L, 1L, false);
        Log.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] maxsize:" + c.jpN);
        u.QE(this.fileName);
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        AppMethodBeat.o(126859);
        return -1;
      }
      localObject1 = new byte[parami.dAc];
      System.arraycopy(parami.buf, 0, localObject1, 0, parami.dAc);
      ((eoc)localObject2).NlQ = this.jqq.jqP;
      ((eoc)localObject2).MrU = this.jqq.jsk;
      ((eoc)localObject2).NlR = new SKBuiltinBuffer_t().setBuffer((byte[])localObject1);
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
    Log.i("MicroMsg.NetSceneUploadVideo", "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.iYT);
    if (this.jqt)
    {
      Log.d("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Call Stop by Service   file:" + this.fileName + " user:" + this.jqq.getUser());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    paramArrayOfByte = (eod)((com.tencent.mm.ak.d)params).iLL.iLR;
    params = (eoc)((com.tencent.mm.ak.d)params).iLK.iLR;
    if ((paramArrayOfByte != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(paramArrayOfByte.LbO);
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!Util.isNullOrNil(this.iYT)))
    {
      Log.w("MicroMsg.NetSceneUploadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.iYT });
      AppMethodBeat.o(126863);
      return;
    }
    this.jqq = u.QN(this.fileName);
    if (this.jqq == null)
    {
      Log.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if (this.jqq.status == 105)
    {
      Log.w("MicroMsg.NetSceneUploadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((this.jqq.status != 104) && (this.jqq.status != 103))
    {
      Log.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.jqq.status + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      Log.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd BLACK  errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.jqq.getUser());
      u.QF(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 220L, 1L, false);
      Log.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.jqq.getUser());
      u.QE(this.fileName);
      com.tencent.mm.plugin.report.service.h.CyF.a(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(this.jqs), Integer.valueOf(0) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 219L, 1L, false);
      Log.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.jqq.getUser());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((!Util.isNullOrNil(params.MrV.getBuffer().zy)) && (params.MrU != paramArrayOfByte.MrU - params.MrV.getILen()))
    {
      Log.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + params.MrU + "," + params.MrV.getILen() + "," + paramArrayOfByte.MrU + "] file:" + this.fileName + " user:" + params.xNG);
      u.QE(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((!Util.isNullOrNil(params.NlR.getBuffer().zy)) && (params.NlQ != paramArrayOfByte.NlQ - params.NlR.getILen()))
    {
      Log.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + params.NlQ + "," + params.NlR.getILen() + "," + paramArrayOfByte.NlQ + "] file:" + this.fileName + " user:" + params.xNG);
      u.QE(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    this.jqq.jsm = Util.nowSecond();
    this.jqq.dTS = paramArrayOfByte.Brn;
    this.jqq.cSx = 1028;
    Log.d("MicroMsg.NetSceneUploadVideo", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(this.jqq.dTS), Integer.valueOf(ac.jOD) });
    if ((10007 == ac.jOC) && (ac.jOD != 0) && (this.jqq.dTS != 0L))
    {
      this.jqq.dTS = ac.jOD;
      ac.jOD = 0;
    }
    paramInt1 = this.jqq.status;
    s locals;
    if (paramInt1 == 103)
    {
      locals = this.jqq;
      paramInt1 = params.MrU;
      locals.jsk = (params.MrV.getILen() + paramInt1);
      this.jqq.cSx |= 0x40;
      if (this.jqq.jsk < this.jqq.jsl) {
        break label2366;
      }
      this.jqq.status = 104;
      this.jqq.cSx |= 0x100;
      paramInt1 = 0;
    }
    for (;;)
    {
      u.f(this.jqq);
      if (this.jqt)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(126863);
        return;
        if (paramInt1 == 104)
        {
          locals = this.jqq;
          paramInt1 = params.NlQ;
          locals.jqP = (params.NlR.getILen() + paramInt1);
          this.jqq.cSx |= 0x8;
          if (this.jqq.jqP >= this.jqq.iKP)
          {
            this.jqq.status = 199;
            this.jqq.cSx |= 0x100;
            u.d(this.jqq);
            paramInt1 = 1;
          }
        }
        else
        {
          Log.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd ERROR STATUS:" + paramInt1 + " file:" + this.fileName + " user:" + params.xNG);
          u.QE(this.fileName);
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(126863);
        }
      }
      else
      {
        if (paramInt1 == 0)
        {
          this.iKj.startTimer(10L);
          AppMethodBeat.o(126863);
          return;
        }
        params = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(this.jqq.jso);
        params.BB(paramArrayOfByte.KHq);
        ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(params.field_msgId, params);
        com.tencent.mm.modelstat.b.jmd.s(params);
        com.tencent.mm.plugin.report.service.h.CyF.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(this.jqs), Integer.valueOf(this.jqq.iKP - this.jqP) });
        boolean bool;
        if (this.jqq == null)
        {
          bool = false;
          if ((!bool) && (!ab.Jf(this.jqq.getUser()))) {
            break label2272;
          }
          Log.i("MicroMsg.NetSceneUploadVideo", "upload to biz :%s", new Object[] { this.jqq.getUser() });
          if (this.jqq.dTS < 0L)
          {
            Log.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.jqq.dTS + " file:" + this.fileName + " toUser:" + this.jqq.getUser());
            u.QE(this.fileName);
          }
          label2005:
          if (this.hvh == null) {
            break label2360;
          }
        }
        label2360:
        for (long l = this.hvh.apr();; l = 0L)
        {
          Log.d("MicroMsg.NetSceneUploadVideo", "!!!FIN: file:" + this.fileName + " toUser:" + this.jqq.getUser() + " msgsvrid:" + this.jqq.dTS + " thumbsize:" + this.jqq.jsl + " videosize:" + this.jqq.iKP + " useTime:" + l);
          Log.d("MicroMsg.NetSceneUploadVideo", "FinishLogForTime file:" + this.fileName + " packSize:" + jqN + " filesize:" + this.jqq.iKP + " useTime:" + l);
          a.a(this.jqq, 0);
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(126863);
          return;
          params = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(this.jqq.getUser());
          if ((params == null) || ((int)params.gMZ <= 0))
          {
            bool = false;
            break;
          }
          bool = params.gBM();
          break;
          label2272:
          Log.i("MicroMsg.NetSceneUploadVideo", "not upload to biz");
          if (this.jqq.dTS > 0L) {
            break label2005;
          }
          Log.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.jqq.dTS + " file:" + this.fileName + " toUser:" + this.jqq.getUser());
          u.QE(this.fileName);
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
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 210L, 1L, false);
    }
    AppMethodBeat.o(126862);
    return bool;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(126860);
    params = (eoc)((com.tencent.mm.ak.d)params).iLK.iLR;
    if ((Util.isNullOrNil(params.KIz)) || (params.MrW <= 0) || (Util.isNullOrNil(params.xNH)) || (Util.isNullOrNil(params.xNG)) || (params.LrC <= 0) || (params.MrU > params.MrT) || (params.MrU < 0) || (params.NlQ > params.NlP) || (params.NlQ < 0) || ((params.NlQ == params.NlP) && (params.MrU == params.MrT)) || (params.MrT <= 0) || (params.NlP <= 0) || ((params.NlR.getILen() <= 0) && (params.MrV.getILen() <= 0)))
    {
      Log.e("MicroMsg.NetSceneUploadVideo", "ERR: Security Check Failed file:" + this.fileName + " user:" + params.xNG);
      params = q.b.iMr;
      AppMethodBeat.o(126860);
      return params;
    }
    params = q.b.iMq;
    AppMethodBeat.o(126860);
    return params;
  }
  
  public final void setSecurityCheckError(q.a parama)
  {
    AppMethodBeat.i(126861);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 221L, 1L, false);
    u.QE(this.fileName);
    AppMethodBeat.o(126861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.g
 * JD-Core Version:    0.7.0.1
 */