package com.tencent.mm.emoji.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "type", "", "reportPosition", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;II)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getReportPosition", "()I", "setReportPosition", "(I)V", "getType", "setType", "plugin-emojisdk_release"})
public final class h
{
  public final EmojiInfo fLP;
  public int fPc;
  public int type;
  
  public h(EmojiInfo paramEmojiInfo, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193410);
    this.fLP = paramEmojiInfo;
    this.type = paramInt1;
    this.fPc = paramInt2;
    AppMethodBeat.o(193410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.h
 * JD-Core Version:    0.7.0.1
 */