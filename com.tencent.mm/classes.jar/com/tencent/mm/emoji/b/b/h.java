package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "emojiType", "", "sosDocId", "", "pageNo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;ILjava/lang/String;I)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getEmojiType", "()I", "getPageNo", "getSosDocId", "()Ljava/lang/String;", "contentEquals", "", "other", "", "equals", "plugin-emojisdk_release"})
public final class h
  extends ae
{
  public final EmojiInfo jHh;
  public final int jJc;
  public final String jJd;
  public final int jJe;
  
  public h(EmojiInfo paramEmojiInfo, int paramInt1, String paramString, int paramInt2) {}
  
  public final boolean ba(Object paramObject)
  {
    AppMethodBeat.i(105537);
    if ((super.ba(paramObject)) && ((paramObject instanceof h)) && (((h)paramObject).jHh.hBB() == this.jHh.hBB()) && (((h)paramObject).jHh.getIndex() == this.jHh.getIndex()) && (((h)paramObject).jHh.hBz() == this.jHh.hBz()) && (((h)paramObject).jJc == this.jJc))
    {
      AppMethodBeat.o(105537);
      return true;
    }
    AppMethodBeat.o(105537);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(105536);
    if ((super.equals(paramObject)) && ((paramObject instanceof h)) && ((p.h(((h)paramObject).jHh.getMd5(), this.jHh.getMd5())) || ((this.jHh.field_captureEnterTime != 0L) && (((h)paramObject).jHh.field_captureEnterTime == this.jHh.field_captureEnterTime))))
    {
      AppMethodBeat.o(105536);
      return true;
    }
    AppMethodBeat.o(105536);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.h
 * JD-Core Version:    0.7.0.1
 */