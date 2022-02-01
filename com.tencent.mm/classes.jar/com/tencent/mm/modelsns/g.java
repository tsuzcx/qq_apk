package com.tencent.mm.modelsns;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.dak;
import com.tencent.mm.protocal.protobuf.deu;
import com.tencent.mm.protocal.protobuf.dwe;
import com.tencent.mm.protocal.protobuf.dx;
import com.tencent.mm.protocal.protobuf.dyo;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.ek;
import com.tencent.mm.protocal.protobuf.el;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.LinkedList;
import java.util.Map;

public final class g
{
  private static float Dq(String paramString)
  {
    AppMethodBeat.i(94861);
    if (paramString == null)
    {
      AppMethodBeat.o(94861);
      return 0.0F;
    }
    float f = bs.getFloat(paramString, 0.0F);
    AppMethodBeat.o(94861);
    return f;
  }
  
  private static String Dr(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static TimeLineObject Ds(String paramString)
  {
    AppMethodBeat.i(94866);
    Map localMap = bv.L(paramString, "TimelineObject");
    TimeLineObject localTimeLineObject = aIb();
    Object localObject1;
    int i;
    Object localObject4;
    Object localObject3;
    label1696:
    label2855:
    int j;
    if (localMap != null)
    {
      localTimeLineObject.Id = Dr((String)localMap.get(".TimelineObject.id"));
      localTimeLineObject.ncR = Dr((String)localMap.get(".TimelineObject.username"));
      localTimeLineObject.Fjj = bs.getInt((String)localMap.get(".TimelineObject.private"), 0);
      localTimeLineObject.CreateTime = bs.getInt((String)localMap.get(".TimelineObject.createTime"), 0);
      localTimeLineObject.FQl = Dr((String)localMap.get(".TimelineObject.contentDesc"));
      localTimeLineObject.FQq = bs.getInt((String)localMap.get(".TimelineObject.contentDescShowType"), 0);
      localTimeLineObject.FQr = bs.getInt((String)localMap.get(".TimelineObject.contentDescScene"), 0);
      localTimeLineObject.yAj = Dr((String)localMap.get(".TimelineObject.statExtStr"));
      localTimeLineObject.FQv = bs.getInt((String)localMap.get(".TimelineObject.sightFolded"), 0);
      localTimeLineObject.exP = bs.getInt((String)localMap.get(".TimelineObject.showFlag"), 0);
      localObject1 = new brd();
      ((brd)localObject1).Eht = Dq((String)localMap.get(".TimelineObject.location.$longitude"));
      ((brd)localObject1).Ehu = Dq((String)localMap.get(".TimelineObject.location.$latitude"));
      ((brd)localObject1).iJV = Dr((String)localMap.get(".TimelineObject.location.$city"));
      ((brd)localObject1).Fgn = bs.getInt((String)localMap.get(".TimelineObject.location.$poiScale"), 0);
      ((brd)localObject1).EFm = Dr((String)localMap.get(".TimelineObject.location.$poiClassifyId"));
      ((brd)localObject1).yAX = bs.getInt((String)localMap.get(".TimelineObject.location.$poiClassifyType"), 0);
      ((brd)localObject1).yAV = Dr((String)localMap.get(".TimelineObject.location.$poiAddress"));
      ((brd)localObject1).gPy = Dr((String)localMap.get(".TimelineObject.location.$poiName"));
      ((brd)localObject1).Fgo = bs.getInt((String)localMap.get(".TimelineObject.location.$poiClickableStatus"), 0);
      ((brd)localObject1).Fgq = Dr((String)localMap.get(".TimelineObject.location.$poiAddressName"));
      ((brd)localObject1).country = Dr((String)localMap.get(".TimelineObject.location.$country"));
      localTimeLineObject.FQm = ((brd)localObject1);
      if (localTimeLineObject.FQo == null) {
        localTimeLineObject.FQo = new zf();
      }
      localTimeLineObject.FQo.Desc = Dr((String)localMap.get(".TimelineObject.ContentObject.description"));
      localTimeLineObject.FQo.Ety = bs.getInt((String)localMap.get(".TimelineObject.ContentObject.contentStyle"), 0);
      localTimeLineObject.FQo.EtA = bs.getInt((String)localMap.get(".TimelineObject.ContentObject.contentSubStyle"), 0);
      localTimeLineObject.FQo.Title = Dr((String)localMap.get(".TimelineObject.ContentObject.title"));
      localTimeLineObject.FQo.Url = Dr((String)localMap.get(".TimelineObject.ContentObject.contentUrl"));
      if (localMap.containsKey(".TimelineObject.ContentObject.mmreadershare.itemshowtype"))
      {
        i = bs.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.itemshowtype"), 0);
        if (i != -1)
        {
          localTimeLineObject.FQo.EtC = new bsj();
          localTimeLineObject.FQo.EtC.hkQ = i;
          localTimeLineObject.FQo.EtC.hhb = bs.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.ispaysubscribe"), 0);
        }
        if (i == 5)
        {
          localTimeLineObject.FQo.EtC.hgZ = bs.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.pubtime"), 0);
          localTimeLineObject.FQo.EtC.hhd = Dr((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.vid"));
          localTimeLineObject.FQo.EtC.coverUrl = Dr((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.cover"));
          localTimeLineObject.FQo.EtC.hhc = bs.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.funcflag"), 0);
          localTimeLineObject.FQo.EtC.duration = bs.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.duration"), 0);
          localTimeLineObject.FQo.EtC.desc = Dr((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.digest"));
          localTimeLineObject.FQo.EtC.hha = bs.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.nativepage"), 0);
          localTimeLineObject.FQo.EtC.videoWidth = bs.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.width"), 0);
          localTimeLineObject.FQo.EtC.videoHeight = bs.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.height"), 0);
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
        localObject6 = new bub();
        ((bub)localObject6).FjZ = 0.0F;
        ((bub)localObject6).FjY = 0.0F;
        ((bub)localObject6).Fka = 0.0F;
        if (str26 != null) {
          ((bub)localObject6).FjY = Dq(str26);
        }
        if (str27 != null) {
          ((bub)localObject6).FjZ = Dq(str27);
        }
        if (localObject7 != null) {
          ((bub)localObject6).Fka = Dq((String)localObject7);
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
        localObject7 = new btz();
        ((btz)localObject7).Id = Dr(str25);
        ((btz)localObject7).ndI = bs.getInt(str24, 0);
        ((btz)localObject7).Title = Dr(str23);
        ((btz)localObject7).Desc = Dr(str22);
        ((btz)localObject7).Url = Dr(str26);
        ((btz)localObject7).EUH = bs.getInt(str17, 0);
        ((btz)localObject7).Fjh = Dr(str19);
        ((btz)localObject7).Fji = bs.getInt(str16, 0);
        ((btz)localObject7).Fjj = bs.getInt(str20, 0);
        ((btz)localObject7).Fjk = ((bub)localObject6);
        ((btz)localObject7).Fjl = Dr(str15);
        ((btz)localObject7).Fjm = bs.getInt(str14, 0);
        ((btz)localObject7).songAlbumUrl = str13;
        ((btz)localObject7).songLyric = str12;
        ((btz)localObject7).yyV = Dr(str10);
        ((btz)localObject7).subType = bs.getInt(str11, 0);
        ((btz)localObject7).Fjo = Dr(str9);
        ((btz)localObject7).Fjq = Dr(str8);
        ((btz)localObject7).Fjp = Dr(str7);
        ((btz)localObject7).FjC = Dr(str18);
        ((btz)localObject7).yYY = bs.getInt(str6, 0);
        ((btz)localObject7).Fjr = Dr(str5);
        ((btz)localObject7).Fjs = Dr(str4);
        ((btz)localObject7).Fjt = bs.getInt(str3, 0);
        ((btz)localObject7).Fju = bs.getLong(str2, 0L);
        if (((btz)localObject7).Url != null) {
          break label2843;
        }
      }
      label2843:
      for (localObject1 = "".getBytes();; localObject1 = ((btz)localObject7).Url.getBytes())
      {
        ((btz)localObject7).Fjv = com.tencent.mm.b.g.getMessageDigest((byte[])localObject1);
        ((btz)localObject7).Fjw = str1;
        ((btz)localObject7).Fjx = bs.getInt((String)localObject5, 0);
        ((btz)localObject7).Fjy = ((String)localObject4);
        ((btz)localObject7).Fjz = ((String)localObject3);
        ((btz)localObject7).FjA = bs.getInt((String)localObject2, 0);
        ((btz)localObject7).FjB = str27;
        ((btz)localObject7).FjD = Dq(str21);
        localTimeLineObject.FQo.Etz.add(localObject7);
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
        localObject3 = ((TimeLineObject)localObject2).FQo;
        localObject1 = new b();
        i = paramString.indexOf("<finderFeed>");
        j = paramString.indexOf("</finderFeed>");
        if ((i >= 0) && (j >= 0)) {
          break label4610;
        }
        localObject1 = null;
        label2924:
        ((zf)localObject3).EtD = ((anx)localObject1);
        localObject1 = ((TimeLineObject)localObject2).FQo;
        localObject3 = new c();
        i = paramString.indexOf("<finderTopic>");
        j = paramString.indexOf("</finderTopic>");
        if ((i >= 0) && (j >= 0)) {
          break label4648;
        }
        paramString = null;
        label2971:
        ((zf)localObject1).EtE = paramString;
        paramString = new ej();
        localObject1 = Dr((String)localMap.get(".TimelineObject.appInfo.id"));
        localObject3 = Dr((String)localMap.get(".TimelineObject.appInfo.version"));
        localObject4 = Dr((String)localMap.get(".TimelineObject.appInfo.appName"));
        localObject5 = Dr((String)localMap.get(".TimelineObject.appInfo.installUrl "));
        str1 = Dr((String)localMap.get(".TimelineObject.appInfo.fromUrl "));
        paramString.Id = ((String)localObject1);
        paramString.tkL = ((String)localObject4);
        paramString.DQS = ((String)localObject5);
        paramString.DQT = str1;
        paramString.Version = ((String)localObject3);
        paramString.DQU = bs.getInt((String)localMap.get(".TimelineObject.appInfo.clickable"), 0);
        ((TimeLineObject)localObject2).FQn = paramString;
        paramString = new dwe();
        localObject1 = Dr((String)localMap.get(".TimelineObject.weappInfo.appUserName"));
        localObject3 = Dr((String)localMap.get(".TimelineObject.weappInfo.pagePath"));
        localObject4 = Dr((String)localMap.get(".TimelineObject.weappInfo.version"));
        localObject5 = Dr((String)localMap.get(".TimelineObject.weappInfo.debugMode"));
        str1 = Dr((String)localMap.get(".TimelineObject.weappInfo.shareActionId"));
        str2 = Dr((String)localMap.get(".TimelineObject.weappInfo.isGame"));
        str3 = Dr((String)localMap.get(".TimelineObject.weappInfo.messageExtraData"));
        str4 = Dr((String)localMap.get(".TimelineObject.weappInfo.subType"));
        paramString.username = ((String)localObject1);
        paramString.path = ((String)localObject3);
        paramString.version = bs.getInt((String)localObject4, 0);
        paramString.BZZ = bs.getInt((String)localObject5, 0);
        paramString.Gdv = str1;
        paramString.isGame = bs.getInt(str2, 0);
        paramString.dxK = str3;
        paramString.subType = bs.getInt(str4, 0);
        ((TimeLineObject)localObject2).FQu = paramString;
        paramString = new deu();
        localObject1 = Dr((String)localMap.get(".TimelineObject.streamvideo.streamvideotitle"));
        localObject3 = Dr((String)localMap.get(".TimelineObject.streamvideo.streamvideototaltime"));
        localObject4 = Dr((String)localMap.get(".TimelineObject.streamvideo.streamvideourl"));
        localObject5 = Dr((String)localMap.get(".TimelineObject.streamvideo.streamvideoweburl"));
        str1 = Dr((String)localMap.get(".TimelineObject.streamvideo.streamvideowording"));
        str2 = Dr((String)localMap.get(".TimelineObject.streamvideo.streamvideothumburl"));
        str3 = Dr((String)localMap.get(".TimelineObject.streamvideo.streamvideoaduxinfo"));
        str4 = Dr((String)localMap.get(".TimelineObject.streamvideo.streamvideopublishid"));
        paramString.hjX = ((String)localObject1);
        paramString.hjW = bs.aLy((String)localObject3);
        paramString.hjV = ((String)localObject4);
        paramString.hjZ = ((String)localObject5);
        paramString.hjY = str1;
        paramString.hka = str2;
        paramString.hkb = str3;
        paramString.hkc = str4;
        ((TimeLineObject)localObject2).FQt = paramString;
        paramString = new dak();
        localObject1 = Dr((String)localMap.get(".TimelineObject.redEnvelopesInfo.sendId"));
        localObject3 = Dr((String)localMap.get(".TimelineObject.redEnvelopesInfo.ticket"));
        paramString.uhB = ((String)localObject1);
        paramString.ddJ = ((String)localObject3);
        paramString = new ba();
        i = bs.getInt((String)localMap.get(".TimelineObject.actionInfo.scene"), 0);
        localObject1 = Dr((String)localMap.get(".TimelineObject.actionInfo.appid"));
        j = bs.getInt((String)localMap.get(".TimelineObject.actionInfo.type"), 0);
        localObject3 = Dr((String)localMap.get(".TimelineObject.actionInfo.url"));
        localObject4 = Dr((String)localMap.get(".TimelineObject.actionInfo.mediaTagName"));
        localObject5 = Dr((String)localMap.get(".TimelineObject.actionInfo.wordingKey"));
        paramString.DNq = ((String)localObject1);
        paramString.Scene = i;
        paramString.ndI = j;
        paramString.Url = ((String)localObject3);
        paramString.DNr = ((String)localObject4);
        paramString.DNs = ((String)localObject5);
        localObject1 = new ay();
        localObject3 = Dr((String)localMap.get(".TimelineObject.actionInfo.appMsg.appid"));
        localObject4 = Dr((String)localMap.get(".TimelineObject.actionInfo.appMsg.mediaTagName"));
        localObject5 = Dr((String)localMap.get(".TimelineObject.actionInfo.appMsg.messageExt"));
        str1 = Dr((String)localMap.get(".TimelineObject.actionInfo.appMsg.messageAction"));
        ((ay)localObject1).hOf = ((String)localObject3);
        ((ay)localObject1).DNn = ((String)localObject4);
        ((ay)localObject1).DNo = ((String)localObject5);
        ((ay)localObject1).DNp = str1;
        paramString.DNt = ((ay)localObject1);
        i = bs.getInt((String)localMap.get(".TimelineObject.actionInfo.appActionScene.installedActionScene"), 0);
        j = bs.getInt((String)localMap.get(".TimelineObject.actionInfo.appActionScene.uninstalledActionScene"), 0);
        localObject1 = Dr((String)localMap.get(".TimelineObject.actionInfo.appJumpWordingKey.installedWordingKey"));
        localObject3 = Dr((String)localMap.get(".TimelineObject.actionInfo.appJumpWordingKey.uninstalledWordingKey"));
        paramString.DNu = Dr((String)localMap.get(".TimelineObject.actionInfo.newWordingKey"));
        localObject4 = new dx();
        ((dx)localObject4).DQI = i;
        ((dx)localObject4).DQJ = j;
        localObject5 = new el();
        ((el)localObject5).DQY = ((String)localObject1);
        ((el)localObject5).DQZ = ((String)localObject3);
        paramString.DNv = ((dx)localObject4);
        paramString.DNw = ((el)localObject5);
        paramString.DNx = Dt((String)localMap.get(".TimelineObject.actionInfo.installedWording"));
        paramString.DNy = Dt((String)localMap.get(".TimelineObject.actionInfo.uninstalledWording"));
        ((TimeLineObject)localObject2).xXR = paramString;
        ((TimeLineObject)localObject2).jEq = Dr((String)localMap.get(".TimelineObject.sourceUserName"));
        ((TimeLineObject)localObject2).DpN = Dr((String)localMap.get(".TimelineObject.sourceNickName"));
        ((TimeLineObject)localObject2).FQp = Dr((String)localMap.get(".TimelineObject.publicUserName"));
        ((TimeLineObject)localObject2).FQs = Dr((String)localMap.get(".TimelineObject.statisticsData"));
        ((TimeLineObject)localObject2).yCb = Dr((String)localMap.get(".TimelineObject.canvasInfoXml"));
        ((TimeLineObject)localObject2).hhK = bs.getInt((String)localMap.get(".TimelineObject.contentattr"), 0);
        paramString = new dyo();
        paramString.BYK = Dr((String)localMap.get(".TimelineObject.websearch.relevant_vid"));
        paramString.BYL = Dr((String)localMap.get(".TimelineObject.websearch.relevant_expand"));
        paramString.BYM = Dr((String)localMap.get(".TimelineObject.websearch.relevant_pre_searchid"));
        paramString.BYN = Dr((String)localMap.get(".TimelineObject.websearch.relevant_shared_openid"));
        paramString.BYO = bs.getLong((String)localMap.get(".TimelineObject.websearch.rec_category"), 0L);
        paramString.pBl = Dr((String)localMap.get(".TimelineObject.websearch.shareUrl"));
        paramString.pBm = Dr((String)localMap.get(".TimelineObject.websearch.shareTitle"));
        paramString.tcG = Dr((String)localMap.get(".TimelineObject.websearch.shareDesc"));
        paramString.BYP = Dr((String)localMap.get(".TimelineObject.websearch.shareImgUrl"));
        paramString.BYQ = Dr((String)localMap.get(".TimelineObject.websearch.shareString"));
        paramString.BYR = Dr((String)localMap.get(".TimelineObject.websearch.shareStringUrl"));
        paramString.source = Dr((String)localMap.get(".TimelineObject.websearch.source"));
        paramString.kRU = Dr((String)localMap.get(".TimelineObject.websearch.sourceUrl"));
        paramString.BYS = Dr((String)localMap.get(".TimelineObject.websearch.strPlayCount"));
        paramString.BYT = Dr((String)localMap.get(".TimelineObject.websearch.titleUrl"));
        paramString.BYU = Dr((String)localMap.get(".TimelineObject.websearch.extReqParams"));
        paramString.BYV = Dr((String)localMap.get(".TimelineObject.websearch.tagList"));
        paramString.BYW = bs.getLong((String)localMap.get(".TimelineObject.websearch.channelId"), 0L);
        paramString.BYX = Dr((String)localMap.get(".TimelineObject.websearch.shareTag"));
        ((TimeLineObject)localObject2).xXT = paramString;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(94866);
      return localTimeLineObject;
      localTimeLineObject.FQo.EtB = paramString.substring(i, j + 11);
      break;
      label4610:
      localObject4 = bv.L(paramString.substring(i, j + 13), "finderFeed");
      if (localObject4 != null) {
        ((b)localObject1).h("", (Map)localObject4);
      }
      localObject1 = ((b)localObject1).hTI;
      break label2924;
      label4648:
      paramString = bv.L(paramString.substring(i, j + 14), "finderTopic");
      if (paramString != null) {
        ((c)localObject3).h("", paramString);
      }
      paramString = ((c)localObject3).hTJ;
      break label2971;
    }
  }
  
  private static ek Dt(String paramString)
  {
    AppMethodBeat.i(94867);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(94867);
      return null;
    }
    paramString = Du(paramString);
    paramString = bv.L("<root>" + paramString + "</root>", "root");
    if (paramString == null)
    {
      AppMethodBeat.o(94867);
      return null;
    }
    ek localek = new ek();
    localek.DQV = Dr((String)paramString.get(".root.en"));
    localek.DQW = Dr((String)paramString.get(".root.zh-CN"));
    localek.DQX = Dr((String)paramString.get(".root.zh-TW"));
    AppMethodBeat.o(94867);
    return localek;
  }
  
  private static String Du(String paramString)
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
        ac.e("MicroMsg.TimeLineHelper", "the context is null");
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
          ac.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
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
    if ((paramTimeLineObject != null) && (paramTimeLineObject.FQo != null) && (paramTimeLineObject.FQo.Etz != null) && (paramTimeLineObject.FQo.Etz.size() > 0))
    {
      paramTimeLineObject = (btz)paramTimeLineObject.FQo.Etz.get(0);
      if ((paramTimeLineObject != null) && (paramTimeLineObject.Fjk != null) && (paramTimeLineObject.Fjk.FjY > 0.0F) && (paramTimeLineObject.Fjk.FjZ > 0.0F))
      {
        j = (int)paramTimeLineObject.Fjk.FjY;
        i = (int)paramTimeLineObject.Fjk.FjZ;
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
  
  public static btz a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4, String paramString4, bub parambub)
  {
    AppMethodBeat.i(94865);
    btz localbtz = new btz();
    localbtz.Id = Dr(paramString1);
    localbtz.ndI = paramInt1;
    localbtz.Desc = Dr(paramString4);
    localbtz.Url = Dr(paramString2);
    localbtz.EUH = paramInt2;
    localbtz.Fjh = Dr(paramString3);
    localbtz.Fji = paramInt3;
    localbtz.Fjj = paramInt4;
    localbtz.Fjk = parambub;
    if (paramString2 == null) {}
    for (paramString1 = "".getBytes();; paramString1 = paramString2.getBytes())
    {
      localbtz.Fjv = com.tencent.mm.b.g.getMessageDigest(paramString1);
      AppMethodBeat.o(94865);
      return localbtz;
    }
  }
  
  public static btz a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, String paramString4)
  {
    AppMethodBeat.i(94864);
    btz localbtz = new btz();
    localbtz.Id = paramString1;
    localbtz.ndI = paramInt1;
    localbtz.Url = paramString2;
    localbtz.Fjh = paramString3;
    localbtz.EUH = paramInt2;
    localbtz.Fji = paramInt3;
    localbtz.Desc = paramString4;
    paramString1 = new bub();
    paramString1.FjZ = 0.0F;
    paramString1.FjY = 0.0F;
    paramString1.Fka = 0.0F;
    localbtz.Fjk = paramString1;
    if (paramString2 == null) {}
    for (paramString1 = "".getBytes();; paramString1 = paramString2.getBytes())
    {
      localbtz.Fjv = com.tencent.mm.b.g.getMessageDigest(paramString1);
      AppMethodBeat.o(94864);
      return localbtz;
    }
  }
  
  public static TimeLineObject aIb()
  {
    AppMethodBeat.i(94862);
    TimeLineObject localTimeLineObject = new TimeLineObject();
    Object localObject = new zf();
    localTimeLineObject.FQn = new ej();
    localTimeLineObject.FQo = ((zf)localObject);
    localTimeLineObject.Fjj = 0;
    localTimeLineObject.CreateTime = 0;
    localTimeLineObject.Id = "";
    localObject = new brd();
    ((brd)localObject).Ehu = 0.0F;
    ((brd)localObject).Eht = 0.0F;
    localTimeLineObject.FQm = ((brd)localObject);
    localTimeLineObject.yCb = "";
    localTimeLineObject.FQu = new dwe();
    AppMethodBeat.o(94862);
    return localTimeLineObject;
  }
  
  public static btz aIc()
  {
    AppMethodBeat.i(94863);
    btz localbtz = new btz();
    localbtz.Desc = "";
    localbtz.Fjj = 0;
    AppMethodBeat.o(94863);
    return localbtz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.g
 * JD-Core Version:    0.7.0.1
 */