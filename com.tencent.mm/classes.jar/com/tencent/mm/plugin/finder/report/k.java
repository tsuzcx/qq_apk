package com.tencent.mm.plugin.finder.report;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.event.base.i;
import com.tencent.mm.plugin.finder.event.base.j;
import com.tencent.mm.plugin.finder.utils.p.b;
import d.l;
import d.v;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEventSubscriber;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "TAG", "", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/SingleFeedFlowScrollEvent;", "newState", "", "handleEvent", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onInvisible", "", "plugin-finder_release"})
public final class k
  extends i
{
  private final String TAG = "Finder.FinderSingleFeedFlowEventSubscriber";
  private long rVz = -1L;
  
  public k(c paramc)
  {
    super(paramc);
  }
  
  private static j Fx(int paramInt)
  {
    AppMethodBeat.i(203857);
    j localj = new j(paramInt);
    AppMethodBeat.o(203857);
    return localj;
  }
  
  public final h i(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(203855);
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    Object localObject1 = super.i(paramRecyclerView, paramInt);
    if (localObject1 == null)
    {
      paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.event.base.SingleFeedFlowScrollEvent");
      AppMethodBeat.o(203855);
      throw paramRecyclerView;
    }
    localObject1 = (j)localObject1;
    ((j)localObject1).rVz = this.rVz;
    ((j)localObject1).ohB = this.ohB;
    ((j)localObject1).ohC = this.ohC;
    Object localObject2 = this.rZn;
    int i;
    if (localObject2 != null)
    {
      com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sXz;
      localObject2 = com.tencent.mm.plugin.finder.utils.p.a(paramRecyclerView, (Rect)localObject2);
      ((j)localObject1).rZS = ((List)((p.b)localObject2).sXC);
      ((j)localObject1).rZT = ((p.b)localObject2).sXD;
      if ((this.ohB != ((h)localObject1).rZF) || (this.ohC != ((h)localObject1).rZH))
      {
        if ((this.ohB != 2147483647) && (this.ohC != 2147483647)) {
          break label259;
        }
        i = ((h)localObject1).rZF;
        paramInt = ((h)localObject1).rZH;
      }
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
      ((j)localObject1).rZR = com.tencent.mm.plugin.finder.utils.p.a(i, paramInt, paramRecyclerView);
      this.rVz = ((h)localObject1).rZL;
      this.ohB = ((h)localObject1).rZF;
      this.ohC = ((h)localObject1).rZH;
      paramRecyclerView = (h)localObject1;
      AppMethodBeat.o(203855);
      return paramRecyclerView;
      localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
      ((j)localObject1).rZS = com.tencent.mm.plugin.finder.utils.p.a(((h)localObject1).rZF, ((h)localObject1).rZH, paramRecyclerView);
      break;
      label259:
      if (((h)localObject1).rZF < this.ohB) {}
      for (paramInt = ((h)localObject1).rZF;; paramInt = this.ohB)
      {
        if (((h)localObject1).rZH <= this.ohC) {
          break label312;
        }
        j = ((h)localObject1).rZH;
        i = paramInt;
        paramInt = j;
        break;
      }
      label312:
      int j = this.ohC;
      i = paramInt;
      paramInt = j;
    }
  }
  
  public final void onInvisible()
  {
    AppMethodBeat.i(203860);
    super.onInvisible();
    this.rVz = -1L;
    AppMethodBeat.o(203860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.k
 * JD-Core Version:    0.7.0.1
 */