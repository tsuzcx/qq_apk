package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "", "key", "", "valueCount", "", "times", "", "averageValue", "(Ljava/lang/String;JIJ)V", "getAverageValue", "()J", "setAverageValue", "(J)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getTimes", "()I", "setTimes", "(I)V", "getValueCount", "setValueCount", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
public final class e
{
  int hjI;
  private String key;
  long uvZ;
  public long uwa;
  
  public e()
  {
    this(null, 15);
  }
  
  private e(String paramString)
  {
    AppMethodBeat.i(247229);
    this.key = paramString;
    this.uvZ = 0L;
    this.hjI = 0;
    this.uwa = 0L;
    AppMethodBeat.o(247229);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(247233);
    if (this != paramObject)
    {
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
        if ((!p.j(this.key, paramObject.key)) || (this.uvZ != paramObject.uvZ) || (this.hjI != paramObject.hjI) || (this.uwa != paramObject.uwa)) {}
      }
    }
    else
    {
      AppMethodBeat.o(247233);
      return true;
    }
    AppMethodBeat.o(247233);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(247232);
    String str = this.key;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      long l = this.uvZ;
      int j = (int)(l ^ l >>> 32);
      int k = this.hjI;
      l = this.uwa;
      int m = (int)(l ^ l >>> 32);
      AppMethodBeat.o(247232);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(247231);
    String str = "AverageCachePair(key=" + this.key + ", valueCount=" + this.uvZ + ", times=" + this.hjI + ", averageValue=" + this.uwa + ")";
    AppMethodBeat.o(247231);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.e
 * JD-Core Version:    0.7.0.1
 */