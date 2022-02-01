package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.d;
import com.tencent.mm.protocal.protobuf.afw;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.agf;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public final class a
{
  public static String dj(List<afy> paramList)
  {
    AppMethodBeat.i(103494);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ad.v("MicroMsg.FavDataItemParser", "klem toXml data list empty");
      AppMethodBeat.o(103494);
      return "";
    }
    int j = paramList.size();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("<datalist count='").append(j).append("'>");
    int i = 0;
    if (i < j)
    {
      Object localObject1 = (afy)paramList.get(i);
      localStringBuffer.append("<dataitem ");
      if (((afy)localObject1).Dgn) {
        localStringBuffer.append("datatype='").append(((afy)localObject1).dataType).append("'");
      }
      if (((afy)localObject1).DgQ) {
        localStringBuffer.append(" datastatus='").append(((afy)localObject1).DgP).append("'");
      }
      if (((afy)localObject1).Dgw) {
        localStringBuffer.append(" dataid='").append(((afy)localObject1).dkb).append("'");
      }
      if (((afy)localObject1).Dhc) {
        localStringBuffer.append(" htmlid='").append(bt.aGf(((afy)localObject1).Dhb)).append("'");
      }
      if (((afy)localObject1).Dhi) {
        localStringBuffer.append(" dataillegaltype='").append(((afy)localObject1).Dhh).append("'");
      }
      if (((afy)localObject1).DgI) {
        localStringBuffer.append(" datasourceid='").append(((afy)localObject1).DgH).append("'");
      }
      localStringBuffer.append(">");
      if (((afy)localObject1).Dgp) {
        localStringBuffer.append("<datafmt>").append(((afy)localObject1).Dgo).append("</datafmt>");
      }
      if (((afy)localObject1).DfS) {
        localStringBuffer.append("<datatitle>").append(bt.aGf(((afy)localObject1).title)).append("</datatitle>");
      }
      if (((afy)localObject1).DfT) {
        localStringBuffer.append("<datadesc>").append(bt.aGf(((afy)localObject1).desc)).append("</datadesc>");
      }
      if (((afy)localObject1).DfU) {
        localStringBuffer.append("<cdn_thumburl>").append(bt.aGf(((afy)localObject1).gHu)).append("</cdn_thumburl>");
      }
      if (((afy)localObject1).DfX) {
        localStringBuffer.append("<thumb_width>").append(((afy)localObject1).thumbWidth).append("</thumb_width>");
      }
      if (((afy)localObject1).DfY) {
        localStringBuffer.append("<thumb_height>").append(((afy)localObject1).thumbHeight).append("</thumb_height>");
      }
      if (((afy)localObject1).Dga) {
        localStringBuffer.append("<cdn_dataurl>").append(bt.aGf(((afy)localObject1).DfZ)).append("</cdn_dataurl>");
      }
      if (((afy)localObject1).DfW) {
        localStringBuffer.append("<cdn_thumbkey>").append(bt.aGf(((afy)localObject1).DfV)).append("</cdn_thumbkey>");
      }
      if (((afy)localObject1).Dgc) {
        localStringBuffer.append("<cdn_datakey>").append(bt.aGf(((afy)localObject1).Dgb)).append("</cdn_datakey>");
      }
      if (((afy)localObject1).Dge) {
        localStringBuffer.append("<cdn_encryver>").append(((afy)localObject1).Dgd).append("</cdn_encryver>");
      }
      if (((afy)localObject1).Dgf) {
        localStringBuffer.append("<duration>").append(((afy)localObject1).duration).append("</duration>");
      }
      if (((afy)localObject1).Dgh) {
        localStringBuffer.append("<stream_weburl>").append(bt.aGf(((afy)localObject1).Dgg)).append("</stream_weburl>");
      }
      if (((afy)localObject1).Dhy) {
        localStringBuffer.append("<songalbumurl>").append(bt.aGf(((afy)localObject1).songAlbumUrl)).append("</songalbumurl>");
      }
      if (((afy)localObject1).Dhz) {
        localStringBuffer.append("<songlyric>").append(bt.aGf(((afy)localObject1).songLyric)).append("</songlyric>");
      }
      if (((afy)localObject1).Dgj) {
        localStringBuffer.append("<stream_dataurl>").append(bt.aGf(((afy)localObject1).Dgi)).append("</stream_dataurl>");
      }
      if (((afy)localObject1).Dgl) {
        localStringBuffer.append("<stream_lowbandurl>").append(bt.aGf(((afy)localObject1).Dgk)).append("</stream_lowbandurl>");
      }
      if (((afy)localObject1).Dgm) {
        localStringBuffer.append("<dataext>").append(bt.aGf(((afy)localObject1).deE)).append("</dataext>");
      }
      if (((afy)localObject1).Dgr) {
        localStringBuffer.append("<fullmd5>").append(((afy)localObject1).Dgq).append("</fullmd5>");
      }
      if (((afy)localObject1).Dgt) {
        localStringBuffer.append("<head256md5>").append(((afy)localObject1).Dgs).append("</head256md5>");
      }
      if (((afy)localObject1).Dgv) {
        localStringBuffer.append("<fullsize>").append(((afy)localObject1).Dgu).append("</fullsize>");
      }
      if (((afy)localObject1).DgC) {
        localStringBuffer.append("<thumbfullmd5>").append(((afy)localObject1).DgB).append("</thumbfullmd5>");
      }
      if (((afy)localObject1).DgE) {
        localStringBuffer.append("<thumbhead256md5>").append(((afy)localObject1).DgD).append("</thumbhead256md5>");
      }
      if (((afy)localObject1).DgG) {
        localStringBuffer.append("<thumbfullsize>").append(((afy)localObject1).DgF).append("</thumbfullsize>");
      }
      if (((afy)localObject1).DgK) {
        localStringBuffer.append("<stream_videoid>").append(bt.aGf(((afy)localObject1).DgJ)).append("</stream_videoid>");
      }
      if (((afy)localObject1).DgS) {
        localStringBuffer.append("<datasrctitle>").append(bt.aGf(((afy)localObject1).DgR)).append("</datasrctitle>");
      }
      if (((afy)localObject1).DgW) {
        localStringBuffer.append("<datasrcname>").append(bt.aGf(((afy)localObject1).DgV)).append("</datasrcname>");
      }
      if (((afy)localObject1).DgY) {
        localStringBuffer.append("<datasrctime>").append(bt.aGf(((afy)localObject1).DgX)).append("</datasrctime>");
      }
      if ((((afy)localObject1).Dhe) && ((((afy)localObject1).DgT == null) || (((afy)localObject1).DgT.DhE == null) || (((afy)localObject1).DgT.DhE.computeSize() == 0))) {
        localStringBuffer.append("<canvasPageXml>").append(bt.aGf(((afy)localObject1).canvasPageXml)).append("</canvasPageXml>");
      }
      if (((afy)localObject1).Dhd) {
        localStringBuffer.append("<statextstr>").append(bt.aGf(((afy)localObject1).dxG)).append("</statextstr>");
      }
      if (((afy)localObject1).Dhk) {
        localStringBuffer.append("<recordxml>").append(((afy)localObject1).Dhj).append("</recordxml>");
      }
      if (((afy)localObject1).hAv) {
        localStringBuffer.append("<messageuuid>").append(bt.aGf(((afy)localObject1).hAt)).append("</messageuuid>");
      }
      Object localObject2 = ((afy)localObject1).DgZ;
      if (localObject2 != null)
      {
        localStringBuffer.append("<streamvideo>");
        localStringBuffer.append("<streamvideourl>").append(bt.aGf(((agb)localObject2).gJv)).append("</streamvideourl>");
        localStringBuffer.append("<streamvideototaltime>").append(((agb)localObject2).Dim).append("</streamvideototaltime>");
        localStringBuffer.append("<streamvideotitle>").append(bt.aGf(((agb)localObject2).gJx)).append("</streamvideotitle>");
        localStringBuffer.append("<streamvideowording>").append(bt.aGf(((agb)localObject2).gJy)).append("</streamvideowording>");
        localStringBuffer.append("<streamvideoweburl>").append(bt.aGf(((agb)localObject2).gJz)).append("</streamvideoweburl>");
        localStringBuffer.append("<streamvideoaduxinfo>").append(bt.aGf(((agb)localObject2).gJB)).append("</streamvideoaduxinfo>");
        localStringBuffer.append("<streamvideopublishid>").append(bt.aGf(((agb)localObject2).gJC)).append("</streamvideopublishid>");
        localStringBuffer.append("</streamvideo>");
      }
      localObject2 = ((afy)localObject1).DgT;
      if ((localObject2 == null) || (((afz)localObject2).DhA == null) || (((afz)localObject2).DhA.computeSize() == 0))
      {
        ad.v("MicroMsg.FavDataItemParser", "klem toXml, data source item empty");
        label1500:
        localObject2 = ((afy)localObject1).DgT;
        if ((localObject2 != null) && (((afz)localObject2).DhC != null) && (((afz)localObject2).DhC.computeSize() != 0)) {
          break label2101;
        }
        ad.v("MicroMsg.FavDataItemParser", "klem toXml, loc item empty");
        label1539:
        localObject2 = ((afy)localObject1).DgT;
        if ((localObject2 != null) && (((afz)localObject2).DhE != null) && (((afz)localObject2).DhE.computeSize() != 0)) {
          break label2280;
        }
        ad.v("MicroMsg.FavDataItemParser", "klem toXml, url item empty");
        localObject2 = ((afy)localObject1).DgT;
        if ((localObject2 != null) && (((afz)localObject2).DhW != null)) {
          break label2601;
        }
        ad.i("MicroMsg.FavDataItemParser", "klem toXml, finder item empty");
        label1606:
        localObject2 = ((afy)localObject1).DgT;
        if ((localObject2 != null) && (((afz)localObject2).DhU != null)) {
          break label2617;
        }
        ad.d("MicroMsg.FavDataItemParser", "setMpVideoXml toXml, item empty");
        label1634:
        localObject2 = ((afy)localObject1).DgT;
        if ((localObject2 != null) && (((afz)localObject2).DhG != null) && (((afz)localObject2).DhG.computeSize() != 0)) {
          break label2633;
        }
        ad.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
        label1673:
        localObject2 = ((afy)localObject1).DgT;
        if ((localObject2 != null) && (((afz)localObject2).DhI != null) && (((afz)localObject2).DhI.computeSize() != 0)) {
          break label2827;
        }
        ad.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
        label1712:
        localObject1 = ((afy)localObject1).DgT;
        if ((localObject1 != null) && (((afz)localObject1).DhR != null)) {
          break label2985;
        }
        ad.e("MicroMsg.FavDataItemParser", "setAppBrandXml toXml, item empty");
      }
      for (;;)
      {
        localStringBuffer.append("</dataitem>");
        i += 1;
        break;
        localObject2 = ((afz)localObject2).DhA;
        localStringBuffer.append("<dataitemsource");
        if (((aga)localObject2).DhY) {
          localStringBuffer.append(" sourcetype='").append(((aga)localObject2).sourceType).append("'");
        }
        if (((aga)localObject2).Dic) {
          localStringBuffer.append(" sourceid='").append(((aga)localObject2).Dib).append("'");
        }
        localStringBuffer.append(">");
        if (((aga)localObject2).DhZ) {
          localStringBuffer.append("<fromusr>").append(bt.aGf(((aga)localObject2).dpv)).append("</fromusr>");
        }
        if (((aga)localObject2).Dia) {
          localStringBuffer.append("<tousr>").append(bt.aGf(((aga)localObject2).toUser)).append("</tousr>");
        }
        if (((aga)localObject2).Die) {
          localStringBuffer.append("<realchatname>").append(bt.aGf(((aga)localObject2).Did)).append("</realchatname>");
        }
        if (((aga)localObject2).Dif) {
          localStringBuffer.append("<msgid>").append(((aga)localObject2).dvT).append("</msgid>");
        }
        if (((aga)localObject2).Dig) {
          localStringBuffer.append("<eventid>").append(((aga)localObject2).dAA).append("</eventid>");
        }
        if (((aga)localObject2).Dih) {
          localStringBuffer.append("<appid>").append(((aga)localObject2).appId).append("</appid>");
        }
        if (((aga)localObject2).Dii) {
          localStringBuffer.append("<link>").append(bt.aGf(((aga)localObject2).link)).append("</link>");
        }
        if (((aga)localObject2).Dil) {
          localStringBuffer.append("<brandid>").append(bt.aGf(((aga)localObject2).dbj)).append("</brandid>");
        }
        localStringBuffer.append("</dataitemsource>");
        break label1500;
        label2101:
        localObject2 = ((afz)localObject2).DhC;
        localStringBuffer.append("<locitem>");
        if (((agf)localObject2).Dit) {
          localStringBuffer.append("<label>").append(bt.aGf(((agf)localObject2).label)).append("</label>");
        }
        if (((agf)localObject2).Dir) {
          localStringBuffer.append("<lat>").append(((agf)localObject2).lat).append("</lat>");
        }
        if (((agf)localObject2).Diq) {
          localStringBuffer.append("<lng>").append(((agf)localObject2).lng).append("</lng>");
        }
        if (((agf)localObject2).Dis) {
          localStringBuffer.append("<scale>").append(((agf)localObject2).dpd).append("</scale>");
        }
        if (((agf)localObject2).Diu) {
          localStringBuffer.append("<poiname>").append(((agf)localObject2).dtN).append("</poiname>");
        }
        localStringBuffer.append("</locitem>");
        break label1539;
        label2280:
        ahd localahd = ((afz)localObject2).DhE;
        localStringBuffer.append("<weburlitem>");
        if (localahd.Djg) {
          localStringBuffer.append("<clean_url>").append(bt.aGf(localahd.Djf)).append("</clean_url>");
        }
        if (localahd.DfT) {
          localStringBuffer.append("<pagedesc>").append(bt.aGf(localahd.desc)).append("</pagedesc>");
        }
        if (localahd.DiA) {
          localStringBuffer.append("<pagethumb_url>").append(bt.aGf(localahd.thumbUrl)).append("</pagethumb_url>");
        }
        if (localahd.DfS) {
          localStringBuffer.append("<pagetitle>").append(bt.aGf(localahd.title)).append("</pagetitle>");
        }
        if (localahd.Dji) {
          localStringBuffer.append("<opencache>").append(localahd.Djh).append("</opencache>");
        }
        if (localahd.Djj) {
          localStringBuffer.append("<contentattr>").append(localahd.gHj).append("</contentattr>");
        }
        if (localahd.Dhe) {
          localStringBuffer.append("<canvasPageXml>").append(bt.aGf(localahd.canvasPageXml)).append("</canvasPageXml>");
        }
        if (localahd.Djl) {
          localStringBuffer.append("<wsVideoFlowXml>").append(bt.aGf(localahd.Djk)).append("</wsVideoFlowXml>");
        }
        if ((localObject2 == null) || (((afz)localObject2).AWL == null)) {
          ad.d("MicroMsg.FavDataItemParser", "setMpMsgXml toXml, item empty");
        }
        for (;;)
        {
          localStringBuffer.append("</weburlitem>");
          break;
          localStringBuffer.append(b.a(((afz)localObject2).AWL));
        }
        label2601:
        localStringBuffer.append(d.a(((afz)localObject2).DhW));
        break label1606;
        label2617:
        localStringBuffer.append(b.b(((afz)localObject2).DhU));
        break label1634;
        label2633:
        localObject2 = ((afz)localObject2).DhG;
        localStringBuffer.append("<productitem");
        if (((agn)localObject2).DiC) {
          localStringBuffer.append(" type='").append(((agn)localObject2).type).append("'");
        }
        localStringBuffer.append(">");
        if (((agn)localObject2).DfS) {
          localStringBuffer.append("<producttitle>").append(bt.aGf(((agn)localObject2).title)).append("</producttitle>");
        }
        if (((agn)localObject2).DfT) {
          localStringBuffer.append("<productdesc>").append(bt.aGf(((agn)localObject2).desc)).append("</productdesc>");
        }
        if (((agn)localObject2).DiA) {
          localStringBuffer.append("<productthumb_url>").append(bt.aGf(((agn)localObject2).thumbUrl)).append("</productthumb_url>");
        }
        if (((agn)localObject2).DiB) {
          localStringBuffer.append("<productinfo>").append(bt.aGf(((agn)localObject2).info)).append("</productinfo>");
        }
        localStringBuffer.append("</productitem>");
        break label1673;
        label2827:
        localObject2 = ((afz)localObject2).DhI;
        localStringBuffer.append("<tvitem>");
        if (((agx)localObject2).DfS) {
          localStringBuffer.append("<tvtitle>").append(bt.aGf(((agx)localObject2).title)).append("</tvtitle>");
        }
        if (((agx)localObject2).DfT) {
          localStringBuffer.append("<tvdesc>").append(bt.aGf(((agx)localObject2).desc)).append("</tvdesc>");
        }
        if (((agx)localObject2).DiA) {
          localStringBuffer.append("<tvthumb_url>").append(bt.aGf(((agx)localObject2).thumbUrl)).append("</tvthumb_url>");
        }
        if (((agx)localObject2).DiB) {
          localStringBuffer.append("<tvinfo>").append(bt.aGf(((agx)localObject2).info)).append("</tvinfo>");
        }
        localStringBuffer.append("</tvitem>");
        break label1712;
        label2985:
        localObject1 = ((afz)localObject1).DhR;
        if (localObject1 != null)
        {
          localStringBuffer.append("<appbranditem>");
          localStringBuffer.append("<username>").append(bt.aGf(((afw)localObject1).username)).append("</username>");
          localStringBuffer.append("<appid>").append(bt.aGf(((afw)localObject1).appId)).append("</appid>");
          localStringBuffer.append("<pkgtype>").append(((afw)localObject1).dkC).append("</pkgtype>");
          localStringBuffer.append("<iconurl>").append(bt.aGf(((afw)localObject1).iconUrl)).append("</iconurl>");
          localStringBuffer.append("<type>").append(((afw)localObject1).type).append("</type>");
          localStringBuffer.append("<pagepath>").append(bt.aGf(((afw)localObject1).dbu)).append("</pagepath>");
          localStringBuffer.append("<sourcedisplayname>").append(bt.aGf(((afw)localObject1).DfP)).append("</sourcedisplayname>");
          localStringBuffer.append("<version>").append(((afw)localObject1).version).append("</version>");
          localStringBuffer.append("<disableforward>").append(((afw)localObject1).jwB).append("</disableforward>");
          localStringBuffer.append("<tradingguaranteeflag>").append(((afw)localObject1).cfU).append("</tradingguaranteeflag>");
          localStringBuffer.append("<messageextradata>").append(String.format("<![CDATA[%s]]>", new Object[] { ((afw)localObject1).dzY })).append("</messageextradata>");
          localStringBuffer.append("<subtype>").append(((afw)localObject1).subType).append("</subtype>");
          localStringBuffer.append("</appbranditem>");
        }
      }
    }
    localStringBuffer.append("</datalist>");
    paramList = localStringBuffer.toString();
    AppMethodBeat.o(103494);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.a
 * JD-Core Version:    0.7.0.1
 */