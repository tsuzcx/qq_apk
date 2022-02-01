package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hs;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e.a;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.model.i;
import com.tencent.mm.plugin.finder.view.FinderTagView;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.alx;
import com.tencent.mm.protocal.protobuf.aly;
import com.tencent.mm.protocal.protobuf.asv;
import com.tencent.mm.protocal.protobuf.ctu;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "canTimelineRefresh", "", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "headerSearchData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderSearchData;", "headerTagsData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "getHeaderTagsData", "()Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "setHeaderTagsData", "(Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;)V", "msgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "relFeedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "selectedTag", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tagsCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM;", "tagsData", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "findFirstPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "initDataFromCache", "forceCache", "refreshHeader", "initTagHeader", "notifyChanged", "rv", "itemId", "onActionbarClick", "onAttach", "callback", "onCategoryLoadMore", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onUserVisibleFocused", "refreshMsgNotify", "refreshOnCategoryClick", "removeTagFlowView", "scrollToTop", "endCallBack", "Lkotlin/Function0;", "Companion", "plugin-finder_release"})
public final class al
  implements ak.a
{
  public static final al.b shK;
  private final MMActivity activity;
  private c<hs> seA;
  public final FinderHomeTabStateVM sgM;
  private final boolean sgN;
  public int sgO;
  private com.tencent.mm.view.d sgS;
  private final FinderFeedRelTimelineLoader shD;
  public final FinderTagCacheVM shE;
  public ak.b shF;
  private final com.tencent.mm.plugin.finder.model.h shG;
  public aly shH;
  private asv shI;
  private i shJ;
  public final FinderTimelineFeedLoader sho;
  private final com.tencent.mm.plugin.finder.model.g shp;
  
  static
  {
    AppMethodBeat.i(202651);
    shK = new al.b((byte)0);
    AppMethodBeat.o(202651);
  }
  
  public al(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(202650);
    this.activity = paramMMActivity;
    paramMMActivity = com.tencent.mm.plugin.finder.feed.model.internal.e.slN;
    int j = e.a.EQ(4).value;
    paramMMActivity = com.tencent.mm.ui.component.a.KEX;
    this.shD = new FinderFeedRelTimelineLoader(0L, "", 4, null, j, false, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.activity).get(FinderReporterUIC.class)).cQZ(), 40);
    paramMMActivity = com.tencent.mm.ui.component.a.KEX;
    paramMMActivity = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    p.g(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.sgM = ((FinderHomeTabStateVM)paramMMActivity);
    paramMMActivity = com.tencent.mm.ui.component.a.KEX;
    paramMMActivity = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTagCacheVM.class);
    p.g(paramMMActivity, "UICProvider.of(PluginFin…erTagCacheVM::class.java)");
    this.shE = ((FinderTagCacheVM)paramMMActivity);
    this.sgN = this.sgM.EX(4);
    this.shG = new com.tencent.mm.plugin.finder.model.h();
    paramMMActivity = com.tencent.mm.plugin.finder.feed.model.internal.e.slN;
    paramMMActivity = e.a.EQ(4);
    if (this.sgN) {}
    for (;;)
    {
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KEX;
      paramMMActivity = new FinderTimelineFeedLoader(paramMMActivity, i, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.activity).get(FinderReporterUIC.class)).cQZ());
      paramMMActivity.setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.h)new a(paramMMActivity, this));
      this.sho = paramMMActivity;
      this.sgS = ((com.tencent.mm.view.d)new j(this));
      this.shJ = new i(new ctu());
      this.shp = new com.tencent.mm.plugin.finder.model.g();
      AppMethodBeat.o(202650);
      return;
      i = 1;
    }
  }
  
  public final void ZC()
  {
    AppMethodBeat.i(202643);
    if (this.shI != null)
    {
      ae.d("Finder.TimelineMachinePresenter", "loadMore category feed:" + this.shI);
      FinderFeedRelTimelineLoader localFinderFeedRelTimelineLoader = this.shD;
      Object localObject = this.shI;
      if (localObject != null) {}
      for (localObject = ((asv)localObject).dBe;; localObject = null)
      {
        localFinderFeedRelTimelineLoader.category = ((String)localObject);
        this.shD.rQa = 1;
        this.shD.requestLoadMore();
        AppMethodBeat.o(202643);
        return;
      }
    }
    ae.d("Finder.TimelineMachinePresenter", "loadMore tl feed:");
    this.sho.requestLoadMore();
    AppMethodBeat.o(202643);
  }
  
  public final void a(ak.b paramb)
  {
    AppMethodBeat.i(202645);
    p.h(paramb, "callback");
    this.shF = paramb;
    ak.b localb = this.shF;
    if (localb == null) {
      p.bdF("viewCallback");
    }
    localb.U((ArrayList)this.sho.getDataListJustForAdapter());
    this.sho.register((com.tencent.mm.view.d)paramb.cDp());
    this.shD.register(this.sgS);
    this.sgM.GH(4).tkA.size();
    BaseFeedLoader.requestInit$default(this.sho, false, 1, null);
    this.sho.skJ = ((d.g.a.b)new d(this));
    paramb = this.shF;
    if (paramb == null) {
      p.bdF("viewCallback");
    }
    paramb.getRecyclerView().a((RecyclerView.m)new e(this));
    this.seA = ((c)new f(this));
    com.tencent.mm.sdk.b.a.IvT.b(this.seA);
    AppMethodBeat.o(202645);
  }
  
  public final void b(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202642);
    p.h(paramc, "reason");
    if (paramc.LNU <= 0)
    {
      paramc = this.shF;
      if (paramc == null) {
        p.bdF("viewCallback");
      }
      paramc = paramc.cDp();
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
      paramc.b(com.tencent.mm.plugin.finder.storage.b.cIs(), (d.g.a.a)al.g.shP);
    }
    AppMethodBeat.o(202642);
  }
  
  public final List<d.b> cDj()
  {
    AppMethodBeat.i(202644);
    Object localObject1 = new LinkedList();
    Object localObject2 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject2, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.e)localObject2).ajA().getInt(am.a.Jcf, 0);
    localObject2 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject2, "MMKernel.storage()");
    int j = ((com.tencent.mm.kernel.e)localObject2).ajA().getInt(am.a.Jcg, 0);
    localObject2 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject2, "MMKernel.storage()");
    int k = ((com.tencent.mm.kernel.e)localObject2).ajA().getInt(am.a.Jch, 0);
    localObject2 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject2, "MMKernel.storage()");
    int m = ((com.tencent.mm.kernel.e)localObject2).ajA().getInt(am.a.Jci, 0);
    localObject2 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject2, "MMKernel.storage()");
    int n = ((com.tencent.mm.kernel.e)localObject2).ajA().getInt(am.a.Jcj, 0);
    this.shp.count = (i + j + k + m + n);
    localObject2 = this.shp;
    Object localObject3 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject3, "MMKernel.storage()");
    localObject3 = ((com.tencent.mm.kernel.e)localObject3).ajA().get(am.a.Jck, "");
    if (localObject3 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(202644);
      throw ((Throwable)localObject1);
    }
    ((com.tencent.mm.plugin.finder.model.g)localObject2).setAvatar((String)localObject3);
    ((LinkedList)localObject1).add(this.shp);
    ((LinkedList)localObject1).add(this.shG);
    ((LinkedList)localObject1).add(this.shJ);
    localObject1 = (List)localObject1;
    AppMethodBeat.o(202644);
    return localObject1;
  }
  
  public final ak.b cDt()
  {
    AppMethodBeat.i(202640);
    ak.b localb = this.shF;
    if (localb == null) {
      p.bdF("viewCallback");
    }
    AppMethodBeat.o(202640);
    return localb;
  }
  
  public final void cDu()
  {
    AppMethodBeat.i(202648);
    if (this.shH != null)
    {
      Object localObject1 = new ctu();
      ((ctu)localObject1).HEO = new LinkedList();
      Object localObject2 = this.shH;
      if (localObject2 == null) {
        p.gkB();
      }
      localObject2 = ((aly)localObject2).GEo;
      p.g(localObject2, "tagsData!!.categoryInfo");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        alx localalx = (alx)((Iterator)localObject2).next();
        asv localasv = new asv();
        localasv.dBe = localalx.tSH;
        ((ctu)localObject1).HEO.add(localasv);
      }
      this.shJ.a((ctu)localObject1);
      localObject1 = this.shF;
      if (localObject1 == null) {
        p.bdF("viewCallback");
      }
      com.tencent.mm.view.recyclerview.d.a(((ak.b)localObject1).cDs(), this.shJ.hashCode());
      localObject1 = this.shF;
      if (localObject1 == null) {
        p.bdF("viewCallback");
      }
      localObject1 = ((ak.b)localObject1).getRootView();
      localObject2 = FinderTagView.thj;
      localObject1 = ((View)localObject1).findViewById(FinderTagView.cQl());
      if (localObject1 != null)
      {
        localObject2 = this.shF;
        if (localObject2 == null) {
          p.bdF("viewCallback");
        }
        localObject2 = ((ak.b)localObject2).getRootView();
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(202648);
          throw ((Throwable)localObject1);
        }
        ((ViewGroup)localObject2).removeView((View)localObject1);
      }
      localObject1 = this.shF;
      if (localObject1 == null) {
        p.bdF("viewCallback");
      }
      com.tencent.mm.view.recyclerview.d.a(((ak.b)localObject1).cDs(), (d.b)this.shJ);
    }
    AppMethodBeat.o(202648);
  }
  
  public final void cvt()
  {
    AppMethodBeat.i(202641);
    if (this.shI != null)
    {
      ae.d("Finder.TimelineMachinePresenter", "refresh category feed:" + this.shI);
      FinderFeedRelTimelineLoader localFinderFeedRelTimelineLoader = this.shD;
      Object localObject = this.shI;
      if (localObject != null) {}
      for (localObject = ((asv)localObject).dBe;; localObject = null)
      {
        localFinderFeedRelTimelineLoader.category = ((String)localObject);
        this.shD.rQa = 1;
        this.shD.requestRefresh();
        AppMethodBeat.o(202641);
        return;
      }
    }
    ae.d("Finder.TimelineMachinePresenter", "refresh tl feed:");
    this.sho.requestRefresh();
    AppMethodBeat.o(202641);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(202649);
    FinderTimelineFeedLoader localFinderTimelineFeedLoader = this.sho;
    ak.b localb = this.shF;
    if (localb == null) {
      p.bdF("viewCallback");
    }
    localFinderTimelineFeedLoader.unregister((com.tencent.mm.view.d)localb.cDp());
    com.tencent.mm.sdk.b.a.IvT.d(this.seA);
    AppMethodBeat.o(202649);
  }
  
  public final void y(final d.g.a.a<z> parama)
  {
    AppMethodBeat.i(202647);
    Object localObject = this.shF;
    if (localObject == null) {
      p.bdF("viewCallback");
    }
    localObject = ((ak.b)localObject).getRecyclerView().getLayoutManager();
    if ((localObject instanceof StaggeredGridLayoutManager))
    {
      ((StaggeredGridLayoutManager)localObject).ag(0, 0);
      ak.b localb = this.shF;
      if (localb == null) {
        p.bdF("viewCallback");
      }
      localb.getRecyclerView().post((Runnable)new i((RecyclerView.i)localObject, parama));
    }
    AppMethodBeat.o(202647);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$feedLoader$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.plugin.finder.feed.model.internal.h
  {
    a(FinderTimelineFeedLoader paramFinderTimelineFeedLoader, al paramal) {}
    
    public final void call(final int paramInt)
    {
      AppMethodBeat.i(202620);
      ae.i(this.shr.getTAG(), "[initData] canTimelineRefresh=" + al.g(jdField_this) + ", incrementCount=" + paramInt);
      if (al.g(jdField_this))
      {
        localObject = jdField_this;
        if (paramInt <= 0) {}
        for (boolean bool = true;; bool = false)
        {
          al.a((al)localObject, bool);
          AppMethodBeat.o(202620);
          return;
        }
      }
      Object localObject = al.d(jdField_this).GH(4);
      paramInt = ((FinderHomeTabStateVM.a)localObject).tkC;
      final int i = ((FinderHomeTabStateVM.a)localObject).tkD;
      al.a(jdField_this, i);
      ae.i(this.shr.getTAG(), "[initData] canTimelineRefresh " + al.g(jdField_this) + " lastPos=" + paramInt + " fromTopPixel=" + i);
      RecyclerView.i locali = jdField_this.cDt().getRecyclerView().getLayoutManager();
      al localal = jdField_this;
      FinderTagCacheVM.a locala = (FinderTagCacheVM.a)al.h(jdField_this).tkt.get(Integer.valueOf(4));
      localObject = locala;
      if (locala == null) {
        localObject = new FinderTagCacheVM.a();
      }
      al.a(localal, ((FinderTagCacheVM.a)localObject).tln);
      jdField_this.cDu();
      if ((locali instanceof StaggeredGridLayoutManager))
      {
        ((StaggeredGridLayoutManager)locali).ag(paramInt, i);
        jdField_this.cDt().getRecyclerView().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(202619);
            ((StaggeredGridLayoutManager)this.sha).ag(paramInt, i);
            AppMethodBeat.o(202619);
          }
        });
      }
      AppMethodBeat.o(202620);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(202621);
      this.sgV.zu(this.sgW);
      AppMethodBeat.o(202621);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<IResponse<am>, z>
  {
    d(al paramal)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class e
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202623);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt1);
      localb.mu(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
      p.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = this.shL;
      al.a(paramRecyclerView, al.b(paramRecyclerView) - paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(202623);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(202624);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
      super.b(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(202624);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$3", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class f
    extends c<hs>
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$3$callback$1$1"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(al.f paramf, hs paramhs)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class h
    extends q
    implements d.g.a.a<z>
  {
    public h(al paramal)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(RecyclerView.i parami, d.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(202632);
      ((StaggeredGridLayoutManager)this.sha).ag(0, 0);
      d.g.a.a locala = parama;
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(202632);
        return;
      }
      AppMethodBeat.o(202632);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class j
    implements com.tencent.mm.view.d
  {
    private WxRecyclerAdapter<?> getAdapter()
    {
      AppMethodBeat.i(202633);
      WxRecyclerAdapter localWxRecyclerAdapter = this.shL.cDt().cDs();
      AppMethodBeat.o(202633);
      return localWxRecyclerAdapter;
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202636);
      Object localObject = this.shL.cDt();
      if (localObject != null)
      {
        localObject = ((ak.b)localObject).cDp();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.LRV.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).au(i + paramInt1, paramInt2);
            AppMethodBeat.o(202636);
            return;
          }
        }
      }
      AppMethodBeat.o(202636);
    }
    
    public final void av(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202637);
      Object localObject = this.shL.cDt();
      if (localObject != null)
      {
        localObject = ((ak.b)localObject).cDp();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.LRV.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).av(i + paramInt1, paramInt2);
            AppMethodBeat.o(202637);
            return;
          }
        }
      }
      AppMethodBeat.o(202637);
    }
    
    public final void c(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202638);
      p.h(paramc, "reason");
      this.shL.cDt().cDp().c(paramc);
      AppMethodBeat.o(202638);
    }
    
    public final void d(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202639);
      p.h(paramc, "reason");
      this.shL.cDt().cDp().d(paramc);
      AppMethodBeat.o(202639);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(202635);
      Object localObject = this.shL.cDt();
      if (localObject != null)
      {
        localObject = ((ak.b)localObject).cDp();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.LRV.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).f(i + paramInt1, paramInt2, paramObject);
            AppMethodBeat.o(202635);
            return;
          }
        }
      }
      AppMethodBeat.o(202635);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(202634);
      int i = al.e(this.shL).getSize();
      al.e(this.shL).getDataListJustForAdapter().clear();
      av(0, i);
      al.e(this.shL).getDataListJustForAdapter().addAll((Collection)al.f(this.shL).getDataListJustForAdapter());
      au(0, al.f(this.shL).getSize());
      AppMethodBeat.o(202634);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.al
 * JD-Core Version:    0.7.0.1
 */