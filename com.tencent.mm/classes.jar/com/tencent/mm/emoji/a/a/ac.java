package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/panel/PanelItem;", "", "type", "", "(I)V", "getType", "()I", "contentEquals", "", "other", "equals", "plugin-emojisdk_release"})
public class ac
{
  public final int type;
  
  public ac(int paramInt)
  {
    this.type = paramInt;
  }
  
  public boolean aS(Object paramObject)
  {
    AppMethodBeat.i(105573);
    boolean bool = equals(paramObject);
    AppMethodBeat.o(105573);
    return bool;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof ac)) && (((ac)paramObject).type == this.type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.ac
 * JD-Core Version:    0.7.0.1
 */