package com.tencent.mm.modelsns;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.cc.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.protocal.protobuf.bww;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.dfx;
import com.tencent.mm.protocal.protobuf.dkh;
import com.tencent.mm.protocal.protobuf.dy;
import com.tencent.mm.protocal.protobuf.ece;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.protocal.protobuf.eo;
import com.tencent.mm.protocal.protobuf.ep;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.LinkedList;
import java.util.Map;

public final class h
{
  private static float Gv(String paramString)
  {
    AppMethodBeat.i(94861);
    if (paramString == null)
    {
      AppMethodBeat.o(94861);
      return 0.0F;
    }
    float f = bt.getFloat(paramString, 0.0F);
    AppMethodBeat.o(94861);
    return f;
  }
  
  private static String Gw(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static TimeLineObject Gx(String paramString)
  {
    AppMethodBeat.i(94866);
    Map localMap = bw.M(paramString, "TimelineObject");
    TimeLineObject localTimeLineObject = aLm();
    Object localObject1;
    int i;
    Object localObject4;
    Object localObject3;
    label1696:
    label2855:
    int j;
    if (localMap != null)
    {
      localTimeLineObject.Id = Gw((String)localMap.get(".TimelineObject.id"));
      localTimeLineObject.nDo = Gw((String)localMap.get(".TimelineObject.username"));
      localTimeLineObject.GSK = bt.getInt((String)localMap.get(".TimelineObject.private"), 0);
      localTimeLineObject.CreateTime = bt.getInt((String)localMap.get(".TimelineObject.createTime"), 0);
      localTimeLineObject.HAQ = Gw((String)localMap.get(".TimelineObject.contentDesc"));
      localTimeLineObject.HAV = bt.getInt((String)localMap.get(".TimelineObject.contentDescShowType"), 0);
      localTimeLineObject.HAW = bt.getInt((String)localMap.get(".TimelineObject.contentDescScene"), 0);
      localTimeLineObject.zRz = Gw((String)localMap.get(".TimelineObject.statExtStr"));
      localTimeLineObject.HBa = bt.getInt((String)localMap.get(".TimelineObject.sightFolded"), 0);
      localTimeLineObject.ePo = bt.getInt((String)localMap.get(".TimelineObject.showFlag"), 0);
      localObject1 = new bvq();
      ((bvq)localObject1).FOA = Gv((String)localMap.get(".TimelineObject.location.$longitude"));
      ((bvq)localObject1).FOB = Gv((String)localMap.get(".TimelineObject.location.$latitude"));
      ((bvq)localObject1).jde = Gw((String)localMap.get(".TimelineObject.location.$city"));
      ((bvq)localObject1).GPP = bt.getInt((String)localMap.get(".TimelineObject.location.$poiScale"), 0);
      ((bvq)localObject1).Gnu = Gw((String)localMap.get(".TimelineObject.location.$poiClassifyId"));
      ((bvq)localObject1).zSm = bt.getInt((String)localMap.get(".TimelineObject.location.$poiClassifyType"), 0);
      ((bvq)localObject1).zSk = Gw((String)localMap.get(".TimelineObject.location.$poiAddress"));
      ((bvq)localObject1).jDf = Gw((String)localMap.get(".TimelineObject.location.$poiName"));
      ((bvq)localObject1).GPQ = bt.getInt((String)localMap.get(".TimelineObject.location.$poiClickableStatus"), 0);
      ((bvq)localObject1).GPT = Gw((String)localMap.get(".TimelineObject.location.$poiAddressName"));
      ((bvq)localObject1).country = Gw((String)localMap.get(".TimelineObject.location.$country"));
      localTimeLineObject.HAR = ((bvq)localObject1);
      if (localTimeLineObject.HAT == null) {
        localTimeLineObject.HAT = new abf();
      }
      localTimeLineObject.HAT.Desc = Gw((String)localMap.get(".TimelineObject.ContentObject.description"));
      localTimeLineObject.HAT.GaP = bt.getInt((String)localMap.get(".TimelineObject.ContentObject.contentStyle"), 0);
      localTimeLineObject.HAT.GaR = bt.getInt((String)localMap.get(".TimelineObject.ContentObject.contentSubStyle"), 0);
      localTimeLineObject.HAT.Title = Gw((String)localMap.get(".TimelineObject.ContentObject.title"));
      localTimeLineObject.HAT.Url = Gw((String)localMap.get(".TimelineObject.ContentObject.contentUrl"));
      if (localMap.containsKey(".TimelineObject.ContentObject.mmreadershare.itemshowtype"))
      {
        i = bt.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.itemshowtype"), 0);
        if (i != -1)
        {
          localTimeLineObject.HAT.GaT = new bww();
          localTimeLineObject.HAT.GaT.hCZ = i;
          localTimeLineObject.HAT.GaT.hzk = bt.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.ispaysubscribe"), 0);
        }
        if (i == 5)
        {
          localTimeLineObject.HAT.GaT.hzi = bt.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.pubtime"), 0);
          localTimeLineObject.HAT.GaT.hzm = Gw((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.vid"));
          localTimeLineObject.HAT.GaT.coverUrl = Gw((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.cover"));
          localTimeLineObject.HAT.GaT.hzl = bt.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.funcflag"), 0);
          localTimeLineObject.HAT.GaT.duration = bt.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.duration"), 0);
          localTimeLineObject.HAT.GaT.desc = Gw((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.digest"));
          localTimeLineObject.HAT.GaT.hzj = bt.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.nativepage"), 0);
          localTimeLineObject.HAT.GaT.videoWidth = bt.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.width"), 0);
          localTimeLineObject.HAT.GaT.videoHeight = bt.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.height"), 0);
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
        localObject6 = new byp();
        ((byp)localObject6).GTA = 0.0F;
        ((byp)localObject6).GTz = 0.0F;
        ((byp)localObject6).GTB = 0.0F;
        if (str26 != null) {
          ((byp)localObject6).GTz = Gv(str26);
        }
        if (str27 != null) {
          ((byp)localObject6).GTA = Gv(str27);
        }
        if (localObject7 != null) {
          ((byp)localObject6).GTB = Gv((String)localObject7);
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
        localObject7 = new byn();
        ((byn)localObject7).Id = Gw(str25);
        ((byn)localObject7).nEf = bt.getInt(str24, 0);
        ((byn)localObject7).Title = Gw(str23);
        ((byn)localObject7).Desc = Gw(str22);
        ((byn)localObject7).Url = Gw(str26);
        ((byn)localObject7).GEe = bt.getInt(str17, 0);
        ((byn)localObject7).GSI = Gw(str19);
        ((byn)localObject7).GSJ = bt.getInt(str16, 0);
        ((byn)localObject7).GSK = bt.getInt(str20, 0);
        ((byn)localObject7).GSL = ((byp)localObject6);
        ((byn)localObject7).GSM = Gw(str15);
        ((byn)localObject7).GSN = bt.getInt(str14, 0);
        ((byn)localObject7).songAlbumUrl = str13;
        ((byn)localObject7).songLyric = str12;
        ((byn)localObject7).zQh = Gw(str10);
        ((byn)localObject7).subType = bt.getInt(str11, 0);
        ((byn)localObject7).GSP = Gw(str9);
        ((byn)localObject7).GSR = Gw(str8);
        ((byn)localObject7).GSQ = Gw(str7);
        ((byn)localObject7).GTd = Gw(str18);
        ((byn)localObject7).AqM = bt.getInt(str6, 0);
        ((byn)localObject7).GSS = Gw(str5);
        ((byn)localObject7).GST = Gw(str4);
        ((byn)localObject7).GSU = bt.getInt(str3, 0);
        ((byn)localObject7).GSV = bt.getLong(str2, 0L);
        if (((byn)localObject7).Url != null) {
          break label2843;
        }
      }
      label2843:
      for (localObject1 = "".getBytes();; localObject1 = ((byn)localObject7).Url.getBytes())
      {
        ((byn)localObject7).GSW = g.getMessageDigest((byte[])localObject1);
        ((byn)localObject7).GSX = str1;
        ((byn)localObject7).GSY = bt.getInt((String)localObject5, 0);
        ((byn)localObject7).GSZ = ((String)localObject4);
        ((byn)localObject7).GTa = ((String)localObject3);
        ((byn)localObject7).GTb = bt.getInt((String)localObject2, 0);
        ((byn)localObject7).GTc = str27;
        ((byn)localObject7).GTe = Gv(str21);
        localTimeLineObject.HAT.GaQ.add(localObject7);
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
        localObject3 = ((TimeLineObject)localObject2).HAT;
        localObject1 = new b();
        i = paramString.indexOf("<finderFeed>");
        j = paramString.indexOf("</finderFeed>");
        if ((i >= 0) && (j >= 0)) {
          break label4657;
        }
        localObject1 = null;
        label2924:
        ((abf)localObject3).GaU = ((arj)localObject1);
        localObject3 = ((TimeLineObject)localObject2).HAT;
        localObject1 = new c();
        i = paramString.indexOf("<finderTopic>");
        j = paramString.indexOf("</finderTopic>");
        if ((i >= 0) && (j >= 0)) {
          break label4695;
        }
        localObject1 = null;
        label2971:
        ((abf)localObject3).GaV = ((ark)localObject1);
        localObject1 = ((TimeLineObject)localObject2).HAT;
        localObject3 = new d();
        i = paramString.indexOf("<mmbrandmpvideo>");
        j = paramString.indexOf("</mmbrandmpvideo>");
        if ((i >= 0) && (j >= 0)) {
          break label4733;
        }
        paramString = null;
        label3018:
        ((abf)localObject1).GaW = paramString;
        paramString = new en();
        localObject1 = Gw((String)localMap.get(".TimelineObject.appInfo.id"));
        localObject3 = Gw((String)localMap.get(".TimelineObject.appInfo.version"));
        localObject4 = Gw((String)localMap.get(".TimelineObject.appInfo.appName"));
        localObject5 = Gw((String)localMap.get(".TimelineObject.appInfo.installUrl "));
        str1 = Gw((String)localMap.get(".TimelineObject.appInfo.fromUrl "));
        paramString.Id = ((String)localObject1);
        paramString.uiR = ((String)localObject4);
        paramString.Fwk = ((String)localObject5);
        paramString.Fwl = str1;
        paramString.Version = ((String)localObject3);
        paramString.Fwm = bt.getInt((String)localMap.get(".TimelineObject.appInfo.clickable"), 0);
        ((TimeLineObject)localObject2).HAS = paramString;
        paramString = new ece();
        localObject1 = Gw((String)localMap.get(".TimelineObject.weappInfo.appUserName"));
        localObject3 = Gw((String)localMap.get(".TimelineObject.weappInfo.pagePath"));
        localObject4 = Gw((String)localMap.get(".TimelineObject.weappInfo.version"));
        localObject5 = Gw((String)localMap.get(".TimelineObject.weappInfo.debugMode"));
        str1 = Gw((String)localMap.get(".TimelineObject.weappInfo.shareActionId"));
        str2 = Gw((String)localMap.get(".TimelineObject.weappInfo.isGame"));
        str3 = Gw((String)localMap.get(".TimelineObject.weappInfo.messageExtraData"));
        str4 = Gw((String)localMap.get(".TimelineObject.weappInfo.subType"));
        paramString.username = ((String)localObject1);
        paramString.path = ((String)localObject3);
        paramString.version = bt.getInt((String)localObject4, 0);
        paramString.DCU = bt.getInt((String)localObject5, 0);
        paramString.HOB = str1;
        paramString.isGame = bt.getInt(str2, 0);
        paramString.dJW = str3;
        paramString.subType = bt.getInt(str4, 0);
        ((TimeLineObject)localObject2).HAZ = paramString;
        paramString = new dkh();
        localObject1 = Gw((String)localMap.get(".TimelineObject.streamvideo.streamvideotitle"));
        localObject3 = Gw((String)localMap.get(".TimelineObject.streamvideo.streamvideototaltime"));
        localObject4 = Gw((String)localMap.get(".TimelineObject.streamvideo.streamvideourl"));
        localObject5 = Gw((String)localMap.get(".TimelineObject.streamvideo.streamvideoweburl"));
        str1 = Gw((String)localMap.get(".TimelineObject.streamvideo.streamvideowording"));
        str2 = Gw((String)localMap.get(".TimelineObject.streamvideo.streamvideothumburl"));
        str3 = Gw((String)localMap.get(".TimelineObject.streamvideo.streamvideoaduxinfo"));
        str4 = Gw((String)localMap.get(".TimelineObject.streamvideo.streamvideopublishid"));
        paramString.hCg = ((String)localObject1);
        paramString.hCf = bt.aRe((String)localObject3);
        paramString.hCe = ((String)localObject4);
        paramString.hCi = ((String)localObject5);
        paramString.hCh = str1;
        paramString.hCj = str2;
        paramString.hCk = str3;
        paramString.hCl = str4;
        ((TimeLineObject)localObject2).HAY = paramString;
        paramString = new dfx();
        localObject1 = Gw((String)localMap.get(".TimelineObject.redEnvelopesInfo.sendId"));
        localObject3 = Gw((String)localMap.get(".TimelineObject.redEnvelopesInfo.ticket"));
        paramString.vkl = ((String)localObject1);
        paramString.dpf = ((String)localObject3);
        paramString = new ba();
        i = bt.getInt((String)localMap.get(".TimelineObject.actionInfo.scene"), 0);
        localObject1 = Gw((String)localMap.get(".TimelineObject.actionInfo.appid"));
        j = bt.getInt((String)localMap.get(".TimelineObject.actionInfo.type"), 0);
        localObject3 = Gw((String)localMap.get(".TimelineObject.actionInfo.url"));
        localObject4 = Gw((String)localMap.get(".TimelineObject.actionInfo.mediaTagName"));
        localObject5 = Gw((String)localMap.get(".TimelineObject.actionInfo.wordingKey"));
        paramString.Fsv = ((String)localObject1);
        paramString.Scene = i;
        paramString.nEf = j;
        paramString.Url = ((String)localObject3);
        paramString.Fsw = ((String)localObject4);
        paramString.Fsx = ((String)localObject5);
        localObject1 = new ay();
        localObject3 = Gw((String)localMap.get(".TimelineObject.actionInfo.appMsg.appid"));
        localObject4 = Gw((String)localMap.get(".TimelineObject.actionInfo.appMsg.mediaTagName"));
        localObject5 = Gw((String)localMap.get(".TimelineObject.actionInfo.appMsg.messageExt"));
        str1 = Gw((String)localMap.get(".TimelineObject.actionInfo.appMsg.messageAction"));
        ((ay)localObject1).iht = ((String)localObject3);
        ((ay)localObject1).Fss = ((String)localObject4);
        ((ay)localObject1).Fst = ((String)localObject5);
        ((ay)localObject1).Fsu = str1;
        paramString.Fsy = ((ay)localObject1);
        i = bt.getInt((String)localMap.get(".TimelineObject.actionInfo.appActionScene.installedActionScene"), 0);
        j = bt.getInt((String)localMap.get(".TimelineObject.actionInfo.appActionScene.uninstalledActionScene"), 0);
        localObject1 = Gw((String)localMap.get(".TimelineObject.actionInfo.appJumpWordingKey.installedWordingKey"));
        localObject3 = Gw((String)localMap.get(".TimelineObject.actionInfo.appJumpWordingKey.uninstalledWordingKey"));
        paramString.Fsz = Gw((String)localMap.get(".TimelineObject.actionInfo.newWordingKey"));
        localObject4 = new dy();
        ((dy)localObject4).FvX = i;
        ((dy)localObject4).FvY = j;
        localObject5 = new ep();
        ((ep)localObject5).Fwq = ((String)localObject1);
        ((ep)localObject5).Fwr = ((String)localObject3);
        paramString.FsA = ((dy)localObject4);
        paramString.FsB = ((ep)localObject5);
        paramString.FsC = Gy((String)localMap.get(".TimelineObject.actionInfo.installedWording"));
        paramString.FsD = Gy((String)localMap.get(".TimelineObject.actionInfo.uninstalledWording"));
        ((TimeLineObject)localObject2).znQ = paramString;
        ((TimeLineObject)localObject2).jYs = Gw((String)localMap.get(".TimelineObject.sourceUserName"));
        ((TimeLineObject)localObject2).EUR = Gw((String)localMap.get(".TimelineObject.sourceNickName"));
        ((TimeLineObject)localObject2).HAU = Gw((String)localMap.get(".TimelineObject.publicUserName"));
        ((TimeLineObject)localObject2).HAX = Gw((String)localMap.get(".TimelineObject.statisticsData"));
        ((TimeLineObject)localObject2).zTv = Gw((String)localMap.get(".TimelineObject.canvasInfoXml"));
        ((TimeLineObject)localObject2).hzT = bt.getInt((String)localMap.get(".TimelineObject.contentattr"), 0);
        paramString = new eeq();
        paramString.DBG = Gw((String)localMap.get(".TimelineObject.websearch.relevant_vid"));
        paramString.DBH = Gw((String)localMap.get(".TimelineObject.websearch.relevant_expand"));
        paramString.DBI = Gw((String)localMap.get(".TimelineObject.websearch.relevant_pre_searchid"));
        paramString.DBJ = Gw((String)localMap.get(".TimelineObject.websearch.relevant_shared_openid"));
        paramString.DBK = bt.getLong((String)localMap.get(".TimelineObject.websearch.rec_category"), 0L);
        paramString.qeQ = Gw((String)localMap.get(".TimelineObject.websearch.shareUrl"));
        paramString.qeR = Gw((String)localMap.get(".TimelineObject.websearch.shareTitle"));
        paramString.uaw = Gw((String)localMap.get(".TimelineObject.websearch.shareDesc"));
        paramString.DBL = Gw((String)localMap.get(".TimelineObject.websearch.shareImgUrl"));
        paramString.DBM = Gw((String)localMap.get(".TimelineObject.websearch.shareString"));
        paramString.DBN = Gw((String)localMap.get(".TimelineObject.websearch.shareStringUrl"));
        paramString.source = Gw((String)localMap.get(".TimelineObject.websearch.source"));
        paramString.lox = Gw((String)localMap.get(".TimelineObject.websearch.sourceUrl"));
        paramString.DBO = Gw((String)localMap.get(".TimelineObject.websearch.strPlayCount"));
        paramString.DBP = Gw((String)localMap.get(".TimelineObject.websearch.titleUrl"));
        paramString.DBQ = Gw((String)localMap.get(".TimelineObject.websearch.extReqParams"));
        paramString.DBR = Gw((String)localMap.get(".TimelineObject.websearch.tagList"));
        paramString.DBS = bt.getLong((String)localMap.get(".TimelineObject.websearch.channelId"), 0L);
        paramString.DBT = Gw((String)localMap.get(".TimelineObject.websearch.shareTag"));
        ((TimeLineObject)localObject2).znS = paramString;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(94866);
      return localTimeLineObject;
      localTimeLineObject.HAT.GaS = paramString.substring(i, j + 11);
      break;
      label4657:
      localObject4 = bw.M(paramString.substring(i, j + 13), "finderFeed");
      if (localObject4 != null) {
        ((b)localObject1).i("", (Map)localObject4);
      }
      localObject1 = ((b)localObject1).inc;
      break label2924;
      label4695:
      localObject4 = bw.M(paramString.substring(i, j + 14), "finderTopic");
      if (localObject4 != null) {
        ((c)localObject1).i("", (Map)localObject4);
      }
      localObject1 = ((c)localObject1).ind;
      break label2971;
      label4733:
      paramString = bw.M(paramString.substring(i, j + 17), "mmbrandmpvideo");
      if (paramString != null) {
        ((d)localObject3).ine = d.j("", paramString);
      }
      paramString = ((d)localObject3).ine;
      break label3018;
    }
  }
  
  private static eo Gy(String paramString)
  {
    AppMethodBeat.i(94867);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(94867);
      return null;
    }
    paramString = Gz(paramString);
    paramString = bw.M("<root>" + paramString + "</root>", "root");
    if (paramString == null)
    {
      AppMethodBeat.o(94867);
      return null;
    }
    eo localeo = new eo();
    localeo.Fwn = Gw((String)paramString.get(".root.en"));
    localeo.Fwo = Gw((String)paramString.get(".root.zh-CN"));
    localeo.Fwp = Gw((String)paramString.get(".root.zh-TW"));
    AppMethodBeat.o(94867);
    return localeo;
  }
  
  private static String Gz(String paramString)
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
    AppMethodBeat.i(197554);
    int i = BackwardSupportUtil.b.g(paramContext, 160.0F);
    int j = BackwardSupportUtil.b.g(paramContext, 200.0F);
    int k = BackwardSupportUtil.b.g(paramContext, 44.0F);
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
      AppMethodBeat.o(197554);
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
        ad.e("MicroMsg.TimeLineHelper", "the context is null");
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
            paramInt2 = Math.min(BackwardSupportUtil.b.g(paramContext, 160.0F), i);
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
          ad.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
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
    if ((paramTimeLineObject != null) && (paramTimeLineObject.HAT != null) && (paramTimeLineObject.HAT.GaQ != null) && (paramTimeLineObject.HAT.GaQ.size() > 0))
    {
      paramTimeLineObject = (byn)paramTimeLineObject.HAT.GaQ.get(0);
      if ((paramTimeLineObject != null) && (paramTimeLineObject.GSL != null) && (paramTimeLineObject.GSL.GTz > 0.0F) && (paramTimeLineObject.GSL.GTA > 0.0F))
      {
        j = (int)paramTimeLineObject.GSL.GTz;
        i = (int)paramTimeLineObject.GSL.GTA;
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
  
  public static byn a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4, String paramString4, byp parambyp)
  {
    AppMethodBeat.i(94865);
    byn localbyn = new byn();
    localbyn.Id = Gw(paramString1);
    localbyn.nEf = paramInt1;
    localbyn.Desc = Gw(paramString4);
    localbyn.Url = Gw(paramString2);
    localbyn.GEe = paramInt2;
    localbyn.GSI = Gw(paramString3);
    localbyn.GSJ = paramInt3;
    localbyn.GSK = paramInt4;
    localbyn.GSL = parambyp;
    if (paramString2 == null) {}
    for (paramString1 = "".getBytes();; paramString1 = paramString2.getBytes())
    {
      localbyn.GSW = g.getMessageDigest(paramString1);
      AppMethodBeat.o(94865);
      return localbyn;
    }
  }
  
  public static byn a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, String paramString4)
  {
    AppMethodBeat.i(94864);
    byn localbyn = new byn();
    localbyn.Id = paramString1;
    localbyn.nEf = paramInt1;
    localbyn.Url = paramString2;
    localbyn.GSI = paramString3;
    localbyn.GEe = paramInt2;
    localbyn.GSJ = paramInt3;
    localbyn.Desc = paramString4;
    paramString1 = new byp();
    paramString1.GTA = 0.0F;
    paramString1.GTz = 0.0F;
    paramString1.GTB = 0.0F;
    localbyn.GSL = paramString1;
    if (paramString2 == null) {}
    for (paramString1 = "".getBytes();; paramString1 = paramString2.getBytes())
    {
      localbyn.GSW = g.getMessageDigest(paramString1);
      AppMethodBeat.o(94864);
      return localbyn;
    }
  }
  
  public static TimeLineObject aLm()
  {
    AppMethodBeat.i(94862);
    TimeLineObject localTimeLineObject = new TimeLineObject();
    Object localObject = new abf();
    localTimeLineObject.HAS = new en();
    localTimeLineObject.HAT = ((abf)localObject);
    localTimeLineObject.GSK = 0;
    localTimeLineObject.CreateTime = 0;
    localTimeLineObject.Id = "";
    localObject = new bvq();
    ((bvq)localObject).FOB = 0.0F;
    ((bvq)localObject).FOA = 0.0F;
    localTimeLineObject.HAR = ((bvq)localObject);
    localTimeLineObject.zTv = "";
    localTimeLineObject.HAZ = new ece();
    AppMethodBeat.o(94862);
    return localTimeLineObject;
  }
  
  public static byn aLn()
  {
    AppMethodBeat.i(94863);
    byn localbyn = new byn();
    localbyn.Desc = "";
    localbyn.GSK = 0;
    AppMethodBeat.o(94863);
    return localbyn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.h
 * JD-Core Version:    0.7.0.1
 */