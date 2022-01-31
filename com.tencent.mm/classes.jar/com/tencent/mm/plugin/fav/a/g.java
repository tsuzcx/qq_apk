package com.tencent.mm.plugin.fav.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bp;
import com.tencent.mm.plugin.fav.a.a.a;
import com.tencent.mm.plugin.fav.a.a.b;
import com.tencent.mm.plugin.fav.a.a.c;
import com.tencent.mm.plugin.fav.a.a.d;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.add;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class g
  extends bp
{
  public static c.a info;
  private static g.a msV;
  private static g.a msW;
  
  static
  {
    AppMethodBeat.i(102647);
    info = bp.Hm();
    msV = new g.1();
    msW = new g.2();
    AppMethodBeat.o(102647);
  }
  
  public g()
  {
    AppMethodBeat.i(102632);
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
    bwk();
    AppMethodBeat.o(102632);
  }
  
  private static void a(String paramString, g.a parama, ach paramach)
  {
    AppMethodBeat.i(102640);
    if (paramach == null)
    {
      AppMethodBeat.o(102640);
      return;
    }
    parama.log(paramString + " ----loc item----");
    parama.log(paramString + "  lng: " + paramach.lng);
    parama.log(paramString + "  lat: " + paramach.lat);
    parama.log(paramString + "  scale: " + paramach.cyX);
    parama.log(paramString + "  label: " + paramach.label);
    parama.log(paramString + "  poiname: " + paramach.cDl);
    AppMethodBeat.o(102640);
  }
  
  private static void a(String paramString, g.a parama, ack paramack)
  {
    AppMethodBeat.i(102638);
    if (paramack == null)
    {
      AppMethodBeat.o(102638);
      return;
    }
    parama.log(paramString + " ----noteInfoItem item----");
    parama.log(paramString + "  author: " + paramack.wUT);
    parama.log(paramString + "  editor: " + paramack.wUU);
    AppMethodBeat.o(102638);
  }
  
  private static void a(String paramString, g.a parama, acp paramacp)
  {
    AppMethodBeat.i(102639);
    if (paramacp == null)
    {
      AppMethodBeat.o(102639);
      return;
    }
    parama.log(paramString + " ----product item----");
    parama.log(paramString + "  title: " + paramacp.title);
    parama.log(paramString + "  desc: " + paramacp.desc);
    parama.log(paramString + "  thumbUrl: " + paramacp.thumbUrl);
    parama.log(paramString + "  type: " + paramacp.type);
    AppMethodBeat.o(102639);
  }
  
  private static void a(String paramString, g.a parama, acz paramacz)
  {
    AppMethodBeat.i(102637);
    if (paramacz == null)
    {
      AppMethodBeat.o(102637);
      return;
    }
    parama.log(paramString + " ----tv item----");
    parama.log(paramString + "  title: " + paramacz.title);
    parama.log(paramString + "  desc: " + paramacz.desc);
    parama.log(paramString + "  thumbUrl: " + paramacz.thumbUrl);
    AppMethodBeat.o(102637);
  }
  
  private static void a(String paramString, g.a parama, adf paramadf)
  {
    AppMethodBeat.i(102641);
    if (paramadf == null)
    {
      AppMethodBeat.o(102641);
      return;
    }
    parama.log(paramString + " ----url item----");
    parama.log(paramString + "  title: " + paramadf.title);
    parama.log(paramString + "  desc: " + paramadf.desc);
    parama.log(paramString + "  cleanUrl: " + paramadf.wVF);
    parama.log(paramString + "  thumbUrl: " + paramadf.thumbUrl);
    parama.log(paramString + "  opencache: " + paramadf.wVH);
    AppMethodBeat.o(102641);
  }
  
  private void bwk()
  {
    AppMethodBeat.i(102633);
    this.field_favProto = new acq();
    acw localacw = new acw();
    localacw.MR(1);
    this.field_favProto.a(localacw);
    this.field_favProto.b(new adf());
    this.field_favProto.c(new aci());
    this.field_favProto.b(new ach());
    this.field_favProto.b(new acp());
    this.field_favProto.b(new acz());
    this.field_favProto.MP(-1);
    this.field_tagProto = new add();
    this.field_favProto.a(new ack());
    AppMethodBeat.o(102633);
  }
  
  public static String s(g paramg)
  {
    AppMethodBeat.i(102643);
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append("<favitem");
    localStringBuffer1.append(" type='").append(paramg.field_type).append("'");
    localStringBuffer1.append(">");
    Object localObject2 = paramg.field_favProto;
    StringBuilder localStringBuilder = new StringBuilder();
    if (!bo.isNullOrNil(((acq)localObject2).title)) {
      localStringBuilder.append("<title>").append(bo.apT(((acq)localObject2).title)).append("</title>");
    }
    if (!bo.isNullOrNil(((acq)localObject2).desc)) {
      localStringBuilder.append("<desc>").append(bo.apT(((acq)localObject2).desc)).append("</desc>");
    }
    if (((acq)localObject2).lsP > 0L) {
      localStringBuilder.append("<edittime>").append(((acq)localObject2).lsP).append("</edittime>");
    }
    if (!bo.isNullOrNil(((acq)localObject2).hKa))
    {
      localStringBuilder.append("<remark ");
      if (((acq)localObject2).wUm > 0L) {
        localStringBuilder.append(" time ='").append(((acq)localObject2).wUm).append("'");
      }
      localStringBuilder.append(">").append(bo.apT(((acq)localObject2).hKa)).append("</remark>");
    }
    if (((acq)localObject2).wUp) {
      localStringBuilder.append("<ctrlflag>").append(((acq)localObject2).wUo).append("</ctrlflag>");
    }
    if (((acq)localObject2).wVe)
    {
      localStringBuilder.append("<version>").append(((acq)localObject2).version).append("</version>");
      localObject1 = ((acq)localObject2).wVa;
      if ((localObject1 != null) && (((acw)localObject1).computeSize() != 0)) {
        break label598;
      }
      ab.w("MicroMsg.FavSourceItemParser", "klem toXml, source item empty");
      localObject1 = "";
      label334:
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(a.bH(((acq)localObject2).wVc));
      localObject1 = paramg.field_favProto.wUd;
      if ((localObject1 != null) && (((ach)localObject1).computeSize() != 0)) {
        break label948;
      }
      ab.d("MicroMsg.FavLocItemParser", "klem toXml, loc item empty");
      localObject1 = "";
      label384:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.wUf;
      if ((localObject1 != null) && (((adf)localObject1).computeSize() != 0)) {
        break label1132;
      }
      ab.d("MicroMsg.FavUrlItemParser", "klem toXml, url item empty");
      localObject1 = "";
      label421:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.wUh;
      if ((localObject1 != null) && (((acp)localObject1).computeSize() != 0)) {
        break label1399;
      }
      ab.d("MicroMsg.FavProductItemParser", "klem toXml, product item empty");
      localObject1 = "";
      label458:
      localStringBuilder.append((String)localObject1);
      localObject1 = paramg.field_favProto.wUj;
      if ((localObject1 != null) && (((acz)localObject1).computeSize() != 0)) {
        break label1601;
      }
      ab.d("MicroMsg.FavTVItemParser", "klem toXml, product item empty");
      localObject1 = "";
      label495:
      localStringBuilder.append((String)localObject1);
      localObject1 = ((acq)localObject2).wjV;
      if ((localObject1 != null) && (((ack)localObject1).computeSize() != 0)) {
        break label1765;
      }
      ab.w("MicroMsg.FavNoteInfoItemParser", "klem toXml, source item empty");
    }
    for (Object localObject1 = "";; localObject1 = ((StringBuffer)localObject2).toString())
    {
      localStringBuilder.append((String)localObject1);
      localStringBuffer1.append(localStringBuilder.toString());
      localStringBuffer1.append(d.a(paramg.field_tagProto));
      localStringBuffer1.append("</favitem>");
      paramg = localStringBuffer1.toString();
      AppMethodBeat.o(102643);
      return paramg;
      if (paramg.field_type != 18) {
        break;
      }
      localStringBuilder.append("<version>1</version>");
      break;
      label598:
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<source");
      if (((acw)localObject1).wUv) {
        localStringBuffer2.append(" sourcetype='").append(((acw)localObject1).cpG).append("'");
      }
      if (((acw)localObject1).wVk) {
        localStringBuffer2.append(" sourceid='").append(((acw)localObject1).wVj).append("'");
      }
      localStringBuffer2.append(">");
      if (((acw)localObject1).wUw) {
        localStringBuffer2.append("<fromusr>").append(bo.apT(((acw)localObject1).czp)).append("</fromusr>");
      }
      if (((acw)localObject1).wUx) {
        localStringBuffer2.append("<tousr>").append(bo.apT(((acw)localObject1).toUser)).append("</tousr>");
      }
      if (((acw)localObject1).wUB) {
        localStringBuffer2.append("<realchatname>").append(bo.apT(((acw)localObject1).wUA)).append("</realchatname>");
      }
      if (((acw)localObject1).wUC) {
        localStringBuffer2.append("<msgid>").append(((acw)localObject1).cDC).append("</msgid>");
      }
      if (((acw)localObject1).wUD) {
        localStringBuffer2.append("<eventid>").append(((acw)localObject1).cJG).append("</eventid>");
      }
      if (((acw)localObject1).wUE) {
        localStringBuffer2.append("<appid>").append(((acw)localObject1).appId).append("</appid>");
      }
      if (((acw)localObject1).wUF) {
        localStringBuffer2.append("<link>").append(bo.apT(((acw)localObject1).link)).append("</link>");
      }
      if (((acw)localObject1).wUI) {
        localStringBuffer2.append("<brandid>").append(bo.apT(((acw)localObject1).cmx)).append("</brandid>");
      }
      localStringBuffer2.append("</source>");
      localObject1 = localStringBuffer2.toString();
      break label334;
      label948:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<locitem>");
      if (((ach)localObject1).wUQ) {
        localStringBuffer2.append("<label>").append(bo.apT(((ach)localObject1).label)).append("</label>");
      }
      if (((ach)localObject1).wUO) {
        localStringBuffer2.append("<lat>").append(((ach)localObject1).lat).append("</lat>");
      }
      if (((ach)localObject1).wUN) {
        localStringBuffer2.append("<lng>").append(((ach)localObject1).lng).append("</lng>");
      }
      if (((ach)localObject1).wUP) {
        localStringBuffer2.append("<scale>").append(((ach)localObject1).cyX).append("</scale>");
      }
      if (((ach)localObject1).wUR) {
        localStringBuffer2.append("<poiname>").append(((ach)localObject1).cDl).append("</poiname>");
      }
      localStringBuffer2.append("</locitem>");
      localObject1 = localStringBuffer2.toString();
      break label384;
      label1132:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<weburlitem>");
      if (((adf)localObject1).wVG) {
        localStringBuffer2.append("<clean_url>").append(bo.apT(((adf)localObject1).wVF)).append("</clean_url>");
      }
      if (((adf)localObject1).wSw) {
        localStringBuffer2.append("<pagedesc>").append(bo.apT(((adf)localObject1).desc)).append("</pagedesc>");
      }
      if (((adf)localObject1).wUX) {
        localStringBuffer2.append("<pagethumb_url>").append(bo.apT(((adf)localObject1).thumbUrl)).append("</pagethumb_url>");
      }
      if (((adf)localObject1).wSv) {
        localStringBuffer2.append("<pagetitle>").append(bo.apT(((adf)localObject1).title)).append("</pagetitle>");
      }
      if (((adf)localObject1).wVI) {
        localStringBuffer2.append("<opencache>").append(((adf)localObject1).wVH).append("</opencache>");
      }
      if (((adf)localObject1).wVJ) {
        localStringBuffer2.append("<contentattr>").append(((adf)localObject1).fgB).append("</contentattr>");
      }
      if (((adf)localObject1).wTH) {
        localStringBuffer2.append("<canvasPageXml>").append(((adf)localObject1).canvasPageXml).append("</canvasPageXml>");
      }
      localStringBuffer2.append(b.a(paramg.field_favProto.uVl));
      localStringBuffer2.append("</weburlitem>");
      localObject1 = localStringBuffer2.toString();
      break label421;
      label1399:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<productitem");
      if (((acp)localObject1).wUZ) {
        localStringBuffer2.append(" type='").append(((acp)localObject1).type).append("'");
      }
      localStringBuffer2.append(">");
      if (((acp)localObject1).wSv) {
        localStringBuffer2.append("<producttitle>").append(bo.apT(((acp)localObject1).title)).append("</producttitle>");
      }
      if (((acp)localObject1).wSw) {
        localStringBuffer2.append("<productdesc>").append(bo.apT(((acp)localObject1).desc)).append("</productdesc>");
      }
      if (((acp)localObject1).wUX) {
        localStringBuffer2.append("<productthumb_url>").append(bo.apT(((acp)localObject1).thumbUrl)).append("</productthumb_url>");
      }
      if (((acp)localObject1).wUY) {
        localStringBuffer2.append("<productinfo>").append(bo.apT(((acp)localObject1).info)).append("</productinfo>");
      }
      localStringBuffer2.append("</productitem>");
      localObject1 = localStringBuffer2.toString();
      break label458;
      label1601:
      localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append("<tvitem>");
      if (((acz)localObject1).wSv) {
        localStringBuffer2.append("<tvtitle>").append(bo.apT(((acz)localObject1).title)).append("</tvtitle>");
      }
      if (((acz)localObject1).wSw) {
        localStringBuffer2.append("<tvdesc>").append(bo.apT(((acz)localObject1).desc)).append("</tvdesc>");
      }
      if (((acz)localObject1).wUX) {
        localStringBuffer2.append("<tvthumb_url>").append(bo.apT(((acz)localObject1).thumbUrl)).append("</tvthumb_url>");
      }
      if (((acz)localObject1).wUY) {
        localStringBuffer2.append("<tvinfo>").append(bo.apT(((acz)localObject1).info)).append("</tvinfo>");
      }
      localStringBuffer2.append("</tvitem>");
      localObject1 = localStringBuffer2.toString();
      break label495;
      label1765:
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject2).append("<noteinfo>");
      ((StringBuffer)localObject2).append("<noteauthor>").append(bo.apT(((ack)localObject1).wUT)).append("</noteauthor>");
      ((StringBuffer)localObject2).append("<noteeditor>").append(bo.apT(((ack)localObject1).wUU)).append("</noteeditor>");
      ((StringBuffer)localObject2).append("</noteinfo>");
    }
  }
  
  public final g NF(String paramString)
  {
    AppMethodBeat.i(102635);
    if ((paramString == null) || (paramString.equals("")))
    {
      ab.e("MicroMsg.FavItemInfo", "klem, FavItemInfo xml null");
      AppMethodBeat.o(102635);
      return this;
    }
    Map localMap = br.F(paramString, "favitem");
    if (localMap == null)
    {
      ab.e("MicroMsg.FavItemInfo", "klem, FavItemInfo maps null");
      AppMethodBeat.o(102635);
      return this;
    }
    for (;;)
    {
      try
      {
        bwk();
        acq localacq = this.field_favProto;
        localacq.aol((String)localMap.get(".favitem.title"));
        localacq.aom((String)localMap.get(".favitem.desc"));
        localacq.aok((String)localMap.get(".favitem.remark"));
        localacq.nG(bo.getLong((String)localMap.get(".favitem.remark.$time"), 0L));
        localObject = (String)localMap.get(".favitem.edittime");
        localacq.MQ(bo.getInt((String)localMap.get(".favitem.version"), 0));
        localacq.nH(bo.getLong((String)localObject, 0L));
        localacq.MP(bo.getInt((String)localMap.get(".favitem.ctrlflag"), -1));
        localObject = localacq.wVa;
        ((acw)localObject).MR(bo.getInt((String)localMap.get(".favitem.source" + ".$sourcetype"), 0));
        ((acw)localObject).aop((String)localMap.get(".favitem.source" + ".$sourceid"));
        ((acw)localObject).aon((String)localMap.get(".favitem.source" + ".fromusr"));
        ((acw)localObject).aoo((String)localMap.get(".favitem.source" + ".tousr"));
        ((acw)localObject).aoq((String)localMap.get(".favitem.source" + ".realchatname"));
        ((acw)localObject).nI(bo.getLong((String)localMap.get(".favitem.source" + ".createtime"), 0L));
        ((acw)localObject).aor((String)localMap.get(".favitem.source" + ".msgid"));
        ((acw)localObject).aos((String)localMap.get(".favitem.source" + ".eventid"));
        ((acw)localObject).aot((String)localMap.get(".favitem.source" + ".appid"));
        ((acw)localObject).aou((String)localMap.get(".favitem.source" + ".link"));
        ((acw)localObject).aov((String)localMap.get(".favitem.source" + ".brandid"));
        c.a(paramString, localacq);
        paramString = localacq.wUd;
        if (!bo.isNullOrNil((String)localMap.get(".favitem.locitem" + ".label"))) {
          paramString.aoe((String)localMap.get(".favitem.locitem" + ".label"));
        }
        if (!bo.isNullOrNil((String)localMap.get(".favitem.locitem" + ".poiname"))) {
          paramString.aof((String)localMap.get(".favitem.locitem" + ".poiname"));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".lng");
        if (!bo.isNullOrNil((String)localObject)) {
          paramString.C(bo.getDouble((String)localObject, 0.0D));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".lat");
        if (!bo.isNullOrNil((String)localObject)) {
          paramString.D(bo.getDouble((String)localObject, 0.0D));
        }
        localObject = (String)localMap.get(".favitem.locitem" + ".scale");
        if (!bo.isNullOrNil((String)localObject))
        {
          if (((String)localObject).indexOf('.') == -1) {
            continue;
          }
          paramString.MN(bo.getInt(((String)localObject).substring(0, ((String)localObject).indexOf('.')), -1));
        }
        paramString = localacq.wUf;
        paramString.aoC((String)localMap.get(".favitem.weburlitem" + ".clean_url"));
        paramString.aoB((String)localMap.get(".favitem.weburlitem" + ".pagedesc"));
        paramString.aoD((String)localMap.get(".favitem.weburlitem" + ".pagethumb_url"));
        paramString.aoA((String)localMap.get(".favitem.weburlitem" + ".pagetitle"));
        paramString.MS(bo.getInt((String)localMap.get(".favitem.weburlitem" + ".opencache"), 0));
        paramString.MT(bo.getInt((String)localMap.get(".favitem.weburlitem" + ".contentattr"), 0));
        paramString.aoE((String)localMap.get(".favitem.weburlitem" + ".canvasPageXml"));
        if (localacq.uVl != null) {
          localacq.c(b.o(".favitem.weburlitem.appmsgshareitem", localMap));
        }
        paramString = localacq.wUh;
        paramString.aog((String)localMap.get(".favitem.productitem" + ".producttitle"));
        paramString.aoh((String)localMap.get(".favitem.productitem" + ".productdesc"));
        paramString.aoi((String)localMap.get(".favitem.productitem" + ".productthumb_url"));
        paramString.aoj((String)localMap.get(".favitem.productitem" + ".productinfo"));
        paramString.MO(bo.getInt((String)localMap.get(".favitem.productitem" + ".$type"), 0));
        paramString = localacq.wUj;
        paramString.aow((String)localMap.get(".favitem.tvitem" + ".tvtitle"));
        paramString.aox((String)localMap.get(".favitem.tvitem" + ".tvdesc"));
        paramString.aoy((String)localMap.get(".favitem.tvitem" + ".tvthumb_url"));
        paramString.aoz((String)localMap.get(".favitem.tvitem" + ".tvinfo"));
        paramString = localacq.wjV;
        paramString.wUT = ((String)localMap.get(".favitem.noteinfo" + ".noteauthor"));
        paramString.wUU = ((String)localMap.get(".favitem.noteinfo" + ".noteeditor"));
        paramString = localacq.wUs;
        if (paramString != null)
        {
          paramString.username = ((String)localMap.get(".favitem.appbranditem" + ".username"));
          paramString.appId = ((String)localMap.get(".favitem.appbranditem" + ".appid"));
          paramString.cvs = bo.getInt((String)localMap.get(".favitem.appbranditem" + ".pkgtype"), 0);
          paramString.iconUrl = ((String)localMap.get(".favitem.appbranditem" + ".iconurl"));
          paramString.type = bo.getInt((String)localMap.get(".favitem.appbranditem" + ".type"), 0);
          paramString.cmG = ((String)localMap.get(".favitem.appbranditem" + ".pagepath"));
          paramString.wSs = ((String)localMap.get(".favitem.appbranditem" + ".sourcedisplayname"));
        }
        if (localacq.uVl != null) {
          localacq.c(b.o(".favitem.weburlitem.appmsgshareitem", localMap));
        }
        if (this.field_favProto.wVa != null)
        {
          paramString = this.field_favProto.wVa;
          this.field_sourceId = paramString.wVj;
          this.field_sourceType = paramString.cpG;
          this.field_fromUser = paramString.czp;
          this.field_toUser = paramString.toUser;
        }
        this.field_edittime = this.field_favProto.lsP;
        d.a(localMap, this.field_tagProto);
      }
      catch (Exception paramString)
      {
        Object localObject;
        ab.printErrStackTrace("MicroMsg.FavItemInfo", paramString, "", new Object[0]);
        ab.e("MicroMsg.FavItemInfo", "klem , FavItemInfo exception:+%s", new Object[] { paramString.toString() });
        continue;
      }
      AppMethodBeat.o(102635);
      return this;
      paramString.MN(bo.getInt((String)localObject, -1));
    }
  }
  
  public final void NG(String paramString)
  {
    AppMethodBeat.i(102636);
    g.a locala = msV;
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
      locala.log("remarktime: " + this.field_favProto.wUm);
      locala.log("dataitemCount: " + this.field_favProto.wVc.size());
      if (this.field_favProto.wVa != null)
      {
        locala.log(" ----source item----");
        paramString = this.field_favProto.wVa;
        locala.log("  sourceType: " + paramString.cpG);
        locala.log("  fromUser: " + paramString.czp);
        locala.log("  toUser: " + paramString.toUser);
        locala.log("  sourceId: " + paramString.wVj);
        locala.log("  realChatName: " + paramString.wUA);
        locala.log("  createTime: " + paramString.createTime);
        locala.log("  msgId: " + paramString.cDC);
        locala.log("  eventId: " + paramString.cJG);
        locala.log("  appId: " + paramString.appId);
        locala.log("  link: " + paramString.link);
        locala.log("  mediaId: " + paramString.wUG);
        locala.log("  brandId: " + paramString.cmx);
      }
      paramString = this.field_favProto.wVc.iterator();
      int i = 0;
      while (paramString.hasNext())
      {
        aca localaca = (aca)paramString.next();
        locala.log(" ----data item " + i + "----");
        locala.log("  dataId: " + localaca.mBq);
        locala.log("  dataType: " + localaca.dataType);
        locala.log("  dataSouceId: " + localaca.wTk);
        locala.log("  svrDataStatus: " + localaca.wTs);
        locala.log("  cdnThumbUrl: " + localaca.fgM);
        locala.log("  cdnThumbKey: " + localaca.wSy);
        locala.log("  cdnDataUrl: " + localaca.wSC);
        locala.log("  cdnDataKey: " + localaca.wSE);
        locala.log("  cdnEncryVer: " + localaca.wSG);
        locala.log("  fullmd5: " + localaca.wST);
        locala.log("  head256md5: " + localaca.wSV);
        locala.log("  fullsize: " + localaca.wSX);
        locala.log("  thumbMd5: " + localaca.wTe);
        locala.log("  thumbHead256md5: " + localaca.wTg);
        locala.log("  thumbfullsize: " + localaca.wTi);
        locala.log("  duration: " + localaca.duration);
        locala.log("  datafmt: " + localaca.wSR);
        locala.log("  streamWebUrl: " + localaca.wSJ);
        locala.log("  streamDataUrl: " + localaca.wSL);
        locala.log("  streamLowBandUrl: " + localaca.wSN);
        locala.log("  ext: " + localaca.cpH);
        if (localaca.wTw != null)
        {
          locala.log("  remarktime: " + localaca.wTw.wUm);
          locala.log("  ctrlflag: " + localaca.wTw.wUo);
          locala.log("  edittime: " + localaca.wTw.lsP);
          if (localaca.wTw.wUb != null)
          {
            locala.log("   ----data source item----");
            acc localacc = localaca.wTw.wUb;
            locala.log("    sourceType: " + localacc.cpG);
            locala.log("    fromUser: " + localacc.czp);
            locala.log("    toUser: " + localacc.toUser);
            locala.log("    realChatName: " + localacc.wUA);
            locala.log("    createTime: " + localacc.createTime);
            locala.log("    msgId: " + localacc.cDC);
            locala.log("    eventId: " + localacc.cJG);
            locala.log("    appId: " + localacc.appId);
            locala.log("    link: " + localacc.link);
            locala.log("    mediaId: " + localacc.wUG);
            locala.log("    brandId: " + localacc.cmx);
          }
          a("  ", locala, localaca.wTw.wUd);
          a("  ", locala, localaca.wTw.wUf);
          a("  ", locala, localaca.wTw.wUh);
          a("  ", locala, localaca.wTw.wUj);
          a("  ", locala, localaca.wTw.wjV);
        }
        i += 1;
      }
      a("", locala, this.field_favProto.wUd);
      a("", locala, this.field_favProto.wUf);
      a("", locala, this.field_favProto.wUh);
      a("", locala, this.field_favProto.wUj);
      a("  ", locala, this.field_favProto.wjV);
    }
    locala.log("----dump favitem end----");
    AppMethodBeat.o(102636);
  }
  
  public final boolean NH(String paramString)
  {
    AppMethodBeat.i(102642);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(102642);
      return false;
    }
    Iterator localIterator = this.field_tagProto.wVq.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equals((String)localIterator.next()))
      {
        AppMethodBeat.o(102642);
        return false;
      }
    }
    this.field_tagProto.wVq.add(paramString);
    AppMethodBeat.o(102642);
    return true;
  }
  
  public final boolean bwl()
  {
    return (this.field_favProto.wUo & 0x1) != 0;
  }
  
  public final boolean bwm()
  {
    return (this.field_favProto.wUo & 0x2) != 0;
  }
  
  public final Bundle bwn()
  {
    AppMethodBeat.i(102634);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_ctrl_flag_open_chat", bwl());
    localBundle.putBoolean("key_ctrl_flag_open_sns", bwm());
    if ((this.field_favProto.wUo & 0x4) != 0)
    {
      bool = true;
      localBundle.putBoolean("key_ctrl_flag_open_weibo", bool);
      if ((this.field_favProto.wUo & 0x8) == 0) {
        break label183;
      }
      bool = true;
      label73:
      localBundle.putBoolean("key_ctrl_flag_open_cplink", bool);
      if ((this.field_favProto.wUo & 0x10) == 0) {
        break label188;
      }
      bool = true;
      label96:
      localBundle.putBoolean("key_ctrl_flag_open_browser", bool);
      if ((this.field_favProto.wUo & 0x20) == 0) {
        break label193;
      }
      bool = true;
      label119:
      localBundle.putBoolean("key_ctrl_flag_open_weiyun", bool);
      if ((this.field_favProto.wUo & 0x40) == 0) {
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
      ab.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", new Object[] { localBundle.toString() });
      AppMethodBeat.o(102634);
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
  
  public final boolean bwo()
  {
    return (this.field_itemStatus == 1) || (this.field_itemStatus == 4) || (this.field_itemStatus == 9) || (this.field_itemStatus == 12) || (this.field_itemStatus == 13) || (this.field_itemStatus == 15) || (this.field_itemStatus == 17);
  }
  
  public final boolean bwp()
  {
    return (this.field_itemStatus == 3) || (this.field_itemStatus == 6) || (this.field_itemStatus == 11) || (this.field_itemStatus == 14) || (this.field_itemStatus == 16) || (this.field_itemStatus == 18);
  }
  
  public final boolean bwq()
  {
    return this.field_itemStatus == 8;
  }
  
  public final boolean bwr()
  {
    return (this.field_itemStatus == 15) || (this.field_itemStatus == 16);
  }
  
  public final boolean bws()
  {
    return (this.field_itemStatus == 12) || (this.field_itemStatus == 13) || (this.field_itemStatus == 14);
  }
  
  public final g bwt()
  {
    AppMethodBeat.i(102644);
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
    AppMethodBeat.o(102644);
    return localg;
  }
  
  public final boolean bwu()
  {
    AppMethodBeat.i(102645);
    Iterator localIterator = this.field_favProto.wVc.iterator();
    while (localIterator.hasNext()) {
      if (((aca)localIterator.next()).wTO != 0)
      {
        AppMethodBeat.o(102645);
        return true;
      }
    }
    AppMethodBeat.o(102645);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.g
 * JD-Core Version:    0.7.0.1
 */