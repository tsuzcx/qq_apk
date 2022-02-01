package com.tencent.mm.modelsns;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.protocal.protobuf.dif;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.dll;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.fb;
import com.tencent.mm.protocal.protobuf.feg;
import com.tencent.mm.protocal.protobuf.ffv;
import com.tencent.mm.protocal.protobuf.fjo;
import com.tencent.mm.protocal.protobuf.fr;
import com.tencent.mm.protocal.protobuf.fs;
import com.tencent.mm.protocal.protobuf.ft;
import com.tencent.mm.protocal.protobuf.gfh;
import com.tencent.mm.protocal.protobuf.gib;
import com.tencent.mm.protocal.protobuf.gom;
import com.tencent.mm.protocal.protobuf.jz;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.LinkedList;
import java.util.Map;

public final class o
{
  private static bmr In(String paramString)
  {
    AppMethodBeat.i(369551);
    d locald = new d();
    int i = paramString.indexOf("<finderLive>");
    int j = paramString.indexOf("</finderLive>");
    if ((i < 0) || (j < 0))
    {
      AppMethodBeat.o(369551);
      return null;
    }
    paramString = XmlParser.parseXml(paramString.substring(i, j + 13), "finderLive", null);
    if (paramString != null) {
      locald.i("", paramString);
    }
    paramString = locald.oUb;
    AppMethodBeat.o(369551);
    return paramString;
  }
  
  public static float Pk(String paramString)
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
  
