package com.tencent.mm.plugin.finder.report;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.event.base.i;
import com.tencent.mm.plugin.finder.event.base.k;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.av.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEventSubscriber;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/SingleFeedFlowScrollEvent;", "newState", "", "handleEvent", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onInvisible", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
  extends i
{
  private long AIv = -1L;
  
  public ad(c paramc)
  {
    super(paramc);
  }
  
  private static k SF(int paramInt)
  {
    AppMethodBeat.i(331311);
    k localk = new k(paramInt);
    AppMethodBeat.o(331311);
    return localk;
  }
  
  public final h i(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(331322);
    s.u(paramRecyclerView, "recyclerView");
    k localk = (k)super.i(paramRecyclerView, paramInt);
    localk.AIv = this.AIv;
    localk.vIj = this.vIj;
    localk.vIk = dYI();
    Object localObject = av.GiL;
    localObject = av.a(paramRecyclerView, getGlobalVisibleRect());
    localk.AOB = ((List)((av.c)localObject).Gjd);
    localk.AOC = ((av.c)localObject).Gje;
    int i;
    if ((this.vIj != localk.AOr) || (dYI() != localk.AOt))
    {
      if ((this.vIj != 2147483647) && (dYI() != 2147483647)) {
        break label197;
      }
      i = localk.AOr;
      paramInt = localk.AOt;
    }
    for (;;)
    {
      localObject = av.GiL;
      localk.AOA = av.a(i, paramInt, paramRecyclerView);
      this.AIv = localk.AOv;
      this.vIj = localk.AOr;
      Nl(localk.AOt);
      paramRecyclerView = (h)localk;
      AppMethodBeat.o(331322);
      return paramRecyclerView;
      label197:
      if (localk.AOr < this.vIj) {}
      for (paramInt = localk.AOr;; paramInt = this.vIj)
      {
        if (localk.AOt <= dYI()) {
          break label250;
        }
        j = localk.AOt;
        i = paramInt;
        paramInt = j;
        break;
      }
      label250:
      int j = dYI();
      i = paramInt;
      paramInt = j;
    }
  }
  
  public final void onInvisible()
  {
    AppMethodBeat.i(331330);
    super.onInvisible();
    this.AIv = -1L;
    AppMethodBeat.o(331330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ad
 * JD-Core Version:    0.7.0.1
 */