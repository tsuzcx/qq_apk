package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "", "key", "", "value", "", "times", "(Ljava/lang/String;II)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getTimes", "()I", "setTimes", "(I)V", "getValue", "setValue", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  String key;
  int oZt;
  int value;
  
  public i()
  {
    this(null, 0, 7);
  }
  
  private i(String paramString, int paramInt)
  {
    AppMethodBeat.i(351279);
    this.key = paramString;
    this.value = paramInt;
    this.oZt = 0;
    AppMethodBeat.o(351279);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(351319);
    if (this == paramObject)
    {
      AppMethodBeat.o(351319);
      return true;
    }
    if (!(paramObject instanceof i))
    {
      AppMethodBeat.o(351319);
      return false;
    }
    paramObject = (i)paramObject;
    if (!s.p(this.key, paramObject.key))
    {
      AppMethodBeat.o(351319);
      return false;
    }
    if (this.value != paramObject.value)
    {
      AppMethodBeat.o(351319);
      return false;
    }
    if (this.oZt != paramObject.oZt)
    {
      AppMethodBeat.o(351319);
      return false;
    }
    AppMethodBeat.o(351319);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(351307);
    int i = this.key.hashCode();
    int j = this.value;
    int k = this.oZt;
    AppMethodBeat.o(351307);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(351297);
    String str = "CachePair(key=" + this.key + ", value=" + this.value + ", times=" + this.oZt + ')';
    AppMethodBeat.o(351297);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.i
 * JD-Core Version:    0.7.0.1
 */