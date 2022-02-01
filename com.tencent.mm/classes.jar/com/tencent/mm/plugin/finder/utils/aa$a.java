package com.tencent.mm.plugin.finder.utils;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderObjectStatusRefresher$ObjectStatusReqState;", "", "lastReqTime", "", "waitTime", "(JJ)V", "getLastReqTime", "()J", "getWaitTime", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa$a
{
  final long Ghb;
  final long waitTime;
  
  public aa$a(long paramLong1, long paramLong2)
  {
    this.Ghb = paramLong1;
    this.waitTime = paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      if (this.Ghb != paramObject.Ghb) {
        return false;
      }
    } while (this.waitTime == paramObject.waitTime);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(333495);
    int i = q.a..ExternalSyntheticBackport0.m(this.Ghb);
    int j = q.a..ExternalSyntheticBackport0.m(this.waitTime);
    AppMethodBeat.o(333495);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167890);
    String str = "ObjectStatusReqState(lastReqTime=" + this.Ghb + ", waitTime=" + this.waitTime + ')';
    AppMethodBeat.o(167890);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.aa.a
 * JD-Core Version:    0.7.0.1
 */