package com.tencent.mm.plugin.finder.event.base;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.utils.y.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/event/base/ScrollEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "newState", "", "handleEvent", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public class i
  extends f
{
  public i(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(165579);
    AppMethodBeat.o(165579);
  }
  
  public h Iu(int paramInt)
  {
    AppMethodBeat.i(243467);
    h localh = new h(paramInt);
    AppMethodBeat.o(243467);
    return localh;
  }
  
  public h h(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(243469);
    p.h(paramRecyclerView, "recyclerView");
    Object localObject1 = super.g(paramRecyclerView, paramInt);
    if (localObject1 == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.event.base.ScrollEvent");
      AppMethodBeat.o(243469);
      throw paramRecyclerView;
    }
    localObject1 = (h)localObject1;
    Object localObject2 = paramRecyclerView.getLayoutManager();
    if (localObject2 == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
      AppMethodBeat.o(243469);
      throw paramRecyclerView;
    }
    localObject2 = (LinearLayoutManager)localObject2;
    ((h)localObject1).tIx = ((LinearLayoutManager)localObject2).kt();
    ((h)localObject1).tIz = ((LinearLayoutManager)localObject2).kv();
    ((h)localObject1).tIy = ((LinearLayoutManager)localObject2).ks();
    ((h)localObject1).tIA = ((LinearLayoutManager)localObject2).ku();
    ((h)localObject1).akb = ((LinearLayoutManager)localObject2).getItemCount();
    ((h)localObject1).tIB = paramInt;
    localObject2 = y.vXH;
    paramRecyclerView = y.a(paramRecyclerView, ((h)localObject1).tIy, ((h)localObject1).tIA, null, 8);
    ((h)localObject1).tIC = paramRecyclerView.feedId;
    localObject2 = paramRecyclerView.mediaId;
    p.h(localObject2, "<set-?>");
    ((h)localObject1).tIE = ((String)localObject2);
    ((h)localObject1).tIF = paramRecyclerView.feed;
    ((h)localObject1).tID = paramRecyclerView.vXK;
    AppMethodBeat.o(243469);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.i
 * JD-Core Version:    0.7.0.1
 */