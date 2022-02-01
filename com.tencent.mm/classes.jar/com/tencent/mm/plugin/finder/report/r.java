package com.tencent.mm.plugin.finder.report;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.event.base.i;
import com.tencent.mm.plugin.finder.event.base.j;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.aj.b;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEventSubscriber;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/SingleFeedFlowScrollEvent;", "newState", "", "handleEvent", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onInvisible", "", "plugin-finder_release"})
public final class r
  extends i
{
  private long xjA = -1L;
  
  public r(c paramc)
  {
    super(paramc);
  }
  
  private static j PB(int paramInt)
  {
    AppMethodBeat.i(292310);
    j localj = new j(paramInt);
    AppMethodBeat.o(292310);
    return localj;
  }
  
  public final h g(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(292308);
    p.k(paramRecyclerView, "recyclerView");
    Object localObject1 = super.g(paramRecyclerView, paramInt);
    if (localObject1 == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.event.base.SingleFeedFlowScrollEvent");
      AppMethodBeat.o(292308);
      throw paramRecyclerView;
    }
    localObject1 = (j)localObject1;
    ((j)localObject1).xjA = this.xjA;
    ((j)localObject1).sCr = this.sCr;
    ((j)localObject1).sCs = dqm();
    Object localObject2 = aj.AGc;
    localObject2 = aj.a(paramRecyclerView, this.xqO);
    ((j)localObject1).xrr = ((List)((aj.b)localObject2).AGe);
    ((j)localObject1).xrs = ((aj.b)localObject2).AGf;
    int i;
    if ((this.sCr != ((h)localObject1).xrh) || (dqm() != ((h)localObject1).xrj))
    {
      if ((this.sCr != 2147483647) && (dqm() != 2147483647)) {
        break label223;
      }
      i = ((h)localObject1).xrh;
      paramInt = ((h)localObject1).xrj;
    }
    for (;;)
    {
      localObject2 = aj.AGc;
      ((j)localObject1).xrq = aj.a(i, paramInt, paramRecyclerView);
      this.xjA = ((h)localObject1).xrl;
      this.sCr = ((h)localObject1).xrh;
      Mg(((h)localObject1).xrj);
      paramRecyclerView = (h)localObject1;
      AppMethodBeat.o(292308);
      return paramRecyclerView;
      label223:
      if (((h)localObject1).xrh < this.sCr) {}
      for (paramInt = ((h)localObject1).xrh;; paramInt = this.sCr)
      {
        if (((h)localObject1).xrj <= dqm()) {
          break label276;
        }
        j = ((h)localObject1).xrj;
        i = paramInt;
        paramInt = j;
        break;
      }
      label276:
      int j = dqm();
      i = paramInt;
      paramInt = j;
    }
  }
  
  public final void onInvisible()
  {
    AppMethodBeat.i(292313);
    super.onInvisible();
    this.xjA = -1L;
    AppMethodBeat.o(292313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.r
 * JD-Core Version:    0.7.0.1
 */