package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.n;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerResultData;", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "(ILjava/util/List;)V", "getCommentCount", "()I", "getData", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class e$a$c
{
  final int commentCount;
  final List<n> pkh;
  
  public e$a$c(int paramInt, List<? extends n> paramList)
  {
    AppMethodBeat.i(205700);
    this.commentCount = paramInt;
    this.pkh = paramList;
    AppMethodBeat.o(205700);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205703);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((this.commentCount != paramObject.commentCount) || (!p.i(this.pkh, paramObject.pkh))) {}
      }
    }
    else
    {
      AppMethodBeat.o(205703);
      return true;
    }
    AppMethodBeat.o(205703);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205702);
    int j = this.commentCount;
    List localList = this.pkh;
    if (localList != null) {}
    for (int i = localList.hashCode();; i = 0)
    {
      AppMethodBeat.o(205702);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205701);
    String str = "DrawerResultData(commentCount=" + this.commentCount + ", data=" + this.pkh + ")";
    AppMethodBeat.o(205701);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.e.a.c
 * JD-Core Version:    0.7.0.1
 */