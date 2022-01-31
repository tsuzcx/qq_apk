package com.tencent.mm.modelsns;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.cb.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.at;
import com.tencent.mm.protocal.protobuf.av;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.bbs;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.ceb;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.dv;
import com.tencent.mm.protocal.protobuf.dw;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.LinkedList;
import java.util.Map;

public final class e
{
  public static Pair<Integer, Integer> a(int paramInt1, int paramInt2, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(35582);
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
        ab.e("MicroMsg.TimeLineHelper", "the context is null");
        paramContext = Pair.create(Integer.valueOf(paramInt1), Integer.valueOf(k));
        AppMethodBeat.o(35582);
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
            paramInt2 = Math.min(BackwardSupportUtil.b.b(paramContext, 160.0F), i);
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
          ab.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
          paramContext = Pair.create(Integer.valueOf(j), Integer.valueOf(i));
          AppMethodBeat.o(35582);
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
    AppMethodBeat.i(35581);
    int j;
    int i;
    if ((paramTimeLineObject != null) && (paramTimeLineObject.xTS != null) && (paramTimeLineObject.xTS.wOa != null) && (paramTimeLineObject.xTS.wOa.size() > 0))
    {
      paramTimeLineObject = (bcs)paramTimeLineObject.xTS.wOa.get(0);
      if ((paramTimeLineObject != null) && (paramTimeLineObject.xrV != null) && (paramTimeLineObject.xrV.xsH > 0.0F) && (paramTimeLineObject.xrV.xsI > 0.0F))
      {
        j = (int)paramTimeLineObject.xrV.xsH;
        i = (int)paramTimeLineObject.xrV.xsI;
      }
    }
    for (;;)
    {
      paramTimeLineObject = a(j, i, paramContext, paramBoolean);
      AppMethodBeat.o(35581);
      return paramTimeLineObject;
      i = 0;
      j = 0;
    }
  }
  
