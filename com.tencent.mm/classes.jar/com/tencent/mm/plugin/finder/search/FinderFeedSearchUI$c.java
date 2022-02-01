package com.tencent.mm.plugin.finder.search;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderFeedSearchUI$ReportData;", "", "id", "", "query", "", "requestId", "hotWordId", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHotWordId", "()Ljava/lang/String;", "getId", "()J", "getQuery", "getRequestId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFeedSearchUI$c
{
  final String FwD;
  final String hOG;
  private final long id;
  final String query;
  
  public FinderFeedSearchUI$c(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(342302);
    this.id = paramLong;
    this.query = paramString1;
    this.hOG = paramString2;
    this.FwD = paramString3;
    AppMethodBeat.o(342302);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(342322);
    if (this == paramObject)
    {
      AppMethodBeat.o(342322);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(342322);
      return false;
    }
    paramObject = (c)paramObject;
    if (this.id != paramObject.id)
    {
      AppMethodBeat.o(342322);
      return false;
    }
    if (!s.p(this.query, paramObject.query))
    {
      AppMethodBeat.o(342322);
      return false;
    }
    if (!s.p(this.hOG, paramObject.hOG))
    {
      AppMethodBeat.o(342322);
      return false;
    }
    if (!s.p(this.FwD, paramObject.FwD))
    {
      AppMethodBeat.o(342322);
      return false;
    }
    AppMethodBeat.o(342322);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(342314);
    int i = q.a..ExternalSyntheticBackport0.m(this.id);
    int j = this.query.hashCode();
    int k = this.hOG.hashCode();
    int m = this.FwD.hashCode();
    AppMethodBeat.o(342314);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(342305);
    String str = "ReportData(id=" + this.id + ", query=" + this.query + ", requestId=" + this.hOG + ", hotWordId=" + this.FwD + ')';
    AppMethodBeat.o(342305);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderFeedSearchUI.c
 * JD-Core Version:    0.7.0.1
 */