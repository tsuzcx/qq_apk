package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-core_release"})
public final class a
{
  public String name;
  
  public a(String paramString)
  {
    AppMethodBeat.i(196820);
    this.name = paramString;
    AppMethodBeat.o(196820);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(196823);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if (!p.i(this.name, paramObject.name)) {}
      }
    }
    else
    {
      AppMethodBeat.o(196823);
      return true;
    }
    AppMethodBeat.o(196823);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(196822);
    String str = this.name;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(196822);
      return i;
    }
    AppMethodBeat.o(196822);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(196821);
    String str = "LiveJumpInfo(name=" + this.name + ")";
    AppMethodBeat.o(196821);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.a
 * JD-Core Version:    0.7.0.1
 */