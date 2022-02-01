package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-core_release"})
public final class b
{
  public String name;
  
  public b(String paramString)
  {
    AppMethodBeat.i(196447);
    this.name = paramString;
    AppMethodBeat.o(196447);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(196450);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if (!p.j(this.name, paramObject.name)) {}
      }
    }
    else
    {
      AppMethodBeat.o(196450);
      return true;
    }
    AppMethodBeat.o(196450);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(196449);
    String str = this.name;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(196449);
      return i;
    }
    AppMethodBeat.o(196449);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(196448);
    String str = "LiveJumpInfo(name=" + this.name + ")";
    AppMethodBeat.o(196448);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.b
 * JD-Core Version:    0.7.0.1
 */