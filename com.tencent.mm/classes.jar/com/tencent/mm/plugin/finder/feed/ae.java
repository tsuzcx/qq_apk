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
import com.tencent.mm.plugin.finder.feed.model.FinderLbsLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.model.f;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", "canTimelineRefresh", "", "emptyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;)V", "isEmptyLocation", "isRequestingLbs", "()Z", "setRequestingLbs", "(Z)V", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "checkEmptyHeader", "r", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "findFirstPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "onActionbarClick", "isDouble", "onAttach", "callback", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "onUserVisibleFocused", "Companion", "plugin-finder_release"})
public final class ae
  implements ad.a<com.tencent.mm.plugin.finder.model.c>
{
  public static final ae.a sgU;
  public final MMActivity activity;
  public FinderLbsLoader sgK;
  public ad.b<com.tencent.mm.plugin.finder.model.c> sgL;
  public final FinderHomeTabStateVM sgM;
  private final boolean sgN;
  public int sgO;
  boolean sgP;
  public boolean sgQ;
  private f sgR;
  private com.tencent.mm.view.d sgS;
  private final FinderHomeTabFragment sgT;
  
  static
  {
    AppMethodBeat.i(202548);
    sgU = new ae.a((byte)0);
    AppMethodBeat.o(202548);
  }
  
  public ae(MMActivity paramMMActivity, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(202547);
    this.activity = paramMMActivity;
    this.sgT = paramFinderHomeTabFragment;
    paramMMActivity = com.tencent.mm.ui.component.a.KEX;
    paramMMActivity = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    p.g(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.sgM = ((FinderHomeTabStateVM)paramMMActivity);
    this.sgN = this.sgM.EX(1000);
    this.sgR = new f();
    this.sgS = ((com.tencent.mm.view.d)new k(this));
    AppMethodBeat.o(202547);
  }
  
  private final void g(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202545);
    com.tencent.mm.ac.c.h((d.g.a.a)new c(this, paramc));
    AppMethodBeat.o(202545);
  }
  
  public static int u(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(202543);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    int i;
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      int[] arrayOfInt = new int[2];
      ((StaggeredGridLayoutManager)paramRecyclerView).n(arrayOfInt);
      i = arrayOfInt[1];
      AppMethodBeat.o(202543);
      return i;
    }
    if ((paramRecyclerView instanceof LinearLayoutManager))
    {
      i = ((LinearLayoutManager)paramRecyclerView).km();
      AppMethodBeat.o(202543);
      return i;
    }
    AppMethodBeat.o(202543);
    return 0;
  }
  
  public final void ZC()
  {
    AppMethodBeat.i(202538);
    FinderLbsLoader localFinderLbsLoader = this.sgK;
    if (localFinderLbsLoader == null) {
      p.bdF("feedLoader");
    }
    localFinderLbsLoader.requestLoadMore();
    AppMethodBeat.o(202538);
  }
  
  public final void a(ad.b<com.tencent.mm.plugin.finder.model.c> paramb)
  {
    AppMethodBeat.i(202539);
    p.h(paramb, "callback");
    this.sgL = paramb;
    paramb = com.tencent.mm.ui.component.a.KEX;
    paramb = new FinderLbsLoader(((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.activity).get(FinderReporterUIC.class)).cQZ());
    paramb.setInitDone((h)new d(paramb, this));
    paramb.fetchEndCallback = ((d.g.a.b)new e(this));
    this.sgK = paramb;
    paramb = this.sgL;
    if (paramb == null) {
      p.bdF("viewCallback");
    }
    FinderLbsLoader localFinderLbsLoader = this.sgK;
    if (localFinderLbsLoader == null) {
      p.bdF("feedLoader");
    }
    paramb.U((ArrayList)localFinderLbsLoader.getDataListJustForAdapter());
    paramb = this.sgK;
    if (paramb == null) {
      p.bdF("feedLoader");
    }
    paramb.register(this.sgS);
    paramb = com.tencent.mm.plugin.finder.utils.i.sWy;
    if (com.tencent.mm.plugin.finder.utils.i.cNN())
    {
      this.sgM.GH(1000).tkB.size();
      paramb = this.sgK;
      if (paramb == null) {
        p.bdF("feedLoader");
      }
      paramb.requestInit(false);
      paramb = this.sgL;
      if (paramb == null) {
        p.bdF("viewCallback");
      }
      paramb.getRecyclerView().a((RecyclerView.m)new f(this));
      AppMethodBeat.o(202539);
      return;
    }
    paramb = new RefreshLoadMoreLayout.c(0);
    paramb.LNR = -2;
    g(paramb);
    AppMethodBeat.o(202539);
  }
  
  public final void b(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202537);
    p.h(paramc, "reason");
    Object localObject;
    if (paramc.LNU <= 0)
    {
      localObject = this.sgL;
      if (localObject == null) {
        p.bdF("viewCallback");
      }
      localObject = ((ad.b)localObject).cDp();
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
      ((RefreshLoadMoreLayout)localObject).b(com.tencent.mm.plugin.finder.storage.b.cIs(), (d.g.a.a)ae.j.shi);
    }
    if (paramc.LNT)
    {
      localObject = this.sgL;
      if (localObject == null) {
        p.bdF("viewCallback");
      }
      if (!((ad.b)localObject).cDp().LNG)
      {
        localObject = this.sgL;
        if (localObject == null) {
          p.bdF("viewCallback");
        }
        ((ad.b)localObject).cDp().setHasBottomMore(true);
      }
    }
    g(paramc);
    AppMethodBeat.o(202537);
  }
  
  public final FinderLbsLoader cDq()
  {
    AppMethodBeat.i(202534);
    FinderLbsLoader localFinderLbsLoader = this.sgK;
    if (localFinderLbsLoader == null) {
      p.bdF("feedLoader");
    }
    AppMethodBeat.o(202534);
    return localFinderLbsLoader;
  }
  
  public final ad.b<com.tencent.mm.plugin.finder.model.c> cDr()
  {
    AppMethodBeat.i(202535);
    ad.b localb = this.sgL;
    if (localb == null) {
      p.bdF("viewCallback");
    }
    AppMethodBeat.o(202535);
    return localb;
  }
  
  public final void cvt()
  {
    AppMethodBeat.i(202536);
    com.tencent.mm.plugin.finder.utils.i locali = com.tencent.mm.plugin.finder.utils.i.sWy;
    com.tencent.mm.plugin.finder.utils.i.a((d.g.a.a)new g(this), (d.g.a.a)new h(this), (d.g.a.a)new i(this));
    AppMethodBeat.o(202536);
  }
  
  public final void lT(boolean paramBoolean)
  {
    AppMethodBeat.i(202542);
    Object localObject1 = this.sgL;
    if (localObject1 == null) {
      p.bdF("viewCallback");
    }
    localObject1 = ((ad.b)localObject1).getRecyclerView();
    int i = u((RecyclerView)localObject1);
    com.tencent.mm.sdk.platformtools.ae.i("Finder.FinderTimelineLbsMixPresenter", "[onActionbarClick] position=" + i + " isDouble=" + paramBoolean);
    Object localObject2;
    if (i <= 12)
    {
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
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
      AppMethodBeat.o(202542);
      return;
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      break;
      label287:
      wx(600L);
    }
    label297:
    AppMethodBeat.o(202542);
    return;
    label304:
    localObject1 = FinderReporterUIC.tnG;
    localObject1 = FinderReporterUIC.a.fc((Context)this.activity);
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.report.i.syT;
      com.tencent.mm.plugin.finder.report.i.a(((FinderReporterUIC)localObject1).cQZ(), 1);
      AppMethodBeat.o(202542);
      return;
    }
    AppMethodBeat.o(202542);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(202544);
    Object localObject = this.sgK;
    if (localObject == null) {
      p.bdF("feedLoader");
    }
    ((FinderLbsLoader)localObject).unregister(this.sgS);
    localObject = com.tencent.mm.ui.component.a.KEX;
    ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).GG(1000);
    AppMethodBeat.o(202544);
  }
  
  public final void wx(long paramLong)
  {
    AppMethodBeat.i(202541);
    Object localObject = this.sgL;
    if (localObject == null) {
      p.bdF("viewCallback");
    }
    localObject = ((ad.b)localObject).cDp();
    ((RefreshLoadMoreLayout)localObject).postDelayed((Runnable)new b((RefreshLoadMoreLayout)localObject), paramLong);
    AppMethodBeat.o(202541);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(202512);
      this.sgV.zu(this.sgW);
      AppMethodBeat.o(202512);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(ae paramae, RefreshLoadMoreLayout.c paramc)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class d
    implements h
  {
    d(FinderLbsLoader paramFinderLbsLoader, ae paramae) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(202515);
      com.tencent.mm.sdk.platformtools.ae.i(this.sgZ.getTAG(), "[initData] canTimelineRefresh=" + ae.c(jdField_this) + ", incrementCount=" + paramInt);
      ae localae;
      if (ae.c(jdField_this))
      {
        jdField_this.wx(0L);
        if (paramInt <= 0)
        {
          localae = jdField_this;
          if (!ae.c(jdField_this)) {
            break label260;
          }
        }
      }
      label260:
      for (Object localObject = new RefreshLoadMoreLayout.c(0);; localObject = null)
      {
        ae.a(localae, (RefreshLoadMoreLayout.c)localObject);
        AppMethodBeat.o(202515);
        return;
        localObject = ae.d(jdField_this).GH(1000);
        final int i = ((FinderHomeTabStateVM.a)localObject).tkC;
        final int j = ((FinderHomeTabStateVM.a)localObject).tkD;
        com.tencent.mm.sdk.platformtools.ae.i(this.sgZ.getTAG(), "[initData] canTimelineRefresh " + ae.c(jdField_this) + " lastPos=" + i + " fromTopPixel=" + j);
        localObject = jdField_this.cDr().getRecyclerView().getLayoutManager();
        ae.a(jdField_this, j);
        if (!(localObject instanceof StaggeredGridLayoutManager)) {
          break;
        }
        ((StaggeredGridLayoutManager)localObject).ag(i, j);
        jdField_this.cDr().getRecyclerView().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(202514);
            ((StaggeredGridLayoutManager)this.sha).ag(i, j);
            AppMethodBeat.o(202514);
          }
        });
        break;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$1$2"})
  static final class e
    extends q
    implements d.g.a.b<IResponse<com.tencent.mm.plugin.finder.model.c>, z>
  {
    e(ae paramae)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202517);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt1);
      localb.mu(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
      p.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = this.sgX;
      ae.a(paramRecyclerView, ae.e(paramRecyclerView) - paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(202517);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(202518);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
      super.b(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(202518);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<z>
  {
    g(ae paramae)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(ae paramae)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements d.g.a.a<z>
  {
    i(ae paramae)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class k
    implements com.tencent.mm.view.d
  {
    private WxRecyclerAdapter<?> getAdapter()
    {
      AppMethodBeat.i(202527);
      Object localObject = this.sgX.cDr().getRecyclerView().getAdapter();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
        AppMethodBeat.o(202527);
        throw ((Throwable)localObject);
      }
      localObject = (WxRecyclerAdapter)localObject;
      AppMethodBeat.o(202527);
      return localObject;
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202530);
      Object localObject = this.sgX.cDr();
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
            AppMethodBeat.o(202530);
            return;
          }
        }
      }
      AppMethodBeat.o(202530);
    }
    
    public final void av(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202531);
      Object localObject = this.sgX.cDr();
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
            AppMethodBeat.o(202531);
            return;
          }
        }
      }
      AppMethodBeat.o(202531);
    }
    
    public final void c(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202532);
      p.h(paramc, "reason");
      this.sgX.cDr().cDp().c(paramc);
      AppMethodBeat.o(202532);
    }
    
    public final void d(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202533);
      p.h(paramc, "reason");
      this.sgX.cDr().cDp().d(paramc);
      AppMethodBeat.o(202533);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(202529);
      Object localObject = this.sgX.cDr();
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
            AppMethodBeat.o(202529);
            return;
          }
        }
      }
      AppMethodBeat.o(202529);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(202528);
      Object localObject = this.sgX.cDr();
      if (localObject != null)
      {
        localObject = ((ad.b)localObject).cDp();
        if (localObject != null) {
          ((RefreshLoadMoreLayout)localObject).onChanged();
        }
      }
      ae.a(this.sgX);
      AppMethodBeat.o(202528);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ae
 * JD-Core Version:    0.7.0.1
 */