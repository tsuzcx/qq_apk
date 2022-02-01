package com.tencent.mm.emoji.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/panel/EntranceItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "entranceType", "", "(I)V", "getEntranceType", "()I", "equals", "", "other", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends ae
{
  public final int miZ;
  
  public m(int paramInt)
  {
    super(3);
    this.miZ = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(105558);
    if ((super.equals(paramObject)) && ((paramObject instanceof m)) && (((m)paramObject).miZ == this.miZ))
    {
      AppMethodBeat.o(105558);
      return true;
    }
    AppMethodBeat.o(105558);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b.m
 * JD-Core Version:    0.7.0.1
 */