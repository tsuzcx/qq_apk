package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.b.a.cl;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.e.a;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.live.s.j;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.storage.o;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", "canTimelineRefresh", "", "emptyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "isEmptyLocation", "isRequestingLbs", "()Z", "setRequestingLbs", "(Z)V", "msgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "checkEmptyHeader", "r", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "findFirstPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "notifyChanged", "rv", "itemId", "onActionbarClick", "isDouble", "onAttach", "callback", "onClickReport", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLbsCardActionReportStruct;", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "feedIndex", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "onUserVisibleFocused", "refreshMsgNotify", "refreshRV", "data", "Landroid/content/Intent;", "Companion", "plugin-finder_release"})
public final class am
  implements aj.a<bo>
{
  public static final b tRp;
  public final MMActivity activity;
  private final boolean canTimelineRefresh;
  private com.tencent.mm.plugin.finder.model.g emptyData;
  public boolean isEmptyLocation;
  boolean isRequestingLbs;
  private final com.tencent.mm.plugin.finder.model.h msgNotifyData;
  public aj.b<bo> tQZ;
  private final FinderHomeTabFragment tRb;
  public final FinderTimelineFeedLoader tRo;
  private j tagViewActionCallback;
  public final FinderHomeTabStateVM tlCache;
  public int totalDy;
  
  static
  {
    AppMethodBeat.i(244276);
    tRp = new b((byte)0);
    AppMethodBeat.o(244276);
  }
  
  public am(MMActivity paramMMActivity, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(244275);
    this.activity = paramMMActivity;
    this.tRb = paramFinderHomeTabFragment;
    paramMMActivity = com.tencent.mm.ui.component.a.PRN;
    paramMMActivity = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    p.g(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.tlCache = ((FinderHomeTabStateVM)paramMMActivity);
    this.canTimelineRefresh = this.tlCache.JN(2);
    paramMMActivity = e.tYB;
    paramMMActivity = e.a.IO(2);
    if (this.canTimelineRefresh) {}
    for (int i = 0;; i = 1)
    {
      paramFinderHomeTabFragment = com.tencent.mm.ui.component.a.PRN;
      paramMMActivity = new FinderTimelineFeedLoader(paramMMActivity, i, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.activity).get(FinderReporterUIC.class)).dIx());
      paramMMActivity.setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.h)new a(paramMMActivity, this));
      this.tRo = paramMMActivity;
      this.tagViewActionCallback = ((j)new l(this));
      this.emptyData = new com.tencent.mm.plugin.finder.model.g();
      this.msgNotifyData = new com.tencent.mm.plugin.finder.model.h();
      AppMethodBeat.o(244275);
      return;
    }
  }
  
  private final void checkEmptyHeader(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(244269);
    d.h((kotlin.g.a.a)new d(this, paramc));
    AppMethodBeat.o(244269);
  }
  
  public static int findFirstPosition(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(244272);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    int i;
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      int[] arrayOfInt = new int[2];
      ((StaggeredGridLayoutManager)paramRecyclerView).n(arrayOfInt);
      i = arrayOfInt[1];
      AppMethodBeat.o(244272);
      return i;
    }
    if ((paramRecyclerView instanceof LinearLayoutManager))
    {
      i = ((LinearLayoutManager)paramRecyclerView).ks();
      AppMethodBeat.o(244272);
      return i;
    }
    AppMethodBeat.o(244272);
    return 0;
  }
  
  public final void ED(long paramLong)
  {
    AppMethodBeat.i(244270);
    Object localObject = this.tQZ;
    if (localObject == null) {
      p.btv("viewCallback");
    }
    localObject = ((aj.b)localObject).dcQ();
    if (localObject != null)
    {
      ((RefreshLoadMoreLayout)localObject).postDelayed((Runnable)new c((RefreshLoadMoreLayout)localObject), paramLong);
      AppMethodBeat.o(244270);
      return;
    }
    AppMethodBeat.o(244270);
  }
  
  public final void a(cl paramcl, o paramo, int paramInt)
  {
    AppMethodBeat.i(244274);
    p.h(paramcl, "struct");
    p.h(paramo, "lbsItem");
    AppMethodBeat.o(244274);
  }
  
  public final void a(aj.b<bo> paramb)
  {
    AppMethodBeat.i(244267);
    p.h(paramb, "callback");
    this.tQZ = paramb;
    paramb = this.tQZ;
    if (paramb == null) {
      p.btv("viewCallback");
    }
    paramb.ab((ArrayList)this.tRo.getDataListJustForAdapter());
    this.tRo.register(this.tagViewActionCallback);
    paramb = com.tencent.mm.plugin.finder.utils.l.vVE;
    if (com.tencent.mm.plugin.finder.utils.l.dBJ())
    {
      this.tlCache.Mq(2).wuc.size();
      BaseFeedLoader.requestInit$default(this.tRo, false, 1, null);
      paramb = this.tQZ;
      if (paramb == null) {
        p.btv("viewCallback");
      }
      paramb = paramb.getRecyclerView();
      if (paramb != null)
      {
        paramb.a((RecyclerView.l)new e(this));
        AppMethodBeat.o(244267);
        return;
      }
      AppMethodBeat.o(244267);
      return;
    }
    paramb = new RefreshLoadMoreLayout.c(0);
    paramb.Rmh = -2;
    checkEmptyHeader(paramb);
    AppMethodBeat.o(244267);
  }
  
  public final aj.b<bo> dcS()
  {
    AppMethodBeat.i(244263);
    aj.b localb = this.tQZ;
    if (localb == null) {
      p.btv("viewCallback");
    }
    AppMethodBeat.o(244263);
    return localb;
  }
  
  public final void onActionbarClick(boolean paramBoolean)
  {
    AppMethodBeat.i(244271);
    Object localObject1 = this.tQZ;
    if (localObject1 == null) {
      p.btv("viewCallback");
    }
    localObject1 = ((aj.b)localObject1).getRecyclerView();
    if (localObject1 == null)
    {
      AppMethodBeat.o(244271);
      return;
    }
    int i = findFirstPosition((RecyclerView)localObject1);
    Log.i("Finder.TimelineLbsPresenter", "[onActionbarClick] position=" + i + " isDouble=" + paramBoolean);
    Object localObject2;
    if (i <= 12)
    {
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      if (!paramBoolean) {
        break label315;
      }
      if (i > 12) {
        break label298;
      }
      ED(20L);
    }
    for (;;)
    {
      localObject1 = FinderReporterUIC.wzC;
      localObject1 = FinderReporterUIC.a.fH((Context)this.activity);
      if (localObject1 == null) {
        break label308;
      }
      localObject2 = com.tencent.mm.plugin.finder.report.k.vfA;
      com.tencent.mm.plugin.finder.report.k.a(((FinderReporterUIC)localObject1).dIx(), 5);
      AppMethodBeat.o(244271);
      return;
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      break;
      label298:
      ED(600L);
    }
    label308:
    AppMethodBeat.o(244271);
    return;
    label315:
    localObject1 = FinderReporterUIC.wzC;
    localObject1 = FinderReporterUIC.a.fH((Context)this.activity);
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.report.k.vfA;
      com.tencent.mm.plugin.finder.report.k.a(((FinderReporterUIC)localObject1).dIx(), 1);
      AppMethodBeat.o(244271);
      return;
    }
    AppMethodBeat.o(244271);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(244273);
    this.tRo.unregister(this.tagViewActionCallback);
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
    ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Mp(2);
    AppMethodBeat.o(244273);
  }
  
  public final void onLoadMore()
  {
    AppMethodBeat.i(244266);
    this.tRo.requestLoadMore();
    AppMethodBeat.o(244266);
  }
  
  public final void onRefresh()
  {
    AppMethodBeat.i(244264);
    com.tencent.mm.plugin.finder.utils.l locall = com.tencent.mm.plugin.finder.utils.l.vVE;
    com.tencent.mm.plugin.finder.utils.l.a((kotlin.g.a.a)new f(this), (kotlin.g.a.a)new g(this), (kotlin.g.a.a)new h(this));
    AppMethodBeat.o(244264);
  }
  
  public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(244265);
    p.h(paramc, "reason");
    if (paramc.Rmk <= 0)
    {
      Object localObject = this.tQZ;
      if (localObject == null) {
        p.btv("viewCallback");
      }
      localObject = ((aj.b)localObject).dcQ();
      if (localObject != null)
      {
        com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
        ((RefreshLoadMoreLayout)localObject).b(com.tencent.mm.plugin.finder.storage.c.dsb(), (kotlin.g.a.a)am.i.tRy);
      }
    }
    checkEmptyHeader(paramc);
    paramc = com.tencent.mm.kernel.g.ah(PluginFinder.class);
    p.g(paramc, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramc).getRedDotManager().asV("finder_tl_nearby_tab");
    paramc = com.tencent.mm.kernel.g.ah(PluginFinder.class);
    p.g(paramc, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramc).getRedDotManager().gI("finder_tl_nearby_tab", "onRefreshEnd");
    paramc = com.tencent.mm.plugin.finder.report.live.k.vkd;
    com.tencent.mm.plugin.finder.report.live.k.b(null, s.p.voz, s.j.vnV.scene, com.tencent.mm.plugin.finder.report.live.c.vjh);
    AppMethodBeat.o(244265);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$feedLoader$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.plugin.finder.feed.model.internal.h
  {
    a(FinderTimelineFeedLoader paramFinderTimelineFeedLoader, am paramam) {}
    
    public final void call(final int paramInt)
    {
      AppMethodBeat.i(244233);
      Log.i(this.tRq.getTAG(), "[initData] canTimelineRefresh=" + am.f(jdField_this) + ", incrementCount=" + paramInt);
      Object localObject;
      if (am.f(jdField_this))
      {
        jdField_this.ED(0L);
        localObject = jdField_this.dcS().dcQ();
        if (localObject != null) {
          ((RefreshLoadMoreLayout)localObject).post((Runnable)an.tRs);
        }
        localObject = jdField_this.dcS().dcQ();
        if (localObject != null)
        {
          ((RefreshLoadMoreLayout)localObject).post((Runnable)ao.tRt);
          AppMethodBeat.o(244233);
        }
      }
      else
      {
        localObject = am.g(jdField_this).Mq(2);
        paramInt = ((FinderHomeTabStateVM.a)localObject).wuf;
        final int i = ((FinderHomeTabStateVM.a)localObject).wug;
        Log.i(this.tRq.getTAG(), "[initData] canTimelineRefresh " + am.f(jdField_this) + " lastPos=" + paramInt + " fromTopPixel=" + i);
        localObject = jdField_this.dcS().getRecyclerView();
        if (localObject != null) {}
        for (localObject = ((RecyclerView)localObject).getLayoutManager();; localObject = null)
        {
          am.a(jdField_this, i);
          if (!(localObject instanceof StaggeredGridLayoutManager)) {
            break;
          }
          ((StaggeredGridLayoutManager)localObject).ah(paramInt, i);
          RecyclerView localRecyclerView = jdField_this.dcS().getRecyclerView();
          if (localRecyclerView == null) {
            break;
          }
          localRecyclerView.post((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(244232);
              ((StaggeredGridLayoutManager)this.$layoutManager).ah(paramInt, i);
              AppMethodBeat.o(244232);
            }
          });
          break;
        }
      }
      AppMethodBeat.o(244233);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(244234);
      this.$rlLayout.DD(this.$isSilence);
      AppMethodBeat.o(244234);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(am paramam, RefreshLoadMoreLayout.c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class e
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(244241);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(244241);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(244240);
      Object localObject = new b();
      ((b)localObject).bm(paramRecyclerView);
      ((b)localObject).pH(paramInt1);
      ((b)localObject).pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = this.tRr;
      am.a((am)localObject, am.b((am)localObject) - paramInt2);
      localObject = com.tencent.mm.plugin.finder.report.live.k.vkd;
      com.tencent.mm.plugin.finder.report.live.k.b(paramRecyclerView, s.p.voz, s.j.vnV.scene, com.tencent.mm.plugin.finder.report.live.c.vje);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(244240);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(am paramam)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(am paramam)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(am paramam)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class j
    extends q
    implements kotlin.g.a.a<x>
  {
    public j(am paramam)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class l
    implements j
  {
    private WxRecyclerAdapter<?> getAdapter()
    {
      AppMethodBeat.i(244254);
      Object localObject1 = this.tRr.dcS();
      if (localObject1 != null)
      {
        localObject1 = ((aj.b)localObject1).getRecyclerView();
        if (localObject1 == null) {}
      }
      for (localObject1 = ((RecyclerView)localObject1).getAdapter();; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (!(localObject1 instanceof WxRecyclerAdapter)) {
          localObject2 = null;
        }
        localObject1 = (WxRecyclerAdapter)localObject2;
        AppMethodBeat.o(244254);
        return localObject1;
      }
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(244255);
      Object localObject = this.tRr.dcS();
      if (localObject != null)
      {
        localObject = ((aj.b)localObject).dcQ();
        if (localObject != null)
        {
          ((RefreshLoadMoreLayout)localObject).onChanged();
          AppMethodBeat.o(244255);
          return;
        }
      }
      AppMethodBeat.o(244255);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(244256);
      Object localObject = this.tRr.dcS();
      if (localObject != null)
      {
        localObject = ((aj.b)localObject).dcQ();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.RqM.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeChanged(i + paramInt1, paramInt2);
            AppMethodBeat.o(244256);
            return;
          }
        }
      }
      AppMethodBeat.o(244256);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(244257);
      Object localObject = this.tRr.dcS();
      if (localObject != null)
      {
        localObject = ((aj.b)localObject).dcQ();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.RqM.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeChanged(i + paramInt1, paramInt2, paramObject);
            AppMethodBeat.o(244257);
            return;
          }
        }
      }
      AppMethodBeat.o(244257);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(244258);
      Object localObject = this.tRr.dcS();
      if (localObject != null)
      {
        localObject = ((aj.b)localObject).dcQ();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.RqM.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeInserted(i + paramInt1, paramInt2);
            AppMethodBeat.o(244258);
            return;
          }
        }
      }
      AppMethodBeat.o(244258);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(244259);
      Object localObject = this.tRr.dcS();
      if (localObject != null)
      {
        localObject = ((aj.b)localObject).dcQ();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.RqM.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeRemoved(i + paramInt1, paramInt2);
            AppMethodBeat.o(244259);
            return;
          }
        }
      }
      AppMethodBeat.o(244259);
    }
    
    public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(244261);
      p.h(paramc, "reason");
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.tRr.dcS().dcQ();
      if (localRefreshLoadMoreLayout != null)
      {
        localRefreshLoadMoreLayout.onPreFinishLoadMore(paramc);
        AppMethodBeat.o(244261);
        return;
      }
      AppMethodBeat.o(244261);
    }
    
    public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(244262);
      p.h(paramc, "reason");
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.tRr.dcS().dcQ();
      if (localRefreshLoadMoreLayout != null)
      {
        localRefreshLoadMoreLayout.onPreFinishLoadMoreSmooth(paramc);
        AppMethodBeat.o(244262);
        return;
      }
      AppMethodBeat.o(244262);
    }
    
    public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(244260);
      p.h(paramc, "reason");
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.tRr.dcS().dcQ();
      if (localRefreshLoadMoreLayout != null)
      {
        localRefreshLoadMoreLayout.onPreFinishRefresh(paramc);
        AppMethodBeat.o(244260);
        return;
      }
      AppMethodBeat.o(244260);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.am
 * JD-Core Version:    0.7.0.1
 */