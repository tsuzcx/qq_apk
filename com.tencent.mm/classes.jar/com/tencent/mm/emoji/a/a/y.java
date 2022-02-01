package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/panel/PanelItem;", "", "type", "", "(I)V", "getType", "()I", "contentEquals", "", "other", "equals", "plugin-emojisdk_release"})
public class y
{
  public final int type;
  
  public y(int paramInt)
  {
    this.type = paramInt;
  }
  
  public boolean aT(Object paramObject)
  {
    AppMethodBeat.i(105573);
    boolean bool = equals(paramObject);
    AppMethodBeat.o(105573);
    return bool;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof y)) && (((y)paramObject).type == this.type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.y
 * JD-Core Version:    0.7.0.1
 */