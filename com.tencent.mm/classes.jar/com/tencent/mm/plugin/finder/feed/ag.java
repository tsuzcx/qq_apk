package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.e.a;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.model.f;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", "canTimelineRefresh", "", "emptyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "isEmptyLocation", "isRequestingLbs", "()Z", "setRequestingLbs", "(Z)V", "msgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "checkEmptyHeader", "r", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "findFirstPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "notifyChanged", "rv", "itemId", "onActionbarClick", "isDouble", "onAttach", "callback", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "onUserVisibleFocused", "refreshMsgNotify", "refreshRV", "data", "Landroid/content/Intent;", "Companion", "plugin-finder_release"})
public final class ag
  implements ad.a<am>
{
  public static final ag.b shq;
  public final MMActivity activity;
  public ad.b<am> sgL;
  public final FinderHomeTabStateVM sgM;
  private final boolean sgN;
  public int sgO;
  boolean sgP;
  public boolean sgQ;
  private f sgR;
  private com.tencent.mm.view.d sgS;
  private final FinderHomeTabFragment sgT;
  public final FinderTimelineFeedLoader sho;
  private final com.tencent.mm.plugin.finder.model.g shp;
  
  static
  {
    AppMethodBeat.i(202603);
    shq = new ag.b((byte)0);
    AppMethodBeat.o(202603);
  }
  
  public ag(MMActivity paramMMActivity, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(202602);
    this.activity = paramMMActivity;
    this.sgT = paramFinderHomeTabFragment;
    paramMMActivity = com.tencent.mm.ui.component.a.KEX;
    paramMMActivity = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    p.g(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.sgM = ((FinderHomeTabStateVM)paramMMActivity);
    this.sgN = this.sgM.EX(2);
    paramMMActivity = com.tencent.mm.plugin.finder.feed.model.internal.e.slN;
    paramMMActivity = e.a.EQ(2);
    if (this.sgN) {}
    for (int i = 0;; i = 1)
    {
      paramFinderHomeTabFragment = com.tencent.mm.ui.component.a.KEX;
      paramMMActivity = new FinderTimelineFeedLoader(paramMMActivity, i, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.activity).get(FinderReporterUIC.class)).cQZ());
      paramMMActivity.setInitDone((h)new a(paramMMActivity, this));
      this.sho = paramMMActivity;
      this.sgS = ((com.tencent.mm.view.d)new k(this));
      this.sgR = new f();
      this.shp = new com.tencent.mm.plugin.finder.model.g();
      AppMethodBeat.o(202602);
      return;
    }
  }
  
  private final void g(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202597);
    com.tencent.mm.ac.c.h((d.g.a.a)new d(this, paramc));
    AppMethodBeat.o(202597);
  }
  
  public static int u(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(202600);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    int i;
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      int[] arrayOfInt = new int[2];
      ((StaggeredGridLayoutManager)paramRecyclerView).n(arrayOfInt);
      i = arrayOfInt[1];
      AppMethodBeat.o(202600);
      return i;
    }
    if ((paramRecyclerView instanceof LinearLayoutManager))
    {
      i = ((LinearLayoutManager)paramRecyclerView).km();
      AppMethodBeat.o(202600);
      return i;
    }
    AppMethodBeat.o(202600);
    return 0;
  }
  
  public final void ZC()
  {
    AppMethodBeat.i(202594);
    this.sho.requestLoadMore();
    AppMethodBeat.o(202594);
  }
  
  public final void a(ad.b<am> paramb)
  {
    AppMethodBeat.i(202595);
    p.h(paramb, "callback");
    this.sgL = paramb;
    paramb = this.sgL;
    if (paramb == null) {
      p.bdF("viewCallback");
    }
    paramb.U((ArrayList)this.sho.getDataListJustForAdapter());
    this.sho.register(this.sgS);
    paramb = com.tencent.mm.plugin.finder.utils.i.sWy;
    if (com.tencent.mm.plugin.finder.utils.i.cNN())
    {
      this.sgM.GH(2).tkA.size();
      BaseFeedLoader.requestInit$default(this.sho, false, 1, null);
      paramb = this.sgL;
      if (paramb == null) {
        p.bdF("viewCallback");
      }
      paramb.getRecyclerView().a((RecyclerView.m)new e(this));
      AppMethodBeat.o(202595);
      return;
    }
    paramb = new RefreshLoadMoreLayout.c(0);
    paramb.LNR = -2;
    g(paramb);
    AppMethodBeat.o(202595);
  }
  
  public final void b(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202593);
    p.h(paramc, "reason");
    if (paramc.LNU <= 0)
    {
      Object localObject = this.sgL;
      if (localObject == null) {
        p.bdF("viewCallback");
      }
      localObject = ((ad.b)localObject).cDp();
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
      ((RefreshLoadMoreLayout)localObject).b(com.tencent.mm.plugin.finder.storage.b.cIs(), (d.g.a.a)ag.i.shz);
    }
    g(paramc);
    paramc = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    p.g(paramc, "MMKernel.plugin(PluginFinder::class.java)");
    com.tencent.mm.plugin.finder.extension.reddot.e.a(((PluginFinder)paramc).getRedDotManager(), 1003);
    AppMethodBeat.o(202593);
  }
  
  public final ad.b<am> cDr()
  {
    AppMethodBeat.i(202591);
    ad.b localb = this.sgL;
    if (localb == null) {
      p.bdF("viewCallback");
    }
    AppMethodBeat.o(202591);
    return localb;
  }
  
  public final void cvt()
  {
    AppMethodBeat.i(202592);
    com.tencent.mm.plugin.finder.utils.i locali = com.tencent.mm.plugin.finder.utils.i.sWy;
    com.tencent.mm.plugin.finder.utils.i.a((d.g.a.a)new f(this), (d.g.a.a)new g(this), (d.g.a.a)new h(this));
    AppMethodBeat.o(202592);
  }
  
  public final void lT(boolean paramBoolean)
  {
    AppMethodBeat.i(202599);
    Object localObject1 = this.sgL;
    if (localObject1 == null) {
      p.bdF("viewCallback");
    }
    localObject1 = ((ad.b)localObject1).getRecyclerView();
    int i = u((RecyclerView)localObject1);
    ae.i("Finder.TimelineLbsPresenter", "[onActionbarClick] position=" + i + " isDouble=" + paramBoolean);
    Object localObject2;
    if (i <= 12)
    {
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      if (!paramBoolean) {
        break label304;
      }
      if (i > 12) {
        break label287;
      }
      wx(20L);
    }
    for (;;)
    {
      localObject1 = FinderReporterUIC.tnG;
      localObject1 = FinderReporterUIC.a.fc((Context)this.activity);
      if (localObject1 == null) {
        break label297;
      }
      localObject2 = com.tencent.mm.plugin.finder.report.i.syT;
      com.tencent.mm.plugin.finder.report.i.a(((FinderReporterUIC)localObject1).cQZ(), 5);
      AppMethodBeat.o(202599);
      return;
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      break;
      label287:
      wx(600L);
    }
    label297:
    AppMethodBeat.o(202599);
    return;
    label304:
    localObject1 = FinderReporterUIC.tnG;
    localObject1 = FinderReporterUIC.a.fc((Context)this.activity);
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.report.i.syT;
      com.tencent.mm.plugin.finder.report.i.a(((FinderReporterUIC)localObject1).cQZ(), 1);
      AppMethodBeat.o(202599);
      return;
    }
    AppMethodBeat.o(202599);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(202601);
    this.sho.unregister(this.sgS);
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KEX;
    ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).GG(2);
    AppMethodBeat.o(202601);
  }
  
  public final void wx(long paramLong)
  {
    AppMethodBeat.i(202598);
    Object localObject = this.sgL;
    if (localObject == null) {
      p.bdF("viewCallback");
    }
    localObject = ((ad.b)localObject).cDp();
    ((RefreshLoadMoreLayout)localObject).postDelayed((Runnable)new c((RefreshLoadMoreLayout)localObject), paramLong);
    AppMethodBeat.o(202598);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$feedLoader$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements h
  {
    a(FinderTimelineFeedLoader paramFinderTimelineFeedLoader, ag paramag) {}
    
    public final void call(final int paramInt)
    {
      AppMethodBeat.i(202565);
      ae.i(this.shr.getTAG(), "[initData] canTimelineRefresh=" + ag.f(jdField_this) + ", incrementCount=" + paramInt);
      if (ag.f(jdField_this))
      {
        jdField_this.wx(0L);
        jdField_this.cDr().cDp().post((Runnable)ah.sht);
      }
      for (;;)
      {
        jdField_this.cDr().cDp().post((Runnable)ai.shu);
        AppMethodBeat.o(202565);
        return;
        Object localObject = ag.g(jdField_this).GH(2);
        paramInt = ((FinderHomeTabStateVM.a)localObject).tkC;
        final int i = ((FinderHomeTabStateVM.a)localObject).tkD;
        ae.i(this.shr.getTAG(), "[initData] canTimelineRefresh " + ag.f(jdField_this) + " lastPos=" + paramInt + " fromTopPixel=" + i);
        localObject = jdField_this.cDr().getRecyclerView().getLayoutManager();
        ag.a(jdField_this, i);
        if ((localObject instanceof StaggeredGridLayoutManager))
        {
          ((StaggeredGridLayoutManager)localObject).ag(paramInt, i);
          jdField_this.cDr().getRecyclerView().post((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(202564);
              ((StaggeredGridLayoutManager)this.sha).ag(paramInt, i);
              AppMethodBeat.o(202564);
            }
          });
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(202566);
      this.sgV.zu(this.sgW);
      AppMethodBeat.o(202566);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(ag paramag, RefreshLoadMoreLayout.c paramc)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class e
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202572);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt1);
      localb.mu(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
      p.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = this.shs;
      ag.a(paramRecyclerView, ag.b(paramRecyclerView) - paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(202572);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(202573);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
      super.b(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(202573);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(ag paramag)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<z>
  {
    g(ag paramag)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(ag paramag)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class j
    extends q
    implements d.g.a.a<z>
  {
    public j(ag paramag)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class k
    implements com.tencent.mm.view.d
  {
    private WxRecyclerAdapter<?> getAdapter()
    {
      AppMethodBeat.i(202584);
      Object localObject = this.shs.cDr().getRecyclerView().getAdapter();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
        AppMethodBeat.o(202584);
        throw ((Throwable)localObject);
      }
      localObject = (WxRecyclerAdapter)localObject;
      AppMethodBeat.o(202584);
      return localObject;
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202587);
      Object localObject = this.shs.cDr();
      if (localObject != null)
      {
        localObject = ((ad.b)localObject).cDp();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.LRV.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).au(i + paramInt1, paramInt2);
            AppMethodBeat.o(202587);
            return;
          }
        }
      }
      AppMethodBeat.o(202587);
    }
    
    public final void av(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202588);
      Object localObject = this.shs.cDr();
      if (localObject != null)
      {
        localObject = ((ad.b)localObject).cDp();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.LRV.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).av(i + paramInt1, paramInt2);
            AppMethodBeat.o(202588);
            return;
          }
        }
      }
      AppMethodBeat.o(202588);
    }
    
    public final void c(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202589);
      p.h(paramc, "reason");
      this.shs.cDr().cDp().c(paramc);
      AppMethodBeat.o(202589);
    }
    
    public final void d(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202590);
      p.h(paramc, "reason");
      this.shs.cDr().cDp().d(paramc);
      AppMethodBeat.o(202590);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(202586);
      Object localObject = this.shs.cDr();
      if (localObject != null)
      {
        localObject = ((ad.b)localObject).cDp();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.LRV.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).f(i + paramInt1, paramInt2, paramObject);
            AppMethodBeat.o(202586);
            return;
          }
        }
      }
      AppMethodBeat.o(202586);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(202585);
      Object localObject = this.shs.cDr();
      if (localObject != null)
      {
        localObject = ((ad.b)localObject).cDp();
        if (localObject != null)
        {
          ((RefreshLoadMoreLayout)localObject).onChanged();
          AppMethodBeat.o(202585);
          return;
        }
      }
      AppMethodBeat.o(202585);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ag
 * JD-Core Version:    0.7.0.1
 */