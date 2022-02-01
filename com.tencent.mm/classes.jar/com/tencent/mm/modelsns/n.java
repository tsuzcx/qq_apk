package com.tencent.mm.modelsns;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.cio;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.dzy;
import com.tencent.mm.protocal.protobuf.eep;
import com.tencent.mm.protocal.protobuf.ek;
import com.tencent.mm.protocal.protobuf.eyd;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.protocal.protobuf.fat;
import com.tencent.mm.protocal.protobuf.fb;
import com.tencent.mm.protocal.protobuf.fc;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.LinkedList;
import java.util.Map;

public final class n
{
  private static float PK(String paramString)
  {
    AppMethodBeat.i(94861);
    if (paramString == null)
    {
      AppMethodBeat.o(94861);
      return 0.0F;
    }
    float f = Util.getFloat(paramString, 0.0F);
    AppMethodBeat.o(94861);
    return f;
  }
  
  private static String PL(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static TimeLineObject PM(String paramString)
  {
    AppMethodBeat.i(94866);
    Map localMap = XmlParser.parseXml(paramString, "TimelineObject", null);
    TimeLineObject localTimeLineObject = bfM();
    Object localObject1;
    int i;
    Object localObject4;
    Object localObject3;
    label1711:
    label2865:
    label2878:
    int j;
    label2949:
    label2999:
    label3049:
    label3199:
    int k;
    if (localMap != null)
    {
      localTimeLineObject.Id = PL((String)localMap.get(".TimelineObject.id"));
      localTimeLineObject.UserName = PL((String)localMap.get(".TimelineObject.username"));
      localTimeLineObject.Privated = Util.getInt((String)localMap.get(".TimelineObject.private"), 0);
      localTimeLineObject.CreateTime = Util.getInt((String)localMap.get(".TimelineObject.createTime"), 0);
      localTimeLineObject.ContentDesc = PL((String)localMap.get(".TimelineObject.contentDesc"));
      localTimeLineObject.contentDescShowType = Util.getInt((String)localMap.get(".TimelineObject.contentDescShowType"), 0);
      localTimeLineObject.contentDescScene = Util.getInt((String)localMap.get(".TimelineObject.contentDescScene"), 0);
      localTimeLineObject.statExtStr = PL((String)localMap.get(".TimelineObject.statExtStr"));
      localTimeLineObject.sightFolded = Util.getInt((String)localMap.get(".TimelineObject.sightFolded"), 0);
      localTimeLineObject.showFlag = Util.getInt((String)localMap.get(".TimelineObject.showFlag"), 0);
      localObject1 = new cjy();
      ((cjy)localObject1).LbC = PK((String)localMap.get(".TimelineObject.location.$longitude"));
      ((cjy)localObject1).LbD = PK((String)localMap.get(".TimelineObject.location.$latitude"));
      ((cjy)localObject1).kea = PL((String)localMap.get(".TimelineObject.location.$city"));
      ((cjy)localObject1).Mpu = Util.getInt((String)localMap.get(".TimelineObject.location.$poiScale"), 0);
      ((cjy)localObject1).LIb = PL((String)localMap.get(".TimelineObject.location.$poiClassifyId"));
      ((cjy)localObject1).Esb = Util.getInt((String)localMap.get(".TimelineObject.location.$poiClassifyType"), 0);
      ((cjy)localObject1).ErZ = PL((String)localMap.get(".TimelineObject.location.$poiAddress"));
      ((cjy)localObject1).kHV = PL((String)localMap.get(".TimelineObject.location.$poiName"));
      ((cjy)localObject1).Mpv = Util.getInt((String)localMap.get(".TimelineObject.location.$poiClickableStatus"), 0);
      ((cjy)localObject1).Mpx = PL((String)localMap.get(".TimelineObject.location.$poiAddressName"));
      ((cjy)localObject1).country = PL((String)localMap.get(".TimelineObject.location.$country"));
      localTimeLineObject.Location = ((cjy)localObject1);
      if (localTimeLineObject.ContentObj == null) {
        localTimeLineObject.ContentObj = new adp();
      }
      localTimeLineObject.ContentObj.Desc = PL((String)localMap.get(".TimelineObject.ContentObject.description"));
      localTimeLineObject.ContentObj.LoU = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.contentStyle"), 0);
      localTimeLineObject.ContentObj.LoW = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.contentSubStyle"), 0);
      localTimeLineObject.ContentObj.Title = PL((String)localMap.get(".TimelineObject.ContentObject.title"));
      localTimeLineObject.ContentObj.Url = PL((String)localMap.get(".TimelineObject.ContentObject.contentUrl"));
      if (localMap.containsKey(".TimelineObject.ContentObject.mmreadershare.itemshowtype"))
      {
        i = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.itemshowtype"), 0);
        if (i != -1)
        {
          localTimeLineObject.ContentObj.LoY = new cli();
          localTimeLineObject.ContentObj.LoY.iAb = i;
          localTimeLineObject.ContentObj.LoY.iwf = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.ispaysubscribe"), 0);
        }
        if (i == 5)
        {
          localTimeLineObject.ContentObj.LoY.iwd = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.pubtime"), 0);
          localTimeLineObject.ContentObj.LoY.vid = PL((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.vid"));
          localTimeLineObject.ContentObj.LoY.coverUrl = PL((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.cover"));
          localTimeLineObject.ContentObj.LoY.iwg = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.funcflag"), 0);
          localTimeLineObject.ContentObj.LoY.duration = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.duration"), 0);
          localTimeLineObject.ContentObj.LoY.desc = PL((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.digest"));
          localTimeLineObject.ContentObj.LoY.iwe = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.nativepage"), 0);
          localTimeLineObject.ContentObj.LoY.videoWidth = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.width"), 0);
          localTimeLineObject.ContentObj.LoY.videoHeight = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.height"), 0);
        }
      }
      i = 0;
      String str25;
      String str24;
      String str23;
      String str22;
      String str21;
      String str18;
      String str19;
      String str17;
      String str16;
      String str20;
      String str11;
      String str10;
      Object localObject6;
      String str15;
      String str14;
      String str13;
      String str12;
      String str9;
      String str8;
      String str7;
      String str6;
      String str5;
      String str4;
      String str3;
      String str2;
      String str1;
      Object localObject5;
      Object localObject2;
      String str27;
      Object localObject7;
      if (i != 0)
      {
        str25 = ".TimelineObject.ContentObject.mediaList.media" + i + ".id";
        str24 = ".TimelineObject.ContentObject.mediaList.media" + i + ".type";
        str23 = ".TimelineObject.ContentObject.mediaList.media" + i + ".title";
        str22 = ".TimelineObject.ContentObject.mediaList.media" + i + ".description";
        str21 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url";
        str18 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$videomd5";
        str19 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb";
        str17 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$type";
        str16 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb.$type";
        str20 = ".TimelineObject.ContentObject.mediaList.media" + i + ".private";
        str11 = ".TimelineObject.ContentObject.mediaList.media" + i + ".subType";
        str10 = ".TimelineObject.ContentObject.mediaList.media" + i + ".userData";
        localObject6 = ".TimelineObject.ContentObject.mediaList.media".concat(String.valueOf(i));
        str15 = ".TimelineObject.ContentObject.mediaList.media" + i + ".lowBandUrl";
        str14 = ".TimelineObject.ContentObject.mediaList.media" + i + ".lowBandUrl.$type";
        str13 = ".TimelineObject.ContentObject.mediaList.media" + i + ".songalbumurl";
        str12 = ".TimelineObject.ContentObject.mediaList.media" + i + ".songlyric";
        str9 = ".TimelineObject.ContentObject.mediaList.media" + i + ".attachUrl";
        str8 = ".TimelineObject.ContentObject.mediaList.media" + i + ".attachUrl.$md5";
        str7 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$md5";
        str6 = ".TimelineObject.ContentObject.mediaList.media" + i + ".videosize.$attachTotalTime";
        str5 = ".TimelineObject.ContentObject.mediaList.media" + i + ".attachThumbUrl";
        str4 = ".TimelineObject.ContentObject.mediaList.media" + i + ".attachShareTitle";
        str3 = ".TimelineObject.ContentObject.mediaList.media" + i + ".enc";
        str2 = ".TimelineObject.ContentObject.mediaList.media" + i + ".enc.$key";
        str1 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$token";
        localObject5 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$enc_idx";
        localObject4 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$key";
        localObject3 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb.$token";
        localObject2 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb.$enc_idx";
        localObject1 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb.$key";
        String str26 = (String)localObject6 + ".size.$width";
        str27 = (String)localObject6 + ".size.$height";
        localObject6 = (String)localObject6 + ".size.$totalSize";
        str26 = (String)localMap.get(str26);
        str27 = (String)localMap.get(str27);
        localObject7 = (String)localMap.get(localObject6);
        localObject6 = new cnd();
        ((cnd)localObject6).Mtp = 0.0F;
        ((cnd)localObject6).Mto = 0.0F;
        ((cnd)localObject6).Mtq = 0.0F;
        if (str26 != null) {
          ((cnd)localObject6).Mto = PK(str26);
        }
        if (str27 != null) {
          ((cnd)localObject6).Mtp = PK(str27);
        }
        if (localObject7 != null) {
          ((cnd)localObject6).Mtq = PK((String)localObject7);
        }
        str25 = (String)localMap.get(str25);
        str24 = (String)localMap.get(str24);
        str23 = (String)localMap.get(str23);
        str22 = (String)localMap.get(str22);
        str26 = (String)localMap.get(str21);
        str21 = (String)localMap.get(".TimelineObject.ContentObject.mediaList.media.videoDuration");
        str20 = (String)localMap.get(str20);
        str19 = (String)localMap.get(str19);
        str18 = (String)localMap.get(str18);
        str17 = (String)localMap.get(str17);
        str16 = (String)localMap.get(str16);
        str15 = (String)localMap.get(str15);
        str14 = (String)localMap.get(str14);
        str13 = (String)localMap.get(str13);
        str12 = (String)localMap.get(str12);
        str11 = (String)localMap.get(str11);
        str10 = (String)localMap.get(str10);
        str9 = (String)localMap.get(str9);
        str8 = (String)localMap.get(str8);
        str7 = (String)localMap.get(str7);
        str6 = (String)localMap.get(str6);
        str5 = (String)localMap.get(str5);
        str4 = (String)localMap.get(str4);
        str3 = (String)localMap.get(str3);
        str2 = (String)localMap.get(str2);
        str1 = (String)localMap.get(str1);
        localObject5 = (String)localMap.get(localObject5);
        localObject4 = (String)localMap.get(localObject4);
        localObject3 = (String)localMap.get(localObject3);
        localObject2 = (String)localMap.get(localObject2);
        str27 = (String)localMap.get(localObject1);
        if ((str24 == null) || (Util.isNullOrNil(str25))) {
          break label2878;
        }
        localObject7 = new cnb();
        ((cnb)localObject7).Id = PL(str25);
        ((cnb)localObject7).oUv = Util.getInt(str24, 0);
        ((cnb)localObject7).Title = PL(str23);
        ((cnb)localObject7).Desc = PL(str22);
        ((cnb)localObject7).Url = PL(str26);
        ((cnb)localObject7).Mcw = Util.getInt(str17, 0);
        ((cnb)localObject7).Msz = PL(str19);
        ((cnb)localObject7).MsA = Util.getInt(str16, 0);
        ((cnb)localObject7).Privated = Util.getInt(str20, 0);
        ((cnb)localObject7).MsB = ((cnd)localObject6);
        ((cnb)localObject7).MsC = PL(str15);
        ((cnb)localObject7).MsD = Util.getInt(str14, 0);
        ((cnb)localObject7).songAlbumUrl = str13;
        ((cnb)localObject7).songLyric = str12;
        ((cnb)localObject7).EpK = PL(str10);
        ((cnb)localObject7).subType = Util.getInt(str11, 0);
        ((cnb)localObject7).MsF = PL(str9);
        ((cnb)localObject7).MsH = PL(str8);
        ((cnb)localObject7).MsG = PL(str7);
        ((cnb)localObject7).MsS = PL(str18);
        ((cnb)localObject7).ERX = Util.getInt(str6, 0);
        ((cnb)localObject7).MsI = PL(str5);
        ((cnb)localObject7).MsJ = PL(str4);
        ((cnb)localObject7).MsK = Util.getInt(str3, 0);
        ((cnb)localObject7).MsL = Util.getLong(str2, 0L);
        if (((cnb)localObject7).Url != null) {
          break label2865;
        }
      }
      for (localObject1 = "".getBytes();; localObject1 = ((cnb)localObject7).Url.getBytes())
      {
        ((cnb)localObject7).MsM = com.tencent.mm.b.g.getMessageDigest((byte[])localObject1);
        ((cnb)localObject7).viB = str1;
        ((cnb)localObject7).MsN = Util.getInt((String)localObject5, 0);
        ((cnb)localObject7).MsO = ((String)localObject4);
        ((cnb)localObject7).MsP = ((String)localObject3);
        ((cnb)localObject7).MsQ = Util.getInt((String)localObject2, 0);
        ((cnb)localObject7).MsR = str27;
        ((cnb)localObject7).MsT = PK(str21);
        localTimeLineObject.ContentObj.LoV.add(localObject7);
        i += 1;
        break;
        str25 = ".TimelineObject.ContentObject.mediaList.media.id";
        str24 = ".TimelineObject.ContentObject.mediaList.media.type";
        str23 = ".TimelineObject.ContentObject.mediaList.media.title";
        str22 = ".TimelineObject.ContentObject.mediaList.media.description";
        str21 = ".TimelineObject.ContentObject.mediaList.media.url";
        str18 = ".TimelineObject.ContentObject.mediaList.media.url.$videomd5";
        str19 = ".TimelineObject.ContentObject.mediaList.media.thumb";
        str17 = ".TimelineObject.ContentObject.mediaList.media.url.$type";
        str16 = ".TimelineObject.ContentObject.mediaList.media.thumb.$type";
        str20 = ".TimelineObject.ContentObject.mediaList.media.private";
        str11 = ".TimelineObject.ContentObject.mediaList.media.subType";
        localObject6 = ".TimelineObject.ContentObject.mediaList.media";
        str15 = ".TimelineObject.ContentObject.mediaList.media.lowBandUrl";
        str14 = ".TimelineObject.ContentObject.mediaList.media.lowBandUrl.$type";
        str13 = ".TimelineObject.ContentObject.mediaList.media.songalbumurl";
        str12 = ".TimelineObject.ContentObject.mediaList.media.songlyric";
        localObject1 = ".TimelineObject.ContentObject.mediaList.media.thumb.$key";
        localObject2 = ".TimelineObject.ContentObject.mediaList.media.thumb.$enc_idx";
        localObject3 = ".TimelineObject.ContentObject.mediaList.media.thumb.$token";
        localObject4 = ".TimelineObject.ContentObject.mediaList.media.url.$key";
        localObject5 = ".TimelineObject.ContentObject.mediaList.media.url.$enc_idx";
        str1 = ".TimelineObject.ContentObject.mediaList.media.url.$token";
        str2 = ".TimelineObject.ContentObject.mediaList.media.enc.$key";
        str3 = ".TimelineObject.ContentObject.mediaList.media.enc";
        str4 = ".TimelineObject.ContentObject.mediaList.media.attachShareTitle";
        str5 = ".TimelineObject.ContentObject.mediaList.media.attachThumbUrl";
        str6 = ".TimelineObject.ContentObject.mediaList.media.videosize.$attachTotalTime";
        str7 = ".TimelineObject.ContentObject.mediaList.media.url.$md5";
        str8 = ".TimelineObject.ContentObject.mediaList.media.attachUrl.$md5";
        str9 = ".TimelineObject.ContentObject.mediaList.media.attachUrl";
        str10 = ".TimelineObject.ContentObject.mediaList.media.userData";
        break label1711;
      }
      i = paramString.indexOf("<noteinfo>");
      j = paramString.indexOf("</noteinfo>");
      if ((i < 0) || (j < 0))
      {
        localObject2 = localTimeLineObject;
        localObject3 = ((TimeLineObject)localObject2).ContentObj;
        localObject1 = new e();
        i = paramString.indexOf("<finderFeed>");
        j = paramString.indexOf("</finderFeed>");
        if ((i >= 0) && (j >= 0)) {
          break label5055;
        }
        localObject1 = null;
        ((adp)localObject3).dME = ((bcj)localObject1);
        localObject3 = ((TimeLineObject)localObject2).ContentObj;
        localObject1 = new i();
        i = paramString.indexOf("<musicShareItem>");
        j = paramString.indexOf("</musicShareItem>");
        if ((i >= 0) && (j >= 0)) {
          break label5097;
        }
        localObject1 = null;
        ((adp)localObject3).jfy = ((css)localObject1);
        localObject3 = ((TimeLineObject)localObject2).ContentObj;
        localObject1 = new g();
        i = paramString.indexOf("<finderMegaVideo>");
        j = paramString.indexOf("</finderMegaVideo>");
        if ((i >= 0) && (j >= 0)) {
          break label5139;
        }
        localObject1 = null;
        ((adp)localObject3).Lpd = ((col)localObject1);
        localObject3 = ((TimeLineObject)localObject2).ContentObj;
        localObject1 = new f();
        i = paramString.indexOf("<finderTopic>");
        j = paramString.indexOf("</finderTopic>");
        if ((i >= 0) && (j >= 0)) {
          break label5181;
        }
        localObject1 = null;
        label3099:
        ((adp)localObject3).LoZ = ((bcl)localObject1);
        localObject3 = ((TimeLineObject)localObject2).ContentObj;
        localObject1 = new c();
        i = paramString.indexOf("<finderColumn>");
        j = paramString.indexOf("</finderColumn>");
        if ((i >= 0) && (j >= 0)) {
          break label5223;
        }
        localObject1 = null;
        label3149:
        ((adp)localObject3).Lpb = ((bcf)localObject1);
        localObject3 = ((TimeLineObject)localObject2).ContentObj;
        localObject1 = new h();
        i = paramString.indexOf("<mmbrandmpvideo>");
        j = paramString.indexOf("</mmbrandmpvideo>");
        if ((i >= 0) && (j >= 0)) {
          break label5265;
        }
        localObject1 = null;
        ((adp)localObject3).Lpa = ((jo)localObject1);
        localObject3 = ((TimeLineObject)localObject2).ContentObj;
        localObject1 = new d();
        i = paramString.indexOf("<finderLive>");
        j = paramString.indexOf("</finderLive>");
        if ((i >= 0) && (j >= 0)) {
          break label5310;
        }
        localObject1 = null;
        label3249:
        ((adp)localObject3).Lpc = ((axf)localObject1);
        localObject1 = ((TimeLineObject)localObject2).ContentObj;
        j = paramString.indexOf("<finder>");
        k = paramString.indexOf("</finder>");
        i = 0;
        if ((j >= 0) && (k >= 0)) {
          break label5352;
        }
        i = 0;
        label3291:
        ((adp)localObject1).izD = i;
        localObject1 = ((TimeLineObject)localObject2).ContentObj;
        localObject3 = new f();
        i = paramString.indexOf("<finder>");
        j = paramString.indexOf("</finder>");
        if ((i >= 0) && (j >= 0)) {
          break label5395;
        }
        paramString = null;
        label3339:
        ((adp)localObject1).Lpe = paramString;
        paramString = new fa();
        localObject1 = PL((String)localMap.get(".TimelineObject.appInfo.id"));
        localObject3 = PL((String)localMap.get(".TimelineObject.appInfo.version"));
        localObject4 = PL((String)localMap.get(".TimelineObject.appInfo.appName"));
        localObject5 = PL((String)localMap.get(".TimelineObject.appInfo.installUrl "));
        str1 = PL((String)localMap.get(".TimelineObject.appInfo.fromUrl "));
        paramString.Id = ((String)localObject1);
        paramString.xMq = ((String)localObject4);
        paramString.KIq = ((String)localObject5);
        paramString.KIr = str1;
        paramString.Version = ((String)localObject3);
        paramString.KIs = Util.getInt((String)localMap.get(".TimelineObject.appInfo.clickable"), 0);
        ((TimeLineObject)localObject2).AppInfo = paramString;
        paramString = new eyd();
        localObject1 = PL((String)localMap.get(".TimelineObject.weappInfo.appUserName"));
        localObject3 = PL((String)localMap.get(".TimelineObject.weappInfo.pagePath"));
        localObject4 = PL((String)localMap.get(".TimelineObject.weappInfo.version"));
        localObject5 = PL((String)localMap.get(".TimelineObject.weappInfo.debugMode"));
        str1 = PL((String)localMap.get(".TimelineObject.weappInfo.shareActionId"));
        str2 = PL((String)localMap.get(".TimelineObject.weappInfo.isGame"));
        str3 = PL((String)localMap.get(".TimelineObject.weappInfo.messageExtraData"));
        str4 = PL((String)localMap.get(".TimelineObject.weappInfo.subType"));
        str5 = PL((String)localMap.get(".TimelineObject.weappInfo.preloadResources"));
        paramString.username = ((String)localObject1);
        paramString.path = ((String)localObject3);
        paramString.version = Util.getInt((String)localObject4, 0);
        paramString.nbf = Util.getInt((String)localObject5, 0);
        paramString.dCC = str1;
        paramString.isGame = Util.getInt(str2, 0);
        paramString.eda = str3;
        paramString.subType = Util.getInt(str4, 0);
        paramString.Nvm = str5;
        ((TimeLineObject)localObject2).weappInfo = paramString;
        localObject1 = PL((String)localMap.get(".TimelineObject.liteApp.appId"));
        if (!((String)localObject1).isEmpty()) {
          break label5472;
        }
        paramString = null;
        label3774:
        ((TimeLineObject)localObject2).liteappInfo = paramString;
        paramString = new eep();
        localObject1 = PL((String)localMap.get(".TimelineObject.streamvideo.streamvideotitle"));
        localObject3 = PL((String)localMap.get(".TimelineObject.streamvideo.streamvideototaltime"));
        localObject4 = PL((String)localMap.get(".TimelineObject.streamvideo.streamvideourl"));
        localObject5 = PL((String)localMap.get(".TimelineObject.streamvideo.streamvideoweburl"));
        str1 = PL((String)localMap.get(".TimelineObject.streamvideo.streamvideowording"));
        str2 = PL((String)localMap.get(".TimelineObject.streamvideo.streamvideothumburl"));
        str3 = PL((String)localMap.get(".TimelineObject.streamvideo.streamvideoaduxinfo"));
        str4 = PL((String)localMap.get(".TimelineObject.streamvideo.streamvideopublishid"));
        paramString.izb = ((String)localObject1);
        paramString.iza = Util.safeParseInt((String)localObject3);
        paramString.iyZ = ((String)localObject4);
        paramString.izd = ((String)localObject5);
        paramString.izc = str1;
        paramString.ize = str2;
        paramString.izf = str3;
        paramString.izg = str4;
        ((TimeLineObject)localObject2).streamvideo = paramString;
        paramString = new dzy();
        localObject1 = PL((String)localMap.get(".TimelineObject.redEnvelopesInfo.sendId"));
        localObject3 = PL((String)localMap.get(".TimelineObject.redEnvelopesInfo.ticket"));
        paramString.yQE = ((String)localObject1);
        paramString.dHx = ((String)localObject3);
        paramString = new be();
        i = Util.getInt((String)localMap.get(".TimelineObject.actionInfo.scene"), 0);
        localObject1 = PL((String)localMap.get(".TimelineObject.actionInfo.appid"));
        j = Util.getInt((String)localMap.get(".TimelineObject.actionInfo.type"), 0);
        localObject3 = PL((String)localMap.get(".TimelineObject.actionInfo.url"));
        localObject4 = PL((String)localMap.get(".TimelineObject.actionInfo.mediaTagName"));
        localObject5 = PL((String)localMap.get(".TimelineObject.actionInfo.wordingKey"));
        paramString.KEt = ((String)localObject1);
        paramString.Scene = i;
        paramString.oUv = j;
        paramString.Url = ((String)localObject3);
        paramString.KEu = ((String)localObject4);
        paramString.KEv = ((String)localObject5);
        localObject1 = new bc();
        localObject3 = PL((String)localMap.get(".TimelineObject.actionInfo.appMsg.appid"));
        localObject4 = PL((String)localMap.get(".TimelineObject.actionInfo.appMsg.mediaTagName"));
        localObject5 = PL((String)localMap.get(".TimelineObject.actionInfo.appMsg.messageExt"));
        str1 = PL((String)localMap.get(".TimelineObject.actionInfo.appMsg.messageAction"));
        ((bc)localObject1).jfi = ((String)localObject3);
        ((bc)localObject1).KEq = ((String)localObject4);
        ((bc)localObject1).KEr = ((String)localObject5);
        ((bc)localObject1).KEs = str1;
        paramString.KEw = ((bc)localObject1);
        i = Util.getInt((String)localMap.get(".TimelineObject.actionInfo.appActionScene.installedActionScene"), 0);
        j = Util.getInt((String)localMap.get(".TimelineObject.actionInfo.appActionScene.uninstalledActionScene"), 0);
        localObject1 = PL((String)localMap.get(".TimelineObject.actionInfo.appJumpWordingKey.installedWordingKey"));
        localObject3 = PL((String)localMap.get(".TimelineObject.actionInfo.appJumpWordingKey.uninstalledWordingKey"));
        paramString.KEx = PL((String)localMap.get(".TimelineObject.actionInfo.newWordingKey"));
        localObject4 = new ek();
        ((ek)localObject4).KIc = i;
        ((ek)localObject4).KIe = j;
        localObject5 = new fc();
        ((fc)localObject5).KIw = ((String)localObject1);
        ((fc)localObject5).KIx = ((String)localObject3);
        paramString.KEy = ((ek)localObject4);
        paramString.KEz = ((fc)localObject5);
        paramString.KEA = PN((String)localMap.get(".TimelineObject.actionInfo.installedWording"));
        paramString.KEB = PN((String)localMap.get(".TimelineObject.actionInfo.uninstalledWording"));
        ((TimeLineObject)localObject2).actionInfo = paramString;
        ((TimeLineObject)localObject2).sourceUserName = PL((String)localMap.get(".TimelineObject.sourceUserName"));
        ((TimeLineObject)localObject2).sourceNickName = PL((String)localMap.get(".TimelineObject.sourceNickName"));
        ((TimeLineObject)localObject2).publicUserName = PL((String)localMap.get(".TimelineObject.publicUserName"));
        ((TimeLineObject)localObject2).statisticsData = PL((String)localMap.get(".TimelineObject.statisticsData"));
        ((TimeLineObject)localObject2).canvasInfo = PL((String)localMap.get(".TimelineObject.canvasInfoXml"));
        ((TimeLineObject)localObject2).contentattr = Util.getInt((String)localMap.get(".TimelineObject.contentattr"), 0);
        paramString = new fat();
        paramString.IEy = PL((String)localMap.get(".TimelineObject.websearch.relevant_vid"));
        paramString.IEz = PL((String)localMap.get(".TimelineObject.websearch.relevant_expand"));
        paramString.IEA = PL((String)localMap.get(".TimelineObject.websearch.relevant_pre_searchid"));
        paramString.IEB = PL((String)localMap.get(".TimelineObject.websearch.relevant_shared_openid"));
        paramString.IEC = Util.getLong((String)localMap.get(".TimelineObject.websearch.rec_category"), 0L);
        paramString.rCq = PL((String)localMap.get(".TimelineObject.websearch.shareUrl"));
        paramString.msN = PL((String)localMap.get(".TimelineObject.websearch.shareTitle"));
        paramString.xDQ = PL((String)localMap.get(".TimelineObject.websearch.shareDesc"));
        paramString.IED = PL((String)localMap.get(".TimelineObject.websearch.shareImgUrl"));
        paramString.IEE = PL((String)localMap.get(".TimelineObject.websearch.shareString"));
        paramString.IEF = PL((String)localMap.get(".TimelineObject.websearch.shareStringUrl"));
        paramString.source = PL((String)localMap.get(".TimelineObject.websearch.source"));
        paramString.eby = PL((String)localMap.get(".TimelineObject.websearch.sourceUrl"));
        paramString.IEG = PL((String)localMap.get(".TimelineObject.websearch.strPlayCount"));
        paramString.IEH = PL((String)localMap.get(".TimelineObject.websearch.titleUrl"));
        paramString.IEI = PL((String)localMap.get(".TimelineObject.websearch.extReqParams"));
        paramString.IEJ = PL((String)localMap.get(".TimelineObject.websearch.tagList"));
        paramString.IEK = Util.getLong((String)localMap.get(".TimelineObject.websearch.channelId"), 0L);
        paramString.IEL = PL((String)localMap.get(".TimelineObject.websearch.shareTag"));
        ((TimeLineObject)localObject2).webSearchInfo = paramString;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(94866);
      return localTimeLineObject;
      localTimeLineObject.ContentObj.LoX = paramString.substring(i, j + 11);
      break;
      label5055:
      localObject4 = XmlParser.parseXml(paramString.substring(i, j + 13), "finderFeed", null);
      if (localObject4 != null) {
        ((e)localObject1).j("", (Map)localObject4);
      }
      localObject1 = ((e)localObject1).jlg;
      break label2949;
      label5097:
      localObject4 = XmlParser.parseXml(paramString.substring(i, j + 17), "musicShareItem", null);
      if (localObject4 != null) {
        ((i)localObject1).j("", (Map)localObject4);
      }
      localObject1 = ((i)localObject1).jlj;
      break label2999;
      label5139:
      localObject4 = XmlParser.parseXml(paramString.substring(i, j + 18), "finderMegaVideo", null);
      if (localObject4 != null) {
        ((g)localObject1).j("", (Map)localObject4);
      }
      localObject1 = ((g)localObject1).jlh;
      break label3049;
      label5181:
      localObject4 = XmlParser.parseXml(paramString.substring(i, j + 14), "finderTopic", null);
      if (localObject4 != null) {
        ((f)localObject1).j("", (Map)localObject4);
      }
      localObject1 = ((f)localObject1).jld;
      break label3099;
      label5223:
      localObject4 = XmlParser.parseXml(paramString.substring(i, j + 15), "finderColumn", null);
      if (localObject4 != null) {
        ((c)localObject1).j("", (Map)localObject4);
      }
      localObject1 = ((c)localObject1).jle;
      break label3149;
      label5265:
      localObject4 = XmlParser.parseXml(paramString.substring(i, j + 17), "mmbrandmpvideo", null);
      if (localObject4 != null) {
        ((h)localObject1).jli = h.k("", (Map)localObject4);
      }
      localObject1 = ((h)localObject1).jli;
      break label3199;
      label5310:
      localObject4 = XmlParser.parseXml(paramString.substring(i, j + 13), "finderLive", null);
      if (localObject4 != null) {
        ((d)localObject1).j("", (Map)localObject4);
      }
      localObject1 = ((d)localObject1).jlf;
      break label3249;
      label5352:
      localObject3 = XmlParser.parseXml(paramString.substring(j, k + 9), "finder", null);
      if (localObject3 == null) {
        break label3291;
      }
      i = Util.safeParseInt((String)((Map)localObject3).get(".finder.type"));
      break label3291;
      label5395:
      paramString = paramString.substring(i, j + 9);
      i = paramString.indexOf("<finderTopic>");
      j = paramString.indexOf("</finderTopic>");
      if ((i < 0) || (j < 0))
      {
        paramString = null;
        break label3339;
      }
      paramString = XmlParser.parseXml(paramString.substring(i, j + 14), "finderTopic", null);
      if (paramString != null) {
        ((f)localObject3).j("", paramString);
      }
      paramString = ((f)localObject3).jld;
      break label3339;
      label5472:
      paramString = new cio();
      paramString.appId = ((String)localObject1);
      paramString.path = PL((String)localMap.get(".TimelineObject.liteApp.path"));
      paramString.query = PL((String)localMap.get(".TimelineObject.liteApp.query"));
      break label3774;
    }
  }
  
  private static fb PN(String paramString)
  {
    AppMethodBeat.i(94867);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(94867);
      return null;
    }
    paramString = PO(paramString);
    paramString = XmlParser.parseXml("<root>" + paramString + "</root>", "root", null);
    if (paramString == null)
    {
      AppMethodBeat.o(94867);
      return null;
    }
    fb localfb = new fb();
    localfb.KIt = PL((String)paramString.get(".root.en"));
    localfb.KIu = PL((String)paramString.get(".root.zh-CN"));
    localfb.KIv = PL((String)paramString.get(".root.zh-TW"));
    AppMethodBeat.o(94867);
    return localfb;
  }
  
  private static String PO(String paramString)
  {
    AppMethodBeat.i(94868);
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    int i = 0;
    int j = paramString.length();
    while (i < j)
    {
      char c = paramString.charAt(i);
      if (c != '&')
      {
        localStringBuilder.append(c);
        i += 1;
      }
      else if (paramString.startsWith("&amp;", i))
      {
        localStringBuilder.append('&');
        i += 5;
      }
      else if (paramString.startsWith("&apos;", i))
      {
        localStringBuilder.append('\'');
        i += 6;
      }
      else if (paramString.startsWith("&quot;", i))
      {
        localStringBuilder.append('"');
        i += 6;
      }
      else if (paramString.startsWith("&lt;", i))
      {
        localStringBuilder.append('<');
        i += 4;
      }
      else if (paramString.startsWith("&gt;", i))
      {
        localStringBuilder.append('>');
        i += 4;
      }
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(94868);
    return paramString;
  }
  
  public static Pair<Integer, Integer> a(int paramInt1, int paramInt2, Context paramContext)
  {
    AppMethodBeat.i(201846);
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, 160.0F);
    int j = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, 200.0F);
    int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, 44.0F);
    double d3 = paramInt1;
    double d1 = paramInt2;
    double d2;
    double d4;
    if ((d3 > 0.0D) && (d1 > 0.0D))
    {
      d2 = Math.min(j / d3, j / d1);
      d3 *= d2;
      d4 = d2 * d1;
      d1 = d4;
      d2 = d3;
      if (d3 < k)
      {
        d1 = k * 1.0D / d3;
        d2 = d3 * d1;
        d1 = d4 * d1;
      }
      d3 = d1;
      d4 = d2;
      if (d1 < k)
      {
        d3 = k * 1.0D / d1;
        d4 = d2 * d3;
        d3 = d1 * d3;
      }
      d2 = d4;
      if (d4 > j) {
        d2 = j;
      }
      d1 = d3;
      d4 = d2;
      if (d3 > j)
      {
        d1 = j;
        d4 = d2;
      }
    }
    for (;;)
    {
      d2 = d4;
      if (d4 < 1.0D) {
        d2 = 1.0D;
      }
      d3 = d1;
      if (d1 < 1.0D) {
        d3 = 1.0D;
      }
      paramContext = Pair.create(Integer.valueOf((int)d2), Integer.valueOf((int)d3));
      AppMethodBeat.o(201846);
      return paramContext;
      d4 = i;
      d1 = d4;
    }
  }
  
  public static Pair<Integer, Integer> a(int paramInt1, int paramInt2, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(94870);
    if (paramInt1 <= 0) {
      paramInt1 = 320;
    }
    for (;;)
    {
      int k = paramInt2;
      if (paramInt2 <= 0) {
        k = 240;
      }
      if (paramContext == null)
      {
        Log.e("MicroMsg.TimeLineHelper", "the context is null");
        paramContext = Pair.create(Integer.valueOf(paramInt1), Integer.valueOf(k));
        AppMethodBeat.o(94870);
        return paramContext;
      }
      DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      if (localDisplayMetrics != null) {}
      for (paramInt2 = (int)Math.min(localDisplayMetrics.widthPixels * 0.63F, localDisplayMetrics.heightPixels * 0.63F);; paramInt2 = paramInt1)
      {
        int i = paramInt2 >> 5 << 5;
        paramInt2 = i;
        if (paramInt1 < k)
        {
          paramInt2 = i;
          if (paramContext != null) {
            paramInt2 = Math.min(BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, 160.0F), i);
          }
        }
        int m = (int)(paramInt2 * 1.0D * k / paramInt1);
        i = m;
        int j = paramInt2;
        if (!paramBoolean)
        {
          i = a.fromDPToPix(paramContext, 225);
          j = a.fromDPToPix(paramContext, 169);
          if (m <= paramInt2) {
            break label257;
          }
        }
        for (;;)
        {
          Log.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
          paramContext = Pair.create(Integer.valueOf(j), Integer.valueOf(i));
          AppMethodBeat.o(94870);
          return paramContext;
          label257:
          paramInt2 = i;
          i = j;
          j = paramInt2;
        }
      }
    }
  }
  
  public static Pair<Integer, Integer> a(TimeLineObject paramTimeLineObject, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(94869);
    int j;
    int i;
    if ((paramTimeLineObject != null) && (paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.LoV != null) && (paramTimeLineObject.ContentObj.LoV.size() > 0))
    {
      paramTimeLineObject = (cnb)paramTimeLineObject.ContentObj.LoV.get(0);
      if ((paramTimeLineObject != null) && (paramTimeLineObject.MsB != null) && (paramTimeLineObject.MsB.Mto > 0.0F) && (paramTimeLineObject.MsB.Mtp > 0.0F))
      {
        j = (int)paramTimeLineObject.MsB.Mto;
        i = (int)paramTimeLineObject.MsB.Mtp;
      }
    }
    for (;;)
    {
      paramTimeLineObject = a(j, i, paramContext, paramBoolean);
      AppMethodBeat.o(94869);
      return paramTimeLineObject;
      i = 0;
      j = 0;
    }
  }
  
  public static cnb a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4, String paramString4, cnd paramcnd)
  {
    AppMethodBeat.i(94865);
    cnb localcnb = new cnb();
    localcnb.Id = PL(paramString1);
    localcnb.oUv = paramInt1;
    localcnb.Desc = PL(paramString4);
    localcnb.Url = PL(paramString2);
    localcnb.Mcw = paramInt2;
    localcnb.Msz = PL(paramString3);
    localcnb.MsA = paramInt3;
    localcnb.Privated = paramInt4;
    localcnb.MsB = paramcnd;
    if (paramString2 == null) {}
    for (paramString1 = "".getBytes();; paramString1 = paramString2.getBytes())
    {
      localcnb.MsM = com.tencent.mm.b.g.getMessageDigest(paramString1);
      AppMethodBeat.o(94865);
      return localcnb;
    }
  }
  
  public static cnb a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, String paramString4)
  {
    AppMethodBeat.i(94864);
    cnb localcnb = new cnb();
    localcnb.Id = paramString1;
    localcnb.oUv = paramInt1;
    localcnb.Url = paramString2;
    localcnb.Msz = paramString3;
    localcnb.Mcw = paramInt2;
    localcnb.MsA = paramInt3;
    localcnb.Desc = paramString4;
    paramString1 = new cnd();
    paramString1.Mtp = 0.0F;
    paramString1.Mto = 0.0F;
    paramString1.Mtq = 0.0F;
    localcnb.MsB = paramString1;
    if (paramString2 == null) {}
    for (paramString1 = "".getBytes();; paramString1 = paramString2.getBytes())
    {
      localcnb.MsM = com.tencent.mm.b.g.getMessageDigest(paramString1);
      AppMethodBeat.o(94864);
      return localcnb;
    }
  }
  
  public static TimeLineObject bfM()
  {
    AppMethodBeat.i(94862);
    TimeLineObject localTimeLineObject = new TimeLineObject();
    Object localObject = new adp();
    localTimeLineObject.AppInfo = new fa();
    localTimeLineObject.ContentObj = ((adp)localObject);
    localTimeLineObject.Privated = 0;
    localTimeLineObject.CreateTime = 0;
    localTimeLineObject.Id = "";
    localObject = new cjy();
    ((cjy)localObject).LbD = 0.0F;
    ((cjy)localObject).LbC = 0.0F;
    localTimeLineObject.Location = ((cjy)localObject);
    localTimeLineObject.canvasInfo = "";
    localTimeLineObject.weappInfo = new eyd();
    AppMethodBeat.o(94862);
    return localTimeLineObject;
  }
  
  public static cnb bfN()
  {
    AppMethodBeat.i(94863);
    cnb localcnb = new cnb();
    localcnb.Desc = "";
    localcnb.Privated = 0;
    AppMethodBeat.o(94863);
    return localcnb;
  }
  
  public static Pair<Integer, Integer> df(Context paramContext)
  {
    AppMethodBeat.i(201847);
    int i = a.fromDPToPix(paramContext, 225);
    paramContext = Pair.create(Integer.valueOf(a.fromDPToPix(paramContext, 127)), Integer.valueOf(i));
    AppMethodBeat.o(201847);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsns.n
 * JD-Core Version:    0.7.0.1
 */