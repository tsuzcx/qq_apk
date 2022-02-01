package com.tencent.mm.plugin.finder.report;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.utils.aj;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "TAG", "", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/TwoFeedFlowScrollEvent;", "newState", "", "handleEvent", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"})
public final class y
  extends f
{
  private final String TAG = "Finder.FinderTwoFeedFlowEventSubscriber";
  
  public y(c paramc)
  {
    super(paramc);
  }
  
  public final b f(RecyclerView paramRecyclerView, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(291200);
    p.k(paramRecyclerView, "recyclerView");
    Object localObject1 = super.f(paramRecyclerView, paramInt);
    if (localObject1 == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.event.base.TwoFeedFlowScrollEvent");
      AppMethodBeat.o(291200);
      throw paramRecyclerView;
    }
    localObject1 = (com.tencent.mm.plugin.finder.event.base.l)localObject1;
    Object localObject2 = paramRecyclerView.getLayoutManager();
    if (localObject2 == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager");
      AppMethodBeat.o(291200);
      throw paramRecyclerView;
    }
    Object localObject3 = (StaggeredGridLayoutManager)localObject2;
    localObject2 = ((StaggeredGridLayoutManager)localObject3).k(null);
    localObject3 = ((StaggeredGridLayoutManager)localObject3).l(null);
    int i;
    if (localObject2 != null)
    {
      paramInt = localObject2[0];
      if (localObject2 == null) {
        break label295;
      }
      i = localObject2[1];
      label122:
      ((com.tencent.mm.plugin.finder.event.base.l)localObject1).xrh = Math.min(paramInt, i);
      if (localObject3 == null) {
        break label300;
      }
      paramInt = localObject3[0];
      label142:
      i = j;
      if (localObject3 != null) {
        i = localObject3[1];
      }
      ((com.tencent.mm.plugin.finder.event.base.l)localObject1).xrj = Math.max(paramInt, i);
      localObject2 = aj.AGc;
      ((com.tencent.mm.plugin.finder.event.base.l)localObject1).xrr = aj.a(((com.tencent.mm.plugin.finder.event.base.l)localObject1).xrh, ((com.tencent.mm.plugin.finder.event.base.l)localObject1).xrj, paramRecyclerView);
      if ((this.sCr != ((com.tencent.mm.plugin.finder.event.base.l)localObject1).xrh) || (dqm() != ((com.tencent.mm.plugin.finder.event.base.l)localObject1).xrj))
      {
        if ((this.sCr != 2147483647) && (dqm() != 2147483647)) {
          break label305;
        }
        i = ((com.tencent.mm.plugin.finder.event.base.l)localObject1).xrh;
        paramInt = ((com.tencent.mm.plugin.finder.event.base.l)localObject1).xrj;
      }
    }
    for (;;)
    {
      localObject2 = aj.AGc;
      ((com.tencent.mm.plugin.finder.event.base.l)localObject1).xrq = aj.a(i, paramInt, paramRecyclerView);
      this.sCr = ((com.tencent.mm.plugin.finder.event.base.l)localObject1).xrh;
      Mg(((com.tencent.mm.plugin.finder.event.base.l)localObject1).xrj);
      paramRecyclerView = (b)localObject1;
      AppMethodBeat.o(291200);
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
      if (((com.tencent.mm.plugin.finder.event.base.l)localObject1).xrh < this.sCr) {}
      for (paramInt = ((com.tencent.mm.plugin.finder.event.base.l)localObject1).xrh;; paramInt = this.sCr)
      {
        if (((com.tencent.mm.plugin.finder.event.base.l)localObject1).xrj <= dqm()) {
          break label358;
        }
        j = ((com.tencent.mm.plugin.finder.event.base.l)localObject1).xrj;
        i = paramInt;
        paramInt = j;
        break;
      }
      label358:
      j = dqm();
      i = paramInt;
      paramInt = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.y
 * JD-Core Version:    0.7.0.1
 */