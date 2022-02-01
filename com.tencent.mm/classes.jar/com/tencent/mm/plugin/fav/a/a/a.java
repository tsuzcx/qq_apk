package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.e;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.aha;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;

public final class a
{
  public static String dl(List<agx> paramList)
  {
    AppMethodBeat.i(103494);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ac.v("MicroMsg.FavDataItemParser", "klem toXml data list empty");
      AppMethodBeat.o(103494);
      return "";
    }
    int j = paramList.size();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("<datalist count='").append(j).append("'>");
    int i = 0;
    if (i < j)
    {
      Object localObject1 = (agx)paramList.get(i);
      localStringBuffer.append("<dataitem ");
      if (((agx)localObject1).Ezt) {
        localStringBuffer.append("datatype='").append(((agx)localObject1).dataType).append("'");
      }
      if (((agx)localObject1).EzW) {
        localStringBuffer.append(" datastatus='").append(((agx)localObject1).EzV).append("'");
      }
      if (((agx)localObject1).EzC) {
        localStringBuffer.append(" dataid='").append(((agx)localObject1).dhw).append("'");
      }
      if (((agx)localObject1).EAi) {
        localStringBuffer.append(" htmlid='").append(bs.aLw(((agx)localObject1).EAh)).append("'");
      }
      if (((agx)localObject1).EAo) {
        localStringBuffer.append(" dataillegaltype='").append(((agx)localObject1).EAn).append("'");
      }
      if (((agx)localObject1).EzO) {
        localStringBuffer.append(" datasourceid='").append(((agx)localObject1).EzN).append("'");
      }
      localStringBuffer.append(">");
      if (((agx)localObject1).Ezv) {
        localStringBuffer.append("<datafmt>").append(((agx)localObject1).Ezu).append("</datafmt>");
      }
      if (((agx)localObject1).EyY) {
        localStringBuffer.append("<datatitle>").append(bs.aLw(((agx)localObject1).title)).append("</datatitle>");
      }
      if (((agx)localObject1).EyZ) {
        localStringBuffer.append("<datadesc>").append(bs.aLw(((agx)localObject1).desc)).append("</datadesc>");
      }
      if (((agx)localObject1).Eza) {
        localStringBuffer.append("<cdn_thumburl>").append(bs.aLw(((agx)localObject1).hhV)).append("</cdn_thumburl>");
      }
      if (((agx)localObject1).Ezd) {
        localStringBuffer.append("<thumb_width>").append(((agx)localObject1).thumbWidth).append("</thumb_width>");
      }
      if (((agx)localObject1).Eze) {
        localStringBuffer.append("<thumb_height>").append(((agx)localObject1).thumbHeight).append("</thumb_height>");
      }
      if (((agx)localObject1).Ezg) {
        localStringBuffer.append("<cdn_dataurl>").append(bs.aLw(((agx)localObject1).Ezf)).append("</cdn_dataurl>");
      }
      if (((agx)localObject1).Ezc) {
        localStringBuffer.append("<cdn_thumbkey>").append(bs.aLw(((agx)localObject1).Ezb)).append("</cdn_thumbkey>");
      }
      if (((agx)localObject1).Ezi) {
        localStringBuffer.append("<cdn_datakey>").append(bs.aLw(((agx)localObject1).Ezh)).append("</cdn_datakey>");
      }
      if (((agx)localObject1).Ezk) {
        localStringBuffer.append("<cdn_encryver>").append(((agx)localObject1).Ezj).append("</cdn_encryver>");
      }
      if (((agx)localObject1).Ezl) {
        localStringBuffer.append("<duration>").append(((agx)localObject1).duration).append("</duration>");
      }
      if (((agx)localObject1).Ezn) {
        localStringBuffer.append("<stream_weburl>").append(bs.aLw(((agx)localObject1).Ezm)).append("</stream_weburl>");
      }
      if (((agx)localObject1).EAE) {
        localStringBuffer.append("<songalbumurl>").append(bs.aLw(((agx)localObject1).songAlbumUrl)).append("</songalbumurl>");
      }
      if (((agx)localObject1).EAF) {
        localStringBuffer.append("<songlyric>").append(bs.aLw(((agx)localObject1).songLyric)).append("</songlyric>");
      }
      if (((agx)localObject1).Ezp) {
        localStringBuffer.append("<stream_dataurl>").append(bs.aLw(((agx)localObject1).Ezo)).append("</stream_dataurl>");
      }
      if (((agx)localObject1).Ezr) {
        localStringBuffer.append("<stream_lowbandurl>").append(bs.aLw(((agx)localObject1).Ezq)).append("</stream_lowbandurl>");
      }
      if (((agx)localObject1).Ezs) {
        localStringBuffer.append("<dataext>").append(bs.aLw(((agx)localObject1).dbZ)).append("</dataext>");
      }
      if (((agx)localObject1).Ezx) {
        localStringBuffer.append("<fullmd5>").append(((agx)localObject1).Ezw).append("</fullmd5>");
      }
      if (((agx)localObject1).Ezz) {
        localStringBuffer.append("<head256md5>").append(((agx)localObject1).Ezy).append("</head256md5>");
      }
      if (((agx)localObject1).EzB) {
        localStringBuffer.append("<fullsize>").append(((agx)localObject1).EzA).append("</fullsize>");
      }
      if (((agx)localObject1).EzI) {
        localStringBuffer.append("<thumbfullmd5>").append(((agx)localObject1).EzH).append("</thumbfullmd5>");
      }
      if (((agx)localObject1).EzK) {
        localStringBuffer.append("<thumbhead256md5>").append(((agx)localObject1).EzJ).append("</thumbhead256md5>");
      }
      if (((agx)localObject1).EzM) {
        localStringBuffer.append("<thumbfullsize>").append(((agx)localObject1).EzL).append("</thumbfullsize>");
      }
      if (((agx)localObject1).EzQ) {
        localStringBuffer.append("<stream_videoid>").append(bs.aLw(((agx)localObject1).EzP)).append("</stream_videoid>");
      }
      if (((agx)localObject1).EzY) {
        localStringBuffer.append("<datasrctitle>").append(bs.aLw(((agx)localObject1).EzX)).append("</datasrctitle>");
      }
      if (((agx)localObject1).EAc) {
        localStringBuffer.append("<datasrcname>").append(bs.aLw(((agx)localObject1).EAb)).append("</datasrcname>");
      }
      if (((agx)localObject1).EAe) {
        localStringBuffer.append("<datasrctime>").append(bs.aLw(((agx)localObject1).EAd)).append("</datasrctime>");
      }
      if ((((agx)localObject1).EAk) && ((((agx)localObject1).EzZ == null) || (((agx)localObject1).EzZ.EAK == null) || (((agx)localObject1).EzZ.EAK.computeSize() == 0))) {
        localStringBuffer.append("<canvasPageXml>").append(bs.aLw(((agx)localObject1).canvasPageXml)).append("</canvasPageXml>");
      }
      if (((agx)localObject1).EAj) {
        localStringBuffer.append("<statextstr>").append(bs.aLw(((agx)localObject1).dvs)).append("</statextstr>");
      }
      if (((agx)localObject1).EAq) {
        localStringBuffer.append("<recordxml>").append(((agx)localObject1).EAp).append("</recordxml>");
      }
      if (((agx)localObject1).iaW) {
        localStringBuffer.append("<messageuuid>").append(bs.aLw(((agx)localObject1).iaU)).append("</messageuuid>");
      }
      Object localObject2 = ((agx)localObject1).EAf;
      if (localObject2 != null)
      {
        localStringBuffer.append("<streamvideo>");
        localStringBuffer.append("<streamvideourl>").append(bs.aLw(((aha)localObject2).hjV)).append("</streamvideourl>");
        localStringBuffer.append("<streamvideototaltime>").append(((aha)localObject2).EBs).append("</streamvideototaltime>");
        localStringBuffer.append("<streamvideotitle>").append(bs.aLw(((aha)localObject2).hjX)).append("</streamvideotitle>");
        localStringBuffer.append("<streamvideowording>").append(bs.aLw(((aha)localObject2).hjY)).append("</streamvideowording>");
        localStringBuffer.append("<streamvideoweburl>").append(bs.aLw(((aha)localObject2).hjZ)).append("</streamvideoweburl>");
        localStringBuffer.append("<streamvideoaduxinfo>").append(bs.aLw(((aha)localObject2).hkb)).append("</streamvideoaduxinfo>");
        localStringBuffer.append("<streamvideopublishid>").append(bs.aLw(((aha)localObject2).hkc)).append("</streamvideopublishid>");
        localStringBuffer.append("</streamvideo>");
      }
      localObject2 = ((agx)localObject1).EzZ;
      if ((localObject2 == null) || (((agy)localObject2).EAG == null) || (((agy)localObject2).EAG.computeSize() == 0))
      {
        ac.v("MicroMsg.FavDataItemParser", "klem toXml, data source item empty");
        label1500:
        localObject2 = ((agx)localObject1).EzZ;
        if ((localObject2 != null) && (((agy)localObject2).EAI != null) && (((agy)localObject2).EAI.computeSize() != 0)) {
          break label2101;
        }
        ac.v("MicroMsg.FavDataItemParser", "klem toXml, loc item empty");
        label1539:
        localObject2 = ((agx)localObject1).EzZ;
        if ((localObject2 != null) && (((agy)localObject2).EAK != null) && (((agy)localObject2).EAK.computeSize() != 0)) {
          break label2280;
        }
        ac.v("MicroMsg.FavDataItemParser", "klem toXml, url item empty");
        localObject2 = ((agx)localObject1).EzZ;
        if ((localObject2 != null) && (((agy)localObject2).EBc != null)) {
          break label2601;
        }
        ac.i("MicroMsg.FavDataItemParser", "klem toXml, finder item empty");
        label1606:
        localObject2 = ((agx)localObject1).EzZ;
        if ((localObject2 != null) && (((agy)localObject2).EBa != null)) {
          break label2617;
        }
        ac.d("MicroMsg.FavDataItemParser", "setMpVideoXml toXml, item empty");
        label1634:
        localObject2 = ((agx)localObject1).EzZ;
        if ((localObject2 != null) && (((agy)localObject2).EAM != null) && (((agy)localObject2).EAM.computeSize() != 0)) {
          break label2633;
        }
        ac.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
        label1673:
        localObject2 = ((agx)localObject1).EzZ;
        if ((localObject2 != null) && (((agy)localObject2).EAO != null) && (((agy)localObject2).EAO.computeSize() != 0)) {
          break label2827;
        }
        ac.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
        label1712:
        localObject1 = ((agx)localObject1).EzZ;
        if ((localObject1 != null) && (((agy)localObject1).EAX != null)) {
          break label2985;
        }
        ac.e("MicroMsg.FavDataItemParser", "setAppBrandXml toXml, item empty");
      }
      for (;;)
      {
        localStringBuffer.append("</dataitem>");
        i += 1;
        break;
        localObject2 = ((agy)localObject2).EAG;
        localStringBuffer.append("<dataitemsource");
        if (((agz)localObject2).EBe) {
          localStringBuffer.append(" sourcetype='").append(((agz)localObject2).sourceType).append("'");
        }
        if (((agz)localObject2).EBi) {
          localStringBuffer.append(" sourceid='").append(((agz)localObject2).EBh).append("'");
        }
        localStringBuffer.append(">");
        if (((agz)localObject2).EBf) {
          localStringBuffer.append("<fromusr>").append(bs.aLw(((agz)localObject2).dng)).append("</fromusr>");
        }
        if (((agz)localObject2).EBg) {
          localStringBuffer.append("<tousr>").append(bs.aLw(((agz)localObject2).toUser)).append("</tousr>");
        }
        if (((agz)localObject2).EBk) {
          localStringBuffer.append("<realchatname>").append(bs.aLw(((agz)localObject2).EBj)).append("</realchatname>");
        }
        if (((agz)localObject2).EBl) {
          localStringBuffer.append("<msgid>").append(((agz)localObject2).dtG).append("</msgid>");
        }
        if (((agz)localObject2).EBm) {
          localStringBuffer.append("<eventid>").append(((agz)localObject2).dym).append("</eventid>");
        }
        if (((agz)localObject2).EBn) {
          localStringBuffer.append("<appid>").append(((agz)localObject2).appId).append("</appid>");
        }
        if (((agz)localObject2).EBo) {
          localStringBuffer.append("<link>").append(bs.aLw(((agz)localObject2).link)).append("</link>");
        }
        if (((agz)localObject2).EBr) {
          localStringBuffer.append("<brandid>").append(bs.aLw(((agz)localObject2).cYF)).append("</brandid>");
        }
        localStringBuffer.append("</dataitemsource>");
        break label1500;
        label2101:
        localObject2 = ((agy)localObject2).EAI;
        localStringBuffer.append("<locitem>");
        if (((ahe)localObject2).EBz) {
          localStringBuffer.append("<label>").append(bs.aLw(((ahe)localObject2).label)).append("</label>");
        }
        if (((ahe)localObject2).EBx) {
          localStringBuffer.append("<lat>").append(((ahe)localObject2).lat).append("</lat>");
        }
        if (((ahe)localObject2).EBw) {
          localStringBuffer.append("<lng>").append(((ahe)localObject2).lng).append("</lng>");
        }
        if (((ahe)localObject2).EBy) {
          localStringBuffer.append("<scale>").append(((ahe)localObject2).dmN).append("</scale>");
        }
        if (((ahe)localObject2).EBA) {
          localStringBuffer.append("<poiname>").append(((ahe)localObject2).dry).append("</poiname>");
        }
        localStringBuffer.append("</locitem>");
        break label1539;
        label2280:
        aic localaic = ((agy)localObject2).EAK;
        localStringBuffer.append("<weburlitem>");
        if (localaic.ECm) {
          localStringBuffer.append("<clean_url>").append(bs.aLw(localaic.ECl)).append("</clean_url>");
        }
        if (localaic.EyZ) {
          localStringBuffer.append("<pagedesc>").append(bs.aLw(localaic.desc)).append("</pagedesc>");
        }
        if (localaic.EBG) {
          localStringBuffer.append("<pagethumb_url>").append(bs.aLw(localaic.thumbUrl)).append("</pagethumb_url>");
        }
        if (localaic.EyY) {
          localStringBuffer.append("<pagetitle>").append(bs.aLw(localaic.title)).append("</pagetitle>");
        }
        if (localaic.ECo) {
          localStringBuffer.append("<opencache>").append(localaic.ECn).append("</opencache>");
        }
        if (localaic.ECp) {
          localStringBuffer.append("<contentattr>").append(localaic.hhK).append("</contentattr>");
        }
        if (localaic.EAk) {
          localStringBuffer.append("<canvasPageXml>").append(bs.aLw(localaic.canvasPageXml)).append("</canvasPageXml>");
        }
        if (localaic.ECr) {
          localStringBuffer.append("<wsVideoFlowXml>").append(bs.aLw(localaic.ECq)).append("</wsVideoFlowXml>");
        }
        if ((localObject2 == null) || (((agy)localObject2).CoY == null)) {
          ac.d("MicroMsg.FavDataItemParser", "setMpMsgXml toXml, item empty");
        }
        for (;;)
        {
          localStringBuffer.append("</weburlitem>");
          break;
          localStringBuffer.append(b.a(((agy)localObject2).CoY));
        }
        label2601:
        localStringBuffer.append(e.b(((agy)localObject2).EBc));
        break label1606;
        label2617:
        localStringBuffer.append(b.b(((agy)localObject2).EBa));
        break label1634;
        label2633:
        localObject2 = ((agy)localObject2).EAM;
        localStringBuffer.append("<productitem");
        if (((ahm)localObject2).EBI) {
          localStringBuffer.append(" type='").append(((ahm)localObject2).type).append("'");
        }
        localStringBuffer.append(">");
        if (((ahm)localObject2).EyY) {
          localStringBuffer.append("<producttitle>").append(bs.aLw(((ahm)localObject2).title)).append("</producttitle>");
        }
        if (((ahm)localObject2).EyZ) {
          localStringBuffer.append("<productdesc>").append(bs.aLw(((ahm)localObject2).desc)).append("</productdesc>");
        }
        if (((ahm)localObject2).EBG) {
          localStringBuffer.append("<productthumb_url>").append(bs.aLw(((ahm)localObject2).thumbUrl)).append("</productthumb_url>");
        }
        if (((ahm)localObject2).EBH) {
          localStringBuffer.append("<productinfo>").append(bs.aLw(((ahm)localObject2).info)).append("</productinfo>");
        }
        localStringBuffer.append("</productitem>");
        break label1673;
        label2827:
        localObject2 = ((agy)localObject2).EAO;
        localStringBuffer.append("<tvitem>");
        if (((ahw)localObject2).EyY) {
          localStringBuffer.append("<tvtitle>").append(bs.aLw(((ahw)localObject2).title)).append("</tvtitle>");
        }
        if (((ahw)localObject2).EyZ) {
          localStringBuffer.append("<tvdesc>").append(bs.aLw(((ahw)localObject2).desc)).append("</tvdesc>");
        }
        if (((ahw)localObject2).EBG) {
          localStringBuffer.append("<tvthumb_url>").append(bs.aLw(((ahw)localObject2).thumbUrl)).append("</tvthumb_url>");
        }
        if (((ahw)localObject2).EBH) {
          localStringBuffer.append("<tvinfo>").append(bs.aLw(((ahw)localObject2).info)).append("</tvinfo>");
        }
        localStringBuffer.append("</tvitem>");
        break label1712;
        label2985:
        localObject1 = ((agy)localObject1).EAX;
        if (localObject1 != null)
        {
          localStringBuffer.append("<appbranditem>");
          localStringBuffer.append("<username>").append(bs.aLw(((agv)localObject1).username)).append("</username>");
          localStringBuffer.append("<appid>").append(bs.aLw(((agv)localObject1).appId)).append("</appid>");
          localStringBuffer.append("<pkgtype>").append(((agv)localObject1).dib).append("</pkgtype>");
          localStringBuffer.append("<iconurl>").append(bs.aLw(((agv)localObject1).iconUrl)).append("</iconurl>");
          localStringBuffer.append("<type>").append(((agv)localObject1).type).append("</type>");
          localStringBuffer.append("<pagepath>").append(bs.aLw(((agv)localObject1).cYQ)).append("</pagepath>");
          localStringBuffer.append("<sourcedisplayname>").append(bs.aLw(((agv)localObject1).EyV)).append("</sourcedisplayname>");
          localStringBuffer.append("<version>").append(((agv)localObject1).version).append("</version>");
          localStringBuffer.append("<disableforward>").append(((agv)localObject1).jWX).append("</disableforward>");
          localStringBuffer.append("<tradingguaranteeflag>").append(((agv)localObject1).ccR).append("</tradingguaranteeflag>");
          localStringBuffer.append("<messageextradata>").append(String.format("<![CDATA[%s]]>", new Object[] { ((agv)localObject1).dxK })).append("</messageextradata>");
          localStringBuffer.append("<subtype>").append(((agv)localObject1).subType).append("</subtype>");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.a
 * JD-Core Version:    0.7.0.1
 */