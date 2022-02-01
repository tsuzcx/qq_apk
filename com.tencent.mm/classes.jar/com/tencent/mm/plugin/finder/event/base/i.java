package com.tencent.mm.plugin.finder.event.base;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.utils.n.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/event/base/ScrollEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "newState", "", "handleEvent", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public class i
  extends f
{
  public i(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(165579);
    AppMethodBeat.o(165579);
  }
  
  public h Dt(int paramInt)
  {
    AppMethodBeat.i(201426);
    h localh = new h(paramInt);
    AppMethodBeat.o(201426);
    return localh;
  }
  
  public h i(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(201428);
    k.h(paramRecyclerView, "recyclerView");
    Object localObject1 = super.h(paramRecyclerView, paramInt);
    if (localObject1 == null)
    {
      paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.event.base.ScrollEvent");
      AppMethodBeat.o(201428);
      throw paramRecyclerView;
    }
    localObject1 = (h)localObject1;
    Object localObject2 = paramRecyclerView.getLayoutManager();
    if (localObject2 == null)
    {
      paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
      AppMethodBeat.o(201428);
      throw paramRecyclerView;
    }
    localObject2 = (LinearLayoutManager)localObject2;
    ((h)localObject1).rdG = ((LinearLayoutManager)localObject2).jX();
    ((h)localObject1).rdI = ((LinearLayoutManager)localObject2).jZ();
    ((h)localObject1).rdH = ((LinearLayoutManager)localObject2).jW();
    ((h)localObject1).rdJ = ((LinearLayoutManager)localObject2).jY();
    ((h)localObject1).ahX = ((LinearLayoutManager)localObject2).getItemCount();
    ((h)localObject1).rdK = paramInt;
    localObject2 = n.rPN;
    localObject2 = n.b(paramRecyclerView, ((h)localObject1).rdH, ((h)localObject1).rdJ, 8);
    ((h)localObject1).rdL = ((n.a)localObject2).dig;
    String str = ((n.a)localObject2).mediaId;
    k.h(str, "<set-?>");
    ((h)localObject1).rdN = str;
    ((h)localObject1).rde = ((n.a)localObject2).rdD;
    paramRecyclerView = paramRecyclerView.getAdapter();
    if ((paramRecyclerView instanceof WxRecyclerAdapter)) {}
    for (((h)localObject1).rdM = (((n.a)localObject2).rPO - ((WxRecyclerAdapter)paramRecyclerView).JCb.size());; ((h)localObject1).rdM = ((n.a)localObject2).rPO)
    {
      AppMethodBeat.o(201428);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.i
 * JD-Core Version:    0.7.0.1
 */