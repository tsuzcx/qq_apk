package com.tencent.mm.plugin.finder.feed;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.iv;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.i;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.view.FinderTagView;
import com.tencent.mm.plugin.finder.viewmodel.b.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.protocal.protobuf.aqj;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.protocal.protobuf.dwb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h.b;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "canTimelineRefresh", "", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "headerSearchData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderSearchData;", "headerTagsData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "getHeaderTagsData", "()Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "setHeaderTagsData", "(Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;)V", "msgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "relFeedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "selectedTag", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tagsCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM;", "tagsData", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "findFirstPosition", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "initDataFromCache", "forceCache", "refreshHeader", "initTagHeader", "notifyChanged", "rv", "itemId", "onActionbarClick", "onAttach", "callback", "onCategoryLoadMore", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onUserVisibleFocused", "refreshMsgNotify", "refreshOnCategoryClick", "removeTagFlowView", "scrollToTop", "endCallBack", "Lkotlin/Function0;", "Companion", "plugin-finder_release"})
public final class ax
  implements aw.a
{
  public static final b xCD;
  private final MMActivity activity;
  private final boolean canTimelineRefresh;
  private final com.tencent.mm.plugin.finder.model.h msgNotifyData;
  private com.tencent.mm.view.j tagViewActionCallback;
  public final com.tencent.mm.plugin.finder.viewmodel.b tlCache;
  public int totalDy;
  public aqk xCA;
  private bkr xCB;
  private com.tencent.mm.plugin.finder.model.j xCC;
  public final FinderTimelineFeedLoader xCg;
  private final FinderFeedRelTimelineLoader xCw;
  public final com.tencent.mm.plugin.finder.viewmodel.g xCx;
  public aw.b xCy;
  private final i xCz;
  private IListener<iv> xyI;
  
  static
  {
    AppMethodBeat.i(287878);
    xCD = new b((byte)0);
    AppMethodBeat.o(287878);
  }
  
  public ax(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(287877);
    this.activity = paramMMActivity;
    paramMMActivity = com.tencent.mm.plugin.finder.feed.model.internal.g.xKI;
    int i = com.tencent.mm.plugin.finder.feed.model.internal.g.a.MG(4).value;
    paramMMActivity = com.tencent.mm.ui.component.g.Xox;
    this.xCw = new FinderFeedRelTimelineLoader(0L, "", 4, null, i, false, null, null, null, 0, ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.activity).i(aj.class)).ekY(), 0.0F, 0.0F, 28648);
    paramMMActivity = com.tencent.mm.ui.component.g.Xox;
    paramMMActivity = com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class);
    p.j(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.tlCache = ((com.tencent.mm.plugin.finder.viewmodel.b)paramMMActivity);
    paramMMActivity = com.tencent.mm.ui.component.g.Xox;
    paramMMActivity = com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.g.class);
    p.j(paramMMActivity, "UICProvider.of(PluginFin…erTagCacheVM::class.java)");
    this.xCx = ((com.tencent.mm.plugin.finder.viewmodel.g)paramMMActivity);
    this.canTimelineRefresh = this.tlCache.OO(4);
    this.xCz = new i();
    paramMMActivity = com.tencent.mm.plugin.finder.feed.model.internal.g.xKI;
    paramMMActivity = com.tencent.mm.plugin.finder.feed.model.internal.g.a.MG(4);
    if (this.canTimelineRefresh) {}
    for (i = 0;; i = 1)
    {
      com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
      paramMMActivity = new FinderTimelineFeedLoader(paramMMActivity, i, ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.activity).i(aj.class)).ekY());
      paramMMActivity.setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.j)new a(paramMMActivity, this));
      this.xCg = paramMMActivity;
      this.tagViewActionCallback = ((com.tencent.mm.view.j)new j(this));
      this.xCC = new com.tencent.mm.plugin.finder.model.j(new dwb());
      this.msgNotifyData = new com.tencent.mm.plugin.finder.model.h();
      AppMethodBeat.o(287877);
      return;
    }
  }
  
  public final void E(final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(287874);
    Object localObject = this.xCy;
    if (localObject == null) {
      p.bGy("viewCallback");
    }
    localObject = ((aw.b)localObject).getRecyclerView().getLayoutManager();
    if ((localObject instanceof StaggeredGridLayoutManager))
    {
      ((StaggeredGridLayoutManager)localObject).au(0, 0);
      aw.b localb = this.xCy;
      if (localb == null) {
        p.bGy("viewCallback");
      }
      localb.getRecyclerView().post((Runnable)new i((RecyclerView.LayoutManager)localObject, parama));
    }
    AppMethodBeat.o(287874);
  }
  
  public final void a(aw.b paramb)
  {
    AppMethodBeat.i(287872);
    p.k(paramb, "callback");
    this.xCy = paramb;
    aw.b localb = this.xCy;
    if (localb == null) {
      p.bGy("viewCallback");
    }
    localb.ab((ArrayList)this.xCg.getDataListJustForAdapter());
    this.xCg.register((com.tencent.mm.view.j)paramb.dtq());
    this.xCw.register(this.tagViewActionCallback);
    this.tlCache.RI(4).Bgw.size();
    BaseFeedLoader.requestInit$default(this.xCg, false, 1, null);
    this.xCg.xJr = ((kotlin.g.a.b)new d(this));
    paramb = this.xCy;
    if (paramb == null) {
      p.bGy("viewCallback");
    }
    paramb.getRecyclerView().a((RecyclerView.l)new e(this));
    this.xyI = ((IListener)new f(this));
    EventCenter.instance.add(this.xyI);
    AppMethodBeat.o(287872);
  }
  
  public final aw.b dtw()
  {
    AppMethodBeat.i(287867);
    aw.b localb = this.xCy;
    if (localb == null) {
      p.bGy("viewCallback");
    }
    AppMethodBeat.o(287867);
    return localb;
  }
  
  public final void dtx()
  {
    AppMethodBeat.i(287875);
    if (this.xCA != null)
    {
      Object localObject1 = new dwb();
      ((dwb)localObject1).Uca = new LinkedList();
      Object localObject2 = this.xCA;
      if (localObject2 == null) {
        p.iCn();
      }
      localObject2 = ((aqk)localObject2).SDG;
      p.j(localObject2, "tagsData!!.categoryInfo");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        aqj localaqj = (aqj)((Iterator)localObject2).next();
        bkr localbkr = new bkr();
        localbkr.topic = localaqj.BWk;
        ((dwb)localObject1).Uca.add(localbkr);
      }
      this.xCC.a((dwb)localObject1);
      localObject1 = this.xCy;
      if (localObject1 == null) {
        p.bGy("viewCallback");
      }
      com.tencent.mm.view.recyclerview.h.a(((aw.b)localObject1).dtv(), this.xCC.hashCode());
      localObject1 = this.xCy;
      if (localObject1 == null) {
        p.bGy("viewCallback");
      }
      localObject1 = ((aw.b)localObject1).getRootView();
      localObject2 = FinderTagView.BaE;
      localObject1 = ((View)localObject1).findViewById(FinderTagView.ejl());
      if (localObject1 != null)
      {
        localObject2 = this.xCy;
        if (localObject2 == null) {
          p.bGy("viewCallback");
        }
        localObject2 = ((aw.b)localObject2).getRootView();
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(287875);
          throw ((Throwable)localObject1);
        }
        ((ViewGroup)localObject2).removeView((View)localObject1);
      }
      localObject1 = this.xCy;
      if (localObject1 == null) {
        p.bGy("viewCallback");
      }
      com.tencent.mm.view.recyclerview.h.a(((aw.b)localObject1).dtv(), (h.b)this.xCC);
    }
    AppMethodBeat.o(287875);
  }
  
  public final List<h.b> getHeaderInfo()
  {
    AppMethodBeat.i(287871);
    Object localObject1 = new LinkedList();
    Object localObject2 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject2, "MMKernel.storage()");
    int i = ((f)localObject2).aHp().getInt(ar.a.VAb, 0);
    localObject2 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject2, "MMKernel.storage()");
    int j = ((f)localObject2).aHp().getInt(ar.a.VAc, 0);
    localObject2 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject2, "MMKernel.storage()");
    int k = ((f)localObject2).aHp().getInt(ar.a.VAd, 0);
    localObject2 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject2, "MMKernel.storage()");
    int m = ((f)localObject2).aHp().getInt(ar.a.VAe, 0);
    localObject2 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject2, "MMKernel.storage()");
    int n = ((f)localObject2).aHp().getInt(ar.a.VAf, 0);
    this.msgNotifyData.count = (i + j + k + m + n);
    localObject2 = this.msgNotifyData;
    Object localObject3 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject3, "MMKernel.storage()");
    localObject3 = ((f)localObject3).aHp().get(ar.a.VAg, "");
    if (localObject3 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(287871);
      throw ((Throwable)localObject1);
    }
    ((com.tencent.mm.plugin.finder.model.h)localObject2).setAvatar((String)localObject3);
    ((LinkedList)localObject1).add(this.msgNotifyData);
    ((LinkedList)localObject1).add(this.xCz);
    ((LinkedList)localObject1).add(this.xCC);
    localObject1 = (List)localObject1;
    AppMethodBeat.o(287871);
    return localObject1;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(287876);
    FinderTimelineFeedLoader localFinderTimelineFeedLoader = this.xCg;
    aw.b localb = this.xCy;
    if (localb == null) {
      p.bGy("viewCallback");
    }
    localFinderTimelineFeedLoader.unregister((com.tencent.mm.view.j)localb.dtq());
    EventCenter.instance.removeListener(this.xyI);
    AppMethodBeat.o(287876);
  }
  
  public final void onLoadMore()
  {
    AppMethodBeat.i(287870);
    if (this.xCB != null)
    {
      Log.d("Finder.TimelineMachinePresenter", "loadMore category feed:" + this.xCB);
      FinderFeedRelTimelineLoader localFinderFeedRelTimelineLoader = this.xCw;
      Object localObject = this.xCB;
      if (localObject != null) {}
      for (localObject = ((bkr)localObject).topic;; localObject = null)
      {
        localFinderFeedRelTimelineLoader.idV = ((String)localObject);
        this.xCw.xGL = 1;
        this.xCw.requestLoadMore();
        AppMethodBeat.o(287870);
        return;
      }
    }
    Log.d("Finder.TimelineMachinePresenter", "loadMore tl feed:");
    this.xCg.requestLoadMore();
    AppMethodBeat.o(287870);
  }
  
  public final void onRefresh()
  {
    AppMethodBeat.i(287868);
    if (this.xCB != null)
    {
      Log.d("Finder.TimelineMachinePresenter", "refresh category feed:" + this.xCB);
      FinderFeedRelTimelineLoader localFinderFeedRelTimelineLoader = this.xCw;
      Object localObject = this.xCB;
      if (localObject != null) {}
      for (localObject = ((bkr)localObject).topic;; localObject = null)
      {
        localFinderFeedRelTimelineLoader.idV = ((String)localObject);
        this.xCw.xGL = 1;
        this.xCw.requestRefresh();
        AppMethodBeat.o(287868);
        return;
      }
    }
    Log.d("Finder.TimelineMachinePresenter", "refresh tl feed:");
    this.xCg.requestRefresh();
    AppMethodBeat.o(287868);
  }
  
  public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(287869);
    p.k(paramc, "reason");
    if (paramc.YNG <= 0)
    {
      paramc = this.xCy;
      if (paramc == null) {
        p.bGy("viewCallback");
      }
      paramc = paramc.dtq();
      d locald = d.AjH;
      paramc.c(d.dTq(), (kotlin.g.a.a)ax.g.xCI);
    }
    AppMethodBeat.o(287869);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$feedLoader$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    a(FinderTimelineFeedLoader paramFinderTimelineFeedLoader, ax paramax) {}
    
    public final void call(final int paramInt)
    {
      AppMethodBeat.i(278013);
      Log.i(this.xCi.getTAG(), "[initData] canTimelineRefresh=" + ax.g(jdField_this) + ", incrementCount=" + paramInt);
      if (ax.g(jdField_this))
      {
        localObject = jdField_this;
        if (paramInt <= 0) {}
        for (boolean bool = true;; bool = false)
        {
          ax.a((ax)localObject, bool);
          AppMethodBeat.o(278013);
          return;
        }
      }
      Object localObject = ax.d(jdField_this).RI(4);
      paramInt = ((b.a)localObject).Bgy;
      final int i = ((b.a)localObject).Bgz;
      ax.a(jdField_this, i);
      Log.i(this.xCi.getTAG(), "[initData] canTimelineRefresh " + ax.g(jdField_this) + " lastPos=" + paramInt + " fromTopPixel=" + i);
      RecyclerView.LayoutManager localLayoutManager = jdField_this.dtw().getRecyclerView().getLayoutManager();
      ax localax = jdField_this;
      com.tencent.mm.plugin.finder.viewmodel.g.a locala = (com.tencent.mm.plugin.finder.viewmodel.g.a)ax.h(jdField_this).Bgm.get(Integer.valueOf(4));
      localObject = locala;
      if (locala == null) {
        localObject = new com.tencent.mm.plugin.finder.viewmodel.g.a();
      }
      ax.a(localax, ((com.tencent.mm.plugin.finder.viewmodel.g.a)localObject).Bhr);
      jdField_this.dtx();
      if ((localLayoutManager instanceof StaggeredGridLayoutManager))
      {
        ((StaggeredGridLayoutManager)localLayoutManager).au(paramInt, i);
        jdField_this.dtw().getRecyclerView().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(289802);
            ((StaggeredGridLayoutManager)this.$layoutManager).au(paramInt, i);
            AppMethodBeat.o(289802);
          }
        });
      }
      AppMethodBeat.o(278013);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(220952);
      this.$rlLayout.Id(this.$isSilence);
      AppMethodBeat.o(220952);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<IResponse<bu>, x>
  {
    d(ax paramax)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class e
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(277350);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(277350);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(277348);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = this.xCE;
      ax.a(paramRecyclerView, ax.b(paramRecyclerView) - paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(277348);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$3", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class f
    extends IListener<iv>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$3$callback$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(ax.f paramf, iv paramiv)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    public h(ax paramax)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(RecyclerView.LayoutManager paramLayoutManager, kotlin.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(251933);
      ((StaggeredGridLayoutManager)this.$layoutManager).au(0, 0);
      kotlin.g.a.a locala = parama;
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(251933);
        return;
      }
      AppMethodBeat.o(251933);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class j
    implements com.tencent.mm.view.j
  {
    private WxRecyclerAdapter<?> getAdapter()
    {
      AppMethodBeat.i(289493);
      WxRecyclerAdapter localWxRecyclerAdapter = this.xCE.dtw().dtv();
      AppMethodBeat.o(289493);
      return localWxRecyclerAdapter;
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(289494);
      int i = ax.e(this.xCE).getSize();
      ax.e(this.xCE).getDataListJustForAdapter().clear();
      onItemRangeRemoved(0, i);
      ax.e(this.xCE).getDataListJustForAdapter().addAll((Collection)ax.f(this.xCE).getDataListJustForAdapter());
      onItemRangeInserted(0, ax.f(this.xCE).getSize());
      AppMethodBeat.o(289494);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(289495);
      Object localObject = this.xCE.dtw();
      if (localObject != null)
      {
        localObject = ((aw.b)localObject).dtq();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.YSk.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeChanged(i + paramInt1, paramInt2);
            AppMethodBeat.o(289495);
            return;
          }
        }
      }
      AppMethodBeat.o(289495);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(289496);
      Object localObject = this.xCE.dtw();
      if (localObject != null)
      {
        localObject = ((aw.b)localObject).dtq();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.YSk.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeChanged(i + paramInt1, paramInt2, paramObject);
            AppMethodBeat.o(289496);
            return;
          }
        }
      }
      AppMethodBeat.o(289496);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(289498);
      Object localObject = this.xCE.dtw();
      if (localObject != null)
      {
        localObject = ((aw.b)localObject).dtq();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.YSk.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeInserted(i + paramInt1, paramInt2);
            AppMethodBeat.o(289498);
            return;
          }
        }
      }
      AppMethodBeat.o(289498);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(289499);
      Object localObject = this.xCE.dtw();
      if (localObject != null)
      {
        localObject = ((aw.b)localObject).dtq();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.YSk.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeRemoved(i + paramInt1, paramInt2);
            AppMethodBeat.o(289499);
            return;
          }
        }
      }
      AppMethodBeat.o(289499);
    }
    
    public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(289501);
      p.k(paramc, "reason");
      this.xCE.dtw().dtq().onPreFinishLoadMore(paramc);
      AppMethodBeat.o(289501);
    }
    
    public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(289502);
      p.k(paramc, "reason");
      this.xCE.dtw().dtq().onPreFinishLoadMoreSmooth(paramc);
      AppMethodBeat.o(289502);
    }
    
    public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(289500);
      p.k(paramc, "reason");
      this.xCE.dtw().dtq().onPreFinishRefresh(paramc);
      AppMethodBeat.o(289500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ax
 * JD-Core Version:    0.7.0.1
 */