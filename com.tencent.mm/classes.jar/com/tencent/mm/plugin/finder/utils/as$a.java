package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$SmileySpanInfo;", "", "start", "", "count", "(II)V", "getCount", "()I", "getStart", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class as$a
{
  final int count;
  final int start;
  
  public as$a(int paramInt1, int paramInt2)
  {
    this.start = paramInt1;
    this.count = paramInt2;
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
      if (this.start != paramObject.start) {
        return false;
      }
    } while (this.count == paramObject.count);
    return false;
  }
  
  public final int hashCode()
  {
    return this.start * 31 + this.count;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167911);
    String str = "SmileySpanInfo(start=" + this.start + ", count=" + this.count + ')';
    AppMethodBeat.o(167911);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.as.a
 * JD-Core Version:    0.7.0.1
 */