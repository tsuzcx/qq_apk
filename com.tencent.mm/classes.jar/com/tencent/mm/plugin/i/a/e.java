package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class e
{
  public static String a(ark paramark)
  {
    AppMethodBeat.i(164042);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramark != null)
    {
      localStringBuilder.append("<finderTopic><topic>").append(bt.aRc(paramark.dzZ)).append("</topic><topicType>").append(paramark.sMj).append("</topicType><iconUrl>").append(bw.aRy(paramark.iconUrl)).append("</iconUrl><desc>").append(bt.aRc(paramark.desc)).append("</desc>");
      if (paramark.Gpj != null) {
        localStringBuilder.append("<location><poiClassifyId>").append(bt.aRc(paramark.Gpj.Gnu)).append("</poiClassifyId><longitude>").append(paramark.Gpj.dAp).append("</longitude><latitude>").append(paramark.Gpj.dyz).append("</latitude></location>");
      }
      localStringBuilder.append("</finderTopic>");
    }
    paramark = localStringBuilder.toString();
    AppMethodBeat.o(164042);
    return paramark;
  }
  
  public static String b(arj paramarj)
  {
    AppMethodBeat.i(164040);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramarj != null) {
      try
      {
        localStringBuilder.append("<finderFeed><objectId>").append(paramarj.objectId).append("</objectId><objectNonceId>").append(paramarj.objectNonceId).append("</objectNonceId><feedType>").append(paramarj.Gpi).append("</feedType><nickname>").append(bt.aRc(paramarj.nickname)).append("</nickname><username>").append(bt.aRc(paramarj.username)).append("</username><avatar>").append(bw.aRy(paramarj.sjU)).append("</avatar><desc>").append(bt.aRc(paramarj.desc)).append("</desc><mediaCount>").append(paramarj.dqU).append("</mediaCount>");
        localStringBuilder.append("<mediaList>");
        paramarj = paramarj.mediaList.iterator();
        while (paramarj.hasNext())
        {
          ari localari = (ari)paramarj.next();
          localStringBuilder.append("<media><mediaType>").append(localari.mediaType).append("</mediaType><url>").append(bw.aRy(localari.url)).append("</url><thumbUrl>").append(bw.aRy(localari.thumbUrl)).append("</thumbUrl><width>").append(localari.width).append("</width><height>").append(localari.height).append("</height><videoPlayDuration>").append(localari.Gph).append("</videoPlayDuration></media>");
          continue;
          paramarj = localStringBuilder.toString();
        }
      }
      catch (Exception paramarj)
      {
        ad.e("MicroMsg.FinderShareParser", "make content error! %s", new Object[] { paramarj.getMessage() });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(164040);
      return paramarj;
      localStringBuilder.append("</mediaList>");
      localStringBuilder.append("</finderFeed>");
    }
  }
  
  public static arj v(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164041);
    arj localarj = new arj();
    try
    {
      String str = paramString + ".finderFeed";
      int i;
      ari localari;
      if ((!paramMap.isEmpty()) && (paramMap.containsKey(str + ".objectId")))
      {
        localarj.objectId = bt.nullAsNil((String)paramMap.get(str + ".objectId"));
        localarj.objectNonceId = bt.nullAsNil((String)paramMap.get(str + ".objectNonceId"));
        localarj.Gpi = bt.aRe((String)paramMap.get(str + ".feedType"));
        localarj.nickname = bt.nullAsNil((String)paramMap.get(str + ".nickname"));
        localarj.username = bt.nullAsNil((String)paramMap.get(str + ".username"));
        localarj.sjU = bt.nullAsNil((String)paramMap.get(str + ".avatar"));
        localarj.desc = bt.nullAsNil((String)paramMap.get(str + ".desc"));
        localarj.dqU = bt.aRe((String)paramMap.get(str + ".mediaCount"));
        i = 0;
        if (i < localarj.dqU)
        {
          localari = new ari();
          paramString = str + ".mediaList.media";
          if (i <= 0) {
            break label695;
          }
          paramString = paramString + i;
        }
      }
      for (;;)
      {
        localari.mediaType = bt.aRe((String)paramMap.get(paramString + ".mediaType"));
        localari.url = bt.nullAsNil((String)paramMap.get(paramString + ".url"));
        localari.thumbUrl = bt.nullAsNil((String)paramMap.get(paramString + ".thumbUrl"));
        localari.width = bt.aRh((String)paramMap.get(paramString + ".width"));
        localari.height = bt.aRh((String)paramMap.get(paramString + ".height"));
        localari.Gph = bt.aRe((String)paramMap.get(paramString + ".videoPlayDuration"));
        localarj.mediaList.add(localari);
        i += 1;
        break;
      }
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.FinderShareParser", "parse error! %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(164041);
      return localarj;
    }
  }
  
  public static ark w(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164043);
    ark localark = new ark();
    paramString = paramString + ".finderTopic";
    arh localarh;
    if (!paramMap.isEmpty())
    {
      localark.dzZ = bt.nullAsNil((String)paramMap.get(paramString + ".topic"));
      localark.sMj = bt.getInt((String)paramMap.get(paramString + ".topicType"), -1);
      localark.iconUrl = bt.nullAsNil((String)paramMap.get(paramString + ".iconUrl"));
      localark.desc = bt.nullAsNil((String)paramMap.get(paramString + ".desc"));
      localarh = new arh();
      localarh.Gnu = ((String)paramMap.get(paramString + ".location.poiClassifyId"));
      localarh.dAp = bt.getFloat((String)paramMap.get(paramString + ".location.longitude"), 0.0F);
      localarh.dyz = bt.getFloat((String)paramMap.get(paramString + ".location.latitude"), 0.0F);
    }
    for (localark.Gpj = localarh;; localark.Gpj = new arh())
    {
      AppMethodBeat.o(164043);
      return localark;
      localark.dzZ = "";
      localark.sMj = -1;
      localark.iconUrl = "";
      localark.desc = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.e
 * JD-Core Version:    0.7.0.1
 */