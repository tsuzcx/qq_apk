package com.tencent.mm.plugin.emoji.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.emoji.a.m;
import com.tencent.mm.emoji.d.a;
import com.tencent.mm.protocal.protobuf.agk;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public static void a(agk paramagk, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104577);
    if ((!bu.isNullOrNil(paramEmojiInfo.field_md5)) && (!paramEmojiInfo.field_md5.equals(paramagk.Md5)))
    {
      AppMethodBeat.o(104577);
      return;
    }
    paramEmojiInfo.field_md5 = fE(paramagk.Md5, paramEmojiInfo.field_md5);
    paramEmojiInfo.field_cdnUrl = fE(paramagk.Url, paramEmojiInfo.field_cdnUrl);
    paramEmojiInfo.field_thumbUrl = fE(paramagk.ThumbUrl, paramEmojiInfo.field_thumbUrl);
    paramEmojiInfo.field_designerID = fE(paramagk.GwF, paramEmojiInfo.field_designerID);
    paramEmojiInfo.field_encrypturl = fE(paramagk.EncryptUrl, paramEmojiInfo.field_encrypturl);
    paramEmojiInfo.field_aeskey = fE(paramagk.AesKey, paramEmojiInfo.field_aeskey);
    paramEmojiInfo.field_groupId = fE(paramagk.ProductID, paramEmojiInfo.field_groupId);
    paramEmojiInfo.field_externUrl = fE(paramagk.ExternUrl, paramEmojiInfo.field_externUrl);
    paramEmojiInfo.field_externMd5 = fE(paramagk.ExternMd5, paramEmojiInfo.field_externMd5);
    paramEmojiInfo.field_activityid = fE(paramagk.ActivityID, paramEmojiInfo.field_activityid);
    paramEmojiInfo.field_attachedText = fE(paramagk.GwG, paramEmojiInfo.field_attachedText);
    paramEmojiInfo.field_attachTextColor = fE(paramagk.GwH, paramEmojiInfo.field_attachTextColor);
    paramEmojiInfo.field_lensId = fE(paramagk.GwI, paramEmojiInfo.field_lensId);
    AppMethodBeat.o(104577);
  }
  
  public static void a(JSONObject paramJSONObject, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104576);
    try
    {
      if (!bu.isNullOrNil(paramEmojiInfo.field_md5))
      {
        boolean bool = paramEmojiInfo.field_md5.equals(paramJSONObject.getString("md5"));
        if (!bool)
        {
          AppMethodBeat.o(104576);
          return;
        }
      }
      paramEmojiInfo.field_md5 = fE(paramJSONObject.optString("md5", ""), paramEmojiInfo.field_md5);
      paramEmojiInfo.field_cdnUrl = fE(paramJSONObject.optString("productUrl", ""), paramEmojiInfo.field_cdnUrl);
      paramEmojiInfo.field_thumbUrl = fE(paramJSONObject.optString("thumb", ""), paramEmojiInfo.field_thumbUrl);
      paramEmojiInfo.field_encrypturl = fE(paramJSONObject.optString("encryptUrl", ""), paramEmojiInfo.field_encrypturl);
      paramEmojiInfo.field_aeskey = fE(paramJSONObject.optString("aesKey", ""), paramEmojiInfo.field_aeskey);
      paramEmojiInfo.field_groupId = fE(paramJSONObject.optString("productID", ""), paramEmojiInfo.field_groupId);
      paramEmojiInfo.OAq = fE(paramJSONObject.optString("productName", ""), paramEmojiInfo.OAq);
      paramEmojiInfo.field_catalog = EmojiInfo.OzU;
      if ((com.tencent.matrix.trace.g.b.ef(paramEmojiInfo.field_cdnUrl)) && (com.tencent.matrix.trace.g.b.ef(paramEmojiInfo.field_aeskey))) {
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
  
  public static boolean acZ(String paramString)
  {
    AppMethodBeat.i(104580);
    if ((!bu.isNullOrNil(paramString)) && (!bu.lX(paramString, "capture")) && (!bu.lX(paramString, EmojiGroupInfo.OzR)))
    {
      AppMethodBeat.o(104580);
      return true;
    }
    AppMethodBeat.o(104580);
    return false;
  }
  
  public static boolean ada(String paramString)
  {
    AppMethodBeat.i(104583);
    if ((!bu.isNullOrNil(paramString)) && (!bu.lX(paramString, "capture")))
    {
      AppMethodBeat.o(104583);
      return true;
    }
    AppMethodBeat.o(104583);
    return false;
  }
  
  public static String azV()
  {
    AppMethodBeat.i(224505);
    Object localObject = a.gsI;
    localObject = a.agD();
    AppMethodBeat.o(224505);
    return localObject;
  }
  
  public static void b(bd parambd, EmojiInfo paramEmojiInfo)
  {
    int j = 1;
    AppMethodBeat.i(162344);
    paramEmojiInfo.field_md5 = fE(parambd.md5, paramEmojiInfo.field_md5);
    paramEmojiInfo.field_svrid = fE(parambd.id, paramEmojiInfo.field_svrid);
    paramEmojiInfo.field_type = parambd.JfJ;
    paramEmojiInfo.field_size = parambd.JfK;
    paramEmojiInfo.field_groupId = fE(parambd.dpp, paramEmojiInfo.field_groupId);
    paramEmojiInfo.field_designerID = fE(parambd.JfO, paramEmojiInfo.field_designerID);
    paramEmojiInfo.field_thumbUrl = fE(parambd.thumbUrl, paramEmojiInfo.field_thumbUrl);
    paramEmojiInfo.field_cdnUrl = fE(parambd.gKg, paramEmojiInfo.field_cdnUrl);
    paramEmojiInfo.field_encrypturl = fE(parambd.dtB, paramEmojiInfo.field_encrypturl);
    paramEmojiInfo.field_width = parambd.width;
    paramEmojiInfo.field_height = parambd.height;
    paramEmojiInfo.field_externUrl = fE(parambd.JfP, paramEmojiInfo.field_externUrl);
    paramEmojiInfo.field_externMd5 = fE(parambd.JfQ, paramEmojiInfo.field_externMd5);
    paramEmojiInfo.field_activityid = fE(parambd.JfS, paramEmojiInfo.field_activityid);
    paramEmojiInfo.field_tpurl = fE(parambd.hCI, paramEmojiInfo.field_tpurl);
    paramEmojiInfo.field_tpauthkey = fE(parambd.hCO, paramEmojiInfo.field_tpauthkey);
    int i;
    if ((!bu.isNullOrNil(paramEmojiInfo.field_externUrl)) || (!bu.isNullOrNil(paramEmojiInfo.field_encrypturl)) || (!bu.isNullOrNil(paramEmojiInfo.field_cdnUrl)))
    {
      i = 1;
      if (bu.isNullOrNil(parambd.hCI)) {
        break label340;
      }
    }
    for (;;)
    {
      if ((j == 0) || (i == 0)) {
        paramEmojiInfo.field_aeskey = fE(parambd.aeskey, paramEmojiInfo.field_aeskey);
      }
      paramEmojiInfo.field_attachedText = fE(parambd.gmF, paramEmojiInfo.field_attachedText);
      paramEmojiInfo.field_lensId = fE(parambd.pWT, paramEmojiInfo.field_lensId);
      paramEmojiInfo.field_attachTextColor = fE(parambd.JfT, paramEmojiInfo.field_attachTextColor);
      AppMethodBeat.o(162344);
      return;
      i = 0;
      break;
      label340:
      j = 0;
    }
  }
  
  public static int bc(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4)) {
      return EmojiInfo.OzQ;
    }
    if ((paramArrayOfByte[1] == 80) && (paramArrayOfByte[2] == 78) && (paramArrayOfByte[3] == 71)) {
      return EmojiInfo.OAb;
    }
    if ((paramArrayOfByte[0] == 71) && (paramArrayOfByte[1] == 73) && (paramArrayOfByte[2] == 70)) {
      return EmojiInfo.OAc;
    }
    if ((paramArrayOfByte[6] == 74) && (paramArrayOfByte[7] == 70) && (paramArrayOfByte[8] == 73) && (paramArrayOfByte[9] == 70)) {
      return EmojiInfo.OAd;
    }
    return EmojiInfo.OzQ;
  }
  
  public static String fE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104578);
    if (bu.isNullOrNil(paramString1))
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
    if ((paramEmojiInfo != null) && (acZ(paramEmojiInfo.field_groupId)))
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
    if (paramEmojiInfo.field_catalog == EmojiInfo.OAa)
    {
      AppMethodBeat.o(183923);
      return true;
    }
    Object localObject = i.aeX().dj(true);
    if (localObject == null)
    {
      AppMethodBeat.o(183923);
      return false;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (bu.lX(((EmojiInfo)((Iterator)localObject).next()).field_md5, paramEmojiInfo.field_md5))
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
    boolean bool = bu.lX(paramEmojiInfo.field_groupId, "capture");
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
    if (!m.afu())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.h.b
 * JD-Core Version:    0.7.0.1
 */