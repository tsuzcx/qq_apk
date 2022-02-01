package com.tencent.mm.plugin.finder.event.base;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
public final class e$a
  extends RecyclerView.m
{
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197536);
    Object localObject = new b();
    ((b)localObject).be(paramRecyclerView);
    ((b)localObject).lT(paramInt1);
    ((b)localObject).lT(paramInt2);
    a.b("com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((b)localObject).ado());
    k.h(paramRecyclerView, "recyclerView");
    super.a(paramRecyclerView, paramInt1, paramInt2);
    if (this.KMf.qsD == 2)
    {
      a.a(this, "com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(197536);
      return;
    }
    localObject = paramRecyclerView.getLayoutManager();
    if (localObject == null) {
      k.fvU();
    }
    k.g(localObject, "recyclerView.layoutManager!!");
    if (((RecyclerView.i)localObject).jE()) {}
    for (;;)
    {
      localObject = this.KMf;
      ((e)localObject).KMe += paramInt1;
      if ((Math.abs(this.KMf.KMe) > this.KMf.KMd * 5) || ((this.KMf.qsI == 2) && (this.KMf.qsD == 1)))
      {
        this.KMf.g(paramRecyclerView, 3);
        this.KMf.KMe = 0;
      }
      a.a(this, "com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(197536);
      return;
      paramInt1 = paramInt2;
    }
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(197535);
    Object localObject = new b();
    ((b)localObject).be(paramRecyclerView);
    ((b)localObject).lT(paramInt);
    a.b("com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((b)localObject).ado());
    k.h(paramRecyclerView, "recyclerView");
    super.b(paramRecyclerView, paramInt);
    if (this.KMf.KMc == null)
    {
      localObject = this.KMf;
      Rect localRect = new Rect();
      paramRecyclerView.getGlobalVisibleRect(localRect);
      ((e)localObject).KMc = localRect;
    }
    this.KMf.qsD = paramInt;
    this.KMf.g(paramRecyclerView, paramInt);
    this.KMf.qsI = this.KMf.qsD;
    a.a(this, "com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
    AppMethodBeat.o(197535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.e.a
 * JD-Core Version:    0.7.0.1
 */