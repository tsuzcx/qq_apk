package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache$CacheKey;", "", "feedId", "", "refCommentId", "(JJ)V", "getFeedId", "()J", "getRefCommentId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
public final class e$a
{
  final long dig;
  private final long qXy;
  
  public e$a(long paramLong1, long paramLong2)
  {
    this.dig = paramLong1;
    this.qXy = paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.dig != paramObject.dig) || (this.qXy != paramObject.qXy)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    long l = this.dig;
    int i = (int)(l ^ l >>> 32);
    l = this.qXy;
    return i * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167048);
    String str = "CacheKey(feedId=" + this.dig + ", refCommentId=" + this.qXy + ")";
    AppMethodBeat.o(167048);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.e.a
 * JD-Core Version:    0.7.0.1
 */