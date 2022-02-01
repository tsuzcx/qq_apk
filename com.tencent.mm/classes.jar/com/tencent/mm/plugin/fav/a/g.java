package com.tencent.mm.plugin.fav.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bw;
import com.tencent.mm.plugin.fav.a.a.a;
import com.tencent.mm.plugin.fav.a.a.b;
import com.tencent.mm.plugin.fav.a.a.c;
import com.tencent.mm.plugin.fav.a.a.d;
import com.tencent.mm.plugin.i.a.e;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.protocal.protobuf.ahh;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class g
  extends bw
{
  public static c.a info;
  private static g.a qIo;
  private static g.a qIp;
  public String dhm;
  public boolean qIl;
  public g qIm;
  public String qIn;
  
  static
  {
    AppMethodBeat.i(103387);
    info = bw.Th();
    qIo = new g.1();
    qIp = new g.2();
    AppMethodBeat.o(103387);
  }
  
  public g()
  {
    AppMethodBeat.i(103372);
    this.qIl = false;
    this.qIm = null;
    this.dhm = "";
    this.qIn = "";
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
    cpk();
    AppMethodBeat.o(103372);
  }
  
  private static void a(String paramString, g.a parama, ahe paramahe)
  {
    AppMethodBeat.i(103380);
    if (paramahe == null)
    {
      AppMethodBeat.o(103380);
      return;
    }
    parama.log(paramString + " ----loc item----");
    parama.log(paramString + "  lng: " + paramahe.lng);
    parama.log(paramString + "  lat: " + paramahe.lat);
    parama.log(paramString + "  scale: " + paramahe.dmN);
    parama.log(paramString + "  label: " + paramahe.label);
    parama.log(paramString + "  poiname: " + paramahe.dry);
    AppMethodBeat.o(103380);
  }
  
  private static void a(String paramString, g.a parama, ahh paramahh)
  {
    AppMethodBeat.i(103378);
    if (paramahh == null)
    {
      AppMethodBeat.o(103378);
      return;
    }
    parama.log(paramString + " ----noteInfoItem item----");
    parama.log(paramString + "  author: " + paramahh.EBC);
    parama.log(paramString + "  editor: " + paramahh.EBD);
    AppMethodBeat.o(103378);
  }
  
  private static void a(String paramString, g.a parama, ahm paramahm)
  {
    AppMethodBeat.i(103379);
    if (paramahm == null)
    {
      AppMethodBeat.o(103379);
      return;
    }
    parama.log(paramString + " ----product item----");
    parama.log(paramString + "  title: " + paramahm.title);
    parama.log(paramString + "  desc: " + paramahm.desc);
    parama.log(paramString + "  thumbUrl: " + paramahm.thumbUrl);
    parama.log(paramString + "  type: " + paramahm.type);
    AppMethodBeat.o(103379);
  }
  
  private static void a(String paramString, g.a parama, ahw paramahw)
  {
    AppMethodBeat.i(103377);
    if (paramahw == null)
    {
      AppMethodBeat.o(103377);
      return;
    }
    parama.log(paramString + " ----tv item----");
    parama.log(paramString + "  title: " + paramahw.title);
    parama.log(paramString + "  desc: " + paramahw.desc);
    parama.log(paramString + "  thumbUrl: " + paramahw.thumbUrl);
    AppMethodBeat.o(103377);
  }
  
  private static void a(String paramString, g.a parama, aic paramaic)
  {
    AppMethodBeat.i(103381);
    if (paramaic == null)
    {
      AppMethodBeat.o(103381);
      return;
    }
    parama.log(paramString + " ----url item----");
    parama.log(paramString + "  title: " + paramaic.title);
    parama.log(paramString + "  desc: " + paramaic.desc);
    parama.log(paramString + "  cleanUrl: " + paramaic.ECl);
    parama.log(paramString + "  thumbUrl: " + paramaic.thumbUrl);
    parama.log(paramString + "  opencache: " + paramaic.ECn);
    parama.log(paramString + "  topstory: " + paramaic.ECq);
    AppMethodBeat.o(103381);
  }
  
  private void cpk()
  {
    AppMethodBeat.i(103373);
    this.field_favProto = new ahn();
    aht localaht = new aht();
    localaht.XV(1);
    this.field_favProto.a(localaht);
    this.field_favProto.b(new aic());
    this.field_favProto.f(new ahf());
    this.field_favProto.d(new ahe());
    this.field_favProto.b(new ahm());
    this.field_favProto.b(new ahw());
    this.field_favProto.d(new anx());
    this.field_favProto.XT(-1);
    this.field_tagProto = new aia();
    this.field_favProto.a(new ahh());
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
    if (!bs.isNullOrNil(((ahn)localObject2).title)) {
      localStringBuilder.append("<title>").append(bs.aLw(((ahn)localObject2).title)).append("</title>");
    }
    if (!bs.isNullOrNil(((ahn)localObject2).desc)) {
      localStringBuilder.append("<desc>").append(bs.aLw(((ahn)localObject2).desc)).append("</desc>");
    }
    if (((ahn)localObject2).pmI > 0L) {
      localStringBuilder.append("<edittime>").append(((ahn)localObject2).pmI).append("</edittime>");
    }
    if ((((ahn)localObject2).DKz != null) && (!bs.isNullOrNil(((ahn)localObject2).DKz.EBD))) {
      localStringBuilder.append("<editusr>").append(((ahn)localObject2).DKz.EBD).append("</editusr>");
    }
    if (!bs.isNullOrNil(((ahn)localObject2).iAC))
    {
      localStringBuilder.append("<remark ");
      if (((ahn)localObject2).EAR > 0L) {
        localStringBuilder.append(" time ='").append(((ahn)localObject2).EAR).append("'");
      }
      localStringBuilder.append(">").append(bs.aLw(((ahn)localObject2).iAC)).append("</remark>");
    }
    if (((ahn)localObject2).EAU) {
      localStringBuilder.append("<ctrlflag>").append(((ahn)localObject2).EAT).append("</ctrlflag>");
    }
    if (((ahn)localObject2).EBM)
    {
      localStringBuilder.append("<version>").append(((ahn)localObject2).version).append("</version>");
      localObject1 = ((ahn)localObject2).EBJ;
      if ((localObject1 != null) && (((aht)localObject1).computeSize() != 0)) {
        break label679;
      }
      ac.w("MicroMsg.FavSourceItemParser", "klem toXml, source item empty");
      localObject1 = "";
      label381:
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(a.dl(((ahn)localObject2).nxC));
      localObject1 = paramg.field_favProto.EAI;
      if ((localObject1 != null) && (((ahe)localObject1).computeSize() != 0)) {
        break label1029;
      }
      ac.d("MicroMsg.FavLocItemParser", "klem toXml, loc item empty");
      localObject1 = "";
      label431:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.EAK;
      if ((localObject1 != null) && (((aic)localObject1).computeSize() != 0)) {
        break label1213;
      }
      ac.d("MicroMsg.FavUrlItemParser", "klem toXml, url item empty");
      localObject1 = "";
      label468:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.EAM;
      if ((localObject1 != null) && (((ahm)localObject1).computeSize() != 0)) {
        break label1512;
      }
      ac.d("MicroMsg.FavProductItemParser", "klem toXml, product item empty");
      localObject1 = "";
      label505:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.EAO;
      if ((localObject1 != null) && (((ahw)localObject1).computeSize() != 0)) {
        break label1714;
      }
      ac.d("MicroMsg.FavTVItemParser", "klem toXml, product item empty");
      localObject1 = "";
      label542:
      localStringBuilder.append((String)localObject1);
      localObject1 = ((ahn)localObject2).DKz;
      if ((localObject1 != null) && (((ahh)localObject1).computeSize() != 0)) {
        break label1878;
      }
      ac.w("MicroMsg.FavNoteInfoItemParser", "klem toXml, source item empty");
      localObject1 = "";
      label577:
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(e.b(((ahn)localObject2).EBc));
      localObject1 = paramg.field_favProto.EAX;
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
      if (((aht)localObject1).EBe) {
        localStringBuffer2.append(" sourcetype='").append(((aht)localObject1).sourceType).append("'");
      }
      if (((aht)localObject1).EBS) {
        localStringBuffer2.append(" sourceid='").append(((aht)localObject1).EBR).append("'");
      }
      localStringBuffer2.append(">");
      if (((aht)localObject1).EBf) {
        localStringBuffer2.append("<fromusr>").append(bs.aLw(((aht)localObject1).dng)).append("</fromusr>");
      }
      if (((aht)localObject1).EBg) {
        localStringBuffer2.append("<tousr>").append(bs.aLw(((aht)localObject1).toUser)).append("</tousr>");
      }
      if (((aht)localObject1).EBk) {
        localStringBuffer2.append("<realchatname>").append(bs.aLw(((aht)localObject1).EBj)).append("</realchatname>");
      }
      if (((aht)localObject1).EBl) {
        localStringBuffer2.append("<msgid>").append(((aht)localObject1).dtG).append("</msgid>");
      }
      if (((aht)localObject1).EBm) {
        localStringBuffer2.append("<eventid>").append(((aht)localObject1).dym).append("</eventid>");
      }
      if (((aht)localObject1).EBn) {
        localStringBuffer2.append("<appid>").append(((aht)localObject1).appId).append("</appid>");
      }
      if (((aht)localObject1).EBo) {
        localStringBuffer2.append("<link>").append(bs.aLw(((aht)localObject1).link)).append("</link>");
      }
      if (((aht)localObject1).EBr) {
        localStringBuffer2.append("<brandid>").append(bs.aLw(((aht)localObject1).cYF)).append("</brandid>");
      }
      localStringBuffer2.append("</source>");
      localObject1 = localStringBuffer2.toString();
      break label381;
      label1029:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<locitem>");
      if (((ahe)localObject1).EBz) {
        localStringBuffer2.append("<label>").append(bs.aLw(((ahe)localObject1).label)).append("</label>");
      }
      if (((ahe)localObject1).EBx) {
        localStringBuffer2.append("<lat>").append(((ahe)localObject1).lat).append("</lat>");
      }
      if (((ahe)localObject1).EBw) {
        localStringBuffer2.append("<lng>").append(((ahe)localObject1).lng).append("</lng>");
      }
      if (((ahe)localObject1).EBy) {
        localStringBuffer2.append("<scale>").append(((ahe)localObject1).dmN).append("</scale>");
      }
      if (((ahe)localObject1).EBA) {
        localStringBuffer2.append("<poiname>").append(((ahe)localObject1).dry).append("</poiname>");
      }
      localStringBuffer2.append("</locitem>");
      localObject1 = localStringBuffer2.toString();
      break label431;
      label1213:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<weburlitem>");
      if (((aic)localObject1).ECm) {
        localStringBuffer2.append("<clean_url>").append(bs.aLw(((aic)localObject1).ECl)).append("</clean_url>");
      }
      if (((aic)localObject1).EyZ) {
        localStringBuffer2.append("<pagedesc>").append(bs.aLw(((aic)localObject1).desc)).append("</pagedesc>");
      }
      if (((aic)localObject1).EBG) {
        localStringBuffer2.append("<pagethumb_url>").append(bs.aLw(((aic)localObject1).thumbUrl)).append("</pagethumb_url>");
      }
      if (((aic)localObject1).EyY) {
        localStringBuffer2.append("<pagetitle>").append(bs.aLw(((aic)localObject1).title)).append("</pagetitle>");
      }
      if (((aic)localObject1).ECo) {
        localStringBuffer2.append("<opencache>").append(((aic)localObject1).ECn).append("</opencache>");
      }
      if (((aic)localObject1).ECp) {
        localStringBuffer2.append("<contentattr>").append(((aic)localObject1).hhK).append("</contentattr>");
      }
      if (((aic)localObject1).EAk) {
        localStringBuffer2.append("<canvasPageXml>").append(((aic)localObject1).canvasPageXml).append("</canvasPageXml>");
      }
      if (((aic)localObject1).ECr) {
        localStringBuffer2.append("<wsVideoFlowXml>").append(bs.aLw(((aic)localObject1).ECq)).append("</wsVideoFlowXml>");
      }
      localStringBuffer2.append(b.a(paramg.field_favProto.CoY));
      localStringBuffer2.append("</weburlitem>");
      localObject1 = localStringBuffer2.toString();
      break label468;
      label1512:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<productitem");
      if (((ahm)localObject1).EBI) {
        localStringBuffer2.append(" type='").append(((ahm)localObject1).type).append("'");
      }
      localStringBuffer2.append(">");
      if (((ahm)localObject1).EyY) {
        localStringBuffer2.append("<producttitle>").append(bs.aLw(((ahm)localObject1).title)).append("</producttitle>");
      }
      if (((ahm)localObject1).EyZ) {
        localStringBuffer2.append("<productdesc>").append(bs.aLw(((ahm)localObject1).desc)).append("</productdesc>");
      }
      if (((ahm)localObject1).EBG) {
        localStringBuffer2.append("<productthumb_url>").append(bs.aLw(((ahm)localObject1).thumbUrl)).append("</productthumb_url>");
      }
      if (((ahm)localObject1).EBH) {
        localStringBuffer2.append("<productinfo>").append(bs.aLw(((ahm)localObject1).info)).append("</productinfo>");
      }
      localStringBuffer2.append("</productitem>");
      localObject1 = localStringBuffer2.toString();
      break label505;
      label1714:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<tvitem>");
      if (((ahw)localObject1).EyY) {
        localStringBuffer2.append("<tvtitle>").append(bs.aLw(((ahw)localObject1).title)).append("</tvtitle>");
      }
      if (((ahw)localObject1).EyZ) {
        localStringBuffer2.append("<tvdesc>").append(bs.aLw(((ahw)localObject1).desc)).append("</tvdesc>");
      }
      if (((ahw)localObject1).EBG) {
        localStringBuffer2.append("<tvthumb_url>").append(bs.aLw(((ahw)localObject1).thumbUrl)).append("</tvthumb_url>");
      }
      if (((ahw)localObject1).EBH) {
        localStringBuffer2.append("<tvinfo>").append(bs.aLw(((ahw)localObject1).info)).append("</tvinfo>");
      }
      localStringBuffer2.append("</tvitem>");
      localObject1 = localStringBuffer2.toString();
      break label542;
      label1878:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<noteinfo>");
      localStringBuffer2.append("<noteauthor>").append(bs.aLw(((ahh)localObject1).EBC)).append("</noteauthor>");
      localStringBuffer2.append("<noteeditor>").append(bs.aLw(((ahh)localObject1).EBD)).append("</noteeditor>");
      localStringBuffer2.append("</noteinfo>");
      localObject1 = localStringBuffer2.toString();
      break label577;
      label1964:
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<appbranditem>");
      ((StringBuilder)localObject2).append("<username>").append(bs.aLw(((agv)localObject1).username)).append("</username>");
      ((StringBuilder)localObject2).append("<appid>").append(bs.aLw(((agv)localObject1).appId)).append("</appid>");
      ((StringBuilder)localObject2).append("<pkgtype>").append(((agv)localObject1).dib).append("</pkgtype>");
      ((StringBuilder)localObject2).append("<iconurl>").append(bs.aLw(((agv)localObject1).iconUrl)).append("</iconurl>");
      ((StringBuilder)localObject2).append("<type>").append(((agv)localObject1).type).append("</type>");
      ((StringBuilder)localObject2).append("<pagepath>").append(bs.aLw(((agv)localObject1).cYQ)).append("</pagepath>");
      ((StringBuilder)localObject2).append("<sourcedisplayname>").append(bs.aLw(((agv)localObject1).EyV)).append("</sourcedisplayname>");
      ((StringBuilder)localObject2).append("<version>").append(((agv)localObject1).version).append("</version>");
      ((StringBuilder)localObject2).append("<disableforward>").append(((agv)localObject1).jWX).append("</disableforward>");
      ((StringBuilder)localObject2).append("<tradingguaranteeflag>").append(((agv)localObject1).ccR).append("</tradingguaranteeflag>");
      ((StringBuilder)localObject2).append("<messageextradata>").append(String.format("<![CDATA[%s]]>", new Object[] { ((agv)localObject1).dxK })).append("</messageextradata>");
      ((StringBuilder)localObject2).append("<subtype>").append(((agv)localObject1).subType).append("</subtype>");
      ((StringBuilder)localObject2).append("</appbranditem>");
    }
  }
  
  public final g acw(String paramString)
  {
    AppMethodBeat.i(103375);
    if ((paramString == null) || (paramString.equals("")))
    {
      ac.e("MicroMsg.FavItemInfo", "klem, FavItemInfo xml null");
      AppMethodBeat.o(103375);
      return this;
    }
    Map localMap = bv.L(paramString, "favitem");
    if (localMap == null)
    {
      ac.e("MicroMsg.FavItemInfo", "klem, FavItemInfo maps null");
      AppMethodBeat.o(103375);
      return this;
    }
    for (;;)
    {
      try
      {
        cpk();
        ahn localahn = this.field_favProto;
        localahn.aJA((String)localMap.get(".favitem.title"));
        localahn.aJB((String)localMap.get(".favitem.desc"));
        localahn.aJz((String)localMap.get(".favitem.remark"));
        localahn.zW(bs.getLong((String)localMap.get(".favitem.remark.$time"), 0L));
        localObject = (String)localMap.get(".favitem.edittime");
        localahn.XU(bs.getInt((String)localMap.get(".favitem.version"), 0));
        localahn.zX(bs.getLong((String)localObject, 0L));
        localahn.XT(bs.getInt((String)localMap.get(".favitem.ctrlflag"), -1));
        localObject = localahn.EBJ;
        ((aht)localObject).XV(bs.getInt((String)localMap.get(".favitem.source" + ".$sourcetype"), 0));
        ((aht)localObject).aJE((String)localMap.get(".favitem.source" + ".$sourceid"));
        ((aht)localObject).aJC((String)localMap.get(".favitem.source" + ".fromusr"));
        ((aht)localObject).aJD((String)localMap.get(".favitem.source" + ".tousr"));
        ((aht)localObject).aJF((String)localMap.get(".favitem.source" + ".realchatname"));
        ((aht)localObject).zY(bs.getLong((String)localMap.get(".favitem.source" + ".createtime"), 0L));
        ((aht)localObject).aJG((String)localMap.get(".favitem.source" + ".msgid"));
        ((aht)localObject).aJH((String)localMap.get(".favitem.source" + ".eventid"));
        ((aht)localObject).aJI((String)localMap.get(".favitem.source" + ".appid"));
        ((aht)localObject).aJJ((String)localMap.get(".favitem.source" + ".link"));
        ((aht)localObject).aJK((String)localMap.get(".favitem.source" + ".brandid"));
        c.a(paramString, localahn);
        paramString = localahn.EAI;
        if (!bs.isNullOrNil((String)localMap.get(".favitem.locitem" + ".label"))) {
          paramString.aJt((String)localMap.get(".favitem.locitem" + ".label"));
        }
        if (!bs.isNullOrNil((String)localMap.get(".favitem.locitem" + ".poiname"))) {
          paramString.aJu((String)localMap.get(".favitem.locitem" + ".poiname"));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".lng");
        if (!bs.isNullOrNil((String)localObject)) {
          paramString.A(bs.getDouble((String)localObject, 0.0D));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".lat");
        if (!bs.isNullOrNil((String)localObject)) {
          paramString.B(bs.getDouble((String)localObject, 0.0D));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".scale");
        if (!bs.isNullOrNil((String)localObject))
        {
          if (((String)localObject).indexOf('.') == -1) {
            continue;
          }
          paramString.XR(bs.getInt(((String)localObject).substring(0, ((String)localObject).indexOf('.')), -1));
        }
        paramString = localahn.EAK;
        paramString.aJR((String)localMap.get(".favitem.weburlitem" + ".clean_url"));
        paramString.aJQ((String)localMap.get(".favitem.weburlitem" + ".pagedesc"));
        paramString.aJS((String)localMap.get(".favitem.weburlitem" + ".pagethumb_url"));
        paramString.aJP((String)localMap.get(".favitem.weburlitem" + ".pagetitle"));
        paramString.XW(bs.getInt((String)localMap.get(".favitem.weburlitem" + ".opencache"), 0));
        paramString.XX(bs.getInt((String)localMap.get(".favitem.weburlitem" + ".contentattr"), 0));
        paramString.aJT((String)localMap.get(".favitem.weburlitem" + ".canvasPageXml"));
        paramString.aJU((String)localMap.get(".favitem.weburlitem" + ".wsVideoFlowXml"));
        localahn.d(e.t(".favitem", localMap));
        if (localahn.CoY != null) {
          localahn.f(b.r(".favitem.weburlitem.appmsgshareitem", localMap));
        }
        paramString = localahn.EAM;
        paramString.aJv((String)localMap.get(".favitem.productitem" + ".producttitle"));
        paramString.aJw((String)localMap.get(".favitem.productitem" + ".productdesc"));
        paramString.aJx((String)localMap.get(".favitem.productitem" + ".productthumb_url"));
        paramString.aJy((String)localMap.get(".favitem.productitem" + ".productinfo"));
        paramString.XS(bs.getInt((String)localMap.get(".favitem.productitem" + ".$type"), 0));
        paramString = localahn.EAO;
        paramString.aJL((String)localMap.get(".favitem.tvitem" + ".tvtitle"));
        paramString.aJM((String)localMap.get(".favitem.tvitem" + ".tvdesc"));
        paramString.aJN((String)localMap.get(".favitem.tvitem" + ".tvthumb_url"));
        paramString.aJO((String)localMap.get(".favitem.tvitem" + ".tvinfo"));
        paramString = localahn.DKz;
        paramString.EBC = ((String)localMap.get(".favitem.noteinfo" + ".noteauthor"));
        paramString.EBD = ((String)localMap.get(".favitem.noteinfo" + ".noteeditor"));
        if (localMap.containsKey(".favitem.appbranditem"))
        {
          paramString = new agv();
          paramString.username = ((String)localMap.get(".favitem.appbranditem" + ".username"));
          paramString.appId = ((String)localMap.get(".favitem.appbranditem" + ".appid"));
          paramString.dib = bs.getInt((String)localMap.get(".favitem.appbranditem" + ".pkgtype"), 0);
          paramString.iconUrl = ((String)localMap.get(".favitem.appbranditem" + ".iconurl"));
          paramString.type = bs.getInt((String)localMap.get(".favitem.appbranditem" + ".type"), 0);
          paramString.cYQ = ((String)localMap.get(".favitem.appbranditem" + ".pagepath"));
          paramString.EyV = ((String)localMap.get(".favitem.appbranditem" + ".sourcedisplayname"));
          paramString.version = bs.getInt((String)localMap.get(".favitem.appbranditem" + ".version"), 0);
          paramString.jWX = bs.getInt((String)localMap.get(".favitem.appbranditem" + ".disableforward"), 0);
          paramString.ccR = bs.getInt((String)localMap.get(".favitem.appbranditem" + ".tradingguaranteeflag"), 0);
          paramString.dxK = ((String)localMap.get(".favitem.appbranditem" + ".messageextradata"));
          paramString.subType = bs.getInt((String)localMap.get(".favitem.appbranditem" + ".subtype"), 0);
          localahn.c(paramString);
        }
        if (localahn.CoY != null) {
          localahn.f(b.r(".favitem.weburlitem.appmsgshareitem", localMap));
        }
        if (this.field_favProto.EBJ != null)
        {
          paramString = this.field_favProto.EBJ;
          this.field_sourceId = paramString.EBR;
          this.field_sourceType = paramString.sourceType;
          this.field_fromUser = paramString.dng;
          this.field_toUser = paramString.toUser;
        }
        this.field_edittime = this.field_favProto.pmI;
        d.a(localMap, this.field_tagProto);
      }
      catch (Exception paramString)
      {
        Object localObject;
        ac.printErrStackTrace("MicroMsg.FavItemInfo", paramString, "", new Object[0]);
        ac.e("MicroMsg.FavItemInfo", "klem , FavItemInfo exception:+%s", new Object[] { paramString.toString() });
        continue;
      }
      AppMethodBeat.o(103375);
      return this;
      paramString.XR(bs.getInt((String)localObject, -1));
    }
  }
  
  public final void acx(String paramString)
  {
    AppMethodBeat.i(103376);
    g.a locala = qIo;
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
      locala.log("remarktime: " + this.field_favProto.EAR);
      locala.log("dataitemCount: " + this.field_favProto.nxC.size());
      if (this.field_favProto.EBJ != null)
      {
        locala.log(" ----source item----");
        paramString = this.field_favProto.EBJ;
        locala.log("  sourceType: " + paramString.sourceType);
        locala.log("  fromUser: " + paramString.dng);
        locala.log("  toUser: " + paramString.toUser);
        locala.log("  sourceId: " + paramString.EBR);
        locala.log("  realChatName: " + paramString.EBj);
        locala.log("  createTime: " + paramString.createTime);
        locala.log("  msgId: " + paramString.dtG);
        locala.log("  eventId: " + paramString.dym);
        locala.log("  appId: " + paramString.appId);
        locala.log("  link: " + paramString.link);
        locala.log("  mediaId: " + paramString.EBp);
        locala.log("  brandId: " + paramString.cYF);
      }
      paramString = this.field_favProto.nxC.iterator();
      int i = 0;
      while (paramString.hasNext())
      {
        agx localagx = (agx)paramString.next();
        locala.log(" ----data item " + i + "----");
        locala.log("  dataId: " + localagx.dhw);
        locala.log("  dataType: " + localagx.dataType);
        locala.log("  dataSouceId: " + localagx.EzN);
        locala.log("  svrDataStatus: " + localagx.EzV);
        locala.log("  cdnThumbUrl: " + localagx.hhV);
        locala.log("  cdnThumbKey: " + localagx.Ezb);
        locala.log("  cdnDataUrl: " + localagx.Ezf);
        locala.log("  cdnDataKey: " + localagx.Ezh);
        locala.log("  cdnEncryVer: " + localagx.Ezj);
        locala.log("  fullmd5: " + localagx.Ezw);
        locala.log("  head256md5: " + localagx.Ezy);
        locala.log("  fullsize: " + localagx.EzA);
        locala.log("  thumbMd5: " + localagx.EzH);
        locala.log("  thumbHead256md5: " + localagx.EzJ);
        locala.log("  thumbfullsize: " + localagx.EzL);
        locala.log("  duration: " + localagx.duration);
        locala.log("  datafmt: " + localagx.Ezu);
        locala.log("  streamWebUrl: " + localagx.Ezm);
        locala.log("  streamDataUrl: " + localagx.Ezo);
        locala.log("  streamLowBandUrl: " + localagx.Ezq);
        locala.log("  ext: " + localagx.dbZ);
        locala.log("  msgUuid: " + localagx.iaU);
        if (localagx.EzZ != null)
        {
          locala.log("  remarktime: " + localagx.EzZ.EAR);
          locala.log("  ctrlflag: " + localagx.EzZ.EAT);
          locala.log("  edittime: " + localagx.EzZ.pmI);
          if (localagx.EzZ.EAG != null)
          {
            locala.log("   ----data source item----");
            agz localagz = localagx.EzZ.EAG;
            locala.log("    sourceType: " + localagz.sourceType);
            locala.log("    fromUser: " + localagz.dng);
            locala.log("    toUser: " + localagz.toUser);
            locala.log("    realChatName: " + localagz.EBj);
            locala.log("    createTime: " + localagz.createTime);
            locala.log("    msgId: " + localagz.dtG);
            locala.log("    eventId: " + localagz.dym);
            locala.log("    appId: " + localagz.appId);
            locala.log("    link: " + localagz.link);
            locala.log("    mediaId: " + localagz.EBp);
            locala.log("    brandId: " + localagz.cYF);
          }
          a("  ", locala, localagx.EzZ.EAI);
          a("  ", locala, localagx.EzZ.EAK);
          a("  ", locala, localagx.EzZ.EAM);
          a("  ", locala, localagx.EzZ.EAO);
          a("  ", locala, localagx.EzZ.DKz);
        }
        i += 1;
      }
      a("", locala, this.field_favProto.EAI);
      a("", locala, this.field_favProto.EAK);
      a("", locala, this.field_favProto.EAM);
      a("", locala, this.field_favProto.EAO);
      a("  ", locala, this.field_favProto.DKz);
    }
    locala.log("----dump favitem end----");
    AppMethodBeat.o(103376);
  }
  
  public final boolean acy(String paramString)
  {
    AppMethodBeat.i(103382);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103382);
      return false;
    }
    Iterator localIterator = this.field_tagProto.EBX.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equals((String)localIterator.next()))
      {
        AppMethodBeat.o(103382);
        return false;
      }
    }
    this.field_tagProto.EBX.add(paramString);
    AppMethodBeat.o(103382);
    return true;
  }
  
  public final boolean cpl()
  {
    return (this.field_favProto.EAT & 0x1) != 0;
  }
  
  public final boolean cpm()
  {
    return (this.field_favProto.EAT & 0x2) != 0;
  }
  
  public final Bundle cpn()
  {
    AppMethodBeat.i(103374);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_ctrl_flag_open_chat", cpl());
    localBundle.putBoolean("key_ctrl_flag_open_sns", cpm());
    if ((this.field_favProto.EAT & 0x4) != 0)
    {
      bool = true;
      localBundle.putBoolean("key_ctrl_flag_open_weibo", bool);
      if ((this.field_favProto.EAT & 0x8) == 0) {
        break label183;
      }
      bool = true;
      label73:
      localBundle.putBoolean("key_ctrl_flag_open_cplink", bool);
      if ((this.field_favProto.EAT & 0x10) == 0) {
        break label188;
      }
      bool = true;
      label96:
      localBundle.putBoolean("key_ctrl_flag_open_browser", bool);
      if ((this.field_favProto.EAT & 0x20) == 0) {
        break label193;
      }
      bool = true;
      label119:
      localBundle.putBoolean("key_ctrl_flag_open_weiyun", bool);
      if ((this.field_favProto.EAT & 0x40) == 0) {
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
      ac.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", new Object[] { localBundle.toString() });
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
  
  public final boolean cpo()
  {
    return (this.field_itemStatus == 1) || (this.field_itemStatus == 4) || (this.field_itemStatus == 9) || (this.field_itemStatus == 12) || (this.field_itemStatus == 13) || (this.field_itemStatus == 15) || (this.field_itemStatus == 17);
  }
  
  public final boolean cpp()
  {
    return this.field_itemStatus == 8;
  }
  
  public final boolean cpq()
  {
    return (this.field_itemStatus == 15) || (this.field_itemStatus == 16);
  }
  
  public final boolean cpr()
  {
    return (this.field_itemStatus == 12) || (this.field_itemStatus == 13) || (this.field_itemStatus == 14);
  }
  
  public final g cps()
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
    localg.qIl = this.qIl;
    localg.qIm = this.qIm;
    localg.dhm = this.dhm;
    AppMethodBeat.o(103384);
    return localg;
  }
  
  public final boolean cpt()
  {
    AppMethodBeat.i(103385);
    Iterator localIterator = this.field_favProto.nxC.iterator();
    while (localIterator.hasNext()) {
      if (((agx)localIterator.next()).EAr != 0)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.g
 * JD-Core Version:    0.7.0.1
 */