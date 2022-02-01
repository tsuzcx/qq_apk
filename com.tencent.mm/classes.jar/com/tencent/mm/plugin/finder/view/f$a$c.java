package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.s;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerResultData;", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "(ILjava/util/List;)V", "getCommentCount", "()I", "getData", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class f$a$c
{
  final int commentCount;
  final List<s> tYs;
  
  public f$a$c(int paramInt, List<? extends s> paramList)
  {
    AppMethodBeat.i(268327);
    this.commentCount = paramInt;
    this.tYs = paramList;
    AppMethodBeat.o(268327);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(268332);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((this.commentCount != paramObject.commentCount) || (!p.h(this.tYs, paramObject.tYs))) {}
      }
    }
    else
    {
      AppMethodBeat.o(268332);
      return true;
    }
    AppMethodBeat.o(268332);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(268331);
    int j = this.commentCount;
    List localList = this.tYs;
    if (localList != null) {}
    for (int i = localList.hashCode();; i = 0)
    {
      AppMethodBeat.o(268331);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(268330);
    String str = "DrawerResultData(commentCount=" + this.commentCount + ", data=" + this.tYs + ")";
    AppMethodBeat.o(268330);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.f.a.c
 * JD-Core Version:    0.7.0.1
 */