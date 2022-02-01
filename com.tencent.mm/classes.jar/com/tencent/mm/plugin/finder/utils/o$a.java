package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderObjectStatusRefresher$ObjectStatusReqState;", "", "lastReqTime", "", "waitTime", "(JJ)V", "getLastReqTime", "()J", "getWaitTime", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
public final class o$a
{
  final long vVU;
  final long waitTime;
  
  public o$a(long paramLong1, long paramLong2)
  {
    this.vVU = paramLong1;
    this.waitTime = paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.vVU != paramObject.vVU) || (this.waitTime != paramObject.waitTime)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    long l = this.vVU;
    int i = (int)(l ^ l >>> 32);
    l = this.waitTime;
    return i * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167890);
    String str = "ObjectStatusReqState(lastReqTime=" + this.vVU + ", waitTime=" + this.waitTime + ")";
    AppMethodBeat.o(167890);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.o.a
 * JD-Core Version:    0.7.0.1
 */