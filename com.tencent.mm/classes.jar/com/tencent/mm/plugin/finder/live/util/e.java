package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "", "key", "", "valueCount", "", "times", "", "averageValue", "(Ljava/lang/String;JIJ)V", "getAverageValue", "()J", "setAverageValue", "(J)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getTimes", "()I", "setTimes", "(I)V", "getValueCount", "setValueCount", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder-base_release"})
public final class e
{
  private String key;
  int mgw;
  long yPF;
  long yPG;
  
  public e()
  {
    this(null, 15);
  }
  
  private e(String paramString)
  {
    AppMethodBeat.i(263704);
    this.key = paramString;
    this.yPF = 0L;
    this.mgw = 0;
    this.yPG = 0L;
    AppMethodBeat.o(263704);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(263708);
    if (this != paramObject)
    {
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
        if ((!p.h(this.key, paramObject.key)) || (this.yPF != paramObject.yPF) || (this.mgw != paramObject.mgw) || (this.yPG != paramObject.yPG)) {}
      }
    }
    else
    {
      AppMethodBeat.o(263708);
      return true;
    }
    AppMethodBeat.o(263708);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(263707);
    String str = this.key;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      long l = this.yPF;
      int j = (int)(l ^ l >>> 32);
      int k = this.mgw;
      l = this.yPG;
      int m = (int)(l ^ l >>> 32);
      AppMethodBeat.o(263707);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(263706);
    String str = "AverageCachePair(key=" + this.key + ", valueCount=" + this.yPF + ", times=" + this.mgw + ", averageValue=" + this.yPG + ")";
    AppMethodBeat.o(263706);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.e
 * JD-Core Version:    0.7.0.1
 */