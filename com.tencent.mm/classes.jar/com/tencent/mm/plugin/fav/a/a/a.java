package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aby;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class a
{
  public static String bH(List<aca> paramList)
  {
    AppMethodBeat.i(102754);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ab.v("MicroMsg.FavDataItemParser", "klem toXml data list empty");
      AppMethodBeat.o(102754);
      return "";
    }
    int j = paramList.size();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("<datalist count='").append(j).append("'>");
    int i = 0;
    if (i < j)
    {
      Object localObject1 = (aca)paramList.get(i);
      localStringBuffer.append("<dataitem ");
      if (((aca)localObject1).wSQ) {
        localStringBuffer.append("datatype='").append(((aca)localObject1).dataType).append("'");
      }
      if (((aca)localObject1).wTt) {
        localStringBuffer.append(" datastatus='").append(((aca)localObject1).wTs).append("'");
      }
      if (((aca)localObject1).wSZ) {
        localStringBuffer.append(" dataid='").append(((aca)localObject1).mBq).append("'");
      }
      if (((aca)localObject1).wTF) {
        localStringBuffer.append(" htmlid='").append(bo.apT(((aca)localObject1).wTE)).append("'");
      }
      if (((aca)localObject1).wTL) {
        localStringBuffer.append(" dataillegaltype='").append(((aca)localObject1).wTK).append("'");
      }
      if (((aca)localObject1).wTl) {
        localStringBuffer.append(" datasourceid='").append(((aca)localObject1).wTk).append("'");
      }
      localStringBuffer.append(">");
      if (((aca)localObject1).wSS) {
        localStringBuffer.append("<datafmt>").append(((aca)localObject1).wSR).append("</datafmt>");
      }
      if (((aca)localObject1).wSv) {
        localStringBuffer.append("<datatitle>").append(bo.apT(((aca)localObject1).title)).append("</datatitle>");
      }
      if (((aca)localObject1).wSw) {
        localStringBuffer.append("<datadesc>").append(bo.apT(((aca)localObject1).desc)).append("</datadesc>");
      }
      if (((aca)localObject1).wSx) {
        localStringBuffer.append("<cdn_thumburl>").append(bo.apT(((aca)localObject1).fgM)).append("</cdn_thumburl>");
      }
      if (((aca)localObject1).wSA) {
        localStringBuffer.append("<thumb_width>").append(((aca)localObject1).fgR).append("</thumb_width>");
      }
      if (((aca)localObject1).wSB) {
        localStringBuffer.append("<thumb_height>").append(((aca)localObject1).fgQ).append("</thumb_height>");
      }
      if (((aca)localObject1).wSD) {
        localStringBuffer.append("<cdn_dataurl>").append(bo.apT(((aca)localObject1).wSC)).append("</cdn_dataurl>");
      }
      if (((aca)localObject1).wSz) {
        localStringBuffer.append("<cdn_thumbkey>").append(bo.apT(((aca)localObject1).wSy)).append("</cdn_thumbkey>");
      }
      if (((aca)localObject1).wSF) {
        localStringBuffer.append("<cdn_datakey>").append(bo.apT(((aca)localObject1).wSE)).append("</cdn_datakey>");
      }
      if (((aca)localObject1).wSH) {
        localStringBuffer.append("<cdn_encryver>").append(((aca)localObject1).wSG).append("</cdn_encryver>");
      }
      if (((aca)localObject1).wSI) {
        localStringBuffer.append("<duration>").append(((aca)localObject1).duration).append("</duration>");
      }
      if (((aca)localObject1).wSK) {
        localStringBuffer.append("<stream_weburl>").append(bo.apT(((aca)localObject1).wSJ)).append("</stream_weburl>");
      }
      if (((aca)localObject1).wSM) {
        localStringBuffer.append("<stream_dataurl>").append(bo.apT(((aca)localObject1).wSL)).append("</stream_dataurl>");
      }
      if (((aca)localObject1).wSO) {
        localStringBuffer.append("<stream_lowbandurl>").append(bo.apT(((aca)localObject1).wSN)).append("</stream_lowbandurl>");
      }
      if (((aca)localObject1).wSP) {
        localStringBuffer.append("<dataext>").append(bo.apT(((aca)localObject1).cpH)).append("</dataext>");
      }
      if (((aca)localObject1).wSU) {
        localStringBuffer.append("<fullmd5>").append(((aca)localObject1).wST).append("</fullmd5>");
      }
      if (((aca)localObject1).wSW) {
        localStringBuffer.append("<head256md5>").append(((aca)localObject1).wSV).append("</head256md5>");
      }
      if (((aca)localObject1).wSY) {
        localStringBuffer.append("<fullsize>").append(((aca)localObject1).wSX).append("</fullsize>");
      }
      if (((aca)localObject1).wTf) {
        localStringBuffer.append("<thumbfullmd5>").append(((aca)localObject1).wTe).append("</thumbfullmd5>");
      }
      if (((aca)localObject1).wTh) {
        localStringBuffer.append("<thumbhead256md5>").append(((aca)localObject1).wTg).append("</thumbhead256md5>");
      }
      if (((aca)localObject1).wTj) {
        localStringBuffer.append("<thumbfullsize>").append(((aca)localObject1).wTi).append("</thumbfullsize>");
      }
      if (((aca)localObject1).wTn) {
        localStringBuffer.append("<stream_videoid>").append(bo.apT(((aca)localObject1).wTm)).append("</stream_videoid>");
      }
      if (((aca)localObject1).wTv) {
        localStringBuffer.append("<datasrctitle>").append(bo.apT(((aca)localObject1).wTu)).append("</datasrctitle>");
      }
      if (((aca)localObject1).wTz) {
        localStringBuffer.append("<datasrcname>").append(bo.apT(((aca)localObject1).wTy)).append("</datasrcname>");
      }
      if (((aca)localObject1).wTB) {
        localStringBuffer.append("<datasrctime>").append(bo.apT(((aca)localObject1).wTA)).append("</datasrctime>");
      }
      if ((((aca)localObject1).wTH) && ((((aca)localObject1).wTw == null) || (((aca)localObject1).wTw.wUf == null) || (((aca)localObject1).wTw.wUf.computeSize() == 0))) {
        localStringBuffer.append("<canvasPageXml>").append(bo.apT(((aca)localObject1).canvasPageXml)).append("</canvasPageXml>");
      }
      if (((aca)localObject1).wTG) {
        localStringBuffer.append("<statextstr>").append(bo.apT(((aca)localObject1).cGU)).append("</statextstr>");
      }
      if (((aca)localObject1).wTN) {
        localStringBuffer.append("<recordxml>").append(((aca)localObject1).wTM).append("</recordxml>");
      }
      Object localObject2 = ((aca)localObject1).wTC;
      if (localObject2 != null)
      {
        localStringBuffer.append("<streamvideo>");
        localStringBuffer.append("<streamvideourl>").append(bo.apT(((acd)localObject2).fiO)).append("</streamvideourl>");
        localStringBuffer.append("<streamvideototaltime>").append(((acd)localObject2).wUJ).append("</streamvideototaltime>");
        localStringBuffer.append("<streamvideotitle>").append(bo.apT(((acd)localObject2).fiQ)).append("</streamvideotitle>");
        localStringBuffer.append("<streamvideowording>").append(bo.apT(((acd)localObject2).fiR)).append("</streamvideowording>");
        localStringBuffer.append("<streamvideoweburl>").append(bo.apT(((acd)localObject2).fiS)).append("</streamvideoweburl>");
        localStringBuffer.append("<streamvideoaduxinfo>").append(bo.apT(((acd)localObject2).fiU)).append("</streamvideoaduxinfo>");
        localStringBuffer.append("<streamvideopublishid>").append(bo.apT(((acd)localObject2).fiV)).append("</streamvideopublishid>");
        localStringBuffer.append("</streamvideo>");
      }
      localObject2 = ((aca)localObject1).wTw;
      if ((localObject2 == null) || (((acb)localObject2).wUb == null) || (((acb)localObject2).wUb.computeSize() == 0))
      {
        ab.v("MicroMsg.FavDataItemParser", "klem toXml, data source item empty");
        label1401:
        localObject2 = ((aca)localObject1).wTw;
        if ((localObject2 != null) && (((acb)localObject2).wUd != null) && (((acb)localObject2).wUd.computeSize() != 0)) {
          break label1946;
        }
        ab.v("MicroMsg.FavDataItemParser", "klem toXml, loc item empty");
        label1440:
        localObject2 = ((aca)localObject1).wTw;
        if ((localObject2 != null) && (((acb)localObject2).wUf != null) && (((acb)localObject2).wUf.computeSize() != 0)) {
          break label2125;
        }
        ab.v("MicroMsg.FavDataItemParser", "klem toXml, url item empty");
        localObject2 = ((aca)localObject1).wTw;
        if ((localObject2 != null) && (((acb)localObject2).wUh != null) && (((acb)localObject2).wUh.computeSize() != 0)) {
          break label2413;
        }
        ab.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
        label1518:
        localObject2 = ((aca)localObject1).wTw;
        if ((localObject2 != null) && (((acb)localObject2).wUj != null) && (((acb)localObject2).wUj.computeSize() != 0)) {
          break label2607;
        }
        ab.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
        label1557:
        localObject1 = ((aca)localObject1).wTw;
        if ((localObject1 != null) && (((acb)localObject1).wUs != null)) {
          break label2765;
        }
        ab.e("MicroMsg.FavDataItemParser", "setAppBrandXml toXml, item empty");
      }
      for (;;)
      {
        localStringBuffer.append("</dataitem>");
        i += 1;
        break;
        localObject2 = ((acb)localObject2).wUb;
        localStringBuffer.append("<dataitemsource");
        if (((acc)localObject2).wUv) {
          localStringBuffer.append(" sourcetype='").append(((acc)localObject2).cpG).append("'");
        }
        if (((acc)localObject2).wUz) {
          localStringBuffer.append(" sourceid='").append(((acc)localObject2).wUy).append("'");
        }
        localStringBuffer.append(">");
        if (((acc)localObject2).wUw) {
          localStringBuffer.append("<fromusr>").append(bo.apT(((acc)localObject2).czp)).append("</fromusr>");
        }
        if (((acc)localObject2).wUx) {
          localStringBuffer.append("<tousr>").append(bo.apT(((acc)localObject2).toUser)).append("</tousr>");
        }
        if (((acc)localObject2).wUB) {
          localStringBuffer.append("<realchatname>").append(bo.apT(((acc)localObject2).wUA)).append("</realchatname>");
        }
        if (((acc)localObject2).wUC) {
          localStringBuffer.append("<msgid>").append(((acc)localObject2).cDC).append("</msgid>");
        }
        if (((acc)localObject2).wUD) {
          localStringBuffer.append("<eventid>").append(((acc)localObject2).cJG).append("</eventid>");
        }
        if (((acc)localObject2).wUE) {
          localStringBuffer.append("<appid>").append(((acc)localObject2).appId).append("</appid>");
        }
        if (((acc)localObject2).wUF) {
          localStringBuffer.append("<link>").append(bo.apT(((acc)localObject2).link)).append("</link>");
        }
        if (((acc)localObject2).wUI) {
          localStringBuffer.append("<brandid>").append(bo.apT(((acc)localObject2).cmx)).append("</brandid>");
        }
        localStringBuffer.append("</dataitemsource>");
        break label1401;
        label1946:
        localObject2 = ((acb)localObject2).wUd;
        localStringBuffer.append("<locitem>");
        if (((ach)localObject2).wUQ) {
          localStringBuffer.append("<label>").append(bo.apT(((ach)localObject2).label)).append("</label>");
        }
        if (((ach)localObject2).wUO) {
          localStringBuffer.append("<lat>").append(((ach)localObject2).lat).append("</lat>");
        }
        if (((ach)localObject2).wUN) {
          localStringBuffer.append("<lng>").append(((ach)localObject2).lng).append("</lng>");
        }
        if (((ach)localObject2).wUP) {
          localStringBuffer.append("<scale>").append(((ach)localObject2).cyX).append("</scale>");
        }
        if (((ach)localObject2).wUR) {
          localStringBuffer.append("<poiname>").append(((ach)localObject2).cDl).append("</poiname>");
        }
        localStringBuffer.append("</locitem>");
        break label1440;
        label2125:
        adf localadf = ((acb)localObject2).wUf;
        localStringBuffer.append("<weburlitem>");
        if (localadf.wVG) {
          localStringBuffer.append("<clean_url>").append(bo.apT(localadf.wVF)).append("</clean_url>");
        }
        if (localadf.wSw) {
          localStringBuffer.append("<pagedesc>").append(bo.apT(localadf.desc)).append("</pagedesc>");
        }
        if (localadf.wUX) {
          localStringBuffer.append("<pagethumb_url>").append(bo.apT(localadf.thumbUrl)).append("</pagethumb_url>");
        }
        if (localadf.wSv) {
          localStringBuffer.append("<pagetitle>").append(bo.apT(localadf.title)).append("</pagetitle>");
        }
        if (localadf.wVI) {
          localStringBuffer.append("<opencache>").append(localadf.wVH).append("</opencache>");
        }
        if (localadf.wVJ) {
          localStringBuffer.append("<contentattr>").append(localadf.fgB).append("</contentattr>");
        }
        if (localadf.wTH) {
          localStringBuffer.append("<canvasPageXml>").append(bo.apT(localadf.canvasPageXml)).append("</canvasPageXml>");
        }
        if ((localObject2 == null) || (((acb)localObject2).uVl == null)) {
          ab.d("MicroMsg.FavDataItemParser", "setMpMsgXml toXml, item empty");
        }
        for (;;)
        {
          localStringBuffer.append("</weburlitem>");
          break;
          localStringBuffer.append(b.a(((acb)localObject2).uVl));
        }
        label2413:
        localObject2 = ((acb)localObject2).wUh;
        localStringBuffer.append("<productitem");
        if (((acp)localObject2).wUZ) {
          localStringBuffer.append(" type='").append(((acp)localObject2).type).append("'");
        }
        localStringBuffer.append(">");
        if (((acp)localObject2).wSv) {
          localStringBuffer.append("<producttitle>").append(bo.apT(((acp)localObject2).title)).append("</producttitle>");
        }
        if (((acp)localObject2).wSw) {
          localStringBuffer.append("<productdesc>").append(bo.apT(((acp)localObject2).desc)).append("</productdesc>");
        }
        if (((acp)localObject2).wUX) {
          localStringBuffer.append("<productthumb_url>").append(bo.apT(((acp)localObject2).thumbUrl)).append("</productthumb_url>");
        }
        if (((acp)localObject2).wUY) {
          localStringBuffer.append("<productinfo>").append(bo.apT(((acp)localObject2).info)).append("</productinfo>");
        }
        localStringBuffer.append("</productitem>");
        break label1518;
        label2607:
        localObject2 = ((acb)localObject2).wUj;
        localStringBuffer.append("<tvitem>");
        if (((acz)localObject2).wSv) {
          localStringBuffer.append("<tvtitle>").append(bo.apT(((acz)localObject2).title)).append("</tvtitle>");
        }
        if (((acz)localObject2).wSw) {
          localStringBuffer.append("<tvdesc>").append(bo.apT(((acz)localObject2).desc)).append("</tvdesc>");
        }
        if (((acz)localObject2).wUX) {
          localStringBuffer.append("<tvthumb_url>").append(bo.apT(((acz)localObject2).thumbUrl)).append("</tvthumb_url>");
        }
        if (((acz)localObject2).wUY) {
          localStringBuffer.append("<tvinfo>").append(bo.apT(((acz)localObject2).info)).append("</tvinfo>");
        }
        localStringBuffer.append("</tvitem>");
        break label1557;
        label2765:
        localObject1 = ((acb)localObject1).wUs;
        if (localObject1 != null)
        {
          localStringBuffer.append("<appbranditem>");
          localStringBuffer.append("<username>").append(bo.apT(((aby)localObject1).username)).append("</username>");
          localStringBuffer.append("<appid>").append(bo.apT(((aby)localObject1).appId)).append("</appid>");
          localStringBuffer.append("<pkgtype>").append(((aby)localObject1).cvs).append("</pkgtype>");
          localStringBuffer.append("<iconurl>").append(bo.apT(((aby)localObject1).iconUrl)).append("</iconurl>");
          localStringBuffer.append("<type>").append(((aby)localObject1).type).append("</type>");
          localStringBuffer.append("<pagepath>").append(bo.apT(((aby)localObject1).cmG)).append("</pagepath>");
          localStringBuffer.append("<sourcedisplayname>").append(bo.apT(((aby)localObject1).wSs)).append("</sourcedisplayname>");
          localStringBuffer.append("</appbranditem>");
        }
      }
    }
    localStringBuffer.append("</datalist>");
    paramList = localStringBuffer.toString();
    AppMethodBeat.o(102754);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.a
 * JD-Core Version:    0.7.0.1
 */