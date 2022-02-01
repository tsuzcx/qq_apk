package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.dc;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.ag;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.viewmodel.b.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", "canTimelineRefresh", "", "emptyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;)V", "isEmptyLocation", "isRequestingLbs", "()Z", "setRequestingLbs", "(Z)V", "refreshTime", "", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "isSilence", "checkEmptyHeader", "r", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "findFirstPosition", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "onActionbarClick", "isDouble", "onAttach", "callback", "onClickReport", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLbsCardActionReportStruct;", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "feedIndex", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "onUserVisibleFocused", "Companion", "plugin-finder_release"})
public final class as
  implements ar.a<com.tencent.mm.plugin.finder.model.c>
{
  public static final a xBU;
  public final MMActivity activity;
  private final boolean canTimelineRefresh;
  private com.tencent.mm.plugin.finder.model.g emptyData;
  public boolean isEmptyLocation;
  boolean isRequestingLbs;
  private com.tencent.mm.view.j tagViewActionCallback;
  public final com.tencent.mm.plugin.finder.viewmodel.b tlCache;
  public int totalDy;
  public FinderLbsLoader xBQ;
  public ar.b<com.tencent.mm.plugin.finder.model.c> xBR;
  private long xBS;
  private final FinderHomeTabFragment xBT;
  
  static
  {
    AppMethodBeat.i(288789);
    xBU = new a((byte)0);
    AppMethodBeat.o(288789);
  }
  
  public as(MMActivity paramMMActivity, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(288788);
    this.activity = paramMMActivity;
    this.xBT = paramFinderHomeTabFragment;
    paramMMActivity = com.tencent.mm.ui.component.g.Xox;
    paramMMActivity = com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class);
    kotlin.g.b.p.j(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.tlCache = ((com.tencent.mm.plugin.finder.viewmodel.b)paramMMActivity);
    this.canTimelineRefresh = this.tlCache.OO(1000);
    this.xBS = -1L;
    this.emptyData = new com.tencent.mm.plugin.finder.model.g();
    this.tagViewActionCallback = ((com.tencent.mm.view.j)new l(this));
    AppMethodBeat.o(288788);
  }
  
  private final void checkEmptyHeader(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(288785);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this, paramc));
    AppMethodBeat.o(288785);
  }
  
  public static int findFirstPosition(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(288783);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    int i;
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      int[] arrayOfInt = new int[2];
      ((StaggeredGridLayoutManager)paramRecyclerView).k(arrayOfInt);
      i = arrayOfInt[1];
      AppMethodBeat.o(288783);
      return i;
    }
    if ((paramRecyclerView instanceof LinearLayoutManager))
    {
      i = ((LinearLayoutManager)paramRecyclerView).kJ();
      AppMethodBeat.o(288783);
      return i;
    }
    AppMethodBeat.o(288783);
    return 0;
  }
  
  public final void KT(long paramLong)
  {
    AppMethodBeat.i(288781);
    Object localObject = this.xBR;
    if (localObject == null) {
      kotlin.g.b.p.bGy("viewCallback");
    }
    localObject = ((ar.b)localObject).dtq();
    if (localObject != null)
    {
      ((RefreshLoadMoreLayout)localObject).postDelayed((Runnable)new b((RefreshLoadMoreLayout)localObject), paramLong);
      AppMethodBeat.o(288781);
      return;
    }
    AppMethodBeat.o(288781);
  }
  
  public final void a(dc paramdc, com.tencent.mm.plugin.finder.storage.p paramp, int paramInt)
  {
    AppMethodBeat.i(288787);
    kotlin.g.b.p.k(paramdc, "struct");
    kotlin.g.b.p.k(paramp, "lbsItem");
    Object localObject = aj.Bnu;
    localObject = aj.a.fZ((Context)this.activity);
    if (localObject != null) {}
    for (localObject = aj.c((aj)localObject);; localObject = null)
    {
      if ((localObject instanceof ag))
      {
        paramdc.hn(this.xBS);
        localObject = (ag)localObject;
        kotlin.g.b.p.k(paramdc, "struct");
        kotlin.g.b.p.k(paramp, "lbsItem");
        paramdc = (dc)ag.a((com.tencent.mm.plugin.report.a)((ag)localObject).b((com.tencent.mm.plugin.report.a)paramdc), paramp);
        if ((paramInt >= 0) && (paramInt < paramp.Alp.size()))
        {
          paramdc.hr(paramInt);
          localObject = (com.tencent.mm.plugin.report.a)paramdc;
          paramp = paramp.Alp.get(paramInt);
          kotlin.g.b.p.j(paramp, "lbsItem.feedList[feedIndex]");
          ag.a((com.tencent.mm.plugin.report.a)localObject, (BaseFinderFeed)paramp);
        }
        paramdc.bpa();
      }
      AppMethodBeat.o(288787);
      return;
    }
  }
  
  public final void a(ar.b<com.tencent.mm.plugin.finder.model.c> paramb)
  {
    AppMethodBeat.i(288778);
    kotlin.g.b.p.k(paramb, "callback");
    this.xBS = cm.bfE();
    this.xBR = paramb;
    paramb = com.tencent.mm.ui.component.g.Xox;
    paramb = new FinderLbsLoader(((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.activity).i(aj.class)).ekY());
    paramb.setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.j)new d(paramb, this));
    paramb.fetchEndCallback = ((kotlin.g.a.b)new e(this));
    this.xBQ = paramb;
    paramb = this.xBR;
    if (paramb == null) {
      kotlin.g.b.p.bGy("viewCallback");
    }
    FinderLbsLoader localFinderLbsLoader = this.xBQ;
    if (localFinderLbsLoader == null) {
      kotlin.g.b.p.bGy("feedLoader");
    }
    paramb.ab((ArrayList)localFinderLbsLoader.getDataListJustForAdapter());
    paramb = this.xBQ;
    if (paramb == null) {
      kotlin.g.b.p.bGy("feedLoader");
    }
    paramb.register(this.tagViewActionCallback);
    paramb = com.tencent.mm.plugin.finder.utils.q.ADH;
    if (com.tencent.mm.plugin.finder.utils.q.edb())
    {
      this.tlCache.RI(1000).Bgx.size();
      paramb = this.xBQ;
      if (paramb == null) {
        kotlin.g.b.p.bGy("feedLoader");
      }
      paramb.requestInit(false);
      paramb = this.xBR;
      if (paramb == null) {
        kotlin.g.b.p.bGy("viewCallback");
      }
      paramb = paramb.getRecyclerView();
      if (paramb != null) {
        paramb.a((RecyclerView.l)new f(this));
      }
    }
    for (;;)
    {
      paramb = this.xBR;
      if (paramb == null) {
        kotlin.g.b.p.bGy("viewCallback");
      }
      paramb = paramb.getRecyclerView();
      if (paramb == null) {
        break;
      }
      com.tencent.mm.view.recyclerview.c.a(paramb, (com.tencent.mm.view.recyclerview.d)new g(this));
      AppMethodBeat.o(288778);
      return;
      paramb = new RefreshLoadMoreLayout.c(0);
      paramb.YND = -2;
      checkEmptyHeader(paramb);
    }
    AppMethodBeat.o(288778);
  }
  
  public final FinderLbsLoader dtt()
  {
    AppMethodBeat.i(288773);
    FinderLbsLoader localFinderLbsLoader = this.xBQ;
    if (localFinderLbsLoader == null) {
      kotlin.g.b.p.bGy("feedLoader");
    }
    AppMethodBeat.o(288773);
    return localFinderLbsLoader;
  }
  
  public final ar.b<com.tencent.mm.plugin.finder.model.c> dtu()
  {
    AppMethodBeat.i(288774);
    ar.b localb = this.xBR;
    if (localb == null) {
      kotlin.g.b.p.bGy("viewCallback");
    }
    AppMethodBeat.o(288774);
    return localb;
  }
  
  public final void onActionbarClick(boolean paramBoolean)
  {
    AppMethodBeat.i(288782);
    Object localObject1 = this.xBR;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("viewCallback");
    }
    localObject1 = ((ar.b)localObject1).getRecyclerView();
    if (localObject1 == null)
    {
      AppMethodBeat.o(288782);
      return;
    }
    int i = findFirstPosition((RecyclerView)localObject1);
    Log.i("Finder.FinderTimelineLbsMixPresenter", "[onActionbarClick] position=" + i + " isDouble=" + paramBoolean);
    Object localObject2;
    if (i <= 12)
    {
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      if (!paramBoolean) {
        break label315;
      }
      if (i > 12) {
        break label298;
      }
      KT(20L);
    }
    for (;;)
    {
      localObject1 = aj.Bnu;
      localObject1 = aj.a.fZ((Context)this.activity);
      if (localObject1 == null) {
        break label308;
      }
      localObject2 = n.zWF;
      n.b(((aj)localObject1).ekY(), 5);
      AppMethodBeat.o(288782);
      return;
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      break;
      label298:
      KT(600L);
    }
    label308:
    AppMethodBeat.o(288782);
    return;
    label315:
    localObject1 = aj.Bnu;
    localObject1 = aj.a.fZ((Context)this.activity);
    if (localObject1 != null)
    {
      localObject2 = n.zWF;
      n.b(((aj)localObject1).ekY(), 1);
      AppMethodBeat.o(288782);
      return;
    }
    AppMethodBeat.o(288782);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(288784);
    Object localObject = this.xBQ;
    if (localObject == null) {
      kotlin.g.b.p.bGy("feedLoader");
    }
    ((FinderLbsLoader)localObject).unregister(this.tagViewActionCallback);
    localObject = com.tencent.mm.ui.component.g.Xox;
    ((com.tencent.mm.plugin.finder.viewmodel.b)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class)).RH(1000);
    AppMethodBeat.o(288784);
  }
  
  public final void onLoadMore()
  {
    AppMethodBeat.i(288777);
    FinderLbsLoader localFinderLbsLoader = this.xBQ;
    if (localFinderLbsLoader == null) {
      kotlin.g.b.p.bGy("feedLoader");
    }
    localFinderLbsLoader.requestLoadMore();
    AppMethodBeat.o(288777);
  }
  
  public final void onRefresh()
  {
    AppMethodBeat.i(288775);
    com.tencent.mm.plugin.finder.utils.q localq = com.tencent.mm.plugin.finder.utils.q.ADH;
    com.tencent.mm.plugin.finder.utils.q.a((kotlin.g.a.a)new h(this), (kotlin.g.a.a)new i(this), (kotlin.g.a.a)new j(this));
    AppMethodBeat.o(288775);
  }
  
  public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(288776);
    kotlin.g.b.p.k(paramc, "reason");
    this.xBS = cm.bfE();
    Object localObject1;
    Object localObject2;
    if (paramc.YNG <= 0)
    {
      localObject1 = this.xBR;
      if (localObject1 == null) {
        kotlin.g.b.p.bGy("viewCallback");
      }
      localObject1 = ((ar.b)localObject1).dtq();
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
        ((RefreshLoadMoreLayout)localObject1).c(com.tencent.mm.plugin.finder.storage.d.dTq(), (kotlin.g.a.a)as.k.xCb);
      }
    }
    if (paramc.YNF)
    {
      localObject1 = this.xBR;
      if (localObject1 == null) {
        kotlin.g.b.p.bGy("viewCallback");
      }
      localObject1 = ((ar.b)localObject1).dtq();
      if ((localObject1 != null) && (!((RefreshLoadMoreLayout)localObject1).YNq))
      {
        localObject1 = this.xBR;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("viewCallback");
        }
        localObject1 = ((ar.b)localObject1).dtq();
        if (localObject1 != null) {
          ((RefreshLoadMoreLayout)localObject1).setHasBottomMore(true);
        }
      }
      localObject1 = this.xBR;
      if (localObject1 == null) {
        kotlin.g.b.p.bGy("viewCallback");
      }
      localObject1 = ((ar.b)localObject1).dtq();
      if ((localObject1 != null) && (!((RefreshLoadMoreLayout)localObject1).getEnableLoadMore()))
      {
        localObject1 = this.xBR;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("viewCallback");
        }
        localObject1 = ((ar.b)localObject1).dtq();
        if (localObject1 != null) {
          ((RefreshLoadMoreLayout)localObject1).setEnableLoadMore(true);
        }
        localObject1 = this.xBR;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("viewCallback");
        }
        localObject1 = ((ar.b)localObject1).dtq();
        if (localObject1 != null)
        {
          localObject2 = ad.kS((Context)this.activity).inflate(b.g.load_more_footer, null);
          kotlin.g.b.p.j(localObject2, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
          ((RefreshLoadMoreLayout)localObject1).setLoadMoreFooter((View)localObject2);
        }
      }
    }
    checkEmptyHeader(paramc);
    AppMethodBeat.o(288776);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(242940);
      this.$rlLayout.Id(this.$isSilence);
      AppMethodBeat.o(242940);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(as paramas, RefreshLoadMoreLayout.c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    d(FinderLbsLoader paramFinderLbsLoader, as paramas) {}
    
    public final void call(int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(225741);
      Log.i(this.xBW.getTAG(), "[initData] canTimelineRefresh=" + as.c(jdField_this) + ", incrementCount=" + paramInt);
      Object localObject3;
      if (as.c(jdField_this))
      {
        jdField_this.KT(0L);
        if (paramInt <= 0)
        {
          localObject3 = jdField_this;
          localObject1 = localObject2;
          if (as.c(jdField_this)) {
            localObject1 = new RefreshLoadMoreLayout.c(0);
          }
          as.a((as)localObject3, (RefreshLoadMoreLayout.c)localObject1);
        }
        AppMethodBeat.o(225741);
        return;
      }
      Object localObject1 = as.d(jdField_this).RI(1000);
      final int i = ((b.a)localObject1).Bgy;
      final int j = ((b.a)localObject1).Bgz;
      Log.i(this.xBW.getTAG(), "[initData] canTimelineRefresh " + as.c(jdField_this) + " lastPos=" + i + " fromTopPixel=" + j);
      localObject1 = jdField_this.dtu().getRecyclerView();
      if (localObject1 != null) {}
      for (localObject1 = ((RecyclerView)localObject1).getLayoutManager();; localObject1 = null)
      {
        as.a(jdField_this, j);
        if (!(localObject1 instanceof StaggeredGridLayoutManager)) {
          break;
        }
        ((StaggeredGridLayoutManager)localObject1).au(i, j);
        localObject3 = jdField_this.dtu().getRecyclerView();
        if (localObject3 == null) {
          break;
        }
        ((RecyclerView)localObject3).post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(288520);
            ((StaggeredGridLayoutManager)this.$layoutManager).au(i, j);
            AppMethodBeat.o(288520);
          }
        });
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$1$2"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<IResponse<com.tencent.mm.plugin.finder.model.c>, x>
  {
    e(as paramas)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(223743);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(223743);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(223734);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = this.xBV;
      as.a(paramRecyclerView, as.e(paramRecyclerView) - paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(223734);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$4", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecordListener;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "onExposeTimeRecorded", "", "recordsSet", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "plugin-finder_release"})
  public static final class g
    extends com.tencent.mm.view.recyclerview.d<com.tencent.mm.view.recyclerview.a>
  {
    public final void l(Set<com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a>> paramSet)
    {
      AppMethodBeat.i(267948);
      kotlin.g.b.p.k(paramSet, "recordsSet");
      Log.i("Finder.FinderTimelineLbsMixPresenter", "onExposeTimeRecorded: size = " + paramSet.size());
      Object localObject1 = aj.Bnu;
      localObject1 = aj.a.fZ((Context)as.b(this.xBV));
      if (localObject1 != null) {
        localObject1 = aj.c((aj)localObject1);
      }
      while ((localObject1 instanceof ag))
      {
        Object localObject2 = (Iterable)paramSet;
        paramSet = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = ((Iterator)localObject2).next();
            if ((((com.tencent.mm.view.recyclerview.b)localObject3).YRY instanceof com.tencent.mm.plugin.finder.model.c))
            {
              paramSet.add(localObject3);
              continue;
              localObject1 = null;
              break;
            }
          }
        }
        paramSet = (List)paramSet;
        ((ag)localObject1).d(paramSet, as.f(this.xBV));
      }
      AppMethodBeat.o(267948);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    h(as paramas)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    i(as paramas)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    j(as paramas)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class l
    implements com.tencent.mm.view.j
  {
    private WxRecyclerAdapter<?> getAdapter()
    {
      AppMethodBeat.i(278643);
      Object localObject1 = this.xBV.dtu().getRecyclerView();
      if (localObject1 != null) {}
      for (localObject1 = ((RecyclerView)localObject1).getAdapter();; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (!(localObject1 instanceof WxRecyclerAdapter)) {
          localObject2 = null;
        }
        localObject1 = (WxRecyclerAdapter)localObject2;
        AppMethodBeat.o(278643);
        return localObject1;
      }
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(278644);
      Object localObject = this.xBV.dtu();
      if (localObject != null)
      {
        localObject = ((ar.b)localObject).dtq();
        if (localObject != null) {
          ((RefreshLoadMoreLayout)localObject).onChanged();
        }
      }
      as.a(this.xBV);
      AppMethodBeat.o(278644);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(278645);
      Object localObject = this.xBV.dtu();
      if (localObject != null)
      {
        localObject = ((ar.b)localObject).dtq();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.YSk.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeChanged(i + paramInt1, paramInt2);
            AppMethodBeat.o(278645);
            return;
          }
        }
      }
      AppMethodBeat.o(278645);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(278646);
      Object localObject = this.xBV.dtu();
      if (localObject != null)
      {
        localObject = ((ar.b)localObject).dtq();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.YSk.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeChanged(i + paramInt1, paramInt2, paramObject);
            AppMethodBeat.o(278646);
            return;
          }
        }
      }
      AppMethodBeat.o(278646);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(278647);
      Object localObject = this.xBV.dtu();
      if (localObject != null)
      {
        localObject = ((ar.b)localObject).dtq();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.YSk.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeInserted(i + paramInt1, paramInt2);
            AppMethodBeat.o(278647);
            return;
          }
        }
      }
      AppMethodBeat.o(278647);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(278648);
      Object localObject = this.xBV.dtu();
      if (localObject != null)
      {
        localObject = ((ar.b)localObject).dtq();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.YSk.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeRemoved(i + paramInt1, paramInt2);
            AppMethodBeat.o(278648);
            return;
          }
        }
      }
      AppMethodBeat.o(278648);
    }
    
    public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(278650);
      kotlin.g.b.p.k(paramc, "reason");
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.xBV.dtu().dtq();
      if (localRefreshLoadMoreLayout != null)
      {
        localRefreshLoadMoreLayout.onPreFinishLoadMore(paramc);
        AppMethodBeat.o(278650);
        return;
      }
      AppMethodBeat.o(278650);
    }
    
    public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(278651);
      kotlin.g.b.p.k(paramc, "reason");
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.xBV.dtu().dtq();
      if (localRefreshLoadMoreLayout != null)
      {
        localRefreshLoadMoreLayout.onPreFinishLoadMoreSmooth(paramc);
        AppMethodBeat.o(278651);
        return;
      }
      AppMethodBeat.o(278651);
    }
    
    public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(278649);
      kotlin.g.b.p.k(paramc, "reason");
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.xBV.dtu().dtq();
      if (localRefreshLoadMoreLayout != null)
      {
        localRefreshLoadMoreLayout.onPreFinishRefresh(paramc);
        AppMethodBeat.o(278649);
        return;
      }
      AppMethodBeat.o(278649);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.as
 * JD-Core Version:    0.7.0.1
 */