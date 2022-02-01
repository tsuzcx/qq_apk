package com.tencent.mm.plugin.finder.event.base;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.i.e;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/event/base/ScrollEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "newState", "", "handleEvent", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public class j
  extends e
{
  public j(d paramd)
  {
    super(paramd);
    AppMethodBeat.i(165579);
    AppMethodBeat.o(165579);
  }
  
  public i ahe(int paramInt)
  {
    AppMethodBeat.i(197545);
    i locali = new i(paramInt);
    AppMethodBeat.o(197545);
    return locali;
  }
  
  public i i(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(197547);
    k.h(paramRecyclerView, "recyclerView");
    Object localObject1 = super.h(paramRecyclerView, paramInt);
    if (localObject1 == null)
    {
      paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.event.base.ScrollEvent");
      AppMethodBeat.o(197547);
      throw paramRecyclerView;
    }
    localObject1 = (i)localObject1;
    Object localObject2 = paramRecyclerView.getLayoutManager();
    if (localObject2 == null)
    {
      paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
      AppMethodBeat.o(197547);
      throw paramRecyclerView;
    }
    localObject2 = (LinearLayoutManager)localObject2;
    ((i)localObject1).qsB = ((LinearLayoutManager)localObject2).jP();
    ((i)localObject1).qsC = ((LinearLayoutManager)localObject2).jR();
    ((i)localObject1).qsi = ((LinearLayoutManager)localObject2).jO();
    ((i)localObject1).qsj = ((LinearLayoutManager)localObject2).jQ();
    ((i)localObject1).ahd = ((LinearLayoutManager)localObject2).getItemCount();
    ((i)localObject1).qsD = paramInt;
    localObject2 = com.tencent.mm.plugin.finder.utils.i.qTa;
    localObject2 = com.tencent.mm.plugin.finder.utils.i.j(paramRecyclerView, ((i)localObject1).qsi, ((i)localObject1).qsj);
    ((i)localObject1).qsk = ((i.e)localObject2).feedId;
    String str = ((i.e)localObject2).mediaId;
    k.h(str, "<set-?>");
    ((i)localObject1).qsm = str;
    ((i)localObject1).qsl = ((i.e)localObject2).qHv;
    paramRecyclerView = paramRecyclerView.getAdapter();
    if ((paramRecyclerView instanceof WxRecyclerAdapter)) {}
    for (((i)localObject1).KMk = (((i.e)localObject2).Lbk - ((WxRecyclerAdapter)paramRecyclerView).Ibl.size());; ((i)localObject1).KMk = ((i.e)localObject2).Lbk)
    {
      AppMethodBeat.o(197547);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.j
 * JD-Core Version:    0.7.0.1
 */