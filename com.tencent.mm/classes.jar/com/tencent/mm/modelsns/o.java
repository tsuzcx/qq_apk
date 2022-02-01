package com.tencent.mm.modelsns;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.protocal.protobuf.crk;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.cuf;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.ejy;
import com.tencent.mm.protocal.protobuf.eoq;
import com.tencent.mm.protocal.protobuf.ex;
import com.tencent.mm.protocal.protobuf.ey;
import com.tencent.mm.protocal.protobuf.ez;
import com.tencent.mm.protocal.protobuf.fiu;
import com.tencent.mm.protocal.protobuf.flm;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.LinkedList;
import java.util.Map;

public final class o
{
  private static float Xi(String paramString)
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
  
  private static String Xj(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static TimeLineObject Xk(String paramString)
  {
    AppMethodBeat.i(94866);
    Map localMap = XmlParser.parseXml(paramString, "TimelineObject", null);
    TimeLineObject localTimeLineObject = bpc();
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
      localTimeLineObject.Id = Xj((String)localMap.get(".TimelineObject.id"));
      localTimeLineObject.UserName = Xj((String)localMap.get(".TimelineObject.username"));
      localTimeLineObject.Privated = Util.getInt((String)localMap.get(".TimelineObject.private"), 0);
      localTimeLineObject.CreateTime = Util.getInt((String)localMap.get(".TimelineObject.createTime"), 0);
      localTimeLineObject.ContentDesc = Xj((String)localMap.get(".TimelineObject.contentDesc"));
      localTimeLineObject.contentDescShowType = Util.getInt((String)localMap.get(".TimelineObject.contentDescShowType"), 0);
      localTimeLineObject.contentDescScene = Util.getInt((String)localMap.get(".TimelineObject.contentDescScene"), 0);
      localTimeLineObject.statExtStr = Xj((String)localMap.get(".TimelineObject.statExtStr"));
      localTimeLineObject.sightFolded = Util.getInt((String)localMap.get(".TimelineObject.sightFolded"), 0);
      localTimeLineObject.showFlag = Util.getInt((String)localMap.get(".TimelineObject.showFlag"), 0);
      localObject1 = new cst();
      ((cst)localObject1).ScO = Xi((String)localMap.get(".TimelineObject.location.$longitude"));
      ((cst)localObject1).ScP = Xi((String)localMap.get(".TimelineObject.location.$latitude"));
      ((cst)localObject1).mVA = Xj((String)localMap.get(".TimelineObject.location.$city"));
      ((cst)localObject1).TAz = Util.getInt((String)localMap.get(".TimelineObject.location.$poiScale"), 0);
      ((cst)localObject1).SOz = Xj((String)localMap.get(".TimelineObject.location.$poiClassifyId"));
      ((cst)localObject1).KFw = Util.getInt((String)localMap.get(".TimelineObject.location.$poiClassifyType"), 0);
      ((cst)localObject1).KFu = Xj((String)localMap.get(".TimelineObject.location.$poiAddress"));
      ((cst)localObject1).poiName = Xj((String)localMap.get(".TimelineObject.location.$poiName"));
      ((cst)localObject1).TAA = Util.getInt((String)localMap.get(".TimelineObject.location.$poiClickableStatus"), 0);
      ((cst)localObject1).TAC = Xj((String)localMap.get(".TimelineObject.location.$poiAddressName"));
      ((cst)localObject1).country = Xj((String)localMap.get(".TimelineObject.location.$country"));
      localTimeLineObject.Location = ((cst)localObject1);
      if (localTimeLineObject.ContentObj == null) {
        localTimeLineObject.ContentObj = new adw();
      }
      localTimeLineObject.ContentObj.CMB = Xj((String)localMap.get(".TimelineObject.ContentObject.description"));
      localTimeLineObject.ContentObj.Sqq = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.contentStyle"), 0);
      localTimeLineObject.ContentObj.Sqs = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.contentSubStyle"), 0);
      localTimeLineObject.ContentObj.fwr = Xj((String)localMap.get(".TimelineObject.ContentObject.title"));
      localTimeLineObject.ContentObj.Url = Xj((String)localMap.get(".TimelineObject.ContentObject.contentUrl"));
      if (localMap.containsKey(".TimelineObject.ContentObject.mmreadershare.itemshowtype"))
      {
        i = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.itemshowtype"), 0);
        if (i != -1)
        {
          localTimeLineObject.ContentObj.Squ = new cuf();
          localTimeLineObject.ContentObj.Squ.lpx = i;
          localTimeLineObject.ContentObj.Squ.lls = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.ispaysubscribe"), 0);
        }
        if (i == 5)
        {
          localTimeLineObject.ContentObj.Squ.llq = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.pubtime"), 0);
          localTimeLineObject.ContentObj.Squ.vid = Xj((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.vid"));
          localTimeLineObject.ContentObj.Squ.coverUrl = Xj((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.cover"));
          localTimeLineObject.ContentObj.Squ.llt = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.funcflag"), 0);
          localTimeLineObject.ContentObj.Squ.duration = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.duration"), 0);
          localTimeLineObject.ContentObj.Squ.desc = Xj((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.digest"));
          localTimeLineObject.ContentObj.Squ.llr = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.nativepage"), 0);
          localTimeLineObject.ContentObj.Squ.videoWidth = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.width"), 0);
          localTimeLineObject.ContentObj.Squ.videoHeight = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.height"), 0);
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
        localObject6 = new cvv();
        ((cvv)localObject6).TEv = 0.0F;
        ((cvv)localObject6).TEu = 0.0F;
        ((cvv)localObject6).TEw = 0.0F;
        if (str26 != null) {
          ((cvv)localObject6).TEu = Xi(str26);
        }
        if (str27 != null) {
          ((cvv)localObject6).TEv = Xi(str27);
        }
        if (localObject7 != null) {
          ((cvv)localObject6).TEw = Xi((String)localObject7);
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
        localObject7 = new cvt();
        ((cvt)localObject7).Id = Xj(str25);
        ((cvt)localObject7).rWu = Util.getInt(str24, 0);
        ((cvt)localObject7).fwr = Xj(str23);
        ((cvt)localObject7).CMB = Xj(str22);
        ((cvt)localObject7).Url = Xj(str26);
        ((cvt)localObject7).TlV = Util.getInt(str17, 0);
        ((cvt)localObject7).TDF = Xj(str19);
        ((cvt)localObject7).TDG = Util.getInt(str16, 0);
        ((cvt)localObject7).Privated = Util.getInt(str20, 0);
        ((cvt)localObject7).TDH = ((cvv)localObject6);
        ((cvt)localObject7).TDI = Xj(str15);
        ((cvt)localObject7).TDJ = Util.getInt(str14, 0);
        ((cvt)localObject7).songAlbumUrl = str13;
        ((cvt)localObject7).songLyric = str12;
        ((cvt)localObject7).KCT = Xj(str10);
        ((cvt)localObject7).subType = Util.getInt(str11, 0);
        ((cvt)localObject7).TDL = Xj(str9);
        ((cvt)localObject7).TDN = Xj(str8);
        ((cvt)localObject7).TDM = Xj(str7);
        ((cvt)localObject7).TDY = Xj(str18);
        ((cvt)localObject7).Lgc = Util.getInt(str6, 0);
        ((cvt)localObject7).TDO = Xj(str5);
        ((cvt)localObject7).TDP = Xj(str4);
        ((cvt)localObject7).TDQ = Util.getInt(str3, 0);
        ((cvt)localObject7).TDR = Util.getLong(str2, 0L);
        if (((cvt)localObject7).Url != null) {
          break label2865;
        }
      }
      for (localObject1 = "".getBytes();; localObject1 = ((cvt)localObject7).Url.getBytes())
      {
        ((cvt)localObject7).TDS = com.tencent.mm.b.g.getMessageDigest((byte[])localObject1);
        ((cvt)localObject7).zZu = str1;
        ((cvt)localObject7).TDT = Util.getInt((String)localObject5, 0);
        ((cvt)localObject7).TDU = ((String)localObject4);
        ((cvt)localObject7).TDV = ((String)localObject3);
        ((cvt)localObject7).TDW = Util.getInt((String)localObject2, 0);
        ((cvt)localObject7).TDX = str27;
        ((cvt)localObject7).TDZ = Xi(str21);
        localTimeLineObject.ContentObj.Sqr.add(localObject7);
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
          break label5105;
        }
        localObject1 = null;
        ((adw)localObject3).fFJ = ((bje)localObject1);
        localObject3 = ((TimeLineObject)localObject2).ContentObj;
        localObject1 = new j();
        i = paramString.indexOf("<musicShareItem>");
        j = paramString.indexOf("</musicShareItem>");
        if ((i >= 0) && (j >= 0)) {
          break label5147;
        }
        localObject1 = null;
        ((adw)localObject3).lVY = ((dbr)localObject1);
        localObject3 = ((TimeLineObject)localObject2).ContentObj;
        localObject1 = new h();
        i = paramString.indexOf("<finderMegaVideo>");
        j = paramString.indexOf("</finderMegaVideo>");
        if ((i >= 0) && (j >= 0)) {
          break label5189;
        }
        localObject1 = null;
        ((adw)localObject3).Sqy = ((cwx)localObject1);
        localObject3 = ((TimeLineObject)localObject2).ContentObj;
        localObject1 = new g();
        i = paramString.indexOf("<finderTopic>");
        j = paramString.indexOf("</finderTopic>");
        if ((i >= 0) && (j >= 0)) {
          break label5231;
        }
        localObject1 = null;
        label3099:
        ((adw)localObject3).Sqv = ((bjg)localObject1);
        localObject3 = ((TimeLineObject)localObject2).ContentObj;
        localObject1 = new c();
        i = paramString.indexOf("<finderColumn>");
        j = paramString.indexOf("</finderColumn>");
        if ((i >= 0) && (j >= 0)) {
          break label5273;
        }
        localObject1 = null;
        label3149:
        ((adw)localObject3).Sqx = ((bja)localObject1);
        localObject3 = ((TimeLineObject)localObject2).ContentObj;
        localObject1 = new i();
        i = paramString.indexOf("<mmbrandmpvideo>");
        j = paramString.indexOf("</mmbrandmpvideo>");
        if ((i >= 0) && (j >= 0)) {
          break label5315;
        }
        localObject1 = null;
        ((adw)localObject3).Sqw = ((jd)localObject1);
        localObject3 = ((TimeLineObject)localObject2).ContentObj;
        localObject1 = new d();
        i = paramString.indexOf("<finderLive>");
        j = paramString.indexOf("</finderLive>");
        if ((i >= 0) && (j >= 0)) {
          break label5360;
        }
        localObject1 = null;
        label3249:
        ((adw)localObject3).yNL = ((bcp)localObject1);
        localObject1 = ((TimeLineObject)localObject2).ContentObj;
        j = paramString.indexOf("<finder>");
        k = paramString.indexOf("</finder>");
        i = 0;
        if ((j >= 0) && (k >= 0)) {
          break label5402;
        }
        i = 0;
        label3291:
        ((adw)localObject1).loX = i;
        localObject3 = ((TimeLineObject)localObject2).ContentObj;
        localObject1 = new g();
        i = paramString.indexOf("<finder>");
        j = paramString.indexOf("</finder>");
        if ((i >= 0) && (j >= 0)) {
          break label5445;
        }
        localObject1 = null;
        label3340:
        ((adw)localObject3).Sqz = ((bjg)localObject1);
        localObject1 = ((TimeLineObject)localObject2).ContentObj;
        localObject3 = new f();
        i = paramString.indexOf("<finder>");
        j = paramString.indexOf("</finder>");
        if ((i >= 0) && (j >= 0)) {
          break label5531;
        }
        paramString = null;
        label3389:
        ((adw)localObject1).SqA = paramString;
        paramString = new ex();
        localObject1 = Xj((String)localMap.get(".TimelineObject.appInfo.id"));
        localObject3 = Xj((String)localMap.get(".TimelineObject.appInfo.version"));
        localObject4 = Xj((String)localMap.get(".TimelineObject.appInfo.appName"));
        localObject5 = Xj((String)localMap.get(".TimelineObject.appInfo.installUrl "));
        str1 = Xj((String)localMap.get(".TimelineObject.appInfo.fromUrl "));
        paramString.Id = ((String)localObject1);
        paramString.CQz = ((String)localObject4);
        paramString.RJH = ((String)localObject5);
        paramString.RJI = str1;
        paramString.Version = ((String)localObject3);
        paramString.RJJ = Util.getInt((String)localMap.get(".TimelineObject.appInfo.clickable"), 0);
        ((TimeLineObject)localObject2).AppInfo = paramString;
        paramString = new fiu();
        localObject1 = Xj((String)localMap.get(".TimelineObject.weappInfo.appUserName"));
        localObject3 = Xj((String)localMap.get(".TimelineObject.weappInfo.pagePath"));
        localObject4 = Xj((String)localMap.get(".TimelineObject.weappInfo.version"));
        localObject5 = Xj((String)localMap.get(".TimelineObject.weappInfo.debugMode"));
        str1 = Xj((String)localMap.get(".TimelineObject.weappInfo.shareActionId"));
        str2 = Xj((String)localMap.get(".TimelineObject.weappInfo.isGame"));
        str3 = Xj((String)localMap.get(".TimelineObject.weappInfo.messageExtraData"));
        str4 = Xj((String)localMap.get(".TimelineObject.weappInfo.subType"));
        str5 = Xj((String)localMap.get(".TimelineObject.weappInfo.preloadResources"));
        paramString.username = ((String)localObject1);
        paramString.path = ((String)localObject3);
        paramString.version = Util.getInt((String)localObject4, 0);
        paramString.qbu = Util.getInt((String)localObject5, 0);
        paramString.fvj = str1;
        paramString.UIv = Util.getInt(str2, 0);
        paramString.fXg = str3;
        paramString.subType = Util.getInt(str4, 0);
        paramString.UIw = str5;
        ((TimeLineObject)localObject2).weappInfo = paramString;
        localObject1 = Xj((String)localMap.get(".TimelineObject.liteApp.appId"));
        if (!((String)localObject1).isEmpty()) {
          break label5600;
        }
        paramString = null;
        label3824:
        ((TimeLineObject)localObject2).liteappInfo = paramString;
        paramString = new eoq();
        localObject1 = Xj((String)localMap.get(".TimelineObject.streamvideo.streamvideotitle"));
        localObject3 = Xj((String)localMap.get(".TimelineObject.streamvideo.streamvideototaltime"));
        localObject4 = Xj((String)localMap.get(".TimelineObject.streamvideo.streamvideourl"));
        localObject5 = Xj((String)localMap.get(".TimelineObject.streamvideo.streamvideoweburl"));
        str1 = Xj((String)localMap.get(".TimelineObject.streamvideo.streamvideowording"));
        str2 = Xj((String)localMap.get(".TimelineObject.streamvideo.streamvideothumburl"));
        str3 = Xj((String)localMap.get(".TimelineObject.streamvideo.streamvideoaduxinfo"));
        str4 = Xj((String)localMap.get(".TimelineObject.streamvideo.streamvideopublishid"));
        paramString.lot = ((String)localObject1);
        paramString.los = Util.safeParseInt((String)localObject3);
        paramString.lor = ((String)localObject4);
        paramString.lov = ((String)localObject5);
        paramString.lou = str1;
        paramString.low = str2;
        paramString.lox = str3;
        paramString.loy = str4;
        ((TimeLineObject)localObject2).streamvideo = paramString;
        paramString = new ejy();
        localObject1 = Xj((String)localMap.get(".TimelineObject.redEnvelopesInfo.sendId"));
        localObject3 = Xj((String)localMap.get(".TimelineObject.redEnvelopesInfo.ticket"));
        paramString.ybP = ((String)localObject1);
        paramString.fAo = ((String)localObject3);
        paramString = new bc();
        i = Util.getInt((String)localMap.get(".TimelineObject.actionInfo.scene"), 0);
        localObject1 = Xj((String)localMap.get(".TimelineObject.actionInfo.appid"));
        j = Util.getInt((String)localMap.get(".TimelineObject.actionInfo.type"), 0);
        localObject3 = Xj((String)localMap.get(".TimelineObject.actionInfo.url"));
        localObject4 = Xj((String)localMap.get(".TimelineObject.actionInfo.mediaTagName"));
        localObject5 = Xj((String)localMap.get(".TimelineObject.actionInfo.wordingKey"));
        paramString.RFL = ((String)localObject1);
        paramString.CPw = i;
        paramString.rWu = j;
        paramString.Url = ((String)localObject3);
        paramString.RFM = ((String)localObject4);
        paramString.RFN = ((String)localObject5);
        localObject1 = new ba();
        localObject3 = Xj((String)localMap.get(".TimelineObject.actionInfo.appMsg.appid"));
        localObject4 = Xj((String)localMap.get(".TimelineObject.actionInfo.appMsg.mediaTagName"));
        localObject5 = Xj((String)localMap.get(".TimelineObject.actionInfo.appMsg.messageExt"));
        str1 = Xj((String)localMap.get(".TimelineObject.actionInfo.appMsg.messageAction"));
        ((ba)localObject1).lVG = ((String)localObject3);
        ((ba)localObject1).RFI = ((String)localObject4);
        ((ba)localObject1).RFJ = ((String)localObject5);
        ((ba)localObject1).RFK = str1;
        paramString.RFO = ((ba)localObject1);
        i = Util.getInt((String)localMap.get(".TimelineObject.actionInfo.appActionScene.installedActionScene"), 0);
        j = Util.getInt((String)localMap.get(".TimelineObject.actionInfo.appActionScene.uninstalledActionScene"), 0);
        localObject1 = Xj((String)localMap.get(".TimelineObject.actionInfo.appJumpWordingKey.installedWordingKey"));
        localObject3 = Xj((String)localMap.get(".TimelineObject.actionInfo.appJumpWordingKey.uninstalledWordingKey"));
        paramString.RFP = Xj((String)localMap.get(".TimelineObject.actionInfo.newWordingKey"));
        localObject4 = new eh();
        ((eh)localObject4).RJt = i;
        ((eh)localObject4).RJu = j;
        localObject5 = new ez();
        ((ez)localObject5).RJN = ((String)localObject1);
        ((ez)localObject5).RJO = ((String)localObject3);
        paramString.RFQ = ((eh)localObject4);
        paramString.RFR = ((ez)localObject5);
        paramString.RFS = Xl((String)localMap.get(".TimelineObject.actionInfo.installedWording"));
        paramString.RFT = Xl((String)localMap.get(".TimelineObject.actionInfo.uninstalledWording"));
        ((TimeLineObject)localObject2).actionInfo = paramString;
        ((TimeLineObject)localObject2).sourceUserName = Xj((String)localMap.get(".TimelineObject.sourceUserName"));
        ((TimeLineObject)localObject2).sourceNickName = Xj((String)localMap.get(".TimelineObject.sourceNickName"));
        ((TimeLineObject)localObject2).publicUserName = Xj((String)localMap.get(".TimelineObject.publicUserName"));
        ((TimeLineObject)localObject2).statisticsData = Xj((String)localMap.get(".TimelineObject.statisticsData"));
        ((TimeLineObject)localObject2).canvasInfo = Xj((String)localMap.get(".TimelineObject.canvasInfoXml"));
        ((TimeLineObject)localObject2).contentattr = Util.getInt((String)localMap.get(".TimelineObject.contentattr"), 0);
        paramString = new flm();
        paramString.PyQ = Xj((String)localMap.get(".TimelineObject.websearch.relevant_vid"));
        paramString.PyR = Xj((String)localMap.get(".TimelineObject.websearch.relevant_expand"));
        paramString.PyS = Xj((String)localMap.get(".TimelineObject.websearch.relevant_pre_searchid"));
        paramString.PyT = Xj((String)localMap.get(".TimelineObject.websearch.relevant_shared_openid"));
        paramString.PyU = Util.getLong((String)localMap.get(".TimelineObject.websearch.rec_category"), 0L);
        paramString.vhY = Xj((String)localMap.get(".TimelineObject.websearch.shareUrl"));
        paramString.pqW = Xj((String)localMap.get(".TimelineObject.websearch.shareTitle"));
        paramString.CHR = Xj((String)localMap.get(".TimelineObject.websearch.shareDesc"));
        paramString.PyV = Xj((String)localMap.get(".TimelineObject.websearch.shareImgUrl"));
        paramString.PyW = Xj((String)localMap.get(".TimelineObject.websearch.shareString"));
        paramString.PyX = Xj((String)localMap.get(".TimelineObject.websearch.shareStringUrl"));
        paramString.source = Xj((String)localMap.get(".TimelineObject.websearch.source"));
        paramString.fVx = Xj((String)localMap.get(".TimelineObject.websearch.sourceUrl"));
        paramString.PyY = Xj((String)localMap.get(".TimelineObject.websearch.strPlayCount"));
        paramString.PyZ = Xj((String)localMap.get(".TimelineObject.websearch.titleUrl"));
        paramString.Pza = Xj((String)localMap.get(".TimelineObject.websearch.extReqParams"));
        paramString.Pzb = Xj((String)localMap.get(".TimelineObject.websearch.tagList"));
        paramString.Pzc = Util.getLong((String)localMap.get(".TimelineObject.websearch.channelId"), 0L);
        paramString.Pzd = Xj((String)localMap.get(".TimelineObject.websearch.shareTag"));
        ((TimeLineObject)localObject2).webSearchInfo = paramString;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(94866);
      return localTimeLineObject;
      localTimeLineObject.ContentObj.Sqt = paramString.substring(i, j + 11);
      break;
      label5105:
      localObject4 = XmlParser.parseXml(paramString.substring(i, j + 13), "finderFeed", null);
      if (localObject4 != null) {
        ((e)localObject1).i("", (Map)localObject4);
      }
      localObject1 = ((e)localObject1).mbi;
      break label2949;
      label5147:
      localObject4 = XmlParser.parseXml(paramString.substring(i, j + 17), "musicShareItem", null);
      if (localObject4 != null) {
        ((j)localObject1).i("", (Map)localObject4);
      }
      localObject1 = ((j)localObject1).mbm;
      break label2999;
      label5189:
      localObject4 = XmlParser.parseXml(paramString.substring(i, j + 18), "finderMegaVideo", null);
      if (localObject4 != null) {
        ((h)localObject1).i("", (Map)localObject4);
      }
      localObject1 = ((h)localObject1).mbk;
      break label3049;
      label5231:
      localObject4 = XmlParser.parseXml(paramString.substring(i, j + 14), "finderTopic", null);
      if (localObject4 != null) {
        ((g)localObject1).i("", (Map)localObject4);
      }
      localObject1 = ((g)localObject1).mbf;
      break label3099;
      label5273:
      localObject4 = XmlParser.parseXml(paramString.substring(i, j + 15), "finderColumn", null);
      if (localObject4 != null) {
        ((c)localObject1).i("", (Map)localObject4);
      }
      localObject1 = ((c)localObject1).mbg;
      break label3149;
      label5315:
      localObject4 = XmlParser.parseXml(paramString.substring(i, j + 17), "mmbrandmpvideo", null);
      if (localObject4 != null) {
        ((i)localObject1).mbl = i.j("", (Map)localObject4);
      }
      localObject1 = ((i)localObject1).mbl;
      break label3199;
      label5360:
      localObject4 = XmlParser.parseXml(paramString.substring(i, j + 13), "finderLive", null);
      if (localObject4 != null) {
        ((d)localObject1).i("", (Map)localObject4);
      }
      localObject1 = ((d)localObject1).mbh;
      break label3249;
      label5402:
      localObject3 = XmlParser.parseXml(paramString.substring(j, k + 9), "finder", null);
      if (localObject3 == null) {
        break label3291;
      }
      i = Util.safeParseInt((String)((Map)localObject3).get(".finder.type"));
      break label3291;
      label5445:
      localObject4 = paramString.substring(i, j + 9);
      i = ((String)localObject4).indexOf("<finderTopic>");
      j = ((String)localObject4).indexOf("</finderTopic>");
      if ((i < 0) || (j < 0))
      {
        localObject1 = null;
        break label3340;
      }
      localObject4 = XmlParser.parseXml(((String)localObject4).substring(i, j + 14), "finderTopic", null);
      if (localObject4 != null) {
        ((g)localObject1).i("", (Map)localObject4);
      }
      localObject1 = ((g)localObject1).mbf;
      break label3340;
      label5531:
      paramString = paramString.substring(i, j + 9);
      i = paramString.indexOf("<finderpoirelatedstream>");
      j = paramString.indexOf("</finderpoirelatedstream>");
      if ((i < 0) || (j < 0))
      {
        paramString = null;
        break label3389;
      }
      paramString = XmlParser.parseXml(paramString, "finder", null);
      if (paramString != null) {
        ((f)localObject3).i("", paramString);
      }
      paramString = ((f)localObject3).mbj;
      break label3389;
      label5600:
      paramString = new crk();
      paramString.appId = ((String)localObject1);
      paramString.path = Xj((String)localMap.get(".TimelineObject.liteApp.path"));
      paramString.query = Xj((String)localMap.get(".TimelineObject.liteApp.query"));
      break label3824;
    }
  }
  
  private static ey Xl(String paramString)
  {
    AppMethodBeat.i(94867);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(94867);
      return null;
    }
    paramString = Xm(paramString);
    paramString = XmlParser.parseXml("<root>" + paramString + "</root>", "root", null);
    if (paramString == null)
    {
      AppMethodBeat.o(94867);
      return null;
    }
    ey localey = new ey();
    localey.RJK = Xj((String)paramString.get(".root.en"));
    localey.RJL = Xj((String)paramString.get(".root.zh-CN"));
    localey.RJM = Xj((String)paramString.get(".root.zh-TW"));
    AppMethodBeat.o(94867);
    return localey;
  }
  
  public static String Xm(String paramString)
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
    AppMethodBeat.i(265781);
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
      AppMethodBeat.o(265781);
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
    if ((paramTimeLineObject != null) && (paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.Sqr != null) && (paramTimeLineObject.ContentObj.Sqr.size() > 0))
    {
      paramTimeLineObject = (cvt)paramTimeLineObject.ContentObj.Sqr.get(0);
      if ((paramTimeLineObject != null) && (paramTimeLineObject.TDH != null) && (paramTimeLineObject.TDH.TEu > 0.0F) && (paramTimeLineObject.TDH.TEv > 0.0F))
      {
        j = (int)paramTimeLineObject.TDH.TEu;
        i = (int)paramTimeLineObject.TDH.TEv;
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
  
  public static cvt a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4, String paramString4, cvv paramcvv)
  {
    AppMethodBeat.i(94865);
    cvt localcvt = new cvt();
    localcvt.Id = Xj(paramString1);
    localcvt.rWu = paramInt1;
    localcvt.CMB = Xj(paramString4);
    localcvt.Url = Xj(paramString2);
    localcvt.TlV = paramInt2;
    localcvt.TDF = Xj(paramString3);
    localcvt.TDG = paramInt3;
    localcvt.Privated = paramInt4;
    localcvt.TDH = paramcvv;
    if (paramString2 == null) {}
    for (paramString1 = "".getBytes();; paramString1 = paramString2.getBytes())
    {
      localcvt.TDS = com.tencent.mm.b.g.getMessageDigest(paramString1);
      AppMethodBeat.o(94865);
      return localcvt;
    }
  }
  
  public static cvt a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, String paramString4)
  {
    AppMethodBeat.i(94864);
    cvt localcvt = new cvt();
    localcvt.Id = paramString1;
    localcvt.rWu = paramInt1;
    localcvt.Url = paramString2;
    localcvt.TDF = paramString3;
    localcvt.TlV = paramInt2;
    localcvt.TDG = paramInt3;
    localcvt.CMB = paramString4;
    paramString1 = new cvv();
    paramString1.TEv = 0.0F;
    paramString1.TEu = 0.0F;
    paramString1.TEw = 0.0F;
    localcvt.TDH = paramString1;
    if (paramString2 == null) {}
    for (paramString1 = "".getBytes();; paramString1 = paramString2.getBytes())
    {
      localcvt.TDS = com.tencent.mm.b.g.getMessageDigest(paramString1);
      AppMethodBeat.o(94864);
      return localcvt;
    }
  }
  
  public static TimeLineObject bpc()
  {
    AppMethodBeat.i(94862);
    TimeLineObject localTimeLineObject = new TimeLineObject();
    Object localObject = new adw();
    localTimeLineObject.AppInfo = new ex();
    localTimeLineObject.ContentObj = ((adw)localObject);
    localTimeLineObject.Privated = 0;
    localTimeLineObject.CreateTime = 0;
    localTimeLineObject.Id = "";
    localObject = new cst();
    ((cst)localObject).ScP = 0.0F;
    ((cst)localObject).ScO = 0.0F;
    localTimeLineObject.Location = ((cst)localObject);
    localTimeLineObject.canvasInfo = "";
    localTimeLineObject.weappInfo = new fiu();
    AppMethodBeat.o(94862);
    return localTimeLineObject;
  }
  
  public static cvt bpd()
  {
    AppMethodBeat.i(94863);
    cvt localcvt = new cvt();
    localcvt.CMB = "";
    localcvt.Privated = 0;
    AppMethodBeat.o(94863);
    return localcvt;
  }
  
  public static Pair<Integer, Integer> dc(Context paramContext)
  {
    AppMethodBeat.i(265782);
    int i = a.fromDPToPix(paramContext, 225);
    paramContext = Pair.create(Integer.valueOf(a.fromDPToPix(paramContext, 127)), Integer.valueOf(i));
    AppMethodBeat.o(265782);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.o
 * JD-Core Version:    0.7.0.1
 */