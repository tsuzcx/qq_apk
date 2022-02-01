package com.tencent.mm.emoji.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/panel/EntranceItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "entranceType", "", "(I)V", "getEntranceType", "()I", "equals", "", "other", "", "plugin-emojisdk_release"})
public final class m
  extends ac
{
  public final int gnM;
  
  public m(int paramInt)
  {
    super(3);
    this.gnM = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(105558);
    if ((super.equals(paramObject)) && ((paramObject instanceof m)) && (((m)paramObject).gnM == this.gnM))
    {
      AppMethodBeat.o(105558);
      return true;
    }
    AppMethodBeat.o(105558);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.m
 * JD-Core Version:    0.7.0.1
 */