package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/LiveStatConstant$LiveStage;", "", "id", "", "name", "", "(ILjava/lang/String;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bb$c
{
  final int id;
  public final String name;
  
  public bb$c(int paramInt, String paramString)
  {
    AppMethodBeat.i(333725);
    this.id = paramInt;
    this.name = paramString;
    AppMethodBeat.o(333725);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(333756);
    if (this == paramObject)
    {
      AppMethodBeat.o(333756);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(333756);
      return false;
    }
    paramObject = (c)paramObject;
    if (this.id != paramObject.id)
    {
      AppMethodBeat.o(333756);
      return false;
    }
    if (!s.p(this.name, paramObject.name))
    {
      AppMethodBeat.o(333756);
      return false;
    }
    AppMethodBeat.o(333756);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(333747);
    int i = this.id;
    int j = this.name.hashCode();
    AppMethodBeat.o(333747);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(333731);
    String str = "LiveStage(id=" + this.id + ", name=" + this.name + ')';
    AppMethodBeat.o(333731);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.bb.c
 * JD-Core Version:    0.7.0.1
 */