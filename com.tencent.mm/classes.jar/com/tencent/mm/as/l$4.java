package com.tencent.mm.as;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.p;
import com.tencent.mm.ah.t;
import com.tencent.mm.ah.v;
import com.tencent.mm.j.f.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.cbh;
import com.tencent.mm.protocal.c.cbi;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.c.lf;
import com.tencent.mm.protocal.c.lg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

final class l$4
  implements f.a
{
  l$4(l paraml) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.j.c paramc, com.tencent.mm.j.d paramd, boolean paramBoolean)
  {
    y.d(l.f(this.ept), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { l.j(this.ept), Integer.valueOf(paramInt), paramc, paramd });
    if (paramInt == -21005)
    {
      y.w(l.f(this.ept), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { l.j(this.ept) });
      if (l.k(this.ept) != null) {
        l.k(this.ept).Ow();
      }
      l.g(this.ept).onSceneEnd(3, paramInt, "", this.ept);
      return 0;
    }
    long l1;
    long l2;
    int i;
    int j;
    int k;
    if (paramInt != 0)
    {
      y.e(l.f(this.ept), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { l.j(this.ept), Integer.valueOf(paramInt) });
      i.iL((int)l.b(this.ept));
      i.iK((int)l.b(this.ept));
      if (paramd != null)
      {
        l1 = l.l(this.ept);
        l2 = bk.UY();
        i = com.tencent.mm.ak.c.bx(ae.getContext());
        j = l.m(this.ept);
        k = paramd.field_fileLength;
        paramc = paramd.field_transInfo;
        if (paramd != null) {
          break label402;
        }
      }
      label402:
      for (paramString = "";; paramString = l.mf(paramd.dlG))
      {
        new com.tencent.mm.h.b.a.f(com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramc, "", "", "", "", "", "", "", paramString })).QX();
        l.g(this.ept).onSceneEnd(3, paramInt, "", this.ept);
        if (l.k(this.ept) != null) {
          l.k(this.ept).Ow();
        }
        return 0;
      }
    }
    e locale = l.d(this.ept);
    if ((locale == null) || (locale.enp != l.c(this.ept)))
    {
      com.tencent.mm.ak.f.Nd().lL(l.j(this.ept));
      y.e(l.f(this.ept), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(l.c(this.ept)), l.j(this.ept) });
      if (l.k(this.ept) != null) {
        l.k(this.ept).Ow();
      }
      return 0;
    }
    if (paramc != null)
    {
      l.a(this.ept, locale, paramc.field_finishedLength, 0L, 0, paramd);
      return 0;
    }
    if (paramd != null)
    {
      y.i(l.f(this.ept), "dkupimg sceneResult:%s", new Object[] { paramd });
      if (paramd.field_retCode == 0) {
        break label1238;
      }
      y.e(l.f(this.ept), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { l.j(this.ept), Integer.valueOf(paramd.field_retCode), paramd });
      if (paramd.field_retCode == -21111)
      {
        y.w(l.f(this.ept), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { l.j(this.ept), Boolean.valueOf(l.n(this.ept)) });
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DS().O(new l.4.1(this, paramd));
        return 0;
      }
      if (paramd.field_retCode == -5103237)
      {
        y.w(l.f(this.ept), "upload hevc failed try jpg");
        com.tencent.mm.kernel.g.DS().O(new l.4.2(this));
        return 0;
      }
      paramString = null;
      if (!bk.bE(paramd.field_sKeyrespbuf)) {
        paramString = new cbi();
      }
    }
    Object localObject;
    try
    {
      paramString.aH(paramd.field_sKeyrespbuf);
      y.d(l.f(this.ept), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramString.tFx.sze), paramString.tFx.sAn.toString() });
      i.iL((int)l.b(this.ept));
      i.iK((int)l.b(this.ept));
      paramInt = paramd.field_retCode;
      l1 = l.l(this.ept);
      l2 = bk.UY();
      i = com.tencent.mm.ak.c.bx(ae.getContext());
      j = l.m(this.ept);
      k = paramd.field_fileLength;
      localObject = paramd.field_transInfo;
      if (paramd == null)
      {
        paramc = "";
        paramc = com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), localObject, "", "", "", "", "", "", "", paramc });
        new com.tencent.mm.h.b.a.f(paramc).QX();
        new com.tencent.mm.h.b.a.d(paramc).QX();
        if ((paramString == null) || (paramString.tFx.sze == 0)) {
          break label1211;
        }
        l.g(this.ept).onSceneEnd(4, paramString.tFx.sze, paramString.tFx.sAn.toString(), this.ept);
        if (l.k(this.ept) != null) {
          l.k(this.ept).Ow();
        }
        return 0;
      }
    }
    catch (IOException paramc)
    {
      for (;;)
      {
        paramString = null;
        y.e(l.f(this.ept), "UploadMsgImgResponse parse fail: %s", new Object[] { paramc });
        y.e(l.f(this.ept), "exception:%s", new Object[] { bk.j(paramc) });
      }
    }
    catch (d.a.a.b paramc)
    {
      for (;;)
      {
        paramString = null;
        y.e(l.f(this.ept), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramc });
        y.e(l.f(this.ept), "exception:%s", new Object[] { bk.j(paramc) });
        continue;
        paramc = l.mf(paramd.dlG);
        continue;
        label1211:
        l.g(this.ept).onSceneEnd(3, paramd.field_retCode, "", this.ept);
      }
    }
    label1238:
    y.i(l.f(this.ept), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramd.field_UploadHitCacheType), Boolean.valueOf(paramd.field_needSendMsgField) });
    paramString = h.nFQ;
    if (locale.source == 0)
    {
      paramInt = 3;
      label1291:
      paramString.f(13230, new Object[] { Integer.valueOf(paramInt), l.u(this.ept), Integer.valueOf(paramd.field_UploadHitCacheType) });
      paramString = l.v(this.ept);
      paramc = f.mb(paramString);
      if ((paramc == null) || (bk.bl(paramc.appId))) {
        break label2859;
      }
    }
    label2455:
    label2856:
    label2859:
    for (paramc = f.c(paramc.appId, paramc.mediaTagName, paramc.messageExt, paramc.messageAction);; paramc = "")
    {
      if (bk.bl(paramString))
      {
        paramString = "<msg><img aeskey=\"" + paramd.field_aesKey + "\" cdnmidimgurl=\"" + paramd.field_fileId + "\" cdnbigimgurl=\"" + paramd.field_fileId + "\" ";
        paramString = paramString + "cdnthumburl=\"" + paramd.field_fileId + "\" cdnthumbaeskey=\"" + paramd.field_aesKey + "\" cdnthumblength=\"" + paramd.field_thumbimgLength + "\" ";
        paramString = new StringBuilder().append(paramString).append("length=\"");
        if (paramd.field_midimgLength == 0)
        {
          paramInt = paramd.field_fileLength;
          label1535:
          paramString = paramInt + "\" hdlength=\"" + paramd.field_fileLength + "\"/>" + paramc + "</msg>";
          y.i(l.f(this.ept), "cdn callback new build cdnInfo:%s", new Object[] { paramString });
        }
      }
      for (;;)
      {
        for (;;)
        {
          localObject = paramString;
          if (paramd.wV())
          {
            if (!bk.bl(l.w(this.ept))) {
              break label2283;
            }
            y.w(l.f(this.ept), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
          }
          for (localObject = paramString;; localObject = paramString + "length=\"" + paramd.field_midimgLength + "\" hdlength=\"" + paramd.field_fileLength + "\"/>" + paramc + "</msg>")
          {
            locale.ma((String)localObject);
            if (l.b(this.ept) != l.c(this.ept)) {
              l.e(this.ept).ma((String)localObject);
            }
            if (!paramd.field_needSendMsgField) {
              break label2455;
            }
            com.tencent.mm.kernel.g.DO().dJT.a(new m(l.x(this.ept), (cbh)l.s(this.ept).ecE.ecN, locale, paramd, new l.4.3(this, paramd, locale)), 0);
            break;
            paramInt = locale.source;
            break label1291;
            paramInt = paramd.field_midimgLength;
            break label1535;
            localObject = bn.s(paramString, "msg");
            if (localObject == null) {
              break label2856;
            }
            if (locale.ent == 0)
            {
              paramString = "<msg><img aeskey=\"" + (String)((Map)localObject).get(".msg.img.$aeskey") + "\" cdnmidimgurl=\"" + paramd.field_fileId + "\" cdnbigimgurl=\"" + (String)((Map)localObject).get(".msg.img.$cdnbigimgurl") + "\" ";
              paramString = paramString + "cdnthumburl=\"" + (String)((Map)localObject).get(".msg.img.$cdnthumburl") + "\" cdnthumbaeskey=\"" + (String)((Map)localObject).get(".msg.img.$cdnthumbaeskey") + "\" cdnthumblength=\"" + (String)((Map)localObject).get(".msg.img.cdnthumblength") + "\" ";
              paramString = new StringBuilder().append(paramString).append("length=\"");
              if (paramd.field_midimgLength == 0) {
                paramInt = paramd.field_fileLength;
              }
            }
            label1974:
            for (paramString = paramInt + "\" hdlength=\"" + (String)((Map)localObject).get(".msg.img.$hdlength") + "\"/>" + paramc + "</msg>";; paramString = paramString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramd.field_fileLength + "\"/>" + paramc + "</msg>")
            {
              y.i(l.f(this.ept), "cdn callback rebuild cdnInfo:%s", new Object[] { paramString });
              break;
              paramInt = paramd.field_midimgLength;
              break label1974;
              paramString = "<msg><img aeskey=\"" + (String)((Map)localObject).get(".msg.img.$aeskey") + "\" cdnmidimgurl=\"" + (String)((Map)localObject).get(".msg.img.$cdnmidimgurl") + "\" cdnbigimgurl=\"" + paramd.field_fileId + "\" ";
              paramString = paramString + "cdnthumburl=\"" + (String)((Map)localObject).get(".msg.img.$cdnthumburl") + "\" cdnthumbaeskey=\"" + (String)((Map)localObject).get(".msg.img.$cdnthumbaeskey") + "\" cdnthumblength=\"" + (String)((Map)localObject).get(".msg.img.cdnthumblength") + "\" ";
            }
            label2283:
            paramString = "<msg><img aeskey=\"" + l.w(this.ept) + "\" cdnmidimgurl=\"" + paramd.field_fileId + "\" cdnbigimgurl=\"" + paramd.field_fileId + "\" ";
            paramString = paramString + "cdnthumburl=\"" + paramd.field_fileId + "\" cdnthumbaeskey=\"" + l.w(this.ept) + "\" ";
          }
          new com.tencent.mm.h.b.a.f(com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(l.l(this.ept)), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(l.m(this.ept)), Integer.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", l.mf(paramd.dlG) })).QX();
          paramString = new cbi();
          try
          {
            paramString.aH(paramd.field_sKeyrespbuf);
            if (paramString.ndp != 0L) {}
            for (l1 = paramString.ndp;; l1 = paramInt)
            {
              y.d(l.f(this.ept), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramString.tFx.sze), paramString.tFx.sAn.toString() });
              l.a(this.ept, locale, locale.ebK, l1, paramString.mPL, paramd);
              l.g(this.ept).onSceneEnd(0, 0, "", this.ept);
              if (l.k(this.ept) == null) {
                break;
              }
              l.k(this.ept).Ow();
              break;
              paramInt = paramString.ndm;
            }
            if (l.k(this.ept) == null) {
              break;
            }
          }
          catch (IOException paramString)
          {
            y.e(l.f(this.ept), "UploadMsgImgResponse parse fail: %s", new Object[] { paramString });
            y.e(l.f(this.ept), "exception:%s", new Object[] { bk.j(paramString) });
            l.g(this.ept).onSceneEnd(3, paramd.field_retCode, "", this.ept);
          }
        }
        l.k(this.ept).Ow();
        break;
      }
    }
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    Object localObject1 = (cbh)l.s(this.ept).ecE.ecN;
    lf locallf = new lf();
    locallf.sGF = ((cbh)localObject1).tQp.tFO;
    locallf.kWn = ((cbh)localObject1).svF.tFO;
    locallf.kWm = ((cbh)localObject1).svG.tFO;
    locallf.sGG = ((cbh)localObject1).tQw;
    locallf.sGH = ((cbh)localObject1).tQx;
    locallf.pyo = l.y(this.ept);
    locallf.sGJ = l.z(this.ept);
    locallf.sGK = l.A(this.ept);
    locallf.sGL = l.B(this.ept);
    locallf.svK = ((cbh)localObject1).svK;
    locallf.sGQ = l.C(this.ept);
    locallf.euK = ((cbh)localObject1).euK;
    locallf.sua = ((cbh)localObject1).sua;
    locallf.suc = ((cbh)localObject1).suc;
    locallf.sub = ((cbh)localObject1).sub;
    localObject1 = l.d(this.ept);
    Object localObject2 = o.OJ().o(((e)localObject1).enq, "", "");
    com.tencent.mm.ak.f.Ne();
    locallf.sGS = com.tencent.mm.ak.a.lG((String)localObject2);
    locallf.sGT = ((e)localObject1).enu;
    int i;
    label326:
    String str;
    if (locallf.sGT <= 0)
    {
      if (l.x(this.ept) == 4)
      {
        i = 2;
        locallf.sGT = i;
      }
    }
    else {
      switch (l.x(this.ept))
      {
      case 3: 
      case 5: 
      default: 
        locallf.swS = 2;
        if (locallf.sGT == 3) {
          locallf.swS = 4;
        }
        y.i(l.f(this.ept), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramString, Integer.valueOf(locallf.sGG), Integer.valueOf(locallf.sGH), locallf.svK, locallf.kWm, locallf.sGQ, Long.valueOf(l.c(this.ept)), Long.valueOf(l.D(this.ept)), ((e)localObject1).enq, localObject2, Integer.valueOf(locallf.sGS), Integer.valueOf(locallf.sGT), Integer.valueOf(locallf.swS) });
        paramString = new b.a();
        paramString.ecH = locallf;
        paramString.ecI = new cbi();
        paramString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        paramString.ecG = 625;
        paramString.ecJ = 9;
        paramString.ecK = 1000000009;
        localObject1 = paramString.Kt();
        localObject2 = l.E(this.ept).KR();
        str = l.f(this.ept);
        if (localObject2 != null) {
          break;
        }
      }
    }
    for (paramString = "acc == null";; paramString = Boolean.valueOf(((com.tencent.mm.network.c)localObject2).KN()))
    {
      y.i(str, "getCdnAuthInfo login:%s", new Object[] { paramString });
      if ((localObject2 == null) || (!((com.tencent.mm.network.c)localObject2).KN())) {
        break label747;
      }
      if (!t.a(((com.tencent.mm.network.c)localObject2).Dj(), ((com.tencent.mm.network.c)localObject2).KM(), ((com.tencent.mm.network.c)localObject2).KO(), ((com.tencent.mm.ah.b)localObject1).Kv(), paramByteArrayOutputStream, ((com.tencent.mm.network.c)localObject2).KP())) {
        break label721;
      }
      y.d(l.f(this.ept), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { locallf.sGF });
      return;
      i = 1;
      break;
      locallf.swS = 1;
      break label326;
      locallf.swS = 3;
      break label326;
      locallf.swS = 5;
      break label326;
    }
    label721:
    y.e(l.f(this.ept), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { locallf.sGF });
    return;
    label747:
    y.e(l.f(this.ept), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { locallf.sGF });
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    PInt localPInt = new PInt();
    lg locallg = new lg();
    try
    {
      paramArrayOfByte = v.a(paramArrayOfByte, com.tencent.mm.kernel.g.DO().dJT.edx.KR().Dj(), localPInt, locallg);
      y.i(l.f(this.ept), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { locallg.sGQ, locallg.sGU, locallg.sGF });
      l.b(this.ept, locallg.sGQ);
      y.i(l.f(this.ept), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramString, Integer.valueOf(localPInt.value) });
      return paramArrayOfByte;
    }
    catch (Exception paramString)
    {
      y.e(l.f(this.ept), "decodePrepareResponse Exception:%s", new Object[] { paramString });
      l.b(this.ept, null);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.as.l.4
 * JD-Core Version:    0.7.0.1
 */