package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/utils/FinderObjectStatusRefresher$ObjectStatusReqState;", "", "lastReqTime", "", "waitTime", "(JJ)V", "getLastReqTime", "()J", "getWaitTime", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
public final class i$a
{
  final long rOU;
  final long waitTime;
  
  public i$a(long paramLong1, long paramLong2)
  {
    this.rOU = paramLong1;
    this.waitTime = paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.rOU != paramObject.rOU) || (this.waitTime != paramObject.waitTime)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    long l = this.rOU;
    int i = (int)(l ^ l >>> 32);
    l = this.waitTime;
    return i * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167890);
    String str = "ObjectStatusReqState(lastReqTime=" + this.rOU + ", waitTime=" + this.waitTime + ")";
    AppMethodBeat.o(167890);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.i.a
 * JD-Core Version:    0.7.0.1
 */