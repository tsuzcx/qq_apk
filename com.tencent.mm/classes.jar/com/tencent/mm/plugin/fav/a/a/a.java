package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.e;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public final class a
{
  public static String dn(List<ajn> paramList)
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
      Object localObject1 = (ajn)paramList.get(i);
      localStringBuffer.append("<dataitem ");
      if (((ajn)localObject1).Ghf) {
        localStringBuffer.append("datatype='").append(((ajn)localObject1).dataType).append("'");
      }
      if (((ajn)localObject1).GhI) {
        localStringBuffer.append(" datastatus='").append(((ajn)localObject1).GhH).append("'");
      }
      if (((ajn)localObject1).Gho) {
        localStringBuffer.append(" dataid='").append(((ajn)localObject1).dsU).append("'");
      }
      if (((ajn)localObject1).GhU) {
        localStringBuffer.append(" htmlid='").append(bt.aRc(((ajn)localObject1).GhT)).append("'");
      }
      if (((ajn)localObject1).Gia) {
        localStringBuffer.append(" dataillegaltype='").append(((ajn)localObject1).GhZ).append("'");
      }
      if (((ajn)localObject1).GhA) {
        localStringBuffer.append(" datasourceid='").append(((ajn)localObject1).Ghz).append("'");
      }
      localStringBuffer.append(">");
      if (((ajn)localObject1).Ghh) {
        localStringBuffer.append("<datafmt>").append(((ajn)localObject1).Ghg).append("</datafmt>");
      }
      if (((ajn)localObject1).GgK) {
        localStringBuffer.append("<datatitle>").append(bt.aRc(((ajn)localObject1).title)).append("</datatitle>");
      }
      if (((ajn)localObject1).GgL) {
        localStringBuffer.append("<datadesc>").append(bt.aRc(((ajn)localObject1).desc)).append("</datadesc>");
      }
      if (((ajn)localObject1).GgM) {
        localStringBuffer.append("<cdn_thumburl>").append(bt.aRc(((ajn)localObject1).hAe)).append("</cdn_thumburl>");
      }
      if (((ajn)localObject1).GgP) {
        localStringBuffer.append("<thumb_width>").append(((ajn)localObject1).thumbWidth).append("</thumb_width>");
      }
      if (((ajn)localObject1).GgQ) {
        localStringBuffer.append("<thumb_height>").append(((ajn)localObject1).thumbHeight).append("</thumb_height>");
      }
      if (((ajn)localObject1).GgS) {
        localStringBuffer.append("<cdn_dataurl>").append(bt.aRc(((ajn)localObject1).GgR)).append("</cdn_dataurl>");
      }
      if (((ajn)localObject1).GgO) {
        localStringBuffer.append("<cdn_thumbkey>").append(bt.aRc(((ajn)localObject1).GgN)).append("</cdn_thumbkey>");
      }
      if (((ajn)localObject1).GgU) {
        localStringBuffer.append("<cdn_datakey>").append(bt.aRc(((ajn)localObject1).GgT)).append("</cdn_datakey>");
      }
      if (((ajn)localObject1).GgW) {
        localStringBuffer.append("<cdn_encryver>").append(((ajn)localObject1).GgV).append("</cdn_encryver>");
      }
      if (((ajn)localObject1).GgX) {
        localStringBuffer.append("<duration>").append(((ajn)localObject1).duration).append("</duration>");
      }
      if (((ajn)localObject1).GgZ) {
        localStringBuffer.append("<stream_weburl>").append(bt.aRc(((ajn)localObject1).GgY)).append("</stream_weburl>");
      }
      if (((ajn)localObject1).Giq) {
        localStringBuffer.append("<songalbumurl>").append(bt.aRc(((ajn)localObject1).songAlbumUrl)).append("</songalbumurl>");
      }
      if (((ajn)localObject1).Gir) {
        localStringBuffer.append("<songlyric>").append(bt.aRc(((ajn)localObject1).songLyric)).append("</songlyric>");
      }
      if (((ajn)localObject1).Ghb) {
        localStringBuffer.append("<stream_dataurl>").append(bt.aRc(((ajn)localObject1).Gha)).append("</stream_dataurl>");
      }
      if (((ajn)localObject1).Ghd) {
        localStringBuffer.append("<stream_lowbandurl>").append(bt.aRc(((ajn)localObject1).Ghc)).append("</stream_lowbandurl>");
      }
      if (((ajn)localObject1).Ghe) {
        localStringBuffer.append("<dataext>").append(bt.aRc(((ajn)localObject1).dnv)).append("</dataext>");
      }
      if (((ajn)localObject1).Ghj) {
        localStringBuffer.append("<fullmd5>").append(((ajn)localObject1).Ghi).append("</fullmd5>");
      }
      if (((ajn)localObject1).Ghl) {
        localStringBuffer.append("<head256md5>").append(((ajn)localObject1).Ghk).append("</head256md5>");
      }
      if (((ajn)localObject1).Ghn) {
        localStringBuffer.append("<fullsize>").append(((ajn)localObject1).Ghm).append("</fullsize>");
      }
      if (((ajn)localObject1).Ghu) {
        localStringBuffer.append("<thumbfullmd5>").append(((ajn)localObject1).Ght).append("</thumbfullmd5>");
      }
      if (((ajn)localObject1).Ghw) {
        localStringBuffer.append("<thumbhead256md5>").append(((ajn)localObject1).Ghv).append("</thumbhead256md5>");
      }
      if (((ajn)localObject1).Ghy) {
        localStringBuffer.append("<thumbfullsize>").append(((ajn)localObject1).Ghx).append("</thumbfullsize>");
      }
      if (((ajn)localObject1).GhC) {
        localStringBuffer.append("<stream_videoid>").append(bt.aRc(((ajn)localObject1).GhB)).append("</stream_videoid>");
      }
      if (((ajn)localObject1).GhK) {
        localStringBuffer.append("<datasrctitle>").append(bt.aRc(((ajn)localObject1).GhJ)).append("</datasrctitle>");
      }
      if (((ajn)localObject1).GhO) {
        localStringBuffer.append("<datasrcname>").append(bt.aRc(((ajn)localObject1).GhN)).append("</datasrcname>");
      }
      if (((ajn)localObject1).GhQ) {
        localStringBuffer.append("<datasrctime>").append(bt.aRc(((ajn)localObject1).GhP)).append("</datasrctime>");
      }
      if ((((ajn)localObject1).GhW) && ((((ajn)localObject1).GhL == null) || (((ajn)localObject1).GhL.Giw == null) || (((ajn)localObject1).GhL.Giw.computeSize() == 0))) {
        localStringBuffer.append("<canvasPageXml>").append(bt.aRc(((ajn)localObject1).canvasPageXml)).append("</canvasPageXml>");
      }
      if (((ajn)localObject1).GhV) {
        localStringBuffer.append("<statextstr>").append(bt.aRc(((ajn)localObject1).dHv)).append("</statextstr>");
      }
      if (((ajn)localObject1).Gic) {
        localStringBuffer.append("<recordxml>").append(((ajn)localObject1).Gib).append("</recordxml>");
      }
      if (((ajn)localObject1).ius) {
        localStringBuffer.append("<messageuuid>").append(bt.aRc(((ajn)localObject1).iuq)).append("</messageuuid>");
      }
      Object localObject2 = ((ajn)localObject1).GhR;
      if (localObject2 != null)
      {
        localStringBuffer.append("<streamvideo>");
        localStringBuffer.append("<streamvideourl>").append(bt.aRc(((ajq)localObject2).hCe)).append("</streamvideourl>");
        localStringBuffer.append("<streamvideototaltime>").append(((ajq)localObject2).Gje).append("</streamvideototaltime>");
        localStringBuffer.append("<streamvideotitle>").append(bt.aRc(((ajq)localObject2).hCg)).append("</streamvideotitle>");
        localStringBuffer.append("<streamvideowording>").append(bt.aRc(((ajq)localObject2).hCh)).append("</streamvideowording>");
        localStringBuffer.append("<streamvideoweburl>").append(bt.aRc(((ajq)localObject2).hCi)).append("</streamvideoweburl>");
        localStringBuffer.append("<streamvideoaduxinfo>").append(bt.aRc(((ajq)localObject2).hCk)).append("</streamvideoaduxinfo>");
        localStringBuffer.append("<streamvideopublishid>").append(bt.aRc(((ajq)localObject2).hCl)).append("</streamvideopublishid>");
        localStringBuffer.append("</streamvideo>");
      }
      localObject2 = ((ajn)localObject1).GhL;
      if ((localObject2 == null) || (((ajo)localObject2).Gis == null) || (((ajo)localObject2).Gis.computeSize() == 0))
      {
        ad.v("MicroMsg.FavDataItemParser", "klem toXml, data source item empty");
        label1500:
        localObject2 = ((ajn)localObject1).GhL;
        if ((localObject2 != null) && (((ajo)localObject2).Giu != null) && (((ajo)localObject2).Giu.computeSize() != 0)) {
          break label2101;
        }
        ad.v("MicroMsg.FavDataItemParser", "klem toXml, loc item empty");
        label1539:
        localObject2 = ((ajn)localObject1).GhL;
        if ((localObject2 != null) && (((ajo)localObject2).Giw != null) && (((ajo)localObject2).Giw.computeSize() != 0)) {
          break label2280;
        }
        ad.v("MicroMsg.FavDataItemParser", "klem toXml, url item empty");
        localObject2 = ((ajn)localObject1).GhL;
        if ((localObject2 != null) && (((ajo)localObject2).GiO != null)) {
          break label2601;
        }
        ad.i("MicroMsg.FavDataItemParser", "klem toXml, finder item empty");
        label1606:
        localObject2 = ((ajn)localObject1).GhL;
        if ((localObject2 != null) && (((ajo)localObject2).GiM != null)) {
          break label2617;
        }
        ad.d("MicroMsg.FavDataItemParser", "setMpVideoXml toXml, item empty");
        label1634:
        localObject2 = ((ajn)localObject1).GhL;
        if ((localObject2 != null) && (((ajo)localObject2).Giy != null) && (((ajo)localObject2).Giy.computeSize() != 0)) {
          break label2633;
        }
        ad.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
        label1673:
        localObject2 = ((ajn)localObject1).GhL;
        if ((localObject2 != null) && (((ajo)localObject2).GiA != null) && (((ajo)localObject2).GiA.computeSize() != 0)) {
          break label2827;
        }
        ad.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
        label1712:
        localObject1 = ((ajn)localObject1).GhL;
        if ((localObject1 != null) && (((ajo)localObject1).GiJ != null)) {
          break label2985;
        }
        ad.e("MicroMsg.FavDataItemParser", "setAppBrandXml toXml, item empty");
      }
      for (;;)
      {
        localStringBuffer.append("</dataitem>");
        i += 1;
        break;
        localObject2 = ((ajo)localObject2).Gis;
        localStringBuffer.append("<dataitemsource");
        if (((ajp)localObject2).GiQ) {
          localStringBuffer.append(" sourcetype='").append(((ajp)localObject2).sourceType).append("'");
        }
        if (((ajp)localObject2).GiU) {
          localStringBuffer.append(" sourceid='").append(((ajp)localObject2).GiT).append("'");
        }
        localStringBuffer.append(">");
        if (((ajp)localObject2).GiR) {
          localStringBuffer.append("<fromusr>").append(bt.aRc(((ajp)localObject2).dyU)).append("</fromusr>");
        }
        if (((ajp)localObject2).GiS) {
          localStringBuffer.append("<tousr>").append(bt.aRc(((ajp)localObject2).toUser)).append("</tousr>");
        }
        if (((ajp)localObject2).GiW) {
          localStringBuffer.append("<realchatname>").append(bt.aRc(((ajp)localObject2).GiV)).append("</realchatname>");
        }
        if (((ajp)localObject2).GiX) {
          localStringBuffer.append("<msgid>").append(((ajp)localObject2).msgId).append("</msgid>");
        }
        if (((ajp)localObject2).GiY) {
          localStringBuffer.append("<eventid>").append(((ajp)localObject2).dKz).append("</eventid>");
        }
        if (((ajp)localObject2).GiZ) {
          localStringBuffer.append("<appid>").append(((ajp)localObject2).appId).append("</appid>");
        }
        if (((ajp)localObject2).Gja) {
          localStringBuffer.append("<link>").append(bt.aRc(((ajp)localObject2).link)).append("</link>");
        }
        if (((ajp)localObject2).Gjd) {
          localStringBuffer.append("<brandid>").append(bt.aRc(((ajp)localObject2).djX)).append("</brandid>");
        }
        localStringBuffer.append("</dataitemsource>");
        break label1500;
        label2101:
        localObject2 = ((ajo)localObject2).Giu;
        localStringBuffer.append("<locitem>");
        if (((aju)localObject2).Gjl) {
          localStringBuffer.append("<label>").append(bt.aRc(((aju)localObject2).label)).append("</label>");
        }
        if (((aju)localObject2).Gjj) {
          localStringBuffer.append("<lat>").append(((aju)localObject2).lat).append("</lat>");
        }
        if (((aju)localObject2).Gji) {
          localStringBuffer.append("<lng>").append(((aju)localObject2).lng).append("</lng>");
        }
        if (((aju)localObject2).Gjk) {
          localStringBuffer.append("<scale>").append(((aju)localObject2).dyB).append("</scale>");
        }
        if (((aju)localObject2).Gjm) {
          localStringBuffer.append("<poiname>").append(((aju)localObject2).dDq).append("</poiname>");
        }
        localStringBuffer.append("</locitem>");
        break label1539;
        label2280:
        aks localaks = ((ajo)localObject2).Giw;
        localStringBuffer.append("<weburlitem>");
        if (localaks.GjY) {
          localStringBuffer.append("<clean_url>").append(bt.aRc(localaks.GjX)).append("</clean_url>");
        }
        if (localaks.GgL) {
          localStringBuffer.append("<pagedesc>").append(bt.aRc(localaks.desc)).append("</pagedesc>");
        }
        if (localaks.Gjs) {
          localStringBuffer.append("<pagethumb_url>").append(bt.aRc(localaks.thumbUrl)).append("</pagethumb_url>");
        }
        if (localaks.GgK) {
          localStringBuffer.append("<pagetitle>").append(bt.aRc(localaks.title)).append("</pagetitle>");
        }
        if (localaks.Gka) {
          localStringBuffer.append("<opencache>").append(localaks.GjZ).append("</opencache>");
        }
        if (localaks.Gkb) {
          localStringBuffer.append("<contentattr>").append(localaks.hzT).append("</contentattr>");
        }
        if (localaks.GhW) {
          localStringBuffer.append("<canvasPageXml>").append(bt.aRc(localaks.canvasPageXml)).append("</canvasPageXml>");
        }
        if (localaks.Gkd) {
          localStringBuffer.append("<wsVideoFlowXml>").append(bt.aRc(localaks.Gkc)).append("</wsVideoFlowXml>");
        }
        if ((localObject2 == null) || (((ajo)localObject2).DSw == null)) {
          ad.d("MicroMsg.FavDataItemParser", "setMpMsgXml toXml, item empty");
        }
        for (;;)
        {
          localStringBuffer.append("</weburlitem>");
          break;
          localStringBuffer.append(b.a(((ajo)localObject2).DSw));
        }
        label2601:
        localStringBuffer.append(e.b(((ajo)localObject2).GiO));
        break label1606;
        label2617:
        localStringBuffer.append(b.b(((ajo)localObject2).GiM));
        break label1634;
        label2633:
        localObject2 = ((ajo)localObject2).Giy;
        localStringBuffer.append("<productitem");
        if (((akc)localObject2).Gju) {
          localStringBuffer.append(" type='").append(((akc)localObject2).type).append("'");
        }
        localStringBuffer.append(">");
        if (((akc)localObject2).GgK) {
          localStringBuffer.append("<producttitle>").append(bt.aRc(((akc)localObject2).title)).append("</producttitle>");
        }
        if (((akc)localObject2).GgL) {
          localStringBuffer.append("<productdesc>").append(bt.aRc(((akc)localObject2).desc)).append("</productdesc>");
        }
        if (((akc)localObject2).Gjs) {
          localStringBuffer.append("<productthumb_url>").append(bt.aRc(((akc)localObject2).thumbUrl)).append("</productthumb_url>");
        }
        if (((akc)localObject2).Gjt) {
          localStringBuffer.append("<productinfo>").append(bt.aRc(((akc)localObject2).info)).append("</productinfo>");
        }
        localStringBuffer.append("</productitem>");
        break label1673;
        label2827:
        localObject2 = ((ajo)localObject2).GiA;
        localStringBuffer.append("<tvitem>");
        if (((akm)localObject2).GgK) {
          localStringBuffer.append("<tvtitle>").append(bt.aRc(((akm)localObject2).title)).append("</tvtitle>");
        }
        if (((akm)localObject2).GgL) {
          localStringBuffer.append("<tvdesc>").append(bt.aRc(((akm)localObject2).desc)).append("</tvdesc>");
        }
        if (((akm)localObject2).Gjs) {
          localStringBuffer.append("<tvthumb_url>").append(bt.aRc(((akm)localObject2).thumbUrl)).append("</tvthumb_url>");
        }
        if (((akm)localObject2).Gjt) {
          localStringBuffer.append("<tvinfo>").append(bt.aRc(((akm)localObject2).info)).append("</tvinfo>");
        }
        localStringBuffer.append("</tvitem>");
        break label1712;
        label2985:
        localObject1 = ((ajo)localObject1).GiJ;
        if (localObject1 != null)
        {
          localStringBuffer.append("<appbranditem>");
          localStringBuffer.append("<username>").append(bt.aRc(((ajl)localObject1).username)).append("</username>");
          localStringBuffer.append("<appid>").append(bt.aRc(((ajl)localObject1).appId)).append("</appid>");
          localStringBuffer.append("<pkgtype>").append(((ajl)localObject1).dtF).append("</pkgtype>");
          localStringBuffer.append("<iconurl>").append(bt.aRc(((ajl)localObject1).iconUrl)).append("</iconurl>");
          localStringBuffer.append("<type>").append(((ajl)localObject1).type).append("</type>");
          localStringBuffer.append("<pagepath>").append(bt.aRc(((ajl)localObject1).dki)).append("</pagepath>");
          localStringBuffer.append("<sourcedisplayname>").append(bt.aRc(((ajl)localObject1).GgH)).append("</sourcedisplayname>");
          localStringBuffer.append("<version>").append(((ajl)localObject1).version).append("</version>");
          localStringBuffer.append("<disableforward>").append(((ajl)localObject1).kro).append("</disableforward>");
          localStringBuffer.append("<tradingguaranteeflag>").append(((ajl)localObject1).jXI).append("</tradingguaranteeflag>");
          localStringBuffer.append("<messageextradata>").append(String.format("<![CDATA[%s]]>", new Object[] { ((ajl)localObject1).dJW })).append("</messageextradata>");
          localStringBuffer.append("<subtype>").append(((ajl)localObject1).subType).append("</subtype>");
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