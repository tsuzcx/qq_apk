package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "emojiType", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;I)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getEmojiType", "()I", "contentEquals", "", "other", "", "equals", "plugin-emojisdk_release"})
public final class h
  extends ac
{
  public final EmojiInfo gjb;
  public final int gkP;
  
  public h(EmojiInfo paramEmojiInfo, int paramInt) {}
  
  public final boolean aS(Object paramObject)
  {
    AppMethodBeat.i(105537);
    if ((super.aS(paramObject)) && ((paramObject instanceof h)) && (((h)paramObject).gjb.gzL() == this.gjb.gzL()) && (((h)paramObject).gjb.getIndex() == this.gjb.getIndex()) && (((h)paramObject).gjb.gzJ() == this.gjb.gzJ()))
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
    if ((super.equals(paramObject)) && ((paramObject instanceof h)) && ((p.i(((h)paramObject).gjb.Lb(), this.gjb.Lb())) || ((this.gjb.field_captureEnterTime != 0L) && (((h)paramObject).gjb.field_captureEnterTime == this.gjb.field_captureEnterTime))))
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