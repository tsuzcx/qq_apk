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
import com.tencent.mm.plugin.finder.model.f;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.ad;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", "canTimelineRefresh", "", "emptyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;)V", "isEmptyLocation", "isRequestingLbs", "()Z", "setRequestingLbs", "(Z)V", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "checkEmptyHeader", "r", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "findFirstPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "onActionbarClick", "isDouble", "onAttach", "callback", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "onUserVisibleFocused", "Companion", "plugin-finder_release"})
public final class ae
  implements ad.a<com.tencent.mm.plugin.finder.model.c>
{
  public static final a rYi;
  public final MMActivity activity;
  public FinderLbsLoader rXY;
  public ad.b<com.tencent.mm.plugin.finder.model.c> rXZ;
  public final FinderHomeTabStateVM rYa;
  private final boolean rYb;
  public int rYc;
  boolean rYd;
  public boolean rYe;
  private f rYf;
  private com.tencent.mm.view.d rYg;
  private final FinderHomeTabFragment rYh;
  
  static
  {
    AppMethodBeat.i(202084);
    rYi = new a((byte)0);
    AppMethodBeat.o(202084);
  }
  
  public ae(MMActivity paramMMActivity, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(202083);
    this.activity = paramMMActivity;
    this.rYh = paramFinderHomeTabFragment;
    paramMMActivity = com.tencent.mm.ui.component.a.KiD;
    paramMMActivity = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    p.g(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.rYa = ((FinderHomeTabStateVM)paramMMActivity);
    this.rYb = this.rYa.Gg(1000);
    this.rYf = new f();
    this.rYg = ((com.tencent.mm.view.d)new k(this));
    AppMethodBeat.o(202083);
  }
  
  private final void g(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202081);
    com.tencent.mm.ad.c.g((d.g.a.a)new c(this, paramc));
    AppMethodBeat.o(202081);
  }
  
  public static int u(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(202079);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    int i;
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      int[] arrayOfInt = new int[2];
      ((StaggeredGridLayoutManager)paramRecyclerView).n(arrayOfInt);
      i = arrayOfInt[1];
      AppMethodBeat.o(202079);
      return i;
    }
    if ((paramRecyclerView instanceof LinearLayoutManager))
    {
      i = ((LinearLayoutManager)paramRecyclerView).km();
      AppMethodBeat.o(202079);
      return i;
    }
    AppMethodBeat.o(202079);
    return 0;
  }
  
  public final void Zt()
  {
    AppMethodBeat.i(202074);
    FinderLbsLoader localFinderLbsLoader = this.rXY;
    if (localFinderLbsLoader == null) {
      p.bcb("feedLoader");
    }
    localFinderLbsLoader.requestLoadMore();
    AppMethodBeat.o(202074);
  }
  
  public final void a(ad.b<com.tencent.mm.plugin.finder.model.c> paramb)
  {
    AppMethodBeat.i(202075);
    p.h(paramb, "callback");
    this.rXZ = paramb;
    paramb = com.tencent.mm.ui.component.a.KiD;
    paramb = new FinderLbsLoader(((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.activity).get(FinderReporterUIC.class)).cOu());
    paramb.setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.h)new d(paramb, this));
    paramb.fetchEndCallback = ((d.g.a.b)new e(this));
    this.rXY = paramb;
    paramb = this.rXZ;
    if (paramb == null) {
      p.bcb("viewCallback");
    }
    FinderLbsLoader localFinderLbsLoader = this.rXY;
    if (localFinderLbsLoader == null) {
      p.bcb("feedLoader");
    }
    paramb.U((ArrayList)localFinderLbsLoader.getDataListJustForAdapter());
    paramb = this.rXY;
    if (paramb == null) {
      p.bcb("feedLoader");
    }
    paramb.register(this.rYg);
    paramb = i.sLn;
    if (i.cLj())
    {
      this.rYa.Gi(1000).sZn.size();
      paramb = this.rXY;
      if (paramb == null) {
        p.bcb("feedLoader");
      }
      paramb.requestInit(false);
      paramb = this.rXZ;
      if (paramb == null) {
        p.bcb("viewCallback");
      }
      paramb.getRecyclerView().a((RecyclerView.m)new f(this));
      AppMethodBeat.o(202075);
      return;
    }
    paramb = new RefreshLoadMoreLayout.c(0);
    paramb.Lrg = -2;
    g(paramb);
    AppMethodBeat.o(202075);
  }
  
  public final void b(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202073);
    p.h(paramc, "reason");
    Object localObject;
    if (paramc.Lrj <= 0)
    {
      localObject = this.rXZ;
      if (localObject == null) {
        p.bcb("viewCallback");
      }
      localObject = ((ad.b)localObject).cBD();
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
      ((RefreshLoadMoreLayout)localObject).b(com.tencent.mm.plugin.finder.storage.b.cGv(), (d.g.a.a)ae.j.rYw);
    }
    if (paramc.Lri)
    {
      localObject = this.rXZ;
      if (localObject == null) {
        p.bcb("viewCallback");
      }
      if (!((ad.b)localObject).cBD().LqV)
      {
        localObject = this.rXZ;
        if (localObject == null) {
          p.bcb("viewCallback");
        }
        ((ad.b)localObject).cBD().setHasBottomMore(true);
      }
    }
    g(paramc);
    AppMethodBeat.o(202073);
  }
  
  public final FinderLbsLoader cBE()
  {
    AppMethodBeat.i(202070);
    FinderLbsLoader localFinderLbsLoader = this.rXY;
    if (localFinderLbsLoader == null) {
      p.bcb("feedLoader");
    }
    AppMethodBeat.o(202070);
    return localFinderLbsLoader;
  }
  
  public final ad.b<com.tencent.mm.plugin.finder.model.c> cBF()
  {
    AppMethodBeat.i(202071);
    ad.b localb = this.rXZ;
    if (localb == null) {
      p.bcb("viewCallback");
    }
    AppMethodBeat.o(202071);
    return localb;
  }
  
  public final void ctS()
  {
    AppMethodBeat.i(202072);
    i locali = i.sLn;
    i.a((d.g.a.a)new g(this), (d.g.a.a)new h(this), (d.g.a.a)new i(this));
    AppMethodBeat.o(202072);
  }
  
  public final void lT(boolean paramBoolean)
  {
    AppMethodBeat.i(202078);
    Object localObject1 = this.rXZ;
    if (localObject1 == null) {
      p.bcb("viewCallback");
    }
    localObject1 = ((ad.b)localObject1).getRecyclerView();
    int i = u((RecyclerView)localObject1);
    ad.i("Finder.FinderTimelineLbsMixPresenter", "[onActionbarClick] position=" + i + " isDouble=" + paramBoolean);
    Object localObject2;
    if (i <= 12)
    {
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      if (!paramBoolean) {
        break label304;
      }
      if (i > 12) {
        break label287;
      }
      wh(20L);
    }
    for (;;)
    {
      localObject1 = FinderReporterUIC.tcM;
      localObject1 = FinderReporterUIC.a.eY((Context)this.activity);
      if (localObject1 == null) {
        break label297;
      }
      localObject2 = com.tencent.mm.plugin.finder.report.h.soM;
      com.tencent.mm.plugin.finder.report.h.a(((FinderReporterUIC)localObject1).cOu(), 5);
      AppMethodBeat.o(202078);
      return;
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      break;
      label287:
      wh(600L);
    }
    label297:
    AppMethodBeat.o(202078);
    return;
    label304:
    localObject1 = FinderReporterUIC.tcM;
    localObject1 = FinderReporterUIC.a.eY((Context)this.activity);
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.report.h.soM;
      com.tencent.mm.plugin.finder.report.h.a(((FinderReporterUIC)localObject1).cOu(), 1);
      AppMethodBeat.o(202078);
      return;
    }
    AppMethodBeat.o(202078);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(202080);
    Object localObject = this.rXY;
    if (localObject == null) {
      p.bcb("feedLoader");
    }
    ((FinderLbsLoader)localObject).unregister(this.rYg);
    localObject = com.tencent.mm.ui.component.a.KiD;
    ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Gh(1000);
    AppMethodBeat.o(202080);
  }
  
  public final void wh(long paramLong)
  {
    AppMethodBeat.i(202077);
    Object localObject = this.rXZ;
    if (localObject == null) {
      p.bcb("viewCallback");
    }
    localObject = ((ad.b)localObject).cBD();
    ((RefreshLoadMoreLayout)localObject).postDelayed((Runnable)new b((RefreshLoadMoreLayout)localObject), paramLong);
    AppMethodBeat.o(202077);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(202048);
      this.rYj.zg(this.rYk);
      AppMethodBeat.o(202048);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(ae paramae, RefreshLoadMoreLayout.c paramc)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.plugin.finder.feed.model.internal.h
  {
    d(FinderLbsLoader paramFinderLbsLoader, ae paramae) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(202051);
      ad.i(this.rYn.getTAG(), "[initData] canTimelineRefresh=" + ae.c(jdField_this) + ", incrementCount=" + paramInt);
      ae localae;
      if (ae.c(jdField_this))
      {
        jdField_this.wh(0L);
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
        AppMethodBeat.o(202051);
        return;
        localObject = ae.d(jdField_this).Gi(1000);
        final int i = ((FinderHomeTabStateVM.a)localObject).sZo;
        final int j = ((FinderHomeTabStateVM.a)localObject).sZp;
        ad.i(this.rYn.getTAG(), "[initData] canTimelineRefresh " + ae.c(jdField_this) + " lastPos=" + i + " fromTopPixel=" + j);
        localObject = jdField_this.cBF().getRecyclerView().getLayoutManager();
        ae.a(jdField_this, j);
        if (!(localObject instanceof StaggeredGridLayoutManager)) {
          break;
        }
        ((StaggeredGridLayoutManager)localObject).ag(i, j);
        jdField_this.cBF().getRecyclerView().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(202050);
            ((StaggeredGridLayoutManager)this.rYo).ag(i, j);
            AppMethodBeat.o(202050);
          }
        });
        break;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$1$2"})
  static final class e
    extends q
    implements d.g.a.b<IResponse<com.tencent.mm.plugin.finder.model.c>, z>
  {
    e(ae paramae)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202053);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt1);
      localb.mr(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
      p.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = this.rYl;
      ae.a(paramRecyclerView, ae.e(paramRecyclerView) - paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(202053);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(202054);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
      super.b(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(202054);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<z>
  {
    g(ae paramae)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(ae paramae)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements d.g.a.a<z>
  {
    i(ae paramae)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class k
    implements com.tencent.mm.view.d
  {
    private WxRecyclerAdapter<?> getAdapter()
    {
      AppMethodBeat.i(202063);
      Object localObject = this.rYl.cBF().getRecyclerView().getAdapter();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
        AppMethodBeat.o(202063);
        throw ((Throwable)localObject);
      }
      localObject = (WxRecyclerAdapter)localObject;
      AppMethodBeat.o(202063);
      return localObject;
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202066);
      Object localObject = this.rYl.cBF();
      if (localObject != null)
      {
        localObject = ((ad.b)localObject).cBD();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.Lvi.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).au(i + paramInt1, paramInt2);
            AppMethodBeat.o(202066);
            return;
          }
        }
      }
      AppMethodBeat.o(202066);
    }
    
    public final void av(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202067);
      Object localObject = this.rYl.cBF();
      if (localObject != null)
      {
        localObject = ((ad.b)localObject).cBD();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.Lvi.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).av(i + paramInt1, paramInt2);
            AppMethodBeat.o(202067);
            return;
          }
        }
      }
      AppMethodBeat.o(202067);
    }
    
    public final void c(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202068);
      p.h(paramc, "reason");
      this.rYl.cBF().cBD().c(paramc);
      AppMethodBeat.o(202068);
    }
    
    public final void d(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202069);
      p.h(paramc, "reason");
      this.rYl.cBF().cBD().d(paramc);
      AppMethodBeat.o(202069);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(202065);
      Object localObject = this.rYl.cBF();
      if (localObject != null)
      {
        localObject = ((ad.b)localObject).cBD();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.Lvi.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).f(i + paramInt1, paramInt2, paramObject);
            AppMethodBeat.o(202065);
            return;
          }
        }
      }
      AppMethodBeat.o(202065);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(202064);
      Object localObject = this.rYl.cBF();
      if (localObject != null)
      {
        localObject = ((ad.b)localObject).cBD();
        if (localObject != null) {
          ((RefreshLoadMoreLayout)localObject).onChanged();
        }
      }
      ae.a(this.rYl);
      AppMethodBeat.o(202064);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ae
 * JD-Core Version:    0.7.0.1
 */