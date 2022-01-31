package com.tencent.mm.plugin.emoji.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class b
{
  public static boolean Lk(String paramString)
  {
    AppMethodBeat.i(62347);
    if ((!bo.isNullOrNil(paramString)) && (!bo.isEqual(paramString, "capture")) && (!bo.isEqual(paramString, EmojiGroupInfo.yPd)))
    {
      AppMethodBeat.o(62347);
      return true;
    }
    AppMethodBeat.o(62347);
    return false;
  }
  
  public static boolean Ll(String paramString)
  {
    AppMethodBeat.i(62350);
    if ((!bo.isNullOrNil(paramString)) && (!bo.isEqual(paramString, "capture")))
    {
      AppMethodBeat.o(62350);
      return true;
    }
    AppMethodBeat.o(62350);
    return false;
  }
  
  public static String YP()
  {
    AppMethodBeat.i(62343);
    String str = ((d)g.G(d.class)).getProvider().getAccPath() + "emoji/";
    AppMethodBeat.o(62343);
    return str;
  }
  
  public static void a(zg paramzg, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(62344);
    if ((!bo.isNullOrNil(paramEmojiInfo.field_md5)) && (!paramEmojiInfo.field_md5.equals(paramzg.Md5)))
    {
      AppMethodBeat.o(62344);
      return;
    }
    paramEmojiInfo.field_md5 = dP(paramzg.Md5, paramEmojiInfo.field_md5);
    paramEmojiInfo.field_cdnUrl = dP(paramzg.Url, paramEmojiInfo.field_cdnUrl);
    paramEmojiInfo.field_thumbUrl = dP(paramzg.ThumbUrl, paramEmojiInfo.field_thumbUrl);
    paramEmojiInfo.field_designerID = dP(paramzg.wQg, paramEmojiInfo.field_designerID);
    paramEmojiInfo.field_encrypturl = dP(paramzg.EncryptUrl, paramEmojiInfo.field_encrypturl);
    paramEmojiInfo.field_aeskey = dP(paramzg.AesKey, paramEmojiInfo.field_aeskey);
    paramEmojiInfo.field_groupId = dP(paramzg.ProductID, paramEmojiInfo.field_groupId);
    paramEmojiInfo.field_externUrl = dP(paramzg.ExternUrl, paramEmojiInfo.field_externUrl);
    paramEmojiInfo.field_externMd5 = dP(paramzg.ExternMd5, paramEmojiInfo.field_externMd5);
    paramEmojiInfo.field_activityid = dP(paramzg.ActivityID, paramEmojiInfo.field_activityid);
    paramEmojiInfo.field_attachedText = dP(paramzg.wQh, paramEmojiInfo.field_attachedText);
    paramEmojiInfo.field_attachTextColor = dP(paramzg.wQi, paramEmojiInfo.field_attachTextColor);
    paramEmojiInfo.field_lensId = dP(paramzg.wQj, paramEmojiInfo.field_lensId);
    AppMethodBeat.o(62344);
  }
  
  public static int aG(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4)) {
      return EmojiInfo.yPc;
    }
    if ((paramArrayOfByte[1] == 80) && (paramArrayOfByte[2] == 78) && (paramArrayOfByte[3] == 71)) {
      return EmojiInfo.yPn;
    }
    if ((paramArrayOfByte[0] == 71) && (paramArrayOfByte[1] == 73) && (paramArrayOfByte[2] == 70)) {
      return EmojiInfo.yPo;
    }
    if ((paramArrayOfByte[6] == 74) && (paramArrayOfByte[7] == 70) && (paramArrayOfByte[8] == 73) && (paramArrayOfByte[9] == 70)) {
      return EmojiInfo.yPp;
    }
    return EmojiInfo.yPc;
  }
  
  public static String dP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(62345);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(62345);
      return paramString2;
    }
    AppMethodBeat.o(62345);
    return paramString1;
  }
  
  public static boolean x(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(62346);
    if ((paramEmojiInfo != null) && (Lk(paramEmojiInfo.field_groupId)))
    {
      AppMethodBeat.o(62346);
      return true;
    }
    AppMethodBeat.o(62346);
    return false;
  }
  
  public static boolean y(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(62348);
    boolean bool = bo.isEqual(paramEmojiInfo.field_groupId, "capture");
    AppMethodBeat.o(62348);
    return bool;
  }
  
  public static boolean z(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(62349);
    if (paramEmojiInfo == null)
    {
      AppMethodBeat.o(62349);
      return false;
    }
    if (!h.OU())
    {
      AppMethodBeat.o(62349);
      return false;
    }
    if ((y(paramEmojiInfo)) || ((paramEmojiInfo.field_activityid != null) && (paramEmojiInfo.field_activityid.startsWith("Selfie"))))
    {
      AppMethodBeat.o(62349);
      return true;
    }
    AppMethodBeat.o(62349);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.h.b
 * JD-Core Version:    0.7.0.1
 */