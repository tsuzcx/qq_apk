package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/panel/PanelItem;", "", "type", "", "(I)V", "getType", "()I", "contentEquals", "", "other", "equals", "plugin-emojisdk_release"})
public class ae
{
  public final int type;
  
  public ae(int paramInt)
  {
    this.type = paramInt;
  }
  
  public boolean ba(Object paramObject)
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
 * Qualified Name:     com.tencent.mm.emoji.b.b.ae
 * JD-Core Version:    0.7.0.1
 */