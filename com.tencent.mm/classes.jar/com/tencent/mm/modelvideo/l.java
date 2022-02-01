package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.a;
import com.tencent.mm.an.q.b;
import com.tencent.mm.ay.f;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.z;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.protocal.protobuf.eyk;
import com.tencent.mm.protocal.protobuf.eyl;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import junit.framework.Assert;

public final class l
  extends q
  implements m
{
  private com.tencent.mm.an.i callback;
  String fileName;
  private int lQY;
  public com.tencent.mm.i.d lQZ;
  public f lRa;
  private com.tencent.mm.an.d rr;
  
  public l(String paramString, int paramInt, com.tencent.mm.i.d paramd, f paramf)
  {
    AppMethodBeat.i(215784);
    this.fileName = null;
    this.lQY = 0;
    this.lQZ = null;
    this.lRa = null;
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
      this.lQZ = paramd;
      this.lRa = paramf;
      this.lQY = paramInt;
      AppMethodBeat.o(215784);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label51;
    }
  }
  
  private static boolean XD(String paramString)
  {
    AppMethodBeat.i(215808);
    paramString = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramString);
    if ((paramString == null) || ((int)paramString.jxt <= 0))
    {
      AppMethodBeat.o(215808);
      return false;
    }
    boolean bool = paramString.hxX();
    AppMethodBeat.o(215808);
    return bool;
  }
  
  private String bqr()
  {
    AppMethodBeat.i(126875);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(126875);
    return str;
  }
  
  private String bqt()
  {
    AppMethodBeat.i(215794);
    Object localObject = y.Yk(this.fileName);
    String str = null;
    if (localObject != null)
    {
      if (Util.isNullOrNil(((w)localObject).mic)) {
        break label93;
      }
      str = ((w)localObject).mic;
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSceneUploadVideoForCdn", "createVideoMsgSource preLoadLength: %s, forward uuid %s", new Object[] { Integer.valueOf(this.lQY), str });
      if ((this.lQY > 0) && (this.lQY <= 1048576)) {
        break label165;
      }
      if (!Util.isNullOrNil(str)) {
        break;
      }
      str = bs.apc();
      AppMethodBeat.o(215794);
      return str;
      label93:
      if (((w)localObject).mib > 0)
      {
        str = bs.RU(((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(((w)localObject).mib).hxy);
      }
      else
      {
        str = u.buc(((w)localObject).bqN());
        localObject = com.tencent.mm.platformtools.v.mEG;
        str = com.tencent.mm.platformtools.v.ZU(str);
      }
    }
    str = bs.RV(str);
    AppMethodBeat.o(215794);
    return str;
    label165:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("<msgsource>");
    ((StringBuilder)localObject).append("<videopreloadlen>").append(this.lQY).append("</videopreloadlen>");
    if (!Util.isNullOrNil(str)) {
      ((StringBuilder)localObject).append("<sec_msg_node><uuid>").append(str).append("</uuid></sec_msg_node>");
    }
    ((StringBuilder)localObject).append("</msgsource>");
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 35L, 1L, false);
    str = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(215794);
    return str;
  }
  
  public final eyk a(w paramw, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(215792);
    this.callback = parami;
    parami = new d.a();
    parami.lBU = new eyk();
    parami.lBV = new eyl();
    parami.uri = "/cgi-bin/micromsg-bin/uploadvideo";
    parami.funcId = 149;
    parami.lBW = 39;
    parami.respCmdId = 1000000039;
    this.rr = parami.bgN();
    parami = (eyk)d.b.b(this.rr.lBR);
    parami.UyC = 0;
    parami.UyB = ((int)this.lQZ.field_fileLength);
    parami.UyD = new eae().dc(new byte[0]);
    parami.TDa = 0;
    parami.TCZ = this.lQZ.field_thumbimgLength;
    parami.TDb = new eae().dc(new byte[0]);
    parami.CRR = z.bcZ();
    parami.CRQ = this.lQZ.field_toUser;
    parami.RJQ = this.fileName;
    if (paramw.mhU == 1) {
      parami.RUc = 2;
    }
    if (paramw.mhX == 3) {
      parami.RUc = 3;
    }
    parami.UjJ = paramw.lvw;
    label373:
    Object localObject;
    label572:
    label722:
    String str;
    if (ag.dj(MMApplicationContext.getContext()))
    {
      i = 1;
      parami.SsZ = i;
      parami.TDc = 2;
      parami.Uys = this.lQZ.field_thumbimgLength;
      parami.UyE = this.lQZ.field_fileId;
      parami.Tsc = this.lQZ.field_fileId;
      parami.ScW = 1;
      if (!this.lQZ.arK()) {
        break label981;
      }
      Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", new Object[] { bqr(), Boolean.valueOf(this.lQZ.field_upload_by_safecdn), Integer.valueOf(this.lQZ.field_UploadHitCacheType), Integer.valueOf(this.lQZ.field_filecrc), this.lQZ.field_aesKey });
      parami.UhL = 1;
      parami.ScV = "";
      parami.Tse = "";
      parami.UyG = this.lQZ.field_filemd5;
      parami.UyQ = this.lQZ.field_mp4identifymd5;
      parami.ScX = this.lQZ.field_filecrc;
      parami.RII = bqt();
      parami.UyP = paramw.fUk;
      if (((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).ifAddTicketByActionFlag(this.lQZ.field_toUser)) {
        parami.ScZ = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bws(this.lQZ.field_toUser);
      }
      paramw = paramw.mhZ;
      if ((paramw == null) || (Util.isNullOrNil(paramw.lor))) {
        break label1006;
      }
      parami.UyH = Util.nullAs(paramw.lor, "");
      parami.UyI = paramw.SAk;
      parami.UyJ = Util.nullAs(paramw.lot, "");
      parami.UyL = Util.nullAs(paramw.lov, "");
      parami.UyK = Util.nullAs(paramw.lou, "");
      parami.UyM = Util.nullAs(paramw.low, "");
      if (paramw != null)
      {
        parami.UyO = Util.nullAs(paramw.lox, "");
        parami.UyN = Util.nullAs(paramw.loy, "");
      }
      s.bqB();
      paramw = x.XU(this.fileName);
      localObject = BitmapUtil.getImageOptions(paramw);
      if (localObject == null) {
        break label1049;
      }
      parami.Uyu = ((BitmapFactory.Options)localObject).outWidth;
      parami.Uyt = ((BitmapFactory.Options)localObject).outHeight;
      label645:
      s.bqB();
      paramw = x.XT(this.fileName);
      switch (r.bqz().XG(paramw))
      {
      case 4: 
      case 5: 
      default: 
        parami.ScY = 0;
        parami.Cqs = 0;
        paramw = bqr();
        localObject = this.fileName;
        str = this.lQZ.field_toUser;
        if (this.lQZ.field_aesKey != null) {
          break;
        }
      }
    }
    for (int i = -1;; i = this.lQZ.field_aesKey.length())
    {
      Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn cdntra doscene file:%s touser:%s aes:%d fileid:%s thumb:[%d %d %d], thumbaeskey [%s] funcFlag: %d, md5:%s HitMd5:%d CRC32:%d, VideoNewMd5:%s AESKey:%s stream %s streamtime: %d title %s thumburl %s msgSource[%s] msgForwardType[%d] Source[%d]", new Object[] { paramw, localObject, str, Integer.valueOf(i), this.lQZ.field_fileId, Integer.valueOf(this.lQZ.field_thumbimgLength), Integer.valueOf(parami.Uyu), Integer.valueOf(parami.Uyt), Util.secPrint(parami.Tse), Integer.valueOf(parami.RUc), parami.UyG, Integer.valueOf(parami.UhL), Integer.valueOf(parami.ScX), parami.UyQ, Util.secPrint(parami.ScV), parami.UyH, Integer.valueOf(parami.UyI), parami.UyJ, parami.UyM, parami.RII, Integer.valueOf(parami.ScY), Integer.valueOf(parami.Cqs) });
      AppMethodBeat.o(215792);
      return parami;
      i = 2;
      break;
      label981:
      parami.ScV = this.lQZ.field_aesKey;
      parami.Tse = this.lQZ.field_aesKey;
      break label373;
      label1006:
      if ((paramw == null) || (Util.isNullOrNil(paramw.lov)) || (Util.isNullOrNil(paramw.lou))) {
        break label572;
      }
      parami.UyL = paramw.lov;
      parami.UyK = paramw.lou;
      break label572;
      label1049:
      Log.w("MicroMsg.NetSceneUploadVideoForCdn", "cdntra getImageOptions for thumb failed path:%s", new Object[] { paramw });
      break label645;
      parami.ScY = 1;
      parami.Cqs = 2;
      break label722;
      parami.ScY = 1;
      parami.Cqs = 1;
      break label722;
      parami.ScY = 2;
      parami.Cqs = 3;
      break label722;
      parami.ScY = 3;
      parami.Cqs = 4;
      break label722;
      parami.ScY = 1;
      parami.Cqs = 5;
      break label722;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, eyl parameyl, q paramq)
  {
    AppMethodBeat.i(215805);
    if ((parameyl != null) && ((paramInt1 == 4) || ((paramInt1 == 0) && (paramInt2 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).setEnSendMsgActionFlag(parameyl.Sda);
    }
    w localw = y.Yk(this.fileName);
    if (localw == null)
    {
      Log.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
      this.lRa.dN(3, -1);
      AppMethodBeat.o(215805);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == 102))
    {
      Log.e("MicroMsg.NetSceneUploadVideoForCdn", "summersafecdn ERR: MM_ERR_GET_AESKEY_FAILED errtype:" + paramInt1 + " errCode:" + paramInt2 + "  file:" + this.fileName + " user:" + localw.bqM());
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
      this.lRa.dN(paramInt1, paramInt2);
      AppMethodBeat.o(215805);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -22))
    {
      Log.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd BLACK  errtype:" + paramInt1 + " errCode:" + paramInt2 + "  file:" + this.fileName + " user:" + localw.bqM());
      y.Yc(this.fileName);
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
      this.lRa.dN(paramInt1, paramInt2);
      AppMethodBeat.o(215805);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 != 0))
    {
      Log.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt1 + " errCode:" + paramInt2 + "  file:" + this.fileName + " user:" + localw.bqM());
      y.Yb(this.fileName);
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
      this.lRa.dN(paramInt1, paramInt2);
      AppMethodBeat.o(215805);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt1 + " errCode:" + paramInt2 + "  file:" + this.fileName + " user:" + localw.bqM());
      y.Yb(this.fileName);
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
      this.lRa.dN(paramInt1, paramInt2);
      AppMethodBeat.o(215805);
      return;
    }
    localw.mhP = Util.nowSecond();
    localw.fNu = parameyl.HlH;
    Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s dkmsgid  set svrmsgid %d -> %d", new Object[] { bqr(), Long.valueOf(localw.fNu), Integer.valueOf(ac.mFN) });
    if ((10007 == ac.mFM) && (ac.mFN != 0) && (localw.fNu != 0L))
    {
      localw.fNu = ac.mFN;
      ac.mFN = 0;
    }
    localw.status = 199;
    localw.cUP = 1284;
    Object localObject;
    int i;
    if (this.lQZ.arK())
    {
      Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], old RecvXml[%s]", new Object[] { bqr(), parameyl.ScV, localw.bqO() });
      if (Util.isNullOrNil(parameyl.ScV)) {
        break label1283;
      }
      localObject = "<msg><videomsg aeskey=\"" + parameyl.ScV + "\" cdnthumbaeskey=\"" + parameyl.ScV + "\" cdnvideourl=\"" + this.lQZ.field_fileId + "\" ";
      localObject = (String)localObject + "cdnthumburl=\"" + this.lQZ.field_fileId + "\" ";
      localObject = (String)localObject + "length=\"" + this.lQZ.field_fileLength + "\" ";
      localObject = (String)localObject + "cdnthumblength=\"" + this.lQZ.field_thumbimgLength + "\"/></msg>";
      Log.i("MicroMsg.NetSceneUploadVideoForCdn", "cdn callback new build cdnInfo:%s", new Object[] { localObject });
      localw.mhW = ((String)localObject);
      localObject = s.bqB();
      s.bqB();
      boolean bool = ((x)localObject).t(x.XT(this.fileName), this.lQZ.field_fileId, parameyl.ScV);
      localObject = com.tencent.mm.plugin.report.service.h.IzE;
      if (bool)
      {
        i = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject).a(12696, new Object[] { Integer.valueOf(i + 900), Integer.valueOf(localw.lAW) });
        Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], new RecvXml[%s], saveret[%b]", new Object[] { bqr(), parameyl.ScV, localw.bqO(), Boolean.valueOf(bool) });
      }
    }
    else
    {
      label1034:
      y.f(localw);
      y.d(localw);
      localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(localw.mhR);
      ((ca)localObject).Ip(parameyl.RII);
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(((et)localObject).field_msgId, (ca)localObject);
      b.mcf.u((ca)localObject);
      if ((!XD(localw.bqM())) && (!ab.Qy(localw.bqM()))) {
        break label1305;
      }
      Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s upload to biz :%s", new Object[] { bqr(), localw.bqM() });
      if (localw.fNu < 0L)
      {
        Log.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + localw.fNu + " file:" + this.fileName + " toUser:" + localw.bqM());
        y.Yb(this.fileName);
        this.lRa.dN(3, -1);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
      this.lRa.dN(0, 0);
      AppMethodBeat.o(215805);
      return;
      i = 2;
      break;
      label1283:
      Log.w("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn need aeskey but ret null", new Object[] { bqr() });
      break label1034;
      label1305:
      Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s not upload to biz", new Object[] { bqr() });
      if (localw.fNu <= 0L)
      {
        Log.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + localw.fNu + " file:" + this.fileName + " toUser:" + localw.bqM());
        y.Yb(this.fileName);
        this.lRa.dN(3, -1);
      }
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(126872);
    w localw = y.Yk(this.fileName);
    if (localw == null)
    {
      Log.e("MicroMsg.NetSceneUploadVideoForCdn", "Get info Failed file:" + this.fileName);
      this.lRa.dN(3, -1);
      AppMethodBeat.o(126872);
      return -1;
    }
    a(localw, parami);
    int i = dispatch(paramg, this.rr, this);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126874);
    Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s cdntra onGYNetEnd errtype[%d %d]", new Object[] { bqr(), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    a(paramInt2, paramInt3, paramString, (eyl)d.c.b(((com.tencent.mm.an.d)params).lBS), this);
    AppMethodBeat.o(126874);
  }
  
  public final int securityLimitCount()
  {
    return 1;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return q.b.lCx;
  }
  
  public final void setSecurityCheckError(q.a parama)
  {
    AppMethodBeat.i(126873);
    y.Yb(this.fileName);
    AppMethodBeat.o(126873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.l
 * JD-Core Version:    0.7.0.1
 */