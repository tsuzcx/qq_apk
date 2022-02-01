package com.tencent.mm.plugin.finder.search;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderFeedSearchUI$ReportData;", "", "id", "", "query", "", "requestId", "(JLjava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getQuery", "()Ljava/lang/String;", "getRequestId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder_release"})
public final class FinderFeedSearchUI$c
{
  final String fIY;
  private final long id;
  final String query;
  
  public FinderFeedSearchUI$c(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(292271);
    this.id = paramLong;
    this.query = paramString1;
    this.fIY = paramString2;
    AppMethodBeat.o(292271);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(292274);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((this.id != paramObject.id) || (!p.h(this.query, paramObject.query)) || (!p.h(this.fIY, paramObject.fIY))) {}
      }
    }
    else
    {
      AppMethodBeat.o(292274);
      return true;
    }
    AppMethodBeat.o(292274);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(292273);
    long l = this.id;
    int k = (int)(l ^ l >>> 32);
    String str = this.query;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      str = this.fIY;
      if (str != null) {
        j = str.hashCode();
      }
      AppMethodBeat.o(292273);
      return (i + k * 31) * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(292272);
    String str = "ReportData(id=" + this.id + ", query=" + this.query + ", requestId=" + this.fIY + ")";
    AppMethodBeat.o(292272);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderFeedSearchUI.c
 * JD-Core Version:    0.7.0.1
 */