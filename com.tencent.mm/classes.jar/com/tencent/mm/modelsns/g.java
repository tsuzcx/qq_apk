package com.tencent.mm.modelsns;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.bnt;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.cuy;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.dqn;
import com.tencent.mm.protocal.protobuf.dsx;
import com.tencent.mm.protocal.protobuf.dv;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.ei;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.LinkedList;
import java.util.Map;

public final class g
{
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
            break label247;
          }
        }
        for (;;)
        {
          ad.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
          paramContext = Pair.create(Integer.valueOf(j), Integer.valueOf(i));
          AppMethodBeat.o(94870);
          return paramContext;
          label247:
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
    if ((paramTimeLineObject != null) && (paramTimeLineObject.Etm != null) && (paramTimeLineObject.Etm.DaC != null) && (paramTimeLineObject.Etm.DaC.size() > 0))
    {
      paramTimeLineObject = (bpi)paramTimeLineObject.Etm.DaC.get(0);
      if ((paramTimeLineObject != null) && (paramTimeLineObject.DMT != null) && (paramTimeLineObject.DMT.DNH > 0.0F) && (paramTimeLineObject.DMT.DNI > 0.0F))
      {
        j = (int)paramTimeLineObject.DMT.DNH;
        i = (int)paramTimeLineObject.DMT.DNI;
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
  
  public static bpi a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4, String paramString4, bpk parambpk)
  {
    AppMethodBeat.i(94865);
    bpi localbpi = new bpi();
    localbpi.Id = zm(paramString1);
    localbpi.mBH = paramInt1;
    localbpi.Desc = zm(paramString4);
    localbpi.Url = zm(paramString2);
    localbpi.Dzl = paramInt2;
    localbpi.DMQ = zm(paramString3);
    localbpi.DMR = paramInt3;
    localbpi.DMS = paramInt4;
    localbpi.DMT = parambpk;
    if (paramString2 == null) {}
    for (paramString1 = "".getBytes();; paramString1 = paramString2.getBytes())
    {
      localbpi.DNe = com.tencent.mm.b.g.getMessageDigest(paramString1);
      AppMethodBeat.o(94865);
      return localbpi;
    }
  }
  
  public static bpi a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, String paramString4)
  {
    AppMethodBeat.i(94864);
    bpi localbpi = new bpi();
    localbpi.Id = paramString1;
    localbpi.mBH = paramInt1;
    localbpi.Url = paramString2;
    localbpi.DMQ = paramString3;
    localbpi.Dzl = paramInt2;
    localbpi.DMR = paramInt3;
    localbpi.Desc = paramString4;
    paramString1 = new bpk();
    paramString1.DNI = 0.0F;
    paramString1.DNH = 0.0F;
    paramString1.DNJ = 0.0F;
    localbpi.DMT = paramString1;
    if (paramString2 == null) {}
    for (paramString1 = "".getBytes();; paramString1 = paramString2.getBytes())
    {
      localbpi.DNe = com.tencent.mm.b.g.getMessageDigest(paramString1);
      AppMethodBeat.o(94864);
      return localbpi;
    }
  }
  
  public static TimeLineObject aBl()
  {
    AppMethodBeat.i(94862);
    TimeLineObject localTimeLineObject = new TimeLineObject();
    Object localObject = new yk();
    localTimeLineObject.Etl = new eh();
    localTimeLineObject.Etm = ((yk)localObject);
    localTimeLineObject.DMS = 0;
    localTimeLineObject.CreateTime = 0;
    localTimeLineObject.Id = "";
    localObject = new bmn();
    ((bmn)localObject).COJ = 0.0F;
    ((bmn)localObject).COI = 0.0F;
    localTimeLineObject.Etk = ((bmn)localObject);
    localTimeLineObject.xpl = "";
    localTimeLineObject.Ets = new dqn();
    AppMethodBeat.o(94862);
    return localTimeLineObject;
  }
  
  public static bpi aBm()
  {
    AppMethodBeat.i(94863);
    bpi localbpi = new bpi();
    localbpi.Desc = "";
    localbpi.DMS = 0;
    AppMethodBeat.o(94863);
    return localbpi;
  }
  
  private static float zl(String paramString)
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
  
  private static String zm(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static TimeLineObject zn(String paramString)
  {
    AppMethodBeat.i(94866);
    Map localMap = bw.K(paramString, "TimelineObject");
    TimeLineObject localTimeLineObject = aBl();
    Object localObject1;
    int i;
    Object localObject4;
    Object localObject3;
    label1730:
    label2889:
    int j;
    if (localMap != null)
    {
      localTimeLineObject.Id = zm((String)localMap.get(".TimelineObject.id"));
      localTimeLineObject.mAQ = zm((String)localMap.get(".TimelineObject.username"));
      localTimeLineObject.DMS = bt.getInt((String)localMap.get(".TimelineObject.private"), 0);
      localTimeLineObject.CreateTime = bt.getInt((String)localMap.get(".TimelineObject.createTime"), 0);
      localTimeLineObject.Etj = zm((String)localMap.get(".TimelineObject.contentDesc"));
      localTimeLineObject.Eto = bt.getInt((String)localMap.get(".TimelineObject.contentDescShowType"), 0);
      localTimeLineObject.Etp = bt.getInt((String)localMap.get(".TimelineObject.contentDescScene"), 0);
      localTimeLineObject.xns = zm((String)localMap.get(".TimelineObject.statExtStr"));
      localTimeLineObject.Ett = bt.getInt((String)localMap.get(".TimelineObject.sightFolded"), 0);
      localTimeLineObject.evt = bt.getInt((String)localMap.get(".TimelineObject.showFlag"), 0);
      localObject1 = new bmn();
      ((bmn)localObject1).COI = zl((String)localMap.get(".TimelineObject.location.$longitude"));
      ((bmn)localObject1).COJ = zl((String)localMap.get(".TimelineObject.location.$latitude"));
      ((bmn)localObject1).ijO = zm((String)localMap.get(".TimelineObject.location.$city"));
      ((bmn)localObject1).DJY = bt.getInt((String)localMap.get(".TimelineObject.location.$poiScale"), 0);
      ((bmn)localObject1).DlE = zm((String)localMap.get(".TimelineObject.location.$poiClassifyId"));
      ((bmn)localObject1).xog = bt.getInt((String)localMap.get(".TimelineObject.location.$poiClassifyType"), 0);
      ((bmn)localObject1).xoe = zm((String)localMap.get(".TimelineObject.location.$poiAddress"));
      ((bmn)localObject1).goQ = zm((String)localMap.get(".TimelineObject.location.$poiName"));
      ((bmn)localObject1).DJZ = bt.getInt((String)localMap.get(".TimelineObject.location.$poiClickableStatus"), 0);
      ((bmn)localObject1).DKb = zm((String)localMap.get(".TimelineObject.location.$poiAddressName"));
      ((bmn)localObject1).country = zm((String)localMap.get(".TimelineObject.location.$country"));
      localTimeLineObject.Etk = ((bmn)localObject1);
      if (localTimeLineObject.Etm == null) {
        localTimeLineObject.Etm = new yk();
      }
      localTimeLineObject.Etm.Desc = zm((String)localMap.get(".TimelineObject.ContentObject.description"));
      localTimeLineObject.Etm.DaB = bt.getInt((String)localMap.get(".TimelineObject.ContentObject.contentStyle"), 0);
      localTimeLineObject.Etm.DaD = bt.getInt((String)localMap.get(".TimelineObject.ContentObject.contentSubStyle"), 0);
      localTimeLineObject.Etm.Title = zm((String)localMap.get(".TimelineObject.ContentObject.title"));
      localTimeLineObject.Etm.Url = zm((String)localMap.get(".TimelineObject.ContentObject.contentUrl"));
      if (localMap.containsKey(".TimelineObject.ContentObject.mmreadershare.itemshowtype"))
      {
        i = bt.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.itemshowtype"), 0);
        if (i != -1)
        {
          localTimeLineObject.Etm.DaF = new bnt();
          localTimeLineObject.Etm.DaF.gKq = i;
          localTimeLineObject.Etm.DaF.gGA = bt.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.ispaysubscribe"), 0);
        }
        if (i == 5)
        {
          localTimeLineObject.Etm.DaF.gGy = bt.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.pubtime"), 0);
          localTimeLineObject.Etm.DaF.gGC = zm((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.vid"));
          localTimeLineObject.Etm.DaF.coverUrl = zm((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.cover"));
          localTimeLineObject.Etm.DaF.gGB = bt.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.funcflag"), 0);
          localTimeLineObject.Etm.DaF.duration = bt.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.duration"), 0);
          localTimeLineObject.Etm.DaF.desc = zm((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.digest"));
          localTimeLineObject.Etm.DaF.gGz = bt.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.nativepage"), 0);
          localTimeLineObject.Etm.DaF.videoWidth = bt.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.width"), 0);
          localTimeLineObject.Etm.DaF.videoHeight = bt.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.height"), 0);
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
        localObject6 = new bpk();
        ((bpk)localObject6).DNI = 0.0F;
        ((bpk)localObject6).DNH = 0.0F;
        ((bpk)localObject6).DNJ = 0.0F;
        if (str26 != null) {
          ((bpk)localObject6).DNH = zl(str26);
        }
        if (str27 != null) {
          ((bpk)localObject6).DNI = zl(str27);
        }
        if (localObject7 != null) {
          ((bpk)localObject6).DNJ = zl((String)localObject7);
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
          break label2889;
        }
        localObject7 = new bpi();
        ((bpi)localObject7).Id = zm(str25);
        ((bpi)localObject7).mBH = bt.getInt(str24, 0);
        ((bpi)localObject7).Title = zm(str23);
        ((bpi)localObject7).Desc = zm(str22);
        ((bpi)localObject7).Url = zm(str26);
        ((bpi)localObject7).Dzl = bt.getInt(str17, 0);
        ((bpi)localObject7).DMQ = zm(str19);
        ((bpi)localObject7).DMR = bt.getInt(str16, 0);
        ((bpi)localObject7).DMS = bt.getInt(str20, 0);
        ((bpi)localObject7).DMT = ((bpk)localObject6);
        ((bpi)localObject7).DMU = zm(str15);
        ((bpi)localObject7).DMV = bt.getInt(str14, 0);
        ((bpi)localObject7).songAlbumUrl = str13;
        ((bpi)localObject7).songLyric = str12;
        ((bpi)localObject7).xmd = zm(str10);
        ((bpi)localObject7).subType = bt.getInt(str11, 0);
        ((bpi)localObject7).DMX = zm(str9);
        ((bpi)localObject7).DMZ = zm(str8);
        ((bpi)localObject7).DMY = zm(str7);
        ((bpi)localObject7).DNl = zm(str18);
        ((bpi)localObject7).xMj = bt.getInt(str6, 0);
        ((bpi)localObject7).DNa = zm(str5);
        ((bpi)localObject7).DNb = zm(str4);
        ((bpi)localObject7).DNc = bt.getInt(str3, 0);
        ((bpi)localObject7).DNd = bt.getLong(str2, 0L);
        if (((bpi)localObject7).Url != null) {
          break label2877;
        }
      }
      label2877:
      for (localObject1 = "".getBytes();; localObject1 = ((bpi)localObject7).Url.getBytes())
      {
        ((bpi)localObject7).DNe = com.tencent.mm.b.g.getMessageDigest((byte[])localObject1);
        ((bpi)localObject7).DNf = str1;
        ((bpi)localObject7).DNg = bt.getInt((String)localObject5, 0);
        ((bpi)localObject7).DNh = ((String)localObject4);
        ((bpi)localObject7).DNi = ((String)localObject3);
        ((bpi)localObject7).DNj = bt.getInt((String)localObject2, 0);
        ((bpi)localObject7).DNk = str27;
        ((bpi)localObject7).DNm = zl(str21);
        localTimeLineObject.Etm.DaC.add(localObject7);
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
        break label1730;
      }
      i = paramString.indexOf("<noteinfo>");
      j = paramString.indexOf("</noteinfo>");
      if ((i < 0) || (j < 0))
      {
        localObject2 = localTimeLineObject;
        localObject3 = ((TimeLineObject)localObject2).Etm;
        localObject1 = new b();
        i = paramString.indexOf("<finderFeed>");
        j = paramString.indexOf("</finderFeed>");
        if ((i >= 0) && (j >= 0)) {
          break label4644;
        }
        localObject1 = null;
        label2958:
        ((yk)localObject3).DaG = ((ald)localObject1);
        localObject1 = ((TimeLineObject)localObject2).Etm;
        localObject3 = new c();
        i = paramString.indexOf("<finderTopic>");
        j = paramString.indexOf("</finderTopic>");
        if ((i >= 0) && (j >= 0)) {
          break label4682;
        }
        paramString = null;
        label3005:
        ((yk)localObject1).DaH = paramString;
        paramString = new eh();
        localObject1 = zm((String)localMap.get(".TimelineObject.appInfo.id"));
        localObject3 = zm((String)localMap.get(".TimelineObject.appInfo.version"));
        localObject4 = zm((String)localMap.get(".TimelineObject.appInfo.appName"));
        localObject5 = zm((String)localMap.get(".TimelineObject.appInfo.installUrl "));
        str1 = zm((String)localMap.get(".TimelineObject.appInfo.fromUrl "));
        paramString.Id = ((String)localObject1);
        paramString.scR = ((String)localObject4);
        paramString.Cyw = ((String)localObject5);
        paramString.Cyx = str1;
        paramString.Version = ((String)localObject3);
        paramString.Cyy = bt.getInt((String)localMap.get(".TimelineObject.appInfo.clickable"), 0);
        ((TimeLineObject)localObject2).Etl = paramString;
        paramString = new dqn();
        localObject1 = zm((String)localMap.get(".TimelineObject.weappInfo.appUserName"));
        localObject3 = zm((String)localMap.get(".TimelineObject.weappInfo.pagePath"));
        localObject4 = zm((String)localMap.get(".TimelineObject.weappInfo.version"));
        localObject5 = zm((String)localMap.get(".TimelineObject.weappInfo.debugMode"));
        str1 = zm((String)localMap.get(".TimelineObject.weappInfo.shareActionId"));
        str2 = zm((String)localMap.get(".TimelineObject.weappInfo.isGame"));
        str3 = zm((String)localMap.get(".TimelineObject.weappInfo.messageExtraData"));
        str4 = zm((String)localMap.get(".TimelineObject.weappInfo.subType"));
        paramString.username = ((String)localObject1);
        paramString.path = ((String)localObject3);
        paramString.version = bt.getInt((String)localObject4, 0);
        paramString.AHI = bt.getInt((String)localObject5, 0);
        paramString.EGj = str1;
        paramString.isGame = bt.getInt(str2, 0);
        paramString.dzY = str3;
        paramString.subType = bt.getInt(str4, 0);
        ((TimeLineObject)localObject2).Ets = paramString;
        paramString = new czi();
        localObject1 = zm((String)localMap.get(".TimelineObject.streamvideo.streamvideotitle"));
        localObject3 = zm((String)localMap.get(".TimelineObject.streamvideo.streamvideototaltime"));
        localObject4 = zm((String)localMap.get(".TimelineObject.streamvideo.streamvideourl"));
        localObject5 = zm((String)localMap.get(".TimelineObject.streamvideo.streamvideoweburl"));
        str1 = zm((String)localMap.get(".TimelineObject.streamvideo.streamvideowording"));
        str2 = zm((String)localMap.get(".TimelineObject.streamvideo.streamvideothumburl"));
        str3 = zm((String)localMap.get(".TimelineObject.streamvideo.streamvideoaduxinfo"));
        str4 = zm((String)localMap.get(".TimelineObject.streamvideo.streamvideopublishid"));
        paramString.gJx = ((String)localObject1);
        paramString.gJw = bt.aGh((String)localObject3);
        paramString.gJv = ((String)localObject4);
        paramString.gJz = ((String)localObject5);
        paramString.gJy = str1;
        paramString.gJA = str2;
        paramString.gJB = str3;
        paramString.gJC = str4;
        ((TimeLineObject)localObject2).Etr = paramString;
        paramString = new cuy();
        localObject1 = zm((String)localMap.get(".TimelineObject.redEnvelopesInfo.sendId"));
        localObject3 = zm((String)localMap.get(".TimelineObject.redEnvelopesInfo.ticket"));
        paramString.sZn = ((String)localObject1);
        paramString.dgo = ((String)localObject3);
        paramString = new ay();
        i = bt.getInt((String)localMap.get(".TimelineObject.actionInfo.scene"), 0);
        localObject1 = zm((String)localMap.get(".TimelineObject.actionInfo.appid"));
        j = bt.getInt((String)localMap.get(".TimelineObject.actionInfo.type"), 0);
        localObject3 = zm((String)localMap.get(".TimelineObject.actionInfo.url"));
        localObject4 = zm((String)localMap.get(".TimelineObject.actionInfo.mediaTagName"));
        localObject5 = zm((String)localMap.get(".TimelineObject.actionInfo.wordingKey"));
        paramString.CuV = ((String)localObject1);
        paramString.Scene = i;
        paramString.mBH = j;
        paramString.Url = ((String)localObject3);
        paramString.CuW = ((String)localObject4);
        paramString.CuX = ((String)localObject5);
        localObject1 = new aw();
        localObject3 = zm((String)localMap.get(".TimelineObject.actionInfo.appMsg.appid"));
        localObject4 = zm((String)localMap.get(".TimelineObject.actionInfo.appMsg.mediaTagName"));
        localObject5 = zm((String)localMap.get(".TimelineObject.actionInfo.appMsg.messageExt"));
        str1 = zm((String)localMap.get(".TimelineObject.actionInfo.appMsg.messageAction"));
        ((aw)localObject1).hnC = ((String)localObject3);
        ((aw)localObject1).CuS = ((String)localObject4);
        ((aw)localObject1).CuT = ((String)localObject5);
        ((aw)localObject1).CuU = str1;
        paramString.CuY = ((aw)localObject1);
        i = bt.getInt((String)localMap.get(".TimelineObject.actionInfo.appActionScene.installedActionScene"), 0);
        j = bt.getInt((String)localMap.get(".TimelineObject.actionInfo.appActionScene.uninstalledActionScene"), 0);
        localObject1 = zm((String)localMap.get(".TimelineObject.actionInfo.appJumpWordingKey.installedWordingKey"));
        localObject3 = zm((String)localMap.get(".TimelineObject.actionInfo.appJumpWordingKey.uninstalledWordingKey"));
        paramString.CuZ = zm((String)localMap.get(".TimelineObject.actionInfo.newWordingKey"));
        localObject4 = new dv();
        ((dv)localObject4).Cym = i;
        ((dv)localObject4).Cyn = j;
        localObject5 = new ej();
        ((ej)localObject5).CyC = ((String)localObject1);
        ((ej)localObject5).CyD = ((String)localObject3);
        paramString.Cva = ((dv)localObject4);
        paramString.Cvb = ((ej)localObject5);
        paramString.Cvc = zo((String)localMap.get(".TimelineObject.actionInfo.installedWording"));
        paramString.Cvd = zo((String)localMap.get(".TimelineObject.actionInfo.uninstalledWording"));
        ((TimeLineObject)localObject2).wLl = paramString;
        ((TimeLineObject)localObject2).jec = zm((String)localMap.get(".TimelineObject.sourceUserName"));
        ((TimeLineObject)localObject2).BXw = zm((String)localMap.get(".TimelineObject.sourceNickName"));
        ((TimeLineObject)localObject2).Etn = zm((String)localMap.get(".TimelineObject.publicUserName"));
        ((TimeLineObject)localObject2).Etq = zm((String)localMap.get(".TimelineObject.statisticsData"));
        ((TimeLineObject)localObject2).xpl = zm((String)localMap.get(".TimelineObject.canvasInfoXml"));
        ((TimeLineObject)localObject2).gHj = bt.getInt((String)localMap.get(".TimelineObject.contentattr"), 0);
        paramString = new dsx();
        paramString.AGs = zm((String)localMap.get(".TimelineObject.websearch.relevant_vid"));
        paramString.AGt = zm((String)localMap.get(".TimelineObject.websearch.relevant_expand"));
        paramString.AGu = zm((String)localMap.get(".TimelineObject.websearch.relevant_pre_searchid"));
        paramString.AGv = zm((String)localMap.get(".TimelineObject.websearch.relevant_shared_openid"));
        paramString.AGw = bt.getLong((String)localMap.get(".TimelineObject.websearch.rec_category"), 0L);
        paramString.oYa = zm((String)localMap.get(".TimelineObject.websearch.shareUrl"));
        paramString.oYb = zm((String)localMap.get(".TimelineObject.websearch.shareTitle"));
        paramString.rUO = zm((String)localMap.get(".TimelineObject.websearch.shareDesc"));
        paramString.AGx = zm((String)localMap.get(".TimelineObject.websearch.shareImgUrl"));
        paramString.AGy = zm((String)localMap.get(".TimelineObject.websearch.shareString"));
        paramString.AGz = zm((String)localMap.get(".TimelineObject.websearch.shareStringUrl"));
        paramString.source = zm((String)localMap.get(".TimelineObject.websearch.source"));
        paramString.kqB = zm((String)localMap.get(".TimelineObject.websearch.sourceUrl"));
        paramString.AGA = zm((String)localMap.get(".TimelineObject.websearch.strPlayCount"));
        paramString.AGB = zm((String)localMap.get(".TimelineObject.websearch.titleUrl"));
        paramString.AGC = zm((String)localMap.get(".TimelineObject.websearch.extReqParams"));
        paramString.AGD = zm((String)localMap.get(".TimelineObject.websearch.tagList"));
        paramString.AGE = bt.getLong((String)localMap.get(".TimelineObject.websearch.channelId"), 0L);
        paramString.AGF = zm((String)localMap.get(".TimelineObject.websearch.shareTag"));
        ((TimeLineObject)localObject2).wLn = paramString;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(94866);
      return localTimeLineObject;
      localTimeLineObject.Etm.DaE = paramString.substring(i, j + 11);
      break;
      label4644:
      localObject4 = bw.K(paramString.substring(i, j + 13), "finderFeed");
      if (localObject4 != null) {
        ((b)localObject1).h("", (Map)localObject4);
      }
      localObject1 = ((b)localObject1).htg;
      break label2958;
      label4682:
      paramString = bw.K(paramString.substring(i, j + 14), "finderTopic");
      if (paramString != null) {
        ((c)localObject3).h("", paramString);
      }
      paramString = ((c)localObject3).hth;
      break label3005;
    }
  }
  
  private static ei zo(String paramString)
  {
    AppMethodBeat.i(94867);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(94867);
      return null;
    }
    paramString = zp(paramString);
    paramString = bw.K("<root>" + paramString + "</root>", "root");
    if (paramString == null)
    {
      AppMethodBeat.o(94867);
      return null;
    }
    ei localei = new ei();
    localei.Cyz = zm((String)paramString.get(".root.en"));
    localei.CyA = zm((String)paramString.get(".root.zh-CN"));
    localei.CyB = zm((String)paramString.get(".root.zh-TW"));
    AppMethodBeat.o(94867);
    return localei;
  }
  
  private static String zp(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.g
 * JD-Core Version:    0.7.0.1
 */