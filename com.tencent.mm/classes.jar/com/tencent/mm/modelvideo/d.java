package com.tencent.mm.modelvideo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m.a;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.ak.c;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.j.f.a;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bd.b;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.uh;
import com.tencent.mm.protocal.c.ui;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import java.util.HashSet;
import java.util.Map;
import junit.framework.Assert;

public final class d
  extends com.tencent.mm.ah.m
  implements k
{
  private String bUi;
  private com.tencent.mm.ah.b dmK;
  com.tencent.mm.ah.f dmL;
  boolean eFK;
  boolean eFL;
  s eFM = null;
  com.tencent.mm.j.g eFN;
  int eFO = com.tencent.mm.j.a.MediaType_VIDEO;
  private boolean eFP = false;
  boolean eFQ = true;
  long eFR = 0L;
  int ebK = 0;
  private am ebj = new am(new d.3(this), false);
  String eoQ = "";
  String eoX = null;
  int eoY = 0;
  private f.a epa = new d.1(this);
  String fileName;
  int retCode = 0;
  private int startOffset = 0;
  long startTime = 0L;
  
  public d(String paramString)
  {
    this(paramString, false);
  }
  
  public d(String paramString, boolean paramBoolean)
  {
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.fileName = paramString;
      this.eFK = paramBoolean;
      y.i("MicroMsg.NetSceneDownloadVideo", "%s NetSceneDownloadVideo:  file [%s] isCompleteOnlineVideo [%b]", new Object[] { Sj(), paramString, Boolean.valueOf(paramBoolean) });
      return;
    }
  }
  
  private boolean Si()
  {
    y.d("MicroMsg.NetSceneDownloadVideo", "%s parseVideoMsgXML content: %s", new Object[] { Sj(), this.eFM.SD() });
    Object localObject4 = bn.s(this.eFM.SD(), "msg");
    if (localObject4 == null)
    {
      h.nFQ.a(111L, 214L, 1L, false);
      y.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", new Object[] { Sj() });
      return false;
    }
    String str1 = (String)((Map)localObject4).get(".msg.videomsg.$cdnvideourl");
    Object localObject1 = (String)((Map)localObject4).get(".msg.videomsg.$tpvideourl");
    if ((bk.bl(str1)) && (bk.bl((String)localObject1)))
    {
      h.nFQ.a(111L, 213L, 1L, false);
      y.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", new Object[] { Sj() });
      return false;
    }
    Object localObject5 = (String)((Map)localObject4).get(".msg.videomsg.$aeskey");
    this.ebK = bk.getInt((String)((Map)localObject4).get(".msg.videomsg.$length"), 0);
    String str2 = (String)((Map)localObject4).get(".msg.videomsg.$fileparam");
    this.eoQ = c.a("downvideo", this.eFM.createTime, this.eFM.SA(), this.eFM.getFileName());
    if (bk.bl(this.eoQ))
    {
      y.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra genClientId failed not use cdn file:%s", new Object[] { Sj(), this.eFM.getFileName() });
      return false;
    }
    if ((!this.eFK) && (this.ebK < 1048576) && (this.eFM != null) && (this.eFM.bRT > 0))
    {
      this.eFK = true;
      y.i("MicroMsg.NetSceneDownloadVideo", "%s less 1M and had preload, reset isCompleteOnlineVideo [%b]", new Object[] { Sj(), Boolean.valueOf(this.eFK) });
    }
    Object localObject2 = (String)((Map)localObject4).get(".msg.videomsg.$md5");
    Object localObject3 = new StringBuilder();
    o.Sr();
    localObject3 = t.nS(this.fileName) + ".tmp";
    this.eFN = new com.tencent.mm.j.g();
    this.eFN.filename = this.eFM.getFileName();
    this.eFN.dme = ((String)localObject2);
    this.eFN.dmf = this.ebK;
    this.eFN.dmg = 0;
    this.eFN.bRO = this.eFM.SB();
    this.eFN.dmh = this.eFM.SA();
    com.tencent.mm.j.g localg = this.eFN;
    int i;
    label619:
    int k;
    if (com.tencent.mm.model.s.fn(this.eFM.SA()))
    {
      i = com.tencent.mm.model.m.gM(this.eFM.SA());
      localg.bRQ = i;
      this.eFN.field_mediaId = this.eoQ;
      this.eFN.field_fullpath = ((String)localObject3);
      this.eFN.field_fileType = com.tencent.mm.j.a.MediaType_VIDEO;
      this.eFN.field_totalLen = this.ebK;
      this.eFN.field_aesKey = ((String)localObject5);
      this.eFN.field_fileId = str1;
      this.eFN.field_priority = com.tencent.mm.j.a.dlk;
      this.eFN.dlP = this.epa;
      this.eFN.field_wxmsgparam = str2;
      localObject5 = this.eFN;
      if (!com.tencent.mm.model.s.fn(this.eFM.SA())) {
        break label1639;
      }
      i = 1;
      ((com.tencent.mm.j.g)localObject5).field_chattype = i;
      this.eFN.dmi = this.eFM.dmi;
      if (!bk.bl((String)localObject1))
      {
        localObject4 = (String)((Map)localObject4).get(".msg.videomsg.$tpauthkey");
        this.eFN.field_fileId = "";
        this.eFN.field_fileType = 19;
        this.eFN.field_authKey = ((String)localObject4);
        this.eFN.dlQ = ((String)localObject1);
      }
      localObject4 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().O(this.eFM.SA(), this.eFM.bXr);
      this.eFN.dmk = ((cs)localObject4).field_createTime;
      this.eFN.bXr = ((cs)localObject4).field_msgSvrId;
      localObject1 = bd.iM(((cs)localObject4).czr);
      localObject5 = this.eFN;
      if (localObject1 == null) {
        break label1644;
      }
      i = ((bd.b)localObject1).dWM;
      label784:
      ((com.tencent.mm.j.g)localObject5).dml = i;
      if (this.eFM.SA().equals(((cs)localObject4).field_talker))
      {
        localObject5 = this.eFN;
        if (localObject1 != null) {
          break label1649;
        }
        i = 0;
        label821:
        ((com.tencent.mm.j.g)localObject5).field_limitrate = i;
      }
      y.d("MicroMsg.NetSceneDownloadVideo", "%s limitrate:%d file:%s", new Object[] { Sj(), Integer.valueOf(this.eFN.field_limitrate), this.eFM.getFileName() });
      if (!com.tencent.mm.ak.f.Nd().eiM.contains("video_" + this.eFM.eHI)) {
        break label1661;
      }
      com.tencent.mm.ak.f.Nd().eiM.remove("video_" + this.eFM.eHI);
      this.eFN.field_autostart = true;
      label945:
      if (3 == this.eFM.eHO) {
        this.eFN.field_smallVideoFlag = 1;
      }
      if ((bk.bl((String)localObject2)) || (this.eFK)) {
        break label1692;
      }
      localObject1 = ((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.r.a.a.class)).FD().dx((String)localObject2, this.ebK);
      j = (int)com.tencent.mm.vfs.e.aeQ((String)localObject1);
      k = this.ebK - j;
      o.Sr();
      localObject5 = t.nS(this.fileName);
      int m = (int)com.tencent.mm.vfs.e.aeQ((String)localObject5);
      if (m > 0)
      {
        y.w("MicroMsg.NetSceneDownloadVideo", "%s already copy dup file, but download again, something error here.", new Object[] { Sj() });
        bool = com.tencent.mm.vfs.e.deleteFile((String)localObject5);
        localObject1 = ((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.r.a.a.class)).FD();
        int n = this.ebK;
        i = 0;
        if (!bk.bl((String)localObject2)) {
          i = ((bh)localObject1).dXw.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[] { localObject2, String.valueOf(n), "100" });
        }
        localObject1 = u.oe(this.fileName);
        ((s)localObject1).eHC = 0;
        ((s)localObject1).bcw = 16;
        u.f((s)localObject1);
        y.w("MicroMsg.NetSceneDownloadVideo", "%s don't copy dup file, go to download now. target video len %d, delete file:%b,delete db: %d", new Object[] { Sj(), Integer.valueOf(m), Boolean.valueOf(bool), Integer.valueOf(i) });
        localObject1 = "";
      }
      y.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage: totallen:%s md5:%s  dup(len:%d path:%s) diffLen:%d to:%s target video len %d", new Object[] { Sj(), Integer.valueOf(this.ebK), localObject2, Integer.valueOf(j), localObject1, Integer.valueOf(k), localObject3, Integer.valueOf(m) });
      if (bk.bl((String)localObject1)) {
        break label1678;
      }
      if ((k < 0) || (k > 16)) {
        break label1692;
      }
      y.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage copy dup file now :%s -> %s", new Object[] { Sj(), localObject1, localObject3 });
      com.tencent.mm.vfs.e.r((String)localObject1, (String)localObject3);
      jt(this.ebK);
      ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(new g.c(((cs)localObject4).field_talker, "update", (bi)localObject4));
      localObject1 = h.nFQ;
      long l1 = this.eFM.bXr;
      long l2 = this.eFM.createTime;
      localObject3 = this.eFM.SA();
      if (3 == this.eFM.eHO) {
        break label1672;
      }
      i = 43;
      label1430:
      ((h)localObject1).f(13267, new Object[] { str1, Long.valueOf(l1), localObject2, Long.valueOf(l2), localObject3, Integer.valueOf(i), Integer.valueOf(j) });
      i = 1;
      label1491:
      if (i != 0) {
        break label1724;
      }
      this.bUi = this.eFN.field_mediaId;
      this.eFR = bk.UY();
      if (this.eFM.videoFormat != 2) {
        break label1697;
      }
    }
    label1672:
    label1678:
    label1692:
    label1697:
    for (boolean bool = true;; bool = false)
    {
      this.eFL = bool;
      y.i("MicroMsg.NetSceneDownloadVideo", "%s check use cdn isHadHevcLocalFile[%b] isCompleteOnlineVideo[%b]", new Object[] { Sj(), Boolean.valueOf(this.eFL), Boolean.valueOf(this.eFK) });
      if (this.eFK) {
        break label1937;
      }
      if (com.tencent.mm.ak.f.Nd().b(this.eFN, -1)) {
        break label1703;
      }
      h.nFQ.a(111L, 212L, 1L, false);
      y.e("MicroMsg.NetSceneDownloadVideo", "%s cdntra addSendTask failed.", new Object[] { Sj() });
      this.eoQ = "";
      return false;
      i = 0;
      break;
      label1639:
      i = 0;
      break label619;
      label1644:
      i = 0;
      break label784;
      label1649:
      i = ((bd.b)localObject1).dWK / 8;
      break label821;
      label1661:
      this.eFN.field_autostart = false;
      break label945;
      i = 62;
      break label1430;
      this.eoX = ((String)localObject2);
      this.eoY = this.ebK;
      i = 0;
      break label1491;
    }
    label1703:
    if (this.eFL) {
      h.nFQ.a(354L, 135L, 1L, false);
    }
    label1724:
    if (this.eFM.eHM != 1)
    {
      this.eFM.eHM = 1;
      this.eFM.bcw = 524288;
      u.f(this.eFM);
    }
    if (3 != this.eFM.eHO)
    {
      localObject1 = this.eFM.SA();
      if (!bk.bl((String)localObject1)) {
        if (!com.tencent.mm.model.s.fn((String)localObject1)) {
          break label2110;
        }
      }
    }
    label1937:
    label2110:
    for (int j = com.tencent.mm.model.m.gM((String)localObject1);; j = 0) {
      for (;;)
      {
        try
        {
          localObject2 = ((ConnectivityManager)ae.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
          i = ((NetworkInfo)localObject2).getSubtype();
          k = ((NetworkInfo)localObject2).getType();
          if (k != 1) {
            continue;
          }
          i = 1;
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.NetSceneDownloadVideo", "getNetType : %s", new Object[] { bk.j(localException) });
          i = 0;
          continue;
        }
        localObject1 = (String)localObject1 + "," + j + "," + str1 + "," + this.ebK + "," + i;
        y.i("MicroMsg.NetSceneDownloadVideo", "%s dk12024 report:%s", new Object[] { Sj(), localObject1 });
        h.nFQ.aC(12024, (String)localObject1);
        return true;
        this.eFQ = false;
        localObject1 = this.eFN;
        o.Sr();
        ((com.tencent.mm.j.g)localObject1).field_fullpath = t.nS(this.fileName);
        if (this.eFL)
        {
          this.eFN.field_requestVideoFormat = 2;
          h.nFQ.a(354L, 251L, 1L, false);
        }
        o.Ss().a(this.eFN, false);
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
  
  protected final int Ka()
  {
    return 2500;
  }
  
  public final boolean Ky()
  {
    boolean bool = super.Ky();
    if (bool) {
      h.nFQ.a(111L, 210L, 1L, false);
    }
    return bool;
  }
  
  final String Sj()
  {
    return this.fileName + "_" + hashCode();
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    int i = 1;
    this.dmL = paramf;
    this.eFM = u.oe(this.fileName);
    if (this.eFM == null)
    {
      y.e("MicroMsg.NetSceneDownloadVideo", "ERR: Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
      return -1;
    }
    if ((this.eFM != null) && (3 == this.eFM.eHO)) {
      this.eFO = com.tencent.mm.j.a.MediaType_TinyVideo;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bk.UY();
      this.startOffset = this.eFM.eHC;
    }
    if (Si())
    {
      y.d("MicroMsg.NetSceneDownloadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { this.fileName });
      return 0;
    }
    if (this.eFM.status != 112)
    {
      y.e("MicroMsg.NetSceneDownloadVideo", "ERR: STATUS: " + this.eFM.status + " [" + this.fileName + "," + this.eFM.bXr + "," + this.eFM.SB() + "," + this.eFM.SA() + "]");
      this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
      return -1;
    }
    y.d("MicroMsg.NetSceneDownloadVideo", "start doScene  [" + this.fileName + "," + this.eFM.bXr + "," + this.eFM.SB() + "," + this.eFM.SA() + "]  filesize:" + this.eFM.eHC + " file:" + this.eFM.ebK + " netTimes:" + this.eFM.eHJ);
    if (!u.nW(this.fileName))
    {
      y.e("MicroMsg.NetSceneDownloadVideo", "ERR: NET TIMES: " + this.eFM.eHJ + " [" + this.fileName + "," + this.eFM.bXr + "," + this.eFM.SB() + "," + this.eFM.SA() + "] ");
      u.nX(this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
      return -1;
    }
    if (this.eFM.bXr <= 0L)
    {
      y.e("MicroMsg.NetSceneDownloadVideo", "ERR: MSGSVRID: " + this.eFM.bXr + " [" + this.fileName + "," + this.eFM.bXr + "," + this.eFM.SB() + "," + this.eFM.SA() + "] ");
      u.nX(this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
      return -1;
    }
    if ((this.eFM.eHC < 0) || (this.eFM.ebK <= this.eFM.eHC) || (this.eFM.ebK <= 0))
    {
      y.e("MicroMsg.NetSceneDownloadVideo", "ERR: fileSize:" + this.eFM.eHC + " total:" + this.eFM.ebK + " [" + this.fileName + "," + this.eFM.bXr + "," + this.eFM.SB() + "," + this.eFM.SA() + "] ");
      u.nX(this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
      return -1;
    }
    paramf = new b.a();
    paramf.ecH = new uh();
    paramf.ecI = new ui();
    paramf.uri = "/cgi-bin/micromsg-bin/downloadvideo";
    paramf.ecG = 150;
    paramf.ecJ = 40;
    paramf.ecK = 1000000040;
    this.dmK = paramf.Kt();
    paramf = (uh)this.dmK.ecE.ecN;
    paramf.ndp = this.eFM.bXr;
    paramf.ndg = this.eFM.eHC;
    paramf.ndf = this.eFM.ebK;
    if (ab.bG(ae.getContext())) {}
    for (;;)
    {
      paramf.sRb = i;
      return a(parame, this.dmK, this);
      i = 2;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if (this.eFP)
    {
      y.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd Call Stop by Service  [" + this.fileName + "," + this.eFM.bXr + "," + this.eFM.SB() + "," + this.eFM.SA() + "] ");
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bk.bl(this.eoQ)))
    {
      y.w("MicroMsg.NetSceneDownloadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.eoQ });
      return;
    }
    paramArrayOfByte = (ui)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    paramq = (uh)((com.tencent.mm.ah.b)paramq).ecE.ecN;
    this.eFM = u.oe(this.fileName);
    if (this.eFM == null)
    {
      y.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if (this.eFM.status == 113)
    {
      y.w("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.eFM.bXr + "," + this.eFM.SB() + "," + this.eFM.SA() + "] ");
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if (this.eFM.status != 112)
    {
      y.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.eFM.status + " [" + this.fileName + "," + this.eFM.bXr + "," + this.eFM.SB() + "," + this.eFM.SA() + "] ");
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      h.nFQ.a(111L, 208L, 1L, false);
      y.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + " [" + this.fileName + "," + this.eFM.bXr + "," + this.eFM.SB() + "," + this.eFM.SA() + "] ");
      u.nX(this.fileName);
      h.nFQ.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bk.UY()), Integer.valueOf(c.bx(ae.getContext())), Integer.valueOf(this.eFO), Integer.valueOf(this.ebK - this.startOffset) });
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      h.nFQ.a(111L, 207L, 1L, false);
      y.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED (SET PAUSE) errtype:" + paramInt2 + " errCode:" + paramInt3 + " [" + this.fileName + "," + this.eFM.bXr + "," + this.eFM.SB() + "," + this.eFM.SA() + "] ");
      this.eFM.status = 113;
      u.f(this.eFM);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if (bk.bE(paramArrayOfByte.ndi.tFM.oY))
    {
      y.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Recv BUF ZERO length  [" + this.fileName + "," + this.eFM.bXr + "," + this.eFM.SB() + "," + this.eFM.SA() + "] ");
      u.nX(this.fileName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if (paramArrayOfByte.ndg != paramq.ndg)
    {
      y.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd OFFSET ERROR respStartPos:" + paramArrayOfByte.ndg + " reqStartPos:" + paramq.ndg + " [" + this.fileName + "," + this.eFM.bXr + "," + this.eFM.SB() + "," + this.eFM.SA() + "] ");
      u.nX(this.fileName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if (paramArrayOfByte.ndf != paramq.ndf)
    {
      y.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + paramArrayOfByte.ndf + " reqTotal:" + paramq.ndf + " [" + this.fileName + "," + this.eFM.bXr + "," + this.eFM.SB() + "," + this.eFM.SA() + "] ");
      u.nX(this.fileName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if (paramq.ndf < paramArrayOfByte.ndg)
    {
      y.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + paramArrayOfByte.ndf + " respStartPos:" + paramq.ndg + " [" + this.fileName + "," + this.eFM.bXr + "," + this.eFM.SB() + "," + this.eFM.SA() + "] ");
      u.nX(this.fileName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if (paramArrayOfByte.ndp != paramq.ndp)
    {
      y.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respMsgId:" + paramArrayOfByte.ndp + " reqMsgId:" + paramq.ndp + " [" + this.fileName + "," + this.eFM.bXr + "," + this.eFM.SB() + "," + this.eFM.SA() + "] ");
      u.nX(this.fileName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    y.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd respBuf:" + paramArrayOfByte.ndi.tFK + " reqStartPos:" + paramq.ndg + " totallen:" + paramq.ndf + " [" + this.fileName + "," + this.eFM.bXr + "," + this.eFM.SB() + "," + this.eFM.SA() + "] ");
    o.Sr();
    int j = t.a(t.nS(this.fileName), paramq.ndg, paramArrayOfByte.ndi.tFM.toByteArray());
    if (j < 0)
    {
      y.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE RET:" + j + " [" + this.fileName + "," + this.eFM.bXr + "," + this.eFM.SB() + "," + this.eFM.SA() + "] ");
      u.nX(this.fileName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if (j > this.eFM.ebK)
    {
      y.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE newOffset:" + j + " totalLen:" + this.eFM.ebK + " [" + this.fileName + "," + this.eFM.bXr + "," + this.eFM.SB() + "," + this.eFM.SA() + "] ");
      u.nX(this.fileName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramq = this.fileName;
    paramArrayOfByte = u.oe(paramq);
    if (paramArrayOfByte == null)
    {
      y.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zI() + " getinfo failed: " + paramq);
      paramInt1 = 0 - com.tencent.mm.compatible.util.g.getLine();
    }
    while (paramInt1 < 0)
    {
      y.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd updateAfterRecv Ret:" + paramInt1 + " newOffset :" + j + " [" + this.fileName + "," + this.eFM.bXr + "," + this.eFM.SB() + "," + this.eFM.SA() + "] ");
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      paramArrayOfByte.eHC = j;
      paramArrayOfByte.eHF = bk.UX();
      paramArrayOfByte.bcw = 1040;
      int i = 0;
      paramInt1 = i;
      if (paramArrayOfByte.ebK > 0)
      {
        paramInt1 = i;
        if (j >= paramArrayOfByte.ebK)
        {
          u.e(paramArrayOfByte);
          paramArrayOfByte.status = 199;
          paramArrayOfByte.bcw |= 0x100;
          y.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + paramq + " newsize:" + j + " total:" + paramArrayOfByte.ebK + " status:" + paramArrayOfByte.status + " netTimes:" + paramArrayOfByte.eHJ);
          paramInt1 = 1;
        }
      }
      y.d("MicroMsg.VideoLogic", "updateRecv " + com.tencent.mm.compatible.util.g.zI() + " file:" + paramq + " newsize:" + j + " total:" + paramArrayOfByte.ebK + " status:" + paramArrayOfByte.status);
      if (!u.f(paramArrayOfByte)) {
        paramInt1 = 0 - com.tencent.mm.compatible.util.g.getLine();
      }
    }
    if (paramInt1 == 1)
    {
      h.nFQ.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bk.UY()), Integer.valueOf(c.bx(ae.getContext())), Integer.valueOf(this.eFO), Integer.valueOf(this.ebK - this.startOffset) });
      a.a(this.eFM, 1);
      y.i("MicroMsg.NetSceneDownloadVideo", "!!!FIN [" + this.fileName + "," + this.eFM.bXr + "," + this.eFM.SB() + "," + this.eFM.SA() + "]");
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if (this.eFP)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.ebj.S(0L, 0L);
  }
  
  protected final void a(m.a parama)
  {
    h.nFQ.a(111L, 211L, 1L, false);
    u.nX(this.fileName);
  }
  
  protected final m.b b(q paramq)
  {
    paramq = (uh)((com.tencent.mm.ah.b)paramq).ecE.ecN;
    if ((paramq.ndp <= 0L) || (paramq.ndg < 0) || (paramq.ndf <= 0) || (paramq.ndf <= paramq.ndg))
    {
      y.e("MicroMsg.NetSceneDownloadVideo", "ERR: SECURITY CHECK FAILED [" + this.fileName + "," + this.eFM.bXr + "," + this.eFM.SB() + "," + this.eFM.SA() + "] ");
      u.nX(this.fileName);
      return m.b.eds;
    }
    return m.b.edr;
  }
  
  protected final void cancel()
  {
    un();
    super.cancel();
  }
  
  public final int getType()
  {
    return 150;
  }
  
  final void jt(int paramInt)
  {
    Object localObject;
    if (this.eFQ)
    {
      localObject = new StringBuilder();
      o.Sr();
      localObject = new com.tencent.mm.vfs.b(t.nS(this.fileName) + ".tmp");
      o.Sr();
    }
    for (boolean bool = ((com.tencent.mm.vfs.b)localObject).n(new com.tencent.mm.vfs.b(t.nS(this.fileName)));; bool = true)
    {
      com.tencent.mm.kernel.g.DS().O(new d.2(this, bool, paramInt));
      return;
      localObject = new StringBuilder();
      o.Sr();
      com.tencent.mm.vfs.e.deleteFile(t.nS(this.fileName) + ".tmp");
    }
  }
  
  final boolean un()
  {
    boolean bool = false;
    if (!bk.bl(this.bUi))
    {
      if (!this.eFK) {
        break label59;
      }
      y.i("MicroMsg.NetSceneDownloadVideo", "%s cancel online video task.", new Object[] { Sj() });
      o.Ss().k(this.bUi, null);
    }
    for (;;)
    {
      bool = true;
      this.eFP = true;
      return bool;
      label59:
      y.i("MicroMsg.NetSceneDownloadVideo", "%s cancel offline video task.", new Object[] { Sj() });
      com.tencent.mm.ak.f.Nd().lM(this.bUi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.d
 * JD-Core Version:    0.7.0.1
 */