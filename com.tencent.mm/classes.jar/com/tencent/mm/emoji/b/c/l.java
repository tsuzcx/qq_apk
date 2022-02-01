package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "type", "", "reportPosition", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;II)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getReportPosition", "()I", "setReportPosition", "(I)V", "getType", "setType", "plugin-emojisdk_release"})
public final class l
{
  public final EmojiInfo gWm;
  public int gZO;
  public int type;
  
  public l(EmojiInfo paramEmojiInfo, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199958);
    this.gWm = paramEmojiInfo;
    this.type = paramInt1;
    this.gZO = paramInt2;
    AppMethodBeat.o(199958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c.l
 * JD-Core Version:    0.7.0.1
 */