package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class b$a
  implements am.a
{
  public b$a()
  {
    b.access$002(0);
  }
  
  public final boolean tC()
  {
    if (b.access$000() >= 100)
    {
      b.access$002(0);
      y.d("MicroMsg.emoji.EmojiTuziTool", "insert tuzi");
      com.tencent.mm.storage.emotion.a locala = i.getEmojiStorageMgr().uBc;
      EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
      localEmojiGroupInfo.field_productID = com.tencent.mm.plugin.emoji.h.a.aJK();
      localEmojiGroupInfo.field_packName = "emoji_custom_all";
      localEmojiGroupInfo.field_type = EmojiGroupInfo.TYPE_SYSTEM;
      localEmojiGroupInfo.field_sort = 1;
      localEmojiGroupInfo.field_idx = 0;
      localEmojiGroupInfo.field_packType = 4;
      localEmojiGroupInfo.field_packFlag = 1;
      localEmojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
      locala.c(localEmojiGroupInfo);
      i.aHU().g(com.tencent.mm.plugin.emoji.h.a.aJK(), 7, b.access$000(), "");
      b.ch();
      return false;
    }
    i.aHU().g(com.tencent.mm.plugin.emoji.h.a.aJK(), 6, b.access$000(), "");
    b.access$002(b.access$000() + 2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.b.a
 * JD-Core Version:    0.7.0.1
 */