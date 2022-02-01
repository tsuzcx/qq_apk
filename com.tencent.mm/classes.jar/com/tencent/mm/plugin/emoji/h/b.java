package com.tencent.mm.plugin.emoji.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.emoji.a.m;
import com.tencent.mm.emoji.d.a;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public static void a(agb paramagb, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104577);
    if ((!bt.isNullOrNil(paramEmojiInfo.field_md5)) && (!paramEmojiInfo.field_md5.equals(paramagb.Md5)))
    {
      AppMethodBeat.o(104577);
      return;
    }
    paramEmojiInfo.field_md5 = fA(paramagb.Md5, paramEmojiInfo.field_md5);
    paramEmojiInfo.field_cdnUrl = fA(paramagb.Url, paramEmojiInfo.field_cdnUrl);
    paramEmojiInfo.field_thumbUrl = fA(paramagb.ThumbUrl, paramEmojiInfo.field_thumbUrl);
    paramEmojiInfo.field_designerID = fA(paramagb.GdY, paramEmojiInfo.field_designerID);
    paramEmojiInfo.field_encrypturl = fA(paramagb.EncryptUrl, paramEmojiInfo.field_encrypturl);
    paramEmojiInfo.field_aeskey = fA(paramagb.AesKey, paramEmojiInfo.field_aeskey);
    paramEmojiInfo.field_groupId = fA(paramagb.ProductID, paramEmojiInfo.field_groupId);
    paramEmojiInfo.field_externUrl = fA(paramagb.ExternUrl, paramEmojiInfo.field_externUrl);
    paramEmojiInfo.field_externMd5 = fA(paramagb.ExternMd5, paramEmojiInfo.field_externMd5);
    paramEmojiInfo.field_activityid = fA(paramagb.ActivityID, paramEmojiInfo.field_activityid);
    paramEmojiInfo.field_attachedText = fA(paramagb.GdZ, paramEmojiInfo.field_attachedText);
    paramEmojiInfo.field_attachTextColor = fA(paramagb.Gea, paramEmojiInfo.field_attachTextColor);
    paramEmojiInfo.field_lensId = fA(paramagb.Geb, paramEmojiInfo.field_lensId);
    AppMethodBeat.o(104577);
  }
  
  public static void a(JSONObject paramJSONObject, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104576);
    try
    {
      if (!bt.isNullOrNil(paramEmojiInfo.field_md5))
      {
        boolean bool = paramEmojiInfo.field_md5.equals(paramJSONObject.getString("md5"));
        if (!bool)
        {
          AppMethodBeat.o(104576);
          return;
        }
      }
      paramEmojiInfo.field_md5 = fA(paramJSONObject.optString("md5", ""), paramEmojiInfo.field_md5);
      paramEmojiInfo.field_cdnUrl = fA(paramJSONObject.optString("productUrl", ""), paramEmojiInfo.field_cdnUrl);
      paramEmojiInfo.field_thumbUrl = fA(paramJSONObject.optString("thumb", ""), paramEmojiInfo.field_thumbUrl);
      paramEmojiInfo.field_encrypturl = fA(paramJSONObject.optString("encryptUrl", ""), paramEmojiInfo.field_encrypturl);
      paramEmojiInfo.field_aeskey = fA(paramJSONObject.optString("aesKey", ""), paramEmojiInfo.field_aeskey);
      paramEmojiInfo.field_groupId = fA(paramJSONObject.optString("productID", ""), paramEmojiInfo.field_groupId);
      paramEmojiInfo.Ofj = fA(paramJSONObject.optString("productName", ""), paramEmojiInfo.Ofj);
      paramEmojiInfo.field_catalog = EmojiInfo.OeN;
      if ((com.tencent.matrix.trace.g.b.ea(paramEmojiInfo.field_cdnUrl)) && (com.tencent.matrix.trace.g.b.ea(paramEmojiInfo.field_aeskey))) {
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
  
  public static boolean aci(String paramString)
  {
    AppMethodBeat.i(104580);
    if ((!bt.isNullOrNil(paramString)) && (!bt.lQ(paramString, "capture")) && (!bt.lQ(paramString, EmojiGroupInfo.OeK)))
    {
      AppMethodBeat.o(104580);
      return true;
    }
    AppMethodBeat.o(104580);
    return false;
  }
  
  public static boolean acj(String paramString)
  {
    AppMethodBeat.i(104583);
    if ((!bt.isNullOrNil(paramString)) && (!bt.lQ(paramString, "capture")))
    {
      AppMethodBeat.o(104583);
      return true;
    }
    AppMethodBeat.o(104583);
    return false;
  }
  
  public static String azF()
  {
    AppMethodBeat.i(221213);
    Object localObject = a.gqn;
    localObject = a.agp();
    AppMethodBeat.o(221213);
    return localObject;
  }
  
  public static void b(bc parambc, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(162344);
    paramEmojiInfo.field_md5 = fA(parambc.md5, paramEmojiInfo.field_md5);
    paramEmojiInfo.field_svrid = fA(parambc.id, paramEmojiInfo.field_svrid);
    paramEmojiInfo.field_type = parambc.ILc;
    paramEmojiInfo.field_size = parambc.ILd;
    paramEmojiInfo.field_groupId = fA(parambc.dok, paramEmojiInfo.field_groupId);
    paramEmojiInfo.field_designerID = fA(parambc.ILh, paramEmojiInfo.field_designerID);
    paramEmojiInfo.field_thumbUrl = fA(parambc.thumbUrl, paramEmojiInfo.field_thumbUrl);
    paramEmojiInfo.field_cdnUrl = fA(parambc.gHx, paramEmojiInfo.field_cdnUrl);
    paramEmojiInfo.field_encrypturl = fA(parambc.dsv, paramEmojiInfo.field_encrypturl);
    paramEmojiInfo.field_aeskey = fA(parambc.aeskey, paramEmojiInfo.field_aeskey);
    paramEmojiInfo.field_width = parambc.width;
    paramEmojiInfo.field_height = parambc.height;
    paramEmojiInfo.field_externUrl = fA(parambc.ILi, paramEmojiInfo.field_externUrl);
    paramEmojiInfo.field_externMd5 = fA(parambc.ILj, paramEmojiInfo.field_externMd5);
    paramEmojiInfo.field_activityid = fA(parambc.ILl, paramEmojiInfo.field_activityid);
    paramEmojiInfo.field_tpurl = fA(parambc.hzU, paramEmojiInfo.field_tpurl);
    paramEmojiInfo.field_tpauthkey = fA(parambc.hAa, paramEmojiInfo.field_tpauthkey);
    paramEmojiInfo.field_attachedText = fA(parambc.gkl, paramEmojiInfo.field_attachedText);
    paramEmojiInfo.field_lensId = fA(parambc.pQo, paramEmojiInfo.field_lensId);
    paramEmojiInfo.field_attachTextColor = fA(parambc.ILm, paramEmojiInfo.field_attachTextColor);
    AppMethodBeat.o(162344);
  }
  
  public static int bd(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4)) {
      return EmojiInfo.OeJ;
    }
    if ((paramArrayOfByte[1] == 80) && (paramArrayOfByte[2] == 78) && (paramArrayOfByte[3] == 71)) {
      return EmojiInfo.OeU;
    }
    if ((paramArrayOfByte[0] == 71) && (paramArrayOfByte[1] == 73) && (paramArrayOfByte[2] == 70)) {
      return EmojiInfo.OeV;
    }
    if ((paramArrayOfByte[6] == 74) && (paramArrayOfByte[7] == 70) && (paramArrayOfByte[8] == 73) && (paramArrayOfByte[9] == 70)) {
      return EmojiInfo.OeW;
    }
    return EmojiInfo.OeJ;
  }
  
  public static String fA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104578);
    if (bt.isNullOrNil(paramString1))
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
    if ((paramEmojiInfo != null) && (aci(paramEmojiInfo.field_groupId)))
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
    if (paramEmojiInfo.field_catalog == EmojiInfo.OeT)
    {
      AppMethodBeat.o(183923);
      return true;
    }
    Object localObject = i.aeL().dj(true);
    if (localObject == null)
    {
      AppMethodBeat.o(183923);
      return false;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (bt.lQ(((EmojiInfo)((Iterator)localObject).next()).field_md5, paramEmojiInfo.field_md5))
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
    boolean bool = bt.lQ(paramEmojiInfo.field_groupId, "capture");
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
    if (!m.afg())
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