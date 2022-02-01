package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/LiveStatConstant$LiveStage;", "", "id", "", "name", "", "(ILjava/lang/String;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
public final class ap$c
{
  final int id;
  public final String name;
  
  public ap$c(int paramInt, String paramString)
  {
    AppMethodBeat.i(266262);
    this.id = paramInt;
    this.name = paramString;
    AppMethodBeat.o(266262);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(266267);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((this.id != paramObject.id) || (!p.h(this.name, paramObject.name))) {}
      }
    }
    else
    {
      AppMethodBeat.o(266267);
      return true;
    }
    AppMethodBeat.o(266267);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(266265);
    int j = this.id;
    String str = this.name;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      AppMethodBeat.o(266265);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(266264);
    String str = "LiveStage(id=" + this.id + ", name=" + this.name + ")";
    AppMethodBeat.o(266264);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ap.c
 * JD-Core Version:    0.7.0.1
 */