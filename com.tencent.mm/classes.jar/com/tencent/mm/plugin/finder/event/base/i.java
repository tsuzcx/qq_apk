package com.tencent.mm.plugin.finder.event.base;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.ak;
import com.tencent.mm.plugin.finder.utils.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/event/base/ScrollEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "newState", "", "handleEvent", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder-base_release"})
public class i
  extends f
{
  public i(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(165579);
    AppMethodBeat.o(165579);
  }
  
  public h Mi(int paramInt)
  {
    AppMethodBeat.i(263626);
    h localh = new h(paramInt);
    AppMethodBeat.o(263626);
    return localh;
  }
  
  public h g(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(263628);
    p.k(paramRecyclerView, "recyclerView");
    Object localObject1 = super.f(paramRecyclerView, paramInt);
    if (localObject1 == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.event.base.ScrollEvent");
      AppMethodBeat.o(263628);
      throw paramRecyclerView;
    }
    localObject1 = (h)localObject1;
    Object localObject2 = paramRecyclerView.getLayoutManager();
    if (localObject2 == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
      AppMethodBeat.o(263628);
      throw paramRecyclerView;
    }
    localObject2 = (LinearLayoutManager)localObject2;
    ((h)localObject1).xrg = ((LinearLayoutManager)localObject2).kK();
    ((h)localObject1).xri = ((LinearLayoutManager)localObject2).kM();
    ((h)localObject1).xrh = ((LinearLayoutManager)localObject2).kJ();
    ((h)localObject1).xrj = ((LinearLayoutManager)localObject2).kL();
    ((h)localObject1).afI = ((LinearLayoutManager)localObject2).getItemCount();
    ((h)localObject1).xrk = paramInt;
    localObject2 = (com.tencent.mm.plugin.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.c.class);
    paramInt = ((h)localObject1).xrh;
    int i = ((h)localObject1).xrj;
    ak localak = ak.AGL;
    paramRecyclerView = ((com.tencent.mm.plugin.c)localObject2).a(paramRecyclerView, paramInt, i, ak.edV());
    ((h)localObject1).xrl = paramRecyclerView.feedId;
    localObject2 = paramRecyclerView.mediaId;
    p.k(localObject2, "<set-?>");
    ((h)localObject1).xrn = ((String)localObject2);
    ((h)localObject1).xro = paramRecyclerView.feed;
    ((h)localObject1).xrm = paramRecyclerView.ACR;
    AppMethodBeat.o(263628);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.i
 * JD-Core Version:    0.7.0.1
 */