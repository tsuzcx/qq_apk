package com.tencent.mm.live.view.a;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$LiveCommentItemHolder;", "()V", "commentList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/CommentData;", "Lkotlin/collections/ArrayList;", "getCommentList", "()Ljava/util/ArrayList;", "sysSpan", "com/tencent/mm/live/view/adapter/LiveCommentAdapter$sysSpan$1", "Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$sysSpan$1;", "appendComment", "", "comment", "getItemCount", "", "onBindSysMsg", "context", "Landroid/content/Context;", "holder", "commentData", "onBindTextMsg", "onBindViewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "removeComment", "updateComments", "", "LiveCommentItemHolder", "LiveHeightSpan", "plugin-logic_release"})
public final class c
  extends RecyclerView.a<c.a>
{
  public final ArrayList<a> heL;
  private final c.b heM;
  
  public c()
  {
    AppMethodBeat.i(216695);
    this.heL = new ArrayList();
    this.heM = new c.b();
    AppMethodBeat.o(216695);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(216691);
    p.h(parama, "comment");
    int i = this.heL.size();
    this.heL.add(parama);
    ck(i);
    AppMethodBeat.o(216691);
  }
  
  public final void ab(List<a> paramList)
  {
    AppMethodBeat.i(216690);
    p.h(paramList, "commentList");
    this.heL.clear();
    this.heL.addAll((Collection)paramList);
    AppMethodBeat.o(216690);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(216693);
    int i = this.heL.size();
    AppMethodBeat.o(216693);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.view.a.c
 * JD-Core Version:    0.7.0.1
 */