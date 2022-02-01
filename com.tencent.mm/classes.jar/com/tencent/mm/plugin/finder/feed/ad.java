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
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.x;
import com.tencent.mm.plugin.finder.feed.model.x.a;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", "canTimelineRefresh", "", "emptyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;)V", "isEmptyLocation", "isRequestingLbs", "()Z", "setRequestingLbs", "(Z)V", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "checkEmptyHeader", "r", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "findFirstPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "onActionbarClick", "isDouble", "onAttach", "callback", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "onUserVisibleFocused", "Companion", "plugin-finder_release"})
public final class ad
  implements ac.a<com.tencent.mm.plugin.finder.model.v>
{
  public static final a KOh;
  public x KNY;
  public ac.b<com.tencent.mm.plugin.finder.model.v> KNZ;
  public final FinderHomeTabStateVM KOa;
  public int KOb;
  boolean KOc;
  public boolean KOd;
  private com.tencent.mm.plugin.finder.model.c KOe;
  private com.tencent.mm.view.d KOf;
  private final FinderHomeTabFragment KOg;
  public final MMActivity activity;
  private final boolean qwK;
  
  static
  {
    AppMethodBeat.i(197940);
    KOh = new a((byte)0);
    AppMethodBeat.o(197940);
  }
  
  public ad(MMActivity paramMMActivity, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(197939);
    this.activity = paramMMActivity;
    this.KOg = paramFinderHomeTabFragment;
    paramMMActivity = com.tencent.mm.ui.component.a.LCX;
    paramMMActivity = com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderHomeTabStateVM.class);
    k.g(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.KOa = ((FinderHomeTabStateVM)paramMMActivity);
    this.qwK = this.KOa.ahN(1000);
    this.KOe = new com.tencent.mm.plugin.finder.model.c();
    this.KOf = ((com.tencent.mm.view.d)new k(this));
    AppMethodBeat.o(197939);
  }
  
  private final void e(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(197937);
    com.tencent.mm.ad.c.g((d.g.a.a)new c(this, paramc));
    AppMethodBeat.o(197937);
  }
  
  public static int x(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(197935);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    int i;
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      int[] arrayOfInt = new int[2];
      ((StaggeredGridLayoutManager)paramRecyclerView).x(arrayOfInt);
      i = arrayOfInt[1];
      AppMethodBeat.o(197935);
      return i;
    }
    if ((paramRecyclerView instanceof LinearLayoutManager))
    {
      i = ((LinearLayoutManager)paramRecyclerView).jO();
      AppMethodBeat.o(197935);
      return i;
    }
    AppMethodBeat.o(197935);
    return 0;
  }
  
  public final void BH(long paramLong)
  {
    AppMethodBeat.i(197933);
    Object localObject = this.KNZ;
    if (localObject == null) {
      k.aPZ("viewCallback");
    }
    localObject = ((ac.b)localObject).cmp();
    ((RefreshLoadMoreLayout)localObject).postDelayed((Runnable)new b((RefreshLoadMoreLayout)localObject), paramLong);
    AppMethodBeat.o(197933);
  }
  
  public final void Wc()
  {
    AppMethodBeat.i(197930);
    x localx = this.KNY;
    if (localx == null) {
      k.aPZ("feedLoader");
    }
    localx.requestLoadMore();
    AppMethodBeat.o(197930);
  }
  
  public final void a(ac.b<com.tencent.mm.plugin.finder.model.v> paramb)
  {
    AppMethodBeat.i(197931);
    k.h(paramb, "callback");
    this.KNZ = paramb;
    paramb = com.tencent.mm.ui.component.a.LCX;
    paramb = new x(((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.activity).get(FinderReporterUIC.class)).fXs());
    paramb.KPL = ((d.g.a.b)new d(this));
    this.KNY = paramb;
    paramb = this.KNZ;
    if (paramb == null) {
      k.aPZ("viewCallback");
    }
    x localx = this.KNY;
    if (localx == null) {
      k.aPZ("feedLoader");
    }
    paramb.N((ArrayList)localx.getDataListJustForAdapter());
    paramb = this.KNY;
    if (paramb == null) {
      k.aPZ("feedLoader");
    }
    paramb.register(this.KOf, this.activity);
    paramb = p.LaH;
    if (p.fVQ())
    {
      final int i = this.KOa.ahO(1000).Lhj.size();
      paramb = this.KNY;
      if (paramb == null) {
        k.aPZ("feedLoader");
      }
      paramb.initData((h)new x.a((g)new e(this, i)), false);
      paramb = this.KNZ;
      if (paramb == null) {
        k.aPZ("viewCallback");
      }
      paramb.getRecyclerView().a((RecyclerView.m)new f(this));
      AppMethodBeat.o(197931);
      return;
    }
    paramb = new RefreshLoadMoreLayout.c(0);
    paramb.HXo = -2;
    e(paramb);
    AppMethodBeat.o(197931);
  }
  
  public final void b(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(197929);
    k.h(paramc, "reason");
    Object localObject;
    if (paramc.HXr <= 0)
    {
      localObject = this.KNZ;
      if (localObject == null) {
        k.aPZ("viewCallback");
      }
      localObject = ((ac.b)localObject).cmp();
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      ((RefreshLoadMoreLayout)localObject).b(com.tencent.mm.plugin.finder.storage.b.fUv(), (d.g.a.a)j.KOr);
    }
    if (paramc.HXq)
    {
      localObject = this.KNZ;
      if (localObject == null) {
        k.aPZ("viewCallback");
      }
      if (!((ac.b)localObject).cmp().HXd)
      {
        localObject = this.KNZ;
        if (localObject == null) {
          k.aPZ("viewCallback");
        }
        ((ac.b)localObject).cmp().setHasBottomMore(true);
      }
    }
    e(paramc);
    AppMethodBeat.o(197929);
  }
  
  public final void cgG()
  {
    AppMethodBeat.i(197928);
    p localp = p.LaH;
    p.a((d.g.a.a)new g(this), (d.g.a.a)new h(this), (d.g.a.a)new i(this));
    AppMethodBeat.o(197928);
  }
  
  public final x fTp()
  {
    AppMethodBeat.i(197926);
    x localx = this.KNY;
    if (localx == null) {
      k.aPZ("feedLoader");
    }
    AppMethodBeat.o(197926);
    return localx;
  }
  
  public final ac.b<com.tencent.mm.plugin.finder.model.v> fTq()
  {
    AppMethodBeat.i(197927);
    ac.b localb = this.KNZ;
    if (localb == null) {
      k.aPZ("viewCallback");
    }
    AppMethodBeat.o(197927);
    return localb;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(197936);
    x localx = this.KNY;
    if (localx == null) {
      k.aPZ("feedLoader");
    }
    ac.b localb = this.KNZ;
    if (localb == null) {
      k.aPZ("viewCallback");
    }
    localx.unregister((com.tencent.mm.view.d)localb.cmp(), this.activity);
    AppMethodBeat.o(197936);
  }
  
  public final void yB(boolean paramBoolean)
  {
    AppMethodBeat.i(197934);
    Object localObject1 = this.KNZ;
    if (localObject1 == null) {
      k.aPZ("viewCallback");
    }
    localObject1 = ((ac.b)localObject1).getRecyclerView();
    int i = x((RecyclerView)localObject1);
    com.tencent.mm.sdk.platformtools.ad.i("Finder.FinderTimelineLbsMixPresenter", "[onActionbarClick] position=" + i + " isDouble=" + paramBoolean);
    Object localObject2;
    if (i <= 12)
    {
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
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
      AppMethodBeat.o(197934);
      return;
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      break;
      label287:
      BH(600L);
    }
    label297:
    AppMethodBeat.o(197934);
    return;
    label304:
    localObject1 = FinderReporterUIC.Ljl;
    localObject1 = FinderReporterUIC.a.lB((Context)this.activity);
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.report.b.qFq;
      com.tencent.mm.plugin.finder.report.b.a(((FinderReporterUIC)localObject1).fXs(), 1);
      AppMethodBeat.o(197934);
      return;
    }
    AppMethodBeat.o(197934);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(197904);
      this.KOi.xk(this.qxv);
      AppMethodBeat.o(197904);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(ad paramad, RefreshLoadMoreLayout.c paramc)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$1$1"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<IResponse<com.tencent.mm.plugin.finder.model.v>, y>
  {
    d(ad paramad)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class e
    implements g
  {
    e(int paramInt) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(197908);
      com.tencent.mm.sdk.platformtools.ad.i("Finder.FinderTimelineLbsMixPresenter", "[initData] canTimelineRefresh=" + ad.c(this.KOj) + ", incrementCount=" + paramInt);
      ad localad;
      if (ad.c(this.KOj))
      {
        this.KOj.BH(0L);
        if (paramInt <= 0)
        {
          localad = this.KOj;
          if (!ad.c(this.KOj)) {
            break label262;
          }
        }
      }
      label262:
      for (Object localObject = new RefreshLoadMoreLayout.c(0);; localObject = null)
      {
        ad.a(localad, (RefreshLoadMoreLayout.c)localObject);
        AppMethodBeat.o(197908);
        return;
        localObject = ad.d(this.KOj).ahO(1000);
        final int i = ((FinderHomeTabStateVM.a)localObject).Lhf;
        final int j = ((FinderHomeTabStateVM.a)localObject).Lhg;
        com.tencent.mm.sdk.platformtools.ad.i("Finder.FinderTimelineLbsMixPresenter", "[initData] canTimelineRefresh " + ad.c(this.KOj) + " lastPos=" + i + " fromTopPixel=" + j + " initCount=" + i);
        localObject = this.KOj.fTq().getRecyclerView().getLayoutManager();
        ad.a(this.KOj, j);
        if (!(localObject instanceof StaggeredGridLayoutManager)) {
          break;
        }
        ((StaggeredGridLayoutManager)localObject).af(i, j);
        this.KOj.fTq().getRecyclerView().post((Runnable)new a((RecyclerView.i)localObject, i, j));
        break;
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(RecyclerView.i parami, int paramInt1, int paramInt2) {}
      
      public final void run()
      {
        AppMethodBeat.i(197907);
        ((StaggeredGridLayoutManager)this.KOl).af(i, j);
        AppMethodBeat.o(197907);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$3", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(197909);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt1);
      localb.lT(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
      k.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = this.KOj;
      ad.a(paramRecyclerView, ad.e(paramRecyclerView) - paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(197909);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(197910);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
      super.b(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(197910);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    g(ad paramad)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    h(ad paramad)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    i(ad paramad)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final j KOr;
    
    static
    {
      AppMethodBeat.i(197918);
      KOr = new j();
      AppMethodBeat.o(197918);
    }
    
    j()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class k
    implements com.tencent.mm.view.d
  {
    private WxRecyclerAdapter<?> getAdapter()
    {
      AppMethodBeat.i(197919);
      Object localObject = this.KOj.fTq().getRecyclerView().getAdapter();
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
        AppMethodBeat.o(197919);
        throw ((Throwable)localObject);
      }
      localObject = (WxRecyclerAdapter)localObject;
      AppMethodBeat.o(197919);
      return localObject;
    }
    
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(197922);
      Object localObject = this.KOj.fTq();
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
            AppMethodBeat.o(197922);
            return;
          }
        }
      }
      AppMethodBeat.o(197922);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(197923);
      Object localObject = this.KOj.fTq();
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
            AppMethodBeat.o(197923);
            return;
          }
        }
      }
      AppMethodBeat.o(197923);
    }
    
    public final void c(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(197925);
      k.h(paramc, "reason");
      this.KOj.fTq().cmp().c(paramc);
      AppMethodBeat.o(197925);
    }
    
    public final void d(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(197924);
      k.h(paramc, "reason");
      this.KOj.fTq().cmp().d(paramc);
      AppMethodBeat.o(197924);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(197921);
      Object localObject = this.KOj.fTq();
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
            AppMethodBeat.o(197921);
            return;
          }
        }
      }
      AppMethodBeat.o(197921);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(197920);
      Object localObject = this.KOj.fTq();
      if (localObject != null)
      {
        localObject = ((ac.b)localObject).cmp();
        if (localObject != null) {
          ((RefreshLoadMoreLayout)localObject).onChanged();
        }
      }
      ad.a(this.KOj);
      AppMethodBeat.o(197920);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ad
 * JD-Core Version:    0.7.0.1
 */