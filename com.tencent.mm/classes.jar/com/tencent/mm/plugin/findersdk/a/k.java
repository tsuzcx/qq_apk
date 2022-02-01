package com.tencent.mm.plugin.findersdk.a;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.apn;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.protocal.protobuf.cww;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class k
{
  public static bja A(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(200830);
    bja localbja = new bja();
    String str = paramString + ".finderColumn";
    if (!paramMap.isEmpty())
    {
      localbja.xGO = new b(Base64.decode(Util.nullAsNil((String)paramMap.get(str + ".cardbuffer")), 0));
      paramString = Util.nullAsNil((String)paramMap.get(str + ".iconUrl"));
      Object localObject3 = Util.nullAsNil((String)paramMap.get(str + ".iconUrl_1"));
      Object localObject2 = Util.nullAsNil((String)paramMap.get(str + ".iconUrl_2"));
      Object localObject1 = Util.nullAsNil((String)paramMap.get(str + ".iconUrl_3"));
      paramString = paramString.split("&token");
      localbja.STk.add(paramString[0]);
      LinkedList localLinkedList = localbja.STl;
      if (paramString.length > 1)
      {
        paramString = "&token" + paramString[1];
        localLinkedList.add(paramString);
        paramString = ((String)localObject3).split("&token");
        localbja.STk.add(paramString[0]);
        localObject3 = localbja.STl;
        if (paramString.length <= 1) {
          break label564;
        }
        paramString = "&token" + paramString[1];
        label325:
        ((LinkedList)localObject3).add(paramString);
        paramString = ((String)localObject2).split("&token");
        localbja.STk.add(paramString[0]);
        localObject2 = localbja.STl;
        if (paramString.length <= 1) {
          break label570;
        }
        paramString = "&token" + paramString[1];
        label382:
        ((LinkedList)localObject2).add(paramString);
        paramString = ((String)localObject1).split("&token");
        localbja.STk.add(paramString[0]);
        localObject1 = localbja.STl;
        if (paramString.length <= 1) {
          break label576;
        }
        paramString = "&token" + paramString[1];
        label439:
        ((LinkedList)localObject1).add(paramString);
        localbja.cardId = Util.nullAsNil((String)paramMap.get(str + ".cardId"));
        localbja.title = Util.nullAsNil((String)paramMap.get(str + ".title"));
        localbja.rsw = Util.nullAsNil((String)paramMap.get(str + ".secondTitle"));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(200830);
      return localbja;
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
      localbja.cardId = "";
      localbja.title = "";
      localbja.rsw = "";
      localbja.xGO = null;
    }
  }
  
  public static bjf B(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(200834);
    bjf localbjf = new bjf();
    paramString = paramString + ".finderpoirelatedstream";
    if (!paramMap.isEmpty())
    {
      localbjf.STs = Util.nullAsNil((String)paramMap.get(paramString + ".longitudeString"));
      localbjf.STr = Util.nullAsNil((String)paramMap.get(paramString + ".latitudeString"));
      localbjf.poiName = Util.nullAsNil((String)paramMap.get(paramString + ".poiName"));
      localbjf.STt = Util.nullAsNil((String)paramMap.get(paramString + ".poiScaleString"));
      localbjf.lLg = Util.nullAsNil((String)paramMap.get(paramString + ".address"));
      localbjf.QSw = Util.nullAsNil((String)paramMap.get(paramString + ".infoUrl"));
      localbjf.SOz = Util.nullAsNil((String)paramMap.get(paramString + ".poiClassifyId"));
    }
    for (localbjf.xzN = Util.nullAsNil((String)paramMap.get(paramString + ".poiCategories"));; localbjf.xzN = "")
    {
      AppMethodBeat.o(200834);
      return localbjf;
      localbjf.STs = "";
      localbjf.STr = "";
      localbjf.poiName = "";
      localbjf.STt = "";
      localbjf.lLg = "";
      localbjf.QSw = "";
      localbjf.SOz = "";
    }
  }
  
  public static String a(bja parambja)
  {
    AppMethodBeat.i(200827);
    StringBuilder localStringBuilder = new StringBuilder();
    if (parambja != null) {}
    for (;;)
    {
      int i;
      String str;
      try
      {
        if (!Util.isNullOrNil(parambja.cardId))
        {
          localStringBuilder.append("<finderColumn><cardId>").append(Util.escapeStringForXml(parambja.cardId)).append("</cardId><title>").append(Util.escapeStringForXml(parambja.title)).append("</title><secondTitle>").append(Util.escapeStringForXml(parambja.rsw)).append("</secondTitle>");
          i = 0;
          if (i >= parambja.STk.size()) {
            break label269;
          }
          str = (String)parambja.STk.get(i) + (String)parambja.STl.get(i);
          if (i == 0) {
            localStringBuilder.append("<iconUrl>").append(XmlParser.getCDataWrapper(str)).append("</iconUrl>");
          } else if (i == 1) {
            localStringBuilder.append("<iconUrl_1>").append(XmlParser.getCDataWrapper(str)).append("</iconUrl_1>");
          }
        }
      }
      catch (Exception parambja)
      {
        Log.e("MicroMsg.FinderShareParser", "make content error! %s", new Object[] { parambja.getMessage() });
      }
      for (;;)
      {
        parambja = localStringBuilder.toString();
        AppMethodBeat.o(200827);
        return parambja;
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
        if (parambja.xGO != null)
        {
          parambja = new String(Base64.encode(parambja.xGO.toByteArray(), 0));
          localStringBuilder.append("<cardbuffer>").append(XmlParser.getCDataWrapper(parambja)).append("</cardbuffer>");
        }
        localStringBuilder.append("</finderColumn>");
      }
      i += 1;
    }
  }
  
  public static String a(bjf parambjf)
  {
    AppMethodBeat.i(200833);
    StringBuilder localStringBuilder = new StringBuilder();
    if (parambjf != null)
    {
      localStringBuilder.append("<finderpoirelatedstream><longitudeString>").append(Util.escapeStringForXml(parambjf.STs)).append("</longitudeString><latitudeString>").append(Util.escapeStringForXml(parambjf.STr)).append("</latitudeString><poiName>").append(Util.escapeStringForXml(parambjf.poiName)).append("</poiName><poiScaleString>").append(Util.escapeStringForXml(parambjf.STt)).append("</poiScaleString><address>").append(Util.escapeStringForXml(parambjf.lLg)).append("</address><infoUrl>").append(XmlParser.getCDataWrapper(parambjf.QSw)).append("</infoUrl><poiClassifyId>").append(Util.escapeStringForXml(parambjf.SOz)).append("</poiClassifyId><poiCategories>").append(Util.escapeStringForXml(parambjf.xzN)).append("</poiCategories>");
      localStringBuilder.append("</finderpoirelatedstream>");
    }
    parambjf = localStringBuilder.toString();
    AppMethodBeat.o(200833);
    return parambjf;
  }
  
  public static String a(cwx paramcwx)
  {
    AppMethodBeat.i(200795);
    StringBuilder localStringBuilder = new StringBuilder();
    cww localcww;
    String str;
    if (paramcwx != null) {
      try
      {
        if (!Util.isNullOrNil(paramcwx.objectId))
        {
          localStringBuilder.append("<finderMegaVideo><objectId>").append(paramcwx.objectId).append("</objectId><objectNonceId>").append(paramcwx.objectNonceId).append("</objectNonceId><nickname>").append(Util.escapeStringForXml(paramcwx.nickname)).append("</nickname><avatar>").append(XmlParser.getCDataWrapper(paramcwx.avatar)).append("</avatar><desc>").append(Util.escapeStringForXml(paramcwx.desc)).append("</desc><username>").append(Util.escapeStringForXml(paramcwx.username)).append("</username><mediaCount>").append(paramcwx.fCa).append("</mediaCount>");
          localStringBuilder.append("<mediaList>");
          Iterator localIterator = paramcwx.mediaList.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label336;
            }
            localcww = (cww)localIterator.next();
            if (TextUtils.isEmpty(localcww.coverUrl)) {
              break;
            }
            str = XmlParser.getCDataWrapper(localcww.coverUrl);
            localStringBuilder.append("<media><url>").append(XmlParser.getCDataWrapper(localcww.url)).append("</url><thumbUrl>").append(XmlParser.getCDataWrapper(localcww.thumbUrl)).append("</thumbUrl><width>").append(localcww.width).append("</width><height>").append(localcww.height).append("</height><coverUrl>").append(str).append("</coverUrl><videoPlayDuration>").append(localcww.STm).append("</videoPlayDuration></media>");
          }
        }
        paramcwx = localStringBuilder.toString();
      }
      catch (Exception paramcwx)
      {
        Log.e("MicroMsg.FinderShareParser", "make content error! %s", new Object[] { paramcwx.getMessage() });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(200795);
      return paramcwx;
      str = XmlParser.getCDataWrapper(localcww.thumbUrl);
      break;
      label336:
      localStringBuilder.append("</mediaList>");
      localStringBuilder.append("<finderFeed>");
      localStringBuilder.append("<objectId>").append(paramcwx.TFx).append("</objectId>");
      localStringBuilder.append("<objectNonceId>").append(paramcwx.Jyf).append("</objectNonceId>");
      localStringBuilder.append("</finderFeed>");
      localStringBuilder.append("</finderMegaVideo>");
    }
  }
  
  public static String b(bja parambja)
  {
    AppMethodBeat.i(200831);
    StringBuilder localStringBuilder = new StringBuilder();
    if (parambja != null) {}
    for (;;)
    {
      int i;
      String str;
      try
      {
        localStringBuilder.append("<finderContentColumnSharedItem><cardId>").append(Util.escapeStringForXml(parambja.cardId)).append("</cardId><title>").append(Util.escapeStringForXml(parambja.title)).append("</title><secondTitle>").append(Util.escapeStringForXml(parambja.rsw)).append("</secondTitle>");
        i = 0;
        if (i < parambja.STk.size())
        {
          str = (String)parambja.STk.get(i) + (String)parambja.STl.get(i);
          if (i == 0) {
            localStringBuilder.append("<iconUrl>").append(XmlParser.getCDataWrapper(str)).append("</iconUrl>");
          } else if (i == 1) {
            localStringBuilder.append("<iconUrl_1>").append(XmlParser.getCDataWrapper(str)).append("</iconUrl_1>");
          }
        }
      }
      catch (Exception parambja)
      {
        Log.e("MicroMsg.FinderShareParser", "make content error! %s", new Object[] { parambja.getMessage() });
      }
      for (;;)
      {
        parambja = localStringBuilder.toString();
        AppMethodBeat.o(200831);
        return parambja;
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
        if (parambja.xGO != null)
        {
          parambja = new String(Base64.encode(parambja.xGO.toByteArray(), 0));
          localStringBuilder.append("<cardbuffer>").append(XmlParser.getCDataWrapper(parambja)).append("</cardbuffer>");
        }
        localStringBuilder.append("</finderContentColumnSharedItem>");
      }
      i += 1;
    }
  }
  
  public static String b(bje parambje)
  {
    AppMethodBeat.i(164040);
    StringBuilder localStringBuilder = new StringBuilder();
    if (parambje != null) {
      try
      {
        if (!Util.isNullOrNil(parambje.objectId))
        {
          localStringBuilder.append("<finderFeed><objectId>").append(parambje.objectId).append("</objectId><objectNonceId>").append(parambje.objectNonceId).append("</objectNonceId><feedType>").append(parambje.ACQ).append("</feedType><nickname>").append(Util.escapeStringForXml(parambje.nickname)).append("</nickname><username>").append(Util.escapeStringForXml(parambje.username)).append("</username><avatar>").append(XmlParser.getCDataWrapper(parambje.avatar)).append("</avatar><desc>").append(Util.escapeStringForXml(parambje.desc)).append("</desc><mediaCount>").append(parambje.fCa).append("</mediaCount><localId>").append(parambje.localId).append("</localId>");
          localStringBuilder.append("<mediaList>");
          Iterator localIterator = parambje.mediaList.iterator();
          while (localIterator.hasNext())
          {
            bjc localbjc = (bjc)localIterator.next();
            localStringBuilder.append("<media><mediaType>").append(localbjc.mediaType).append("</mediaType><url>").append(XmlParser.getCDataWrapper(localbjc.url)).append("</url><thumbUrl>").append(XmlParser.getCDataWrapper(localbjc.thumbUrl)).append("</thumbUrl><fullCoverUrl>").append(XmlParser.getCDataWrapper(localbjc.STn)).append("</fullCoverUrl><fullClipInset>").append(XmlParser.getCDataWrapper(localbjc.STo)).append("</fullClipInset><width>").append(localbjc.width).append("</width><height>").append(localbjc.height).append("</height><videoPlayDuration>").append(localbjc.STm).append("</videoPlayDuration></media>");
          }
        }
        parambje = localStringBuilder.toString();
      }
      catch (Exception parambje)
      {
        Log.e("MicroMsg.FinderShareParser", "make content error! %s", new Object[] { parambje.getMessage() });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(164040);
      return parambje;
      localStringBuilder.append("</mediaList>");
      localStringBuilder.append("<megaVideo>");
      localStringBuilder.append("<objectId>").append(parambje.STp).append("</objectId>");
      localStringBuilder.append("<objectNonceId>").append(parambje.STq).append("</objectNonceId>");
      localStringBuilder.append("</megaVideo>");
      localStringBuilder.append("</finderFeed>");
    }
  }
  
  public static String b(bjg parambjg)
  {
    AppMethodBeat.i(164042);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((parambjg != null) && (!Util.isNullOrNil(parambjg.topic)))
    {
      localStringBuilder.append("<finderTopic><topic>").append(Util.escapeStringForXml(parambjg.topic)).append("</topic><topicType>").append(parambjg.wXA).append("</topicType><iconUrl>").append(XmlParser.getCDataWrapper(parambjg.iconUrl)).append("</iconUrl><desc>").append(Util.escapeStringForXml(parambjg.desc)).append("</desc><patMusicId>").append(Util.escapeStringForXml(parambjg.STv)).append("</patMusicId>");
      if (parambjg.STu != null) {
        localStringBuilder.append("<location><poiClassifyId>").append(Util.escapeStringForXml(parambjg.STu.SOz)).append("</poiClassifyId><longitude>").append(parambjg.STu.longitude).append("</longitude><latitude>").append(parambjg.STu.latitude).append("</latitude></location>");
      }
      if (parambjg.STw != null) {
        localStringBuilder.append("<event><topicId>").append(parambjg.STw.SCQ).append("</topicId><name>").append(Util.escapeStringForXml(parambjg.STw.SCR)).append("</name><creatorNickName>").append(Util.escapeStringForXml(parambjg.STw.SCS)).append("</creatorNickName></event>");
      }
      localStringBuilder.append("</finderTopic>");
    }
    parambjg = localStringBuilder.toString();
    AppMethodBeat.o(164042);
    return parambjg;
  }
  
  public static String bf(int paramInt, String paramString)
  {
    AppMethodBeat.i(200836);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<finder><type>").append(paramInt).append("</type><detail>").append(paramString).append("</detail>");
    localStringBuilder.append("</finder>");
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(200836);
    return paramString;
  }
  
  public static String c(bcp parambcp)
  {
    AppMethodBeat.i(200770);
    StringBuilder localStringBuilder = new StringBuilder();
    if (parambcp != null) {}
    try
    {
      if (!Util.isNullOrNil(parambcp.kwM))
      {
        localStringBuilder.append("<finderLive><finderLiveID>").append(parambcp.kwM).append("</finderLiveID><finderUsername>").append(Util.escapeStringForXml(parambcp.username)).append("</finderUsername><finderObjectID>").append(parambcp.feedId).append("</finderObjectID><nickname>").append(XmlParser.getCDataWrapper(parambcp.nickName)).append("</nickname><desc>").append(XmlParser.getCDataWrapper(parambcp.desc)).append("</desc><finderNonceID>").append(Util.escapeStringForXml(parambcp.objectNonceId)).append("</finderNonceID><headUrl>").append(XmlParser.getCDataWrapper(parambcp.headUrl)).append("</headUrl><extFlag>").append(XmlParser.getCDataWrapper(String.valueOf(parambcp.extFlag))).append("</extFlag><media><coverUrl>").append(XmlParser.getCDataWrapper(parambcp.coverUrl)).append("</coverUrl><height>").append(parambcp.height).append("</height><width>").append(parambcp.width).append("</width></media><liveStatus>").append(parambcp.liveStatus).append("</liveStatus><sourceType>").append(parambcp.sourceType).append("</sourceType>");
        localStringBuilder.append("</finderLive>");
      }
      parambcp = localStringBuilder.toString();
      AppMethodBeat.o(200770);
      return parambcp;
    }
    catch (Exception parambcp)
    {
      for (;;)
      {
        Log.e("MicroMsg.FinderShareParser", "make content error! %s", new Object[] { parambcp.getMessage() });
      }
    }
  }
  
  public static String c(bjg parambjg)
  {
    AppMethodBeat.i(200820);
    StringBuilder localStringBuilder = new StringBuilder();
    if (parambjg != null)
    {
      localStringBuilder.append("<finderTopicShareItem><topic>").append(Util.escapeStringForXml(parambjg.topic)).append("</topic><topicType>").append(parambjg.wXA).append("</topicType><iconUrl>").append(XmlParser.getCDataWrapper(parambjg.iconUrl)).append("</iconUrl><desc>").append(Util.escapeStringForXml(parambjg.desc)).append("</desc><patMusicId>").append(Util.escapeStringForXml(parambjg.STv)).append("</patMusicId>");
      if (parambjg.STu != null) {
        localStringBuilder.append("<location><poiClassifyId>").append(Util.escapeStringForXml(parambjg.STu.SOz)).append("</poiClassifyId><longitude>").append(parambjg.STu.longitude).append("</longitude><latitude>").append(parambjg.STu.latitude).append("</latitude></location>");
      }
      if (parambjg.STw != null) {
        localStringBuilder.append("<event><topicId>").append(parambjg.STw.SCQ).append("</topicId><name>").append(Util.escapeStringForXml(parambjg.STw.SCR)).append("</name><creatorNickName>").append(Util.escapeStringForXml(parambjg.STw.SCS)).append("</creatorNickName></event>");
      }
      localStringBuilder.append("</finderTopicShareItem>");
    }
    parambjg = localStringBuilder.toString();
    AppMethodBeat.o(200820);
    return parambjg;
  }
  
  public static int d(Map<String, String> paramMap, int paramInt)
  {
    AppMethodBeat.i(200838);
    if (paramMap != null) {
      paramInt = Util.getInt((String)paramMap.get(".msg.appmsg.finder.type"), -1);
    }
    AppMethodBeat.o(200838);
    return paramInt;
  }
  
  public static String d(bcp parambcp)
  {
    AppMethodBeat.i(200775);
    StringBuilder localStringBuilder = new StringBuilder();
    if (parambcp != null) {}
    try
    {
      if (!Util.isNullOrNil(parambcp.kwM))
      {
        localStringBuilder.append("<finderLiveInvite><finderLiveID>").append(parambcp.kwM).append("</finderLiveID><finderUsername>").append(Util.escapeStringForXml(parambcp.username)).append("</finderUsername><finderObjectID>").append(parambcp.feedId).append("</finderObjectID><nickname>").append(XmlParser.getCDataWrapper(parambcp.nickName)).append("</nickname><desc>").append(XmlParser.getCDataWrapper(parambcp.desc)).append("</desc><finderNonceID>").append(Util.escapeStringForXml(parambcp.objectNonceId)).append("</finderNonceID><headUrl>").append(XmlParser.getCDataWrapper(parambcp.headUrl)).append("</headUrl><coverUrl>").append(XmlParser.getCDataWrapper(parambcp.headUrl)).append("</coverUrl><liveMicId>").append(Util.escapeStringForXml(parambcp.SNR)).append("</liveMicId><liveMicSdkUserId>").append(Util.escapeStringForXml(parambcp.SNS)).append("</liveMicSdkUserId>");
        localStringBuilder.append("</finderLiveInvite>");
      }
      parambcp = localStringBuilder.toString();
      AppMethodBeat.o(200775);
      return parambcp;
    }
    catch (Exception parambcp)
    {
      for (;;)
      {
        Log.e("MicroMsg.FinderShareParser", "make content error! %s", new Object[] { parambcp.getMessage() });
      }
    }
  }
  
  public static String enk()
  {
    return ".msg.appmsg.finder.detail";
  }
  
  public static bcp u(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(200781);
    bcp localbcp = new bcp();
    try
    {
      paramString = paramString + ".finderLive";
      if ((!paramMap.isEmpty()) && (paramMap.containsKey(paramString + ".finderLiveID")))
      {
        localbcp.kwM = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveID"));
        localbcp.username = Util.nullAsNil((String)paramMap.get(paramString + ".finderUsername"));
        localbcp.feedId = Util.nullAsNil((String)paramMap.get(paramString + ".finderObjectID"));
        localbcp.nickName = Util.nullAsNil((String)paramMap.get(paramString + ".nickname"));
        localbcp.desc = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
        localbcp.coverUrl = Util.nullAsNil((String)paramMap.get(paramString + ".media.coverUrl")).replace("&amp;", "&");
        localbcp.height = Util.safeParseFloat((String)paramMap.get(paramString + ".media.height"));
        localbcp.width = Util.safeParseFloat((String)paramMap.get(paramString + ".media.width"));
        localbcp.headUrl = Util.nullAsNil((String)paramMap.get(paramString + ".headUrl"));
        localbcp.objectNonceId = Util.nullAsNil((String)paramMap.get(paramString + ".finderNonceID"));
        localbcp.liveStatus = Util.safeParseInt((String)paramMap.get(paramString + ".liveStatus"));
        localbcp.sourceType = Util.safeParseInt((String)paramMap.get(paramString + ".sourceType"));
        if ((localbcp.liveStatus != 1) && (localbcp.liveStatus != 2))
        {
          Log.i("MicroMsg.FinderShareParser", "[parseFinderLive] shareObject.liveStatus = " + localbcp.liveStatus);
          localbcp.liveStatus = 1;
        }
        localbcp.extFlag = Util.safeParseInt((String)paramMap.get(paramString + ".extFlag"));
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.FinderShareParser", "parse error! %s", new Object[] { paramString.getMessage() });
      }
    }
    AppMethodBeat.o(200781);
    return localbcp;
  }
  
  public static bcp v(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(200784);
    bcp localbcp = new bcp();
    try
    {
      paramString = paramString + ".finderLiveInvite";
      if ((!paramMap.isEmpty()) && (paramMap.containsKey(paramString + ".finderLiveID")))
      {
        localbcp.kwM = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveID"));
        localbcp.username = Util.nullAsNil((String)paramMap.get(paramString + ".finderUsername"));
        localbcp.feedId = Util.nullAsNil((String)paramMap.get(paramString + ".finderObjectID"));
        localbcp.nickName = Util.nullAsNil((String)paramMap.get(paramString + ".nickname"));
        localbcp.desc = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
        localbcp.coverUrl = Util.nullAsNil((String)paramMap.get(paramString + ".coverUrl")).replace("&amp;", "&");
        localbcp.headUrl = Util.nullAsNil((String)paramMap.get(paramString + ".headUrl"));
        localbcp.objectNonceId = Util.nullAsNil((String)paramMap.get(paramString + ".finderNonceID"));
        localbcp.SNR = Util.nullAsNil((String)paramMap.get(paramString + ".liveMicId"));
        localbcp.SNS = Util.nullAsNil((String)paramMap.get(paramString + ".liveMicSdkUserId"));
      }
      AppMethodBeat.o(200784);
      return localbcp;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.FinderShareParser", "parse error! %s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public static bje w(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164041);
    bje localbje = new bje();
    for (;;)
    {
      try
      {
        str = paramString + ".finderFeed";
        if ((paramMap.isEmpty()) || (!paramMap.containsKey(str + ".objectId"))) {
          continue;
        }
        localbje.objectId = Util.nullAsNil((String)paramMap.get(str + ".objectId"));
        localbje.objectNonceId = Util.nullAsNil((String)paramMap.get(str + ".objectNonceId"));
        localbje.ACQ = Util.safeParseInt((String)paramMap.get(str + ".feedType"));
        localbje.nickname = Util.nullAsNil((String)paramMap.get(str + ".nickname"));
        localbje.username = Util.nullAsNil((String)paramMap.get(str + ".username"));
        localbje.avatar = Util.nullAsNil((String)paramMap.get(str + ".avatar"));
        localbje.desc = Util.nullAsNil((String)paramMap.get(str + ".desc"));
        localbje.fCa = Util.safeParseInt((String)paramMap.get(str + ".mediaCount"));
        localbje.localId = Util.safeParseLong((String)paramMap.get(str + ".localId"));
        i = 0;
        if (i >= localbje.fCa) {
          continue;
        }
        localbjc = new bjc();
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
        bjc localbjc;
        Log.e("MicroMsg.FinderShareParser", "parse error! %s", new Object[] { paramString.getMessage() });
        continue;
        continue;
      }
      localbjc.mediaType = Util.safeParseInt((String)paramMap.get(paramString + ".mediaType"));
      localbjc.url = Util.nullAsNil((String)paramMap.get(paramString + ".url"));
      localbjc.thumbUrl = Util.nullAsNil((String)paramMap.get(paramString + ".thumbUrl"));
      localbjc.STn = Util.nullAsNil((String)paramMap.get(paramString + ".fullCoverUrl"));
      localbjc.STo = Util.nullAsNil((String)paramMap.get(paramString + ".fullClipInset"));
      localbjc.width = Util.safeParseFloat((String)paramMap.get(paramString + ".width"));
      localbjc.height = Util.safeParseFloat((String)paramMap.get(paramString + ".height"));
      localbjc.STm = Util.safeParseInt((String)paramMap.get(paramString + ".videoPlayDuration"));
      localbje.mediaList.add(localbjc);
      i += 1;
    }
    paramString = str + ".megaVideo";
    localbje.STp = Util.nullAsNil((String)paramMap.get(paramString + ".objectId"));
    localbje.STq = Util.nullAsNil((String)paramMap.get(paramString + ".objectNonceId"));
    AppMethodBeat.o(164041);
    return localbje;
  }
  
  public static cwx x(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(200811);
    cwx localcwx = new cwx();
    for (;;)
    {
      try
      {
        str = paramString + ".finderMegaVideo";
        if ((paramMap.isEmpty()) || (!paramMap.containsKey(str + ".objectId"))) {
          continue;
        }
        localcwx.objectId = Util.nullAsNil((String)paramMap.get(str + ".objectId"));
        localcwx.objectNonceId = Util.nullAsNil((String)paramMap.get(str + ".objectNonceId"));
        localcwx.nickname = Util.nullAsNil((String)paramMap.get(str + ".nickname"));
        localcwx.username = Util.nullAsNil((String)paramMap.get(str + ".username"));
        localcwx.avatar = Util.nullAsNil((String)paramMap.get(str + ".avatar"));
        localcwx.desc = Util.nullAsNil((String)paramMap.get(str + ".desc"));
        localcwx.fCa = Util.safeParseInt((String)paramMap.get(str + ".mediaCount"));
        i = 0;
        if (i >= localcwx.fCa) {
          continue;
        }
        localcww = new cww();
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
        cww localcww;
        Log.e("MicroMsg.FinderShareParser", "parse error! %s", new Object[] { paramString.getMessage() });
        continue;
        continue;
      }
      localcww.url = Util.nullAsNil((String)paramMap.get(paramString + ".url"));
      localcww.thumbUrl = Util.nullAsNil((String)paramMap.get(paramString + ".thumbUrl"));
      localcww.width = Util.safeParseFloat((String)paramMap.get(paramString + ".width"));
      localcww.height = Util.safeParseFloat((String)paramMap.get(paramString + ".height"));
      localcww.coverUrl = Util.nullAsNil((String)paramMap.get(paramString + ".coverUrl"));
      localcww.STm = Util.safeParseInt((String)paramMap.get(paramString + ".videoPlayDuration"));
      localcwx.mediaList.add(localcww);
      i += 1;
    }
    paramString = str + ".finderFeed";
    localcwx.TFx = Util.nullAsNil((String)paramMap.get(paramString + ".objectId"));
    localcwx.Jyf = Util.nullAsNil((String)paramMap.get(paramString + ".objectNonceId"));
    AppMethodBeat.o(200811);
    return localcwx;
  }
  
  public static bjg y(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164043);
    bjg localbjg = new bjg();
    paramString = paramString + ".finderTopic";
    if (!paramMap.isEmpty())
    {
      localbjg.topic = Util.nullAsNil((String)paramMap.get(paramString + ".topic"));
      localbjg.wXA = Util.getInt((String)paramMap.get(paramString + ".topicType"), -1);
      localbjg.iconUrl = Util.nullAsNil((String)paramMap.get(paramString + ".iconUrl"));
      localbjg.desc = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
      localbjg.STv = Util.nullAsNil((String)paramMap.get(paramString + ".patMusicId"));
      Object localObject = new bjb();
      ((bjb)localObject).SOz = ((String)paramMap.get(paramString + ".location.poiClassifyId"));
      ((bjb)localObject).longitude = Util.getFloat((String)paramMap.get(paramString + ".location.longitude"), 0.0F);
      ((bjb)localObject).latitude = Util.getFloat((String)paramMap.get(paramString + ".location.latitude"), 0.0F);
      localbjg.STu = ((bjb)localObject);
      if (paramMap.get(paramString + ".event.topicId") != null)
      {
        localObject = new apn();
        ((apn)localObject).SCQ = Util.nullAsNil((String)paramMap.get(paramString + ".event.topicId"));
        ((apn)localObject).SCR = Util.nullAsNil((String)paramMap.get(paramString + ".event.name"));
        ((apn)localObject).SCS = Util.nullAsNil((String)paramMap.get(paramString + ".event.creatorNickName"));
        localbjg.STw = ((apn)localObject);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(164043);
      return localbjg;
      localbjg.topic = "";
      localbjg.wXA = -1;
      localbjg.iconUrl = "";
      localbjg.desc = "";
      localbjg.STu = new bjb();
    }
  }
  
  public static bjg z(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(200822);
    bjg localbjg = new bjg();
    paramString = paramString + ".finderTopicShareItem";
    if (!paramMap.isEmpty())
    {
      localbjg.topic = Util.nullAsNil((String)paramMap.get(paramString + ".topic"));
      localbjg.wXA = Util.getInt((String)paramMap.get(paramString + ".topicType"), -1);
      localbjg.iconUrl = Util.nullAsNil((String)paramMap.get(paramString + ".iconUrl"));
      localbjg.desc = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
      localbjg.STv = Util.nullAsNil((String)paramMap.get(paramString + ".patMusicId"));
      Object localObject = new bjb();
      ((bjb)localObject).SOz = ((String)paramMap.get(paramString + ".location.poiClassifyId"));
      ((bjb)localObject).longitude = Util.getFloat((String)paramMap.get(paramString + ".location.longitude"), 0.0F);
      ((bjb)localObject).latitude = Util.getFloat((String)paramMap.get(paramString + ".location.latitude"), 0.0F);
      localbjg.STu = ((bjb)localObject);
      if (paramMap.get(paramString + ".event.topicId") != null)
      {
        localObject = new apn();
        ((apn)localObject).SCQ = Util.nullAsNil((String)paramMap.get(paramString + ".event.topicId"));
        ((apn)localObject).SCR = Util.nullAsNil((String)paramMap.get(paramString + ".event.name"));
        ((apn)localObject).SCS = Util.nullAsNil((String)paramMap.get(paramString + ".event.creatorNickName"));
        localbjg.STw = ((apn)localObject);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(200822);
      return localbjg;
      localbjg.topic = "";
      localbjg.wXA = -1;
      localbjg.iconUrl = "";
      localbjg.desc = "";
      localbjg.STu = new bjb();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.k
 * JD-Core Version:    0.7.0.1
 */