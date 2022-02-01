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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/event/base/ScrollEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "newState", "", "handleEvent", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public class i
  extends f
{
  public i(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(165579);
    AppMethodBeat.o(165579);
  }
  
  public h En(int paramInt)
  {
    AppMethodBeat.i(201567);
    h localh = new h(paramInt);
    AppMethodBeat.o(201567);
    return localh;
  }
  
  public h i(RecyclerView paramRecyclerView, int paramInt)
  {
    int j = -1;
    AppMethodBeat.i(201569);
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    Object localObject1 = super.h(paramRecyclerView, paramInt);
    if (localObject1 == null)
    {
      paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.event.base.ScrollEvent");
      AppMethodBeat.o(201569);
      throw paramRecyclerView;
    }
    localObject1 = (h)localObject1;
    Object localObject2 = paramRecyclerView.getLayoutManager();
    if (localObject2 == null)
    {
      paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
      AppMethodBeat.o(201569);
      throw paramRecyclerView;
    }
    localObject2 = (LinearLayoutManager)localObject2;
    ((h)localObject1).rRc = ((LinearLayoutManager)localObject2).kn();
    ((h)localObject1).rRe = ((LinearLayoutManager)localObject2).kp();
    ((h)localObject1).rRd = ((LinearLayoutManager)localObject2).km();
    ((h)localObject1).rRf = ((LinearLayoutManager)localObject2).ko();
    int i;
    if (paramRecyclerView.getChildAt(0) != null)
    {
      i = LinearLayoutManager.bB(paramRecyclerView.getChildAt(0));
      ((h)localObject1).rRg = i;
      i = j;
      if (paramRecyclerView.getChildAt(paramRecyclerView.getChildCount() - 1) != null) {
        i = LinearLayoutManager.bB(paramRecyclerView.getChildAt(paramRecyclerView.getChildCount() - 1));
      }
      ((h)localObject1).rRh = i;
      ((h)localObject1).ajO = ((LinearLayoutManager)localObject2).getItemCount();
      ((h)localObject1).rRi = paramInt;
      localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
      localObject2 = com.tencent.mm.plugin.finder.utils.p.b(paramRecyclerView, ((h)localObject1).rRd, ((h)localObject1).rRf, 8);
      ((h)localObject1).rRj = ((p.a)localObject2).dtq;
      String str = ((p.a)localObject2).mediaId;
      d.g.b.p.h(str, "<set-?>");
      ((h)localObject1).rRm = str;
      ((h)localObject1).rRn = ((p.a)localObject2).rQZ;
      paramRecyclerView = paramRecyclerView.getAdapter();
      ((h)localObject1).rRk = ((p.a)localObject2).sMq;
      if (!(paramRecyclerView instanceof WxRecyclerAdapter)) {
        break label321;
      }
    }
    label321:
    for (((h)localObject1).rRl = (((p.a)localObject2).sMq - ((WxRecyclerAdapter)paramRecyclerView).Lvi.size());; ((h)localObject1).rRl = ((p.a)localObject2).sMq)
    {
      AppMethodBeat.o(201569);
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