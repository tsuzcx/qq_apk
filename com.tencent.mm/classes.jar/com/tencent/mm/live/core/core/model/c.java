package com.tencent.mm.live.core.core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-core_release"})
public final class c
{
  public String name;
  
  public c(String paramString)
  {
    AppMethodBeat.i(197959);
    this.name = paramString;
    AppMethodBeat.o(197959);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(197970);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if (!p.h(this.name, paramObject.name)) {}
      }
    }
    else
    {
      AppMethodBeat.o(197970);
      return true;
    }
    AppMethodBeat.o(197970);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(197967);
    String str = this.name;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(197967);
      return i;
    }
    AppMethodBeat.o(197967);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(197965);
    String str = "LiveJumpInfo(name=" + this.name + ")";
    AppMethodBeat.o(197965);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.core.core.model.c
 * JD-Core Version:    0.7.0.1
 */