package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.av.f;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.protocal.protobuf.eoc;
import com.tencent.mm.protocal.protobuf.eod;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import junit.framework.Assert;

public final class h
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  String fileName;
  private int jaB;
  public com.tencent.mm.i.d jaC;
  public f jaD;
  private com.tencent.mm.ak.d rr;
  
  public h(String paramString, int paramInt, com.tencent.mm.i.d paramd, f paramf)
  {
    AppMethodBeat.i(240867);
    this.fileName = null;
    this.jaB = 0;
    this.jaC = null;
    this.jaD = null;
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
      this.jaC = paramd;
      this.jaD = paramf;
      this.jaB = paramInt;
      AppMethodBeat.o(240867);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label51;
    }
  }
  
  private static boolean Qg(String paramString)
  {
    AppMethodBeat.i(240871);
    paramString = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramString);
    if ((paramString == null) || ((int)paramString.gMZ <= 0))
    {
      AppMethodBeat.o(240871);
      return false;
    }
    boolean bool = paramString.gBM();
    AppMethodBeat.o(240871);
    return bool;
  }
  
  private String bgZ()
  {
    AppMethodBeat.i(126875);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(126875);
    return str;
  }
  
  private String bhb()
  {
    AppMethodBeat.i(240869);
    Object localObject = u.QN(this.fileName);
    String str = null;
    if (localObject != null)
    {
      if (Util.isNullOrNil(((s)localObject).jsz)) {
        break label93;
      }
      str = ((s)localObject).jsz;
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSceneUploadVideoForCdn", "createVideoMsgSource preLoadLength: %s, forward uuid %s", new Object[] { Integer.valueOf(this.jaB), str });
      if ((this.jaB > 0) && (this.jaB <= 1048576)) {
        break label165;
      }
      if (!Util.isNullOrNil(str)) {
        break;
      }
      str = br.ajw();
      AppMethodBeat.o(240869);
      return str;
      label93:
      if (((s)localObject).jsy > 0)
      {
        str = br.KB(((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(((s)localObject).jsy).fqK);
      }
      else
      {
        str = com.tencent.mm.vfs.s.bhK(((s)localObject).bhu());
        localObject = v.jNy;
        str = v.Ss(str);
      }
    }
    str = br.KC(str);
    AppMethodBeat.o(240869);
    return str;
    label165:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("<msgsource>");
    ((StringBuilder)localObject).append("<videopreloadlen>").append(this.jaB).append("</videopreloadlen>");
    if (!Util.isNullOrNil(str)) {
      ((StringBuilder)localObject).append("<sec_msg_node><uuid>").append(str).append("</uuid></sec_msg_node>");
    }
    ((StringBuilder)localObject).append("</msgsource>");
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 35L, 1L, false);
    str = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(240869);
    return str;
  }
  
  public final eoc a(s params, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(240868);
    this.callback = parami;
    parami = new d.a();
    parami.iLN = new eoc();
    parami.iLO = new eod();
    parami.uri = "/cgi-bin/micromsg-bin/uploadvideo";
    parami.funcId = 149;
    parami.iLP = 39;
    parami.respCmdId = 1000000039;
    this.rr = parami.aXF();
    parami = (eoc)this.rr.iLK.iLR;
    parami.NlQ = 0;
    parami.NlP = ((int)this.jaC.field_fileLength);
    parami.NlR = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    parami.MrU = 0;
    parami.MrT = this.jaC.field_thumbimgLength;
    parami.MrV = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    parami.xNH = z.aTY();
    parami.xNG = this.jaC.field_toUser;
    parami.KIz = this.fileName;
    if (params.jsr == 1) {
      parami.KTf = 2;
    }
    if (params.jsu == 3) {
      parami.KTf = 3;
    }
    parami.MXo = params.iFw;
    label373:
    Object localObject;
    label572:
    label722:
    String str;
    if (ag.dm(MMApplicationContext.getContext()))
    {
      i = 1;
      parami.LrC = i;
      parami.MrW = 2;
      parami.NlH = this.jaC.field_thumbimgLength;
      parami.NlS = this.jaC.field_fileId;
      parami.Mip = this.jaC.field_fileId;
      parami.LbK = 1;
      if (!this.jaC.alL()) {
        break label981;
      }
      Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", new Object[] { bgZ(), Boolean.valueOf(this.jaC.field_upload_by_safecdn), Integer.valueOf(this.jaC.field_UploadHitCacheType), Integer.valueOf(this.jaC.field_filecrc), this.jaC.field_aesKey });
      parami.MVx = 1;
      parami.LbJ = "";
      parami.Mir = "";
      parami.NlU = this.jaC.field_filemd5;
      parami.Nme = this.jaC.field_mp4identifymd5;
      parami.LbL = this.jaC.field_filecrc;
      parami.KHq = bhb();
      parami.Nmd = params.ean;
      if (((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(this.jaC.field_toUser)) {
        parami.LbN = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().bjT(this.jaC.field_toUser);
      }
      params = params.jsw;
      if ((params == null) || (Util.isNullOrNil(params.iyZ))) {
        break label1006;
      }
      parami.NlV = Util.nullAs(params.iyZ, "");
      parami.NlW = params.LxJ;
      parami.NlX = Util.nullAs(params.izb, "");
      parami.NlZ = Util.nullAs(params.izd, "");
      parami.NlY = Util.nullAs(params.izc, "");
      parami.Nma = Util.nullAs(params.ize, "");
      if (params != null)
      {
        parami.Nmc = Util.nullAs(params.izf, "");
        parami.Nmb = Util.nullAs(params.izg, "");
      }
      o.bhj();
      params = t.Qx(this.fileName);
      localObject = BitmapUtil.getImageOptions(params);
      if (localObject == null) {
        break label1049;
      }
      parami.NlJ = ((BitmapFactory.Options)localObject).outWidth;
      parami.NlI = ((BitmapFactory.Options)localObject).outHeight;
      label645:
      o.bhj();
      params = t.Qw(this.fileName);
      switch (n.bhh().Qj(params))
      {
      case 4: 
      case 5: 
      default: 
        parami.LbM = 0;
        parami.xub = 0;
        params = bgZ();
        localObject = this.fileName;
        str = this.jaC.field_toUser;
        if (this.jaC.field_aesKey != null) {
          break;
        }
      }
    }
    for (int i = -1;; i = this.jaC.field_aesKey.length())
    {
      Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn cdntra doscene file:%s touser:%s aes:%d fileid:%s thumb:[%d %d %d], thumbaeskey [%s] funcFlag: %d, md5:%s HitMd5:%d CRC32:%d, VideoNewMd5:%s AESKey:%s stream %s streamtime: %d title %s thumburl %s msgSource[%s] msgForwardType[%d] Source[%d]", new Object[] { params, localObject, str, Integer.valueOf(i), this.jaC.field_fileId, Integer.valueOf(this.jaC.field_thumbimgLength), Integer.valueOf(parami.NlJ), Integer.valueOf(parami.NlI), Util.secPrint(parami.Mir), Integer.valueOf(parami.KTf), parami.NlU, Integer.valueOf(parami.MVx), Integer.valueOf(parami.LbL), parami.Nme, Util.secPrint(parami.LbJ), parami.NlV, Integer.valueOf(parami.NlW), parami.NlX, parami.Nma, parami.KHq, Integer.valueOf(parami.LbM), Integer.valueOf(parami.xub) });
      AppMethodBeat.o(240868);
      return parami;
      i = 2;
      break;
      label981:
      parami.LbJ = this.jaC.field_aesKey;
      parami.Mir = this.jaC.field_aesKey;
      break label373;
      label1006:
      if ((params == null) || (Util.isNullOrNil(params.izd)) || (Util.isNullOrNil(params.izc))) {
        break label572;
      }
      parami.NlZ = params.izd;
      parami.NlY = params.izc;
      break label572;
      label1049:
      Log.w("MicroMsg.NetSceneUploadVideoForCdn", "cdntra getImageOptions for thumb failed path:%s", new Object[] { params });
      break label645;
      parami.LbM = 1;
      parami.xub = 2;
      break label722;
      parami.LbM = 1;
      parami.xub = 1;
      break label722;
      parami.LbM = 2;
      parami.xub = 3;
      break label722;
      parami.LbM = 3;
      parami.xub = 4;
      break label722;
      parami.LbM = 1;
      parami.xub = 5;
      break label722;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, eod parameod, q paramq)
  {
    AppMethodBeat.i(240870);
    if ((parameod != null) && ((paramInt1 == 4) || ((paramInt1 == 0) && (paramInt2 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(parameod.LbO);
    }
    s locals = u.QN(this.fileName);
    if (locals == null)
    {
      Log.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
      this.jaD.dq(3, -1);
      AppMethodBeat.o(240870);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == 102))
    {
      Log.e("MicroMsg.NetSceneUploadVideoForCdn", "summersafecdn ERR: MM_ERR_GET_AESKEY_FAILED errtype:" + paramInt1 + " errCode:" + paramInt2 + "  file:" + this.fileName + " user:" + locals.getUser());
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
      this.jaD.dq(paramInt1, paramInt2);
      AppMethodBeat.o(240870);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -22))
    {
      Log.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd BLACK  errtype:" + paramInt1 + " errCode:" + paramInt2 + "  file:" + this.fileName + " user:" + locals.getUser());
      u.QF(this.fileName);
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
      this.jaD.dq(paramInt1, paramInt2);
      AppMethodBeat.o(240870);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 != 0))
    {
      Log.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt1 + " errCode:" + paramInt2 + "  file:" + this.fileName + " user:" + locals.getUser());
      u.QE(this.fileName);
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
      this.jaD.dq(paramInt1, paramInt2);
      AppMethodBeat.o(240870);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt1 + " errCode:" + paramInt2 + "  file:" + this.fileName + " user:" + locals.getUser());
      u.QE(this.fileName);
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
      this.jaD.dq(paramInt1, paramInt2);
      AppMethodBeat.o(240870);
      return;
    }
    locals.jsm = Util.nowSecond();
    locals.dTS = parameod.Brn;
    Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s dkmsgid  set svrmsgid %d -> %d", new Object[] { bgZ(), Long.valueOf(locals.dTS), Integer.valueOf(ac.jOD) });
    if ((10007 == ac.jOC) && (ac.jOD != 0) && (locals.dTS != 0L))
    {
      locals.dTS = ac.jOD;
      ac.jOD = 0;
    }
    locals.status = 199;
    locals.cSx = 1284;
    Object localObject;
    int i;
    if (this.jaC.alL())
    {
      Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], old RecvXml[%s]", new Object[] { bgZ(), parameod.LbJ, locals.bhv() });
      if (Util.isNullOrNil(parameod.LbJ)) {
        break label1283;
      }
      localObject = "<msg><videomsg aeskey=\"" + parameod.LbJ + "\" cdnthumbaeskey=\"" + parameod.LbJ + "\" cdnvideourl=\"" + this.jaC.field_fileId + "\" ";
      localObject = (String)localObject + "cdnthumburl=\"" + this.jaC.field_fileId + "\" ";
      localObject = (String)localObject + "length=\"" + this.jaC.field_fileLength + "\" ";
      localObject = (String)localObject + "cdnthumblength=\"" + this.jaC.field_thumbimgLength + "\"/></msg>";
      Log.i("MicroMsg.NetSceneUploadVideoForCdn", "cdn callback new build cdnInfo:%s", new Object[] { localObject });
      locals.jst = ((String)localObject);
      localObject = o.bhj();
      o.bhj();
      boolean bool = ((t)localObject).q(t.Qw(this.fileName), this.jaC.field_fileId, parameod.LbJ);
      localObject = com.tencent.mm.plugin.report.service.h.CyF;
      if (bool)
      {
        i = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject).a(12696, new Object[] { Integer.valueOf(i + 900), Integer.valueOf(locals.iKP) });
        Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], new RecvXml[%s], saveret[%b]", new Object[] { bgZ(), parameod.LbJ, locals.bhv(), Boolean.valueOf(bool) });
      }
    }
    else
    {
      label1034:
      u.f(locals);
      u.d(locals);
      localObject = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(locals.jso);
      ((ca)localObject).BB(parameod.KHq);
      ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(((eo)localObject).field_msgId, (ca)localObject);
      b.jmd.s((ca)localObject);
      if ((!Qg(locals.getUser())) && (!ab.Jf(locals.getUser()))) {
        break label1305;
      }
      Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s upload to biz :%s", new Object[] { bgZ(), locals.getUser() });
      if (locals.dTS < 0L)
      {
        Log.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + locals.dTS + " file:" + this.fileName + " toUser:" + locals.getUser());
        u.QE(this.fileName);
        this.jaD.dq(3, -1);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
      this.jaD.dq(0, 0);
      AppMethodBeat.o(240870);
      return;
      i = 2;
      break;
      label1283:
      Log.w("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn need aeskey but ret null", new Object[] { bgZ() });
      break label1034;
      label1305:
      Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s not upload to biz", new Object[] { bgZ() });
      if (locals.dTS <= 0L)
      {
        Log.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + locals.dTS + " file:" + this.fileName + " toUser:" + locals.getUser());
        u.QE(this.fileName);
        this.jaD.dq(3, -1);
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(126872);
    s locals = u.QN(this.fileName);
    if (locals == null)
    {
      Log.e("MicroMsg.NetSceneUploadVideoForCdn", "Get info Failed file:" + this.fileName);
      this.jaD.dq(3, -1);
      AppMethodBeat.o(126872);
      return -1;
    }
    a(locals, parami);
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
    Log.i("MicroMsg.NetSceneUploadVideoForCdn", "%s cdntra onGYNetEnd errtype[%d %d]", new Object[] { bgZ(), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    a(paramInt2, paramInt3, paramString, (eod)((com.tencent.mm.ak.d)params).iLL.iLR, this);
    AppMethodBeat.o(126874);
  }
  
  public final int securityLimitCount()
  {
    return 1;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return q.b.iMq;
  }
  
  public final void setSecurityCheckError(q.a parama)
  {
    AppMethodBeat.i(126873);
    u.QE(this.fileName);
    AppMethodBeat.o(126873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.h
 * JD-Core Version:    0.7.0.1
 */