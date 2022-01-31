package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.p;
import com.tencent.mm.ai.t;
import com.tencent.mm.ai.v;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.con;
import com.tencent.mm.protocal.protobuf.coo;
import com.tencent.mm.protocal.protobuf.nt;
import com.tencent.mm.protocal.protobuf.nu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

final class l$4
  implements g.a
{
  l$4(l paraml) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(78325);
    ab.d(l.f(this.fFT), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { l.j(this.fFT), Integer.valueOf(paramInt), paramc, paramd });
    if (paramInt == -21005)
    {
      ab.w(l.f(this.fFT), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { l.j(this.fFT) });
      if (l.k(this.fFT) != null) {
        l.k(this.fFT).aho();
      }
      l.g(this.fFT).onSceneEnd(3, paramInt, "", this.fFT);
      AppMethodBeat.o(78325);
      return 0;
    }
    long l1;
    long l2;
    int i;
    int j;
    int k;
    if (paramInt != 0)
    {
      ab.e(l.f(this.fFT), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { l.j(this.fFT), Integer.valueOf(paramInt) });
      i.lz((int)l.b(this.fFT));
      i.ly((int)l.b(this.fFT));
      if (paramd != null)
      {
        l1 = l.l(this.fFT);
        l2 = bo.aoy();
        i = com.tencent.mm.al.c.cb(ah.getContext());
        j = l.m(this.fFT);
        k = paramd.field_fileLength;
        paramc = paramd.field_transInfo;
        if (paramd != null) {
          break label417;
        }
      }
      label417:
      for (paramString = "";; paramString = l.tk(paramd.edb))
      {
        new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramc, "", "", "", "", "", "", "", paramString })).ake();
        l.g(this.fFT).onSceneEnd(3, paramInt, "", this.fFT);
        if (l.k(this.fFT) != null) {
          l.k(this.fFT).aho();
        }
        AppMethodBeat.o(78325);
        return 0;
      }
    }
    e locale = l.d(this.fFT);
    if ((locale == null) || (locale.fDL != l.c(this.fFT)))
    {
      com.tencent.mm.al.f.afO().sI(l.j(this.fFT));
      ab.e(l.f(this.fFT), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(l.c(this.fFT)), l.j(this.fFT) });
      if (l.k(this.fFT) != null) {
        l.k(this.fFT).aho();
      }
      AppMethodBeat.o(78325);
      return 0;
    }
    if (paramc != null)
    {
      l.a(this.fFT, locale, paramc.field_finishedLength, 0L, 0, paramd);
      AppMethodBeat.o(78325);
      return 0;
    }
    if (paramd != null)
    {
      ab.i(l.f(this.fFT), "dkupimg sceneResult:%s", new Object[] { paramd });
      if (paramd.field_retCode == 0) {
        break label1279;
      }
      ab.e(l.f(this.fFT), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { l.j(this.fFT), Integer.valueOf(paramd.field_retCode), paramd });
      if (paramd.field_retCode == -21111)
      {
        ab.w(l.f(this.fFT), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { l.j(this.fFT), Boolean.valueOf(l.n(this.fFT)) });
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RO().ac(new l.4.1(this, paramd));
        AppMethodBeat.o(78325);
        return 0;
      }
      if (paramd.field_retCode == -5103237)
      {
        ab.w(l.f(this.fFT), "upload hevc failed try jpg");
        com.tencent.mm.kernel.g.RO().ac(new l.4.2(this));
        AppMethodBeat.o(78325);
        return 0;
      }
      paramString = null;
      if (!bo.ce(paramd.field_sKeyrespbuf)) {
        paramString = new coo();
      }
    }
    Object localObject;
    try
    {
      paramString.parseFrom(paramd.field_sKeyrespbuf);
      ab.d(l.f(this.fFT), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramString.BaseResponse.Ret), paramString.BaseResponse.ErrMsg.toString() });
      i.lz((int)l.b(this.fFT));
      i.ly((int)l.b(this.fFT));
      paramInt = paramd.field_retCode;
      l1 = l.l(this.fFT);
      l2 = bo.aoy();
      i = com.tencent.mm.al.c.cb(ah.getContext());
      j = l.m(this.fFT);
      k = paramd.field_fileLength;
      localObject = paramd.field_transInfo;
      if (paramd == null)
      {
        paramc = "";
        paramc = com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), localObject, "", "", "", "", "", "", "", paramc });
        new com.tencent.mm.g.b.a.f(paramc).ake();
        new com.tencent.mm.g.b.a.d(paramc).ake();
        if ((paramString == null) || (paramString.BaseResponse.Ret == 0)) {
          break label1252;
        }
        l.g(this.fFT).onSceneEnd(4, paramString.BaseResponse.Ret, paramString.BaseResponse.ErrMsg.toString(), this.fFT);
        if (l.k(this.fFT) != null) {
          l.k(this.fFT).aho();
        }
        AppMethodBeat.o(78325);
        return 0;
      }
    }
    catch (IOException paramc)
    {
      for (;;)
      {
        paramString = null;
        ab.e(l.f(this.fFT), "UploadMsgImgResponse parse fail: %s", new Object[] { paramc });
        ab.e(l.f(this.fFT), "exception:%s", new Object[] { bo.l(paramc) });
      }
    }
    catch (e.a.a.b paramc)
    {
      for (;;)
      {
        paramString = null;
        ab.e(l.f(this.fFT), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramc });
        ab.e(l.f(this.fFT), "exception:%s", new Object[] { bo.l(paramc) });
        continue;
        paramc = l.tk(paramd.edb);
        continue;
        label1252:
        l.g(this.fFT).onSceneEnd(3, paramd.field_retCode, "", this.fFT);
      }
    }
    label1279:
    ab.i(l.f(this.fFT), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramd.field_UploadHitCacheType), Boolean.valueOf(paramd.field_needSendMsgField) });
    paramString = h.qsU;
    if (locale.cpt == 0)
    {
      paramInt = 3;
      label1332:
      paramString.e(13230, new Object[] { Integer.valueOf(paramInt), l.u(this.fFT), Integer.valueOf(paramd.field_UploadHitCacheType) });
      paramString = l.v(this.fFT);
      paramc = f.tb(paramString);
      if ((paramc == null) || (bo.isNullOrNil(paramc.appId))) {
        break label2917;
      }
    }
    label1576:
    label2506:
    label2914:
    label2917:
    for (paramc = f.c(paramc.appId, paramc.mediaTagName, paramc.messageExt, paramc.messageAction);; paramc = "")
    {
      if (bo.isNullOrNil(paramString))
      {
        paramString = "<msg><img aeskey=\"" + paramd.field_aesKey + "\" cdnmidimgurl=\"" + paramd.field_fileId + "\" cdnbigimgurl=\"" + paramd.field_fileId + "\" ";
        paramString = paramString + "cdnthumburl=\"" + paramd.field_fileId + "\" cdnthumbaeskey=\"" + paramd.field_aesKey + "\" cdnthumblength=\"" + paramd.field_thumbimgLength + "\" ";
        paramString = new StringBuilder().append(paramString).append("length=\"");
        if (paramd.field_midimgLength == 0)
        {
          paramInt = paramd.field_fileLength;
          paramString = paramInt + "\" hdlength=\"" + paramd.field_fileLength + "\"/>" + paramc + "</msg>";
          ab.i(l.f(this.fFT), "cdn callback new build cdnInfo:%s", new Object[] { paramString });
        }
      }
      for (;;)
      {
        for (;;)
        {
          localObject = paramString;
          if (paramd.Jm())
          {
            if (!bo.isNullOrNil(l.w(this.fFT))) {
              break label2334;
            }
            ab.w(l.f(this.fFT), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
          }
          for (localObject = paramString;; localObject = paramString + "length=\"" + paramd.field_midimgLength + "\" hdlength=\"" + paramd.field_fileLength + "\"/>" + paramc + "</msg>")
          {
            locale.sZ((String)localObject);
            l.b(this.fFT, (String)localObject);
            if (l.b(this.fFT) != l.c(this.fFT)) {
              l.e(this.fFT).sZ((String)localObject);
            }
            if (!paramd.field_needSendMsgField) {
              break label2506;
            }
            com.tencent.mm.kernel.g.RK().eHt.a(new m(l.x(this.fFT), (con)l.s(this.fFT).fsV.fta, locale, paramd, new l.4.3(this, paramd, locale)), 0);
            break;
            paramInt = locale.cpt;
            break label1332;
            paramInt = paramd.field_midimgLength;
            break label1576;
            localObject = br.F(paramString, "msg");
            if (localObject == null) {
              break label2914;
            }
            if (locale.fDP == 0)
            {
              paramString = "<msg><img aeskey=\"" + (String)((Map)localObject).get(".msg.img.$aeskey") + "\" cdnmidimgurl=\"" + paramd.field_fileId + "\" cdnbigimgurl=\"" + (String)((Map)localObject).get(".msg.img.$cdnbigimgurl") + "\" ";
              paramString = paramString + "cdnthumburl=\"" + (String)((Map)localObject).get(".msg.img.$cdnthumburl") + "\" cdnthumbaeskey=\"" + (String)((Map)localObject).get(".msg.img.$cdnthumbaeskey") + "\" cdnthumblength=\"" + (String)((Map)localObject).get(".msg.img.cdnthumblength") + "\" ";
              paramString = new StringBuilder().append(paramString).append("length=\"");
              if (paramd.field_midimgLength == 0) {
                paramInt = paramd.field_fileLength;
              }
            }
            label2025:
            for (paramString = paramInt + "\" hdlength=\"" + (String)((Map)localObject).get(".msg.img.$hdlength") + "\"/>" + paramc + "</msg>";; paramString = paramString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramd.field_fileLength + "\"/>" + paramc + "</msg>")
            {
              ab.i(l.f(this.fFT), "cdn callback rebuild cdnInfo:%s", new Object[] { paramString });
              break;
              paramInt = paramd.field_midimgLength;
              break label2025;
              paramString = "<msg><img aeskey=\"" + (String)((Map)localObject).get(".msg.img.$aeskey") + "\" cdnmidimgurl=\"" + (String)((Map)localObject).get(".msg.img.$cdnmidimgurl") + "\" cdnbigimgurl=\"" + paramd.field_fileId + "\" ";
              paramString = paramString + "cdnthumburl=\"" + (String)((Map)localObject).get(".msg.img.$cdnthumburl") + "\" cdnthumbaeskey=\"" + (String)((Map)localObject).get(".msg.img.$cdnthumbaeskey") + "\" cdnthumblength=\"" + (String)((Map)localObject).get(".msg.img.cdnthumblength") + "\" ";
            }
            paramString = "<msg><img aeskey=\"" + l.w(this.fFT) + "\" cdnmidimgurl=\"" + paramd.field_fileId + "\" cdnbigimgurl=\"" + paramd.field_fileId + "\" ";
            paramString = paramString + "cdnthumburl=\"" + paramd.field_fileId + "\" cdnthumbaeskey=\"" + l.w(this.fFT) + "\" ";
          }
          new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(l.l(this.fFT)), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(l.m(this.fFT)), Integer.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", l.tk(paramd.edb) })).ake();
          paramString = new coo();
          try
          {
            paramString.parseFrom(paramd.field_sKeyrespbuf);
            if (paramString.pIG != 0L) {}
            for (l1 = paramString.pIG;; l1 = paramInt)
            {
              ab.d(l.f(this.fFT), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramString.BaseResponse.Ret), paramString.BaseResponse.ErrMsg.toString() });
              if (l.a(this.fFT, locale, locale.fsd, l1, paramString.CreateTime, paramd))
              {
                l.g(this.fFT).onSceneEnd(0, 0, "", this.fFT);
                if (l.k(this.fFT) != null) {
                  l.k(this.fFT).aho();
                }
              }
              AppMethodBeat.o(78325);
              return 0;
              paramInt = paramString.pIE;
            }
            if (l.k(this.fFT) == null) {
              break;
            }
          }
          catch (IOException paramString)
          {
            ab.e(l.f(this.fFT), "UploadMsgImgResponse parse fail: %s", new Object[] { paramString });
            ab.e(l.f(this.fFT), "exception:%s", new Object[] { bo.l(paramString) });
            l.g(this.fFT).onSceneEnd(3, paramd.field_retCode, "", this.fFT);
          }
        }
        l.k(this.fFT).aho();
        break;
      }
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(78326);
    Object localObject1 = (con)l.s(this.fFT).fsV.fta;
    nt localnt = new nt();
    localnt.wDd = ((con)localObject1).xXk.xJE;
    localnt.num = ((con)localObject1).woP.xJE;
    localnt.nul = ((con)localObject1).woQ.xJE;
    localnt.wDe = ((con)localObject1).xXr;
    localnt.wDf = ((con)localObject1).xXs;
    localnt.Scene = l.y(this.fFT);
    localnt.wDh = l.z(this.fFT);
    localnt.wDi = l.A(this.fFT);
    localnt.wDj = l.B(this.fFT);
    localnt.woU = ((con)localObject1).woU;
    localnt.wDo = l.C(this.fFT);
    localnt.fKw = ((con)localObject1).fKw;
    localnt.wmD = ((con)localObject1).wmD;
    localnt.wmF = ((con)localObject1).wmF;
    localnt.wmE = ((con)localObject1).wmE;
    localObject1 = l.d(this.fFT);
    Object localObject2 = o.ahC().q(((e)localObject1).fDM, "", "");
    com.tencent.mm.al.f.afP();
    localnt.wDq = com.tencent.mm.al.a.sD((String)localObject2);
    localnt.wDr = ((e)localObject1).fDQ;
    int i;
    label334:
    String str;
    if (localnt.wDr <= 0)
    {
      if (l.x(this.fFT) == 4)
      {
        i = 2;
        localnt.wDr = i;
      }
    }
    else {
      switch (l.x(this.fFT))
      {
      case 3: 
      case 5: 
      default: 
        localnt.niK = 2;
        if (localnt.wDr == 3) {
          localnt.niK = 4;
        }
        ab.i(l.f(this.fFT), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramString, Integer.valueOf(localnt.wDe), Integer.valueOf(localnt.wDf), localnt.woU, localnt.nul, localnt.wDo, Long.valueOf(l.c(this.fFT)), Long.valueOf(l.D(this.fFT)), ((e)localObject1).fDM, localObject2, Integer.valueOf(localnt.wDq), Integer.valueOf(localnt.wDr), Integer.valueOf(localnt.niK) });
        paramString = new b.a();
        paramString.fsX = localnt;
        paramString.fsY = new coo();
        paramString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        paramString.funcId = 625;
        paramString.reqCmdId = 9;
        paramString.respCmdId = 1000000009;
        localObject1 = paramString.ado();
        localObject2 = l.E(this.fFT).adI();
        str = l.f(this.fFT);
        if (localObject2 != null) {
          break;
        }
      }
    }
    for (paramString = "acc == null";; paramString = Boolean.valueOf(((com.tencent.mm.network.c)localObject2).adC()))
    {
      ab.i(str, "getCdnAuthInfo login:%s", new Object[] { paramString });
      if ((localObject2 == null) || (!((com.tencent.mm.network.c)localObject2).adC())) {
        break label768;
      }
      if (!t.a(((com.tencent.mm.network.c)localObject2).jN(1), ((com.tencent.mm.network.c)localObject2).adB(), ((com.tencent.mm.network.c)localObject2).adD(), ((com.tencent.mm.ai.b)localObject1).getReqObj(), paramByteArrayOutputStream, ((com.tencent.mm.network.c)localObject2).isForeground())) {
        break label736;
      }
      ab.d(l.f(this.fFT), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localnt.wDd });
      AppMethodBeat.o(78326);
      return;
      i = 1;
      break;
      localnt.niK = 1;
      break label334;
      localnt.niK = 3;
      break label334;
      localnt.niK = 5;
      break label334;
    }
    label736:
    ab.e(l.f(this.fFT), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localnt.wDd });
    AppMethodBeat.o(78326);
    return;
    label768:
    ab.e(l.f(this.fFT), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localnt.wDd });
    AppMethodBeat.o(78326);
  }
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78327);
    PInt localPInt = new PInt();
    nu localnu = new nu();
    try
    {
      paramArrayOfByte = v.a(paramArrayOfByte, com.tencent.mm.kernel.g.RK().eHt.ftA.adI().jN(1), localPInt, localnu);
      ab.i(l.f(this.fFT), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localnu.wDo, localnu.wDs, localnu.wDd });
      l.c(this.fFT, localnu.wDo);
      ab.i(l.f(this.fFT), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramString, Integer.valueOf(localPInt.value) });
      AppMethodBeat.o(78327);
      return paramArrayOfByte;
    }
    catch (Exception paramString)
    {
      ab.e(l.f(this.fFT), "decodePrepareResponse Exception:%s", new Object[] { paramString });
      l.c(this.fFT, null);
      AppMethodBeat.o(78327);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.at.l.4
 * JD-Core Version:    0.7.0.1
 */