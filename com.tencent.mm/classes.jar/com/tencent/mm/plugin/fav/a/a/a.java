package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.e;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akw;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;

public final class a
{
  public static String dq(List<ajx> paramList)
  {
    AppMethodBeat.i(103494);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ae.v("MicroMsg.FavDataItemParser", "klem toXml data list empty");
      AppMethodBeat.o(103494);
      return "";
    }
    int j = paramList.size();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("<datalist count='").append(j).append("'>");
    int i = 0;
    if (i < j)
    {
      Object localObject1 = (ajx)paramList.get(i);
      localStringBuffer.append("<dataitem ");
      if (((ajx)localObject1).GzO) {
        localStringBuffer.append("datatype='").append(((ajx)localObject1).dataType).append("'");
      }
      if (((ajx)localObject1).GAr) {
        localStringBuffer.append(" datastatus='").append(((ajx)localObject1).GAq).append("'");
      }
      if (((ajx)localObject1).GzX) {
        localStringBuffer.append(" dataid='").append(((ajx)localObject1).dua).append("'");
      }
      if (((ajx)localObject1).GAD) {
        localStringBuffer.append(" htmlid='").append(bu.aSz(((ajx)localObject1).GAC)).append("'");
      }
      if (((ajx)localObject1).GAJ) {
        localStringBuffer.append(" dataillegaltype='").append(((ajx)localObject1).GAI).append("'");
      }
      if (((ajx)localObject1).GAj) {
        localStringBuffer.append(" datasourceid='").append(((ajx)localObject1).GAi).append("'");
      }
      localStringBuffer.append(">");
      if (((ajx)localObject1).GzQ) {
        localStringBuffer.append("<datafmt>").append(((ajx)localObject1).GzP).append("</datafmt>");
      }
      if (((ajx)localObject1).Gzt) {
        localStringBuffer.append("<datatitle>").append(bu.aSz(((ajx)localObject1).title)).append("</datatitle>");
      }
      if (((ajx)localObject1).Gzu) {
        localStringBuffer.append("<datadesc>").append(bu.aSz(((ajx)localObject1).desc)).append("</datadesc>");
      }
      if (((ajx)localObject1).Gzv) {
        localStringBuffer.append("<cdn_thumburl>").append(bu.aSz(((ajx)localObject1).hCS)).append("</cdn_thumburl>");
      }
      if (((ajx)localObject1).Gzy) {
        localStringBuffer.append("<thumb_width>").append(((ajx)localObject1).thumbWidth).append("</thumb_width>");
      }
      if (((ajx)localObject1).Gzz) {
        localStringBuffer.append("<thumb_height>").append(((ajx)localObject1).thumbHeight).append("</thumb_height>");
      }
      if (((ajx)localObject1).GzB) {
        localStringBuffer.append("<cdn_dataurl>").append(bu.aSz(((ajx)localObject1).GzA)).append("</cdn_dataurl>");
      }
      if (((ajx)localObject1).Gzx) {
        localStringBuffer.append("<cdn_thumbkey>").append(bu.aSz(((ajx)localObject1).Gzw)).append("</cdn_thumbkey>");
      }
      if (((ajx)localObject1).GzD) {
        localStringBuffer.append("<cdn_datakey>").append(bu.aSz(((ajx)localObject1).GzC)).append("</cdn_datakey>");
      }
      if (((ajx)localObject1).GzF) {
        localStringBuffer.append("<cdn_encryver>").append(((ajx)localObject1).GzE).append("</cdn_encryver>");
      }
      if (((ajx)localObject1).GzG) {
        localStringBuffer.append("<duration>").append(((ajx)localObject1).duration).append("</duration>");
      }
      if (((ajx)localObject1).GzI) {
        localStringBuffer.append("<stream_weburl>").append(bu.aSz(((ajx)localObject1).GzH)).append("</stream_weburl>");
      }
      if (((ajx)localObject1).GAZ) {
        localStringBuffer.append("<songalbumurl>").append(bu.aSz(((ajx)localObject1).songAlbumUrl)).append("</songalbumurl>");
      }
      if (((ajx)localObject1).GBa) {
        localStringBuffer.append("<songlyric>").append(bu.aSz(((ajx)localObject1).songLyric)).append("</songlyric>");
      }
      if (((ajx)localObject1).GzK) {
        localStringBuffer.append("<stream_dataurl>").append(bu.aSz(((ajx)localObject1).GzJ)).append("</stream_dataurl>");
      }
      if (((ajx)localObject1).GzM) {
        localStringBuffer.append("<stream_lowbandurl>").append(bu.aSz(((ajx)localObject1).GzL)).append("</stream_lowbandurl>");
      }
      if (((ajx)localObject1).GzN) {
        localStringBuffer.append("<dataext>").append(bu.aSz(((ajx)localObject1).dox)).append("</dataext>");
      }
      if (((ajx)localObject1).GzS) {
        localStringBuffer.append("<fullmd5>").append(((ajx)localObject1).GzR).append("</fullmd5>");
      }
      if (((ajx)localObject1).GzU) {
        localStringBuffer.append("<head256md5>").append(((ajx)localObject1).GzT).append("</head256md5>");
      }
      if (((ajx)localObject1).GzW) {
        localStringBuffer.append("<fullsize>").append(((ajx)localObject1).GzV).append("</fullsize>");
      }
      if (((ajx)localObject1).GAd) {
        localStringBuffer.append("<thumbfullmd5>").append(((ajx)localObject1).GAc).append("</thumbfullmd5>");
      }
      if (((ajx)localObject1).GAf) {
        localStringBuffer.append("<thumbhead256md5>").append(((ajx)localObject1).GAe).append("</thumbhead256md5>");
      }
      if (((ajx)localObject1).GAh) {
        localStringBuffer.append("<thumbfullsize>").append(((ajx)localObject1).GAg).append("</thumbfullsize>");
      }
      if (((ajx)localObject1).GAl) {
        localStringBuffer.append("<stream_videoid>").append(bu.aSz(((ajx)localObject1).GAk)).append("</stream_videoid>");
      }
      if (((ajx)localObject1).GAt) {
        localStringBuffer.append("<datasrctitle>").append(bu.aSz(((ajx)localObject1).GAs)).append("</datasrctitle>");
      }
      if (((ajx)localObject1).GAx) {
        localStringBuffer.append("<datasrcname>").append(bu.aSz(((ajx)localObject1).GAw)).append("</datasrcname>");
      }
      if (((ajx)localObject1).GAz) {
        localStringBuffer.append("<datasrctime>").append(bu.aSz(((ajx)localObject1).GAy)).append("</datasrctime>");
      }
      if ((((ajx)localObject1).GAF) && ((((ajx)localObject1).GAu == null) || (((ajx)localObject1).GAu.GBf == null) || (((ajx)localObject1).GAu.GBf.computeSize() == 0))) {
        localStringBuffer.append("<canvasPageXml>").append(bu.aSz(((ajx)localObject1).canvasPageXml)).append("</canvasPageXml>");
      }
      if (((ajx)localObject1).GAE) {
        localStringBuffer.append("<statextstr>").append(bu.aSz(((ajx)localObject1).dIA)).append("</statextstr>");
      }
      if (((ajx)localObject1).GAL) {
        localStringBuffer.append("<recordxml>").append(((ajx)localObject1).GAK).append("</recordxml>");
      }
      if (((ajx)localObject1).ixm) {
        localStringBuffer.append("<messageuuid>").append(bu.aSz(((ajx)localObject1).ixk)).append("</messageuuid>");
      }
      Object localObject2 = ((ajx)localObject1).GAA;
      if (localObject2 != null)
      {
        localStringBuffer.append("<streamvideo>");
        localStringBuffer.append("<streamvideourl>").append(bu.aSz(((aka)localObject2).hET)).append("</streamvideourl>");
        localStringBuffer.append("<streamvideototaltime>").append(((aka)localObject2).GBN).append("</streamvideototaltime>");
        localStringBuffer.append("<streamvideotitle>").append(bu.aSz(((aka)localObject2).hEV)).append("</streamvideotitle>");
        localStringBuffer.append("<streamvideowording>").append(bu.aSz(((aka)localObject2).hEW)).append("</streamvideowording>");
        localStringBuffer.append("<streamvideoweburl>").append(bu.aSz(((aka)localObject2).hEX)).append("</streamvideoweburl>");
        localStringBuffer.append("<streamvideoaduxinfo>").append(bu.aSz(((aka)localObject2).hEZ)).append("</streamvideoaduxinfo>");
        localStringBuffer.append("<streamvideopublishid>").append(bu.aSz(((aka)localObject2).hFa)).append("</streamvideopublishid>");
        localStringBuffer.append("</streamvideo>");
      }
      localObject2 = ((ajx)localObject1).GAu;
      if ((localObject2 == null) || (((ajy)localObject2).GBb == null) || (((ajy)localObject2).GBb.computeSize() == 0))
      {
        ae.v("MicroMsg.FavDataItemParser", "klem toXml, data source item empty");
        label1500:
        localObject2 = ((ajx)localObject1).GAu;
        if ((localObject2 != null) && (((ajy)localObject2).GBd != null) && (((ajy)localObject2).GBd.computeSize() != 0)) {
          break label2101;
        }
        ae.v("MicroMsg.FavDataItemParser", "klem toXml, loc item empty");
        label1539:
        localObject2 = ((ajx)localObject1).GAu;
        if ((localObject2 != null) && (((ajy)localObject2).GBf != null) && (((ajy)localObject2).GBf.computeSize() != 0)) {
          break label2280;
        }
        ae.v("MicroMsg.FavDataItemParser", "klem toXml, url item empty");
        localObject2 = ((ajx)localObject1).GAu;
        if ((localObject2 != null) && (((ajy)localObject2).GBx != null)) {
          break label2601;
        }
        ae.i("MicroMsg.FavDataItemParser", "klem toXml, finder item empty");
        label1606:
        localObject2 = ((ajx)localObject1).GAu;
        if ((localObject2 != null) && (((ajy)localObject2).GBv != null)) {
          break label2617;
        }
        ae.d("MicroMsg.FavDataItemParser", "setMpVideoXml toXml, item empty");
        label1634:
        localObject2 = ((ajx)localObject1).GAu;
        if ((localObject2 != null) && (((ajy)localObject2).GBh != null) && (((ajy)localObject2).GBh.computeSize() != 0)) {
          break label2633;
        }
        ae.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
        label1673:
        localObject2 = ((ajx)localObject1).GAu;
        if ((localObject2 != null) && (((ajy)localObject2).GBj != null) && (((ajy)localObject2).GBj.computeSize() != 0)) {
          break label2827;
        }
        ae.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
        label1712:
        localObject1 = ((ajx)localObject1).GAu;
        if ((localObject1 != null) && (((ajy)localObject1).GBs != null)) {
          break label2985;
        }
        ae.e("MicroMsg.FavDataItemParser", "setAppBrandXml toXml, item empty");
      }
      for (;;)
      {
        localStringBuffer.append("</dataitem>");
        i += 1;
        break;
        localObject2 = ((ajy)localObject2).GBb;
        localStringBuffer.append("<dataitemsource");
        if (((ajz)localObject2).GBz) {
          localStringBuffer.append(" sourcetype='").append(((ajz)localObject2).sourceType).append("'");
        }
        if (((ajz)localObject2).GBD) {
          localStringBuffer.append(" sourceid='").append(((ajz)localObject2).GBC).append("'");
        }
        localStringBuffer.append(">");
        if (((ajz)localObject2).GBA) {
          localStringBuffer.append("<fromusr>").append(bu.aSz(((ajz)localObject2).dzZ)).append("</fromusr>");
        }
        if (((ajz)localObject2).GBB) {
          localStringBuffer.append("<tousr>").append(bu.aSz(((ajz)localObject2).toUser)).append("</tousr>");
        }
        if (((ajz)localObject2).GBF) {
          localStringBuffer.append("<realchatname>").append(bu.aSz(((ajz)localObject2).GBE)).append("</realchatname>");
        }
        if (((ajz)localObject2).GBG) {
          localStringBuffer.append("<msgid>").append(((ajz)localObject2).msgId).append("</msgid>");
        }
        if (((ajz)localObject2).GBH) {
          localStringBuffer.append("<eventid>").append(((ajz)localObject2).dLO).append("</eventid>");
        }
        if (((ajz)localObject2).GBI) {
          localStringBuffer.append("<appid>").append(((ajz)localObject2).appId).append("</appid>");
        }
        if (((ajz)localObject2).GBJ) {
          localStringBuffer.append("<link>").append(bu.aSz(((ajz)localObject2).link)).append("</link>");
        }
        if (((ajz)localObject2).GBM) {
          localStringBuffer.append("<brandid>").append(bu.aSz(((ajz)localObject2).dkZ)).append("</brandid>");
        }
        localStringBuffer.append("</dataitemsource>");
        break label1500;
        label2101:
        localObject2 = ((ajy)localObject2).GBd;
        localStringBuffer.append("<locitem>");
        if (((ake)localObject2).GBU) {
          localStringBuffer.append("<label>").append(bu.aSz(((ake)localObject2).label)).append("</label>");
        }
        if (((ake)localObject2).GBS) {
          localStringBuffer.append("<lat>").append(((ake)localObject2).lat).append("</lat>");
        }
        if (((ake)localObject2).GBR) {
          localStringBuffer.append("<lng>").append(((ake)localObject2).lng).append("</lng>");
        }
        if (((ake)localObject2).GBT) {
          localStringBuffer.append("<scale>").append(((ake)localObject2).dzG).append("</scale>");
        }
        if (((ake)localObject2).GBV) {
          localStringBuffer.append("<poiname>").append(((ake)localObject2).dEv).append("</poiname>");
        }
        localStringBuffer.append("</locitem>");
        break label1539;
        label2280:
        alc localalc = ((ajy)localObject2).GBf;
        localStringBuffer.append("<weburlitem>");
        if (localalc.GCH) {
          localStringBuffer.append("<clean_url>").append(bu.aSz(localalc.GCG)).append("</clean_url>");
        }
        if (localalc.Gzu) {
          localStringBuffer.append("<pagedesc>").append(bu.aSz(localalc.desc)).append("</pagedesc>");
        }
        if (localalc.GCb) {
          localStringBuffer.append("<pagethumb_url>").append(bu.aSz(localalc.thumbUrl)).append("</pagethumb_url>");
        }
        if (localalc.Gzt) {
          localStringBuffer.append("<pagetitle>").append(bu.aSz(localalc.title)).append("</pagetitle>");
        }
        if (localalc.GCJ) {
          localStringBuffer.append("<opencache>").append(localalc.GCI).append("</opencache>");
        }
        if (localalc.GCK) {
          localStringBuffer.append("<contentattr>").append(localalc.hCH).append("</contentattr>");
        }
        if (localalc.GAF) {
          localStringBuffer.append("<canvasPageXml>").append(bu.aSz(localalc.canvasPageXml)).append("</canvasPageXml>");
        }
        if (localalc.GCN) {
          localStringBuffer.append("<wsVideoFlowXml>").append(bu.aSz(localalc.GCL)).append("</wsVideoFlowXml>");
        }
        if ((localObject2 == null) || (((ajy)localObject2).Ekw == null)) {
          ae.d("MicroMsg.FavDataItemParser", "setMpMsgXml toXml, item empty");
        }
        for (;;)
        {
          localStringBuffer.append("</weburlitem>");
          break;
          localStringBuffer.append(b.a(((ajy)localObject2).Ekw));
        }
        label2601:
        localStringBuffer.append(e.b(((ajy)localObject2).GBx));
        break label1606;
        label2617:
        localStringBuffer.append(b.b(((ajy)localObject2).GBv));
        break label1634;
        label2633:
        localObject2 = ((ajy)localObject2).GBh;
        localStringBuffer.append("<productitem");
        if (((akm)localObject2).GCd) {
          localStringBuffer.append(" type='").append(((akm)localObject2).type).append("'");
        }
        localStringBuffer.append(">");
        if (((akm)localObject2).Gzt) {
          localStringBuffer.append("<producttitle>").append(bu.aSz(((akm)localObject2).title)).append("</producttitle>");
        }
        if (((akm)localObject2).Gzu) {
          localStringBuffer.append("<productdesc>").append(bu.aSz(((akm)localObject2).desc)).append("</productdesc>");
        }
        if (((akm)localObject2).GCb) {
          localStringBuffer.append("<productthumb_url>").append(bu.aSz(((akm)localObject2).thumbUrl)).append("</productthumb_url>");
        }
        if (((akm)localObject2).GCc) {
          localStringBuffer.append("<productinfo>").append(bu.aSz(((akm)localObject2).info)).append("</productinfo>");
        }
        localStringBuffer.append("</productitem>");
        break label1673;
        label2827:
        localObject2 = ((ajy)localObject2).GBj;
        localStringBuffer.append("<tvitem>");
        if (((akw)localObject2).Gzt) {
          localStringBuffer.append("<tvtitle>").append(bu.aSz(((akw)localObject2).title)).append("</tvtitle>");
        }
        if (((akw)localObject2).Gzu) {
          localStringBuffer.append("<tvdesc>").append(bu.aSz(((akw)localObject2).desc)).append("</tvdesc>");
        }
        if (((akw)localObject2).GCb) {
          localStringBuffer.append("<tvthumb_url>").append(bu.aSz(((akw)localObject2).thumbUrl)).append("</tvthumb_url>");
        }
        if (((akw)localObject2).GCc) {
          localStringBuffer.append("<tvinfo>").append(bu.aSz(((akw)localObject2).info)).append("</tvinfo>");
        }
        localStringBuffer.append("</tvitem>");
        break label1712;
        label2985:
        localObject1 = ((ajy)localObject1).GBs;
        if (localObject1 != null)
        {
          localStringBuffer.append("<appbranditem>");
          localStringBuffer.append("<username>").append(bu.aSz(((ajv)localObject1).username)).append("</username>");
          localStringBuffer.append("<appid>").append(bu.aSz(((ajv)localObject1).appId)).append("</appid>");
          localStringBuffer.append("<pkgtype>").append(((ajv)localObject1).duK).append("</pkgtype>");
          localStringBuffer.append("<iconurl>").append(bu.aSz(((ajv)localObject1).iconUrl)).append("</iconurl>");
          localStringBuffer.append("<type>").append(((ajv)localObject1).type).append("</type>");
          localStringBuffer.append("<pagepath>").append(bu.aSz(((ajv)localObject1).dlk)).append("</pagepath>");
          localStringBuffer.append("<sourcedisplayname>").append(bu.aSz(((ajv)localObject1).Gzq)).append("</sourcedisplayname>");
          localStringBuffer.append("<version>").append(((ajv)localObject1).version).append("</version>");
          localStringBuffer.append("<disableforward>").append(((ajv)localObject1).kuE).append("</disableforward>");
          localStringBuffer.append("<tradingguaranteeflag>").append(((ajv)localObject1).kaX).append("</tradingguaranteeflag>");
          localStringBuffer.append("<messageextradata>").append(String.format("<![CDATA[%s]]>", new Object[] { ((ajv)localObject1).dLl })).append("</messageextradata>");
          localStringBuffer.append("<subtype>").append(((ajv)localObject1).subType).append("</subtype>");
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