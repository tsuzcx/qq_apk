package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.m;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerResultData;", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "(ILjava/util/List;)V", "getCommentCount", "()I", "getData", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class e$a$c
{
  final int commentCount;
  final List<m> pdB;
  
  public e$a$c(int paramInt, List<? extends m> paramList)
  {
    AppMethodBeat.i(205070);
    this.commentCount = paramInt;
    this.pdB = paramList;
    AppMethodBeat.o(205070);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205073);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((this.commentCount != paramObject.commentCount) || (!p.i(this.pdB, paramObject.pdB))) {}
      }
    }
    else
    {
      AppMethodBeat.o(205073);
      return true;
    }
    AppMethodBeat.o(205073);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205072);
    int j = this.commentCount;
    List localList = this.pdB;
    if (localList != null) {}
    for (int i = localList.hashCode();; i = 0)
    {
      AppMethodBeat.o(205072);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205071);
    String str = "DrawerResultData(commentCount=" + this.commentCount + ", data=" + this.pdB + ")";
    AppMethodBeat.o(205071);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.e.a.c
 * JD-Core Version:    0.7.0.1
 */