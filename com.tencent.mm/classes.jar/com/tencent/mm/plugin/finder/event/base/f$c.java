package com.tencent.mm.plugin.finder.event.base;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.h;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
public final class f$c
  extends RecyclerView.m
{
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201417);
    Object localObject = new b();
    ((b)localObject).bb(paramRecyclerView);
    ((b)localObject).lS(paramInt1);
    ((b)localObject).lS(paramInt2);
    a.b("com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((b)localObject).aeE());
    k.h(paramRecyclerView, "recyclerView");
    super.a(paramRecyclerView, paramInt1, paramInt2);
    if (this.rdA.rdr)
    {
      localObject = paramRecyclerView.getLayoutManager();
      if (localObject != null)
      {
        if (!((RecyclerView.i)localObject).jM()) {
          break label232;
        }
        paramInt1 = Math.abs(paramInt1);
        localObject = this.rdA;
        ((f)localObject).rdu += paramInt1;
        this.rdA.rdw[this.rdA.rdv] = paramInt1;
        this.rdA.rdv = ((this.rdA.rdv + 1) % this.rdA.rdw.length);
        if (this.rdA.rds != 1) {
          break label237;
        }
        if (this.rdA.rdu > this.rdA.rdq * 5)
        {
          ac.i(this.rdA.TAG, "publish DRAGGING_DISTANCE");
          this.rdA.g(paramRecyclerView, 3);
          this.rdA.rdu = 0;
        }
      }
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(201417);
      return;
      label232:
      paramInt1 = paramInt2;
      break;
      label237:
      if (this.rdA.rds == 2)
      {
        localObject = this.rdA.rdw;
        k.h(localObject, "$this$average");
        double d1 = 0.0D;
        paramInt2 = 0;
        int i = localObject.length;
        paramInt1 = 0;
        while (paramInt1 < i)
        {
          d1 += localObject[paramInt1];
          paramInt2 += 1;
          paramInt1 += 1;
        }
        if (paramInt2 == 0) {
          localObject = h.KUJ;
        }
        double d2;
        for (d1 = h.fOx();; d1 /= paramInt2)
        {
          localObject = this.rdA.rdw;
          d2 = 0.0D;
          paramInt2 = localObject.length;
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            d2 += Math.pow(localObject[paramInt1] - d1, 2.0D);
            paramInt1 += 1;
          }
        }
        d2 /= localObject.length;
        if ((d1 < 50.0D) && (d2 < 50.0D) && (this.rdA.rdu > this.rdA.rdq * 5))
        {
          ac.i(this.rdA.TAG, "publish LOW_SPEED_FLING");
          this.rdA.g(paramRecyclerView, 8);
          this.rdA.rdu = 0;
        }
      }
    }
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(201416);
    Object localObject = new b();
    ((b)localObject).bb(paramRecyclerView);
    ((b)localObject).lS(paramInt);
    a.b("com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((b)localObject).aeE());
    k.h(paramRecyclerView, "recyclerView");
    super.b(paramRecyclerView, paramInt);
    if (this.rdA.rdp == null)
    {
      localObject = this.rdA;
      Rect localRect = new Rect();
      paramRecyclerView.getGlobalVisibleRect(localRect);
      ((f)localObject).rdp = localRect;
    }
    if (this.rdA.rds != paramInt)
    {
      this.rdA.rdt = this.rdA.rds;
      this.rdA.rds = paramInt;
    }
    this.rdA.g(paramRecyclerView, paramInt);
    if (this.rdA.rds == 0)
    {
      paramRecyclerView = this.rdA;
      localObject = new int[5];
      k.h(localObject, "<set-?>");
      paramRecyclerView.rdw = ((int[])localObject);
      this.rdA.rdv = 0;
    }
    a.a(this, "com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
    AppMethodBeat.o(201416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.f.c
 * JD-Core Version:    0.7.0.1
 */