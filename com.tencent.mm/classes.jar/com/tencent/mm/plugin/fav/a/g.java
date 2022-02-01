package com.tencent.mm.plugin.fav.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.by;
import com.tencent.mm.plugin.fav.a.a.a;
import com.tencent.mm.plugin.fav.a.a.b;
import com.tencent.mm.plugin.fav.a.a.c;
import com.tencent.mm.plugin.fav.a.a.d;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.bcj;
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
  private static g.a tah;
  private static g.a tai;
  public String dLb;
  public boolean tad;
  public g tae;
  public String taf;
  
  static
  {
    AppMethodBeat.i(103387);
    info = by.ajs();
    tah = new g.1();
    tai = new g.2();
    AppMethodBeat.o(103387);
  }
  
  public g()
  {
    AppMethodBeat.i(103372);
    this.tad = false;
    this.tae = null;
    this.dLb = "";
    this.taf = "";
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
    cUt();
    AppMethodBeat.o(103372);
  }
  
  private static void a(String paramString, g.a parama, ams paramams)
  {
    AppMethodBeat.i(103380);
    if (paramams == null)
    {
      AppMethodBeat.o(103380);
      return;
    }
    parama.log(paramString + " ----loc item----");
    parama.log(paramString + "  lng: " + paramams.lng);
    parama.log(paramString + "  lat: " + paramams.lat);
    parama.log(paramString + "  scale: " + paramams.dRt);
    parama.log(paramString + "  label: " + paramams.label);
    parama.log(paramString + "  poiname: " + paramams.dWi);
    AppMethodBeat.o(103380);
  }
  
  private static void a(String paramString, g.a parama, amv paramamv)
  {
    AppMethodBeat.i(103378);
    if (paramamv == null)
    {
      AppMethodBeat.o(103378);
      return;
    }
    parama.log(paramString + " ----noteInfoItem item----");
    parama.log(paramString + "  author: " + paramamv.LxT);
    parama.log(paramString + "  editor: " + paramamv.LxU);
    AppMethodBeat.o(103378);
  }
  
  private static void a(String paramString, g.a parama, ana paramana)
  {
    AppMethodBeat.i(103379);
    if (paramana == null)
    {
      AppMethodBeat.o(103379);
      return;
    }
    parama.log(paramString + " ----product item----");
    parama.log(paramString + "  title: " + paramana.title);
    parama.log(paramString + "  desc: " + paramana.desc);
    parama.log(paramString + "  thumbUrl: " + paramana.thumbUrl);
    parama.log(paramString + "  type: " + paramana.type);
    AppMethodBeat.o(103379);
  }
  
  private static void a(String paramString, g.a parama, ank paramank)
  {
    AppMethodBeat.i(103377);
    if (paramank == null)
    {
      AppMethodBeat.o(103377);
      return;
    }
    parama.log(paramString + " ----tv item----");
    parama.log(paramString + "  title: " + paramank.title);
    parama.log(paramString + "  desc: " + paramank.desc);
    parama.log(paramString + "  thumbUrl: " + paramank.thumbUrl);
    AppMethodBeat.o(103377);
  }
  
  private static void a(String paramString, g.a parama, anq paramanq)
  {
    AppMethodBeat.i(103381);
    if (paramanq == null)
    {
      AppMethodBeat.o(103381);
      return;
    }
    parama.log(paramString + " ----url item----");
    parama.log(paramString + "  title: " + paramanq.title);
    parama.log(paramString + "  desc: " + paramanq.desc);
    parama.log(paramString + "  cleanUrl: " + paramanq.LyC);
    parama.log(paramString + "  thumbUrl: " + paramanq.thumbUrl);
    parama.log(paramString + "  opencache: " + paramanq.LyE);
    parama.log(paramString + "  topstory: " + paramanq.LyH);
    AppMethodBeat.o(103381);
  }
  
  private void cUt()
  {
    AppMethodBeat.i(103373);
    this.field_favProto = new anb();
    anh localanh = new anh();
    localanh.ajm(1);
    this.field_favProto.a(localanh);
    this.field_favProto.b(new anq());
    this.field_favProto.f(new amt());
    this.field_favProto.d(new ams());
    this.field_favProto.b(new ana());
    this.field_favProto.b(new ank());
    this.field_favProto.d(new bcj());
    this.field_favProto.ajk(-1);
    this.field_tagProto = new ano();
    this.field_favProto.a(new amv());
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
    if (!Util.isNullOrNil(((anb)localObject2).title)) {
      localStringBuilder.append("<title>").append(Util.escapeStringForXml(((anb)localObject2).title)).append("</title>");
    }
    if (!Util.isNullOrNil(((anb)localObject2).desc)) {
      localStringBuilder.append("<desc>").append(Util.escapeStringForXml(((anb)localObject2).desc)).append("</desc>");
    }
    if (((anb)localObject2).rnM > 0L) {
      localStringBuilder.append("<edittime>").append(((anb)localObject2).rnM).append("</edittime>");
    }
    if ((((anb)localObject2).KBr != null) && (!Util.isNullOrNil(((anb)localObject2).KBr.LxU))) {
      localStringBuilder.append("<editusr>").append(((anb)localObject2).KBr.LxU).append("</editusr>");
    }
    if (!Util.isNullOrNil(((anb)localObject2).remark))
    {
      localStringBuilder.append("<remark ");
      if (((anb)localObject2).LwZ > 0L) {
        localStringBuilder.append(" time ='").append(((anb)localObject2).LwZ).append("'");
      }
      localStringBuilder.append(">").append(Util.escapeStringForXml(((anb)localObject2).remark)).append("</remark>");
    }
    if (((anb)localObject2).Lxc) {
      localStringBuilder.append("<ctrlflag>").append(((anb)localObject2).Lxb).append("</ctrlflag>");
    }
    if (((anb)localObject2).Lyd)
    {
      localStringBuilder.append("<version>").append(((anb)localObject2).version).append("</version>");
      localObject1 = ((anb)localObject2).Lya;
      if ((localObject1 != null) && (((anh)localObject1).computeSize() != 0)) {
        break label679;
      }
      Log.w("MicroMsg.FavSourceItemParser", "klem toXml, source item empty");
      localObject1 = "";
      label381:
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(a.dE(((anb)localObject2).ppH));
      localObject1 = paramg.field_favProto.LwQ;
      if ((localObject1 != null) && (((ams)localObject1).computeSize() != 0)) {
        break label1029;
      }
      Log.d("MicroMsg.FavLocItemParser", "klem toXml, loc item empty");
      localObject1 = "";
      label431:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.LwS;
      if ((localObject1 != null) && (((anq)localObject1).computeSize() != 0)) {
        break label1213;
      }
      Log.d("MicroMsg.FavUrlItemParser", "klem toXml, url item empty");
      localObject1 = "";
      label468:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.LwU;
      if ((localObject1 != null) && (((ana)localObject1).computeSize() != 0)) {
        break label1512;
      }
      Log.d("MicroMsg.FavProductItemParser", "klem toXml, product item empty");
      localObject1 = "";
      label505:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.LwW;
      if ((localObject1 != null) && (((ank)localObject1).computeSize() != 0)) {
        break label1714;
      }
      Log.d("MicroMsg.FavTVItemParser", "klem toXml, product item empty");
      localObject1 = "";
      label542:
      localStringBuilder.append((String)localObject1);
      localObject1 = ((anb)localObject2).KBr;
      if ((localObject1 != null) && (((amv)localObject1).computeSize() != 0)) {
        break label1878;
      }
      Log.w("MicroMsg.FavNoteInfoItemParser", "klem toXml, source item empty");
      localObject1 = "";
      label577:
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(l.b(((anb)localObject2).Lxk));
      localObject1 = paramg.field_favProto.Lxf;
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
      if (((anh)localObject1).Lxw) {
        localStringBuffer2.append(" sourcetype='").append(((anh)localObject1).sourceType).append("'");
      }
      if (((anh)localObject1).Lyj) {
        localStringBuffer2.append(" sourceid='").append(((anh)localObject1).Lyi).append("'");
      }
      localStringBuffer2.append(">");
      if (((anh)localObject1).Lxx) {
        localStringBuffer2.append("<fromusr>").append(Util.escapeStringForXml(((anh)localObject1).dRL)).append("</fromusr>");
      }
      if (((anh)localObject1).Lxy) {
        localStringBuffer2.append("<tousr>").append(Util.escapeStringForXml(((anh)localObject1).toUser)).append("</tousr>");
      }
      if (((anh)localObject1).LxB) {
        localStringBuffer2.append("<realchatname>").append(Util.escapeStringForXml(((anh)localObject1).LxA)).append("</realchatname>");
      }
      if (((anh)localObject1).LxC) {
        localStringBuffer2.append("<msgid>").append(((anh)localObject1).msgId).append("</msgid>");
      }
      if (((anh)localObject1).LxD) {
        localStringBuffer2.append("<eventid>").append(((anh)localObject1).edD).append("</eventid>");
      }
      if (((anh)localObject1).LxE) {
        localStringBuffer2.append("<appid>").append(((anh)localObject1).appId).append("</appid>");
      }
      if (((anh)localObject1).LxF) {
        localStringBuffer2.append("<link>").append(Util.escapeStringForXml(((anh)localObject1).link)).append("</link>");
      }
      if (((anh)localObject1).LxI) {
        localStringBuffer2.append("<brandid>").append(Util.escapeStringForXml(((anh)localObject1).dCl)).append("</brandid>");
      }
      localStringBuffer2.append("</source>");
      localObject1 = localStringBuffer2.toString();
      break label381;
      label1029:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<locitem>");
      if (((ams)localObject1).LxQ) {
        localStringBuffer2.append("<label>").append(Util.escapeStringForXml(((ams)localObject1).label)).append("</label>");
      }
      if (((ams)localObject1).LxO) {
        localStringBuffer2.append("<lat>").append(((ams)localObject1).lat).append("</lat>");
      }
      if (((ams)localObject1).LxN) {
        localStringBuffer2.append("<lng>").append(((ams)localObject1).lng).append("</lng>");
      }
      if (((ams)localObject1).LxP) {
        localStringBuffer2.append("<scale>").append(((ams)localObject1).dRt).append("</scale>");
      }
      if (((ams)localObject1).LxR) {
        localStringBuffer2.append("<poiname>").append(((ams)localObject1).dWi).append("</poiname>");
      }
      localStringBuffer2.append("</locitem>");
      localObject1 = localStringBuffer2.toString();
      break label431;
      label1213:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<weburlitem>");
      if (((anq)localObject1).LyD) {
        localStringBuffer2.append("<clean_url>").append(Util.escapeStringForXml(((anq)localObject1).LyC)).append("</clean_url>");
      }
      if (((anq)localObject1).Lvi) {
        localStringBuffer2.append("<pagedesc>").append(Util.escapeStringForXml(((anq)localObject1).desc)).append("</pagedesc>");
      }
      if (((anq)localObject1).LxX) {
        localStringBuffer2.append("<pagethumb_url>").append(Util.escapeStringForXml(((anq)localObject1).thumbUrl)).append("</pagethumb_url>");
      }
      if (((anq)localObject1).Lvh) {
        localStringBuffer2.append("<pagetitle>").append(Util.escapeStringForXml(((anq)localObject1).title)).append("</pagetitle>");
      }
      if (((anq)localObject1).LyF) {
        localStringBuffer2.append("<opencache>").append(((anq)localObject1).LyE).append("</opencache>");
      }
      if (((anq)localObject1).LyG) {
        localStringBuffer2.append("<contentattr>").append(((anq)localObject1).contentattr).append("</contentattr>");
      }
      if (((anq)localObject1).Lws) {
        localStringBuffer2.append("<canvasPageXml>").append(((anq)localObject1).canvasPageXml).append("</canvasPageXml>");
      }
      if (((anq)localObject1).LyI) {
        localStringBuffer2.append("<wsVideoFlowXml>").append(Util.escapeStringForXml(((anq)localObject1).LyH)).append("</wsVideoFlowXml>");
      }
      localStringBuffer2.append(b.a(paramg.field_favProto.IXu));
      localStringBuffer2.append("</weburlitem>");
      localObject1 = localStringBuffer2.toString();
      break label468;
      label1512:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<productitem");
      if (((ana)localObject1).LxZ) {
        localStringBuffer2.append(" type='").append(((ana)localObject1).type).append("'");
      }
      localStringBuffer2.append(">");
      if (((ana)localObject1).Lvh) {
        localStringBuffer2.append("<producttitle>").append(Util.escapeStringForXml(((ana)localObject1).title)).append("</producttitle>");
      }
      if (((ana)localObject1).Lvi) {
        localStringBuffer2.append("<productdesc>").append(Util.escapeStringForXml(((ana)localObject1).desc)).append("</productdesc>");
      }
      if (((ana)localObject1).LxX) {
        localStringBuffer2.append("<productthumb_url>").append(Util.escapeStringForXml(((ana)localObject1).thumbUrl)).append("</productthumb_url>");
      }
      if (((ana)localObject1).LxY) {
        localStringBuffer2.append("<productinfo>").append(Util.escapeStringForXml(((ana)localObject1).info)).append("</productinfo>");
      }
      localStringBuffer2.append("</productitem>");
      localObject1 = localStringBuffer2.toString();
      break label505;
      label1714:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<tvitem>");
      if (((ank)localObject1).Lvh) {
        localStringBuffer2.append("<tvtitle>").append(Util.escapeStringForXml(((ank)localObject1).title)).append("</tvtitle>");
      }
      if (((ank)localObject1).Lvi) {
        localStringBuffer2.append("<tvdesc>").append(Util.escapeStringForXml(((ank)localObject1).desc)).append("</tvdesc>");
      }
      if (((ank)localObject1).LxX) {
        localStringBuffer2.append("<tvthumb_url>").append(Util.escapeStringForXml(((ank)localObject1).thumbUrl)).append("</tvthumb_url>");
      }
      if (((ank)localObject1).LxY) {
        localStringBuffer2.append("<tvinfo>").append(Util.escapeStringForXml(((ank)localObject1).info)).append("</tvinfo>");
      }
      localStringBuffer2.append("</tvitem>");
      localObject1 = localStringBuffer2.toString();
      break label542;
      label1878:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<noteinfo>");
      localStringBuffer2.append("<noteauthor>").append(Util.escapeStringForXml(((amv)localObject1).LxT)).append("</noteauthor>");
      localStringBuffer2.append("<noteeditor>").append(Util.escapeStringForXml(((amv)localObject1).LxU)).append("</noteeditor>");
      localStringBuffer2.append("</noteinfo>");
      localObject1 = localStringBuffer2.toString();
      break label577;
      label1964:
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<appbranditem>");
      ((StringBuilder)localObject2).append("<username>").append(Util.escapeStringForXml(((amj)localObject1).username)).append("</username>");
      ((StringBuilder)localObject2).append("<appid>").append(Util.escapeStringForXml(((amj)localObject1).appId)).append("</appid>");
      ((StringBuilder)localObject2).append("<pkgtype>").append(((amj)localObject1).dMe).append("</pkgtype>");
      ((StringBuilder)localObject2).append("<iconurl>").append(Util.escapeStringForXml(((amj)localObject1).iconUrl)).append("</iconurl>");
      ((StringBuilder)localObject2).append("<type>").append(((amj)localObject1).type).append("</type>");
      ((StringBuilder)localObject2).append("<pagepath>").append(Util.escapeStringForXml(((amj)localObject1).dCx)).append("</pagepath>");
      ((StringBuilder)localObject2).append("<sourcedisplayname>").append(Util.escapeStringForXml(((amj)localObject1).Lve)).append("</sourcedisplayname>");
      ((StringBuilder)localObject2).append("<version>").append(((amj)localObject1).version).append("</version>");
      ((StringBuilder)localObject2).append("<disableforward>").append(((amj)localObject1).lyE).append("</disableforward>");
      ((StringBuilder)localObject2).append("<tradingguaranteeflag>").append(((amj)localObject1).leb).append("</tradingguaranteeflag>");
      ((StringBuilder)localObject2).append("<messageextradata>").append(String.format("<![CDATA[%s]]>", new Object[] { ((amj)localObject1).eda })).append("</messageextradata>");
      ((StringBuilder)localObject2).append("<subtype>").append(((amj)localObject1).subType).append("</subtype>");
      ((StringBuilder)localObject2).append("</appbranditem>");
    }
  }
  
  public final g arQ(String paramString)
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
        cUt();
        anb localanb = this.field_favProto;
        localanb.bhd((String)localMap.get(".favitem.title"));
        localanb.bhe((String)localMap.get(".favitem.desc"));
        localanb.bhc((String)localMap.get(".favitem.remark"));
        localanb.My(Util.getLong((String)localMap.get(".favitem.remark.$time"), 0L));
        localObject = (String)localMap.get(".favitem.edittime");
        localanb.ajl(Util.getInt((String)localMap.get(".favitem.version"), 0));
        localanb.Mz(Util.getLong((String)localObject, 0L));
        localanb.ajk(Util.getInt((String)localMap.get(".favitem.ctrlflag"), -1));
        localObject = localanb.Lya;
        ((anh)localObject).ajm(Util.getInt((String)localMap.get(".favitem.source" + ".$sourcetype"), 0));
        ((anh)localObject).bhh((String)localMap.get(".favitem.source" + ".$sourceid"));
        ((anh)localObject).bhf((String)localMap.get(".favitem.source" + ".fromusr"));
        ((anh)localObject).bhg((String)localMap.get(".favitem.source" + ".tousr"));
        ((anh)localObject).bhi((String)localMap.get(".favitem.source" + ".realchatname"));
        ((anh)localObject).MA(Util.getLong((String)localMap.get(".favitem.source" + ".createtime"), 0L));
        ((anh)localObject).bhj((String)localMap.get(".favitem.source" + ".msgid"));
        ((anh)localObject).bhk((String)localMap.get(".favitem.source" + ".eventid"));
        ((anh)localObject).bhl((String)localMap.get(".favitem.source" + ".appid"));
        ((anh)localObject).bhm((String)localMap.get(".favitem.source" + ".link"));
        ((anh)localObject).bhn((String)localMap.get(".favitem.source" + ".brandid"));
        c.a(paramString, localanb);
        paramString = localanb.LwQ;
        if (!Util.isNullOrNil((String)localMap.get(".favitem.locitem" + ".label"))) {
          paramString.bgW((String)localMap.get(".favitem.locitem" + ".label"));
        }
        if (!Util.isNullOrNil((String)localMap.get(".favitem.locitem" + ".poiname"))) {
          paramString.bgX((String)localMap.get(".favitem.locitem" + ".poiname"));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".lng");
        if (!Util.isNullOrNil((String)localObject)) {
          paramString.B(Util.getDouble((String)localObject, 0.0D));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".lat");
        if (!Util.isNullOrNil((String)localObject)) {
          paramString.C(Util.getDouble((String)localObject, 0.0D));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".scale");
        if (!Util.isNullOrNil((String)localObject))
        {
          if (((String)localObject).indexOf('.') == -1) {
            continue;
          }
          paramString.aji(Util.getInt(((String)localObject).substring(0, ((String)localObject).indexOf('.')), -1));
        }
        paramString = localanb.LwS;
        paramString.bhu((String)localMap.get(".favitem.weburlitem" + ".clean_url"));
        paramString.bht((String)localMap.get(".favitem.weburlitem" + ".pagedesc"));
        paramString.bhv((String)localMap.get(".favitem.weburlitem" + ".pagethumb_url"));
        paramString.bhs((String)localMap.get(".favitem.weburlitem" + ".pagetitle"));
        paramString.ajn(Util.getInt((String)localMap.get(".favitem.weburlitem" + ".opencache"), 0));
        paramString.ajo(Util.getInt((String)localMap.get(".favitem.weburlitem" + ".contentattr"), 0));
        paramString.bhw((String)localMap.get(".favitem.weburlitem" + ".canvasPageXml"));
        paramString.bhx((String)localMap.get(".favitem.weburlitem" + ".wsVideoFlowXml"));
        localanb.d(l.x(".favitem", localMap));
        if (localanb.IXu != null) {
          localanb.f(b.t(".favitem.weburlitem.appmsgshareitem", localMap));
        }
        paramString = localanb.LwU;
        paramString.bgY((String)localMap.get(".favitem.productitem" + ".producttitle"));
        paramString.bgZ((String)localMap.get(".favitem.productitem" + ".productdesc"));
        paramString.bha((String)localMap.get(".favitem.productitem" + ".productthumb_url"));
        paramString.bhb((String)localMap.get(".favitem.productitem" + ".productinfo"));
        paramString.ajj(Util.getInt((String)localMap.get(".favitem.productitem" + ".$type"), 0));
        paramString = localanb.LwW;
        paramString.bho((String)localMap.get(".favitem.tvitem" + ".tvtitle"));
        paramString.bhp((String)localMap.get(".favitem.tvitem" + ".tvdesc"));
        paramString.bhq((String)localMap.get(".favitem.tvitem" + ".tvthumb_url"));
        paramString.bhr((String)localMap.get(".favitem.tvitem" + ".tvinfo"));
        paramString = localanb.KBr;
        paramString.LxT = ((String)localMap.get(".favitem.noteinfo" + ".noteauthor"));
        paramString.LxU = ((String)localMap.get(".favitem.noteinfo" + ".noteeditor"));
        if (localMap.containsKey(".favitem.appbranditem"))
        {
          paramString = new amj();
          paramString.username = ((String)localMap.get(".favitem.appbranditem" + ".username"));
          paramString.appId = ((String)localMap.get(".favitem.appbranditem" + ".appid"));
          paramString.dMe = Util.getInt((String)localMap.get(".favitem.appbranditem" + ".pkgtype"), 0);
          paramString.iconUrl = ((String)localMap.get(".favitem.appbranditem" + ".iconurl"));
          paramString.type = Util.getInt((String)localMap.get(".favitem.appbranditem" + ".type"), 0);
          paramString.dCx = ((String)localMap.get(".favitem.appbranditem" + ".pagepath"));
          paramString.Lve = ((String)localMap.get(".favitem.appbranditem" + ".sourcedisplayname"));
          paramString.version = Util.getInt((String)localMap.get(".favitem.appbranditem" + ".version"), 0);
          paramString.lyE = Util.getInt((String)localMap.get(".favitem.appbranditem" + ".disableforward"), 0);
          paramString.leb = Util.getInt((String)localMap.get(".favitem.appbranditem" + ".tradingguaranteeflag"), 0);
          paramString.eda = ((String)localMap.get(".favitem.appbranditem" + ".messageextradata"));
          paramString.subType = Util.getInt((String)localMap.get(".favitem.appbranditem" + ".subtype"), 0);
          localanb.c(paramString);
        }
        if (localanb.IXu != null) {
          localanb.f(b.t(".favitem.weburlitem.appmsgshareitem", localMap));
        }
        if (this.field_favProto.Lya != null)
        {
          paramString = this.field_favProto.Lya;
          this.field_sourceId = paramString.Lyi;
          this.field_sourceType = paramString.sourceType;
          this.field_fromUser = paramString.dRL;
          this.field_toUser = paramString.toUser;
        }
        this.field_edittime = this.field_favProto.rnM;
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
      paramString.aji(Util.getInt((String)localObject, -1));
    }
  }
  
  public final void arR(String paramString)
  {
    AppMethodBeat.i(103376);
    g.a locala = tah;
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
      locala.log("remarktime: " + this.field_favProto.LwZ);
      locala.log("dataitemCount: " + this.field_favProto.ppH.size());
      if (this.field_favProto.Lya != null)
      {
        locala.log(" ----source item----");
        paramString = this.field_favProto.Lya;
        locala.log("  sourceType: " + paramString.sourceType);
        locala.log("  fromUser: " + paramString.dRL);
        locala.log("  toUser: " + paramString.toUser);
        locala.log("  sourceId: " + paramString.Lyi);
        locala.log("  realChatName: " + paramString.LxA);
        locala.log("  createTime: " + paramString.createTime);
        locala.log("  msgId: " + paramString.msgId);
        locala.log("  eventId: " + paramString.edD);
        locala.log("  appId: " + paramString.appId);
        locala.log("  link: " + paramString.link);
        locala.log("  mediaId: " + paramString.LxG);
        locala.log("  brandId: " + paramString.dCl);
      }
      paramString = this.field_favProto.ppH.iterator();
      int i = 0;
      while (paramString.hasNext())
      {
        aml localaml = (aml)paramString.next();
        locala.log(" ----data item " + i + "----");
        locala.log("  dataId: " + localaml.dLl);
        locala.log("  dataType: " + localaml.dataType);
        locala.log("  dataSouceId: " + localaml.LvV);
        locala.log("  svrDataStatus: " + localaml.Lwd);
        locala.log("  cdnThumbUrl: " + localaml.iwX);
        locala.log("  cdnThumbKey: " + localaml.Lvk);
        locala.log("  cdnDataUrl: " + localaml.KuR);
        locala.log("  cdnDataKey: " + localaml.Lvp);
        locala.log("  cdnEncryVer: " + localaml.Lvr);
        locala.log("  fullmd5: " + localaml.LvE);
        locala.log("  head256md5: " + localaml.LvG);
        locala.log("  fullsize: " + localaml.LvI);
        locala.log("  thumbMd5: " + localaml.LvP);
        locala.log("  thumbHead256md5: " + localaml.LvR);
        locala.log("  thumbfullsize: " + localaml.LvT);
        locala.log("  duration: " + localaml.duration);
        locala.log("  datafmt: " + localaml.LvC);
        locala.log("  streamWebUrl: " + localaml.Lvu);
        locala.log("  streamDataUrl: " + localaml.Lvw);
        locala.log("  streamLowBandUrl: " + localaml.Lvy);
        locala.log("  ext: " + localaml.dFN);
        locala.log("  msgUuid: " + localaml.jsz);
        if (localaml.Lwh != null)
        {
          locala.log("  remarktime: " + localaml.Lwh.LwZ);
          locala.log("  ctrlflag: " + localaml.Lwh.Lxb);
          locala.log("  edittime: " + localaml.Lwh.rnM);
          if (localaml.Lwh.LwO != null)
          {
            locala.log("   ----data source item----");
            amn localamn = localaml.Lwh.LwO;
            locala.log("    sourceType: " + localamn.sourceType);
            locala.log("    fromUser: " + localamn.dRL);
            locala.log("    toUser: " + localamn.toUser);
            locala.log("    realChatName: " + localamn.LxA);
            locala.log("    createTime: " + localamn.createTime);
            locala.log("    msgId: " + localamn.msgId);
            locala.log("    eventId: " + localamn.edD);
            locala.log("    appId: " + localamn.appId);
            locala.log("    link: " + localamn.link);
            locala.log("    mediaId: " + localamn.LxG);
            locala.log("    brandId: " + localamn.dCl);
          }
          a("  ", locala, localaml.Lwh.LwQ);
          a("  ", locala, localaml.Lwh.LwS);
          a("  ", locala, localaml.Lwh.LwU);
          a("  ", locala, localaml.Lwh.LwW);
          a("  ", locala, localaml.Lwh.KBr);
        }
        i += 1;
      }
      a("", locala, this.field_favProto.LwQ);
      a("", locala, this.field_favProto.LwS);
      a("", locala, this.field_favProto.LwU);
      a("", locala, this.field_favProto.LwW);
      a("  ", locala, this.field_favProto.KBr);
    }
    locala.log("----dump favitem end----");
    AppMethodBeat.o(103376);
  }
  
  public final boolean arS(String paramString)
  {
    AppMethodBeat.i(103382);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103382);
      return false;
    }
    Iterator localIterator = this.field_tagProto.Lyo.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equals((String)localIterator.next()))
      {
        AppMethodBeat.o(103382);
        return false;
      }
    }
    this.field_tagProto.Lyo.add(paramString);
    AppMethodBeat.o(103382);
    return true;
  }
  
  public final boolean cUA()
  {
    return (this.field_itemStatus == 15) || (this.field_itemStatus == 16);
  }
  
  public final boolean cUB()
  {
    return (this.field_itemStatus == 12) || (this.field_itemStatus == 13) || (this.field_itemStatus == 14);
  }
  
  public final g cUC()
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
    localg.tad = this.tad;
    localg.tae = this.tae;
    localg.dLb = this.dLb;
    AppMethodBeat.o(103384);
    return localg;
  }
  
  public final boolean cUD()
  {
    AppMethodBeat.i(103385);
    Iterator localIterator = this.field_favProto.ppH.iterator();
    while (localIterator.hasNext()) {
      if (((aml)localIterator.next()).Lwz != 0)
      {
        AppMethodBeat.o(103385);
        return true;
      }
    }
    AppMethodBeat.o(103385);
    return false;
  }
  
  public final boolean cUu()
  {
    return (this.field_favProto.Lxb & 0x1) != 0;
  }
  
  public final boolean cUv()
  {
    return (this.field_favProto.Lxb & 0x2) != 0;
  }
  
  public final Bundle cUw()
  {
    AppMethodBeat.i(103374);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_ctrl_flag_open_chat", cUu());
    localBundle.putBoolean("key_ctrl_flag_open_sns", cUv());
    if ((this.field_favProto.Lxb & 0x4) != 0)
    {
      bool = true;
      localBundle.putBoolean("key_ctrl_flag_open_weibo", bool);
      if ((this.field_favProto.Lxb & 0x8) == 0) {
        break label183;
      }
      bool = true;
      label73:
      localBundle.putBoolean("key_ctrl_flag_open_cplink", bool);
      if ((this.field_favProto.Lxb & 0x10) == 0) {
        break label188;
      }
      bool = true;
      label96:
      localBundle.putBoolean("key_ctrl_flag_open_browser", bool);
      if ((this.field_favProto.Lxb & 0x20) == 0) {
        break label193;
      }
      bool = true;
      label119:
      localBundle.putBoolean("key_ctrl_flag_open_weiyun", bool);
      if ((this.field_favProto.Lxb & 0x40) == 0) {
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
  
  public final boolean cUx()
  {
    return (this.field_itemStatus == 1) || (this.field_itemStatus == 4) || (this.field_itemStatus == 9) || (this.field_itemStatus == 12) || (this.field_itemStatus == 13) || (this.field_itemStatus == 15) || (this.field_itemStatus == 17);
  }
  
  public final boolean cUy()
  {
    return (this.field_itemStatus == 3) || (this.field_itemStatus == 6) || (this.field_itemStatus == 11) || (this.field_itemStatus == 14) || (this.field_itemStatus == 16) || (this.field_itemStatus == 18);
  }
  
  public final boolean cUz()
  {
    return this.field_itemStatus == 8;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.g
 * JD-Core Version:    0.7.0.1
 */