package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.alb;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class d
{
  public static String a(ald paramald)
  {
    AppMethodBeat.i(164040);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramald != null) {
      try
      {
        localStringBuilder.append("<finderFeed><objectId>").append(paramald.objectId).append("</objectId><objectNonceId>").append(paramald.objectNonceId).append("</objectNonceId><feedType>").append(paramald.Dmx).append("</feedType><nickname>").append(bt.aGf(paramald.nickname)).append("</nickname><avatar>").append(bw.aGA(paramald.qDs)).append("</avatar><desc>").append(bt.aGf(paramald.desc)).append("</desc><mediaCount>").append(paramald.did).append("</mediaCount>");
        localStringBuilder.append("<mediaList>");
        paramald = paramald.mediaList.iterator();
        while (paramald.hasNext())
        {
          alc localalc = (alc)paramald.next();
          localStringBuilder.append("<media><mediaType>").append(localalc.mediaType).append("</mediaType><url>").append(bw.aGA(localalc.url)).append("</url><thumbUrl>").append(bw.aGA(localalc.thumbUrl)).append("</thumbUrl><width>").append(localalc.width).append("</width><height>").append(localalc.height).append("</height></media>");
          continue;
          paramald = localStringBuilder.toString();
        }
      }
      catch (Exception paramald)
      {
        ad.e("MicroMsg.FinderShareParser", "make content error! %s", new Object[] { paramald.getMessage() });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(164040);
      return paramald;
      localStringBuilder.append("</mediaList>");
      localStringBuilder.append("</finderFeed>");
    }
  }
  
  public static String a(ale paramale)
  {
    AppMethodBeat.i(164042);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramale != null)
    {
      localStringBuilder.append("<finderTopic><topic>").append(bt.aGf(paramale.dqA)).append("</topic><topicType>").append(paramale.qSS).append("</topicType><iconUrl>").append(bw.aGA(paramale.iconUrl)).append("</iconUrl><desc>").append(bt.aGf(paramale.desc)).append("</desc>");
      if (paramale.Dmy != null) {
        localStringBuilder.append("<location><poiClassifyId>").append(bt.aGf(paramale.Dmy.DlE)).append("</poiClassifyId><longitude>").append(paramale.Dmy.dqQ).append("</longitude><latitude>").append(paramale.Dmy.dpb).append("</latitude></location>");
      }
      localStringBuilder.append("</finderTopic>");
    }
    paramale = localStringBuilder.toString();
    AppMethodBeat.o(164042);
    return paramale;
  }
  
  public static ald s(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164041);
    ald localald = new ald();
    try
    {
      String str = paramString + ".finderFeed";
      int i;
      alc localalc;
      if ((!paramMap.isEmpty()) && (paramMap.containsKey(str + ".objectId")))
      {
        localald.objectId = bt.nullAsNil((String)paramMap.get(str + ".objectId"));
        localald.objectNonceId = bt.nullAsNil((String)paramMap.get(str + ".objectNonceId"));
        localald.Dmx = bt.aGh((String)paramMap.get(str + ".feedType"));
        localald.nickname = bt.nullAsNil((String)paramMap.get(str + ".nickname"));
        localald.qDs = bt.nullAsNil((String)paramMap.get(str + ".avatar"));
        localald.desc = bt.nullAsNil((String)paramMap.get(str + ".desc"));
        localald.did = bt.aGh((String)paramMap.get(str + ".mediaCount"));
        i = 0;
        if (i < localald.did)
        {
          localalc = new alc();
          paramString = str + ".mediaList.media";
          if (i <= 0) {
            break label616;
          }
          paramString = paramString + i;
        }
      }
      for (;;)
      {
        localalc.mediaType = bt.aGh((String)paramMap.get(paramString + ".mediaType"));
        localalc.url = bt.nullAsNil((String)paramMap.get(paramString + ".url"));
        localalc.thumbUrl = bt.nullAsNil((String)paramMap.get(paramString + ".thumbUrl"));
        localalc.width = bt.aGk((String)paramMap.get(paramString + ".width"));
        localalc.height = bt.aGk((String)paramMap.get(paramString + ".height"));
        localald.mediaList.add(localalc);
        i += 1;
        break;
      }
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.FinderShareParser", "parse error! %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(164041);
      return localald;
    }
  }
  
  public static ale t(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164043);
    ale localale = new ale();
    paramString = paramString + ".finderTopic";
    alb localalb;
    if (!paramMap.isEmpty())
    {
      localale.dqA = bt.nullAsNil((String)paramMap.get(paramString + ".topic"));
      localale.qSS = bt.getInt((String)paramMap.get(paramString + ".topicType"), -1);
      localale.iconUrl = bt.nullAsNil((String)paramMap.get(paramString + ".iconUrl"));
      localale.desc = bt.nullAsNil((String)paramMap.get(paramString + ".desc"));
      localalb = new alb();
      localalb.DlE = ((String)paramMap.get(paramString + ".location.poiClassifyId"));
      localalb.dqQ = bt.getFloat((String)paramMap.get(paramString + ".location.longitude"), 0.0F);
      localalb.dpb = bt.getFloat((String)paramMap.get(paramString + ".location.latitude"), 0.0F);
    }
    for (localale.Dmy = localalb;; localale.Dmy = new alb())
    {
      AppMethodBeat.o(164043);
      return localale;
      localale.dqA = "";
      localale.qSS = -1;
      localale.iconUrl = "";
      localale.desc = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.d
 * JD-Core Version:    0.7.0.1
 */