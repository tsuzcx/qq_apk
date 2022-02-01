package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.modelimage.t;
import com.tencent.mm.modelmulti.t.b;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.network.ah;
import com.tencent.mm.network.m;
import com.tencent.mm.pluginsdk.g.d.a;
import com.tencent.mm.pluginsdk.model.af;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.fjp;
import com.tencent.mm.protocal.protobuf.fud;
import com.tencent.mm.protocal.protobuf.fue;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import junit.framework.Assert;

public final class k
  extends p
  implements m
{
  private static int oZk = 32000;
  private final int MAX_TIMES;
  private com.tencent.mm.am.h callback;
  public String fileName;
  boolean htN;
  private String ibd;
  f.a mHw;
  private String oHX;
  private d.a oIA;
  private boolean oIo;
  public z oYN;
  private int oYP;
  private boolean oYQ;
  private final long oZl;
  private int oZm;
  private boolean oZn;
  private boolean oZo;
  private int oZp;
  private int oZq;
  private d.a oZr;
  private com.tencent.mm.g.g.a oZs;
  int oZt;
  MTimerHandler orP;
  private com.tencent.mm.g.g.a osH;
  int retCode;
  private com.tencent.mm.am.c rr;
  private long startTime;
  
  public k(String paramString)
  {
    AppMethodBeat.i(126858);
    this.ibd = "";
    this.oZl = 1800000L;
    this.retCode = 0;
    this.oYQ = false;
    this.htN = false;
    this.mHw = null;
    this.oIo = true;
    this.oHX = "";
    this.startTime = 0L;
    this.oZm = -1;
    this.oYP = com.tencent.mm.g.a.MediaType_VIDEO;
    this.oZn = false;
    this.oZo = false;
    this.oZp = 0;
    this.oZq = 0;
    this.oZr = new d.a()
    {
      public final void T(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(241214);
        Log.e("MicroMsg.NetSceneUploadVideo", "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        ab.Qf(k.a(k.this));
        k.h(k.this).onSceneEnd(3, paramAnonymousInt, "", k.this);
        AppMethodBeat.o(241214);
      }
      
      public final void a(final com.tencent.mm.pluginsdk.g.g.a paramAnonymousa)
      {
        AppMethodBeat.i(241210);
        Log.i("MicroMsg.NetSceneUploadVideo", "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.aesKey, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.fileLength) });
        com.tencent.mm.g.d locald = new com.tencent.mm.g.d();
        locald.field_aesKey = paramAnonymousa.aesKey;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.vyS;
        locald.field_fileLength = paramAnonymousa.fileLength;
        v.bOh();
        paramAnonymousa = aa.PY(k.a(k.this));
        locald.field_thumbimgLength = ((int)com.tencent.mm.vfs.y.bEl(k.a(k.this, paramAnonymousa)));
        locald.field_toUser = k.b(k.this).bOs();
        com.tencent.threadpool.h.ahAA.bm(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(241253);
            if (!k.a(k.this, paramAnonymousa).equals(paramAnonymousa))
            {
              com.tencent.mm.vfs.y.deleteFile(k.a(k.this, paramAnonymousa));
              Log.i("MicroMsg.NetSceneUploadVideo", "delete thumbPath %s", new Object[] { paramAnonymousa });
            }
            AppMethodBeat.o(241253);
          }
        });
        com.tencent.mm.kernel.h.aZW().a(new n(k.a(k.this), k.c(k.this), locald, new com.tencent.mm.modelimage.g()
        {
          public final void eF(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(241257);
            if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == 102))
            {
              com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(241198);
                  k.d(k.this);
                  k.b(k.this).status = 104;
                  k.b(k.this).createTime = Util.nowSecond();
                  k.b(k.this).pba = Util.nowSecond();
                  k.b(k.this).oZm = 0;
                  k.b(k.this).eQp = 1800;
                  boolean bool = ab.f(k.b(k.this));
                  Log.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { k.e(k.this), Boolean.valueOf(k.f(k.this)), Boolean.valueOf(bool), Long.valueOf(k.b(k.this).createTime) });
                  k.this.doScene(k.g(k.this), k.h(k.this));
                  AppMethodBeat.o(241198);
                }
              });
              AppMethodBeat.o(241257);
              return;
            }
            k.h(k.this).onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", k.this);
            AppMethodBeat.o(241257);
          }
        }), 0);
        AppMethodBeat.o(241210);
      }
      
      public final void b(float paramAnonymousFloat, long paramAnonymousLong) {}
    };
    this.oZs = new com.tencent.mm.g.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, final com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(241217);
        Log.d("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { k.e(k.this), paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          Log.d("MicroMsg.NetSceneUploadVideo", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(241217);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ab.Qf(k.a(k.this));
          paramAnonymousString = com.tencent.mm.cb.d.acls;
          com.tencent.mm.cb.d.a(null, k.a(k.this), 3, 0L, 0L, 0L, 0L, false, paramAnonymousInt);
          k.h(k.this).onSceneEnd(3, paramAnonymousInt, "", k.this);
          AppMethodBeat.o(241217);
          return 0;
        }
        k.a(k.this, ab.Qo(k.a(k.this)));
        if ((k.b(k.this) == null) || (k.b(k.this).status == 105))
        {
          int i;
          if (k.b(k.this) == null)
          {
            i = -1;
            Log.i("MicroMsg.NetSceneUploadVideo", "%s info is null or has paused, status:%d", new Object[] { k.e(k.this), Integer.valueOf(i) });
            com.tencent.mm.modelcdntran.k.bHW().Ny(k.i(k.this));
            if (k.b(k.this) == null) {
              break label312;
            }
            paramAnonymousString = com.tencent.mm.cb.d.acls;
            com.tencent.mm.cb.d.btM(k.a(k.this));
          }
          for (;;)
          {
            k.h(k.this).onSceneEnd(3, paramAnonymousInt, "info is null or has paused, status".concat(String.valueOf(i)), k.this);
            AppMethodBeat.o(241217);
            return 0;
            i = k.b(k.this).status;
            break;
            label312:
            paramAnonymousString = com.tencent.mm.cb.d.acls;
            com.tencent.mm.cb.d.a(null, k.a(k.this), 5, 0L, 0L, 0L, 0L, false, paramAnonymousInt);
          }
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label466;
          }
          Log.e("MicroMsg.NetSceneUploadVideo", "%s cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { k.e(k.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo });
          ab.Qf(k.a(k.this));
          paramAnonymousString = com.tencent.mm.cb.d.acls;
          com.tencent.mm.cb.d.a(null, k.a(k.this), 3, 0L, 0L, 0L, 0L, false, paramAnonymousd.field_retCode);
          k.h(k.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", k.this);
        }
        for (;;)
        {
          AppMethodBeat.o(241217);
          return 0;
          label466:
          paramAnonymousString = t.bKi();
          paramAnonymousString.fileName = k.a(k.this);
          paramAnonymousString.oJI = 0;
          paramAnonymousString.oJJ = paramAnonymousd;
          paramAnonymousString.enableHitCheck = k.f(k.this);
          paramAnonymousString.oJK = new com.tencent.mm.modelimage.g()
          {
            public final void eF(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(241222);
              if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == 102))
              {
                com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(241186);
                    k.d(k.this);
                    k.b(k.this).status = 104;
                    k.b(k.this).createTime = Util.nowSecond();
                    k.b(k.this).pba = Util.nowSecond();
                    k.b(k.this).oZm = 0;
                    k.b(k.this).eQp = 1800;
                    boolean bool = ab.f(k.b(k.this));
                    Log.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { k.e(k.this), Boolean.valueOf(k.f(k.this)), Boolean.valueOf(bool), Long.valueOf(k.b(k.this).createTime) });
                    k.this.doScene(k.j(k.this), k.h(k.this));
                    AppMethodBeat.o(241186);
                  }
                });
                AppMethodBeat.o(241222);
                return;
              }
              a.a(k.b(k.this), 0);
              k.a(k.this, paramAnonymousd);
              k.a(k.this, ab.Qo(k.a(k.this)));
              if ((k.b(k.this) != null) && (k.b(k.this).status == 105)) {
                k.a(k.this, 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
              }
              k.h(k.this).onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", k.this);
              AppMethodBeat.o(241222);
            }
          };
          paramAnonymousString.oNj = 20;
          paramAnonymousString.bKW().aXz();
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    this.oIA = new d.a()
    {
      public final void T(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(241227);
        Log.e("MicroMsg.NetSceneUploadVideo", "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        ab.Qf(k.a(k.this));
        k.h(k.this).onSceneEnd(3, paramAnonymousInt, "", k.this);
        AppMethodBeat.o(241227);
      }
      
      public final void a(final com.tencent.mm.pluginsdk.g.g.a paramAnonymousa)
      {
        AppMethodBeat.i(241223);
        Log.i("MicroMsg.NetSceneUploadVideo", "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.aesKey, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.fileLength) });
        Util.nowMilliSecond();
        k.k(k.this);
        com.tencent.mm.g.d locald = new com.tencent.mm.g.d();
        locald.field_aesKey = paramAnonymousa.aesKey;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.vyS;
        locald.field_fileLength = paramAnonymousa.fileLength;
        v.bOh();
        paramAnonymousa = aa.PX(k.a(k.this));
        v.bOh();
        Object localObject = aa.PY(k.a(k.this));
        locald.field_thumbimgLength = ((int)com.tencent.mm.vfs.y.bEl(k.a(k.this, (String)localObject)));
        com.tencent.mm.modelcdntran.k.bHX();
        locald.field_filecrc = com.tencent.mm.modelcdntran.d.Nt(paramAnonymousa);
        locald.field_toUser = k.b(k.this).bOs();
        com.tencent.threadpool.h.ahAA.bm(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(241234);
            if (!k.a(k.this, this.oHA).equals(this.oHA))
            {
              com.tencent.mm.vfs.y.deleteFile(k.a(k.this, this.oHA));
              Log.i("MicroMsg.NetSceneUploadVideo", "delete thumbPath %s", new Object[] { this.oHA });
            }
            AppMethodBeat.o(241234);
          }
        });
        paramAnonymousa = ab.Qo(k.a(k.this));
        if (Util.isNullOrNil(paramAnonymousa.bOu()))
        {
          localObject = "<msg><videomsg aeskey=\"" + locald.field_aesKey + "\" cdnthumbaeskey=\"" + locald.field_aesKey + "\" cdnvideourl=\"" + locald.field_fileId + "\" ";
          localObject = (String)localObject + "cdnthumburl=\"" + locald.field_fileId + "\" ";
          localObject = (String)localObject + "length=\"" + locald.field_fileLength + "\" ";
          localObject = (String)localObject + "cdnthumblength=\"" + locald.field_thumbimgLength + "\"/>";
          localObject = (String)localObject + Util.nullAs(paramAnonymousa.pbo, "");
          localObject = (String)localObject + "</msg>";
          Log.i("MicroMsg.NetSceneUploadVideo", "%s cdn callback new build cdnInfo:%s", new Object[] { k.e(k.this), localObject });
          paramAnonymousa.pbh = ((String)localObject);
          ab.f(paramAnonymousa);
        }
        localObject = XmlParser.parseXml(paramAnonymousa.bOu(), "msg", null);
        if (localObject != null)
        {
          aa localaa = v.bOh();
          v.bOh();
          localaa.x(aa.PX(k.a(k.this)), (String)((Map)localObject).get(".msg.videomsg.$cdnvideourl"), (String)((Map)localObject).get(".msg.videomsg.$aeskey"));
        }
        com.tencent.mm.kernel.h.aZW().a(new l(k.a(k.this), k.c(k.this), locald, new com.tencent.mm.modelimage.g()
        {
          public final void eF(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(241239);
            if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == 102))
            {
              com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(241180);
                  k.d(k.this);
                  k.3.2.this.oZA.status = 104;
                  k.3.2.this.oZA.createTime = Util.nowSecond();
                  k.3.2.this.oZA.pba = Util.nowSecond();
                  k.3.2.this.oZA.oZm = 0;
                  k.3.2.this.oZA.eQp = 1800;
                  boolean bool = ab.f(k.3.2.this.oZA);
                  Log.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { k.e(k.this), Boolean.valueOf(k.f(k.this)), Boolean.valueOf(bool), Long.valueOf(k.3.2.this.oZA.createTime) });
                  k.this.doScene(k.l(k.this), k.h(k.this));
                  AppMethodBeat.o(241180);
                }
              });
              AppMethodBeat.o(241239);
              return;
            }
            k.h(k.this).onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", k.this);
            AppMethodBeat.o(241239);
          }
        }), 0);
        AppMethodBeat.o(241223);
      }
      
      public final void b(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(241229);
        z localz = ab.Qo(k.a(k.this));
        if (localz == null)
        {
          Log.e("MicroMsg.NetSceneUploadVideo", "%s info is null", new Object[] { k.e(k.this) });
          AppMethodBeat.o(241229);
          return;
        }
        if (localz.oZm > paramAnonymousLong)
        {
          Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnEndProc error oldpos:%d newpos:%d", new Object[] { k.e(k.this), Integer.valueOf(localz.oZm), Long.valueOf(paramAnonymousLong) });
          AppMethodBeat.o(241229);
          return;
        }
        localz.pba = Util.nowSecond();
        localz.oZm = ((int)paramAnonymousLong);
        localz.eQp = 1032;
        ab.f(localz);
        AppMethodBeat.o(241229);
      }
    };
    this.osH = new com.tencent.mm.g.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, final com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(241212);
        Log.d("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { k.e(k.this), k.i(k.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          Log.d("MicroMsg.NetSceneUploadVideo", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { k.i(k.this) });
          AppMethodBeat.o(241212);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ab.Qf(k.a(k.this));
          k.h(k.this).onSceneEnd(3, paramAnonymousInt, "", k.this);
          AppMethodBeat.o(241212);
          return 0;
        }
        k.a(k.this, ab.Qo(k.a(k.this)));
        if ((k.b(k.this) == null) || (k.b(k.this).status == 105))
        {
          if (k.b(k.this) == null) {}
          for (int i = -1;; i = k.b(k.this).status)
          {
            Log.i("MicroMsg.NetSceneUploadVideo", "%s info is null or has paused, status:%d", new Object[] { k.e(k.this), Integer.valueOf(i) });
            com.tencent.mm.modelcdntran.k.bHW().Ny(k.i(k.this));
            k.h(k.this).onSceneEnd(3, paramAnonymousInt, "info is null or has paused, status".concat(String.valueOf(i)), k.this);
            AppMethodBeat.o(241212);
            return 0;
          }
        }
        if (paramAnonymousc != null)
        {
          if (k.b(k.this).oZm > paramAnonymousc.field_finishedLength)
          {
            Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnEndProc error oldpos:%d newpos:%d", new Object[] { k.e(k.this), Integer.valueOf(k.b(k.this).oZm), Long.valueOf(paramAnonymousc.field_finishedLength) });
            AppMethodBeat.o(241212);
            return 0;
          }
          k.b(k.this).pba = Util.nowSecond();
          k.b(k.this).oZm = ((int)paramAnonymousc.field_finishedLength);
          k.b(k.this).eQp = 1032;
          ab.f(k.b(k.this));
          AppMethodBeat.o(241212);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode != 0)
          {
            Log.e("MicroMsg.NetSceneUploadVideo", "%s cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { k.e(k.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo });
            ab.Qf(k.a(k.this));
            k.h(k.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", k.this);
          }
        }
        else
        {
          AppMethodBeat.o(241212);
          return 0;
        }
        Log.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn uploadvideo by cdn, videohash isHitCacheUpload: %d, enableHitcheck:%b", new Object[] { k.e(k.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(k.f(k.this)) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.OAn;
        if (k.m(k.this))
        {
          paramAnonymousInt = 810;
          label580:
          paramAnonymousString.b(12696, new Object[] { Integer.valueOf(paramAnonymousInt + paramAnonymousd.field_UploadHitCacheType), Integer.valueOf(k.b(k.this).osy) });
          paramAnonymousBoolean = paramAnonymousd.field_isVideoReduced;
          Log.i("MicroMsg.NetSceneUploadVideo", "%s it video was reduced by cdn %b %s", new Object[] { k.e(k.this), Boolean.valueOf(paramAnonymousBoolean), k.a(k.this) });
          if (paramAnonymousBoolean) {
            break label1407;
          }
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 205L, 1L, false);
          if ((k.o(k.this) > 0) && (paramAnonymousd.field_thumbimgLength > 0))
          {
            Log.i("MicroMsg.NetSceneUploadVideo", "%s send video thumb too big thumb length [%d, %d] ", new Object[] { k.e(k.this), Integer.valueOf(k.o(k.this)), Integer.valueOf(paramAnonymousd.field_thumbimgLength) });
            if (k.o(k.this) * 2 <= paramAnonymousd.field_thumbimgLength) {
              break label1373;
            }
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 206L, 1L, false);
          }
          label779:
          v.bOh();
          paramAnonymousInt = (int)com.tencent.mm.vfs.y.bEl(aa.PX(k.a(k.this)));
          Log.i("MicroMsg.NetSceneUploadVideo", "%s send video too big thumb length [%d, %d] ", new Object[] { k.e(k.this), Integer.valueOf(k.b(k.this).osy), Integer.valueOf(paramAnonymousInt) });
          if (k.b(k.this).osy == paramAnonymousInt) {
            break label1390;
          }
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 208L, 1L, false);
          label870:
          k.a(k.this, ab.Qo(k.a(k.this)));
          if (Util.isNullOrNil(k.b(k.this).bOu()))
          {
            paramAnonymousString = "<msg><videomsg aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnvideourl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "length=\"" + paramAnonymousd.field_fileLength + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\"/>";
            paramAnonymousString = paramAnonymousString + Util.nullAs(k.b(k.this).pbo, "");
            paramAnonymousString = paramAnonymousString + "</msg>";
            Log.i("MicroMsg.NetSceneUploadVideo", "%s cdn callback new build cdnInfo:%s", new Object[] { k.e(k.this), paramAnonymousString });
            k.b(k.this).pbh = paramAnonymousString;
            ab.f(k.b(k.this));
          }
          paramAnonymousString = XmlParser.parseXml(k.b(k.this).bOu(), "msg", null);
          if (paramAnonymousString != null)
          {
            paramAnonymousc = v.bOh();
            v.bOh();
            boolean bool = paramAnonymousc.x(aa.PX(k.a(k.this)), (String)paramAnonymousString.get(".msg.videomsg.$cdnvideourl"), (String)paramAnonymousString.get(".msg.videomsg.$aeskey"));
            paramAnonymousString = com.tencent.mm.plugin.report.service.h.OAn;
            if (!bool) {
              break label1424;
            }
            paramAnonymousInt = 1;
            label1248:
            paramAnonymousString.b(12696, new Object[] { Integer.valueOf(paramAnonymousInt + 900), Integer.valueOf(k.b(k.this).osy) });
          }
          paramAnonymousString = t.bKi();
          paramAnonymousString.fileName = k.a(k.this);
          if (!paramAnonymousBoolean) {
            break label1429;
          }
        }
        label1424:
        label1429:
        for (paramAnonymousInt = 0;; paramAnonymousInt = k.c(k.this))
        {
          paramAnonymousString.oJI = paramAnonymousInt;
          paramAnonymousString.oJJ = paramAnonymousd;
          paramAnonymousString.oJK = new com.tencent.mm.modelimage.g()
          {
            public final void eF(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(241188);
              if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == 102))
              {
                com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(241197);
                    k.d(k.this);
                    k.b(k.this).status = 104;
                    k.b(k.this).createTime = Util.nowSecond();
                    k.b(k.this).pba = Util.nowSecond();
                    k.b(k.this).oZm = 0;
                    k.b(k.this).eQp = 1800;
                    boolean bool = ab.f(k.b(k.this));
                    Log.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { k.e(k.this), Boolean.valueOf(k.f(k.this)), Boolean.valueOf(bool), Long.valueOf(k.b(k.this).createTime) });
                    k.this.doScene(k.p(k.this), k.h(k.this));
                    AppMethodBeat.o(241197);
                  }
                });
                AppMethodBeat.o(241188);
                return;
              }
              a.a(k.b(k.this), 0);
              k.a(k.this, paramAnonymousd);
              k.h(k.this).onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", k.this);
              AppMethodBeat.o(241188);
            }
          };
          paramAnonymousString.oNj = 4;
          paramAnonymousString.bKW().aXz();
          break;
          if (k.n(k.this))
          {
            paramAnonymousInt = 820;
            break label580;
          }
          paramAnonymousInt = 830;
          break label580;
          label1373:
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 207L, 1L, false);
          break label779;
          label1390:
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 209L, 1L, false);
          break label870;
          label1407:
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 200L, 1L, false);
          break label870;
          paramAnonymousInt = 2;
          break label1248;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.oZt = 0;
    this.orP = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(241208);
        if (k.this.doScene(k.q(k.this), k.h(k.this)) == -1)
        {
          k.a(k.this, 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          k.h(k.this).onSceneEnd(3, -1, "doScene failed", k.this);
        }
        AppMethodBeat.o(241208);
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
      this.oYN = ab.Qo(paramString);
      if (this.oYN == null) {
        break label289;
      }
    }
    label289:
    for (this.MAX_TIMES = 2500;; this.MAX_TIMES = 0)
    {
      this.mHw = new f.a();
      if ((this.oYN != null) && (3 == this.oYN.pbi)) {
        this.oYP = com.tencent.mm.g.a.MediaType_TinyVideo;
      }
      Log.i("MicroMsg.NetSceneUploadVideo", "%s NetSceneUploadVideo:  videoType:[%d]", new Object[] { bNX(), Integer.valueOf(this.oYP) });
      AppMethodBeat.o(126858);
      return;
      bool = false;
      break;
    }
  }
  
  /* Error */
  private String PE(String paramString)
  {
    // Byte code:
    //   0: ldc 227
    //   2: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 229	com/tencent/mm/vfs/u
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 231	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   13: astore 9
    //   15: new 229	com/tencent/mm/vfs/u
    //   18: dup
    //   19: aload 9
    //   21: invokevirtual 235	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   24: new 237	java/lang/StringBuilder
    //   27: dup
    //   28: ldc 239
    //   30: invokespecial 240	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload 9
    //   35: invokevirtual 243	com/tencent/mm/vfs/u:getName	()Ljava/lang/String;
    //   38: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 253	com/tencent/mm/vfs/u:<init>	(Lcom/tencent/mm/vfs/u;Ljava/lang/String;)V
    //   47: astore 10
    //   49: aconst_null
    //   50: astore 7
    //   52: aconst_null
    //   53: astore 8
    //   55: aconst_null
    //   56: astore 5
    //   58: aconst_null
    //   59: astore 6
    //   61: ldc 161
    //   63: ldc 255
    //   65: iconst_1
    //   66: anewarray 206	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload 9
    //   73: invokevirtual 259	com/tencent/mm/vfs/u:length	()J
    //   76: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   79: aastore
    //   80: invokestatic 266	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload 9
    //   85: invokevirtual 259	com/tencent/mm/vfs/u:length	()J
    //   88: ldc2_w 267
    //   91: lcmp
    //   92: ifle +581 -> 673
    //   95: aload 10
    //   97: invokevirtual 272	com/tencent/mm/vfs/u:jKS	()Z
    //   100: ifeq +121 -> 221
    //   103: ldc 161
    //   105: ldc_w 274
    //   108: iconst_1
    //   109: anewarray 206	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: aload 10
    //   116: invokevirtual 278	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   119: invokestatic 284	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   122: aastore
    //   123: invokestatic 266	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: iconst_1
    //   127: istore_2
    //   128: aload 8
    //   130: astore 4
    //   132: aload 6
    //   134: astore 5
    //   136: aload 4
    //   138: ifnull +8 -> 146
    //   141: aload 4
    //   143: invokevirtual 289	java/io/InputStream:close	()V
    //   146: iload_2
    //   147: istore_3
    //   148: aload 5
    //   150: ifnull +10 -> 160
    //   153: aload 5
    //   155: invokevirtual 292	java/io/OutputStream:close	()V
    //   158: iload_2
    //   159: istore_3
    //   160: iload_3
    //   161: ifeq +394 -> 555
    //   164: ldc 161
    //   166: ldc_w 294
    //   169: iconst_3
    //   170: anewarray 206	java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: aload_0
    //   176: invokespecial 210	com/tencent/mm/modelvideo/k:bNX	()Ljava/lang/String;
    //   179: aastore
    //   180: dup
    //   181: iconst_1
    //   182: aload 10
    //   184: invokevirtual 259	com/tencent/mm/vfs/u:length	()J
    //   187: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   190: aastore
    //   191: dup
    //   192: iconst_2
    //   193: aload 10
    //   195: invokevirtual 278	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   198: invokestatic 284	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   201: aastore
    //   202: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   205: aload 10
    //   207: invokevirtual 278	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   210: invokestatic 284	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   213: astore_1
    //   214: ldc 227
    //   216: invokestatic 221	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: aload_1
    //   220: areturn
    //   221: aload 9
    //   223: invokevirtual 278	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   226: invokestatic 284	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   229: invokestatic 300	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   232: astore 11
    //   234: aload 11
    //   236: ifnonnull +121 -> 357
    //   239: ldc_w 302
    //   242: astore 4
    //   244: ldc 161
    //   246: ldc_w 304
    //   249: iconst_1
    //   250: anewarray 206	java/lang/Object
    //   253: dup
    //   254: iconst_0
    //   255: aload 4
    //   257: aastore
    //   258: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   261: aload 11
    //   263: ifnull +131 -> 394
    //   266: aload 11
    //   268: getfield 309	android/graphics/BitmapFactory$Options:outWidth	I
    //   271: sipush 288
    //   274: if_icmpgt +14 -> 288
    //   277: aload 11
    //   279: getfield 312	android/graphics/BitmapFactory$Options:outHeight	I
    //   282: sipush 288
    //   285: if_icmple +109 -> 394
    //   288: aload 9
    //   290: invokevirtual 278	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   293: invokestatic 284	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   296: sipush 288
    //   299: sipush 288
    //   302: getstatic 318	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   305: bipush 60
    //   307: new 237	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 319	java/lang/StringBuilder:<init>	()V
    //   314: aload 10
    //   316: invokevirtual 235	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   319: invokevirtual 278	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   322: invokestatic 284	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   325: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: ldc_w 321
    //   331: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: aload 10
    //   339: invokevirtual 243	com/tencent/mm/vfs/u:getName	()Ljava/lang/String;
    //   342: invokestatic 325	com/tencent/mm/sdk/platformtools/BitmapUtil:createThumbNail	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;)Z
    //   345: istore_2
    //   346: aload 6
    //   348: astore 5
    //   350: aload 8
    //   352: astore 4
    //   354: goto -218 -> 136
    //   357: new 237	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 319	java/lang/StringBuilder:<init>	()V
    //   364: aload 11
    //   366: getfield 309	android/graphics/BitmapFactory$Options:outWidth	I
    //   369: invokevirtual 328	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   372: ldc_w 330
    //   375: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: aload 11
    //   380: getfield 312	android/graphics/BitmapFactory$Options:outHeight	I
    //   383: invokevirtual 328	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   386: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: astore 4
    //   391: goto -147 -> 244
    //   394: aload 9
    //   396: invokestatic 336	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   399: astore 4
    //   401: aload 4
    //   403: fconst_0
    //   404: sipush 288
    //   407: sipush 288
    //   410: invokestatic 340	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeStream	(Ljava/io/InputStream;FII)Landroid/graphics/Bitmap;
    //   413: astore 8
    //   415: aload 8
    //   417: ifnull +247 -> 664
    //   420: aload 10
    //   422: invokestatic 344	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   425: astore 6
    //   427: aload 6
    //   429: astore 5
    //   431: aload 5
    //   433: astore 7
    //   435: aload 4
    //   437: astore 6
    //   439: aload 8
    //   441: getstatic 318	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   444: bipush 60
    //   446: aload 5
    //   448: invokevirtual 350	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   451: istore_2
    //   452: goto -316 -> 136
    //   455: astore 8
    //   457: aconst_null
    //   458: astore 5
    //   460: aconst_null
    //   461: astore 4
    //   463: aload 5
    //   465: astore 7
    //   467: aload 4
    //   469: astore 6
    //   471: ldc 161
    //   473: ldc_w 352
    //   476: iconst_1
    //   477: anewarray 206	java/lang/Object
    //   480: dup
    //   481: iconst_0
    //   482: aload 8
    //   484: invokestatic 358	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   487: aastore
    //   488: invokestatic 361	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   491: aload 4
    //   493: ifnull +8 -> 501
    //   496: aload 4
    //   498: invokevirtual 289	java/io/InputStream:close	()V
    //   501: aload 5
    //   503: ifnull +156 -> 659
    //   506: aload 5
    //   508: invokevirtual 292	java/io/OutputStream:close	()V
    //   511: iconst_0
    //   512: istore_3
    //   513: goto -353 -> 160
    //   516: astore 4
    //   518: iconst_0
    //   519: istore_3
    //   520: goto -360 -> 160
    //   523: astore_1
    //   524: aload 7
    //   526: astore 4
    //   528: aload 4
    //   530: ifnull +8 -> 538
    //   533: aload 4
    //   535: invokevirtual 289	java/io/InputStream:close	()V
    //   538: aload 5
    //   540: ifnull +8 -> 548
    //   543: aload 5
    //   545: invokevirtual 292	java/io/OutputStream:close	()V
    //   548: ldc 227
    //   550: invokestatic 221	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   553: aload_1
    //   554: athrow
    //   555: ldc 161
    //   557: ldc_w 363
    //   560: iconst_3
    //   561: anewarray 206	java/lang/Object
    //   564: dup
    //   565: iconst_0
    //   566: aload_0
    //   567: invokespecial 210	com/tencent/mm/modelvideo/k:bNX	()Ljava/lang/String;
    //   570: aastore
    //   571: dup
    //   572: iconst_1
    //   573: aload 9
    //   575: invokevirtual 259	com/tencent/mm/vfs/u:length	()J
    //   578: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   581: aastore
    //   582: dup
    //   583: iconst_2
    //   584: aload 9
    //   586: invokevirtual 278	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   589: invokestatic 284	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   592: aastore
    //   593: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   596: ldc 227
    //   598: invokestatic 221	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   601: aload_1
    //   602: areturn
    //   603: astore 4
    //   605: goto -459 -> 146
    //   608: astore 4
    //   610: iload_2
    //   611: istore_3
    //   612: goto -452 -> 160
    //   615: astore 4
    //   617: goto -116 -> 501
    //   620: astore 4
    //   622: goto -84 -> 538
    //   625: astore 4
    //   627: goto -79 -> 548
    //   630: astore_1
    //   631: goto -103 -> 528
    //   634: astore_1
    //   635: aload 7
    //   637: astore 5
    //   639: aload 6
    //   641: astore 4
    //   643: goto -115 -> 528
    //   646: astore 8
    //   648: aconst_null
    //   649: astore 5
    //   651: goto -188 -> 463
    //   654: astore 8
    //   656: goto -193 -> 463
    //   659: iconst_0
    //   660: istore_3
    //   661: goto -501 -> 160
    //   664: iconst_0
    //   665: istore_2
    //   666: aload 6
    //   668: astore 5
    //   670: goto -534 -> 136
    //   673: iconst_0
    //   674: istore_2
    //   675: aload 6
    //   677: astore 5
    //   679: aload 8
    //   681: astore 4
    //   683: goto -547 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	686	0	this	k
    //   0	686	1	paramString	String
    //   127	548	2	bool1	boolean
    //   147	514	3	bool2	boolean
    //   130	367	4	localObject1	Object
    //   516	1	4	localIOException1	java.io.IOException
    //   526	8	4	localObject2	Object
    //   603	1	4	localIOException2	java.io.IOException
    //   608	1	4	localIOException3	java.io.IOException
    //   615	1	4	localIOException4	java.io.IOException
    //   620	1	4	localIOException5	java.io.IOException
    //   625	1	4	localIOException6	java.io.IOException
    //   641	41	4	localObject3	Object
    //   56	622	5	localObject4	Object
    //   59	617	6	localObject5	Object
    //   50	586	7	localObject6	Object
    //   53	387	8	localBitmap	android.graphics.Bitmap
    //   455	28	8	localException1	Exception
    //   646	1	8	localException2	Exception
    //   654	26	8	localException3	Exception
    //   13	572	9	localu1	com.tencent.mm.vfs.u
    //   47	374	10	localu2	com.tencent.mm.vfs.u
    //   232	147	11	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   83	126	455	java/lang/Exception
    //   221	234	455	java/lang/Exception
    //   244	261	455	java/lang/Exception
    //   266	288	455	java/lang/Exception
    //   288	346	455	java/lang/Exception
    //   357	391	455	java/lang/Exception
    //   394	401	455	java/lang/Exception
    //   506	511	516	java/io/IOException
    //   83	126	523	finally
    //   221	234	523	finally
    //   244	261	523	finally
    //   266	288	523	finally
    //   288	346	523	finally
    //   357	391	523	finally
    //   394	401	523	finally
    //   141	146	603	java/io/IOException
    //   153	158	608	java/io/IOException
    //   496	501	615	java/io/IOException
    //   533	538	620	java/io/IOException
    //   543	548	625	java/io/IOException
    //   401	415	630	finally
    //   420	427	630	finally
    //   439	452	634	finally
    //   471	491	634	finally
    //   401	415	646	java/lang/Exception
    //   420	427	646	java/lang/Exception
    //   439	452	654	java/lang/Exception
  }
  
  private boolean bNW()
  {
    AppMethodBeat.i(126857);
    String str1 = this.oYN.bOs();
    if (com.tencent.mm.model.ab.IW(str1))
    {
      Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn user:%s", new Object[] { bNX(), str1 });
      AppMethodBeat.o(126857);
      return false;
    }
    if (!com.tencent.mm.pluginsdk.g.b.iGQ())
    {
      Log.i("MicroMsg.NetSceneUploadVideo", "isAllow2UseCdnWithXLab = false");
      AppMethodBeat.o(126857);
      return false;
    }
    com.tencent.mm.modelcdntran.k.bHW();
    if ((!com.tencent.mm.modelcdntran.g.vV(2)) && (this.oYN.pbg != 1))
    {
      localObject1 = bNX();
      com.tencent.mm.modelcdntran.k.bHW();
      Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { localObject1, Boolean.valueOf(com.tencent.mm.modelcdntran.g.vV(2)), Integer.valueOf(this.oYN.pbg) });
      AppMethodBeat.o(126857);
      return false;
    }
    if (!ab.bOG()) {
      i = 0;
    }
    while (i != 0)
    {
      Log.i("MicroMsg.NetSceneUploadVideo", "go send origin video file process");
      AppMethodBeat.o(126857);
      return true;
      this.oHX = com.tencent.mm.modelcdntran.h.a("upimgthumb", this.oYN.createTime, this.oYN.bOs(), this.oYN.getFileName());
      if (Util.isNullOrNil(this.oHX))
      {
        Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra genClientId failed not use cdn file:%s", new Object[] { bNX(), this.oYN.getFileName() });
        i = 0;
      }
      else
      {
        v.bOh();
        localObject3 = aa.PY(this.fileName);
        localObject1 = new com.tencent.mm.g.g();
        ((com.tencent.mm.g.g)localObject1).taskName = "task_NetSceneUploadVideo_2";
        ((com.tencent.mm.g.g)localObject1).lwL = this.oZs;
        ((com.tencent.mm.g.g)localObject1).field_mediaId = this.oHX;
        ((com.tencent.mm.g.g)localObject1).field_fullpath = ((String)localObject3);
        ((com.tencent.mm.g.g)localObject1).field_thumbpath = PE((String)localObject3);
        ((com.tencent.mm.g.g)localObject1).field_fileType = com.tencent.mm.g.a.MediaType_THUMBIMAGE;
        ((com.tencent.mm.g.g)localObject1).field_enable_hitcheck = false;
        ((com.tencent.mm.g.g)localObject1).field_talker = this.oYN.bOs();
        if (au.bwG(this.oYN.bOs())) {}
        for (i = 1;; i = 0)
        {
          ((com.tencent.mm.g.g)localObject1).field_chattype = i;
          ((com.tencent.mm.g.g)localObject1).field_priority = com.tencent.mm.g.a.lvZ;
          ((com.tencent.mm.g.g)localObject1).field_needStorage = false;
          ((com.tencent.mm.g.g)localObject1).field_isStreamMedia = false;
          ((com.tencent.mm.g.g)localObject1).field_trysafecdn = true;
          i = (int)com.tencent.mm.vfs.y.bEl(((com.tencent.mm.g.g)localObject1).field_thumbpath);
          if (i < com.tencent.mm.g.a.lwv) {
            break label460;
          }
          Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { bNX(), ((com.tencent.mm.g.g)localObject1).field_thumbpath, Integer.valueOf(i) });
          i = 0;
          break;
        }
        label460:
        localObject3 = XmlParser.parseXml(this.oYN.bOu(), "msg", null);
        if (localObject3 != null)
        {
          ((com.tencent.mm.g.g)localObject1).field_fileId = ((String)((Map)localObject3).get(".msg.videomsg.$cdnvideourl"));
          ((com.tencent.mm.g.g)localObject1).field_aesKey = ((String)((Map)localObject3).get(".msg.videomsg.$aeskey"));
        }
        if ((Util.isNullOrNil(((com.tencent.mm.g.g)localObject1).field_aesKey)) || (Util.isNullOrNil(((com.tencent.mm.g.g)localObject1).field_aesKey)))
        {
          ((com.tencent.mm.g.g)localObject1).field_aesKey = "";
          ((com.tencent.mm.g.g)localObject1).field_fileId = "";
        }
        if (!com.tencent.mm.modelcdntran.k.bHW().g((com.tencent.mm.g.g)localObject1)) {
          i = 0;
        } else {
          i = 1;
        }
      }
    }
    this.oHX = com.tencent.mm.modelcdntran.h.a("upvideo", this.oYN.createTime, str1, this.oYN.getFileName());
    if (Util.isNullOrNil(this.oHX))
    {
      Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra genClientId failed not use cdn file:%s", new Object[] { bNX(), this.oYN.getFileName() });
      AppMethodBeat.o(126857);
      return false;
    }
    v.bOh();
    Object localObject1 = aa.PY(this.fileName);
    v.bOh();
    String str2 = aa.PX(this.fileName);
    Object localObject3 = new com.tencent.mm.g.g();
    ((com.tencent.mm.g.g)localObject3).taskName = "task_NetSceneUploadVideo_1";
    ((com.tencent.mm.g.g)localObject3).lwL = this.osH;
    ((com.tencent.mm.g.g)localObject3).field_mediaId = this.oHX;
    ((com.tencent.mm.g.g)localObject3).field_fullpath = str2;
    ((com.tencent.mm.g.g)localObject3).field_thumbpath = PE((String)localObject1);
    ((com.tencent.mm.g.g)localObject3).field_fileType = com.tencent.mm.g.a.MediaType_VIDEO;
    boolean bool1;
    if (au.bwZ(this.oYN.bOs()))
    {
      ((com.tencent.mm.g.g)localObject3).field_sendmsg_viacdn = false;
      if ((au.bwZ(this.oYN.bOs())) || (!this.oIo)) {
        break label1219;
      }
      bool1 = true;
      label775:
      ((com.tencent.mm.g.g)localObject3).field_enable_hitcheck = bool1;
      if (!e.bIg().NE(str2)) {
        break label1224;
      }
      i = 1;
      label794:
      ((com.tencent.mm.g.g)localObject3).field_largesvideo = i;
      if ((this.oYN != null) && (3 == this.oYN.pbi)) {
        ((com.tencent.mm.g.g)localObject3).field_smallVideoFlag = 1;
      }
      localObject1 = bNX();
      if (this.oYN.pbl != null) {
        break label1229;
      }
      bool1 = true;
      label842:
      Log.i("MicroMsg.NetSceneUploadVideo", "%s upload video MMSightExtInfo is null? %b %s", new Object[] { localObject1, Boolean.valueOf(bool1), this.fileName });
      if ((this.oYN.pbl != null) && (this.oYN.pbl.aaSg))
      {
        Log.i("MicroMsg.NetSceneUploadVideo", "%s local capture video, mark use large video", new Object[] { bNX() });
        e.bIg();
        ((com.tencent.mm.g.g)localObject3).field_largesvideo = e.b(e.bIg().bIh());
      }
      localObject1 = u.bOf();
      v.bOh();
      ((u)localObject1).a("", aa.PX(this.fileName), this.oYN.bOs(), "", "", 2, 2);
      String str3 = bNX();
      String str4 = this.oYN.getFileName();
      if (this.oYN.pbk != null) {
        break label1234;
      }
      localObject1 = "null";
      label999:
      Log.i("MicroMsg.NetSceneUploadVideo", "%s checkAD file:%s adinfo:%s", new Object[] { str3, str4, localObject1 });
      if ((this.oYN.pbk != null) && (!Util.isNullOrNil(this.oYN.pbk.nTA))) {
        ((com.tencent.mm.g.g)localObject3).field_advideoflag = 1;
      }
      ((com.tencent.mm.g.g)localObject3).field_talker = str1;
      if (!au.bwE(str1)) {
        break label1249;
      }
    }
    label1219:
    label1224:
    label1229:
    label1234:
    label1249:
    for (int i = 1;; i = 0)
    {
      ((com.tencent.mm.g.g)localObject3).field_chattype = i;
      ((com.tencent.mm.g.g)localObject3).field_priority = com.tencent.mm.g.a.lvZ;
      ((com.tencent.mm.g.g)localObject3).field_needStorage = false;
      ((com.tencent.mm.g.g)localObject3).field_isStreamMedia = false;
      ((com.tencent.mm.g.g)localObject3).field_trysafecdn = true;
      this.oZq = ((int)com.tencent.mm.vfs.y.bEl(((com.tencent.mm.g.g)localObject3).field_fullpath));
      this.oZp = ((int)com.tencent.mm.vfs.y.bEl(((com.tencent.mm.g.g)localObject3).field_thumbpath));
      if (this.oZp < com.tencent.mm.g.a.lwv) {
        break label1254;
      }
      Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { bNX(), ((com.tencent.mm.g.g)localObject3).field_thumbpath, Integer.valueOf(this.oZp) });
      AppMethodBeat.o(126857);
      return false;
      if (!af.bpG(str2)) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 30L, 1L, false);
      ((com.tencent.mm.g.g)localObject3).field_use_multithread = true;
      break;
      bool1 = false;
      break label775;
      i = 0;
      break label794;
      bool1 = false;
      break label842;
      localObject1 = this.oYN.pbk.nTA;
      break label999;
    }
    label1254:
    localObject1 = XmlParser.parseXml(this.oYN.bOu(), "msg", null);
    if (localObject1 != null)
    {
      ((com.tencent.mm.g.g)localObject3).field_fileId = ((String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"));
      ((com.tencent.mm.g.g)localObject3).field_aesKey = ((String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
      this.oZo = true;
      localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
      if (this.oZn)
      {
        i = 1;
        label1330:
        ((com.tencent.mm.plugin.report.service.h)localObject1).b(12696, new Object[] { Integer.valueOf(i + 700), Integer.valueOf(this.oYN.osy) });
        if ((Util.isNullOrNil(((com.tencent.mm.g.g)localObject3).field_aesKey)) || (Util.isNullOrNil(((com.tencent.mm.g.g)localObject3).field_aesKey)))
        {
          ((com.tencent.mm.g.g)localObject3).field_aesKey = "";
          ((com.tencent.mm.g.g)localObject3).field_fileId = "";
          com.tencent.mm.modelcdntran.k.bHX();
          ((com.tencent.mm.g.g)localObject3).field_aesKey = com.tencent.mm.modelcdntran.d.bHI();
        }
        Log.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn check hit cache VideoHash :%s %s %s %b %d", new Object[] { bNX(), ((com.tencent.mm.g.g)localObject3).field_mediaId, ((com.tencent.mm.g.g)localObject3).field_fileId, ((com.tencent.mm.g.g)localObject3).field_aesKey, Boolean.valueOf(this.oIo), Integer.valueOf(((com.tencent.mm.g.g)localObject3).field_largesvideo) });
        if (com.tencent.mm.modelcdntran.k.bHW().g((com.tencent.mm.g.g)localObject3)) {
          break label1928;
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 226L, 1L, false);
        Log.e("MicroMsg.NetSceneUploadVideo", "%s cdntra addSendTask failed.", new Object[] { bNX() });
        this.oHX = "";
        AppMethodBeat.o(126857);
        return false;
      }
    }
    else
    {
      Log.i("MicroMsg.NetSceneUploadVideo", "%s cdntra parse video recv xml failed", new Object[] { bNX() });
    }
    label1928:
    label1993:
    for (;;)
    {
      try
      {
        str1 = Util.nullAsNil(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("UseVideoHash"));
        localObject1 = str1.split(",");
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baC();
        i = com.tencent.mm.b.i.jdMethod_do(com.tencent.mm.kernel.b.getUin(), 100);
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label1878;
        }
        if (Util.getInt(localObject1[0], 0) < i) {
          break label1873;
        }
        bool1 = true;
        if ((localObject1 == null) || (localObject1.length < 2)) {
          break label1888;
        }
        if (Util.getInt(localObject1[1], 0) < i) {
          break label1883;
        }
        bool2 = true;
        if ((localObject1 == null) || (localObject1.length < 3)) {
          break label1899;
        }
        if (Util.getInt(localObject1[2], 0) < i) {
          break label1893;
        }
        bool3 = true;
        if (!CrashReportFactory.hasDebuger()) {
          break label1993;
        }
        bool2 = true;
        bool1 = true;
        bool3 = true;
        if (!bool1) {
          break label1905;
        }
        localObject1 = v.bOh().bc(str2, Util.getInt(localObject1[2], 0));
        if ((bool2) && (localObject1 != null) && (localObject1.length == 2))
        {
          ((com.tencent.mm.g.g)localObject3).field_fileId = localObject1[0];
          ((com.tencent.mm.g.g)localObject3).field_aesKey = localObject1[1];
          this.oZn = true;
        }
        Log.i("MicroMsg.NetSceneUploadVideo", "%s CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", new Object[] { bNX(), Boolean.valueOf(CrashReportFactory.hasDebuger()), str1, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(this.oZn), ((com.tencent.mm.g.g)localObject3).field_fileId, ((com.tencent.mm.g.g)localObject3).field_aesKey });
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.NetSceneUploadVideo", "Check use videohash :%s", new Object[] { Util.stackTraceToString(localException) });
      }
      break;
      label1873:
      bool1 = false;
      continue;
      label1878:
      bool1 = false;
      continue;
      label1883:
      boolean bool2 = false;
      continue;
      label1888:
      bool2 = false;
      continue;
      label1893:
      boolean bool3 = false;
      continue;
      label1899:
      bool3 = false;
      continue;
      label1905:
      Object localObject2 = null;
      continue;
      if (this.oZo)
      {
        i = 2;
        break label1330;
      }
      i = 0;
      break label1330;
      if (this.oYN.pbg != 1)
      {
        this.oYN.pbg = 1;
        this.oYN.status = 104;
        this.oYN.clientId = this.oHX;
        this.oYN.eQp = 524544;
        ab.f(this.oYN);
      }
      AppMethodBeat.o(126857);
      return true;
    }
  }
  
  private String bNX()
  {
    AppMethodBeat.i(126865);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(126865);
    return str;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(126856);
    Log.i("MicroMsg.NetSceneUploadVideo", "%s stop %s", new Object[] { bNX(), this.oHX });
    if (!Util.isNullOrNil(this.oHX)) {
      com.tencent.mm.modelcdntran.k.bHW().Ny(this.oHX);
    }
    this.oYQ = true;
    super.cancel();
    AppMethodBeat.o(126856);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(126859);
    this.callback = paramh;
    this.oYN = ab.Qo(this.fileName);
    if ((this.oYN == null) || ((this.oYN.status != 104) && (this.oYN.status != 103)))
    {
      Log.e("MicroMsg.NetSceneUploadVideo", "%s Get info Failed file:", new Object[] { bNX(), this.fileName });
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(126859);
      return -1;
    }
    paramh = new StringBuilder("doscene file:").append(this.fileName).append(" stat:").append(this.oYN.status).append(" [").append(this.oYN.paY).append(",").append(this.oYN.paZ).append("] [").append(this.oYN.oZm).append(",").append(this.oYN.osy).append("]  netTimes:").append(this.oYN.pbd).append(" times:");
    int i = this.oZt;
    this.oZt = (i + 1);
    Log.d("MicroMsg.NetSceneUploadVideo", i);
    if (this.startTime == 0L)
    {
      this.startTime = Util.nowMilliSecond();
      this.oZm = this.oYN.oZm;
    }
    v.bOh();
    if (y.PL(aa.PX(this.fileName)))
    {
      Log.w("MicroMsg.NetSceneUploadVideo", "%s it is mm h265 video xml[%s]", new Object[] { bNX(), this.oYN.bOu() });
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 139L, 1L, false);
    }
    if (bNW())
    {
      Log.d("MicroMsg.NetSceneUploadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { this.fileName });
      AppMethodBeat.o(126859);
      return 0;
    }
    if (com.tencent.mm.model.ab.IW(this.oYN.bOs()))
    {
      Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use parallel-upload user:%s", new Object[] { bNX(), this.oYN.bOs() });
      i = 0;
    }
    label487:
    Object localObject1;
    label587:
    Object localObject2;
    while (i != 0)
    {
      Log.d("MicroMsg.NetSceneUploadVideo", "cdntra use parallel-upload return -1 for onGYNetEnd clientid:%s", new Object[] { this.fileName });
      AppMethodBeat.o(126859);
      return 0;
      if (1 == ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zpB, 0)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label487;
        }
        Log.i("MicroMsg.NetSceneUploadVideo", "NOT ALLOW USE PARALLEL UPLOAD VIDEO");
        i = 0;
        break;
      }
      if (!ab.bOG()) {}
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label587;
        }
        i = 1;
        break;
        v.bOh();
        paramh = PE(aa.PY(this.fileName));
        localObject1 = new com.tencent.mm.pluginsdk.g.d();
        ((com.tencent.mm.pluginsdk.g.d)localObject1).oGz = this.oYN.pbc;
        ((com.tencent.mm.pluginsdk.g.d)localObject1).XPa = this.oZr;
        ((com.tencent.mm.pluginsdk.g.d)localObject1).scene = 2;
        ((com.tencent.mm.pluginsdk.g.d)localObject1).fileType = 3;
        ((com.tencent.mm.pluginsdk.g.d)localObject1).thumbPath = paramh;
        new com.tencent.mm.pluginsdk.g.c().a((com.tencent.mm.pluginsdk.g.d)localObject1);
      }
      v.bOh();
      localObject1 = aa.PY(this.fileName);
      v.bOh();
      paramh = aa.PX(this.fileName);
      localObject1 = PE((String)localObject1);
      localObject2 = new com.tencent.mm.pluginsdk.g.d();
      ((com.tencent.mm.pluginsdk.g.d)localObject2).oGz = this.oYN.pbc;
      ((com.tencent.mm.pluginsdk.g.d)localObject2).XPa = this.oIA;
      ((com.tencent.mm.pluginsdk.g.d)localObject2).scene = 2;
      ((com.tencent.mm.pluginsdk.g.d)localObject2).fileType = 4;
      ((com.tencent.mm.pluginsdk.g.d)localObject2).thumbPath = ((String)localObject1);
      ((com.tencent.mm.pluginsdk.g.d)localObject2).fullPath = paramh;
      new com.tencent.mm.pluginsdk.g.c().a((com.tencent.mm.pluginsdk.g.d)localObject2);
      Log.i("MicroMsg.NetSceneUploadVideo", "use ParallelUploader, filename:%s", new Object[] { this.fileName });
      i = 1;
    }
    if (this.oYN.pbf == 1)
    {
      this.htN = true;
      paramh = new com.tencent.mm.am.c.a();
      paramh.otE = new fud();
      paramh.otF = new fue();
      paramh.uri = "/cgi-bin/micromsg-bin/uploadvideo";
      paramh.funcId = 149;
      paramh.otG = 39;
      paramh.respCmdId = 1000000039;
      this.rr = paramh.bEF();
      localObject2 = (fud)c.b.b(this.rr.otB);
      ((fud)localObject2).IMh = ((String)com.tencent.mm.kernel.h.baE().ban().d(2, ""));
      ((fud)localObject2).IMg = this.oYN.bOs();
      ((fud)localObject2).YHk = this.fileName;
      if (this.htN) {
        ((fud)localObject2).YRD = 2;
      }
      if (this.oYN.pbi == 3) {
        ((fud)localObject2).YRD = 3;
      }
      ((fud)localObject2).abzG = this.oYN.omT;
      ((fud)localObject2).aaSH = this.oYN.paZ;
      ((fud)localObject2).abSf = this.oYN.osy;
      if (!ah.eb(MMApplicationContext.getContext())) {
        break label1787;
      }
      i = 1;
      label927:
      ((fud)localObject2).Zsm = i;
      ((fud)localObject2).aaSK = 2;
      ((fud)localObject2).abSg = 0;
      ((fud)localObject2).abSh = new gol().df(new byte[0]);
      ((fud)localObject2).aaSJ = new gol().df(new byte[0]);
      if (!Util.isNullOrNil(this.ibd)) {
        break label1792;
      }
      v.bOh();
      paramh = com.tencent.mm.vfs.y.bub(aa.PX(this.fileName));
      this.ibd = paramh;
      label1011:
      ((fud)localObject2).abzH = paramh;
      if (Util.isNullOrNil(this.oYN.pbn)) {
        break label1800;
      }
      paramh = bt.JW(this.oYN.pbn);
    }
    for (;;)
    {
      label1041:
      localObject1 = paramh;
      if (Util.isNullOrNil(paramh)) {
        localObject1 = bt.bCQ();
      }
      Log.i("MicroMsg.NetSceneUploadVideo", "video msg source is %s".concat(String.valueOf(localObject1)));
      ((fud)localObject2).YFJ = ((String)localObject1);
      ((fud)localObject2).abSs = this.oYN.iah;
      paramh = this.oYN.pbk;
      if ((paramh != null) && (!Util.isNullOrNil(paramh.nTu)))
      {
        ((fud)localObject2).abSk = Util.nullAs(paramh.nTu, "");
        ((fud)localObject2).abSl = paramh.ZBc;
        ((fud)localObject2).abSm = Util.nullAs(paramh.nTw, "");
        ((fud)localObject2).abSo = Util.nullAs(paramh.nTy, "");
        ((fud)localObject2).abSn = Util.nullAs(paramh.nTx, "");
        ((fud)localObject2).abSp = Util.nullAs(paramh.nTz, "");
        label1192:
        if (((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).ifAddTicketByActionFlag(this.oYN.bOs())) {
          ((fud)localObject2).ZaR = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxH(this.oYN.bOs());
        }
        if (paramh != null)
        {
          ((fud)localObject2).abSr = Util.nullAs(paramh.nTA, "");
          ((fud)localObject2).abSq = Util.nullAs(paramh.nTB, "");
        }
        paramh = "";
        if (Util.isNullOrNil(this.oYN.bOu())) {
          break label1928;
        }
        paramh = this.oYN.bOu();
      }
      for (;;)
      {
        if (!Util.isNullOrNil(paramh))
        {
          if (Util.isNullOrNil(this.oYN.bOu()))
          {
            Log.i("MicroMsg.NetSceneUploadVideo", "uploadVideo video.recvXml is empty and update: %s", new Object[] { paramh });
            this.oYN.pbh = paramh;
            ab.f(this.oYN);
          }
          paramh = com.tencent.mm.modelimage.a.NM(paramh);
          if ((paramh != null) && (!Util.isNullOrNil(paramh.appId)))
          {
            ((fud)localObject2).oOI = paramh.appId;
            ((fud)localObject2).YCm = paramh.mediaTagName;
            ((fud)localObject2).YCn = paramh.messageExt;
            ((fud)localObject2).YCo = paramh.messageAction;
          }
        }
        Log.d("MicroMsg.NetSceneUploadVideo", "upload video: play length %d, thumb totalLen %d, video totalLen %d, funcFlag %d, videoMd5: %s stream %s streamtime: %d title %s thumburl %s appId: %s", new Object[] { Integer.valueOf(((fud)localObject2).abzG), Integer.valueOf(((fud)localObject2).aaSI), Integer.valueOf(((fud)localObject2).abSf), Integer.valueOf(((fud)localObject2).YRD), ((fud)localObject2).abzH, ((fud)localObject2).abSk, Integer.valueOf(((fud)localObject2).abSl), ((fud)localObject2).abSm, ((fud)localObject2).abSp, ((fud)localObject2).oOI });
        if (this.oYN.status != 103) {
          break label2203;
        }
        v.bOh();
        paramh = aa.x(aa.PY(this.fileName), this.oYN.paY, oZk);
        if ((paramh != null) && (paramh.ret >= 0) && (paramh.hxg != 0)) {
          break label1955;
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 225L, 1L, false);
        ab.Qf(this.fileName);
        Log.e("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "]  Error ");
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        AppMethodBeat.o(126859);
        return -1;
        if (this.oYN.createTime + 600L < Util.nowSecond())
        {
          Log.e("MicroMsg.NetSceneUploadVideo", "create time check error:" + this.fileName);
          ab.Qf(this.fileName);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          AppMethodBeat.o(126859);
          return -1;
        }
        if (ab.Qe(this.fileName)) {
          break;
        }
        Log.e("MicroMsg.NetSceneUploadVideo", "checkVoiceNetTimes Failed file:" + this.fileName);
        ab.Qf(this.fileName);
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        AppMethodBeat.o(126859);
        return -1;
        label1787:
        i = 2;
        break label927;
        label1792:
        paramh = this.ibd;
        break label1011;
        label1800:
        if (this.oYN.pbm > 0)
        {
          paramh = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(this.oYN.pbm);
          if (paramh == null) {
            break label2656;
          }
          paramh = bt.JW(bt.JV(paramh.jUr));
          break label1041;
        }
        paramh = com.tencent.mm.vfs.y.bub(this.oYN.bOt());
        localObject1 = com.tencent.mm.platformtools.s.pBi;
        paramh = bt.JW(com.tencent.mm.platformtools.s.Si(paramh));
        break label1041;
        if ((paramh == null) || (Util.isNullOrNil(paramh.nTy)) || (Util.isNullOrNil(paramh.nTx))) {
          break label1192;
        }
        ((fud)localObject2).abSo = paramh.nTy;
        ((fud)localObject2).abSn = paramh.nTx;
        break label1192;
        label1928:
        if (!Util.isNullOrNil(this.oYN.pbo)) {
          paramh = com.tencent.mm.modelimage.a.NL(this.oYN.pbo);
        }
      }
      label1955:
      Log.d("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "] read ret:" + paramh.ret + " readlen:" + paramh.hxg + " newOff:" + paramh.pbK + " netOff:" + this.oYN.paY);
      if (paramh.pbK < this.oYN.paY)
      {
        Log.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ THUMB[" + this.fileName + "] newOff:" + paramh.pbK + " OldtOff:" + this.oYN.paY);
        ab.Qf(this.fileName);
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        AppMethodBeat.o(126859);
        return -1;
      }
      localObject1 = new byte[paramh.hxg];
      System.arraycopy(paramh.buf, 0, localObject1, 0, paramh.hxg);
      ((fud)localObject2).aaSI = this.oYN.paY;
      ((fud)localObject2).aaSJ = new gol().df((byte[])localObject1);
      for (;;)
      {
        i = dispatch(paramg, this.rr, this);
        AppMethodBeat.o(126859);
        return i;
        label2203:
        v.bOh();
        paramh = aa.x(aa.PX(this.fileName), this.oYN.oZm, oZk);
        if ((paramh == null) || (paramh.ret < 0) || (paramh.hxg == 0))
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 224L, 1L, false);
          ab.Qf(this.fileName);
          Log.e("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          AppMethodBeat.o(126859);
          return -1;
        }
        Log.d("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "] read ret:" + paramh.ret + " readlen:" + paramh.hxg + " newOff:" + paramh.pbK + " netOff:" + this.oYN.oZm);
        if (paramh.pbK < this.oYN.oZm)
        {
          Log.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] newOff:" + paramh.pbK + " OldtOff:" + this.oYN.oZm);
          ab.Qf(this.fileName);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          AppMethodBeat.o(126859);
          return -1;
        }
        if (paramh.pbK >= g.oYh)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 222L, 1L, false);
          Log.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] maxsize:" + g.oYh);
          ab.Qf(this.fileName);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          AppMethodBeat.o(126859);
          return -1;
        }
        localObject1 = new byte[paramh.hxg];
        System.arraycopy(paramh.buf, 0, localObject1, 0, paramh.hxg);
        ((fud)localObject2).abSg = this.oYN.oZm;
        ((fud)localObject2).aaSI = this.oYN.paY;
        ((fud)localObject2).abSh = new gol().df((byte[])localObject1);
      }
      label2656:
      paramh = null;
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
    Log.i("MicroMsg.NetSceneUploadVideo", "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.oHX);
    if (this.oYQ)
    {
      Log.d("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Call Stop by Service   file:" + this.fileName + " user:" + this.oYN.bOs());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    paramArrayOfByte = (fue)c.c.b(((com.tencent.mm.am.c)params).otC);
    params = (fud)c.b.b(((com.tencent.mm.am.c)params).otB);
    if ((paramArrayOfByte != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).setEnSendMsgActionFlag(paramArrayOfByte.ZaS);
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!Util.isNullOrNil(this.oHX)))
    {
      Log.w("MicroMsg.NetSceneUploadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.oHX });
      AppMethodBeat.o(126863);
      return;
    }
    this.oYN = ab.Qo(this.fileName);
    if (this.oYN == null)
    {
      Log.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if (this.oYN.status == 105)
    {
      Log.w("MicroMsg.NetSceneUploadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.oYN.hTh + "," + this.oYN.bOq() + "," + this.oYN.bOs() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((this.oYN.status != 104) && (this.oYN.status != 103))
    {
      Log.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.oYN.status + " [" + this.fileName + "," + this.oYN.hTh + "," + this.oYN.bOq() + "," + this.oYN.bOs() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      Log.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd BLACK  errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.oYN.bOs());
      ab.Qg(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 220L, 1L, false);
      Log.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.oYN.bOs());
      ab.Qf(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 219L, 1L, false);
      Log.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.oYN.bOs());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((!Util.isNullOrNil(params.aaSJ.aaxD.Op)) && (params.aaSI != paramArrayOfByte.aaSI - params.aaSJ.abwJ))
    {
      Log.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + params.aaSI + "," + params.aaSJ.abwJ + "," + paramArrayOfByte.aaSI + "] file:" + this.fileName + " user:" + params.IMg);
      ab.Qf(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((!Util.isNullOrNil(params.abSh.aaxD.Op)) && (params.abSg != paramArrayOfByte.abSg - params.abSh.abwJ))
    {
      Log.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + params.abSg + "," + params.abSh.abwJ + "," + paramArrayOfByte.abSg + "] file:" + this.fileName + " user:" + params.IMg);
      ab.Qf(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    this.oYN.pba = Util.nowSecond();
    this.oYN.hTh = paramArrayOfByte.Njv;
    this.oYN.eQp = 1028;
    Log.d("MicroMsg.NetSceneUploadVideo", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(this.oYN.hTh), Integer.valueOf(com.tencent.mm.platformtools.z.pCn) });
    if ((10007 == com.tencent.mm.platformtools.z.pCm) && (com.tencent.mm.platformtools.z.pCn != 0) && (this.oYN.hTh != 0L))
    {
      this.oYN.hTh = com.tencent.mm.platformtools.z.pCn;
      com.tencent.mm.platformtools.z.pCn = 0;
    }
    paramInt1 = this.oYN.status;
    z localz;
    if (paramInt1 == 103)
    {
      localz = this.oYN;
      paramInt1 = params.aaSI;
      localz.paY = (params.aaSJ.abwJ + paramInt1);
      this.oYN.eQp |= 0x40;
      if (this.oYN.paY < this.oYN.paZ) {
        break label2206;
      }
      this.oYN.status = 104;
      this.oYN.eQp |= 0x100;
      paramInt1 = 0;
    }
    for (;;)
    {
      ab.f(this.oYN);
      if (this.oYQ)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(126863);
        return;
        if (paramInt1 == 104)
        {
          localz = this.oYN;
          paramInt1 = params.abSg;
          localz.oZm = (params.abSh.abwJ + paramInt1);
          this.oYN.eQp |= 0x8;
          if (this.oYN.oZm >= this.oYN.osy)
          {
            this.oYN.status = 199;
            this.oYN.eQp |= 0x100;
            ab.d(this.oYN);
            paramInt1 = 1;
          }
        }
        else
        {
          Log.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd ERROR STATUS:" + paramInt1 + " file:" + this.fileName + " user:" + params.IMg);
          ab.Qf(this.fileName);
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(126863);
        }
      }
      else
      {
        if (paramInt1 == 0)
        {
          this.orP.startTimer(10L);
          AppMethodBeat.o(126863);
          return;
        }
        params = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(this.oYN.pbc);
        if (params != null)
        {
          params.AU(paramArrayOfByte.YFJ);
          ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(params.field_msgId, params);
        }
        com.tencent.mm.modelstat.b.oUZ.u(params);
        boolean bool;
        if (this.oYN == null)
        {
          bool = false;
          if ((!bool) && (!au.bwc(this.oYN.bOs()))) {
            break label2112;
          }
          Log.i("MicroMsg.NetSceneUploadVideo", "upload to biz :%s", new Object[] { this.oYN.bOs() });
          if (this.oYN.hTh < 0L)
          {
            Log.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.oYN.hTh + " file:" + this.fileName + " toUser:" + this.oYN.bOs());
            ab.Qf(this.fileName);
          }
          label1845:
          if (this.mHw == null) {
            break label2200;
          }
        }
        label2200:
        for (long l = this.mHw.aPY();; l = 0L)
        {
          Log.d("MicroMsg.NetSceneUploadVideo", "!!!FIN: file:" + this.fileName + " toUser:" + this.oYN.bOs() + " msgsvrid:" + this.oYN.hTh + " thumbsize:" + this.oYN.paZ + " videosize:" + this.oYN.osy + " useTime:" + l);
          Log.d("MicroMsg.NetSceneUploadVideo", "FinishLogForTime file:" + this.fileName + " packSize:" + oZk + " filesize:" + this.oYN.osy + " useTime:" + l);
          a.a(this.oYN, 0);
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(126863);
          return;
          params = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.oYN.bOs());
          if ((params == null) || ((int)params.maN <= 0))
          {
            bool = false;
            break;
          }
          bool = params.iZC();
          break;
          label2112:
          Log.i("MicroMsg.NetSceneUploadVideo", "not upload to biz");
          if (this.oYN.hTh > 0L) {
            break label1845;
          }
          Log.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.oYN.hTh + " file:" + this.fileName + " toUser:" + this.oYN.bOs());
          ab.Qf(this.fileName);
          break label1845;
        }
      }
      label2206:
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
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 210L, 1L, false);
    }
    AppMethodBeat.o(126862);
    return bool;
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(126860);
    params = (fud)c.b.b(((com.tencent.mm.am.c)params).otB);
    if ((Util.isNullOrNil(params.YHk)) || (params.aaSK <= 0) || (Util.isNullOrNil(params.IMh)) || (Util.isNullOrNil(params.IMg)) || (params.Zsm <= 0) || (params.aaSI > params.aaSH) || (params.aaSI < 0) || (params.abSg > params.abSf) || (params.abSg < 0) || ((params.abSg == params.abSf) && (params.aaSI == params.aaSH)) || (params.aaSH <= 0) || (params.abSf <= 0) || ((params.abSh.abwJ <= 0) && (params.aaSJ.abwJ <= 0)))
    {
      Log.e("MicroMsg.NetSceneUploadVideo", "ERR: Security Check Failed file:" + this.fileName + " user:" + params.IMg);
      params = p.b.oui;
      AppMethodBeat.o(126860);
      return params;
    }
    params = p.b.ouh;
    AppMethodBeat.o(126860);
    return params;
  }
  
  public final void setSecurityCheckError(p.a parama)
  {
    AppMethodBeat.i(126861);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 221L, 1L, false);
    ab.Qf(this.fileName);
    AppMethodBeat.o(126861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.k
 * JD-Core Version:    0.7.0.1
 */