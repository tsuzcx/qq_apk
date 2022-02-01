package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.y;
import com.tencent.mm.plugin.finder.feed.model.y.a;
import com.tencent.mm.plugin.finder.feed.model.y.a.a;
import com.tencent.mm.plugin.finder.feed.model.y.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.c;
import com.tencent.mm.view.recyclerview.d;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract;", "", "()V", "LbsStreamFeedPresenter", "LbsStreamFeedViewCallback", "plugin-finder_release"})
public final class w
{
  public static final w KND;
  
  static
  {
    AppMethodBeat.i(197795);
    KND = new w();
    AppMethodBeat.o(197795);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "cacheId", "", "getCacheId", "()J", "setCacheId", "(J)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "Companion", "plugin-finder_release"})
  public static final class a
    extends n.a
  {
    public static final a KNE;
    
    static
    {
      AppMethodBeat.i(197787);
      KNE = new a((byte)0);
      AppMethodBeat.o(197787);
    }
    
    public a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
    {
      super(paramBaseFinderFeedLoader);
      AppMethodBeat.i(197786);
      AppMethodBeat.o(197786);
    }
    
    public final void a(n.b paramb)
    {
      AppMethodBeat.i(197782);
      k.h(paramb, "callback");
      super.a(paramb);
      AppMethodBeat.o(197782);
    }
    
    public final void aJq()
    {
      AppMethodBeat.i(197780);
      this.qvo.requestLoadMore();
      AppMethodBeat.o(197780);
    }
    
    public final void clJ()
    {
      AppMethodBeat.i(197779);
      n.b localb = this.KMQ;
      if (localb != null)
      {
        localb.N((ArrayList)this.qvo.getDataListJustForAdapter());
        AppMethodBeat.o(197779);
        return;
      }
      AppMethodBeat.o(197779);
    }
    
    public final c clL()
    {
      AppMethodBeat.i(197784);
      Object localObject = this.KMQ;
      if (localObject != null) {}
      for (localObject = ((n.b)localObject).fTe();; localObject = null)
      {
        if (localObject == null) {
          k.fvU();
        }
        localObject = ((com.tencent.mm.plugin.finder.storage.v)localObject).fTj();
        AppMethodBeat.o(197784);
        return localObject;
      }
    }
    
    public final void fTa()
    {
      AppMethodBeat.i(197781);
      long l = this.imP.getIntent().getLongExtra("KEY_CACHE_ID", 0L);
      Object localObject = this.qvo;
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader");
        AppMethodBeat.o(197781);
        throw ((Throwable)localObject);
      }
      localObject = (y)localObject;
      y.a locala = y.KQe;
      ((y)localObject).lastBuffer = y.a.BL(l).lastBuffer;
      com.tencent.mm.plugin.finder.feed.model.internal.a.initData$default(this.qvo, (h)new y.c(l, (g)new b()), false, 2, null);
      AppMethodBeat.o(197781);
    }
    
    public final void onDetach()
    {
      AppMethodBeat.i(197785);
      super.onDetach();
      y.a locala = y.KQe;
      ad.i(y.access$getTAG$cp(), "clearCache");
      y.fTy().clear();
      AppMethodBeat.o(197785);
    }
    
    public final void requestRefresh() {}
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {}
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedPresenter$loadInitData$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class b
      implements g
    {
      public final void call(int paramInt)
      {
        AppMethodBeat.i(197778);
        ad.i("LbsStreamFeedPresenter", "[loadInitData] incrementCount=".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(197778);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "title", "", "(Lcom/tencent/mm/ui/MMActivity;IILjava/lang/String;)V", "TAG", "getTitle", "()Ljava/lang/String;", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "refreshWhenEnter", "", "plugin-finder_release"})
  public static final class b
    extends n.b
  {
    private final String TAG;
    private final String title;
    
    public b(MMActivity paramMMActivity, int paramInt, String paramString)
    {
      super(paramInt, 16);
      AppMethodBeat.i(197794);
      this.title = paramString;
      this.TAG = "Finder.LbsStreamFeedUIContract.LbsStreamFeedViewCallback";
      AppMethodBeat.o(197794);
    }
    
    public final void c(RecyclerView.a<?> parama, View paramView, int paramInt)
    {
      AppMethodBeat.i(197791);
      k.h(parama, "adapter");
      k.h(paramView, "view");
      paramInt -= ((d)parama).Ibl.size();
      if ((paramInt >= 0) && (paramInt < fTb().qvo.getSize()))
      {
        parama = ((BaseFinderFeed)fTb().qvo.getDataListJustForAdapter().get(paramInt)).feedObject;
        ad.i(this.TAG, "onClick " + paramInt + " id:" + parama.getId() + ", pos:" + paramInt);
        Object localObject1 = new Intent();
        ((Intent)localObject1).putExtra("KEY_CLICK_FEED_POSITION", paramInt);
        long l = System.currentTimeMillis();
        Object localObject2 = y.KQe;
        localObject2 = (List)fTb().qvo.getDataListJustForAdapter();
        BaseFinderFeedLoader localBaseFinderFeedLoader = fTb().qvo;
        if (localBaseFinderFeedLoader == null)
        {
          parama = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader");
          AppMethodBeat.o(197791);
          throw parama;
        }
        y.a.a(l, (List)localObject2, ((y)localBaseFinderFeedLoader).lastBuffer);
        ((Intent)localObject1).putExtra("KEY_CACHE_ID", l);
        ((Intent)localObject1).putExtra("KEY_UI_TITLE", this.title);
        localObject2 = FinderReporterUIC.Ljl;
        localObject2 = paramView.getContext();
        k.g(localObject2, "view.context");
        FinderReporterUIC.a.a((Context)localObject2, (Intent)localObject1, 0L, 0, false, 124);
        localObject2 = com.tencent.mm.plugin.finder.utils.a.qSb;
        localObject2 = paramView.getContext();
        k.g(localObject2, "view.context");
        com.tencent.mm.plugin.finder.utils.a.ad((Context)localObject2, (Intent)localObject1);
        localObject1 = FinderReporterUIC.Ljl;
        paramView = paramView.getContext();
        k.g(paramView, "view.context");
        paramView = FinderReporterUIC.a.lB(paramView);
        if (paramView != null)
        {
          paramView = paramView.fXs();
          if (paramView != null)
          {
            localObject1 = b.qFq;
            b.a(paramView, parama.getId(), this.quj.getRecyclerView());
            AppMethodBeat.o(197791);
            return;
          }
        }
      }
      AppMethodBeat.o(197791);
    }
    
    public final boolean fTf()
    {
      return false;
    }
    
    public final void fTg() {}
    
    public final MMActivity getActivity()
    {
      return this.imP;
    }
    
    public final View getEmptyView()
    {
      AppMethodBeat.i(197789);
      View localView = this.imP.findViewById(2131299478);
      AppMethodBeat.o(197789);
      return localView;
    }
    
    public final RecyclerView.h getItemDecoration()
    {
      AppMethodBeat.i(197788);
      RecyclerView.h localh = fTe().getItemDecoration();
      AppMethodBeat.o(197788);
      return localh;
    }
    
    public final String h(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(197792);
      k.h(paramc, "reason");
      AppMethodBeat.o(197792);
      return null;
    }
    
    public final String i(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(197793);
      k.h(paramc, "reason");
      AppMethodBeat.o(197793);
      return null;
    }
    
    public final RecyclerView.i lw(Context paramContext)
    {
      AppMethodBeat.i(197790);
      k.h(paramContext, "context");
      paramContext = fTe().lw(paramContext);
      AppMethodBeat.o(197790);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.w
 * JD-Core Version:    0.7.0.1
 */