package com.tencent.mm.plugin.finder.event.base;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.utils.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/base/ScrollEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "newState", "", "handleEvent", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public class i
  extends f
{
  public i(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(165579);
    AppMethodBeat.o(165579);
  }
  
  public h Nn(int paramInt)
  {
    AppMethodBeat.i(330343);
    h localh = new h(paramInt);
    AppMethodBeat.o(330343);
    return localh;
  }
  
  public h i(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(330358);
    s.u(paramRecyclerView, "recyclerView");
    h localh = (h)super.h(paramRecyclerView, paramInt);
    Object localObject = paramRecyclerView.getLayoutManager();
    if (localObject == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
      AppMethodBeat.o(330358);
      throw paramRecyclerView;
    }
    localObject = (LinearLayoutManager)localObject;
    localh.AOq = ((LinearLayoutManager)localObject).Jv();
    localh.AOs = ((LinearLayoutManager)localObject).Jx();
    localh.AOr = ((LinearLayoutManager)localObject).Ju();
    localh.AOt = ((LinearLayoutManager)localObject).Jw();
    localh.bUo = ((LinearLayoutManager)localObject).getItemCount();
    localh.AOu = paramInt;
    localObject = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
    s.s(localObject, "service(IFinderCommonService::class.java)");
    localObject = (com.tencent.mm.plugin.h)localObject;
    paramInt = localh.AOr;
    int i = localh.AOt;
    aw localaw = aw.Gjk;
    paramRecyclerView = ((com.tencent.mm.plugin.h)localObject).a(paramRecyclerView, paramInt, i, aw.ffO());
    localh.AOv = paramRecyclerView.feedId;
    localObject = paramRecyclerView.mediaId;
    s.u(localObject, "<set-?>");
    localh.AOx = ((String)localObject);
    localh.AOy = paramRecyclerView.feed;
    localh.AOw = paramRecyclerView.GfU;
    AppMethodBeat.o(330358);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.i
 * JD-Core Version:    0.7.0.1
 */