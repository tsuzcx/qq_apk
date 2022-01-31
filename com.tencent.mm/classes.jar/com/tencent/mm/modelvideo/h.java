package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.a;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.j.d;
import com.tencent.mm.model.bf;
import com.tencent.mm.n.a;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bwa;
import com.tencent.mm.protocal.c.cbp;
import com.tencent.mm.protocal.c.cbq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.HashMap;
import junit.framework.Assert;

public final class h
  extends m
  implements k
{
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  private int eGt = 0;
  private d eGu = null;
  private h.a eGv = null;
  String fileName = null;
  
  public h(String paramString, int paramInt, d paramd, h.a parama)
  {
    if (paramString != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      bool1 = bool2;
      if (paramd != null) {
        bool1 = true;
      }
      Assert.assertTrue(bool1);
      Assert.assertTrue(true);
      this.fileName = paramString;
      this.eGu = paramd;
      this.eGv = parama;
      this.eGt = paramInt;
      return;
    }
  }
  
  private String Sj()
  {
    return this.fileName + "_" + hashCode();
  }
  
  protected final int Ka()
  {
    return 1;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    Object localObject = u.oe(this.fileName);
    if (localObject == null)
    {
      y.e("MicroMsg.NetSceneUploadVideoForCdn", "Get info Failed file:" + this.fileName);
      this.eGv.bw(3, -1);
      return -1;
    }
    paramf = new b.a();
    paramf.ecH = new cbp();
    paramf.ecI = new cbq();
    paramf.uri = "/cgi-bin/micromsg-bin/uploadvideo";
    paramf.ecG = 149;
    paramf.ecJ = 39;
    paramf.ecK = 1000000039;
    this.dmK = paramf.Kt();
    cbp localcbp = (cbp)this.dmK.ecE.ecN;
    localcbp.tQE = 0;
    localcbp.tQD = this.eGu.field_fileLength;
    localcbp.tQF = new bmk().bs(new byte[0]);
    localcbp.trB = 0;
    localcbp.trA = this.eGu.field_thumbimgLength;
    localcbp.trC = new bmk().bs(new byte[0]);
    localcbp.kWn = com.tencent.mm.model.q.Gj();
    localcbp.kWm = this.eGu.field_toUser;
    localcbp.swQ = this.fileName;
    if (((s)localObject).eHL == 1) {
      localcbp.tQG = 2;
    }
    if (((s)localObject).eHO == 3) {
      localcbp.tQG = 3;
    }
    localcbp.tIl = ((s)localObject).eHH;
    label442:
    label499:
    String str;
    if (ab.bG(com.tencent.mm.sdk.platformtools.ae.getContext()))
    {
      i = 1;
      localcbp.sRb = i;
      localcbp.trD = 2;
      localcbp.tQv = this.eGu.field_thumbimgLength;
      localcbp.tQH = this.eGu.field_fileId;
      localcbp.tlM = this.eGu.field_fileId;
      localcbp.sGR = 1;
      if (!this.eGu.wV()) {
        break label1079;
      }
      y.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", new Object[] { Sj(), Boolean.valueOf(this.eGu.field_upload_by_safecdn), Integer.valueOf(this.eGu.field_UploadHitCacheType), Integer.valueOf(this.eGu.field_filecrc), this.eGu.field_aesKey });
      localcbp.tHc = 1;
      localcbp.sGQ = "";
      localcbp.tlO = "";
      localcbp.tQJ = this.eGu.field_filemd5;
      localcbp.tQT = this.eGu.field_mp4identifymd5;
      localcbp.sGS = this.eGu.field_filecrc;
      if ((this.eGt > 0) && (this.eGt <= 1048576)) {
        break label1106;
      }
      paramf = bf.HR();
      localcbp.svK = paramf;
      localcbp.tQS = ((s)localObject).bYN;
      paramf = ((s)localObject).eHQ;
      if ((paramf == null) || (bk.bl(paramf.dSP))) {
        break label1173;
      }
      localcbp.tQK = bk.aM(paramf.dSP, "");
      localcbp.tQL = paramf.sWK;
      localcbp.tQM = bk.aM(paramf.dSR, "");
      localcbp.tQO = bk.aM(paramf.dST, "");
      localcbp.tQN = bk.aM(paramf.dSS, "");
      localcbp.tQP = bk.aM(paramf.dSU, "");
      label619:
      if (paramf != null)
      {
        localcbp.tQR = bk.aM(paramf.dSV, "");
        localcbp.tQQ = bk.aM(paramf.dSW, "");
      }
      o.Sr();
      paramf = t.nT(this.fileName);
      localObject = c.YU(paramf);
      if (localObject == null) {
        break label1218;
      }
      localcbp.tQx = ((BitmapFactory.Options)localObject).outWidth;
      localcbp.tQw = ((BitmapFactory.Options)localObject).outHeight;
      label696:
      o.Sr();
      paramf = t.nS(this.fileName);
      localObject = n.Sp();
      if (bk.bl(paramf)) {
        break label1237;
      }
      paramf = (n.a)((n)localObject).eGQ.get(paramf);
      if (paramf == null) {
        break label1237;
      }
      i = paramf.eHh;
      switch (i)
      {
      case 4: 
      case 5: 
      default: 
        label742:
        localcbp.sGT = 0;
        localcbp.swS = 0;
        label800:
        paramf = Sj();
        localObject = this.fileName;
        str = this.eGu.field_toUser;
        if (this.eGu.field_aesKey != null) {
          break;
        }
      }
    }
    for (int i = -1;; i = this.eGu.field_aesKey.length())
    {
      y.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn cdntra doscene file:%s touser:%s aes:%d fileid:%s thumb:[%d %d %d], thumbaeskey [%s] funcFlag: %d, md5:%s HitMd5:%d CRC32:%d, VideoNewMd5:%s AESKey:%s stream %s streamtime: %d title %s thumburl %s msgSource[%s] msgForwardType[%d] Source[%d]", new Object[] { paramf, localObject, str, Integer.valueOf(i), this.eGu.field_fileId, Integer.valueOf(this.eGu.field_thumbimgLength), Integer.valueOf(localcbp.tQx), Integer.valueOf(localcbp.tQw), bk.aac(localcbp.tlO), Integer.valueOf(localcbp.tQG), localcbp.tQJ, Integer.valueOf(localcbp.tHc), Integer.valueOf(localcbp.sGS), localcbp.tQT, bk.aac(localcbp.sGQ), localcbp.tQK, Integer.valueOf(localcbp.tQL), localcbp.tQM, localcbp.tQP, localcbp.svK, Integer.valueOf(localcbp.sGT), Integer.valueOf(localcbp.swS) });
      return a(parame, this.dmK, this);
      i = 2;
      break;
      label1079:
      localcbp.sGQ = this.eGu.field_aesKey;
      localcbp.tlO = this.eGu.field_aesKey;
      break label442;
      label1106:
      paramf = new StringBuilder();
      paramf.append("<msgsource>");
      paramf.append("<videopreloadlen>").append(this.eGt).append("</videopreloadlen>");
      paramf.append("</msgsource>");
      com.tencent.mm.plugin.report.service.h.nFQ.a(354L, 35L, 1L, false);
      paramf = paramf.toString();
      break label499;
      label1173:
      if ((paramf == null) || (bk.bl(paramf.dST)) || (bk.bl(paramf.dSS))) {
        break label619;
      }
      localcbp.tQO = paramf.dST;
      localcbp.tQN = paramf.dSS;
      break label619;
      label1218:
      y.w("MicroMsg.NetSceneUploadVideoForCdn", "cdntra getImageOptions for thumb failed path:%s", new Object[] { paramf });
      break label696;
      label1237:
      i = 0;
      break label742;
      localcbp.sGT = 1;
      localcbp.swS = 2;
      break label800;
      localcbp.sGT = 1;
      localcbp.swS = 1;
      break label800;
      localcbp.sGT = 2;
      localcbp.swS = 3;
      break label800;
      localcbp.sGT = 3;
      localcbp.swS = 4;
      break label800;
      localcbp.sGT = 1;
      localcbp.swS = 5;
      break label800;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneUploadVideoForCdn", "%s cdntra onGYNetEnd errtype[%d %d]", new Object[] { Sj(), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramArrayOfByte = (cbq)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    paramq = u.oe(this.fileName);
    if (paramq == null)
    {
      y.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.eGv.bw(3, -1);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == 102))
    {
      y.e("MicroMsg.NetSceneUploadVideoForCdn", "summersafecdn ERR: MM_ERR_GET_AESKEY_FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + paramq.SA());
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.eGv.bw(paramInt2, paramInt3);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      y.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd BLACK  errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + paramq.SA());
      u.nY(this.fileName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.eGv.bw(paramInt2, paramInt3);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + paramq.SA());
      u.nX(this.fileName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.eGv.bw(paramInt2, paramInt3);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + paramq.SA());
      u.nX(this.fileName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.eGv.bw(paramInt2, paramInt3);
      return;
    }
    paramq.eHF = bk.UX();
    paramq.bXr = paramArrayOfByte.ndp;
    y.i("MicroMsg.NetSceneUploadVideoForCdn", "%s dkmsgid  set svrmsgid %d -> %d", new Object[] { Sj(), Long.valueOf(paramq.bXr), Integer.valueOf(com.tencent.mm.platformtools.ae.eSQ) });
    if ((10007 == com.tencent.mm.platformtools.ae.eSP) && (com.tencent.mm.platformtools.ae.eSQ != 0) && (paramq.bXr != 0L))
    {
      paramq.bXr = com.tencent.mm.platformtools.ae.eSQ;
      com.tencent.mm.platformtools.ae.eSQ = 0;
    }
    paramq.status = 199;
    paramq.bcw = 1284;
    boolean bool;
    if (this.eGu.wV())
    {
      y.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], old RecvXml[%s]", new Object[] { Sj(), paramArrayOfByte.sGQ, paramq.SD() });
      if (bk.bl(paramArrayOfByte.sGQ)) {
        break label1257;
      }
      Object localObject = "<msg><videomsg aeskey=\"" + paramArrayOfByte.sGQ + "\" cdnthumbaeskey=\"" + paramArrayOfByte.sGQ + "\" cdnvideourl=\"" + this.eGu.field_fileId + "\" ";
      localObject = (String)localObject + "cdnthumburl=\"" + this.eGu.field_fileId + "\" ";
      localObject = (String)localObject + "length=\"" + this.eGu.field_fileLength + "\" ";
      localObject = (String)localObject + "cdnthumblength=\"" + this.eGu.field_thumbimgLength + "\"/></msg>";
      y.i("MicroMsg.NetSceneUploadVideoForCdn", "cdn callback new build cdnInfo:%s", new Object[] { localObject });
      paramq.eHN = ((String)localObject);
      localObject = o.Sr();
      o.Sr();
      bool = ((t)localObject).q(t.nS(this.fileName), this.eGu.field_fileId, paramArrayOfByte.sGQ);
      localObject = com.tencent.mm.plugin.report.service.h.nFQ;
      if (bool)
      {
        paramInt1 = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject).f(12696, new Object[] { Integer.valueOf(paramInt1 + 900), Integer.valueOf(paramq.ebK) });
        y.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], new RecvXml[%s], saveret[%b]", new Object[] { Sj(), paramArrayOfByte.sGQ, paramq.SD(), Boolean.valueOf(bool) });
      }
    }
    else
    {
      label1008:
      u.f(paramq);
      u.d(paramq);
      paramArrayOfByte = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(paramq.eHI);
      com.tencent.mm.modelstat.b.eBD.f(paramArrayOfByte);
      paramArrayOfByte = paramq.SA();
      paramArrayOfByte = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl(paramArrayOfByte);
      if ((paramArrayOfByte != null) && ((int)paramArrayOfByte.dBe > 0)) {
        break label1279;
      }
      bool = false;
      label1101:
      if ((!bool) && (!com.tencent.mm.model.s.hx(paramq.SA()))) {
        break label1289;
      }
      y.i("MicroMsg.NetSceneUploadVideoForCdn", "%s upload to biz :%s", new Object[] { Sj(), paramq.SA() });
      if (paramq.bXr < 0L)
      {
        y.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + paramq.bXr + " file:" + this.fileName + " toUser:" + paramq.SA());
        u.nX(this.fileName);
        this.eGv.bw(3, -1);
      }
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.eGv.bw(0, 0);
      return;
      paramInt1 = 2;
      break;
      label1257:
      y.w("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn need aeskey but ret null", new Object[] { Sj() });
      break label1008;
      label1279:
      bool = paramArrayOfByte.cua();
      break label1101;
      label1289:
      y.i("MicroMsg.NetSceneUploadVideoForCdn", "%s not upload to biz", new Object[] { Sj() });
      if (paramq.bXr <= 0L)
      {
        y.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + paramq.bXr + " file:" + this.fileName + " toUser:" + paramq.SA());
        u.nX(this.fileName);
        this.eGv.bw(3, -1);
      }
    }
  }
  
  protected final void a(m.a parama)
  {
    u.nX(this.fileName);
  }
  
  protected final m.b b(com.tencent.mm.network.q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 149;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.h
 * JD-Core Version:    0.7.0.1
 */