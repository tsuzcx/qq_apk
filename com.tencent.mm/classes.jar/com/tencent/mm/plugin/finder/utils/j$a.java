package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/utils/FinderObjectStatusRefresher$ObjectStatusReqState;", "", "lastReqTime", "", "waitTime", "(JJ)V", "getLastReqTime", "()J", "getWaitTime", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
public final class j$a
{
  final long sWC;
  final long waitTime;
  
  public j$a(long paramLong1, long paramLong2)
  {
    this.sWC = paramLong1;
    this.waitTime = paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.sWC != paramObject.sWC) || (this.waitTime != paramObject.waitTime)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    long l = this.sWC;
    int i = (int)(l ^ l >>> 32);
    l = this.waitTime;
    return i * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167890);
    String str = "ObjectStatusReqState(lastReqTime=" + this.sWC + ", waitTime=" + this.waitTime + ")";
    AppMethodBeat.o(167890);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.j.a
 * JD-Core Version:    0.7.0.1
 */