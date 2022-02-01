package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-core_release"})
public final class a
{
  public String name;
  
  public a(String paramString)
  {
    AppMethodBeat.i(205618);
    this.name = paramString;
    AppMethodBeat.o(205618);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205621);
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
      AppMethodBeat.o(205621);
      return true;
    }
    AppMethodBeat.o(205621);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205620);
    String str = this.name;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(205620);
      return i;
    }
    AppMethodBeat.o(205620);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205619);
    String str = "LiveJumpInfo(name=" + this.name + ")";
    AppMethodBeat.o(205619);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.a
 * JD-Core Version:    0.7.0.1
 */