package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "emojiType", "", "sosDocId", "", "pageNo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;ILjava/lang/String;I)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getEmojiType", "()I", "getPageNo", "getSosDocId", "()Ljava/lang/String;", "contentEquals", "", "other", "", "equals", "plugin-emojisdk_release"})
public final class h
  extends ac
{
  public final EmojiInfo gWm;
  public final int gYc;
  public final String gYd;
  public final int gYe;
  
  public h(EmojiInfo paramEmojiInfo, int paramInt1, String paramString, int paramInt2) {}
  
  public final boolean aZ(Object paramObject)
  {
    AppMethodBeat.i(105537);
    if ((super.aZ(paramObject)) && ((paramObject instanceof h)) && (((h)paramObject).gWm.hRH() == this.gWm.hRH()) && (((h)paramObject).gWm.getIndex() == this.gWm.getIndex()) && (((h)paramObject).gWm.hRF() == this.gWm.hRF()))
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
    if ((super.equals(paramObject)) && ((paramObject instanceof h)) && ((p.j(((h)paramObject).gWm.getMd5(), this.gWm.getMd5())) || ((this.gWm.field_captureEnterTime != 0L) && (((h)paramObject).gWm.field_captureEnterTime == this.gWm.field_captureEnterTime))))
    {
      AppMethodBeat.o(105536);
      return true;
    }
    AppMethodBeat.o(105536);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.h
 * JD-Core Version:    0.7.0.1
 */