package com.tencent.mm.plugin.fav.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bu;
import com.tencent.mm.plugin.fav.a.a.a;
import com.tencent.mm.plugin.fav.a.a.b;
import com.tencent.mm.plugin.fav.a.a.c;
import com.tencent.mm.protocal.protobuf.afw;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.protocal.protobuf.agf;
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.protocal.protobuf.agi;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahb;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class g
  extends bu
{
  public static c.a info;
  private static g.a pZH;
  private static g.a pZI;
  public String djR;
  public boolean pZE;
  public g pZF;
  public String pZG;
  
  static
  {
    AppMethodBeat.i(103387);
    info = bu.So();
    pZH = new g.1();
    pZI = new g.2();
    AppMethodBeat.o(103387);
  }
  
  public g()
  {
    AppMethodBeat.i(103372);
    this.pZE = false;
    this.pZF = null;
    this.djR = "";
    this.pZG = "";
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
    chD();
    AppMethodBeat.o(103372);
  }
  
  private static void a(String paramString, g.a parama, agf paramagf)
  {
    AppMethodBeat.i(103380);
    if (paramagf == null)
    {
      AppMethodBeat.o(103380);
      return;
    }
    parama.log(paramString + " ----loc item----");
    parama.log(paramString + "  lng: " + paramagf.lng);
    parama.log(paramString + "  lat: " + paramagf.lat);
    parama.log(paramString + "  scale: " + paramagf.dpd);
    parama.log(paramString + "  label: " + paramagf.label);
    parama.log(paramString + "  poiname: " + paramagf.dtN);
    AppMethodBeat.o(103380);
  }
  
  private static void a(String paramString, g.a parama, agi paramagi)
  {
    AppMethodBeat.i(103378);
    if (paramagi == null)
    {
      AppMethodBeat.o(103378);
      return;
    }
    parama.log(paramString + " ----noteInfoItem item----");
    parama.log(paramString + "  author: " + paramagi.Diw);
    parama.log(paramString + "  editor: " + paramagi.Dix);
    AppMethodBeat.o(103378);
  }
  
  private static void a(String paramString, g.a parama, agn paramagn)
  {
    AppMethodBeat.i(103379);
    if (paramagn == null)
    {
      AppMethodBeat.o(103379);
      return;
    }
    parama.log(paramString + " ----product item----");
    parama.log(paramString + "  title: " + paramagn.title);
    parama.log(paramString + "  desc: " + paramagn.desc);
    parama.log(paramString + "  thumbUrl: " + paramagn.thumbUrl);
    parama.log(paramString + "  type: " + paramagn.type);
    AppMethodBeat.o(103379);
  }
  
  private static void a(String paramString, g.a parama, agx paramagx)
  {
    AppMethodBeat.i(103377);
    if (paramagx == null)
    {
      AppMethodBeat.o(103377);
      return;
    }
    parama.log(paramString + " ----tv item----");
    parama.log(paramString + "  title: " + paramagx.title);
    parama.log(paramString + "  desc: " + paramagx.desc);
    parama.log(paramString + "  thumbUrl: " + paramagx.thumbUrl);
    AppMethodBeat.o(103377);
  }
  
  private static void a(String paramString, g.a parama, ahd paramahd)
  {
    AppMethodBeat.i(103381);
    if (paramahd == null)
    {
      AppMethodBeat.o(103381);
      return;
    }
    parama.log(paramString + " ----url item----");
    parama.log(paramString + "  title: " + paramahd.title);
    parama.log(paramString + "  desc: " + paramahd.desc);
    parama.log(paramString + "  cleanUrl: " + paramahd.Djf);
    parama.log(paramString + "  thumbUrl: " + paramahd.thumbUrl);
    parama.log(paramString + "  opencache: " + paramahd.Djh);
    parama.log(paramString + "  topstory: " + paramahd.Djk);
    AppMethodBeat.o(103381);
  }
  
  private void chD()
  {
    AppMethodBeat.i(103373);
    this.field_favProto = new ago();
    agu localagu = new agu();
    localagu.VM(1);
    this.field_favProto.a(localagu);
    this.field_favProto.b(new ahd());
    this.field_favProto.f(new agg());
    this.field_favProto.d(new agf());
    this.field_favProto.b(new agn());
    this.field_favProto.b(new agx());
    this.field_favProto.c(new ald());
    this.field_favProto.VK(-1);
    this.field_tagProto = new ahb();
    this.field_favProto.a(new agi());
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
    if (!bt.isNullOrNil(((ago)localObject2).title)) {
      localStringBuilder.append("<title>").append(bt.aGf(((ago)localObject2).title)).append("</title>");
    }
    if (!bt.isNullOrNil(((ago)localObject2).desc)) {
      localStringBuilder.append("<desc>").append(bt.aGf(((ago)localObject2).desc)).append("</desc>");
    }
    if (((ago)localObject2).oJi > 0L) {
      localStringBuilder.append("<edittime>").append(((ago)localObject2).oJi).append("</edittime>");
    }
    if ((((ago)localObject2).Csh != null) && (!bt.isNullOrNil(((ago)localObject2).Csh.Dix))) {
      localStringBuilder.append("<editusr>").append(((ago)localObject2).Csh.Dix).append("</editusr>");
    }
    if (!bt.isNullOrNil(((ago)localObject2).iaz))
    {
      localStringBuilder.append("<remark ");
      if (((ago)localObject2).DhL > 0L) {
        localStringBuilder.append(" time ='").append(((ago)localObject2).DhL).append("'");
      }
      localStringBuilder.append(">").append(bt.aGf(((ago)localObject2).iaz)).append("</remark>");
    }
    if (((ago)localObject2).DhO) {
      localStringBuilder.append("<ctrlflag>").append(((ago)localObject2).DhN).append("</ctrlflag>");
    }
    if (((ago)localObject2).DiG)
    {
      localStringBuilder.append("<version>").append(((ago)localObject2).version).append("</version>");
      localObject1 = ((ago)localObject2).DiD;
      if ((localObject1 != null) && (((agu)localObject1).computeSize() != 0)) {
        break label679;
      }
      ad.w("MicroMsg.FavSourceItemParser", "klem toXml, source item empty");
      localObject1 = "";
      label381:
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(a.dj(((ago)localObject2).mVb));
      localObject1 = paramg.field_favProto.DhC;
      if ((localObject1 != null) && (((agf)localObject1).computeSize() != 0)) {
        break label1029;
      }
      ad.d("MicroMsg.FavLocItemParser", "klem toXml, loc item empty");
      localObject1 = "";
      label431:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.DhE;
      if ((localObject1 != null) && (((ahd)localObject1).computeSize() != 0)) {
        break label1213;
      }
      ad.d("MicroMsg.FavUrlItemParser", "klem toXml, url item empty");
      localObject1 = "";
      label468:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.DhG;
      if ((localObject1 != null) && (((agn)localObject1).computeSize() != 0)) {
        break label1512;
      }
      ad.d("MicroMsg.FavProductItemParser", "klem toXml, product item empty");
      localObject1 = "";
      label505:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.DhI;
      if ((localObject1 != null) && (((agx)localObject1).computeSize() != 0)) {
        break label1714;
      }
      ad.d("MicroMsg.FavTVItemParser", "klem toXml, product item empty");
      localObject1 = "";
      label542:
      localStringBuilder.append((String)localObject1);
      localObject1 = ((ago)localObject2).Csh;
      if ((localObject1 != null) && (((agi)localObject1).computeSize() != 0)) {
        break label1878;
      }
      ad.w("MicroMsg.FavNoteInfoItemParser", "klem toXml, source item empty");
      localObject1 = "";
      label577:
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(com.tencent.mm.plugin.i.a.d.a(((ago)localObject2).DhW));
      localObject1 = paramg.field_favProto.DhR;
      if (localObject1 != null) {
        break label1964;
      }
    }
    for (Object localObject1 = "";; localObject1 = ((StringBuilder)localObject2).toString())
    {
      localStringBuilder.append((String)localObject1);
      localStringBuffer1.append(localStringBuilder.toString());
      localStringBuffer1.append(com.tencent.mm.plugin.fav.a.a.d.a(paramg.field_tagProto));
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
      if (((agu)localObject1).DhY) {
        localStringBuffer2.append(" sourcetype='").append(((agu)localObject1).sourceType).append("'");
      }
      if (((agu)localObject1).DiM) {
        localStringBuffer2.append(" sourceid='").append(((agu)localObject1).DiL).append("'");
      }
      localStringBuffer2.append(">");
      if (((agu)localObject1).DhZ) {
        localStringBuffer2.append("<fromusr>").append(bt.aGf(((agu)localObject1).dpv)).append("</fromusr>");
      }
      if (((agu)localObject1).Dia) {
        localStringBuffer2.append("<tousr>").append(bt.aGf(((agu)localObject1).toUser)).append("</tousr>");
      }
      if (((agu)localObject1).Die) {
        localStringBuffer2.append("<realchatname>").append(bt.aGf(((agu)localObject1).Did)).append("</realchatname>");
      }
      if (((agu)localObject1).Dif) {
        localStringBuffer2.append("<msgid>").append(((agu)localObject1).dvT).append("</msgid>");
      }
      if (((agu)localObject1).Dig) {
        localStringBuffer2.append("<eventid>").append(((agu)localObject1).dAA).append("</eventid>");
      }
      if (((agu)localObject1).Dih) {
        localStringBuffer2.append("<appid>").append(((agu)localObject1).appId).append("</appid>");
      }
      if (((agu)localObject1).Dii) {
        localStringBuffer2.append("<link>").append(bt.aGf(((agu)localObject1).link)).append("</link>");
      }
      if (((agu)localObject1).Dil) {
        localStringBuffer2.append("<brandid>").append(bt.aGf(((agu)localObject1).dbj)).append("</brandid>");
      }
      localStringBuffer2.append("</source>");
      localObject1 = localStringBuffer2.toString();
      break label381;
      label1029:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<locitem>");
      if (((agf)localObject1).Dit) {
        localStringBuffer2.append("<label>").append(bt.aGf(((agf)localObject1).label)).append("</label>");
      }
      if (((agf)localObject1).Dir) {
        localStringBuffer2.append("<lat>").append(((agf)localObject1).lat).append("</lat>");
      }
      if (((agf)localObject1).Diq) {
        localStringBuffer2.append("<lng>").append(((agf)localObject1).lng).append("</lng>");
      }
      if (((agf)localObject1).Dis) {
        localStringBuffer2.append("<scale>").append(((agf)localObject1).dpd).append("</scale>");
      }
      if (((agf)localObject1).Diu) {
        localStringBuffer2.append("<poiname>").append(((agf)localObject1).dtN).append("</poiname>");
      }
      localStringBuffer2.append("</locitem>");
      localObject1 = localStringBuffer2.toString();
      break label431;
      label1213:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<weburlitem>");
      if (((ahd)localObject1).Djg) {
        localStringBuffer2.append("<clean_url>").append(bt.aGf(((ahd)localObject1).Djf)).append("</clean_url>");
      }
      if (((ahd)localObject1).DfT) {
        localStringBuffer2.append("<pagedesc>").append(bt.aGf(((ahd)localObject1).desc)).append("</pagedesc>");
      }
      if (((ahd)localObject1).DiA) {
        localStringBuffer2.append("<pagethumb_url>").append(bt.aGf(((ahd)localObject1).thumbUrl)).append("</pagethumb_url>");
      }
      if (((ahd)localObject1).DfS) {
        localStringBuffer2.append("<pagetitle>").append(bt.aGf(((ahd)localObject1).title)).append("</pagetitle>");
      }
      if (((ahd)localObject1).Dji) {
        localStringBuffer2.append("<opencache>").append(((ahd)localObject1).Djh).append("</opencache>");
      }
      if (((ahd)localObject1).Djj) {
        localStringBuffer2.append("<contentattr>").append(((ahd)localObject1).gHj).append("</contentattr>");
      }
      if (((ahd)localObject1).Dhe) {
        localStringBuffer2.append("<canvasPageXml>").append(((ahd)localObject1).canvasPageXml).append("</canvasPageXml>");
      }
      if (((ahd)localObject1).Djl) {
        localStringBuffer2.append("<wsVideoFlowXml>").append(bt.aGf(((ahd)localObject1).Djk)).append("</wsVideoFlowXml>");
      }
      localStringBuffer2.append(b.a(paramg.field_favProto.AWL));
      localStringBuffer2.append("</weburlitem>");
      localObject1 = localStringBuffer2.toString();
      break label468;
      label1512:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<productitem");
      if (((agn)localObject1).DiC) {
        localStringBuffer2.append(" type='").append(((agn)localObject1).type).append("'");
      }
      localStringBuffer2.append(">");
      if (((agn)localObject1).DfS) {
        localStringBuffer2.append("<producttitle>").append(bt.aGf(((agn)localObject1).title)).append("</producttitle>");
      }
      if (((agn)localObject1).DfT) {
        localStringBuffer2.append("<productdesc>").append(bt.aGf(((agn)localObject1).desc)).append("</productdesc>");
      }
      if (((agn)localObject1).DiA) {
        localStringBuffer2.append("<productthumb_url>").append(bt.aGf(((agn)localObject1).thumbUrl)).append("</productthumb_url>");
      }
      if (((agn)localObject1).DiB) {
        localStringBuffer2.append("<productinfo>").append(bt.aGf(((agn)localObject1).info)).append("</productinfo>");
      }
      localStringBuffer2.append("</productitem>");
      localObject1 = localStringBuffer2.toString();
      break label505;
      label1714:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<tvitem>");
      if (((agx)localObject1).DfS) {
        localStringBuffer2.append("<tvtitle>").append(bt.aGf(((agx)localObject1).title)).append("</tvtitle>");
      }
      if (((agx)localObject1).DfT) {
        localStringBuffer2.append("<tvdesc>").append(bt.aGf(((agx)localObject1).desc)).append("</tvdesc>");
      }
      if (((agx)localObject1).DiA) {
        localStringBuffer2.append("<tvthumb_url>").append(bt.aGf(((agx)localObject1).thumbUrl)).append("</tvthumb_url>");
      }
      if (((agx)localObject1).DiB) {
        localStringBuffer2.append("<tvinfo>").append(bt.aGf(((agx)localObject1).info)).append("</tvinfo>");
      }
      localStringBuffer2.append("</tvitem>");
      localObject1 = localStringBuffer2.toString();
      break label542;
      label1878:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<noteinfo>");
      localStringBuffer2.append("<noteauthor>").append(bt.aGf(((agi)localObject1).Diw)).append("</noteauthor>");
      localStringBuffer2.append("<noteeditor>").append(bt.aGf(((agi)localObject1).Dix)).append("</noteeditor>");
      localStringBuffer2.append("</noteinfo>");
      localObject1 = localStringBuffer2.toString();
      break label577;
      label1964:
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<appbranditem>");
      ((StringBuilder)localObject2).append("<username>").append(bt.aGf(((afw)localObject1).username)).append("</username>");
      ((StringBuilder)localObject2).append("<appid>").append(bt.aGf(((afw)localObject1).appId)).append("</appid>");
      ((StringBuilder)localObject2).append("<pkgtype>").append(((afw)localObject1).dkC).append("</pkgtype>");
      ((StringBuilder)localObject2).append("<iconurl>").append(bt.aGf(((afw)localObject1).iconUrl)).append("</iconurl>");
      ((StringBuilder)localObject2).append("<type>").append(((afw)localObject1).type).append("</type>");
      ((StringBuilder)localObject2).append("<pagepath>").append(bt.aGf(((afw)localObject1).dbu)).append("</pagepath>");
      ((StringBuilder)localObject2).append("<sourcedisplayname>").append(bt.aGf(((afw)localObject1).DfP)).append("</sourcedisplayname>");
      ((StringBuilder)localObject2).append("<version>").append(((afw)localObject1).version).append("</version>");
      ((StringBuilder)localObject2).append("<disableforward>").append(((afw)localObject1).jwB).append("</disableforward>");
      ((StringBuilder)localObject2).append("<tradingguaranteeflag>").append(((afw)localObject1).cfU).append("</tradingguaranteeflag>");
      ((StringBuilder)localObject2).append("<messageextradata>").append(String.format("<![CDATA[%s]]>", new Object[] { ((afw)localObject1).dzY })).append("</messageextradata>");
      ((StringBuilder)localObject2).append("<subtype>").append(((afw)localObject1).subType).append("</subtype>");
      ((StringBuilder)localObject2).append("</appbranditem>");
    }
  }
  
  public final g Ya(String paramString)
  {
    AppMethodBeat.i(103375);
    if ((paramString == null) || (paramString.equals("")))
    {
      ad.e("MicroMsg.FavItemInfo", "klem, FavItemInfo xml null");
      AppMethodBeat.o(103375);
      return this;
    }
    Map localMap = bw.K(paramString, "favitem");
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
        chD();
        ago localago = this.field_favProto;
        localago.aEj((String)localMap.get(".favitem.title"));
        localago.aEk((String)localMap.get(".favitem.desc"));
        localago.aEi((String)localMap.get(".favitem.remark"));
        localago.vt(bt.getLong((String)localMap.get(".favitem.remark.$time"), 0L));
        localObject = (String)localMap.get(".favitem.edittime");
        localago.VL(bt.getInt((String)localMap.get(".favitem.version"), 0));
        localago.vu(bt.getLong((String)localObject, 0L));
        localago.VK(bt.getInt((String)localMap.get(".favitem.ctrlflag"), -1));
        localObject = localago.DiD;
        ((agu)localObject).VM(bt.getInt((String)localMap.get(".favitem.source" + ".$sourcetype"), 0));
        ((agu)localObject).aEn((String)localMap.get(".favitem.source" + ".$sourceid"));
        ((agu)localObject).aEl((String)localMap.get(".favitem.source" + ".fromusr"));
        ((agu)localObject).aEm((String)localMap.get(".favitem.source" + ".tousr"));
        ((agu)localObject).aEo((String)localMap.get(".favitem.source" + ".realchatname"));
        ((agu)localObject).vv(bt.getLong((String)localMap.get(".favitem.source" + ".createtime"), 0L));
        ((agu)localObject).aEp((String)localMap.get(".favitem.source" + ".msgid"));
        ((agu)localObject).aEq((String)localMap.get(".favitem.source" + ".eventid"));
        ((agu)localObject).aEr((String)localMap.get(".favitem.source" + ".appid"));
        ((agu)localObject).aEs((String)localMap.get(".favitem.source" + ".link"));
        ((agu)localObject).aEt((String)localMap.get(".favitem.source" + ".brandid"));
        c.a(paramString, localago);
        paramString = localago.DhC;
        if (!bt.isNullOrNil((String)localMap.get(".favitem.locitem" + ".label"))) {
          paramString.aEc((String)localMap.get(".favitem.locitem" + ".label"));
        }
        if (!bt.isNullOrNil((String)localMap.get(".favitem.locitem" + ".poiname"))) {
          paramString.aEd((String)localMap.get(".favitem.locitem" + ".poiname"));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".lng");
        if (!bt.isNullOrNil((String)localObject)) {
          paramString.B(bt.getDouble((String)localObject, 0.0D));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".lat");
        if (!bt.isNullOrNil((String)localObject)) {
          paramString.C(bt.getDouble((String)localObject, 0.0D));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".scale");
        if (!bt.isNullOrNil((String)localObject))
        {
          if (((String)localObject).indexOf('.') == -1) {
            continue;
          }
          paramString.VI(bt.getInt(((String)localObject).substring(0, ((String)localObject).indexOf('.')), -1));
        }
        paramString = localago.DhE;
        paramString.aEA((String)localMap.get(".favitem.weburlitem" + ".clean_url"));
        paramString.aEz((String)localMap.get(".favitem.weburlitem" + ".pagedesc"));
        paramString.aEB((String)localMap.get(".favitem.weburlitem" + ".pagethumb_url"));
        paramString.aEy((String)localMap.get(".favitem.weburlitem" + ".pagetitle"));
        paramString.VN(bt.getInt((String)localMap.get(".favitem.weburlitem" + ".opencache"), 0));
        paramString.VO(bt.getInt((String)localMap.get(".favitem.weburlitem" + ".contentattr"), 0));
        paramString.aEC((String)localMap.get(".favitem.weburlitem" + ".canvasPageXml"));
        paramString.aED((String)localMap.get(".favitem.weburlitem" + ".wsVideoFlowXml"));
        localago.c(com.tencent.mm.plugin.i.a.d.s(".favitem", localMap));
        if (localago.AWL != null) {
          localago.f(b.q(".favitem.weburlitem.appmsgshareitem", localMap));
        }
        paramString = localago.DhG;
        paramString.aEe((String)localMap.get(".favitem.productitem" + ".producttitle"));
        paramString.aEf((String)localMap.get(".favitem.productitem" + ".productdesc"));
        paramString.aEg((String)localMap.get(".favitem.productitem" + ".productthumb_url"));
        paramString.aEh((String)localMap.get(".favitem.productitem" + ".productinfo"));
        paramString.VJ(bt.getInt((String)localMap.get(".favitem.productitem" + ".$type"), 0));
        paramString = localago.DhI;
        paramString.aEu((String)localMap.get(".favitem.tvitem" + ".tvtitle"));
        paramString.aEv((String)localMap.get(".favitem.tvitem" + ".tvdesc"));
        paramString.aEw((String)localMap.get(".favitem.tvitem" + ".tvthumb_url"));
        paramString.aEx((String)localMap.get(".favitem.tvitem" + ".tvinfo"));
        paramString = localago.Csh;
        paramString.Diw = ((String)localMap.get(".favitem.noteinfo" + ".noteauthor"));
        paramString.Dix = ((String)localMap.get(".favitem.noteinfo" + ".noteeditor"));
        if (localMap.containsKey(".favitem.appbranditem"))
        {
          paramString = new afw();
          paramString.username = ((String)localMap.get(".favitem.appbranditem" + ".username"));
          paramString.appId = ((String)localMap.get(".favitem.appbranditem" + ".appid"));
          paramString.dkC = bt.getInt((String)localMap.get(".favitem.appbranditem" + ".pkgtype"), 0);
          paramString.iconUrl = ((String)localMap.get(".favitem.appbranditem" + ".iconurl"));
          paramString.type = bt.getInt((String)localMap.get(".favitem.appbranditem" + ".type"), 0);
          paramString.dbu = ((String)localMap.get(".favitem.appbranditem" + ".pagepath"));
          paramString.DfP = ((String)localMap.get(".favitem.appbranditem" + ".sourcedisplayname"));
          paramString.version = bt.getInt((String)localMap.get(".favitem.appbranditem" + ".version"), 0);
          paramString.jwB = bt.getInt((String)localMap.get(".favitem.appbranditem" + ".disableforward"), 0);
          paramString.cfU = bt.getInt((String)localMap.get(".favitem.appbranditem" + ".tradingguaranteeflag"), 0);
          paramString.dzY = ((String)localMap.get(".favitem.appbranditem" + ".messageextradata"));
          paramString.subType = bt.getInt((String)localMap.get(".favitem.appbranditem" + ".subtype"), 0);
          localago.c(paramString);
        }
        if (localago.AWL != null) {
          localago.f(b.q(".favitem.weburlitem.appmsgshareitem", localMap));
        }
        if (this.field_favProto.DiD != null)
        {
          paramString = this.field_favProto.DiD;
          this.field_sourceId = paramString.DiL;
          this.field_sourceType = paramString.sourceType;
          this.field_fromUser = paramString.dpv;
          this.field_toUser = paramString.toUser;
        }
        this.field_edittime = this.field_favProto.oJi;
        com.tencent.mm.plugin.fav.a.a.d.a(localMap, this.field_tagProto);
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
      paramString.VI(bt.getInt((String)localObject, -1));
    }
  }
  
  public final void Yb(String paramString)
  {
    AppMethodBeat.i(103376);
    g.a locala = pZH;
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
      locala.log("remarktime: " + this.field_favProto.DhL);
      locala.log("dataitemCount: " + this.field_favProto.mVb.size());
      if (this.field_favProto.DiD != null)
      {
        locala.log(" ----source item----");
        paramString = this.field_favProto.DiD;
        locala.log("  sourceType: " + paramString.sourceType);
        locala.log("  fromUser: " + paramString.dpv);
        locala.log("  toUser: " + paramString.toUser);
        locala.log("  sourceId: " + paramString.DiL);
        locala.log("  realChatName: " + paramString.Did);
        locala.log("  createTime: " + paramString.createTime);
        locala.log("  msgId: " + paramString.dvT);
        locala.log("  eventId: " + paramString.dAA);
        locala.log("  appId: " + paramString.appId);
        locala.log("  link: " + paramString.link);
        locala.log("  mediaId: " + paramString.Dij);
        locala.log("  brandId: " + paramString.dbj);
      }
      paramString = this.field_favProto.mVb.iterator();
      int i = 0;
      while (paramString.hasNext())
      {
        afy localafy = (afy)paramString.next();
        locala.log(" ----data item " + i + "----");
        locala.log("  dataId: " + localafy.dkb);
        locala.log("  dataType: " + localafy.dataType);
        locala.log("  dataSouceId: " + localafy.DgH);
        locala.log("  svrDataStatus: " + localafy.DgP);
        locala.log("  cdnThumbUrl: " + localafy.gHu);
        locala.log("  cdnThumbKey: " + localafy.DfV);
        locala.log("  cdnDataUrl: " + localafy.DfZ);
        locala.log("  cdnDataKey: " + localafy.Dgb);
        locala.log("  cdnEncryVer: " + localafy.Dgd);
        locala.log("  fullmd5: " + localafy.Dgq);
        locala.log("  head256md5: " + localafy.Dgs);
        locala.log("  fullsize: " + localafy.Dgu);
        locala.log("  thumbMd5: " + localafy.DgB);
        locala.log("  thumbHead256md5: " + localafy.DgD);
        locala.log("  thumbfullsize: " + localafy.DgF);
        locala.log("  duration: " + localafy.duration);
        locala.log("  datafmt: " + localafy.Dgo);
        locala.log("  streamWebUrl: " + localafy.Dgg);
        locala.log("  streamDataUrl: " + localafy.Dgi);
        locala.log("  streamLowBandUrl: " + localafy.Dgk);
        locala.log("  ext: " + localafy.deE);
        locala.log("  msgUuid: " + localafy.hAt);
        if (localafy.DgT != null)
        {
          locala.log("  remarktime: " + localafy.DgT.DhL);
          locala.log("  ctrlflag: " + localafy.DgT.DhN);
          locala.log("  edittime: " + localafy.DgT.oJi);
          if (localafy.DgT.DhA != null)
          {
            locala.log("   ----data source item----");
            aga localaga = localafy.DgT.DhA;
            locala.log("    sourceType: " + localaga.sourceType);
            locala.log("    fromUser: " + localaga.dpv);
            locala.log("    toUser: " + localaga.toUser);
            locala.log("    realChatName: " + localaga.Did);
            locala.log("    createTime: " + localaga.createTime);
            locala.log("    msgId: " + localaga.dvT);
            locala.log("    eventId: " + localaga.dAA);
            locala.log("    appId: " + localaga.appId);
            locala.log("    link: " + localaga.link);
            locala.log("    mediaId: " + localaga.Dij);
            locala.log("    brandId: " + localaga.dbj);
          }
          a("  ", locala, localafy.DgT.DhC);
          a("  ", locala, localafy.DgT.DhE);
          a("  ", locala, localafy.DgT.DhG);
          a("  ", locala, localafy.DgT.DhI);
          a("  ", locala, localafy.DgT.Csh);
        }
        i += 1;
      }
      a("", locala, this.field_favProto.DhC);
      a("", locala, this.field_favProto.DhE);
      a("", locala, this.field_favProto.DhG);
      a("", locala, this.field_favProto.DhI);
      a("  ", locala, this.field_favProto.Csh);
    }
    locala.log("----dump favitem end----");
    AppMethodBeat.o(103376);
  }
  
  public final boolean Yc(String paramString)
  {
    AppMethodBeat.i(103382);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103382);
      return false;
    }
    Iterator localIterator = this.field_tagProto.DiR.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equals((String)localIterator.next()))
      {
        AppMethodBeat.o(103382);
        return false;
      }
    }
    this.field_tagProto.DiR.add(paramString);
    AppMethodBeat.o(103382);
    return true;
  }
  
  public final boolean chE()
  {
    return (this.field_favProto.DhN & 0x1) != 0;
  }
  
  public final boolean chF()
  {
    return (this.field_favProto.DhN & 0x2) != 0;
  }
  
  public final Bundle chG()
  {
    AppMethodBeat.i(103374);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_ctrl_flag_open_chat", chE());
    localBundle.putBoolean("key_ctrl_flag_open_sns", chF());
    if ((this.field_favProto.DhN & 0x4) != 0)
    {
      bool = true;
      localBundle.putBoolean("key_ctrl_flag_open_weibo", bool);
      if ((this.field_favProto.DhN & 0x8) == 0) {
        break label183;
      }
      bool = true;
      label73:
      localBundle.putBoolean("key_ctrl_flag_open_cplink", bool);
      if ((this.field_favProto.DhN & 0x10) == 0) {
        break label188;
      }
      bool = true;
      label96:
      localBundle.putBoolean("key_ctrl_flag_open_browser", bool);
      if ((this.field_favProto.DhN & 0x20) == 0) {
        break label193;
      }
      bool = true;
      label119:
      localBundle.putBoolean("key_ctrl_flag_open_weiyun", bool);
      if ((this.field_favProto.DhN & 0x40) == 0) {
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
  
  public final boolean chH()
  {
    return (this.field_itemStatus == 1) || (this.field_itemStatus == 4) || (this.field_itemStatus == 9) || (this.field_itemStatus == 12) || (this.field_itemStatus == 13) || (this.field_itemStatus == 15) || (this.field_itemStatus == 17);
  }
  
  public final boolean chI()
  {
    return this.field_itemStatus == 8;
  }
  
  public final boolean chJ()
  {
    return (this.field_itemStatus == 15) || (this.field_itemStatus == 16);
  }
  
  public final boolean chK()
  {
    return (this.field_itemStatus == 12) || (this.field_itemStatus == 13) || (this.field_itemStatus == 14);
  }
  
  public final g chL()
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
    localg.pZE = this.pZE;
    localg.pZF = this.pZF;
    localg.djR = this.djR;
    AppMethodBeat.o(103384);
    return localg;
  }
  
  public final boolean chM()
  {
    AppMethodBeat.i(103385);
    Iterator localIterator = this.field_favProto.mVb.iterator();
    while (localIterator.hasNext()) {
      if (((afy)localIterator.next()).Dhl != 0)
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