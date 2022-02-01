package com.tencent.mm.plugin.finder.preload.tabPreload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$CacheTime;", "", "lastTime", "", "(J)V", "getLastTime", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
public final class f$b
{
  private final long hiI;
  
  public f$b(long paramLong)
  {
    this.hiI = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if (this.hiI != paramObject.hiI) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    long l = this.hiI;
    return (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203581);
    String str = "CacheTime(lastTime=" + this.hiI + ")";
    AppMethodBeat.o(203581);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.f.b
 * JD-Core Version:    0.7.0.1
 */