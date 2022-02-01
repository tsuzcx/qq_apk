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
import com.tencent.mm.plugin.finder.feed.model.i;
import com.tencent.mm.plugin.finder.feed.model.i.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.e;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.h;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.k;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", "canTimelineRefresh", "", "emptyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;)V", "isEmptyLocation", "isRequestingLbs", "()Z", "setRequestingLbs", "(Z)V", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "checkEmptyHeader", "r", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "findFirstPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "onActionbarClick", "isDouble", "onAttach", "callback", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "onUserVisibleFocused", "Companion", "plugin-finder_release"})
public final class z
  implements y.a<com.tencent.mm.plugin.finder.model.b>
{
  public static final z.a rjK;
  public final MMActivity activity;
  public i rjA;
  public y.b<com.tencent.mm.plugin.finder.model.b> rjB;
  public final FinderHomeTabStateVM rjC;
  private final boolean rjD;
  public int rjE;
  boolean rjF;
  public boolean rjG;
  private e rjH;
  private com.tencent.mm.view.d rjI;
  private final FinderHomeTabFragment rjJ;
  
  static
  {
    AppMethodBeat.i(201837);
    rjK = new z.a((byte)0);
    AppMethodBeat.o(201837);
  }
  
  public z(MMActivity paramMMActivity, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(201836);
    this.activity = paramMMActivity;
    this.rjJ = paramFinderHomeTabFragment;
    paramMMActivity = com.tencent.mm.ui.component.a.IrY;
    paramMMActivity = com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class);
    k.g(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.rjC = ((FinderHomeTabStateVM)paramMMActivity);
    this.rjD = this.rjC.ES(1000);
    this.rjH = new e();
    this.rjI = ((com.tencent.mm.view.d)new k(this));
    AppMethodBeat.o(201836);
  }
  
  private final void g(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(201834);
    com.tencent.mm.ac.c.g((d.g.a.a)new c(this, paramc));
    AppMethodBeat.o(201834);
  }
  
  public static int u(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(201832);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    int i;
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      int[] arrayOfInt = new int[2];
      ((StaggeredGridLayoutManager)paramRecyclerView).n(arrayOfInt);
      i = arrayOfInt[1];
      AppMethodBeat.o(201832);
      return i;
    }
    if ((paramRecyclerView instanceof LinearLayoutManager))
    {
      i = ((LinearLayoutManager)paramRecyclerView).jW();
      AppMethodBeat.o(201832);
      return i;
    }
    AppMethodBeat.o(201832);
    return 0;
  }
  
  public final void Xa()
  {
    AppMethodBeat.i(201827);
    i locali = this.rjA;
    if (locali == null) {
      k.aVY("feedLoader");
    }
    locali.requestLoadMore();
    AppMethodBeat.o(201827);
  }
  
  public final void a(y.b<com.tencent.mm.plugin.finder.model.b> paramb)
  {
    AppMethodBeat.i(201828);
    k.h(paramb, "callback");
    this.rjB = paramb;
    paramb = com.tencent.mm.ui.component.a.IrY;
    paramb = new i(((FinderReporterUIC)com.tencent.mm.ui.component.a.q(this.activity).get(FinderReporterUIC.class)).cGb());
    paramb.rmE = ((d.g.a.b)new d(this));
    this.rjA = paramb;
    paramb = this.rjB;
    if (paramb == null) {
      k.aVY("viewCallback");
    }
    i locali = this.rjA;
    if (locali == null) {
      k.aVY("feedLoader");
    }
    paramb.U((ArrayList)locali.getDataListJustForAdapter());
    paramb = this.rjA;
    if (paramb == null) {
      k.aVY("feedLoader");
    }
    paramb.register(this.rjI, this.activity);
    paramb = h.rOQ;
    if (h.cCS())
    {
      final int i = this.rjC.EU(1000).sbV.size();
      paramb = this.rjA;
      if (paramb == null) {
        k.aVY("feedLoader");
      }
      paramb.initData((g)new i.a((f)new e(this, i)), false);
      paramb = this.rjB;
      if (paramb == null) {
        k.aVY("viewCallback");
      }
      paramb.getRecyclerView().a((RecyclerView.m)new f(this));
      AppMethodBeat.o(201828);
      return;
    }
    paramb = new RefreshLoadMoreLayout.c(0);
    paramb.JxZ = -2;
    g(paramb);
    AppMethodBeat.o(201828);
  }
  
  public final void b(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(201826);
    k.h(paramc, "reason");
    Object localObject;
    if (paramc.Jyc <= 0)
    {
      localObject = this.rjB;
      if (localObject == null) {
        k.aVY("viewCallback");
      }
      localObject = ((y.b)localObject).cvl();
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      ((RefreshLoadMoreLayout)localObject).b(com.tencent.mm.plugin.finder.storage.b.czS(), (d.g.a.a)z.j.rjY);
    }
    if (paramc.Jyb)
    {
      localObject = this.rjB;
      if (localObject == null) {
        k.aVY("viewCallback");
      }
      if (!((y.b)localObject).cvl().JxN)
      {
        localObject = this.rjB;
        if (localObject == null) {
          k.aVY("viewCallback");
        }
        ((y.b)localObject).cvl().setHasBottomMore(true);
      }
    }
    g(paramc);
    AppMethodBeat.o(201826);
  }
  
  public final void con()
  {
    AppMethodBeat.i(201825);
    h localh = h.rOQ;
    h.a((d.g.a.a)new g(this), (d.g.a.a)new h(this), (d.g.a.a)new i(this));
    AppMethodBeat.o(201825);
  }
  
  public final i cvm()
  {
    AppMethodBeat.i(201823);
    i locali = this.rjA;
    if (locali == null) {
      k.aVY("feedLoader");
    }
    AppMethodBeat.o(201823);
    return locali;
  }
  
  public final y.b<com.tencent.mm.plugin.finder.model.b> cvn()
  {
    AppMethodBeat.i(201824);
    y.b localb = this.rjB;
    if (localb == null) {
      k.aVY("viewCallback");
    }
    AppMethodBeat.o(201824);
    return localb;
  }
  
  public final void ly(boolean paramBoolean)
  {
    AppMethodBeat.i(201831);
    Object localObject1 = this.rjB;
    if (localObject1 == null) {
      k.aVY("viewCallback");
    }
    localObject1 = ((y.b)localObject1).getRecyclerView();
    int i = u((RecyclerView)localObject1);
    ac.i("Finder.FinderTimelineLbsMixPresenter", "[onActionbarClick] position=" + i + " isDouble=" + paramBoolean);
    Object localObject2;
    if (i <= 12)
    {
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      if (!paramBoolean) {
        break label304;
      }
      if (i > 12) {
        break label287;
      }
      uh(20L);
    }
    for (;;)
    {
      localObject1 = FinderReporterUIC.seQ;
      localObject1 = FinderReporterUIC.a.eV((Context)this.activity);
      if (localObject1 == null) {
        break label297;
      }
      localObject2 = com.tencent.mm.plugin.finder.report.d.rxr;
      com.tencent.mm.plugin.finder.report.d.a(((FinderReporterUIC)localObject1).cGb(), 5);
      AppMethodBeat.o(201831);
      return;
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      break;
      label287:
      uh(600L);
    }
    label297:
    AppMethodBeat.o(201831);
    return;
    label304:
    localObject1 = FinderReporterUIC.seQ;
    localObject1 = FinderReporterUIC.a.eV((Context)this.activity);
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.report.d.rxr;
      com.tencent.mm.plugin.finder.report.d.a(((FinderReporterUIC)localObject1).cGb(), 1);
      AppMethodBeat.o(201831);
      return;
    }
    AppMethodBeat.o(201831);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(201833);
    i locali = this.rjA;
    if (locali == null) {
      k.aVY("feedLoader");
    }
    y.b localb = this.rjB;
    if (localb == null) {
      k.aVY("viewCallback");
    }
    locali.unregister((com.tencent.mm.view.d)localb.cvl(), this.activity);
    AppMethodBeat.o(201833);
  }
  
  public final void uh(long paramLong)
  {
    AppMethodBeat.i(201830);
    Object localObject = this.rjB;
    if (localObject == null) {
      k.aVY("viewCallback");
    }
    localObject = ((y.b)localObject).cvl();
    ((RefreshLoadMoreLayout)localObject).postDelayed((Runnable)new b((RefreshLoadMoreLayout)localObject), paramLong);
    AppMethodBeat.o(201830);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(201801);
      this.rjL.yt(this.rjM);
      AppMethodBeat.o(201801);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(z paramz, RefreshLoadMoreLayout.c paramc)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$1$1"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<IResponse<com.tencent.mm.plugin.finder.model.b>, y>
  {
    d(z paramz)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class e
    implements f
  {
    e(int paramInt) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(201805);
      ac.i("Finder.FinderTimelineLbsMixPresenter", "[initData] canTimelineRefresh=" + z.c(this.rjN) + ", incrementCount=" + paramInt);
      z localz;
      if (z.c(this.rjN))
      {
        this.rjN.uh(0L);
        if (paramInt <= 0)
        {
          localz = this.rjN;
          if (!z.c(this.rjN)) {
            break label262;
          }
        }
      }
      label262:
      for (Object localObject = new RefreshLoadMoreLayout.c(0);; localObject = null)
      {
        z.a(localz, (RefreshLoadMoreLayout.c)localObject);
        AppMethodBeat.o(201805);
        return;
        localObject = z.d(this.rjN).EU(1000);
        final int i = ((FinderHomeTabStateVM.a)localObject).sbW;
        final int j = ((FinderHomeTabStateVM.a)localObject).sbX;
        ac.i("Finder.FinderTimelineLbsMixPresenter", "[initData] canTimelineRefresh " + z.c(this.rjN) + " lastPos=" + i + " fromTopPixel=" + j + " initCount=" + i);
        localObject = this.rjN.cvn().getRecyclerView().getLayoutManager();
        z.a(this.rjN, j);
        if (!(localObject instanceof StaggeredGridLayoutManager)) {
          break;
        }
        ((StaggeredGridLayoutManager)localObject).af(i, j);
        this.rjN.cvn().getRecyclerView().post((Runnable)new a((RecyclerView.i)localObject, i, j));
        break;
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(RecyclerView.i parami, int paramInt1, int paramInt2) {}
      
      public final void run()
      {
        AppMethodBeat.i(201804);
        ((StaggeredGridLayoutManager)this.rjQ).af(i, j);
        AppMethodBeat.o(201804);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$3", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201806);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt1);
      localb.lS(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
      k.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = this.rjN;
      z.a(paramRecyclerView, z.e(paramRecyclerView) - paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(201806);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(201807);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
      super.b(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(201807);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    g(z paramz)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    h(z paramz)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    i(z paramz)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class k
    implements com.tencent.mm.view.d
  {
    private WxRecyclerAdapter<?> getAdapter()
    {
      AppMethodBeat.i(201816);
      Object localObject = this.rjN.cvn().getRecyclerView().getAdapter();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
        AppMethodBeat.o(201816);
        throw ((Throwable)localObject);
      }
      localObject = (WxRecyclerAdapter)localObject;
      AppMethodBeat.o(201816);
      return localObject;
    }
    
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201819);
      Object localObject = this.rjN.cvn();
      if (localObject != null)
      {
        localObject = ((y.b)localObject).cvl();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.JCb.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).at(i + paramInt1, paramInt2);
            AppMethodBeat.o(201819);
            return;
          }
        }
      }
      AppMethodBeat.o(201819);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201820);
      Object localObject = this.rjN.cvn();
      if (localObject != null)
      {
        localObject = ((y.b)localObject).cvl();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.JCb.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).au(i + paramInt1, paramInt2);
            AppMethodBeat.o(201820);
            return;
          }
        }
      }
      AppMethodBeat.o(201820);
    }
    
    public final void c(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201821);
      k.h(paramc, "reason");
      this.rjN.cvn().cvl().c(paramc);
      AppMethodBeat.o(201821);
    }
    
    public final void d(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201822);
      k.h(paramc, "reason");
      this.rjN.cvn().cvl().d(paramc);
      AppMethodBeat.o(201822);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(201818);
      Object localObject = this.rjN.cvn();
      if (localObject != null)
      {
        localObject = ((y.b)localObject).cvl();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.JCb.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).f(i + paramInt1, paramInt2, paramObject);
            AppMethodBeat.o(201818);
            return;
          }
        }
      }
      AppMethodBeat.o(201818);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(201817);
      Object localObject = this.rjN.cvn();
      if (localObject != null)
      {
        localObject = ((y.b)localObject).cvl();
        if (localObject != null) {
          ((RefreshLoadMoreLayout)localObject).onChanged();
        }
      }
      z.a(this.rjN);
      AppMethodBeat.o(201817);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.z
 * JD-Core Version:    0.7.0.1
 */