package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerResultData;", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "(ILjava/util/List;)V", "getCommentCount", "()I", "getData", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class d$a$c
{
  final int commentCount;
  final List<com.tencent.mm.plugin.finder.model.l> oAg;
  
  public d$a$c(int paramInt, List<? extends com.tencent.mm.plugin.finder.model.l> paramList)
  {
    AppMethodBeat.i(204112);
    this.commentCount = paramInt;
    this.oAg = paramList;
    AppMethodBeat.o(204112);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204115);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((this.commentCount != paramObject.commentCount) || (!k.g(this.oAg, paramObject.oAg))) {}
      }
    }
    else
    {
      AppMethodBeat.o(204115);
      return true;
    }
    AppMethodBeat.o(204115);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204114);
    int j = this.commentCount;
    List localList = this.oAg;
    if (localList != null) {}
    for (int i = localList.hashCode();; i = 0)
    {
      AppMethodBeat.o(204114);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204113);
    String str = "DrawerResultData(commentCount=" + this.commentCount + ", data=" + this.oAg + ")";
    AppMethodBeat.o(204113);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.d.a.c
 * JD-Core Version:    0.7.0.1
 */