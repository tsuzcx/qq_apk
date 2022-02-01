package com.tencent.mm.plugin.finder.report;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.event.base.j;
import com.tencent.mm.plugin.finder.utils.i.f;
import d.v;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEventSubscriber;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "TAG", "", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/SingleFeedFlowScrollEvent;", "newState", "", "handleEvent", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onInvisible", "", "plugin-finder_release"})
public final class k
  extends j
{
  private final String TAG = "Finder.FinderSingleFeedFlowEventSubscriber";
  private long qGl = -1L;
  
  public k(d paramd)
  {
    super(paramd);
  }
  
  private static com.tencent.mm.plugin.finder.event.base.l ahr(int paramInt)
  {
    AppMethodBeat.i(198818);
    com.tencent.mm.plugin.finder.event.base.l locall = new com.tencent.mm.plugin.finder.event.base.l(paramInt);
    AppMethodBeat.o(198818);
    return locall;
  }
  
  public final com.tencent.mm.plugin.finder.event.base.i i(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(198816);
    d.g.b.k.h(paramRecyclerView, "recyclerView");
    Object localObject1 = super.i(paramRecyclerView, paramInt);
    if (localObject1 == null)
    {
      paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.event.base.SingleFeedFlowScrollEvent");
      AppMethodBeat.o(198816);
      throw paramRecyclerView;
    }
    localObject1 = (com.tencent.mm.plugin.finder.event.base.l)localObject1;
    ((com.tencent.mm.plugin.finder.event.base.l)localObject1).qGl = this.qGl;
    ((com.tencent.mm.plugin.finder.event.base.l)localObject1).mYh = this.mYh;
    ((com.tencent.mm.plugin.finder.event.base.l)localObject1).mYi = this.mYi;
    Object localObject2 = this.KMc;
    int i;
    if (localObject2 != null)
    {
      com.tencent.mm.plugin.finder.utils.i locali = com.tencent.mm.plugin.finder.utils.i.qTa;
      localObject2 = com.tencent.mm.plugin.finder.utils.i.a(paramRecyclerView, (Rect)localObject2);
      ((com.tencent.mm.plugin.finder.event.base.l)localObject1).KMm = ((List)((i.f)localObject2).Lbl);
      ((com.tencent.mm.plugin.finder.event.base.l)localObject1).KMn = ((i.f)localObject2).Lbm;
      if ((this.mYh != ((com.tencent.mm.plugin.finder.event.base.i)localObject1).qsi) || (this.mYi != ((com.tencent.mm.plugin.finder.event.base.i)localObject1).qsj))
      {
        if ((this.mYh != 2147483647) && (this.mYi != 2147483647)) {
          break label259;
        }
        i = ((com.tencent.mm.plugin.finder.event.base.i)localObject1).qsi;
        paramInt = ((com.tencent.mm.plugin.finder.event.base.i)localObject1).qsj;
      }
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.plugin.finder.utils.i.qTa;
      ((com.tencent.mm.plugin.finder.event.base.l)localObject1).KMl = com.tencent.mm.plugin.finder.utils.i.a(i, paramInt, paramRecyclerView);
      this.qGl = ((com.tencent.mm.plugin.finder.event.base.i)localObject1).qsk;
      this.mYh = ((com.tencent.mm.plugin.finder.event.base.i)localObject1).qsi;
      this.mYi = ((com.tencent.mm.plugin.finder.event.base.i)localObject1).qsj;
      paramRecyclerView = (com.tencent.mm.plugin.finder.event.base.i)localObject1;
      AppMethodBeat.o(198816);
      return paramRecyclerView;
      localObject2 = com.tencent.mm.plugin.finder.utils.i.qTa;
      ((com.tencent.mm.plugin.finder.event.base.l)localObject1).KMm = com.tencent.mm.plugin.finder.utils.i.a(((com.tencent.mm.plugin.finder.event.base.i)localObject1).qsi, ((com.tencent.mm.plugin.finder.event.base.i)localObject1).qsj, paramRecyclerView);
      break;
      label259:
      if (((com.tencent.mm.plugin.finder.event.base.i)localObject1).qsi < this.mYh) {}
      for (paramInt = ((com.tencent.mm.plugin.finder.event.base.i)localObject1).qsi;; paramInt = this.mYh)
      {
        if (((com.tencent.mm.plugin.finder.event.base.i)localObject1).qsj <= this.mYi) {
          break label312;
        }
        j = ((com.tencent.mm.plugin.finder.event.base.i)localObject1).qsj;
        i = paramInt;
        paramInt = j;
        break;
      }
      label312:
      int j = this.mYi;
      i = paramInt;
      paramInt = j;
    }
  }
  
  public final void onInvisible()
  {
    AppMethodBeat.i(198821);
    super.onInvisible();
    this.qGl = -1L;
    AppMethodBeat.o(198821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.k
 * JD-Core Version:    0.7.0.1
 */