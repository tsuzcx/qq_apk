package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/storage/FinderGridLayoutConfig$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
public final class k$b
  extends RecyclerView.h
{
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(204232);
    p.h(paramRect, "outRect");
    p.h(paramView, "view");
    p.h(paramRecyclerView, "parent");
    p.h(paramt, "state");
    paramt = paramView.getContext();
    p.g(paramt, "view.context");
    paramt.getResources().getDimension(2131165274);
    int i = a.h(paramView.getContext(), 0.5F);
    int j = RecyclerView.bw(paramView);
    if (j == 0)
    {
      paramRect.left = 0;
      paramRect.right = 0;
      paramRect.bottom = 0;
      paramRect.top = 0;
      AppMethodBeat.o(204232);
      return;
    }
    paramView = paramRecyclerView.getAdapter();
    if (paramView == null) {
      p.gkB();
    }
    p.g(paramView, "parent.adapter!!");
    if (j >= paramView.getItemCount())
    {
      paramRect.left = 0;
      paramRect.right = 0;
      paramRect.bottom = 0;
      paramRect.top = 0;
      AppMethodBeat.o(204232);
      return;
    }
    j -= 1;
    if (j % this.sIO.sge == 0)
    {
      paramRect.left = 0;
      paramRect.right = i;
      paramRect.bottom = i;
      paramRect.top = i;
      AppMethodBeat.o(204232);
      return;
    }
    if (j % this.sIO.sge == this.sIO.sge - 1)
    {
      paramRect.left = i;
      paramRect.right = 0;
      paramRect.bottom = i;
      paramRect.top = i;
      AppMethodBeat.o(204232);
      return;
    }
    paramRect.left = i;
    paramRect.right = i;
    paramRect.bottom = i;
    paramRect.top = i;
    AppMethodBeat.o(204232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.k.b
 * JD-Core Version:    0.7.0.1
 */