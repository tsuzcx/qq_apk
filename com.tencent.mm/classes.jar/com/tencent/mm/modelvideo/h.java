package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.d;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.x;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.protocal.protobuf.due;
import com.tencent.mm.protocal.protobuf.duf;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import junit.framework.Assert;

public final class h
  extends com.tencent.mm.ak.n
  implements k
{
  private com.tencent.mm.ak.f callback;
  String fileName;
  private int ifG;
  public d ifH;
  public com.tencent.mm.av.f ifI;
  private com.tencent.mm.ak.b rr;
  
  public h(String paramString, int paramInt, d paramd, com.tencent.mm.av.f paramf)
  {
    AppMethodBeat.i(217475);
    this.fileName = null;
    this.ifG = 0;
    this.ifH = null;
    this.ifI = null;
    if (paramString != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (paramd == null) {
        break label103;
      }
      bool1 = true;
      label51:
      Assert.assertTrue(bool1);
      if (paramf == null) {
        break label109;
      }
    }
    label103:
    label109:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      this.fileName = paramString;
      this.ifH = paramd;
      this.ifI = paramf;
      this.ifG = paramInt;
      AppMethodBeat.o(217475);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label51;
    }
  }
  
  private static boolean Ht(String paramString)
  {
    AppMethodBeat.i(217479);
    paramString = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramString);
    if ((paramString == null) || ((int)paramString.ght <= 0))
    {
      AppMethodBeat.o(217479);
      return false;
    }
    boolean bool = paramString.fug();
    AppMethodBeat.o(217479);
    return bool;
  }
  
  private String aMX()
  {
    AppMethodBeat.i(126875);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(126875);
    return str;
  }
  
  private String aMZ()
  {
    AppMethodBeat.i(217477);
    Object localObject = u.Ia(this.fileName);
    String str = null;
    if (localObject != null)
    {
      if (bu.isNullOrNil(((s)localObject).ixk)) {
        break label93;
      }
      str = ((s)localObject).ixk;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideoForCdn", "createVideoMsgSource preLoadLength: %s, forward uuid %s", new Object[] { Integer.valueOf(this.ifG), str });
      if ((this.ifG > 0) && (this.ifG <= 1048576)) {
        break label165;
      }
      if (!bu.isNullOrNil(str)) {
        break;
      }
      str = bn.We();
      AppMethodBeat.o(217477);
      return str;
      label93:
      if (((s)localObject).ixj > 0)
      {
        str = bn.BV(((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(((s)localObject).ixj).eNd);
      }
      else
      {
        str = com.tencent.mm.vfs.o.aRh(((s)localObject).aNs());
        localObject = com.tencent.mm.platformtools.v.iQD;
        str = com.tencent.mm.platformtools.v.Ju(str);
      }
    }
    str = bn.BW(str);
    AppMethodBeat.o(217477);
    return str;
    label165:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("<msgsource>");
    ((StringBuilder)localObject).append("<videopreloadlen>").append(this.ifG).append("</videopreloadlen>");
    if (!bu.isNullOrNil(str)) {
      ((StringBuilder)localObject).append("<sec_msg_node><uuid>").append(str).append("</uuid></sec_msg_node>");
    }
    ((StringBuilder)localObject).append("</msgsource>");
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 35L, 1L, false);
    str = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(217477);
    return str;
  }
  
  public final due a(s params, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(217476);
    this.callback = paramf;
    paramf = new b.a();
    paramf.hQF = new due();
    paramf.hQG = new duf();
    paramf.uri = "/cgi-bin/micromsg-bin/uploadvideo";
    paramf.funcId = 149;
    paramf.hQH = 39;
    paramf.respCmdId = 1000000039;
    this.rr = paramf.aDS();
    paramf = (due)this.rr.hQD.hQJ;
    paramf.HZJ = 0;
    paramf.HZI = ((int)this.ifH.field_fileLength);
    paramf.HZK = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    paramf.HlH = 0;
    paramf.HlG = this.ifH.field_thumbimgLength;
    paramf.HlI = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    paramf.uvG = com.tencent.mm.model.v.aAC();
    paramf.uvF = this.ifH.field_toUser;
    paramf.FOR = this.fileName;
    if (params.ixc == 1) {
      paramf.FZk = 2;
    }
    if (params.ixf == 3) {
      paramf.FZk = 3;
    }
    paramf.HLF = params.hKI;
    label373:
    Object localObject;
    label572:
    label722:
    String str;
    if (com.tencent.mm.network.ae.cR(ak.getContext()))
    {
      i = 1;
      paramf.GvW = i;
      paramf.HlJ = 2;
      paramf.HZA = this.ifH.field_thumbimgLength;
      paramf.HZL = this.ifH.field_fileId;
      paramf.Hdm = this.ifH.field_fileId;
      paramf.Ghh = 1;
      if (!this.ifH.XY()) {
        break label981;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", new Object[] { aMX(), Boolean.valueOf(this.ifH.field_upload_by_safecdn), Integer.valueOf(this.ifH.field_UploadHitCacheType), Integer.valueOf(this.ifH.field_filecrc), this.ifH.field_aesKey });
      paramf.HJK = 1;
      paramf.Ghg = "";
      paramf.Hdo = "";
      paramf.HZN = this.ifH.field_filemd5;
      paramf.HZX = this.ifH.field_mp4identifymd5;
      paramf.Ghi = this.ifH.field_filecrc;
      paramf.FNL = aMZ();
      paramf.HZW = params.dIA;
      if (((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(this.ifH.field_toUser)) {
        paramf.Ghk = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUV(this.ifH.field_toUser);
      }
      params = params.ixh;
      if ((params == null) || (bu.isNullOrNil(params.hET))) {
        break label1006;
      }
      paramf.HZO = bu.bI(params.hET, "");
      paramf.HZP = params.GBN;
      paramf.HZQ = bu.bI(params.hEV, "");
      paramf.HZS = bu.bI(params.hEX, "");
      paramf.HZR = bu.bI(params.hEW, "");
      paramf.HZT = bu.bI(params.hEY, "");
      if (params != null)
      {
        paramf.HZV = bu.bI(params.hEZ, "");
        paramf.HZU = bu.bI(params.hFa, "");
      }
      o.aNh();
      params = t.HK(this.fileName);
      localObject = com.tencent.mm.sdk.platformtools.h.aRz(params);
      if (localObject == null) {
        break label1049;
      }
      paramf.HZC = ((BitmapFactory.Options)localObject).outWidth;
      paramf.HZB = ((BitmapFactory.Options)localObject).outHeight;
      label645:
      o.aNh();
      params = t.HJ(this.fileName);
      switch (n.aNf().Hw(params))
      {
      case 4: 
      case 5: 
      default: 
        paramf.Ghj = 0;
        paramf.ucK = 0;
        params = aMX();
        localObject = this.fileName;
        str = this.ifH.field_toUser;
        if (this.ifH.field_aesKey != null) {
          break;
        }
      }
    }
    for (int i = -1;; i = this.ifH.field_aesKey.length())
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn cdntra doscene file:%s touser:%s aes:%d fileid:%s thumb:[%d %d %d], thumbaeskey [%s] funcFlag: %d, md5:%s HitMd5:%d CRC32:%d, VideoNewMd5:%s AESKey:%s stream %s streamtime: %d title %s thumburl %s msgSource[%s] msgForwardType[%d] Source[%d]", new Object[] { params, localObject, str, Integer.valueOf(i), this.ifH.field_fileId, Integer.valueOf(this.ifH.field_thumbimgLength), Integer.valueOf(paramf.HZC), Integer.valueOf(paramf.HZB), bu.aSM(paramf.Hdo), Integer.valueOf(paramf.FZk), paramf.HZN, Integer.valueOf(paramf.HJK), Integer.valueOf(paramf.Ghi), paramf.HZX, bu.aSM(paramf.Ghg), paramf.HZO, Integer.valueOf(paramf.HZP), paramf.HZQ, paramf.HZT, paramf.FNL, Integer.valueOf(paramf.Ghj), Integer.valueOf(paramf.ucK) });
      AppMethodBeat.o(217476);
      return paramf;
      i = 2;
      break;
      label981:
      paramf.Ghg = this.ifH.field_aesKey;
      paramf.Hdo = this.ifH.field_aesKey;
      break label373;
      label1006:
      if ((params == null) || (bu.isNullOrNil(params.hEX)) || (bu.isNullOrNil(params.hEW))) {
        break label572;
      }
      paramf.HZS = params.hEX;
      paramf.HZR = params.hEW;
      break label572;
      label1049:
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NetSceneUploadVideoForCdn", "cdntra getImageOptions for thumb failed path:%s", new Object[] { params });
      break label645;
      paramf.Ghj = 1;
      paramf.ucK = 2;
      break label722;
      paramf.Ghj = 1;
      paramf.ucK = 1;
      break label722;
      paramf.Ghj = 2;
      paramf.ucK = 3;
      break label722;
      paramf.Ghj = 3;
      paramf.ucK = 4;
      break label722;
      paramf.Ghj = 1;
      paramf.ucK = 5;
      break label722;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, duf paramduf, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(217478);
    if ((paramduf != null) && ((paramInt1 == 4) || ((paramInt1 == 0) && (paramInt2 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(paramduf.Ghl);
    }
    s locals = u.Ia(this.fileName);
    if (locals == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      this.ifI.dg(3, -1);
      AppMethodBeat.o(217478);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == 102))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideoForCdn", "summersafecdn ERR: MM_ERR_GET_AESKEY_FAILED errtype:" + paramInt1 + " errCode:" + paramInt2 + "  file:" + this.fileName + " user:" + locals.getUser());
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      this.ifI.dg(paramInt1, paramInt2);
      AppMethodBeat.o(217478);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -22))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd BLACK  errtype:" + paramInt1 + " errCode:" + paramInt2 + "  file:" + this.fileName + " user:" + locals.getUser());
      u.HS(this.fileName);
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      this.ifI.dg(paramInt1, paramInt2);
      AppMethodBeat.o(217478);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 != 0))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt1 + " errCode:" + paramInt2 + "  file:" + this.fileName + " user:" + locals.getUser());
      u.HR(this.fileName);
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      this.ifI.dg(paramInt1, paramInt2);
      AppMethodBeat.o(217478);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt1 + " errCode:" + paramInt2 + "  file:" + this.fileName + " user:" + locals.getUser());
      u.HR(this.fileName);
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      this.ifI.dg(paramInt1, paramInt2);
      AppMethodBeat.o(217478);
      return;
    }
    locals.iwX = bu.aRi();
    locals.dCd = paramduf.xrk;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideoForCdn", "%s dkmsgid  set svrmsgid %d -> %d", new Object[] { aMX(), Long.valueOf(locals.dCd), Integer.valueOf(ac.iRI) });
    if ((10007 == ac.iRH) && (ac.iRI != 0) && (locals.dCd != 0L))
    {
      locals.dCd = ac.iRI;
      ac.iRI = 0;
    }
    locals.status = 199;
    locals.dEu = 1284;
    Object localObject;
    int i;
    if (this.ifH.XY())
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], old RecvXml[%s]", new Object[] { aMX(), paramduf.Ghg, locals.aNt() });
      if (bu.isNullOrNil(paramduf.Ghg)) {
        break label1283;
      }
      localObject = "<msg><videomsg aeskey=\"" + paramduf.Ghg + "\" cdnthumbaeskey=\"" + paramduf.Ghg + "\" cdnvideourl=\"" + this.ifH.field_fileId + "\" ";
      localObject = (String)localObject + "cdnthumburl=\"" + this.ifH.field_fileId + "\" ";
      localObject = (String)localObject + "length=\"" + this.ifH.field_fileLength + "\" ";
      localObject = (String)localObject + "cdnthumblength=\"" + this.ifH.field_thumbimgLength + "\"/></msg>";
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideoForCdn", "cdn callback new build cdnInfo:%s", new Object[] { localObject });
      locals.ixe = ((String)localObject);
      localObject = o.aNh();
      o.aNh();
      boolean bool = ((t)localObject).q(t.HJ(this.fileName), this.ifH.field_fileId, paramduf.Ghg);
      localObject = com.tencent.mm.plugin.report.service.g.yxI;
      if (bool)
      {
        i = 1;
        ((com.tencent.mm.plugin.report.service.g)localObject).f(12696, new Object[] { Integer.valueOf(i + 900), Integer.valueOf(locals.hPI) });
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], new RecvXml[%s], saveret[%b]", new Object[] { aMX(), paramduf.Ghg, locals.aNt(), Boolean.valueOf(bool) });
      }
    }
    else
    {
      label1034:
      u.f(locals);
      u.d(locals);
      localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(locals.iwZ);
      ((bv)localObject).tk(paramduf.FNL);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(((ei)localObject).field_msgId, (bv)localObject);
      com.tencent.mm.modelstat.b.iqT.q((bv)localObject);
      if ((!Ht(locals.getUser())) && (!x.AA(locals.getUser()))) {
        break label1305;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideoForCdn", "%s upload to biz :%s", new Object[] { aMX(), locals.getUser() });
      if (locals.dCd < 0L)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + locals.dCd + " file:" + this.fileName + " toUser:" + locals.getUser());
        u.HR(this.fileName);
        this.ifI.dg(3, -1);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      this.ifI.dg(0, 0);
      AppMethodBeat.o(217478);
      return;
      i = 2;
      break;
      label1283:
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn need aeskey but ret null", new Object[] { aMX() });
      break label1034;
      label1305:
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideoForCdn", "%s not upload to biz", new Object[] { aMX() });
      if (locals.dCd <= 0L)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + locals.dCd + " file:" + this.fileName + " toUser:" + locals.getUser());
        u.HR(this.fileName);
        this.ifI.dg(3, -1);
      }
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(126872);
    s locals = u.Ia(this.fileName);
    if (locals == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneUploadVideoForCdn", "Get info Failed file:" + this.fileName);
      this.ifI.dg(3, -1);
      AppMethodBeat.o(126872);
      return -1;
    }
    a(locals, paramf);
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(126872);
    return i;
  }
  
  public final String getFileName()
  {
    return this.fileName;
  }
  
  public final int getType()
  {
    return 149;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126874);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadVideoForCdn", "%s cdntra onGYNetEnd errtype[%d %d]", new Object[] { aMX(), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    a(paramInt2, paramInt3, paramString, (duf)((com.tencent.mm.ak.b)paramq).hQE.hQJ, this);
    AppMethodBeat.o(126874);
  }
  
  public final int securityLimitCount()
  {
    return 1;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hRi;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(126873);
    u.HR(this.fileName);
    AppMethodBeat.o(126873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.h
 * JD-Core Version:    0.7.0.1
 */