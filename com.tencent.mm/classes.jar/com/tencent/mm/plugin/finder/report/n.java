package com.tencent.mm.plugin.finder.report;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.utils.i;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "TAG", "", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/TwoFeedFlowScrollEvent;", "newState", "", "handleEvent", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class n
  extends e
{
  private final String TAG = "Finder.FinderTwoFeedFlowEventSubscriber";
  
  public n(d paramd)
  {
    super(paramd);
  }
  
  public final c h(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(198846);
    k.h(paramRecyclerView, "recyclerView");
    Object localObject1 = super.h(paramRecyclerView, paramInt);
    if (localObject1 == null)
    {
      paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.event.base.TwoFeedFlowScrollEvent");
      AppMethodBeat.o(198846);
      throw paramRecyclerView;
    }
    localObject1 = (com.tencent.mm.plugin.finder.event.base.n)localObject1;
    Object localObject2 = paramRecyclerView.getLayoutManager();
    if (localObject2 == null)
    {
      paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager");
      AppMethodBeat.o(198846);
      throw paramRecyclerView;
    }
    Object localObject3 = (StaggeredGridLayoutManager)localObject2;
    localObject2 = ((StaggeredGridLayoutManager)localObject3).x(null);
    localObject3 = ((StaggeredGridLayoutManager)localObject3).ma();
    int i;
    if (localObject2 != null)
    {
      paramInt = localObject2[0];
      if (localObject2 == null) {
        break label274;
      }
      i = localObject2[1];
      label118:
      ((com.tencent.mm.plugin.finder.event.base.n)localObject1).qsi = Math.min(paramInt, i);
      ((com.tencent.mm.plugin.finder.event.base.n)localObject1).qsj = Math.max(localObject3[0], localObject3[1]);
      localObject2 = i.qTa;
      ((com.tencent.mm.plugin.finder.event.base.n)localObject1).KMm = i.a(((com.tencent.mm.plugin.finder.event.base.n)localObject1).qsi, ((com.tencent.mm.plugin.finder.event.base.n)localObject1).qsj, paramRecyclerView);
      if ((this.mYh != ((com.tencent.mm.plugin.finder.event.base.n)localObject1).qsi) || (this.mYi != ((com.tencent.mm.plugin.finder.event.base.n)localObject1).qsj))
      {
        if ((this.mYh != 2147483647) && (this.mYi != 2147483647)) {
          break label279;
        }
        i = ((com.tencent.mm.plugin.finder.event.base.n)localObject1).qsi;
        paramInt = ((com.tencent.mm.plugin.finder.event.base.n)localObject1).qsj;
      }
    }
    for (;;)
    {
      localObject2 = i.qTa;
      ((com.tencent.mm.plugin.finder.event.base.n)localObject1).KMl = i.a(i, paramInt, paramRecyclerView);
      this.mYh = ((com.tencent.mm.plugin.finder.event.base.n)localObject1).qsi;
      this.mYi = ((com.tencent.mm.plugin.finder.event.base.n)localObject1).qsj;
      paramRecyclerView = (c)localObject1;
      AppMethodBeat.o(198846);
      return paramRecyclerView;
      paramInt = 0;
      break;
      label274:
      i = 0;
      break label118;
      label279:
      if (((com.tencent.mm.plugin.finder.event.base.n)localObject1).qsi < this.mYh) {}
      for (paramInt = ((com.tencent.mm.plugin.finder.event.base.n)localObject1).qsi;; paramInt = this.mYh)
      {
        if (((com.tencent.mm.plugin.finder.event.base.n)localObject1).qsj <= this.mYi) {
          break label332;
        }
        j = ((com.tencent.mm.plugin.finder.event.base.n)localObject1).qsj;
        i = paramInt;
        paramInt = j;
        break;
      }
      label332:
      int j = this.mYi;
      i = paramInt;
      paramInt = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.n
 * JD-Core Version:    0.7.0.1
 */