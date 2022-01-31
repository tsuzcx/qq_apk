package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.r;
import com.tencent.mm.n.a;
import com.tencent.mm.network.ac;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.protocal.protobuf.cov;
import com.tencent.mm.protocal.protobuf.cow;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.HashMap;
import junit.framework.Assert;

public final class h
  extends m
  implements k
{
  private f callback;
  private int fWj;
  private com.tencent.mm.i.d fWk;
  private h.a fWl;
  String fileName;
  private com.tencent.mm.ai.b rr;
  
  public h(String paramString, int paramInt, com.tencent.mm.i.d paramd, h.a parama)
  {
    AppMethodBeat.i(50710);
    this.fileName = null;
    this.fWj = 0;
    this.fWk = null;
    this.fWl = null;
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
      this.fWk = paramd;
      this.fWl = parama;
      this.fWj = paramInt;
      AppMethodBeat.o(50710);
      return;
    }
  }
  
  private String alu()
  {
    AppMethodBeat.i(50714);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(50714);
    return str;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(50711);
    this.callback = paramf;
    Object localObject = u.vr(this.fileName);
    if (localObject == null)
    {
      ab.e("MicroMsg.NetSceneUploadVideoForCdn", "Get info Failed file:" + this.fileName);
      this.fWl.cG(3, -1);
      AppMethodBeat.o(50711);
      return -1;
    }
    paramf = new b.a();
    paramf.fsX = new cov();
    paramf.fsY = new cow();
    paramf.uri = "/cgi-bin/micromsg-bin/uploadvideo";
    paramf.funcId = 149;
    paramf.reqCmdId = 39;
    paramf.respCmdId = 1000000039;
    this.rr = paramf.ado();
    cov localcov = (cov)this.rr.fsV.fta;
    localcov.xXz = 0;
    localcov.xXy = this.fWk.field_fileLength;
    localcov.xXA = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    localcov.xrE = 0;
    localcov.xrD = this.fWk.field_thumbimgLength;
    localcov.xrF = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    localcov.num = r.Zn();
    localcov.nul = this.fWk.field_toUser;
    localcov.wpS = this.fileName;
    if (((s)localObject).fXB == 1) {
      localcov.wxV = 2;
    }
    if (((s)localObject).fXE == 3) {
      localcov.wxV = 3;
    }
    localcov.xMz = ((s)localObject).fXx;
    label453:
    label510:
    String str;
    if (ac.cm(ah.getContext()))
    {
      i = 1;
      localcov.wPR = i;
      localcov.xrG = 2;
      localcov.xXq = this.fWk.field_thumbimgLength;
      localcov.xXB = this.fWk.field_fileId;
      localcov.xlf = this.fWk.field_fileId;
      localcov.wDp = 1;
      if (!this.fWk.Jm()) {
        break label1098;
      }
      ab.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", new Object[] { alu(), Boolean.valueOf(this.fWk.field_upload_by_safecdn), Integer.valueOf(this.fWk.field_UploadHitCacheType), Integer.valueOf(this.fWk.field_filecrc), this.fWk.field_aesKey });
      localcov.xKZ = 1;
      localcov.wDo = "";
      localcov.xlh = "";
      localcov.xXD = this.fWk.field_filemd5;
      localcov.xXN = this.fWk.field_mp4identifymd5;
      localcov.wDq = this.fWk.field_filecrc;
      if ((this.fWj > 0) && (this.fWj <= 1048576)) {
        break label1125;
      }
      paramf = bh.aaQ();
      localcov.woU = paramf;
      localcov.xXM = ((s)localObject).cGU;
      paramf = ((s)localObject).fXG;
      if ((paramf == null) || (bo.isNullOrNil(paramf.fiO))) {
        break label1192;
      }
      localcov.xXE = bo.bf(paramf.fiO, "");
      localcov.xXF = paramf.wUJ;
      localcov.xXG = bo.bf(paramf.fiQ, "");
      localcov.xXI = bo.bf(paramf.fiS, "");
      localcov.xXH = bo.bf(paramf.fiR, "");
      localcov.xXJ = bo.bf(paramf.fiT, "");
      label630:
      if (paramf != null)
      {
        localcov.xXL = bo.bf(paramf.fiU, "");
        localcov.xXK = bo.bf(paramf.fiV, "");
      }
      o.alE();
      paramf = t.vg(this.fileName);
      localObject = com.tencent.mm.sdk.platformtools.d.aoT(paramf);
      if (localObject == null) {
        break label1237;
      }
      localcov.xXs = ((BitmapFactory.Options)localObject).outWidth;
      localcov.xXr = ((BitmapFactory.Options)localObject).outHeight;
      label707:
      o.alE();
      paramf = t.vf(this.fileName);
      localObject = n.alC();
      if (bo.isNullOrNil(paramf)) {
        break label1256;
      }
      paramf = (n.a)((n)localObject).fWG.get(paramf);
      if (paramf == null) {
        break label1256;
      }
      i = paramf.fWX;
      switch (i)
      {
      case 4: 
      case 5: 
      default: 
        label753:
        localcov.wDr = 0;
        localcov.niK = 0;
        label812:
        paramf = alu();
        localObject = this.fileName;
        str = this.fWk.field_toUser;
        if (this.fWk.field_aesKey != null) {
          break;
        }
      }
    }
    for (int i = -1;; i = this.fWk.field_aesKey.length())
    {
      ab.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn cdntra doscene file:%s touser:%s aes:%d fileid:%s thumb:[%d %d %d], thumbaeskey [%s] funcFlag: %d, md5:%s HitMd5:%d CRC32:%d, VideoNewMd5:%s AESKey:%s stream %s streamtime: %d title %s thumburl %s msgSource[%s] msgForwardType[%d] Source[%d]", new Object[] { paramf, localObject, str, Integer.valueOf(i), this.fWk.field_fileId, Integer.valueOf(this.fWk.field_thumbimgLength), Integer.valueOf(localcov.xXs), Integer.valueOf(localcov.xXr), bo.aqg(localcov.xlh), Integer.valueOf(localcov.wxV), localcov.xXD, Integer.valueOf(localcov.xKZ), Integer.valueOf(localcov.wDq), localcov.xXN, bo.aqg(localcov.wDo), localcov.xXE, Integer.valueOf(localcov.xXF), localcov.xXG, localcov.xXJ, localcov.woU, Integer.valueOf(localcov.wDr), Integer.valueOf(localcov.niK) });
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(50711);
      return i;
      i = 2;
      break;
      label1098:
      localcov.wDo = this.fWk.field_aesKey;
      localcov.xlh = this.fWk.field_aesKey;
      break label453;
      label1125:
      paramf = new StringBuilder();
      paramf.append("<msgsource>");
      paramf.append("<videopreloadlen>").append(this.fWj).append("</videopreloadlen>");
      paramf.append("</msgsource>");
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 35L, 1L, false);
      paramf = paramf.toString();
      break label510;
      label1192:
      if ((paramf == null) || (bo.isNullOrNil(paramf.fiS)) || (bo.isNullOrNil(paramf.fiR))) {
        break label630;
      }
      localcov.xXI = paramf.fiS;
      localcov.xXH = paramf.fiR;
      break label630;
      label1237:
      ab.w("MicroMsg.NetSceneUploadVideoForCdn", "cdntra getImageOptions for thumb failed path:%s", new Object[] { paramf });
      break label707;
      label1256:
      i = 0;
      break label753;
      localcov.wDr = 1;
      localcov.niK = 2;
      break label812;
      localcov.wDr = 1;
      localcov.niK = 1;
      break label812;
      localcov.wDr = 2;
      localcov.niK = 3;
      break label812;
      localcov.wDr = 3;
      localcov.niK = 4;
      break label812;
      localcov.wDr = 1;
      localcov.niK = 5;
      break label812;
    }
  }
  
  public final int getType()
  {
    return 149;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(50713);
    ab.i("MicroMsg.NetSceneUploadVideoForCdn", "%s cdntra onGYNetEnd errtype[%d %d]", new Object[] { alu(), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramArrayOfByte = (cow)((com.tencent.mm.ai.b)paramq).fsW.fta;
    paramq = u.vr(this.fileName);
    if (paramq == null)
    {
      ab.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.fWl.cG(3, -1);
      AppMethodBeat.o(50713);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == 102))
    {
      ab.e("MicroMsg.NetSceneUploadVideoForCdn", "summersafecdn ERR: MM_ERR_GET_AESKEY_FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + paramq.getUser());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.fWl.cG(paramInt2, paramInt3);
      AppMethodBeat.o(50713);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      ab.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd BLACK  errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + paramq.getUser());
      u.vl(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.fWl.cG(paramInt2, paramInt3);
      AppMethodBeat.o(50713);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + paramq.getUser());
      u.vk(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.fWl.cG(paramInt2, paramInt3);
      AppMethodBeat.o(50713);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + paramq.getUser());
      u.vk(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.fWl.cG(paramInt2, paramInt3);
      AppMethodBeat.o(50713);
      return;
    }
    paramq.fXv = bo.aox();
    paramq.cFn = paramArrayOfByte.pIG;
    ab.i("MicroMsg.NetSceneUploadVideoForCdn", "%s dkmsgid  set svrmsgid %d -> %d", new Object[] { alu(), Long.valueOf(paramq.cFn), Integer.valueOf(ae.gkL) });
    if ((10007 == ae.gkK) && (ae.gkL != 0) && (paramq.cFn != 0L))
    {
      paramq.cFn = ae.gkL;
      ae.gkL = 0;
    }
    paramq.status = 199;
    paramq.bsY = 1284;
    boolean bool;
    if (this.fWk.Jm())
    {
      ab.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], old RecvXml[%s]", new Object[] { alu(), paramArrayOfByte.wDo, paramq.alP() });
      if (bo.isNullOrNil(paramArrayOfByte.wDo)) {
        break label1299;
      }
      Object localObject = "<msg><videomsg aeskey=\"" + paramArrayOfByte.wDo + "\" cdnthumbaeskey=\"" + paramArrayOfByte.wDo + "\" cdnvideourl=\"" + this.fWk.field_fileId + "\" ";
      localObject = (String)localObject + "cdnthumburl=\"" + this.fWk.field_fileId + "\" ";
      localObject = (String)localObject + "length=\"" + this.fWk.field_fileLength + "\" ";
      localObject = (String)localObject + "cdnthumblength=\"" + this.fWk.field_thumbimgLength + "\"/></msg>";
      ab.i("MicroMsg.NetSceneUploadVideoForCdn", "cdn callback new build cdnInfo:%s", new Object[] { localObject });
      paramq.fXD = ((String)localObject);
      localObject = o.alE();
      o.alE();
      bool = ((t)localObject).s(t.vf(this.fileName), this.fWk.field_fileId, paramArrayOfByte.wDo);
      localObject = com.tencent.mm.plugin.report.service.h.qsU;
      if (bool)
      {
        paramInt1 = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject).e(12696, new Object[] { Integer.valueOf(paramInt1 + 900), Integer.valueOf(paramq.fsd) });
        ab.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], new RecvXml[%s], saveret[%b]", new Object[] { alu(), paramArrayOfByte.wDo, paramq.alP(), Boolean.valueOf(bool) });
      }
    }
    else
    {
      label1044:
      u.f(paramq);
      u.d(paramq);
      paramArrayOfByte = ((j)g.E(j.class)).bPQ().kB(paramq.fXy);
      com.tencent.mm.modelstat.b.fRu.j(paramArrayOfByte);
      paramArrayOfByte = paramq.getUser();
      paramArrayOfByte = ((j)g.E(j.class)).YA().arw(paramArrayOfByte);
      if ((paramArrayOfByte != null) && ((int)paramArrayOfByte.euF > 0)) {
        break label1321;
      }
      bool = false;
      label1137:
      if ((!bool) && (!com.tencent.mm.model.t.og(paramq.getUser()))) {
        break label1331;
      }
      ab.i("MicroMsg.NetSceneUploadVideoForCdn", "%s upload to biz :%s", new Object[] { alu(), paramq.getUser() });
      if (paramq.cFn < 0L)
      {
        ab.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + paramq.cFn + " file:" + this.fileName + " toUser:" + paramq.getUser());
        u.vk(this.fileName);
        this.fWl.cG(3, -1);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.fWl.cG(0, 0);
      AppMethodBeat.o(50713);
      return;
      paramInt1 = 2;
      break;
      label1299:
      ab.w("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn need aeskey but ret null", new Object[] { alu() });
      break label1044;
      label1321:
      bool = paramArrayOfByte.dwz();
      break label1137;
      label1331:
      ab.i("MicroMsg.NetSceneUploadVideoForCdn", "%s not upload to biz", new Object[] { alu() });
      if (paramq.cFn <= 0L)
      {
        ab.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + paramq.cFn + " file:" + this.fileName + " toUser:" + paramq.getUser());
        u.vk(this.fileName);
        this.fWl.cG(3, -1);
      }
    }
  }
  
  public final int securityLimitCount()
  {
    return 1;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
  
  public final void setSecurityCheckError(m.a parama)
  {
    AppMethodBeat.i(50712);
    u.vk(this.fileName);
    AppMethodBeat.o(50712);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.h
 * JD-Core Version:    0.7.0.1
 */