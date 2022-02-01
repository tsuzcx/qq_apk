package com.tencent.mm.plugin.findersdk.a;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.atg;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.protocal.protobuf.dob;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class q
{
  public static bth A(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(274077);
    bth localbth = new bth();
    try
    {
      paramString = paramString + ".finderLiveProductShare";
      if (!paramMap.isEmpty())
      {
        localbth.aabe = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveID"));
        localbth.finderUsername = Util.nullAsNil((String)paramMap.get(paramString + ".finderUsername"));
        localbth.aabf = Util.nullAsNil((String)paramMap.get(paramString + ".finderObjectID"));
        localbth.aabg = Util.nullAsNil((String)paramMap.get(paramString + ".finderNonceID"));
        localbth.aabh = Util.nullAsNil((String)paramMap.get(paramString + ".liveStatus"));
        localbth.appId = Util.nullAsNil((String)paramMap.get(paramString + ".appId"));
        localbth.hzy = Util.nullAsNil((String)paramMap.get(paramString + ".pagePath"));
        localbth.productId = Util.nullAsNil((String)paramMap.get(paramString + ".productId"));
        localbth.coverUrl = Util.nullAsNil((String)paramMap.get(paramString + ".coverUrl"));
        localbth.aabi = Util.nullAsNil((String)paramMap.get(paramString + ".productTitle"));
        localbth.aabj = Util.safeParseInt((String)paramMap.get(paramString + ".marketPrice"));
        localbth.aabk = Util.safeParseInt((String)paramMap.get(paramString + ".sellingPrice"));
        localbth.aabl = Util.nullAsNil((String)paramMap.get(paramString + ".platformHeadImg"));
        localbth.ESn = Util.nullAsNil((String)paramMap.get(paramString + ".platformName"));
        localbth.DGl = Util.nullAsNil((String)paramMap.get(paramString + ".shopWindowId"));
      }
      AppMethodBeat.o(274077);
      return localbth;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.FinderShareParser", "parse error! %s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public static bmr B(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(274100);
    bmr localbmr = new bmr();
    try
    {
      paramString = paramString + ".finderLiveInvite";
      if ((!paramMap.isEmpty()) && (paramMap.containsKey(paramString + ".finderLiveID")))
      {
        localbmr.liveId = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveID"));
        localbmr.username = Util.nullAsNil((String)paramMap.get(paramString + ".finderUsername"));
        localbmr.feedId = Util.nullAsNil((String)paramMap.get(paramString + ".finderObjectID"));
        localbmr.nickName = Util.nullAsNil((String)paramMap.get(paramString + ".nickname"));
        localbmr.desc = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
        localbmr.coverUrl = Util.nullAsNil((String)paramMap.get(paramString + ".coverUrl")).replace("&amp;", "&");
        localbmr.headUrl = Util.nullAsNil((String)paramMap.get(paramString + ".headUrl"));
        localbmr.objectNonceId = Util.nullAsNil((String)paramMap.get(paramString + ".finderNonceID"));
        localbmr.ZVi = Util.nullAsNil((String)paramMap.get(paramString + ".liveMicId"));
        localbmr.ZVj = Util.nullAsNil((String)paramMap.get(paramString + ".liveMicSdkUserId"));
      }
      AppMethodBeat.o(274100);
      return localbmr;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.FinderShareParser", "parse error! %s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public static bvl C(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164041);
    bvl localbvl = new bvl();
    for (;;)
    {
      try
      {
        str = paramString + ".finderFeed";
        if ((paramMap.isEmpty()) || (!paramMap.containsKey(str + ".objectId"))) {
          continue;
        }
        localbvl.objectId = Util.nullAsNil((String)paramMap.get(str + ".objectId"));
        localbvl.objectNonceId = Util.nullAsNil((String)paramMap.get(str + ".objectNonceId"));
        localbvl.GfT = Util.safeParseInt((String)paramMap.get(str + ".feedType"));
        localbvl.nickname = Util.nullAsNil((String)paramMap.get(str + ".nickname"));
        localbvl.username = Util.nullAsNil((String)paramMap.get(str + ".username"));
        localbvl.avatar = Util.nullAsNil((String)paramMap.get(str + ".avatar"));
        localbvl.desc = Util.nullAsNil((String)paramMap.get(str + ".desc"));
        localbvl.hGP = Util.safeParseInt((String)paramMap.get(str + ".mediaCount"));
        localbvl.localId = Util.safeParseLong((String)paramMap.get(str + ".localId"));
        localbvl.authIconType = Util.safeParseInt((String)paramMap.get(str + ".authIconType"));
        localbvl.authIconUrl = Util.nullAsNil((String)paramMap.get(str + ".authIconUrl"));
        i = 0;
        if (i >= localbvl.hGP) {
          continue;
        }
        localbvj = new bvj();
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
        bvj localbvj;
        Log.e("MicroMsg.FinderShareParser", "parse error! %s", new Object[] { paramString.getMessage() });
        continue;
        continue;
      }
      localbvj.mediaType = Util.safeParseInt((String)paramMap.get(paramString + ".mediaType"));
      localbvj.url = Util.nullAsNil((String)paramMap.get(paramString + ".url"));
      localbvj.thumbUrl = Util.nullAsNil((String)paramMap.get(paramString + ".thumbUrl"));
      localbvj.HaI = Util.nullAsNil((String)paramMap.get(paramString + ".fullCoverUrl"));
      localbvj.aacS = Util.nullAsNil((String)paramMap.get(paramString + ".fullClipInset"));
      localbvj.width = Util.safeParseFloat((String)paramMap.get(paramString + ".width"));
      localbvj.height = Util.safeParseFloat((String)paramMap.get(paramString + ".height"));
      localbvj.aacR = Util.safeParseInt((String)paramMap.get(paramString + ".videoPlayDuration"));
      localbvl.mediaList.add(localbvj);
      i += 1;
    }
    paramString = str + ".megaVideo";
    localbvl.aacT = Util.nullAsNil((String)paramMap.get(paramString + ".objectId"));
    localbvl.aacU = Util.nullAsNil((String)paramMap.get(paramString + ".objectNonceId"));
    localbvl.hUQ = Util.nullAsNil((String)paramMap.get(str + ".bizUsername"));
    localbvl.mIK = Util.nullAsNil((String)paramMap.get(str + ".bizNickname"));
    localbvl.aacV = Util.nullAsNil((String)paramMap.get(str + ".bizAvatar"));
    localbvl.aacW = Util.nullAsNil((String)paramMap.get(str + ".bizUsernameV2"));
    localbvl.aacX = Util.safeParseInt((String)paramMap.get(str + ".bizAuthIconType"));
    localbvl.aacY = Util.nullAsNil((String)paramMap.get(str + ".bizAuthIconUrl"));
    AppMethodBeat.o(164041);
    return localbvl;
  }
  
  public static bvl D(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(274228);
    localbvl = new bvl();
    for (;;)
    {
      try
      {
        str = paramString + ".finder_feed";
        if ((paramMap.isEmpty()) || (!paramMap.containsKey(str + ".object_id"))) {
          continue;
        }
        localbvl.objectId = Util.nullAsNil((String)paramMap.get(str + ".object_id"));
        localbvl.objectNonceId = Util.nullAsNil((String)paramMap.get(str + ".object_nonce_id"));
        localbvl.GfT = Util.safeParseInt((String)paramMap.get(str + ".feed_type"));
        localbvl.nickname = Util.nullAsNil((String)paramMap.get(str + ".nickname"));
        localbvl.username = Util.nullAsNil((String)paramMap.get(str + ".username"));
        localbvl.avatar = Util.nullAsNil((String)paramMap.get(str + ".avatar"));
        localbvl.desc = Util.nullAsNil((String)paramMap.get(str + ".desc"));
        localbvl.hGP = Util.safeParseInt((String)paramMap.get(str + ".media_count"));
        localbvl.localId = Util.safeParseLong((String)paramMap.get(str + ".local_id"));
        i = 0;
        if (i >= localbvl.hGP) {
          continue;
        }
        localbvj = new bvj();
        paramString = str + ".media_list.media";
        if (i <= 0) {
          continue;
        }
        paramString = paramString + i;
      }
      catch (Exception paramString)
      {
        String str;
        int i;
        bvj localbvj;
        boolean bool;
        Log.e("MicroMsg.FinderShareParser", "parse error! %s", new Object[] { paramString.getMessage() });
        paramString = null;
        continue;
        paramString = localbvl;
        continue;
        continue;
      }
      localbvj.mediaType = Util.safeParseInt((String)paramMap.get(paramString + ".media_type"));
      localbvj.url = Util.nullAsNil((String)paramMap.get(paramString + ".url"));
      localbvj.thumbUrl = Util.nullAsNil((String)paramMap.get(paramString + ".thumb_url"));
      localbvj.HaI = Util.nullAsNil((String)paramMap.get(paramString + ".full_cover_url"));
      localbvj.aacS = Util.nullAsNil((String)paramMap.get(paramString + ".full_clip_inset"));
      localbvj.width = Util.safeParseFloat((String)paramMap.get(paramString + ".width"));
      localbvj.height = Util.safeParseFloat((String)paramMap.get(paramString + ".height"));
      localbvj.aacR = Util.safeParseInt((String)paramMap.get(paramString + ".video_play_duration"));
      localbvl.mediaList.add(localbvj);
      i += 1;
    }
    paramString = str + ".mega_video";
    localbvl.aacT = Util.nullAsNil((String)paramMap.get(paramString + ".object_id"));
    localbvl.aacU = Util.nullAsNil((String)paramMap.get(paramString + ".object_nonce_id"));
    localbvl.hUQ = Util.nullAsNil((String)paramMap.get(".msg.fromusername"));
    localbvl.mIK = localbvl.nickname;
    localbvl.aacV = localbvl.avatar;
    localbvl.aacW = localbvl.hUQ;
    if (!Util.isNullOrNil(localbvl.objectId))
    {
      bool = Util.isNullOrNil(localbvl.objectNonceId);
      if (!bool) {}
    }
    else
    {
      paramString = null;
      AppMethodBeat.o(274228);
      return paramString;
    }
  }
  
  public static doc E(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(274258);
    doc localdoc = new doc();
    for (;;)
    {
      try
      {
        str = paramString + ".finderMegaVideo";
        if ((paramMap.isEmpty()) || (!paramMap.containsKey(str + ".objectId"))) {
          continue;
        }
        localdoc.objectId = Util.nullAsNil((String)paramMap.get(str + ".objectId"));
        localdoc.objectNonceId = Util.nullAsNil((String)paramMap.get(str + ".objectNonceId"));
        localdoc.nickname = Util.nullAsNil((String)paramMap.get(str + ".nickname"));
        localdoc.username = Util.nullAsNil((String)paramMap.get(str + ".username"));
        localdoc.avatar = Util.nullAsNil((String)paramMap.get(str + ".avatar"));
        localdoc.desc = Util.nullAsNil((String)paramMap.get(str + ".desc"));
        localdoc.hGP = Util.safeParseInt((String)paramMap.get(str + ".mediaCount"));
        i = 0;
        if (i >= localdoc.hGP) {
          continue;
        }
        localdob = new dob();
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
        dob localdob;
        Log.e("MicroMsg.FinderShareParser", "parse error! %s", new Object[] { paramString.getMessage() });
        continue;
        continue;
      }
      localdob.url = Util.nullAsNil((String)paramMap.get(paramString + ".url"));
      localdob.thumbUrl = Util.nullAsNil((String)paramMap.get(paramString + ".thumbUrl"));
      localdob.width = Util.safeParseFloat((String)paramMap.get(paramString + ".width"));
      localdob.height = Util.safeParseFloat((String)paramMap.get(paramString + ".height"));
      localdob.coverUrl = Util.nullAsNil((String)paramMap.get(paramString + ".coverUrl"));
      localdob.aacR = Util.safeParseInt((String)paramMap.get(paramString + ".videoPlayDuration"));
      localdoc.mediaList.add(localdob);
      i += 1;
    }
    paramString = str + ".finderFeed";
    localdoc.aaVe = Util.nullAsNil((String)paramMap.get(paramString + ".objectId"));
    localdoc.PMd = Util.nullAsNil((String)paramMap.get(paramString + ".objectNonceId"));
    AppMethodBeat.o(274258);
    return localdoc;
  }
  
  public static bvn F(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164043);
    bvn localbvn = new bvn();
    paramString = paramString + ".finderTopic";
    if (!paramMap.isEmpty())
    {
      localbvn.topic = Util.nullAsNil((String)paramMap.get(paramString + ".topic"));
      localbvn.Auy = Util.getInt((String)paramMap.get(paramString + ".topicType"), -1);
      localbvn.iconUrl = Util.nullAsNil((String)paramMap.get(paramString + ".iconUrl"));
      localbvn.desc = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
      localbvn.aadd = Util.nullAsNil((String)paramMap.get(paramString + ".patMusicId"));
      Object localObject = new bvi();
      ((bvi)localObject).ZWG = ((String)paramMap.get(paramString + ".location.poiClassifyId"));
      ((bvi)localObject).longitude = Util.getFloat((String)paramMap.get(paramString + ".location.longitude"), 0.0F);
      ((bvi)localObject).latitude = Util.getFloat((String)paramMap.get(paramString + ".location.latitude"), 0.0F);
      localbvn.aadc = ((bvi)localObject);
      if (paramMap.get(paramString + ".event.topicId") != null)
      {
        localObject = new atg();
        ((atg)localObject).ZDJ = Util.nullAsNil((String)paramMap.get(paramString + ".event.topicId"));
        ((atg)localObject).ZDK = Util.nullAsNil((String)paramMap.get(paramString + ".event.name"));
        ((atg)localObject).ZDL = Util.nullAsNil((String)paramMap.get(paramString + ".event.creatorNickName"));
        ((atg)localObject).FOi = Util.getLong((String)paramMap.get(paramString + ".event.hiddenMark"), 0L);
        ((atg)localObject).svG = Util.nullAsNil((String)paramMap.get(paramString + ".event.title"));
        localbvn.aade = ((atg)localObject);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(164043);
      return localbvn;
      localbvn.topic = "";
      localbvn.Auy = -1;
      localbvn.iconUrl = "";
      localbvn.desc = "";
      localbvn.aadc = new bvi();
    }
  }
  
  public static bvn G(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(274324);
    bvn localbvn = new bvn();
    paramString = paramString + ".finderTopicShareItem";
    if (!paramMap.isEmpty())
    {
      localbvn.topic = Util.nullAsNil((String)paramMap.get(paramString + ".topic"));
      localbvn.Auy = Util.getInt((String)paramMap.get(paramString + ".topicType"), -1);
      localbvn.iconUrl = Util.nullAsNil((String)paramMap.get(paramString + ".iconUrl"));
      localbvn.desc = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
      localbvn.aadd = Util.nullAsNil((String)paramMap.get(paramString + ".patMusicId"));
      Object localObject = new bvi();
      ((bvi)localObject).ZWG = ((String)paramMap.get(paramString + ".location.poiClassifyId"));
      ((bvi)localObject).longitude = Util.getFloat((String)paramMap.get(paramString + ".location.longitude"), 0.0F);
      ((bvi)localObject).latitude = Util.getFloat((String)paramMap.get(paramString + ".location.latitude"), 0.0F);
      localbvn.aadc = ((bvi)localObject);
      if (paramMap.get(paramString + ".event.topicId") != null)
      {
        localObject = new atg();
        ((atg)localObject).ZDJ = Util.nullAsNil((String)paramMap.get(paramString + ".event.topicId"));
        ((atg)localObject).ZDK = Util.nullAsNil((String)paramMap.get(paramString + ".event.name"));
        ((atg)localObject).ZDL = Util.nullAsNil((String)paramMap.get(paramString + ".event.creatorNickName"));
        ((atg)localObject).FOi = Util.getLong((String)paramMap.get(paramString + ".event.hiddenMark"), 0L);
        ((atg)localObject).svG = Util.nullAsNil((String)paramMap.get(paramString + ".event.title"));
        localbvn.aade = ((atg)localObject);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(274324);
      return localbvn;
      localbvn.topic = "";
      localbvn.Auy = -1;
      localbvn.iconUrl = "";
      localbvn.desc = "";
      localbvn.aadc = new bvi();
    }
  }
  
  public static bvh H(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(274329);
    bvh localbvh = new bvh();
    String str = paramString + ".finderColumn";
    if (!paramMap.isEmpty())
    {
      localbvh.AEA = new b(Base64.decode(Util.nullAsNil((String)paramMap.get(str + ".cardbuffer")), 0));
      paramString = Util.nullAsNil((String)paramMap.get(str + ".iconUrl"));
      Object localObject3 = Util.nullAsNil((String)paramMap.get(str + ".iconUrl_1"));
      Object localObject2 = Util.nullAsNil((String)paramMap.get(str + ".iconUrl_2"));
      Object localObject1 = Util.nullAsNil((String)paramMap.get(str + ".iconUrl_3"));
      paramString = paramString.split("&token");
      localbvh.aacP.add(paramString[0]);
      LinkedList localLinkedList = localbvh.aacQ;
      if (paramString.length > 1)
      {
        paramString = "&token" + paramString[1];
        localLinkedList.add(paramString);
        paramString = ((String)localObject3).split("&token");
        localbvh.aacP.add(paramString[0]);
        localObject3 = localbvh.aacQ;
        if (paramString.length <= 1) {
          break label584;
        }
        paramString = "&token" + paramString[1];
        label336:
        ((LinkedList)localObject3).add(paramString);
        paramString = ((String)localObject2).split("&token");
        localbvh.aacP.add(paramString[0]);
        localObject2 = localbvh.aacQ;
        if (paramString.length <= 1) {
          break label591;
        }
        paramString = "&token" + paramString[1];
        label395:
        ((LinkedList)localObject2).add(paramString);
        paramString = ((String)localObject1).split("&token");
        localbvh.aacP.add(paramString[0]);
        localObject1 = localbvh.aacQ;
        if (paramString.length <= 1) {
          break label598;
        }
        paramString = "&token" + paramString[1];
        label454:
        ((LinkedList)localObject1).add(paramString);
        localbvh.cardId = Util.nullAsNil((String)paramMap.get(str + ".cardId"));
        localbvh.title = Util.nullAsNil((String)paramMap.get(str + ".title"));
        localbvh.uCW = Util.nullAsNil((String)paramMap.get(str + ".secondTitle"));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(274329);
      return localbvh;
      paramString = "";
      break;
      label584:
      paramString = "";
      break label336;
      label591:
      paramString = "";
      break label395;
      label598:
      paramString = "";
      break label454;
      localbvh.cardId = "";
      localbvh.title = "";
      localbvh.uCW = "";
      localbvh.AEA = null;
    }
  }
  
  public static bvm I(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(274332);
    bvm localbvm = new bvm();
    paramString = paramString + ".finderpoirelatedstream";
    if (!paramMap.isEmpty())
    {
      localbvm.aada = Util.nullAsNil((String)paramMap.get(paramString + ".longitudeString"));
      localbvm.aacZ = Util.nullAsNil((String)paramMap.get(paramString + ".latitudeString"));
      localbvm.poiName = Util.nullAsNil((String)paramMap.get(paramString + ".poiName"));
      localbvm.aadb = Util.nullAsNil((String)paramMap.get(paramString + ".poiScaleString"));
      localbvm.oDI = Util.nullAsNil((String)paramMap.get(paramString + ".address"));
      localbvm.XOv = Util.nullAsNil((String)paramMap.get(paramString + ".infoUrl"));
      localbvm.ZWG = Util.nullAsNil((String)paramMap.get(paramString + ".poiClassifyId"));
    }
    for (localbvm.AXm = Util.nullAsNil((String)paramMap.get(paramString + ".poiCategories"));; localbvm.AXm = "")
    {
      AppMethodBeat.o(274332);
      return localbvm;
      localbvm.aada = "";
      localbvm.aacZ = "";
      localbvm.poiName = "";
      localbvm.aadb = "";
      localbvm.oDI = "";
      localbvm.XOv = "";
      localbvm.ZWG = "";
    }
  }
  
  public static String a(bvh parambvh)
  {
    AppMethodBeat.i(274327);
    StringBuilder localStringBuilder = new StringBuilder();
    if (parambvh != null) {}
    for (;;)
    {
      int i;
      String str;
      try
      {
        if (!Util.isNullOrNil(parambvh.cardId))
        {
          localStringBuilder.append("<finderColumn><cardId>").append(Util.escapeStringForXml(parambvh.cardId)).append("</cardId><title>").append(Util.escapeStringForXml(parambvh.title)).append("</title><secondTitle>").append(Util.escapeStringForXml(parambvh.uCW)).append("</secondTitle>");
          i = 0;
          if (i >= parambvh.aacP.size()) {
            break label284;
          }
          str = (String)parambvh.aacP.get(i) + (String)parambvh.aacQ.get(i);
          if (i == 0) {
            localStringBuilder.append("<iconUrl>").append(XmlParser.getCDataWrapper(str)).append("</iconUrl>");
          } else if (i == 1) {
            localStringBuilder.append("<iconUrl_1>").append(XmlParser.getCDataWrapper(str)).append("</iconUrl_1>");
          }
        }
      }
      catch (Exception parambvh)
      {
        Log.e("MicroMsg.FinderShareParser", "make content error! %s", new Object[] { parambvh.getMessage() });
      }
      for (;;)
      {
        parambvh = localStringBuilder.toString();
        AppMethodBeat.o(274327);
        return parambvh;
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
        label284:
        if (parambvh.AEA != null)
        {
          parambvh = new String(Base64.encode(parambvh.AEA.toByteArray(), 0));
          localStringBuilder.append("<cardbuffer>").append(XmlParser.getCDataWrapper(parambvh)).append("</cardbuffer>");
        }
        localStringBuilder.append("</finderColumn>");
      }
      i += 1;
    }
  }
  
  public static String a(bvm parambvm)
  {
    AppMethodBeat.i(274331);
    StringBuilder localStringBuilder = new StringBuilder();
    if (parambvm != null)
    {
      localStringBuilder.append("<finderpoirelatedstream><longitudeString>").append(Util.escapeStringForXml(parambvm.aada)).append("</longitudeString><latitudeString>").append(Util.escapeStringForXml(parambvm.aacZ)).append("</latitudeString><poiName>").append(Util.escapeStringForXml(parambvm.poiName)).append("</poiName><poiScaleString>").append(Util.escapeStringForXml(parambvm.aadb)).append("</poiScaleString><address>").append(Util.escapeStringForXml(parambvm.oDI)).append("</address><infoUrl>").append(XmlParser.getCDataWrapper(parambvm.XOv)).append("</infoUrl><poiClassifyId>").append(Util.escapeStringForXml(parambvm.ZWG)).append("</poiClassifyId><poiCategories>").append(Util.escapeStringForXml(parambvm.AXm)).append("</poiCategories>");
      localStringBuilder.append("</finderpoirelatedstream>");
    }
    parambvm = localStringBuilder.toString();
    AppMethodBeat.o(274331);
    return parambvm;
  }
  
  public static String a(bvn parambvn)
  {
    AppMethodBeat.i(164042);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((parambvn != null) && (!Util.isNullOrNil(parambvn.topic)))
    {
      localStringBuilder.append("<finderTopic><topic>").append(Util.escapeStringForXml(parambvn.topic)).append("</topic><topicType>").append(parambvn.Auy).append("</topicType><iconUrl>").append(XmlParser.getCDataWrapper(parambvn.iconUrl)).append("</iconUrl><desc>").append(Util.escapeStringForXml(parambvn.desc)).append("</desc><patMusicId>").append(Util.escapeStringForXml(parambvn.aadd)).append("</patMusicId>");
      if (parambvn.aadc != null) {
        localStringBuilder.append("<location><poiClassifyId>").append(Util.escapeStringForXml(parambvn.aadc.ZWG)).append("</poiClassifyId><longitude>").append(parambvn.aadc.longitude).append("</longitude><latitude>").append(parambvn.aadc.latitude).append("</latitude></location>");
      }
      if (parambvn.aade != null) {
        localStringBuilder.append("<event><topicId>").append(parambvn.aade.ZDJ).append("</topicId><name>").append(Util.escapeStringForXml(parambvn.aade.ZDK)).append("</name><creatorNickName>").append(Util.escapeStringForXml(parambvn.aade.ZDL)).append("</creatorNickName><hiddenMark>").append(parambvn.aade.FOi).append("</hiddenMark><title>").append(Util.escapeStringForXml(parambvn.aade.svG)).append("</title></event>");
      }
      localStringBuilder.append("</finderTopic>");
    }
    parambvn = localStringBuilder.toString();
    AppMethodBeat.o(164042);
    return parambvn;
  }
  
  public static String b(bvh parambvh)
  {
    AppMethodBeat.i(274330);
    StringBuilder localStringBuilder = new StringBuilder();
    if (parambvh != null) {}
    for (;;)
    {
      int i;
      String str;
      try
      {
        localStringBuilder.append("<finderContentColumnSharedItem><cardId>").append(Util.escapeStringForXml(parambvh.cardId)).append("</cardId><title>").append(Util.escapeStringForXml(parambvh.title)).append("</title><secondTitle>").append(Util.escapeStringForXml(parambvh.uCW)).append("</secondTitle>");
        i = 0;
        if (i < parambvh.aacP.size())
        {
          str = (String)parambvh.aacP.get(i) + (String)parambvh.aacQ.get(i);
          if (i == 0) {
            localStringBuilder.append("<iconUrl>").append(XmlParser.getCDataWrapper(str)).append("</iconUrl>");
          } else if (i == 1) {
            localStringBuilder.append("<iconUrl_1>").append(XmlParser.getCDataWrapper(str)).append("</iconUrl_1>");
          }
        }
      }
      catch (Exception parambvh)
      {
        Log.e("MicroMsg.FinderShareParser", "make content error! %s", new Object[] { parambvh.getMessage() });
      }
      for (;;)
      {
        parambvh = localStringBuilder.toString();
        AppMethodBeat.o(274330);
        return parambvh;
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
        if (parambvh.AEA != null)
        {
          parambvh = new String(Base64.encode(parambvh.AEA.toByteArray(), 0));
          localStringBuilder.append("<cardbuffer>").append(XmlParser.getCDataWrapper(parambvh)).append("</cardbuffer>");
        }
        localStringBuilder.append("</finderContentColumnSharedItem>");
      }
      i += 1;
    }
  }
  
  public static String b(bvn parambvn)
  {
    AppMethodBeat.i(274319);
    StringBuilder localStringBuilder = new StringBuilder();
    if (parambvn != null)
    {
      localStringBuilder.append("<finderTopicShareItem><topic>").append(Util.escapeStringForXml(parambvn.topic)).append("</topic><topicType>").append(parambvn.Auy).append("</topicType><iconUrl>").append(XmlParser.getCDataWrapper(parambvn.iconUrl)).append("</iconUrl><desc>").append(Util.escapeStringForXml(parambvn.desc)).append("</desc><patMusicId>").append(Util.escapeStringForXml(parambvn.aadd)).append("</patMusicId>");
      if (parambvn.aadc != null) {
        localStringBuilder.append("<location><poiClassifyId>").append(Util.escapeStringForXml(parambvn.aadc.ZWG)).append("</poiClassifyId><longitude>").append(parambvn.aadc.longitude).append("</longitude><latitude>").append(parambvn.aadc.latitude).append("</latitude></location>");
      }
      if (parambvn.aade != null) {
        localStringBuilder.append("<event><topicId>").append(parambvn.aade.ZDJ).append("</topicId><name>").append(Util.escapeStringForXml(parambvn.aade.ZDK)).append("</name><creatorNickName>").append(Util.escapeStringForXml(parambvn.aade.ZDL)).append("</creatorNickName><hiddenMark>").append(parambvn.aade.FOi).append("</hiddenMark><title>").append(Util.escapeStringForXml(parambvn.aade.svG)).append("</title></event>");
      }
      localStringBuilder.append("</finderTopicShareItem>");
    }
    parambvn = localStringBuilder.toString();
    AppMethodBeat.o(274319);
    return parambvn;
  }
  
  public static String b(doc paramdoc)
  {
    AppMethodBeat.i(274152);
    StringBuilder localStringBuilder = new StringBuilder();
    dob localdob;
    String str;
    if (paramdoc != null) {
      try
      {
        if (!Util.isNullOrNil(paramdoc.objectId))
        {
          localStringBuilder.append("<finderMegaVideo><objectId>").append(paramdoc.objectId).append("</objectId><objectNonceId>").append(paramdoc.objectNonceId).append("</objectNonceId><nickname>").append(Util.escapeStringForXml(paramdoc.nickname)).append("</nickname><avatar>").append(XmlParser.getCDataWrapper(paramdoc.avatar)).append("</avatar><desc>").append(Util.escapeStringForXml(paramdoc.desc)).append("</desc><username>").append(Util.escapeStringForXml(paramdoc.username)).append("</username><mediaCount>").append(paramdoc.hGP).append("</mediaCount>");
          localStringBuilder.append("<mediaList>");
          Iterator localIterator = paramdoc.mediaList.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label337;
            }
            localdob = (dob)localIterator.next();
            if (TextUtils.isEmpty(localdob.coverUrl)) {
              break;
            }
            str = XmlParser.getCDataWrapper(localdob.coverUrl);
            localStringBuilder.append("<media><url>").append(XmlParser.getCDataWrapper(localdob.url)).append("</url><thumbUrl>").append(XmlParser.getCDataWrapper(localdob.thumbUrl)).append("</thumbUrl><width>").append(localdob.width).append("</width><height>").append(localdob.height).append("</height><coverUrl>").append(str).append("</coverUrl><videoPlayDuration>").append(localdob.aacR).append("</videoPlayDuration></media>");
          }
        }
        paramdoc = localStringBuilder.toString();
      }
      catch (Exception paramdoc)
      {
        Log.e("MicroMsg.FinderShareParser", "make content error! %s", new Object[] { paramdoc.getMessage() });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(274152);
      return paramdoc;
      str = XmlParser.getCDataWrapper(localdob.thumbUrl);
      break;
      label337:
      localStringBuilder.append("</mediaList>");
      localStringBuilder.append("<finderFeed>");
      localStringBuilder.append("<objectId>").append(paramdoc.aaVe).append("</objectId>");
      localStringBuilder.append("<objectNonceId>").append(paramdoc.PMd).append("</objectNonceId>");
      localStringBuilder.append("</finderFeed>");
      localStringBuilder.append("</finderMegaVideo>");
    }
  }
  
  public static String bJ(int paramInt, String paramString)
  {
    AppMethodBeat.i(274333);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<finder><type>").append(paramInt).append("</type><detail>").append(paramString).append("</detail>");
    localStringBuilder.append("</finder>");
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(274333);
    return paramString;
  }
  
  public static String c(bmr parambmr)
  {
    AppMethodBeat.i(274014);
    StringBuilder localStringBuilder = new StringBuilder();
    if (parambmr != null) {}
    try
    {
      if (!Util.isNullOrNil(parambmr.liveId))
      {
        localStringBuilder.append("<finderLive><finderLiveID>").append(parambmr.liveId).append("</finderLiveID><finderUsername>").append(Util.escapeStringForXml(parambmr.username)).append("</finderUsername><finderObjectID>").append(parambmr.feedId).append("</finderObjectID><nickname>").append(XmlParser.getCDataWrapper(parambmr.nickName)).append("</nickname><desc>").append(XmlParser.getCDataWrapper(parambmr.desc)).append("</desc><finderNonceID>").append(Util.escapeStringForXml(parambmr.objectNonceId)).append("</finderNonceID><headUrl>").append(XmlParser.getCDataWrapper(parambmr.headUrl)).append("</headUrl><extFlag>").append(XmlParser.getCDataWrapper(String.valueOf(parambmr.extFlag))).append("</extFlag><media><coverUrl>").append(XmlParser.getCDataWrapper(parambmr.coverUrl)).append("</coverUrl><height>").append(parambmr.height).append("</height><width>").append(parambmr.width).append("</width></media><liveStatus>").append(parambmr.liveStatus).append("</liveStatus><sourceType>").append(parambmr.sourceType).append("</sourceType><ecSource>").append(XmlParser.getCDataWrapper(parambmr.ecSource)).append("</ecSource><authIconType>").append(parambmr.authIconType).append("</authIconType><authIconUrl>").append(XmlParser.getCDataWrapper(parambmr.ZVk)).append("</authIconUrl><bindType>").append(parambmr.mIJ).append("</bindType><bizUsername>").append(XmlParser.getCDataWrapper(parambmr.hUQ)).append("</bizUsername><bizNickname>").append(XmlParser.getCDataWrapper(parambmr.mIK)).append("</bizNickname><chargeFlag>").append(parambmr.ZVl).append("</chargeFlag><liveNickname>").append(XmlParser.getCDataWrapper(parambmr.ZVn)).append("</liveNickname><liveUsername>").append(XmlParser.getCDataWrapper(parambmr.ZVo)).append("</liveUsername><byPassInfoString>").append(XmlParser.getCDataWrapper(parambmr.ZVp)).append("</byPassInfoString><relayIndex>").append(XmlParser.getCDataWrapper(parambmr.ZVq)).append("</relayIndex><eventNickname>").append(XmlParser.getCDataWrapper(parambmr.ZVr)).append("</eventNickname><eventHeadUrl>").append(XmlParser.getCDataWrapper(parambmr.ZVs)).append("</eventHeadUrl><eventId>").append(XmlParser.getCDataWrapper(parambmr.eventId)).append("</eventId><participantIdentity>").append(XmlParser.getCDataWrapper(parambmr.ZVt)).append("</participantIdentity><eventStatus>").append(XmlParser.getCDataWrapper(parambmr.ZVu)).append("</eventStatus><streamStatus>").append(XmlParser.getCDataWrapper(parambmr.ZVv)).append("</streamStatus>");
        localStringBuilder.append("</finderLive>");
      }
      parambmr = localStringBuilder.toString();
      AppMethodBeat.o(274014);
      return parambmr;
    }
    catch (Exception parambmr)
    {
      for (;;)
      {
        Log.e("MicroMsg.FinderShareParser", "make content error! %s", new Object[] { parambmr.getMessage() });
      }
    }
  }
  
  public static String c(bth parambth)
  {
    AppMethodBeat.i(274028);
    StringBuilder localStringBuilder = new StringBuilder();
    if (parambth != null) {}
    try
    {
      localStringBuilder.append("<finderLiveProductShare>");
      localStringBuilder.append("<finderLiveID>").append(XmlParser.getCDataWrapper(parambth.aabe)).append("</finderLiveID><finderUsername>").append(XmlParser.getCDataWrapper(parambth.finderUsername)).append("</finderUsername><finderObjectID>").append(XmlParser.getCDataWrapper(parambth.aabf)).append("</finderObjectID><finderNonceID>").append(XmlParser.getCDataWrapper(parambth.aabg)).append("</finderNonceID><liveStatus>").append(XmlParser.getCDataWrapper(parambth.aabh)).append("</liveStatus><appId>").append(XmlParser.getCDataWrapper(parambth.appId)).append("</appId><pagePath>").append(XmlParser.getCDataWrapper(parambth.hzy)).append("</pagePath><productId>").append(XmlParser.getCDataWrapper(parambth.productId)).append("</productId><coverUrl>").append(XmlParser.getCDataWrapper(parambth.coverUrl)).append("</coverUrl><productTitle>").append(XmlParser.getCDataWrapper(parambth.aabi)).append("</productTitle><marketPrice>").append(XmlParser.getCDataWrapper(Integer.toString(parambth.aabj))).append("</marketPrice><sellingPrice>").append(XmlParser.getCDataWrapper(Integer.toString(parambth.aabk))).append("</sellingPrice><platformHeadImg>").append(XmlParser.getCDataWrapper(parambth.aabl)).append("</platformHeadImg><platformName>").append(XmlParser.getCDataWrapper(parambth.ESn)).append("</platformName><shopWindowId>").append(XmlParser.getCDataWrapper(parambth.DGl)).append("</shopWindowId>");
      localStringBuilder.append("</finderLiveProductShare>");
      parambth = localStringBuilder.toString();
      AppMethodBeat.o(274028);
      return parambth;
    }
    catch (Exception parambth)
    {
      for (;;)
      {
        Log.e("MicroMsg.FinderShareParser", "make content error! %s", new Object[] { parambth.getMessage() });
      }
    }
  }
  
  public static String d(bmr parambmr)
  {
    AppMethodBeat.i(274035);
    StringBuilder localStringBuilder = new StringBuilder();
    if (parambmr != null) {}
    try
    {
      if (!Util.isNullOrNil(parambmr.liveId))
      {
        localStringBuilder.append("<finderLiveInvite><finderLiveID>").append(parambmr.liveId).append("</finderLiveID><finderUsername>").append(Util.escapeStringForXml(parambmr.username)).append("</finderUsername><finderObjectID>").append(parambmr.feedId).append("</finderObjectID><nickname>").append(XmlParser.getCDataWrapper(parambmr.nickName)).append("</nickname><desc>").append(XmlParser.getCDataWrapper(parambmr.desc)).append("</desc><finderNonceID>").append(Util.escapeStringForXml(parambmr.objectNonceId)).append("</finderNonceID><headUrl>").append(XmlParser.getCDataWrapper(parambmr.headUrl)).append("</headUrl><coverUrl>").append(XmlParser.getCDataWrapper(parambmr.headUrl)).append("</coverUrl><liveMicId>").append(Util.escapeStringForXml(parambmr.ZVi)).append("</liveMicId><liveMicSdkUserId>").append(Util.escapeStringForXml(parambmr.ZVj)).append("</liveMicSdkUserId>");
        localStringBuilder.append("</finderLiveInvite>");
      }
      parambmr = localStringBuilder.toString();
      AppMethodBeat.o(274035);
      return parambmr;
    }
    catch (Exception parambmr)
    {
      for (;;)
      {
        Log.e("MicroMsg.FinderShareParser", "make content error! %s", new Object[] { parambmr.getMessage() });
      }
    }
  }
  
  public static String d(bvl parambvl)
  {
    AppMethodBeat.i(164040);
    StringBuilder localStringBuilder = new StringBuilder();
    if (parambvl != null) {
      try
      {
        if (!Util.isNullOrNil(parambvl.objectId))
        {
          localStringBuilder.append("<finderFeed><objectId>").append(Util.nullAsNil(parambvl.objectId)).append("</objectId><objectNonceId>").append(Util.nullAsNil(parambvl.objectNonceId)).append("</objectNonceId><feedType>").append(parambvl.GfT).append("</feedType><nickname>").append(Util.escapeStringForXml(parambvl.nickname)).append("</nickname><username>").append(Util.escapeStringForXml(parambvl.username)).append("</username><avatar>").append(XmlParser.getCDataWrapper(parambvl.avatar)).append("</avatar><desc>").append(Util.escapeStringForXml(parambvl.desc)).append("</desc><mediaCount>").append(parambvl.hGP).append("</mediaCount><localId>").append(parambvl.localId).append("</localId><authIconType>").append(parambvl.authIconType).append("</authIconType><authIconUrl>").append(XmlParser.getCDataWrapper(parambvl.authIconUrl)).append("</authIconUrl>");
          localStringBuilder.append("<mediaList>");
          Iterator localIterator = parambvl.mediaList.iterator();
          while (localIterator.hasNext())
          {
            bvj localbvj = (bvj)localIterator.next();
            localStringBuilder.append("<media><mediaType>").append(localbvj.mediaType).append("</mediaType><url>").append(XmlParser.getCDataWrapper(localbvj.url)).append("</url><thumbUrl>").append(XmlParser.getCDataWrapper(localbvj.thumbUrl)).append("</thumbUrl><fullCoverUrl>").append(XmlParser.getCDataWrapper(localbvj.HaI)).append("</fullCoverUrl><fullClipInset>").append(XmlParser.getCDataWrapper(localbvj.aacS)).append("</fullClipInset><width>").append(localbvj.width).append("</width><height>").append(localbvj.height).append("</height><videoPlayDuration>").append(localbvj.aacR).append("</videoPlayDuration></media>");
          }
        }
        parambvl = localStringBuilder.toString();
      }
      catch (Exception parambvl)
      {
        Log.e("MicroMsg.FinderShareParser", "make content error! %s", new Object[] { parambvl.getMessage() });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(164040);
      return parambvl;
      localStringBuilder.append("</mediaList>");
      localStringBuilder.append("<megaVideo>");
      localStringBuilder.append("<objectId>").append(Util.nullAsNil(parambvl.aacT)).append("</objectId>");
      localStringBuilder.append("<objectNonceId>").append(Util.nullAsNil(parambvl.aacU)).append("</objectNonceId>");
      localStringBuilder.append("</megaVideo>");
      localStringBuilder.append("<bizUsername>").append(Util.escapeStringForXml(parambvl.hUQ)).append("</bizUsername>");
      localStringBuilder.append("<bizNickname>").append(Util.escapeStringForXml(parambvl.mIK)).append("</bizNickname>");
      localStringBuilder.append("<bizAvatar>").append(XmlParser.getCDataWrapper(parambvl.aacV)).append("</bizAvatar>");
      localStringBuilder.append("<bizUsernameV2>").append(Util.escapeStringForXml(parambvl.aacW)).append("</bizUsernameV2>");
      localStringBuilder.append("<bizAuthIconType>").append(parambvl.aacX).append("</bizAuthIconType>");
      localStringBuilder.append("<bizAuthIconUrl>").append(XmlParser.getCDataWrapper(parambvl.aacY)).append("</bizAuthIconUrl>");
      localStringBuilder.append("</finderFeed>");
    }
  }
  
  public static int f(Map<String, String> paramMap, int paramInt)
  {
    AppMethodBeat.i(274335);
    if (paramMap != null) {
      paramInt = Util.getInt((String)paramMap.get(".msg.appmsg.finder.type"), -1);
    }
    AppMethodBeat.o(274335);
    return paramInt;
  }
  
  public static bmr z(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(274057);
    bmr localbmr = new bmr();
    try
    {
      paramString = paramString + ".finderLive";
      if ((!paramMap.isEmpty()) && (paramMap.containsKey(paramString + ".finderLiveID")))
      {
        localbmr.liveId = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveID"));
        localbmr.username = Util.nullAsNil((String)paramMap.get(paramString + ".finderUsername"));
        localbmr.feedId = Util.nullAsNil((String)paramMap.get(paramString + ".finderObjectID"));
        localbmr.nickName = Util.nullAsNil((String)paramMap.get(paramString + ".nickname"));
        localbmr.desc = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
        localbmr.coverUrl = Util.nullAsNil((String)paramMap.get(paramString + ".media.coverUrl")).replace("&amp;", "&");
        localbmr.height = Util.safeParseFloat((String)paramMap.get(paramString + ".media.height"));
        localbmr.width = Util.safeParseFloat((String)paramMap.get(paramString + ".media.width"));
        localbmr.headUrl = Util.nullAsNil((String)paramMap.get(paramString + ".headUrl"));
        localbmr.objectNonceId = Util.nullAsNil((String)paramMap.get(paramString + ".finderNonceID"));
        localbmr.liveStatus = Util.safeParseInt((String)paramMap.get(paramString + ".liveStatus"));
        localbmr.sourceType = Util.safeParseInt((String)paramMap.get(paramString + ".sourceType"));
        localbmr.authIconType = Util.safeParseInt((String)paramMap.get(paramString + ".authIconType"));
        localbmr.ZVk = Util.nullAsNil((String)paramMap.get(paramString + ".authIconUrl"));
        localbmr.mIJ = Util.safeParseInt((String)paramMap.get(paramString + ".bindType"));
        localbmr.hUQ = Util.nullAsNil((String)paramMap.get(paramString + ".bizUsername"));
        localbmr.mIK = Util.nullAsNil((String)paramMap.get(paramString + ".bizNickname"));
        localbmr.ZVl = Util.safeParseInt((String)paramMap.get(paramString + ".chargeFlag"));
        localbmr.ZVn = Util.nullAsNil((String)paramMap.get(paramString + ".liveNickname"));
        localbmr.ZVo = Util.nullAsNil((String)paramMap.get(paramString + ".liveUsername"));
        localbmr.ZVp = Util.nullAsNil((String)paramMap.get(paramString + ".byPassInfoString"));
        localbmr.ZVq = Util.nullAsNil((String)paramMap.get(paramString + ".relayIndex"));
        localbmr.ZVr = Util.nullAsNil((String)paramMap.get(paramString + ".eventNickname"));
        localbmr.ZVs = Util.nullAsNil((String)paramMap.get(paramString + ".eventHeadUrl"));
        localbmr.eventId = Util.nullAsNil((String)paramMap.get(paramString + ".eventId"));
        localbmr.ZVt = Util.nullAsNil((String)paramMap.get(paramString + ".participantIdentity"));
        localbmr.ZVu = Util.nullAsNil((String)paramMap.get(paramString + ".eventStatus"));
        localbmr.ZVv = Util.nullAsNil((String)paramMap.get(paramString + ".streamStatus"));
        if ((localbmr.liveStatus != 1) && (localbmr.liveStatus != 2))
        {
          Log.i("MicroMsg.FinderShareParser", "[parseFinderLive] shareObject.liveStatus = " + localbmr.liveStatus);
          localbmr.liveStatus = 1;
        }
        localbmr.extFlag = Util.safeParseInt((String)paramMap.get(paramString + ".extFlag"));
        localbmr.ecSource = Util.nullAsNil((String)paramMap.get(paramString + ".ecSource"));
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.FinderShareParser", "parse error! %s", new Object[] { paramString.getMessage() });
      }
    }
    AppMethodBeat.o(274057);
    return localbmr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.q
 * JD-Core Version:    0.7.0.1
 */