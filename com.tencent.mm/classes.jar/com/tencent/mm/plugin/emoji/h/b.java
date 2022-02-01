package com.tencent.mm.plugin.emoji.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.h;
import com.tencent.mm.emoji.a.l;
import com.tencent.mm.emoji.d.a;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public static boolean Uq(String paramString)
  {
    AppMethodBeat.i(104580);
    if ((!bt.isNullOrNil(paramString)) && (!bt.kU(paramString, "capture")) && (!bt.kU(paramString, EmojiGroupInfo.LBN)))
    {
      AppMethodBeat.o(104580);
      return true;
    }
    AppMethodBeat.o(104580);
    return false;
  }
  
  public static boolean Ur(String paramString)
  {
    AppMethodBeat.i(104583);
    if ((!bt.isNullOrNil(paramString)) && (!bt.kU(paramString, "capture")))
    {
      AppMethodBeat.o(104583);
      return true;
    }
    AppMethodBeat.o(104583);
    return false;
  }
  
  public static void a(act paramact, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104577);
    if ((!bt.isNullOrNil(paramEmojiInfo.field_md5)) && (!paramEmojiInfo.field_md5.equals(paramact.Md5)))
    {
      AppMethodBeat.o(104577);
      return;
    }
    paramEmojiInfo.field_md5 = fd(paramact.Md5, paramEmojiInfo.field_md5);
    paramEmojiInfo.field_cdnUrl = fd(paramact.Url, paramEmojiInfo.field_cdnUrl);
    paramEmojiInfo.field_thumbUrl = fd(paramact.ThumbUrl, paramEmojiInfo.field_thumbUrl);
    paramEmojiInfo.field_designerID = fd(paramact.Ddp, paramEmojiInfo.field_designerID);
    paramEmojiInfo.field_encrypturl = fd(paramact.EncryptUrl, paramEmojiInfo.field_encrypturl);
    paramEmojiInfo.field_aeskey = fd(paramact.AesKey, paramEmojiInfo.field_aeskey);
    paramEmojiInfo.field_groupId = fd(paramact.ProductID, paramEmojiInfo.field_groupId);
    paramEmojiInfo.field_externUrl = fd(paramact.ExternUrl, paramEmojiInfo.field_externUrl);
    paramEmojiInfo.field_externMd5 = fd(paramact.ExternMd5, paramEmojiInfo.field_externMd5);
    paramEmojiInfo.field_activityid = fd(paramact.ActivityID, paramEmojiInfo.field_activityid);
    paramEmojiInfo.field_attachedText = fd(paramact.Ddq, paramEmojiInfo.field_attachedText);
    paramEmojiInfo.field_attachTextColor = fd(paramact.Ddr, paramEmojiInfo.field_attachTextColor);
    paramEmojiInfo.field_lensId = fd(paramact.Dds, paramEmojiInfo.field_lensId);
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
      paramEmojiInfo.field_md5 = fd(paramJSONObject.optString("md5", ""), paramEmojiInfo.field_md5);
      paramEmojiInfo.field_cdnUrl = fd(paramJSONObject.optString("productUrl", ""), paramEmojiInfo.field_cdnUrl);
      paramEmojiInfo.field_thumbUrl = fd(paramJSONObject.optString("thumb", ""), paramEmojiInfo.field_thumbUrl);
      paramEmojiInfo.field_encrypturl = fd(paramJSONObject.optString("encryptUrl", ""), paramEmojiInfo.field_encrypturl);
      paramEmojiInfo.field_aeskey = fd(paramJSONObject.optString("aesKey", ""), paramEmojiInfo.field_aeskey);
      paramEmojiInfo.field_groupId = fd(paramJSONObject.optString("productID", ""), paramEmojiInfo.field_groupId);
      paramEmojiInfo.LCm = fd(paramJSONObject.optString("productName", ""), paramEmojiInfo.LCm);
      paramEmojiInfo.field_catalog = EmojiInfo.LBQ;
      if ((com.tencent.matrix.trace.g.b.dq(paramEmojiInfo.field_cdnUrl)) && (com.tencent.matrix.trace.g.b.dq(paramEmojiInfo.field_aeskey))) {
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
  
  public static int aW(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4)) {
      return EmojiInfo.LBM;
    }
    if ((paramArrayOfByte[1] == 80) && (paramArrayOfByte[2] == 78) && (paramArrayOfByte[3] == 71)) {
      return EmojiInfo.LBX;
    }
    if ((paramArrayOfByte[0] == 71) && (paramArrayOfByte[1] == 73) && (paramArrayOfByte[2] == 70)) {
      return EmojiInfo.LBY;
    }
    if ((paramArrayOfByte[6] == 74) && (paramArrayOfByte[7] == 70) && (paramArrayOfByte[8] == 73) && (paramArrayOfByte[9] == 70)) {
      return EmojiInfo.LBZ;
    }
    return EmojiInfo.LBM;
  }
  
  public static String aqb()
  {
    AppMethodBeat.i(202411);
    Object localObject = a.fSR;
    localObject = a.acD();
    AppMethodBeat.o(202411);
    return localObject;
  }
  
  public static void b(av paramav, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(162344);
    paramEmojiInfo.field_md5 = fd(paramav.md5, paramEmojiInfo.field_md5);
    paramEmojiInfo.field_svrid = fd(paramav.id, paramEmojiInfo.field_svrid);
    paramEmojiInfo.field_type = paramav.FyN;
    paramEmojiInfo.field_size = paramav.FyO;
    paramEmojiInfo.field_groupId = fd(paramav.dft, paramEmojiInfo.field_groupId);
    paramEmojiInfo.field_designerID = fd(paramav.FyS, paramEmojiInfo.field_designerID);
    paramEmojiInfo.field_thumbUrl = fd(paramav.thumbUrl, paramEmojiInfo.field_thumbUrl);
    paramEmojiInfo.field_cdnUrl = fd(paramav.syH, paramEmojiInfo.field_cdnUrl);
    paramEmojiInfo.field_encrypturl = fd(paramav.djC, paramEmojiInfo.field_encrypturl);
    paramEmojiInfo.field_aeskey = fd(paramav.aeskey, paramEmojiInfo.field_aeskey);
    paramEmojiInfo.field_width = paramav.width;
    paramEmojiInfo.field_height = paramav.height;
    paramEmojiInfo.field_externUrl = fd(paramav.FyT, paramEmojiInfo.field_externUrl);
    paramEmojiInfo.field_externMd5 = fd(paramav.FyU, paramEmojiInfo.field_externMd5);
    paramEmojiInfo.field_activityid = fd(paramav.FyW, paramEmojiInfo.field_activityid);
    paramEmojiInfo.field_tpurl = fd(paramav.gHk, paramEmojiInfo.field_tpurl);
    paramEmojiInfo.field_tpauthkey = fd(paramav.gHq, paramEmojiInfo.field_tpauthkey);
    paramEmojiInfo.field_attachedText = fd(paramav.fNa, paramEmojiInfo.field_attachedText);
    paramEmojiInfo.field_lensId = fd(paramav.oJp, paramEmojiInfo.field_lensId);
    paramEmojiInfo.field_attachTextColor = fd(paramav.FyX, paramEmojiInfo.field_attachTextColor);
    AppMethodBeat.o(162344);
  }
  
  public static String fd(String paramString1, String paramString2)
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
    if ((paramEmojiInfo != null) && (Uq(paramEmojiInfo.field_groupId)))
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
    if (paramEmojiInfo.field_catalog == EmojiInfo.LBW)
    {
      AppMethodBeat.o(183923);
      return true;
    }
    Object localObject = h.abj().di(true);
    if (localObject == null)
    {
      AppMethodBeat.o(183923);
      return false;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (bt.kU(((EmojiInfo)((Iterator)localObject).next()).field_md5, paramEmojiInfo.field_md5))
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
    boolean bool = bt.kU(paramEmojiInfo.field_groupId, "capture");
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
    if (!l.abD())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.h.b
 * JD-Core Version:    0.7.0.1
 */