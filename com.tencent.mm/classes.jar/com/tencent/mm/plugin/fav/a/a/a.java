package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.cq;
import com.tencent.mm.plugin.findersdk.a.q;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class a
{
  public static String fF(List<arf> paramList)
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
      Object localObject1 = (arf)paramList.get(i);
      localStringBuffer.append("<dataitem ");
      if (((arf)localObject1).ZyT) {
        localStringBuffer.append("datatype='").append(((arf)localObject1).dataType).append("'");
      }
      if (((arf)localObject1).Zzv) {
        localStringBuffer.append(" datastatus='").append(((arf)localObject1).Zzu).append("'");
      }
      if (((arf)localObject1).Zzc) {
        localStringBuffer.append(" dataid='").append(((arf)localObject1).hIQ).append("'");
      }
      if (((arf)localObject1).ZzH) {
        localStringBuffer.append(" htmlid='").append(Util.escapeStringForXml(((arf)localObject1).ZzG)).append("'");
      }
      if (((arf)localObject1).ZzN) {
        localStringBuffer.append(" dataillegaltype='").append(((arf)localObject1).ZzM).append("'");
      }
      if (((arf)localObject1).Zzn) {
        localStringBuffer.append(" datasourceid='").append(((arf)localObject1).Zzm).append("'");
      }
      localStringBuffer.append(">");
      if (((arf)localObject1).ZyV) {
        localStringBuffer.append("<datafmt>").append(((arf)localObject1).ZyU).append("</datafmt>");
      }
      if (((arf)localObject1).Zyz) {
        localStringBuffer.append("<datatitle>").append(Util.escapeStringForXml(((arf)localObject1).title)).append("</datatitle>");
      }
      if (((arf)localObject1).ZyA) {
        localStringBuffer.append("<datadesc>").append(Util.escapeStringForXml(((arf)localObject1).desc)).append("</datadesc>");
      }
      if (((arf)localObject1).ZyB) {
        localStringBuffer.append("<cdn_thumburl>").append(Util.escapeStringForXml(((arf)localObject1).nRr)).append("</cdn_thumburl>");
      }
      if (((arf)localObject1).ZyE) {
        localStringBuffer.append("<thumb_width>").append(((arf)localObject1).thumbWidth).append("</thumb_width>");
      }
      if (((arf)localObject1).ZyF) {
        localStringBuffer.append("<thumb_height>").append(((arf)localObject1).thumbHeight).append("</thumb_height>");
      }
      if (((arf)localObject1).ZyG) {
        localStringBuffer.append("<cdn_dataurl>").append(Util.escapeStringForXml(((arf)localObject1).Ysw)).append("</cdn_dataurl>");
      }
      if (((arf)localObject1).ZyD) {
        localStringBuffer.append("<cdn_thumbkey>").append(Util.escapeStringForXml(((arf)localObject1).ZyC)).append("</cdn_thumbkey>");
      }
      if (((arf)localObject1).ZyI) {
        localStringBuffer.append("<cdn_datakey>").append(Util.escapeStringForXml(((arf)localObject1).ZyH)).append("</cdn_datakey>");
      }
      if (((arf)localObject1).ZyK) {
        localStringBuffer.append("<cdn_encryver>").append(((arf)localObject1).ZyJ).append("</cdn_encryver>");
      }
      if (((arf)localObject1).ZyL) {
        localStringBuffer.append("<duration>").append(((arf)localObject1).duration).append("</duration>");
      }
      if (((arf)localObject1).ZyN) {
        localStringBuffer.append("<stream_weburl>").append(Util.escapeStringForXml(((arf)localObject1).ZyM)).append("</stream_weburl>");
      }
      if (((arf)localObject1).ZAd) {
        localStringBuffer.append("<songalbumurl>").append(Util.escapeStringForXml(((arf)localObject1).songAlbumUrl)).append("</songalbumurl>");
      }
      if (((arf)localObject1).ZAe) {
        localStringBuffer.append("<songlyric>").append(Util.escapeStringForXml(((arf)localObject1).songLyric)).append("</songlyric>");
      }
      if (((arf)localObject1).ZyP) {
        localStringBuffer.append("<stream_dataurl>").append(Util.escapeStringForXml(((arf)localObject1).ZyO)).append("</stream_dataurl>");
      }
      if (((arf)localObject1).ZyR) {
        localStringBuffer.append("<stream_lowbandurl>").append(Util.escapeStringForXml(((arf)localObject1).ZyQ)).append("</stream_lowbandurl>");
      }
      if (((arf)localObject1).ZyS) {
        localStringBuffer.append("<dataext>").append(Util.escapeStringForXml(((arf)localObject1).hDd)).append("</dataext>");
      }
      if (((arf)localObject1).ZyX) {
        localStringBuffer.append("<fullmd5>").append(((arf)localObject1).ZyW).append("</fullmd5>");
      }
      if (((arf)localObject1).ZyZ) {
        localStringBuffer.append("<head256md5>").append(((arf)localObject1).ZyY).append("</head256md5>");
      }
      if (((arf)localObject1).Zzb) {
        localStringBuffer.append("<fullsize>").append(((arf)localObject1).Zza).append("</fullsize>");
      }
      if (((arf)localObject1).Zzh) {
        localStringBuffer.append("<thumbfullmd5>").append(((arf)localObject1).QJs).append("</thumbfullmd5>");
      }
      if (((arf)localObject1).Zzj) {
        localStringBuffer.append("<thumbhead256md5>").append(((arf)localObject1).Zzi).append("</thumbhead256md5>");
      }
      if (((arf)localObject1).Zzl) {
        localStringBuffer.append("<thumbfullsize>").append(((arf)localObject1).Zzk).append("</thumbfullsize>");
      }
      if (((arf)localObject1).Zzp) {
        localStringBuffer.append("<stream_videoid>").append(Util.escapeStringForXml(((arf)localObject1).Zzo)).append("</stream_videoid>");
      }
      if (((arf)localObject1).Zzx) {
        localStringBuffer.append("<datasrctitle>").append(Util.escapeStringForXml(((arf)localObject1).Zzw)).append("</datasrctitle>");
      }
      if (((arf)localObject1).ZzB) {
        localStringBuffer.append("<datasrcname>").append(Util.escapeStringForXml(((arf)localObject1).ZzA)).append("</datasrcname>");
      }
      if (((arf)localObject1).ZzD) {
        localStringBuffer.append("<datasrctime>").append(Util.escapeStringForXml(((arf)localObject1).ZzC)).append("</datasrctime>");
      }
      if ((((arf)localObject1).ZzJ) && ((((arf)localObject1).Zzy == null) || (((arf)localObject1).Zzy.ZAj == null) || (((arf)localObject1).Zzy.ZAj.computeSize() == 0))) {
        localStringBuffer.append("<canvasPageXml>").append(Util.escapeStringForXml(((arf)localObject1).canvasPageXml)).append("</canvasPageXml>");
      }
      if (((arf)localObject1).ZzI) {
        localStringBuffer.append("<statextstr>").append(Util.escapeStringForXml(((arf)localObject1).iah)).append("</statextstr>");
      }
      if (((arf)localObject1).ZzP) {
        localStringBuffer.append("<recordxml>").append(((arf)localObject1).ZzO).append("</recordxml>");
      }
      if (((arf)localObject1).pbr) {
        localStringBuffer.append("<messageuuid>").append(Util.escapeStringForXml(((arf)localObject1).pbn)).append("</messageuuid>");
      }
      Object localObject2 = ((arf)localObject1).ZzE;
      if (localObject2 != null)
      {
        localStringBuffer.append("<streamvideo>");
        localStringBuffer.append("<streamvideourl>").append(Util.escapeStringForXml(((ari)localObject2).nTu)).append("</streamvideourl>");
        localStringBuffer.append("<streamvideototaltime>").append(((ari)localObject2).ZBc).append("</streamvideototaltime>");
        localStringBuffer.append("<streamvideotitle>").append(Util.escapeStringForXml(((ari)localObject2).nTw)).append("</streamvideotitle>");
        localStringBuffer.append("<streamvideowording>").append(Util.escapeStringForXml(((ari)localObject2).nTx)).append("</streamvideowording>");
        localStringBuffer.append("<streamvideoweburl>").append(Util.escapeStringForXml(((ari)localObject2).nTy)).append("</streamvideoweburl>");
        localStringBuffer.append("<streamvideoaduxinfo>").append(Util.escapeStringForXml(((ari)localObject2).nTA)).append("</streamvideoaduxinfo>");
        localStringBuffer.append("<streamvideopublishid>").append(Util.escapeStringForXml(((ari)localObject2).nTB)).append("</streamvideopublishid>");
        localStringBuffer.append("</streamvideo>");
      }
      localObject2 = ((arf)localObject1).Zzy;
      if ((localObject2 == null) || (((arg)localObject2).ZAf == null) || (((arg)localObject2).ZAf.computeSize() == 0))
      {
        Log.v("MicroMsg.FavDataItemParser", "klem toXml, data source item empty");
        label1500:
        localObject2 = ((arf)localObject1).Zzy;
        if ((localObject2 != null) && (((arg)localObject2).ZAh != null) && (((arg)localObject2).ZAh.computeSize() != 0)) {
          break label2213;
        }
        Log.v("MicroMsg.FavDataItemParser", "klem toXml, loc item empty");
        label1539:
        localObject2 = ((arf)localObject1).Zzy;
        if ((localObject2 != null) && (((arg)localObject2).ZAj != null) && (((arg)localObject2).ZAj.computeSize() != 0)) {
          break label2392;
        }
        Log.v("MicroMsg.FavDataItemParser", "klem toXml, url item empty");
        localObject2 = ((arf)localObject1).Zzy;
        if ((localObject2 != null) && (((arg)localObject2).ZAB != null)) {
          break label2735;
        }
        Log.d("MicroMsg.FavDataItemParser", "klem toXml, finder item empty");
        label1606:
        localObject2 = ((arf)localObject1).Zzy;
        if ((localObject2 != null) && (((arg)localObject2).ZAJ != null)) {
          break label2751;
        }
        Log.d("MicroMsg.FavDataItemParser", "klem toXml, music item empty");
        label1634:
        localObject2 = ((arf)localObject1).Zzy;
        if ((localObject2 != null) && (((arg)localObject2).ZAD != null)) {
          break label2767;
        }
        Log.d("MicroMsg.FavDataItemParser", "klem toXml, finder live item empty");
        label1662:
        localObject2 = ((arf)localObject1).Zzy;
        if ((localObject2 != null) && (((arg)localObject2).ZAN != null)) {
          break label2783;
        }
        Log.d("MicroMsg.FavDataItemParser", "klem toXml, finder activity item empty");
        label1690:
        localObject2 = ((arf)localObject1).Zzy;
        if ((localObject2 != null) && (((arg)localObject2).ZAL != null)) {
          break label2799;
        }
        Log.d("MicroMsg.FavDataItemParser", "klem toXml, finder topic item empty");
        label1718:
        localObject2 = ((arf)localObject1).Zzy;
        if ((localObject2 != null) && (((arg)localObject2).ZAz != null)) {
          break label2815;
        }
        Log.d("MicroMsg.FavDataItemParser", "setMpVideoXml toXml, item empty");
        label1746:
        localObject2 = ((arf)localObject1).Zzy;
        if ((localObject2 != null) && (((arg)localObject2).ZAl != null) && (((arg)localObject2).ZAl.computeSize() != 0)) {
          break label2831;
        }
        Log.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
        label1785:
        localObject2 = ((arf)localObject1).Zzy;
        if ((localObject2 != null) && (((arg)localObject2).ZAn != null) && (((arg)localObject2).ZAn.computeSize() != 0)) {
          break label3025;
        }
        Log.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
        label1824:
        localObject1 = ((arf)localObject1).Zzy;
        if ((localObject1 != null) && (((arg)localObject1).ZAw != null)) {
          break label3183;
        }
        Log.d("MicroMsg.FavDataItemParser", "setAppBrandXml toXml, item empty");
      }
      for (;;)
      {
        localStringBuffer.append("</dataitem>");
        i += 1;
        break;
        localObject2 = ((arg)localObject2).ZAf;
        localStringBuffer.append("<dataitemsource");
        if (((arh)localObject2).ZAP) {
          localStringBuffer.append(" sourcetype='").append(((arh)localObject2).sourceType).append("'");
        }
        if (((arh)localObject2).ZAS) {
          localStringBuffer.append(" sourceid='").append(((arh)localObject2).sourceId).append("'");
        }
        localStringBuffer.append(">");
        if (((arh)localObject2).ZAQ) {
          localStringBuffer.append("<fromusr>").append(Util.escapeStringForXml(((arh)localObject2).hQQ)).append("</fromusr>");
        }
        if (((arh)localObject2).ZAR) {
          localStringBuffer.append("<tousr>").append(Util.escapeStringForXml(((arh)localObject2).toUser)).append("</tousr>");
        }
        if (((arh)localObject2).ZAU) {
          localStringBuffer.append("<realchatname>").append(Util.escapeStringForXml(((arh)localObject2).ZAT)).append("</realchatname>");
        }
        if (((arh)localObject2).ZAV) {
          localStringBuffer.append("<msgid>").append(((arh)localObject2).msgId).append("</msgid>");
        }
        if (((arh)localObject2).ZAW) {
          localStringBuffer.append("<eventid>").append(((arh)localObject2).eventId).append("</eventid>");
        }
        if (((arh)localObject2).ZAX) {
          localStringBuffer.append("<appid>").append(((arh)localObject2).appId).append("</appid>");
        }
        if (((arh)localObject2).ZAY) {
          localStringBuffer.append("<link>").append(Util.escapeStringForXml(((arh)localObject2).link)).append("</link>");
        }
        if (((arh)localObject2).ZBb) {
          localStringBuffer.append("<brandid>").append(Util.escapeStringForXml(((arh)localObject2).hzi)).append("</brandid>");
        }
        localStringBuffer.append("</dataitemsource>");
        break label1500;
        label2213:
        localObject2 = ((arg)localObject2).ZAh;
        localStringBuffer.append("<locitem>");
        if (((arm)localObject2).ZBj) {
          localStringBuffer.append("<label>").append(Util.escapeStringForXml(((arm)localObject2).label)).append("</label>");
        }
        if (((arm)localObject2).ZBh) {
          localStringBuffer.append("<lat>").append(((arm)localObject2).lat).append("</lat>");
        }
        if (((arm)localObject2).ZBg) {
          localStringBuffer.append("<lng>").append(((arm)localObject2).lng).append("</lng>");
        }
        if (((arm)localObject2).ZBi) {
          localStringBuffer.append("<scale>").append(((arm)localObject2).hQp).append("</scale>");
        }
        if (((arm)localObject2).ZBk) {
          localStringBuffer.append("<poiname>").append(((arm)localObject2).hVI).append("</poiname>");
        }
        localStringBuffer.append("</locitem>");
        break label1539;
        label2392:
        ask localask = ((arg)localObject2).ZAj;
        localStringBuffer.append("<weburlitem>");
        if (localask.ZBW) {
          localStringBuffer.append("<clean_url>").append(Util.escapeStringForXml(localask.ZBV)).append("</clean_url>");
        }
        if (localask.ZyA) {
          localStringBuffer.append("<pagedesc>").append(Util.escapeStringForXml(localask.desc)).append("</pagedesc>");
        }
        if (localask.ZBq) {
          localStringBuffer.append("<pagethumb_url>").append(Util.escapeStringForXml(localask.thumbUrl)).append("</pagethumb_url>");
        }
        if (localask.Zyz) {
          localStringBuffer.append("<pagetitle>").append(Util.escapeStringForXml(localask.title)).append("</pagetitle>");
        }
        if (localask.ZBY) {
          localStringBuffer.append("<opencache>").append(localask.ZBX).append("</opencache>");
        }
        if (localask.ZBZ) {
          localStringBuffer.append("<contentattr>").append(localask.contentattr).append("</contentattr>");
        }
        if (localask.ZzJ) {
          localStringBuffer.append("<canvasPageXml>").append(Util.escapeStringForXml(localask.canvasPageXml)).append("</canvasPageXml>");
        }
        if (localask.ZCb) {
          localStringBuffer.append("<wsVideoFlowXml>").append(Util.escapeStringForXml(localask.ZCa)).append("</wsVideoFlowXml>");
        }
        localStringBuffer.append("<forwardflag>").append(localask.pdq).append("</forwardflag>");
        if ((localObject2 == null) || (((arg)localObject2).WKx == null)) {
          Log.d("MicroMsg.FavDataItemParser", "setMpMsgXml toXml, item empty");
        }
        for (;;)
        {
          localStringBuffer.append("</weburlitem>");
          break;
          localStringBuffer.append(b.a(((arg)localObject2).WKx));
        }
        label2735:
        localStringBuffer.append(q.d(((arg)localObject2).ZAB));
        break label1606;
        label2751:
        localStringBuffer.append(cq.a(((arg)localObject2).ZAJ));
        break label1634;
        label2767:
        localStringBuffer.append(q.c(((arg)localObject2).ZAD));
        break label1662;
        label2783:
        localStringBuffer.append(q.a(((arg)localObject2).ZAN));
        break label1690;
        label2799:
        localStringBuffer.append(q.a(((arg)localObject2).ZAL));
        break label1718;
        label2815:
        localStringBuffer.append(b.b(((arg)localObject2).ZAz));
        break label1746;
        label2831:
        localObject2 = ((arg)localObject2).ZAl;
        localStringBuffer.append("<productitem");
        if (((aru)localObject2).ZBs) {
          localStringBuffer.append(" type='").append(((aru)localObject2).type).append("'");
        }
        localStringBuffer.append(">");
        if (((aru)localObject2).Zyz) {
          localStringBuffer.append("<producttitle>").append(Util.escapeStringForXml(((aru)localObject2).title)).append("</producttitle>");
        }
        if (((aru)localObject2).ZyA) {
          localStringBuffer.append("<productdesc>").append(Util.escapeStringForXml(((aru)localObject2).desc)).append("</productdesc>");
        }
        if (((aru)localObject2).ZBq) {
          localStringBuffer.append("<productthumb_url>").append(Util.escapeStringForXml(((aru)localObject2).thumbUrl)).append("</productthumb_url>");
        }
        if (((aru)localObject2).ZBr) {
          localStringBuffer.append("<productinfo>").append(Util.escapeStringForXml(((aru)localObject2).hZn)).append("</productinfo>");
        }
        localStringBuffer.append("</productitem>");
        break label1785;
        label3025:
        localObject2 = ((arg)localObject2).ZAn;
        localStringBuffer.append("<tvitem>");
        if (((ase)localObject2).Zyz) {
          localStringBuffer.append("<tvtitle>").append(Util.escapeStringForXml(((ase)localObject2).title)).append("</tvtitle>");
        }
        if (((ase)localObject2).ZyA) {
          localStringBuffer.append("<tvdesc>").append(Util.escapeStringForXml(((ase)localObject2).desc)).append("</tvdesc>");
        }
        if (((ase)localObject2).ZBq) {
          localStringBuffer.append("<tvthumb_url>").append(Util.escapeStringForXml(((ase)localObject2).thumbUrl)).append("</tvthumb_url>");
        }
        if (((ase)localObject2).ZBr) {
          localStringBuffer.append("<tvinfo>").append(Util.escapeStringForXml(((ase)localObject2).hZn)).append("</tvinfo>");
        }
        localStringBuffer.append("</tvitem>");
        break label1824;
        label3183:
        localObject1 = ((arg)localObject1).ZAw;
        if (localObject1 != null)
        {
          localStringBuffer.append("<appbranditem>");
          localStringBuffer.append("<username>").append(Util.escapeStringForXml(((ard)localObject1).username)).append("</username>");
          localStringBuffer.append("<appid>").append(Util.escapeStringForXml(((ard)localObject1).appId)).append("</appid>");
          localStringBuffer.append("<pkgtype>").append(((ard)localObject1).hJK).append("</pkgtype>");
          localStringBuffer.append("<iconurl>").append(Util.escapeStringForXml(((ard)localObject1).iconUrl)).append("</iconurl>");
          localStringBuffer.append("<type>").append(((ard)localObject1).type).append("</type>");
          localStringBuffer.append("<pagepath>").append(Util.escapeStringForXml(((ard)localObject1).hzy)).append("</pagepath>");
          localStringBuffer.append("<sourcedisplayname>").append(Util.escapeStringForXml(((ard)localObject1).Zyw)).append("</sourcedisplayname>");
          localStringBuffer.append("<version>").append(((ard)localObject1).version).append("</version>");
          localStringBuffer.append("<disableforward>").append(((ard)localObject1).rxs).append("</disableforward>");
          localStringBuffer.append("<tradingguaranteeflag>").append(((ard)localObject1).rbZ).append("</tradingguaranteeflag>");
          localStringBuffer.append("<showRelievedBuyFlag>").append(((ard)localObject1).nOX).append("</showRelievedBuyFlag>");
          localStringBuffer.append("<messageextradata>").append(String.format("<![CDATA[%s]]>", new Object[] { ((ard)localObject1).idf })).append("</messageextradata>");
          localStringBuffer.append("<subtype>").append(((ard)localObject1).subType).append("</subtype>");
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