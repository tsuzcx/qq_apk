package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/panel/EntranceItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "entranceType", "", "(I)V", "getEntranceType", "()I", "equals", "", "other", "", "plugin-emojisdk_release"})
public final class m
  extends y
{
  public final int fOf;
  
  public m(int paramInt)
  {
    super(3);
    this.fOf = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(105558);
    if ((super.equals(paramObject)) && ((paramObject instanceof m)) && (((m)paramObject).fOf == this.fOf))
    {
      AppMethodBeat.o(105558);
      return true;
    }
    AppMethodBeat.o(105558);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.m
 * JD-Core Version:    0.7.0.1
 */