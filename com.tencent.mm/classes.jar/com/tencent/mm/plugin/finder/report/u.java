package com.tencent.mm.plugin.finder.report;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.utils.y;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "TAG", "", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/TwoFeedFlowScrollEvent;", "newState", "", "handleEvent", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class u
  extends f
{
  private final String TAG = "Finder.FinderTwoFeedFlowEventSubscriber";
  
  public u(c paramc)
  {
    super(paramc);
  }
  
  public final b g(RecyclerView paramRecyclerView, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(250804);
    p.h(paramRecyclerView, "recyclerView");
    Object localObject1 = super.g(paramRecyclerView, paramInt);
    if (localObject1 == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.event.base.TwoFeedFlowScrollEvent");
      AppMethodBeat.o(250804);
      throw paramRecyclerView;
    }
    localObject1 = (com.tencent.mm.plugin.finder.event.base.l)localObject1;
    Object localObject2 = paramRecyclerView.getLayoutManager();
    if (localObject2 == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager");
      AppMethodBeat.o(250804);
      throw paramRecyclerView;
    }
    Object localObject3 = (StaggeredGridLayoutManager)localObject2;
    localObject2 = ((StaggeredGridLayoutManager)localObject3).n(null);
    localObject3 = ((StaggeredGridLayoutManager)localObject3).o(null);
    int i;
    if (localObject2 != null)
    {
      paramInt = localObject2[0];
      if (localObject2 == null) {
        break label295;
      }
      i = localObject2[1];
      label122:
      ((com.tencent.mm.plugin.finder.event.base.l)localObject1).tIy = Math.min(paramInt, i);
      if (localObject3 == null) {
        break label300;
      }
      paramInt = localObject3[0];
      label142:
      i = j;
      if (localObject3 != null) {
        i = localObject3[1];
      }
      ((com.tencent.mm.plugin.finder.event.base.l)localObject1).tIA = Math.max(paramInt, i);
      localObject2 = y.vXH;
      ((com.tencent.mm.plugin.finder.event.base.l)localObject1).tII = y.a(((com.tencent.mm.plugin.finder.event.base.l)localObject1).tIy, ((com.tencent.mm.plugin.finder.event.base.l)localObject1).tIA, paramRecyclerView);
      if ((this.ptb != ((com.tencent.mm.plugin.finder.event.base.l)localObject1).tIy) || (this.ptc != ((com.tencent.mm.plugin.finder.event.base.l)localObject1).tIA))
      {
        if ((this.ptb != 2147483647) && (this.ptc != 2147483647)) {
          break label305;
        }
        i = ((com.tencent.mm.plugin.finder.event.base.l)localObject1).tIy;
        paramInt = ((com.tencent.mm.plugin.finder.event.base.l)localObject1).tIA;
      }
    }
    for (;;)
    {
      localObject2 = y.vXH;
      ((com.tencent.mm.plugin.finder.event.base.l)localObject1).tIH = y.a(i, paramInt, paramRecyclerView);
      this.ptb = ((com.tencent.mm.plugin.finder.event.base.l)localObject1).tIy;
      this.ptc = ((com.tencent.mm.plugin.finder.event.base.l)localObject1).tIA;
      paramRecyclerView = (b)localObject1;
      AppMethodBeat.o(250804);
      return paramRecyclerView;
      paramInt = 0;
      break;
      label295:
      i = 0;
      break label122;
      label300:
      paramInt = 0;
      break label142;
      label305:
      if (((com.tencent.mm.plugin.finder.event.base.l)localObject1).tIy < this.ptb) {}
      for (paramInt = ((com.tencent.mm.plugin.finder.event.base.l)localObject1).tIy;; paramInt = this.ptb)
      {
        if (((com.tencent.mm.plugin.finder.event.base.l)localObject1).tIA <= this.ptc) {
          break label358;
        }
        j = ((com.tencent.mm.plugin.finder.event.base.l)localObject1).tIA;
        i = paramInt;
        paramInt = j;
        break;
      }
      label358:
      j = this.ptc;
      i = paramInt;
      paramInt = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.u
 * JD-Core Version:    0.7.0.1
 */