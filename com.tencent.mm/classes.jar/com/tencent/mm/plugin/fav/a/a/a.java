package com.tencent.mm.plugin.fav.a.a;

import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.xx;
import com.tencent.mm.protocal.c.xy;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.protocal.c.ys;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public final class a
{
  public static String bo(List<xv> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      y.v("MicroMsg.FavDataItemParser", "klem toXml data list empty");
      return "";
    }
    int j = paramList.size();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("<datalist count='").append(j).append("'>");
    int i = 0;
    if (i < j)
    {
      Object localObject1 = (xv)paramList.get(i);
      localStringBuffer.append("<dataitem ");
      if (((xv)localObject1).sUU) {
        localStringBuffer.append("datatype='").append(((xv)localObject1).aYU).append("'");
      }
      if (((xv)localObject1).sVx) {
        localStringBuffer.append(" datastatus='").append(((xv)localObject1).sVw).append("'");
      }
      if (((xv)localObject1).sVd) {
        localStringBuffer.append(" dataid='").append(((xv)localObject1).kgC).append("'");
      }
      if (((xv)localObject1).sVJ) {
        localStringBuffer.append(" htmlid='").append(bk.ZP(((xv)localObject1).sVI)).append("'");
      }
      if (((xv)localObject1).sVP) {
        localStringBuffer.append(" dataillegaltype='").append(((xv)localObject1).sVO).append("'");
      }
      if (((xv)localObject1).sVp) {
        localStringBuffer.append(" datasourceid='").append(((xv)localObject1).sVo).append("'");
      }
      localStringBuffer.append(">");
      if (((xv)localObject1).sUW) {
        localStringBuffer.append("<datafmt>").append(((xv)localObject1).sUV).append("</datafmt>");
      }
      if (((xv)localObject1).sUz) {
        localStringBuffer.append("<datatitle>").append(bk.ZP(((xv)localObject1).title)).append("</datatitle>");
      }
      if (((xv)localObject1).sUA) {
        localStringBuffer.append("<datadesc>").append(bk.ZP(((xv)localObject1).desc)).append("</datadesc>");
      }
      if (((xv)localObject1).sUB) {
        localStringBuffer.append("<cdn_thumburl>").append(bk.ZP(((xv)localObject1).dQL)).append("</cdn_thumburl>");
      }
      if (((xv)localObject1).sUE) {
        localStringBuffer.append("<thumb_width>").append(((xv)localObject1).dQQ).append("</thumb_width>");
      }
      if (((xv)localObject1).sUF) {
        localStringBuffer.append("<thumb_height>").append(((xv)localObject1).dQP).append("</thumb_height>");
      }
      if (((xv)localObject1).sUH) {
        localStringBuffer.append("<cdn_dataurl>").append(bk.ZP(((xv)localObject1).sUG)).append("</cdn_dataurl>");
      }
      if (((xv)localObject1).sUD) {
        localStringBuffer.append("<cdn_thumbkey>").append(bk.ZP(((xv)localObject1).sUC)).append("</cdn_thumbkey>");
      }
      if (((xv)localObject1).sUJ) {
        localStringBuffer.append("<cdn_datakey>").append(bk.ZP(((xv)localObject1).sUI)).append("</cdn_datakey>");
      }
      if (((xv)localObject1).sUL) {
        localStringBuffer.append("<cdn_encryver>").append(((xv)localObject1).sUK).append("</cdn_encryver>");
      }
      if (((xv)localObject1).sUM) {
        localStringBuffer.append("<duration>").append(((xv)localObject1).duration).append("</duration>");
      }
      if (((xv)localObject1).sUO) {
        localStringBuffer.append("<stream_weburl>").append(bk.ZP(((xv)localObject1).sUN)).append("</stream_weburl>");
      }
      if (((xv)localObject1).sUQ) {
        localStringBuffer.append("<stream_dataurl>").append(bk.ZP(((xv)localObject1).sUP)).append("</stream_dataurl>");
      }
      if (((xv)localObject1).sUS) {
        localStringBuffer.append("<stream_lowbandurl>").append(bk.ZP(((xv)localObject1).sUR)).append("</stream_lowbandurl>");
      }
      if (((xv)localObject1).sUT) {
        localStringBuffer.append("<dataext>").append(bk.ZP(((xv)localObject1).bIm)).append("</dataext>");
      }
      if (((xv)localObject1).sUY) {
        localStringBuffer.append("<fullmd5>").append(((xv)localObject1).sUX).append("</fullmd5>");
      }
      if (((xv)localObject1).sVa) {
        localStringBuffer.append("<head256md5>").append(((xv)localObject1).sUZ).append("</head256md5>");
      }
      if (((xv)localObject1).sVc) {
        localStringBuffer.append("<fullsize>").append(((xv)localObject1).sVb).append("</fullsize>");
      }
      if (((xv)localObject1).sVj) {
        localStringBuffer.append("<thumbfullmd5>").append(((xv)localObject1).sVi).append("</thumbfullmd5>");
      }
      if (((xv)localObject1).sVl) {
        localStringBuffer.append("<thumbhead256md5>").append(((xv)localObject1).sVk).append("</thumbhead256md5>");
      }
      if (((xv)localObject1).sVn) {
        localStringBuffer.append("<thumbfullsize>").append(((xv)localObject1).sVm).append("</thumbfullsize>");
      }
      if (((xv)localObject1).sVr) {
        localStringBuffer.append("<stream_videoid>").append(bk.ZP(((xv)localObject1).sVq)).append("</stream_videoid>");
      }
      if (((xv)localObject1).sVz) {
        localStringBuffer.append("<datasrctitle>").append(bk.ZP(((xv)localObject1).sVy)).append("</datasrctitle>");
      }
      if (((xv)localObject1).sVD) {
        localStringBuffer.append("<datasrcname>").append(bk.ZP(((xv)localObject1).sVC)).append("</datasrcname>");
      }
      if (((xv)localObject1).sVF) {
        localStringBuffer.append("<datasrctime>").append(bk.ZP(((xv)localObject1).sVE)).append("</datasrctime>");
      }
      if ((((xv)localObject1).sVL) && ((((xv)localObject1).sVA == null) || (((xv)localObject1).sVA.sWh == null) || (((xv)localObject1).sVA.sWh.btq() == 0))) {
        localStringBuffer.append("<canvasPageXml>").append(bk.ZP(((xv)localObject1).canvasPageXml)).append("</canvasPageXml>");
      }
      if (((xv)localObject1).sVK) {
        localStringBuffer.append("<statextstr>").append(bk.ZP(((xv)localObject1).bYN)).append("</statextstr>");
      }
      if (((xv)localObject1).sVR) {
        localStringBuffer.append("<recordxml>").append(((xv)localObject1).sVQ).append("</recordxml>");
      }
      Object localObject2 = ((xv)localObject1).sVG;
      if (localObject2 != null)
      {
        localStringBuffer.append("<streamvideo>");
        localStringBuffer.append("<streamvideourl>").append(bk.ZP(((xy)localObject2).dSP)).append("</streamvideourl>");
        localStringBuffer.append("<streamvideototaltime>").append(((xy)localObject2).sWK).append("</streamvideototaltime>");
        localStringBuffer.append("<streamvideotitle>").append(bk.ZP(((xy)localObject2).dSR)).append("</streamvideotitle>");
        localStringBuffer.append("<streamvideowording>").append(bk.ZP(((xy)localObject2).dSS)).append("</streamvideowording>");
        localStringBuffer.append("<streamvideoweburl>").append(bk.ZP(((xy)localObject2).dST)).append("</streamvideoweburl>");
        localStringBuffer.append("<streamvideoaduxinfo>").append(bk.ZP(((xy)localObject2).dSV)).append("</streamvideoaduxinfo>");
        localStringBuffer.append("<streamvideopublishid>").append(bk.ZP(((xy)localObject2).dSW)).append("</streamvideopublishid>");
        localStringBuffer.append("</streamvideo>");
      }
      localObject2 = ((xv)localObject1).sVA;
      if ((localObject2 == null) || (((xw)localObject2).sWd == null) || (((xw)localObject2).sWd.btq() == 0))
      {
        y.v("MicroMsg.FavDataItemParser", "klem toXml, data source item empty");
        label1389:
        localObject2 = ((xv)localObject1).sVA;
        if ((localObject2 != null) && (((xw)localObject2).sWf != null) && (((xw)localObject2).sWf.btq() != 0)) {
          break label1934;
        }
        y.v("MicroMsg.FavDataItemParser", "klem toXml, loc item empty");
        label1428:
        localObject2 = ((xv)localObject1).sVA;
        if ((localObject2 != null) && (((xw)localObject2).sWh != null) && (((xw)localObject2).sWh.btq() != 0)) {
          break label2113;
        }
        y.v("MicroMsg.FavDataItemParser", "klem toXml, url item empty");
        label1467:
        localObject2 = ((xv)localObject1).sVA;
        if ((localObject2 != null) && (((xw)localObject2).sWj != null) && (((xw)localObject2).sWj.btq() != 0)) {
          break label2364;
        }
        y.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
        label1506:
        localObject2 = ((xv)localObject1).sVA;
        if ((localObject2 != null) && (((xw)localObject2).sWl != null) && (((xw)localObject2).sWl.btq() != 0)) {
          break label2558;
        }
        y.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
        label1545:
        localObject1 = ((xv)localObject1).sVA;
        if ((localObject1 != null) && (((xw)localObject1).sWu != null)) {
          break label2716;
        }
        y.e("MicroMsg.FavDataItemParser", "setAppBrandXml toXml, item empty");
      }
      for (;;)
      {
        localStringBuffer.append("</dataitem>");
        i += 1;
        break;
        localObject2 = ((xw)localObject2).sWd;
        localStringBuffer.append("<dataitemsource");
        if (((xx)localObject2).sWw) {
          localStringBuffer.append(" sourcetype='").append(((xx)localObject2).bIl).append("'");
        }
        if (((xx)localObject2).sWA) {
          localStringBuffer.append(" sourceid='").append(((xx)localObject2).sWz).append("'");
        }
        localStringBuffer.append(">");
        if (((xx)localObject2).sWx) {
          localStringBuffer.append("<fromusr>").append(bk.ZP(((xx)localObject2).bRO)).append("</fromusr>");
        }
        if (((xx)localObject2).sWy) {
          localStringBuffer.append("<tousr>").append(bk.ZP(((xx)localObject2).toUser)).append("</tousr>");
        }
        if (((xx)localObject2).sWC) {
          localStringBuffer.append("<realchatname>").append(bk.ZP(((xx)localObject2).sWB)).append("</realchatname>");
        }
        if (((xx)localObject2).sWD) {
          localStringBuffer.append("<msgid>").append(((xx)localObject2).bVP).append("</msgid>");
        }
        if (((xx)localObject2).sWE) {
          localStringBuffer.append("<eventid>").append(((xx)localObject2).cbd).append("</eventid>");
        }
        if (((xx)localObject2).sWF) {
          localStringBuffer.append("<appid>").append(((xx)localObject2).appId).append("</appid>");
        }
        if (((xx)localObject2).sWG) {
          localStringBuffer.append("<link>").append(bk.ZP(((xx)localObject2).eAl)).append("</link>");
        }
        if (((xx)localObject2).sWJ) {
          localStringBuffer.append("<brandid>").append(bk.ZP(((xx)localObject2).bFn)).append("</brandid>");
        }
        localStringBuffer.append("</dataitemsource>");
        break label1389;
        label1934:
        localObject2 = ((xw)localObject2).sWf;
        localStringBuffer.append("<locitem>");
        if (((yc)localObject2).sWR) {
          localStringBuffer.append("<label>").append(bk.ZP(((yc)localObject2).label)).append("</label>");
        }
        if (((yc)localObject2).sWP) {
          localStringBuffer.append("<lat>").append(((yc)localObject2).lat).append("</lat>");
        }
        if (((yc)localObject2).sWO) {
          localStringBuffer.append("<lng>").append(((yc)localObject2).lng).append("</lng>");
        }
        if (((yc)localObject2).sWQ) {
          localStringBuffer.append("<scale>").append(((yc)localObject2).bRv).append("</scale>");
        }
        if (((yc)localObject2).sWS) {
          localStringBuffer.append("<poiname>").append(((yc)localObject2).bVA).append("</poiname>");
        }
        localStringBuffer.append("</locitem>");
        break label1428;
        label2113:
        localObject2 = ((xw)localObject2).sWh;
        localStringBuffer.append("<weburlitem>");
        if (((yy)localObject2).sXH) {
          localStringBuffer.append("<clean_url>").append(bk.ZP(((yy)localObject2).sXG)).append("</clean_url>");
        }
        if (((yy)localObject2).sUA) {
          localStringBuffer.append("<pagedesc>").append(bk.ZP(((yy)localObject2).desc)).append("</pagedesc>");
        }
        if (((yy)localObject2).sWX) {
          localStringBuffer.append("<pagethumb_url>").append(bk.ZP(((yy)localObject2).thumbUrl)).append("</pagethumb_url>");
        }
        if (((yy)localObject2).sUz) {
          localStringBuffer.append("<pagetitle>").append(bk.ZP(((yy)localObject2).title)).append("</pagetitle>");
        }
        if (((yy)localObject2).sXJ) {
          localStringBuffer.append("<opencache>").append(((yy)localObject2).sXI).append("</opencache>");
        }
        if (((yy)localObject2).sXK) {
          localStringBuffer.append("<contentattr>").append(((yy)localObject2).dQA).append("</contentattr>");
        }
        if (((yy)localObject2).sVL) {
          localStringBuffer.append("<canvasPageXml>").append(bk.ZP(((yy)localObject2).canvasPageXml)).append("</canvasPageXml>");
        }
        localStringBuffer.append("</weburlitem>");
        break label1467;
        label2364:
        localObject2 = ((xw)localObject2).sWj;
        localStringBuffer.append("<productitem");
        if (((yi)localObject2).sWZ) {
          localStringBuffer.append(" type='").append(((yi)localObject2).type).append("'");
        }
        localStringBuffer.append(">");
        if (((yi)localObject2).sUz) {
          localStringBuffer.append("<producttitle>").append(bk.ZP(((yi)localObject2).title)).append("</producttitle>");
        }
        if (((yi)localObject2).sUA) {
          localStringBuffer.append("<productdesc>").append(bk.ZP(((yi)localObject2).desc)).append("</productdesc>");
        }
        if (((yi)localObject2).sWX) {
          localStringBuffer.append("<productthumb_url>").append(bk.ZP(((yi)localObject2).thumbUrl)).append("</productthumb_url>");
        }
        if (((yi)localObject2).sWY) {
          localStringBuffer.append("<productinfo>").append(bk.ZP(((yi)localObject2).info)).append("</productinfo>");
        }
        localStringBuffer.append("</productitem>");
        break label1506;
        label2558:
        localObject2 = ((xw)localObject2).sWl;
        localStringBuffer.append("<tvitem>");
        if (((ys)localObject2).sUz) {
          localStringBuffer.append("<tvtitle>").append(bk.ZP(((ys)localObject2).title)).append("</tvtitle>");
        }
        if (((ys)localObject2).sUA) {
          localStringBuffer.append("<tvdesc>").append(bk.ZP(((ys)localObject2).desc)).append("</tvdesc>");
        }
        if (((ys)localObject2).sWX) {
          localStringBuffer.append("<tvthumb_url>").append(bk.ZP(((ys)localObject2).thumbUrl)).append("</tvthumb_url>");
        }
        if (((ys)localObject2).sWY) {
          localStringBuffer.append("<tvinfo>").append(bk.ZP(((ys)localObject2).info)).append("</tvinfo>");
        }
        localStringBuffer.append("</tvitem>");
        break label1545;
        label2716:
        localObject1 = ((xw)localObject1).sWu;
        if (localObject1 != null)
        {
          localStringBuffer.append("<appbranditem>");
          localStringBuffer.append("<username>").append(bk.ZP(((xt)localObject1).username)).append("</username>");
          localStringBuffer.append("<appid>").append(bk.ZP(((xt)localObject1).appId)).append("</appid>");
          localStringBuffer.append("<pkgtype>").append(((xt)localObject1).bOa).append("</pkgtype>");
          localStringBuffer.append("<iconurl>").append(bk.ZP(((xt)localObject1).iconUrl)).append("</iconurl>");
          localStringBuffer.append("<type>").append(((xt)localObject1).type).append("</type>");
          localStringBuffer.append("<pagepath>").append(bk.ZP(((xt)localObject1).bFw)).append("</pagepath>");
          localStringBuffer.append("<sourcedisplayname>").append(bk.ZP(((xt)localObject1).sUv)).append("</sourcedisplayname>");
          localStringBuffer.append("</appbranditem>");
        }
      }
    }
    localStringBuffer.append("</datalist>");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.a
 * JD-Core Version:    0.7.0.1
 */