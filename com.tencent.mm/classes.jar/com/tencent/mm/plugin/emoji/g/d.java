package com.tencent.mm.plugin.emoji.g;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.emoji.c.l;
import com.tencent.mm.emoji.c.m;
import com.tencent.mm.emoji.sync.b;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.iw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.smiley.QQSmileyManager;
import com.tencent.mm.smiley.r;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.vending.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class d
{
  public static final ArrayList<String> ydI;
  
  static
  {
    AppMethodBeat.i(269832);
    ArrayList localArrayList = new ArrayList();
    ydI = localArrayList;
    localArrayList.add("9bd1281af3a31710a45b84d736363691");
    ydI.add("08f223fa83f1ca34e143d1e580252c7c");
    AppMethodBeat.o(269832);
  }
  
  public static boolean A(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(269809);
    if (paramEmojiInfo == null)
    {
      AppMethodBeat.o(269809);
      return false;
    }
    boolean bool = apd(paramEmojiInfo.getMd5());
    AppMethodBeat.o(269809);
    return bool;
  }
  
  public static boolean B(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104582);
    if (paramEmojiInfo == null)
    {
      AppMethodBeat.o(104582);
      return false;
    }
    if (!com.tencent.mm.emoji.c.o.aVa())
    {
      AppMethodBeat.o(104582);
      return false;
    }
    if ((z(paramEmojiInfo)) || ((paramEmojiInfo.field_activityid != null) && (paramEmojiInfo.field_activityid.startsWith("Selfie"))))
    {
      AppMethodBeat.o(104582);
      return true;
    }
    AppMethodBeat.o(104582);
    return false;
  }
  
  public static void a(amn paramamn, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104577);
    if ((!Util.isNullOrNil(paramEmojiInfo.field_md5)) && (!paramEmojiInfo.field_md5.equals(paramamn.Md5)))
    {
      AppMethodBeat.o(104577);
      return;
    }
    paramEmojiInfo.field_md5 = gP(paramamn.Md5, paramEmojiInfo.field_md5);
    paramEmojiInfo.field_cdnUrl = gP(paramamn.Url, paramEmojiInfo.field_cdnUrl);
    paramEmojiInfo.field_thumbUrl = gP(paramamn.ThumbUrl, paramEmojiInfo.field_thumbUrl);
    paramEmojiInfo.field_designerID = gP(paramamn.DesignerID, paramEmojiInfo.field_designerID);
    paramEmojiInfo.field_encrypturl = gP(paramamn.EncryptUrl, paramEmojiInfo.field_encrypturl);
    paramEmojiInfo.field_aeskey = gP(paramamn.AesKey, paramEmojiInfo.field_aeskey);
    paramEmojiInfo.field_groupId = gP(paramamn.ProductID, paramEmojiInfo.field_groupId);
    paramEmojiInfo.field_externUrl = gP(paramamn.ExternUrl, paramEmojiInfo.field_externUrl);
    paramEmojiInfo.field_externMd5 = gP(paramamn.ExternMd5, paramEmojiInfo.field_externMd5);
    paramEmojiInfo.field_activityid = gP(paramamn.ActivityID, paramEmojiInfo.field_activityid);
    paramEmojiInfo.field_attachedText = gP(paramamn.AttachedText, paramEmojiInfo.field_attachedText);
    paramEmojiInfo.field_attachTextColor = gP(paramamn.AttachedTextColor, paramEmojiInfo.field_attachTextColor);
    paramEmojiInfo.field_lensId = gP(paramamn.LensId, paramEmojiInfo.field_lensId);
    paramEmojiInfo.field_linkId = gP(paramamn.Ztx, paramEmojiInfo.field_linkId);
    AppMethodBeat.o(104577);
  }
  
  public static void a(amn paramamn, EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(269780);
    a(paramamn, paramEmojiInfo);
    paramEmojiInfo.abrL = paramString;
    AppMethodBeat.o(269780);
  }
  
  public static void a(EmojiInfo paramEmojiInfo, amn paramamn)
  {
    AppMethodBeat.i(269774);
    if ((!Util.isNullOrNil(paramamn.Md5)) && (!paramamn.Md5.equals(paramEmojiInfo.field_md5)))
    {
      AppMethodBeat.o(269774);
      return;
    }
    paramamn.Md5 = gP(paramEmojiInfo.field_md5, paramamn.Md5);
    paramamn.Md5 = gP(paramamn.Md5, "");
    paramamn.Url = gP(paramEmojiInfo.field_cdnUrl, paramamn.Url);
    paramamn.ThumbUrl = gP(paramEmojiInfo.field_thumbUrl, paramamn.ThumbUrl);
    paramamn.DesignerID = gP(paramEmojiInfo.field_designerID, paramamn.DesignerID);
    paramamn.EncryptUrl = gP(paramEmojiInfo.field_encrypturl, paramamn.EncryptUrl);
    paramamn.AesKey = gP(paramEmojiInfo.field_aeskey, paramamn.AesKey);
    paramamn.ProductID = gP(paramEmojiInfo.field_groupId, paramamn.ProductID);
    paramamn.ExternUrl = gP(paramEmojiInfo.field_externUrl, paramamn.ExternUrl);
    paramamn.ExternMd5 = gP(paramEmojiInfo.field_externMd5, paramamn.ExternMd5);
    paramamn.ActivityID = gP(paramEmojiInfo.field_activityid, paramamn.ActivityID);
    paramamn.AttachedText = gP(paramEmojiInfo.field_attachedText, paramamn.AttachedText);
    paramamn.AttachedTextColor = gP(paramEmojiInfo.field_attachTextColor, paramamn.AttachedTextColor);
    paramamn.LensId = gP(paramEmojiInfo.field_lensId, paramamn.LensId);
    paramamn.Ztx = gP(paramEmojiInfo.field_linkId, paramamn.Ztx);
    AppMethodBeat.o(269774);
  }
  
  public static void a(EmojiInfo paramEmojiInfo1, EmojiInfo paramEmojiInfo2)
  {
    paramEmojiInfo2.field_cdnUrl = paramEmojiInfo1.field_cdnUrl;
    paramEmojiInfo2.field_thumbUrl = paramEmojiInfo1.field_thumbUrl;
    paramEmojiInfo2.field_designerID = paramEmojiInfo1.field_designerID;
    paramEmojiInfo2.field_encrypturl = paramEmojiInfo1.field_encrypturl;
    paramEmojiInfo2.field_aeskey = paramEmojiInfo1.field_aeskey;
    paramEmojiInfo2.field_groupId = paramEmojiInfo1.field_groupId;
    paramEmojiInfo2.field_externUrl = paramEmojiInfo1.field_externUrl;
    paramEmojiInfo2.field_externMd5 = paramEmojiInfo1.field_externMd5;
    paramEmojiInfo2.field_activityid = paramEmojiInfo1.field_activityid;
    paramEmojiInfo2.field_attachedText = paramEmojiInfo1.field_attachedText;
    paramEmojiInfo2.field_attachTextColor = paramEmojiInfo1.field_attachTextColor;
    paramEmojiInfo2.field_lensId = paramEmojiInfo1.field_lensId;
  }
  
  public static void a(String paramString, JSONObject paramJSONObject, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(269765);
    try
    {
      if (!Util.isNullOrNil(paramEmojiInfo.field_md5))
      {
        boolean bool = paramEmojiInfo.field_md5.equals(paramJSONObject.getString("md5"));
        if (!bool)
        {
          AppMethodBeat.o(269765);
          return;
        }
      }
      paramEmojiInfo.field_md5 = gP(paramJSONObject.optString("md5", ""), paramEmojiInfo.field_md5);
      paramEmojiInfo.field_cdnUrl = gP(paramJSONObject.optString("productUrl", ""), paramEmojiInfo.field_cdnUrl);
      paramEmojiInfo.field_thumbUrl = gP(paramJSONObject.optString("thumb", ""), paramEmojiInfo.field_thumbUrl);
      paramEmojiInfo.field_encrypturl = gP(paramJSONObject.optString("encryptUrl", ""), paramEmojiInfo.field_encrypturl);
      paramEmojiInfo.field_aeskey = gP(paramJSONObject.optString("aesKey", ""), paramEmojiInfo.field_aeskey);
      paramEmojiInfo.field_groupId = gP(paramJSONObject.optString("productID", ""), paramEmojiInfo.field_groupId);
      paramEmojiInfo.akmc = gP(paramJSONObject.optString("productName", ""), paramEmojiInfo.akmc);
      paramEmojiInfo.field_catalog = EmojiInfo.aklG;
      if ((com.tencent.matrix.trace.f.c.hm(paramEmojiInfo.field_cdnUrl)) && (com.tencent.matrix.trace.f.c.hm(paramEmojiInfo.field_aeskey))) {
        paramEmojiInfo.field_cdnUrl = paramEmojiInfo.field_encrypturl;
      }
      AppMethodBeat.o(269765);
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.printErrStackTrace(paramString, paramJSONObject, "convertEmojiInfo", new Object[0]);
      AppMethodBeat.o(269765);
    }
  }
  
  public static boolean apb(String paramString)
  {
    AppMethodBeat.i(104580);
    if ((!Util.isNullOrNil(paramString)) && (!Util.isEqual(paramString, "capture")) && (!Util.isEqual(paramString, EmojiGroupInfo.aklD)))
    {
      AppMethodBeat.o(104580);
      return true;
    }
    AppMethodBeat.o(104580);
    return false;
  }
  
  public static boolean apc(String paramString)
  {
    AppMethodBeat.i(269806);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(269806);
      return false;
    }
    boolean bool = ydI.contains(paramString);
    AppMethodBeat.o(269806);
    return bool;
  }
  
  public static boolean apd(String paramString)
  {
    AppMethodBeat.i(269808);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(269808);
      return false;
    }
    if ((Util.isEqual(paramString, "9bd1281af3a31710a45b84d736363691")) || (Util.isEqual(paramString, "08f223fa83f1ca34e143d1e580252c7c")))
    {
      AppMethodBeat.o(269808);
      return true;
    }
    AppMethodBeat.o(269808);
    return false;
  }
  
  public static boolean ape(String paramString)
  {
    AppMethodBeat.i(104583);
    if ((!Util.isNullOrNil(paramString)) && (!Util.isEqual(paramString, "capture")))
    {
      AppMethodBeat.o(104583);
      return true;
    }
    AppMethodBeat.o(104583);
    return false;
  }
  
  public static String apf(String paramString)
  {
    AppMethodBeat.i(269820);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(269820);
      return null;
    }
    r localr = QQSmileyManager.iVq().l(paramString, 0);
    if ((localr != null) && (Util.isEqual(localr.text, paramString)))
    {
      paramString = localr.key;
      AppMethodBeat.o(269820);
      return paramString;
    }
    if (com.tencent.mm.smiley.o.iVl().containsKey(paramString))
    {
      AppMethodBeat.o(269820);
      return paramString;
    }
    AppMethodBeat.o(269820);
    return null;
  }
  
  public static String apg(String paramString)
  {
    AppMethodBeat.i(269825);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(269825);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramString.length())
    {
      r localr = QQSmileyManager.iVq().l(paramString, i);
      if (localr != null) {
        localLinkedList.add(localr);
      }
      i += 1;
    }
    if (localLinkedList.size() == 1)
    {
      paramString = ((r)localLinkedList.get(0)).key;
      AppMethodBeat.o(269825);
      return paramString;
    }
    AppMethodBeat.o(269825);
    return null;
  }
  
  public static Drawable aph(String paramString)
  {
    AppMethodBeat.i(269827);
    com.tencent.mm.smiley.o.iVl();
    paramString = com.tencent.mm.smiley.o.buC(paramString);
    AppMethodBeat.o(269827);
    return paramString;
  }
  
  public static void b(bk parambk, EmojiInfo paramEmojiInfo)
  {
    int j = 1;
    AppMethodBeat.i(162344);
    paramEmojiInfo.field_md5 = gP(parambk.md5, paramEmojiInfo.field_md5);
    paramEmojiInfo.field_svrid = gP(parambk.id, paramEmojiInfo.field_svrid);
    paramEmojiInfo.field_type = parambk.adji;
    paramEmojiInfo.field_size = parambk.adjj;
    paramEmojiInfo.field_groupId = gP(parambk.productId, paramEmojiInfo.field_groupId);
    paramEmojiInfo.field_designerID = gP(parambk.adjn, paramEmojiInfo.field_designerID);
    paramEmojiInfo.field_thumbUrl = gP(parambk.thumbUrl, paramEmojiInfo.field_thumbUrl);
    paramEmojiInfo.field_cdnUrl = gP(parambk.mOI, paramEmojiInfo.field_cdnUrl);
    paramEmojiInfo.field_encrypturl = gP(parambk.hIp, paramEmojiInfo.field_encrypturl);
    paramEmojiInfo.field_width = parambk.width;
    paramEmojiInfo.field_height = parambk.height;
    paramEmojiInfo.field_externUrl = gP(parambk.adjo, paramEmojiInfo.field_externUrl);
    paramEmojiInfo.field_externMd5 = gP(parambk.adjp, paramEmojiInfo.field_externMd5);
    paramEmojiInfo.field_activityid = gP(parambk.adjr, paramEmojiInfo.field_activityid);
    paramEmojiInfo.field_tpurl = gP(parambk.tpurl, paramEmojiInfo.field_tpurl);
    paramEmojiInfo.field_tpauthkey = gP(parambk.nRn, paramEmojiInfo.field_tpauthkey);
    int i;
    if ((!Util.isNullOrNil(paramEmojiInfo.field_externUrl)) || (!Util.isNullOrNil(paramEmojiInfo.field_encrypturl)) || (!Util.isNullOrNil(paramEmojiInfo.field_cdnUrl)))
    {
      i = 1;
      if (Util.isNullOrNil(parambk.tpurl)) {
        break label357;
      }
    }
    for (;;)
    {
      if ((j == 0) || (i == 0)) {
        paramEmojiInfo.field_aeskey = gP(parambk.aeskey, paramEmojiInfo.field_aeskey);
      }
      paramEmojiInfo.field_attachedText = gP(parambk.ygi, paramEmojiInfo.field_attachedText);
      paramEmojiInfo.field_lensId = gP(parambk.ygo, paramEmojiInfo.field_lensId);
      paramEmojiInfo.field_attachTextColor = gP(parambk.adjt, paramEmojiInfo.field_attachTextColor);
      paramEmojiInfo.field_linkId = gP(parambk.adjs, paramEmojiInfo.field_linkId);
      AppMethodBeat.o(162344);
      return;
      i = 0;
      break;
      label357:
      j = 0;
    }
  }
  
  public static int bH(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4)) {
      return EmojiInfo.aklC;
    }
    if ((paramArrayOfByte[1] == 80) && (paramArrayOfByte[2] == 78) && (paramArrayOfByte[3] == 71)) {
      return EmojiInfo.aklN;
    }
    if ((paramArrayOfByte[0] == 71) && (paramArrayOfByte[1] == 73) && (paramArrayOfByte[2] == 70)) {
      return EmojiInfo.aklO;
    }
    if ((paramArrayOfByte[6] == 74) && (paramArrayOfByte[7] == 70) && (paramArrayOfByte[8] == 73) && (paramArrayOfByte[9] == 70)) {
      return EmojiInfo.aklP;
    }
    return EmojiInfo.aklC;
  }
  
  public static String bzQ()
  {
    AppMethodBeat.i(185734);
    Object localObject = com.tencent.mm.emoji.f.c.moq;
    localObject = com.tencent.mm.emoji.f.c.aWA();
    AppMethodBeat.o(185734);
    return localObject;
  }
  
  public static void dDu()
  {
    AppMethodBeat.i(269831);
    Object localObject = m.mhY;
    if (m.getKV().getBoolean("game_to_custom", false))
    {
      Log.i("MicroMsg.EmojiUtils", "gameToCustom: done");
      AppMethodBeat.o(269831);
      return;
    }
    localObject = bl.jba().adju.bza("9bd1281af3a31710a45b84d736363691");
    final EmojiInfo localEmojiInfo = bl.jba().adju.bza("08f223fa83f1ca34e143d1e580252c7c");
    if ((localObject == null) || (localEmojiInfo == null))
    {
      Log.i("MicroMsg.EmojiUtils", "gameToCustom: no game emoji!");
      AppMethodBeat.o(269831);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("9bd1281af3a31710a45b84d736363691");
    localArrayList.add("08f223fa83f1ca34e143d1e580252c7c");
    new b(0, 1, localArrayList).bFJ().g(new a() {});
    AppMethodBeat.o(269831);
  }
  
  public static String gP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104578);
    if (Util.isNullOrNil(paramString1))
    {
      if (paramString2 == null)
      {
        AppMethodBeat.o(104578);
        return "";
      }
      AppMethodBeat.o(104578);
      return paramString2;
    }
    AppMethodBeat.o(104578);
    return paramString1;
  }
  
  public static boolean lr(long paramLong)
  {
    AppMethodBeat.i(269818);
    Object localObject = bl.jba().adju.zf(paramLong);
    if ((localObject != null) && (((EmojiInfo)localObject).kMj() == EmojiInfo.a.admi)) {
      localObject = ((EmojiInfo)localObject).kMl();
    }
    switch (2.ydL[localObject.ordinal()])
    {
    default: 
      AppMethodBeat.o(269818);
      return false;
    }
    AppMethodBeat.o(269818);
    return true;
  }
  
  public static boolean w(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(269790);
    if (paramEmojiInfo == null)
    {
      AppMethodBeat.o(269790);
      return false;
    }
    if (!Util.isNullOrNil(paramEmojiInfo.field_cdnUrl))
    {
      AppMethodBeat.o(269790);
      return true;
    }
    AppMethodBeat.o(269790);
    return false;
  }
  
  public static boolean x(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104579);
    if ((paramEmojiInfo != null) && (apb(paramEmojiInfo.field_groupId)))
    {
      AppMethodBeat.o(104579);
      return true;
    }
    AppMethodBeat.o(104579);
    return false;
  }
  
  public static boolean y(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(183923);
    if (paramEmojiInfo.field_catalog == EmojiInfo.aklM)
    {
      AppMethodBeat.o(183923);
      return true;
    }
    Object localObject = l.aUF().aUG();
    if (localObject == null)
    {
      AppMethodBeat.o(183923);
      return false;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (Util.isEqual(((EmojiInfo)((Iterator)localObject).next()).field_md5, paramEmojiInfo.field_md5))
      {
        AppMethodBeat.o(183923);
        return true;
      }
    }
    AppMethodBeat.o(183923);
    return false;
  }
  
  public static boolean z(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104581);
    boolean bool = Util.isEqual(paramEmojiInfo.field_groupId, "capture");
    AppMethodBeat.o(104581);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.d
 * JD-Core Version:    0.7.0.1
 */