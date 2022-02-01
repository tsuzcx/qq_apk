package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.i.d;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.w;
import com.tencent.mm.network.ae;
import com.tencent.mm.network.e;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.protocal.protobuf.dib;
import com.tencent.mm.protocal.protobuf.dic;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.i;
import java.util.HashMap;
import junit.framework.Assert;

public final class h
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  String fileName;
  private int hyV;
  private d hyW;
  private a hyX;
  private com.tencent.mm.al.b rr;
  
  public h(String paramString, int paramInt, d paramd, a parama)
  {
    AppMethodBeat.i(126871);
    this.fileName = null;
    this.hyV = 0;
    this.hyW = null;
    this.hyX = null;
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
      this.hyW = paramd;
      this.hyX = parama;
      this.hyV = paramInt;
      AppMethodBeat.o(126871);
      return;
    }
  }
  
  private String aCy()
  {
    AppMethodBeat.i(126875);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(126875);
    return str;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(126872);
    this.callback = paramg;
    Object localObject1 = u.Ae(this.fileName);
    if (localObject1 == null)
    {
      ad.e("MicroMsg.NetSceneUploadVideoForCdn", "Get info Failed file:" + this.fileName);
      this.hyX.dm(3, -1);
      AppMethodBeat.o(126872);
      return -1;
    }
    paramg = new b.a();
    paramg.gUU = new dib();
    paramg.gUV = new dic();
    paramg.uri = "/cgi-bin/micromsg-bin/uploadvideo";
    paramg.funcId = 149;
    paramg.reqCmdId = 39;
    paramg.respCmdId = 1000000039;
    this.rr = paramg.atI();
    dib localdib = (dib)this.rr.gUS.gUX;
    localdib.Eyg = 0;
    localdib.Eyf = ((int)this.hyW.field_fileLength);
    localdib.Eyh = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    localdib.DMp = 0;
    localdib.DMo = this.hyW.field_thumbimgLength;
    localdib.DMq = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    localdib.sdQ = com.tencent.mm.model.u.aqG();
    localdib.sdP = this.hyW.field_toUser;
    localdib.CyF = this.fileName;
    if (((s)localObject1).hAl == 1) {
      localdib.CID = 2;
    }
    if (((s)localObject1).hAo == 3) {
      localdib.CID = 3;
    }
    localdib.Ekx = ((s)localObject1).gOY;
    label454:
    Object localObject2;
    if (ae.cJ(aj.getContext()))
    {
      i = 1;
      localdib.DcM = i;
      localdib.DMr = 2;
      localdib.ExX = this.hyW.field_thumbimgLength;
      localdib.Eyi = this.hyW.field_fileId;
      localdib.DER = this.hyW.field_fileId;
      localdib.COQ = 1;
      if (!this.hyW.UC()) {
        break label1222;
      }
      ad.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", new Object[] { aCy(), Boolean.valueOf(this.hyW.field_upload_by_safecdn), Integer.valueOf(this.hyW.field_UploadHitCacheType), Integer.valueOf(this.hyW.field_filecrc), this.hyW.field_aesKey });
      localdib.EiL = 1;
      localdib.COP = "";
      localdib.DET = "";
      localdib.Eyk = this.hyW.field_filemd5;
      localdib.Eyu = this.hyW.field_mp4identifymd5;
      localdib.COR = this.hyW.field_filecrc;
      localObject2 = u.Ae(this.fileName);
      paramg = null;
      if (localObject2 != null)
      {
        if (bt.isNullOrNil(((s)localObject2).hAt)) {
          break label1249;
        }
        paramg = ((s)localObject2).hAt;
      }
      label523:
      ad.i("MicroMsg.NetSceneUploadVideoForCdn", "createVideoMsgSource preLoadLength: %s, forward uuid %s", new Object[] { Integer.valueOf(this.hyV), paramg });
      if ((this.hyV > 0) && (this.hyV <= 1048576)) {
        break label1322;
      }
      if (!bt.isNullOrNil(paramg)) {
        break label1314;
      }
      paramg = bk.SM();
      label577:
      localdib.CxC = paramg;
      localdib.Eyt = ((s)localObject1).dxG;
      if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(this.hyW.field_toUser)) {
        localdib.COT = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aIi(this.hyW.field_toUser);
      }
      paramg = ((s)localObject1).hAq;
      if ((paramg == null) || (bt.isNullOrNil(paramg.gJv))) {
        break label1420;
      }
      localdib.Eyl = bt.by(paramg.gJv, "");
      localdib.Eym = paramg.Dim;
      localdib.Eyn = bt.by(paramg.gJx, "");
      localdib.Eyp = bt.by(paramg.gJz, "");
      localdib.Eyo = bt.by(paramg.gJy, "");
      localdib.Eyq = bt.by(paramg.gJA, "");
      label752:
      if (paramg != null)
      {
        localdib.Eys = bt.by(paramg.gJB, "");
        localdib.Eyr = bt.by(paramg.gJC, "");
      }
      o.aCI();
      paramg = t.zR(this.fileName);
      localObject1 = f.aFf(paramg);
      if (localObject1 == null) {
        break label1465;
      }
      localdib.ExZ = ((BitmapFactory.Options)localObject1).outWidth;
      localdib.ExY = ((BitmapFactory.Options)localObject1).outHeight;
      label829:
      o.aCI();
      paramg = t.zQ(this.fileName);
      localObject1 = n.aCG();
      if (bt.isNullOrNil(paramg)) {
        break label1484;
      }
      paramg = (n.a)((n)localObject1).hzs.get(paramg);
      if (paramg == null) {
        break label1484;
      }
      i = paramg.hzJ;
      switch (i)
      {
      case 4: 
      case 5: 
      default: 
        label875:
        localdib.COS = 0;
        localdib.rNz = 0;
        label936:
        paramg = aCy();
        localObject1 = this.fileName;
        localObject2 = this.hyW.field_toUser;
        if (this.hyW.field_aesKey != null) {
          break;
        }
      }
    }
    for (int i = -1;; i = this.hyW.field_aesKey.length())
    {
      ad.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn cdntra doscene file:%s touser:%s aes:%d fileid:%s thumb:[%d %d %d], thumbaeskey [%s] funcFlag: %d, md5:%s HitMd5:%d CRC32:%d, VideoNewMd5:%s AESKey:%s stream %s streamtime: %d title %s thumburl %s msgSource[%s] msgForwardType[%d] Source[%d]", new Object[] { paramg, localObject1, localObject2, Integer.valueOf(i), this.hyW.field_fileId, Integer.valueOf(this.hyW.field_thumbimgLength), Integer.valueOf(localdib.ExZ), Integer.valueOf(localdib.ExY), bt.aGs(localdib.DET), Integer.valueOf(localdib.CID), localdib.Eyk, Integer.valueOf(localdib.EiL), Integer.valueOf(localdib.COR), localdib.Eyu, bt.aGs(localdib.COP), localdib.Eyl, Integer.valueOf(localdib.Eym), localdib.Eyn, localdib.Eyq, localdib.CxC, Integer.valueOf(localdib.COS), Integer.valueOf(localdib.rNz) });
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(126872);
      return i;
      i = 2;
      break;
      label1222:
      localdib.COP = this.hyW.field_aesKey;
      localdib.DET = this.hyW.field_aesKey;
      break label454;
      label1249:
      if (((s)localObject2).hAs > 0)
      {
        paramg = bk.uo(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(((s)localObject2).hAs).esh);
        break label523;
      }
      paramg = i.aEN(((s)localObject2).aCS());
      localObject2 = v.hUC;
      paramg = v.BC(paramg);
      break label523;
      label1314:
      paramg = bk.up(paramg);
      break label577;
      label1322:
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<msgsource>");
      ((StringBuilder)localObject2).append("<videopreloadlen>").append(this.hyV).append("</videopreloadlen>");
      if (!bt.isNullOrNil(paramg)) {
        ((StringBuilder)localObject2).append("<sec_msg_node><uuid>").append(paramg).append("</uuid></sec_msg_node>");
      }
      ((StringBuilder)localObject2).append("</msgsource>");
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 35L, 1L, false);
      paramg = ((StringBuilder)localObject2).toString();
      break label577;
      label1420:
      if ((paramg == null) || (bt.isNullOrNil(paramg.gJz)) || (bt.isNullOrNil(paramg.gJy))) {
        break label752;
      }
      localdib.Eyp = paramg.gJz;
      localdib.Eyo = paramg.gJy;
      break label752;
      label1465:
      ad.w("MicroMsg.NetSceneUploadVideoForCdn", "cdntra getImageOptions for thumb failed path:%s", new Object[] { paramg });
      break label829;
      label1484:
      i = 0;
      break label875;
      localdib.COS = 1;
      localdib.rNz = 2;
      break label936;
      localdib.COS = 1;
      localdib.rNz = 1;
      break label936;
      localdib.COS = 2;
      localdib.rNz = 3;
      break label936;
      localdib.COS = 3;
      localdib.rNz = 4;
      break label936;
      localdib.COS = 1;
      localdib.rNz = 5;
      break label936;
    }
  }
  
  public final int getType()
  {
    return 149;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126874);
    ad.i("MicroMsg.NetSceneUploadVideoForCdn", "%s cdntra onGYNetEnd errtype[%d %d]", new Object[] { aCy(), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramArrayOfByte = (dic)((com.tencent.mm.al.b)paramq).gUT.gUX;
    if ((paramArrayOfByte != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(paramArrayOfByte.COU);
    }
    paramq = u.Ae(this.fileName);
    if (paramq == null)
    {
      ad.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.hyX.dm(3, -1);
      AppMethodBeat.o(126874);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == 102))
    {
      ad.e("MicroMsg.NetSceneUploadVideoForCdn", "summersafecdn ERR: MM_ERR_GET_AESKEY_FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + paramq.getUser());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.hyX.dm(paramInt2, paramInt3);
      AppMethodBeat.o(126874);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      ad.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd BLACK  errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + paramq.getUser());
      u.zW(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.hyX.dm(paramInt2, paramInt3);
      AppMethodBeat.o(126874);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + paramq.getUser());
      u.zV(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.hyX.dm(paramInt2, paramInt3);
      AppMethodBeat.o(126874);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + paramq.getUser());
      u.zV(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.hyX.dm(paramInt2, paramInt3);
      AppMethodBeat.o(126874);
      return;
    }
    paramq.hAg = bt.aGK();
    paramq.drA = paramArrayOfByte.uKZ;
    ad.i("MicroMsg.NetSceneUploadVideoForCdn", "%s dkmsgid  set svrmsgid %d -> %d", new Object[] { aCy(), Long.valueOf(paramq.drA), Integer.valueOf(ab.hVD) });
    if ((10007 == ab.hVC) && (ab.hVD != 0) && (paramq.drA != 0L))
    {
      paramq.drA = ab.hVD;
      ab.hVD = 0;
    }
    paramq.status = 199;
    paramq.dtM = 1284;
    Object localObject;
    boolean bool;
    if (this.hyW.UC())
    {
      ad.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], old RecvXml[%s]", new Object[] { aCy(), paramArrayOfByte.COP, paramq.aCT() });
      if (bt.isNullOrNil(paramArrayOfByte.COP)) {
        break label1372;
      }
      localObject = "<msg><videomsg aeskey=\"" + paramArrayOfByte.COP + "\" cdnthumbaeskey=\"" + paramArrayOfByte.COP + "\" cdnvideourl=\"" + this.hyW.field_fileId + "\" ";
      localObject = (String)localObject + "cdnthumburl=\"" + this.hyW.field_fileId + "\" ";
      localObject = (String)localObject + "length=\"" + this.hyW.field_fileLength + "\" ";
      localObject = (String)localObject + "cdnthumblength=\"" + this.hyW.field_thumbimgLength + "\"/></msg>";
      ad.i("MicroMsg.NetSceneUploadVideoForCdn", "cdn callback new build cdnInfo:%s", new Object[] { localObject });
      paramq.hAn = ((String)localObject);
      localObject = o.aCI();
      o.aCI();
      bool = ((t)localObject).r(t.zQ(this.fileName), this.hyW.field_fileId, paramArrayOfByte.COP);
      localObject = com.tencent.mm.plugin.report.service.h.vKh;
      if (bool)
      {
        paramInt1 = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject).f(12696, new Object[] { Integer.valueOf(paramInt1 + 900), Integer.valueOf(paramq.gTY) });
        ad.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], new RecvXml[%s], saveret[%b]", new Object[] { aCy(), paramArrayOfByte.COP, paramq.aCT(), Boolean.valueOf(bool) });
      }
    }
    else
    {
      label1081:
      u.f(paramq);
      u.d(paramq);
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(paramq.hAi);
      ((bl)localObject).mZ(paramArrayOfByte.CxC);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(((du)localObject).field_msgId, (bl)localObject);
      com.tencent.mm.modelstat.b.huc.q((bl)localObject);
      paramArrayOfByte = paramq.getUser();
      paramArrayOfByte = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramArrayOfByte);
      if ((paramArrayOfByte != null) && ((int)paramArrayOfByte.fId > 0)) {
        break label1394;
      }
      bool = false;
      label1210:
      if ((!bool) && (!w.sQ(paramq.getUser()))) {
        break label1404;
      }
      ad.i("MicroMsg.NetSceneUploadVideoForCdn", "%s upload to biz :%s", new Object[] { aCy(), paramq.getUser() });
      if (paramq.drA < 0L)
      {
        ad.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + paramq.drA + " file:" + this.fileName + " toUser:" + paramq.getUser());
        u.zV(this.fileName);
        this.hyX.dm(3, -1);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.hyX.dm(0, 0);
      AppMethodBeat.o(126874);
      return;
      paramInt1 = 2;
      break;
      label1372:
      ad.w("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn need aeskey but ret null", new Object[] { aCy() });
      break label1081;
      label1394:
      bool = paramArrayOfByte.eKB();
      break label1210;
      label1404:
      ad.i("MicroMsg.NetSceneUploadVideoForCdn", "%s not upload to biz", new Object[] { aCy() });
      if (paramq.drA <= 0L)
      {
        ad.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + paramq.drA + " file:" + this.fileName + " toUser:" + paramq.getUser());
        u.zV(this.fileName);
        this.hyX.dm(3, -1);
      }
    }
  }
  
  public final int securityLimitCount()
  {
    return 1;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.gVB;
  }
  
  public final void setSecurityCheckError(com.tencent.mm.al.n.a parama)
  {
    AppMethodBeat.i(126873);
    u.zV(this.fileName);
    AppMethodBeat.o(126873);
  }
  
  public static abstract interface a
  {
    public abstract void dm(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.h
 * JD-Core Version:    0.7.0.1
 */