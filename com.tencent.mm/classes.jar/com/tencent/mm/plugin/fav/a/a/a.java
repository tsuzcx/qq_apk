package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.ak;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class a
{
  public static String dE(List<aml> paramList)
  {
    AppMethodBeat.i(103494);
    if ((paramList == null) || (paramList.size() == 0))
    {
      Log.v("MicroMsg.FavDataItemParser", "klem toXml data list empty");
      AppMethodBeat.o(103494);
      return "";
    }
    int j = paramList.size();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("<datalist count='").append(j).append("'>");
    int i = 0;
    if (i < j)
    {
      Object localObject1 = (aml)paramList.get(i);
      localStringBuffer.append("<dataitem ");
      if (((aml)localObject1).LvB) {
        localStringBuffer.append("datatype='").append(((aml)localObject1).dataType).append("'");
      }
      if (((aml)localObject1).Lwe) {
        localStringBuffer.append(" datastatus='").append(((aml)localObject1).Lwd).append("'");
      }
      if (((aml)localObject1).LvK) {
        localStringBuffer.append(" dataid='").append(((aml)localObject1).dLl).append("'");
      }
      if (((aml)localObject1).Lwq) {
        localStringBuffer.append(" htmlid='").append(Util.escapeStringForXml(((aml)localObject1).Lwp)).append("'");
      }
      if (((aml)localObject1).Lww) {
        localStringBuffer.append(" dataillegaltype='").append(((aml)localObject1).Lwv).append("'");
      }
      if (((aml)localObject1).LvW) {
        localStringBuffer.append(" datasourceid='").append(((aml)localObject1).LvV).append("'");
      }
      localStringBuffer.append(">");
      if (((aml)localObject1).LvD) {
        localStringBuffer.append("<datafmt>").append(((aml)localObject1).LvC).append("</datafmt>");
      }
      if (((aml)localObject1).Lvh) {
        localStringBuffer.append("<datatitle>").append(Util.escapeStringForXml(((aml)localObject1).title)).append("</datatitle>");
      }
      if (((aml)localObject1).Lvi) {
        localStringBuffer.append("<datadesc>").append(Util.escapeStringForXml(((aml)localObject1).desc)).append("</datadesc>");
      }
      if (((aml)localObject1).Lvj) {
        localStringBuffer.append("<cdn_thumburl>").append(Util.escapeStringForXml(((aml)localObject1).iwX)).append("</cdn_thumburl>");
      }
      if (((aml)localObject1).Lvm) {
        localStringBuffer.append("<thumb_width>").append(((aml)localObject1).thumbWidth).append("</thumb_width>");
      }
      if (((aml)localObject1).Lvn) {
        localStringBuffer.append("<thumb_height>").append(((aml)localObject1).thumbHeight).append("</thumb_height>");
      }
      if (((aml)localObject1).Lvo) {
        localStringBuffer.append("<cdn_dataurl>").append(Util.escapeStringForXml(((aml)localObject1).KuR)).append("</cdn_dataurl>");
      }
      if (((aml)localObject1).Lvl) {
        localStringBuffer.append("<cdn_thumbkey>").append(Util.escapeStringForXml(((aml)localObject1).Lvk)).append("</cdn_thumbkey>");
      }
      if (((aml)localObject1).Lvq) {
        localStringBuffer.append("<cdn_datakey>").append(Util.escapeStringForXml(((aml)localObject1).Lvp)).append("</cdn_datakey>");
      }
      if (((aml)localObject1).Lvs) {
        localStringBuffer.append("<cdn_encryver>").append(((aml)localObject1).Lvr).append("</cdn_encryver>");
      }
      if (((aml)localObject1).Lvt) {
        localStringBuffer.append("<duration>").append(((aml)localObject1).duration).append("</duration>");
      }
      if (((aml)localObject1).Lvv) {
        localStringBuffer.append("<stream_weburl>").append(Util.escapeStringForXml(((aml)localObject1).Lvu)).append("</stream_weburl>");
      }
      if (((aml)localObject1).LwM) {
        localStringBuffer.append("<songalbumurl>").append(Util.escapeStringForXml(((aml)localObject1).songAlbumUrl)).append("</songalbumurl>");
      }
      if (((aml)localObject1).LwN) {
        localStringBuffer.append("<songlyric>").append(Util.escapeStringForXml(((aml)localObject1).songLyric)).append("</songlyric>");
      }
      if (((aml)localObject1).Lvx) {
        localStringBuffer.append("<stream_dataurl>").append(Util.escapeStringForXml(((aml)localObject1).Lvw)).append("</stream_dataurl>");
      }
      if (((aml)localObject1).Lvz) {
        localStringBuffer.append("<stream_lowbandurl>").append(Util.escapeStringForXml(((aml)localObject1).Lvy)).append("</stream_lowbandurl>");
      }
      if (((aml)localObject1).LvA) {
        localStringBuffer.append("<dataext>").append(Util.escapeStringForXml(((aml)localObject1).dFN)).append("</dataext>");
      }
      if (((aml)localObject1).LvF) {
        localStringBuffer.append("<fullmd5>").append(((aml)localObject1).LvE).append("</fullmd5>");
      }
      if (((aml)localObject1).LvH) {
        localStringBuffer.append("<head256md5>").append(((aml)localObject1).LvG).append("</head256md5>");
      }
      if (((aml)localObject1).LvJ) {
        localStringBuffer.append("<fullsize>").append(((aml)localObject1).LvI).append("</fullsize>");
      }
      if (((aml)localObject1).LvQ) {
        localStringBuffer.append("<thumbfullmd5>").append(((aml)localObject1).LvP).append("</thumbfullmd5>");
      }
      if (((aml)localObject1).LvS) {
        localStringBuffer.append("<thumbhead256md5>").append(((aml)localObject1).LvR).append("</thumbhead256md5>");
      }
      if (((aml)localObject1).LvU) {
        localStringBuffer.append("<thumbfullsize>").append(((aml)localObject1).LvT).append("</thumbfullsize>");
      }
      if (((aml)localObject1).LvY) {
        localStringBuffer.append("<stream_videoid>").append(Util.escapeStringForXml(((aml)localObject1).LvX)).append("</stream_videoid>");
      }
      if (((aml)localObject1).Lwg) {
        localStringBuffer.append("<datasrctitle>").append(Util.escapeStringForXml(((aml)localObject1).Lwf)).append("</datasrctitle>");
      }
      if (((aml)localObject1).Lwk) {
        localStringBuffer.append("<datasrcname>").append(Util.escapeStringForXml(((aml)localObject1).Lwj)).append("</datasrcname>");
      }
      if (((aml)localObject1).Lwm) {
        localStringBuffer.append("<datasrctime>").append(Util.escapeStringForXml(((aml)localObject1).Lwl)).append("</datasrctime>");
      }
      if ((((aml)localObject1).Lws) && ((((aml)localObject1).Lwh == null) || (((aml)localObject1).Lwh.LwS == null) || (((aml)localObject1).Lwh.LwS.computeSize() == 0))) {
        localStringBuffer.append("<canvasPageXml>").append(Util.escapeStringForXml(((aml)localObject1).canvasPageXml)).append("</canvasPageXml>");
      }
      if (((aml)localObject1).Lwr) {
        localStringBuffer.append("<statextstr>").append(Util.escapeStringForXml(((aml)localObject1).ean)).append("</statextstr>");
      }
      if (((aml)localObject1).Lwy) {
        localStringBuffer.append("<recordxml>").append(((aml)localObject1).Lwx).append("</recordxml>");
      }
      if (((aml)localObject1).jsB) {
        localStringBuffer.append("<messageuuid>").append(Util.escapeStringForXml(((aml)localObject1).jsz)).append("</messageuuid>");
      }
      Object localObject2 = ((aml)localObject1).Lwn;
      if (localObject2 != null)
      {
        localStringBuffer.append("<streamvideo>");
        localStringBuffer.append("<streamvideourl>").append(Util.escapeStringForXml(((amo)localObject2).iyZ)).append("</streamvideourl>");
        localStringBuffer.append("<streamvideototaltime>").append(((amo)localObject2).LxJ).append("</streamvideototaltime>");
        localStringBuffer.append("<streamvideotitle>").append(Util.escapeStringForXml(((amo)localObject2).izb)).append("</streamvideotitle>");
        localStringBuffer.append("<streamvideowording>").append(Util.escapeStringForXml(((amo)localObject2).izc)).append("</streamvideowording>");
        localStringBuffer.append("<streamvideoweburl>").append(Util.escapeStringForXml(((amo)localObject2).izd)).append("</streamvideoweburl>");
        localStringBuffer.append("<streamvideoaduxinfo>").append(Util.escapeStringForXml(((amo)localObject2).izf)).append("</streamvideoaduxinfo>");
        localStringBuffer.append("<streamvideopublishid>").append(Util.escapeStringForXml(((amo)localObject2).izg)).append("</streamvideopublishid>");
        localStringBuffer.append("</streamvideo>");
      }
      localObject2 = ((aml)localObject1).Lwh;
      if ((localObject2 == null) || (((amm)localObject2).LwO == null) || (((amm)localObject2).LwO.computeSize() == 0))
      {
        Log.v("MicroMsg.FavDataItemParser", "klem toXml, data source item empty");
        label1500:
        localObject2 = ((aml)localObject1).Lwh;
        if ((localObject2 != null) && (((amm)localObject2).LwQ != null) && (((amm)localObject2).LwQ.computeSize() != 0)) {
          break label2185;
        }
        Log.v("MicroMsg.FavDataItemParser", "klem toXml, loc item empty");
        label1539:
        localObject2 = ((aml)localObject1).Lwh;
        if ((localObject2 != null) && (((amm)localObject2).LwS != null) && (((amm)localObject2).LwS.computeSize() != 0)) {
          break label2364;
        }
        Log.v("MicroMsg.FavDataItemParser", "klem toXml, url item empty");
        localObject2 = ((aml)localObject1).Lwh;
        if ((localObject2 != null) && (((amm)localObject2).Lxk != null)) {
          break label2685;
        }
        Log.i("MicroMsg.FavDataItemParser", "klem toXml, finder item empty");
        label1606:
        localObject2 = ((aml)localObject1).Lwh;
        if ((localObject2 != null) && (((amm)localObject2).Lxs != null)) {
          break label2701;
        }
        Log.i("MicroMsg.FavDataItemParser", "klem toXml, music item empty");
        label1634:
        localObject2 = ((aml)localObject1).Lwh;
        if ((localObject2 != null) && (((amm)localObject2).Lxm != null)) {
          break label2717;
        }
        Log.i("MicroMsg.FavDataItemParser", "klem toXml, finder live item empty");
        label1662:
        localObject2 = ((aml)localObject1).Lwh;
        if ((localObject2 != null) && (((amm)localObject2).Lxu != null)) {
          break label2733;
        }
        Log.i("MicroMsg.FavDataItemParser", "klem toXml, finder topic item empty");
        label1690:
        localObject2 = ((aml)localObject1).Lwh;
        if ((localObject2 != null) && (((amm)localObject2).Lxi != null)) {
          break label2749;
        }
        Log.d("MicroMsg.FavDataItemParser", "setMpVideoXml toXml, item empty");
        label1718:
        localObject2 = ((aml)localObject1).Lwh;
        if ((localObject2 != null) && (((amm)localObject2).LwU != null) && (((amm)localObject2).LwU.computeSize() != 0)) {
          break label2765;
        }
        Log.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
        label1757:
        localObject2 = ((aml)localObject1).Lwh;
        if ((localObject2 != null) && (((amm)localObject2).LwW != null) && (((amm)localObject2).LwW.computeSize() != 0)) {
          break label2959;
        }
        Log.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
        label1796:
        localObject1 = ((aml)localObject1).Lwh;
        if ((localObject1 != null) && (((amm)localObject1).Lxf != null)) {
          break label3117;
        }
        Log.e("MicroMsg.FavDataItemParser", "setAppBrandXml toXml, item empty");
      }
      for (;;)
      {
        localStringBuffer.append("</dataitem>");
        i += 1;
        break;
        localObject2 = ((amm)localObject2).LwO;
        localStringBuffer.append("<dataitemsource");
        if (((amn)localObject2).Lxw) {
          localStringBuffer.append(" sourcetype='").append(((amn)localObject2).sourceType).append("'");
        }
        if (((amn)localObject2).Lxz) {
          localStringBuffer.append(" sourceid='").append(((amn)localObject2).Gah).append("'");
        }
        localStringBuffer.append(">");
        if (((amn)localObject2).Lxx) {
          localStringBuffer.append("<fromusr>").append(Util.escapeStringForXml(((amn)localObject2).dRL)).append("</fromusr>");
        }
        if (((amn)localObject2).Lxy) {
          localStringBuffer.append("<tousr>").append(Util.escapeStringForXml(((amn)localObject2).toUser)).append("</tousr>");
        }
        if (((amn)localObject2).LxB) {
          localStringBuffer.append("<realchatname>").append(Util.escapeStringForXml(((amn)localObject2).LxA)).append("</realchatname>");
        }
        if (((amn)localObject2).LxC) {
          localStringBuffer.append("<msgid>").append(((amn)localObject2).msgId).append("</msgid>");
        }
        if (((amn)localObject2).LxD) {
          localStringBuffer.append("<eventid>").append(((amn)localObject2).edD).append("</eventid>");
        }
        if (((amn)localObject2).LxE) {
          localStringBuffer.append("<appid>").append(((amn)localObject2).appId).append("</appid>");
        }
        if (((amn)localObject2).LxF) {
          localStringBuffer.append("<link>").append(Util.escapeStringForXml(((amn)localObject2).link)).append("</link>");
        }
        if (((amn)localObject2).LxI) {
          localStringBuffer.append("<brandid>").append(Util.escapeStringForXml(((amn)localObject2).dCl)).append("</brandid>");
        }
        localStringBuffer.append("</dataitemsource>");
        break label1500;
        label2185:
        localObject2 = ((amm)localObject2).LwQ;
        localStringBuffer.append("<locitem>");
        if (((ams)localObject2).LxQ) {
          localStringBuffer.append("<label>").append(Util.escapeStringForXml(((ams)localObject2).label)).append("</label>");
        }
        if (((ams)localObject2).LxO) {
          localStringBuffer.append("<lat>").append(((ams)localObject2).lat).append("</lat>");
        }
        if (((ams)localObject2).LxN) {
          localStringBuffer.append("<lng>").append(((ams)localObject2).lng).append("</lng>");
        }
        if (((ams)localObject2).LxP) {
          localStringBuffer.append("<scale>").append(((ams)localObject2).dRt).append("</scale>");
        }
        if (((ams)localObject2).LxR) {
          localStringBuffer.append("<poiname>").append(((ams)localObject2).dWi).append("</poiname>");
        }
        localStringBuffer.append("</locitem>");
        break label1539;
        label2364:
        anq localanq = ((amm)localObject2).LwS;
        localStringBuffer.append("<weburlitem>");
        if (localanq.LyD) {
          localStringBuffer.append("<clean_url>").append(Util.escapeStringForXml(localanq.LyC)).append("</clean_url>");
        }
        if (localanq.Lvi) {
          localStringBuffer.append("<pagedesc>").append(Util.escapeStringForXml(localanq.desc)).append("</pagedesc>");
        }
        if (localanq.LxX) {
          localStringBuffer.append("<pagethumb_url>").append(Util.escapeStringForXml(localanq.thumbUrl)).append("</pagethumb_url>");
        }
        if (localanq.Lvh) {
          localStringBuffer.append("<pagetitle>").append(Util.escapeStringForXml(localanq.title)).append("</pagetitle>");
        }
        if (localanq.LyF) {
          localStringBuffer.append("<opencache>").append(localanq.LyE).append("</opencache>");
        }
        if (localanq.LyG) {
          localStringBuffer.append("<contentattr>").append(localanq.contentattr).append("</contentattr>");
        }
        if (localanq.Lws) {
          localStringBuffer.append("<canvasPageXml>").append(Util.escapeStringForXml(localanq.canvasPageXml)).append("</canvasPageXml>");
        }
        if (localanq.LyI) {
          localStringBuffer.append("<wsVideoFlowXml>").append(Util.escapeStringForXml(localanq.LyH)).append("</wsVideoFlowXml>");
        }
        if ((localObject2 == null) || (((amm)localObject2).IXu == null)) {
          Log.d("MicroMsg.FavDataItemParser", "setMpMsgXml toXml, item empty");
        }
        for (;;)
        {
          localStringBuffer.append("</weburlitem>");
          break;
          localStringBuffer.append(b.a(((amm)localObject2).IXu));
        }
        label2685:
        localStringBuffer.append(l.b(((amm)localObject2).Lxk));
        break label1606;
        label2701:
        localStringBuffer.append(ak.a(((amm)localObject2).Lxs));
        break label1634;
        label2717:
        localStringBuffer.append(l.c(((amm)localObject2).Lxm));
        break label1662;
        label2733:
        localStringBuffer.append(l.b(((amm)localObject2).Lxu));
        break label1690;
        label2749:
        localStringBuffer.append(b.b(((amm)localObject2).Lxi));
        break label1718;
        label2765:
        localObject2 = ((amm)localObject2).LwU;
        localStringBuffer.append("<productitem");
        if (((ana)localObject2).LxZ) {
          localStringBuffer.append(" type='").append(((ana)localObject2).type).append("'");
        }
        localStringBuffer.append(">");
        if (((ana)localObject2).Lvh) {
          localStringBuffer.append("<producttitle>").append(Util.escapeStringForXml(((ana)localObject2).title)).append("</producttitle>");
        }
        if (((ana)localObject2).Lvi) {
          localStringBuffer.append("<productdesc>").append(Util.escapeStringForXml(((ana)localObject2).desc)).append("</productdesc>");
        }
        if (((ana)localObject2).LxX) {
          localStringBuffer.append("<productthumb_url>").append(Util.escapeStringForXml(((ana)localObject2).thumbUrl)).append("</productthumb_url>");
        }
        if (((ana)localObject2).LxY) {
          localStringBuffer.append("<productinfo>").append(Util.escapeStringForXml(((ana)localObject2).info)).append("</productinfo>");
        }
        localStringBuffer.append("</productitem>");
        break label1757;
        label2959:
        localObject2 = ((amm)localObject2).LwW;
        localStringBuffer.append("<tvitem>");
        if (((ank)localObject2).Lvh) {
          localStringBuffer.append("<tvtitle>").append(Util.escapeStringForXml(((ank)localObject2).title)).append("</tvtitle>");
        }
        if (((ank)localObject2).Lvi) {
          localStringBuffer.append("<tvdesc>").append(Util.escapeStringForXml(((ank)localObject2).desc)).append("</tvdesc>");
        }
        if (((ank)localObject2).LxX) {
          localStringBuffer.append("<tvthumb_url>").append(Util.escapeStringForXml(((ank)localObject2).thumbUrl)).append("</tvthumb_url>");
        }
        if (((ank)localObject2).LxY) {
          localStringBuffer.append("<tvinfo>").append(Util.escapeStringForXml(((ank)localObject2).info)).append("</tvinfo>");
        }
        localStringBuffer.append("</tvitem>");
        break label1796;
        label3117:
        localObject1 = ((amm)localObject1).Lxf;
        if (localObject1 != null)
        {
          localStringBuffer.append("<appbranditem>");
          localStringBuffer.append("<username>").append(Util.escapeStringForXml(((amj)localObject1).username)).append("</username>");
          localStringBuffer.append("<appid>").append(Util.escapeStringForXml(((amj)localObject1).appId)).append("</appid>");
          localStringBuffer.append("<pkgtype>").append(((amj)localObject1).dMe).append("</pkgtype>");
          localStringBuffer.append("<iconurl>").append(Util.escapeStringForXml(((amj)localObject1).iconUrl)).append("</iconurl>");
          localStringBuffer.append("<type>").append(((amj)localObject1).type).append("</type>");
          localStringBuffer.append("<pagepath>").append(Util.escapeStringForXml(((amj)localObject1).dCx)).append("</pagepath>");
          localStringBuffer.append("<sourcedisplayname>").append(Util.escapeStringForXml(((amj)localObject1).Lve)).append("</sourcedisplayname>");
          localStringBuffer.append("<version>").append(((amj)localObject1).version).append("</version>");
          localStringBuffer.append("<disableforward>").append(((amj)localObject1).lyE).append("</disableforward>");
          localStringBuffer.append("<tradingguaranteeflag>").append(((amj)localObject1).leb).append("</tradingguaranteeflag>");
          localStringBuffer.append("<messageextradata>").append(String.format("<![CDATA[%s]]>", new Object[] { ((amj)localObject1).eda })).append("</messageextradata>");
          localStringBuffer.append("<subtype>").append(((amj)localObject1).subType).append("</subtype>");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.a
 * JD-Core Version:    0.7.0.1
 */