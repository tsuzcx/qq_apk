package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e.a;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.i;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.view.FinderTagView;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.aoz;
import com.tencent.mm.protocal.protobuf.apa;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "canTimelineRefresh", "", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "headerSearchData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderSearchData;", "headerTagsData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "getHeaderTagsData", "()Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "setHeaderTagsData", "(Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;)V", "msgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "relFeedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "selectedTag", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tagsCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM;", "tagsData", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "findFirstPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "initDataFromCache", "forceCache", "refreshHeader", "initTagHeader", "notifyChanged", "rv", "itemId", "onActionbarClick", "onAttach", "callback", "onCategoryLoadMore", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onUserVisibleFocused", "refreshMsgNotify", "refreshOnCategoryClick", "removeTagFlowView", "scrollToTop", "endCallBack", "Lkotlin/Function0;", "Companion", "plugin-finder_release"})
public final class ar
  implements aq.a
{
  public static final b tRL;
  private final MMActivity activity;
  private final boolean canTimelineRefresh;
  private final com.tencent.mm.plugin.finder.model.h msgNotifyData;
  private IListener<ig> tOh;
  private final FinderFeedRelTimelineLoader tRE;
  public final FinderTagCacheVM tRF;
  public aq.b tRG;
  private final i tRH;
  public apa tRI;
  private bds tRJ;
  private com.tencent.mm.plugin.finder.model.j tRK;
  public final FinderTimelineFeedLoader tRo;
  private com.tencent.mm.view.j tagViewActionCallback;
  public final FinderHomeTabStateVM tlCache;
  public int totalDy;
  
  static
  {
    AppMethodBeat.i(244328);
    tRL = new b((byte)0);
    AppMethodBeat.o(244328);
  }
  
  public ar(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(244327);
    this.activity = paramMMActivity;
    paramMMActivity = com.tencent.mm.plugin.finder.feed.model.internal.e.tYB;
    int i = e.a.IO(4).value;
    paramMMActivity = com.tencent.mm.ui.component.a.PRN;
    this.tRE = new FinderFeedRelTimelineLoader(0L, "", 4, null, i, false, null, null, null, 0, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.activity).get(FinderReporterUIC.class)).dIx(), 4072);
    paramMMActivity = com.tencent.mm.ui.component.a.PRN;
    paramMMActivity = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    p.g(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.tlCache = ((FinderHomeTabStateVM)paramMMActivity);
    paramMMActivity = com.tencent.mm.ui.component.a.PRN;
    paramMMActivity = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTagCacheVM.class);
    p.g(paramMMActivity, "UICProvider.of(PluginFin…erTagCacheVM::class.java)");
    this.tRF = ((FinderTagCacheVM)paramMMActivity);
    this.canTimelineRefresh = this.tlCache.JN(4);
    this.tRH = new i();
    paramMMActivity = com.tencent.mm.plugin.finder.feed.model.internal.e.tYB;
    paramMMActivity = e.a.IO(4);
    if (this.canTimelineRefresh) {}
    for (i = 0;; i = 1)
    {
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
      paramMMActivity = new FinderTimelineFeedLoader(paramMMActivity, i, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.activity).get(FinderReporterUIC.class)).dIx());
      paramMMActivity.setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.h)new a(paramMMActivity, this));
      this.tRo = paramMMActivity;
      this.tagViewActionCallback = ((com.tencent.mm.view.j)new j(this));
      this.tRK = new com.tencent.mm.plugin.finder.model.j(new dmk());
      this.msgNotifyData = new com.tencent.mm.plugin.finder.model.h();
      AppMethodBeat.o(244327);
      return;
    }
  }
  
  public final void F(final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(244324);
    Object localObject = this.tRG;
    if (localObject == null) {
      p.btv("viewCallback");
    }
    localObject = ((aq.b)localObject).getRecyclerView().getLayoutManager();
    if ((localObject instanceof StaggeredGridLayoutManager))
    {
      ((StaggeredGridLayoutManager)localObject).ah(0, 0);
      aq.b localb = this.tRG;
      if (localb == null) {
        p.btv("viewCallback");
      }
      localb.getRecyclerView().post((Runnable)new i((RecyclerView.LayoutManager)localObject, parama));
    }
    AppMethodBeat.o(244324);
  }
  
  public final void a(aq.b paramb)
  {
    AppMethodBeat.i(244322);
    p.h(paramb, "callback");
    this.tRG = paramb;
    aq.b localb = this.tRG;
    if (localb == null) {
      p.btv("viewCallback");
    }
    localb.ab((ArrayList)this.tRo.getDataListJustForAdapter());
    this.tRo.register((com.tencent.mm.view.j)paramb.dcQ());
    this.tRE.register(this.tagViewActionCallback);
    this.tlCache.Mq(4).wuc.size();
    BaseFeedLoader.requestInit$default(this.tRo, false, 1, null);
    this.tRo.tXr = ((kotlin.g.a.b)new d(this));
    paramb = this.tRG;
    if (paramb == null) {
      p.btv("viewCallback");
    }
    paramb.getRecyclerView().a((RecyclerView.l)new e(this));
    this.tOh = ((IListener)new f(this));
    EventCenter.instance.add(this.tOh);
    AppMethodBeat.o(244322);
  }
  
  public final aq.b dcU()
  {
    AppMethodBeat.i(244317);
    aq.b localb = this.tRG;
    if (localb == null) {
      p.btv("viewCallback");
    }
    AppMethodBeat.o(244317);
    return localb;
  }
  
  public final void dcV()
  {
    AppMethodBeat.i(244325);
    if (this.tRI != null)
    {
      Object localObject1 = new dmk();
      ((dmk)localObject1).MPW = new LinkedList();
      Object localObject2 = this.tRI;
      if (localObject2 == null) {
        p.hyc();
      }
      localObject2 = ((apa)localObject2).LBa;
      p.g(localObject2, "tagsData!!.categoryInfo");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        aoz localaoz = (aoz)((Iterator)localObject2).next();
        bds localbds = new bds();
        localbds.dST = localaoz.xjU;
        ((dmk)localObject1).MPW.add(localbds);
      }
      this.tRK.a((dmk)localObject1);
      localObject1 = this.tRG;
      if (localObject1 == null) {
        p.btv("viewCallback");
      }
      com.tencent.mm.view.recyclerview.g.a(((aq.b)localObject1).dcT(), this.tRK.hashCode());
      localObject1 = this.tRG;
      if (localObject1 == null) {
        p.btv("viewCallback");
      }
      localObject1 = ((aq.b)localObject1).getRootView();
      localObject2 = FinderTagView.wpv;
      localObject1 = ((View)localObject1).findViewById(FinderTagView.dHk());
      if (localObject1 != null)
      {
        localObject2 = this.tRG;
        if (localObject2 == null) {
          p.btv("viewCallback");
        }
        localObject2 = ((aq.b)localObject2).getRootView();
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(244325);
          throw ((Throwable)localObject1);
        }
        ((ViewGroup)localObject2).removeView((View)localObject1);
      }
      localObject1 = this.tRG;
      if (localObject1 == null) {
        p.btv("viewCallback");
      }
      com.tencent.mm.view.recyclerview.g.a(((aq.b)localObject1).dcT(), (g.b)this.tRK);
    }
    AppMethodBeat.o(244325);
  }
  
  public final List<g.b> getHeaderInfo()
  {
    AppMethodBeat.i(244321);
    Object localObject1 = new LinkedList();
    Object localObject2 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject2, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.e)localObject2).azQ().getInt(com.tencent.mm.storage.ar.a.Olg, 0);
    localObject2 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject2, "MMKernel.storage()");
    int j = ((com.tencent.mm.kernel.e)localObject2).azQ().getInt(com.tencent.mm.storage.ar.a.Olh, 0);
    localObject2 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject2, "MMKernel.storage()");
    int k = ((com.tencent.mm.kernel.e)localObject2).azQ().getInt(com.tencent.mm.storage.ar.a.Oli, 0);
    localObject2 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject2, "MMKernel.storage()");
    int m = ((com.tencent.mm.kernel.e)localObject2).azQ().getInt(com.tencent.mm.storage.ar.a.Olj, 0);
    localObject2 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject2, "MMKernel.storage()");
    int n = ((com.tencent.mm.kernel.e)localObject2).azQ().getInt(com.tencent.mm.storage.ar.a.Olk, 0);
    this.msgNotifyData.count = (i + j + k + m + n);
    localObject2 = this.msgNotifyData;
    Object localObject3 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject3, "MMKernel.storage()");
    localObject3 = ((com.tencent.mm.kernel.e)localObject3).azQ().get(com.tencent.mm.storage.ar.a.Oll, "");
    if (localObject3 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(244321);
      throw ((Throwable)localObject1);
    }
    ((com.tencent.mm.plugin.finder.model.h)localObject2).setAvatar((String)localObject3);
    ((LinkedList)localObject1).add(this.msgNotifyData);
    ((LinkedList)localObject1).add(this.tRH);
    ((LinkedList)localObject1).add(this.tRK);
    localObject1 = (List)localObject1;
    AppMethodBeat.o(244321);
    return localObject1;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(244326);
    FinderTimelineFeedLoader localFinderTimelineFeedLoader = this.tRo;
    aq.b localb = this.tRG;
    if (localb == null) {
      p.btv("viewCallback");
    }
    localFinderTimelineFeedLoader.unregister((com.tencent.mm.view.j)localb.dcQ());
    EventCenter.instance.removeListener(this.tOh);
    AppMethodBeat.o(244326);
  }
  
  public final void onLoadMore()
  {
    AppMethodBeat.i(244320);
    if (this.tRJ != null)
    {
      Log.d("Finder.TimelineMachinePresenter", "loadMore category feed:" + this.tRJ);
      FinderFeedRelTimelineLoader localFinderFeedRelTimelineLoader = this.tRE;
      Object localObject = this.tRJ;
      if (localObject != null) {}
      for (localObject = ((bds)localObject).dST;; localObject = null)
      {
        localFinderFeedRelTimelineLoader.category = ((String)localObject);
        this.tRE.ttb = 1;
        this.tRE.requestLoadMore();
        AppMethodBeat.o(244320);
        return;
      }
    }
    Log.d("Finder.TimelineMachinePresenter", "loadMore tl feed:");
    this.tRo.requestLoadMore();
    AppMethodBeat.o(244320);
  }
  
  public final void onRefresh()
  {
    AppMethodBeat.i(244318);
    if (this.tRJ != null)
    {
      Log.d("Finder.TimelineMachinePresenter", "refresh category feed:" + this.tRJ);
      FinderFeedRelTimelineLoader localFinderFeedRelTimelineLoader = this.tRE;
      Object localObject = this.tRJ;
      if (localObject != null) {}
      for (localObject = ((bds)localObject).dST;; localObject = null)
      {
        localFinderFeedRelTimelineLoader.category = ((String)localObject);
        this.tRE.ttb = 1;
        this.tRE.requestRefresh();
        AppMethodBeat.o(244318);
        return;
      }
    }
    Log.d("Finder.TimelineMachinePresenter", "refresh tl feed:");
    this.tRo.requestRefresh();
    AppMethodBeat.o(244318);
  }
  
  public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(244319);
    p.h(paramc, "reason");
    if (paramc.Rmk <= 0)
    {
      paramc = this.tRG;
      if (paramc == null) {
        p.btv("viewCallback");
      }
      paramc = paramc.dcQ();
      c localc = c.vCb;
      paramc.b(c.dsb(), (kotlin.g.a.a)ar.g.tRQ);
    }
    AppMethodBeat.o(244319);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$feedLoader$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.plugin.finder.feed.model.internal.h
  {
    a(FinderTimelineFeedLoader paramFinderTimelineFeedLoader, ar paramar) {}
    
    public final void call(final int paramInt)
    {
      AppMethodBeat.i(244295);
      Log.i(this.tRq.getTAG(), "[initData] canTimelineRefresh=" + ar.g(jdField_this) + ", incrementCount=" + paramInt);
      if (ar.g(jdField_this))
      {
        localObject = jdField_this;
        if (paramInt <= 0) {}
        for (boolean bool = true;; bool = false)
        {
          ar.a((ar)localObject, bool);
          AppMethodBeat.o(244295);
          return;
        }
      }
      Object localObject = ar.d(jdField_this).Mq(4);
      paramInt = ((FinderHomeTabStateVM.a)localObject).wuf;
      final int i = ((FinderHomeTabStateVM.a)localObject).wug;
      ar.a(jdField_this, i);
      Log.i(this.tRq.getTAG(), "[initData] canTimelineRefresh " + ar.g(jdField_this) + " lastPos=" + paramInt + " fromTopPixel=" + i);
      RecyclerView.LayoutManager localLayoutManager = jdField_this.dcU().getRecyclerView().getLayoutManager();
      ar localar = jdField_this;
      FinderTagCacheVM.a locala = (FinderTagCacheVM.a)ar.h(jdField_this).wtV.get(Integer.valueOf(4));
      localObject = locala;
      if (locala == null) {
        localObject = new FinderTagCacheVM.a();
      }
      ar.a(localar, ((FinderTagCacheVM.a)localObject).wuT);
      jdField_this.dcV();
      if ((localLayoutManager instanceof StaggeredGridLayoutManager))
      {
        ((StaggeredGridLayoutManager)localLayoutManager).ah(paramInt, i);
        jdField_this.dcU().getRecyclerView().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(244294);
            ((StaggeredGridLayoutManager)this.$layoutManager).ah(paramInt, i);
            AppMethodBeat.o(244294);
          }
        });
      }
      AppMethodBeat.o(244295);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(244296);
      this.$rlLayout.DD(this.$isSilence);
      AppMethodBeat.o(244296);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<IResponse<bo>, x>
  {
    d(ar paramar)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class e
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(244299);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(244299);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(244298);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = this.tRM;
      ar.a(paramRecyclerView, ar.b(paramRecyclerView) - paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(244298);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$3", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class f
    extends IListener<ig>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$3$callback$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(ar.f paramf, ig paramig)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    public h(ar paramar)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(RecyclerView.LayoutManager paramLayoutManager, kotlin.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(244307);
      ((StaggeredGridLayoutManager)this.$layoutManager).ah(0, 0);
      kotlin.g.a.a locala = parama;
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(244307);
        return;
      }
      AppMethodBeat.o(244307);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class j
    implements com.tencent.mm.view.j
  {
    private WxRecyclerAdapter<?> getAdapter()
    {
      AppMethodBeat.i(244308);
      WxRecyclerAdapter localWxRecyclerAdapter = this.tRM.dcU().dcT();
      AppMethodBeat.o(244308);
      return localWxRecyclerAdapter;
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(244309);
      int i = ar.e(this.tRM).getSize();
      ar.e(this.tRM).getDataListJustForAdapter().clear();
      onItemRangeRemoved(0, i);
      ar.e(this.tRM).getDataListJustForAdapter().addAll((Collection)ar.f(this.tRM).getDataListJustForAdapter());
      onItemRangeInserted(0, ar.f(this.tRM).getSize());
      AppMethodBeat.o(244309);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(244310);
      Object localObject = this.tRM.dcU();
      if (localObject != null)
      {
        localObject = ((aq.b)localObject).dcQ();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.RqM.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeChanged(i + paramInt1, paramInt2);
            AppMethodBeat.o(244310);
            return;
          }
        }
      }
      AppMethodBeat.o(244310);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(244311);
      Object localObject = this.tRM.dcU();
      if (localObject != null)
      {
        localObject = ((aq.b)localObject).dcQ();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.RqM.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeChanged(i + paramInt1, paramInt2, paramObject);
            AppMethodBeat.o(244311);
            return;
          }
        }
      }
      AppMethodBeat.o(244311);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(244312);
      Object localObject = this.tRM.dcU();
      if (localObject != null)
      {
        localObject = ((aq.b)localObject).dcQ();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.RqM.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeInserted(i + paramInt1, paramInt2);
            AppMethodBeat.o(244312);
            return;
          }
        }
      }
      AppMethodBeat.o(244312);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(244313);
      Object localObject = this.tRM.dcU();
      if (localObject != null)
      {
        localObject = ((aq.b)localObject).dcQ();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.RqM.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeRemoved(i + paramInt1, paramInt2);
            AppMethodBeat.o(244313);
            return;
          }
        }
      }
      AppMethodBeat.o(244313);
    }
    
    public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(244315);
      p.h(paramc, "reason");
      this.tRM.dcU().dcQ().onPreFinishLoadMore(paramc);
      AppMethodBeat.o(244315);
    }
    
    public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(244316);
      p.h(paramc, "reason");
      this.tRM.dcU().dcQ().onPreFinishLoadMoreSmooth(paramc);
      AppMethodBeat.o(244316);
    }
    
    public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(244314);
      p.h(paramc, "reason");
      this.tRM.dcU().dcQ().onPreFinishRefresh(paramc);
      AppMethodBeat.o(244314);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ar
 * JD-Core Version:    0.7.0.1
 */