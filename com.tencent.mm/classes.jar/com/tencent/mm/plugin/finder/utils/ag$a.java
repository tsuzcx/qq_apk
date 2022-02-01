package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$SmileySpanInfo;", "", "start", "", "count", "(II)V", "getCount", "()I", "getStart", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class ag$a
{
  final int count;
  final int start;
  
  public ag$a(int paramInt1, int paramInt2)
  {
    this.start = paramInt1;
    this.count = paramInt2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.start != paramObject.start) || (this.count != paramObject.count)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.start * 31 + this.count;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167911);
    String str = "SmileySpanInfo(start=" + this.start + ", count=" + this.count + ")";
    AppMethodBeat.o(167911);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ag.a
 * JD-Core Version:    0.7.0.1
 */