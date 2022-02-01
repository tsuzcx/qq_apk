package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/panel/EntranceItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "entranceType", "", "(I)V", "getEntranceType", "()I", "equals", "", "other", "", "plugin-emojisdk_release"})
public final class m
  extends ac
{
  public final int glr;
  
  public m(int paramInt)
  {
    super(3);
    this.glr = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(105558);
    if ((super.equals(paramObject)) && ((paramObject instanceof m)) && (((m)paramObject).glr == this.glr))
    {
      AppMethodBeat.o(105558);
      return true;
    }
    AppMethodBeat.o(105558);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.m
 * JD-Core Version:    0.7.0.1
 */