package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.am;
import com.tencent.mm.plugin.findersdk.a.k;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class a
{
  public static String dK(List<anm> paramList)
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
      Object localObject1 = (anm)paramList.get(i);
      localStringBuffer.append("<dataitem ");
      if (((anm)localObject1).Syb) {
        localStringBuffer.append("datatype='").append(((anm)localObject1).dataType).append("'");
      }
      if (((anm)localObject1).SyD) {
        localStringBuffer.append(" datastatus='").append(((anm)localObject1).SyC).append("'");
      }
      if (((anm)localObject1).Syk) {
        localStringBuffer.append(" dataid='").append(((anm)localObject1).fEa).append("'");
      }
      if (((anm)localObject1).SyP) {
        localStringBuffer.append(" htmlid='").append(Util.escapeStringForXml(((anm)localObject1).SyO)).append("'");
      }
      if (((anm)localObject1).SyV) {
        localStringBuffer.append(" dataillegaltype='").append(((anm)localObject1).SyU).append("'");
      }
      if (((anm)localObject1).Syv) {
        localStringBuffer.append(" datasourceid='").append(((anm)localObject1).Syu).append("'");
      }
      localStringBuffer.append(">");
      if (((anm)localObject1).Syd) {
        localStringBuffer.append("<datafmt>").append(((anm)localObject1).Syc).append("</datafmt>");
      }
      if (((anm)localObject1).SxH) {
        localStringBuffer.append("<datatitle>").append(Util.escapeStringForXml(((anm)localObject1).title)).append("</datatitle>");
      }
      if (((anm)localObject1).SxI) {
        localStringBuffer.append("<datadesc>").append(Util.escapeStringForXml(((anm)localObject1).desc)).append("</datadesc>");
      }
      if (((anm)localObject1).SxJ) {
        localStringBuffer.append("<cdn_thumburl>").append(Util.escapeStringForXml(((anm)localObject1).lmm)).append("</cdn_thumburl>");
      }
      if (((anm)localObject1).SxM) {
        localStringBuffer.append("<thumb_width>").append(((anm)localObject1).thumbWidth).append("</thumb_width>");
      }
      if (((anm)localObject1).SxN) {
        localStringBuffer.append("<thumb_height>").append(((anm)localObject1).thumbHeight).append("</thumb_height>");
      }
      if (((anm)localObject1).SxO) {
        localStringBuffer.append("<cdn_dataurl>").append(Util.escapeStringForXml(((anm)localObject1).Rwb)).append("</cdn_dataurl>");
      }
      if (((anm)localObject1).SxL) {
        localStringBuffer.append("<cdn_thumbkey>").append(Util.escapeStringForXml(((anm)localObject1).SxK)).append("</cdn_thumbkey>");
      }
      if (((anm)localObject1).SxQ) {
        localStringBuffer.append("<cdn_datakey>").append(Util.escapeStringForXml(((anm)localObject1).SxP)).append("</cdn_datakey>");
      }
      if (((anm)localObject1).SxS) {
        localStringBuffer.append("<cdn_encryver>").append(((anm)localObject1).SxR).append("</cdn_encryver>");
      }
      if (((anm)localObject1).SxT) {
        localStringBuffer.append("<duration>").append(((anm)localObject1).duration).append("</duration>");
      }
      if (((anm)localObject1).SxV) {
        localStringBuffer.append("<stream_weburl>").append(Util.escapeStringForXml(((anm)localObject1).SxU)).append("</stream_weburl>");
      }
      if (((anm)localObject1).Szl) {
        localStringBuffer.append("<songalbumurl>").append(Util.escapeStringForXml(((anm)localObject1).songAlbumUrl)).append("</songalbumurl>");
      }
      if (((anm)localObject1).Szm) {
        localStringBuffer.append("<songlyric>").append(Util.escapeStringForXml(((anm)localObject1).songLyric)).append("</songlyric>");
      }
      if (((anm)localObject1).SxX) {
        localStringBuffer.append("<stream_dataurl>").append(Util.escapeStringForXml(((anm)localObject1).SxW)).append("</stream_dataurl>");
      }
      if (((anm)localObject1).SxZ) {
        localStringBuffer.append("<stream_lowbandurl>").append(Util.escapeStringForXml(((anm)localObject1).SxY)).append("</stream_lowbandurl>");
      }
      if (((anm)localObject1).Sya) {
        localStringBuffer.append("<dataext>").append(Util.escapeStringForXml(((anm)localObject1).fyu)).append("</dataext>");
      }
      if (((anm)localObject1).Syf) {
        localStringBuffer.append("<fullmd5>").append(((anm)localObject1).Sye).append("</fullmd5>");
      }
      if (((anm)localObject1).Syh) {
        localStringBuffer.append("<head256md5>").append(((anm)localObject1).Syg).append("</head256md5>");
      }
      if (((anm)localObject1).Syj) {
        localStringBuffer.append("<fullsize>").append(((anm)localObject1).Syi).append("</fullsize>");
      }
      if (((anm)localObject1).Syp) {
        localStringBuffer.append("<thumbfullmd5>").append(((anm)localObject1).Kll).append("</thumbfullmd5>");
      }
      if (((anm)localObject1).Syr) {
        localStringBuffer.append("<thumbhead256md5>").append(((anm)localObject1).Syq).append("</thumbhead256md5>");
      }
      if (((anm)localObject1).Syt) {
        localStringBuffer.append("<thumbfullsize>").append(((anm)localObject1).Sys).append("</thumbfullsize>");
      }
      if (((anm)localObject1).Syx) {
        localStringBuffer.append("<stream_videoid>").append(Util.escapeStringForXml(((anm)localObject1).Syw)).append("</stream_videoid>");
      }
      if (((anm)localObject1).SyF) {
        localStringBuffer.append("<datasrctitle>").append(Util.escapeStringForXml(((anm)localObject1).SyE)).append("</datasrctitle>");
      }
      if (((anm)localObject1).SyJ) {
        localStringBuffer.append("<datasrcname>").append(Util.escapeStringForXml(((anm)localObject1).SyI)).append("</datasrcname>");
      }
      if (((anm)localObject1).SyL) {
        localStringBuffer.append("<datasrctime>").append(Util.escapeStringForXml(((anm)localObject1).SyK)).append("</datasrctime>");
      }
      if ((((anm)localObject1).SyR) && ((((anm)localObject1).SyG == null) || (((anm)localObject1).SyG.Szr == null) || (((anm)localObject1).SyG.Szr.computeSize() == 0))) {
        localStringBuffer.append("<canvasPageXml>").append(Util.escapeStringForXml(((anm)localObject1).canvasPageXml)).append("</canvasPageXml>");
      }
      if (((anm)localObject1).SyQ) {
        localStringBuffer.append("<statextstr>").append(Util.escapeStringForXml(((anm)localObject1).fUk)).append("</statextstr>");
      }
      if (((anm)localObject1).SyX) {
        localStringBuffer.append("<recordxml>").append(((anm)localObject1).SyW).append("</recordxml>");
      }
      if (((anm)localObject1).mie) {
        localStringBuffer.append("<messageuuid>").append(Util.escapeStringForXml(((anm)localObject1).mic)).append("</messageuuid>");
      }
      Object localObject2 = ((anm)localObject1).SyM;
      if (localObject2 != null)
      {
        localStringBuffer.append("<streamvideo>");
        localStringBuffer.append("<streamvideourl>").append(Util.escapeStringForXml(((anp)localObject2).lor)).append("</streamvideourl>");
        localStringBuffer.append("<streamvideototaltime>").append(((anp)localObject2).SAk).append("</streamvideototaltime>");
        localStringBuffer.append("<streamvideotitle>").append(Util.escapeStringForXml(((anp)localObject2).lot)).append("</streamvideotitle>");
        localStringBuffer.append("<streamvideowording>").append(Util.escapeStringForXml(((anp)localObject2).lou)).append("</streamvideowording>");
        localStringBuffer.append("<streamvideoweburl>").append(Util.escapeStringForXml(((anp)localObject2).lov)).append("</streamvideoweburl>");
        localStringBuffer.append("<streamvideoaduxinfo>").append(Util.escapeStringForXml(((anp)localObject2).lox)).append("</streamvideoaduxinfo>");
        localStringBuffer.append("<streamvideopublishid>").append(Util.escapeStringForXml(((anp)localObject2).loy)).append("</streamvideopublishid>");
        localStringBuffer.append("</streamvideo>");
      }
      localObject2 = ((anm)localObject1).SyG;
      if ((localObject2 == null) || (((ann)localObject2).Szn == null) || (((ann)localObject2).Szn.computeSize() == 0))
      {
        Log.v("MicroMsg.FavDataItemParser", "klem toXml, data source item empty");
        label1500:
        localObject2 = ((anm)localObject1).SyG;
        if ((localObject2 != null) && (((ann)localObject2).Szp != null) && (((ann)localObject2).Szp.computeSize() != 0)) {
          break label2213;
        }
        Log.v("MicroMsg.FavDataItemParser", "klem toXml, loc item empty");
        label1539:
        localObject2 = ((anm)localObject1).SyG;
        if ((localObject2 != null) && (((ann)localObject2).Szr != null) && (((ann)localObject2).Szr.computeSize() != 0)) {
          break label2392;
        }
        Log.v("MicroMsg.FavDataItemParser", "klem toXml, url item empty");
        localObject2 = ((anm)localObject1).SyG;
        if ((localObject2 != null) && (((ann)localObject2).SzJ != null)) {
          break label2735;
        }
        Log.i("MicroMsg.FavDataItemParser", "klem toXml, finder item empty");
        label1606:
        localObject2 = ((anm)localObject1).SyG;
        if ((localObject2 != null) && (((ann)localObject2).SzR != null)) {
          break label2751;
        }
        Log.i("MicroMsg.FavDataItemParser", "klem toXml, music item empty");
        label1634:
        localObject2 = ((anm)localObject1).SyG;
        if ((localObject2 != null) && (((ann)localObject2).SzL != null)) {
          break label2767;
        }
        Log.i("MicroMsg.FavDataItemParser", "klem toXml, finder live item empty");
        label1662:
        localObject2 = ((anm)localObject1).SyG;
        if ((localObject2 != null) && (((ann)localObject2).SzV != null)) {
          break label2783;
        }
        Log.i("MicroMsg.FavDataItemParser", "klem toXml, finder activity item empty");
        label1690:
        localObject2 = ((anm)localObject1).SyG;
        if ((localObject2 != null) && (((ann)localObject2).SzT != null)) {
          break label2799;
        }
        Log.i("MicroMsg.FavDataItemParser", "klem toXml, finder topic item empty");
        label1718:
        localObject2 = ((anm)localObject1).SyG;
        if ((localObject2 != null) && (((ann)localObject2).SzH != null)) {
          break label2815;
        }
        Log.d("MicroMsg.FavDataItemParser", "setMpVideoXml toXml, item empty");
        label1746:
        localObject2 = ((anm)localObject1).SyG;
        if ((localObject2 != null) && (((ann)localObject2).Szt != null) && (((ann)localObject2).Szt.computeSize() != 0)) {
          break label2831;
        }
        Log.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
        label1785:
        localObject2 = ((anm)localObject1).SyG;
        if ((localObject2 != null) && (((ann)localObject2).Szv != null) && (((ann)localObject2).Szv.computeSize() != 0)) {
          break label3025;
        }
        Log.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
        label1824:
        localObject1 = ((anm)localObject1).SyG;
        if ((localObject1 != null) && (((ann)localObject1).SzE != null)) {
          break label3183;
        }
        Log.e("MicroMsg.FavDataItemParser", "setAppBrandXml toXml, item empty");
      }
      for (;;)
      {
        localStringBuffer.append("</dataitem>");
        i += 1;
        break;
        localObject2 = ((ann)localObject2).Szn;
        localStringBuffer.append("<dataitemsource");
        if (((ano)localObject2).SzX) {
          localStringBuffer.append(" sourcetype='").append(((ano)localObject2).sourceType).append("'");
        }
        if (((ano)localObject2).SAa) {
          localStringBuffer.append(" sourceid='").append(((ano)localObject2).sourceId).append("'");
        }
        localStringBuffer.append(">");
        if (((ano)localObject2).SzY) {
          localStringBuffer.append("<fromusr>").append(Util.escapeStringForXml(((ano)localObject2).fLi)).append("</fromusr>");
        }
        if (((ano)localObject2).SzZ) {
          localStringBuffer.append("<tousr>").append(Util.escapeStringForXml(((ano)localObject2).toUser)).append("</tousr>");
        }
        if (((ano)localObject2).SAc) {
          localStringBuffer.append("<realchatname>").append(Util.escapeStringForXml(((ano)localObject2).SAb)).append("</realchatname>");
        }
        if (((ano)localObject2).SAd) {
          localStringBuffer.append("<msgid>").append(((ano)localObject2).msgId).append("</msgid>");
        }
        if (((ano)localObject2).SAe) {
          localStringBuffer.append("<eventid>").append(((ano)localObject2).fXM).append("</eventid>");
        }
        if (((ano)localObject2).SAf) {
          localStringBuffer.append("<appid>").append(((ano)localObject2).appId).append("</appid>");
        }
        if (((ano)localObject2).SAg) {
          localStringBuffer.append("<link>").append(Util.escapeStringForXml(((ano)localObject2).link)).append("</link>");
        }
        if (((ano)localObject2).SAj) {
          localStringBuffer.append("<brandid>").append(Util.escapeStringForXml(((ano)localObject2).fuO)).append("</brandid>");
        }
        localStringBuffer.append("</dataitemsource>");
        break label1500;
        label2213:
        localObject2 = ((ann)localObject2).Szp;
        localStringBuffer.append("<locitem>");
        if (((ant)localObject2).SAr) {
          localStringBuffer.append("<label>").append(Util.escapeStringForXml(((ant)localObject2).label)).append("</label>");
        }
        if (((ant)localObject2).SAp) {
          localStringBuffer.append("<lat>").append(((ant)localObject2).lat).append("</lat>");
        }
        if (((ant)localObject2).SAo) {
          localStringBuffer.append("<lng>").append(((ant)localObject2).lng).append("</lng>");
        }
        if (((ant)localObject2).SAq) {
          localStringBuffer.append("<scale>").append(((ant)localObject2).fKJ).append("</scale>");
        }
        if (((ant)localObject2).SAs) {
          localStringBuffer.append("<poiname>").append(((ant)localObject2).fPN).append("</poiname>");
        }
        localStringBuffer.append("</locitem>");
        break label1539;
        label2392:
        aor localaor = ((ann)localObject2).Szr;
        localStringBuffer.append("<weburlitem>");
        if (localaor.SBd) {
          localStringBuffer.append("<clean_url>").append(Util.escapeStringForXml(localaor.SBc)).append("</clean_url>");
        }
        if (localaor.SxI) {
          localStringBuffer.append("<pagedesc>").append(Util.escapeStringForXml(localaor.desc)).append("</pagedesc>");
        }
        if (localaor.SAy) {
          localStringBuffer.append("<pagethumb_url>").append(Util.escapeStringForXml(localaor.thumbUrl)).append("</pagethumb_url>");
        }
        if (localaor.SxH) {
          localStringBuffer.append("<pagetitle>").append(Util.escapeStringForXml(localaor.title)).append("</pagetitle>");
        }
        if (localaor.SBf) {
          localStringBuffer.append("<opencache>").append(localaor.SBe).append("</opencache>");
        }
        if (localaor.SBg) {
          localStringBuffer.append("<contentattr>").append(localaor.contentattr).append("</contentattr>");
        }
        if (localaor.SyR) {
          localStringBuffer.append("<canvasPageXml>").append(Util.escapeStringForXml(localaor.canvasPageXml)).append("</canvasPageXml>");
        }
        if (localaor.SBi) {
          localStringBuffer.append("<wsVideoFlowXml>").append(Util.escapeStringForXml(localaor.SBh)).append("</wsVideoFlowXml>");
        }
        localStringBuffer.append("<forwardflag>").append(localaor.mjT).append("</forwardflag>");
        if ((localObject2 == null) || (((ann)localObject2).PTL == null)) {
          Log.d("MicroMsg.FavDataItemParser", "setMpMsgXml toXml, item empty");
        }
        for (;;)
        {
          localStringBuffer.append("</weburlitem>");
          break;
          localStringBuffer.append(b.a(((ann)localObject2).PTL));
        }
        label2735:
        localStringBuffer.append(k.b(((ann)localObject2).SzJ));
        break label1606;
        label2751:
        localStringBuffer.append(am.a(((ann)localObject2).SzR));
        break label1634;
        label2767:
        localStringBuffer.append(k.c(((ann)localObject2).SzL));
        break label1662;
        label2783:
        localStringBuffer.append(k.b(((ann)localObject2).SzV));
        break label1690;
        label2799:
        localStringBuffer.append(k.b(((ann)localObject2).SzT));
        break label1718;
        label2815:
        localStringBuffer.append(b.b(((ann)localObject2).SzH));
        break label1746;
        label2831:
        localObject2 = ((ann)localObject2).Szt;
        localStringBuffer.append("<productitem");
        if (((aob)localObject2).SAA) {
          localStringBuffer.append(" type='").append(((aob)localObject2).type).append("'");
        }
        localStringBuffer.append(">");
        if (((aob)localObject2).SxH) {
          localStringBuffer.append("<producttitle>").append(Util.escapeStringForXml(((aob)localObject2).title)).append("</producttitle>");
        }
        if (((aob)localObject2).SxI) {
          localStringBuffer.append("<productdesc>").append(Util.escapeStringForXml(((aob)localObject2).desc)).append("</productdesc>");
        }
        if (((aob)localObject2).SAy) {
          localStringBuffer.append("<productthumb_url>").append(Util.escapeStringForXml(((aob)localObject2).thumbUrl)).append("</productthumb_url>");
        }
        if (((aob)localObject2).SAz) {
          localStringBuffer.append("<productinfo>").append(Util.escapeStringForXml(((aob)localObject2).fTp)).append("</productinfo>");
        }
        localStringBuffer.append("</productitem>");
        break label1785;
        label3025:
        localObject2 = ((ann)localObject2).Szv;
        localStringBuffer.append("<tvitem>");
        if (((aol)localObject2).SxH) {
          localStringBuffer.append("<tvtitle>").append(Util.escapeStringForXml(((aol)localObject2).title)).append("</tvtitle>");
        }
        if (((aol)localObject2).SxI) {
          localStringBuffer.append("<tvdesc>").append(Util.escapeStringForXml(((aol)localObject2).desc)).append("</tvdesc>");
        }
        if (((aol)localObject2).SAy) {
          localStringBuffer.append("<tvthumb_url>").append(Util.escapeStringForXml(((aol)localObject2).thumbUrl)).append("</tvthumb_url>");
        }
        if (((aol)localObject2).SAz) {
          localStringBuffer.append("<tvinfo>").append(Util.escapeStringForXml(((aol)localObject2).fTp)).append("</tvinfo>");
        }
        localStringBuffer.append("</tvitem>");
        break label1824;
        label3183:
        localObject1 = ((ann)localObject1).SzE;
        if (localObject1 != null)
        {
          localStringBuffer.append("<appbranditem>");
          localStringBuffer.append("<username>").append(Util.escapeStringForXml(((ank)localObject1).username)).append("</username>");
          localStringBuffer.append("<appid>").append(Util.escapeStringForXml(((ank)localObject1).appId)).append("</appid>");
          localStringBuffer.append("<pkgtype>").append(((ank)localObject1).fES).append("</pkgtype>");
          localStringBuffer.append("<iconurl>").append(Util.escapeStringForXml(((ank)localObject1).iconUrl)).append("</iconurl>");
          localStringBuffer.append("<type>").append(((ank)localObject1).type).append("</type>");
          localStringBuffer.append("<pagepath>").append(Util.escapeStringForXml(((ank)localObject1).fve)).append("</pagepath>");
          localStringBuffer.append("<sourcedisplayname>").append(Util.escapeStringForXml(((ank)localObject1).SxE)).append("</sourcedisplayname>");
          localStringBuffer.append("<version>").append(((ank)localObject1).version).append("</version>");
          localStringBuffer.append("<disableforward>").append(((ank)localObject1).otE).append("</disableforward>");
          localStringBuffer.append("<tradingguaranteeflag>").append(((ank)localObject1).nYp).append("</tradingguaranteeflag>");
          localStringBuffer.append("<messageextradata>").append(String.format("<![CDATA[%s]]>", new Object[] { ((ank)localObject1).fXg })).append("</messageextradata>");
          localStringBuffer.append("<subtype>").append(((ank)localObject1).subType).append("</subtype>");
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