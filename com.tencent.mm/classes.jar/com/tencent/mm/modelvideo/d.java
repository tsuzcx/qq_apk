package com.tencent.mm.modelvideo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.al.c;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.model.n;
import com.tencent.mm.network.ac;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.yu;
import com.tencent.mm.protocal.protobuf.yv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import java.util.HashSet;
import java.util.Map;
import junit.framework.Assert;

public final class d
  extends m
  implements k
{
  private String cBO;
  com.tencent.mm.ai.f callback;
  String fFo;
  String fFv;
  int fFw;
  private g.a fFy;
  boolean fVB;
  boolean fVC;
  s fVD;
  com.tencent.mm.i.h fVE;
  int fVF;
  private boolean fVG;
  boolean fVH;
  long fVI;
  String fileName;
  private ap frx;
  int fsd;
  int retCode;
  private com.tencent.mm.ai.b rr;
  private int startOffset;
  long startTime;
  
  public d(String paramString)
  {
    this(paramString, false);
  }
  
  public d(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(50670);
    this.fVD = null;
    this.fFo = "";
    this.startOffset = 0;
    this.startTime = 0L;
    this.fsd = 0;
    this.retCode = 0;
    this.fVF = com.tencent.mm.i.a.MediaType_VIDEO;
    this.fVG = false;
    this.fVH = true;
    this.fFv = null;
    this.fFw = 0;
    this.fVI = 0L;
    this.fFy = new d.1(this);
    this.frx = new ap(new d.3(this), false);
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.fileName = paramString;
      this.fVB = paramBoolean;
      ab.i("MicroMsg.NetSceneDownloadVideo", "%s NetSceneDownloadVideo:  file [%s] isCompleteOnlineVideo [%b]", new Object[] { alu(), paramString, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(50670);
      return;
    }
  }
  
  private boolean alt()
  {
    AppMethodBeat.i(50671);
    ab.d("MicroMsg.NetSceneDownloadVideo", "%s parseVideoMsgXML content: %s", new Object[] { alu(), this.fVD.alP() });
    Object localObject4 = br.F(this.fVD.alP(), "msg");
    if (localObject4 == null)
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 214L, 1L, false);
      ab.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", new Object[] { alu() });
      AppMethodBeat.o(50671);
      return false;
    }
    String str1 = (String)((Map)localObject4).get(".msg.videomsg.$cdnvideourl");
    Object localObject1 = (String)((Map)localObject4).get(".msg.videomsg.$tpvideourl");
    if ((bo.isNullOrNil(str1)) && (bo.isNullOrNil((String)localObject1)))
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 213L, 1L, false);
      ab.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", new Object[] { alu() });
      AppMethodBeat.o(50671);
      return false;
    }
    Object localObject5 = (String)((Map)localObject4).get(".msg.videomsg.$aeskey");
    this.fsd = bo.getInt((String)((Map)localObject4).get(".msg.videomsg.$length"), 0);
    String str2 = (String)((Map)localObject4).get(".msg.videomsg.$fileparam");
    this.fFo = c.a("downvideo", this.fVD.createTime, this.fVD.getUser(), this.fVD.getFileName());
    if (bo.isNullOrNil(this.fFo))
    {
      ab.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra genClientId failed not use cdn file:%s", new Object[] { alu(), this.fVD.getFileName() });
      AppMethodBeat.o(50671);
      return false;
    }
    if ((!this.fVB) && (this.fsd < 1048576) && (this.fVD != null) && (this.fVD.czu > 0))
    {
      this.fVB = true;
      ab.i("MicroMsg.NetSceneDownloadVideo", "%s less 1M and had preload, reset isCompleteOnlineVideo [%b]", new Object[] { alu(), Boolean.valueOf(this.fVB) });
    }
    Object localObject2 = (String)((Map)localObject4).get(".msg.videomsg.$md5");
    Object localObject3 = new StringBuilder();
    o.alE();
    localObject3 = t.vf(this.fileName) + ".tmp";
    this.fVE = new com.tencent.mm.i.h();
    this.fVE.filename = this.fVD.getFileName();
    this.fVE.edH = ((String)localObject2);
    this.fVE.edI = this.fsd;
    this.fVE.edJ = 0;
    this.fVE.czp = this.fVD.alM();
    this.fVE.edK = this.fVD.getUser();
    com.tencent.mm.i.h localh = this.fVE;
    int i;
    label639:
    int k;
    if (com.tencent.mm.model.t.lA(this.fVD.getUser()))
    {
      i = n.nv(this.fVD.getUser());
      localh.czr = i;
      this.fVE.field_mediaId = this.fFo;
      this.fVE.field_fullpath = ((String)localObject3);
      this.fVE.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
      this.fVE.field_totalLen = this.fsd;
      this.fVE.field_aesKey = ((String)localObject5);
      this.fVE.field_fileId = str1;
      this.fVE.field_priority = com.tencent.mm.i.a.ecF;
      this.fVE.edp = this.fFy;
      this.fVE.field_wxmsgparam = str2;
      localObject5 = this.fVE;
      if (!com.tencent.mm.model.t.lA(this.fVD.getUser())) {
        break label1664;
      }
      i = 1;
      ((com.tencent.mm.i.h)localObject5).field_chattype = i;
      this.fVE.edL = this.fVD.edL;
      if (!bo.isNullOrNil((String)localObject1))
      {
        localObject4 = (String)((Map)localObject4).get(".msg.videomsg.$tpauthkey");
        this.fVE.field_fileId = "";
        this.fVE.field_fileType = 19;
        this.fVE.field_authKey = ((String)localObject4);
        this.fVE.eds = ((String)localObject1);
      }
      localObject4 = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().ag(this.fVD.getUser(), this.fVD.cFn);
      this.fVE.edN = ((dd)localObject4).field_createTime;
      this.fVE.cFn = ((dd)localObject4).field_msgSvrId;
      localObject1 = bf.pA(((dd)localObject4).dns);
      localObject5 = this.fVE;
      if (localObject1 == null) {
        break label1669;
      }
      i = ((bf.b)localObject1).fmU;
      label804:
      ((com.tencent.mm.i.h)localObject5).edO = i;
      if (this.fVD.getUser().equals(((dd)localObject4).field_talker))
      {
        localObject5 = this.fVE;
        if (localObject1 != null) {
          break label1674;
        }
        i = 0;
        label841:
        ((com.tencent.mm.i.h)localObject5).field_limitrate = i;
      }
      ab.d("MicroMsg.NetSceneDownloadVideo", "%s limitrate:%d file:%s", new Object[] { alu(), Integer.valueOf(this.fVE.field_limitrate), this.fVD.getFileName() });
      if (!com.tencent.mm.al.f.afO().fyQ.contains("video_" + this.fVD.fXy)) {
        break label1686;
      }
      com.tencent.mm.al.f.afO().fyQ.remove("video_" + this.fVD.fXy);
      this.fVE.field_autostart = true;
      label965:
      if (3 == this.fVD.fXE) {
        this.fVE.field_smallVideoFlag = 1;
      }
      if ((bo.isNullOrNil((String)localObject2)) || (this.fVB)) {
        break label1717;
      }
      localObject1 = ((com.tencent.mm.plugin.m.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.m.a.a.class)).YH().eG((String)localObject2, this.fsd);
      j = (int)com.tencent.mm.vfs.e.avI((String)localObject1);
      k = this.fsd - j;
      o.alE();
      localObject5 = t.vf(this.fileName);
      int m = (int)com.tencent.mm.vfs.e.avI((String)localObject5);
      if (m > 0)
      {
        ab.w("MicroMsg.NetSceneDownloadVideo", "%s already copy dup file, but download again, something error here.", new Object[] { alu() });
        bool = com.tencent.mm.vfs.e.deleteFile((String)localObject5);
        localObject1 = ((com.tencent.mm.plugin.m.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.m.a.a.class)).YH();
        int n = this.fsd;
        i = 0;
        if (!bo.isNullOrNil((String)localObject2)) {
          i = ((bh)localObject1).db.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[] { localObject2, String.valueOf(n), "100" });
        }
        localObject1 = u.vr(this.fileName);
        ((s)localObject1).fXs = 0;
        ((s)localObject1).bsY = 16;
        u.f((s)localObject1);
        ab.w("MicroMsg.NetSceneDownloadVideo", "%s don't copy dup file, go to download now. target video len %d, delete file:%b,delete db: %d", new Object[] { alu(), Integer.valueOf(m), Boolean.valueOf(bool), Integer.valueOf(i) });
        localObject1 = "";
      }
      ab.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage: totallen:%s md5:%s  dup(len:%d path:%s) diffLen:%d to:%s target video len %d", new Object[] { alu(), Integer.valueOf(this.fsd), localObject2, Integer.valueOf(j), localObject1, Integer.valueOf(k), localObject3, Integer.valueOf(m) });
      if (bo.isNullOrNil((String)localObject1)) {
        break label1703;
      }
      if ((k < 0) || (k > 16)) {
        break label1717;
      }
      ab.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage copy dup file now :%s -> %s", new Object[] { alu(), localObject1, localObject3 });
      com.tencent.mm.vfs.e.C((String)localObject1, (String)localObject3);
      ml(this.fsd);
      ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a(new h.c(((dd)localObject4).field_talker, "update", (bi)localObject4));
      localObject1 = com.tencent.mm.plugin.report.service.h.qsU;
      long l1 = this.fVD.cFn;
      long l2 = this.fVD.createTime;
      localObject3 = this.fVD.getUser();
      if (3 == this.fVD.fXE) {
        break label1697;
      }
      i = 43;
      label1450:
      ((com.tencent.mm.plugin.report.service.h)localObject1).e(13267, new Object[] { str1, Long.valueOf(l1), localObject2, Long.valueOf(l2), localObject3, Integer.valueOf(i), Integer.valueOf(j) });
      i = 1;
      label1511:
      if (i != 0) {
        break label1749;
      }
      this.cBO = this.fVE.field_mediaId;
      this.fVI = bo.aoy();
      if (this.fVD.videoFormat != 2) {
        break label1722;
      }
    }
    label1664:
    label1669:
    label1674:
    label1686:
    label1697:
    label1703:
    label1717:
    label1722:
    for (boolean bool = true;; bool = false)
    {
      this.fVC = bool;
      ab.i("MicroMsg.NetSceneDownloadVideo", "%s check use cdn isHadHevcLocalFile[%b] isCompleteOnlineVideo[%b]", new Object[] { alu(), Boolean.valueOf(this.fVC), Boolean.valueOf(this.fVB) });
      if (this.fVB) {
        break label1967;
      }
      if (com.tencent.mm.al.f.afO().b(this.fVE, -1)) {
        break label1728;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 212L, 1L, false);
      ab.e("MicroMsg.NetSceneDownloadVideo", "%s cdntra addSendTask failed.", new Object[] { alu() });
      this.fFo = "";
      AppMethodBeat.o(50671);
      return false;
      i = 0;
      break;
      i = 0;
      break label639;
      i = 0;
      break label804;
      i = ((bf.b)localObject1).fmS / 8;
      break label841;
      this.fVE.field_autostart = false;
      break label965;
      i = 62;
      break label1450;
      this.fFv = ((String)localObject2);
      this.fFw = this.fsd;
      i = 0;
      break label1511;
    }
    label1728:
    if (this.fVC) {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 135L, 1L, false);
    }
    label1749:
    if (this.fVD.fXC != 1)
    {
      this.fVD.fXC = 1;
      this.fVD.bsY = 524288;
      u.f(this.fVD);
    }
    if (3 != this.fVD.fXE)
    {
      localObject1 = this.fVD.getUser();
      if (!bo.isNullOrNil((String)localObject1)) {
        if (!com.tencent.mm.model.t.lA((String)localObject1)) {
          break label2140;
        }
      }
    }
    label1967:
    label2140:
    for (int j = n.nv((String)localObject1);; j = 0) {
      for (;;)
      {
        try
        {
          localObject2 = ((ConnectivityManager)ah.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
          i = ((NetworkInfo)localObject2).getSubtype();
          k = ((NetworkInfo)localObject2).getType();
          if (k != 1) {
            continue;
          }
          i = 1;
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.NetSceneDownloadVideo", "getNetType : %s", new Object[] { bo.l(localException) });
          i = 0;
          continue;
        }
        localObject1 = (String)localObject1 + "," + j + "," + str1 + "," + this.fsd + "," + i;
        ab.i("MicroMsg.NetSceneDownloadVideo", "%s dk12024 report:%s", new Object[] { alu(), localObject1 });
        com.tencent.mm.plugin.report.service.h.qsU.kvStat(12024, (String)localObject1);
        AppMethodBeat.o(50671);
        return true;
        this.fVH = false;
        localObject1 = this.fVE;
        o.alE();
        ((com.tencent.mm.i.h)localObject1).field_fullpath = t.vf(this.fileName);
        if (this.fVC)
        {
          this.fVE.field_requestVideoFormat = 2;
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 251L, 1L, false);
        }
        o.alF().a(this.fVE, false);
        break;
        if ((i == 13) || (i == 15) || (i == 14)) {
          i = 4;
        } else if ((i == 3) || (i == 4) || (i == 5) || (i == 6) || (i == 12)) {
          i = 3;
        } else if ((i == 1) || (i == 2)) {
          i = 2;
        } else {
          i = 0;
        }
      }
    }
  }
  
  final boolean Ez()
  {
    boolean bool = false;
    AppMethodBeat.i(50669);
    if (!bo.isNullOrNil(this.cBO))
    {
      if (!this.fVB) {
        break label71;
      }
      ab.i("MicroMsg.NetSceneDownloadVideo", "%s cancel online video task.", new Object[] { alu() });
      o.alF().j(this.cBO, null);
    }
    for (;;)
    {
      bool = true;
      this.fVG = true;
      AppMethodBeat.o(50669);
      return bool;
      label71:
      ab.i("MicroMsg.NetSceneDownloadVideo", "%s cancel offline video task.", new Object[] { alu() });
      com.tencent.mm.al.f.afO().sJ(this.cBO);
    }
  }
  
  final String alu()
  {
    AppMethodBeat.i(50678);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(50678);
    return str;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(50668);
    Ez();
    super.cancel();
    AppMethodBeat.o(50668);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    int i = 1;
    AppMethodBeat.i(50673);
    this.callback = paramf;
    this.fVD = u.vr(this.fileName);
    if (this.fVD == null)
    {
      ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
      AppMethodBeat.o(50673);
      return -1;
    }
    if ((this.fVD != null) && (3 == this.fVD.fXE)) {
      this.fVF = com.tencent.mm.i.a.MediaType_TinyVideo;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bo.aoy();
      this.startOffset = this.fVD.fXs;
    }
    if (alt())
    {
      ab.d("MicroMsg.NetSceneDownloadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { this.fileName });
      AppMethodBeat.o(50673);
      return 0;
    }
    if (this.fVD.status != 112)
    {
      ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: STATUS: " + this.fVD.status + " [" + this.fileName + "," + this.fVD.cFn + "," + this.fVD.alM() + "," + this.fVD.getUser() + "]");
      this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
      AppMethodBeat.o(50673);
      return -1;
    }
    ab.d("MicroMsg.NetSceneDownloadVideo", "start doScene  [" + this.fileName + "," + this.fVD.cFn + "," + this.fVD.alM() + "," + this.fVD.getUser() + "]  filesize:" + this.fVD.fXs + " file:" + this.fVD.fsd + " netTimes:" + this.fVD.fXz);
    if (!u.vj(this.fileName))
    {
      ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: NET TIMES: " + this.fVD.fXz + " [" + this.fileName + "," + this.fVD.cFn + "," + this.fVD.alM() + "," + this.fVD.getUser() + "] ");
      u.vk(this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
      AppMethodBeat.o(50673);
      return -1;
    }
    if (this.fVD.cFn <= 0L)
    {
      ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: MSGSVRID: " + this.fVD.cFn + " [" + this.fileName + "," + this.fVD.cFn + "," + this.fVD.alM() + "," + this.fVD.getUser() + "] ");
      u.vk(this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
      AppMethodBeat.o(50673);
      return -1;
    }
    if ((this.fVD.fXs < 0) || (this.fVD.fsd <= this.fVD.fXs) || (this.fVD.fsd <= 0))
    {
      ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: fileSize:" + this.fVD.fXs + " total:" + this.fVD.fsd + " [" + this.fileName + "," + this.fVD.cFn + "," + this.fVD.alM() + "," + this.fVD.getUser() + "] ");
      u.vk(this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
      AppMethodBeat.o(50673);
      return -1;
    }
    paramf = new b.a();
    paramf.fsX = new yu();
    paramf.fsY = new yv();
    paramf.uri = "/cgi-bin/micromsg-bin/downloadvideo";
    paramf.funcId = 150;
    paramf.reqCmdId = 40;
    paramf.respCmdId = 1000000040;
    this.rr = paramf.ado();
    paramf = (yu)this.rr.fsV.fta;
    paramf.pIG = this.fVD.cFn;
    paramf.pIy = this.fVD.fXs;
    paramf.pIx = this.fVD.fsd;
    if (ac.cm(ah.getContext())) {}
    for (;;)
    {
      paramf.wPR = i;
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(50673);
      return i;
      i = 2;
    }
  }
  
  public final int getType()
  {
    return 150;
  }
  
  final void ml(int paramInt)
  {
    AppMethodBeat.i(50672);
    Object localObject;
    if (this.fVH)
    {
      localObject = new StringBuilder();
      o.alE();
      localObject = new com.tencent.mm.vfs.b(t.vf(this.fileName) + ".tmp");
      o.alE();
    }
    for (boolean bool = ((com.tencent.mm.vfs.b)localObject).p(new com.tencent.mm.vfs.b(t.vf(this.fileName)));; bool = true)
    {
      com.tencent.mm.kernel.g.RO().ac(new d.2(this, bool, paramInt));
      AppMethodBeat.o(50672);
      return;
      localObject = new StringBuilder();
      o.alE();
      com.tencent.mm.vfs.e.deleteFile(t.vf(this.fileName) + ".tmp");
    }
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(50677);
    if (this.fVG)
    {
      ab.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd Call Stop by Service  [" + this.fileName + "," + this.fVD.cFn + "," + this.fVD.alM() + "," + this.fVD.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50677);
      return;
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bo.isNullOrNil(this.fFo)))
    {
      ab.w("MicroMsg.NetSceneDownloadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.fFo });
      AppMethodBeat.o(50677);
      return;
    }
    paramArrayOfByte = (yv)((com.tencent.mm.ai.b)paramq).fsW.fta;
    paramq = (yu)((com.tencent.mm.ai.b)paramq).fsV.fta;
    this.fVD = u.vr(this.fileName);
    if (this.fVD == null)
    {
      ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50677);
      return;
    }
    if (this.fVD.status == 113)
    {
      ab.w("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.fVD.cFn + "," + this.fVD.alM() + "," + this.fVD.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50677);
      return;
    }
    if (this.fVD.status != 112)
    {
      ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.fVD.status + " [" + this.fileName + "," + this.fVD.cFn + "," + this.fVD.alM() + "," + this.fVD.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50677);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 208L, 1L, false);
      ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + " [" + this.fileName + "," + this.fVD.cFn + "," + this.fVD.alM() + "," + this.fVD.getUser() + "] ");
      u.vk(this.fileName);
      com.tencent.mm.plugin.report.service.h.qsU.e(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(c.cb(ah.getContext())), Integer.valueOf(this.fVF), Integer.valueOf(this.fsd - this.startOffset) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50677);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 207L, 1L, false);
      ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED (SET PAUSE) errtype:" + paramInt2 + " errCode:" + paramInt3 + " [" + this.fileName + "," + this.fVD.cFn + "," + this.fVD.alM() + "," + this.fVD.getUser() + "] ");
      this.fVD.status = 113;
      u.f(this.fVD);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50677);
      return;
    }
    if (bo.ce(paramArrayOfByte.pIA.getBuffer().pW))
    {
      ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Recv BUF ZERO length  [" + this.fileName + "," + this.fVD.cFn + "," + this.fVD.alM() + "," + this.fVD.getUser() + "] ");
      u.vk(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50677);
      return;
    }
    if (paramArrayOfByte.pIy != paramq.pIy)
    {
      ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd OFFSET ERROR respStartPos:" + paramArrayOfByte.pIy + " reqStartPos:" + paramq.pIy + " [" + this.fileName + "," + this.fVD.cFn + "," + this.fVD.alM() + "," + this.fVD.getUser() + "] ");
      u.vk(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50677);
      return;
    }
    if (paramArrayOfByte.pIx != paramq.pIx)
    {
      ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + paramArrayOfByte.pIx + " reqTotal:" + paramq.pIx + " [" + this.fileName + "," + this.fVD.cFn + "," + this.fVD.alM() + "," + this.fVD.getUser() + "] ");
      u.vk(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50677);
      return;
    }
    if (paramq.pIx < paramArrayOfByte.pIy)
    {
      ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + paramArrayOfByte.pIx + " respStartPos:" + paramq.pIy + " [" + this.fileName + "," + this.fVD.cFn + "," + this.fVD.alM() + "," + this.fVD.getUser() + "] ");
      u.vk(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50677);
      return;
    }
    if (paramArrayOfByte.pIG != paramq.pIG)
    {
      ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respMsgId:" + paramArrayOfByte.pIG + " reqMsgId:" + paramq.pIG + " [" + this.fileName + "," + this.fVD.cFn + "," + this.fVD.alM() + "," + this.fVD.getUser() + "] ");
      u.vk(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50677);
      return;
    }
    ab.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd respBuf:" + paramArrayOfByte.pIA.getILen() + " reqStartPos:" + paramq.pIy + " totallen:" + paramq.pIx + " [" + this.fileName + "," + this.fVD.cFn + "," + this.fVD.alM() + "," + this.fVD.getUser() + "] ");
    o.alE();
    int j = t.a(t.vf(this.fileName), paramq.pIy, paramArrayOfByte.pIA.getBuffer().toByteArray());
    if (j < 0)
    {
      ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE RET:" + j + " [" + this.fileName + "," + this.fVD.cFn + "," + this.fVD.alM() + "," + this.fVD.getUser() + "] ");
      u.vk(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50677);
      return;
    }
    if (j > this.fVD.fsd)
    {
      ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE newOffset:" + j + " totalLen:" + this.fVD.fsd + " [" + this.fileName + "," + this.fVD.cFn + "," + this.fVD.alM() + "," + this.fVD.getUser() + "] ");
      u.vk(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50677);
      return;
    }
    paramq = this.fileName;
    paramArrayOfByte = u.vr(paramq);
    if (paramArrayOfByte == null)
    {
      ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ml() + " getinfo failed: " + paramq);
      paramInt1 = 0 - com.tencent.mm.compatible.util.g.getLine();
    }
    while (paramInt1 < 0)
    {
      ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd updateAfterRecv Ret:" + paramInt1 + " newOffset :" + j + " [" + this.fileName + "," + this.fVD.cFn + "," + this.fVD.alM() + "," + this.fVD.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50677);
      return;
      paramArrayOfByte.fXs = j;
      paramArrayOfByte.fXv = bo.aox();
      paramArrayOfByte.bsY = 1040;
      int i = 0;
      paramInt1 = i;
      if (paramArrayOfByte.fsd > 0)
      {
        paramInt1 = i;
        if (j >= paramArrayOfByte.fsd)
        {
          u.e(paramArrayOfByte);
          paramArrayOfByte.status = 199;
          paramArrayOfByte.bsY |= 0x100;
          ab.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + paramq + " newsize:" + j + " total:" + paramArrayOfByte.fsd + " status:" + paramArrayOfByte.status + " netTimes:" + paramArrayOfByte.fXz);
          paramInt1 = 1;
        }
      }
      ab.d("MicroMsg.VideoLogic", "updateRecv " + com.tencent.mm.compatible.util.g.Ml() + " file:" + paramq + " newsize:" + j + " total:" + paramArrayOfByte.fsd + " status:" + paramArrayOfByte.status);
      if (!u.f(paramArrayOfByte)) {
        paramInt1 = 0 - com.tencent.mm.compatible.util.g.getLine();
      }
    }
    if (paramInt1 == 1)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(c.cb(ah.getContext())), Integer.valueOf(this.fVF), Integer.valueOf(this.fsd - this.startOffset) });
      a.a(this.fVD, 1);
      ab.i("MicroMsg.NetSceneDownloadVideo", "!!!FIN [" + this.fileName + "," + this.fVD.cFn + "," + this.fVD.alM() + "," + this.fVD.getUser() + "]");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50677);
      return;
    }
    if (this.fVG)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50677);
      return;
    }
    this.frx.ag(0L, 0L);
    AppMethodBeat.o(50677);
  }
  
  public final int securityLimitCount()
  {
    return 2500;
  }
  
  public final boolean securityLimitCountReach()
  {
    AppMethodBeat.i(50675);
    boolean bool = super.securityLimitCountReach();
    if (bool) {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 210L, 1L, false);
    }
    AppMethodBeat.o(50675);
    return bool;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(50674);
    paramq = (yu)((com.tencent.mm.ai.b)paramq).fsV.fta;
    if ((paramq.pIG <= 0L) || (paramq.pIy < 0) || (paramq.pIx <= 0) || (paramq.pIx <= paramq.pIy))
    {
      ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: SECURITY CHECK FAILED [" + this.fileName + "," + this.fVD.cFn + "," + this.fVD.alM() + "," + this.fVD.getUser() + "] ");
      u.vk(this.fileName);
      paramq = m.b.ftv;
      AppMethodBeat.o(50674);
      return paramq;
    }
    paramq = m.b.ftu;
    AppMethodBeat.o(50674);
    return paramq;
  }
  
  public final void setSecurityCheckError(m.a parama)
  {
    AppMethodBeat.i(50676);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 211L, 1L, false);
    u.vk(this.fileName);
    AppMethodBeat.o(50676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelvideo.d
 * JD-Core Version:    0.7.0.1
 */