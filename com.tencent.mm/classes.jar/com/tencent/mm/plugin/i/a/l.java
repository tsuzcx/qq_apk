package com.tencent.mm.plugin.i.a;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bcg;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.bck;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class l
{
  public static bcf A(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(196078);
    bcf localbcf = new bcf();
    String str = paramString + ".finderColumn";
    if (!paramMap.isEmpty())
    {
      localbcf.tVe = new b(Base64.decode(Util.nullAsNil((String)paramMap.get(str + ".cardbuffer")), 0));
      paramString = Util.nullAsNil((String)paramMap.get(str + ".iconUrl"));
      Object localObject3 = Util.nullAsNil((String)paramMap.get(str + ".iconUrl_1"));
      Object localObject2 = Util.nullAsNil((String)paramMap.get(str + ".iconUrl_2"));
      Object localObject1 = Util.nullAsNil((String)paramMap.get(str + ".iconUrl_3"));
      paramString = paramString.split("&token");
      localbcf.LLt.add(paramString[0]);
      LinkedList localLinkedList = localbcf.LLu;
      if (paramString.length > 1)
      {
        paramString = "&token" + paramString[1];
        localLinkedList.add(paramString);
        paramString = ((String)localObject3).split("&token");
        localbcf.LLt.add(paramString[0]);
        localObject3 = localbcf.LLu;
        if (paramString.length <= 1) {
          break label564;
        }
        paramString = "&token" + paramString[1];
        label325:
        ((LinkedList)localObject3).add(paramString);
        paramString = ((String)localObject2).split("&token");
        localbcf.LLt.add(paramString[0]);
        localObject2 = localbcf.LLu;
        if (paramString.length <= 1) {
          break label570;
        }
        paramString = "&token" + paramString[1];
        label382:
        ((LinkedList)localObject2).add(paramString);
        paramString = ((String)localObject1).split("&token");
        localbcf.LLt.add(paramString[0]);
        localObject1 = localbcf.LLu;
        if (paramString.length <= 1) {
          break label576;
        }
        paramString = "&token" + paramString[1];
        label439:
        ((LinkedList)localObject1).add(paramString);
        localbcf.cardId = Util.nullAsNil((String)paramMap.get(str + ".cardId"));
        localbcf.title = Util.nullAsNil((String)paramMap.get(str + ".title"));
        localbcf.oqZ = Util.nullAsNil((String)paramMap.get(str + ".secondTitle"));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(196078);
      return localbcf;
      paramString = "";
      break;
      label564:
      paramString = "";
      break label325;
      label570:
      paramString = "";
      break label382;
      label576:
      paramString = "";
      break label439;
      localbcf.cardId = "";
      localbcf.title = "";
      localbcf.oqZ = "";
      localbcf.tVe = null;
    }
  }
  
  public static bck B(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(196081);
    bck localbck = new bck();
    paramString = paramString + ".finderpoirelatedstream";
    if (!paramMap.isEmpty())
    {
      localbck.LLz = Util.nullAsNil((String)paramMap.get(paramString + ".longitudeString"));
      localbck.LLy = Util.nullAsNil((String)paramMap.get(paramString + ".latitudeString"));
      localbck.kHV = Util.nullAsNil((String)paramMap.get(paramString + ".poiName"));
      localbck.LLA = Util.nullAsNil((String)paramMap.get(paramString + ".poiScaleString"));
      localbck.iUO = Util.nullAsNil((String)paramMap.get(paramString + ".address"));
      localbck.JTr = Util.nullAsNil((String)paramMap.get(paramString + ".infoUrl"));
      localbck.LIb = Util.nullAsNil((String)paramMap.get(paramString + ".poiClassifyId"));
    }
    for (localbck.tPa = Util.nullAsNil((String)paramMap.get(paramString + ".poiCategories"));; localbck.tPa = "")
    {
      AppMethodBeat.o(196081);
      return localbck;
      localbck.LLz = "";
      localbck.LLy = "";
      localbck.kHV = "";
      localbck.LLA = "";
      localbck.iUO = "";
      localbck.JTr = "";
      localbck.LIb = "";
    }
  }
  
  public static String a(bcf parambcf)
  {
    AppMethodBeat.i(196077);
    StringBuilder localStringBuilder = new StringBuilder();
    if (parambcf != null) {}
    for (;;)
    {
      int i;
      String str;
      try
      {
        if (!Util.isNullOrNil(parambcf.cardId))
        {
          localStringBuilder.append("<finderColumn><cardId>").append(Util.escapeStringForXml(parambcf.cardId)).append("</cardId><title>").append(Util.escapeStringForXml(parambcf.title)).append("</title><secondTitle>").append(Util.escapeStringForXml(parambcf.oqZ)).append("</secondTitle>");
          i = 0;
          if (i >= parambcf.LLt.size()) {
            break label269;
          }
          str = (String)parambcf.LLt.get(i) + (String)parambcf.LLu.get(i);
          if (i == 0) {
            localStringBuilder.append("<iconUrl>").append(XmlParser.getCDataWrapper(str)).append("</iconUrl>");
          } else if (i == 1) {
            localStringBuilder.append("<iconUrl_1>").append(XmlParser.getCDataWrapper(str)).append("</iconUrl_1>");
          }
        }
      }
      catch (Exception parambcf)
      {
        Log.e("MicroMsg.FinderShareParser", "make content error! %s", new Object[] { parambcf.getMessage() });
      }
      for (;;)
      {
        parambcf = localStringBuilder.toString();
        AppMethodBeat.o(196077);
        return parambcf;
        if (i == 2)
        {
          localStringBuilder.append("<iconUrl_2>").append(XmlParser.getCDataWrapper(str)).append("</iconUrl_2>");
          break;
        }
        if (i != 3) {
          break;
        }
        localStringBuilder.append("<iconUrl_3>").append(XmlParser.getCDataWrapper(str)).append("</iconUrl_3>");
        break;
        label269:
        if (parambcf.tVe != null)
        {
          parambcf = new String(Base64.encode(parambcf.tVe.toByteArray(), 0));
          localStringBuilder.append("<cardbuffer>").append(XmlParser.getCDataWrapper(parambcf)).append("</cardbuffer>");
        }
        localStringBuilder.append("</finderColumn>");
      }
      i += 1;
    }
  }
  
  public static String a(bck parambck)
  {
    AppMethodBeat.i(196080);
    StringBuilder localStringBuilder = new StringBuilder();
    if (parambck != null)
    {
      localStringBuilder.append("<finderpoirelatedstream><longitudeString>").append(Util.escapeStringForXml(parambck.LLz)).append("</longitudeString><latitudeString>").append(Util.escapeStringForXml(parambck.LLy)).append("</latitudeString><poiName>").append(Util.escapeStringForXml(parambck.kHV)).append("</poiName><poiScaleString>").append(Util.escapeStringForXml(parambck.LLA)).append("</poiScaleString><address>").append(Util.escapeStringForXml(parambck.iUO)).append("</address><infoUrl>").append(XmlParser.getCDataWrapper(parambck.JTr)).append("</infoUrl><poiClassifyId>").append(Util.escapeStringForXml(parambck.LIb)).append("</poiClassifyId><poiCategories>").append(Util.escapeStringForXml(parambck.tPa)).append("</poiCategories>");
      localStringBuilder.append("</finderpoirelatedstream>");
    }
    parambck = localStringBuilder.toString();
    AppMethodBeat.o(196080);
    return parambck;
  }
  
  public static String a(col paramcol)
  {
    AppMethodBeat.i(196075);
    StringBuilder localStringBuilder = new StringBuilder();
    cok localcok;
    String str;
    if (paramcol != null) {
      try
      {
        if (!Util.isNullOrNil(paramcol.objectId))
        {
          localStringBuilder.append("<finderMegaVideo><objectId>").append(paramcol.objectId).append("</objectId><objectNonceId>").append(paramcol.objectNonceId).append("</objectNonceId><nickname>").append(Util.escapeStringForXml(paramcol.nickname)).append("</nickname><avatar>").append(XmlParser.getCDataWrapper(paramcol.uNR)).append("</avatar><desc>").append(Util.escapeStringForXml(paramcol.desc)).append("</desc><username>").append(Util.escapeStringForXml(paramcol.username)).append("</username><mediaCount>").append(paramcol.dJl).append("</mediaCount>");
          localStringBuilder.append("<mediaList>");
          Iterator localIterator = paramcol.mediaList.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label336;
            }
            localcok = (cok)localIterator.next();
            if (TextUtils.isEmpty(localcok.coverUrl)) {
              break;
            }
            str = XmlParser.getCDataWrapper(localcok.coverUrl);
            localStringBuilder.append("<media><url>").append(XmlParser.getCDataWrapper(localcok.url)).append("</url><thumbUrl>").append(XmlParser.getCDataWrapper(localcok.thumbUrl)).append("</thumbUrl><width>").append(localcok.width).append("</width><height>").append(localcok.height).append("</height><coverUrl>").append(str).append("</coverUrl><videoPlayDuration>").append(localcok.LLv).append("</videoPlayDuration></media>");
          }
        }
        paramcol = localStringBuilder.toString();
      }
      catch (Exception paramcol)
      {
        Log.e("MicroMsg.FinderShareParser", "make content error! %s", new Object[] { paramcol.getMessage() });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(196075);
      return paramcol;
      str = XmlParser.getCDataWrapper(localcok.thumbUrl);
      break;
      label336:
      localStringBuilder.append("</mediaList>");
      localStringBuilder.append("<finderFeed>");
      localStringBuilder.append("<objectId>").append(paramcol.MuF).append("</objectId>");
      localStringBuilder.append("<objectNonceId>").append(paramcol.MuG).append("</objectNonceId>");
      localStringBuilder.append("</finderFeed>");
      localStringBuilder.append("</finderMegaVideo>");
    }
  }
  
  public static String b(bcf parambcf)
  {
    AppMethodBeat.i(196079);
    StringBuilder localStringBuilder = new StringBuilder();
    if (parambcf != null) {}
    for (;;)
    {
      int i;
      String str;
      try
      {
        localStringBuilder.append("<finderContentColumnSharedItem><cardId>").append(Util.escapeStringForXml(parambcf.cardId)).append("</cardId><title>").append(Util.escapeStringForXml(parambcf.title)).append("</title><secondTitle>").append(Util.escapeStringForXml(parambcf.oqZ)).append("</secondTitle>");
        i = 0;
        if (i < parambcf.LLt.size())
        {
          str = (String)parambcf.LLt.get(i) + (String)parambcf.LLu.get(i);
          if (i == 0) {
            localStringBuilder.append("<iconUrl>").append(XmlParser.getCDataWrapper(str)).append("</iconUrl>");
          } else if (i == 1) {
            localStringBuilder.append("<iconUrl_1>").append(XmlParser.getCDataWrapper(str)).append("</iconUrl_1>");
          }
        }
      }
      catch (Exception parambcf)
      {
        Log.e("MicroMsg.FinderShareParser", "make content error! %s", new Object[] { parambcf.getMessage() });
      }
      for (;;)
      {
        parambcf = localStringBuilder.toString();
        AppMethodBeat.o(196079);
        return parambcf;
        if (i == 2)
        {
          localStringBuilder.append("<iconUrl_2>").append(XmlParser.getCDataWrapper(str)).append("</iconUrl_2>");
          break;
        }
        if (i != 3) {
          break;
        }
        localStringBuilder.append("<iconUrl_3>").append(XmlParser.getCDataWrapper(str)).append("</iconUrl_3>");
        break;
        if (parambcf.tVe != null)
        {
          parambcf = new String(Base64.encode(parambcf.tVe.toByteArray(), 0));
          localStringBuilder.append("<cardbuffer>").append(XmlParser.getCDataWrapper(parambcf)).append("</cardbuffer>");
        }
        localStringBuilder.append("</finderContentColumnSharedItem>");
      }
      i += 1;
    }
  }
  
  public static String b(bcj parambcj)
  {
    AppMethodBeat.i(164040);
    StringBuilder localStringBuilder = new StringBuilder();
    if (parambcj != null) {
      try
      {
        if (!Util.isNullOrNil(parambcj.objectId))
        {
          localStringBuilder.append("<finderFeed><objectId>").append(parambcj.objectId).append("</objectId><objectNonceId>").append(parambcj.objectNonceId).append("</objectNonceId><feedType>").append(parambcj.vXJ).append("</feedType><nickname>").append(Util.escapeStringForXml(parambcj.nickname)).append("</nickname><username>").append(Util.escapeStringForXml(parambcj.username)).append("</username><avatar>").append(XmlParser.getCDataWrapper(parambcj.uNR)).append("</avatar><desc>").append(Util.escapeStringForXml(parambcj.desc)).append("</desc><mediaCount>").append(parambcj.dJl).append("</mediaCount><localId>").append(parambcj.localId).append("</localId>");
          localStringBuilder.append("<mediaList>");
          Iterator localIterator = parambcj.mediaList.iterator();
          while (localIterator.hasNext())
          {
            bch localbch = (bch)localIterator.next();
            localStringBuilder.append("<media><mediaType>").append(localbch.mediaType).append("</mediaType><url>").append(XmlParser.getCDataWrapper(localbch.url)).append("</url><thumbUrl>").append(XmlParser.getCDataWrapper(localbch.thumbUrl)).append("</thumbUrl><width>").append(localbch.width).append("</width><height>").append(localbch.height).append("</height><videoPlayDuration>").append(localbch.LLv).append("</videoPlayDuration></media>");
          }
        }
        parambcj = localStringBuilder.toString();
      }
      catch (Exception parambcj)
      {
        Log.e("MicroMsg.FinderShareParser", "make content error! %s", new Object[] { parambcj.getMessage() });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(164040);
      return parambcj;
      localStringBuilder.append("</mediaList>");
      localStringBuilder.append("<megaVideo>");
      localStringBuilder.append("<objectId>").append(parambcj.LLw).append("</objectId>");
      localStringBuilder.append("<objectNonceId>").append(parambcj.LLx).append("</objectNonceId>");
      localStringBuilder.append("</megaVideo>");
      localStringBuilder.append("</finderFeed>");
    }
  }
  
  public static String b(bcl parambcl)
  {
    AppMethodBeat.i(164042);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((parambcl != null) && (!Util.isNullOrNil(parambcl.dST)))
    {
      localStringBuilder.append("<finderTopic><topic>").append(Util.escapeStringForXml(parambcl.dST)).append("</topic><topicType>").append(parambcl.tvC).append("</topicType><iconUrl>").append(XmlParser.getCDataWrapper(parambcl.iconUrl)).append("</iconUrl><desc>").append(Util.escapeStringForXml(parambcl.desc)).append("</desc><patMusicId>").append(Util.escapeStringForXml(parambcl.LLC)).append("</patMusicId>");
      if (parambcl.LLB != null) {
        localStringBuilder.append("<location><poiClassifyId>").append(Util.escapeStringForXml(parambcl.LLB.LIb)).append("</poiClassifyId><longitude>").append(parambcl.LLB.dTj).append("</longitude><latitude>").append(parambcl.LLB.latitude).append("</latitude></location>");
      }
      if (parambcl.LLD != null) {
        localStringBuilder.append("<event><topicId>").append(parambcl.LLD.LAp).append("</topicId><topicEventName>").append(Util.escapeStringForXml(parambcl.LLD.LAq)).append("</topicEventName><creatorNickName>").append(Util.escapeStringForXml(parambcl.LLD.LAr)).append("</creatorNickName></event>");
      }
      localStringBuilder.append("</finderTopic>");
    }
    parambcl = localStringBuilder.toString();
    AppMethodBeat.o(164042);
    return parambcl;
  }
  
  public static String bf(int paramInt, String paramString)
  {
    AppMethodBeat.i(196082);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<finder><type>").append(paramInt).append("</type><detail>").append(paramString).append("</detail>");
    localStringBuilder.append("</finder>");
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(196082);
    return paramString;
  }
  
  public static String c(axf paramaxf)
  {
    AppMethodBeat.i(196071);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramaxf != null) {}
    try
    {
      if (!Util.isNullOrNil(paramaxf.hJs))
      {
        localStringBuilder.append("<finderLive><finderLiveID>").append(paramaxf.hJs).append("</finderLiveID><finderUsername>").append(Util.escapeStringForXml(paramaxf.username)).append("</finderUsername><finderObjectID>").append(paramaxf.feedId).append("</finderObjectID><nickname>").append(XmlParser.getCDataWrapper(paramaxf.nickName)).append("</nickname><desc>").append(XmlParser.getCDataWrapper(paramaxf.desc)).append("</desc><finderNonceID>").append(Util.escapeStringForXml(paramaxf.objectNonceId)).append("</finderNonceID><headUrl>").append(XmlParser.getCDataWrapper(paramaxf.headUrl)).append("</headUrl><media><coverUrl>").append(XmlParser.getCDataWrapper(paramaxf.coverUrl)).append("</coverUrl><height>").append(paramaxf.height).append("</height><width>").append(paramaxf.width).append("</width></media><liveStatus>").append(paramaxf.liveStatus).append("</liveStatus>");
        localStringBuilder.append("</finderLive>");
      }
      paramaxf = localStringBuilder.toString();
      AppMethodBeat.o(196071);
      return paramaxf;
    }
    catch (Exception paramaxf)
    {
      for (;;)
      {
        Log.e("MicroMsg.FinderShareParser", "make content error! %s", new Object[] { paramaxf.getMessage() });
      }
    }
  }
  
  public static int d(Map<String, String> paramMap, int paramInt)
  {
    AppMethodBeat.i(196083);
    if (paramMap != null) {
      paramInt = Util.getInt((String)paramMap.get(".msg.appmsg.finder.type"), -1);
    }
    AppMethodBeat.o(196083);
    return paramInt;
  }
  
  public static String d(axf paramaxf)
  {
    AppMethodBeat.i(196072);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramaxf != null) {}
    try
    {
      if (!Util.isNullOrNil(paramaxf.hJs))
      {
        localStringBuilder.append("<finderLiveInvite><finderLiveID>").append(paramaxf.hJs).append("</finderLiveID><finderUsername>").append(Util.escapeStringForXml(paramaxf.username)).append("</finderUsername><finderObjectID>").append(paramaxf.feedId).append("</finderObjectID><nickname>").append(XmlParser.getCDataWrapper(paramaxf.nickName)).append("</nickname><desc>").append(XmlParser.getCDataWrapper(paramaxf.desc)).append("</desc><finderNonceID>").append(Util.escapeStringForXml(paramaxf.objectNonceId)).append("</finderNonceID><headUrl>").append(XmlParser.getCDataWrapper(paramaxf.headUrl)).append("</headUrl><coverUrl>").append(XmlParser.getCDataWrapper(paramaxf.headUrl)).append("</coverUrl><liveMicId>").append(Util.escapeStringForXml(paramaxf.hFO)).append("</liveMicId><liveMicSdkUserId>").append(Util.escapeStringForXml(paramaxf.LHH)).append("</liveMicSdkUserId>");
        localStringBuilder.append("</finderLiveInvite>");
      }
      paramaxf = localStringBuilder.toString();
      AppMethodBeat.o(196072);
      return paramaxf;
    }
    catch (Exception paramaxf)
    {
      for (;;)
      {
        Log.e("MicroMsg.FinderShareParser", "make content error! %s", new Object[] { paramaxf.getMessage() });
      }
    }
  }
  
  public static String dJA()
  {
    return ".msg.appmsg.finder.detail";
  }
  
  public static axf v(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(196073);
    axf localaxf = new axf();
    try
    {
      paramString = paramString + ".finderLive";
      if ((!paramMap.isEmpty()) && (paramMap.containsKey(paramString + ".finderLiveID")))
      {
        localaxf.hJs = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveID"));
        localaxf.username = Util.nullAsNil((String)paramMap.get(paramString + ".finderUsername"));
        localaxf.feedId = Util.nullAsNil((String)paramMap.get(paramString + ".finderObjectID"));
        localaxf.nickName = Util.nullAsNil((String)paramMap.get(paramString + ".nickname"));
        localaxf.desc = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
        localaxf.coverUrl = Util.nullAsNil((String)paramMap.get(paramString + ".media.coverUrl")).replace("&amp;", "&");
        localaxf.height = Util.safeParseFloat((String)paramMap.get(paramString + ".media.height"));
        localaxf.width = Util.safeParseFloat((String)paramMap.get(paramString + ".media.width"));
        localaxf.headUrl = Util.nullAsNil((String)paramMap.get(paramString + ".headUrl"));
        localaxf.objectNonceId = Util.nullAsNil((String)paramMap.get(paramString + ".finderNonceID"));
        localaxf.liveStatus = Util.safeParseInt((String)paramMap.get(paramString + ".liveStatus"));
      }
      AppMethodBeat.o(196073);
      return localaxf;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.FinderShareParser", "parse error! %s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public static axf w(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(196074);
    axf localaxf = new axf();
    try
    {
      paramString = paramString + ".finderLiveInvite";
      if ((!paramMap.isEmpty()) && (paramMap.containsKey(paramString + ".finderLiveID")))
      {
        localaxf.hJs = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveID"));
        localaxf.username = Util.nullAsNil((String)paramMap.get(paramString + ".finderUsername"));
        localaxf.feedId = Util.nullAsNil((String)paramMap.get(paramString + ".finderObjectID"));
        localaxf.nickName = Util.nullAsNil((String)paramMap.get(paramString + ".nickname"));
        localaxf.desc = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
        localaxf.coverUrl = Util.nullAsNil((String)paramMap.get(paramString + ".coverUrl")).replace("&amp;", "&");
        localaxf.headUrl = Util.nullAsNil((String)paramMap.get(paramString + ".headUrl"));
        localaxf.objectNonceId = Util.nullAsNil((String)paramMap.get(paramString + ".finderNonceID"));
        localaxf.hFO = Util.nullAsNil((String)paramMap.get(paramString + ".liveMicId"));
        localaxf.LHH = Util.nullAsNil((String)paramMap.get(paramString + ".liveMicSdkUserId"));
      }
      AppMethodBeat.o(196074);
      return localaxf;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.FinderShareParser", "parse error! %s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public static bcj x(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164041);
    bcj localbcj = new bcj();
    for (;;)
    {
      try
      {
        str = paramString + ".finderFeed";
        if ((paramMap.isEmpty()) || (!paramMap.containsKey(str + ".objectId"))) {
          continue;
        }
        localbcj.objectId = Util.nullAsNil((String)paramMap.get(str + ".objectId"));
        localbcj.objectNonceId = Util.nullAsNil((String)paramMap.get(str + ".objectNonceId"));
        localbcj.vXJ = Util.safeParseInt((String)paramMap.get(str + ".feedType"));
        localbcj.nickname = Util.nullAsNil((String)paramMap.get(str + ".nickname"));
        localbcj.username = Util.nullAsNil((String)paramMap.get(str + ".username"));
        localbcj.uNR = Util.nullAsNil((String)paramMap.get(str + ".avatar"));
        localbcj.desc = Util.nullAsNil((String)paramMap.get(str + ".desc"));
        localbcj.dJl = Util.safeParseInt((String)paramMap.get(str + ".mediaCount"));
        localbcj.localId = Util.safeParseLong((String)paramMap.get(str + ".localId"));
        i = 0;
        if (i >= localbcj.dJl) {
          continue;
        }
        localbch = new bch();
        paramString = str + ".mediaList.media";
        if (i <= 0) {
          continue;
        }
        paramString = paramString + i;
      }
      catch (Exception paramString)
      {
        String str;
        int i;
        bch localbch;
        Log.e("MicroMsg.FinderShareParser", "parse error! %s", new Object[] { paramString.getMessage() });
        continue;
        continue;
      }
      localbch.mediaType = Util.safeParseInt((String)paramMap.get(paramString + ".mediaType"));
      localbch.url = Util.nullAsNil((String)paramMap.get(paramString + ".url"));
      localbch.thumbUrl = Util.nullAsNil((String)paramMap.get(paramString + ".thumbUrl"));
      localbch.width = Util.safeParseFloat((String)paramMap.get(paramString + ".width"));
      localbch.height = Util.safeParseFloat((String)paramMap.get(paramString + ".height"));
      localbch.LLv = Util.safeParseInt((String)paramMap.get(paramString + ".videoPlayDuration"));
      localbcj.mediaList.add(localbch);
      i += 1;
    }
    paramString = str + ".megaVideo";
    localbcj.LLw = Util.nullAsNil((String)paramMap.get(paramString + ".objectId"));
    localbcj.LLx = Util.nullAsNil((String)paramMap.get(paramString + ".objectNonceId"));
    AppMethodBeat.o(164041);
    return localbcj;
  }
  
  public static col y(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(196076);
    col localcol = new col();
    for (;;)
    {
      try
      {
        str = paramString + ".finderMegaVideo";
        if ((paramMap.isEmpty()) || (!paramMap.containsKey(str + ".objectId"))) {
          continue;
        }
        localcol.objectId = Util.nullAsNil((String)paramMap.get(str + ".objectId"));
        localcol.objectNonceId = Util.nullAsNil((String)paramMap.get(str + ".objectNonceId"));
        localcol.nickname = Util.nullAsNil((String)paramMap.get(str + ".nickname"));
        localcol.username = Util.nullAsNil((String)paramMap.get(str + ".username"));
        localcol.uNR = Util.nullAsNil((String)paramMap.get(str + ".avatar"));
        localcol.desc = Util.nullAsNil((String)paramMap.get(str + ".desc"));
        localcol.dJl = Util.safeParseInt((String)paramMap.get(str + ".mediaCount"));
        i = 0;
        if (i >= localcol.dJl) {
          continue;
        }
        localcok = new cok();
        paramString = str + ".mediaList.media";
        if (i <= 0) {
          continue;
        }
        paramString = paramString + i;
      }
      catch (Exception paramString)
      {
        String str;
        int i;
        cok localcok;
        Log.e("MicroMsg.FinderShareParser", "parse error! %s", new Object[] { paramString.getMessage() });
        continue;
        continue;
      }
      localcok.url = Util.nullAsNil((String)paramMap.get(paramString + ".url"));
      localcok.thumbUrl = Util.nullAsNil((String)paramMap.get(paramString + ".thumbUrl"));
      localcok.width = Util.safeParseFloat((String)paramMap.get(paramString + ".width"));
      localcok.height = Util.safeParseFloat((String)paramMap.get(paramString + ".height"));
      localcok.coverUrl = Util.nullAsNil((String)paramMap.get(paramString + ".coverUrl"));
      localcok.LLv = Util.safeParseInt((String)paramMap.get(paramString + ".videoPlayDuration"));
      localcol.mediaList.add(localcok);
      i += 1;
    }
    paramString = str + ".finderFeed";
    localcol.MuF = Util.nullAsNil((String)paramMap.get(paramString + ".objectId"));
    localcol.MuG = Util.nullAsNil((String)paramMap.get(paramString + ".objectNonceId"));
    AppMethodBeat.o(196076);
    return localcol;
  }
  
  public static bcl z(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164043);
    bcl localbcl = new bcl();
    paramString = paramString + ".finderTopic";
    if (!paramMap.isEmpty())
    {
      localbcl.dST = Util.nullAsNil((String)paramMap.get(paramString + ".topic"));
      localbcl.tvC = Util.getInt((String)paramMap.get(paramString + ".topicType"), -1);
      localbcl.iconUrl = Util.nullAsNil((String)paramMap.get(paramString + ".iconUrl"));
      localbcl.desc = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
      localbcl.LLC = Util.nullAsNil((String)paramMap.get(paramString + ".patMusicId"));
      Object localObject = new bcg();
      ((bcg)localObject).LIb = ((String)paramMap.get(paramString + ".location.poiClassifyId"));
      ((bcg)localObject).dTj = Util.getFloat((String)paramMap.get(paramString + ".location.longitude"), 0.0F);
      ((bcg)localObject).latitude = Util.getFloat((String)paramMap.get(paramString + ".location.latitude"), 0.0F);
      localbcl.LLB = ((bcg)localObject);
      if (paramMap.get(paramString + ".event.topicId") != null)
      {
        localObject = new aoi();
        ((aoi)localObject).LAp = Util.nullAsNil((String)paramMap.get(paramString + ".event.topicId"));
        ((aoi)localObject).LAq = Util.nullAsNil((String)paramMap.get(paramString + ".event.topicEventName"));
        ((aoi)localObject).LAr = Util.nullAsNil((String)paramMap.get(paramString + ".event.creatorNickName"));
        localbcl.LLD = ((aoi)localObject);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(164043);
      return localbcl;
      localbcl.dST = "";
      localbcl.tvC = -1;
      localbcl.iconUrl = "";
      localbcl.desc = "";
      localbcl.LLB = new bcg();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.l
 * JD-Core Version:    0.7.0.1
 */