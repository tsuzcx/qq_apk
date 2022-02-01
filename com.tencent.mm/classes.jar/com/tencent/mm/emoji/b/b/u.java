package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/panel/GroupLoadingMoreItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "panelType", "", "(I)V", "getPanelType", "()I", "contentEquals", "", "other", "", "plugin-emojisdk_release"})
public final class u
  extends ae
{
  public final int jJL;
  
  public u(int paramInt)
  {
    super(8);
    this.jJL = paramInt;
  }
  
  public final boolean ba(Object paramObject)
  {
    AppMethodBeat.i(234780);
    if ((super.ba(paramObject)) && ((paramObject instanceof u)) && (this.jJL == ((u)paramObject).jJL))
    {
      AppMethodBeat.o(234780);
      return true;
    }
    AppMethodBeat.o(234780);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.u
 * JD-Core Version:    0.7.0.1
 */