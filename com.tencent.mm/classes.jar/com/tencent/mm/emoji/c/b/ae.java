package com.tencent.mm.emoji.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/panel/PanelItem;", "", "type", "", "(I)V", "getType", "()I", "contentEquals", "", "other", "equals", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class ae
{
  public final int type;
  
  public ae(int paramInt)
  {
    this.type = paramInt;
  }
  
  public boolean cv(Object paramObject)
  {
    AppMethodBeat.i(105573);
    boolean bool = equals(paramObject);
    AppMethodBeat.o(105573);
    return bool;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof ae)) && (((ae)paramObject).type == this.type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b.ae
 * JD-Core Version:    0.7.0.1
 */