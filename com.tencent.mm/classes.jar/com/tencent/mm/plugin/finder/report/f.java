package com.tencent.mm.plugin.finder.report;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.event.base.i;
import com.tencent.mm.plugin.finder.event.base.j;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.utils.n.b;
import d.g.b.k;
import d.l;
import d.v;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEventSubscriber;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "TAG", "", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/SingleFeedFlowScrollEvent;", "newState", "", "handleEvent", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onInvisible", "", "plugin-finder_release"})
public final class f
  extends i
{
  private final String TAG = "Finder.FinderSingleFeedFlowEventSubscriber";
  private long raQ = -1L;
  
  public f(c paramc)
  {
    super(paramc);
  }
  
  private static j DX(int paramInt)
  {
    AppMethodBeat.i(202762);
    j localj = new j(paramInt);
    AppMethodBeat.o(202762);
    return localj;
  }
  
  public final h i(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(202760);
    k.h(paramRecyclerView, "recyclerView");
    Object localObject1 = super.i(paramRecyclerView, paramInt);
    if (localObject1 == null)
    {
      paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.event.base.SingleFeedFlowScrollEvent");
      AppMethodBeat.o(202760);
      throw paramRecyclerView;
    }
    localObject1 = (j)localObject1;
    ((j)localObject1).raQ = this.raQ;
    ((j)localObject1).nAG = this.nAG;
    ((j)localObject1).nAH = this.nAH;
    Object localObject2 = this.rdp;
    int i;
    if (localObject2 != null)
    {
      n localn = n.rPN;
      localObject2 = n.a(paramRecyclerView, (Rect)localObject2);
      ((j)localObject1).rdQ = ((List)((n.b)localObject2).rPP);
      ((j)localObject1).rdR = ((n.b)localObject2).rPQ;
      if ((this.nAG != ((h)localObject1).rdH) || (this.nAH != ((h)localObject1).rdJ))
      {
        if ((this.nAG != 2147483647) && (this.nAH != 2147483647)) {
          break label259;
        }
        i = ((h)localObject1).rdH;
        paramInt = ((h)localObject1).rdJ;
      }
    }
    for (;;)
    {
      localObject2 = n.rPN;
      ((j)localObject1).rdP = n.a(i, paramInt, paramRecyclerView);
      this.raQ = ((h)localObject1).rdL;
      this.nAG = ((h)localObject1).rdH;
      this.nAH = ((h)localObject1).rdJ;
      paramRecyclerView = (h)localObject1;
      AppMethodBeat.o(202760);
      return paramRecyclerView;
      localObject2 = n.rPN;
      ((j)localObject1).rdQ = n.a(((h)localObject1).rdH, ((h)localObject1).rdJ, paramRecyclerView);
      break;
      label259:
      if (((h)localObject1).rdH < this.nAG) {}
      for (paramInt = ((h)localObject1).rdH;; paramInt = this.nAG)
      {
        if (((h)localObject1).rdJ <= this.nAH) {
          break label312;
        }
        j = ((h)localObject1).rdJ;
        i = paramInt;
        paramInt = j;
        break;
      }
      label312:
      int j = this.nAH;
      i = paramInt;
      paramInt = j;
    }
  }
  
  public final void onInvisible()
  {
    AppMethodBeat.i(202765);
    super.onInvisible();
    this.raQ = -1L;
    AppMethodBeat.o(202765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.f
 * JD-Core Version:    0.7.0.1
 */