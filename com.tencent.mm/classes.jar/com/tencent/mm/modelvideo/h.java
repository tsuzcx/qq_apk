package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.d;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.w;
import com.tencent.mm.network.ae;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.protocal.protobuf.dth;
import com.tencent.mm.protocal.protobuf.dti;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import junit.framework.Assert;

public final class h
  extends com.tencent.mm.al.n
  implements k
{
  private com.tencent.mm.al.f callback;
  String fileName;
  private int icN;
  public d icO;
  public com.tencent.mm.aw.f icP;
  private com.tencent.mm.al.b rr;
  
  public h(String paramString, int paramInt, d paramd, com.tencent.mm.aw.f paramf)
  {
    AppMethodBeat.i(218858);
    this.fileName = null;
    this.icN = 0;
    this.icO = null;
    this.icP = null;
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
      this.icO = paramd;
      this.icP = paramf;
      this.icN = paramInt;
      AppMethodBeat.o(218858);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label51;
    }
  }
  
  private static boolean GR(String paramString)
  {
    AppMethodBeat.i(218862);
    paramString = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramString);
    if ((paramString == null) || ((int)paramString.gfj <= 0))
    {
      AppMethodBeat.o(218862);
      return false;
    }
    boolean bool = paramString.fqg();
    AppMethodBeat.o(218862);
    return bool;
  }
  
  private String aMB()
  {
    AppMethodBeat.i(218860);
    Object localObject = u.Hy(this.fileName);
    String str = null;
    if (localObject != null)
    {
      if (bt.isNullOrNil(((s)localObject).iuq)) {
        break label93;
      }
      str = ((s)localObject).iuq;
    }
    for (;;)
    {
      ad.i("MicroMsg.NetSceneUploadVideoForCdn", "createVideoMsgSource preLoadLength: %s, forward uuid %s", new Object[] { Integer.valueOf(this.icN), str });
      if ((this.icN > 0) && (this.icN <= 1048576)) {
        break label165;
      }
      if (!bt.isNullOrNil(str)) {
        break;
      }
      str = bl.VW();
      AppMethodBeat.o(218860);
      return str;
      label93:
      if (((s)localObject).iup > 0)
      {
        str = bl.Bt(((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(((s)localObject).iup).eLs);
      }
      else
      {
        str = com.tencent.mm.vfs.i.aPK(((s)localObject).aMU());
        localObject = v.iNJ;
        str = v.IV(str);
      }
    }
    str = bl.Bu(str);
    AppMethodBeat.o(218860);
    return str;
    label165:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("<msgsource>");
    ((StringBuilder)localObject).append("<videopreloadlen>").append(this.icN).append("</videopreloadlen>");
    if (!bt.isNullOrNil(str)) {
      ((StringBuilder)localObject).append("<sec_msg_node><uuid>").append(str).append("</uuid></sec_msg_node>");
    }
    ((StringBuilder)localObject).append("</msgsource>");
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 35L, 1L, false);
    str = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(218860);
    return str;
  }
  
  private String aMz()
  {
    AppMethodBeat.i(126875);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(126875);
    return str;
  }
  
  public final dth a(s params, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(218859);
    this.callback = paramf;
    paramf = new b.a();
    paramf.hNM = new dth();
    paramf.hNN = new dti();
    paramf.uri = "/cgi-bin/micromsg-bin/uploadvideo";
    paramf.funcId = 149;
    paramf.hNO = 39;
    paramf.respCmdId = 1000000039;
    this.rr = paramf.aDC();
    paramf = (dth)this.rr.hNK.hNQ;
    paramf.HFW = 0;
    paramf.HFV = ((int)this.icO.field_fileLength);
    paramf.HFX = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    paramf.GSg = 0;
    paramf.GSf = this.icO.field_thumbimgLength;
    paramf.GSh = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    paramf.ukj = com.tencent.mm.model.u.aAm();
    paramf.uki = this.icO.field_toUser;
    paramf.Fwt = this.fileName;
    if (params.iui == 1) {
      paramf.FGO = 2;
    }
    if (params.iul == 3) {
      paramf.FGO = 3;
    }
    paramf.Hsd = params.hHQ;
    label373:
    Object localObject;
    label572:
    label722:
    String str;
    if (ae.cP(aj.getContext()))
    {
      i = 1;
      paramf.Gdp = i;
      paramf.GSi = 2;
      paramf.HFN = this.icO.field_thumbimgLength;
      paramf.HFY = this.icO.field_fileId;
      paramf.GJL = this.icO.field_fileId;
      paramf.FOI = 1;
      if (!this.icO.XO()) {
        break label981;
      }
      ad.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", new Object[] { aMz(), Boolean.valueOf(this.icO.field_upload_by_safecdn), Integer.valueOf(this.icO.field_UploadHitCacheType), Integer.valueOf(this.icO.field_filecrc), this.icO.field_aesKey });
      paramf.Hqi = 1;
      paramf.FOH = "";
      paramf.GJN = "";
      paramf.HGa = this.icO.field_filemd5;
      paramf.HGk = this.icO.field_mp4identifymd5;
      paramf.FOJ = this.icO.field_filecrc;
      paramf.Fvn = aMB();
      paramf.HGj = params.dHv;
      if (((r)com.tencent.mm.kernel.g.ad(r.class)).ifAddTicketByActionFlag(this.icO.field_toUser)) {
        paramf.FOL = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTu(this.icO.field_toUser);
      }
      params = params.iun;
      if ((params == null) || (bt.isNullOrNil(params.hCe))) {
        break label1006;
      }
      paramf.HGb = bt.bI(params.hCe, "");
      paramf.HGc = params.Gje;
      paramf.HGd = bt.bI(params.hCg, "");
      paramf.HGf = bt.bI(params.hCi, "");
      paramf.HGe = bt.bI(params.hCh, "");
      paramf.HGg = bt.bI(params.hCj, "");
      if (params != null)
      {
        paramf.HGi = bt.bI(params.hCk, "");
        paramf.HGh = bt.bI(params.hCl, "");
      }
      o.aMJ();
      params = t.Hi(this.fileName);
      localObject = com.tencent.mm.sdk.platformtools.g.aQc(params);
      if (localObject == null) {
        break label1049;
      }
      paramf.HFP = ((BitmapFactory.Options)localObject).outWidth;
      paramf.HFO = ((BitmapFactory.Options)localObject).outHeight;
      label645:
      o.aMJ();
      params = t.Hh(this.fileName);
      switch (n.aMH().GU(params))
      {
      case 4: 
      case 5: 
      default: 
        paramf.FOK = 0;
        paramf.tRT = 0;
        params = aMz();
        localObject = this.fileName;
        str = this.icO.field_toUser;
        if (this.icO.field_aesKey != null) {
          break;
        }
      }
    }
    for (int i = -1;; i = this.icO.field_aesKey.length())
    {
      ad.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn cdntra doscene file:%s touser:%s aes:%d fileid:%s thumb:[%d %d %d], thumbaeskey [%s] funcFlag: %d, md5:%s HitMd5:%d CRC32:%d, VideoNewMd5:%s AESKey:%s stream %s streamtime: %d title %s thumburl %s msgSource[%s] msgForwardType[%d] Source[%d]", new Object[] { params, localObject, str, Integer.valueOf(i), this.icO.field_fileId, Integer.valueOf(this.icO.field_thumbimgLength), Integer.valueOf(paramf.HFP), Integer.valueOf(paramf.HFO), bt.aRp(paramf.GJN), Integer.valueOf(paramf.FGO), paramf.HGa, Integer.valueOf(paramf.Hqi), Integer.valueOf(paramf.FOJ), paramf.HGk, bt.aRp(paramf.FOH), paramf.HGb, Integer.valueOf(paramf.HGc), paramf.HGd, paramf.HGg, paramf.Fvn, Integer.valueOf(paramf.FOK), Integer.valueOf(paramf.tRT) });
      AppMethodBeat.o(218859);
      return paramf;
      i = 2;
      break;
      label981:
      paramf.FOH = this.icO.field_aesKey;
      paramf.GJN = this.icO.field_aesKey;
      break label373;
      label1006:
      if ((params == null) || (bt.isNullOrNil(params.hCi)) || (bt.isNullOrNil(params.hCh))) {
        break label572;
      }
      paramf.HGf = params.hCi;
      paramf.HGe = params.hCh;
      break label572;
      label1049:
      ad.w("MicroMsg.NetSceneUploadVideoForCdn", "cdntra getImageOptions for thumb failed path:%s", new Object[] { params });
      break label645;
      paramf.FOK = 1;
      paramf.tRT = 2;
      break label722;
      paramf.FOK = 1;
      paramf.tRT = 1;
      break label722;
      paramf.FOK = 2;
      paramf.tRT = 3;
      break label722;
      paramf.FOK = 3;
      paramf.tRT = 4;
      break label722;
      paramf.FOK = 1;
      paramf.tRT = 5;
      break label722;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, dti paramdti, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(218861);
    if ((paramdti != null) && ((paramInt1 == 4) || ((paramInt1 == 0) && (paramInt2 == 0)))) {
      ((r)com.tencent.mm.kernel.g.ad(r.class)).setEnSendMsgActionFlag(paramdti.FOM);
    }
    s locals = u.Hy(this.fileName);
    if (locals == null)
    {
      ad.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      this.icP.dg(3, -1);
      AppMethodBeat.o(218861);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == 102))
    {
      ad.e("MicroMsg.NetSceneUploadVideoForCdn", "summersafecdn ERR: MM_ERR_GET_AESKEY_FAILED errtype:" + paramInt1 + " errCode:" + paramInt2 + "  file:" + this.fileName + " user:" + locals.getUser());
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      this.icP.dg(paramInt1, paramInt2);
      AppMethodBeat.o(218861);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -22))
    {
      ad.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd BLACK  errtype:" + paramInt1 + " errCode:" + paramInt2 + "  file:" + this.fileName + " user:" + locals.getUser());
      u.Hq(this.fileName);
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      this.icP.dg(paramInt1, paramInt2);
      AppMethodBeat.o(218861);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 != 0))
    {
      ad.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt1 + " errCode:" + paramInt2 + "  file:" + this.fileName + " user:" + locals.getUser());
      u.Hp(this.fileName);
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      this.icP.dg(paramInt1, paramInt2);
      AppMethodBeat.o(218861);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt1 + " errCode:" + paramInt2 + "  file:" + this.fileName + " user:" + locals.getUser());
      u.Hp(this.fileName);
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      this.icP.dg(paramInt1, paramInt2);
      AppMethodBeat.o(218861);
      return;
    }
    locals.iud = bt.aQJ();
    locals.dAY = paramdti.xbt;
    ad.i("MicroMsg.NetSceneUploadVideoForCdn", "%s dkmsgid  set svrmsgid %d -> %d", new Object[] { aMz(), Long.valueOf(locals.dAY), Integer.valueOf(ac.iOO) });
    if ((10007 == ac.iON) && (ac.iOO != 0) && (locals.dAY != 0L))
    {
      locals.dAY = ac.iOO;
      ac.iOO = 0;
    }
    locals.status = 199;
    locals.dDp = 1284;
    Object localObject;
    int i;
    if (this.icO.XO())
    {
      ad.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], old RecvXml[%s]", new Object[] { aMz(), paramdti.FOH, locals.aMV() });
      if (bt.isNullOrNil(paramdti.FOH)) {
        break label1283;
      }
      localObject = "<msg><videomsg aeskey=\"" + paramdti.FOH + "\" cdnthumbaeskey=\"" + paramdti.FOH + "\" cdnvideourl=\"" + this.icO.field_fileId + "\" ";
      localObject = (String)localObject + "cdnthumburl=\"" + this.icO.field_fileId + "\" ";
      localObject = (String)localObject + "length=\"" + this.icO.field_fileLength + "\" ";
      localObject = (String)localObject + "cdnthumblength=\"" + this.icO.field_thumbimgLength + "\"/></msg>";
      ad.i("MicroMsg.NetSceneUploadVideoForCdn", "cdn callback new build cdnInfo:%s", new Object[] { localObject });
      locals.iuk = ((String)localObject);
      localObject = o.aMJ();
      o.aMJ();
      boolean bool = ((t)localObject).q(t.Hh(this.fileName), this.icO.field_fileId, paramdti.FOH);
      localObject = com.tencent.mm.plugin.report.service.g.yhR;
      if (bool)
      {
        i = 1;
        ((com.tencent.mm.plugin.report.service.g)localObject).f(12696, new Object[] { Integer.valueOf(i + 900), Integer.valueOf(locals.hMP) });
        ad.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], new RecvXml[%s], saveret[%b]", new Object[] { aMz(), paramdti.FOH, locals.aMV(), Boolean.valueOf(bool) });
      }
    }
    else
    {
      label1034:
      u.f(locals);
      u.d(locals);
      localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(locals.iuf);
      ((bu)localObject).sP(paramdti.Fvn);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(((ei)localObject).field_msgId, (bu)localObject);
      com.tencent.mm.modelstat.b.inZ.q((bu)localObject);
      if ((!GR(locals.getUser())) && (!w.zQ(locals.getUser()))) {
        break label1305;
      }
      ad.i("MicroMsg.NetSceneUploadVideoForCdn", "%s upload to biz :%s", new Object[] { aMz(), locals.getUser() });
      if (locals.dAY < 0L)
      {
        ad.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + locals.dAY + " file:" + this.fileName + " toUser:" + locals.getUser());
        u.Hp(this.fileName);
        this.icP.dg(3, -1);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      this.icP.dg(0, 0);
      AppMethodBeat.o(218861);
      return;
      i = 2;
      break;
      label1283:
      ad.w("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn need aeskey but ret null", new Object[] { aMz() });
      break label1034;
      label1305:
      ad.i("MicroMsg.NetSceneUploadVideoForCdn", "%s not upload to biz", new Object[] { aMz() });
      if (locals.dAY <= 0L)
      {
        ad.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + locals.dAY + " file:" + this.fileName + " toUser:" + locals.getUser());
        u.Hp(this.fileName);
        this.icP.dg(3, -1);
      }
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(126872);
    s locals = u.Hy(this.fileName);
    if (locals == null)
    {
      ad.e("MicroMsg.NetSceneUploadVideoForCdn", "Get info Failed file:" + this.fileName);
      this.icP.dg(3, -1);
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
    ad.i("MicroMsg.NetSceneUploadVideoForCdn", "%s cdntra onGYNetEnd errtype[%d %d]", new Object[] { aMz(), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    a(paramInt2, paramInt3, paramString, (dti)((com.tencent.mm.al.b)paramq).hNL.hNQ, this);
    AppMethodBeat.o(126874);
  }
  
  public final int securityLimitCount()
  {
    return 1;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hOp;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(126873);
    u.Hp(this.fileName);
    AppMethodBeat.o(126873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.h
 * JD-Core Version:    0.7.0.1
 */