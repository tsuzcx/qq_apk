package com.tencent.mm.plugin.fav.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bx;
import com.tencent.mm.plugin.fav.a.a.a;
import com.tencent.mm.plugin.fav.a.a.b;
import com.tencent.mm.plugin.fav.a.a.c;
import com.tencent.mm.plugin.fav.a.a.d;
import com.tencent.mm.plugin.i.a.e;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akq;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class g
  extends bx
{
  public static c.a info;
  private static g.a rsp;
  private static g.a rsq;
  public String dsK;
  public boolean rsm;
  public g rsn;
  public String rso;
  
  static
  {
    AppMethodBeat.i(103387);
    info = bx.Vv();
    rsp = new g.1();
    rsq = new g.2();
    AppMethodBeat.o(103387);
  }
  
  public g()
  {
    AppMethodBeat.i(103372);
    this.rsm = false;
    this.rsn = null;
    this.dsK = "";
    this.rso = "";
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
    cuP();
    AppMethodBeat.o(103372);
  }
  
  private static void a(String paramString, g.a parama, aju paramaju)
  {
    AppMethodBeat.i(103380);
    if (paramaju == null)
    {
      AppMethodBeat.o(103380);
      return;
    }
    parama.log(paramString + " ----loc item----");
    parama.log(paramString + "  lng: " + paramaju.lng);
    parama.log(paramString + "  lat: " + paramaju.lat);
    parama.log(paramString + "  scale: " + paramaju.dyB);
    parama.log(paramString + "  label: " + paramaju.label);
    parama.log(paramString + "  poiname: " + paramaju.dDq);
    AppMethodBeat.o(103380);
  }
  
  private static void a(String paramString, g.a parama, ajx paramajx)
  {
    AppMethodBeat.i(103378);
    if (paramajx == null)
    {
      AppMethodBeat.o(103378);
      return;
    }
    parama.log(paramString + " ----noteInfoItem item----");
    parama.log(paramString + "  author: " + paramajx.Gjo);
    parama.log(paramString + "  editor: " + paramajx.Gjp);
    AppMethodBeat.o(103378);
  }
  
  private static void a(String paramString, g.a parama, akc paramakc)
  {
    AppMethodBeat.i(103379);
    if (paramakc == null)
    {
      AppMethodBeat.o(103379);
      return;
    }
    parama.log(paramString + " ----product item----");
    parama.log(paramString + "  title: " + paramakc.title);
    parama.log(paramString + "  desc: " + paramakc.desc);
    parama.log(paramString + "  thumbUrl: " + paramakc.thumbUrl);
    parama.log(paramString + "  type: " + paramakc.type);
    AppMethodBeat.o(103379);
  }
  
  private static void a(String paramString, g.a parama, akm paramakm)
  {
    AppMethodBeat.i(103377);
    if (paramakm == null)
    {
      AppMethodBeat.o(103377);
      return;
    }
    parama.log(paramString + " ----tv item----");
    parama.log(paramString + "  title: " + paramakm.title);
    parama.log(paramString + "  desc: " + paramakm.desc);
    parama.log(paramString + "  thumbUrl: " + paramakm.thumbUrl);
    AppMethodBeat.o(103377);
  }
  
  private static void a(String paramString, g.a parama, aks paramaks)
  {
    AppMethodBeat.i(103381);
    if (paramaks == null)
    {
      AppMethodBeat.o(103381);
      return;
    }
    parama.log(paramString + " ----url item----");
    parama.log(paramString + "  title: " + paramaks.title);
    parama.log(paramString + "  desc: " + paramaks.desc);
    parama.log(paramString + "  cleanUrl: " + paramaks.GjX);
    parama.log(paramString + "  thumbUrl: " + paramaks.thumbUrl);
    parama.log(paramString + "  opencache: " + paramaks.GjZ);
    parama.log(paramString + "  topstory: " + paramaks.Gkc);
    AppMethodBeat.o(103381);
  }
  
  private void cuP()
  {
    AppMethodBeat.i(103373);
    this.field_favProto = new akd();
    akj localakj = new akj();
    localakj.ZR(1);
    this.field_favProto.a(localakj);
    this.field_favProto.b(new aks());
    this.field_favProto.f(new ajv());
    this.field_favProto.d(new aju());
    this.field_favProto.b(new akc());
    this.field_favProto.b(new akm());
    this.field_favProto.d(new arj());
    this.field_favProto.ZP(-1);
    this.field_tagProto = new akq();
    this.field_favProto.a(new ajx());
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
    if (!bt.isNullOrNil(((akd)localObject2).title)) {
      localStringBuilder.append("<title>").append(bt.aRc(((akd)localObject2).title)).append("</title>");
    }
    if (!bt.isNullOrNil(((akd)localObject2).desc)) {
      localStringBuilder.append("<desc>").append(bt.aRc(((akd)localObject2).desc)).append("</desc>");
    }
    if (((akd)localObject2).pQi > 0L) {
      localStringBuilder.append("<edittime>").append(((akd)localObject2).pQi).append("</edittime>");
    }
    if ((((akd)localObject2).FpF != null) && (!bt.isNullOrNil(((akd)localObject2).FpF.Gjp))) {
      localStringBuilder.append("<editusr>").append(((akd)localObject2).FpF.Gjp).append("</editusr>");
    }
    if (!bt.isNullOrNil(((akd)localObject2).iTM))
    {
      localStringBuilder.append("<remark ");
      if (((akd)localObject2).GiD > 0L) {
        localStringBuilder.append(" time ='").append(((akd)localObject2).GiD).append("'");
      }
      localStringBuilder.append(">").append(bt.aRc(((akd)localObject2).iTM)).append("</remark>");
    }
    if (((akd)localObject2).GiG) {
      localStringBuilder.append("<ctrlflag>").append(((akd)localObject2).GiF).append("</ctrlflag>");
    }
    if (((akd)localObject2).Gjy)
    {
      localStringBuilder.append("<version>").append(((akd)localObject2).version).append("</version>");
      localObject1 = ((akd)localObject2).Gjv;
      if ((localObject1 != null) && (((akj)localObject1).computeSize() != 0)) {
        break label679;
      }
      ad.w("MicroMsg.FavSourceItemParser", "klem toXml, source item empty");
      localObject1 = "";
      label381:
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(a.dn(((akd)localObject2).nZa));
      localObject1 = paramg.field_favProto.Giu;
      if ((localObject1 != null) && (((aju)localObject1).computeSize() != 0)) {
        break label1029;
      }
      ad.d("MicroMsg.FavLocItemParser", "klem toXml, loc item empty");
      localObject1 = "";
      label431:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.Giw;
      if ((localObject1 != null) && (((aks)localObject1).computeSize() != 0)) {
        break label1213;
      }
      ad.d("MicroMsg.FavUrlItemParser", "klem toXml, url item empty");
      localObject1 = "";
      label468:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.Giy;
      if ((localObject1 != null) && (((akc)localObject1).computeSize() != 0)) {
        break label1512;
      }
      ad.d("MicroMsg.FavProductItemParser", "klem toXml, product item empty");
      localObject1 = "";
      label505:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.GiA;
      if ((localObject1 != null) && (((akm)localObject1).computeSize() != 0)) {
        break label1714;
      }
      ad.d("MicroMsg.FavTVItemParser", "klem toXml, product item empty");
      localObject1 = "";
      label542:
      localStringBuilder.append((String)localObject1);
      localObject1 = ((akd)localObject2).FpF;
      if ((localObject1 != null) && (((ajx)localObject1).computeSize() != 0)) {
        break label1878;
      }
      ad.w("MicroMsg.FavNoteInfoItemParser", "klem toXml, source item empty");
      localObject1 = "";
      label577:
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(e.b(((akd)localObject2).GiO));
      localObject1 = paramg.field_favProto.GiJ;
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
      if (((akj)localObject1).GiQ) {
        localStringBuffer2.append(" sourcetype='").append(((akj)localObject1).sourceType).append("'");
      }
      if (((akj)localObject1).GjE) {
        localStringBuffer2.append(" sourceid='").append(((akj)localObject1).GjD).append("'");
      }
      localStringBuffer2.append(">");
      if (((akj)localObject1).GiR) {
        localStringBuffer2.append("<fromusr>").append(bt.aRc(((akj)localObject1).dyU)).append("</fromusr>");
      }
      if (((akj)localObject1).GiS) {
        localStringBuffer2.append("<tousr>").append(bt.aRc(((akj)localObject1).toUser)).append("</tousr>");
      }
      if (((akj)localObject1).GiW) {
        localStringBuffer2.append("<realchatname>").append(bt.aRc(((akj)localObject1).GiV)).append("</realchatname>");
      }
      if (((akj)localObject1).GiX) {
        localStringBuffer2.append("<msgid>").append(((akj)localObject1).msgId).append("</msgid>");
      }
      if (((akj)localObject1).GiY) {
        localStringBuffer2.append("<eventid>").append(((akj)localObject1).dKz).append("</eventid>");
      }
      if (((akj)localObject1).GiZ) {
        localStringBuffer2.append("<appid>").append(((akj)localObject1).appId).append("</appid>");
      }
      if (((akj)localObject1).Gja) {
        localStringBuffer2.append("<link>").append(bt.aRc(((akj)localObject1).link)).append("</link>");
      }
      if (((akj)localObject1).Gjd) {
        localStringBuffer2.append("<brandid>").append(bt.aRc(((akj)localObject1).djX)).append("</brandid>");
      }
      localStringBuffer2.append("</source>");
      localObject1 = localStringBuffer2.toString();
      break label381;
      label1029:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<locitem>");
      if (((aju)localObject1).Gjl) {
        localStringBuffer2.append("<label>").append(bt.aRc(((aju)localObject1).label)).append("</label>");
      }
      if (((aju)localObject1).Gjj) {
        localStringBuffer2.append("<lat>").append(((aju)localObject1).lat).append("</lat>");
      }
      if (((aju)localObject1).Gji) {
        localStringBuffer2.append("<lng>").append(((aju)localObject1).lng).append("</lng>");
      }
      if (((aju)localObject1).Gjk) {
        localStringBuffer2.append("<scale>").append(((aju)localObject1).dyB).append("</scale>");
      }
      if (((aju)localObject1).Gjm) {
        localStringBuffer2.append("<poiname>").append(((aju)localObject1).dDq).append("</poiname>");
      }
      localStringBuffer2.append("</locitem>");
      localObject1 = localStringBuffer2.toString();
      break label431;
      label1213:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<weburlitem>");
      if (((aks)localObject1).GjY) {
        localStringBuffer2.append("<clean_url>").append(bt.aRc(((aks)localObject1).GjX)).append("</clean_url>");
      }
      if (((aks)localObject1).GgL) {
        localStringBuffer2.append("<pagedesc>").append(bt.aRc(((aks)localObject1).desc)).append("</pagedesc>");
      }
      if (((aks)localObject1).Gjs) {
        localStringBuffer2.append("<pagethumb_url>").append(bt.aRc(((aks)localObject1).thumbUrl)).append("</pagethumb_url>");
      }
      if (((aks)localObject1).GgK) {
        localStringBuffer2.append("<pagetitle>").append(bt.aRc(((aks)localObject1).title)).append("</pagetitle>");
      }
      if (((aks)localObject1).Gka) {
        localStringBuffer2.append("<opencache>").append(((aks)localObject1).GjZ).append("</opencache>");
      }
      if (((aks)localObject1).Gkb) {
        localStringBuffer2.append("<contentattr>").append(((aks)localObject1).hzT).append("</contentattr>");
      }
      if (((aks)localObject1).GhW) {
        localStringBuffer2.append("<canvasPageXml>").append(((aks)localObject1).canvasPageXml).append("</canvasPageXml>");
      }
      if (((aks)localObject1).Gkd) {
        localStringBuffer2.append("<wsVideoFlowXml>").append(bt.aRc(((aks)localObject1).Gkc)).append("</wsVideoFlowXml>");
      }
      localStringBuffer2.append(b.a(paramg.field_favProto.DSw));
      localStringBuffer2.append("</weburlitem>");
      localObject1 = localStringBuffer2.toString();
      break label468;
      label1512:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<productitem");
      if (((akc)localObject1).Gju) {
        localStringBuffer2.append(" type='").append(((akc)localObject1).type).append("'");
      }
      localStringBuffer2.append(">");
      if (((akc)localObject1).GgK) {
        localStringBuffer2.append("<producttitle>").append(bt.aRc(((akc)localObject1).title)).append("</producttitle>");
      }
      if (((akc)localObject1).GgL) {
        localStringBuffer2.append("<productdesc>").append(bt.aRc(((akc)localObject1).desc)).append("</productdesc>");
      }
      if (((akc)localObject1).Gjs) {
        localStringBuffer2.append("<productthumb_url>").append(bt.aRc(((akc)localObject1).thumbUrl)).append("</productthumb_url>");
      }
      if (((akc)localObject1).Gjt) {
        localStringBuffer2.append("<productinfo>").append(bt.aRc(((akc)localObject1).info)).append("</productinfo>");
      }
      localStringBuffer2.append("</productitem>");
      localObject1 = localStringBuffer2.toString();
      break label505;
      label1714:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<tvitem>");
      if (((akm)localObject1).GgK) {
        localStringBuffer2.append("<tvtitle>").append(bt.aRc(((akm)localObject1).title)).append("</tvtitle>");
      }
      if (((akm)localObject1).GgL) {
        localStringBuffer2.append("<tvdesc>").append(bt.aRc(((akm)localObject1).desc)).append("</tvdesc>");
      }
      if (((akm)localObject1).Gjs) {
        localStringBuffer2.append("<tvthumb_url>").append(bt.aRc(((akm)localObject1).thumbUrl)).append("</tvthumb_url>");
      }
      if (((akm)localObject1).Gjt) {
        localStringBuffer2.append("<tvinfo>").append(bt.aRc(((akm)localObject1).info)).append("</tvinfo>");
      }
      localStringBuffer2.append("</tvitem>");
      localObject1 = localStringBuffer2.toString();
      break label542;
      label1878:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<noteinfo>");
      localStringBuffer2.append("<noteauthor>").append(bt.aRc(((ajx)localObject1).Gjo)).append("</noteauthor>");
      localStringBuffer2.append("<noteeditor>").append(bt.aRc(((ajx)localObject1).Gjp)).append("</noteeditor>");
      localStringBuffer2.append("</noteinfo>");
      localObject1 = localStringBuffer2.toString();
      break label577;
      label1964:
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<appbranditem>");
      ((StringBuilder)localObject2).append("<username>").append(bt.aRc(((ajl)localObject1).username)).append("</username>");
      ((StringBuilder)localObject2).append("<appid>").append(bt.aRc(((ajl)localObject1).appId)).append("</appid>");
      ((StringBuilder)localObject2).append("<pkgtype>").append(((ajl)localObject1).dtF).append("</pkgtype>");
      ((StringBuilder)localObject2).append("<iconurl>").append(bt.aRc(((ajl)localObject1).iconUrl)).append("</iconurl>");
      ((StringBuilder)localObject2).append("<type>").append(((ajl)localObject1).type).append("</type>");
      ((StringBuilder)localObject2).append("<pagepath>").append(bt.aRc(((ajl)localObject1).dki)).append("</pagepath>");
      ((StringBuilder)localObject2).append("<sourcedisplayname>").append(bt.aRc(((ajl)localObject1).GgH)).append("</sourcedisplayname>");
      ((StringBuilder)localObject2).append("<version>").append(((ajl)localObject1).version).append("</version>");
      ((StringBuilder)localObject2).append("<disableforward>").append(((ajl)localObject1).kro).append("</disableforward>");
      ((StringBuilder)localObject2).append("<tradingguaranteeflag>").append(((ajl)localObject1).jXI).append("</tradingguaranteeflag>");
      ((StringBuilder)localObject2).append("<messageextradata>").append(String.format("<![CDATA[%s]]>", new Object[] { ((ajl)localObject1).dJW })).append("</messageextradata>");
      ((StringBuilder)localObject2).append("<subtype>").append(((ajl)localObject1).subType).append("</subtype>");
      ((StringBuilder)localObject2).append("</appbranditem>");
    }
  }
  
  public final g agl(String paramString)
  {
    AppMethodBeat.i(103375);
    if ((paramString == null) || (paramString.equals("")))
    {
      ad.e("MicroMsg.FavItemInfo", "klem, FavItemInfo xml null");
      AppMethodBeat.o(103375);
      return this;
    }
    Map localMap = bw.M(paramString, "favitem");
    if (localMap == null)
    {
      ad.e("MicroMsg.FavItemInfo", "klem, FavItemInfo maps null");
      AppMethodBeat.o(103375);
      return this;
    }
    for (;;)
    {
      try
      {
        cuP();
        akd localakd = this.field_favProto;
        localakd.aPd((String)localMap.get(".favitem.title"));
        localakd.aPe((String)localMap.get(".favitem.desc"));
        localakd.aPc((String)localMap.get(".favitem.remark"));
        localakd.CK(bt.getLong((String)localMap.get(".favitem.remark.$time"), 0L));
        localObject = (String)localMap.get(".favitem.edittime");
        localakd.ZQ(bt.getInt((String)localMap.get(".favitem.version"), 0));
        localakd.CL(bt.getLong((String)localObject, 0L));
        localakd.ZP(bt.getInt((String)localMap.get(".favitem.ctrlflag"), -1));
        localObject = localakd.Gjv;
        ((akj)localObject).ZR(bt.getInt((String)localMap.get(".favitem.source" + ".$sourcetype"), 0));
        ((akj)localObject).aPh((String)localMap.get(".favitem.source" + ".$sourceid"));
        ((akj)localObject).aPf((String)localMap.get(".favitem.source" + ".fromusr"));
        ((akj)localObject).aPg((String)localMap.get(".favitem.source" + ".tousr"));
        ((akj)localObject).aPi((String)localMap.get(".favitem.source" + ".realchatname"));
        ((akj)localObject).CM(bt.getLong((String)localMap.get(".favitem.source" + ".createtime"), 0L));
        ((akj)localObject).aPj((String)localMap.get(".favitem.source" + ".msgid"));
        ((akj)localObject).aPk((String)localMap.get(".favitem.source" + ".eventid"));
        ((akj)localObject).aPl((String)localMap.get(".favitem.source" + ".appid"));
        ((akj)localObject).aPm((String)localMap.get(".favitem.source" + ".link"));
        ((akj)localObject).aPn((String)localMap.get(".favitem.source" + ".brandid"));
        c.a(paramString, localakd);
        paramString = localakd.Giu;
        if (!bt.isNullOrNil((String)localMap.get(".favitem.locitem" + ".label"))) {
          paramString.aOW((String)localMap.get(".favitem.locitem" + ".label"));
        }
        if (!bt.isNullOrNil((String)localMap.get(".favitem.locitem" + ".poiname"))) {
          paramString.aOX((String)localMap.get(".favitem.locitem" + ".poiname"));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".lng");
        if (!bt.isNullOrNil((String)localObject)) {
          paramString.A(bt.getDouble((String)localObject, 0.0D));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".lat");
        if (!bt.isNullOrNil((String)localObject)) {
          paramString.B(bt.getDouble((String)localObject, 0.0D));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".scale");
        if (!bt.isNullOrNil((String)localObject))
        {
          if (((String)localObject).indexOf('.') == -1) {
            continue;
          }
          paramString.ZN(bt.getInt(((String)localObject).substring(0, ((String)localObject).indexOf('.')), -1));
        }
        paramString = localakd.Giw;
        paramString.aPu((String)localMap.get(".favitem.weburlitem" + ".clean_url"));
        paramString.aPt((String)localMap.get(".favitem.weburlitem" + ".pagedesc"));
        paramString.aPv((String)localMap.get(".favitem.weburlitem" + ".pagethumb_url"));
        paramString.aPs((String)localMap.get(".favitem.weburlitem" + ".pagetitle"));
        paramString.ZS(bt.getInt((String)localMap.get(".favitem.weburlitem" + ".opencache"), 0));
        paramString.ZT(bt.getInt((String)localMap.get(".favitem.weburlitem" + ".contentattr"), 0));
        paramString.aPw((String)localMap.get(".favitem.weburlitem" + ".canvasPageXml"));
        paramString.aPx((String)localMap.get(".favitem.weburlitem" + ".wsVideoFlowXml"));
        localakd.d(e.v(".favitem", localMap));
        if (localakd.DSw != null) {
          localakd.f(b.t(".favitem.weburlitem.appmsgshareitem", localMap));
        }
        paramString = localakd.Giy;
        paramString.aOY((String)localMap.get(".favitem.productitem" + ".producttitle"));
        paramString.aOZ((String)localMap.get(".favitem.productitem" + ".productdesc"));
        paramString.aPa((String)localMap.get(".favitem.productitem" + ".productthumb_url"));
        paramString.aPb((String)localMap.get(".favitem.productitem" + ".productinfo"));
        paramString.ZO(bt.getInt((String)localMap.get(".favitem.productitem" + ".$type"), 0));
        paramString = localakd.GiA;
        paramString.aPo((String)localMap.get(".favitem.tvitem" + ".tvtitle"));
        paramString.aPp((String)localMap.get(".favitem.tvitem" + ".tvdesc"));
        paramString.aPq((String)localMap.get(".favitem.tvitem" + ".tvthumb_url"));
        paramString.aPr((String)localMap.get(".favitem.tvitem" + ".tvinfo"));
        paramString = localakd.FpF;
        paramString.Gjo = ((String)localMap.get(".favitem.noteinfo" + ".noteauthor"));
        paramString.Gjp = ((String)localMap.get(".favitem.noteinfo" + ".noteeditor"));
        if (localMap.containsKey(".favitem.appbranditem"))
        {
          paramString = new ajl();
          paramString.username = ((String)localMap.get(".favitem.appbranditem" + ".username"));
          paramString.appId = ((String)localMap.get(".favitem.appbranditem" + ".appid"));
          paramString.dtF = bt.getInt((String)localMap.get(".favitem.appbranditem" + ".pkgtype"), 0);
          paramString.iconUrl = ((String)localMap.get(".favitem.appbranditem" + ".iconurl"));
          paramString.type = bt.getInt((String)localMap.get(".favitem.appbranditem" + ".type"), 0);
          paramString.dki = ((String)localMap.get(".favitem.appbranditem" + ".pagepath"));
          paramString.GgH = ((String)localMap.get(".favitem.appbranditem" + ".sourcedisplayname"));
          paramString.version = bt.getInt((String)localMap.get(".favitem.appbranditem" + ".version"), 0);
          paramString.kro = bt.getInt((String)localMap.get(".favitem.appbranditem" + ".disableforward"), 0);
          paramString.jXI = bt.getInt((String)localMap.get(".favitem.appbranditem" + ".tradingguaranteeflag"), 0);
          paramString.dJW = ((String)localMap.get(".favitem.appbranditem" + ".messageextradata"));
          paramString.subType = bt.getInt((String)localMap.get(".favitem.appbranditem" + ".subtype"), 0);
          localakd.c(paramString);
        }
        if (localakd.DSw != null) {
          localakd.f(b.t(".favitem.weburlitem.appmsgshareitem", localMap));
        }
        if (this.field_favProto.Gjv != null)
        {
          paramString = this.field_favProto.Gjv;
          this.field_sourceId = paramString.GjD;
          this.field_sourceType = paramString.sourceType;
          this.field_fromUser = paramString.dyU;
          this.field_toUser = paramString.toUser;
        }
        this.field_edittime = this.field_favProto.pQi;
        d.a(localMap, this.field_tagProto);
      }
      catch (Exception paramString)
      {
        Object localObject;
        ad.printErrStackTrace("MicroMsg.FavItemInfo", paramString, "", new Object[0]);
        ad.e("MicroMsg.FavItemInfo", "klem , FavItemInfo exception:+%s", new Object[] { paramString.toString() });
        continue;
      }
      AppMethodBeat.o(103375);
      return this;
      paramString.ZN(bt.getInt((String)localObject, -1));
    }
  }
  
  public final void agm(String paramString)
  {
    AppMethodBeat.i(103376);
    g.a locala = rsp;
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
      locala.log("remarktime: " + this.field_favProto.GiD);
      locala.log("dataitemCount: " + this.field_favProto.nZa.size());
      if (this.field_favProto.Gjv != null)
      {
        locala.log(" ----source item----");
        paramString = this.field_favProto.Gjv;
        locala.log("  sourceType: " + paramString.sourceType);
        locala.log("  fromUser: " + paramString.dyU);
        locala.log("  toUser: " + paramString.toUser);
        locala.log("  sourceId: " + paramString.GjD);
        locala.log("  realChatName: " + paramString.GiV);
        locala.log("  createTime: " + paramString.createTime);
        locala.log("  msgId: " + paramString.msgId);
        locala.log("  eventId: " + paramString.dKz);
        locala.log("  appId: " + paramString.appId);
        locala.log("  link: " + paramString.link);
        locala.log("  mediaId: " + paramString.Gjb);
        locala.log("  brandId: " + paramString.djX);
      }
      paramString = this.field_favProto.nZa.iterator();
      int i = 0;
      while (paramString.hasNext())
      {
        ajn localajn = (ajn)paramString.next();
        locala.log(" ----data item " + i + "----");
        locala.log("  dataId: " + localajn.dsU);
        locala.log("  dataType: " + localajn.dataType);
        locala.log("  dataSouceId: " + localajn.Ghz);
        locala.log("  svrDataStatus: " + localajn.GhH);
        locala.log("  cdnThumbUrl: " + localajn.hAe);
        locala.log("  cdnThumbKey: " + localajn.GgN);
        locala.log("  cdnDataUrl: " + localajn.GgR);
        locala.log("  cdnDataKey: " + localajn.GgT);
        locala.log("  cdnEncryVer: " + localajn.GgV);
        locala.log("  fullmd5: " + localajn.Ghi);
        locala.log("  head256md5: " + localajn.Ghk);
        locala.log("  fullsize: " + localajn.Ghm);
        locala.log("  thumbMd5: " + localajn.Ght);
        locala.log("  thumbHead256md5: " + localajn.Ghv);
        locala.log("  thumbfullsize: " + localajn.Ghx);
        locala.log("  duration: " + localajn.duration);
        locala.log("  datafmt: " + localajn.Ghg);
        locala.log("  streamWebUrl: " + localajn.GgY);
        locala.log("  streamDataUrl: " + localajn.Gha);
        locala.log("  streamLowBandUrl: " + localajn.Ghc);
        locala.log("  ext: " + localajn.dnv);
        locala.log("  msgUuid: " + localajn.iuq);
        if (localajn.GhL != null)
        {
          locala.log("  remarktime: " + localajn.GhL.GiD);
          locala.log("  ctrlflag: " + localajn.GhL.GiF);
          locala.log("  edittime: " + localajn.GhL.pQi);
          if (localajn.GhL.Gis != null)
          {
            locala.log("   ----data source item----");
            ajp localajp = localajn.GhL.Gis;
            locala.log("    sourceType: " + localajp.sourceType);
            locala.log("    fromUser: " + localajp.dyU);
            locala.log("    toUser: " + localajp.toUser);
            locala.log("    realChatName: " + localajp.GiV);
            locala.log("    createTime: " + localajp.createTime);
            locala.log("    msgId: " + localajp.msgId);
            locala.log("    eventId: " + localajp.dKz);
            locala.log("    appId: " + localajp.appId);
            locala.log("    link: " + localajp.link);
            locala.log("    mediaId: " + localajp.Gjb);
            locala.log("    brandId: " + localajp.djX);
          }
          a("  ", locala, localajn.GhL.Giu);
          a("  ", locala, localajn.GhL.Giw);
          a("  ", locala, localajn.GhL.Giy);
          a("  ", locala, localajn.GhL.GiA);
          a("  ", locala, localajn.GhL.FpF);
        }
        i += 1;
      }
      a("", locala, this.field_favProto.Giu);
      a("", locala, this.field_favProto.Giw);
      a("", locala, this.field_favProto.Giy);
      a("", locala, this.field_favProto.GiA);
      a("  ", locala, this.field_favProto.FpF);
    }
    locala.log("----dump favitem end----");
    AppMethodBeat.o(103376);
  }
  
  public final boolean agn(String paramString)
  {
    AppMethodBeat.i(103382);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103382);
      return false;
    }
    Iterator localIterator = this.field_tagProto.GjJ.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equals((String)localIterator.next()))
      {
        AppMethodBeat.o(103382);
        return false;
      }
    }
    this.field_tagProto.GjJ.add(paramString);
    AppMethodBeat.o(103382);
    return true;
  }
  
  public final boolean cuQ()
  {
    return (this.field_favProto.GiF & 0x1) != 0;
  }
  
  public final boolean cuR()
  {
    return (this.field_favProto.GiF & 0x2) != 0;
  }
  
  public final Bundle cuS()
  {
    AppMethodBeat.i(103374);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_ctrl_flag_open_chat", cuQ());
    localBundle.putBoolean("key_ctrl_flag_open_sns", cuR());
    if ((this.field_favProto.GiF & 0x4) != 0)
    {
      bool = true;
      localBundle.putBoolean("key_ctrl_flag_open_weibo", bool);
      if ((this.field_favProto.GiF & 0x8) == 0) {
        break label183;
      }
      bool = true;
      label73:
      localBundle.putBoolean("key_ctrl_flag_open_cplink", bool);
      if ((this.field_favProto.GiF & 0x10) == 0) {
        break label188;
      }
      bool = true;
      label96:
      localBundle.putBoolean("key_ctrl_flag_open_browser", bool);
      if ((this.field_favProto.GiF & 0x20) == 0) {
        break label193;
      }
      bool = true;
      label119:
      localBundle.putBoolean("key_ctrl_flag_open_weiyun", bool);
      if ((this.field_favProto.GiF & 0x40) == 0) {
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
      ad.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", new Object[] { localBundle.toString() });
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
  
  public final boolean cuT()
  {
    return (this.field_itemStatus == 1) || (this.field_itemStatus == 4) || (this.field_itemStatus == 9) || (this.field_itemStatus == 12) || (this.field_itemStatus == 13) || (this.field_itemStatus == 15) || (this.field_itemStatus == 17);
  }
  
  public final boolean cuU()
  {
    return this.field_itemStatus == 8;
  }
  
  public final boolean cuV()
  {
    return (this.field_itemStatus == 15) || (this.field_itemStatus == 16);
  }
  
  public final boolean cuW()
  {
    return (this.field_itemStatus == 12) || (this.field_itemStatus == 13) || (this.field_itemStatus == 14);
  }
  
  public final g cuX()
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
    localg.rsm = this.rsm;
    localg.rsn = this.rsn;
    localg.dsK = this.dsK;
    AppMethodBeat.o(103384);
    return localg;
  }
  
  public final boolean cuY()
  {
    AppMethodBeat.i(103385);
    Iterator localIterator = this.field_favProto.nZa.iterator();
    while (localIterator.hasNext()) {
      if (((ajn)localIterator.next()).Gid != 0)
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