package com.tencent.mm.plugin.finder.report;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.event.base.m;
import com.tencent.mm.plugin.finder.utils.av;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "TAG", "", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/TwoFeedFlowScrollEvent;", "newState", "", "handleEvent", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class al
  extends f
{
  private final String TAG = "Finder.FinderTwoFeedFlowEventSubscriber";
  
  public al(c paramc)
  {
    super(paramc);
  }
  
  public final b h(RecyclerView paramRecyclerView, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(331279);
    s.u(paramRecyclerView, "recyclerView");
    m localm = (m)super.h(paramRecyclerView, paramInt);
    Object localObject1 = paramRecyclerView.getLayoutManager();
    if (localObject1 == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager");
      AppMethodBeat.o(331279);
      throw paramRecyclerView;
    }
    Object localObject2 = (StaggeredGridLayoutManager)localObject1;
    localObject1 = ((StaggeredGridLayoutManager)localObject2).n(null);
    localObject2 = ((StaggeredGridLayoutManager)localObject2).o(null);
    int i;
    if (localObject1 == null)
    {
      paramInt = 0;
      if (localObject1 != null) {
        break label258;
      }
      i = 0;
      label90:
      localm.AOr = Math.min(paramInt, i);
      if (localObject2 != null) {
        break label266;
      }
      paramInt = 0;
      label107:
      if (localObject2 != null) {
        break label274;
      }
      i = j;
      label115:
      localm.AOt = Math.max(paramInt, i);
      localObject1 = av.GiL;
      localm.AOB = av.a(localm.AOr, localm.AOt, paramRecyclerView);
      if ((this.vIj != localm.AOr) || (dYI() != localm.AOt))
      {
        if ((this.vIj != 2147483647) && (dYI() != 2147483647)) {
          break label282;
        }
        i = localm.AOr;
        paramInt = localm.AOt;
      }
    }
    for (;;)
    {
      localObject1 = av.GiL;
      localm.AOA = av.a(i, paramInt, paramRecyclerView);
      this.vIj = localm.AOr;
      Nl(localm.AOt);
      paramRecyclerView = (b)localm;
      AppMethodBeat.o(331279);
      return paramRecyclerView;
      paramInt = localObject1[0];
      break;
      label258:
      i = localObject1[1];
      break label90;
      label266:
      paramInt = localObject2[0];
      break label107;
      label274:
      i = localObject2[1];
      break label115;
      label282:
      if (localm.AOr < this.vIj) {}
      for (paramInt = localm.AOr;; paramInt = this.vIj)
      {
        if (localm.AOt <= dYI()) {
          break label335;
        }
        j = localm.AOt;
        i = paramInt;
        paramInt = j;
        break;
      }
      label335:
      j = dYI();
      i = paramInt;
      paramInt = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.al
 * JD-Core Version:    0.7.0.1
 */