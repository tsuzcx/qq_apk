package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.arw;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.arz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class e
{
  public static String a(arz paramarz)
  {
    AppMethodBeat.i(164042);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramarz != null)
    {
      localStringBuilder.append("<finderTopic><topic>").append(bu.aSz(paramarz.dBe)).append("</topic><topicType>").append(paramarz.sXu).append("</topicType><iconUrl>").append(bx.aSV(paramarz.iconUrl)).append("</iconUrl><desc>").append(bu.aSz(paramarz.desc)).append("</desc>");
      if (paramarz.GIz != null) {
        localStringBuilder.append("<location><poiClassifyId>").append(bu.aSz(paramarz.GIz.GGA)).append("</poiClassifyId><longitude>").append(paramarz.GIz.dBu).append("</longitude><latitude>").append(paramarz.GIz.dzE).append("</latitude></location>");
      }
      localStringBuilder.append("</finderTopic>");
    }
    paramarz = localStringBuilder.toString();
    AppMethodBeat.o(164042);
    return paramarz;
  }
  
  public static String b(ary paramary)
  {
    AppMethodBeat.i(164040);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramary != null) {
      try
      {
        localStringBuilder.append("<finderFeed><objectId>").append(paramary.objectId).append("</objectId><objectNonceId>").append(paramary.objectNonceId).append("</objectNonceId><feedType>").append(paramary.GIy).append("</feedType><nickname>").append(bu.aSz(paramary.nickname)).append("</nickname><username>").append(bu.aSz(paramary.username)).append("</username><avatar>").append(bx.aSV(paramary.ssR)).append("</avatar><desc>").append(bu.aSz(paramary.desc)).append("</desc><mediaCount>").append(paramary.drZ).append("</mediaCount>");
        localStringBuilder.append("<mediaList>");
        paramary = paramary.mediaList.iterator();
        while (paramary.hasNext())
        {
          arx localarx = (arx)paramary.next();
          localStringBuilder.append("<media><mediaType>").append(localarx.mediaType).append("</mediaType><url>").append(bx.aSV(localarx.url)).append("</url><thumbUrl>").append(bx.aSV(localarx.thumbUrl)).append("</thumbUrl><width>").append(localarx.width).append("</width><height>").append(localarx.height).append("</height><videoPlayDuration>").append(localarx.GIx).append("</videoPlayDuration></media>");
          continue;
          paramary = localStringBuilder.toString();
        }
      }
      catch (Exception paramary)
      {
        ae.e("MicroMsg.FinderShareParser", "make content error! %s", new Object[] { paramary.getMessage() });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(164040);
      return paramary;
      localStringBuilder.append("</mediaList>");
      localStringBuilder.append("</finderFeed>");
    }
  }
  
  public static ary w(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164041);
    ary localary = new ary();
    try
    {
      String str = paramString + ".finderFeed";
      int i;
      arx localarx;
      if ((!paramMap.isEmpty()) && (paramMap.containsKey(str + ".objectId")))
      {
        localary.objectId = bu.nullAsNil((String)paramMap.get(str + ".objectId"));
        localary.objectNonceId = bu.nullAsNil((String)paramMap.get(str + ".objectNonceId"));
        localary.GIy = bu.aSB((String)paramMap.get(str + ".feedType"));
        localary.nickname = bu.nullAsNil((String)paramMap.get(str + ".nickname"));
        localary.username = bu.nullAsNil((String)paramMap.get(str + ".username"));
        localary.ssR = bu.nullAsNil((String)paramMap.get(str + ".avatar"));
        localary.desc = bu.nullAsNil((String)paramMap.get(str + ".desc"));
        localary.drZ = bu.aSB((String)paramMap.get(str + ".mediaCount"));
        i = 0;
        if (i < localary.drZ)
        {
          localarx = new arx();
          paramString = str + ".mediaList.media";
          if (i <= 0) {
            break label695;
          }
          paramString = paramString + i;
        }
      }
      for (;;)
      {
        localarx.mediaType = bu.aSB((String)paramMap.get(paramString + ".mediaType"));
        localarx.url = bu.nullAsNil((String)paramMap.get(paramString + ".url"));
        localarx.thumbUrl = bu.nullAsNil((String)paramMap.get(paramString + ".thumbUrl"));
        localarx.width = bu.aSE((String)paramMap.get(paramString + ".width"));
        localarx.height = bu.aSE((String)paramMap.get(paramString + ".height"));
        localarx.GIx = bu.aSB((String)paramMap.get(paramString + ".videoPlayDuration"));
        localary.mediaList.add(localarx);
        i += 1;
        break;
      }
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.FinderShareParser", "parse error! %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(164041);
      return localary;
    }
  }
  
  public static arz x(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164043);
    arz localarz = new arz();
    paramString = paramString + ".finderTopic";
    arw localarw;
    if (!paramMap.isEmpty())
    {
      localarz.dBe = bu.nullAsNil((String)paramMap.get(paramString + ".topic"));
      localarz.sXu = bu.getInt((String)paramMap.get(paramString + ".topicType"), -1);
      localarz.iconUrl = bu.nullAsNil((String)paramMap.get(paramString + ".iconUrl"));
      localarz.desc = bu.nullAsNil((String)paramMap.get(paramString + ".desc"));
      localarw = new arw();
      localarw.GGA = ((String)paramMap.get(paramString + ".location.poiClassifyId"));
      localarw.dBu = bu.getFloat((String)paramMap.get(paramString + ".location.longitude"), 0.0F);
      localarw.dzE = bu.getFloat((String)paramMap.get(paramString + ".location.latitude"), 0.0F);
    }
    for (localarz.GIz = localarw;; localarz.GIz = new arw())
    {
      AppMethodBeat.o(164043);
      return localarz;
      localarz.dBe = "";
      localarz.sXu = -1;
      localarz.iconUrl = "";
      localarz.desc = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.e
 * JD-Core Version:    0.7.0.1
 */