  public static String Pl(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static TimeLineObject Pm(String paramString)
  {
    AppMethodBeat.i(94866);
    Map localMap = XmlParser.parseXml(paramString, "TimelineObject", null);
    TimeLineObject localTimeLineObject = bMJ();
    Object localObject1;
    int i;
    Object localObject4;
    Object localObject3;
    label1722:
    label2876:
    label2889:
    int j;
    label2960:
    label3010:
    label3060:
    int k;
    if (localMap != null)
    {
      localTimeLineObject.Id = Pl((String)localMap.get(".TimelineObject.id"));
      localTimeLineObject.UserName = Pl((String)localMap.get(".TimelineObject.username"));
      localTimeLineObject.Privated = Util.getInt((String)localMap.get(".TimelineObject.private"), 0);
      localTimeLineObject.CreateTime = Util.getInt((String)localMap.get(".TimelineObject.createTime"), 0);
      localTimeLineObject.ContentDesc = Pl((String)localMap.get(".TimelineObject.contentDesc"));
      localTimeLineObject.contentDescShowType = Util.getInt((String)localMap.get(".TimelineObject.contentDescShowType"), 0);
      localTimeLineObject.contentDescScene = Util.getInt((String)localMap.get(".TimelineObject.contentDescScene"), 0);
      localTimeLineObject.statExtStr = Pl((String)localMap.get(".TimelineObject.statExtStr"));
      localTimeLineObject.sightFolded = Util.getInt((String)localMap.get(".TimelineObject.sightFolded"), 0);
      localTimeLineObject.showFlag = Util.getInt((String)localMap.get(".TimelineObject.showFlag"), 0);
      localObject1 = new djv();
      ((djv)localObject1).ZaG = Pk((String)localMap.get(".TimelineObject.location.$longitude"));
      ((djv)localObject1).ZaH = Pk((String)localMap.get(".TimelineObject.location.$latitude"));
      ((djv)localObject1).pSh = Pl((String)localMap.get(".TimelineObject.location.$city"));
      ((djv)localObject1).aaPN = Util.getInt((String)localMap.get(".TimelineObject.location.$poiScale"), 0);
      ((djv)localObject1).ZWG = Pl((String)localMap.get(".TimelineObject.location.$poiClassifyId"));
      ((djv)localObject1).ReW = Util.getInt((String)localMap.get(".TimelineObject.location.$poiClassifyType"), 0);
      ((djv)localObject1).ReU = Pl((String)localMap.get(".TimelineObject.location.$poiAddress"));
      ((djv)localObject1).poiName = Pl((String)localMap.get(".TimelineObject.location.$poiName"));
      ((djv)localObject1).aaPO = Util.getInt((String)localMap.get(".TimelineObject.location.$poiClickableStatus"), 0);
      ((djv)localObject1).aaPQ = Pl((String)localMap.get(".TimelineObject.location.$poiAddressName"));
      ((djv)localObject1).country = Pl((String)localMap.get(".TimelineObject.location.$country"));
      localTimeLineObject.Location = ((djv)localObject1);
      if (localTimeLineObject.ContentObj == null) {
        localTimeLineObject.ContentObj = new agh();
      }
      localTimeLineObject.ContentObj.IGG = Pl((String)localMap.get(".TimelineObject.ContentObject.description"));
      localTimeLineObject.ContentObj.Zpq = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.contentStyle"), 0);
      localTimeLineObject.ContentObj.Zps = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.contentSubStyle"), 0);
      localTimeLineObject.ContentObj.hAP = Pl((String)localMap.get(".TimelineObject.ContentObject.title"));
      localTimeLineObject.ContentObj.Url = Pl((String)localMap.get(".TimelineObject.ContentObject.contentUrl"));
      if (localMap.containsKey(".TimelineObject.ContentObject.mmreadershare.itemshowtype"))
      {
        i = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.itemshowtype"), 0);
        if (i != -1)
        {
          localTimeLineObject.ContentObj.Zpu = new dll();
          localTimeLineObject.ContentObj.Zpu.nUA = i;
          localTimeLineObject.ContentObj.Zpu.nQp = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.ispaysubscribe"), 0);
        }
        if ((i == 5) || (i == 16))
        {
          localTimeLineObject.ContentObj.Zpu.nQn = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.pubtime"), 0);
          localTimeLineObject.ContentObj.Zpu.vid = Pl((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.vid"));
          localTimeLineObject.ContentObj.Zpu.coverUrl = Pl((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.cover"));
          localTimeLineObject.ContentObj.Zpu.nQq = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.funcflag"), 0);
          localTimeLineObject.ContentObj.Zpu.duration = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.duration"), 0);
          localTimeLineObject.ContentObj.Zpu.desc = Pl((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.digest"));
          localTimeLineObject.ContentObj.Zpu.nQo = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.nativepage"), 0);
          localTimeLineObject.ContentObj.Zpu.videoWidth = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.width"), 0);
          localTimeLineObject.ContentObj.Zpu.videoHeight = Util.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.height"), 0);
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
        localObject6 = new dnb();
        ((dnb)localObject6).aaUc = 0.0F;
        ((dnb)localObject6).aaUb = 0.0F;
        ((dnb)localObject6).aaUd = 0.0F;
        if (str26 != null) {
          ((dnb)localObject6).aaUb = Pk(str26);
        }
        if (str27 != null) {
          ((dnb)localObject6).aaUc = Pk(str27);
        }
        if (localObject7 != null) {
          ((dnb)localObject6).aaUd = Pk((String)localObject7);
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
          break label2889;
        }
        localObject7 = new dmz();
        ((dmz)localObject7).Id = Pl(str25);
        ((dmz)localObject7).vhJ = Util.getInt(str24, 0);
        ((dmz)localObject7).hAP = Pl(str23);
        ((dmz)localObject7).IGG = Pl(str22);
        ((dmz)localObject7).Url = Pl(str26);
        ((dmz)localObject7).aazR = Util.getInt(str17, 0);
        ((dmz)localObject7).aaTl = Pl(str19);
        ((dmz)localObject7).aaTm = Util.getInt(str16, 0);
        ((dmz)localObject7).Privated = Util.getInt(str20, 0);
        ((dmz)localObject7).aaTn = ((dnb)localObject6);
        ((dmz)localObject7).aaTo = Pl(str15);
        ((dmz)localObject7).aaTp = Util.getInt(str14, 0);
        ((dmz)localObject7).songAlbumUrl = str13;
        ((dmz)localObject7).songLyric = str12;
        ((dmz)localObject7).RcB = Pl(str10);
        ((dmz)localObject7).subType = Util.getInt(str11, 0);
        ((dmz)localObject7).aaTr = Pl(str9);
        ((dmz)localObject7).aaTt = Pl(str8);
        ((dmz)localObject7).aaTs = Pl(str7);
        ((dmz)localObject7).aaTE = Pl(str18);
        ((dmz)localObject7).RGm = Util.getInt(str6, 0);
        ((dmz)localObject7).aaTu = Pl(str5);
        ((dmz)localObject7).aaTv = Pl(str4);
        ((dmz)localObject7).aaTw = Util.getInt(str3, 0);
        ((dmz)localObject7).aaTx = Util.getLong(str2, 0L);
        if (((dmz)localObject7).Url != null) {
          break label2876;
        }
      }
      for (localObject1 = "".getBytes();; localObject1 = ((dmz)localObject7).Url.getBytes())
      {
        ((dmz)localObject7).aaTy = com.tencent.mm.b.g.getMessageDigest((byte[])localObject1);
        ((dmz)localObject7).msf = str1;
        ((dmz)localObject7).aaTz = Util.getInt((String)localObject5, 0);
        ((dmz)localObject7).aaTA = ((String)localObject4);
        ((dmz)localObject7).aaTB = ((String)localObject3);
        ((dmz)localObject7).aaTC = Util.getInt((String)localObject2, 0);
        ((dmz)localObject7).aaTD = str27;
        ((dmz)localObject7).aaTF = Pk(str21);
        localTimeLineObject.ContentObj.Zpr.add(localObject7);
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
        break label1722;
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
          break label5179;
        }
        localObject1 = null;
        ((agh)localObject3).hKU = ((bvl)localObject1);
        localObject3 = ((TimeLineObject)localObject2).ContentObj;
        localObject1 = new j();
        i = paramString.indexOf("<musicShareItem>");
        j = paramString.indexOf("</musicShareItem>");
        if ((i >= 0) && (j >= 0)) {
          break label5221;
        }
        localObject1 = null;
        ((agh)localObject3).oPb = ((dtj)localObject1);
        localObject3 = ((TimeLineObject)localObject2).ContentObj;
        localObject1 = new h();
        i = paramString.indexOf("<finderMegaVideo>");
        j = paramString.indexOf("</finderMegaVideo>");
        if ((i >= 0) && (j >= 0)) {
          break label5263;
        }
        localObject1 = null;
        ((agh)localObject3).Zpy = ((doc)localObject1);
        localObject3 = ((TimeLineObject)localObject2).ContentObj;
        localObject1 = new g();
        i = paramString.indexOf("<finderTopic>");
        j = paramString.indexOf("</finderTopic>");
        if ((i >= 0) && (j >= 0)) {
          break label5305;
        }
        localObject1 = null;
        label3110:
        ((agh)localObject3).Zpv = ((bvn)localObject1);
        localObject3 = ((TimeLineObject)localObject2).ContentObj;
        localObject1 = new c();
        i = paramString.indexOf("<finderColumn>");
        j = paramString.indexOf("</finderColumn>");
        if ((i >= 0) && (j >= 0)) {
          break label5347;
        }
        localObject1 = null;
        label3160:
        ((agh)localObject3).Zpx = ((bvh)localObject1);
        localObject3 = ((TimeLineObject)localObject2).ContentObj;
        localObject1 = new i();
        i = paramString.indexOf("<mmbrandmpvideo>");
        j = paramString.indexOf("</mmbrandmpvideo>");
        if ((i >= 0) && (j >= 0)) {
          break label5389;
        }
        localObject1 = null;
        label3210:
        ((agh)localObject3).Zpw = ((jz)localObject1);
        ((TimeLineObject)localObject2).ContentObj.DHa = In(paramString);
        localObject1 = ((TimeLineObject)localObject2).ContentObj;
        j = paramString.indexOf("<finder>");
        k = paramString.indexOf("</finder>");
        i = 0;
        if ((j >= 0) && (k >= 0)) {
          break label5434;
        }
        i = 0;
        label3264:
        ((agh)localObject1).nUa = i;
        localObject3 = ((TimeLineObject)localObject2).ContentObj;
        localObject1 = new g();
        i = paramString.indexOf("<finder>");
        j = paramString.indexOf("</finder>");
        if ((i >= 0) && (j >= 0)) {
          break label5477;
        }
        localObject1 = null;
        label3313:
        ((agh)localObject3).Zpz = ((bvn)localObject1);
        localObject3 = ((TimeLineObject)localObject2).ContentObj;
        localObject1 = new f();
        i = paramString.indexOf("<finder>");
        j = paramString.indexOf("</finder>");
        if ((i >= 0) && (j >= 0)) {
          break label5563;
        }
        localObject1 = null;
        label3363:
        ((agh)localObject3).ZpA = ((bvm)localObject1);
        localObject3 = ((TimeLineObject)localObject2).ContentObj;
        i = paramString.indexOf("<Tiger2022>");
        j = paramString.indexOf("</Tiger2022>");
        if ((i >= 0) && (j >= 0)) {
          break label5641;
        }
        paramString = null;
        ((agh)localObject3).akiL = paramString;
        paramString = new fr();
        localObject1 = Pl((String)localMap.get(".TimelineObject.appInfo.id"));
        localObject3 = Pl((String)localMap.get(".TimelineObject.appInfo.version"));
        localObject4 = Pl((String)localMap.get(".TimelineObject.appInfo.appName"));
        localObject5 = Pl((String)localMap.get(".TimelineObject.appInfo.installUrl "));
        str1 = Pl((String)localMap.get(".TimelineObject.appInfo.fromUrl "));
        paramString.Id = ((String)localObject1);
        paramString.IKJ = ((String)localObject4);
        paramString.YHb = ((String)localObject5);
        paramString.YHc = str1;
        paramString.Version = ((String)localObject3);
        paramString.YHd = Util.getInt((String)localMap.get(".TimelineObject.appInfo.clickable"), 0);
        ((TimeLineObject)localObject2).AppInfo = paramString;
        paramString = new gfh();
        localObject1 = Pl((String)localMap.get(".TimelineObject.weappInfo.appUserName"));
        localObject3 = Pl((String)localMap.get(".TimelineObject.weappInfo.pagePath"));
        localObject4 = Pl((String)localMap.get(".TimelineObject.weappInfo.version"));
        localObject5 = Pl((String)localMap.get(".TimelineObject.weappInfo.debugMode"));
        str1 = Pl((String)localMap.get(".TimelineObject.weappInfo.shareActionId"));
        str2 = Pl((String)localMap.get(".TimelineObject.weappInfo.isGame"));
        str3 = Pl((String)localMap.get(".TimelineObject.weappInfo.messageExtraData"));
        str4 = Pl((String)localMap.get(".TimelineObject.weappInfo.subType"));
        str5 = Pl((String)localMap.get(".TimelineObject.weappInfo.preloadResources"));
        paramString.username = ((String)localObject1);
        paramString.path = ((String)localObject3);
        paramString.version = Util.getInt((String)localObject4, 0);
        paramString.tgv = Util.getInt((String)localObject5, 0);
        paramString.hzD = str1;
        paramString.accE = Util.getInt(str2, 0);
        paramString.idf = str3;
        paramString.subType = Util.getInt(str4, 0);
        paramString.accF = str5;
        ((TimeLineObject)localObject2).weappInfo = paramString;
        localObject1 = Pl((String)localMap.get(".TimelineObject.liteApp.appId"));
        if (!((String)localObject1).isEmpty()) {
          break label5840;
        }
        paramString = null;
        label3838:
        ((TimeLineObject)localObject2).liteappInfo = paramString;
        paramString = new fjo();
        localObject1 = Pl((String)localMap.get(".TimelineObject.streamvideo.streamvideotitle"));
        localObject3 = Pl((String)localMap.get(".TimelineObject.streamvideo.streamvideototaltime"));
        localObject4 = Pl((String)localMap.get(".TimelineObject.streamvideo.streamvideourl"));
        localObject5 = Pl((String)localMap.get(".TimelineObject.streamvideo.streamvideoweburl"));
        str1 = Pl((String)localMap.get(".TimelineObject.streamvideo.streamvideowording"));
        str2 = Pl((String)localMap.get(".TimelineObject.streamvideo.streamvideothumburl"));
        str3 = Pl((String)localMap.get(".TimelineObject.streamvideo.streamvideoaduxinfo"));
        str4 = Pl((String)localMap.get(".TimelineObject.streamvideo.streamvideopublishid"));
        paramString.nTw = ((String)localObject1);
        paramString.nTv = Util.safeParseInt((String)localObject3);
        paramString.nTu = ((String)localObject4);
        paramString.nTy = ((String)localObject5);
        paramString.nTx = str1;
        paramString.nTz = str2;
        paramString.nTA = str3;
        paramString.nTB = str4;
        ((TimeLineObject)localObject2).streamvideo = paramString;
        paramString = new feg();
        localObject1 = Pl((String)localMap.get(".TimelineObject.redEnvelopesInfo.sendId"));
        localObject3 = Pl((String)localMap.get(".TimelineObject.redEnvelopesInfo.ticket"));
        paramString.CAf = ((String)localObject1);
        paramString.hFb = ((String)localObject3);
        paramString = new bh();
        i = Util.getInt((String)localMap.get(".TimelineObject.actionInfo.scene"), 0);
        localObject1 = Pl((String)localMap.get(".TimelineObject.actionInfo.appid"));
        j = Util.getInt((String)localMap.get(".TimelineObject.actionInfo.type"), 0);
        localObject3 = Pl((String)localMap.get(".TimelineObject.actionInfo.url"));
        localObject4 = Pl((String)localMap.get(".TimelineObject.actionInfo.mediaTagName"));
        localObject5 = Pl((String)localMap.get(".TimelineObject.actionInfo.wordingKey"));
        paramString.YCz = ((String)localObject1);
        paramString.IJG = i;
        paramString.vhJ = j;
        paramString.Url = ((String)localObject3);
        paramString.YCA = ((String)localObject4);
        paramString.YCB = ((String)localObject5);
        localObject1 = new bd();
        localObject3 = Pl((String)localMap.get(".TimelineObject.actionInfo.appMsg.appid"));
        localObject4 = Pl((String)localMap.get(".TimelineObject.actionInfo.appMsg.mediaTagName"));
        localObject5 = Pl((String)localMap.get(".TimelineObject.actionInfo.appMsg.messageExt"));
        str1 = Pl((String)localMap.get(".TimelineObject.actionInfo.appMsg.messageAction"));
        ((bd)localObject1).oOI = ((String)localObject3);
        ((bd)localObject1).YCm = ((String)localObject4);
        ((bd)localObject1).YCn = ((String)localObject5);
        ((bd)localObject1).YCo = str1;
        paramString.YCC = ((bd)localObject1);
        i = Util.getInt((String)localMap.get(".TimelineObject.actionInfo.appActionScene.installedActionScene"), 0);
        j = Util.getInt((String)localMap.get(".TimelineObject.actionInfo.appActionScene.uninstalledActionScene"), 0);
        localObject1 = Pl((String)localMap.get(".TimelineObject.actionInfo.appJumpWordingKey.installedWordingKey"));
        localObject3 = Pl((String)localMap.get(".TimelineObject.actionInfo.appJumpWordingKey.uninstalledWordingKey"));
        paramString.YCD = Pl((String)localMap.get(".TimelineObject.actionInfo.newWordingKey"));
        localObject4 = new fb();
        ((fb)localObject4).YGN = i;
        ((fb)localObject4).YGO = j;
        localObject5 = new ft();
        ((ft)localObject5).YHh = ((String)localObject1);
        ((ft)localObject5).YHi = ((String)localObject3);
        paramString.YCE = ((fb)localObject4);
        paramString.YCF = ((ft)localObject5);
        paramString.YCG = Pn((String)localMap.get(".TimelineObject.actionInfo.installedWording"));
        paramString.YCH = Pn((String)localMap.get(".TimelineObject.actionInfo.uninstalledWording"));
        ((TimeLineObject)localObject2).actionInfo = paramString;
        ((TimeLineObject)localObject2).sourceUserName = Pl((String)localMap.get(".TimelineObject.sourceUserName"));
        ((TimeLineObject)localObject2).sourceNickName = Pl((String)localMap.get(".TimelineObject.sourceNickName"));
        ((TimeLineObject)localObject2).publicUserName = Pl((String)localMap.get(".TimelineObject.publicUserName"));
        ((TimeLineObject)localObject2).statisticsData = Pl((String)localMap.get(".TimelineObject.statisticsData"));
        ((TimeLineObject)localObject2).canvasInfo = Pl((String)localMap.get(".TimelineObject.canvasInfoXml"));
        ((TimeLineObject)localObject2).contentattr = Util.getInt((String)localMap.get(".TimelineObject.contentattr"), 0);
        paramString = new gib();
        paramString.WoZ = Pl((String)localMap.get(".TimelineObject.websearch.relevant_vid"));
        paramString.Wpa = Pl((String)localMap.get(".TimelineObject.websearch.relevant_expand"));
        paramString.Wpb = Pl((String)localMap.get(".TimelineObject.websearch.relevant_pre_searchid"));
        paramString.Wpc = Pl((String)localMap.get(".TimelineObject.websearch.relevant_shared_openid"));
        paramString.Wpd = Util.getLong((String)localMap.get(".TimelineObject.websearch.rec_category"), 0L);
        paramString.ytZ = Pl((String)localMap.get(".TimelineObject.websearch.shareUrl"));
        paramString.svG = Pl((String)localMap.get(".TimelineObject.websearch.shareTitle"));
        paramString.ICb = Pl((String)localMap.get(".TimelineObject.websearch.shareDesc"));
        paramString.Wpe = Pl((String)localMap.get(".TimelineObject.websearch.shareImgUrl"));
        paramString.Wpf = Pl((String)localMap.get(".TimelineObject.websearch.shareString"));
        paramString.Wpg = Pl((String)localMap.get(".TimelineObject.websearch.shareStringUrl"));
        paramString.source = Pl((String)localMap.get(".TimelineObject.websearch.source"));
        paramString.ibx = Pl((String)localMap.get(".TimelineObject.websearch.sourceUrl"));
        paramString.Wph = Pl((String)localMap.get(".TimelineObject.websearch.strPlayCount"));
        paramString.Wpi = Pl((String)localMap.get(".TimelineObject.websearch.titleUrl"));
        paramString.Wpj = Pl((String)localMap.get(".TimelineObject.websearch.extReqParams"));
        paramString.Wpk = Pl((String)localMap.get(".TimelineObject.websearch.tagList"));
        paramString.Wpl = Util.getLong((String)localMap.get(".TimelineObject.websearch.channelId"), 0L);
        paramString.Wpm = Pl((String)localMap.get(".TimelineObject.websearch.shareTag"));
        ((TimeLineObject)localObject2).webSearchInfo = paramString;
        localObject1 = Pl((String)localMap.get(".TimelineObject.VideoTemplate.Type"));
        localObject3 = Pl((String)localMap.get(".TimelineObject.VideoTemplate.TemplateId"));
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3))) {
          break label5897;
        }
        paramString = null;
        label5145:
        ((TimeLineObject)localObject2).videoTemplate = paramString;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(94866);
      return localTimeLineObject;
      localTimeLineObject.ContentObj.Zpt = paramString.substring(i, j + 11);
      break;
      label5179:
      localObject4 = XmlParser.parseXml(paramString.substring(i, j + 13), "finderFeed", null);
      if (localObject4 != null) {
        ((e)localObject1).i("", (Map)localObject4);
      }
      localObject1 = ((e)localObject1).oUc;
      break label2960;
      label5221:
      localObject4 = XmlParser.parseXml(paramString.substring(i, j + 17), "musicShareItem", null);
      if (localObject4 != null) {
        ((j)localObject1).i("", (Map)localObject4);
      }
      localObject1 = ((j)localObject1).oUg;
      break label3010;
      label5263:
      localObject4 = XmlParser.parseXml(paramString.substring(i, j + 18), "finderMegaVideo", null);
      if (localObject4 != null) {
        ((h)localObject1).i("", (Map)localObject4);
      }
      localObject1 = ((h)localObject1).oUe;
      break label3060;
      label5305:
      localObject4 = XmlParser.parseXml(paramString.substring(i, j + 14), "finderTopic", null);
      if (localObject4 != null) {
        ((g)localObject1).i("", (Map)localObject4);
      }
      localObject1 = ((g)localObject1).oTZ;
      break label3110;
      label5347:
      localObject4 = XmlParser.parseXml(paramString.substring(i, j + 15), "finderColumn", null);
      if (localObject4 != null) {
        ((c)localObject1).i("", (Map)localObject4);
      }
      localObject1 = ((c)localObject1).oUa;
      break label3160;
      label5389:
      localObject4 = XmlParser.parseXml(paramString.substring(i, j + 17), "mmbrandmpvideo", null);
      if (localObject4 != null) {
        ((i)localObject1).oUf = i.j("", (Map)localObject4);
      }
      localObject1 = ((i)localObject1).oUf;
      break label3210;
      label5434:
      localObject3 = XmlParser.parseXml(paramString.substring(j, k + 9), "finder", null);
      if (localObject3 == null) {
        break label3264;
      }
      i = Util.safeParseInt((String)((Map)localObject3).get(".finder.type"));
      break label3264;
      label5477:
      localObject4 = paramString.substring(i, j + 9);
      i = ((String)localObject4).indexOf("<finderTopic>");
      j = ((String)localObject4).indexOf("</finderTopic>");
      if ((i < 0) || (j < 0))
      {
        localObject1 = null;
        break label3313;
      }
      localObject4 = XmlParser.parseXml(((String)localObject4).substring(i, j + 14), "finderTopic", null);
      if (localObject4 != null) {
        ((g)localObject1).i("", (Map)localObject4);
      }
      localObject1 = ((g)localObject1).oTZ;
      break label3313;
      label5563:
      localObject4 = paramString.substring(i, j + 9);
      i = ((String)localObject4).indexOf("<finderpoirelatedstream>");
      j = ((String)localObject4).indexOf("</finderpoirelatedstream>");
      if ((i < 0) || (j < 0))
      {
        localObject1 = null;
        break label3363;
      }
      localObject4 = XmlParser.parseXml((String)localObject4, "finder", null);
      if (localObject4 != null) {
        ((f)localObject1).i("", (Map)localObject4);
      }
      localObject1 = ((f)localObject1).oUd;
      break label3363;
      label5641:
      localObject1 = new gom();
      j = paramString.indexOf("<LinkEnabled>", i);
      k = paramString.indexOf("</LinkEnabled>", i);
      if ((j >= 0) && (k >= 0))
      {
        localObject4 = paramString.substring(j + 13, k).trim();
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          if (Util.safeParseInt((String)localObject4) != 1) {
            break label5834;
          }
        }
      }
      label5834:
      for (boolean bool = true;; bool = false)
      {
        ((gom)localObject1).aklp = bool;
        j = paramString.indexOf("<EnterLiveMode>", i);
        k = paramString.indexOf("</EnterLiveMode>", i);
        if ((j >= 0) && (k >= 0))
        {
          localObject4 = paramString.substring(j + 15, k).trim();
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            ((gom)localObject1).aklr = Util.safeParseInt((String)localObject4);
          }
        }
        j = paramString.indexOf("<finderLive>", i);
        i = paramString.indexOf("</finderLive>", i);
        if ((j >= 0) && (i >= 0))
        {
          paramString = paramString.substring(j, i + 13).trim();
          if (!TextUtils.isEmpty(paramString)) {
            ((gom)localObject1).aklq = In(paramString);
          }
        }
        paramString = (String)localObject1;
        break;
      }
      label5840:
      paramString = new dif();
      paramString.appId = ((String)localObject1);
      paramString.path = Pl((String)localMap.get(".TimelineObject.liteApp.path"));
      paramString.query = Pl((String)localMap.get(".TimelineObject.liteApp.query"));
      break label3838;
      label5897:
      paramString = new ffv();
      paramString.type = ((String)localObject1);
      paramString.nSg = ((String)localObject3);
      paramString.musicId = Pl((String)localMap.get(".TimelineObject.VideoTemplate.MusicId"));
      paramString.abFS = Util.getLong((String)localMap.get(".TimelineObject.VideoTemplate.VersionInfo.IosSdkVersionMin"), 0L);
      paramString.abFR = Util.getLong((String)localMap.get(".TimelineObject.VideoTemplate.VersionInfo.AndroidSdkVersionMin"), 0L);
      break label5145;
    }
  }
  
  private static fs Pn(String paramString)
  {
    AppMethodBeat.i(94867);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(94867);
      return null;
    }
    paramString = Po(paramString);
    paramString = XmlParser.parseXml("<root>" + paramString + "</root>", "root", null);
    if (paramString == null)
    {
      AppMethodBeat.o(94867);
      return null;
    }
    fs localfs = new fs();
    localfs.YHe = Pl((String)paramString.get(".root.en"));
    localfs.YHf = Pl((String)paramString.get(".root.zh-CN"));
    localfs.YHg = Pl((String)paramString.get(".root.zh-TW"));
    AppMethodBeat.o(94867);
    return localfs;
  }
  
  public static String Po(String paramString)
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
    AppMethodBeat.i(233348);
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
      AppMethodBeat.o(233348);
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
    if ((paramTimeLineObject != null) && (paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.Zpr != null) && (paramTimeLineObject.ContentObj.Zpr.size() > 0))
    {
      paramTimeLineObject = (dmz)paramTimeLineObject.ContentObj.Zpr.get(0);
      if ((paramTimeLineObject != null) && (paramTimeLineObject.aaTn != null) && (paramTimeLineObject.aaTn.aaUb > 0.0F) && (paramTimeLineObject.aaTn.aaUc > 0.0F))
      {
        j = (int)paramTimeLineObject.aaTn.aaUb;
        i = (int)paramTimeLineObject.aaTn.aaUc;
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
  
  public static dmz a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4, String paramString4, dnb paramdnb)
  {
    AppMethodBeat.i(94865);
    dmz localdmz = new dmz();
    localdmz.Id = Pl(paramString1);
    localdmz.vhJ = paramInt1;
    localdmz.IGG = Pl(paramString4);
    localdmz.Url = Pl(paramString2);
    localdmz.aazR = paramInt2;
    localdmz.aaTl = Pl(paramString3);
    localdmz.aaTm = paramInt3;
    localdmz.Privated = paramInt4;
    localdmz.aaTn = paramdnb;
    if (paramString2 == null) {}
    for (paramString1 = "".getBytes();; paramString1 = paramString2.getBytes())
    {
      localdmz.aaTy = com.tencent.mm.b.g.getMessageDigest(paramString1);
      AppMethodBeat.o(94865);
      return localdmz;
    }
  }
  
  public static dmz a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, String paramString4)
  {
    AppMethodBeat.i(94864);
    dmz localdmz = new dmz();
    localdmz.Id = paramString1;
    localdmz.vhJ = paramInt1;
    localdmz.Url = paramString2;
    localdmz.aaTl = paramString3;
    localdmz.aazR = paramInt2;
    localdmz.aaTm = paramInt3;
    localdmz.IGG = paramString4;
    paramString1 = new dnb();
    paramString1.aaUc = 0.0F;
    paramString1.aaUb = 0.0F;
    paramString1.aaUd = 0.0F;
    localdmz.aaTn = paramString1;
    if (paramString2 == null) {}
    for (paramString1 = "".getBytes();; paramString1 = paramString2.getBytes())
    {
      localdmz.aaTy = com.tencent.mm.b.g.getMessageDigest(paramString1);
      AppMethodBeat.o(94864);
      return localdmz;
    }
  }
  
  public static TimeLineObject bMJ()
  {
    AppMethodBeat.i(94862);
    TimeLineObject localTimeLineObject = new TimeLineObject();
    Object localObject = new agh();
    localTimeLineObject.AppInfo = new fr();
    localTimeLineObject.ContentObj = ((agh)localObject);
    localTimeLineObject.Privated = 0;
    localTimeLineObject.CreateTime = 0;
    localTimeLineObject.Id = "";
    localObject = new djv();
    ((djv)localObject).ZaH = 0.0F;
    ((djv)localObject).ZaG = 0.0F;
    localTimeLineObject.Location = ((djv)localObject);
    localTimeLineObject.canvasInfo = "";
    localTimeLineObject.weappInfo = new gfh();
    localTimeLineObject.videoTemplate = null;
    AppMethodBeat.o(94862);
    return localTimeLineObject;
  }
  
  public static dmz bMK()
  {
    AppMethodBeat.i(94863);
    dmz localdmz = new dmz();
    localdmz.IGG = "";
    localdmz.Privated = 0;
    AppMethodBeat.o(94863);
    return localdmz;
  }
  
  public static Pair<Integer, Integer> dV(Context paramContext)
  {
    AppMethodBeat.i(233367);
    int i = a.fromDPToPix(paramContext, 225);
    paramContext = Pair.create(Integer.valueOf(a.fromDPToPix(paramContext, 127)), Integer.valueOf(i));
    AppMethodBeat.o(233367);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsns.o
 * JD-Core Version:    0.7.0.1
 */