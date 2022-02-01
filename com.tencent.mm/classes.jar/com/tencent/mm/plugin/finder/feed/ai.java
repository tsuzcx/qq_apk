package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yp;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.b.a;
import com.tencent.mm.plugin.finder.feed.model.s;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.view.FinderTagView;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.dye;
import com.tencent.mm.protocal.protobuf.dyf;
import com.tencent.mm.protocal.protobuf.dzw;
import com.tencent.mm.protocal.protobuf.ebq;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d.b;
import d.g.b.k;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "canTimelineRefresh", "", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "headerSearchData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderSearchData;", "headerTagsData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "getHeaderTagsData", "()Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "setHeaderTagsData", "(Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;)V", "msgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "relFeedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "selectedTag", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tagsCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM;", "tagsData", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "findFirstPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "initDataFromCache", "forceCache", "refreshHeader", "initTagHeader", "notifyChanged", "rv", "itemId", "onActionbarClick", "onAttach", "callback", "onCategoryLoadMore", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onUserVisibleFocused", "refreshMsgNotify", "refreshOnCategoryClick", "removeTagFlowView", "scrollToTop", "endCallBack", "Lkotlin/Function0;", "Companion", "plugin-finder_release"})
public final class ai
  implements ah.a
{
  public static final a KOM;
  private final com.tencent.mm.plugin.finder.feed.model.b KOG;
  public final FinderTagCacheVM KOH;
  public ah.b KOI;
  public dyf KOJ;
  private dzw KOK;
  private x KOL;
  public final FinderHomeTabStateVM KOa;
  public int KOb;
  private com.tencent.mm.view.d KOf;
  private final MMActivity activity;
  public final com.tencent.mm.plugin.finder.feed.model.h qrj;
  private final boolean qwK;
  private final com.tencent.mm.plugin.finder.model.d qwP;
  private final com.tencent.mm.plugin.finder.model.e qwQ;
  private c<yp> xpb;
  
  static
  {
    AppMethodBeat.i(198039);
    KOM = new a((byte)0);
    AppMethodBeat.o(198039);
  }
  
  public ai(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(198038);
    this.activity = paramMMActivity;
    paramMMActivity = com.tencent.mm.plugin.finder.feed.model.internal.b.KQP;
    int i = b.a.ahj(4).value;
    paramMMActivity = com.tencent.mm.ui.component.a.LCX;
    this.KOG = new com.tencent.mm.plugin.finder.feed.model.b(0L, 4, null, i, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.activity).get(FinderReporterUIC.class)).fXs(), 4);
    paramMMActivity = com.tencent.mm.ui.component.a.LCX;
    paramMMActivity = com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderHomeTabStateVM.class);
    k.g(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.KOa = ((FinderHomeTabStateVM)paramMMActivity);
    paramMMActivity = com.tencent.mm.ui.component.a.LCX;
    paramMMActivity = com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderTagCacheVM.class);
    k.g(paramMMActivity, "UICProvider.of(PluginFin…erTagCacheVM::class.java)");
    this.KOH = ((FinderTagCacheVM)paramMMActivity);
    this.qwK = this.KOa.ahN(4);
    this.qwQ = new com.tencent.mm.plugin.finder.model.e();
    paramMMActivity = com.tencent.mm.plugin.finder.feed.model.internal.b.KQP;
    paramMMActivity = b.a.ahj(4);
    if (this.qwK) {}
    for (i = 0;; i = 1)
    {
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.LCX;
      this.qrj = new com.tencent.mm.plugin.finder.feed.model.h(paramMMActivity, i, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.activity).get(FinderReporterUIC.class)).fXs());
      this.KOf = ((com.tencent.mm.view.d)new j(this));
      this.KOL = new x(new ebq());
      this.qwP = new com.tencent.mm.plugin.finder.model.d();
      AppMethodBeat.o(198038);
      return;
    }
  }
  
  public final void R(final d.g.a.a<y> parama)
  {
    AppMethodBeat.i(198035);
    Object localObject = this.KOI;
    if (localObject == null) {
      k.aPZ("viewCallback");
    }
    localObject = ((ah.b)localObject).getRecyclerView().getLayoutManager();
    if ((localObject instanceof StaggeredGridLayoutManager))
    {
      ((StaggeredGridLayoutManager)localObject).af(0, 0);
      ah.b localb = this.KOI;
      if (localb == null) {
        k.aPZ("viewCallback");
      }
      localb.getRecyclerView().post((Runnable)new i((RecyclerView.i)localObject, parama));
    }
    AppMethodBeat.o(198035);
  }
  
  public final void Wc()
  {
    AppMethodBeat.i(198031);
    if (this.KOK != null)
    {
      ad.d("Finder.TimelineMachinePresenter", "loadMore category feed:" + this.KOK);
      com.tencent.mm.plugin.finder.feed.model.b localb = this.KOG;
      Object localObject = this.KOK;
      if (localObject != null) {}
      for (localObject = ((dzw)localObject).dqA;; localObject = null)
      {
        localb.category = ((String)localObject);
        this.KOG.KPQ = 1;
        this.KOG.requestLoadMore();
        AppMethodBeat.o(198031);
        return;
      }
    }
    ad.d("Finder.TimelineMachinePresenter", "loadMore tl feed:");
    this.qrj.requestLoadMore();
    AppMethodBeat.o(198031);
  }
  
  public final void a(ah.b paramb)
  {
    AppMethodBeat.i(198033);
    k.h(paramb, "callback");
    this.KOI = paramb;
    ah.b localb = this.KOI;
    if (localb == null) {
      k.aPZ("viewCallback");
    }
    localb.N((ArrayList)this.qrj.getDataListJustForAdapter());
    this.qrj.register((com.tencent.mm.view.d)paramb.cmp(), this.activity);
    this.KOG.register(this.KOf, this.activity);
    final int i = this.KOa.ahO(4).Lhe.size();
    this.qrj.initData((com.tencent.mm.plugin.finder.feed.model.internal.h)new s(i, false, (com.tencent.mm.plugin.finder.feed.model.internal.g)new c(this, i)), true);
    this.qrj.KQo = ((d.g.a.b)new d(this));
    paramb = this.KOI;
    if (paramb == null) {
      k.aPZ("viewCallback");
    }
    paramb.getRecyclerView().a((RecyclerView.m)new e(this));
    this.xpb = ((c)new f(this));
    com.tencent.mm.sdk.b.a.ESL.b(this.xpb);
    AppMethodBeat.o(198033);
  }
  
  public final void b(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(198030);
    k.h(paramc, "reason");
    if (paramc.HXr <= 0)
    {
      paramc = this.KOI;
      if (paramc == null) {
        k.aPZ("viewCallback");
      }
      paramc = paramc.cmp();
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      paramc.b(com.tencent.mm.plugin.finder.storage.b.fUv(), (d.g.a.a)g.KOT);
    }
    AppMethodBeat.o(198030);
  }
  
  public final void cgG()
  {
    AppMethodBeat.i(198029);
    if (this.KOK != null)
    {
      ad.d("Finder.TimelineMachinePresenter", "refresh category feed:" + this.KOK);
      com.tencent.mm.plugin.finder.feed.model.b localb = this.KOG;
      Object localObject = this.KOK;
      if (localObject != null) {}
      for (localObject = ((dzw)localObject).dqA;; localObject = null)
      {
        localb.category = ((String)localObject);
        this.KOG.KPQ = 1;
        this.KOG.requestRefresh();
        AppMethodBeat.o(198029);
        return;
      }
    }
    ad.d("Finder.TimelineMachinePresenter", "refresh tl feed:");
    this.qrj.requestRefresh();
    AppMethodBeat.o(198029);
  }
  
  public final List<d.b> cmm()
  {
    AppMethodBeat.i(198032);
    Object localObject1 = new LinkedList();
    Object localObject2 = com.tencent.mm.kernel.g.afB();
    k.g(localObject2, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.e)localObject2).afk().getInt(ae.a.FwJ, 0);
    localObject2 = com.tencent.mm.kernel.g.afB();
    k.g(localObject2, "MMKernel.storage()");
    int j = ((com.tencent.mm.kernel.e)localObject2).afk().getInt(ae.a.FwK, 0);
    localObject2 = com.tencent.mm.kernel.g.afB();
    k.g(localObject2, "MMKernel.storage()");
    int k = ((com.tencent.mm.kernel.e)localObject2).afk().getInt(ae.a.LBe, 0);
    localObject2 = com.tencent.mm.kernel.g.afB();
    k.g(localObject2, "MMKernel.storage()");
    int m = ((com.tencent.mm.kernel.e)localObject2).afk().getInt(ae.a.LBf, 0);
    this.qwP.count = (i + j + k + m);
    localObject2 = this.qwP;
    Object localObject3 = com.tencent.mm.kernel.g.afB();
    k.g(localObject3, "MMKernel.storage()");
    localObject3 = ((com.tencent.mm.kernel.e)localObject3).afk().get(ae.a.FwL, "");
    if (localObject3 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(198032);
      throw ((Throwable)localObject1);
    }
    ((com.tencent.mm.plugin.finder.model.d)localObject2).setAvatar((String)localObject3);
    ((LinkedList)localObject1).add(this.qwP);
    ((LinkedList)localObject1).add(this.qwQ);
    ((LinkedList)localObject1).add(this.KOL);
    localObject1 = (List)localObject1;
    AppMethodBeat.o(198032);
    return localObject1;
  }
  
  public final ah.b fTs()
  {
    AppMethodBeat.i(198028);
    ah.b localb = this.KOI;
    if (localb == null) {
      k.aPZ("viewCallback");
    }
    AppMethodBeat.o(198028);
    return localb;
  }
  
  public final void fTt()
  {
    AppMethodBeat.i(198036);
    if (this.KOJ != null)
    {
      Object localObject1 = new ebq();
      ((ebq)localObject1).LAk = new LinkedList();
      Object localObject2 = this.KOJ;
      if (localObject2 == null) {
        k.fvU();
      }
      localObject2 = ((dyf)localObject2).Lxm;
      k.g(localObject2, "tagsData!!.categoryInfo");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        dye localdye = (dye)((Iterator)localObject2).next();
        dzw localdzw = new dzw();
        localdzw.dqA = localdye.rCn;
        ((ebq)localObject1).LAk.add(localdzw);
      }
      this.KOL.a((ebq)localObject1);
      localObject1 = this.KOI;
      if (localObject1 == null) {
        k.aPZ("viewCallback");
      }
      com.tencent.mm.view.recyclerview.d.b(((ah.b)localObject1).fTr(), this.KOL.hashCode());
      localObject1 = this.KOI;
      if (localObject1 == null) {
        k.aPZ("viewCallback");
      }
      localObject1 = ((ah.b)localObject1).getRootView();
      localObject2 = FinderTagView.LfB;
      localObject1 = ((View)localObject1).findViewById(FinderTagView.fWW());
      if (localObject1 != null)
      {
        localObject2 = this.KOI;
        if (localObject2 == null) {
          k.aPZ("viewCallback");
        }
        localObject2 = ((ah.b)localObject2).getRootView();
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(198036);
          throw ((Throwable)localObject1);
        }
        ((ViewGroup)localObject2).removeView((View)localObject1);
      }
      localObject1 = this.KOI;
      if (localObject1 == null) {
        k.aPZ("viewCallback");
      }
      com.tencent.mm.view.recyclerview.d.a(((ah.b)localObject1).fTr(), (d.b)this.KOL);
    }
    AppMethodBeat.o(198036);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(198037);
    com.tencent.mm.plugin.finder.feed.model.h localh = this.qrj;
    ah.b localb = this.KOI;
    if (localb == null) {
      k.aPZ("viewCallback");
    }
    localh.unregister((com.tencent.mm.view.d)localb.cmp(), this.activity);
    com.tencent.mm.sdk.b.a.ESL.d(this.xpb);
    AppMethodBeat.o(198037);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(198007);
      this.KOi.xk(this.qxv);
      AppMethodBeat.o(198007);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$initDataFromCache$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class c
    implements com.tencent.mm.plugin.finder.feed.model.internal.g
  {
    c(boolean paramBoolean1, boolean paramBoolean2) {}
    
    public final void call(final int paramInt)
    {
      boolean bool = false;
      AppMethodBeat.i(198009);
      ad.i("Finder.TimelineMachinePresenter", "[initData] canTimelineRefresh=" + ai.g(this.KON) + ", incrementCount=" + paramInt);
      if ((!this.KOO) && (ai.g(this.KON)))
      {
        localObject = this.KON;
        if (paramInt <= 0) {
          bool = true;
        }
        ai.a((ai)localObject, bool);
        AppMethodBeat.o(198009);
        return;
      }
      Object localObject = ai.d(this.KON).ahO(4);
      if (this.KOO)
      {
        paramInt = 0;
        if (!this.KOO) {
          break label330;
        }
      }
      label330:
      for (final int i = 0;; i = ((FinderHomeTabStateVM.a)localObject).Lhg)
      {
        ai.a(this.KON, i);
        ad.i("Finder.TimelineMachinePresenter", "[initData] canTimelineRefresh " + ai.g(this.KON) + " lastPos=" + paramInt + " fromTopPixel=" + i + " initCount=:" + i);
        RecyclerView.i locali = this.KON.fTs().getRecyclerView().getLayoutManager();
        if (this.KOP)
        {
          ai localai = this.KON;
          FinderTagCacheVM.a locala = (FinderTagCacheVM.a)ai.h(this.KON).LgZ.get(Integer.valueOf(4));
          localObject = locala;
          if (locala == null) {
            localObject = new FinderTagCacheVM.a();
          }
          ai.a(localai, ((FinderTagCacheVM.a)localObject).Lhv);
          this.KON.fTt();
        }
        if ((locali instanceof StaggeredGridLayoutManager))
        {
          ((StaggeredGridLayoutManager)locali).af(paramInt, i);
          this.KON.fTs().getRecyclerView().post((Runnable)new a(locali, paramInt, i));
        }
        AppMethodBeat.o(198009);
        return;
        paramInt = ((FinderHomeTabStateVM.a)localObject).Lhf;
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
        AppMethodBeat.i(198008);
        ((StaggeredGridLayoutManager)this.KOl).af(paramInt, i);
        AppMethodBeat.o(198008);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<IResponse<BaseFinderFeed>, y>
  {
    d(ai paramai)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class e
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(198011);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt1);
      localb.lT(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
      k.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = this.KON;
      ai.a(paramRecyclerView, ai.b(paramRecyclerView) - paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(198011);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(198012);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
      super.b(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(198012);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$3", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class f
    extends c<yp>
  {
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$3$callback$1$1"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(ai.f paramf, yp paramyp)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final g KOT;
    
    static
    {
      AppMethodBeat.i(198017);
      KOT = new g();
      AppMethodBeat.o(198017);
    }
    
    g()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public h(ai paramai)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(RecyclerView.i parami, d.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(198020);
      ((StaggeredGridLayoutManager)this.KOl).af(0, 0);
      d.g.a.a locala = parama;
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(198020);
        return;
      }
      AppMethodBeat.o(198020);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class j
    implements com.tencent.mm.view.d
  {
    private WxRecyclerAdapter<?> getAdapter()
    {
      AppMethodBeat.i(198021);
      WxRecyclerAdapter localWxRecyclerAdapter = this.KON.fTs().fTr();
      AppMethodBeat.o(198021);
      return localWxRecyclerAdapter;
    }
    
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(198024);
      Object localObject = this.KON.fTs();
      if (localObject != null)
      {
        localObject = ((ah.b)localObject).cmp();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.Ibl.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).at(i + paramInt1, paramInt2);
            AppMethodBeat.o(198024);
            return;
          }
        }
      }
      AppMethodBeat.o(198024);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(198025);
      Object localObject = this.KON.fTs();
      if (localObject != null)
      {
        localObject = ((ah.b)localObject).cmp();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.Ibl.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).au(i + paramInt1, paramInt2);
            AppMethodBeat.o(198025);
            return;
          }
        }
      }
      AppMethodBeat.o(198025);
    }
    
    public final void c(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(198027);
      k.h(paramc, "reason");
      this.KON.fTs().cmp().c(paramc);
      AppMethodBeat.o(198027);
    }
    
    public final void d(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(198026);
      k.h(paramc, "reason");
      this.KON.fTs().cmp().d(paramc);
      AppMethodBeat.o(198026);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(198023);
      Object localObject = this.KON.fTs();
      if (localObject != null)
      {
        localObject = ((ah.b)localObject).cmp();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.Ibl.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).f(i + paramInt1, paramInt2, paramObject);
            AppMethodBeat.o(198023);
            return;
          }
        }
      }
      AppMethodBeat.o(198023);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(198022);
      int i = ai.e(this.KON).getSize();
      ai.e(this.KON).getDataListJustForAdapter().clear();
      au(0, i);
      ai.e(this.KON).getDataListJustForAdapter().addAll((Collection)ai.f(this.KON).getDataListJustForAdapter());
      at(0, ai.f(this.KON).getSize());
      AppMethodBeat.o(198022);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ai
 * JD-Core Version:    0.7.0.1
 */