  public static bcs a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4, String paramString4, bcu parambcu)
  {
    AppMethodBeat.i(35577);
    bcs localbcs = new bcs();
    localbcs.Id = uz(paramString1);
    localbcs.jKs = paramInt1;
    localbcs.Desc = uz(paramString4);
    localbcs.Url = uz(paramString2);
    localbcs.xrR = paramInt2;
    localbcs.xrS = uz(paramString3);
    localbcs.xrT = paramInt3;
    localbcs.xrU = paramInt4;
    localbcs.xrV = parambcu;
    if (paramString2 == null) {}
    for (paramString1 = "".getBytes();; paramString1 = paramString2.getBytes())
    {
      localbcs.xsg = g.w(paramString1);
      AppMethodBeat.o(35577);
      return localbcs;
    }
  }
  
  public static bcs a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, String paramString4)
  {
    AppMethodBeat.i(35576);
    bcs localbcs = new bcs();
    localbcs.Id = paramString1;
    localbcs.jKs = paramInt1;
    localbcs.Url = paramString2;
    localbcs.xrS = paramString3;
    localbcs.xrR = paramInt2;
    localbcs.xrT = paramInt3;
    localbcs.Desc = paramString4;
    paramString1 = new bcu();
    paramString1.xsI = 0.0F;
    paramString1.xsH = 0.0F;
    paramString1.xsJ = 0.0F;
    localbcs.xrV = paramString1;
    if (paramString2 == null) {}
    for (paramString1 = "".getBytes();; paramString1 = paramString2.getBytes())
    {
      localbcs.xsg = g.w(paramString1);
      AppMethodBeat.o(35576);
      return localbcs;
    }
  }
  
  public static TimeLineObject akg()
  {
    AppMethodBeat.i(35574);
    TimeLineObject localTimeLineObject = new TimeLineObject();
    Object localObject = new vi();
    localTimeLineObject.xTR = new du();
    localTimeLineObject.xTS = ((vi)localObject);
    localTimeLineObject.xrU = 0;
    localTimeLineObject.CreateTime = 0;
    localTimeLineObject.Id = "";
    localObject = new bap();
    ((bap)localObject).wDi = 0.0F;
    ((bap)localObject).wDh = 0.0F;
    localTimeLineObject.xTQ = ((bap)localObject);
    localTimeLineObject.sbN = "";
    localTimeLineObject.xTY = new cwk();
    AppMethodBeat.o(35574);
    return localTimeLineObject;
  }
  
  public static bcs akh()
  {
    AppMethodBeat.i(35575);
    bcs localbcs = new bcs();
    localbcs.Desc = "";
    localbcs.xrU = 0;
    AppMethodBeat.o(35575);
    return localbcs;
  }
  
  public static TimeLineObject uA(String paramString)
  {
    AppMethodBeat.i(35578);
    Map localMap = br.F(paramString, "TimelineObject");
    TimeLineObject localTimeLineObject = akg();
    int i;
    label1651:
    int j;
    if (localMap != null)
    {
      localTimeLineObject.Id = uz((String)localMap.get(".TimelineObject.id"));
      localTimeLineObject.jJA = uz((String)localMap.get(".TimelineObject.username"));
      localTimeLineObject.xrU = bo.getInt((String)localMap.get(".TimelineObject.private"), 0);
      localTimeLineObject.CreateTime = bo.getInt((String)localMap.get(".TimelineObject.createTime"), 0);
      localTimeLineObject.xTP = uz((String)localMap.get(".TimelineObject.contentDesc"));
      localTimeLineObject.xTU = bo.getInt((String)localMap.get(".TimelineObject.contentDescShowType"), 0);
      localTimeLineObject.xTV = bo.getInt((String)localMap.get(".TimelineObject.contentDescScene"), 0);
      localTimeLineObject.rHA = uz((String)localMap.get(".TimelineObject.statExtStr"));
      localTimeLineObject.xTZ = bo.getInt((String)localMap.get(".TimelineObject.sightFolded"), 0);
      localTimeLineObject.dqG = bo.getInt((String)localMap.get(".TimelineObject.showFlag"), 0);
      Object localObject1 = new bap();
      ((bap)localObject1).wDh = uy((String)localMap.get(".TimelineObject.location.$longitude"));
      ((bap)localObject1).wDi = uy((String)localMap.get(".TimelineObject.location.$latitude"));
      ((bap)localObject1).gwR = uz((String)localMap.get(".TimelineObject.location.$city"));
      ((bap)localObject1).xpP = bo.getInt((String)localMap.get(".TimelineObject.location.$poiScale"), 0);
      ((bap)localObject1).xpN = uz((String)localMap.get(".TimelineObject.location.$poiClassifyId"));
      ((bap)localObject1).rIg = bo.getInt((String)localMap.get(".TimelineObject.location.$poiClassifyType"), 0);
      ((bap)localObject1).rIe = uz((String)localMap.get(".TimelineObject.location.$poiAddress"));
      ((bap)localObject1).eSM = uz((String)localMap.get(".TimelineObject.location.$poiName"));
      ((bap)localObject1).xpQ = bo.getInt((String)localMap.get(".TimelineObject.location.$poiClickableStatus"), 0);
      ((bap)localObject1).xpS = uz((String)localMap.get(".TimelineObject.location.$poiAddressName"));
      ((bap)localObject1).country = uz((String)localMap.get(".TimelineObject.location.$country"));
      localTimeLineObject.xTQ = ((bap)localObject1);
      if (localTimeLineObject.xTS == null) {
        localTimeLineObject.xTS = new vi();
      }
      localTimeLineObject.xTS.Desc = uz((String)localMap.get(".TimelineObject.ContentObject.description"));
      localTimeLineObject.xTS.wNZ = bo.getInt((String)localMap.get(".TimelineObject.ContentObject.contentStyle"), 0);
      localTimeLineObject.xTS.wOb = bo.getInt((String)localMap.get(".TimelineObject.ContentObject.contentSubStyle"), 0);
      localTimeLineObject.xTS.Title = uz((String)localMap.get(".TimelineObject.ContentObject.title"));
      localTimeLineObject.xTS.Url = uz((String)localMap.get(".TimelineObject.ContentObject.contentUrl"));
      if (localMap.containsKey(".TimelineObject.ContentObject.mmreadershare.itemshowtype"))
      {
        i = bo.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.itemshowtype"), 0);
        if (i != -1)
        {
          localTimeLineObject.xTS.wOd = new bbs();
          localTimeLineObject.xTS.wOd.wqp = i;
        }
        if (i == 5)
        {
          localTimeLineObject.xTS.wOd.fgi = bo.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.pubtime"), 0);
          localTimeLineObject.xTS.wOd.fgl = uz((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.vid"));
          localTimeLineObject.xTS.wOd.lHo = uz((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.cover"));
          localTimeLineObject.xTS.wOd.fgk = bo.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.funcflag"), 0);
          localTimeLineObject.xTS.wOd.duration = bo.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.duration"), 0);
          localTimeLineObject.xTS.wOd.desc = uz((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.digest"));
          localTimeLineObject.xTS.wOd.fgj = bo.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.nativepage"), 0);
          localTimeLineObject.xTS.wOd.videoWidth = bo.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.width"), 0);
          localTimeLineObject.xTS.wOd.videoHeight = bo.getInt((String)localMap.get(".TimelineObject.ContentObject.mmreadershare.height"), 0);
        }
      }
      i = 0;
      String str24;
      String str23;
      String str22;
      String str21;
      String str20;
      String str17;
      String str18;
      String str16;
      String str15;
      String str19;
      String str12;
      String str11;
      Object localObject5;
      String str14;
      String str13;
      String str10;
      String str9;
      String str8;
      String str7;
      String str6;
      String str5;
      String str4;
      String str3;
      String str2;
      Object localObject4;
      Object localObject3;
      String str1;
      Object localObject2;
      String str25;
      Object localObject6;
      if (i != 0)
      {
        str24 = ".TimelineObject.ContentObject.mediaList.media" + i + ".id";
        str23 = ".TimelineObject.ContentObject.mediaList.media" + i + ".type";
        str22 = ".TimelineObject.ContentObject.mediaList.media" + i + ".title";
        str21 = ".TimelineObject.ContentObject.mediaList.media" + i + ".description";
        str20 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url";
        str17 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$videomd5";
        str18 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb";
        str16 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$type";
        str15 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb.$type";
        str19 = ".TimelineObject.ContentObject.mediaList.media" + i + ".private";
        str12 = ".TimelineObject.ContentObject.mediaList.media" + i + ".subType";
        str11 = ".TimelineObject.ContentObject.mediaList.media" + i + ".userData";
        localObject5 = ".TimelineObject.ContentObject.mediaList.media".concat(String.valueOf(i));
        str14 = ".TimelineObject.ContentObject.mediaList.media" + i + ".lowBandUrl";
        str13 = ".TimelineObject.ContentObject.mediaList.media" + i + ".lowBandUrl.$type";
        str10 = ".TimelineObject.ContentObject.mediaList.media" + i + ".attachUrl";
        str9 = ".TimelineObject.ContentObject.mediaList.media" + i + ".attachUrl.$md5";
        str8 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$md5";
        str7 = ".TimelineObject.ContentObject.mediaList.media" + i + ".videosize.$attachTotalTime";
        str6 = ".TimelineObject.ContentObject.mediaList.media" + i + ".attachThumbUrl";
        str5 = ".TimelineObject.ContentObject.mediaList.media" + i + ".attachShareTitle";
        str4 = ".TimelineObject.ContentObject.mediaList.media" + i + ".enc";
        str3 = ".TimelineObject.ContentObject.mediaList.media" + i + ".enc.$key";
        str2 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$token";
        localObject4 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$enc_idx";
        localObject3 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$key";
        str1 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb.$token";
        localObject2 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb.$enc_idx";
        localObject1 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb.$key";
        str25 = (String)localObject5 + ".size.$width";
        localObject6 = (String)localObject5 + ".size.$height";
        localObject5 = (String)localObject5 + ".size.$totalSize";
        str25 = (String)localMap.get(str25);
        localObject6 = (String)localMap.get(localObject6);
        String str26 = (String)localMap.get(localObject5);
        localObject5 = new bcu();
        ((bcu)localObject5).xsI = 0.0F;
        ((bcu)localObject5).xsH = 0.0F;
        ((bcu)localObject5).xsJ = 0.0F;
        if (str25 != null) {
          ((bcu)localObject5).xsH = uy(str25);
        }
        if (localObject6 != null) {
          ((bcu)localObject5).xsI = uy((String)localObject6);
        }
        if (str26 != null) {
          ((bcu)localObject5).xsJ = uy(str26);
        }
        str24 = (String)localMap.get(str24);
        str23 = (String)localMap.get(str23);
        str22 = (String)localMap.get(str22);
        str21 = (String)localMap.get(str21);
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
        localObject4 = (String)localMap.get(localObject4);
        localObject3 = (String)localMap.get(localObject3);
        str1 = (String)localMap.get(str1);
        localObject2 = (String)localMap.get(localObject2);
        str25 = (String)localMap.get(localObject1);
        if ((str23 == null) || (str24 == null)) {
          break label2733;
        }
        localObject6 = new bcs();
        ((bcs)localObject6).Id = uz(str24);
        ((bcs)localObject6).jKs = bo.getInt(str23, 0);
        ((bcs)localObject6).Title = uz(str22);
        ((bcs)localObject6).Desc = uz(str21);
        ((bcs)localObject6).Url = uz(str20);
        ((bcs)localObject6).xrR = bo.getInt(str16, 0);
        ((bcs)localObject6).xrS = uz(str18);
        ((bcs)localObject6).xrT = bo.getInt(str15, 0);
        ((bcs)localObject6).xrU = bo.getInt(str19, 0);
        ((bcs)localObject6).xrV = ((bcu)localObject5);
        ((bcs)localObject6).xrW = uz(str14);
        ((bcs)localObject6).xrX = bo.getInt(str13, 0);
        ((bcs)localObject6).rGh = uz(str11);
        ((bcs)localObject6).subType = bo.getInt(str12, 0);
        ((bcs)localObject6).xrZ = uz(str10);
        ((bcs)localObject6).xsb = uz(str9);
        ((bcs)localObject6).xsa = uz(str8);
        ((bcs)localObject6).xsn = uz(str17);
        ((bcs)localObject6).sdf = bo.getInt(str7, 0);
        ((bcs)localObject6).xsc = uz(str6);
        ((bcs)localObject6).xsd = uz(str5);
        ((bcs)localObject6).xse = bo.getInt(str4, 0);
        ((bcs)localObject6).xsf = bo.getLong(str3, 0L);
        if (((bcs)localObject6).Url != null) {
          break label2721;
        }
      }
      label2721:
      for (localObject1 = "".getBytes();; localObject1 = ((bcs)localObject6).Url.getBytes())
      {
        ((bcs)localObject6).xsg = g.w((byte[])localObject1);
        ((bcs)localObject6).xsh = str2;
        ((bcs)localObject6).xsi = bo.getInt((String)localObject4, 0);
        ((bcs)localObject6).xsj = ((String)localObject3);
        ((bcs)localObject6).xsk = str1;
        ((bcs)localObject6).xsl = bo.getInt((String)localObject2, 0);
        ((bcs)localObject6).xsm = str25;
        localTimeLineObject.xTS.wOa.add(localObject6);
        i += 1;
        break;
        str24 = ".TimelineObject.ContentObject.mediaList.media.id";
        str23 = ".TimelineObject.ContentObject.mediaList.media.type";
        str22 = ".TimelineObject.ContentObject.mediaList.media.title";
        str21 = ".TimelineObject.ContentObject.mediaList.media.description";
        str20 = ".TimelineObject.ContentObject.mediaList.media.url";
        str17 = ".TimelineObject.ContentObject.mediaList.media.url.$videomd5";
        str18 = ".TimelineObject.ContentObject.mediaList.media.thumb";
        str16 = ".TimelineObject.ContentObject.mediaList.media.url.$type";
        str15 = ".TimelineObject.ContentObject.mediaList.media.thumb.$type";
        str19 = ".TimelineObject.ContentObject.mediaList.media.private";
        str12 = ".TimelineObject.ContentObject.mediaList.media.subType";
        str11 = ".TimelineObject.ContentObject.mediaList.media.userData";
        localObject5 = ".TimelineObject.ContentObject.mediaList.media";
        str14 = ".TimelineObject.ContentObject.mediaList.media.lowBandUrl";
        str13 = ".TimelineObject.ContentObject.mediaList.media.lowBandUrl.$type";
        localObject1 = ".TimelineObject.ContentObject.mediaList.media.thumb.$key";
        localObject2 = ".TimelineObject.ContentObject.mediaList.media.thumb.$enc_idx";
        str1 = ".TimelineObject.ContentObject.mediaList.media.thumb.$token";
        localObject3 = ".TimelineObject.ContentObject.mediaList.media.url.$key";
        localObject4 = ".TimelineObject.ContentObject.mediaList.media.url.$enc_idx";
        str2 = ".TimelineObject.ContentObject.mediaList.media.url.$token";
        str3 = ".TimelineObject.ContentObject.mediaList.media.enc.$key";
        str4 = ".TimelineObject.ContentObject.mediaList.media.enc";
        str5 = ".TimelineObject.ContentObject.mediaList.media.attachShareTitle";
        str6 = ".TimelineObject.ContentObject.mediaList.media.attachThumbUrl";
        str7 = ".TimelineObject.ContentObject.mediaList.media.videosize.$attachTotalTime";
        str8 = ".TimelineObject.ContentObject.mediaList.media.url.$md5";
        str9 = ".TimelineObject.ContentObject.mediaList.media.attachUrl.$md5";
        str10 = ".TimelineObject.ContentObject.mediaList.media.attachUrl";
        break label1651;
      }
      label2733:
      i = paramString.indexOf("<noteinfo>");
      j = paramString.indexOf("</noteinfo>");
      if ((i < 0) || (j < 0))
      {
        paramString = localTimeLineObject;
        localObject1 = new du();
        localObject2 = uz((String)localMap.get(".TimelineObject.appInfo.id"));
        str1 = uz((String)localMap.get(".TimelineObject.appInfo.version"));
        localObject3 = uz((String)localMap.get(".TimelineObject.appInfo.appName"));
        localObject4 = uz((String)localMap.get(".TimelineObject.appInfo.installUrl "));
        str2 = uz((String)localMap.get(".TimelineObject.appInfo.fromUrl "));
        ((du)localObject1).Id = ((String)localObject2);
        ((du)localObject1).ntp = ((String)localObject3);
        ((du)localObject1).wpJ = ((String)localObject4);
        ((du)localObject1).wpK = str2;
        ((du)localObject1).jKg = str1;
        ((du)localObject1).wpL = bo.getInt((String)localMap.get(".TimelineObject.appInfo.clickable"), 0);
        paramString.xTR = ((du)localObject1);
        localObject1 = new cwk();
        localObject2 = uz((String)localMap.get(".TimelineObject.weappInfo.appUserName"));
        str1 = uz((String)localMap.get(".TimelineObject.weappInfo.pagePath"));
        ((cwk)localObject1).username = ((String)localObject2);
        ((cwk)localObject1).path = str1;
        paramString.xTY = ((cwk)localObject1);
        localObject1 = new cih();
        localObject2 = uz((String)localMap.get(".TimelineObject.streamvideo.streamvideotitle"));
        str1 = uz((String)localMap.get(".TimelineObject.streamvideo.streamvideototaltime"));
        localObject3 = uz((String)localMap.get(".TimelineObject.streamvideo.streamvideourl"));
        localObject4 = uz((String)localMap.get(".TimelineObject.streamvideo.streamvideoweburl"));
        str2 = uz((String)localMap.get(".TimelineObject.streamvideo.streamvideowording"));
        str3 = uz((String)localMap.get(".TimelineObject.streamvideo.streamvideothumburl"));
        str4 = uz((String)localMap.get(".TimelineObject.streamvideo.streamvideoaduxinfo"));
        str5 = uz((String)localMap.get(".TimelineObject.streamvideo.streamvideopublishid"));
        ((cih)localObject1).fiQ = ((String)localObject2);
        ((cih)localObject1).fiP = bo.apV(str1);
        ((cih)localObject1).fiO = ((String)localObject3);
        ((cih)localObject1).fiS = ((String)localObject4);
        ((cih)localObject1).fiR = str2;
        ((cih)localObject1).fiT = str3;
        ((cih)localObject1).fiU = str4;
        ((cih)localObject1).fiV = str5;
        paramString.xTX = ((cih)localObject1);
        localObject1 = new ceb();
        localObject2 = uz((String)localMap.get(".TimelineObject.redEnvelopesInfo.sendId"));
        str1 = uz((String)localMap.get(".TimelineObject.redEnvelopesInfo.ticket"));
        ((ceb)localObject1).ojA = ((String)localObject2);
        ((ceb)localObject1).crs = str1;
        localObject1 = new av();
        i = bo.getInt((String)localMap.get(".TimelineObject.actionInfo.scene"), 0);
        localObject2 = uz((String)localMap.get(".TimelineObject.actionInfo.appid"));
        j = bo.getInt((String)localMap.get(".TimelineObject.actionInfo.type"), 0);
        str1 = uz((String)localMap.get(".TimelineObject.actionInfo.url"));
        localObject3 = uz((String)localMap.get(".TimelineObject.actionInfo.mediaTagName"));
        localObject4 = uz((String)localMap.get(".TimelineObject.actionInfo.wordingKey"));
        ((av)localObject1).wmG = ((String)localObject2);
        ((av)localObject1).Scene = i;
        ((av)localObject1).jKs = j;
        ((av)localObject1).Url = str1;
        ((av)localObject1).wmH = ((String)localObject3);
        ((av)localObject1).wmI = ((String)localObject4);
        localObject2 = new at();
        str1 = uz((String)localMap.get(".TimelineObject.actionInfo.appMsg.appid"));
        localObject3 = uz((String)localMap.get(".TimelineObject.actionInfo.appMsg.mediaTagName"));
        localObject4 = uz((String)localMap.get(".TimelineObject.actionInfo.appMsg.messageExt"));
        str2 = uz((String)localMap.get(".TimelineObject.actionInfo.appMsg.messageAction"));
        ((at)localObject2).fKw = str1;
        ((at)localObject2).wmD = ((String)localObject3);
        ((at)localObject2).wmE = ((String)localObject4);
        ((at)localObject2).wmF = str2;
        ((av)localObject1).wmJ = ((at)localObject2);
        i = bo.getInt((String)localMap.get(".TimelineObject.actionInfo.appActionScene.installedActionScene"), 0);
        j = bo.getInt((String)localMap.get(".TimelineObject.actionInfo.appActionScene.uninstalledActionScene"), 0);
        localObject2 = uz((String)localMap.get(".TimelineObject.actionInfo.appJumpWordingKey.installedWordingKey"));
        str1 = uz((String)localMap.get(".TimelineObject.actionInfo.appJumpWordingKey.uninstalledWordingKey"));
        ((av)localObject1).wmK = uz((String)localMap.get(".TimelineObject.actionInfo.newWordingKey"));
        localObject3 = new dj();
        ((dj)localObject3).wpB = i;
        ((dj)localObject3).wpC = j;
        localObject4 = new dw();
        ((dw)localObject4).wpP = ((String)localObject2);
        ((dw)localObject4).wpQ = str1;
        ((av)localObject1).wmL = ((dj)localObject3);
        ((av)localObject1).wmM = ((dw)localObject4);
        ((av)localObject1).wmN = uB((String)localMap.get(".TimelineObject.actionInfo.installedWording"));
        ((av)localObject1).wmO = uB((String)localMap.get(".TimelineObject.actionInfo.uninstalledWording"));
        paramString.rjv = ((av)localObject1);
        paramString.inF = uz((String)localMap.get(".TimelineObject.sourceUserName"));
        paramString.vSR = uz((String)localMap.get(".TimelineObject.sourceNickName"));
        paramString.xTT = uz((String)localMap.get(".TimelineObject.publicUserName"));
        paramString.xTW = uz((String)localMap.get(".TimelineObject.statisticsData"));
        paramString.sbN = uz((String)localMap.get(".TimelineObject.canvasInfoXml"));
        paramString.fgB = bo.getInt((String)localMap.get(".TimelineObject.contentattr"), 0);
        localObject1 = new cyl();
        ((cyl)localObject1).uJi = uz((String)localMap.get(".TimelineObject.websearch.relevant_vid"));
        ((cyl)localObject1).uJj = uz((String)localMap.get(".TimelineObject.websearch.relevant_expand"));
        ((cyl)localObject1).uJk = uz((String)localMap.get(".TimelineObject.websearch.relevant_pre_searchid"));
        ((cyl)localObject1).uJl = uz((String)localMap.get(".TimelineObject.websearch.relevant_shared_openid"));
        ((cyl)localObject1).uJm = bo.getLong((String)localMap.get(".TimelineObject.websearch.rec_category"), 0L);
        ((cyl)localObject1).lHq = uz((String)localMap.get(".TimelineObject.websearch.shareUrl"));
        ((cyl)localObject1).lHr = uz((String)localMap.get(".TimelineObject.websearch.shareTitle"));
        ((cyl)localObject1).rrm = uz((String)localMap.get(".TimelineObject.websearch.shareDesc"));
        ((cyl)localObject1).uJn = uz((String)localMap.get(".TimelineObject.websearch.shareImgUrl"));
        ((cyl)localObject1).uJo = uz((String)localMap.get(".TimelineObject.websearch.shareString"));
        ((cyl)localObject1).uJp = uz((String)localMap.get(".TimelineObject.websearch.shareStringUrl"));
        ((cyl)localObject1).source = uz((String)localMap.get(".TimelineObject.websearch.source"));
        ((cyl)localObject1).puE = uz((String)localMap.get(".TimelineObject.websearch.sourceUrl"));
        ((cyl)localObject1).uJq = uz((String)localMap.get(".TimelineObject.websearch.strPlayCount"));
        ((cyl)localObject1).uJr = uz((String)localMap.get(".TimelineObject.websearch.titleUrl"));
        ((cyl)localObject1).uJs = uz((String)localMap.get(".TimelineObject.websearch.extReqParams"));
        ((cyl)localObject1).uJt = uz((String)localMap.get(".TimelineObject.websearch.tagList"));
        ((cyl)localObject1).uJu = bo.getLong((String)localMap.get(".TimelineObject.websearch.channelId"), 0L);
        ((cyl)localObject1).uJv = uz((String)localMap.get(".TimelineObject.websearch.shareTag"));
        paramString.rjx = ((cyl)localObject1);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35578);
      return localTimeLineObject;
      localTimeLineObject.xTS.wOc = paramString.substring(i, j + 11);
      break;
    }
  }
  
  private static dv uB(String paramString)
  {
    AppMethodBeat.i(35579);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(35579);
      return null;
    }
    paramString = uC(paramString);
    paramString = br.F("<root>" + paramString + "</root>", "root");
    if (paramString == null)
    {
      AppMethodBeat.o(35579);
      return null;
    }
    dv localdv = new dv();
    localdv.wpM = uz((String)paramString.get(".root.en"));
    localdv.wpN = uz((String)paramString.get(".root.zh-CN"));
    localdv.wpO = uz((String)paramString.get(".root.zh-TW"));
    AppMethodBeat.o(35579);
    return localdv;
  }
  
  private static String uC(String paramString)
  {
    AppMethodBeat.i(35580);
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
    AppMethodBeat.o(35580);
    return paramString;
  }
  
  private static float uy(String paramString)
  {
    AppMethodBeat.i(35573);
    if (paramString == null)
    {
      AppMethodBeat.o(35573);
      return 0.0F;
    }
    float f = bo.getFloat(paramString, 0.0F);
    AppMethodBeat.o(35573);
    return f;
  }
  
  private static String uz(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelsns.e
 * JD-Core Version:    0.7.0.1
 */