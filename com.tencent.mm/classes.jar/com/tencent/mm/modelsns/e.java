package com.tencent.mm.modelsns;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.mm.a.g;
import com.tencent.mm.cb.a;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.protocal.c.av;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.awf;
import com.tencent.mm.protocal.c.btl;
import com.tencent.mm.protocal.c.bvz;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.cix;
import com.tencent.mm.protocal.c.ckw;
import com.tencent.mm.protocal.c.da;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.protocal.c.dl;
import com.tencent.mm.protocal.c.dm;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.Map;

public final class e
{
  public static bxk QZ()
  {
    bxk localbxk = new bxk();
    Object localObject = new rp();
    localbxk.tNq = new dk();
    localbxk.tNr = ((rp)localObject);
    localbxk.trR = 0;
    localbxk.mPL = 0;
    localbxk.lsK = "";
    localObject = new aui();
    ((aui)localObject).sGK = 0.0F;
    ((aui)localObject).sGJ = 0.0F;
    localbxk.tNp = ((aui)localObject);
    localbxk.pjl = "";
    localbxk.tNx = new cix();
    return localbxk;
  }
  
  public static awd Ra()
  {
    awd localawd = new awd();
    localawd.kRN = "";
    localawd.trR = 0;
    return localawd;
  }
  
