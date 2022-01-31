package com.tencent.mm.plugin.emoji.h;

import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class a
{
  public static boolean Bh(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.equals(aJK());
  }
  
  public static final String aJK()
  {
    return EmojiGroupInfo.uCQ;
  }
  
  public static boolean aJh()
  {
    return i.getEmojiStorageMgr().uBc.cwh();
  }
  
  public static boolean b(EmojiGroupInfo paramEmojiGroupInfo)
  {
    if (paramEmojiGroupInfo == null) {
      return false;
    }
    return Bh(paramEmojiGroupInfo.field_productID);
  }
  
  public static boolean d(vn paramvn)
  {
    if (paramvn == null) {
      return false;
    }
    return Bh(paramvn.syc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.h.a
 * JD-Core Version:    0.7.0.1
 */