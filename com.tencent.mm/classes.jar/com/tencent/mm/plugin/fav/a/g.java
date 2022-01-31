package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.plugin.fav.a.a.a;
import com.tencent.mm.plugin.fav.a.a.b;
import com.tencent.mm.plugin.fav.a.a.c;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.xx;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.protocal.c.yd;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.protocal.c.ys;
import com.tencent.mm.protocal.c.yw;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class g
  extends com.tencent.mm.h.c.bn
{
  public static c.a buS = ;
  private static g.a jYC = new g.1();
  private static g.a jYD = new g.2();
  
  public g()
  {
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
    aPW();
  }
  
  private static void a(String paramString, g.a parama, yc paramyc)
  {
    if (paramyc == null) {
      return;
    }
    parama.tn(paramString + " ----loc item----");
    parama.tn(paramString + "  lng: " + paramyc.lng);
    parama.tn(paramString + "  lat: " + paramyc.lat);
    parama.tn(paramString + "  scale: " + paramyc.bRv);
    parama.tn(paramString + "  label: " + paramyc.label);
    parama.tn(paramString + "  poiname: " + paramyc.bVA);
  }
  
  private static void a(String paramString, g.a parama, yd paramyd)
  {
    if (paramyd == null) {
      return;
    }
    parama.tn(paramString + " ----noteInfoItem item----");
    parama.tn(paramString + "  author: " + paramyd.sWT);
    parama.tn(paramString + "  editor: " + paramyd.sWU);
  }
  
  private static void a(String paramString, g.a parama, yi paramyi)
  {
    if (paramyi == null) {
      return;
    }
    parama.tn(paramString + " ----product item----");
    parama.tn(paramString + "  title: " + paramyi.title);
    parama.tn(paramString + "  desc: " + paramyi.desc);
    parama.tn(paramString + "  thumbUrl: " + paramyi.thumbUrl);
    parama.tn(paramString + "  type: " + paramyi.type);
  }
  
  private static void a(String paramString, g.a parama, ys paramys)
  {
    if (paramys == null) {
      return;
    }
    parama.tn(paramString + " ----tv item----");
    parama.tn(paramString + "  title: " + paramys.title);
    parama.tn(paramString + "  desc: " + paramys.desc);
    parama.tn(paramString + "  thumbUrl: " + paramys.thumbUrl);
  }
  
  private static void a(String paramString, g.a parama, yy paramyy)
  {
    if (paramyy == null) {
      return;
    }
    parama.tn(paramString + " ----url item----");
    parama.tn(paramString + "  title: " + paramyy.title);
    parama.tn(paramString + "  desc: " + paramyy.desc);
    parama.tn(paramString + "  cleanUrl: " + paramyy.sXG);
    parama.tn(paramString + "  thumbUrl: " + paramyy.thumbUrl);
    parama.tn(paramString + "  opencache: " + paramyy.sXI);
  }
  
  private void aPW()
  {
    this.field_favProto = new yj();
    yp localyp = new yp();
    localyp.EQ(1);
    this.field_favProto.a(localyp);
    this.field_favProto.b(new yy());
    this.field_favProto.b(new yc());
    this.field_favProto.b(new yi());
    this.field_favProto.b(new ys());
    this.field_favProto.EO(-1);
    this.field_tagProto = new yw();
    this.field_favProto.a(new yd());
  }
  
  public static String s(g paramg)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append("<favitem");
    localStringBuffer1.append(" type='").append(paramg.field_type).append("'");
    localStringBuffer1.append(">");
    Object localObject2 = paramg.field_favProto;
    StringBuilder localStringBuilder = new StringBuilder();
    if (!bk.bl(((yj)localObject2).title)) {
      localStringBuilder.append("<title>").append(bk.ZP(((yj)localObject2).title)).append("</title>");
    }
    if (!bk.bl(((yj)localObject2).desc)) {
      localStringBuilder.append("<desc>").append(bk.ZP(((yj)localObject2).desc)).append("</desc>");
    }
    if (((yj)localObject2).srp > 0L) {
      localStringBuilder.append("<edittime>").append(((yj)localObject2).srp).append("</edittime>");
    }
    if (!bk.bl(((yj)localObject2).fGK))
    {
      localStringBuilder.append("<remark ");
      if (((yj)localObject2).sWo > 0L) {
        localStringBuilder.append(" time ='").append(((yj)localObject2).sWo).append("'");
      }
      localStringBuilder.append(">").append(bk.ZP(((yj)localObject2).fGK)).append("</remark>");
    }
    if (((yj)localObject2).sWr) {
      localStringBuilder.append("<ctrlflag>").append(((yj)localObject2).sWq).append("</ctrlflag>");
    }
    if (((yj)localObject2).sXe)
    {
      localStringBuilder.append("<version>").append(((yj)localObject2).version).append("</version>");
      localObject1 = ((yj)localObject2).sXa;
      if ((localObject1 != null) && (((yp)localObject1).btq() != 0)) {
        break label583;
      }
      y.w("MicroMsg.FavSourceItemParser", "klem toXml, source item empty");
      localObject1 = "";
      label327:
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(a.bo(((yj)localObject2).sXc));
      localObject1 = paramg.field_favProto.sWf;
      if ((localObject1 != null) && (((yc)localObject1).btq() != 0)) {
        break label933;
      }
      y.d("MicroMsg.FavLocItemParser", "klem toXml, loc item empty");
      localObject1 = "";
      label377:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.sWh;
      if ((localObject1 != null) && (((yy)localObject1).btq() != 0)) {
        break label1117;
      }
      y.d("MicroMsg.FavUrlItemParser", "klem toXml, url item empty");
      localObject1 = "";
      label414:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.sWj;
      if ((localObject1 != null) && (((yi)localObject1).btq() != 0)) {
        break label1368;
      }
      y.d("MicroMsg.FavProductItemParser", "klem toXml, product item empty");
      localObject1 = "";
      label451:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.sWl;
      if ((localObject1 != null) && (((ys)localObject1).btq() != 0)) {
        break label1570;
      }
      y.d("MicroMsg.FavTVItemParser", "klem toXml, product item empty");
      localObject1 = "";
      label488:
      localStringBuilder.append((String)localObject1);
      localObject1 = ((yj)localObject2).sro;
      if ((localObject1 != null) && (((yd)localObject1).btq() != 0)) {
        break label1734;
      }
      y.w("MicroMsg.FavNoteInfoItemParser", "klem toXml, source item empty");
    }
    for (Object localObject1 = "";; localObject1 = ((StringBuffer)localObject2).toString())
    {
      localStringBuilder.append((String)localObject1);
      localStringBuffer1.append(localStringBuilder.toString());
      localStringBuffer1.append(c.a(paramg.field_tagProto));
      localStringBuffer1.append("</favitem>");
      return localStringBuffer1.toString();
      if (paramg.field_type != 18) {
        break;
      }
      localStringBuilder.append("<version>1</version>");
      break;
      label583:
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<source");
      if (((yp)localObject1).sWw) {
        localStringBuffer2.append(" sourcetype='").append(((yp)localObject1).bIl).append("'");
      }
      if (((yp)localObject1).sXk) {
        localStringBuffer2.append(" sourceid='").append(((yp)localObject1).sXj).append("'");
      }
      localStringBuffer2.append(">");
      if (((yp)localObject1).sWx) {
        localStringBuffer2.append("<fromusr>").append(bk.ZP(((yp)localObject1).bRO)).append("</fromusr>");
      }
      if (((yp)localObject1).sWy) {
        localStringBuffer2.append("<tousr>").append(bk.ZP(((yp)localObject1).toUser)).append("</tousr>");
      }
      if (((yp)localObject1).sWC) {
        localStringBuffer2.append("<realchatname>").append(bk.ZP(((yp)localObject1).sWB)).append("</realchatname>");
      }
      if (((yp)localObject1).sWD) {
        localStringBuffer2.append("<msgid>").append(((yp)localObject1).bVP).append("</msgid>");
      }
      if (((yp)localObject1).sWE) {
        localStringBuffer2.append("<eventid>").append(((yp)localObject1).cbd).append("</eventid>");
      }
      if (((yp)localObject1).sWF) {
        localStringBuffer2.append("<appid>").append(((yp)localObject1).appId).append("</appid>");
      }
      if (((yp)localObject1).sWG) {
        localStringBuffer2.append("<link>").append(bk.ZP(((yp)localObject1).eAl)).append("</link>");
      }
      if (((yp)localObject1).sWJ) {
        localStringBuffer2.append("<brandid>").append(bk.ZP(((yp)localObject1).bFn)).append("</brandid>");
      }
      localStringBuffer2.append("</source>");
      localObject1 = localStringBuffer2.toString();
      break label327;
      label933:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<locitem>");
      if (((yc)localObject1).sWR) {
        localStringBuffer2.append("<label>").append(bk.ZP(((yc)localObject1).label)).append("</label>");
      }
      if (((yc)localObject1).sWP) {
        localStringBuffer2.append("<lat>").append(((yc)localObject1).lat).append("</lat>");
      }
      if (((yc)localObject1).sWO) {
        localStringBuffer2.append("<lng>").append(((yc)localObject1).lng).append("</lng>");
      }
      if (((yc)localObject1).sWQ) {
        localStringBuffer2.append("<scale>").append(((yc)localObject1).bRv).append("</scale>");
      }
      if (((yc)localObject1).sWS) {
        localStringBuffer2.append("<poiname>").append(((yc)localObject1).bVA).append("</poiname>");
      }
      localStringBuffer2.append("</locitem>");
      localObject1 = localStringBuffer2.toString();
      break label377;
      label1117:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<weburlitem>");
      if (((yy)localObject1).sXH) {
        localStringBuffer2.append("<clean_url>").append(bk.ZP(((yy)localObject1).sXG)).append("</clean_url>");
      }
      if (((yy)localObject1).sUA) {
        localStringBuffer2.append("<pagedesc>").append(bk.ZP(((yy)localObject1).desc)).append("</pagedesc>");
      }
      if (((yy)localObject1).sWX) {
        localStringBuffer2.append("<pagethumb_url>").append(bk.ZP(((yy)localObject1).thumbUrl)).append("</pagethumb_url>");
      }
      if (((yy)localObject1).sUz) {
        localStringBuffer2.append("<pagetitle>").append(bk.ZP(((yy)localObject1).title)).append("</pagetitle>");
      }
      if (((yy)localObject1).sXJ) {
        localStringBuffer2.append("<opencache>").append(((yy)localObject1).sXI).append("</opencache>");
      }
      if (((yy)localObject1).sXK) {
        localStringBuffer2.append("<contentattr>").append(((yy)localObject1).dQA).append("</contentattr>");
      }
      if (((yy)localObject1).sVL) {
        localStringBuffer2.append("<canvasPageXml>").append(((yy)localObject1).canvasPageXml).append("</canvasPageXml>");
      }
      localStringBuffer2.append("</weburlitem>");
      localObject1 = localStringBuffer2.toString();
      break label414;
      label1368:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<productitem");
      if (((yi)localObject1).sWZ) {
        localStringBuffer2.append(" type='").append(((yi)localObject1).type).append("'");
      }
      localStringBuffer2.append(">");
      if (((yi)localObject1).sUz) {
        localStringBuffer2.append("<producttitle>").append(bk.ZP(((yi)localObject1).title)).append("</producttitle>");
      }
      if (((yi)localObject1).sUA) {
        localStringBuffer2.append("<productdesc>").append(bk.ZP(((yi)localObject1).desc)).append("</productdesc>");
      }
      if (((yi)localObject1).sWX) {
        localStringBuffer2.append("<productthumb_url>").append(bk.ZP(((yi)localObject1).thumbUrl)).append("</productthumb_url>");
      }
      if (((yi)localObject1).sWY) {
        localStringBuffer2.append("<productinfo>").append(bk.ZP(((yi)localObject1).info)).append("</productinfo>");
      }
      localStringBuffer2.append("</productitem>");
      localObject1 = localStringBuffer2.toString();
      break label451;
      label1570:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<tvitem>");
      if (((ys)localObject1).sUz) {
        localStringBuffer2.append("<tvtitle>").append(bk.ZP(((ys)localObject1).title)).append("</tvtitle>");
      }
      if (((ys)localObject1).sUA) {
        localStringBuffer2.append("<tvdesc>").append(bk.ZP(((ys)localObject1).desc)).append("</tvdesc>");
      }
      if (((ys)localObject1).sWX) {
        localStringBuffer2.append("<tvthumb_url>").append(bk.ZP(((ys)localObject1).thumbUrl)).append("</tvthumb_url>");
      }
      if (((ys)localObject1).sWY) {
        localStringBuffer2.append("<tvinfo>").append(bk.ZP(((ys)localObject1).info)).append("</tvinfo>");
      }
      localStringBuffer2.append("</tvitem>");
      localObject1 = localStringBuffer2.toString();
      break label488;
      label1734:
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject2).append("<noteinfo>");
      ((StringBuffer)localObject2).append("<noteauthor>").append(bk.ZP(((yd)localObject1).sWT)).append("</noteauthor>");
      ((StringBuffer)localObject2).append("<noteeditor>").append(bk.ZP(((yd)localObject1).sWU)).append("</noteeditor>");
      ((StringBuffer)localObject2).append("</noteinfo>");
    }
  }
  
  public final g CD(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      y.e("MicroMsg.FavItemInfo", "klem, FavItemInfo xml null");
      return this;
    }
    Map localMap = com.tencent.mm.sdk.platformtools.bn.s(paramString, "favitem");
    if (localMap == null)
    {
      y.e("MicroMsg.FavItemInfo", "klem, FavItemInfo maps null");
      return this;
    }
    for (;;)
    {
      Object localObject;
      try
      {
        aPW();
        yj localyj = this.field_favProto;
        localyj.Yo((String)localMap.get(".favitem.title"));
        localyj.Yp((String)localMap.get(".favitem.desc"));
        localyj.Yn((String)localMap.get(".favitem.remark"));
        localyj.hj(bk.getLong((String)localMap.get(".favitem.remark.$time"), 0L));
        localObject = (String)localMap.get(".favitem.edittime");
        localyj.EP(bk.getInt((String)localMap.get(".favitem.version"), 0));
        localyj.hk(bk.getLong((String)localObject, 0L));
        localyj.EO(bk.getInt((String)localMap.get(".favitem.ctrlflag"), -1));
        localObject = localyj.sXa;
        ((yp)localObject).EQ(bk.getInt((String)localMap.get(".favitem.source" + ".$sourcetype"), 0));
        ((yp)localObject).Ys((String)localMap.get(".favitem.source" + ".$sourceid"));
        ((yp)localObject).Yq((String)localMap.get(".favitem.source" + ".fromusr"));
        ((yp)localObject).Yr((String)localMap.get(".favitem.source" + ".tousr"));
        ((yp)localObject).Yt((String)localMap.get(".favitem.source" + ".realchatname"));
        ((yp)localObject).hl(bk.getLong((String)localMap.get(".favitem.source" + ".createtime"), 0L));
        ((yp)localObject).Yu((String)localMap.get(".favitem.source" + ".msgid"));
        ((yp)localObject).Yv((String)localMap.get(".favitem.source" + ".eventid"));
        ((yp)localObject).Yw((String)localMap.get(".favitem.source" + ".appid"));
        ((yp)localObject).Yx((String)localMap.get(".favitem.source" + ".link"));
        ((yp)localObject).Yy((String)localMap.get(".favitem.source" + ".brandid"));
        b.a(paramString, localyj);
        paramString = localyj.sWf;
        if (!bk.bl((String)localMap.get(".favitem.locitem" + ".label"))) {
          paramString.Yh((String)localMap.get(".favitem.locitem" + ".label"));
        }
        if (!bk.bl((String)localMap.get(".favitem.locitem" + ".poiname"))) {
          paramString.Yi((String)localMap.get(".favitem.locitem" + ".poiname"));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".lng");
        if (!bk.bl((String)localObject)) {
          paramString.y(bk.getDouble((String)localObject, 0.0D));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".lat");
        if (!bk.bl((String)localObject)) {
          paramString.z(bk.getDouble((String)localObject, 0.0D));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".scale");
        if (!bk.bl((String)localObject))
        {
          if (((String)localObject).indexOf('.') != -1) {
            paramString.EM(bk.getInt(((String)localObject).substring(0, ((String)localObject).indexOf('.')), -1));
          }
        }
        else
        {
          paramString = localyj.sWh;
          paramString.YF((String)localMap.get(".favitem.weburlitem" + ".clean_url"));
          paramString.YE((String)localMap.get(".favitem.weburlitem" + ".pagedesc"));
          paramString.YG((String)localMap.get(".favitem.weburlitem" + ".pagethumb_url"));
          paramString.YD((String)localMap.get(".favitem.weburlitem" + ".pagetitle"));
          paramString.ER(bk.getInt((String)localMap.get(".favitem.weburlitem" + ".opencache"), 0));
          paramString.ES(bk.getInt((String)localMap.get(".favitem.weburlitem" + ".contentattr"), 0));
          paramString.YH((String)localMap.get(".favitem.weburlitem" + ".canvasPageXml"));
          paramString = localyj.sWj;
          paramString.Yj((String)localMap.get(".favitem.productitem" + ".producttitle"));
          paramString.Yk((String)localMap.get(".favitem.productitem" + ".productdesc"));
          paramString.Yl((String)localMap.get(".favitem.productitem" + ".productthumb_url"));
          paramString.Ym((String)localMap.get(".favitem.productitem" + ".productinfo"));
          paramString.EN(bk.getInt((String)localMap.get(".favitem.productitem" + ".$type"), 0));
          paramString = localyj.sWl;
          paramString.Yz((String)localMap.get(".favitem.tvitem" + ".tvtitle"));
          paramString.YA((String)localMap.get(".favitem.tvitem" + ".tvdesc"));
          paramString.YB((String)localMap.get(".favitem.tvitem" + ".tvthumb_url"));
          paramString.YC((String)localMap.get(".favitem.tvitem" + ".tvinfo"));
          paramString = localyj.sro;
          paramString.sWT = ((String)localMap.get(".favitem.noteinfo" + ".noteauthor"));
          paramString.sWU = ((String)localMap.get(".favitem.noteinfo" + ".noteeditor"));
          paramString = localyj.sWu;
          if (paramString != null)
          {
            paramString.username = ((String)localMap.get(".favitem.appbranditem" + ".username"));
            paramString.appId = ((String)localMap.get(".favitem.appbranditem" + ".appid"));
            paramString.bOa = bk.getInt((String)localMap.get(".favitem.appbranditem" + ".pkgtype"), 0);
            paramString.iconUrl = ((String)localMap.get(".favitem.appbranditem" + ".iconurl"));
            paramString.type = bk.getInt((String)localMap.get(".favitem.appbranditem" + ".type"), 0);
            paramString.bFw = ((String)localMap.get(".favitem.appbranditem" + ".pagepath"));
            paramString.sUv = ((String)localMap.get(".favitem.appbranditem" + ".sourcedisplayname"));
          }
          if (this.field_favProto.sXa != null)
          {
            paramString = this.field_favProto.sXa;
            this.field_sourceId = paramString.sXj;
            this.field_sourceType = paramString.bIl;
            this.field_fromUser = paramString.bRO;
            this.field_toUser = paramString.toUser;
          }
          this.field_edittime = this.field_favProto.srp;
          c.a(localMap, this.field_tagProto);
          return this;
        }
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("MicroMsg.FavItemInfo", paramString, "", new Object[0]);
        y.e("MicroMsg.FavItemInfo", "klem , FavItemInfo exception:+%s", new Object[] { paramString.toString() });
        return this;
      }
      paramString.EM(bk.getInt((String)localObject, -1));
    }
  }
  
  public final void CE(String paramString)
  {
    g.a locala = jYC;
    locala.tn("----dump favitem from[" + paramString + "] beg----");
    locala.tn("type: " + this.field_type);
    locala.tn("favId: " + this.field_id);
    locala.tn("localId: " + this.field_localId);
    locala.tn("itemStatus: " + this.field_itemStatus);
    locala.tn("localSeq: " + this.field_localSeq);
    locala.tn("updateSeq: " + this.field_updateSeq);
    locala.tn("ctrlFlag: " + this.field_flag);
    locala.tn("sourceId: " + this.field_sourceId);
    locala.tn("sourceType: " + this.field_sourceType);
    locala.tn("sourceCreateTime: " + this.field_sourceCreateTime);
    locala.tn("updateTime: " + this.field_updateTime);
    locala.tn("editTime: " + this.field_edittime);
    locala.tn("fromuser: " + this.field_fromUser);
    locala.tn("toUser: " + this.field_toUser);
    locala.tn("realChatName: " + this.field_realChatName);
    if (this.field_favProto != null)
    {
      locala.tn("remarktime: " + this.field_favProto.sWo);
      locala.tn("dataitemCount: " + this.field_favProto.sXc.size());
      if (this.field_favProto.sXa != null)
      {
        locala.tn(" ----source item----");
        paramString = this.field_favProto.sXa;
        locala.tn("  sourceType: " + paramString.bIl);
        locala.tn("  fromUser: " + paramString.bRO);
        locala.tn("  toUser: " + paramString.toUser);
        locala.tn("  sourceId: " + paramString.sXj);
        locala.tn("  realChatName: " + paramString.sWB);
        locala.tn("  createTime: " + paramString.createTime);
        locala.tn("  msgId: " + paramString.bVP);
        locala.tn("  eventId: " + paramString.cbd);
        locala.tn("  appId: " + paramString.appId);
        locala.tn("  link: " + paramString.eAl);
        locala.tn("  mediaId: " + paramString.sWH);
        locala.tn("  brandId: " + paramString.bFn);
      }
      paramString = this.field_favProto.sXc.iterator();
      int i = 0;
      while (paramString.hasNext())
      {
        xv localxv = (xv)paramString.next();
        locala.tn(" ----data item " + i + "----");
        locala.tn("  dataId: " + localxv.kgC);
        locala.tn("  dataType: " + localxv.aYU);
        locala.tn("  dataSouceId: " + localxv.sVo);
        locala.tn("  svrDataStatus: " + localxv.sVw);
        locala.tn("  cdnThumbUrl: " + localxv.dQL);
        locala.tn("  cdnThumbKey: " + localxv.sUC);
        locala.tn("  cdnDataUrl: " + localxv.sUG);
        locala.tn("  cdnDataKey: " + localxv.sUI);
        locala.tn("  cdnEncryVer: " + localxv.sUK);
        locala.tn("  fullmd5: " + localxv.sUX);
        locala.tn("  head256md5: " + localxv.sUZ);
        locala.tn("  fullsize: " + localxv.sVb);
        locala.tn("  thumbMd5: " + localxv.sVi);
        locala.tn("  thumbHead256md5: " + localxv.sVk);
        locala.tn("  thumbfullsize: " + localxv.sVm);
        locala.tn("  duration: " + localxv.duration);
        locala.tn("  datafmt: " + localxv.sUV);
        locala.tn("  streamWebUrl: " + localxv.sUN);
        locala.tn("  streamDataUrl: " + localxv.sUP);
        locala.tn("  streamLowBandUrl: " + localxv.sUR);
        locala.tn("  ext: " + localxv.bIm);
        if (localxv.sVA != null)
        {
          locala.tn("  remarktime: " + localxv.sVA.sWo);
          locala.tn("  ctrlflag: " + localxv.sVA.sWq);
          locala.tn("  edittime: " + localxv.sVA.srp);
          if (localxv.sVA.sWd != null)
          {
            locala.tn("   ----data source item----");
            xx localxx = localxv.sVA.sWd;
            locala.tn("    sourceType: " + localxx.bIl);
            locala.tn("    fromUser: " + localxx.bRO);
            locala.tn("    toUser: " + localxx.toUser);
            locala.tn("    realChatName: " + localxx.sWB);
            locala.tn("    createTime: " + localxx.createTime);
            locala.tn("    msgId: " + localxx.bVP);
            locala.tn("    eventId: " + localxx.cbd);
            locala.tn("    appId: " + localxx.appId);
            locala.tn("    link: " + localxx.eAl);
            locala.tn("    mediaId: " + localxx.sWH);
            locala.tn("    brandId: " + localxx.bFn);
          }
          a("  ", locala, localxv.sVA.sWf);
          a("  ", locala, localxv.sVA.sWh);
          a("  ", locala, localxv.sVA.sWj);
          a("  ", locala, localxv.sVA.sWl);
          a("  ", locala, localxv.sVA.sro);
        }
        i += 1;
      }
      a("", locala, this.field_favProto.sWf);
      a("", locala, this.field_favProto.sWh);
      a("", locala, this.field_favProto.sWj);
      a("", locala, this.field_favProto.sWl);
      a("  ", locala, this.field_favProto.sro);
    }
    locala.tn("----dump favitem end----");
  }
  
  public final boolean CF(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    Iterator localIterator = this.field_tagProto.sXq.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equals((String)localIterator.next())) {
        return false;
      }
    }
    this.field_tagProto.sXq.add(paramString);
    return true;
  }
  
  public final boolean aPX()
  {
    return (this.field_favProto.sWq & 0x1) != 0;
  }
  
  public final boolean aPY()
  {
    return (this.field_favProto.sWq & 0x2) != 0;
  }
  
  public final boolean aPZ()
  {
    return (this.field_itemStatus == 1) || (this.field_itemStatus == 4) || (this.field_itemStatus == 9) || (this.field_itemStatus == 12) || (this.field_itemStatus == 13) || (this.field_itemStatus == 15) || (this.field_itemStatus == 17);
  }
  
  public final boolean aQa()
  {
    return (this.field_itemStatus == 3) || (this.field_itemStatus == 6) || (this.field_itemStatus == 11) || (this.field_itemStatus == 14) || (this.field_itemStatus == 16) || (this.field_itemStatus == 18);
  }
  
  public final boolean aQb()
  {
    return this.field_itemStatus == 8;
  }
  
  public final boolean aQc()
  {
    return (this.field_itemStatus == 15) || (this.field_itemStatus == 16);
  }
  
  public final boolean aQd()
  {
    return (this.field_itemStatus == 12) || (this.field_itemStatus == 13) || (this.field_itemStatus == 14);
  }
  
  public final g aQe()
  {
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
    return localg;
  }
  
  public final boolean aQf()
  {
    Iterator localIterator = this.field_favProto.sXc.iterator();
    while (localIterator.hasNext()) {
      if (((xv)localIterator.next()).sVS != 0) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean isDone()
  {
    return this.field_itemStatus == 10;
  }
  
  public final boolean isDownloading()
  {
    return this.field_itemStatus == 7;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.g
 * JD-Core Version:    0.7.0.1
 */