  public static Pair<Integer, Integer> a(int paramInt1, int paramInt2, Context paramContext, boolean paramBoolean)
  {
    if (paramInt1 <= 0) {}
    for (int j = 320;; j = paramInt1)
    {
      int k = paramInt2;
      if (paramInt2 <= 0) {
        k = 240;
      }
      if (paramContext == null)
      {
        y.e("MicroMsg.TimeLineHelper", "the context is null");
        return Pair.create(Integer.valueOf(j), Integer.valueOf(k));
      }
      DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      if (localDisplayMetrics != null) {}
      for (paramInt1 = (int)Math.min(localDisplayMetrics.widthPixels * 0.63F, localDisplayMetrics.heightPixels * 0.63F);; paramInt1 = j)
      {
        paramInt1 = paramInt1 >> 5 << 5;
        int i = paramInt1;
        if (j < k)
        {
          i = paramInt1;
          if (paramContext != null) {
            i = Math.min(BackwardSupportUtil.b.b(paramContext, 160.0F), paramInt1);
          }
        }
        int n = (int)(i * 1.0D * k / j);
        paramInt1 = n;
        paramInt2 = i;
        int i1;
        int m;
        if (!paramBoolean)
        {
          i1 = a.fromDPToPix(paramContext, 200);
          m = a.fromDPToPix(paramContext, 44);
          if (n < i) {
            break label284;
          }
          paramInt1 = n;
          if (n > i1) {
            paramInt1 = i1;
          }
          i = (int)(j * 1.0F / k * paramInt1);
          paramInt2 = i;
          if (i < m)
          {
            paramInt1 = (int)(m * 1.0D * k / j);
            paramInt2 = m;
          }
        }
        for (;;)
        {
          y.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean) });
          return Pair.create(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
          label284:
          paramInt2 = i;
          if (i > i1) {
            paramInt2 = i1;
          }
          i = (int)(k * 1.0F / j * paramInt2);
          paramInt1 = i;
          if (i < m)
          {
            paramInt2 = (int)(m * 1.0D * j / k);
            paramInt1 = m;
          }
        }
      }
    }
  }
  
  public static Pair<Integer, Integer> a(bxk parambxk, Context paramContext, boolean paramBoolean)
  {
    int j;
    int i;
    if ((parambxk != null) && (parambxk.tNr != null) && (parambxk.tNr.sPJ != null) && (parambxk.tNr.sPJ.size() > 0))
    {
      parambxk = (awd)parambxk.tNr.sPJ.get(0);
      if ((parambxk != null) && (parambxk.trS != null) && (parambxk.trS.tsF > 0.0F) && (parambxk.trS.tsG > 0.0F))
      {
        j = (int)parambxk.trS.tsF;
        i = (int)parambxk.trS.tsG;
      }
    }
    for (;;)
    {
      return a(j, i, paramContext, paramBoolean);
      i = 0;
      j = 0;
    }
  }
  
  public static awd a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4, String paramString4, awf paramawf)
  {
    awd localawd = new awd();
    localawd.lsK = nm(paramString1);
    localawd.hQR = paramInt1;
    localawd.kRN = nm(paramString4);
    localawd.kSC = nm(paramString2);
    localawd.trO = paramInt2;
    localawd.trP = nm(paramString3);
    localawd.trQ = paramInt3;
    localawd.trR = paramInt4;
    localawd.trS = paramawf;
    if (paramString2 == null) {}
    for (paramString1 = "".getBytes();; paramString1 = paramString2.getBytes())
    {
      localawd.tsd = g.o(paramString1);
      return localawd;
    }
  }
  
  public static awd a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, String paramString4)
  {
    awd localawd = new awd();
    localawd.lsK = paramString1;
    localawd.hQR = paramInt1;
    localawd.kSC = paramString2;
    localawd.trP = paramString3;
    localawd.trO = paramInt2;
    localawd.trQ = paramInt3;
    localawd.kRN = paramString4;
    paramString1 = new awf();
    paramString1.tsG = 0.0F;
    paramString1.tsF = 0.0F;
    paramString1.tsH = 0.0F;
    localawd.trS = paramString1;
    if (paramString2 == null) {}
    for (paramString1 = "".getBytes();; paramString1 = paramString2.getBytes())
    {
      localawd.tsd = g.o(paramString1);
      return localawd;
    }
  }
  
  private static float nl(String paramString)
  {
    if (paramString == null) {
      return 0.0F;
    }
    return bk.getFloat(paramString, 0.0F);
  }
  
  private static String nm(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static bxk nn(String paramString)
  {
    Map localMap = bn.s(paramString, "TimelineObject");
    bxk localbxk = QZ();
    if (localMap != null)
    {
      localbxk.lsK = nm((String)localMap.get(".TimelineObject.id"));
      localbxk.hPY = nm((String)localMap.get(".TimelineObject.username"));
      localbxk.trR = bk.getInt((String)localMap.get(".TimelineObject.private"), 0);
      localbxk.mPL = bk.getInt((String)localMap.get(".TimelineObject.createTime"), 0);
      localbxk.tNo = nm((String)localMap.get(".TimelineObject.contentDesc"));
      localbxk.tNt = bk.getInt((String)localMap.get(".TimelineObject.contentDescShowType"), 0);
      localbxk.tNu = bk.getInt((String)localMap.get(".TimelineObject.contentDescScene"), 0);
      localbxk.oPO = nm((String)localMap.get(".TimelineObject.statExtStr"));
      localbxk.tNy = bk.getInt((String)localMap.get(".TimelineObject.sightFolded"), 0);
      localbxk.cCu = bk.getInt((String)localMap.get(".TimelineObject.showFlag"), 0);
      Object localObject1 = new aui();
      ((aui)localObject1).sGJ = nl((String)localMap.get(".TimelineObject.location.$longitude"));
      ((aui)localObject1).sGK = nl((String)localMap.get(".TimelineObject.location.$latitude"));
      ((aui)localObject1).ffj = nm((String)localMap.get(".TimelineObject.location.$city"));
      ((aui)localObject1).tpS = bk.getInt((String)localMap.get(".TimelineObject.location.$poiScale"), 0);
      ((aui)localObject1).tpQ = nm((String)localMap.get(".TimelineObject.location.$poiClassifyId"));
      ((aui)localObject1).oQu = bk.getInt((String)localMap.get(".TimelineObject.location.$poiClassifyType"), 0);
      ((aui)localObject1).oQs = nm((String)localMap.get(".TimelineObject.location.$poiAddress"));
      ((aui)localObject1).lFn = nm((String)localMap.get(".TimelineObject.location.$poiName"));
      ((aui)localObject1).tpT = bk.getInt((String)localMap.get(".TimelineObject.location.$poiClickableStatus"), 0);
      ((aui)localObject1).tpV = nm((String)localMap.get(".TimelineObject.location.$poiAddressName"));
      ((aui)localObject1).country = nm((String)localMap.get(".TimelineObject.location.$country"));
      localbxk.tNp = ((aui)localObject1);
      if (localbxk.tNr == null) {
        localbxk.tNr = new rp();
      }
      localbxk.tNr.kRN = nm((String)localMap.get(".TimelineObject.ContentObject.description"));
      localbxk.tNr.sPI = bk.getInt((String)localMap.get(".TimelineObject.ContentObject.contentStyle"), 0);
      localbxk.tNr.sPK = bk.getInt((String)localMap.get(".TimelineObject.ContentObject.contentSubStyle"), 0);
      localbxk.tNr.bGw = nm((String)localMap.get(".TimelineObject.ContentObject.title"));
      localbxk.tNr.kSC = nm((String)localMap.get(".TimelineObject.ContentObject.contentUrl"));
      int i = 0;
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
      String str13;
      String str12;
      Object localObject4;
      String str15;
      String str14;
      String str11;
      String str10;
      String str9;
      String str8;
      String str7;
      String str6;
      String str5;
      String str4;
      String str3;
      String str2;
      Object localObject3;
      Object localObject2;
      String str1;
      label1335:
      String str26;
      Object localObject5;
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
        str13 = ".TimelineObject.ContentObject.mediaList.media" + i + ".subType";
        str12 = ".TimelineObject.ContentObject.mediaList.media" + i + ".userData";
        localObject4 = ".TimelineObject.ContentObject.mediaList.media" + i;
        str15 = ".TimelineObject.ContentObject.mediaList.media" + i + ".lowBandUrl";
        str14 = ".TimelineObject.ContentObject.mediaList.media" + i + ".lowBandUrl.$type";
        str11 = ".TimelineObject.ContentObject.mediaList.media" + i + ".attachUrl";
        str10 = ".TimelineObject.ContentObject.mediaList.media" + i + ".attachUrl.$md5";
        str9 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$md5";
        str8 = ".TimelineObject.ContentObject.mediaList.media" + i + ".videosize.$attachTotalTime";
        str7 = ".TimelineObject.ContentObject.mediaList.media" + i + ".attachThumbUrl";
        str6 = ".TimelineObject.ContentObject.mediaList.media" + i + ".attachShareTitle";
        str5 = ".TimelineObject.ContentObject.mediaList.media" + i + ".enc";
        str4 = ".TimelineObject.ContentObject.mediaList.media" + i + ".enc.$key";
        str3 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$token";
        str2 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$enc_idx";
        localObject3 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$key";
        localObject2 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb.$token";
        str1 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb.$enc_idx";
        localObject1 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb.$key";
        str26 = (String)localObject4 + ".size.$width";
        localObject5 = (String)localObject4 + ".size.$height";
        localObject4 = (String)localObject4 + ".size.$totalSize";
        str26 = (String)localMap.get(str26);
        localObject5 = (String)localMap.get(localObject5);
        String str27 = (String)localMap.get(localObject4);
        localObject4 = new awf();
        ((awf)localObject4).tsG = 0.0F;
        ((awf)localObject4).tsF = 0.0F;
        ((awf)localObject4).tsH = 0.0F;
        if (str26 != null) {
          ((awf)localObject4).tsF = nl(str26);
        }
        if (localObject5 != null) {
          ((awf)localObject4).tsG = nl((String)localObject5);
        }
        if (str27 != null) {
          ((awf)localObject4).tsH = nl(str27);
        }
        str25 = (String)localMap.get(str25);
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
        localObject3 = (String)localMap.get(localObject3);
        localObject2 = (String)localMap.get(localObject2);
        str1 = (String)localMap.get(str1);
        str26 = (String)localMap.get(localObject1);
        if ((str24 == null) || (str25 == null)) {
          break label2417;
        }
        localObject5 = new awd();
        ((awd)localObject5).lsK = nm(str25);
        ((awd)localObject5).hQR = bk.getInt(str24, 0);
        ((awd)localObject5).bGw = nm(str23);
        ((awd)localObject5).kRN = nm(str22);
        ((awd)localObject5).kSC = nm(str21);
        ((awd)localObject5).trO = bk.getInt(str17, 0);
        ((awd)localObject5).trP = nm(str19);
        ((awd)localObject5).trQ = bk.getInt(str16, 0);
        ((awd)localObject5).trR = bk.getInt(str20, 0);
        ((awd)localObject5).trS = ((awf)localObject4);
        ((awd)localObject5).trT = nm(str15);
        ((awd)localObject5).trU = bk.getInt(str14, 0);
        ((awd)localObject5).oOw = nm(str12);
        ((awd)localObject5).brC = bk.getInt(str13, 0);
        ((awd)localObject5).trW = nm(str11);
        ((awd)localObject5).trY = nm(str10);
        ((awd)localObject5).trX = nm(str9);
        ((awd)localObject5).tsk = nm(str18);
        ((awd)localObject5).pkD = bk.getInt(str8, 0);
        ((awd)localObject5).trZ = nm(str7);
        ((awd)localObject5).tsa = nm(str6);
        ((awd)localObject5).tsb = bk.getInt(str5, 0);
        ((awd)localObject5).tsc = bk.getLong(str4, 0L);
        if (((awd)localObject5).kSC != null) {
          break label2405;
        }
      }
      label2405:
      for (localObject1 = "".getBytes();; localObject1 = ((awd)localObject5).kSC.getBytes())
      {
        ((awd)localObject5).tsd = g.o((byte[])localObject1);
        ((awd)localObject5).tse = str3;
        ((awd)localObject5).tsf = bk.getInt(str2, 0);
        ((awd)localObject5).tsg = ((String)localObject3);
        ((awd)localObject5).tsh = ((String)localObject2);
        ((awd)localObject5).tsi = bk.getInt(str1, 0);
        ((awd)localObject5).tsj = str26;
        localbxk.tNr.sPJ.add(localObject5);
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
        str13 = ".TimelineObject.ContentObject.mediaList.media.subType";
        str12 = ".TimelineObject.ContentObject.mediaList.media.userData";
        localObject4 = ".TimelineObject.ContentObject.mediaList.media";
        str15 = ".TimelineObject.ContentObject.mediaList.media.lowBandUrl";
        str14 = ".TimelineObject.ContentObject.mediaList.media.lowBandUrl.$type";
        localObject1 = ".TimelineObject.ContentObject.mediaList.media.thumb.$key";
        str1 = ".TimelineObject.ContentObject.mediaList.media.thumb.$enc_idx";
        localObject2 = ".TimelineObject.ContentObject.mediaList.media.thumb.$token";
        localObject3 = ".TimelineObject.ContentObject.mediaList.media.url.$key";
        str2 = ".TimelineObject.ContentObject.mediaList.media.url.$enc_idx";
        str3 = ".TimelineObject.ContentObject.mediaList.media.url.$token";
        str4 = ".TimelineObject.ContentObject.mediaList.media.enc.$key";
        str5 = ".TimelineObject.ContentObject.mediaList.media.enc";
        str6 = ".TimelineObject.ContentObject.mediaList.media.attachShareTitle";
        str7 = ".TimelineObject.ContentObject.mediaList.media.attachThumbUrl";
        str8 = ".TimelineObject.ContentObject.mediaList.media.videosize.$attachTotalTime";
        str9 = ".TimelineObject.ContentObject.mediaList.media.url.$md5";
        str10 = ".TimelineObject.ContentObject.mediaList.media.attachUrl.$md5";
        str11 = ".TimelineObject.ContentObject.mediaList.media.attachUrl";
        break label1335;
      }
      label2417:
      i = paramString.indexOf("<noteinfo>");
      int j = paramString.indexOf("</noteinfo>");
      if ((i < 0) || (j < 0)) {}
      for (;;)
      {
        paramString = new dk();
        localObject1 = nm((String)localMap.get(".TimelineObject.appInfo.id"));
        str1 = nm((String)localMap.get(".TimelineObject.appInfo.version"));
        localObject2 = nm((String)localMap.get(".TimelineObject.appInfo.appName"));
        localObject3 = nm((String)localMap.get(".TimelineObject.appInfo.installUrl "));
        str2 = nm((String)localMap.get(".TimelineObject.appInfo.fromUrl "));
        paramString.lsK = ((String)localObject1);
        paramString.kVn = ((String)localObject2);
        paramString.swH = ((String)localObject3);
        paramString.swI = str2;
        paramString.hQE = str1;
        paramString.swJ = bk.getInt((String)localMap.get(".TimelineObject.appInfo.clickable"), 0);
        localbxk.tNq = paramString;
        paramString = new cix();
        localObject1 = nm((String)localMap.get(".TimelineObject.weappInfo.appUserName"));
        str1 = nm((String)localMap.get(".TimelineObject.weappInfo.pagePath"));
        paramString.username = ((String)localObject1);
        paramString.path = str1;
        localbxk.tNx = paramString;
        paramString = new bvz();
        localObject1 = nm((String)localMap.get(".TimelineObject.streamvideo.streamvideotitle"));
        str1 = nm((String)localMap.get(".TimelineObject.streamvideo.streamvideototaltime"));
        localObject2 = nm((String)localMap.get(".TimelineObject.streamvideo.streamvideourl"));
        localObject3 = nm((String)localMap.get(".TimelineObject.streamvideo.streamvideoweburl"));
        str2 = nm((String)localMap.get(".TimelineObject.streamvideo.streamvideowording"));
        str3 = nm((String)localMap.get(".TimelineObject.streamvideo.streamvideothumburl"));
        str4 = nm((String)localMap.get(".TimelineObject.streamvideo.streamvideoaduxinfo"));
        str5 = nm((String)localMap.get(".TimelineObject.streamvideo.streamvideopublishid"));
        paramString.dSR = ((String)localObject1);
        paramString.dSQ = bk.ZR(str1);
        paramString.dSP = ((String)localObject2);
        paramString.dST = ((String)localObject3);
        paramString.dSS = str2;
        paramString.dSU = str3;
        paramString.dSV = str4;
        paramString.dSW = str5;
        localbxk.tNw = paramString;
        paramString = new btl();
        localObject1 = nm((String)localMap.get(".TimelineObject.redEnvelopesInfo.sendId"));
        str1 = nm((String)localMap.get(".TimelineObject.redEnvelopesInfo.ticket"));
        paramString.lMg = ((String)localObject1);
        paramString.bJY = str1;
        paramString = new av();
        i = bk.getInt((String)localMap.get(".TimelineObject.actionInfo.scene"), 0);
        localObject1 = nm((String)localMap.get(".TimelineObject.actionInfo.appid"));
        j = bk.getInt((String)localMap.get(".TimelineObject.actionInfo.type"), 0);
        str1 = nm((String)localMap.get(".TimelineObject.actionInfo.url"));
        localObject2 = nm((String)localMap.get(".TimelineObject.actionInfo.mediaTagName"));
        localObject3 = nm((String)localMap.get(".TimelineObject.actionInfo.wordingKey"));
        paramString.sud = ((String)localObject1);
        paramString.pyo = i;
        paramString.hQR = j;
        paramString.kSC = str1;
        paramString.sue = ((String)localObject2);
        paramString.suf = ((String)localObject3);
        localObject1 = new at();
        str1 = nm((String)localMap.get(".TimelineObject.actionInfo.appMsg.appid"));
        localObject2 = nm((String)localMap.get(".TimelineObject.actionInfo.appMsg.mediaTagName"));
        localObject3 = nm((String)localMap.get(".TimelineObject.actionInfo.appMsg.messageExt"));
        str2 = nm((String)localMap.get(".TimelineObject.actionInfo.appMsg.messageAction"));
        ((at)localObject1).euK = str1;
        ((at)localObject1).sua = ((String)localObject2);
        ((at)localObject1).sub = ((String)localObject3);
        ((at)localObject1).suc = str2;
        paramString.sug = ((at)localObject1);
        i = bk.getInt((String)localMap.get(".TimelineObject.actionInfo.appActionScene.installedActionScene"), 0);
        j = bk.getInt((String)localMap.get(".TimelineObject.actionInfo.appActionScene.uninstalledActionScene"), 0);
        localObject1 = nm((String)localMap.get(".TimelineObject.actionInfo.appJumpWordingKey.installedWordingKey"));
        str1 = nm((String)localMap.get(".TimelineObject.actionInfo.appJumpWordingKey.uninstalledWordingKey"));
        paramString.suh = nm((String)localMap.get(".TimelineObject.actionInfo.newWordingKey"));
        localObject2 = new da();
        ((da)localObject2).swp = i;
        ((da)localObject2).swq = j;
        localObject3 = new dm();
        ((dm)localObject3).swN = ((String)localObject1);
        ((dm)localObject3).swO = str1;
        paramString.sui = ((da)localObject2);
        paramString.suj = ((dm)localObject3);
        paramString.suk = no((String)localMap.get(".TimelineObject.actionInfo.installedWording"));
        paramString.sul = no((String)localMap.get(".TimelineObject.actionInfo.uninstalledWording"));
        localbxk.ouC = paramString;
        localbxk.sbK = nm((String)localMap.get(".TimelineObject.sourceUserName"));
        localbxk.sbL = nm((String)localMap.get(".TimelineObject.sourceNickName"));
        localbxk.tNs = nm((String)localMap.get(".TimelineObject.publicUserName"));
        localbxk.tNv = nm((String)localMap.get(".TimelineObject.statisticsData"));
        localbxk.pjl = nm((String)localMap.get(".TimelineObject.canvasInfoXml"));
        localbxk.dQA = bk.getInt((String)localMap.get(".TimelineObject.contentattr"), 0);
        paramString = new ckw();
        paramString.qTY = nm((String)localMap.get(".TimelineObject.websearch.relevant_vid"));
        paramString.qTZ = nm((String)localMap.get(".TimelineObject.websearch.relevant_expand"));
        paramString.qUa = nm((String)localMap.get(".TimelineObject.websearch.relevant_pre_searchid"));
        paramString.qUb = nm((String)localMap.get(".TimelineObject.websearch.relevant_shared_openid"));
        paramString.qUc = bk.getLong((String)localMap.get(".TimelineObject.websearch.rec_category"), 0L);
        paramString.jxR = nm((String)localMap.get(".TimelineObject.websearch.shareUrl"));
        paramString.jxS = nm((String)localMap.get(".TimelineObject.websearch.shareTitle"));
        paramString.oBT = nm((String)localMap.get(".TimelineObject.websearch.shareDesc"));
        paramString.qUd = nm((String)localMap.get(".TimelineObject.websearch.shareImgUrl"));
        paramString.qUe = nm((String)localMap.get(".TimelineObject.websearch.shareString"));
        paramString.qUf = nm((String)localMap.get(".TimelineObject.websearch.shareStringUrl"));
        paramString.aWf = nm((String)localMap.get(".TimelineObject.websearch.source"));
        paramString.mSy = nm((String)localMap.get(".TimelineObject.websearch.sourceUrl"));
        paramString.qUg = nm((String)localMap.get(".TimelineObject.websearch.strPlayCount"));
        paramString.qUh = nm((String)localMap.get(".TimelineObject.websearch.titleUrl"));
        paramString.qUi = nm((String)localMap.get(".TimelineObject.websearch.extReqParams"));
        paramString.qUj = nm((String)localMap.get(".TimelineObject.websearch.tagList"));
        paramString.qUk = bk.getLong((String)localMap.get(".TimelineObject.websearch.channelId"), 0L);
        localbxk.ouE = paramString;
        return localbxk;
        localbxk.tNr.sPL = paramString.substring(i, j + 11);
      }
    }
    return localbxk;
  }
  
  private static dl no(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    Object localObject = new StringBuilder(paramString.length());
    int i = 0;
    int j = paramString.length();
    while (i < j)
    {
      char c = paramString.charAt(i);
      if (c != '&')
      {
        ((StringBuilder)localObject).append(c);
        i += 1;
      }
      else if (paramString.startsWith("&amp;", i))
      {
        ((StringBuilder)localObject).append('&');
        i += 5;
      }
      else if (paramString.startsWith("&apos;", i))
      {
        ((StringBuilder)localObject).append('\'');
        i += 6;
      }
      else if (paramString.startsWith("&quot;", i))
      {
        ((StringBuilder)localObject).append('"');
        i += 6;
      }
      else if (paramString.startsWith("&lt;", i))
      {
        ((StringBuilder)localObject).append('<');
        i += 4;
      }
      else if (paramString.startsWith("&gt;", i))
      {
        ((StringBuilder)localObject).append('>');
        i += 4;
      }
    }
    paramString = ((StringBuilder)localObject).toString();
    paramString = bn.s("<root>" + paramString + "</root>", "root");
    if (paramString == null) {
      return null;
    }
    localObject = new dl();
    ((dl)localObject).swK = nm((String)paramString.get(".root.en"));
    ((dl)localObject).swL = nm((String)paramString.get(".root.zh-CN"));
    ((dl)localObject).swM = nm((String)paramString.get(".root.zh-TW"));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelsns.e
 * JD-Core Version:    0.7.0.1
 */