package com.tencent.mm.plugin.finder.report;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.event.base.i;
import com.tencent.mm.plugin.finder.utils.p.b;
import d.l;
import d.v;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEventSubscriber;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "TAG", "", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/SingleFeedFlowScrollEvent;", "newState", "", "handleEvent", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onInvisible", "", "plugin-finder_release"})
public final class j
  extends i
{
  private final String TAG = "Finder.FinderSingleFeedFlowEventSubscriber";
  private long rNl = -1L;
  
  public j(c paramc)
  {
    super(paramc);
  }
  
  private static com.tencent.mm.plugin.finder.event.base.j Fb(int paramInt)
  {
    AppMethodBeat.i(203299);
    com.tencent.mm.plugin.finder.event.base.j localj = new com.tencent.mm.plugin.finder.event.base.j(paramInt);
    AppMethodBeat.o(203299);
    return localj;
  }
  
  public final h i(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(203297);
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    Object localObject1 = super.i(paramRecyclerView, paramInt);
    if (localObject1 == null)
    {
      paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.event.base.SingleFeedFlowScrollEvent");
      AppMethodBeat.o(203297);
      throw paramRecyclerView;
    }
    localObject1 = (com.tencent.mm.plugin.finder.event.base.j)localObject1;
    ((com.tencent.mm.plugin.finder.event.base.j)localObject1).rNl = this.rNl;
    ((com.tencent.mm.plugin.finder.event.base.j)localObject1).obN = this.obN;
    ((com.tencent.mm.plugin.finder.event.base.j)localObject1).obO = this.obO;
    Object localObject2 = this.rQL;
    int i;
    if (localObject2 != null)
    {
      com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
      localObject2 = com.tencent.mm.plugin.finder.utils.p.a(paramRecyclerView, (Rect)localObject2);
      ((com.tencent.mm.plugin.finder.event.base.j)localObject1).rRq = ((List)((p.b)localObject2).sMr);
      ((com.tencent.mm.plugin.finder.event.base.j)localObject1).rRr = ((p.b)localObject2).sMs;
      if ((this.obN != ((h)localObject1).rRd) || (this.obO != ((h)localObject1).rRf))
      {
        if ((this.obN != 2147483647) && (this.obO != 2147483647)) {
          break label259;
        }
        i = ((h)localObject1).rRd;
        paramInt = ((h)localObject1).rRf;
      }
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
      ((com.tencent.mm.plugin.finder.event.base.j)localObject1).rRp = com.tencent.mm.plugin.finder.utils.p.a(i, paramInt, paramRecyclerView);
      this.rNl = ((h)localObject1).rRj;
      this.obN = ((h)localObject1).rRd;
      this.obO = ((h)localObject1).rRf;
      paramRecyclerView = (h)localObject1;
      AppMethodBeat.o(203297);
      return paramRecyclerView;
      localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
      ((com.tencent.mm.plugin.finder.event.base.j)localObject1).rRq = com.tencent.mm.plugin.finder.utils.p.a(((h)localObject1).rRd, ((h)localObject1).rRf, paramRecyclerView);
      break;
      label259:
      if (((h)localObject1).rRd < this.obN) {}
      for (paramInt = ((h)localObject1).rRd;; paramInt = this.obN)
      {
        if (((h)localObject1).rRf <= this.obO) {
          break label312;
        }
        j = ((h)localObject1).rRf;
        i = paramInt;
        paramInt = j;
        break;
      }
      label312:
      int j = this.obO;
      i = paramInt;
      paramInt = j;
    }
  }
  
  public final void onInvisible()
  {
    AppMethodBeat.i(203302);
    super.onInvisible();
    this.rNl = -1L;
    AppMethodBeat.o(203302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.j
 * JD-Core Version:    0.7.0.1
 */