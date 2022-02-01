package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/panel/PlaceHolderItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "emojiType", "", "(I)V", "getEmojiType", "()I", "equals", "", "other", "", "plugin-emojisdk_release"})
public final class ah
  extends ac
{
  public final int gkP;
  
  public ah(int paramInt)
  {
    super(paramInt);
    this.gkP = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(161813);
    if ((super.equals(paramObject)) && ((paramObject instanceof ah)) && (((ah)paramObject).gkP == this.gkP))
    {
      AppMethodBeat.o(161813);
      return true;
    }
    AppMethodBeat.o(161813);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.ah
 * JD-Core Version:    0.7.0.1
 */