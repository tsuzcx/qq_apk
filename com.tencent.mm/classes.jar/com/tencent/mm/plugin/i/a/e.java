package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.anv;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class e
{
  public static String a(any paramany)
  {
    AppMethodBeat.i(164042);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramany != null)
    {
      localStringBuilder.append("<finderTopic><topic>").append(bs.aLw(paramany.dol)).append("</topic><topicType>").append(paramany.rPI).append("</topicType><iconUrl>").append(bv.aLR(paramany.iconUrl)).append("</iconUrl><desc>").append(bs.aLw(paramany.desc)).append("</desc>");
      if (paramany.EGK != null) {
        localStringBuilder.append("<location><poiClassifyId>").append(bs.aLw(paramany.EGK.EFm)).append("</poiClassifyId><longitude>").append(paramany.EGK.doB).append("</longitude><latitude>").append(paramany.EGK.dmL).append("</latitude></location>");
      }
      localStringBuilder.append("</finderTopic>");
    }
    paramany = localStringBuilder.toString();
    AppMethodBeat.o(164042);
    return paramany;
  }
  
  public static String b(anx paramanx)
  {
    AppMethodBeat.i(164040);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramanx != null) {
      try
      {
        localStringBuilder.append("<finderFeed><objectId>").append(paramanx.objectId).append("</objectId><objectNonceId>").append(paramanx.objectNonceId).append("</objectNonceId><feedType>").append(paramanx.EGJ).append("</feedType><nickname>").append(bs.aLw(paramanx.nickname)).append("</nickname><avatar>").append(bv.aLR(paramanx.ruB)).append("</avatar><desc>").append(bs.aLw(paramanx.desc)).append("</desc><mediaCount>").append(paramanx.dfy).append("</mediaCount>");
        localStringBuilder.append("<mediaList>");
        paramanx = paramanx.mediaList.iterator();
        while (paramanx.hasNext())
        {
          anw localanw = (anw)paramanx.next();
          localStringBuilder.append("<media><mediaType>").append(localanw.mediaType).append("</mediaType><url>").append(bv.aLR(localanw.url)).append("</url><thumbUrl>").append(bv.aLR(localanw.thumbUrl)).append("</thumbUrl><width>").append(localanw.width).append("</width><height>").append(localanw.height).append("</height></media>");
          continue;
          paramanx = localStringBuilder.toString();
        }
      }
      catch (Exception paramanx)
      {
        ac.e("MicroMsg.FinderShareParser", "make content error! %s", new Object[] { paramanx.getMessage() });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(164040);
      return paramanx;
      localStringBuilder.append("</mediaList>");
      localStringBuilder.append("</finderFeed>");
    }
  }
  
  public static anx t(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164041);
    anx localanx = new anx();
    try
    {
      String str = paramString + ".finderFeed";
      int i;
      anw localanw;
      if ((!paramMap.isEmpty()) && (paramMap.containsKey(str + ".objectId")))
      {
        localanx.objectId = bs.nullAsNil((String)paramMap.get(str + ".objectId"));
        localanx.objectNonceId = bs.nullAsNil((String)paramMap.get(str + ".objectNonceId"));
        localanx.EGJ = bs.aLy((String)paramMap.get(str + ".feedType"));
        localanx.nickname = bs.nullAsNil((String)paramMap.get(str + ".nickname"));
        localanx.ruB = bs.nullAsNil((String)paramMap.get(str + ".avatar"));
        localanx.desc = bs.nullAsNil((String)paramMap.get(str + ".desc"));
        localanx.dfy = bs.aLy((String)paramMap.get(str + ".mediaCount"));
        i = 0;
        if (i < localanx.dfy)
        {
          localanw = new anw();
          paramString = str + ".mediaList.media";
          if (i <= 0) {
            break label616;
          }
          paramString = paramString + i;
        }
      }
      for (;;)
      {
        localanw.mediaType = bs.aLy((String)paramMap.get(paramString + ".mediaType"));
        localanw.url = bs.nullAsNil((String)paramMap.get(paramString + ".url"));
        localanw.thumbUrl = bs.nullAsNil((String)paramMap.get(paramString + ".thumbUrl"));
        localanw.width = bs.aLB((String)paramMap.get(paramString + ".width"));
        localanw.height = bs.aLB((String)paramMap.get(paramString + ".height"));
        localanx.mediaList.add(localanw);
        i += 1;
        break;
      }
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.FinderShareParser", "parse error! %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(164041);
      return localanx;
    }
  }
  
  public static any u(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164043);
    any localany = new any();
    paramString = paramString + ".finderTopic";
    anv localanv;
    if (!paramMap.isEmpty())
    {
      localany.dol = bs.nullAsNil((String)paramMap.get(paramString + ".topic"));
      localany.rPI = bs.getInt((String)paramMap.get(paramString + ".topicType"), -1);
      localany.iconUrl = bs.nullAsNil((String)paramMap.get(paramString + ".iconUrl"));
      localany.desc = bs.nullAsNil((String)paramMap.get(paramString + ".desc"));
      localanv = new anv();
      localanv.EFm = ((String)paramMap.get(paramString + ".location.poiClassifyId"));
      localanv.doB = bs.getFloat((String)paramMap.get(paramString + ".location.longitude"), 0.0F);
      localanv.dmL = bs.getFloat((String)paramMap.get(paramString + ".location.latitude"), 0.0F);
    }
    for (localany.EGK = localanv;; localany.EGK = new anv())
    {
      AppMethodBeat.o(164043);
      return localany;
      localany.dol = "";
      localany.rPI = -1;
      localany.iconUrl = "";
      localany.desc = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.e
 * JD-Core Version:    0.7.0.1
 */