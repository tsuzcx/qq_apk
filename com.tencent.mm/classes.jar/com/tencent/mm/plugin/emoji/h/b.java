package com.tencent.mm.plugin.emoji.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.e;
import com.tencent.mm.ce.f;
import com.tencent.mm.ce.f.a;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.emoji.e.a;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public final class b
{
  public static void a(ait paramait, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104577);
    if ((!Util.isNullOrNil(paramEmojiInfo.field_md5)) && (!paramEmojiInfo.field_md5.equals(paramait.Md5)))
    {
      AppMethodBeat.o(104577);
      return;
    }
    paramEmojiInfo.field_md5 = fX(paramait.Md5, paramEmojiInfo.field_md5);
    paramEmojiInfo.field_cdnUrl = fX(paramait.Url, paramEmojiInfo.field_cdnUrl);
    paramEmojiInfo.field_thumbUrl = fX(paramait.ThumbUrl, paramEmojiInfo.field_thumbUrl);
    paramEmojiInfo.field_designerID = fX(paramait.Lsl, paramEmojiInfo.field_designerID);
    paramEmojiInfo.field_encrypturl = fX(paramait.EncryptUrl, paramEmojiInfo.field_encrypturl);
    paramEmojiInfo.field_aeskey = fX(paramait.AesKey, paramEmojiInfo.field_aeskey);
    paramEmojiInfo.field_groupId = fX(paramait.ProductID, paramEmojiInfo.field_groupId);
    paramEmojiInfo.field_externUrl = fX(paramait.ExternUrl, paramEmojiInfo.field_externUrl);
    paramEmojiInfo.field_externMd5 = fX(paramait.ExternMd5, paramEmojiInfo.field_externMd5);
    paramEmojiInfo.field_activityid = fX(paramait.ActivityID, paramEmojiInfo.field_activityid);
    paramEmojiInfo.field_attachedText = fX(paramait.Lsm, paramEmojiInfo.field_attachedText);
    paramEmojiInfo.field_attachTextColor = fX(paramait.Lsn, paramEmojiInfo.field_attachTextColor);
    paramEmojiInfo.field_lensId = fX(paramait.Lso, paramEmojiInfo.field_lensId);
    AppMethodBeat.o(104577);
  }
  
  public static void a(ait paramait, EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(199787);
    a(paramait, paramEmojiInfo);
    paramEmojiInfo.MOK = paramString;
    AppMethodBeat.o(199787);
  }
  
  public static void a(String paramString, JSONObject paramJSONObject, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(199786);
    try
    {
      if (!Util.isNullOrNil(paramEmojiInfo.field_md5))
      {
        boolean bool = paramEmojiInfo.field_md5.equals(paramJSONObject.getString("md5"));
        if (!bool)
        {
          AppMethodBeat.o(199786);
          return;
        }
      }
      paramEmojiInfo.field_md5 = fX(paramJSONObject.optString("md5", ""), paramEmojiInfo.field_md5);
      paramEmojiInfo.field_cdnUrl = fX(paramJSONObject.optString("productUrl", ""), paramEmojiInfo.field_cdnUrl);
      paramEmojiInfo.field_thumbUrl = fX(paramJSONObject.optString("thumb", ""), paramEmojiInfo.field_thumbUrl);
      paramEmojiInfo.field_encrypturl = fX(paramJSONObject.optString("encryptUrl", ""), paramEmojiInfo.field_encrypturl);
      paramEmojiInfo.field_aeskey = fX(paramJSONObject.optString("aesKey", ""), paramEmojiInfo.field_aeskey);
      paramEmojiInfo.field_groupId = fX(paramJSONObject.optString("productID", ""), paramEmojiInfo.field_groupId);
      paramEmojiInfo.UuL = fX(paramJSONObject.optString("productName", ""), paramEmojiInfo.UuL);
      paramEmojiInfo.field_catalog = EmojiInfo.Uup;
      if ((com.tencent.matrix.trace.g.b.eP(paramEmojiInfo.field_cdnUrl)) && (com.tencent.matrix.trace.g.b.eP(paramEmojiInfo.field_aeskey))) {
        paramEmojiInfo.field_cdnUrl = paramEmojiInfo.field_encrypturl;
      }
      AppMethodBeat.o(199786);
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.printErrStackTrace(paramString, paramJSONObject, "convertEmojiInfo", new Object[0]);
      AppMethodBeat.o(199786);
    }
  }
  
  public static String aTd()
  {
    AppMethodBeat.i(258530);
    Object localObject = a.hdT;
    localObject = a.awt();
    AppMethodBeat.o(258530);
    return localObject;
  }
  
  public static boolean anh(String paramString)
  {
    AppMethodBeat.i(104580);
    if ((!Util.isNullOrNil(paramString)) && (!Util.isEqual(paramString, "capture")) && (!Util.isEqual(paramString, EmojiGroupInfo.Uum)))
    {
      AppMethodBeat.o(104580);
      return true;
    }
    AppMethodBeat.o(104580);
    return false;
  }
  
  public static boolean ani(String paramString)
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
  
  public static String anj(String paramString)
  {
    AppMethodBeat.i(199788);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(199788);
      return null;
    }
    f.a locala = f.gxT().big(paramString);
    if ((locala != null) && (Util.isEqual(locala.text, paramString)))
    {
      paramString = locala.key;
      AppMethodBeat.o(199788);
      return paramString;
    }
    if (e.gxR().containsKey(paramString))
    {
      AppMethodBeat.o(199788);
      return paramString;
    }
    AppMethodBeat.o(199788);
    return null;
  }
  
  public static void b(bi parambi, EmojiInfo paramEmojiInfo)
  {
    int j = 1;
    AppMethodBeat.i(162344);
    paramEmojiInfo.field_md5 = fX(parambi.md5, paramEmojiInfo.field_md5);
    paramEmojiInfo.field_svrid = fX(parambi.id, paramEmojiInfo.field_svrid);
    paramEmojiInfo.field_type = parambi.OpC;
    paramEmojiInfo.field_size = parambi.OpD;
    paramEmojiInfo.field_groupId = fX(parambi.productId, paramEmojiInfo.field_groupId);
    paramEmojiInfo.field_designerID = fX(parambi.OpH, paramEmojiInfo.field_designerID);
    paramEmojiInfo.field_thumbUrl = fX(parambi.thumbUrl, paramEmojiInfo.field_thumbUrl);
    paramEmojiInfo.field_cdnUrl = fX(parambi.pkK, paramEmojiInfo.field_cdnUrl);
    paramEmojiInfo.field_encrypturl = fX(parambi.dKK, paramEmojiInfo.field_encrypturl);
    paramEmojiInfo.field_width = parambi.width;
    paramEmojiInfo.field_height = parambi.height;
    paramEmojiInfo.field_externUrl = fX(parambi.OpI, paramEmojiInfo.field_externUrl);
    paramEmojiInfo.field_externMd5 = fX(parambi.OpJ, paramEmojiInfo.field_externMd5);
    paramEmojiInfo.field_activityid = fX(parambi.OpL, paramEmojiInfo.field_activityid);
    paramEmojiInfo.field_tpurl = fX(parambi.iwN, paramEmojiInfo.field_tpurl);
    paramEmojiInfo.field_tpauthkey = fX(parambi.iwT, paramEmojiInfo.field_tpauthkey);
    int i;
    if ((!Util.isNullOrNil(paramEmojiInfo.field_externUrl)) || (!Util.isNullOrNil(paramEmojiInfo.field_encrypturl)) || (!Util.isNullOrNil(paramEmojiInfo.field_cdnUrl)))
    {
      i = 1;
      if (Util.isNullOrNil(parambi.iwN)) {
        break label340;
      }
    }
    for (;;)
    {
      if ((j == 0) || (i == 0)) {
        paramEmojiInfo.field_aeskey = fX(parambi.aeskey, paramEmojiInfo.field_aeskey);
      }
      paramEmojiInfo.field_attachedText = fX(parambi.gXx, paramEmojiInfo.field_attachedText);
      paramEmojiInfo.field_lensId = fX(parambi.rnS, paramEmojiInfo.field_lensId);
      paramEmojiInfo.field_attachTextColor = fX(parambi.OpM, paramEmojiInfo.field_attachTextColor);
      AppMethodBeat.o(162344);
      return;
      i = 0;
      break;
      label340:
      j = 0;
    }
  }
  
  public static int bt(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4)) {
      return EmojiInfo.Uul;
    }
    if ((paramArrayOfByte[1] == 80) && (paramArrayOfByte[2] == 78) && (paramArrayOfByte[3] == 71)) {
      return EmojiInfo.Uuw;
    }
    if ((paramArrayOfByte[0] == 71) && (paramArrayOfByte[1] == 73) && (paramArrayOfByte[2] == 70)) {
      return EmojiInfo.Uux;
    }
    if ((paramArrayOfByte[6] == 74) && (paramArrayOfByte[7] == 70) && (paramArrayOfByte[8] == 73) && (paramArrayOfByte[9] == 70)) {
      return EmojiInfo.Uuy;
    }
    return EmojiInfo.Uul;
  }
  
  public static String fX(String paramString1, String paramString2)
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
    AppMethodBeat.i(104579);
    if ((paramEmojiInfo != null) && (anh(paramEmojiInfo.field_groupId)))
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
    if (paramEmojiInfo.field_catalog == EmojiInfo.Uuv)
    {
      AppMethodBeat.o(183923);
      return true;
    }
    Object localObject = j.auL().dT(true);
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
  
  public static boolean y(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104581);
    boolean bool = Util.isEqual(paramEmojiInfo.field_groupId, "capture");
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
    if (!n.avi())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.h.b
 * JD-Core Version:    0.7.0.1
 */