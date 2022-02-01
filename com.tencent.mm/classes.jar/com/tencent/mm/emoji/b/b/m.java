package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/panel/EntranceItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "entranceType", "", "(I)V", "getEntranceType", "()I", "equals", "", "other", "", "plugin-emojisdk_release"})
public final class m
  extends ac
{
  public final int gYH;
  
  public m(int paramInt)
  {
    super(3);
    this.gYH = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(105558);
    if ((super.equals(paramObject)) && ((paramObject instanceof m)) && (((m)paramObject).gYH == this.gYH))
    {
      AppMethodBeat.o(105558);
      return true;
    }
    AppMethodBeat.o(105558);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.m
 * JD-Core Version:    0.7.0.1
 */