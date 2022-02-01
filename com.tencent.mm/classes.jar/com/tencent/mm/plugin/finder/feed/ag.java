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
import com.tencent.mm.plugin.finder.model.al;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", "canTimelineRefresh", "", "emptyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "isEmptyLocation", "isRequestingLbs", "()Z", "setRequestingLbs", "(Z)V", "msgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "checkEmptyHeader", "r", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "findFirstPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "notifyChanged", "rv", "itemId", "onActionbarClick", "isDouble", "onAttach", "callback", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "onUserVisibleFocused", "refreshMsgNotify", "refreshRV", "data", "Landroid/content/Intent;", "Companion", "plugin-finder_release"})
public final class ag
  implements ad.a<al>
{
  public static final b rYE;
  public final MMActivity activity;
  public ad.b<al> rXZ;
  public final FinderTimelineFeedLoader rYC;
  private final com.tencent.mm.plugin.finder.model.g rYD;
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
    AppMethodBeat.i(202139);
    rYE = new b((byte)0);
    AppMethodBeat.o(202139);
  }
  
  public ag(MMActivity paramMMActivity, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(202138);
    this.activity = paramMMActivity;
    this.rYh = paramFinderHomeTabFragment;
    paramMMActivity = com.tencent.mm.ui.component.a.KiD;
    paramMMActivity = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    p.g(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.rYa = ((FinderHomeTabStateVM)paramMMActivity);
    this.rYb = this.rYa.Gg(2);
    paramMMActivity = com.tencent.mm.plugin.finder.feed.model.internal.e.scW;
    paramMMActivity = e.a.ED(2);
    if (this.rYb) {}
    for (int i = 0;; i = 1)
    {
      paramFinderHomeTabFragment = com.tencent.mm.ui.component.a.KiD;
      paramMMActivity = new FinderTimelineFeedLoader(paramMMActivity, i, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.activity).get(FinderReporterUIC.class)).cOu());
      paramMMActivity.setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.h)new a(paramMMActivity, this));
      this.rYC = paramMMActivity;
      this.rYg = ((com.tencent.mm.view.d)new k(this));
      this.rYf = new f();
      this.rYD = new com.tencent.mm.plugin.finder.model.g();
      AppMethodBeat.o(202138);
      return;
    }
  }
  
  private final void g(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202133);
    com.tencent.mm.ad.c.g((d.g.a.a)new d(this, paramc));
    AppMethodBeat.o(202133);
  }
  
  public static int u(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(202136);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    int i;
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      int[] arrayOfInt = new int[2];
      ((StaggeredGridLayoutManager)paramRecyclerView).n(arrayOfInt);
      i = arrayOfInt[1];
      AppMethodBeat.o(202136);
      return i;
    }
    if ((paramRecyclerView instanceof LinearLayoutManager))
    {
      i = ((LinearLayoutManager)paramRecyclerView).km();
      AppMethodBeat.o(202136);
      return i;
    }
    AppMethodBeat.o(202136);
    return 0;
  }
  
  public final void Zt()
  {
    AppMethodBeat.i(202130);
    this.rYC.requestLoadMore();
    AppMethodBeat.o(202130);
  }
  
  public final void a(ad.b<al> paramb)
  {
    AppMethodBeat.i(202131);
    p.h(paramb, "callback");
    this.rXZ = paramb;
    paramb = this.rXZ;
    if (paramb == null) {
      p.bcb("viewCallback");
    }
    paramb.U((ArrayList)this.rYC.getDataListJustForAdapter());
    this.rYC.register(this.rYg);
    paramb = i.sLn;
    if (i.cLj())
    {
      this.rYa.Gi(2).sZm.size();
      BaseFeedLoader.requestInit$default(this.rYC, false, 1, null);
      paramb = this.rXZ;
      if (paramb == null) {
        p.bcb("viewCallback");
      }
      paramb.getRecyclerView().a((RecyclerView.m)new e(this));
      AppMethodBeat.o(202131);
      return;
    }
    paramb = new RefreshLoadMoreLayout.c(0);
    paramb.Lrg = -2;
    g(paramb);
    AppMethodBeat.o(202131);
  }
  
  public final void b(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202129);
    p.h(paramc, "reason");
    if (paramc.Lrj <= 0)
    {
      Object localObject = this.rXZ;
      if (localObject == null) {
        p.bcb("viewCallback");
      }
      localObject = ((ad.b)localObject).cBD();
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
      ((RefreshLoadMoreLayout)localObject).b(com.tencent.mm.plugin.finder.storage.b.cGv(), (d.g.a.a)ag.i.rYN);
    }
    g(paramc);
    paramc = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    p.g(paramc, "MMKernel.plugin(PluginFinder::class.java)");
    com.tencent.mm.plugin.finder.extension.reddot.e.a(((PluginFinder)paramc).getRedDotManager(), 1003);
    AppMethodBeat.o(202129);
  }
  
  public final ad.b<al> cBF()
  {
    AppMethodBeat.i(202127);
    ad.b localb = this.rXZ;
    if (localb == null) {
      p.bcb("viewCallback");
    }
    AppMethodBeat.o(202127);
    return localb;
  }
  
  public final void ctS()
  {
    AppMethodBeat.i(202128);
    i locali = i.sLn;
    i.a((d.g.a.a)new f(this), (d.g.a.a)new g(this), (d.g.a.a)new h(this));
    AppMethodBeat.o(202128);
  }
  
  public final void lT(boolean paramBoolean)
  {
    AppMethodBeat.i(202135);
    Object localObject1 = this.rXZ;
    if (localObject1 == null) {
      p.bcb("viewCallback");
    }
    localObject1 = ((ad.b)localObject1).getRecyclerView();
    int i = u((RecyclerView)localObject1);
    ad.i("Finder.TimelineLbsPresenter", "[onActionbarClick] position=" + i + " isDouble=" + paramBoolean);
    Object localObject2;
    if (i <= 12)
    {
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
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
      AppMethodBeat.o(202135);
      return;
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      break;
      label287:
      wh(600L);
    }
    label297:
    AppMethodBeat.o(202135);
    return;
    label304:
    localObject1 = FinderReporterUIC.tcM;
    localObject1 = FinderReporterUIC.a.eY((Context)this.activity);
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.report.h.soM;
      com.tencent.mm.plugin.finder.report.h.a(((FinderReporterUIC)localObject1).cOu(), 1);
      AppMethodBeat.o(202135);
      return;
    }
    AppMethodBeat.o(202135);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(202137);
    this.rYC.unregister(this.rYg);
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KiD;
    ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Gh(2);
    AppMethodBeat.o(202137);
  }
  
  public final void wh(long paramLong)
  {
    AppMethodBeat.i(202134);
    Object localObject = this.rXZ;
    if (localObject == null) {
      p.bcb("viewCallback");
    }
    localObject = ((ad.b)localObject).cBD();
    ((RefreshLoadMoreLayout)localObject).postDelayed((Runnable)new c((RefreshLoadMoreLayout)localObject), paramLong);
    AppMethodBeat.o(202134);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$feedLoader$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.plugin.finder.feed.model.internal.h
  {
    a(FinderTimelineFeedLoader paramFinderTimelineFeedLoader, ag paramag) {}
    
    public final void call(final int paramInt)
    {
      AppMethodBeat.i(202101);
      ad.i(this.rYF.getTAG(), "[initData] canTimelineRefresh=" + ag.f(jdField_this) + ", incrementCount=" + paramInt);
      if (ag.f(jdField_this))
      {
        jdField_this.wh(0L);
        jdField_this.cBF().cBD().post((Runnable)ah.rYH);
      }
      for (;;)
      {
        jdField_this.cBF().cBD().post((Runnable)ai.rYI);
        AppMethodBeat.o(202101);
        return;
        Object localObject = ag.g(jdField_this).Gi(2);
        paramInt = ((FinderHomeTabStateVM.a)localObject).sZo;
        final int i = ((FinderHomeTabStateVM.a)localObject).sZp;
        ad.i(this.rYF.getTAG(), "[initData] canTimelineRefresh " + ag.f(jdField_this) + " lastPos=" + paramInt + " fromTopPixel=" + i);
        localObject = jdField_this.cBF().getRecyclerView().getLayoutManager();
        ag.a(jdField_this, i);
        if ((localObject instanceof StaggeredGridLayoutManager))
        {
          ((StaggeredGridLayoutManager)localObject).ag(paramInt, i);
          jdField_this.cBF().getRecyclerView().post((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(202100);
              ((StaggeredGridLayoutManager)this.rYo).ag(paramInt, i);
              AppMethodBeat.o(202100);
            }
          });
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(202102);
      this.rYj.zg(this.rYk);
      AppMethodBeat.o(202102);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(ag paramag, RefreshLoadMoreLayout.c paramc)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class e
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202108);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt1);
      localb.mr(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
      p.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = this.rYG;
      ag.a(paramRecyclerView, ag.b(paramRecyclerView) - paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(202108);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(202109);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
      super.b(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(202109);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(ag paramag)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<z>
  {
    g(ag paramag)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(ag paramag)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class j
    extends q
    implements d.g.a.a<z>
  {
    public j(ag paramag)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class k
    implements com.tencent.mm.view.d
  {
    private WxRecyclerAdapter<?> getAdapter()
    {
      AppMethodBeat.i(202120);
      Object localObject = this.rYG.cBF().getRecyclerView().getAdapter();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
        AppMethodBeat.o(202120);
        throw ((Throwable)localObject);
      }
      localObject = (WxRecyclerAdapter)localObject;
      AppMethodBeat.o(202120);
      return localObject;
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202123);
      Object localObject = this.rYG.cBF();
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
            AppMethodBeat.o(202123);
            return;
          }
        }
      }
      AppMethodBeat.o(202123);
    }
    
    public final void av(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202124);
      Object localObject = this.rYG.cBF();
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
            AppMethodBeat.o(202124);
            return;
          }
        }
      }
      AppMethodBeat.o(202124);
    }
    
    public final void c(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202125);
      p.h(paramc, "reason");
      this.rYG.cBF().cBD().c(paramc);
      AppMethodBeat.o(202125);
    }
    
    public final void d(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202126);
      p.h(paramc, "reason");
      this.rYG.cBF().cBD().d(paramc);
      AppMethodBeat.o(202126);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(202122);
      Object localObject = this.rYG.cBF();
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
            AppMethodBeat.o(202122);
            return;
          }
        }
      }
      AppMethodBeat.o(202122);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(202121);
      Object localObject = this.rYG.cBF();
      if (localObject != null)
      {
        localObject = ((ad.b)localObject).cBD();
        if (localObject != null)
        {
          ((RefreshLoadMoreLayout)localObject).onChanged();
          AppMethodBeat.o(202121);
          return;
        }
      }
      AppMethodBeat.o(202121);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ag
 * JD-Core Version:    0.7.0.1
 */