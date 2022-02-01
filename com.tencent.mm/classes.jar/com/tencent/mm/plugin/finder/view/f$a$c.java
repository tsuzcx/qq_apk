package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.t;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerResultData;", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "(ILjava/util/List;)V", "getCommentCount", "()I", "getData", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$a$c
{
  final List<t> bMf;
  final int commentCount;
  
  public f$a$c(int paramInt, List<? extends t> paramList)
  {
    AppMethodBeat.i(344520);
    this.commentCount = paramInt;
    this.bMf = paramList;
    AppMethodBeat.o(344520);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(344534);
    if (this == paramObject)
    {
      AppMethodBeat.o(344534);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(344534);
      return false;
    }
    paramObject = (c)paramObject;
    if (this.commentCount != paramObject.commentCount)
    {
      AppMethodBeat.o(344534);
      return false;
    }
    if (!s.p(this.bMf, paramObject.bMf))
    {
      AppMethodBeat.o(344534);
      return false;
    }
    AppMethodBeat.o(344534);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(344529);
    int i = this.commentCount;
    int j = this.bMf.hashCode();
    AppMethodBeat.o(344529);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(344524);
    String str = "DrawerResultData(commentCount=" + this.commentCount + ", data=" + this.bMf + ')';
    AppMethodBeat.o(344524);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.f.a.c
 * JD-Core Version:    0.7.0.1
 */