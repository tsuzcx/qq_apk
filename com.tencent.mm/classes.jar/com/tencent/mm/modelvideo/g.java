package com.tencent.mm.modelvideo;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.w;
import com.tencent.mm.network.ae;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.protocal.protobuf.dib;
import com.tencent.mm.protocal.protobuf.dic;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.Vector;
import junit.framework.Assert;

public final class g
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  private static int hyK = 32000;
  private final int MAX_TIMES;
  boolean cVU;
  private com.tencent.mm.al.g callback;
  private String dyw;
  public String fileName;
  av gTs;
  f.a ghu;
  private String hhN;
  private g.a hhW;
  private boolean hie;
  private final long hyL;
  private int hyM;
  private boolean hyN;
  private boolean hyO;
  private int hyP;
  private int hyQ;
  int hyR;
  public s hyn;
  private int hyp;
  private boolean hyq;
  int retCode;
  private com.tencent.mm.al.b rr;
  private long startTime;
  
  public g(String paramString)
  {
    AppMethodBeat.i(126858);
    this.dyw = "";
    this.hyL = 1800000L;
    this.retCode = 0;
    this.hyq = false;
    this.cVU = false;
    this.ghu = null;
    this.hie = true;
    this.hhN = "";
    this.startTime = 0L;
    this.hyM = -1;
    this.hyp = com.tencent.mm.i.a.MediaType_VIDEO;
    this.hyN = false;
    this.hyO = false;
    this.hyP = 0;
    this.hyQ = 0;
    this.hhW = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(126854);
        ad.d("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { g.a(g.this), g.b(g.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          ad.d("MicroMsg.NetSceneUploadVideo", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { g.b(g.this) });
          AppMethodBeat.o(126854);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          u.zV(g.c(g.this));
          new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(g.d(g.this)), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(g.e(g.this)), Integer.valueOf(0), "" })).aBj();
          g.f(g.this).onSceneEnd(3, paramAnonymousInt, "", g.this);
          AppMethodBeat.o(126854);
          return 0;
        }
        g.a(g.this, u.Ae(g.c(g.this)));
        if ((g.g(g.this) == null) || (g.g(g.this).status == 105))
        {
          if (g.g(g.this) == null) {}
          for (int i = -1;; i = g.g(g.this).status)
          {
            ad.i("MicroMsg.NetSceneUploadVideo", "%s info is null or has paused, status:%d", new Object[] { g.a(g.this), Integer.valueOf(i) });
            com.tencent.mm.ao.f.awL().xK(g.b(g.this));
            g.f(g.this).onSceneEnd(3, paramAnonymousInt, "info is null or has paused, status".concat(String.valueOf(i)), g.this);
            AppMethodBeat.o(126854);
            return 0;
          }
        }
        if (paramAnonymousc != null)
        {
          if (g.g(g.this).hyM > paramAnonymousc.field_finishedLength)
          {
            ad.w("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnEndProc error oldpos:%d newpos:%d", new Object[] { g.a(g.this), Integer.valueOf(g.g(g.this).hyM), Long.valueOf(paramAnonymousc.field_finishedLength) });
            AppMethodBeat.o(126854);
            return 0;
          }
          g.g(g.this).hAg = bt.aGK();
          g.g(g.this).hyM = ((int)paramAnonymousc.field_finishedLength);
          g.g(g.this).dtM = 1032;
          u.f(g.g(g.this));
          AppMethodBeat.o(126854);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode != 0)
          {
            ad.e("MicroMsg.NetSceneUploadVideo", "%s cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { g.a(g.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo });
            u.zV(g.c(g.this));
            paramAnonymousString = com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(1), Long.valueOf(g.d(g.this)), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(g.e(g.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fns });
            new com.tencent.mm.g.b.a.h(paramAnonymousString).aBj();
            new com.tencent.mm.g.b.a.f(paramAnonymousString).aBj();
            g.f(g.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", g.this);
          }
        }
        else
        {
          AppMethodBeat.o(126854);
          return 0;
        }
        ad.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn uploadvideo by cdn, videohash isHitCacheUpload: %d, enableHitcheck:%b", new Object[] { g.a(g.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(g.h(g.this)) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.vKh;
        if (g.i(g.this))
        {
          paramAnonymousInt = 810;
          label844:
          paramAnonymousString.f(12696, new Object[] { Integer.valueOf(paramAnonymousInt + paramAnonymousd.field_UploadHitCacheType), Integer.valueOf(g.g(g.this).gTY) });
          paramAnonymousBoolean = paramAnonymousd.field_isVideoReduced;
          ad.i("MicroMsg.NetSceneUploadVideo", "%s it video was reduced by cdn %b %s", new Object[] { g.a(g.this), Boolean.valueOf(paramAnonymousBoolean), g.c(g.this) });
          if (paramAnonymousBoolean) {
            break label1604;
          }
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(106L, 205L, 1L, false);
          if ((g.k(g.this) > 0) && (paramAnonymousd.field_thumbimgLength > 0))
          {
            ad.i("MicroMsg.NetSceneUploadVideo", "%s send video thumb too big thumb length [%d, %d] ", new Object[] { g.a(g.this), Integer.valueOf(g.k(g.this)), Integer.valueOf(paramAnonymousd.field_thumbimgLength) });
            if (g.k(g.this) * 2 <= paramAnonymousd.field_thumbimgLength) {
              break label1570;
            }
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(106L, 206L, 1L, false);
          }
          label1044:
          o.aCI();
          paramAnonymousInt = (int)com.tencent.mm.vfs.i.aMN(t.zQ(g.c(g.this)));
          ad.i("MicroMsg.NetSceneUploadVideo", "%s send video too big thumb length [%d, %d] ", new Object[] { g.a(g.this), Integer.valueOf(g.g(g.this).gTY), Integer.valueOf(paramAnonymousInt) });
          if (g.g(g.this).gTY == paramAnonymousInt) {
            break label1587;
          }
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(106L, 208L, 1L, false);
          label1136:
          g.a(g.this, u.Ae(g.c(g.this)));
          if (bt.isNullOrNil(g.g(g.this).aCT()))
          {
            paramAnonymousString = "<msg><videomsg aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnvideourl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "length=\"" + paramAnonymousd.field_fileLength + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\"/></msg>";
            ad.i("MicroMsg.NetSceneUploadVideo", "%s cdn callback new build cdnInfo:%s", new Object[] { g.a(g.this), paramAnonymousString });
            g.g(g.this).hAn = paramAnonymousString;
            u.f(g.g(g.this));
          }
          paramAnonymousString = bw.K(g.g(g.this).aCT(), "msg");
          if (paramAnonymousString != null)
          {
            paramAnonymousc = o.aCI();
            o.aCI();
            boolean bool = paramAnonymousc.r(t.zQ(g.c(g.this)), (String)paramAnonymousString.get(".msg.videomsg.$cdnvideourl"), (String)paramAnonymousString.get(".msg.videomsg.$aeskey"));
            paramAnonymousString = com.tencent.mm.plugin.report.service.h.vKh;
            if (!bool) {
              break label1621;
            }
            paramAnonymousInt = 1;
            label1459:
            paramAnonymousString.f(12696, new Object[] { Integer.valueOf(paramAnonymousInt + 900), Integer.valueOf(g.g(g.this).gTY) });
          }
          paramAnonymousString = com.tencent.mm.kernel.g.aeS();
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
                com.tencent.mm.kernel.g.afE().ax(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(126852);
                    g.m(g.this);
                    g.g(g.this).status = 104;
                    g.g(g.this).createTime = bt.aGK();
                    g.g(g.this).hAg = bt.aGK();
                    g.g(g.this).hyM = 0;
                    g.g(g.this).dtM = 1800;
                    boolean bool = u.f(g.g(g.this));
                    ad.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { g.a(g.this), Boolean.valueOf(g.h(g.this)), Boolean.valueOf(bool), Long.valueOf(g.g(g.this).createTime) });
                    g.this.doScene(g.n(g.this), g.f(g.this));
                    AppMethodBeat.o(126852);
                  }
                });
                AppMethodBeat.o(126853);
                return;
              }
              new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(1), Long.valueOf(g.d(g.this)), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(g.e(g.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fns })).aBj();
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
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(106L, 207L, 1L, false);
          break label1044;
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(106L, 209L, 1L, false);
          break label1136;
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(106L, 200L, 1L, false);
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
    this.hyR = 0;
    this.gTs = new av(new av.a()
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
      ad.d("MicroMsg.NetSceneUploadVideo", "NetSceneUploadVideo:  file:".concat(String.valueOf(paramString)));
      this.fileName = paramString;
      this.hyn = u.Ae(paramString);
      if (this.hyn == null) {
        break label253;
      }
    }
    label253:
    for (this.MAX_TIMES = 2500;; this.MAX_TIMES = 0)
    {
      this.ghu = new f.a();
      if ((this.hyn != null) && (3 == this.hyn.hAo)) {
        this.hyp = com.tencent.mm.i.a.MediaType_TinyVideo;
      }
      ad.i("MicroMsg.NetSceneUploadVideo", "%s NetSceneUploadVideo:  videoType:[%d]", new Object[] { aCy(), Integer.valueOf(this.hyp) });
      AppMethodBeat.o(126858);
      return;
      bool = false;
      break;
    }
  }
  
  private boolean aCx()
  {
    AppMethodBeat.i(126857);
    if (w.tp(this.hyn.getUser()))
    {
      ad.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn user:%s", new Object[] { aCy(), this.hyn.getUser() });
      AppMethodBeat.o(126857);
      return false;
    }
    com.tencent.mm.ao.f.awL();
    if ((!com.tencent.mm.ao.b.nL(2)) && (this.hyn.hAm != 1))
    {
      localObject1 = aCy();
      com.tencent.mm.ao.f.awL();
      ad.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { localObject1, Boolean.valueOf(com.tencent.mm.ao.b.nL(2)), Integer.valueOf(this.hyn.hAm) });
      AppMethodBeat.o(126857);
      return false;
    }
    this.hhN = com.tencent.mm.ao.c.a("upvideo", this.hyn.createTime, this.hyn.getUser(), this.hyn.getFileName());
    if (bt.isNullOrNil(this.hhN))
    {
      ad.w("MicroMsg.NetSceneUploadVideo", "%s cdntra genClientId failed not use cdn file:%s", new Object[] { aCy(), this.hyn.getFileName() });
      AppMethodBeat.o(126857);
      return false;
    }
    o.aCI();
    Object localObject1 = t.zR(this.fileName);
    o.aCI();
    String str2 = t.zQ(this.fileName);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fnH = this.hhW;
    localg.field_mediaId = this.hhN;
    localg.field_fullpath = str2;
    localg.field_thumbpath = zG((String)localObject1);
    localg.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
    localg.field_enable_hitcheck = this.hie;
    boolean bool1;
    label358:
    String str1;
    Object localObject3;
    if (com.tencent.mm.modelcontrol.d.awT().xQ(str2))
    {
      i = 1;
      localg.field_largesvideo = i;
      if ((this.hyn != null) && (3 == this.hyn.hAo)) {
        localg.field_smallVideoFlag = 1;
      }
      localObject1 = aCy();
      if (this.hyn.hAr != null) {
        break label719;
      }
      bool1 = true;
      ad.i("MicroMsg.NetSceneUploadVideo", "%s upload video MMSightExtInfo is null? %b %s", new Object[] { localObject1, Boolean.valueOf(bool1), this.fileName });
      if ((this.hyn.hAr != null) && (this.hyn.hAr.DLK))
      {
        ad.i("MicroMsg.NetSceneUploadVideo", "%s local capture video, mark use large video", new Object[] { aCy() });
        localObject1 = n.aCG();
        o.aCI();
        ((n)localObject1).a("", t.zQ(this.fileName), this.hyn.getUser(), "", "", 2, 2);
        com.tencent.mm.modelcontrol.d.awT();
        localg.field_largesvideo = com.tencent.mm.modelcontrol.d.b(com.tencent.mm.modelcontrol.d.awT().awU());
      }
      str1 = aCy();
      localObject3 = this.hyn.getFileName();
      if (this.hyn.hAq != null) {
        break label725;
      }
      localObject1 = "null";
      label516:
      ad.i("MicroMsg.NetSceneUploadVideo", "%s checkAD file:%s adinfo:%s", new Object[] { str1, localObject3, localObject1 });
      if ((this.hyn.hAq != null) && (!bt.isNullOrNil(this.hyn.hAq.gJB))) {
        localg.field_advideoflag = 1;
      }
      localg.field_talker = this.hyn.getUser();
      if (!w.pF(this.hyn.getUser())) {
        break label740;
      }
    }
    label719:
    label725:
    label740:
    for (int i = 1;; i = 0)
    {
      localg.field_chattype = i;
      localg.field_priority = com.tencent.mm.i.a.fmV;
      localg.field_needStorage = false;
      localg.field_isStreamMedia = false;
      localg.field_trysafecdn = true;
      this.hyQ = ((int)com.tencent.mm.vfs.i.aMN(localg.field_fullpath));
      this.hyP = ((int)com.tencent.mm.vfs.i.aMN(localg.field_thumbpath));
      if (this.hyP < com.tencent.mm.i.a.fnq) {
        break label745;
      }
      ad.w("MicroMsg.NetSceneUploadVideo", "%s cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { aCy(), localg.field_thumbpath, Integer.valueOf(this.hyP) });
      AppMethodBeat.o(126857);
      return false;
      i = 0;
      break;
      bool1 = false;
      break label358;
      localObject1 = this.hyn.hAq.gJB;
      break label516;
    }
    label745:
    localObject1 = bw.K(this.hyn.aCT(), "msg");
    boolean bool2;
    label1180:
    int m;
    long l1;
    label1267:
    Object localObject2;
    label1285:
    label1440:
    label1446:
    label1452:
    label1458:
    label1464:
    label1470:
    label1476:
    Object localObject5;
    Object localObject4;
    label1886:
    int k;
    int j;
    label1949:
    int i2;
    if (localObject1 != null)
    {
      localg.field_fileId = ((String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"));
      localg.field_aesKey = ((String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
      this.hyO = true;
      localObject1 = com.tencent.mm.plugin.report.service.h.vKh;
      if (this.hyN)
      {
        i = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject1).f(12696, new Object[] { Integer.valueOf(i + 700), Integer.valueOf(this.hyn.gTY) });
        if ((bt.isNullOrNil(localg.field_aesKey)) || (bt.isNullOrNil(localg.field_aesKey)))
        {
          localg.field_aesKey = "";
          localg.field_fileId = "";
        }
        ad.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn check hit cache VideoHash :%s %s %s %b %d", new Object[] { aCy(), localg.field_mediaId, localg.field_fileId, localg.field_aesKey, Boolean.valueOf(this.hie), Integer.valueOf(localg.field_largesvideo) });
        if (com.tencent.mm.ao.f.awL().e(localg)) {
          break label2867;
        }
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 226L, 1L, false);
        ad.e("MicroMsg.NetSceneUploadVideo", "%s cdntra addSendTask failed.", new Object[] { aCy() });
        this.hhN = "";
        AppMethodBeat.o(126857);
        return false;
      }
    }
    else
    {
      ad.i("MicroMsg.NetSceneUploadVideo", "%s cdntra parse video recv xml failed", new Object[] { aCy() });
      int n;
      int i1;
      Vector localVector2;
      for (;;)
      {
        try
        {
          str1 = bt.nullAsNil(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("UseVideoHash"));
          localObject1 = str1.split(",");
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afz();
          i = com.tencent.mm.b.i.cf(com.tencent.mm.kernel.a.getUin(), 100);
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break label1446;
          }
          if (bt.getInt(localObject1[0], 0) < i) {
            break label1440;
          }
          bool1 = true;
          if ((localObject1 == null) || (localObject1.length < 2)) {
            break label1458;
          }
          if (bt.getInt(localObject1[1], 0) < i) {
            break label1452;
          }
          bool2 = true;
          if ((localObject1 == null) || (localObject1.length < 3)) {
            break label1470;
          }
          if (bt.getInt(localObject1[2], 0) < i) {
            break label1464;
          }
          bool3 = true;
          if (!com.tencent.mm.sdk.a.b.eEQ()) {
            break label2940;
          }
          bool1 = true;
          bool2 = true;
          bool3 = true;
          if (!bool2) {
            break label2844;
          }
          localObject3 = o.aCI();
          m = bt.getInt(localObject1[2], 0);
          ad.i("MicroMsg.VideoInfoStorage", "checkVideoHash in fullCheckRatio:%s path:%s stack:%s", new Object[] { Integer.valueOf(m), str2, bt.eGN() });
          l1 = bt.eGO();
          if (!bt.isNullOrNil(str2)) {
            break label1476;
          }
          ad.e("MicroMsg.VideoInfoStorage", "checkVideoHash failed , path:%s ", new Object[] { str2 });
          localObject1 = "";
          if (bt.isNullOrNil((String)localObject1)) {
            break label2844;
          }
          localObject1 = ((String)localObject1).split("##");
          if ((bool1) && (localObject1 != null) && (localObject1.length == 2))
          {
            localg.field_fileId = localObject1[0];
            localg.field_aesKey = localObject1[1];
            this.hyN = true;
          }
          ad.i("MicroMsg.NetSceneUploadVideo", "%s CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", new Object[] { aCy(), Boolean.valueOf(com.tencent.mm.sdk.a.b.eEQ()), str1, Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(this.hyN), localg.field_fileId, localg.field_aesKey });
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.NetSceneUploadVideo", "Check use videohash :%s", new Object[] { bt.m(localException) });
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
        localObject2 = t.zT(str2);
        if ((localObject2 == null) || (localObject2.length < 33))
        {
          ad.e("MicroMsg.VideoInfoStorage", "checkVideoHash  readHash failed :%s", new Object[] { str2 });
          localObject2 = "";
        }
        else
        {
          ((t)localObject3).gPa.execSQL("VideoHash", "delete from VideoHash where CreateTime < " + (bt.aGK() - 432000L));
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
          Cursor localCursor = ((t)localObject3).gPa.a("select size, CreateTime, hash, cdnxml, orgpath from VideoHash where size = ".concat(String.valueOf(n)), null, 0);
          while (localCursor.moveToNext())
          {
            l2 = localCursor.getLong(1);
            String str3 = localCursor.getString(2);
            String str4 = localCursor.getString(3);
            String str5 = localCursor.getString(4);
            ad.v("MicroMsg.VideoInfoStorage", "checkVideoHash select [%s][%s]", new Object[] { str3, str4 });
            if ((bt.isNullOrNil(str3)) || (bt.isNullOrNil(str4)))
            {
              com.tencent.mm.plugin.report.service.h.vKh.f(12696, new Object[] { Integer.valueOf(104), Integer.valueOf(n) });
              ad.w("MicroMsg.VideoInfoStorage", "checkVideoHash select error [%s][%s]", new Object[] { str3, str4 });
            }
            else
            {
              if (i1 == str3.length()) {
                break label2955;
              }
              com.tencent.mm.plugin.report.service.h.vKh.f(12696, new Object[] { Integer.valueOf(105), Integer.valueOf(n) });
              ad.w("MicroMsg.VideoInfoStorage", "checkVideoHash err length file:%d cursor:%d", new Object[] { Integer.valueOf(i1), Integer.valueOf(str3.length()) });
              continue;
              if (k < i1)
              {
                if (localStringBuffer.charAt(k) != str3.charAt(k)) {
                  break label2937;
                }
                j += 1;
                break label2962;
              }
              if ((i >= 0) && (localVector1.size() > i) && (((Integer)localVector1.get(i)).intValue() >= j)) {
                break label2934;
              }
              i = localVector1.size();
              localVector1.add(Integer.valueOf(j));
              ((Vector)localObject5).add(str4);
              ((Vector)localObject4).add(str5);
              localVector2.add(Long.valueOf(l2));
              ad.d("MicroMsg.VideoInfoStorage", "checkVideoHash cursor hitCount:%d/%d ,max:%d vector:%d/%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i1), localVector1.get(i), Integer.valueOf(i), Integer.valueOf(localVector1.size()) });
            }
          }
          localCursor.close();
          if ((i < 0) || (localVector1.size() <= 0))
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(12696, new Object[] { Integer.valueOf(201), Integer.valueOf(n) });
            ad.w("MicroMsg.VideoInfoStorage", "checkVideoHash cursor empty maxHitIndex:%d vector:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localVector1.size()) });
            localObject2 = "";
          }
          else
          {
            i1 = ((Integer)localVector1.get(i)).intValue();
            i2 = i1 * 100 / 256;
            if (i2 < 77)
            {
              com.tencent.mm.plugin.report.service.h.vKh.f(12696, new Object[] { Integer.valueOf(202), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(0), Integer.valueOf(localVector2.size()) });
              ad.w("MicroMsg.VideoInfoStorage", "checkVideoHash NotEnoughHit. time:%d hit:%d percentMatch:%s arr:%d path:%s", new Object[] { Long.valueOf(bt.vM(l1)), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(localObject2.length - 1), str2 });
              localObject2 = "";
            }
            else
            {
              localObject2 = bt.nullAsNil((String)((Vector)localObject5).get(i));
              j = 0;
              k = 0;
              label2300:
              if (k < localVector1.size())
              {
                if ((k == i) || (((Integer)localVector1.get(k)).intValue() < i1) || (((String)localObject2).hashCode() == ((String)((Vector)localObject5).get(k)).hashCode())) {
                  break label2931;
                }
                j += 1;
                break label2969;
              }
              if (j <= 0) {
                break label2507;
              }
              ((t)localObject3).gPa.execSQL("VideoHash", "delete from VideoHash where size = ".concat(String.valueOf(n)));
              com.tencent.mm.plugin.report.service.h.vKh.f(12696, new Object[] { Integer.valueOf(203), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(0), Integer.valueOf(localVector2.size()), Integer.valueOf(0), "", "", "", Integer.valueOf(j) });
              ad.e("MicroMsg.VideoInfoStorage", "checkVideoHash Not ONE hash hit this path, give up duplicate:%s path:%s", new Object[] { Integer.valueOf(j), str2 });
              localObject2 = "";
            }
          }
        }
      }
      label2507:
      l1 = bt.vM(l1);
      long l2 = bt.a((Long)localVector2.get(i), 0L);
      localObject5 = String.format("%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(n), Integer.valueOf(i1), Long.valueOf(l2), Integer.valueOf(localVector2.size()), Long.valueOf(l1) });
      com.tencent.mm.plugin.report.service.h.vKh.f(12696, new Object[] { Integer.valueOf(300), localObject5 });
      com.tencent.mm.plugin.report.service.h.vKh.f(12696, new Object[] { Integer.valueOf(i2 + 3000), localObject5 });
      ad.i("MicroMsg.VideoInfoStorage", "checkVideoHash Succ time:%s hit:%s match:%s%% savetime:%s path:%s xml:%s orgpath:%s", new Object[] { Long.valueOf(l1), Integer.valueOf(i1), Integer.valueOf(i2), Long.valueOf(l2), str2, localObject2, ((Vector)localObject4).get(i) });
      localObject4 = (String)((Vector)localObject4).get(i);
      l1 = bt.eGO() % 1000L;
      if (l1 < m * 10) {
        break label2976;
      }
      if (i2 < 90) {
        break label2976;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff should:%s now:%s ratio:%s percentMatch:%s debuger:%s", new Object[] { Boolean.valueOf(bool4), Long.valueOf(l1), Integer.valueOf(m), Integer.valueOf(i2), Boolean.valueOf(com.tencent.mm.sdk.a.b.eEQ()) });
      if ((bool4) || (com.tencent.mm.sdk.a.b.eEQ())) {
        com.tencent.mm.sdk.g.b.d(new t.2((t)localObject3, str2, (String)localObject4, (String)localObject5), "checkVideoHashByteDiff");
      }
      break label1267;
      boolean bool4 = false;
      continue;
      label2844:
      localObject2 = null;
      break label1285;
      if (this.hyO)
      {
        i = 2;
        break;
      }
      i = 0;
      break;
      label2867:
      if (this.hyn.hAm != 1)
      {
        this.hyn.hAm = 1;
        this.hyn.status = 104;
        this.hyn.clientId = this.hhN;
        this.hyn.dtM = 524544;
        u.f(this.hyn);
      }
      AppMethodBeat.o(126857);
      return true;
      label2931:
      break label2969;
      label2934:
      break label1949;
      label2937:
      break label2962;
      label2940:
      bool4 = bool1;
      bool1 = bool2;
      bool2 = bool4;
      break label1180;
      label2955:
      j = 0;
      k = 0;
      break label1886;
      label2962:
      k += 1;
      break label1886;
      label2969:
      k += 1;
      break label2300;
      label2976:
      bool4 = true;
    }
  }
  
  private String aCy()
  {
    AppMethodBeat.i(126865);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(126865);
    return str;
  }
  
  /* Error */
  private String zG(String paramString)
  {
    // Byte code:
    //   0: ldc_w 763
    //   3: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 765	com/tencent/mm/vfs/e
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 766	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   14: astore 9
    //   16: new 765	com/tencent/mm/vfs/e
    //   19: dup
    //   20: aload 9
    //   22: invokevirtual 770	com/tencent/mm/vfs/e:fhT	()Lcom/tencent/mm/vfs/e;
    //   25: new 546	java/lang/StringBuilder
    //   28: dup
    //   29: ldc_w 772
    //   32: invokespecial 550	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: aload 9
    //   37: invokevirtual 775	com/tencent/mm/vfs/e:getName	()Ljava/lang/String;
    //   40: invokevirtual 703	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokespecial 778	com/tencent/mm/vfs/e:<init>	(Lcom/tencent/mm/vfs/e;Ljava/lang/String;)V
    //   49: astore 10
    //   51: aconst_null
    //   52: astore 7
    //   54: aconst_null
    //   55: astore 8
    //   57: aconst_null
    //   58: astore 5
    //   60: aconst_null
    //   61: astore 6
    //   63: ldc 126
    //   65: ldc_w 780
    //   68: iconst_1
    //   69: anewarray 171	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload 9
    //   76: invokevirtual 782	com/tencent/mm/vfs/e:length	()J
    //   79: invokestatic 636	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   82: aastore
    //   83: invokestatic 640	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: aload 9
    //   88: invokevirtual 782	com/tencent/mm/vfs/e:length	()J
    //   91: ldc2_w 783
    //   94: lcmp
    //   95: ifle +584 -> 679
    //   98: aload 10
    //   100: invokevirtual 787	com/tencent/mm/vfs/e:exists	()Z
    //   103: ifeq +122 -> 225
    //   106: ldc 126
    //   108: ldc_w 789
    //   111: iconst_1
    //   112: anewarray 171	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload 10
    //   119: invokevirtual 793	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
    //   122: invokestatic 799	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   125: aastore
    //   126: invokestatic 640	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: iconst_1
    //   130: istore_2
    //   131: aload 8
    //   133: astore 4
    //   135: aload 6
    //   137: astore 5
    //   139: aload 4
    //   141: ifnull +8 -> 149
    //   144: aload 4
    //   146: invokevirtual 802	java/io/InputStream:close	()V
    //   149: iload_2
    //   150: istore_3
    //   151: aload 5
    //   153: ifnull +10 -> 163
    //   156: aload 5
    //   158: invokevirtual 805	java/io/OutputStream:close	()V
    //   161: iload_2
    //   162: istore_3
    //   163: iload_3
    //   164: ifeq +396 -> 560
    //   167: ldc 126
    //   169: ldc_w 807
    //   172: iconst_3
    //   173: anewarray 171	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload_0
    //   179: invokespecial 175	com/tencent/mm/modelvideo/g:aCy	()Ljava/lang/String;
    //   182: aastore
    //   183: dup
    //   184: iconst_1
    //   185: aload 10
    //   187: invokevirtual 782	com/tencent/mm/vfs/e:length	()J
    //   190: invokestatic 636	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   193: aastore
    //   194: dup
    //   195: iconst_2
    //   196: aload 10
    //   198: invokevirtual 793	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
    //   201: invokestatic 799	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   204: aastore
    //   205: invokestatic 183	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   208: aload 10
    //   210: invokevirtual 793	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
    //   213: invokestatic 799	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   216: astore_1
    //   217: ldc_w 763
    //   220: invokestatic 186	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: aload_1
    //   224: areturn
    //   225: aload 9
    //   227: invokevirtual 793	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
    //   230: invokestatic 799	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   233: invokestatic 813	com/tencent/mm/sdk/platformtools/f:aFf	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   236: astore 11
    //   238: aload 11
    //   240: ifnonnull +121 -> 361
    //   243: ldc_w 346
    //   246: astore 4
    //   248: ldc 126
    //   250: ldc_w 815
    //   253: iconst_1
    //   254: anewarray 171	java/lang/Object
    //   257: dup
    //   258: iconst_0
    //   259: aload 4
    //   261: aastore
    //   262: invokestatic 183	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   265: aload 11
    //   267: ifnull +131 -> 398
    //   270: aload 11
    //   272: getfield 820	android/graphics/BitmapFactory$Options:outWidth	I
    //   275: sipush 288
    //   278: if_icmpgt +14 -> 292
    //   281: aload 11
    //   283: getfield 823	android/graphics/BitmapFactory$Options:outHeight	I
    //   286: sipush 288
    //   289: if_icmple +109 -> 398
    //   292: aload 9
    //   294: invokevirtual 793	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
    //   297: invokestatic 799	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   300: sipush 288
    //   303: sipush 288
    //   306: getstatic 829	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   309: bipush 60
    //   311: new 546	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 700	java/lang/StringBuilder:<init>	()V
    //   318: aload 10
    //   320: invokevirtual 770	com/tencent/mm/vfs/e:fhT	()Lcom/tencent/mm/vfs/e;
    //   323: invokevirtual 793	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
    //   326: invokestatic 799	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   329: invokevirtual 703	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: ldc_w 831
    //   335: invokevirtual 703	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: aload 10
    //   343: invokevirtual 775	com/tencent/mm/vfs/e:getName	()Ljava/lang/String;
    //   346: invokestatic 834	com/tencent/mm/sdk/platformtools/f:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;)Z
    //   349: istore_2
    //   350: aload 6
    //   352: astore 5
    //   354: aload 8
    //   356: astore 4
    //   358: goto -219 -> 139
    //   361: new 546	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 700	java/lang/StringBuilder:<init>	()V
    //   368: aload 11
    //   370: getfield 820	android/graphics/BitmapFactory$Options:outWidth	I
    //   373: invokevirtual 709	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: ldc_w 836
    //   379: invokevirtual 703	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload 11
    //   384: getfield 823	android/graphics/BitmapFactory$Options:outHeight	I
    //   387: invokevirtual 709	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   390: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: astore 4
    //   395: goto -147 -> 248
    //   398: aload 9
    //   400: invokestatic 840	com/tencent/mm/vfs/i:ah	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   403: astore 4
    //   405: aload 4
    //   407: fconst_0
    //   408: sipush 288
    //   411: sipush 288
    //   414: invokestatic 843	com/tencent/mm/sdk/platformtools/f:a	(Ljava/io/InputStream;FII)Landroid/graphics/Bitmap;
    //   417: astore 8
    //   419: aload 8
    //   421: ifnull +249 -> 670
    //   424: aload 10
    //   426: invokestatic 847	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   429: astore 6
    //   431: aload 6
    //   433: astore 5
    //   435: aload 5
    //   437: astore 7
    //   439: aload 4
    //   441: astore 6
    //   443: aload 8
    //   445: getstatic 829	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   448: bipush 60
    //   450: aload 5
    //   452: invokevirtual 853	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   455: istore_2
    //   456: goto -317 -> 139
    //   459: astore 8
    //   461: aconst_null
    //   462: astore 5
    //   464: aconst_null
    //   465: astore 4
    //   467: aload 5
    //   469: astore 7
    //   471: aload 4
    //   473: astore 6
    //   475: ldc 126
    //   477: ldc_w 855
    //   480: iconst_1
    //   481: anewarray 171	java/lang/Object
    //   484: dup
    //   485: iconst_0
    //   486: aload 8
    //   488: invokestatic 532	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   491: aastore
    //   492: invokestatic 449	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   495: aload 4
    //   497: ifnull +8 -> 505
    //   500: aload 4
    //   502: invokevirtual 802	java/io/InputStream:close	()V
    //   505: aload 5
    //   507: ifnull +158 -> 665
    //   510: aload 5
    //   512: invokevirtual 805	java/io/OutputStream:close	()V
    //   515: iconst_0
    //   516: istore_3
    //   517: goto -354 -> 163
    //   520: astore 4
    //   522: iconst_0
    //   523: istore_3
    //   524: goto -361 -> 163
    //   527: astore_1
    //   528: aload 7
    //   530: astore 4
    //   532: aload 4
    //   534: ifnull +8 -> 542
    //   537: aload 4
    //   539: invokevirtual 802	java/io/InputStream:close	()V
    //   542: aload 5
    //   544: ifnull +8 -> 552
    //   547: aload 5
    //   549: invokevirtual 805	java/io/OutputStream:close	()V
    //   552: ldc_w 763
    //   555: invokestatic 186	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   558: aload_1
    //   559: athrow
    //   560: ldc 126
    //   562: ldc_w 857
    //   565: iconst_3
    //   566: anewarray 171	java/lang/Object
    //   569: dup
    //   570: iconst_0
    //   571: aload_0
    //   572: invokespecial 175	com/tencent/mm/modelvideo/g:aCy	()Ljava/lang/String;
    //   575: aastore
    //   576: dup
    //   577: iconst_1
    //   578: aload 9
    //   580: invokevirtual 782	com/tencent/mm/vfs/e:length	()J
    //   583: invokestatic 636	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   586: aastore
    //   587: dup
    //   588: iconst_2
    //   589: aload 9
    //   591: invokevirtual 793	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
    //   594: invokestatic 799	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   597: aastore
    //   598: invokestatic 183	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   601: ldc_w 763
    //   604: invokestatic 186	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   607: aload_1
    //   608: areturn
    //   609: astore 4
    //   611: goto -462 -> 149
    //   614: astore 4
    //   616: iload_2
    //   617: istore_3
    //   618: goto -455 -> 163
    //   621: astore 4
    //   623: goto -118 -> 505
    //   626: astore 4
    //   628: goto -86 -> 542
    //   631: astore 4
    //   633: goto -81 -> 552
    //   636: astore_1
    //   637: goto -105 -> 532
    //   640: astore_1
    //   641: aload 7
    //   643: astore 5
    //   645: aload 6
    //   647: astore 4
    //   649: goto -117 -> 532
    //   652: astore 8
    //   654: aconst_null
    //   655: astore 5
    //   657: goto -190 -> 467
    //   660: astore 8
    //   662: goto -195 -> 467
    //   665: iconst_0
    //   666: istore_3
    //   667: goto -504 -> 163
    //   670: iconst_0
    //   671: istore_2
    //   672: aload 6
    //   674: astore 5
    //   676: goto -537 -> 139
    //   679: iconst_0
    //   680: istore_2
    //   681: aload 6
    //   683: astore 5
    //   685: aload 8
    //   687: astore 4
    //   689: goto -550 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	692	0	this	g
    //   0	692	1	paramString	String
    //   130	551	2	bool1	boolean
    //   150	517	3	bool2	boolean
    //   133	368	4	localObject1	Object
    //   520	1	4	localIOException1	java.io.IOException
    //   530	8	4	localObject2	Object
    //   609	1	4	localIOException2	java.io.IOException
    //   614	1	4	localIOException3	java.io.IOException
    //   621	1	4	localIOException4	java.io.IOException
    //   626	1	4	localIOException5	java.io.IOException
    //   631	1	4	localIOException6	java.io.IOException
    //   647	41	4	localObject3	Object
    //   58	626	5	localObject4	Object
    //   61	621	6	localObject5	Object
    //   52	590	7	localObject6	Object
    //   55	389	8	localBitmap	android.graphics.Bitmap
    //   459	28	8	localException1	Exception
    //   652	1	8	localException2	Exception
    //   660	26	8	localException3	Exception
    //   14	576	9	locale1	com.tencent.mm.vfs.e
    //   49	376	10	locale2	com.tencent.mm.vfs.e
    //   236	147	11	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   86	129	459	java/lang/Exception
    //   225	238	459	java/lang/Exception
    //   248	265	459	java/lang/Exception
    //   270	292	459	java/lang/Exception
    //   292	350	459	java/lang/Exception
    //   361	395	459	java/lang/Exception
    //   398	405	459	java/lang/Exception
    //   510	515	520	java/io/IOException
    //   86	129	527	finally
    //   225	238	527	finally
    //   248	265	527	finally
    //   270	292	527	finally
    //   292	350	527	finally
    //   361	395	527	finally
    //   398	405	527	finally
    //   144	149	609	java/io/IOException
    //   156	161	614	java/io/IOException
    //   500	505	621	java/io/IOException
    //   537	542	626	java/io/IOException
    //   547	552	631	java/io/IOException
    //   405	419	636	finally
    //   424	431	636	finally
    //   443	456	640	finally
    //   475	495	640	finally
    //   405	419	652	java/lang/Exception
    //   424	431	652	java/lang/Exception
    //   443	456	660	java/lang/Exception
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(126856);
    ad.i("MicroMsg.NetSceneUploadVideo", "%s stop %s", new Object[] { aCy(), this.hhN });
    if (!bt.isNullOrNil(this.hhN)) {
      com.tencent.mm.ao.f.awL().xK(this.hhN);
    }
    this.hyq = true;
    super.cancel();
    AppMethodBeat.o(126856);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(126859);
    this.callback = paramg;
    this.hyn = u.Ae(this.fileName);
    if ((this.hyn == null) || ((this.hyn.status != 104) && (this.hyn.status != 103)))
    {
      ad.e("MicroMsg.NetSceneUploadVideo", "%s Get info Failed file:", new Object[] { aCy(), this.fileName });
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(126859);
      return -1;
    }
    paramg = new StringBuilder("doscene file:").append(this.fileName).append(" stat:").append(this.hyn.status).append(" [").append(this.hyn.hAe).append(",").append(this.hyn.hAf).append("] [").append(this.hyn.hyM).append(",").append(this.hyn.gTY).append("]  netTimes:").append(this.hyn.hAj).append(" times:");
    int i = this.hyR;
    this.hyR = (i + 1);
    ad.d("MicroMsg.NetSceneUploadVideo", i);
    if (this.startTime == 0L)
    {
      this.startTime = bt.eGO();
      this.hyM = this.hyn.hyM;
    }
    o.aCI();
    if (r.zL(t.zQ(this.fileName)))
    {
      ad.w("MicroMsg.NetSceneUploadVideo", "%s it is mm h265 video xml[%s]", new Object[] { aCy(), this.hyn.aCT() });
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 139L, 1L, false);
    }
    if (aCx())
    {
      ad.d("MicroMsg.NetSceneUploadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { this.fileName });
      AppMethodBeat.o(126859);
      return 0;
    }
    dib localdib;
    if (this.hyn.hAl == 1)
    {
      this.cVU = true;
      paramg = new b.a();
      paramg.gUU = new dib();
      paramg.gUV = new dic();
      paramg.uri = "/cgi-bin/micromsg-bin/uploadvideo";
      paramg.funcId = 149;
      paramg.reqCmdId = 39;
      paramg.respCmdId = 1000000039;
      this.rr = paramg.atI();
      localdib = (dib)this.rr.gUS.gUX;
      localdib.sdQ = ((String)com.tencent.mm.kernel.g.afB().afk().get(2, ""));
      localdib.sdP = this.hyn.getUser();
      localdib.CyF = this.fileName;
      if (this.cVU) {
        localdib.CID = 2;
      }
      if (this.hyn.hAo == 3) {
        localdib.CID = 3;
      }
      localdib.Ekx = this.hyn.gOY;
      localdib.DMo = this.hyn.hAf;
      localdib.Eyf = this.hyn.gTY;
      if (!ae.cJ(aj.getContext())) {
        break label1299;
      }
      i = 1;
      label583:
      localdib.DcM = i;
      localdib.DMr = 2;
      localdib.Eyg = 0;
      localdib.Eyh = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      localdib.DMq = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      if (!bt.isNullOrNil(this.dyw)) {
        break label1304;
      }
      o.aCI();
      paramg = com.tencent.mm.vfs.i.aEN(t.zQ(this.fileName));
      this.dyw = paramg;
      label667:
      localdib.Eyk = paramg;
      if (bt.isNullOrNil(this.hyn.hAt)) {
        break label1312;
      }
      paramg = bk.up(this.hyn.hAt);
      label697:
      localObject = paramg;
      if (bt.isNullOrNil(paramg)) {
        localObject = bk.SM();
      }
      ad.i("MicroMsg.NetSceneUploadVideo", "video msg source is %s".concat(String.valueOf(localObject)));
      localdib.CxC = ((String)localObject);
      localdib.Eyt = this.hyn.dxG;
      paramg = this.hyn.hAq;
      if ((paramg == null) || (bt.isNullOrNil(paramg.gJv))) {
        break label1389;
      }
      localdib.Eyl = bt.by(paramg.gJv, "");
      localdib.Eym = paramg.Dim;
      localdib.Eyn = bt.by(paramg.gJx, "");
      localdib.Eyp = bt.by(paramg.gJz, "");
      localdib.Eyo = bt.by(paramg.gJy, "");
      localdib.Eyq = bt.by(paramg.gJA, "");
    }
    for (;;)
    {
      if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(this.hyn.getUser())) {
        localdib.COT = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aIi(this.hyn.getUser());
      }
      if (paramg != null)
      {
        localdib.Eys = bt.by(paramg.gJB, "");
        localdib.Eyr = bt.by(paramg.gJC, "");
      }
      ad.d("MicroMsg.NetSceneUploadVideo", "upload video: play length %d, thumb totalLen %d, video totalLen %d, funcFlag %d, videoMd5: %s stream %s streamtime: %d title %s thumburl %s", new Object[] { Integer.valueOf(localdib.Ekx), Integer.valueOf(localdib.DMp), Integer.valueOf(localdib.Eyf), Integer.valueOf(localdib.CID), localdib.Eyk, localdib.Eyl, Integer.valueOf(localdib.Eym), localdib.Eyn, localdib.Eyq });
      if (this.hyn.status != 103) {
        break label1682;
      }
      o.aCI();
      paramg = t.s(t.zR(this.fileName), this.hyn.hAe, hyK);
      if ((paramg.ret >= 0) && (paramg.cZc != 0)) {
        break label1434;
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 225L, 1L, false);
      u.zV(this.fileName);
      ad.e("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "]  Error ");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(126859);
      return -1;
      if (this.hyn.createTime + 600L < bt.aGK())
      {
        ad.e("MicroMsg.NetSceneUploadVideo", "create time check error:" + this.fileName);
        u.zV(this.fileName);
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        AppMethodBeat.o(126859);
        return -1;
      }
      if (u.zU(this.fileName)) {
        break;
      }
      ad.e("MicroMsg.NetSceneUploadVideo", "checkVoiceNetTimes Failed file:" + this.fileName);
      u.zV(this.fileName);
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(126859);
      return -1;
      label1299:
      i = 2;
      break label583;
      label1304:
      paramg = this.dyw;
      break label667;
      label1312:
      if (this.hyn.hAs > 0)
      {
        paramg = bk.up(bk.uo(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(this.hyn.hAs).esh));
        break label697;
      }
      paramg = com.tencent.mm.vfs.i.aEN(this.hyn.aCS());
      localObject = v.hUC;
      paramg = bk.up(v.BC(paramg));
      break label697;
      label1389:
      if ((paramg != null) && (!bt.isNullOrNil(paramg.gJz)) && (!bt.isNullOrNil(paramg.gJy)))
      {
        localdib.Eyp = paramg.gJz;
        localdib.Eyo = paramg.gJy;
      }
    }
    label1434:
    ad.d("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "] read ret:" + paramg.ret + " readlen:" + paramg.cZc + " newOff:" + paramg.hAL + " netOff:" + this.hyn.hAe);
    if (paramg.hAL < this.hyn.hAe)
    {
      ad.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ THUMB[" + this.fileName + "] newOff:" + paramg.hAL + " OldtOff:" + this.hyn.hAe);
      u.zV(this.fileName);
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(126859);
      return -1;
    }
    Object localObject = new byte[paramg.cZc];
    System.arraycopy(paramg.buf, 0, localObject, 0, paramg.cZc);
    localdib.DMp = this.hyn.hAe;
    localdib.DMq = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
    for (;;)
    {
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(126859);
      return i;
      label1682:
      o.aCI();
      paramg = t.s(t.zQ(this.fileName), this.hyn.hyM, hyK);
      if ((paramg.ret < 0) || (paramg.cZc == 0))
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 224L, 1L, false);
        u.zV(this.fileName);
        ad.e("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "]  Error ");
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        AppMethodBeat.o(126859);
        return -1;
      }
      ad.d("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "] read ret:" + paramg.ret + " readlen:" + paramg.cZc + " newOff:" + paramg.hAL + " netOff:" + this.hyn.hyM);
      if (paramg.hAL < this.hyn.hyM)
      {
        ad.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] newOff:" + paramg.hAL + " OldtOff:" + this.hyn.hyM);
        u.zV(this.fileName);
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        AppMethodBeat.o(126859);
        return -1;
      }
      if (paramg.hAL >= c.hxJ)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 222L, 1L, false);
        ad.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] maxsize:" + c.hxJ);
        u.zV(this.fileName);
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        AppMethodBeat.o(126859);
        return -1;
      }
      localObject = new byte[paramg.cZc];
      System.arraycopy(paramg.buf, 0, localObject, 0, paramg.cZc);
      localdib.Eyg = this.hyn.hyM;
      localdib.DMp = this.hyn.hAe;
      localdib.Eyh = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
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
    ad.i("MicroMsg.NetSceneUploadVideo", "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.hhN);
    if (this.hyq)
    {
      ad.d("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Call Stop by Service   file:" + this.fileName + " user:" + this.hyn.getUser());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    paramArrayOfByte = (dic)((com.tencent.mm.al.b)paramq).gUT.gUX;
    paramq = (dib)((com.tencent.mm.al.b)paramq).gUS.gUX;
    if ((paramArrayOfByte != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(paramArrayOfByte.COU);
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bt.isNullOrNil(this.hhN)))
    {
      ad.w("MicroMsg.NetSceneUploadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.hhN });
      AppMethodBeat.o(126863);
      return;
    }
    this.hyn = u.Ae(this.fileName);
    if (this.hyn == null)
    {
      ad.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if (this.hyn.status == 105)
    {
      ad.w("MicroMsg.NetSceneUploadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.hyn.drA + "," + this.hyn.aCQ() + "," + this.hyn.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((this.hyn.status != 104) && (this.hyn.status != 103))
    {
      ad.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.hyn.status + " [" + this.fileName + "," + this.hyn.drA + "," + this.hyn.aCQ() + "," + this.hyn.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      ad.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd BLACK  errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.hyn.getUser());
      u.zW(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 220L, 1L, false);
      ad.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.hyn.getUser());
      u.zV(this.fileName);
      com.tencent.mm.plugin.report.service.h.vKh.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(this.hyp), Integer.valueOf(0) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 219L, 1L, false);
      ad.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.hyn.getUser());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((!bt.cw(paramq.DMq.getBuffer().wA)) && (paramq.DMp != paramArrayOfByte.DMp - paramq.DMq.getILen()))
    {
      ad.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + paramq.DMp + "," + paramq.DMq.getILen() + "," + paramArrayOfByte.DMp + "] file:" + this.fileName + " user:" + paramq.sdP);
      u.zV(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    if ((!bt.cw(paramq.Eyh.getBuffer().wA)) && (paramq.Eyg != paramArrayOfByte.Eyg - paramq.Eyh.getILen()))
    {
      ad.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + paramq.Eyg + "," + paramq.Eyh.getILen() + "," + paramArrayOfByte.Eyg + "] file:" + this.fileName + " user:" + paramq.sdP);
      u.zV(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126863);
      return;
    }
    this.hyn.hAg = bt.aGK();
    this.hyn.drA = paramArrayOfByte.uKZ;
    this.hyn.dtM = 1028;
    ad.d("MicroMsg.NetSceneUploadVideo", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(this.hyn.drA), Integer.valueOf(com.tencent.mm.platformtools.ab.hVD) });
    if ((10007 == com.tencent.mm.platformtools.ab.hVC) && (com.tencent.mm.platformtools.ab.hVD != 0) && (this.hyn.drA != 0L))
    {
      this.hyn.drA = com.tencent.mm.platformtools.ab.hVD;
      com.tencent.mm.platformtools.ab.hVD = 0;
    }
    paramInt1 = this.hyn.status;
    s locals;
    if (paramInt1 == 103)
    {
      locals = this.hyn;
      paramInt1 = paramq.DMp;
      locals.hAe = (paramq.DMq.getILen() + paramInt1);
      this.hyn.dtM |= 0x40;
      if (this.hyn.hAe < this.hyn.hAf) {
        break label2369;
      }
      this.hyn.status = 104;
      this.hyn.dtM |= 0x100;
      paramInt1 = 0;
    }
    for (;;)
    {
      u.f(this.hyn);
      if (this.hyq)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(126863);
        return;
        if (paramInt1 == 104)
        {
          locals = this.hyn;
          paramInt1 = paramq.Eyg;
          locals.hyM = (paramq.Eyh.getILen() + paramInt1);
          this.hyn.dtM |= 0x8;
          if (this.hyn.hyM >= this.hyn.gTY)
          {
            this.hyn.status = 199;
            this.hyn.dtM |= 0x100;
            u.d(this.hyn);
            paramInt1 = 1;
          }
        }
        else
        {
          ad.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd ERROR STATUS:" + paramInt1 + " file:" + this.fileName + " user:" + paramq.sdP);
          u.zV(this.fileName);
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(126863);
        }
      }
      else
      {
        if (paramInt1 == 0)
        {
          this.gTs.av(10L, 10L);
          AppMethodBeat.o(126863);
          return;
        }
        paramq = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(this.hyn.hAi);
        paramq.mZ(paramArrayOfByte.CxC);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(paramq.field_msgId, paramq);
        com.tencent.mm.modelstat.b.huc.q(paramq);
        com.tencent.mm.plugin.report.service.h.vKh.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(this.hyp), Integer.valueOf(this.hyn.gTY - this.hyM) });
        boolean bool;
        if (this.hyn == null)
        {
          bool = false;
          if ((!bool) && (!w.sQ(this.hyn.getUser()))) {
            break label2275;
          }
          ad.i("MicroMsg.NetSceneUploadVideo", "upload to biz :%s", new Object[] { this.hyn.getUser() });
          if (this.hyn.drA < 0L)
          {
            ad.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.hyn.drA + " file:" + this.fileName + " toUser:" + this.hyn.getUser());
            u.zV(this.fileName);
          }
          label2008:
          if (this.ghu == null) {
            break label2363;
          }
        }
        label2363:
        for (long l = this.ghu.XK();; l = 0L)
        {
          ad.d("MicroMsg.NetSceneUploadVideo", "!!!FIN: file:" + this.fileName + " toUser:" + this.hyn.getUser() + " msgsvrid:" + this.hyn.drA + " thumbsize:" + this.hyn.hAf + " videosize:" + this.hyn.gTY + " useTime:" + l);
          ad.d("MicroMsg.NetSceneUploadVideo", "FinishLogForTime file:" + this.fileName + " packSize:" + hyK + " filesize:" + this.hyn.gTY + " useTime:" + l);
          a.a(this.hyn, 0);
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(126863);
          return;
          paramq = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.hyn.getUser());
          if ((paramq == null) || ((int)paramq.fId <= 0))
          {
            bool = false;
            break;
          }
          bool = paramq.eKB();
          break;
          label2275:
          ad.i("MicroMsg.NetSceneUploadVideo", "not upload to biz");
          if (this.hyn.drA > 0L) {
            break label2008;
          }
          ad.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.hyn.drA + " file:" + this.fileName + " toUser:" + this.hyn.getUser());
          u.zV(this.fileName);
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
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 210L, 1L, false);
    }
    AppMethodBeat.o(126862);
    return bool;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    AppMethodBeat.i(126860);
    paramq = (dib)((com.tencent.mm.al.b)paramq).gUS.gUX;
    if ((bt.isNullOrNil(paramq.CyF)) || (paramq.DMr <= 0) || (bt.isNullOrNil(paramq.sdQ)) || (bt.isNullOrNil(paramq.sdP)) || (paramq.DcM <= 0) || (paramq.DMp > paramq.DMo) || (paramq.DMp < 0) || (paramq.Eyg > paramq.Eyf) || (paramq.Eyg < 0) || ((paramq.Eyg == paramq.Eyf) && (paramq.DMp == paramq.DMo)) || (paramq.DMo <= 0) || (paramq.Eyf <= 0) || ((paramq.Eyh.getILen() <= 0) && (paramq.DMq.getILen() <= 0)))
    {
      ad.e("MicroMsg.NetSceneUploadVideo", "ERR: Security Check Failed file:" + this.fileName + " user:" + paramq.sdP);
      paramq = n.b.gVC;
      AppMethodBeat.o(126860);
      return paramq;
    }
    paramq = n.b.gVB;
    AppMethodBeat.o(126860);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(126861);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 221L, 1L, false);
    u.zV(this.fileName);
    AppMethodBeat.o(126861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.g
 * JD-Core Version:    0.7.0.1
 */