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
import com.tencent.mm.plugin.finder.feed.model.internal.c.a;
import com.tencent.mm.plugin.finder.feed.model.m;
import com.tencent.mm.plugin.finder.feed.model.x;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", "canTimelineRefresh", "", "emptyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "isEmptyLocation", "isRequestingLbs", "()Z", "setRequestingLbs", "(Z)V", "msgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "checkEmptyHeader", "r", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "findFirstPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "notifyChanged", "rv", "itemId", "onActionbarClick", "isDouble", "onAttach", "callback", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "onUserVisibleFocused", "refreshMsgNotify", "Companion", "plugin-finder_release"})
public final class ab
  implements y.a<BaseFinderFeed>
{
  public static final ab.a rkg;
  public final MMActivity activity;
  public y.b<BaseFinderFeed> rjB;
  public final FinderHomeTabStateVM rjC;
  private final boolean rjD;
  public int rjE;
  boolean rjF;
  public boolean rjG;
  private e rjH;
  private com.tencent.mm.view.d rjI;
  private final FinderHomeTabFragment rjJ;
  public final m rke;
  private final com.tencent.mm.plugin.finder.model.f rkf;
  
  static
  {
    AppMethodBeat.i(201888);
    rkg = new ab.a((byte)0);
    AppMethodBeat.o(201888);
  }
  
  public ab(MMActivity paramMMActivity, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(201887);
    this.activity = paramMMActivity;
    this.rjJ = paramFinderHomeTabFragment;
    paramMMActivity = com.tencent.mm.ui.component.a.IrY;
    paramMMActivity = com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class);
    k.g(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.rjC = ((FinderHomeTabStateVM)paramMMActivity);
    this.rjD = this.rjC.ES(2);
    paramMMActivity = com.tencent.mm.plugin.finder.feed.model.internal.c.roo;
    paramMMActivity = c.a.DJ(2);
    if (this.rjD) {}
    for (int i = 0;; i = 1)
    {
      paramFinderHomeTabFragment = com.tencent.mm.ui.component.a.IrY;
      this.rke = new m(paramMMActivity, i, ((FinderReporterUIC)com.tencent.mm.ui.component.a.q(this.activity).get(FinderReporterUIC.class)).cGb());
      this.rjI = ((com.tencent.mm.view.d)new k(this));
      this.rjH = new e();
      this.rkf = new com.tencent.mm.plugin.finder.model.f();
      AppMethodBeat.o(201887);
      return;
    }
  }
  
  private final void g(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(201882);
    com.tencent.mm.ac.c.g((d.g.a.a)new c(this, paramc));
    AppMethodBeat.o(201882);
  }
  
  public static int u(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(201885);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    int i;
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      int[] arrayOfInt = new int[2];
      ((StaggeredGridLayoutManager)paramRecyclerView).n(arrayOfInt);
      i = arrayOfInt[1];
      AppMethodBeat.o(201885);
      return i;
    }
    if ((paramRecyclerView instanceof LinearLayoutManager))
    {
      i = ((LinearLayoutManager)paramRecyclerView).jW();
      AppMethodBeat.o(201885);
      return i;
    }
    AppMethodBeat.o(201885);
    return 0;
  }
  
  public final void Xa()
  {
    AppMethodBeat.i(201879);
    this.rke.requestLoadMore();
    AppMethodBeat.o(201879);
  }
  
  public final void a(y.b<BaseFinderFeed> paramb)
  {
    AppMethodBeat.i(201880);
    k.h(paramb, "callback");
    this.rjB = paramb;
    paramb = this.rjB;
    if (paramb == null) {
      k.aVY("viewCallback");
    }
    paramb.U((ArrayList)this.rke.getDataListJustForAdapter());
    this.rke.register(this.rjI, this.activity);
    paramb = h.rOQ;
    if (h.cCS())
    {
      final int i = this.rjC.EU(2).sbU.size();
      this.rke.initData((com.tencent.mm.plugin.finder.feed.model.internal.g)new x(i, false, (com.tencent.mm.plugin.finder.feed.model.internal.f)new d(this, i)), true);
      paramb = this.rjB;
      if (paramb == null) {
        k.aVY("viewCallback");
      }
      paramb.getRecyclerView().a((RecyclerView.m)new e(this));
      AppMethodBeat.o(201880);
      return;
    }
    paramb = new RefreshLoadMoreLayout.c(0);
    paramb.JxZ = -2;
    g(paramb);
    AppMethodBeat.o(201880);
  }
  
  public final void b(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(201878);
    k.h(paramc, "reason");
    if (paramc.Jyc <= 0)
    {
      Object localObject = this.rjB;
      if (localObject == null) {
        k.aVY("viewCallback");
      }
      localObject = ((y.b)localObject).cvl();
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      ((RefreshLoadMoreLayout)localObject).b(com.tencent.mm.plugin.finder.storage.b.czS(), (d.g.a.a)ab.i.rkm);
    }
    g(paramc);
    paramc = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    k.g(paramc, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramc).getRedDotManager().Dy(1003);
    AppMethodBeat.o(201878);
  }
  
  public final void con()
  {
    AppMethodBeat.i(201877);
    h localh = h.rOQ;
    h.a((d.g.a.a)new f(this), (d.g.a.a)new g(this), (d.g.a.a)new h(this));
    AppMethodBeat.o(201877);
  }
  
  public final y.b<BaseFinderFeed> cvn()
  {
    AppMethodBeat.i(201876);
    y.b localb = this.rjB;
    if (localb == null) {
      k.aVY("viewCallback");
    }
    AppMethodBeat.o(201876);
    return localb;
  }
  
  public final void ly(boolean paramBoolean)
  {
    AppMethodBeat.i(201884);
    Object localObject1 = this.rjB;
    if (localObject1 == null) {
      k.aVY("viewCallback");
    }
    localObject1 = ((y.b)localObject1).getRecyclerView();
    int i = u((RecyclerView)localObject1);
    ac.i("Finder.TimelineLbsPresenter", "[onActionbarClick] position=" + i + " isDouble=" + paramBoolean);
    Object localObject2;
    if (i <= 12)
    {
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
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
      AppMethodBeat.o(201884);
      return;
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      break;
      label287:
      uh(600L);
    }
    label297:
    AppMethodBeat.o(201884);
    return;
    label304:
    localObject1 = FinderReporterUIC.seQ;
    localObject1 = FinderReporterUIC.a.eV((Context)this.activity);
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.report.d.rxr;
      com.tencent.mm.plugin.finder.report.d.a(((FinderReporterUIC)localObject1).cGb(), 1);
      AppMethodBeat.o(201884);
      return;
    }
    AppMethodBeat.o(201884);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(201886);
    this.rke.unregister(this.rjI, this.activity);
    AppMethodBeat.o(201886);
  }
  
  public final void uh(long paramLong)
  {
    AppMethodBeat.i(201883);
    Object localObject = this.rjB;
    if (localObject == null) {
      k.aVY("viewCallback");
    }
    localObject = ((y.b)localObject).cvl();
    ((RefreshLoadMoreLayout)localObject).postDelayed((Runnable)new b((RefreshLoadMoreLayout)localObject), paramLong);
    AppMethodBeat.o(201883);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(201853);
      this.rjL.yt(this.rjM);
      AppMethodBeat.o(201853);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(ab paramab, RefreshLoadMoreLayout.c paramc)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.plugin.finder.feed.model.internal.f
  {
    d(int paramInt) {}
    
    public final void call(final int paramInt)
    {
      AppMethodBeat.i(201856);
      ac.i("Finder.TimelineLbsPresenter", "[initData] canTimelineRefresh=" + ab.b(this.rkh) + ", incrementCount=" + paramInt);
      if (ab.b(this.rkh))
      {
        this.rkh.uh(0L);
        AppMethodBeat.o(201856);
        return;
      }
      Object localObject = ab.c(this.rkh).EU(2);
      paramInt = ((FinderHomeTabStateVM.a)localObject).sbW;
      final int i = ((FinderHomeTabStateVM.a)localObject).sbX;
      ac.i("Finder.TimelineLbsPresenter", "[initData] canTimelineRefresh " + ab.b(this.rkh) + " lastPos=" + paramInt + " fromTopPixel=" + i + " initCount=" + i);
      localObject = this.rkh.cvn().getRecyclerView().getLayoutManager();
      ab.a(this.rkh, i);
      if ((localObject instanceof StaggeredGridLayoutManager))
      {
        ((StaggeredGridLayoutManager)localObject).af(paramInt, i);
        this.rkh.cvn().getRecyclerView().post((Runnable)new a((RecyclerView.i)localObject, paramInt, i));
      }
      AppMethodBeat.o(201856);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(RecyclerView.i parami, int paramInt1, int paramInt2) {}
      
      public final void run()
      {
        AppMethodBeat.i(201855);
        ((StaggeredGridLayoutManager)this.rjQ).af(paramInt, i);
        AppMethodBeat.o(201855);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$2", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class e
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201857);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt1);
      localb.lS(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
      k.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = this.rkh;
      ab.a(paramRecyclerView, ab.d(paramRecyclerView) - paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(201857);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(201858);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
      super.b(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(201858);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(ab paramab)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    g(ab paramab)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    h(ab paramab)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class j
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public j(ab paramab)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class k
    implements com.tencent.mm.view.d
  {
    private WxRecyclerAdapter<?> getAdapter()
    {
      AppMethodBeat.i(201869);
      Object localObject = this.rkh.cvn().getRecyclerView().getAdapter();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
        AppMethodBeat.o(201869);
        throw ((Throwable)localObject);
      }
      localObject = (WxRecyclerAdapter)localObject;
      AppMethodBeat.o(201869);
      return localObject;
    }
    
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201872);
      Object localObject = this.rkh.cvn();
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
            AppMethodBeat.o(201872);
            return;
          }
        }
      }
      AppMethodBeat.o(201872);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201873);
      Object localObject = this.rkh.cvn();
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
            AppMethodBeat.o(201873);
            return;
          }
        }
      }
      AppMethodBeat.o(201873);
    }
    
    public final void c(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201874);
      k.h(paramc, "reason");
      this.rkh.cvn().cvl().c(paramc);
      AppMethodBeat.o(201874);
    }
    
    public final void d(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201875);
      k.h(paramc, "reason");
      this.rkh.cvn().cvl().d(paramc);
      AppMethodBeat.o(201875);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(201871);
      Object localObject = this.rkh.cvn();
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
            AppMethodBeat.o(201871);
            return;
          }
        }
      }
      AppMethodBeat.o(201871);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(201870);
      Object localObject = this.rkh.cvn();
      if (localObject != null)
      {
        localObject = ((y.b)localObject).cvl();
        if (localObject != null)
        {
          ((RefreshLoadMoreLayout)localObject).onChanged();
          AppMethodBeat.o(201870);
          return;
        }
      }
      AppMethodBeat.o(201870);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ab
 * JD-Core Version:    0.7.0.1
 */