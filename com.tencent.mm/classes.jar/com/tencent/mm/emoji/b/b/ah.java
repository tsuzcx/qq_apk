package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/panel/PlaceHolderItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "emojiType", "", "(I)V", "getEmojiType", "()I", "equals", "", "other", "", "plugin-emojisdk_release"})
public final class ah
  extends ac
{
  public final int gYc;
  
  public ah(int paramInt)
  {
    super(paramInt);
    this.gYc = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(161813);
    if ((super.equals(paramObject)) && ((paramObject instanceof ah)) && (((ah)paramObject).gYc == this.gYc))
    {
      AppMethodBeat.o(161813);
      return true;
    }
    AppMethodBeat.o(161813);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.ah
 * JD-Core Version:    0.7.0.1
 */