package com.tencent.mm.plugin.fav.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.a.a;
import com.tencent.mm.plugin.fav.a.a.b;
import com.tencent.mm.plugin.fav.a.a.c;
import com.tencent.mm.plugin.fav.a.a.d;
import com.tencent.mm.plugin.i.a.e;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.akw;
import com.tencent.mm.protocal.protobuf.ala;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class g
  extends com.tencent.mm.g.c.bx
{
  public static c.a info;
  private static g.a rAC;
  private static g.a rAD;
  public String dtQ;
  public g rAA;
  public String rAB;
  public boolean rAz;
  
  static
  {
    AppMethodBeat.i(103387);
    info = com.tencent.mm.g.c.bx.VD();
    rAC = new g.1();
    rAD = new g.2();
    AppMethodBeat.o(103387);
  }
  
  public g()
  {
    AppMethodBeat.i(103372);
    this.rAz = false;
    this.rAA = null;
    this.dtQ = "";
    this.rAB = "";
    this.field_flag = -1;
    this.field_fromUser = "";
    this.field_toUser = "";
    this.field_id = -1;
    this.field_realChatName = "";
    this.field_sourceType = -1;
    this.field_updateTime = -1L;
    this.field_type = -1;
    this.field_updateSeq = -1;
    this.field_xml = "";
    this.field_itemStatus = 0;
    cwq();
    AppMethodBeat.o(103372);
  }
  
  private static void a(String paramString, g.a parama, ake paramake)
  {
    AppMethodBeat.i(103380);
    if (paramake == null)
    {
      AppMethodBeat.o(103380);
      return;
    }
    parama.log(paramString + " ----loc item----");
    parama.log(paramString + "  lng: " + paramake.lng);
    parama.log(paramString + "  lat: " + paramake.lat);
    parama.log(paramString + "  scale: " + paramake.dzG);
    parama.log(paramString + "  label: " + paramake.label);
    parama.log(paramString + "  poiname: " + paramake.dEv);
    AppMethodBeat.o(103380);
  }
  
  private static void a(String paramString, g.a parama, akh paramakh)
  {
    AppMethodBeat.i(103378);
    if (paramakh == null)
    {
      AppMethodBeat.o(103378);
      return;
    }
    parama.log(paramString + " ----noteInfoItem item----");
    parama.log(paramString + "  author: " + paramakh.GBX);
    parama.log(paramString + "  editor: " + paramakh.GBY);
    AppMethodBeat.o(103378);
  }
  
  private static void a(String paramString, g.a parama, akm paramakm)
  {
    AppMethodBeat.i(103379);
    if (paramakm == null)
    {
      AppMethodBeat.o(103379);
      return;
    }
    parama.log(paramString + " ----product item----");
    parama.log(paramString + "  title: " + paramakm.title);
    parama.log(paramString + "  desc: " + paramakm.desc);
    parama.log(paramString + "  thumbUrl: " + paramakm.thumbUrl);
    parama.log(paramString + "  type: " + paramakm.type);
    AppMethodBeat.o(103379);
  }
  
  private static void a(String paramString, g.a parama, akw paramakw)
  {
    AppMethodBeat.i(103377);
    if (paramakw == null)
    {
      AppMethodBeat.o(103377);
      return;
    }
    parama.log(paramString + " ----tv item----");
    parama.log(paramString + "  title: " + paramakw.title);
    parama.log(paramString + "  desc: " + paramakw.desc);
    parama.log(paramString + "  thumbUrl: " + paramakw.thumbUrl);
    AppMethodBeat.o(103377);
  }
  
  private static void a(String paramString, g.a parama, alc paramalc)
  {
    AppMethodBeat.i(103381);
    if (paramalc == null)
    {
      AppMethodBeat.o(103381);
      return;
    }
    parama.log(paramString + " ----url item----");
    parama.log(paramString + "  title: " + paramalc.title);
    parama.log(paramString + "  desc: " + paramalc.desc);
    parama.log(paramString + "  cleanUrl: " + paramalc.GCG);
    parama.log(paramString + "  thumbUrl: " + paramalc.thumbUrl);
    parama.log(paramString + "  opencache: " + paramalc.GCI);
    parama.log(paramString + "  topstory: " + paramalc.GCL);
    AppMethodBeat.o(103381);
  }
  
  private void cwq()
  {
    AppMethodBeat.i(103373);
    this.field_favProto = new akn();
    akt localakt = new akt();
    localakt.aax(1);
    this.field_favProto.a(localakt);
    this.field_favProto.b(new alc());
    this.field_favProto.f(new akf());
    this.field_favProto.d(new ake());
    this.field_favProto.b(new akm());
    this.field_favProto.b(new akw());
    this.field_favProto.d(new ary());
    this.field_favProto.aav(-1);
    this.field_tagProto = new ala();
    this.field_favProto.a(new akh());
    AppMethodBeat.o(103373);
  }
  
  public static String t(g paramg)
  {
    AppMethodBeat.i(103383);
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append("<favitem");
    localStringBuffer1.append(" type='").append(paramg.field_type).append("'");
    localStringBuffer1.append(">");
    Object localObject2 = paramg.field_favProto;
    StringBuilder localStringBuilder = new StringBuilder();
    if (!bu.isNullOrNil(((akn)localObject2).title)) {
      localStringBuilder.append("<title>").append(bu.aSz(((akn)localObject2).title)).append("</title>");
    }
    if (!bu.isNullOrNil(((akn)localObject2).desc)) {
      localStringBuilder.append("<desc>").append(bu.aSz(((akn)localObject2).desc)).append("</desc>");
    }
    if (((akn)localObject2).pWN > 0L) {
      localStringBuilder.append("<edittime>").append(((akn)localObject2).pWN).append("</edittime>");
    }
    if ((((akn)localObject2).FId != null) && (!bu.isNullOrNil(((akn)localObject2).FId.GBY))) {
      localStringBuilder.append("<editusr>").append(((akn)localObject2).FId.GBY).append("</editusr>");
    }
    if (!bu.isNullOrNil(((akn)localObject2).iWF))
    {
      localStringBuilder.append("<remark ");
      if (((akn)localObject2).GBm > 0L) {
        localStringBuilder.append(" time ='").append(((akn)localObject2).GBm).append("'");
      }
      localStringBuilder.append(">").append(bu.aSz(((akn)localObject2).iWF)).append("</remark>");
    }
    if (((akn)localObject2).GBp) {
      localStringBuilder.append("<ctrlflag>").append(((akn)localObject2).GBo).append("</ctrlflag>");
    }
    if (((akn)localObject2).GCh)
    {
      localStringBuilder.append("<version>").append(((akn)localObject2).version).append("</version>");
      localObject1 = ((akn)localObject2).GCe;
      if ((localObject1 != null) && (((akt)localObject1).computeSize() != 0)) {
        break label679;
      }
      ae.w("MicroMsg.FavSourceItemParser", "klem toXml, source item empty");
      localObject1 = "";
      label381:
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(a.dq(((akn)localObject2).oeJ));
      localObject1 = paramg.field_favProto.GBd;
      if ((localObject1 != null) && (((ake)localObject1).computeSize() != 0)) {
        break label1029;
      }
      ae.d("MicroMsg.FavLocItemParser", "klem toXml, loc item empty");
      localObject1 = "";
      label431:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.GBf;
      if ((localObject1 != null) && (((alc)localObject1).computeSize() != 0)) {
        break label1213;
      }
      ae.d("MicroMsg.FavUrlItemParser", "klem toXml, url item empty");
      localObject1 = "";
      label468:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.GBh;
      if ((localObject1 != null) && (((akm)localObject1).computeSize() != 0)) {
        break label1512;
      }
      ae.d("MicroMsg.FavProductItemParser", "klem toXml, product item empty");
      localObject1 = "";
      label505:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.GBj;
      if ((localObject1 != null) && (((akw)localObject1).computeSize() != 0)) {
        break label1714;
      }
      ae.d("MicroMsg.FavTVItemParser", "klem toXml, product item empty");
      localObject1 = "";
      label542:
      localStringBuilder.append((String)localObject1);
      localObject1 = ((akn)localObject2).FId;
      if ((localObject1 != null) && (((akh)localObject1).computeSize() != 0)) {
        break label1878;
      }
      ae.w("MicroMsg.FavNoteInfoItemParser", "klem toXml, source item empty");
      localObject1 = "";
      label577:
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(e.b(((akn)localObject2).GBx));
      localObject1 = paramg.field_favProto.GBs;
      if (localObject1 != null) {
        break label1964;
      }
    }
    for (Object localObject1 = "";; localObject1 = ((StringBuilder)localObject2).toString())
    {
      localStringBuilder.append((String)localObject1);
      localStringBuffer1.append(localStringBuilder.toString());
      localStringBuffer1.append(d.a(paramg.field_tagProto));
      localStringBuffer1.append("</favitem>");
      paramg = localStringBuffer1.toString();
      AppMethodBeat.o(103383);
      return paramg;
      if (paramg.field_type != 18) {
        break;
      }
      localStringBuilder.append("<version>1</version>");
      break;
      label679:
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<source");
      if (((akt)localObject1).GBz) {
        localStringBuffer2.append(" sourcetype='").append(((akt)localObject1).sourceType).append("'");
      }
      if (((akt)localObject1).GCn) {
        localStringBuffer2.append(" sourceid='").append(((akt)localObject1).GCm).append("'");
      }
      localStringBuffer2.append(">");
      if (((akt)localObject1).GBA) {
        localStringBuffer2.append("<fromusr>").append(bu.aSz(((akt)localObject1).dzZ)).append("</fromusr>");
      }
      if (((akt)localObject1).GBB) {
        localStringBuffer2.append("<tousr>").append(bu.aSz(((akt)localObject1).toUser)).append("</tousr>");
      }
      if (((akt)localObject1).GBF) {
        localStringBuffer2.append("<realchatname>").append(bu.aSz(((akt)localObject1).GBE)).append("</realchatname>");
      }
      if (((akt)localObject1).GBG) {
        localStringBuffer2.append("<msgid>").append(((akt)localObject1).msgId).append("</msgid>");
      }
      if (((akt)localObject1).GBH) {
        localStringBuffer2.append("<eventid>").append(((akt)localObject1).dLO).append("</eventid>");
      }
      if (((akt)localObject1).GBI) {
        localStringBuffer2.append("<appid>").append(((akt)localObject1).appId).append("</appid>");
      }
      if (((akt)localObject1).GBJ) {
        localStringBuffer2.append("<link>").append(bu.aSz(((akt)localObject1).link)).append("</link>");
      }
      if (((akt)localObject1).GBM) {
        localStringBuffer2.append("<brandid>").append(bu.aSz(((akt)localObject1).dkZ)).append("</brandid>");
      }
      localStringBuffer2.append("</source>");
      localObject1 = localStringBuffer2.toString();
      break label381;
      label1029:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<locitem>");
      if (((ake)localObject1).GBU) {
        localStringBuffer2.append("<label>").append(bu.aSz(((ake)localObject1).label)).append("</label>");
      }
      if (((ake)localObject1).GBS) {
        localStringBuffer2.append("<lat>").append(((ake)localObject1).lat).append("</lat>");
      }
      if (((ake)localObject1).GBR) {
        localStringBuffer2.append("<lng>").append(((ake)localObject1).lng).append("</lng>");
      }
      if (((ake)localObject1).GBT) {
        localStringBuffer2.append("<scale>").append(((ake)localObject1).dzG).append("</scale>");
      }
      if (((ake)localObject1).GBV) {
        localStringBuffer2.append("<poiname>").append(((ake)localObject1).dEv).append("</poiname>");
      }
      localStringBuffer2.append("</locitem>");
      localObject1 = localStringBuffer2.toString();
      break label431;
      label1213:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<weburlitem>");
      if (((alc)localObject1).GCH) {
        localStringBuffer2.append("<clean_url>").append(bu.aSz(((alc)localObject1).GCG)).append("</clean_url>");
      }
      if (((alc)localObject1).Gzu) {
        localStringBuffer2.append("<pagedesc>").append(bu.aSz(((alc)localObject1).desc)).append("</pagedesc>");
      }
      if (((alc)localObject1).GCb) {
        localStringBuffer2.append("<pagethumb_url>").append(bu.aSz(((alc)localObject1).thumbUrl)).append("</pagethumb_url>");
      }
      if (((alc)localObject1).Gzt) {
        localStringBuffer2.append("<pagetitle>").append(bu.aSz(((alc)localObject1).title)).append("</pagetitle>");
      }
      if (((alc)localObject1).GCJ) {
        localStringBuffer2.append("<opencache>").append(((alc)localObject1).GCI).append("</opencache>");
      }
      if (((alc)localObject1).GCK) {
        localStringBuffer2.append("<contentattr>").append(((alc)localObject1).hCH).append("</contentattr>");
      }
      if (((alc)localObject1).GAF) {
        localStringBuffer2.append("<canvasPageXml>").append(((alc)localObject1).canvasPageXml).append("</canvasPageXml>");
      }
      if (((alc)localObject1).GCN) {
        localStringBuffer2.append("<wsVideoFlowXml>").append(bu.aSz(((alc)localObject1).GCL)).append("</wsVideoFlowXml>");
      }
      localStringBuffer2.append(b.a(paramg.field_favProto.Ekw));
      localStringBuffer2.append("</weburlitem>");
      localObject1 = localStringBuffer2.toString();
      break label468;
      label1512:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<productitem");
      if (((akm)localObject1).GCd) {
        localStringBuffer2.append(" type='").append(((akm)localObject1).type).append("'");
      }
      localStringBuffer2.append(">");
      if (((akm)localObject1).Gzt) {
        localStringBuffer2.append("<producttitle>").append(bu.aSz(((akm)localObject1).title)).append("</producttitle>");
      }
      if (((akm)localObject1).Gzu) {
        localStringBuffer2.append("<productdesc>").append(bu.aSz(((akm)localObject1).desc)).append("</productdesc>");
      }
      if (((akm)localObject1).GCb) {
        localStringBuffer2.append("<productthumb_url>").append(bu.aSz(((akm)localObject1).thumbUrl)).append("</productthumb_url>");
      }
      if (((akm)localObject1).GCc) {
        localStringBuffer2.append("<productinfo>").append(bu.aSz(((akm)localObject1).info)).append("</productinfo>");
      }
      localStringBuffer2.append("</productitem>");
      localObject1 = localStringBuffer2.toString();
      break label505;
      label1714:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<tvitem>");
      if (((akw)localObject1).Gzt) {
        localStringBuffer2.append("<tvtitle>").append(bu.aSz(((akw)localObject1).title)).append("</tvtitle>");
      }
      if (((akw)localObject1).Gzu) {
        localStringBuffer2.append("<tvdesc>").append(bu.aSz(((akw)localObject1).desc)).append("</tvdesc>");
      }
      if (((akw)localObject1).GCb) {
        localStringBuffer2.append("<tvthumb_url>").append(bu.aSz(((akw)localObject1).thumbUrl)).append("</tvthumb_url>");
      }
      if (((akw)localObject1).GCc) {
        localStringBuffer2.append("<tvinfo>").append(bu.aSz(((akw)localObject1).info)).append("</tvinfo>");
      }
      localStringBuffer2.append("</tvitem>");
      localObject1 = localStringBuffer2.toString();
      break label542;
      label1878:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<noteinfo>");
      localStringBuffer2.append("<noteauthor>").append(bu.aSz(((akh)localObject1).GBX)).append("</noteauthor>");
      localStringBuffer2.append("<noteeditor>").append(bu.aSz(((akh)localObject1).GBY)).append("</noteeditor>");
      localStringBuffer2.append("</noteinfo>");
      localObject1 = localStringBuffer2.toString();
      break label577;
      label1964:
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<appbranditem>");
      ((StringBuilder)localObject2).append("<username>").append(bu.aSz(((ajv)localObject1).username)).append("</username>");
      ((StringBuilder)localObject2).append("<appid>").append(bu.aSz(((ajv)localObject1).appId)).append("</appid>");
      ((StringBuilder)localObject2).append("<pkgtype>").append(((ajv)localObject1).duK).append("</pkgtype>");
      ((StringBuilder)localObject2).append("<iconurl>").append(bu.aSz(((ajv)localObject1).iconUrl)).append("</iconurl>");
      ((StringBuilder)localObject2).append("<type>").append(((ajv)localObject1).type).append("</type>");
      ((StringBuilder)localObject2).append("<pagepath>").append(bu.aSz(((ajv)localObject1).dlk)).append("</pagepath>");
      ((StringBuilder)localObject2).append("<sourcedisplayname>").append(bu.aSz(((ajv)localObject1).Gzq)).append("</sourcedisplayname>");
      ((StringBuilder)localObject2).append("<version>").append(((ajv)localObject1).version).append("</version>");
      ((StringBuilder)localObject2).append("<disableforward>").append(((ajv)localObject1).kuE).append("</disableforward>");
      ((StringBuilder)localObject2).append("<tradingguaranteeflag>").append(((ajv)localObject1).kaX).append("</tradingguaranteeflag>");
      ((StringBuilder)localObject2).append("<messageextradata>").append(String.format("<![CDATA[%s]]>", new Object[] { ((ajv)localObject1).dLl })).append("</messageextradata>");
      ((StringBuilder)localObject2).append("<subtype>").append(((ajv)localObject1).subType).append("</subtype>");
      ((StringBuilder)localObject2).append("</appbranditem>");
    }
  }
  
  public final g ahi(String paramString)
  {
    AppMethodBeat.i(103375);
    if ((paramString == null) || (paramString.equals("")))
    {
      ae.e("MicroMsg.FavItemInfo", "klem, FavItemInfo xml null");
      AppMethodBeat.o(103375);
      return this;
    }
    Map localMap = com.tencent.mm.sdk.platformtools.bx.M(paramString, "favitem");
    if (localMap == null)
    {
      ae.e("MicroMsg.FavItemInfo", "klem, FavItemInfo maps null");
      AppMethodBeat.o(103375);
      return this;
    }
    for (;;)
    {
      try
      {
        cwq();
        akn localakn = this.field_favProto;
        localakn.aQA((String)localMap.get(".favitem.title"));
        localakn.aQB((String)localMap.get(".favitem.desc"));
        localakn.aQz((String)localMap.get(".favitem.remark"));
        localakn.Di(bu.getLong((String)localMap.get(".favitem.remark.$time"), 0L));
        localObject = (String)localMap.get(".favitem.edittime");
        localakn.aaw(bu.getInt((String)localMap.get(".favitem.version"), 0));
        localakn.Dj(bu.getLong((String)localObject, 0L));
        localakn.aav(bu.getInt((String)localMap.get(".favitem.ctrlflag"), -1));
        localObject = localakn.GCe;
        ((akt)localObject).aax(bu.getInt((String)localMap.get(".favitem.source" + ".$sourcetype"), 0));
        ((akt)localObject).aQE((String)localMap.get(".favitem.source" + ".$sourceid"));
        ((akt)localObject).aQC((String)localMap.get(".favitem.source" + ".fromusr"));
        ((akt)localObject).aQD((String)localMap.get(".favitem.source" + ".tousr"));
        ((akt)localObject).aQF((String)localMap.get(".favitem.source" + ".realchatname"));
        ((akt)localObject).Dk(bu.getLong((String)localMap.get(".favitem.source" + ".createtime"), 0L));
        ((akt)localObject).aQG((String)localMap.get(".favitem.source" + ".msgid"));
        ((akt)localObject).aQH((String)localMap.get(".favitem.source" + ".eventid"));
        ((akt)localObject).aQI((String)localMap.get(".favitem.source" + ".appid"));
        ((akt)localObject).aQJ((String)localMap.get(".favitem.source" + ".link"));
        ((akt)localObject).aQK((String)localMap.get(".favitem.source" + ".brandid"));
        c.a(paramString, localakn);
        paramString = localakn.GBd;
        if (!bu.isNullOrNil((String)localMap.get(".favitem.locitem" + ".label"))) {
          paramString.aQt((String)localMap.get(".favitem.locitem" + ".label"));
        }
        if (!bu.isNullOrNil((String)localMap.get(".favitem.locitem" + ".poiname"))) {
          paramString.aQu((String)localMap.get(".favitem.locitem" + ".poiname"));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".lng");
        if (!bu.isNullOrNil((String)localObject)) {
          paramString.A(bu.getDouble((String)localObject, 0.0D));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".lat");
        if (!bu.isNullOrNil((String)localObject)) {
          paramString.B(bu.getDouble((String)localObject, 0.0D));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".scale");
        if (!bu.isNullOrNil((String)localObject))
        {
          if (((String)localObject).indexOf('.') == -1) {
            continue;
          }
          paramString.aat(bu.getInt(((String)localObject).substring(0, ((String)localObject).indexOf('.')), -1));
        }
        paramString = localakn.GBf;
        paramString.aQR((String)localMap.get(".favitem.weburlitem" + ".clean_url"));
        paramString.aQQ((String)localMap.get(".favitem.weburlitem" + ".pagedesc"));
        paramString.aQS((String)localMap.get(".favitem.weburlitem" + ".pagethumb_url"));
        paramString.aQP((String)localMap.get(".favitem.weburlitem" + ".pagetitle"));
        paramString.aay(bu.getInt((String)localMap.get(".favitem.weburlitem" + ".opencache"), 0));
        paramString.aaz(bu.getInt((String)localMap.get(".favitem.weburlitem" + ".contentattr"), 0));
        paramString.aQT((String)localMap.get(".favitem.weburlitem" + ".canvasPageXml"));
        paramString.aQU((String)localMap.get(".favitem.weburlitem" + ".wsVideoFlowXml"));
        localakn.d(e.w(".favitem", localMap));
        if (localakn.Ekw != null) {
          localakn.f(b.u(".favitem.weburlitem.appmsgshareitem", localMap));
        }
        paramString = localakn.GBh;
        paramString.aQv((String)localMap.get(".favitem.productitem" + ".producttitle"));
        paramString.aQw((String)localMap.get(".favitem.productitem" + ".productdesc"));
        paramString.aQx((String)localMap.get(".favitem.productitem" + ".productthumb_url"));
        paramString.aQy((String)localMap.get(".favitem.productitem" + ".productinfo"));
        paramString.aau(bu.getInt((String)localMap.get(".favitem.productitem" + ".$type"), 0));
        paramString = localakn.GBj;
        paramString.aQL((String)localMap.get(".favitem.tvitem" + ".tvtitle"));
        paramString.aQM((String)localMap.get(".favitem.tvitem" + ".tvdesc"));
        paramString.aQN((String)localMap.get(".favitem.tvitem" + ".tvthumb_url"));
        paramString.aQO((String)localMap.get(".favitem.tvitem" + ".tvinfo"));
        paramString = localakn.FId;
        paramString.GBX = ((String)localMap.get(".favitem.noteinfo" + ".noteauthor"));
        paramString.GBY = ((String)localMap.get(".favitem.noteinfo" + ".noteeditor"));
        if (localMap.containsKey(".favitem.appbranditem"))
        {
          paramString = new ajv();
          paramString.username = ((String)localMap.get(".favitem.appbranditem" + ".username"));
          paramString.appId = ((String)localMap.get(".favitem.appbranditem" + ".appid"));
          paramString.duK = bu.getInt((String)localMap.get(".favitem.appbranditem" + ".pkgtype"), 0);
          paramString.iconUrl = ((String)localMap.get(".favitem.appbranditem" + ".iconurl"));
          paramString.type = bu.getInt((String)localMap.get(".favitem.appbranditem" + ".type"), 0);
          paramString.dlk = ((String)localMap.get(".favitem.appbranditem" + ".pagepath"));
          paramString.Gzq = ((String)localMap.get(".favitem.appbranditem" + ".sourcedisplayname"));
          paramString.version = bu.getInt((String)localMap.get(".favitem.appbranditem" + ".version"), 0);
          paramString.kuE = bu.getInt((String)localMap.get(".favitem.appbranditem" + ".disableforward"), 0);
          paramString.kaX = bu.getInt((String)localMap.get(".favitem.appbranditem" + ".tradingguaranteeflag"), 0);
          paramString.dLl = ((String)localMap.get(".favitem.appbranditem" + ".messageextradata"));
          paramString.subType = bu.getInt((String)localMap.get(".favitem.appbranditem" + ".subtype"), 0);
          localakn.c(paramString);
        }
        if (localakn.Ekw != null) {
          localakn.f(b.u(".favitem.weburlitem.appmsgshareitem", localMap));
        }
        if (this.field_favProto.GCe != null)
        {
          paramString = this.field_favProto.GCe;
          this.field_sourceId = paramString.GCm;
          this.field_sourceType = paramString.sourceType;
          this.field_fromUser = paramString.dzZ;
          this.field_toUser = paramString.toUser;
        }
        this.field_edittime = this.field_favProto.pWN;
        d.a(localMap, this.field_tagProto);
      }
      catch (Exception paramString)
      {
        Object localObject;
        ae.printErrStackTrace("MicroMsg.FavItemInfo", paramString, "", new Object[0]);
        ae.e("MicroMsg.FavItemInfo", "klem , FavItemInfo exception:+%s", new Object[] { paramString.toString() });
        continue;
      }
      AppMethodBeat.o(103375);
      return this;
      paramString.aat(bu.getInt((String)localObject, -1));
    }
  }
  
  public final void ahj(String paramString)
  {
    AppMethodBeat.i(103376);
    g.a locala = rAC;
    locala.log("----dump favitem from[" + paramString + "] beg----");
    locala.log("type: " + this.field_type);
    locala.log("favId: " + this.field_id);
    locala.log("localId: " + this.field_localId);
    locala.log("itemStatus: " + this.field_itemStatus);
    locala.log("localSeq: " + this.field_localSeq);
    locala.log("updateSeq: " + this.field_updateSeq);
    locala.log("ctrlFlag: " + this.field_flag);
    locala.log("sourceId: " + this.field_sourceId);
    locala.log("sourceType: " + this.field_sourceType);
    locala.log("sourceCreateTime: " + this.field_sourceCreateTime);
    locala.log("updateTime: " + this.field_updateTime);
    locala.log("editTime: " + this.field_edittime);
    locala.log("fromuser: " + this.field_fromUser);
    locala.log("toUser: " + this.field_toUser);
    locala.log("realChatName: " + this.field_realChatName);
    if (this.field_favProto != null)
    {
      locala.log("remarktime: " + this.field_favProto.GBm);
      locala.log("dataitemCount: " + this.field_favProto.oeJ.size());
      if (this.field_favProto.GCe != null)
      {
        locala.log(" ----source item----");
        paramString = this.field_favProto.GCe;
        locala.log("  sourceType: " + paramString.sourceType);
        locala.log("  fromUser: " + paramString.dzZ);
        locala.log("  toUser: " + paramString.toUser);
        locala.log("  sourceId: " + paramString.GCm);
        locala.log("  realChatName: " + paramString.GBE);
        locala.log("  createTime: " + paramString.createTime);
        locala.log("  msgId: " + paramString.msgId);
        locala.log("  eventId: " + paramString.dLO);
        locala.log("  appId: " + paramString.appId);
        locala.log("  link: " + paramString.link);
        locala.log("  mediaId: " + paramString.GBK);
        locala.log("  brandId: " + paramString.dkZ);
      }
      paramString = this.field_favProto.oeJ.iterator();
      int i = 0;
      while (paramString.hasNext())
      {
        ajx localajx = (ajx)paramString.next();
        locala.log(" ----data item " + i + "----");
        locala.log("  dataId: " + localajx.dua);
        locala.log("  dataType: " + localajx.dataType);
        locala.log("  dataSouceId: " + localajx.GAi);
        locala.log("  svrDataStatus: " + localajx.GAq);
        locala.log("  cdnThumbUrl: " + localajx.hCS);
        locala.log("  cdnThumbKey: " + localajx.Gzw);
        locala.log("  cdnDataUrl: " + localajx.GzA);
        locala.log("  cdnDataKey: " + localajx.GzC);
        locala.log("  cdnEncryVer: " + localajx.GzE);
        locala.log("  fullmd5: " + localajx.GzR);
        locala.log("  head256md5: " + localajx.GzT);
        locala.log("  fullsize: " + localajx.GzV);
        locala.log("  thumbMd5: " + localajx.GAc);
        locala.log("  thumbHead256md5: " + localajx.GAe);
        locala.log("  thumbfullsize: " + localajx.GAg);
        locala.log("  duration: " + localajx.duration);
        locala.log("  datafmt: " + localajx.GzP);
        locala.log("  streamWebUrl: " + localajx.GzH);
        locala.log("  streamDataUrl: " + localajx.GzJ);
        locala.log("  streamLowBandUrl: " + localajx.GzL);
        locala.log("  ext: " + localajx.dox);
        locala.log("  msgUuid: " + localajx.ixk);
        if (localajx.GAu != null)
        {
          locala.log("  remarktime: " + localajx.GAu.GBm);
          locala.log("  ctrlflag: " + localajx.GAu.GBo);
          locala.log("  edittime: " + localajx.GAu.pWN);
          if (localajx.GAu.GBb != null)
          {
            locala.log("   ----data source item----");
            ajz localajz = localajx.GAu.GBb;
            locala.log("    sourceType: " + localajz.sourceType);
            locala.log("    fromUser: " + localajz.dzZ);
            locala.log("    toUser: " + localajz.toUser);
            locala.log("    realChatName: " + localajz.GBE);
            locala.log("    createTime: " + localajz.createTime);
            locala.log("    msgId: " + localajz.msgId);
            locala.log("    eventId: " + localajz.dLO);
            locala.log("    appId: " + localajz.appId);
            locala.log("    link: " + localajz.link);
            locala.log("    mediaId: " + localajz.GBK);
            locala.log("    brandId: " + localajz.dkZ);
          }
          a("  ", locala, localajx.GAu.GBd);
          a("  ", locala, localajx.GAu.GBf);
          a("  ", locala, localajx.GAu.GBh);
          a("  ", locala, localajx.GAu.GBj);
          a("  ", locala, localajx.GAu.FId);
        }
        i += 1;
      }
      a("", locala, this.field_favProto.GBd);
      a("", locala, this.field_favProto.GBf);
      a("", locala, this.field_favProto.GBh);
      a("", locala, this.field_favProto.GBj);
      a("  ", locala, this.field_favProto.FId);
    }
    locala.log("----dump favitem end----");
    AppMethodBeat.o(103376);
  }
  
  public final boolean ahk(String paramString)
  {
    AppMethodBeat.i(103382);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103382);
      return false;
    }
    Iterator localIterator = this.field_tagProto.GCs.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equals((String)localIterator.next()))
      {
        AppMethodBeat.o(103382);
        return false;
      }
    }
    this.field_tagProto.GCs.add(paramString);
    AppMethodBeat.o(103382);
    return true;
  }
  
  public final boolean cwr()
  {
    return (this.field_favProto.GBo & 0x1) != 0;
  }
  
  public final boolean cws()
  {
    return (this.field_favProto.GBo & 0x2) != 0;
  }
  
  public final Bundle cwt()
  {
    AppMethodBeat.i(103374);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_ctrl_flag_open_chat", cwr());
    localBundle.putBoolean("key_ctrl_flag_open_sns", cws());
    if ((this.field_favProto.GBo & 0x4) != 0)
    {
      bool = true;
      localBundle.putBoolean("key_ctrl_flag_open_weibo", bool);
      if ((this.field_favProto.GBo & 0x8) == 0) {
        break label183;
      }
      bool = true;
      label73:
      localBundle.putBoolean("key_ctrl_flag_open_cplink", bool);
      if ((this.field_favProto.GBo & 0x10) == 0) {
        break label188;
      }
      bool = true;
      label96:
      localBundle.putBoolean("key_ctrl_flag_open_browser", bool);
      if ((this.field_favProto.GBo & 0x20) == 0) {
        break label193;
      }
      bool = true;
      label119:
      localBundle.putBoolean("key_ctrl_flag_open_weiyun", bool);
      if ((this.field_favProto.GBo & 0x40) == 0) {
        break label198;
      }
    }
    label183:
    label188:
    label193:
    label198:
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("key_ctrl_flag_open_facebook", bool);
      ae.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", new Object[] { localBundle.toString() });
      AppMethodBeat.o(103374);
      return localBundle;
      bool = false;
      break;
      bool = false;
      break label73;
      bool = false;
      break label96;
      bool = false;
      break label119;
    }
  }
  
  public final boolean cwu()
  {
    return (this.field_itemStatus == 1) || (this.field_itemStatus == 4) || (this.field_itemStatus == 9) || (this.field_itemStatus == 12) || (this.field_itemStatus == 13) || (this.field_itemStatus == 15) || (this.field_itemStatus == 17);
  }
  
  public final boolean cwv()
  {
    return this.field_itemStatus == 8;
  }
  
  public final boolean cww()
  {
    return (this.field_itemStatus == 15) || (this.field_itemStatus == 16);
  }
  
  public final boolean cwx()
  {
    return (this.field_itemStatus == 12) || (this.field_itemStatus == 13) || (this.field_itemStatus == 14);
  }
  
  public final g cwy()
  {
    AppMethodBeat.i(103384);
    g localg = new g();
    localg.field_favProto = this.field_favProto;
    localg.field_sourceId = this.field_sourceId;
    localg.field_edittime = this.field_edittime;
    localg.field_ext = this.field_ext;
    localg.field_flag = this.field_flag;
    localg.field_fromUser = this.field_fromUser;
    localg.field_id = this.field_id;
    localg.field_itemStatus = this.field_itemStatus;
    localg.field_localId = this.field_localId;
    localg.field_localSeq = this.field_localSeq;
    localg.field_realChatName = this.field_realChatName;
    localg.field_tagProto = this.field_tagProto;
    localg.field_sourceCreateTime = this.field_sourceCreateTime;
    localg.field_updateSeq = this.field_updateSeq;
    localg.field_toUser = this.field_toUser;
    localg.field_updateTime = this.field_updateTime;
    localg.field_type = this.field_type;
    localg.field_xml = this.field_xml;
    localg.field_datatotalsize = this.field_datatotalsize;
    localg.rAz = this.rAz;
    localg.rAA = this.rAA;
    localg.dtQ = this.dtQ;
    AppMethodBeat.o(103384);
    return localg;
  }
  
  public final boolean cwz()
  {
    AppMethodBeat.i(103385);
    Iterator localIterator = this.field_favProto.oeJ.iterator();
    while (localIterator.hasNext()) {
      if (((ajx)localIterator.next()).GAM != 0)
      {
        AppMethodBeat.o(103385);
        return true;
      }
    }
    AppMethodBeat.o(103385);
    return false;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final boolean isDone()
  {
    return this.field_itemStatus == 10;
  }
  
  public final boolean isDownloading()
  {
    return this.field_itemStatus == 7;
  }
  
  public final boolean isUploadFailed()
  {
    return (this.field_itemStatus == 3) || (this.field_itemStatus == 6) || (this.field_itemStatus == 11) || (this.field_itemStatus == 14) || (this.field_itemStatus == 16) || (this.field_itemStatus == 18);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.g
 * JD-Core Version:    0.7.0.1
 */