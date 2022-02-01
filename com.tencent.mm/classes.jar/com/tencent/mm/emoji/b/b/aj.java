package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/panel/PlaceHolderItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "emojiType", "", "(I)V", "getEmojiType", "()I", "equals", "", "other", "", "plugin-emojisdk_release"})
public final class aj
  extends ae
{
  public final int jJc;
  
  public aj(int paramInt)
  {
    super(paramInt);
    this.jJc = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(161813);
    if ((super.equals(paramObject)) && ((paramObject instanceof aj)) && (((aj)paramObject).jJc == this.jJc))
    {
      AppMethodBeat.o(161813);
      return true;
    }
    AppMethodBeat.o(161813);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.aj
 * JD-Core Version:    0.7.0.1
 */