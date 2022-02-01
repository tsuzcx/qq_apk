package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.ac;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.o;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", "canTimelineRefresh", "", "emptyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;)V", "isEmptyLocation", "isRequestingLbs", "()Z", "setRequestingLbs", "(Z)V", "refreshTime", "", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "isSilence", "checkEmptyHeader", "r", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "findFirstPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "onActionbarClick", "isDouble", "onAttach", "callback", "onClickReport", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLbsCardActionReportStruct;", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "feedIndex", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "onUserVisibleFocused", "Companion", "plugin-finder_release"})
public final class ak
  implements aj.a<com.tencent.mm.plugin.finder.model.c>
{
  public static final a tRc;
  public final MMActivity activity;
  private final boolean canTimelineRefresh;
  private com.tencent.mm.plugin.finder.model.g emptyData;
  public boolean isEmptyLocation;
  boolean isRequestingLbs;
  public FinderLbsLoader tQY;
  public aj.b<com.tencent.mm.plugin.finder.model.c> tQZ;
  private long tRa;
  private final FinderHomeTabFragment tRb;
  private j tagViewActionCallback;
  public final FinderHomeTabStateVM tlCache;
  public int totalDy;
  
  static
  {
    AppMethodBeat.i(244216);
    tRc = new a((byte)0);
    AppMethodBeat.o(244216);
  }
  
  public ak(MMActivity paramMMActivity, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(244215);
    this.activity = paramMMActivity;
    this.tRb = paramFinderHomeTabFragment;
    paramMMActivity = com.tencent.mm.ui.component.a.PRN;
    paramMMActivity = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    p.g(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.tlCache = ((FinderHomeTabStateVM)paramMMActivity);
    this.canTimelineRefresh = this.tlCache.JN(1000);
    this.tRa = -1L;
    this.emptyData = new com.tencent.mm.plugin.finder.model.g();
    this.tagViewActionCallback = ((j)new l(this));
    AppMethodBeat.o(244215);
  }
  
  private final void checkEmptyHeader(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(244212);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new c(this, paramc));
    AppMethodBeat.o(244212);
  }
  
  public static int findFirstPosition(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(244210);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    int i;
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      int[] arrayOfInt = new int[2];
      ((StaggeredGridLayoutManager)paramRecyclerView).n(arrayOfInt);
      i = arrayOfInt[1];
      AppMethodBeat.o(244210);
      return i;
    }
    if ((paramRecyclerView instanceof LinearLayoutManager))
    {
      i = ((LinearLayoutManager)paramRecyclerView).ks();
      AppMethodBeat.o(244210);
      return i;
    }
    AppMethodBeat.o(244210);
    return 0;
  }
  
  public final void ED(long paramLong)
  {
    AppMethodBeat.i(244208);
    Object localObject = this.tQZ;
    if (localObject == null) {
      p.btv("viewCallback");
    }
    localObject = ((aj.b)localObject).dcQ();
    if (localObject != null)
    {
      ((RefreshLoadMoreLayout)localObject).postDelayed((Runnable)new b((RefreshLoadMoreLayout)localObject), paramLong);
      AppMethodBeat.o(244208);
      return;
    }
    AppMethodBeat.o(244208);
  }
  
  public final void a(com.tencent.mm.g.b.a.cl paramcl, o paramo, int paramInt)
  {
    AppMethodBeat.i(244214);
    p.h(paramcl, "struct");
    p.h(paramo, "lbsItem");
    Object localObject = FinderReporterUIC.wzC;
    localObject = FinderReporterUIC.a.fH((Context)this.activity);
    if (localObject != null) {}
    for (localObject = FinderReporterUIC.c((FinderReporterUIC)localObject);; localObject = null)
    {
      if ((localObject instanceof ac))
      {
        paramcl.gv(this.tRa);
        localObject = (ac)localObject;
        p.h(paramcl, "struct");
        p.h(paramo, "lbsItem");
        paramcl = (com.tencent.mm.g.b.a.cl)ac.a((com.tencent.mm.plugin.report.a)((ac)localObject).b((com.tencent.mm.plugin.report.a)paramcl), paramo);
        if ((paramInt >= 0) && (paramInt < paramo.vDZ.size()))
        {
          paramcl.gz(paramInt);
          localObject = (com.tencent.mm.plugin.report.a)paramcl;
          paramo = paramo.vDZ.get(paramInt);
          p.g(paramo, "lbsItem.feedList[feedIndex]");
          ac.a((com.tencent.mm.plugin.report.a)localObject, (BaseFinderFeed)paramo);
        }
        paramcl.bfK();
      }
      AppMethodBeat.o(244214);
      return;
    }
  }
  
  public final void a(aj.b<com.tencent.mm.plugin.finder.model.c> paramb)
  {
    AppMethodBeat.i(244206);
    p.h(paramb, "callback");
    this.tRa = com.tencent.mm.model.cl.aWA();
    this.tQZ = paramb;
    paramb = com.tencent.mm.ui.component.a.PRN;
    paramb = new FinderLbsLoader(((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.activity).get(FinderReporterUIC.class)).dIx());
    paramb.setInitDone((h)new d(paramb, this));
    paramb.fetchEndCallback = ((kotlin.g.a.b)new e(this));
    this.tQY = paramb;
    paramb = this.tQZ;
    if (paramb == null) {
      p.btv("viewCallback");
    }
    FinderLbsLoader localFinderLbsLoader = this.tQY;
    if (localFinderLbsLoader == null) {
      p.btv("feedLoader");
    }
    paramb.ab((ArrayList)localFinderLbsLoader.getDataListJustForAdapter());
    paramb = this.tQY;
    if (paramb == null) {
      p.btv("feedLoader");
    }
    paramb.register(this.tagViewActionCallback);
    paramb = com.tencent.mm.plugin.finder.utils.l.vVE;
    if (com.tencent.mm.plugin.finder.utils.l.dBJ())
    {
      this.tlCache.Mq(1000).wud.size();
      paramb = this.tQY;
      if (paramb == null) {
        p.btv("feedLoader");
      }
      paramb.requestInit(false);
      paramb = this.tQZ;
      if (paramb == null) {
        p.btv("viewCallback");
      }
      paramb = paramb.getRecyclerView();
      if (paramb != null) {
        paramb.a((RecyclerView.l)new f(this));
      }
    }
    for (;;)
    {
      paramb = this.tQZ;
      if (paramb == null) {
        p.btv("viewCallback");
      }
      paramb = paramb.getRecyclerView();
      if (paramb == null) {
        break;
      }
      com.tencent.mm.view.recyclerview.c.a(paramb, (com.tencent.mm.view.recyclerview.d)new g(this));
      AppMethodBeat.o(244206);
      return;
      paramb = new RefreshLoadMoreLayout.c(0);
      paramb.Rmh = -2;
      checkEmptyHeader(paramb);
    }
    AppMethodBeat.o(244206);
  }
  
  public final FinderLbsLoader dcR()
  {
    AppMethodBeat.i(244201);
    FinderLbsLoader localFinderLbsLoader = this.tQY;
    if (localFinderLbsLoader == null) {
      p.btv("feedLoader");
    }
    AppMethodBeat.o(244201);
    return localFinderLbsLoader;
  }
  
  public final aj.b<com.tencent.mm.plugin.finder.model.c> dcS()
  {
    AppMethodBeat.i(244202);
    aj.b localb = this.tQZ;
    if (localb == null) {
      p.btv("viewCallback");
    }
    AppMethodBeat.o(244202);
    return localb;
  }
  
  public final void onActionbarClick(boolean paramBoolean)
  {
    AppMethodBeat.i(244209);
    Object localObject1 = this.tQZ;
    if (localObject1 == null) {
      p.btv("viewCallback");
    }
    localObject1 = ((aj.b)localObject1).getRecyclerView();
    if (localObject1 == null)
    {
      AppMethodBeat.o(244209);
      return;
    }
    int i = findFirstPosition((RecyclerView)localObject1);
    Log.i("Finder.FinderTimelineLbsMixPresenter", "[onActionbarClick] position=" + i + " isDouble=" + paramBoolean);
    Object localObject2;
    if (i <= 12)
    {
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
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
      localObject2 = k.vfA;
      k.a(((FinderReporterUIC)localObject1).dIx(), 5);
      AppMethodBeat.o(244209);
      return;
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      break;
      label298:
      ED(600L);
    }
    label308:
    AppMethodBeat.o(244209);
    return;
    label315:
    localObject1 = FinderReporterUIC.wzC;
    localObject1 = FinderReporterUIC.a.fH((Context)this.activity);
    if (localObject1 != null)
    {
      localObject2 = k.vfA;
      k.a(((FinderReporterUIC)localObject1).dIx(), 1);
      AppMethodBeat.o(244209);
      return;
    }
    AppMethodBeat.o(244209);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(244211);
    Object localObject = this.tQY;
    if (localObject == null) {
      p.btv("feedLoader");
    }
    ((FinderLbsLoader)localObject).unregister(this.tagViewActionCallback);
    localObject = com.tencent.mm.ui.component.a.PRN;
    ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Mp(1000);
    AppMethodBeat.o(244211);
  }
  
  public final void onLoadMore()
  {
    AppMethodBeat.i(244205);
    FinderLbsLoader localFinderLbsLoader = this.tQY;
    if (localFinderLbsLoader == null) {
      p.btv("feedLoader");
    }
    localFinderLbsLoader.requestLoadMore();
    AppMethodBeat.o(244205);
  }
  
  public final void onRefresh()
  {
    AppMethodBeat.i(244203);
    com.tencent.mm.plugin.finder.utils.l locall = com.tencent.mm.plugin.finder.utils.l.vVE;
    com.tencent.mm.plugin.finder.utils.l.a((kotlin.g.a.a)new h(this), (kotlin.g.a.a)new i(this), (kotlin.g.a.a)new j(this));
    AppMethodBeat.o(244203);
  }
  
  public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(244204);
    p.h(paramc, "reason");
    this.tRa = com.tencent.mm.model.cl.aWA();
    Object localObject1;
    Object localObject2;
    if (paramc.Rmk <= 0)
    {
      localObject1 = this.tQZ;
      if (localObject1 == null) {
        p.btv("viewCallback");
      }
      localObject1 = ((aj.b)localObject1).dcQ();
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        ((RefreshLoadMoreLayout)localObject1).b(com.tencent.mm.plugin.finder.storage.c.dsb(), (kotlin.g.a.a)ak.k.tRj);
      }
    }
    if (paramc.Rmj)
    {
      localObject1 = this.tQZ;
      if (localObject1 == null) {
        p.btv("viewCallback");
      }
      localObject1 = ((aj.b)localObject1).dcQ();
      if ((localObject1 != null) && (!((RefreshLoadMoreLayout)localObject1).RlV))
      {
        localObject1 = this.tQZ;
        if (localObject1 == null) {
          p.btv("viewCallback");
        }
        localObject1 = ((aj.b)localObject1).dcQ();
        if (localObject1 != null) {
          ((RefreshLoadMoreLayout)localObject1).setHasBottomMore(true);
        }
      }
      localObject1 = this.tQZ;
      if (localObject1 == null) {
        p.btv("viewCallback");
      }
      localObject1 = ((aj.b)localObject1).dcQ();
      if ((localObject1 != null) && (!((RefreshLoadMoreLayout)localObject1).getEnableLoadMore()))
      {
        localObject1 = this.tQZ;
        if (localObject1 == null) {
          p.btv("viewCallback");
        }
        localObject1 = ((aj.b)localObject1).dcQ();
        if (localObject1 != null) {
          ((RefreshLoadMoreLayout)localObject1).setEnableLoadMore(true);
        }
        localObject1 = this.tQZ;
        if (localObject1 == null) {
          p.btv("viewCallback");
        }
        localObject1 = ((aj.b)localObject1).dcQ();
        if (localObject1 != null)
        {
          localObject2 = aa.jQ((Context)this.activity).inflate(2131495297, null);
          p.g(localObject2, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
          ((RefreshLoadMoreLayout)localObject1).setLoadMoreFooter((View)localObject2);
        }
      }
    }
    checkEmptyHeader(paramc);
    AppMethodBeat.o(244204);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(244176);
      this.$rlLayout.DD(this.$isSilence);
      AppMethodBeat.o(244176);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(ak paramak, RefreshLoadMoreLayout.c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class d
    implements h
  {
    d(FinderLbsLoader paramFinderLbsLoader, ak paramak) {}
    
    public final void call(int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(244179);
      Log.i(this.tRe.getTAG(), "[initData] canTimelineRefresh=" + ak.c(jdField_this) + ", incrementCount=" + paramInt);
      Object localObject3;
      if (ak.c(jdField_this))
      {
        jdField_this.ED(0L);
        if (paramInt <= 0)
        {
          localObject3 = jdField_this;
          localObject1 = localObject2;
          if (ak.c(jdField_this)) {
            localObject1 = new RefreshLoadMoreLayout.c(0);
          }
          ak.a((ak)localObject3, (RefreshLoadMoreLayout.c)localObject1);
        }
        AppMethodBeat.o(244179);
        return;
      }
      Object localObject1 = ak.d(jdField_this).Mq(1000);
      final int i = ((FinderHomeTabStateVM.a)localObject1).wuf;
      final int j = ((FinderHomeTabStateVM.a)localObject1).wug;
      Log.i(this.tRe.getTAG(), "[initData] canTimelineRefresh " + ak.c(jdField_this) + " lastPos=" + i + " fromTopPixel=" + j);
      localObject1 = jdField_this.dcS().getRecyclerView();
      if (localObject1 != null) {}
      for (localObject1 = ((RecyclerView)localObject1).getLayoutManager();; localObject1 = null)
      {
        ak.a(jdField_this, j);
        if (!(localObject1 instanceof StaggeredGridLayoutManager)) {
          break;
        }
        ((StaggeredGridLayoutManager)localObject1).ah(i, j);
        localObject3 = jdField_this.dcS().getRecyclerView();
        if (localObject3 == null) {
          break;
        }
        ((RecyclerView)localObject3).post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(244178);
            ((StaggeredGridLayoutManager)this.$layoutManager).ah(i, j);
            AppMethodBeat.o(244178);
          }
        });
        break;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$1$2"})
  static final class e
    extends q
    implements kotlin.g.a.b<IResponse<com.tencent.mm.plugin.finder.model.c>, x>
  {
    e(ak paramak)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(244182);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(244182);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(244181);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = this.tRd;
      ak.a(paramRecyclerView, ak.e(paramRecyclerView) - paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(244181);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$4", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecordListener;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "onExposeTimeRecorded", "", "recordsSet", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "plugin-finder_release"})
  public static final class g
    extends com.tencent.mm.view.recyclerview.d<com.tencent.mm.view.recyclerview.a>
  {
    public final void l(Set<com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a>> paramSet)
    {
      AppMethodBeat.i(244183);
      p.h(paramSet, "recordsSet");
      Log.i("Finder.FinderTimelineLbsMixPresenter", "onExposeTimeRecorded: size = " + paramSet.size());
      Object localObject1 = FinderReporterUIC.wzC;
      localObject1 = FinderReporterUIC.a.fH((Context)ak.b(this.tRd));
      if (localObject1 != null) {
        localObject1 = FinderReporterUIC.c((FinderReporterUIC)localObject1);
      }
      while ((localObject1 instanceof ac))
      {
        Object localObject2 = (Iterable)paramSet;
        paramSet = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = ((Iterator)localObject2).next();
            if ((((com.tencent.mm.view.recyclerview.b)localObject3).RqA instanceof com.tencent.mm.plugin.finder.model.c))
            {
              paramSet.add(localObject3);
              continue;
              localObject1 = null;
              break;
            }
          }
        }
        paramSet = (List)paramSet;
        ((ac)localObject1).e(paramSet, ak.f(this.tRd));
      }
      AppMethodBeat.o(244183);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(ak paramak)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    i(ak paramak)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<x>
  {
    j(ak paramak)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class l
    implements j
  {
    private WxRecyclerAdapter<?> getAdapter()
    {
      AppMethodBeat.i(244192);
      Object localObject1 = this.tRd.dcS().getRecyclerView();
      if (localObject1 != null) {}
      for (localObject1 = ((RecyclerView)localObject1).getAdapter();; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (!(localObject1 instanceof WxRecyclerAdapter)) {
          localObject2 = null;
        }
        localObject1 = (WxRecyclerAdapter)localObject2;
        AppMethodBeat.o(244192);
        return localObject1;
      }
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(244193);
      Object localObject = this.tRd.dcS();
      if (localObject != null)
      {
        localObject = ((aj.b)localObject).dcQ();
        if (localObject != null) {
          ((RefreshLoadMoreLayout)localObject).onChanged();
        }
      }
      ak.a(this.tRd);
      AppMethodBeat.o(244193);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(244194);
      Object localObject = this.tRd.dcS();
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
            AppMethodBeat.o(244194);
            return;
          }
        }
      }
      AppMethodBeat.o(244194);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(244195);
      Object localObject = this.tRd.dcS();
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
            AppMethodBeat.o(244195);
            return;
          }
        }
      }
      AppMethodBeat.o(244195);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(244196);
      Object localObject = this.tRd.dcS();
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
            AppMethodBeat.o(244196);
            return;
          }
        }
      }
      AppMethodBeat.o(244196);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(244197);
      Object localObject = this.tRd.dcS();
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
            AppMethodBeat.o(244197);
            return;
          }
        }
      }
      AppMethodBeat.o(244197);
    }
    
    public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(244199);
      p.h(paramc, "reason");
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.tRd.dcS().dcQ();
      if (localRefreshLoadMoreLayout != null)
      {
        localRefreshLoadMoreLayout.onPreFinishLoadMore(paramc);
        AppMethodBeat.o(244199);
        return;
      }
      AppMethodBeat.o(244199);
    }
    
    public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(244200);
      p.h(paramc, "reason");
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.tRd.dcS().dcQ();
      if (localRefreshLoadMoreLayout != null)
      {
        localRefreshLoadMoreLayout.onPreFinishLoadMoreSmooth(paramc);
        AppMethodBeat.o(244200);
        return;
      }
      AppMethodBeat.o(244200);
    }
    
    public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(244198);
      p.h(paramc, "reason");
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.tRd.dcS().dcQ();
      if (localRefreshLoadMoreLayout != null)
      {
        localRefreshLoadMoreLayout.onPreFinishRefresh(paramc);
        AppMethodBeat.o(244198);
        return;
      }
      AppMethodBeat.o(244198);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ak
 * JD-Core Version:    0.7.0.1
 */