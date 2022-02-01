package com.tencent.mm.plugin.finder.report;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.event.base.i;
import com.tencent.mm.plugin.finder.event.base.j;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.utils.y.b;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEventSubscriber;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/SingleFeedFlowScrollEvent;", "newState", "", "handleEvent", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onInvisible", "", "plugin-finder_release"})
public final class n
  extends i
{
  private long tCi = -1L;
  
  public n(c paramc)
  {
    super(paramc);
  }
  
  private static j Ky(int paramInt)
  {
    AppMethodBeat.i(250715);
    j localj = new j(paramInt);
    AppMethodBeat.o(250715);
    return localj;
  }
  
  public final h h(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(250713);
    p.h(paramRecyclerView, "recyclerView");
    Object localObject1 = super.h(paramRecyclerView, paramInt);
    if (localObject1 == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.event.base.SingleFeedFlowScrollEvent");
      AppMethodBeat.o(250713);
      throw paramRecyclerView;
    }
    localObject1 = (j)localObject1;
    ((j)localObject1).tCi = this.tCi;
    ((j)localObject1).ptb = this.ptb;
    ((j)localObject1).ptc = this.ptc;
    Object localObject2 = y.vXH;
    localObject2 = y.a(paramRecyclerView, this.tIf);
    ((j)localObject1).tII = ((List)((y.b)localObject2).vXL);
    ((j)localObject1).tIJ = ((y.b)localObject2).vXM;
    int i;
    if ((this.ptb != ((h)localObject1).tIy) || (this.ptc != ((h)localObject1).tIA))
    {
      if ((this.ptb != 2147483647) && (this.ptc != 2147483647)) {
        break label223;
      }
      i = ((h)localObject1).tIy;
      paramInt = ((h)localObject1).tIA;
    }
    for (;;)
    {
      localObject2 = y.vXH;
      ((j)localObject1).tIH = y.a(i, paramInt, paramRecyclerView);
      this.tCi = ((h)localObject1).tIC;
      this.ptb = ((h)localObject1).tIy;
      this.ptc = ((h)localObject1).tIA;
      paramRecyclerView = (h)localObject1;
      AppMethodBeat.o(250713);
      return paramRecyclerView;
      label223:
      if (((h)localObject1).tIy < this.ptb) {}
      for (paramInt = ((h)localObject1).tIy;; paramInt = this.ptb)
      {
        if (((h)localObject1).tIA <= this.ptc) {
          break label276;
        }
        j = ((h)localObject1).tIA;
        i = paramInt;
        paramInt = j;
        break;
      }
      label276:
      int j = this.ptc;
      i = paramInt;
      paramInt = j;
    }
  }
  
  public final void onInvisible()
  {
    AppMethodBeat.i(250718);
    super.onInvisible();
    this.tCi = -1L;
    AppMethodBeat.o(250718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.n
 * JD-Core Version:    0.7.0.1
 */