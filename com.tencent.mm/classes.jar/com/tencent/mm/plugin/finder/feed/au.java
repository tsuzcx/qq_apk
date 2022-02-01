package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.dc;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.l;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.viewmodel.b.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", "canTimelineRefresh", "", "emptyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "isEmptyLocation", "isRequestingLbs", "()Z", "setRequestingLbs", "(Z)V", "msgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "checkEmptyHeader", "r", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "findFirstPosition", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "notifyChanged", "rv", "itemId", "onActionbarClick", "isDouble", "onAttach", "callback", "onClickReport", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLbsCardActionReportStruct;", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "feedIndex", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "onUserVisibleFocused", "refreshMsgNotify", "refreshRV", "data", "Landroid/content/Intent;", "Companion", "plugin-finder_release"})
public final class au
  implements ar.a<bu>
{
  public static final b xCh;
  public final MMActivity activity;
  private final boolean canTimelineRefresh;
  private com.tencent.mm.plugin.finder.model.g emptyData;
  public boolean isEmptyLocation;
  boolean isRequestingLbs;
  private final com.tencent.mm.plugin.finder.model.h msgNotifyData;
  private com.tencent.mm.view.j tagViewActionCallback;
  public final com.tencent.mm.plugin.finder.viewmodel.b tlCache;
  public int totalDy;
  public ar.b<bu> xBR;
  private final FinderHomeTabFragment xBT;
  public final FinderTimelineFeedLoader xCg;
  
  static
  {
    AppMethodBeat.i(284258);
    xCh = new b((byte)0);
    AppMethodBeat.o(284258);
  }
  
  public au(MMActivity paramMMActivity, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(284257);
    this.activity = paramMMActivity;
    this.xBT = paramFinderHomeTabFragment;
    paramMMActivity = com.tencent.mm.ui.component.g.Xox;
    paramMMActivity = com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class);
    kotlin.g.b.p.j(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.tlCache = ((com.tencent.mm.plugin.finder.viewmodel.b)paramMMActivity);
    this.canTimelineRefresh = this.tlCache.OO(2);
    paramMMActivity = com.tencent.mm.plugin.finder.feed.model.internal.g.xKI;
    paramMMActivity = com.tencent.mm.plugin.finder.feed.model.internal.g.a.MG(2);
    if (this.canTimelineRefresh) {}
    for (int i = 0;; i = 1)
    {
      paramFinderHomeTabFragment = com.tencent.mm.ui.component.g.Xox;
      paramMMActivity = new FinderTimelineFeedLoader(paramMMActivity, i, ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.activity).i(aj.class)).ekY());
      paramMMActivity.setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.j)new a(paramMMActivity, this));
      this.xCg = paramMMActivity;
      this.tagViewActionCallback = ((com.tencent.mm.view.j)new n(this));
      this.emptyData = new com.tencent.mm.plugin.finder.model.g();
      this.msgNotifyData = new com.tencent.mm.plugin.finder.model.h();
      AppMethodBeat.o(284257);
      return;
    }
  }
  
  private final void checkEmptyHeader(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(284250);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this, paramc));
    AppMethodBeat.o(284250);
  }
  
  public static int findFirstPosition(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(284253);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    int i;
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      int[] arrayOfInt = new int[2];
      ((StaggeredGridLayoutManager)paramRecyclerView).k(arrayOfInt);
      i = arrayOfInt[1];
      AppMethodBeat.o(284253);
      return i;
    }
    if ((paramRecyclerView instanceof LinearLayoutManager))
    {
      i = ((LinearLayoutManager)paramRecyclerView).kJ();
      AppMethodBeat.o(284253);
      return i;
    }
    AppMethodBeat.o(284253);
    return 0;
  }
  
  public final void KT(long paramLong)
  {
    AppMethodBeat.i(284251);
    Object localObject = this.xBR;
    if (localObject == null) {
      kotlin.g.b.p.bGy("viewCallback");
    }
    localObject = ((ar.b)localObject).dtq();
    if (localObject != null)
    {
      ((RefreshLoadMoreLayout)localObject).postDelayed((Runnable)new c((RefreshLoadMoreLayout)localObject), paramLong);
      AppMethodBeat.o(284251);
      return;
    }
    AppMethodBeat.o(284251);
  }
  
  public final void a(dc paramdc, com.tencent.mm.plugin.finder.storage.p paramp, int paramInt)
  {
    AppMethodBeat.i(284255);
    kotlin.g.b.p.k(paramdc, "struct");
    kotlin.g.b.p.k(paramp, "lbsItem");
    AppMethodBeat.o(284255);
  }
  
  public final void a(ar.b<bu> paramb)
  {
    AppMethodBeat.i(284247);
    kotlin.g.b.p.k(paramb, "callback");
    this.xBR = paramb;
    paramb = this.xBR;
    if (paramb == null) {
      kotlin.g.b.p.bGy("viewCallback");
    }
    paramb.ab((ArrayList)this.xCg.getDataListJustForAdapter());
    this.xCg.register(this.tagViewActionCallback);
    paramb = com.tencent.mm.plugin.finder.utils.q.ADH;
    if (com.tencent.mm.plugin.finder.utils.q.edb())
    {
      this.tlCache.RI(2).Bgw.size();
      BaseFeedLoader.requestInit$default(this.xCg, false, 1, null);
      paramb = this.xBR;
      if (paramb == null) {
        kotlin.g.b.p.bGy("viewCallback");
      }
      paramb = paramb.getRecyclerView();
      if (paramb != null)
      {
        paramb.a((RecyclerView.l)new g(this));
        AppMethodBeat.o(284247);
        return;
      }
      AppMethodBeat.o(284247);
      return;
    }
    paramb = new RefreshLoadMoreLayout.c(0);
    paramb.YND = -2;
    checkEmptyHeader(paramb);
    AppMethodBeat.o(284247);
  }
  
  public final ar.b<bu> dtu()
  {
    AppMethodBeat.i(284243);
    ar.b localb = this.xBR;
    if (localb == null) {
      kotlin.g.b.p.bGy("viewCallback");
    }
    AppMethodBeat.o(284243);
    return localb;
  }
  
  public final void onActionbarClick(boolean paramBoolean)
  {
    AppMethodBeat.i(284252);
    Object localObject1 = this.xBR;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("viewCallback");
    }
    localObject1 = ((ar.b)localObject1).getRecyclerView();
    if (localObject1 == null)
    {
      AppMethodBeat.o(284252);
      return;
    }
    int i = findFirstPosition((RecyclerView)localObject1);
    Log.i("Finder.TimelineLbsPresenter", "[onActionbarClick] position=" + i + " isDouble=" + paramBoolean);
    Object localObject2;
    if (i <= 12)
    {
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
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
      AppMethodBeat.o(284252);
      return;
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      break;
      label298:
      KT(600L);
    }
    label308:
    AppMethodBeat.o(284252);
    return;
    label315:
    localObject1 = aj.Bnu;
    localObject1 = aj.a.fZ((Context)this.activity);
    if (localObject1 != null)
    {
      localObject2 = n.zWF;
      n.b(((aj)localObject1).ekY(), 1);
      AppMethodBeat.o(284252);
      return;
    }
    AppMethodBeat.o(284252);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(284254);
    this.xCg.unregister(this.tagViewActionCallback);
    com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
    ((com.tencent.mm.plugin.finder.viewmodel.b)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class)).RH(2);
    AppMethodBeat.o(284254);
  }
  
  public final void onLoadMore()
  {
    AppMethodBeat.i(284246);
    this.xCg.requestLoadMore();
    AppMethodBeat.o(284246);
  }
  
  public final void onRefresh()
  {
    AppMethodBeat.i(284244);
    com.tencent.mm.plugin.finder.utils.q localq = com.tencent.mm.plugin.finder.utils.q.ADH;
    com.tencent.mm.plugin.finder.utils.q.a((kotlin.g.a.a)new h(this), (kotlin.g.a.a)new i(this), (kotlin.g.a.a)new j(this));
    AppMethodBeat.o(284244);
  }
  
  public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(284245);
    kotlin.g.b.p.k(paramc, "reason");
    if (paramc.YNG <= 0)
    {
      Object localObject = this.xBR;
      if (localObject == null) {
        kotlin.g.b.p.bGy("viewCallback");
      }
      localObject = ((ar.b)localObject).dtq();
      if (localObject != null)
      {
        com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
        ((RefreshLoadMoreLayout)localObject).c(com.tencent.mm.plugin.finder.storage.d.dTq(), (kotlin.g.a.a)au.k.xCq);
      }
    }
    checkEmptyHeader(paramc);
    paramc = com.tencent.mm.kernel.h.ag(PluginFinder.class);
    kotlin.g.b.p.j(paramc, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramc).getRedDotManager().aBd("finder_tl_nearby_tab");
    paramc = com.tencent.mm.kernel.h.ag(PluginFinder.class);
    kotlin.g.b.p.j(paramc, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramc).getRedDotManager().gW("finder_tl_nearby_tab", "onRefreshEnd");
    paramc = k.yBj;
    k.b(null, s.t.yGM, s.l.yFX.scene, com.tencent.mm.plugin.finder.live.report.c.yAk);
    AppMethodBeat.o(284245);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$feedLoader$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    a(FinderTimelineFeedLoader paramFinderTimelineFeedLoader, au paramau) {}
    
    public final void call(final int paramInt)
    {
      AppMethodBeat.i(272636);
      Log.i(this.xCi.getTAG(), "[initData] canTimelineRefresh=" + au.f(jdField_this) + ", incrementCount=" + paramInt);
      Object localObject;
      if (au.f(jdField_this))
      {
        jdField_this.KT(0L);
        localObject = jdField_this.dtu().dtq();
        if (localObject != null) {
          ((RefreshLoadMoreLayout)localObject).post((Runnable)au.e.xCk);
        }
        localObject = jdField_this.dtu().dtq();
        if (localObject != null)
        {
          ((RefreshLoadMoreLayout)localObject).post((Runnable)au.f.xCl);
          AppMethodBeat.o(272636);
        }
      }
      else
      {
        localObject = au.g(jdField_this).RI(2);
        paramInt = ((b.a)localObject).Bgy;
        final int i = ((b.a)localObject).Bgz;
        Log.i(this.xCi.getTAG(), "[initData] canTimelineRefresh " + au.f(jdField_this) + " lastPos=" + paramInt + " fromTopPixel=" + i);
        localObject = jdField_this.dtu().getRecyclerView();
        if (localObject != null) {}
        for (localObject = ((RecyclerView)localObject).getLayoutManager();; localObject = null)
        {
          au.a(jdField_this, i);
          if (!(localObject instanceof StaggeredGridLayoutManager)) {
            break;
          }
          ((StaggeredGridLayoutManager)localObject).au(paramInt, i);
          RecyclerView localRecyclerView = jdField_this.dtu().getRecyclerView();
          if (localRecyclerView == null) {
            break;
          }
          localRecyclerView.post((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(270910);
              ((StaggeredGridLayoutManager)this.$layoutManager).au(paramInt, i);
              AppMethodBeat.o(270910);
            }
          });
          break;
        }
      }
      AppMethodBeat.o(272636);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(290748);
      this.$rlLayout.Id(this.$isSilence);
      AppMethodBeat.o(290748);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(au paramau, RefreshLoadMoreLayout.c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class g
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(226812);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(226812);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(226809);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = this.xCj;
      au.a((au)localObject, au.b((au)localObject) - paramInt2);
      localObject = k.yBj;
      k.b(paramRecyclerView, s.t.yGM, s.l.yFX.scene, com.tencent.mm.plugin.finder.live.report.c.yAh);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(226809);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    h(au paramau)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    i(au paramau)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    j(au paramau)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public l(au paramau)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "RVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
  public static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.b<bu, Boolean>
  {
    public static final m xCs;
    
    static
    {
      AppMethodBeat.i(286521);
      xCs = new m();
      AppMethodBeat.o(286521);
    }
    
    m()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class n
    implements com.tencent.mm.view.j
  {
    private WxRecyclerAdapter<?> getAdapter()
    {
      AppMethodBeat.i(292081);
      Object localObject1 = this.xCj.dtu();
      if (localObject1 != null)
      {
        localObject1 = ((ar.b)localObject1).getRecyclerView();
        if (localObject1 == null) {}
      }
      for (localObject1 = ((RecyclerView)localObject1).getAdapter();; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (!(localObject1 instanceof WxRecyclerAdapter)) {
          localObject2 = null;
        }
        localObject1 = (WxRecyclerAdapter)localObject2;
        AppMethodBeat.o(292081);
        return localObject1;
      }
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(292082);
      Object localObject = this.xCj.dtu();
      if (localObject != null)
      {
        localObject = ((ar.b)localObject).dtq();
        if (localObject != null)
        {
          ((RefreshLoadMoreLayout)localObject).onChanged();
          AppMethodBeat.o(292082);
          return;
        }
      }
      AppMethodBeat.o(292082);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(292083);
      Object localObject = this.xCj.dtu();
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
            AppMethodBeat.o(292083);
            return;
          }
        }
      }
      AppMethodBeat.o(292083);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(292084);
      Object localObject = this.xCj.dtu();
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
            AppMethodBeat.o(292084);
            return;
          }
        }
      }
      AppMethodBeat.o(292084);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(292085);
      Object localObject = this.xCj.dtu();
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
            AppMethodBeat.o(292085);
            return;
          }
        }
      }
      AppMethodBeat.o(292085);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(292086);
      Object localObject = this.xCj.dtu();
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
            AppMethodBeat.o(292086);
            return;
          }
        }
      }
      AppMethodBeat.o(292086);
    }
    
    public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(292088);
      kotlin.g.b.p.k(paramc, "reason");
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.xCj.dtu().dtq();
      if (localRefreshLoadMoreLayout != null)
      {
        localRefreshLoadMoreLayout.onPreFinishLoadMore(paramc);
        AppMethodBeat.o(292088);
        return;
      }
      AppMethodBeat.o(292088);
    }
    
    public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(292089);
      kotlin.g.b.p.k(paramc, "reason");
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.xCj.dtu().dtq();
      if (localRefreshLoadMoreLayout != null)
      {
        localRefreshLoadMoreLayout.onPreFinishLoadMoreSmooth(paramc);
        AppMethodBeat.o(292089);
        return;
      }
      AppMethodBeat.o(292089);
    }
    
    public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(292087);
      kotlin.g.b.p.k(paramc, "reason");
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.xCj.dtu().dtq();
      if (localRefreshLoadMoreLayout != null)
      {
        localRefreshLoadMoreLayout.onPreFinishRefresh(paramc);
        AppMethodBeat.o(292087);
        return;
      }
      AppMethodBeat.o(292087);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.au
 * JD-Core Version:    0.7.0.1
 */