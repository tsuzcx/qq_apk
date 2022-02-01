package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$SmileySpanInfo;", "", "start", "", "count", "(II)V", "getCount", "()I", "getStart", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class w$b
{
  final int count;
  final int start;
  
  public w$b(int paramInt1, int paramInt2)
  {
    this.start = paramInt1;
    this.count = paramInt2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
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
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.w.b
 * JD-Core Version:    0.7.0.1
 */