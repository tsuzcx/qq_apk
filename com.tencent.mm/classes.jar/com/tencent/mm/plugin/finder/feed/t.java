package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.w;
import com.tencent.mm.plugin.finder.feed.model.w.a;
import com.tencent.mm.plugin.finder.feed.model.w.a.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.c;
import com.tencent.mm.view.recyclerview.d;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class t
{
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "cacheId", "", "getCacheId", "()J", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "onDetach", "requestRefresh", "plugin-finder_release"})
  public static final class a
    extends n.a
  {
    public a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
    {
      super(paramBaseFinderFeedLoader);
      AppMethodBeat.i(197736);
      AppMethodBeat.o(197736);
    }
    
    public final void aJq()
    {
      AppMethodBeat.i(197733);
      this.qvo.requestLoadMore();
      AppMethodBeat.o(197733);
    }
    
    public final void clJ()
    {
      AppMethodBeat.i(197731);
      n.b localb = this.KMQ;
      if (localb != null)
      {
        localb.N((ArrayList)this.qvo.getDataListJustForAdapter());
        AppMethodBeat.o(197731);
        return;
      }
      AppMethodBeat.o(197731);
    }
    
    public final c clL()
    {
      AppMethodBeat.i(197734);
      Object localObject = this.KMQ;
      if (localObject != null) {}
      for (localObject = ((n.b)localObject).fTe();; localObject = null)
      {
        if (localObject == null) {
          k.fvU();
        }
        localObject = ((com.tencent.mm.plugin.finder.storage.v)localObject).fTj();
        AppMethodBeat.o(197734);
        return localObject;
      }
    }
    
    public final void fTa() {}
    
    public final void onDetach()
    {
      AppMethodBeat.i(197735);
      super.onDetach();
      w.a locala = w.KPW;
      ad.i(w.access$getTAG$cp(), "clearCache");
      w.fTx().clear();
      AppMethodBeat.o(197735);
    }
    
    public final void requestRefresh()
    {
      AppMethodBeat.i(197732);
      this.qvo.requestRefresh();
      AppMethodBeat.o(197732);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "plugin-finder_release"})
  public static final class b
    extends n.b
  {
    private final String TAG;
    
    public b(MMActivity paramMMActivity)
    {
      super(0, 0, true);
      AppMethodBeat.i(197743);
      this.TAG = "Finder.FinderFriendLikeFeedUIContract.ViewCallback";
      AppMethodBeat.o(197743);
    }
    
    public final void c(RecyclerView.a<?> parama, View paramView, int paramInt)
    {
      AppMethodBeat.i(197740);
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
        Object localObject1 = w.KPW;
        localObject1 = (List)fTb().qvo.getDataListJustForAdapter();
        Object localObject2 = fTb().qvo;
        if (localObject2 == null)
        {
          parama = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFriendLikeLoader");
          AppMethodBeat.o(197740);
          throw parama;
        }
        localObject2 = ((w)localObject2).lastBuffer;
        k.h(localObject1, "dataList");
        ad.i(w.access$getTAG$cp(), "putCache " + l + ", list size:" + ((List)localObject1).size());
        List localList = (List)new ArrayList();
        localList.addAll((Collection)localObject1);
        w.fTx().put(Long.valueOf(l), new w.a.a(localList, (b)localObject2));
        parama.putExtra("KEY_CACHE_ID", l);
        localObject1 = a.qSb;
        paramView = paramView.getContext();
        k.g(paramView, "view.context");
        a.ag(paramView, parama);
      }
      AppMethodBeat.o(197740);
    }
    
    public final void fTg() {}
    
    public final MMActivity getActivity()
    {
      return this.imP;
    }
    
    public final View getEmptyView()
    {
      AppMethodBeat.i(197738);
      View localView = this.imP.findViewById(2131299478);
      AppMethodBeat.o(197738);
      return localView;
    }
    
    public final RecyclerView.h getItemDecoration()
    {
      AppMethodBeat.i(197737);
      RecyclerView.h localh = fTe().getItemDecoration();
      AppMethodBeat.o(197737);
      return localh;
    }
    
    public final String h(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(197741);
      k.h(paramc, "reason");
      AppMethodBeat.o(197741);
      return "";
    }
    
    public final String i(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(197742);
      k.h(paramc, "reason");
      AppMethodBeat.o(197742);
      return "";
    }
    
    public final RecyclerView.i lw(Context paramContext)
    {
      AppMethodBeat.i(197739);
      k.h(paramContext, "context");
      paramContext = fTe().lw(paramContext);
      AppMethodBeat.o(197739);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.t
 * JD-Core Version:    0.7.0.1
 */