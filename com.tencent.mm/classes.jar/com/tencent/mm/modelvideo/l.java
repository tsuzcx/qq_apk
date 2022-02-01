package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelimage.a;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.network.ah;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.fjp;
import com.tencent.mm.protocal.protobuf.fud;
import com.tencent.mm.protocal.protobuf.fue;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import junit.framework.Assert;

public final class l
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  public String fileName;
  private int oJI;
  public com.tencent.mm.g.d oJJ;
  public com.tencent.mm.modelimage.g oJK;
  public com.tencent.mm.g.d oJL;
  private String oJM;
  private c rr;
  
  public l(String paramString, int paramInt, com.tencent.mm.g.d paramd, com.tencent.mm.modelimage.g paramg)
  {
    AppMethodBeat.i(241275);
    this.fileName = null;
    this.oJI = 0;
    this.oJJ = null;
    this.oJL = null;
    this.oJK = null;
    if (paramString != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (paramd == null) {
        break label108;
      }
      bool1 = true;
      label56:
      Assert.assertTrue(bool1);
      if (paramg == null) {
        break label114;
      }
    }
    label108:
    label114:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      this.fileName = paramString;
      this.oJJ = paramd;
      this.oJK = paramg;
      this.oJI = paramInt;
      AppMethodBeat.o(241275);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label56;
    }
  }
  
  public l(String paramString1, String paramString2, int paramInt, com.tencent.mm.g.d paramd1, com.tencent.mm.g.d paramd2, com.tencent.mm.modelimage.g paramg)
  {
    AppMethodBeat.i(241288);
    this.fileName = null;
    this.oJI = 0;
    this.oJJ = null;
    this.oJL = null;
    this.oJK = null;
    if (paramString1 != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (paramd1 == null) {
        break label134;
      }
      bool1 = true;
      label57:
      Assert.assertTrue(bool1);
      if (paramg == null) {
        break label140;
      }
      bool1 = true;
      label70:
      Assert.assertTrue(bool1);
      if (paramd2 == null) {
        break label146;
      }
    }
    label134:
    label140:
    label146:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      this.fileName = paramString1;
      this.oJJ = paramd1;
      this.oJK = paramg;
      this.oJI = paramInt;
      this.oJL = paramd2;
      this.oJM = paramString2;
      AppMethodBeat.o(241288);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label57;
      bool1 = false;
      break label70;
    }
  }
  
  public l(String paramString1, String paramString2, int paramInt, com.tencent.mm.g.d paramd, com.tencent.mm.modelimage.g paramg)
  {
    AppMethodBeat.i(241281);
    this.fileName = null;
    this.oJI = 0;
    this.oJJ = null;
    this.oJL = null;
    this.oJK = null;
    if (paramString1 != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (paramd == null) {
        break label115;
      }
      bool1 = true;
      label57:
      Assert.assertTrue(bool1);
      if (paramg == null) {
        break label121;
      }
    }
    label115:
    label121:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      this.fileName = paramString1;
      this.oJJ = paramd;
      this.oJK = paramg;
      this.oJI = paramInt;
      this.oJM = paramString2;
      AppMethodBeat.o(241281);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label57;
    }
  }
  
  private static boolean PF(String paramString)
  {
    AppMethodBeat.i(241294);
    paramString = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString);
    if ((paramString == null) || ((int)paramString.maN <= 0))
    {
      AppMethodBeat.o(241294);
      return false;
    }
    boolean bool = paramString.iZC();
    AppMethodBeat.o(241294);
    return bool;
  }
  
  private String bNX()
  {
    AppMethodBeat.i(126875);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(126875);
    return str;
  }
  
  private String bNZ()
  {
    AppMethodBeat.i(241292);
    Object localObject1 = ab.Qo(this.fileName);
    if (localObject1 != null) {
      if (!Util.isNullOrNil(((z)localObject1).pbn)) {
        localObject1 = ((z)localObject1).pbn;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSceneUploadVideoForCdn", "createVideoMsgSource preLoadLength: %s, forward uuid %s", new Object[] { Integer.valueOf(this.oJI), localObject1 });
      Object localObject2;
      if ((this.oJI <= 0) || (this.oJI > 1048576))
      {
        if (Util.isNullOrNil((String)localObject1))
        {
          localObject1 = bt.bCQ();
          AppMethodBeat.o(241292);
          return localObject1;
          if (((z)localObject1).pbm > 0)
          {
            localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(((z)localObject1).pbm);
            if (localObject1 != null) {
              localObject1 = bt.JV(((fi)localObject1).jUr);
            }
          }
          else
          {
            localObject1 = y.bub(((z)localObject1).bOt());
            localObject2 = com.tencent.mm.platformtools.s.pBi;
            localObject1 = com.tencent.mm.platformtools.s.Si((String)localObject1);
          }
        }
        else
        {
          localObject1 = bt.JW((String)localObject1);
          AppMethodBeat.o(241292);
          return localObject1;
        }
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("<msgsource>");
        ((StringBuilder)localObject2).append("<videopreloadlen>").append(this.oJI).append("</videopreloadlen>");
        if (!Util.isNullOrNil((String)localObject1)) {
          ((StringBuilder)localObject2).append("<sec_msg_node><uuid>").append((String)localObject1).append("</uuid></sec_msg_node>");
        }
        ((StringBuilder)localObject2).append("</msgsource>");
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 35L, 1L, false);
        localObject1 = ((StringBuilder)localObject2).toString();
        AppMethodBeat.o(241292);
        return localObject1;
      }
      localObject1 = null;
    }
  }
  
  public final fud a(z paramz, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(241312);
    this.callback = paramh;
    paramh = new c.a();
    paramh.otE = new fud();
    paramh.otF = new fue();
    paramh.uri = "/cgi-bin/micromsg-bin/uploadvideo";
    paramh.funcId = 149;
    paramh.otG = 39;
    paramh.respCmdId = 1000000039;
    this.rr = paramh.bEF();
    fud localfud = (fud)c.b.b(this.rr.otB);
    localfud.abSg = 0;
    localfud.abSf = ((int)this.oJJ.field_fileLength);
    localfud.abSh = new gol().df(new byte[0]);
    localfud.aaSI = 0;
    localfud.aaSH = this.oJJ.field_thumbimgLength;
    localfud.aaSJ = new gol().df(new byte[0]);
    localfud.IMh = com.tencent.mm.model.z.bAM();
    localfud.IMg = this.oJJ.field_toUser;
    localfud.YHk = this.fileName;
    if (paramz.pbf == 1) {
      localfud.YRD = 2;
    }
    if (paramz.pbi == 3) {
      localfud.YRD = 3;
    }
    localfud.abzG = paramz.omT;
    label392:
    label502:
    String str;
    if (ah.eb(MMApplicationContext.getContext()))
    {
      i = 1;
      localfud.Zsm = i;
      localfud.aaSK = 2;
      localfud.abzD = this.oJJ.field_thumbimgLength;
      localfud.abSi = this.oJJ.field_fileId;
      localfud.aaGn = this.oJJ.field_fileId;
      localfud.ZaO = 1;
      if (!this.oJJ.aLG()) {
        break label1247;
      }
      Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", new Object[] { bNX(), Boolean.valueOf(this.oJJ.field_upload_by_safecdn), Integer.valueOf(this.oJJ.field_UploadHitCacheType), Integer.valueOf(this.oJJ.field_filecrc), this.oJJ.field_aesKey });
      localfud.abzb = 1;
      localfud.ZaN = "";
      localfud.aaGp = "";
      localfud.abzH = this.oJJ.field_filemd5;
      localfud.abzI = this.oJJ.field_mp4identifymd5;
      localfud.ZaP = this.oJJ.field_filecrc;
      localfud.YFJ = bNZ();
      localfud.abSs = paramz.iah;
      if (this.oJM != null)
      {
        localfud.abSt = paramz.hTh;
        localfud.abzN = this.oJM;
      }
      if (this.oJL != null)
      {
        if (!this.oJL.aLG()) {
          break label1274;
        }
        localfud.abSx = 1;
        localfud.abSw = "";
        localfud.abSu = this.oJL.field_filemd5;
        localfud.abSv = this.oJL.field_fileId;
        localfud.abzL = ((int)this.oJL.field_fileLength);
      }
      paramh = "";
      if (Util.isNullOrNil(paramz.bOu())) {
        break label1289;
      }
      paramh = paramz.bOu();
      label558:
      if (!Util.isNullOrNil(paramh))
      {
        if (Util.isNullOrNil(paramz.bOu()))
        {
          Log.i("MicroMsg.NetSceneUploadVideoForCdn", "uploadVideo video.recvXml is empty and update: %s", new Object[] { paramh });
          paramz.pbh = paramh;
          ab.f(paramz);
        }
        paramh = a.NM(paramh);
        if ((paramh != null) && (!Util.isNullOrNil(paramh.appId)))
        {
          localfud.oOI = paramh.appId;
          localfud.YCm = paramh.mediaTagName;
          localfud.YCn = paramh.messageExt;
          localfud.YCo = paramh.messageAction;
        }
      }
      if (((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).ifAddTicketByActionFlag(this.oJJ.field_toUser)) {
        localfud.ZaR = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxH(this.oJJ.field_toUser);
      }
      paramz = paramz.pbk;
      if ((paramz == null) || (Util.isNullOrNil(paramz.nTu))) {
        break label1310;
      }
      localfud.abSk = Util.nullAs(paramz.nTu, "");
      localfud.abSl = paramz.ZBc;
      localfud.abSm = Util.nullAs(paramz.nTw, "");
      localfud.abSo = Util.nullAs(paramz.nTy, "");
      localfud.abSn = Util.nullAs(paramz.nTx, "");
      localfud.abSp = Util.nullAs(paramz.nTz, "");
      label813:
      if (paramz != null)
      {
        localfud.abSr = Util.nullAs(paramz.nTA, "");
        localfud.abSq = Util.nullAs(paramz.nTB, "");
      }
      v.bOh();
      paramz = aa.PY(this.fileName);
      paramh = BitmapUtil.getImageOptions(paramz);
      if (paramh == null) {
        break label1355;
      }
      localfud.abzF = paramh.outWidth;
      localfud.abzE = paramh.outHeight;
      label886:
      v.bOh();
      paramz = aa.PX(this.fileName);
      switch (u.bOf().PI(paramz))
      {
      case 4: 
      case 5: 
      default: 
        localfud.ZaQ = 0;
        localfud.IcB = 0;
        label964:
        paramz = bNX();
        paramh = this.fileName;
        str = this.oJJ.field_toUser;
        if (this.oJJ.field_aesKey != null) {
          break;
        }
      }
    }
    for (int i = -1;; i = this.oJJ.field_aesKey.length())
    {
      Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn cdntra doscene file:%s touser:%s aes:%d fileid:%s thumb:[%d %d %d], thumbaeskey [%s] funcFlag: %d, md5:%s HitMd5:%d CRC32:%d, VideoNewMd5:%s AESKey:%s stream %s streamtime: %d title %s thumburl %s msgSource[%s] msgForwardType[%d] Source[%d], appId[%s]", new Object[] { paramz, paramh, str, Integer.valueOf(i), this.oJJ.field_fileId, Integer.valueOf(this.oJJ.field_thumbimgLength), Integer.valueOf(localfud.abzF), Integer.valueOf(localfud.abzE), Util.secPrint(localfud.aaGp), Integer.valueOf(localfud.YRD), localfud.abzH, Integer.valueOf(localfud.abzb), Integer.valueOf(localfud.ZaP), localfud.abzI, Util.secPrint(localfud.ZaN), localfud.abSk, Integer.valueOf(localfud.abSl), localfud.abSm, localfud.abSp, localfud.YFJ, Integer.valueOf(localfud.ZaQ), Integer.valueOf(localfud.IcB), localfud.oOI });
      AppMethodBeat.o(241312);
      return localfud;
      i = 2;
      break;
      label1247:
      localfud.ZaN = this.oJJ.field_aesKey;
      localfud.aaGp = this.oJJ.field_aesKey;
      break label392;
      label1274:
      localfud.abSw = this.oJL.field_aesKey;
      break label502;
      label1289:
      if (Util.isNullOrNil(paramz.pbo)) {
        break label558;
      }
      paramh = a.NL(paramz.pbo);
      break label558;
      label1310:
      if ((paramz == null) || (Util.isNullOrNil(paramz.nTy)) || (Util.isNullOrNil(paramz.nTx))) {
        break label813;
      }
      localfud.abSo = paramz.nTy;
      localfud.abSn = paramz.nTx;
      break label813;
      label1355:
      Log.w("MicroMsg.NetSceneUploadVideoForCdn", "cdntra getImageOptions for thumb failed path:%s", new Object[] { paramz });
      break label886;
      localfud.ZaQ = 1;
      localfud.IcB = 2;
      break label964;
      localfud.ZaQ = 1;
      localfud.IcB = 1;
      break label964;
      localfud.ZaQ = 2;
      localfud.IcB = 3;
      break label964;
      localfud.ZaQ = 3;
      localfud.IcB = 4;
      break label964;
      localfud.ZaQ = 1;
      localfud.IcB = 5;
      break label964;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, fue paramfue, p paramp)
  {
    AppMethodBeat.i(241371);
    if ((paramfue != null) && ((paramInt1 == 4) || ((paramInt1 == 0) && (paramInt2 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).setEnSendMsgActionFlag(paramfue.ZaS);
    }
    z localz = ab.Qo(this.fileName);
    if (localz == null)
    {
      Log.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      paramfue = com.tencent.mm.cb.d.acls;
      com.tencent.mm.cb.d.a(null, this.fileName, 5, 0L, 0L, 0L, 0L, false, paramInt2);
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
      this.oJK.eF(3, -1);
      AppMethodBeat.o(241371);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == 102))
    {
      Log.e("MicroMsg.NetSceneUploadVideoForCdn", "summersafecdn ERR: MM_ERR_GET_AESKEY_FAILED errtype:" + paramInt1 + " errCode:" + paramInt2 + "  file:" + this.fileName + " user:" + localz.bOs());
      paramfue = com.tencent.mm.cb.d.acls;
      com.tencent.mm.cb.d.a(null, this.fileName, 10, 0L, 0L, 0L, 0L, false, paramInt2);
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
      this.oJK.eF(paramInt1, paramInt2);
      AppMethodBeat.o(241371);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -22))
    {
      Log.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd BLACK  errtype:" + paramInt1 + " errCode:" + paramInt2 + "  file:" + this.fileName + " user:" + localz.bOs());
      ab.Qg(this.fileName);
      paramfue = com.tencent.mm.cb.d.acls;
      com.tencent.mm.cb.d.a(null, this.fileName, 10, 0L, 0L, 0L, 0L, false, paramInt2);
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
      this.oJK.eF(paramInt1, paramInt2);
      AppMethodBeat.o(241371);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 != 0))
    {
      Log.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt1 + " errCode:" + paramInt2 + "  file:" + this.fileName + " user:" + localz.bOs());
      ab.Qf(this.fileName);
      paramfue = com.tencent.mm.cb.d.acls;
      com.tencent.mm.cb.d.a(null, this.fileName, 10, 0L, 0L, 0L, 0L, false, paramInt2);
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
      this.oJK.eF(paramInt1, paramInt2);
      AppMethodBeat.o(241371);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt1 + " errCode:" + paramInt2 + "  file:" + this.fileName + " user:" + localz.bOs());
      ab.Qf(this.fileName);
      paramfue = com.tencent.mm.cb.d.acls;
      com.tencent.mm.cb.d.a(null, this.fileName, 10, 0L, 0L, 0L, 0L, false, paramInt2);
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
      this.oJK.eF(paramInt1, paramInt2);
      AppMethodBeat.o(241371);
      return;
    }
    localz.pba = Util.nowSecond();
    localz.hTh = paramfue.Njv;
    Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s dkmsgid  set svrmsgid %d -> %d", new Object[] { bNX(), Long.valueOf(localz.hTh), Integer.valueOf(com.tencent.mm.platformtools.z.pCn) });
    if ((10007 == com.tencent.mm.platformtools.z.pCm) && (com.tencent.mm.platformtools.z.pCn != 0) && (localz.hTh != 0L))
    {
      localz.hTh = com.tencent.mm.platformtools.z.pCn;
      com.tencent.mm.platformtools.z.pCn = 0;
    }
    localz.status = 199;
    localz.eQp = 1284;
    Object localObject;
    int i;
    if (this.oJJ.aLG())
    {
      Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], old RecvXml[%s]", new Object[] { bNX(), paramfue.ZaN, localz.bOu() });
      if (Util.isNullOrNil(paramfue.ZaN)) {
        break label1553;
      }
      localObject = "<msg><videomsg aeskey=\"" + paramfue.ZaN + "\" cdnthumbaeskey=\"" + paramfue.ZaN + "\" cdnvideourl=\"" + this.oJJ.field_fileId + "\" ";
      localObject = (String)localObject + "cdnthumburl=\"" + this.oJJ.field_fileId + "\" ";
      localObject = (String)localObject + "length=\"" + this.oJJ.field_fileLength + "\" ";
      localObject = (String)localObject + "cdnthumblength=\"" + this.oJJ.field_thumbimgLength + "\"/>";
      localObject = (String)localObject + Util.nullAs(localz.pbo, "");
      localObject = (String)localObject + "</msg>";
      Log.i("MicroMsg.NetSceneUploadVideoForCdn", "cdn callback new build cdnInfo:%s", new Object[] { localObject });
      localz.pbh = ((String)localObject);
      localObject = v.bOh();
      v.bOh();
      boolean bool = ((aa)localObject).x(aa.PX(this.fileName), this.oJJ.field_fileId, paramfue.ZaN);
      localObject = com.tencent.mm.plugin.report.service.h.OAn;
      if (bool)
      {
        i = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject).b(12696, new Object[] { Integer.valueOf(i + 900), Integer.valueOf(localz.osy) });
        Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], new RecvXml[%s], saveret[%b]", new Object[] { bNX(), paramfue.ZaN, localz.bOu(), Boolean.valueOf(bool) });
      }
    }
    else
    {
      label1192:
      ab.f(localz);
      ab.d(localz);
      if ((ab.bOG()) && (this.oJL != null) && (!Util.isNullOrNil(localz.oYk)))
      {
        localObject = ab.Qo(localz.oYk);
        if (localObject != null)
        {
          ((z)localObject).pba = Util.nowSecond();
          ((z)localObject).status = 199;
          ((z)localObject).eQp = 1284;
          ab.f((z)localObject);
        }
      }
      localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(localz.pbc);
      if (localObject != null)
      {
        ((cc)localObject).AU(paramfue.YFJ);
        ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(((fi)localObject).field_msgId, (cc)localObject);
      }
      b.oUZ.u((cc)localObject);
      if ((!PF(localz.bOs())) && (!au.bwc(localz.bOs()))) {
        break label1575;
      }
      Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s upload to biz :%s", new Object[] { bNX(), localz.bOs() });
      if (localz.hTh < 0L)
      {
        Log.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + localz.hTh + " file:" + this.fileName + " toUser:" + localz.bOs());
        paramfue = com.tencent.mm.cb.d.acls;
        com.tencent.mm.cb.d.a(null, this.fileName, 5, 0L, 0L, 0L, 0L, false, -1);
        ab.Qf(this.fileName);
        this.oJK.eF(3, -1);
      }
    }
    for (;;)
    {
      paramfue = com.tencent.mm.cb.d.acls;
      com.tencent.mm.cb.d.btO(this.fileName);
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
      if (!ab.bOG()) {
        this.oJK.eF(0, 0);
      }
      AppMethodBeat.o(241371);
      return;
      i = 2;
      break;
      label1553:
      Log.w("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn need aeskey but ret null", new Object[] { bNX() });
      break label1192;
      label1575:
      Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s not upload to biz", new Object[] { bNX() });
      if (localz.hTh <= 0L)
      {
        Log.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + localz.hTh + " file:" + this.fileName + " toUser:" + localz.bOs());
        paramfue = com.tencent.mm.cb.d.acls;
        com.tencent.mm.cb.d.a(null, this.fileName, 5, 0L, 0L, 0L, 0L, false, -1);
        ab.Qf(this.fileName);
        this.oJK.eF(3, -1);
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(126872);
    z localz = ab.Qo(this.fileName);
    if (localz == null)
    {
      Log.e("MicroMsg.NetSceneUploadVideoForCdn", "Get info Failed file:" + this.fileName);
      this.oJK.eF(3, -1);
      AppMethodBeat.o(126872);
      return -1;
    }
    a(localz, paramh);
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(126872);
    return i;
  }
  
  public final int getType()
  {
    return 149;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126874);
    Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s cdntra onGYNetEnd errtype[%d %d]", new Object[] { bNX(), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    a(paramInt2, paramInt3, paramString, (fue)c.c.b(((c)params).otC), this);
    AppMethodBeat.o(126874);
  }
  
  public final int securityLimitCount()
  {
    return 1;
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return p.b.ouh;
  }
  
  public final void setSecurityCheckError(p.a parama)
  {
    AppMethodBeat.i(126873);
    ab.Qf(this.fileName);
    AppMethodBeat.o(126873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.l
 * JD-Core Version:    0.7.0.1
 */