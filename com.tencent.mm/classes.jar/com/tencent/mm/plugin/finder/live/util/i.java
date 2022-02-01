package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "", "key", "", "value", "", "times", "(Ljava/lang/String;II)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getTimes", "()I", "setTimes", "(I)V", "getValue", "setValue", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder-base_release"})
public final class i
{
  String key;
  int mgw;
  int value;
  
  public i()
  {
    this(null, 0, 7);
  }
  
  private i(String paramString, int paramInt)
  {
    AppMethodBeat.i(258037);
    this.key = paramString;
    this.value = paramInt;
    this.mgw = 0;
    AppMethodBeat.o(258037);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(258042);
    if (this != paramObject)
    {
      if ((paramObject instanceof i))
      {
        paramObject = (i)paramObject;
        if ((!p.h(this.key, paramObject.key)) || (this.value != paramObject.value) || (this.mgw != paramObject.mgw)) {}
      }
    }
    else
    {
      AppMethodBeat.o(258042);
      return true;
    }
    AppMethodBeat.o(258042);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(258040);
    String str = this.key;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int j = this.value;
      int k = this.mgw;
      AppMethodBeat.o(258040);
      return (i * 31 + j) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(258039);
    String str = "CachePair(key=" + this.key + ", value=" + this.value + ", times=" + this.mgw + ")";
    AppMethodBeat.o(258039);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.i
 * JD-Core Version:    0.7.0.1
 */