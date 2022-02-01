package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.d.a.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "plugin-finder_release"})
public final class e$b
  extends c.b
{
  private final String TAG;
  
  private e$b(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, paramInt, 24, false);
    AppMethodBeat.i(201567);
    this.TAG = "Finder.FinderFavFeedUIContract.FavFeedViewCallback";
    AppMethodBeat.o(201567);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(201564);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bb(parama);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bb(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).lS(paramInt);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aeE());
    k.h(parama, "adapter");
    k.h(paramView, "view");
    paramInt -= ((com.tencent.mm.view.recyclerview.d)parama).JCb.size();
    if ((paramInt >= 0) && (paramInt < cuC().rgh.getSize()))
    {
      parama = ((BaseFinderFeed)cuC().rgh.getDataListJustForAdapter().get(paramInt)).feedObject;
      ac.i(this.TAG, "onClick " + paramInt + " id:" + parama.getId() + ", pos:" + paramInt);
      parama = new Intent();
      parama.putExtra("KEY_CLICK_FEED_POSITION", paramInt);
      long l = System.currentTimeMillis();
      localObject1 = com.tencent.mm.plugin.finder.feed.model.d.rmH;
      localObject1 = (List)cuC().rgh.getDataListJustForAdapter();
      Object localObject2 = cuC().rgh;
      if (localObject2 == null)
      {
        parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
        AppMethodBeat.o(201564);
        throw parama;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.feed.model.d)localObject2).lastBuffer;
      k.h(localObject1, "dataList");
      ac.i(com.tencent.mm.plugin.finder.feed.model.d.access$getTAG$cp(), "putCache " + l + ", list size:" + ((List)localObject1).size());
      List localList = (List)new ArrayList();
      localList.addAll((Collection)localObject1);
      com.tencent.mm.plugin.finder.feed.model.d.cvA().put(Long.valueOf(l), new d.a.a(localList, (com.tencent.mm.bw.b)localObject2));
      parama.putExtra("KEY_CACHE_ID", l);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.rOv;
      paramView = paramView.getContext();
      k.g(paramView, "view.context");
      com.tencent.mm.plugin.finder.utils.a.L(paramView, parama);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
    AppMethodBeat.o(201564);
  }
  
  public final void cuH()
  {
    AppMethodBeat.i(201561);
    if (cuD().rgh.getSize() <= this.arE * 3)
    {
      localObject = cuD().rgh;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
        AppMethodBeat.o(201561);
        throw ((Throwable)localObject);
      }
      if (((com.tencent.mm.plugin.finder.feed.model.d)localObject).hasMore) {
        RefreshLoadMoreLayout.d(this.rfT);
      }
    }
    Object localObject = cuD().rgh;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
      AppMethodBeat.o(201561);
      throw ((Throwable)localObject);
    }
    localObject = (com.tencent.mm.plugin.finder.feed.model.d)localObject;
    ((com.tencent.mm.plugin.finder.feed.model.d)localObject).fAw -= 1;
    int i = ((com.tencent.mm.plugin.finder.feed.model.d)localObject).fAw;
    localObject = this.rgo;
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(2131298996);
      if (localObject != null)
      {
        ((TextView)localObject).setText((CharSequence)this.iMV.getResources().getString(2131766387, new Object[] { Integer.valueOf(i) }));
        AppMethodBeat.o(201561);
        return;
      }
    }
    AppMethodBeat.o(201561);
  }
  
  public final String e(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(201565);
    k.h(paramc, "reason");
    paramc = this.iMV.getResources().getString(2131766394);
    AppMethodBeat.o(201565);
    return paramc;
  }
  
  public final RecyclerView.i eL(Context paramContext)
  {
    AppMethodBeat.i(201563);
    k.h(paramContext, "context");
    paramContext = cuF().eL(paramContext);
    AppMethodBeat.o(201563);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(201566);
    k.h(paramc, "reason");
    if (paramc.hvK == null)
    {
      AppMethodBeat.o(201566);
      return null;
    }
    if ((paramc.hvK instanceof Integer))
    {
      Resources localResources = this.iMV.getResources();
      paramc = paramc.hvK;
      if (paramc == null)
      {
        paramc = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(201566);
        throw paramc;
      }
      paramc = localResources.getString(2131766387, new Object[] { (Integer)paramc });
      AppMethodBeat.o(201566);
      return paramc;
    }
    AppMethodBeat.o(201566);
    return null;
  }
  
  public final MMActivity getActivity()
  {
    return this.iMV;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(201562);
    View localView = this.iMV.findViewById(2131299478);
    AppMethodBeat.o(201562);
    return localView;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(201560);
    RecyclerView.h localh = cuF().getItemDecoration();
    AppMethodBeat.o(201560);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.e.b
 * JD-Core Version:    0.7.0.1
 */