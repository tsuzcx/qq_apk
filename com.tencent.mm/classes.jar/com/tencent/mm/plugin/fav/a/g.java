package com.tencent.mm.plugin.fav.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.by;
import com.tencent.mm.plugin.fav.a.a.a;
import com.tencent.mm.plugin.fav.a.a.b;
import com.tencent.mm.plugin.fav.a.a.c;
import com.tencent.mm.plugin.fav.a.a.d;
import com.tencent.mm.plugin.findersdk.a.k;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class g
  extends by
{
  public static IAutoDBItem.MAutoDBInfo info;
  private static a wGk;
  private static a wGl;
  public String fDQ;
  public boolean wGh;
  public g wGi;
  public String wGj;
  
  static
  {
    AppMethodBeat.i(103387);
    info = by.aoY();
    wGk = new a()
    {
      public final void log(String paramAnonymousString)
      {
        AppMethodBeat.i(103370);
        Log.d("MicroMsg.FavItemInfo", paramAnonymousString);
        AppMethodBeat.o(103370);
      }
    };
    wGl = new a()
    {
      public final void log(String paramAnonymousString)
      {
        AppMethodBeat.i(103371);
        Log.e("MicroMsg.FavItemInfo", paramAnonymousString);
        AppMethodBeat.o(103371);
      }
    };
    AppMethodBeat.o(103387);
  }
  
  public g()
  {
    AppMethodBeat.i(103372);
    this.wGh = false;
    this.wGi = null;
    this.fDQ = "";
    this.wGj = "";
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
    djz();
    AppMethodBeat.o(103372);
  }
  
  private static void a(String paramString, a parama, ant paramant)
  {
    AppMethodBeat.i(103380);
    if (paramant == null)
    {
      AppMethodBeat.o(103380);
      return;
    }
    parama.log(paramString + " ----loc item----");
    parama.log(paramString + "  lng: " + paramant.lng);
    parama.log(paramString + "  lat: " + paramant.lat);
    parama.log(paramString + "  scale: " + paramant.fKJ);
    parama.log(paramString + "  label: " + paramant.label);
    parama.log(paramString + "  poiname: " + paramant.fPN);
    AppMethodBeat.o(103380);
  }
  
  private static void a(String paramString, a parama, anw paramanw)
  {
    AppMethodBeat.i(103378);
    if (paramanw == null)
    {
      AppMethodBeat.o(103378);
      return;
    }
    parama.log(paramString + " ----noteInfoItem item----");
    parama.log(paramString + "  author: " + paramanw.SAu);
    parama.log(paramString + "  editor: " + paramanw.SAv);
    AppMethodBeat.o(103378);
  }
  
  private static void a(String paramString, a parama, aob paramaob)
  {
    AppMethodBeat.i(103379);
    if (paramaob == null)
    {
      AppMethodBeat.o(103379);
      return;
    }
    parama.log(paramString + " ----product item----");
    parama.log(paramString + "  title: " + paramaob.title);
    parama.log(paramString + "  desc: " + paramaob.desc);
    parama.log(paramString + "  thumbUrl: " + paramaob.thumbUrl);
    parama.log(paramString + "  type: " + paramaob.type);
    AppMethodBeat.o(103379);
  }
  
  private static void a(String paramString, a parama, aol paramaol)
  {
    AppMethodBeat.i(103377);
    if (paramaol == null)
    {
      AppMethodBeat.o(103377);
      return;
    }
    parama.log(paramString + " ----tv item----");
    parama.log(paramString + "  title: " + paramaol.title);
    parama.log(paramString + "  desc: " + paramaol.desc);
    parama.log(paramString + "  thumbUrl: " + paramaol.thumbUrl);
    AppMethodBeat.o(103377);
  }
  
  private static void a(String paramString, a parama, aor paramaor)
  {
    AppMethodBeat.i(103381);
    if (paramaor == null)
    {
      AppMethodBeat.o(103381);
      return;
    }
    parama.log(paramString + " ----url item----");
    parama.log(paramString + "  title: " + paramaor.title);
    parama.log(paramString + "  desc: " + paramaor.desc);
    parama.log(paramString + "  cleanUrl: " + paramaor.SBc);
    parama.log(paramString + "  thumbUrl: " + paramaor.thumbUrl);
    parama.log(paramString + "  opencache: " + paramaor.SBe);
    parama.log(paramString + "  topstory: " + paramaor.SBh);
    AppMethodBeat.o(103381);
  }
  
  private void djz()
  {
    AppMethodBeat.i(103373);
    this.field_favProto = new aoc();
    aoi localaoi = new aoi();
    localaoi.arz(1);
    this.field_favProto.a(localaoi);
    this.field_favProto.c(new aor());
    this.field_favProto.f(new anu());
    this.field_favProto.d(new ant());
    this.field_favProto.b(new aob());
    this.field_favProto.b(new aol());
    this.field_favProto.d(new bje());
    this.field_favProto.arx(-1);
    this.field_tagProto = new aop();
    this.field_favProto.a(new anw());
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
    if (!Util.isNullOrNil(((aoc)localObject2).title)) {
      localStringBuilder.append("<title>").append(Util.escapeStringForXml(((aoc)localObject2).title)).append("</title>");
    }
    if (!Util.isNullOrNil(((aoc)localObject2).desc)) {
      localStringBuilder.append("<desc>").append(Util.escapeStringForXml(((aoc)localObject2).desc)).append("</desc>");
    }
    if (((aoc)localObject2).uTt > 0L) {
      localStringBuilder.append("<edittime>").append(((aoc)localObject2).uTt).append("</edittime>");
    }
    if ((((aoc)localObject2).RDh != null) && (!Util.isNullOrNil(((aoc)localObject2).RDh.SAv))) {
      localStringBuilder.append("<editusr>").append(((aoc)localObject2).RDh.SAv).append("</editusr>");
    }
    if (!Util.isNullOrNil(((aoc)localObject2).remark))
    {
      localStringBuilder.append("<remark ");
      if (((aoc)localObject2).Szy > 0L) {
        localStringBuilder.append(" time ='").append(((aoc)localObject2).Szy).append("'");
      }
      localStringBuilder.append(">").append(Util.escapeStringForXml(((aoc)localObject2).remark)).append("</remark>");
    }
    if (((aoc)localObject2).SzB) {
      localStringBuilder.append("<ctrlflag>").append(((aoc)localObject2).SzA).append("</ctrlflag>");
    }
    if (((aoc)localObject2).SAE)
    {
      localStringBuilder.append("<version>").append(((aoc)localObject2).version).append("</version>");
      localObject1 = ((aoc)localObject2).SAB;
      if ((localObject1 != null) && (((aoi)localObject1).computeSize() != 0)) {
        break label679;
      }
      Log.w("MicroMsg.FavSourceItemParser", "klem toXml, source item empty");
      localObject1 = "";
      label381:
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(a.dK(((aoc)localObject2).syG));
      localObject1 = paramg.field_favProto.Szp;
      if ((localObject1 != null) && (((ant)localObject1).computeSize() != 0)) {
        break label1029;
      }
      Log.d("MicroMsg.FavLocItemParser", "klem toXml, loc item empty");
      localObject1 = "";
      label431:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.Szr;
      if ((localObject1 != null) && (((aor)localObject1).computeSize() != 0)) {
        break label1213;
      }
      Log.d("MicroMsg.FavUrlItemParser", "klem toXml, url item empty");
      localObject1 = "";
      label468:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.Szt;
      if ((localObject1 != null) && (((aob)localObject1).computeSize() != 0)) {
        break label1534;
      }
      Log.d("MicroMsg.FavProductItemParser", "klem toXml, product item empty");
      localObject1 = "";
      label505:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.Szv;
      if ((localObject1 != null) && (((aol)localObject1).computeSize() != 0)) {
        break label1736;
      }
      Log.d("MicroMsg.FavTVItemParser", "klem toXml, product item empty");
      localObject1 = "";
      label542:
      localStringBuilder.append((String)localObject1);
      localObject1 = ((aoc)localObject2).RDh;
      if ((localObject1 != null) && (((anw)localObject1).computeSize() != 0)) {
        break label1900;
      }
      Log.w("MicroMsg.FavNoteInfoItemParser", "klem toXml, source item empty");
      localObject1 = "";
      label577:
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(k.b(((aoc)localObject2).SzJ));
      localObject1 = paramg.field_favProto.SzE;
      if (localObject1 != null) {
        break label1986;
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
      if (((aoi)localObject1).SzX) {
        localStringBuffer2.append(" sourcetype='").append(((aoi)localObject1).sourceType).append("'");
      }
      if (((aoi)localObject1).SAK) {
        localStringBuffer2.append(" sourceid='").append(((aoi)localObject1).SAJ).append("'");
      }
      localStringBuffer2.append(">");
      if (((aoi)localObject1).SzY) {
        localStringBuffer2.append("<fromusr>").append(Util.escapeStringForXml(((aoi)localObject1).fLi)).append("</fromusr>");
      }
      if (((aoi)localObject1).SzZ) {
        localStringBuffer2.append("<tousr>").append(Util.escapeStringForXml(((aoi)localObject1).toUser)).append("</tousr>");
      }
      if (((aoi)localObject1).SAc) {
        localStringBuffer2.append("<realchatname>").append(Util.escapeStringForXml(((aoi)localObject1).SAb)).append("</realchatname>");
      }
      if (((aoi)localObject1).SAd) {
        localStringBuffer2.append("<msgid>").append(((aoi)localObject1).msgId).append("</msgid>");
      }
      if (((aoi)localObject1).SAe) {
        localStringBuffer2.append("<eventid>").append(((aoi)localObject1).fXM).append("</eventid>");
      }
      if (((aoi)localObject1).SAf) {
        localStringBuffer2.append("<appid>").append(((aoi)localObject1).appId).append("</appid>");
      }
      if (((aoi)localObject1).SAg) {
        localStringBuffer2.append("<link>").append(Util.escapeStringForXml(((aoi)localObject1).link)).append("</link>");
      }
      if (((aoi)localObject1).SAj) {
        localStringBuffer2.append("<brandid>").append(Util.escapeStringForXml(((aoi)localObject1).fuO)).append("</brandid>");
      }
      localStringBuffer2.append("</source>");
      localObject1 = localStringBuffer2.toString();
      break label381;
      label1029:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<locitem>");
      if (((ant)localObject1).SAr) {
        localStringBuffer2.append("<label>").append(Util.escapeStringForXml(((ant)localObject1).label)).append("</label>");
      }
      if (((ant)localObject1).SAp) {
        localStringBuffer2.append("<lat>").append(((ant)localObject1).lat).append("</lat>");
      }
      if (((ant)localObject1).SAo) {
        localStringBuffer2.append("<lng>").append(((ant)localObject1).lng).append("</lng>");
      }
      if (((ant)localObject1).SAq) {
        localStringBuffer2.append("<scale>").append(((ant)localObject1).fKJ).append("</scale>");
      }
      if (((ant)localObject1).SAs) {
        localStringBuffer2.append("<poiname>").append(((ant)localObject1).fPN).append("</poiname>");
      }
      localStringBuffer2.append("</locitem>");
      localObject1 = localStringBuffer2.toString();
      break label431;
      label1213:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<weburlitem>");
      if (((aor)localObject1).SBd) {
        localStringBuffer2.append("<clean_url>").append(Util.escapeStringForXml(((aor)localObject1).SBc)).append("</clean_url>");
      }
      if (((aor)localObject1).SxI) {
        localStringBuffer2.append("<pagedesc>").append(Util.escapeStringForXml(((aor)localObject1).desc)).append("</pagedesc>");
      }
      if (((aor)localObject1).SAy) {
        localStringBuffer2.append("<pagethumb_url>").append(Util.escapeStringForXml(((aor)localObject1).thumbUrl)).append("</pagethumb_url>");
      }
      if (((aor)localObject1).SxH) {
        localStringBuffer2.append("<pagetitle>").append(Util.escapeStringForXml(((aor)localObject1).title)).append("</pagetitle>");
      }
      if (((aor)localObject1).SBf) {
        localStringBuffer2.append("<opencache>").append(((aor)localObject1).SBe).append("</opencache>");
      }
      if (((aor)localObject1).SBg) {
        localStringBuffer2.append("<contentattr>").append(((aor)localObject1).contentattr).append("</contentattr>");
      }
      if (((aor)localObject1).SyR) {
        localStringBuffer2.append("<canvasPageXml>").append(((aor)localObject1).canvasPageXml).append("</canvasPageXml>");
      }
      if (((aor)localObject1).SBi) {
        localStringBuffer2.append("<wsVideoFlowXml>").append(Util.escapeStringForXml(((aor)localObject1).SBh)).append("</wsVideoFlowXml>");
      }
      localStringBuffer2.append("<forwardflag>").append(((aor)localObject1).mjT).append("</forwardflag>");
      localStringBuffer2.append(b.a(paramg.field_favProto.PTL));
      localStringBuffer2.append("</weburlitem>");
      localObject1 = localStringBuffer2.toString();
      break label468;
      label1534:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<productitem");
      if (((aob)localObject1).SAA) {
        localStringBuffer2.append(" type='").append(((aob)localObject1).type).append("'");
      }
      localStringBuffer2.append(">");
      if (((aob)localObject1).SxH) {
        localStringBuffer2.append("<producttitle>").append(Util.escapeStringForXml(((aob)localObject1).title)).append("</producttitle>");
      }
      if (((aob)localObject1).SxI) {
        localStringBuffer2.append("<productdesc>").append(Util.escapeStringForXml(((aob)localObject1).desc)).append("</productdesc>");
      }
      if (((aob)localObject1).SAy) {
        localStringBuffer2.append("<productthumb_url>").append(Util.escapeStringForXml(((aob)localObject1).thumbUrl)).append("</productthumb_url>");
      }
      if (((aob)localObject1).SAz) {
        localStringBuffer2.append("<productinfo>").append(Util.escapeStringForXml(((aob)localObject1).fTp)).append("</productinfo>");
      }
      localStringBuffer2.append("</productitem>");
      localObject1 = localStringBuffer2.toString();
      break label505;
      label1736:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<tvitem>");
      if (((aol)localObject1).SxH) {
        localStringBuffer2.append("<tvtitle>").append(Util.escapeStringForXml(((aol)localObject1).title)).append("</tvtitle>");
      }
      if (((aol)localObject1).SxI) {
        localStringBuffer2.append("<tvdesc>").append(Util.escapeStringForXml(((aol)localObject1).desc)).append("</tvdesc>");
      }
      if (((aol)localObject1).SAy) {
        localStringBuffer2.append("<tvthumb_url>").append(Util.escapeStringForXml(((aol)localObject1).thumbUrl)).append("</tvthumb_url>");
      }
      if (((aol)localObject1).SAz) {
        localStringBuffer2.append("<tvinfo>").append(Util.escapeStringForXml(((aol)localObject1).fTp)).append("</tvinfo>");
      }
      localStringBuffer2.append("</tvitem>");
      localObject1 = localStringBuffer2.toString();
      break label542;
      label1900:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<noteinfo>");
      localStringBuffer2.append("<noteauthor>").append(Util.escapeStringForXml(((anw)localObject1).SAu)).append("</noteauthor>");
      localStringBuffer2.append("<noteeditor>").append(Util.escapeStringForXml(((anw)localObject1).SAv)).append("</noteeditor>");
      localStringBuffer2.append("</noteinfo>");
      localObject1 = localStringBuffer2.toString();
      break label577;
      label1986:
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<appbranditem>");
      ((StringBuilder)localObject2).append("<username>").append(Util.escapeStringForXml(((ank)localObject1).username)).append("</username>");
      ((StringBuilder)localObject2).append("<appid>").append(Util.escapeStringForXml(((ank)localObject1).appId)).append("</appid>");
      ((StringBuilder)localObject2).append("<pkgtype>").append(((ank)localObject1).fES).append("</pkgtype>");
      ((StringBuilder)localObject2).append("<iconurl>").append(Util.escapeStringForXml(((ank)localObject1).iconUrl)).append("</iconurl>");
      ((StringBuilder)localObject2).append("<type>").append(((ank)localObject1).type).append("</type>");
      ((StringBuilder)localObject2).append("<pagepath>").append(Util.escapeStringForXml(((ank)localObject1).fve)).append("</pagepath>");
      ((StringBuilder)localObject2).append("<sourcedisplayname>").append(Util.escapeStringForXml(((ank)localObject1).SxE)).append("</sourcedisplayname>");
      ((StringBuilder)localObject2).append("<version>").append(((ank)localObject1).version).append("</version>");
      ((StringBuilder)localObject2).append("<disableforward>").append(((ank)localObject1).otE).append("</disableforward>");
      ((StringBuilder)localObject2).append("<tradingguaranteeflag>").append(((ank)localObject1).nYp).append("</tradingguaranteeflag>");
      ((StringBuilder)localObject2).append("<messageextradata>").append(String.format("<![CDATA[%s]]>", new Object[] { ((ank)localObject1).fXg })).append("</messageextradata>");
      ((StringBuilder)localObject2).append("<subtype>").append(((ank)localObject1).subType).append("</subtype>");
      ((StringBuilder)localObject2).append("</appbranditem>");
    }
  }
  
  public final g azR(String paramString)
  {
    AppMethodBeat.i(103375);
    if ((paramString == null) || (paramString.equals("")))
    {
      Log.e("MicroMsg.FavItemInfo", "klem, FavItemInfo xml null");
      AppMethodBeat.o(103375);
      return this;
    }
    Map localMap = XmlParser.parseXml(paramString, "favitem", null);
    if (localMap == null)
    {
      Log.e("MicroMsg.FavItemInfo", "klem, FavItemInfo maps null");
      AppMethodBeat.o(103375);
      return this;
    }
    for (;;)
    {
      try
      {
        djz();
        aoc localaoc = this.field_favProto;
        localaoc.btv((String)localMap.get(".favitem.title"));
        localaoc.btw((String)localMap.get(".favitem.desc"));
        localaoc.btu((String)localMap.get(".favitem.remark"));
        localaoc.Uc(Util.getLong((String)localMap.get(".favitem.remark.$time"), 0L));
        localObject = (String)localMap.get(".favitem.edittime");
        localaoc.ary(Util.getInt((String)localMap.get(".favitem.version"), 0));
        localaoc.Ud(Util.getLong((String)localObject, 0L));
        localaoc.arx(Util.getInt((String)localMap.get(".favitem.ctrlflag"), -1));
        localObject = localaoc.SAB;
        ((aoi)localObject).arz(Util.getInt((String)localMap.get(".favitem.source" + ".$sourcetype"), 0));
        ((aoi)localObject).btz((String)localMap.get(".favitem.source" + ".$sourceid"));
        ((aoi)localObject).btx((String)localMap.get(".favitem.source" + ".fromusr"));
        ((aoi)localObject).bty((String)localMap.get(".favitem.source" + ".tousr"));
        ((aoi)localObject).btA((String)localMap.get(".favitem.source" + ".realchatname"));
        ((aoi)localObject).Ue(Util.getLong((String)localMap.get(".favitem.source" + ".createtime"), 0L));
        ((aoi)localObject).btB((String)localMap.get(".favitem.source" + ".msgid"));
        ((aoi)localObject).btC((String)localMap.get(".favitem.source" + ".eventid"));
        ((aoi)localObject).btD((String)localMap.get(".favitem.source" + ".appid"));
        ((aoi)localObject).btE((String)localMap.get(".favitem.source" + ".link"));
        ((aoi)localObject).btF((String)localMap.get(".favitem.source" + ".brandid"));
        c.a(paramString, localaoc);
        paramString = localaoc.Szp;
        if (!Util.isNullOrNil((String)localMap.get(".favitem.locitem" + ".label"))) {
          paramString.bto((String)localMap.get(".favitem.locitem" + ".label"));
        }
        if (!Util.isNullOrNil((String)localMap.get(".favitem.locitem" + ".poiname"))) {
          paramString.btp((String)localMap.get(".favitem.locitem" + ".poiname"));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".lng");
        if (!Util.isNullOrNil((String)localObject)) {
          paramString.D(Util.getDouble((String)localObject, 0.0D));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".lat");
        if (!Util.isNullOrNil((String)localObject)) {
          paramString.E(Util.getDouble((String)localObject, 0.0D));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".scale");
        if (!Util.isNullOrNil((String)localObject))
        {
          if (((String)localObject).indexOf('.') == -1) {
            continue;
          }
          paramString.arv(Util.getInt(((String)localObject).substring(0, ((String)localObject).indexOf('.')), -1));
        }
        paramString = localaoc.Szr;
        paramString.btM((String)localMap.get(".favitem.weburlitem" + ".clean_url"));
        paramString.btL((String)localMap.get(".favitem.weburlitem" + ".pagedesc"));
        paramString.btN((String)localMap.get(".favitem.weburlitem" + ".pagethumb_url"));
        paramString.btK((String)localMap.get(".favitem.weburlitem" + ".pagetitle"));
        paramString.arA(Util.getInt((String)localMap.get(".favitem.weburlitem" + ".opencache"), 0));
        paramString.arB(Util.getInt((String)localMap.get(".favitem.weburlitem" + ".contentattr"), 0));
        paramString.btO((String)localMap.get(".favitem.weburlitem" + ".canvasPageXml"));
        paramString.btP((String)localMap.get(".favitem.weburlitem" + ".wsVideoFlowXml"));
        paramString.arC(Util.getInt((String)localMap.get(".favitem.weburlitem" + ".forwardflag"), 0));
        localaoc.d(k.w(".favitem", localMap));
        if (localaoc.PTL != null) {
          localaoc.f(b.s(".favitem.weburlitem.appmsgshareitem", localMap));
        }
        paramString = localaoc.Szt;
        paramString.btq((String)localMap.get(".favitem.productitem" + ".producttitle"));
        paramString.btr((String)localMap.get(".favitem.productitem" + ".productdesc"));
        paramString.bts((String)localMap.get(".favitem.productitem" + ".productthumb_url"));
        paramString.btt((String)localMap.get(".favitem.productitem" + ".productinfo"));
        paramString.arw(Util.getInt((String)localMap.get(".favitem.productitem" + ".$type"), 0));
        paramString = localaoc.Szv;
        paramString.btG((String)localMap.get(".favitem.tvitem" + ".tvtitle"));
        paramString.btH((String)localMap.get(".favitem.tvitem" + ".tvdesc"));
        paramString.btI((String)localMap.get(".favitem.tvitem" + ".tvthumb_url"));
        paramString.btJ((String)localMap.get(".favitem.tvitem" + ".tvinfo"));
        paramString = localaoc.RDh;
        paramString.SAu = ((String)localMap.get(".favitem.noteinfo" + ".noteauthor"));
        paramString.SAv = ((String)localMap.get(".favitem.noteinfo" + ".noteeditor"));
        if (localMap.containsKey(".favitem.appbranditem"))
        {
          paramString = new ank();
          paramString.username = ((String)localMap.get(".favitem.appbranditem" + ".username"));
          paramString.appId = ((String)localMap.get(".favitem.appbranditem" + ".appid"));
          paramString.fES = Util.getInt((String)localMap.get(".favitem.appbranditem" + ".pkgtype"), 0);
          paramString.iconUrl = ((String)localMap.get(".favitem.appbranditem" + ".iconurl"));
          paramString.type = Util.getInt((String)localMap.get(".favitem.appbranditem" + ".type"), 0);
          paramString.fve = ((String)localMap.get(".favitem.appbranditem" + ".pagepath"));
          paramString.SxE = ((String)localMap.get(".favitem.appbranditem" + ".sourcedisplayname"));
          paramString.version = Util.getInt((String)localMap.get(".favitem.appbranditem" + ".version"), 0);
          paramString.otE = Util.getInt((String)localMap.get(".favitem.appbranditem" + ".disableforward"), 0);
          paramString.nYp = Util.getInt((String)localMap.get(".favitem.appbranditem" + ".tradingguaranteeflag"), 0);
          paramString.fXg = ((String)localMap.get(".favitem.appbranditem" + ".messageextradata"));
          paramString.subType = Util.getInt((String)localMap.get(".favitem.appbranditem" + ".subtype"), 0);
          localaoc.c(paramString);
        }
        if (localaoc.PTL != null) {
          localaoc.f(b.s(".favitem.weburlitem.appmsgshareitem", localMap));
        }
        if (this.field_favProto.SAB != null)
        {
          paramString = this.field_favProto.SAB;
          this.field_sourceId = paramString.SAJ;
          this.field_sourceType = paramString.sourceType;
          this.field_fromUser = paramString.fLi;
          this.field_toUser = paramString.toUser;
        }
        this.field_edittime = this.field_favProto.uTt;
        d.a(localMap, this.field_tagProto);
      }
      catch (Exception paramString)
      {
        Object localObject;
        Log.printErrStackTrace("MicroMsg.FavItemInfo", paramString, "", new Object[0]);
        Log.e("MicroMsg.FavItemInfo", "klem , FavItemInfo exception:+%s", new Object[] { paramString.toString() });
        continue;
      }
      AppMethodBeat.o(103375);
      return this;
      paramString.arv(Util.getInt((String)localObject, -1));
    }
  }
  
  public final void azS(String paramString)
  {
    AppMethodBeat.i(103376);
    a locala = wGk;
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
      locala.log("remarktime: " + this.field_favProto.Szy);
      locala.log("dataitemCount: " + this.field_favProto.syG.size());
      if (this.field_favProto.SAB != null)
      {
        locala.log(" ----source item----");
        paramString = this.field_favProto.SAB;
        locala.log("  sourceType: " + paramString.sourceType);
        locala.log("  fromUser: " + paramString.fLi);
        locala.log("  toUser: " + paramString.toUser);
        locala.log("  sourceId: " + paramString.SAJ);
        locala.log("  realChatName: " + paramString.SAb);
        locala.log("  createTime: " + paramString.createTime);
        locala.log("  msgId: " + paramString.msgId);
        locala.log("  eventId: " + paramString.fXM);
        locala.log("  appId: " + paramString.appId);
        locala.log("  link: " + paramString.link);
        locala.log("  mediaId: " + paramString.SAh);
        locala.log("  brandId: " + paramString.fuO);
      }
      paramString = this.field_favProto.syG.iterator();
      int i = 0;
      while (paramString.hasNext())
      {
        anm localanm = (anm)paramString.next();
        locala.log(" ----data item " + i + "----");
        locala.log("  dataId: " + localanm.fEa);
        locala.log("  dataType: " + localanm.dataType);
        locala.log("  dataSouceId: " + localanm.Syu);
        locala.log("  svrDataStatus: " + localanm.SyC);
        locala.log("  cdnThumbUrl: " + localanm.lmm);
        locala.log("  cdnThumbKey: " + localanm.SxK);
        locala.log("  cdnDataUrl: " + localanm.Rwb);
        locala.log("  cdnDataKey: " + localanm.SxP);
        locala.log("  cdnEncryVer: " + localanm.SxR);
        locala.log("  fullmd5: " + localanm.Sye);
        locala.log("  head256md5: " + localanm.Syg);
        locala.log("  fullsize: " + localanm.Syi);
        locala.log("  thumbMd5: " + localanm.Kll);
        locala.log("  thumbHead256md5: " + localanm.Syq);
        locala.log("  thumbfullsize: " + localanm.Sys);
        locala.log("  duration: " + localanm.duration);
        locala.log("  datafmt: " + localanm.Syc);
        locala.log("  streamWebUrl: " + localanm.SxU);
        locala.log("  streamDataUrl: " + localanm.SxW);
        locala.log("  streamLowBandUrl: " + localanm.SxY);
        locala.log("  ext: " + localanm.fyu);
        locala.log("  msgUuid: " + localanm.mic);
        if (localanm.SyG != null)
        {
          locala.log("  remarktime: " + localanm.SyG.Szy);
          locala.log("  ctrlflag: " + localanm.SyG.SzA);
          locala.log("  edittime: " + localanm.SyG.uTt);
          if (localanm.SyG.Szn != null)
          {
            locala.log("   ----data source item----");
            ano localano = localanm.SyG.Szn;
            locala.log("    sourceType: " + localano.sourceType);
            locala.log("    fromUser: " + localano.fLi);
            locala.log("    toUser: " + localano.toUser);
            locala.log("    realChatName: " + localano.SAb);
            locala.log("    createTime: " + localano.createTime);
            locala.log("    msgId: " + localano.msgId);
            locala.log("    eventId: " + localano.fXM);
            locala.log("    appId: " + localano.appId);
            locala.log("    link: " + localano.link);
            locala.log("    mediaId: " + localano.SAh);
            locala.log("    brandId: " + localano.fuO);
          }
          a("  ", locala, localanm.SyG.Szp);
          a("  ", locala, localanm.SyG.Szr);
          a("  ", locala, localanm.SyG.Szt);
          a("  ", locala, localanm.SyG.Szv);
          a("  ", locala, localanm.SyG.RDh);
        }
        i += 1;
      }
      a("", locala, this.field_favProto.Szp);
      a("", locala, this.field_favProto.Szr);
      a("", locala, this.field_favProto.Szt);
      a("", locala, this.field_favProto.Szv);
      a("  ", locala, this.field_favProto.RDh);
    }
    locala.log("----dump favitem end----");
    AppMethodBeat.o(103376);
  }
  
  public final boolean azT(String paramString)
  {
    AppMethodBeat.i(103382);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103382);
      return false;
    }
    Iterator localIterator = this.field_tagProto.SAP.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equals((String)localIterator.next()))
      {
        AppMethodBeat.o(103382);
        return false;
      }
    }
    this.field_tagProto.SAP.add(paramString);
    AppMethodBeat.o(103382);
    return true;
  }
  
  public final boolean djA()
  {
    return (this.field_favProto.SzA & 0x1) != 0;
  }
  
  public final boolean djB()
  {
    return (this.field_favProto.SzA & 0x2) != 0;
  }
  
  public final Bundle djC()
  {
    AppMethodBeat.i(103374);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_ctrl_flag_open_chat", djA());
    localBundle.putBoolean("key_ctrl_flag_open_sns", djB());
    if ((this.field_favProto.SzA & 0x4) != 0)
    {
      bool = true;
      localBundle.putBoolean("key_ctrl_flag_open_weibo", bool);
      if ((this.field_favProto.SzA & 0x8) == 0) {
        break label183;
      }
      bool = true;
      label73:
      localBundle.putBoolean("key_ctrl_flag_open_cplink", bool);
      if ((this.field_favProto.SzA & 0x10) == 0) {
        break label188;
      }
      bool = true;
      label96:
      localBundle.putBoolean("key_ctrl_flag_open_browser", bool);
      if ((this.field_favProto.SzA & 0x20) == 0) {
        break label193;
      }
      bool = true;
      label119:
      localBundle.putBoolean("key_ctrl_flag_open_weiyun", bool);
      if ((this.field_favProto.SzA & 0x40) == 0) {
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
      Log.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", new Object[] { localBundle.toString() });
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
  
  public final boolean djD()
  {
    return (this.field_itemStatus == 1) || (this.field_itemStatus == 4) || (this.field_itemStatus == 9) || (this.field_itemStatus == 12) || (this.field_itemStatus == 13) || (this.field_itemStatus == 15) || (this.field_itemStatus == 17);
  }
  
  public final boolean djE()
  {
    return (this.field_itemStatus == 3) || (this.field_itemStatus == 6) || (this.field_itemStatus == 11) || (this.field_itemStatus == 14) || (this.field_itemStatus == 16) || (this.field_itemStatus == 18);
  }
  
  public final boolean djF()
  {
    return this.field_itemStatus == 8;
  }
  
  public final boolean djG()
  {
    return (this.field_itemStatus == 15) || (this.field_itemStatus == 16);
  }
  
  public final boolean djH()
  {
    return (this.field_itemStatus == 12) || (this.field_itemStatus == 13) || (this.field_itemStatus == 14);
  }
  
  public final g djI()
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
    localg.wGh = this.wGh;
    localg.wGi = this.wGi;
    localg.fDQ = this.fDQ;
    AppMethodBeat.o(103384);
    return localg;
  }
  
  public final boolean djJ()
  {
    AppMethodBeat.i(103385);
    Iterator localIterator = this.field_favProto.syG.iterator();
    while (localIterator.hasNext()) {
      if (((anm)localIterator.next()).SyY != 0)
      {
        AppMethodBeat.o(103385);
        return true;
      }
    }
    AppMethodBeat.o(103385);
    return false;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
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
  
  static abstract interface a
  {
    public abstract void log(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.g
 * JD-Core Version:    0.7.0.1
 */