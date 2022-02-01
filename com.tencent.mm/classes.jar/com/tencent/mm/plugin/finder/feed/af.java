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
import com.tencent.mm.plugin.finder.feed.model.internal.b.a;
import com.tencent.mm.plugin.finder.feed.model.s;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.k;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", "canTimelineRefresh", "", "emptyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "isEmptyLocation", "isRequestingLbs", "()Z", "setRequestingLbs", "(Z)V", "msgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "checkEmptyHeader", "r", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "findFirstPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "notifyChanged", "rv", "itemId", "onActionbarClick", "isDouble", "onAttach", "callback", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "onUserVisibleFocused", "refreshMsgNotify", "Companion", "plugin-finder_release"})
public final class af
  implements ac.a<BaseFinderFeed>
{
  public static final a KOw;
  public ac.b<BaseFinderFeed> KNZ;
  public final FinderHomeTabStateVM KOa;
  public int KOb;
  boolean KOc;
  public boolean KOd;
  private com.tencent.mm.plugin.finder.model.c KOe;
  private com.tencent.mm.view.d KOf;
  private final FinderHomeTabFragment KOg;
  public final MMActivity activity;
  public final com.tencent.mm.plugin.finder.feed.model.h qrj;
  private final boolean qwK;
  private final com.tencent.mm.plugin.finder.model.d qwP;
  
  static
  {
    AppMethodBeat.i(197991);
    KOw = new a((byte)0);
    AppMethodBeat.o(197991);
  }
  
  public af(MMActivity paramMMActivity, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(197990);
    this.activity = paramMMActivity;
    this.KOg = paramFinderHomeTabFragment;
    paramMMActivity = com.tencent.mm.ui.component.a.LCX;
    paramMMActivity = com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderHomeTabStateVM.class);
    k.g(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.KOa = ((FinderHomeTabStateVM)paramMMActivity);
    this.qwK = this.KOa.ahN(2);
    paramMMActivity = com.tencent.mm.plugin.finder.feed.model.internal.b.KQP;
    paramMMActivity = b.a.ahj(2);
    if (this.qwK) {}
    for (int i = 0;; i = 1)
    {
      paramFinderHomeTabFragment = com.tencent.mm.ui.component.a.LCX;
      this.qrj = new com.tencent.mm.plugin.finder.feed.model.h(paramMMActivity, i, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.activity).get(FinderReporterUIC.class)).fXs());
      this.KOf = ((com.tencent.mm.view.d)new k(this));
      this.KOe = new com.tencent.mm.plugin.finder.model.c();
      this.qwP = new com.tencent.mm.plugin.finder.model.d();
      AppMethodBeat.o(197990);
      return;
    }
  }
  
  private final void e(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(197985);
    com.tencent.mm.ad.c.g((d.g.a.a)new c(this, paramc));
    AppMethodBeat.o(197985);
  }
  
  public static int x(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(197988);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    int i;
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      int[] arrayOfInt = new int[2];
      ((StaggeredGridLayoutManager)paramRecyclerView).x(arrayOfInt);
      i = arrayOfInt[1];
      AppMethodBeat.o(197988);
      return i;
    }
    if ((paramRecyclerView instanceof LinearLayoutManager))
    {
      i = ((LinearLayoutManager)paramRecyclerView).jO();
      AppMethodBeat.o(197988);
      return i;
    }
    AppMethodBeat.o(197988);
    return 0;
  }
  
  public final void BH(long paramLong)
  {
    AppMethodBeat.i(197986);
    Object localObject = this.KNZ;
    if (localObject == null) {
      k.aPZ("viewCallback");
    }
    localObject = ((ac.b)localObject).cmp();
    ((RefreshLoadMoreLayout)localObject).postDelayed((Runnable)new b((RefreshLoadMoreLayout)localObject), paramLong);
    AppMethodBeat.o(197986);
  }
  
  public final void Wc()
  {
    AppMethodBeat.i(197982);
    this.qrj.requestLoadMore();
    AppMethodBeat.o(197982);
  }
  
  public final void a(ac.b<BaseFinderFeed> paramb)
  {
    AppMethodBeat.i(197983);
    k.h(paramb, "callback");
    this.KNZ = paramb;
    paramb = this.KNZ;
    if (paramb == null) {
      k.aPZ("viewCallback");
    }
    paramb.N((ArrayList)this.qrj.getDataListJustForAdapter());
    this.qrj.register(this.KOf, this.activity);
    paramb = p.LaH;
    if (p.fVQ())
    {
      final int i = this.KOa.ahO(2).Lhe.size();
      this.qrj.initData((com.tencent.mm.plugin.finder.feed.model.internal.h)new s(i, false, (com.tencent.mm.plugin.finder.feed.model.internal.g)new d(this, i)), true);
      paramb = this.KNZ;
      if (paramb == null) {
        k.aPZ("viewCallback");
      }
      paramb.getRecyclerView().a((RecyclerView.m)new e(this));
      AppMethodBeat.o(197983);
      return;
    }
    paramb = new RefreshLoadMoreLayout.c(0);
    paramb.HXo = -2;
    e(paramb);
    AppMethodBeat.o(197983);
  }
  
  public final void b(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(197981);
    k.h(paramc, "reason");
    if (paramc.HXr <= 0)
    {
      Object localObject = this.KNZ;
      if (localObject == null) {
        k.aPZ("viewCallback");
      }
      localObject = ((ac.b)localObject).cmp();
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      ((RefreshLoadMoreLayout)localObject).b(com.tencent.mm.plugin.finder.storage.b.fUv(), (d.g.a.a)i.KOC);
    }
    e(paramc);
    paramc = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    k.g(paramc, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramc).getRedDotManager().ahg(1003);
    AppMethodBeat.o(197981);
  }
  
  public final void cgG()
  {
    AppMethodBeat.i(197980);
    p localp = p.LaH;
    p.a((d.g.a.a)new f(this), (d.g.a.a)new g(this), (d.g.a.a)new h(this));
    AppMethodBeat.o(197980);
  }
  
  public final ac.b<BaseFinderFeed> fTq()
  {
    AppMethodBeat.i(197979);
    ac.b localb = this.KNZ;
    if (localb == null) {
      k.aPZ("viewCallback");
    }
    AppMethodBeat.o(197979);
    return localb;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(197989);
    com.tencent.mm.plugin.finder.feed.model.h localh = this.qrj;
    ac.b localb = this.KNZ;
    if (localb == null) {
      k.aPZ("viewCallback");
    }
    localh.unregister((com.tencent.mm.view.d)localb.cmp(), this.activity);
    AppMethodBeat.o(197989);
  }
  
  public final void yB(boolean paramBoolean)
  {
    AppMethodBeat.i(197987);
    Object localObject1 = this.KNZ;
    if (localObject1 == null) {
      k.aPZ("viewCallback");
    }
    localObject1 = ((ac.b)localObject1).getRecyclerView();
    int i = x((RecyclerView)localObject1);
    ad.i("Finder.TimelineLbsPresenter", "[onActionbarClick] position=" + i + " isDouble=" + paramBoolean);
    Object localObject2;
    if (i <= 12)
    {
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      if (!paramBoolean) {
        break label304;
      }
      if (i > 12) {
        break label287;
      }
      BH(20L);
    }
    for (;;)
    {
      localObject1 = FinderReporterUIC.Ljl;
      localObject1 = FinderReporterUIC.a.lB((Context)this.activity);
      if (localObject1 == null) {
        break label297;
      }
      localObject2 = com.tencent.mm.plugin.finder.report.b.qFq;
      com.tencent.mm.plugin.finder.report.b.a(((FinderReporterUIC)localObject1).fXs(), 5);
      AppMethodBeat.o(197987);
      return;
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      break;
      label287:
      BH(600L);
    }
    label297:
    AppMethodBeat.o(197987);
    return;
    label304:
    localObject1 = FinderReporterUIC.Ljl;
    localObject1 = FinderReporterUIC.a.lB((Context)this.activity);
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.report.b.qFq;
      com.tencent.mm.plugin.finder.report.b.a(((FinderReporterUIC)localObject1).fXs(), 1);
      AppMethodBeat.o(197987);
      return;
    }
    AppMethodBeat.o(197987);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(197956);
      this.KOi.xk(this.qxv);
      AppMethodBeat.o(197956);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(af paramaf, RefreshLoadMoreLayout.c paramc)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.plugin.finder.feed.model.internal.g
  {
    d(int paramInt) {}
    
    public final void call(final int paramInt)
    {
      AppMethodBeat.i(197959);
      ad.i("Finder.TimelineLbsPresenter", "[initData] canTimelineRefresh=" + af.b(this.KOx) + ", incrementCount=" + paramInt);
      if (af.b(this.KOx))
      {
        this.KOx.BH(0L);
        AppMethodBeat.o(197959);
        return;
      }
      Object localObject = af.c(this.KOx).ahO(2);
      paramInt = ((FinderHomeTabStateVM.a)localObject).Lhf;
      final int i = ((FinderHomeTabStateVM.a)localObject).Lhg;
      ad.i("Finder.TimelineLbsPresenter", "[initData] canTimelineRefresh " + af.b(this.KOx) + " lastPos=" + paramInt + " fromTopPixel=" + i + " initCount=" + i);
      localObject = this.KOx.fTq().getRecyclerView().getLayoutManager();
      af.a(this.KOx, i);
      if ((localObject instanceof StaggeredGridLayoutManager))
      {
        ((StaggeredGridLayoutManager)localObject).af(paramInt, i);
        this.KOx.fTq().getRecyclerView().post((Runnable)new a((RecyclerView.i)localObject, paramInt, i));
      }
      AppMethodBeat.o(197959);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(RecyclerView.i parami, int paramInt1, int paramInt2) {}
      
      public final void run()
      {
        AppMethodBeat.i(197958);
        ((StaggeredGridLayoutManager)this.KOl).af(paramInt, i);
        AppMethodBeat.o(197958);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$2", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class e
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(197960);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt1);
      localb.lT(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
      k.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = this.KOx;
      af.a(paramRecyclerView, af.d(paramRecyclerView) - paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(197960);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(197961);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
      super.b(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(197961);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(af paramaf)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    g(af paramaf)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    h(af paramaf)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final i KOC;
    
    static
    {
      AppMethodBeat.i(197969);
      KOC = new i();
      AppMethodBeat.o(197969);
    }
    
    i()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class j
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public j(af paramaf)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class k
    implements com.tencent.mm.view.d
  {
    private WxRecyclerAdapter<?> getAdapter()
    {
      AppMethodBeat.i(197972);
      Object localObject = this.KOx.fTq().getRecyclerView().getAdapter();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
        AppMethodBeat.o(197972);
        throw ((Throwable)localObject);
      }
      localObject = (WxRecyclerAdapter)localObject;
      AppMethodBeat.o(197972);
      return localObject;
    }
    
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(197975);
      Object localObject = this.KOx.fTq();
      if (localObject != null)
      {
        localObject = ((ac.b)localObject).cmp();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.Ibl.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).at(i + paramInt1, paramInt2);
            AppMethodBeat.o(197975);
            return;
          }
        }
      }
      AppMethodBeat.o(197975);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(197976);
      Object localObject = this.KOx.fTq();
      if (localObject != null)
      {
        localObject = ((ac.b)localObject).cmp();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.Ibl.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).au(i + paramInt1, paramInt2);
            AppMethodBeat.o(197976);
            return;
          }
        }
      }
      AppMethodBeat.o(197976);
    }
    
    public final void c(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(197978);
      k.h(paramc, "reason");
      this.KOx.fTq().cmp().c(paramc);
      AppMethodBeat.o(197978);
    }
    
    public final void d(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(197977);
      k.h(paramc, "reason");
      this.KOx.fTq().cmp().d(paramc);
      AppMethodBeat.o(197977);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(197974);
      Object localObject = this.KOx.fTq();
      if (localObject != null)
      {
        localObject = ((ac.b)localObject).cmp();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.Ibl.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).f(i + paramInt1, paramInt2, paramObject);
            AppMethodBeat.o(197974);
            return;
          }
        }
      }
      AppMethodBeat.o(197974);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(197973);
      Object localObject = this.KOx.fTq();
      if (localObject != null)
      {
        localObject = ((ac.b)localObject).cmp();
        if (localObject != null)
        {
          ((RefreshLoadMoreLayout)localObject).onChanged();
          AppMethodBeat.o(197973);
          return;
        }
      }
      AppMethodBeat.o(197973);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.af
 * JD-Core Version:    0.7.0.1
 */