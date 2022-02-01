package com.tencent.mm.live.core.core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public String name;
  
  public d(String paramString)
  {
    AppMethodBeat.i(247890);
    this.name = paramString;
    AppMethodBeat.o(247890);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(247910);
    if (this == paramObject)
    {
      AppMethodBeat.o(247910);
      return true;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(247910);
      return false;
    }
    paramObject = (d)paramObject;
    if (!s.p(this.name, paramObject.name))
    {
      AppMethodBeat.o(247910);
      return false;
    }
    AppMethodBeat.o(247910);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(247903);
    int i = this.name.hashCode();
    AppMethodBeat.o(247903);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(247896);
    String str = "LiveJumpInfo(name=" + this.name + ')';
    AppMethodBeat.o(247896);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.model.d
 * JD-Core Version:    0.7.0.1
 */