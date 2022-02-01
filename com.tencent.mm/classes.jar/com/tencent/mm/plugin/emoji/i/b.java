package com.tencent.mm.plugin.emoji.i;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.cl.g;
import com.tencent.mm.cl.g.b;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.emoji.b.l;
import com.tencent.mm.emoji.b.o;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.protocal.protobuf.ia;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class b
{
  public static final ArrayList<String> uQU;
  
  static
  {
    AppMethodBeat.i(225798);
    ArrayList localArrayList = new ArrayList();
    uQU = localArrayList;
    localArrayList.add("9bd1281af3a31710a45b84d736363691");
    uQU.add("08f223fa83f1ca34e143d1e580252c7c");
    AppMethodBeat.o(225798);
  }
  
  public static boolean A(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(225786);
    if (paramEmojiInfo == null)
    {
      AppMethodBeat.o(225786);
      return false;
    }
    boolean bool = avd(paramEmojiInfo.getMd5());
    AppMethodBeat.o(225786);
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
    if (!o.aCd())
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
  
  public static boolean IV(long paramLong)
  {
    AppMethodBeat.i(225789);
    Object localObject = bj.hyV().VFH.UX(paramLong);
    if ((localObject != null) && (((EmojiInfo)localObject).hBB() == EmojiInfo.a.VIm)) {
      localObject = ((EmojiInfo)localObject).hBE();
    }
    switch (2.uQX[localObject.ordinal()])
    {
    default: 
      AppMethodBeat.o(225789);
      return false;
    }
    AppMethodBeat.o(225789);
    return true;
  }
  
  public static void a(aji paramaji, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104577);
    if ((!Util.isNullOrNil(paramEmojiInfo.field_md5)) && (!paramEmojiInfo.field_md5.equals(paramaji.Md5)))
    {
      AppMethodBeat.o(104577);
      return;
    }
    paramEmojiInfo.field_md5 = gk(paramaji.Md5, paramEmojiInfo.field_md5);
    paramEmojiInfo.field_cdnUrl = gk(paramaji.Url, paramEmojiInfo.field_cdnUrl);
    paramEmojiInfo.field_thumbUrl = gk(paramaji.ThumbUrl, paramEmojiInfo.field_thumbUrl);
    paramEmojiInfo.field_designerID = gk(paramaji.DesignerID, paramEmojiInfo.field_designerID);
    paramEmojiInfo.field_encrypturl = gk(paramaji.EncryptUrl, paramEmojiInfo.field_encrypturl);
    paramEmojiInfo.field_aeskey = gk(paramaji.AesKey, paramEmojiInfo.field_aeskey);
    paramEmojiInfo.field_groupId = gk(paramaji.ProductID, paramEmojiInfo.field_groupId);
    paramEmojiInfo.field_externUrl = gk(paramaji.ExternUrl, paramEmojiInfo.field_externUrl);
    paramEmojiInfo.field_externMd5 = gk(paramaji.ExternMd5, paramEmojiInfo.field_externMd5);
    paramEmojiInfo.field_activityid = gk(paramaji.ActivityID, paramEmojiInfo.field_activityid);
    paramEmojiInfo.field_attachedText = gk(paramaji.AttachedText, paramEmojiInfo.field_attachedText);
    paramEmojiInfo.field_attachTextColor = gk(paramaji.AttachedTextColor, paramEmojiInfo.field_attachTextColor);
    paramEmojiInfo.field_lensId = gk(paramaji.LensId, paramEmojiInfo.field_lensId);
    paramEmojiInfo.field_linkId = gk(paramaji.StN, paramEmojiInfo.field_linkId);
    AppMethodBeat.o(104577);
  }
  
  public static void a(aji paramaji, EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(225770);
    a(paramaji, paramEmojiInfo);
    paramEmojiInfo.UaI = paramString;
    AppMethodBeat.o(225770);
  }
  
  public static void a(EmojiInfo paramEmojiInfo, aji paramaji)
  {
    AppMethodBeat.i(225764);
    if ((!Util.isNullOrNil(paramaji.Md5)) && (!paramaji.Md5.equals(paramEmojiInfo.field_md5)))
    {
      AppMethodBeat.o(225764);
      return;
    }
    paramaji.Md5 = gk(paramEmojiInfo.field_md5, paramaji.Md5);
    paramaji.Md5 = gk(paramaji.Md5, "");
    paramaji.Url = gk(paramEmojiInfo.field_cdnUrl, paramaji.Url);
    paramaji.ThumbUrl = gk(paramEmojiInfo.field_thumbUrl, paramaji.ThumbUrl);
    paramaji.DesignerID = gk(paramEmojiInfo.field_designerID, paramaji.DesignerID);
    paramaji.EncryptUrl = gk(paramEmojiInfo.field_encrypturl, paramaji.EncryptUrl);
    paramaji.AesKey = gk(paramEmojiInfo.field_aeskey, paramaji.AesKey);
    paramaji.ProductID = gk(paramEmojiInfo.field_groupId, paramaji.ProductID);
    paramaji.ExternUrl = gk(paramEmojiInfo.field_externUrl, paramaji.ExternUrl);
    paramaji.ExternMd5 = gk(paramEmojiInfo.field_externMd5, paramaji.ExternMd5);
    paramaji.ActivityID = gk(paramEmojiInfo.field_activityid, paramaji.ActivityID);
    paramaji.AttachedText = gk(paramEmojiInfo.field_attachedText, paramaji.AttachedText);
    paramaji.AttachedTextColor = gk(paramEmojiInfo.field_attachTextColor, paramaji.AttachedTextColor);
    paramaji.LensId = gk(paramEmojiInfo.field_lensId, paramaji.LensId);
    paramaji.StN = gk(paramEmojiInfo.field_linkId, paramaji.StN);
    AppMethodBeat.o(225764);
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
    AppMethodBeat.i(225758);
    try
    {
      if (!Util.isNullOrNil(paramEmojiInfo.field_md5))
      {
        boolean bool = paramEmojiInfo.field_md5.equals(paramJSONObject.getString("md5"));
        if (!bool)
        {
          AppMethodBeat.o(225758);
          return;
        }
      }
      paramEmojiInfo.field_md5 = gk(paramJSONObject.optString("md5", ""), paramEmojiInfo.field_md5);
      paramEmojiInfo.field_cdnUrl = gk(paramJSONObject.optString("productUrl", ""), paramEmojiInfo.field_cdnUrl);
      paramEmojiInfo.field_thumbUrl = gk(paramJSONObject.optString("thumb", ""), paramEmojiInfo.field_thumbUrl);
      paramEmojiInfo.field_encrypturl = gk(paramJSONObject.optString("encryptUrl", ""), paramEmojiInfo.field_encrypturl);
      paramEmojiInfo.field_aeskey = gk(paramJSONObject.optString("aesKey", ""), paramEmojiInfo.field_aeskey);
      paramEmojiInfo.field_groupId = gk(paramJSONObject.optString("productID", ""), paramEmojiInfo.field_groupId);
      paramEmojiInfo.ZuN = gk(paramJSONObject.optString("productName", ""), paramEmojiInfo.ZuN);
      paramEmojiInfo.field_catalog = EmojiInfo.YCx;
      if ((com.tencent.matrix.trace.g.b.fK(paramEmojiInfo.field_cdnUrl)) && (com.tencent.matrix.trace.g.b.fK(paramEmojiInfo.field_aeskey))) {
        paramEmojiInfo.field_cdnUrl = paramEmojiInfo.field_encrypturl;
      }
      AppMethodBeat.o(225758);
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.printErrStackTrace(paramString, paramJSONObject, "convertEmojiInfo", new Object[0]);
      AppMethodBeat.o(225758);
    }
  }
  
  public static boolean avb(String paramString)
  {
    AppMethodBeat.i(104580);
    if ((!Util.isNullOrNil(paramString)) && (!Util.isEqual(paramString, "capture")) && (!Util.isEqual(paramString, EmojiGroupInfo.YCu)))
    {
      AppMethodBeat.o(104580);
      return true;
    }
    AppMethodBeat.o(104580);
    return false;
  }
  
  public static boolean avc(String paramString)
  {
    AppMethodBeat.i(225784);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(225784);
      return false;
    }
    boolean bool = uQU.contains(paramString);
    AppMethodBeat.o(225784);
    return bool;
  }
  
  public static boolean avd(String paramString)
  {
    AppMethodBeat.i(225785);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(225785);
      return false;
    }
    if ((Util.isEqual(paramString, "9bd1281af3a31710a45b84d736363691")) || (Util.isEqual(paramString, "08f223fa83f1ca34e143d1e580252c7c")))
    {
      AppMethodBeat.o(225785);
      return true;
    }
    AppMethodBeat.o(225785);
    return false;
  }
  
  public static boolean ave(String paramString)
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
  
  public static String avf(String paramString)
  {
    AppMethodBeat.i(225791);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(225791);
      return null;
    }
    g.b localb = g.htS().o(paramString, 0);
    if ((localb != null) && (Util.isEqual(localb.text, paramString)))
    {
      paramString = localb.key;
      AppMethodBeat.o(225791);
      return paramString;
    }
    if (com.tencent.mm.cl.f.htQ().containsKey(paramString))
    {
      AppMethodBeat.o(225791);
      return paramString;
    }
    AppMethodBeat.o(225791);
    return null;
  }
  
  public static String avg(String paramString)
  {
    AppMethodBeat.i(225794);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(225794);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramString.length())
    {
      g.b localb = g.htS().o(paramString, i);
      if (localb != null) {
        localLinkedList.add(localb);
      }
      i += 1;
    }
    if (localLinkedList.size() == 1)
    {
      paramString = ((g.b)localLinkedList.get(0)).key;
      AppMethodBeat.o(225794);
      return paramString;
    }
    AppMethodBeat.o(225794);
    return null;
  }
  
  public static Drawable avh(String paramString)
  {
    AppMethodBeat.i(225795);
    com.tencent.mm.cl.f.htQ();
    paramString = com.tencent.mm.cl.f.buv(paramString);
    AppMethodBeat.o(225795);
    return paramString;
  }
  
  public static void b(bi parambi, EmojiInfo paramEmojiInfo)
  {
    int j = 1;
    AppMethodBeat.i(162344);
    paramEmojiInfo.field_md5 = gk(parambi.md5, paramEmojiInfo.field_md5);
    paramEmojiInfo.field_svrid = gk(parambi.id, paramEmojiInfo.field_svrid);
    paramEmojiInfo.field_type = parambi.VFv;
    paramEmojiInfo.field_size = parambi.VFw;
    paramEmojiInfo.field_groupId = gk(parambi.productId, paramEmojiInfo.field_groupId);
    paramEmojiInfo.field_designerID = gk(parambi.VFA, paramEmojiInfo.field_designerID);
    paramEmojiInfo.field_thumbUrl = gk(parambi.thumbUrl, paramEmojiInfo.field_thumbUrl);
    paramEmojiInfo.field_cdnUrl = gk(parambi.smT, paramEmojiInfo.field_cdnUrl);
    paramEmojiInfo.field_encrypturl = gk(parambi.fDz, paramEmojiInfo.field_encrypturl);
    paramEmojiInfo.field_width = parambi.width;
    paramEmojiInfo.field_height = parambi.height;
    paramEmojiInfo.field_externUrl = gk(parambi.VFB, paramEmojiInfo.field_externUrl);
    paramEmojiInfo.field_externMd5 = gk(parambi.VFC, paramEmojiInfo.field_externMd5);
    paramEmojiInfo.field_activityid = gk(parambi.VFE, paramEmojiInfo.field_activityid);
    paramEmojiInfo.field_tpurl = gk(parambi.lmc, paramEmojiInfo.field_tpurl);
    paramEmojiInfo.field_tpauthkey = gk(parambi.lmi, paramEmojiInfo.field_tpauthkey);
    int i;
    if ((!Util.isNullOrNil(paramEmojiInfo.field_externUrl)) || (!Util.isNullOrNil(paramEmojiInfo.field_encrypturl)) || (!Util.isNullOrNil(paramEmojiInfo.field_cdnUrl)))
    {
      i = 1;
      if (Util.isNullOrNil(parambi.lmc)) {
        break label357;
      }
    }
    for (;;)
    {
      if ((j == 0) || (i == 0)) {
        paramEmojiInfo.field_aeskey = gk(parambi.aeskey, paramEmojiInfo.field_aeskey);
      }
      paramEmojiInfo.field_attachedText = gk(parambi.jIv, paramEmojiInfo.field_attachedText);
      paramEmojiInfo.field_lensId = gk(parambi.uTz, paramEmojiInfo.field_lensId);
      paramEmojiInfo.field_attachTextColor = gk(parambi.VFG, paramEmojiInfo.field_attachTextColor);
      paramEmojiInfo.field_linkId = gk(parambi.VFF, paramEmojiInfo.field_linkId);
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
      return EmojiInfo.YCt;
    }
    if ((paramArrayOfByte[1] == 80) && (paramArrayOfByte[2] == 78) && (paramArrayOfByte[3] == 71)) {
      return EmojiInfo.YCE;
    }
    if ((paramArrayOfByte[0] == 71) && (paramArrayOfByte[1] == 73) && (paramArrayOfByte[2] == 70)) {
      return EmojiInfo.YCF;
    }
    if ((paramArrayOfByte[6] == 74) && (paramArrayOfByte[7] == 70) && (paramArrayOfByte[8] == 73) && (paramArrayOfByte[9] == 70)) {
      return EmojiInfo.ZuA;
    }
    return EmojiInfo.YCt;
  }
  
  public static String bcb()
  {
    AppMethodBeat.i(185734);
    Object localObject = com.tencent.mm.emoji.e.a.jPz;
    localObject = com.tencent.mm.emoji.e.a.aDB();
    AppMethodBeat.o(185734);
    return localObject;
  }
  
  public static void cXa()
  {
    AppMethodBeat.i(225797);
    Object localObject = l.jIq;
    if (l.getKV().getBoolean("game_to_custom", false))
    {
      Log.i("MicroMsg.EmojiUtils", "gameToCustom: done");
      AppMethodBeat.o(225797);
      return;
    }
    localObject = bj.hyV().VFH.bxK("9bd1281af3a31710a45b84d736363691");
    final EmojiInfo localEmojiInfo = bj.hyV().VFH.bxK("08f223fa83f1ca34e143d1e580252c7c");
    if ((localObject == null) || (localEmojiInfo == null))
    {
      Log.i("MicroMsg.EmojiUtils", "gameToCustom: no game emoji!");
      AppMethodBeat.o(225797);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("9bd1281af3a31710a45b84d736363691");
    localArrayList.add("08f223fa83f1ca34e143d1e580252c7c");
    new com.tencent.mm.emoji.sync.b(0, 1, localArrayList).bhW().g(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(225797);
  }
  
  private static String gk(String paramString1, String paramString2)
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
  
  public static boolean w(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(225780);
    if (paramEmojiInfo == null)
    {
      AppMethodBeat.o(225780);
      return false;
    }
    if (!Util.isNullOrNil(paramEmojiInfo.field_cdnUrl))
    {
      AppMethodBeat.o(225780);
      return true;
    }
    AppMethodBeat.o(225780);
    return false;
  }
  
  public static boolean x(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104579);
    if ((paramEmojiInfo != null) && (avb(paramEmojiInfo.field_groupId)))
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
    if (paramEmojiInfo.field_catalog == EmojiInfo.YCD)
    {
      AppMethodBeat.o(183923);
      return true;
    }
    Object localObject = k.aBH().aBK();
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
 * Qualified Name:     com.tencent.mm.plugin.emoji.i.b
 * JD-Core Version:    0.7.0.1
 */