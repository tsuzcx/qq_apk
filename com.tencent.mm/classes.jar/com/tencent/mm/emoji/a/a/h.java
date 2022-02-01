package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "emojiType", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;I)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getEmojiType", "()I", "contentEquals", "", "other", "", "equals", "plugin-emojisdk_release"})
public final class h
  extends y
{
  public final EmojiInfo fPB;
  public final int fRp;
  
  public h(EmojiInfo paramEmojiInfo, int paramInt) {}
  
  public final boolean aQ(Object paramObject)
  {
    AppMethodBeat.i(105537);
    if ((super.aQ(paramObject)) && ((paramObject instanceof h)) && (((h)paramObject).fPB.fFY() == this.fPB.fFY()))
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
    if ((super.equals(paramObject)) && ((paramObject instanceof h)) && ((k.g(((h)paramObject).fPB.JC(), this.fPB.JC())) || ((this.fPB.field_captureEnterTime != 0L) && (((h)paramObject).fPB.field_captureEnterTime == this.fPB.field_captureEnterTime))))
    {
      AppMethodBeat.o(105536);
      return true;
    }
    AppMethodBeat.o(105536);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.h
 * JD-Core Version:    0.7.0.1
 */