package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-core_release"})
public final class a
{
  public String name;
  
  public a(String paramString)
  {
    AppMethodBeat.i(209151);
    this.name = paramString;
    AppMethodBeat.o(209151);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(209154);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if (!k.g(this.name, paramObject.name)) {}
      }
    }
    else
    {
      AppMethodBeat.o(209154);
      return true;
    }
    AppMethodBeat.o(209154);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(209153);
    String str = this.name;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(209153);
      return i;
    }
    AppMethodBeat.o(209153);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(209152);
    String str = "LiveJumpInfo(name=" + this.name + ")";
    AppMethodBeat.o(209152);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.a
 * JD-Core Version:    0.7.0.1
 */