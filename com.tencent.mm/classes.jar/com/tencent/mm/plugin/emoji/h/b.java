package com.tencent.mm.plugin.emoji.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.emoji.a.m;
import com.tencent.mm.emoji.d.a;
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public static boolean YC(String paramString)
  {
    AppMethodBeat.i(104580);
    if ((!bs.isNullOrNil(paramString)) && (!bs.lr(paramString, "capture")) && (!bs.lr(paramString, EmojiGroupInfo.Jsp)))
    {
      AppMethodBeat.o(104580);
      return true;
    }
    AppMethodBeat.o(104580);
    return false;
  }
  
  public static boolean YD(String paramString)
  {
    AppMethodBeat.i(104583);
    if ((!bs.isNullOrNil(paramString)) && (!bs.lr(paramString, "capture")))
    {
      AppMethodBeat.o(104583);
      return true;
    }
    AppMethodBeat.o(104583);
    return false;
  }
  
  public static void a(ads paramads, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104577);
    if ((!bs.isNullOrNil(paramEmojiInfo.field_md5)) && (!paramEmojiInfo.field_md5.equals(paramads.Md5)))
    {
      AppMethodBeat.o(104577);
      return;
    }
    paramEmojiInfo.field_md5 = fq(paramads.Md5, paramEmojiInfo.field_md5);
    paramEmojiInfo.field_cdnUrl = fq(paramads.Url, paramEmojiInfo.field_cdnUrl);
    paramEmojiInfo.field_thumbUrl = fq(paramads.ThumbUrl, paramEmojiInfo.field_thumbUrl);
    paramEmojiInfo.field_designerID = fq(paramads.Ewv, paramEmojiInfo.field_designerID);
    paramEmojiInfo.field_encrypturl = fq(paramads.EncryptUrl, paramEmojiInfo.field_encrypturl);
    paramEmojiInfo.field_aeskey = fq(paramads.AesKey, paramEmojiInfo.field_aeskey);
    paramEmojiInfo.field_groupId = fq(paramads.ProductID, paramEmojiInfo.field_groupId);
    paramEmojiInfo.field_externUrl = fq(paramads.ExternUrl, paramEmojiInfo.field_externUrl);
    paramEmojiInfo.field_externMd5 = fq(paramads.ExternMd5, paramEmojiInfo.field_externMd5);
    paramEmojiInfo.field_activityid = fq(paramads.ActivityID, paramEmojiInfo.field_activityid);
    paramEmojiInfo.field_attachedText = fq(paramads.Eww, paramEmojiInfo.field_attachedText);
    paramEmojiInfo.field_attachTextColor = fq(paramads.Ewx, paramEmojiInfo.field_attachTextColor);
    paramEmojiInfo.field_lensId = fq(paramads.Ewy, paramEmojiInfo.field_lensId);
    AppMethodBeat.o(104577);
  }
  
  public static void a(JSONObject paramJSONObject, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104576);
    try
    {
      if (!bs.isNullOrNil(paramEmojiInfo.field_md5))
      {
        boolean bool = paramEmojiInfo.field_md5.equals(paramJSONObject.getString("md5"));
        if (!bool)
        {
          AppMethodBeat.o(104576);
          return;
        }
      }
      paramEmojiInfo.field_md5 = fq(paramJSONObject.optString("md5", ""), paramEmojiInfo.field_md5);
      paramEmojiInfo.field_cdnUrl = fq(paramJSONObject.optString("productUrl", ""), paramEmojiInfo.field_cdnUrl);
      paramEmojiInfo.field_thumbUrl = fq(paramJSONObject.optString("thumb", ""), paramEmojiInfo.field_thumbUrl);
      paramEmojiInfo.field_encrypturl = fq(paramJSONObject.optString("encryptUrl", ""), paramEmojiInfo.field_encrypturl);
      paramEmojiInfo.field_aeskey = fq(paramJSONObject.optString("aesKey", ""), paramEmojiInfo.field_aeskey);
      paramEmojiInfo.field_groupId = fq(paramJSONObject.optString("productID", ""), paramEmojiInfo.field_groupId);
      paramEmojiInfo.Kgn = fq(paramJSONObject.optString("productName", ""), paramEmojiInfo.Kgn);
      paramEmojiInfo.field_catalog = EmojiInfo.Jss;
      if ((com.tencent.matrix.trace.g.b.cX(paramEmojiInfo.field_cdnUrl)) && (com.tencent.matrix.trace.g.b.cX(paramEmojiInfo.field_aeskey))) {
        paramEmojiInfo.field_cdnUrl = paramEmojiInfo.field_encrypturl;
      }
      AppMethodBeat.o(104576);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      AppMethodBeat.o(104576);
    }
  }
  
  public static int aV(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4)) {
      return EmojiInfo.Jso;
    }
    if ((paramArrayOfByte[1] == 80) && (paramArrayOfByte[2] == 78) && (paramArrayOfByte[3] == 71)) {
      return EmojiInfo.KfY;
    }
    if ((paramArrayOfByte[0] == 71) && (paramArrayOfByte[1] == 73) && (paramArrayOfByte[2] == 70)) {
      return EmojiInfo.KfZ;
    }
    if ((paramArrayOfByte[6] == 74) && (paramArrayOfByte[7] == 70) && (paramArrayOfByte[8] == 73) && (paramArrayOfByte[9] == 70)) {
      return EmojiInfo.Kga;
    }
    return EmojiInfo.Jso;
  }
  
  public static String awQ()
  {
    AppMethodBeat.i(210508);
    Object localObject = a.fWM;
    localObject = a.adJ();
    AppMethodBeat.o(210508);
    return localObject;
  }
  
  public static void b(ay paramay, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(162344);
    paramEmojiInfo.field_md5 = fq(paramay.md5, paramEmojiInfo.field_md5);
    paramEmojiInfo.field_svrid = fq(paramay.id, paramEmojiInfo.field_svrid);
    paramEmojiInfo.field_type = paramay.GXO;
    paramEmojiInfo.field_size = paramay.GXP;
    paramEmojiInfo.field_groupId = fq(paramay.dcO, paramEmojiInfo.field_groupId);
    paramEmojiInfo.field_designerID = fq(paramay.GXT, paramEmojiInfo.field_designerID);
    paramEmojiInfo.field_thumbUrl = fq(paramay.thumbUrl, paramEmojiInfo.field_thumbUrl);
    paramEmojiInfo.field_cdnUrl = fq(paramay.gnO, paramEmojiInfo.field_cdnUrl);
    paramEmojiInfo.field_encrypturl = fq(paramay.dgX, paramEmojiInfo.field_encrypturl);
    paramEmojiInfo.field_aeskey = fq(paramay.aeskey, paramEmojiInfo.field_aeskey);
    paramEmojiInfo.field_width = paramay.width;
    paramEmojiInfo.field_height = paramay.height;
    paramEmojiInfo.field_externUrl = fq(paramay.GXU, paramEmojiInfo.field_externUrl);
    paramEmojiInfo.field_externMd5 = fq(paramay.GXV, paramEmojiInfo.field_externMd5);
    paramEmojiInfo.field_activityid = fq(paramay.GXX, paramEmojiInfo.field_activityid);
    paramEmojiInfo.field_tpurl = fq(paramay.hhL, paramEmojiInfo.field_tpurl);
    paramEmojiInfo.field_tpauthkey = fq(paramay.hhR, paramEmojiInfo.field_tpauthkey);
    paramEmojiInfo.field_attachedText = fq(paramay.fQL, paramEmojiInfo.field_attachedText);
    paramEmojiInfo.field_lensId = fq(paramay.pmO, paramEmojiInfo.field_lensId);
    paramEmojiInfo.field_attachTextColor = fq(paramay.GXY, paramEmojiInfo.field_attachTextColor);
    AppMethodBeat.o(162344);
  }
  
  public static String fq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104578);
    if (bs.isNullOrNil(paramString1))
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
    AppMethodBeat.i(104579);
    if ((paramEmojiInfo != null) && (YC(paramEmojiInfo.field_groupId)))
    {
      AppMethodBeat.o(104579);
      return true;
    }
    AppMethodBeat.o(104579);
    return false;
  }
  
  public static boolean x(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(183923);
    if (paramEmojiInfo.field_catalog == EmojiInfo.Jsy)
    {
      AppMethodBeat.o(183923);
      return true;
    }
    Object localObject = i.ach().dh(true);
    if (localObject == null)
    {
      AppMethodBeat.o(183923);
      return false;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (bs.lr(((EmojiInfo)((Iterator)localObject).next()).field_md5, paramEmojiInfo.field_md5))
      {
        AppMethodBeat.o(183923);
        return true;
      }
    }
    AppMethodBeat.o(183923);
    return false;
  }
  
  public static boolean y(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104581);
    boolean bool = bs.lr(paramEmojiInfo.field_groupId, "capture");
    AppMethodBeat.o(104581);
    return bool;
  }
  
  public static boolean z(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104582);
    if (paramEmojiInfo == null)
    {
      AppMethodBeat.o(104582);
      return false;
    }
    if (!m.acC())
    {
      AppMethodBeat.o(104582);
      return false;
    }
    if ((y(paramEmojiInfo)) || ((paramEmojiInfo.field_activityid != null) && (paramEmojiInfo.field_activityid.startsWith("Selfie"))))
    {
      AppMethodBeat.o(104582);
      return true;
    }
    AppMethodBeat.o(104582);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.h.b
 * JD-Core Version:    0.7.0.1
 */