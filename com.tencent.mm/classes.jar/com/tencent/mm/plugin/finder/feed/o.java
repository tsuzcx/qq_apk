package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.a.a;
import com.tencent.mm.plugin.finder.feed.model.a.a.a;
import com.tencent.mm.plugin.finder.feed.model.a.c;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.c;
import com.tencent.mm.view.recyclerview.d;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract;", "", "()V", "FavFeedPresenter", "FavFeedViewCallback", "plugin-finder_release"})
public final class o
{
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "cacheId", "", "getCacheId", "()J", "setCacheId", "(J)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
  public static final class a
    extends n.a
  {
    long qxT;
    
    public a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
    {
      super(paramBaseFinderFeedLoader);
      AppMethodBeat.i(197662);
      AppMethodBeat.o(197662);
    }
    
    public final void a(n.b paramb)
    {
      AppMethodBeat.i(197658);
      k.h(paramb, "callback");
      super.a(paramb);
      AppMethodBeat.o(197658);
    }
    
    public final void aJq()
    {
      AppMethodBeat.i(197656);
      this.qvo.requestLoadMore();
      AppMethodBeat.o(197656);
    }
    
    public final void clJ()
    {
      AppMethodBeat.i(197654);
      n.b localb = this.KMQ;
      if (localb != null)
      {
        localb.N((ArrayList)this.qvo.getDataListJustForAdapter());
        AppMethodBeat.o(197654);
        return;
      }
      AppMethodBeat.o(197654);
    }
    
    public final c clL()
    {
      AppMethodBeat.i(197660);
      Object localObject = this.KMQ;
      if (localObject != null) {}
      for (localObject = ((n.b)localObject).fTe();; localObject = null)
      {
        if (localObject == null) {
          k.fvU();
        }
        localObject = ((com.tencent.mm.plugin.finder.storage.v)localObject).fTj();
        AppMethodBeat.o(197660);
        return localObject;
      }
    }
    
    public final void fTa()
    {
      AppMethodBeat.i(197657);
      com.tencent.mm.plugin.finder.feed.model.internal.a.initData$default(this.qvo, (h)new a.c(0L, false, (g)new a(this)), false, 2, null);
      AppMethodBeat.o(197657);
    }
    
    public final void onDetach()
    {
      AppMethodBeat.i(197661);
      super.onDetach();
      a.a locala = com.tencent.mm.plugin.finder.feed.model.a.KPO;
      ad.i(com.tencent.mm.plugin.finder.feed.model.a.access$getTAG$cp(), "clearCache");
      com.tencent.mm.plugin.finder.feed.model.a.fTv().clear();
      AppMethodBeat.o(197661);
    }
    
    public final void requestRefresh()
    {
      AppMethodBeat.i(197655);
      this.qvo.requestRefresh();
      AppMethodBeat.o(197655);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedPresenter$loadInitData$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class a
      implements g
    {
      public final void call(int paramInt)
      {
        AppMethodBeat.i(197653);
        Object localObject = this.KNe.qvo;
        if (localObject == null)
        {
          localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
          AppMethodBeat.o(197653);
          throw ((Throwable)localObject);
        }
        localObject = (com.tencent.mm.plugin.finder.feed.model.a)localObject;
        a.a locala = com.tencent.mm.plugin.finder.feed.model.a.KPO;
        ((com.tencent.mm.plugin.finder.feed.model.a)localObject).lastBuffer = a.a.BJ(this.KNe.qxT).lastBuffer;
        localObject = this.KNe.KMQ;
        if (localObject != null)
        {
          localObject = ((n.b)localObject).getEmptyView();
          if (localObject != null)
          {
            ((View)localObject).setVisibility(8);
            localObject = this.KNe.KMQ;
            if (localObject != null)
            {
              localObject = ((n.b)localObject).quj.getRecyclerView();
              if (localObject != null) {
                ((RecyclerView)localObject).setVisibility(0);
              }
            }
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)new gy());
            AppMethodBeat.o(197653);
            return;
          }
        }
        AppMethodBeat.o(197653);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "plugin-finder_release"})
  public static final class b
    extends n.b
  {
    private final String TAG;
    
    private b(MMActivity paramMMActivity, int paramInt)
    {
      super(paramInt, 24, false);
      AppMethodBeat.i(197670);
      this.TAG = "Finder.FinderFavFeedUIContract.FavFeedViewCallback";
      AppMethodBeat.o(197670);
    }
    
    public final void c(RecyclerView.a<?> parama, View paramView, int paramInt)
    {
      AppMethodBeat.i(197667);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).be(parama);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).be(paramView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ado());
      k.h(parama, "adapter");
      k.h(paramView, "view");
      paramInt -= ((d)parama).Ibl.size();
      if ((paramInt >= 0) && (paramInt < fTb().qvo.getSize()))
      {
        parama = ((BaseFinderFeed)fTb().qvo.getDataListJustForAdapter().get(paramInt)).feedObject;
        ad.i(this.TAG, "onClick " + paramInt + " id:" + parama.getId() + ", pos:" + paramInt);
        parama = new Intent();
        parama.putExtra("KEY_CLICK_FEED_POSITION", paramInt);
        long l = System.currentTimeMillis();
        localObject1 = com.tencent.mm.plugin.finder.feed.model.a.KPO;
        localObject1 = (List)fTb().qvo.getDataListJustForAdapter();
        Object localObject2 = fTb().qvo;
        if (localObject2 == null)
        {
          parama = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
          AppMethodBeat.o(197667);
          throw parama;
        }
        localObject2 = ((com.tencent.mm.plugin.finder.feed.model.a)localObject2).lastBuffer;
        k.h(localObject1, "dataList");
        ad.i(com.tencent.mm.plugin.finder.feed.model.a.access$getTAG$cp(), "putCache " + l + ", list size:" + ((List)localObject1).size());
        List localList = (List)new ArrayList();
        localList.addAll((Collection)localObject1);
        com.tencent.mm.plugin.finder.feed.model.a.fTv().put(Long.valueOf(l), new a.a.a(localList, (com.tencent.mm.bx.b)localObject2));
        parama.putExtra("KEY_CACHE_ID", l);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.qSb;
        paramView = paramView.getContext();
        k.g(paramView, "view.context");
        com.tencent.mm.plugin.finder.utils.a.ac(paramView, parama);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
      AppMethodBeat.o(197667);
    }
    
