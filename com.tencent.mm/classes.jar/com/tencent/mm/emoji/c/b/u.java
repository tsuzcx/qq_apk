package com.tencent.mm.emoji.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/panel/GroupLoadingMoreItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "panelType", "", "(I)V", "getPanelType", "()I", "contentEquals", "", "other", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends ae
{
  public final int mjd;
  
  public u(int paramInt)
  {
    super(8);
    this.mjd = paramInt;
  }
  
  public final boolean cv(Object paramObject)
  {
    AppMethodBeat.i(242718);
    if ((super.cv(paramObject)) && ((paramObject instanceof u)) && (this.mjd == ((u)paramObject).mjd))
    {
      AppMethodBeat.o(242718);
      return true;
    }
    AppMethodBeat.o(242718);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b.u
 * JD-Core Version:    0.7.0.1
 */