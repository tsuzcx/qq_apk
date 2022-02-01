package com.tencent.mm.plugin.finder.report;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.f;
import d.v;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "TAG", "", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/TwoFeedFlowScrollEvent;", "newState", "", "handleEvent", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class p
  extends f
{
  private final String TAG = "Finder.FinderTwoFeedFlowEventSubscriber";
  
  public p(c paramc)
  {
    super(paramc);
  }
  
  public final b h(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(203907);
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    Object localObject1 = super.h(paramRecyclerView, paramInt);
    if (localObject1 == null)
    {
      paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.event.base.TwoFeedFlowScrollEvent");
      AppMethodBeat.o(203907);
      throw paramRecyclerView;
    }
    localObject1 = (com.tencent.mm.plugin.finder.event.base.l)localObject1;
    Object localObject2 = paramRecyclerView.getLayoutManager();
    if (localObject2 == null)
    {
      paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager");
      AppMethodBeat.o(203907);
      throw paramRecyclerView;
    }
    Object localObject3 = (StaggeredGridLayoutManager)localObject2;
    localObject2 = ((StaggeredGridLayoutManager)localObject3).n(null);
    localObject3 = ((StaggeredGridLayoutManager)localObject3).mA();
    int i;
    if (localObject2 != null)
    {
      paramInt = localObject2[0];
      if (localObject2 == null) {
        break label274;
      }
      i = localObject2[1];
      label118:
      ((com.tencent.mm.plugin.finder.event.base.l)localObject1).rZF = Math.min(paramInt, i);
      ((com.tencent.mm.plugin.finder.event.base.l)localObject1).rZH = Math.max(localObject3[0], localObject3[1]);
      localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
      ((com.tencent.mm.plugin.finder.event.base.l)localObject1).rZS = com.tencent.mm.plugin.finder.utils.p.a(((com.tencent.mm.plugin.finder.event.base.l)localObject1).rZF, ((com.tencent.mm.plugin.finder.event.base.l)localObject1).rZH, paramRecyclerView);
      if ((this.ohB != ((com.tencent.mm.plugin.finder.event.base.l)localObject1).rZF) || (this.ohC != ((com.tencent.mm.plugin.finder.event.base.l)localObject1).rZH))
      {
        if ((this.ohB != 2147483647) && (this.ohC != 2147483647)) {
          break label279;
        }
        i = ((com.tencent.mm.plugin.finder.event.base.l)localObject1).rZF;
        paramInt = ((com.tencent.mm.plugin.finder.event.base.l)localObject1).rZH;
      }
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
      ((com.tencent.mm.plugin.finder.event.base.l)localObject1).rZR = com.tencent.mm.plugin.finder.utils.p.a(i, paramInt, paramRecyclerView);
      this.ohB = ((com.tencent.mm.plugin.finder.event.base.l)localObject1).rZF;
      this.ohC = ((com.tencent.mm.plugin.finder.event.base.l)localObject1).rZH;
      paramRecyclerView = (b)localObject1;
      AppMethodBeat.o(203907);
      return paramRecyclerView;
      paramInt = 0;
      break;
      label274:
      i = 0;
      break label118;
      label279:
      if (((com.tencent.mm.plugin.finder.event.base.l)localObject1).rZF < this.ohB) {}
      for (paramInt = ((com.tencent.mm.plugin.finder.event.base.l)localObject1).rZF;; paramInt = this.ohB)
      {
        if (((com.tencent.mm.plugin.finder.event.base.l)localObject1).rZH <= this.ohC) {
          break label332;
        }
        j = ((com.tencent.mm.plugin.finder.event.base.l)localObject1).rZH;
        i = paramInt;
        paramInt = j;
        break;
      }
      label332:
      int j = this.ohC;
      i = paramInt;
      paramInt = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.p
 * JD-Core Version:    0.7.0.1
 */