package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import com.tencent.mm.view.recyclerview.i;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "plugin-finder_release"})
public final class ao$e
  implements i
{
  ao$e(int paramInt) {}
  
  public final void a(RecyclerView paramRecyclerView, g paramg)
  {
    AppMethodBeat.i(202715);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramg, "data");
    paramRecyclerView = a.KEX;
    paramRecyclerView = a.bi(PluginFinder.class).get(FinderTabStreamUnreadVM.class);
    p.g(paramRecyclerView, "UICProvider.of(PluginFin…reamUnreadVM::class.java)");
    paramRecyclerView = (FinderTabStreamUnreadVM)paramRecyclerView;
    if (this.sjd == 4)
    {
      Object localObject1 = (Iterable)paramg.LSu;
      paramg = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if ((((h)localObject2).LSx instanceof BaseFinderFeed)) {
          paramg.add(localObject2);
        }
      }
      localObject1 = (Iterable)paramg;
      paramg = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((h)((Iterator)localObject1).next()).LSx;
        if (localObject2 == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
          AppMethodBeat.o(202715);
          throw paramRecyclerView;
        }
        paramg.add((BaseFinderFeed)localObject2);
      }
      paramRecyclerView.k(19, (List)paramg);
    }
    AppMethodBeat.o(202715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ao.e
 * JD-Core Version:    0.7.0.1
 */