    public final void fTg()
    {
      AppMethodBeat.i(197664);
      if (fTc().qvo.getSize() <= this.aqI * 3)
      {
        localObject = fTc().qvo;
        if (localObject == null)
        {
          localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
          AppMethodBeat.o(197664);
          throw ((Throwable)localObject);
        }
        if (((com.tencent.mm.plugin.finder.feed.model.a)localObject).hasMore) {
          RefreshLoadMoreLayout.k(this.quj);
        }
      }
      Object localObject = fTc().qvo;
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
        AppMethodBeat.o(197664);
        throw ((Throwable)localObject);
      }
      localObject = (com.tencent.mm.plugin.finder.feed.model.a)localObject;
      ((com.tencent.mm.plugin.finder.feed.model.a)localObject).fwP -= 1;
      int i = ((com.tencent.mm.plugin.finder.feed.model.a)localObject).fwP;
      localObject = this.KMV;
      if (localObject != null)
      {
        localObject = (TextView)((View)localObject).findViewById(2131298996);
        if (localObject != null)
        {
          ((TextView)localObject).setText((CharSequence)this.imP.getResources().getString(2131766237, new Object[] { Integer.valueOf(i) }));
          AppMethodBeat.o(197664);
          return;
        }
      }
      AppMethodBeat.o(197664);
    }
    
    public final MMActivity getActivity()
    {
      return this.imP;
    }
    
    public final View getEmptyView()
    {
      AppMethodBeat.i(197665);
      View localView = this.imP.findViewById(2131299478);
      AppMethodBeat.o(197665);
      return localView;
    }
    
    public final RecyclerView.h getItemDecoration()
    {
      AppMethodBeat.i(197663);
      RecyclerView.h localh = fTe().getItemDecoration();
      AppMethodBeat.o(197663);
      return localh;
    }
    
    public final String h(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(197668);
      k.h(paramc, "reason");
      paramc = this.imP.getResources().getString(2131766238);
      AppMethodBeat.o(197668);
      return paramc;
    }
    
    public final String i(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(197669);
      k.h(paramc, "reason");
      if (paramc.gVl == null)
      {
        AppMethodBeat.o(197669);
        return null;
      }
      if ((paramc.gVl instanceof Integer))
      {
        Resources localResources = this.imP.getResources();
        paramc = paramc.gVl;
        if (paramc == null)
        {
          paramc = new d.v("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(197669);
          throw paramc;
        }
        paramc = localResources.getString(2131766237, new Object[] { (Integer)paramc });
        AppMethodBeat.o(197669);
        return paramc;
      }
      AppMethodBeat.o(197669);
      return null;
    }
    
    public final RecyclerView.i lw(Context paramContext)
    {
      AppMethodBeat.i(197666);
      k.h(paramContext, "context");
      paramContext = fTe().lw(paramContext);
      AppMethodBeat.o(197666);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.o
 * JD-Core Version:    0.7.0.1
 */