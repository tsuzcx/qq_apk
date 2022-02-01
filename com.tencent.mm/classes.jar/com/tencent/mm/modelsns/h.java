package com.tencent.mm.modelsns;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.cb.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.arz;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.protocal.protobuf.dgr;
import com.tencent.mm.protocal.protobuf.dlc;
import com.tencent.mm.protocal.protobuf.dy;
import com.tencent.mm.protocal.protobuf.edv;
import com.tencent.mm.protocal.protobuf.egh;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.protocal.protobuf.eo;
import com.tencent.mm.protocal.protobuf.ep;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.LinkedList;
import java.util.Map;

public final class h
{
  private static float GX(String paramString)
  {
    AppMethodBeat.i(94861);
    if (paramString == null)
    {
      AppMethodBeat.o(94861);
      return 0.0F;
    }
    float f = bu.getFloat(paramString, 0.0F);
    AppMethodBeat.o(94861);
    return f;
  }
  
  private static String GY(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static TimeLineObject GZ(String paramString)
  {
    AppMethodBeat.i(94866);
    Map localMap = bx.M(paramString, "TimelineObject");
    TimeLineObject localTimeLineObject = aLJ();
    Object localObject1;
    int i;
    Object localObject4;
    Object localObject3;
    label1696:
    label2855:
    int j;
    if (localMap != null)
    {
      localTimeLineObject.Id = GY((String)localMap.get(".TimelineObject.id"));
      localTimeLineObject.nIJ = GY((String)localMap.get(".TimelineObject.username"));
      localTimeLineObject.Hml = bu.getInt((String)localMap.get(".TimelineObject.private"), 0);
      localTimeLineObject.CreateTime = bu.getInt((String)localMap.get(".TimelineObject.createTime"), 0);
      localTimeLineObject.HUD = GY((String)localMap.get(".TimelineObject.contentDesc"));
      localTimeLineObject.HUI = bu.getInt((String)localMap.get(".TimelineObject.contentDescShowType"), 0);
      localTimeLineObject.HUJ = bu.getInt((String)localMap.get(".TimelineObject.contentDescScene"), 0);
      localTimeLineObject.AiG = GY((String)localMap.get(".TimelineObject.statExtStr"));
      localTimeLineObject.HUN = bu.getInt((String)localMap.get(".TimelineObject.sightFolded"), 0);
      localTimeLineObject.eQZ = bu.getInt((String)localMap.get(".TimelineObject.showFlag"), 0);
      localObject1 = new bwk();
      ((bwk)localObject1).GgZ = GX((String)localMap.get(".TimelineObject.location.$longitude"));
      ((bwk)localObject1).Gha = GX((String)localMap.get(".TimelineObject.location.$latitude"));
      ((bwk)localObject1).jfX = GY((String)localMap.get(".TimelineObject.location.$city"));
      ((bwk)localObject1).Hjr = bu.getInt((String)localMap.get(".TimelineObject.location.$poiScale"), 0);
      ((bwk)localObject1).GGA = GY((String)localMap.get(".TimelineObject.location.$poiClassifyId"));
      ((bwk)localObject1).Ajt = bu.getInt((String)localMap.get(".TimelineObject.location.$poiClassifyType"), 0);
      ((bwk)localObject1).Ajr = GY((String)localMap.get(".TimelineObject.location.$poiAddress"));
      ((bwk)localObject1).jGd = GY((String)localMap.get(".TimelineObject.location.$poiName"));
      ((bwk)localObject1).Hjs = bu.getInt((String)localMap.get(".TimelineObject.location.$poiClickableStatus"), 0);
      ((bwk)localObject1).Hju = GY((String)localMap.get(".TimelineObject.location.$poiAddressName"));
      ((bwk)localObject1).country = GY((String)localMap.get(".TimelineObject.location.$country"));
      localTimeLineObject.HUE = ((bwk)localObject1);
      if (localTimeLineObject.HUG == null) {
        localTimeLineObject.HUG = new abo();
      }
      localTimeLineObject.HUG.Desc = GY((String)localMap.get(".TimelineObject.ContentObject.description"));
      localTimeLineObject.HUG.Gtw = bu.getInt((String)localMap.get(".TimelineObject.ContentObject.contentStyle"), 0);
      localTimeLineObject.HUG.Gty = bu.getInt((String)localMap.get(".TimelineObject.ContentObject.contentSubStyle"), 0);
      localTimeLineObject.HUG.Title = GY((String)localMap.get(".TimelineObject.ContentObject.title"));
      localTimeLineObject.HUG.Url = GY((String)localMap.get(".TimelineObject.ContentObject.contentUrl"));
      if (localMap.containsKey(".TimelineObject.ContentObject.mmreadershare.itemshowtype"))
      {
        i = bu.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.itemshowtype"), 0);
        if (i != -1)
        {
          localTimeLineObject.HUG.GtA = new bxq();
          localTimeLineObject.HUG.GtA.hFR = i;
          localTimeLineObject.HUG.GtA.hBY = bu.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.ispaysubscribe"), 0);
        }
        if (i == 5)
        {
          localTimeLineObject.HUG.GtA.hBW = bu.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.pubtime"), 0);
          localTimeLineObject.HUG.GtA.hCa = GY((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.vid"));
          localTimeLineObject.HUG.GtA.coverUrl = GY((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.cover"));
          localTimeLineObject.HUG.GtA.hBZ = bu.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.funcflag"), 0);
          localTimeLineObject.HUG.GtA.duration = bu.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.duration"), 0);
          localTimeLineObject.HUG.GtA.desc = GY((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.digest"));
          localTimeLineObject.HUG.GtA.hBX = bu.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.nativepage"), 0);
          localTimeLineObject.HUG.GtA.videoWidth = bu.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.width"), 0);
          localTimeLineObject.HUG.GtA.videoHeight = bu.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.height"), 0);
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
        localObject6 = new bzj();
        ((bzj)localObject6).Hnb = 0.0F;
        ((bzj)localObject6).Hna = 0.0F;
        ((bzj)localObject6).Hnc = 0.0F;
        if (str26 != null) {
          ((bzj)localObject6).Hna = GX(str26);
        }
        if (str27 != null) {
          ((bzj)localObject6).Hnb = GX(str27);
        }
        if (localObject7 != null) {
          ((bzj)localObject6).Hnc = GX((String)localObject7);
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
        if ((str24 == null) || (str25 == null)) {
          break label2855;
        }
        localObject7 = new bzh();
        ((bzh)localObject7).Id = GY(str25);
        ((bzh)localObject7).nJA = bu.getInt(str24, 0);
        ((bzh)localObject7).Title = GY(str23);
        ((bzh)localObject7).Desc = GY(str22);
        ((bzh)localObject7).Url = GY(str26);
        ((bzh)localObject7).GXH = bu.getInt(str17, 0);
        ((bzh)localObject7).Hmj = GY(str19);
        ((bzh)localObject7).Hmk = bu.getInt(str16, 0);
        ((bzh)localObject7).Hml = bu.getInt(str20, 0);
        ((bzh)localObject7).Hmm = ((bzj)localObject6);
        ((bzh)localObject7).Hmn = GY(str15);
        ((bzh)localObject7).Hmo = bu.getInt(str14, 0);
        ((bzh)localObject7).songAlbumUrl = str13;
        ((bzh)localObject7).songLyric = str12;
        ((bzh)localObject7).Aho = GY(str10);
        ((bzh)localObject7).subType = bu.getInt(str11, 0);
        ((bzh)localObject7).Hmq = GY(str9);
        ((bzh)localObject7).Hms = GY(str8);
        ((bzh)localObject7).Hmr = GY(str7);
        ((bzh)localObject7).HmE = GY(str18);
        ((bzh)localObject7).AIa = bu.getInt(str6, 0);
        ((bzh)localObject7).Hmt = GY(str5);
        ((bzh)localObject7).Hmu = GY(str4);
        ((bzh)localObject7).Hmv = bu.getInt(str3, 0);
        ((bzh)localObject7).Hmw = bu.getLong(str2, 0L);
        if (((bzh)localObject7).Url != null) {
          break label2843;
        }
      }
      label2843:
      for (localObject1 = "".getBytes();; localObject1 = ((bzh)localObject7).Url.getBytes())
      {
        ((bzh)localObject7).Hmx = g.getMessageDigest((byte[])localObject1);
        ((bzh)localObject7).Hmy = str1;
        ((bzh)localObject7).Hmz = bu.getInt((String)localObject5, 0);
        ((bzh)localObject7).HmA = ((String)localObject4);
        ((bzh)localObject7).HmB = ((String)localObject3);
        ((bzh)localObject7).HmC = bu.getInt((String)localObject2, 0);
        ((bzh)localObject7).HmD = str27;
        ((bzh)localObject7).HmF = GX(str21);
        localTimeLineObject.HUG.Gtx.add(localObject7);
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
        break label1696;
      }
      i = paramString.indexOf("<noteinfo>");
      j = paramString.indexOf("</noteinfo>");
      if ((i < 0) || (j < 0))
      {
        localObject2 = localTimeLineObject;
        localObject3 = ((TimeLineObject)localObject2).HUG;
        localObject1 = new b();
        i = paramString.indexOf("<finderFeed>");
        j = paramString.indexOf("</finderFeed>");
        if ((i >= 0) && (j >= 0)) {
          break label4657;
        }
        localObject1 = null;
        label2924:
        ((abo)localObject3).GtB = ((ary)localObject1);
        localObject3 = ((TimeLineObject)localObject2).HUG;
        localObject1 = new c();
        i = paramString.indexOf("<finderTopic>");
        j = paramString.indexOf("</finderTopic>");
        if ((i >= 0) && (j >= 0)) {
          break label4695;
        }
        localObject1 = null;
        label2971:
        ((abo)localObject3).GtC = ((arz)localObject1);
        localObject1 = ((TimeLineObject)localObject2).HUG;
        localObject3 = new d();
        i = paramString.indexOf("<mmbrandmpvideo>");
        j = paramString.indexOf("</mmbrandmpvideo>");
        if ((i >= 0) && (j >= 0)) {
          break label4733;
        }
        paramString = null;
        label3018:
        ((abo)localObject1).GtD = paramString;
        paramString = new en();
        localObject1 = GY((String)localMap.get(".TimelineObject.appInfo.id"));
        localObject3 = GY((String)localMap.get(".TimelineObject.appInfo.version"));
        localObject4 = GY((String)localMap.get(".TimelineObject.appInfo.appName"));
        localObject5 = GY((String)localMap.get(".TimelineObject.appInfo.installUrl "));
        str1 = GY((String)localMap.get(".TimelineObject.appInfo.fromUrl "));
        paramString.Id = ((String)localObject1);
        paramString.uuo = ((String)localObject4);
        paramString.FOI = ((String)localObject5);
        paramString.FOJ = str1;
        paramString.Version = ((String)localObject3);
        paramString.FOK = bu.getInt((String)localMap.get(".TimelineObject.appInfo.clickable"), 0);
        ((TimeLineObject)localObject2).HUF = paramString;
        paramString = new edv();
        localObject1 = GY((String)localMap.get(".TimelineObject.weappInfo.appUserName"));
        localObject3 = GY((String)localMap.get(".TimelineObject.weappInfo.pagePath"));
        localObject4 = GY((String)localMap.get(".TimelineObject.weappInfo.version"));
        localObject5 = GY((String)localMap.get(".TimelineObject.weappInfo.debugMode"));
        str1 = GY((String)localMap.get(".TimelineObject.weappInfo.shareActionId"));
        str2 = GY((String)localMap.get(".TimelineObject.weappInfo.isGame"));
        str3 = GY((String)localMap.get(".TimelineObject.weappInfo.messageExtraData"));
        str4 = GY((String)localMap.get(".TimelineObject.weappInfo.subType"));
        paramString.username = ((String)localObject1);
        paramString.path = ((String)localObject3);
        paramString.version = bu.getInt((String)localObject4, 0);
        paramString.DUS = bu.getInt((String)localObject5, 0);
        paramString.IiI = str1;
        paramString.isGame = bu.getInt(str2, 0);
        paramString.dLl = str3;
        paramString.subType = bu.getInt(str4, 0);
        ((TimeLineObject)localObject2).HUM = paramString;
        paramString = new dlc();
        localObject1 = GY((String)localMap.get(".TimelineObject.streamvideo.streamvideotitle"));
        localObject3 = GY((String)localMap.get(".TimelineObject.streamvideo.streamvideototaltime"));
        localObject4 = GY((String)localMap.get(".TimelineObject.streamvideo.streamvideourl"));
        localObject5 = GY((String)localMap.get(".TimelineObject.streamvideo.streamvideoweburl"));
        str1 = GY((String)localMap.get(".TimelineObject.streamvideo.streamvideowording"));
        str2 = GY((String)localMap.get(".TimelineObject.streamvideo.streamvideothumburl"));
        str3 = GY((String)localMap.get(".TimelineObject.streamvideo.streamvideoaduxinfo"));
        str4 = GY((String)localMap.get(".TimelineObject.streamvideo.streamvideopublishid"));
        paramString.hEV = ((String)localObject1);
        paramString.hEU = bu.aSB((String)localObject3);
        paramString.hET = ((String)localObject4);
        paramString.hEX = ((String)localObject5);
        paramString.hEW = str1;
        paramString.hEY = str2;
        paramString.hEZ = str3;
        paramString.hFa = str4;
        ((TimeLineObject)localObject2).HUL = paramString;
        paramString = new dgr();
        localObject1 = GY((String)localMap.get(".TimelineObject.redEnvelopesInfo.sendId"));
        localObject3 = GY((String)localMap.get(".TimelineObject.redEnvelopesInfo.ticket"));
        paramString.vwq = ((String)localObject1);
        paramString.dqk = ((String)localObject3);
        paramString = new ba();
        i = bu.getInt((String)localMap.get(".TimelineObject.actionInfo.scene"), 0);
        localObject1 = GY((String)localMap.get(".TimelineObject.actionInfo.appid"));
        j = bu.getInt((String)localMap.get(".TimelineObject.actionInfo.type"), 0);
        localObject3 = GY((String)localMap.get(".TimelineObject.actionInfo.url"));
        localObject4 = GY((String)localMap.get(".TimelineObject.actionInfo.mediaTagName"));
        localObject5 = GY((String)localMap.get(".TimelineObject.actionInfo.wordingKey"));
        paramString.FKT = ((String)localObject1);
        paramString.Scene = i;
        paramString.nJA = j;
        paramString.Url = ((String)localObject3);
        paramString.FKU = ((String)localObject4);
        paramString.FKV = ((String)localObject5);
        localObject1 = new ay();
        localObject3 = GY((String)localMap.get(".TimelineObject.actionInfo.appMsg.appid"));
        localObject4 = GY((String)localMap.get(".TimelineObject.actionInfo.appMsg.mediaTagName"));
        localObject5 = GY((String)localMap.get(".TimelineObject.actionInfo.appMsg.messageExt"));
        str1 = GY((String)localMap.get(".TimelineObject.actionInfo.appMsg.messageAction"));
        ((ay)localObject1).ikm = ((String)localObject3);
        ((ay)localObject1).FKQ = ((String)localObject4);
        ((ay)localObject1).FKR = ((String)localObject5);
        ((ay)localObject1).FKS = str1;
        paramString.FKW = ((ay)localObject1);
        i = bu.getInt((String)localMap.get(".TimelineObject.actionInfo.appActionScene.installedActionScene"), 0);
        j = bu.getInt((String)localMap.get(".TimelineObject.actionInfo.appActionScene.uninstalledActionScene"), 0);
        localObject1 = GY((String)localMap.get(".TimelineObject.actionInfo.appJumpWordingKey.installedWordingKey"));
        localObject3 = GY((String)localMap.get(".TimelineObject.actionInfo.appJumpWordingKey.uninstalledWordingKey"));
        paramString.FKX = GY((String)localMap.get(".TimelineObject.actionInfo.newWordingKey"));
        localObject4 = new dy();
        ((dy)localObject4).FOv = i;
        ((dy)localObject4).FOw = j;
        localObject5 = new ep();
        ((ep)localObject5).FOO = ((String)localObject1);
        ((ep)localObject5).FOP = ((String)localObject3);
        paramString.FKY = ((dy)localObject4);
        paramString.FKZ = ((ep)localObject5);
        paramString.FLa = Ha((String)localMap.get(".TimelineObject.actionInfo.installedWording"));
        paramString.FLb = Ha((String)localMap.get(".TimelineObject.actionInfo.uninstalledWording"));
        ((TimeLineObject)localObject2).zFf = paramString;
        ((TimeLineObject)localObject2).kbH = GY((String)localMap.get(".TimelineObject.sourceUserName"));
        ((TimeLineObject)localObject2).Fnm = GY((String)localMap.get(".TimelineObject.sourceNickName"));
        ((TimeLineObject)localObject2).HUH = GY((String)localMap.get(".TimelineObject.publicUserName"));
        ((TimeLineObject)localObject2).HUK = GY((String)localMap.get(".TimelineObject.statisticsData"));
        ((TimeLineObject)localObject2).AkC = GY((String)localMap.get(".TimelineObject.canvasInfoXml"));
        ((TimeLineObject)localObject2).hCH = bu.getInt((String)localMap.get(".TimelineObject.contentattr"), 0);
        paramString = new egh();
        paramString.DTD = GY((String)localMap.get(".TimelineObject.websearch.relevant_vid"));
        paramString.DTE = GY((String)localMap.get(".TimelineObject.websearch.relevant_expand"));
        paramString.DTF = GY((String)localMap.get(".TimelineObject.websearch.relevant_pre_searchid"));
        paramString.DTG = GY((String)localMap.get(".TimelineObject.websearch.relevant_shared_openid"));
        paramString.DTH = bu.getLong((String)localMap.get(".TimelineObject.websearch.rec_category"), 0L);
        paramString.qlv = GY((String)localMap.get(".TimelineObject.websearch.shareUrl"));
        paramString.qlw = GY((String)localMap.get(".TimelineObject.websearch.shareTitle"));
        paramString.uly = GY((String)localMap.get(".TimelineObject.websearch.shareDesc"));
        paramString.DTI = GY((String)localMap.get(".TimelineObject.websearch.shareImgUrl"));
        paramString.DTJ = GY((String)localMap.get(".TimelineObject.websearch.shareString"));
        paramString.DTK = GY((String)localMap.get(".TimelineObject.websearch.shareStringUrl"));
        paramString.source = GY((String)localMap.get(".TimelineObject.websearch.source"));
        paramString.dJL = GY((String)localMap.get(".TimelineObject.websearch.sourceUrl"));
        paramString.DTL = GY((String)localMap.get(".TimelineObject.websearch.strPlayCount"));
        paramString.DTM = GY((String)localMap.get(".TimelineObject.websearch.titleUrl"));
        paramString.DTN = GY((String)localMap.get(".TimelineObject.websearch.extReqParams"));
        paramString.DTO = GY((String)localMap.get(".TimelineObject.websearch.tagList"));
        paramString.DTP = bu.getLong((String)localMap.get(".TimelineObject.websearch.channelId"), 0L);
        paramString.DTQ = GY((String)localMap.get(".TimelineObject.websearch.shareTag"));
        ((TimeLineObject)localObject2).zFh = paramString;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(94866);
      return localTimeLineObject;
      localTimeLineObject.HUG.Gtz = paramString.substring(i, j + 11);
      break;
      label4657:
      localObject4 = bx.M(paramString.substring(i, j + 13), "finderFeed");
      if (localObject4 != null) {
        ((b)localObject1).j("", (Map)localObject4);
      }
      localObject1 = ((b)localObject1).ipW;
      break label2924;
      label4695:
      localObject4 = bx.M(paramString.substring(i, j + 14), "finderTopic");
      if (localObject4 != null) {
        ((c)localObject1).j("", (Map)localObject4);
      }
      localObject1 = ((c)localObject1).ipX;
      break label2971;
      label4733:
      paramString = bx.M(paramString.substring(i, j + 17), "mmbrandmpvideo");
      if (paramString != null) {
        ((d)localObject3).ipY = d.k("", paramString);
      }
      paramString = ((d)localObject3).ipY;
      break label3018;
    }
  }
  
  private static eo Ha(String paramString)
  {
    AppMethodBeat.i(94867);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(94867);
      return null;
    }
    paramString = Hb(paramString);
    paramString = bx.M("<root>" + paramString + "</root>", "root");
    if (paramString == null)
    {
      AppMethodBeat.o(94867);
      return null;
    }
    eo localeo = new eo();
    localeo.FOL = GY((String)paramString.get(".root.en"));
    localeo.FOM = GY((String)paramString.get(".root.zh-CN"));
    localeo.FON = GY((String)paramString.get(".root.zh-TW"));
    AppMethodBeat.o(94867);
    return localeo;
  }
  
  private static String Hb(String paramString)
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
    AppMethodBeat.i(218982);
    int i = BackwardSupportUtil.b.h(paramContext, 160.0F);
    int j = BackwardSupportUtil.b.h(paramContext, 200.0F);
    int k = BackwardSupportUtil.b.h(paramContext, 44.0F);
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
      AppMethodBeat.o(218982);
      return paramContext;
      d4 = i;
      d1 = i;
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
        ae.e("MicroMsg.TimeLineHelper", "the context is null");
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
            paramInt2 = Math.min(BackwardSupportUtil.b.h(paramContext, 160.0F), i);
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
          ae.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
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
    if ((paramTimeLineObject != null) && (paramTimeLineObject.HUG != null) && (paramTimeLineObject.HUG.Gtx != null) && (paramTimeLineObject.HUG.Gtx.size() > 0))
    {
      paramTimeLineObject = (bzh)paramTimeLineObject.HUG.Gtx.get(0);
      if ((paramTimeLineObject != null) && (paramTimeLineObject.Hmm != null) && (paramTimeLineObject.Hmm.Hna > 0.0F) && (paramTimeLineObject.Hmm.Hnb > 0.0F))
      {
        j = (int)paramTimeLineObject.Hmm.Hna;
        i = (int)paramTimeLineObject.Hmm.Hnb;
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
  
  public static bzh a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4, String paramString4, bzj parambzj)
  {
    AppMethodBeat.i(94865);
    bzh localbzh = new bzh();
    localbzh.Id = GY(paramString1);
    localbzh.nJA = paramInt1;
    localbzh.Desc = GY(paramString4);
    localbzh.Url = GY(paramString2);
    localbzh.GXH = paramInt2;
    localbzh.Hmj = GY(paramString3);
    localbzh.Hmk = paramInt3;
    localbzh.Hml = paramInt4;
    localbzh.Hmm = parambzj;
    if (paramString2 == null) {}
    for (paramString1 = "".getBytes();; paramString1 = paramString2.getBytes())
    {
      localbzh.Hmx = g.getMessageDigest(paramString1);
      AppMethodBeat.o(94865);
      return localbzh;
    }
  }
  
  public static bzh a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, String paramString4)
  {
    AppMethodBeat.i(94864);
    bzh localbzh = new bzh();
    localbzh.Id = paramString1;
    localbzh.nJA = paramInt1;
    localbzh.Url = paramString2;
    localbzh.Hmj = paramString3;
    localbzh.GXH = paramInt2;
    localbzh.Hmk = paramInt3;
    localbzh.Desc = paramString4;
    paramString1 = new bzj();
    paramString1.Hnb = 0.0F;
    paramString1.Hna = 0.0F;
    paramString1.Hnc = 0.0F;
    localbzh.Hmm = paramString1;
    if (paramString2 == null) {}
    for (paramString1 = "".getBytes();; paramString1 = paramString2.getBytes())
    {
      localbzh.Hmx = g.getMessageDigest(paramString1);
      AppMethodBeat.o(94864);
      return localbzh;
    }
  }
  
  public static TimeLineObject aLJ()
  {
    AppMethodBeat.i(94862);
    TimeLineObject localTimeLineObject = new TimeLineObject();
    Object localObject = new abo();
    localTimeLineObject.HUF = new en();
    localTimeLineObject.HUG = ((abo)localObject);
    localTimeLineObject.Hml = 0;
    localTimeLineObject.CreateTime = 0;
    localTimeLineObject.Id = "";
    localObject = new bwk();
    ((bwk)localObject).Gha = 0.0F;
    ((bwk)localObject).GgZ = 0.0F;
    localTimeLineObject.HUE = ((bwk)localObject);
    localTimeLineObject.AkC = "";
    localTimeLineObject.HUM = new edv();
    AppMethodBeat.o(94862);
    return localTimeLineObject;
  }
  
  public static bzh aLK()
  {
    AppMethodBeat.i(94863);
    bzh localbzh = new bzh();
    localbzh.Desc = "";
    localbzh.Hml = 0;
    AppMethodBeat.o(94863);
    return localbzh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.h
 * JD-Core Version:    0.7.0.1
 */