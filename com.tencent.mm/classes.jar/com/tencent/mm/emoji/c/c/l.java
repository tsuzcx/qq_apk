package com.tencent.mm.emoji.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "type", "", "reportPosition", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;II)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getReportPosition", "()I", "setReportPosition", "(I)V", "getType", "setType", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public final EmojiInfo mgK;
  public int mkb;
  public int type;
  
  public l(EmojiInfo paramEmojiInfo, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242670);
    this.mgK = paramEmojiInfo;
    this.type = paramInt1;
    this.mkb = paramInt2;
    AppMethodBeat.o(242670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.c.c.l
 * JD-Core Version:    0.7.0.1
 */