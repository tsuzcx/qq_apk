package com.tencent.mm.plugin.fav.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.cb;
import com.tencent.mm.plugin.fav.a.a.a;
import com.tencent.mm.plugin.fav.a.a.b;
import com.tencent.mm.plugin.fav.a.a.c;
import com.tencent.mm.plugin.fav.a.a.d;
import com.tencent.mm.plugin.findersdk.a.q;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.arp;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class g
  extends cb
{
  private static g.a Act;
  private static g.a Acu;
  public static IAutoDBItem.MAutoDBInfo info;
  public boolean Acq;
  public g Acr;
  public String Acs;
  public String hIG;
  
  static
  {
    AppMethodBeat.i(103387);
    info = cb.aJm();
    Act = new g.1();
    Acu = new g.2();
    AppMethodBeat.o(103387);
  }
  
  public g()
  {
    AppMethodBeat.i(103372);
    this.Acq = false;
    this.Acr = null;
    this.hIG = "";
    this.Acs = "";
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
    dQk();
    AppMethodBeat.o(103372);
  }
  
  private static void a(String paramString, g.a parama, arm paramarm)
  {
    AppMethodBeat.i(103380);
    if (paramarm == null)
    {
      AppMethodBeat.o(103380);
      return;
    }
    parama.log(paramString + " ----loc item----");
    parama.log(paramString + "  lng: " + paramarm.lng);
    parama.log(paramString + "  lat: " + paramarm.lat);
    parama.log(paramString + "  scale: " + paramarm.hQp);
    parama.log(paramString + "  label: " + paramarm.label);
    parama.log(paramString + "  poiname: " + paramarm.hVI);
    AppMethodBeat.o(103380);
  }
  
  private static void a(String paramString, g.a parama, arp paramarp)
  {
    AppMethodBeat.i(103378);
    if (paramarp == null)
    {
      AppMethodBeat.o(103378);
      return;
    }
    parama.log(paramString + " ----noteInfoItem item----");
    parama.log(paramString + "  author: " + paramarp.ZBm);
    parama.log(paramString + "  editor: " + paramarp.ZBn);
    AppMethodBeat.o(103378);
  }
  
  private static void a(String paramString, g.a parama, aru paramaru)
  {
    AppMethodBeat.i(103379);
    if (paramaru == null)
    {
      AppMethodBeat.o(103379);
      return;
    }
    parama.log(paramString + " ----product item----");
    parama.log(paramString + "  title: " + paramaru.title);
    parama.log(paramString + "  desc: " + paramaru.desc);
    parama.log(paramString + "  thumbUrl: " + paramaru.thumbUrl);
    parama.log(paramString + "  type: " + paramaru.type);
    AppMethodBeat.o(103379);
  }
  
  private static void a(String paramString, g.a parama, ase paramase)
  {
    AppMethodBeat.i(103377);
    if (paramase == null)
    {
      AppMethodBeat.o(103377);
      return;
    }
    parama.log(paramString + " ----tv item----");
    parama.log(paramString + "  title: " + paramase.title);
    parama.log(paramString + "  desc: " + paramase.desc);
    parama.log(paramString + "  thumbUrl: " + paramase.thumbUrl);
    AppMethodBeat.o(103377);
  }
  
  private static void a(String paramString, g.a parama, ask paramask)
  {
    AppMethodBeat.i(103381);
    if (paramask == null)
    {
      AppMethodBeat.o(103381);
      return;
    }
    parama.log(paramString + " ----url item----");
    parama.log(paramString + "  title: " + paramask.title);
    parama.log(paramString + "  desc: " + paramask.desc);
    parama.log(paramString + "  cleanUrl: " + paramask.ZBV);
    parama.log(paramString + "  thumbUrl: " + paramask.thumbUrl);
    parama.log(paramString + "  opencache: " + paramask.ZBX);
    parama.log(paramString + "  topstory: " + paramask.ZCa);
    AppMethodBeat.o(103381);
  }
  
  private void dQk()
  {
    AppMethodBeat.i(103373);
    this.field_favProto = new arv();
    asb localasb = new asb();
    localasb.axH(1);
    this.field_favProto.a(localasb);
    this.field_favProto.c(new ask());
    this.field_favProto.f(new arn());
    this.field_favProto.d(new arm());
    this.field_favProto.b(new aru());
    this.field_favProto.b(new ase());
    this.field_favProto.h(new bvl());
    this.field_favProto.axF(-1);
    this.field_tagProto = new asi();
    this.field_favProto.a(new arp());
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
    if (!Util.isNullOrNil(((arv)localObject2).title)) {
      localStringBuilder.append("<title>").append(Util.escapeStringForXml(((arv)localObject2).title)).append("</title>");
    }
    if (!Util.isNullOrNil(((arv)localObject2).desc)) {
      localStringBuilder.append("<desc>").append(Util.escapeStringForXml(((arv)localObject2).desc)).append("</desc>");
    }
    if (((arv)localObject2).ygh > 0L) {
      localStringBuilder.append("<edittime>").append(((arv)localObject2).ygh).append("</edittime>");
    }
    if ((((arv)localObject2).YzK != null) && (!Util.isNullOrNil(((arv)localObject2).YzK.ZBn))) {
      localStringBuilder.append("<editusr>").append(((arv)localObject2).YzK.ZBn).append("</editusr>");
    }
    if (!Util.isNullOrNil(((arv)localObject2).remark))
    {
      localStringBuilder.append("<remark ");
      if (((arv)localObject2).ZAq > 0L) {
        localStringBuilder.append(" time ='").append(((arv)localObject2).ZAq).append("'");
      }
      localStringBuilder.append(">").append(Util.escapeStringForXml(((arv)localObject2).remark)).append("</remark>");
    }
    if (((arv)localObject2).ZAt) {
      localStringBuilder.append("<ctrlflag>").append(((arv)localObject2).ZAs).append("</ctrlflag>");
    }
    if (((arv)localObject2).ZBw)
    {
      localStringBuilder.append("<version>").append(((arv)localObject2).version).append("</version>");
      localObject1 = ((arv)localObject2).ZBt;
      if ((localObject1 != null) && (((asb)localObject1).computeSize() != 0)) {
        break label679;
      }
      Log.w("MicroMsg.FavSourceItemParser", "klem toXml, source item empty");
      localObject1 = "";
      label381:
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(a.fF(((arv)localObject2).vEn));
      localObject1 = paramg.field_favProto.ZAh;
      if ((localObject1 != null) && (((arm)localObject1).computeSize() != 0)) {
        break label1029;
      }
      Log.d("MicroMsg.FavLocItemParser", "klem toXml, loc item empty");
      localObject1 = "";
      label431:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.ZAj;
      if ((localObject1 != null) && (((ask)localObject1).computeSize() != 0)) {
        break label1213;
      }
      Log.d("MicroMsg.FavUrlItemParser", "klem toXml, url item empty");
      localObject1 = "";
      label468:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.ZAl;
      if ((localObject1 != null) && (((aru)localObject1).computeSize() != 0)) {
        break label1534;
      }
      Log.d("MicroMsg.FavProductItemParser", "klem toXml, product item empty");
      localObject1 = "";
      label505:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.ZAn;
      if ((localObject1 != null) && (((ase)localObject1).computeSize() != 0)) {
        break label1736;
      }
      Log.d("MicroMsg.FavTVItemParser", "klem toXml, product item empty");
      localObject1 = "";
      label542:
      localStringBuilder.append((String)localObject1);
      localObject1 = ((arv)localObject2).YzK;
      if ((localObject1 != null) && (((arp)localObject1).computeSize() != 0)) {
        break label1900;
      }
      Log.w("MicroMsg.FavNoteInfoItemParser", "klem toXml, source item empty");
      localObject1 = "";
      label577:
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(q.d(((arv)localObject2).ZAB));
      localObject1 = paramg.field_favProto.ZAw;
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
      if (((asb)localObject1).ZAP) {
        localStringBuffer2.append(" sourcetype='").append(((asb)localObject1).sourceType).append("'");
      }
      if (((asb)localObject1).ZBC) {
        localStringBuffer2.append(" sourceid='").append(((asb)localObject1).ZBB).append("'");
      }
      localStringBuffer2.append(">");
      if (((asb)localObject1).ZAQ) {
        localStringBuffer2.append("<fromusr>").append(Util.escapeStringForXml(((asb)localObject1).hQQ)).append("</fromusr>");
      }
      if (((asb)localObject1).ZAR) {
        localStringBuffer2.append("<tousr>").append(Util.escapeStringForXml(((asb)localObject1).toUser)).append("</tousr>");
      }
      if (((asb)localObject1).ZAU) {
        localStringBuffer2.append("<realchatname>").append(Util.escapeStringForXml(((asb)localObject1).ZAT)).append("</realchatname>");
      }
      if (((asb)localObject1).ZAV) {
        localStringBuffer2.append("<msgid>").append(((asb)localObject1).msgId).append("</msgid>");
      }
      if (((asb)localObject1).ZAW) {
        localStringBuffer2.append("<eventid>").append(((asb)localObject1).eventId).append("</eventid>");
      }
      if (((asb)localObject1).ZAX) {
        localStringBuffer2.append("<appid>").append(((asb)localObject1).appId).append("</appid>");
      }
      if (((asb)localObject1).ZAY) {
        localStringBuffer2.append("<link>").append(Util.escapeStringForXml(((asb)localObject1).link)).append("</link>");
      }
      if (((asb)localObject1).ZBb) {
        localStringBuffer2.append("<brandid>").append(Util.escapeStringForXml(((asb)localObject1).hzi)).append("</brandid>");
      }
      localStringBuffer2.append("</source>");
      localObject1 = localStringBuffer2.toString();
      break label381;
      label1029:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<locitem>");
      if (((arm)localObject1).ZBj) {
        localStringBuffer2.append("<label>").append(Util.escapeStringForXml(((arm)localObject1).label)).append("</label>");
      }
      if (((arm)localObject1).ZBh) {
        localStringBuffer2.append("<lat>").append(((arm)localObject1).lat).append("</lat>");
      }
      if (((arm)localObject1).ZBg) {
        localStringBuffer2.append("<lng>").append(((arm)localObject1).lng).append("</lng>");
      }
      if (((arm)localObject1).ZBi) {
        localStringBuffer2.append("<scale>").append(((arm)localObject1).hQp).append("</scale>");
      }
      if (((arm)localObject1).ZBk) {
        localStringBuffer2.append("<poiname>").append(((arm)localObject1).hVI).append("</poiname>");
      }
      localStringBuffer2.append("</locitem>");
      localObject1 = localStringBuffer2.toString();
      break label431;
      label1213:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<weburlitem>");
      if (((ask)localObject1).ZBW) {
        localStringBuffer2.append("<clean_url>").append(Util.escapeStringForXml(((ask)localObject1).ZBV)).append("</clean_url>");
      }
      if (((ask)localObject1).ZyA) {
        localStringBuffer2.append("<pagedesc>").append(Util.escapeStringForXml(((ask)localObject1).desc)).append("</pagedesc>");
      }
      if (((ask)localObject1).ZBq) {
        localStringBuffer2.append("<pagethumb_url>").append(Util.escapeStringForXml(((ask)localObject1).thumbUrl)).append("</pagethumb_url>");
      }
      if (((ask)localObject1).Zyz) {
        localStringBuffer2.append("<pagetitle>").append(Util.escapeStringForXml(((ask)localObject1).title)).append("</pagetitle>");
      }
      if (((ask)localObject1).ZBY) {
        localStringBuffer2.append("<opencache>").append(((ask)localObject1).ZBX).append("</opencache>");
      }
      if (((ask)localObject1).ZBZ) {
        localStringBuffer2.append("<contentattr>").append(((ask)localObject1).contentattr).append("</contentattr>");
      }
      if (((ask)localObject1).ZzJ) {
        localStringBuffer2.append("<canvasPageXml>").append(((ask)localObject1).canvasPageXml).append("</canvasPageXml>");
      }
      if (((ask)localObject1).ZCb) {
        localStringBuffer2.append("<wsVideoFlowXml>").append(Util.escapeStringForXml(((ask)localObject1).ZCa)).append("</wsVideoFlowXml>");
      }
      localStringBuffer2.append("<forwardflag>").append(((ask)localObject1).pdq).append("</forwardflag>");
      localStringBuffer2.append(b.a(paramg.field_favProto.WKx));
      localStringBuffer2.append("</weburlitem>");
      localObject1 = localStringBuffer2.toString();
      break label468;
      label1534:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<productitem");
      if (((aru)localObject1).ZBs) {
        localStringBuffer2.append(" type='").append(((aru)localObject1).type).append("'");
      }
      localStringBuffer2.append(">");
      if (((aru)localObject1).Zyz) {
        localStringBuffer2.append("<producttitle>").append(Util.escapeStringForXml(((aru)localObject1).title)).append("</producttitle>");
      }
      if (((aru)localObject1).ZyA) {
        localStringBuffer2.append("<productdesc>").append(Util.escapeStringForXml(((aru)localObject1).desc)).append("</productdesc>");
      }
      if (((aru)localObject1).ZBq) {
        localStringBuffer2.append("<productthumb_url>").append(Util.escapeStringForXml(((aru)localObject1).thumbUrl)).append("</productthumb_url>");
      }
      if (((aru)localObject1).ZBr) {
        localStringBuffer2.append("<productinfo>").append(Util.escapeStringForXml(((aru)localObject1).hZn)).append("</productinfo>");
      }
      localStringBuffer2.append("</productitem>");
      localObject1 = localStringBuffer2.toString();
      break label505;
      label1736:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<tvitem>");
      if (((ase)localObject1).Zyz) {
        localStringBuffer2.append("<tvtitle>").append(Util.escapeStringForXml(((ase)localObject1).title)).append("</tvtitle>");
      }
      if (((ase)localObject1).ZyA) {
        localStringBuffer2.append("<tvdesc>").append(Util.escapeStringForXml(((ase)localObject1).desc)).append("</tvdesc>");
      }
      if (((ase)localObject1).ZBq) {
        localStringBuffer2.append("<tvthumb_url>").append(Util.escapeStringForXml(((ase)localObject1).thumbUrl)).append("</tvthumb_url>");
      }
      if (((ase)localObject1).ZBr) {
        localStringBuffer2.append("<tvinfo>").append(Util.escapeStringForXml(((ase)localObject1).hZn)).append("</tvinfo>");
      }
      localStringBuffer2.append("</tvitem>");
      localObject1 = localStringBuffer2.toString();
      break label542;
      label1900:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<noteinfo>");
      localStringBuffer2.append("<noteauthor>").append(Util.escapeStringForXml(((arp)localObject1).ZBm)).append("</noteauthor>");
      localStringBuffer2.append("<noteeditor>").append(Util.escapeStringForXml(((arp)localObject1).ZBn)).append("</noteeditor>");
      localStringBuffer2.append("</noteinfo>");
      localObject1 = localStringBuffer2.toString();
      break label577;
      label1986:
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<appbranditem>");
      ((StringBuilder)localObject2).append("<username>").append(Util.escapeStringForXml(((ard)localObject1).username)).append("</username>");
      ((StringBuilder)localObject2).append("<appid>").append(Util.escapeStringForXml(((ard)localObject1).appId)).append("</appid>");
      ((StringBuilder)localObject2).append("<pkgtype>").append(((ard)localObject1).hJK).append("</pkgtype>");
      ((StringBuilder)localObject2).append("<iconurl>").append(Util.escapeStringForXml(((ard)localObject1).iconUrl)).append("</iconurl>");
      ((StringBuilder)localObject2).append("<type>").append(((ard)localObject1).type).append("</type>");
      ((StringBuilder)localObject2).append("<pagepath>").append(Util.escapeStringForXml(((ard)localObject1).hzy)).append("</pagepath>");
      ((StringBuilder)localObject2).append("<sourcedisplayname>").append(Util.escapeStringForXml(((ard)localObject1).Zyw)).append("</sourcedisplayname>");
      ((StringBuilder)localObject2).append("<version>").append(((ard)localObject1).version).append("</version>");
      ((StringBuilder)localObject2).append("<disableforward>").append(((ard)localObject1).rxs).append("</disableforward>");
      ((StringBuilder)localObject2).append("<tradingguaranteeflag>").append(((ard)localObject1).rbZ).append("</tradingguaranteeflag>");
      ((StringBuilder)localObject2).append("<showRelievedBuyFlag>").append(((ard)localObject1).nOX).append("</showRelievedBuyFlag>");
      ((StringBuilder)localObject2).append("<messageextradata>").append(String.format("<![CDATA[%s]]>", new Object[] { ((ard)localObject1).idf })).append("</messageextradata>");
      ((StringBuilder)localObject2).append("<subtype>").append(((ard)localObject1).subType).append("</subtype>");
      ((StringBuilder)localObject2).append("</appbranditem>");
    }
  }
  
  public final g atX(String paramString)
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
        dQk();
        arv localarv = this.field_favProto;
        localarv.btm((String)localMap.get(".favitem.title"));
        localarv.btn((String)localMap.get(".favitem.desc"));
        localarv.btl((String)localMap.get(".favitem.remark"));
        localarv.ys(Util.getLong((String)localMap.get(".favitem.remark.$time"), 0L));
        localObject = (String)localMap.get(".favitem.edittime");
        localarv.axG(Util.getInt((String)localMap.get(".favitem.version"), 0));
        localarv.yt(Util.getLong((String)localObject, 0L));
        localarv.axF(Util.getInt((String)localMap.get(".favitem.ctrlflag"), -1));
        localObject = localarv.ZBt;
        ((asb)localObject).axH(Util.getInt((String)localMap.get(".favitem.source" + ".$sourcetype"), 0));
        ((asb)localObject).btq((String)localMap.get(".favitem.source" + ".$sourceid"));
        ((asb)localObject).bto((String)localMap.get(".favitem.source" + ".fromusr"));
        ((asb)localObject).btp((String)localMap.get(".favitem.source" + ".tousr"));
        ((asb)localObject).btr((String)localMap.get(".favitem.source" + ".realchatname"));
        ((asb)localObject).yu(Util.getLong((String)localMap.get(".favitem.source" + ".createtime"), 0L));
        ((asb)localObject).bts((String)localMap.get(".favitem.source" + ".msgid"));
        ((asb)localObject).btt((String)localMap.get(".favitem.source" + ".eventid"));
        ((asb)localObject).btu((String)localMap.get(".favitem.source" + ".appid"));
        ((asb)localObject).btv((String)localMap.get(".favitem.source" + ".link"));
        ((asb)localObject).btw((String)localMap.get(".favitem.source" + ".brandid"));
        c.a(paramString, localarv);
        paramString = localarv.ZAh;
        if (!Util.isNullOrNil((String)localMap.get(".favitem.locitem" + ".label"))) {
          paramString.btf((String)localMap.get(".favitem.locitem" + ".label"));
        }
        if (!Util.isNullOrNil((String)localMap.get(".favitem.locitem" + ".poiname"))) {
          paramString.btg((String)localMap.get(".favitem.locitem" + ".poiname"));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".lng");
        if (!Util.isNullOrNil((String)localObject)) {
          paramString.V(Util.getDouble((String)localObject, 0.0D));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".lat");
        if (!Util.isNullOrNil((String)localObject)) {
          paramString.W(Util.getDouble((String)localObject, 0.0D));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".scale");
        if (!Util.isNullOrNil((String)localObject))
        {
          if (((String)localObject).indexOf('.') == -1) {
            continue;
          }
          paramString.axD(Util.getInt(((String)localObject).substring(0, ((String)localObject).indexOf('.')), -1));
        }
        paramString = localarv.ZAj;
        paramString.btD((String)localMap.get(".favitem.weburlitem" + ".clean_url"));
        paramString.btC((String)localMap.get(".favitem.weburlitem" + ".pagedesc"));
        paramString.btE((String)localMap.get(".favitem.weburlitem" + ".pagethumb_url"));
        paramString.btB((String)localMap.get(".favitem.weburlitem" + ".pagetitle"));
        paramString.axI(Util.getInt((String)localMap.get(".favitem.weburlitem" + ".opencache"), 0));
        paramString.axJ(Util.getInt((String)localMap.get(".favitem.weburlitem" + ".contentattr"), 0));
        paramString.btF((String)localMap.get(".favitem.weburlitem" + ".canvasPageXml"));
        paramString.btG((String)localMap.get(".favitem.weburlitem" + ".wsVideoFlowXml"));
        paramString.axK(Util.getInt((String)localMap.get(".favitem.weburlitem" + ".forwardflag"), 0));
        localarv.h(q.C(".favitem", localMap));
        if (localarv.WKx != null) {
          localarv.f(b.u(".favitem.weburlitem.appmsgshareitem", localMap));
        }
        paramString = localarv.ZAl;
        paramString.bth((String)localMap.get(".favitem.productitem" + ".producttitle"));
        paramString.bti((String)localMap.get(".favitem.productitem" + ".productdesc"));
        paramString.btj((String)localMap.get(".favitem.productitem" + ".productthumb_url"));
        paramString.btk((String)localMap.get(".favitem.productitem" + ".productinfo"));
        paramString.axE(Util.getInt((String)localMap.get(".favitem.productitem" + ".$type"), 0));
        paramString = localarv.ZAn;
        paramString.btx((String)localMap.get(".favitem.tvitem" + ".tvtitle"));
        paramString.bty((String)localMap.get(".favitem.tvitem" + ".tvdesc"));
        paramString.btz((String)localMap.get(".favitem.tvitem" + ".tvthumb_url"));
        paramString.btA((String)localMap.get(".favitem.tvitem" + ".tvinfo"));
        paramString = localarv.YzK;
        paramString.ZBm = ((String)localMap.get(".favitem.noteinfo" + ".noteauthor"));
        paramString.ZBn = ((String)localMap.get(".favitem.noteinfo" + ".noteeditor"));
        if (localMap.containsKey(".favitem.appbranditem"))
        {
          paramString = new ard();
          paramString.username = ((String)localMap.get(".favitem.appbranditem" + ".username"));
          paramString.appId = ((String)localMap.get(".favitem.appbranditem" + ".appid"));
          paramString.hJK = Util.getInt((String)localMap.get(".favitem.appbranditem" + ".pkgtype"), 0);
          paramString.iconUrl = ((String)localMap.get(".favitem.appbranditem" + ".iconurl"));
          paramString.type = Util.getInt((String)localMap.get(".favitem.appbranditem" + ".type"), 0);
          paramString.hzy = ((String)localMap.get(".favitem.appbranditem" + ".pagepath"));
          paramString.Zyw = ((String)localMap.get(".favitem.appbranditem" + ".sourcedisplayname"));
          paramString.version = Util.getInt((String)localMap.get(".favitem.appbranditem" + ".version"), 0);
          paramString.rxs = Util.getInt((String)localMap.get(".favitem.appbranditem" + ".disableforward"), 0);
          paramString.rbZ = Util.getInt((String)localMap.get(".favitem.appbranditem" + ".tradingguaranteeflag"), 0);
          paramString.nOX = Util.getInt((String)localMap.get(".favitem.appbranditem" + ".showRelievedBuyFlag"), 0);
          paramString.idf = ((String)localMap.get(".favitem.appbranditem" + ".messageextradata"));
          paramString.subType = Util.getInt((String)localMap.get(".favitem.appbranditem" + ".subtype"), 0);
          localarv.c(paramString);
        }
        if (localarv.WKx != null) {
          localarv.f(b.u(".favitem.weburlitem.appmsgshareitem", localMap));
        }
        if (this.field_favProto.ZBt != null)
        {
          paramString = this.field_favProto.ZBt;
          this.field_sourceId = paramString.ZBB;
          this.field_sourceType = paramString.sourceType;
          this.field_fromUser = paramString.hQQ;
          this.field_toUser = paramString.toUser;
        }
        this.field_edittime = this.field_favProto.ygh;
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
      paramString.axD(Util.getInt((String)localObject, -1));
    }
  }
  
  public final void atY(String paramString)
  {
    AppMethodBeat.i(103376);
    g.a locala = Act;
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
      locala.log("remarktime: " + this.field_favProto.ZAq);
      locala.log("dataitemCount: " + this.field_favProto.vEn.size());
      if (this.field_favProto.ZBt != null)
      {
        locala.log(" ----source item----");
        paramString = this.field_favProto.ZBt;
        locala.log("  sourceType: " + paramString.sourceType);
        locala.log("  fromUser: " + paramString.hQQ);
        locala.log("  toUser: " + paramString.toUser);
        locala.log("  sourceId: " + paramString.ZBB);
        locala.log("  realChatName: " + paramString.ZAT);
        locala.log("  createTime: " + paramString.createTime);
        locala.log("  msgId: " + paramString.msgId);
        locala.log("  eventId: " + paramString.eventId);
        locala.log("  appId: " + paramString.appId);
        locala.log("  link: " + paramString.link);
        locala.log("  mediaId: " + paramString.ZAZ);
        locala.log("  brandId: " + paramString.hzi);
      }
      paramString = this.field_favProto.vEn.iterator();
      int i = 0;
      while (paramString.hasNext())
      {
        arf localarf = (arf)paramString.next();
        locala.log(" ----data item " + i + "----");
        locala.log("  dataId: " + localarf.hIQ);
        locala.log("  dataType: " + localarf.dataType);
        locala.log("  dataSouceId: " + localarf.Zzm);
        locala.log("  svrDataStatus: " + localarf.Zzu);
        locala.log("  cdnThumbUrl: " + localarf.nRr);
        locala.log("  cdnThumbKey: " + localarf.ZyC);
        locala.log("  cdnDataUrl: " + localarf.Ysw);
        locala.log("  cdnDataKey: " + localarf.ZyH);
        locala.log("  cdnEncryVer: " + localarf.ZyJ);
        locala.log("  fullmd5: " + localarf.ZyW);
        locala.log("  head256md5: " + localarf.ZyY);
        locala.log("  fullsize: " + localarf.Zza);
        locala.log("  thumbMd5: " + localarf.QJs);
        locala.log("  thumbHead256md5: " + localarf.Zzi);
        locala.log("  thumbfullsize: " + localarf.Zzk);
        locala.log("  duration: " + localarf.duration);
        locala.log("  datafmt: " + localarf.ZyU);
        locala.log("  streamWebUrl: " + localarf.ZyM);
        locala.log("  streamDataUrl: " + localarf.ZyO);
        locala.log("  streamLowBandUrl: " + localarf.ZyQ);
        locala.log("  ext: " + localarf.hDd);
        locala.log("  msgUuid: " + localarf.pbn);
        if (localarf.Zzy != null)
        {
          locala.log("  remarktime: " + localarf.Zzy.ZAq);
          locala.log("  ctrlflag: " + localarf.Zzy.ZAs);
          locala.log("  edittime: " + localarf.Zzy.ygh);
          if (localarf.Zzy.ZAf != null)
          {
            locala.log("   ----data source item----");
            arh localarh = localarf.Zzy.ZAf;
            locala.log("    sourceType: " + localarh.sourceType);
            locala.log("    fromUser: " + localarh.hQQ);
            locala.log("    toUser: " + localarh.toUser);
            locala.log("    realChatName: " + localarh.ZAT);
            locala.log("    createTime: " + localarh.createTime);
            locala.log("    msgId: " + localarh.msgId);
            locala.log("    eventId: " + localarh.eventId);
            locala.log("    appId: " + localarh.appId);
            locala.log("    link: " + localarh.link);
            locala.log("    mediaId: " + localarh.ZAZ);
            locala.log("    brandId: " + localarh.hzi);
          }
          a("  ", locala, localarf.Zzy.ZAh);
          a("  ", locala, localarf.Zzy.ZAj);
          a("  ", locala, localarf.Zzy.ZAl);
          a("  ", locala, localarf.Zzy.ZAn);
          a("  ", locala, localarf.Zzy.YzK);
        }
        i += 1;
      }
      a("", locala, this.field_favProto.ZAh);
      a("", locala, this.field_favProto.ZAj);
      a("", locala, this.field_favProto.ZAl);
      a("", locala, this.field_favProto.ZAn);
      a("  ", locala, this.field_favProto.YzK);
    }
    locala.log("----dump favitem end----");
    AppMethodBeat.o(103376);
  }
  
  public final boolean atZ(String paramString)
  {
    AppMethodBeat.i(103382);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103382);
      return false;
    }
    Iterator localIterator = this.field_tagProto.ZBH.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equals((String)localIterator.next()))
      {
        AppMethodBeat.o(103382);
        return false;
      }
    }
    this.field_tagProto.ZBH.add(paramString);
    AppMethodBeat.o(103382);
    return true;
  }
  
  public final boolean dQl()
  {
    return (this.field_favProto.ZAs & 0x1) != 0;
  }
  
  public final boolean dQm()
  {
    return (this.field_favProto.ZAs & 0x2) != 0;
  }
  
  public final Bundle dQn()
  {
    AppMethodBeat.i(103374);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_ctrl_flag_open_chat", dQl());
    localBundle.putBoolean("key_ctrl_flag_open_sns", dQm());
    if ((this.field_favProto.ZAs & 0x4) != 0)
    {
      bool = true;
      localBundle.putBoolean("key_ctrl_flag_open_weibo", bool);
      if ((this.field_favProto.ZAs & 0x8) == 0) {
        break label183;
      }
      bool = true;
      label73:
      localBundle.putBoolean("key_ctrl_flag_open_cplink", bool);
      if ((this.field_favProto.ZAs & 0x10) == 0) {
        break label188;
      }
      bool = true;
      label96:
      localBundle.putBoolean("key_ctrl_flag_open_browser", bool);
      if ((this.field_favProto.ZAs & 0x20) == 0) {
        break label193;
      }
      bool = true;
      label119:
      localBundle.putBoolean("key_ctrl_flag_open_weiyun", bool);
      if ((this.field_favProto.ZAs & 0x40) == 0) {
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
  
  public final boolean dQo()
  {
    return (this.field_itemStatus == 1) || (this.field_itemStatus == 4) || (this.field_itemStatus == 9) || (this.field_itemStatus == 12) || (this.field_itemStatus == 13) || (this.field_itemStatus == 15) || (this.field_itemStatus == 17);
  }
  
  public final boolean dQp()
  {
    return (this.field_itemStatus == 3) || (this.field_itemStatus == 6) || (this.field_itemStatus == 11) || (this.field_itemStatus == 14) || (this.field_itemStatus == 16) || (this.field_itemStatus == 18);
  }
  
  public final boolean dQq()
  {
    return this.field_itemStatus == 8;
  }
  
  public final boolean dQr()
  {
    return (this.field_itemStatus == 15) || (this.field_itemStatus == 16);
  }
  
  public final boolean dQs()
  {
    return (this.field_itemStatus == 12) || (this.field_itemStatus == 13) || (this.field_itemStatus == 14);
  }
  
  public final g dQt()
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
    localg.Acq = this.Acq;
    localg.Acr = this.Acr;
    localg.hIG = this.hIG;
    AppMethodBeat.o(103384);
    return localg;
  }
  
  public final boolean dQu()
  {
    AppMethodBeat.i(103385);
    Iterator localIterator = this.field_favProto.vEn.iterator();
    while (localIterator.hasNext()) {
      if (((arf)localIterator.next()).ZzQ != 0)
      {
        AppMethodBeat.o(103385);
        return true;
      }
    }
    AppMethodBeat.o(103385);
    return false;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.g
 * JD-Core Version:    0.7.0.1
 */