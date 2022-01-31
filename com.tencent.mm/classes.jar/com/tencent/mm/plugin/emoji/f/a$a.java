package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class a$a
  implements ap.a
{
  public a$a()
  {
    AppMethodBeat.i(53085);
    a.access$002(0);
    AppMethodBeat.o(53085);
  }
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(53086);
    if (a.access$000() >= 100)
    {
      a.access$002(0);
      ab.d("MicroMsg.emoji.EmojiTuziTool", "insert tuzi");
      com.tencent.mm.storage.emotion.a locala = i.getEmojiStorageMgr().yNo;
      EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
      localEmojiGroupInfo.field_productID = com.tencent.mm.plugin.emoji.h.a.bnx();
      localEmojiGroupInfo.field_packName = "emoji_custom_all";
      localEmojiGroupInfo.field_type = EmojiGroupInfo.TYPE_SYSTEM;
      localEmojiGroupInfo.field_sort = 1;
      localEmojiGroupInfo.field_idx = 0;
      localEmojiGroupInfo.field_packType = 4;
      localEmojiGroupInfo.field_packFlag = 1;
      localEmojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
      locala.c(localEmojiGroupInfo);
      i.blu().g(com.tencent.mm.plugin.emoji.h.a.bnx(), 7, a.access$000(), "");
      a.removeListener();
      AppMethodBeat.o(53086);
      return false;
    }
    i.blu().g(com.tencent.mm.plugin.emoji.h.a.bnx(), 6, a.access$000(), "");
    a.access$002(a.access$000() + 2);
    AppMethodBeat.o(53086);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.a.a
 * JD-Core Version:    0.7.0.1
 */