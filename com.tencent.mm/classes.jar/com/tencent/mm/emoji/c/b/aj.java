package com.tencent.mm.emoji.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/panel/PlaceHolderItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "emojiType", "", "(I)V", "getEmojiType", "()I", "equals", "", "other", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj
  extends ae
{
  public final int miu;
  
  public aj(int paramInt)
  {
    super(paramInt);
    this.miu = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(161813);
    if ((super.equals(paramObject)) && ((paramObject instanceof aj)) && (((aj)paramObject).miu == this.miu))
    {
      AppMethodBeat.o(161813);
      return true;
    }
    AppMethodBeat.o(161813);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b.aj
 * JD-Core Version:    0.7.0.1
 */