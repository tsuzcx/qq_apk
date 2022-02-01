package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.s;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerResultData;", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "(ILjava/util/List;)V", "getCommentCount", "()I", "getData", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class e$a$c
{
  final int commentCount;
  final List<s> qzs;
  
  public e$a$c(int paramInt, List<? extends s> paramList)
  {
    AppMethodBeat.i(254715);
    this.commentCount = paramInt;
    this.qzs = paramList;
    AppMethodBeat.o(254715);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(254718);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((this.commentCount != paramObject.commentCount) || (!p.j(this.qzs, paramObject.qzs))) {}
      }
    }
    else
    {
      AppMethodBeat.o(254718);
      return true;
    }
    AppMethodBeat.o(254718);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(254717);
    int j = this.commentCount;
    List localList = this.qzs;
    if (localList != null) {}
    for (int i = localList.hashCode();; i = 0)
    {
      AppMethodBeat.o(254717);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(254716);
    String str = "DrawerResultData(commentCount=" + this.commentCount + ", data=" + this.qzs + ")";
    AppMethodBeat.o(254716);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.e.a.c
 * JD-Core Version:    0.7.0.1
 */