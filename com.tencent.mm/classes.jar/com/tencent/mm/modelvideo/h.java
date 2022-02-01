package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.i.d;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.w;
import com.tencent.mm.network.ae;
import com.tencent.mm.network.e;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.protocal.protobuf.dnq;
import com.tencent.mm.protocal.protobuf.dnr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;
import java.util.HashMap;
import junit.framework.Assert;

public final class h
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g callback;
  String fileName;
  private int hZw;
  private d hZx;
  private a hZy;
  private com.tencent.mm.ak.b rr;
  
  public h(String paramString, int paramInt, d paramd, a parama)
  {
    AppMethodBeat.i(126871);
    this.fileName = null;
    this.hZw = 0;
    this.hZx = null;
    this.hZy = null;
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
      this.hZx = paramd;
      this.hZy = parama;
      this.hZw = paramInt;
      AppMethodBeat.o(126871);
      return;
    }
  }
  
  private String aJp()
  {
    AppMethodBeat.i(126875);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(126875);
    return str;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(126872);
    this.callback = paramg;
    Object localObject1 = u.Ej(this.fileName);
    if (localObject1 == null)
    {
      ac.e("MicroMsg.NetSceneUploadVideoForCdn", "Get info Failed file:" + this.fileName);
      this.hZy.dm(3, -1);
      AppMethodBeat.o(126872);
      return -1;
    }
    paramg = new b.a();
    paramg.hvt = new dnq();
    paramg.hvu = new dnr();
    paramg.uri = "/cgi-bin/micromsg-bin/uploadvideo";
    paramg.funcId = 149;
    paramg.reqCmdId = 39;
    paramg.respCmdId = 1000000039;
    this.rr = paramg.aAz();
    dnq localdnq = (dnq)this.rr.hvr.hvw;
    localdnq.FVi = 0;
    localdnq.FVh = ((int)this.hZx.field_fileLength);
    localdnq.FVj = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    localdnq.FiF = 0;
    localdnq.FiE = this.hZx.field_thumbimgLength;
    localdnq.FiG = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    localdnq.tlK = com.tencent.mm.model.u.axw();
    localdnq.tlJ = this.hZx.field_toUser;
    localdnq.DRb = this.fileName;
    if (((s)localObject1).iaM == 1) {
      localdnq.Ebf = 2;
    }
    if (((s)localObject1).iaP == 3) {
      localdnq.Ebf = 3;
    }
    localdnq.FHv = ((s)localObject1).hpy;
    label454:
    Object localObject2;
    if (ae.cS(com.tencent.mm.sdk.platformtools.ai.getContext()))
    {
      i = 1;
      localdnq.EvT = i;
      localdnq.FiH = 2;
      localdnq.FUZ = this.hZx.field_thumbimgLength;
      localdnq.FVk = this.hZx.field_fileId;
      localdnq.Fam = this.hZx.field_fileId;
      localdnq.EhB = 1;
      if (!this.hZx.Vx()) {
        break label1222;
      }
      ac.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", new Object[] { aJp(), Boolean.valueOf(this.hZx.field_upload_by_safecdn), Integer.valueOf(this.hZx.field_UploadHitCacheType), Integer.valueOf(this.hZx.field_filecrc), this.hZx.field_aesKey });
      localdnq.FFJ = 1;
      localdnq.EhA = "";
      localdnq.Fao = "";
      localdnq.FVm = this.hZx.field_filemd5;
      localdnq.FVw = this.hZx.field_mp4identifymd5;
      localdnq.EhC = this.hZx.field_filecrc;
      localObject2 = u.Ej(this.fileName);
      paramg = null;
      if (localObject2 != null)
      {
        if (bs.isNullOrNil(((s)localObject2).iaU)) {
          break label1249;
        }
        paramg = ((s)localObject2).iaU;
      }
      label523:
      ac.i("MicroMsg.NetSceneUploadVideoForCdn", "createVideoMsgSource preLoadLength: %s, forward uuid %s", new Object[] { Integer.valueOf(this.hZw), paramg });
      if ((this.hZw > 0) && (this.hZw <= 1048576)) {
        break label1322;
      }
      if (!bs.isNullOrNil(paramg)) {
        break label1314;
      }
      paramg = bk.TG();
      label577:
      localdnq.DPY = paramg;
      localdnq.FVv = ((s)localObject1).dvs;
      if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(this.hZx.field_toUser)) {
        localdnq.EhE = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aND(this.hZx.field_toUser);
      }
      paramg = ((s)localObject1).iaR;
      if ((paramg == null) || (bs.isNullOrNil(paramg.hjV))) {
        break label1420;
      }
      localdnq.FVn = bs.bG(paramg.hjV, "");
      localdnq.FVo = paramg.EBs;
      localdnq.FVp = bs.bG(paramg.hjX, "");
      localdnq.FVr = bs.bG(paramg.hjZ, "");
      localdnq.FVq = bs.bG(paramg.hjY, "");
      localdnq.FVs = bs.bG(paramg.hka, "");
      label752:
      if (paramg != null)
      {
        localdnq.FVu = bs.bG(paramg.hkb, "");
        localdnq.FVt = bs.bG(paramg.hkc, "");
      }
      o.aJy();
      paramg = t.DW(this.fileName);
      localObject1 = f.aKw(paramg);
      if (localObject1 == null) {
        break label1465;
      }
      localdnq.FVb = ((BitmapFactory.Options)localObject1).outWidth;
      localdnq.FVa = ((BitmapFactory.Options)localObject1).outHeight;
      label829:
      o.aJy();
      paramg = t.DV(this.fileName);
      localObject1 = n.aJw();
      if (bs.isNullOrNil(paramg)) {
        break label1484;
      }
      paramg = (n.a)((n)localObject1).hZT.get(paramg);
      if (paramg == null) {
        break label1484;
      }
      i = paramg.iak;
      switch (i)
      {
      case 4: 
      case 5: 
      default: 
        label875:
        localdnq.EhD = 0;
        localdnq.sVo = 0;
        label936:
        paramg = aJp();
        localObject1 = this.fileName;
        localObject2 = this.hZx.field_toUser;
        if (this.hZx.field_aesKey != null) {
          break;
        }
      }
    }
    for (int i = -1;; i = this.hZx.field_aesKey.length())
    {
      ac.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn cdntra doscene file:%s touser:%s aes:%d fileid:%s thumb:[%d %d %d], thumbaeskey [%s] funcFlag: %d, md5:%s HitMd5:%d CRC32:%d, VideoNewMd5:%s AESKey:%s stream %s streamtime: %d title %s thumburl %s msgSource[%s] msgForwardType[%d] Source[%d]", new Object[] { paramg, localObject1, localObject2, Integer.valueOf(i), this.hZx.field_fileId, Integer.valueOf(this.hZx.field_thumbimgLength), Integer.valueOf(localdnq.FVb), Integer.valueOf(localdnq.FVa), bs.aLJ(localdnq.Fao), Integer.valueOf(localdnq.Ebf), localdnq.FVm, Integer.valueOf(localdnq.FFJ), Integer.valueOf(localdnq.EhC), localdnq.FVw, bs.aLJ(localdnq.EhA), localdnq.FVn, Integer.valueOf(localdnq.FVo), localdnq.FVp, localdnq.FVs, localdnq.DPY, Integer.valueOf(localdnq.EhD), Integer.valueOf(localdnq.sVo) });
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(126872);
      return i;
      i = 2;
      break;
      label1222:
      localdnq.EhA = this.hZx.field_aesKey;
      localdnq.Fao = this.hZx.field_aesKey;
      break label454;
      label1249:
      if (((s)localObject2).iaT > 0)
      {
        paramg = bk.yu(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(((s)localObject2).iaT).eul);
        break label523;
      }
      paramg = i.aKe(((s)localObject2).aJJ());
      localObject2 = v.iuG;
      paramg = v.FG(paramg);
      break label523;
      label1314:
      paramg = bk.yv(paramg);
      break label577;
      label1322:
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<msgsource>");
      ((StringBuilder)localObject2).append("<videopreloadlen>").append(this.hZw).append("</videopreloadlen>");
      if (!bs.isNullOrNil(paramg)) {
        ((StringBuilder)localObject2).append("<sec_msg_node><uuid>").append(paramg).append("</uuid></sec_msg_node>");
      }
      ((StringBuilder)localObject2).append("</msgsource>");
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 35L, 1L, false);
      paramg = ((StringBuilder)localObject2).toString();
      break label577;
      label1420:
      if ((paramg == null) || (bs.isNullOrNil(paramg.hjZ)) || (bs.isNullOrNil(paramg.hjY))) {
        break label752;
      }
      localdnq.FVr = paramg.hjZ;
      localdnq.FVq = paramg.hjY;
      break label752;
      label1465:
      ac.w("MicroMsg.NetSceneUploadVideoForCdn", "cdntra getImageOptions for thumb failed path:%s", new Object[] { paramg });
      break label829;
      label1484:
      i = 0;
      break label875;
      localdnq.EhD = 1;
      localdnq.sVo = 2;
      break label936;
      localdnq.EhD = 1;
      localdnq.sVo = 1;
      break label936;
      localdnq.EhD = 2;
      localdnq.sVo = 3;
      break label936;
      localdnq.EhD = 3;
      localdnq.sVo = 4;
      break label936;
      localdnq.EhD = 1;
      localdnq.sVo = 5;
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
    ac.i("MicroMsg.NetSceneUploadVideoForCdn", "%s cdntra onGYNetEnd errtype[%d %d]", new Object[] { aJp(), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramArrayOfByte = (dnr)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    if ((paramArrayOfByte != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(paramArrayOfByte.EhF);
    }
    paramq = u.Ej(this.fileName);
    if (paramq == null)
    {
      ac.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.hZy.dm(3, -1);
      AppMethodBeat.o(126874);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == 102))
    {
      ac.e("MicroMsg.NetSceneUploadVideoForCdn", "summersafecdn ERR: MM_ERR_GET_AESKEY_FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + paramq.getUser());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.hZy.dm(paramInt2, paramInt3);
      AppMethodBeat.o(126874);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      ac.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd BLACK  errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + paramq.getUser());
      u.Eb(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.hZy.dm(paramInt2, paramInt3);
      AppMethodBeat.o(126874);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + paramq.getUser());
      u.Ea(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.hZy.dm(paramInt2, paramInt3);
      AppMethodBeat.o(126874);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + paramq.getUser());
      u.Ea(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.hZy.dm(paramInt2, paramInt3);
      AppMethodBeat.o(126874);
      return;
    }
    paramq.iaH = bs.aNx();
    paramq.dpl = paramArrayOfByte.vTQ;
    ac.i("MicroMsg.NetSceneUploadVideoForCdn", "%s dkmsgid  set svrmsgid %d -> %d", new Object[] { aJp(), Long.valueOf(paramq.dpl), Integer.valueOf(ab.ivH) });
    if ((10007 == ab.ivG) && (ab.ivH != 0) && (paramq.dpl != 0L))
    {
      paramq.dpl = ab.ivH;
      ab.ivH = 0;
    }
    paramq.status = 199;
    paramq.drx = 1284;
    Object localObject;
    boolean bool;
    if (this.hZx.Vx())
    {
      ac.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], old RecvXml[%s]", new Object[] { aJp(), paramArrayOfByte.EhA, paramq.aJK() });
      if (bs.isNullOrNil(paramArrayOfByte.EhA)) {
        break label1372;
      }
      localObject = "<msg><videomsg aeskey=\"" + paramArrayOfByte.EhA + "\" cdnthumbaeskey=\"" + paramArrayOfByte.EhA + "\" cdnvideourl=\"" + this.hZx.field_fileId + "\" ";
      localObject = (String)localObject + "cdnthumburl=\"" + this.hZx.field_fileId + "\" ";
      localObject = (String)localObject + "length=\"" + this.hZx.field_fileLength + "\" ";
      localObject = (String)localObject + "cdnthumblength=\"" + this.hZx.field_thumbimgLength + "\"/></msg>";
      ac.i("MicroMsg.NetSceneUploadVideoForCdn", "cdn callback new build cdnInfo:%s", new Object[] { localObject });
      paramq.iaO = ((String)localObject);
      localObject = o.aJy();
      o.aJy();
      bool = ((t)localObject).r(t.DV(this.fileName), this.hZx.field_fileId, paramArrayOfByte.EhA);
      localObject = com.tencent.mm.plugin.report.service.h.wUl;
      if (bool)
      {
        paramInt1 = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject).f(12696, new Object[] { Integer.valueOf(paramInt1 + 900), Integer.valueOf(paramq.hux) });
        ac.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], new RecvXml[%s], saveret[%b]", new Object[] { aJp(), paramArrayOfByte.EhA, paramq.aJK(), Boolean.valueOf(bool) });
      }
    }
    else
    {
      label1081:
      u.f(paramq);
      u.d(paramq);
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(paramq.iaJ);
      ((bo)localObject).qf(paramArrayOfByte.DPY);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(((dy)localObject).field_msgId, (bo)localObject);
      com.tencent.mm.modelstat.b.hUE.q((bo)localObject);
      paramArrayOfByte = paramq.getUser();
      paramArrayOfByte = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramArrayOfByte);
      if ((paramArrayOfByte != null) && ((int)paramArrayOfByte.fLJ > 0)) {
        break label1394;
      }
      bool = false;
      label1210:
      if ((!bool) && (!w.wT(paramq.getUser()))) {
        break label1404;
      }
      ac.i("MicroMsg.NetSceneUploadVideoForCdn", "%s upload to biz :%s", new Object[] { aJp(), paramq.getUser() });
      if (paramq.dpl < 0L)
      {
        ac.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + paramq.dpl + " file:" + this.fileName + " toUser:" + paramq.getUser());
        u.Ea(this.fileName);
        this.hZy.dm(3, -1);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.hZy.dm(0, 0);
      AppMethodBeat.o(126874);
      return;
      paramInt1 = 2;
      break;
      label1372:
      ac.w("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn need aeskey but ret null", new Object[] { aJp() });
      break label1081;
      label1394:
      bool = paramArrayOfByte.fad();
      break label1210;
      label1404:
      ac.i("MicroMsg.NetSceneUploadVideoForCdn", "%s not upload to biz", new Object[] { aJp() });
      if (paramq.dpl <= 0L)
      {
        ac.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + paramq.dpl + " file:" + this.fileName + " toUser:" + paramq.getUser());
        u.Ea(this.fileName);
        this.hZy.dm(3, -1);
      }
    }
  }
  
  public final int securityLimitCount()
  {
    return 1;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hwa;
  }
  
  public final void setSecurityCheckError(com.tencent.mm.ak.n.a parama)
  {
    AppMethodBeat.i(126873);
    u.Ea(this.fileName);
    AppMethodBeat.o(126873);
  }
  
  public static abstract interface a
  {
    public abstract void dm(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.h
 * JD-Core Version:    0.7.0.1
 */