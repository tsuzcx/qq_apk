package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "", "key", "", "value", "", "times", "(Ljava/lang/String;II)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getTimes", "()I", "setTimes", "(I)V", "getValue", "setValue", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
public final class i
{
  int hjI;
  public String key;
  public int value;
  
  public i()
  {
    this(null, 0, 7);
  }
  
  private i(String paramString, int paramInt)
  {
    AppMethodBeat.i(247242);
    this.key = paramString;
    this.value = paramInt;
    this.hjI = 0;
    AppMethodBeat.o(247242);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(247246);
    if (this != paramObject)
    {
      if ((paramObject instanceof i))
      {
        paramObject = (i)paramObject;
        if ((!p.j(this.key, paramObject.key)) || (this.value != paramObject.value) || (this.hjI != paramObject.hjI)) {}
      }
    }
    else
    {
      AppMethodBeat.o(247246);
      return true;
    }
    AppMethodBeat.o(247246);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(247245);
    String str = this.key;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int j = this.value;
      int k = this.hjI;
      AppMethodBeat.o(247245);
      return (i * 31 + j) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(247244);
    String str = "CachePair(key=" + this.key + ", value=" + this.value + ", times=" + this.hjI + ")";
    AppMethodBeat.o(247244);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.i
 * JD-Core Version:    0.7.0.1
 */