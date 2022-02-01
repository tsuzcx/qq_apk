package com.tencent.mm.plugin.finder.event.base;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.p.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d;
import d.l;
import d.v;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/event/base/ScrollEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "newState", "", "handleEvent", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public class i
  extends f
{
  public i(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(165579);
    AppMethodBeat.o(165579);
  }
  
  public h EA(int paramInt)
  {
    AppMethodBeat.i(202014);
    h localh = new h(paramInt);
    AppMethodBeat.o(202014);
    return localh;
  }
  
  public h i(RecyclerView paramRecyclerView, int paramInt)
  {
    int j = -1;
    AppMethodBeat.i(202016);
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    Object localObject1 = super.h(paramRecyclerView, paramInt);
    if (localObject1 == null)
    {
      paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.event.base.ScrollEvent");
      AppMethodBeat.o(202016);
      throw paramRecyclerView;
    }
    localObject1 = (h)localObject1;
    Object localObject2 = paramRecyclerView.getLayoutManager();
    if (localObject2 == null)
    {
      paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
      AppMethodBeat.o(202016);
      throw paramRecyclerView;
    }
    localObject2 = (LinearLayoutManager)localObject2;
    ((h)localObject1).rZE = ((LinearLayoutManager)localObject2).kn();
    ((h)localObject1).rZG = ((LinearLayoutManager)localObject2).kp();
    ((h)localObject1).rZF = ((LinearLayoutManager)localObject2).km();
    ((h)localObject1).rZH = ((LinearLayoutManager)localObject2).ko();
    int i;
    if (paramRecyclerView.getChildAt(0) != null)
    {
      i = LinearLayoutManager.bB(paramRecyclerView.getChildAt(0));
      ((h)localObject1).rZI = i;
      i = j;
      if (paramRecyclerView.getChildAt(paramRecyclerView.getChildCount() - 1) != null) {
        i = LinearLayoutManager.bB(paramRecyclerView.getChildAt(paramRecyclerView.getChildCount() - 1));
      }
      ((h)localObject1).rZJ = i;
      ((h)localObject1).ajO = ((LinearLayoutManager)localObject2).getItemCount();
      ((h)localObject1).rZK = paramInt;
      localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
      localObject2 = com.tencent.mm.plugin.finder.utils.p.b(paramRecyclerView, ((h)localObject1).rZF, ((h)localObject1).rZH, 8);
      ((h)localObject1).rZL = ((p.a)localObject2).duw;
      String str = ((p.a)localObject2).mediaId;
      d.g.b.p.h(str, "<set-?>");
      ((h)localObject1).rZO = str;
      ((h)localObject1).rZP = ((p.a)localObject2).rZB;
      paramRecyclerView = paramRecyclerView.getAdapter();
      ((h)localObject1).rZM = ((p.a)localObject2).sXB;
      if (!(paramRecyclerView instanceof WxRecyclerAdapter)) {
        break label321;
      }
    }
    label321:
    for (((h)localObject1).rZN = (((p.a)localObject2).sXB - ((WxRecyclerAdapter)paramRecyclerView).LRV.size());; ((h)localObject1).rZN = ((p.a)localObject2).sXB)
    {
      AppMethodBeat.o(202016);
      return localObject1;
      i = -1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.i
 * JD-Core Version:    0.7.0.1
 */