package com.tencent.mm.plugin.finder.live.util;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "", "key", "", "valueCount", "", "times", "", "averageValue", "(Ljava/lang/String;JIJ)V", "getAverageValue", "()J", "setAverageValue", "(J)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getTimes", "()I", "setTimes", "(I)V", "getValueCount", "setValueCount", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  long DIm;
  long DIn;
  private String key;
  int oZt;
  
  public e()
  {
    this(null, 15);
  }
  
  private e(String paramString)
  {
    AppMethodBeat.i(351340);
    this.key = paramString;
    this.DIm = 0L;
    this.oZt = 0;
    this.DIn = 0L;
    AppMethodBeat.o(351340);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(351382);
    if (this == paramObject)
    {
      AppMethodBeat.o(351382);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(351382);
      return false;
    }
    paramObject = (e)paramObject;
    if (!s.p(this.key, paramObject.key))
    {
      AppMethodBeat.o(351382);
      return false;
    }
    if (this.DIm != paramObject.DIm)
    {
      AppMethodBeat.o(351382);
      return false;
    }
    if (this.oZt != paramObject.oZt)
    {
      AppMethodBeat.o(351382);
      return false;
    }
    if (this.DIn != paramObject.DIn)
    {
      AppMethodBeat.o(351382);
      return false;
    }
    AppMethodBeat.o(351382);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(351373);
    int i = this.key.hashCode();
    int j = q.a..ExternalSyntheticBackport0.m(this.DIm);
    int k = this.oZt;
    int m = q.a..ExternalSyntheticBackport0.m(this.DIn);
    AppMethodBeat.o(351373);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(351363);
    String str = "AverageCachePair(key=" + this.key + ", valueCount=" + this.DIm + ", times=" + this.oZt + ", averageValue=" + this.DIn + ')';
    AppMethodBeat.o(351363);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.e
 * JD-Core Version:    0.7.0.1
 */