package com.tencent.mm.plugin.finder.feed;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.js;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.g.a;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.view.FinderTagView;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.d.a;
import com.tencent.mm.plugin.finder.viewmodel.i.a;
import com.tencent.mm.protocal.protobuf.auj;
import com.tencent.mm.protocal.protobuf.auk;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.protocal.protobuf.epc;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "canTimelineRefresh", "", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "headerSearchData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderSearchData;", "headerTagsData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "getHeaderTagsData", "()Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "setHeaderTagsData", "(Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;)V", "msgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "relFeedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "selectedTag", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tagsCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM;", "tagsData", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "findFirstPosition", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "initDataFromCache", "forceCache", "refreshHeader", "initTagHeader", "notifyChanged", "rv", "itemId", "onActionbarClick", "onAttach", "callback", "onCategoryLoadMore", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onUserVisibleFocused", "refreshMsgNotify", "refreshOnCategoryClick", "removeTagFlowView", "scrollToTop", "endCallBack", "Lkotlin/Function0;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class be
  implements bd.a
{
  public static final a AZA;
  private final FinderFeedRelTimelineLoader AZB;
  public final com.tencent.mm.plugin.finder.viewmodel.i AZC;
  public bd.b AZD;
  private final com.tencent.mm.plugin.finder.model.i AZE;
  public auk AZF;
  private bxv AZG;
  private com.tencent.mm.plugin.finder.model.j AZH;
  public final com.tencent.mm.plugin.finder.viewmodel.d AZj;
  public final FinderTimelineFeedLoader AZs;
  private final MMActivity activity;
  private final boolean canTimelineRefresh;
  private final com.tencent.mm.plugin.finder.model.h msgNotifyData;
  private IListener<js> qmO;
  private com.tencent.mm.view.k tagViewActionCallback;
  public int totalDy;
  
  static
  {
    AppMethodBeat.i(362988);
    AZA = new a((byte)0);
    AppMethodBeat.o(362988);
  }
  
  public be(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(362886);
    this.activity = paramMMActivity;
    paramMMActivity = g.Bkb;
    int i = g.a.Od(4).value;
    paramMMActivity = com.tencent.mm.ui.component.k.aeZF;
    this.AZB = new FinderFeedRelTimelineLoader(0L, "", 4, null, i, false, null, null, null, 0, ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.activity).q(as.class)).fou(), 0.0F, 0.0F, 28648);
    paramMMActivity = com.tencent.mm.ui.component.k.aeZF;
    paramMMActivity = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class);
    s.s(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.AZj = ((com.tencent.mm.plugin.finder.viewmodel.d)paramMMActivity);
    paramMMActivity = com.tencent.mm.ui.component.k.aeZF;
    paramMMActivity = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.i.class);
    s.s(paramMMActivity, "UICProvider.of(PluginFin…erTagCacheVM::class.java)");
    this.AZC = ((com.tencent.mm.plugin.finder.viewmodel.i)paramMMActivity);
    this.canTimelineRefresh = this.AZj.Rp(4);
    this.AZE = new com.tencent.mm.plugin.finder.model.i();
    paramMMActivity = g.Bkb;
    paramMMActivity = g.a.Od(4);
    if (this.canTimelineRefresh) {}
    for (i = 0;; i = 1)
    {
      Object localObject = com.tencent.mm.ui.component.k.aeZF;
      paramMMActivity = new FinderTimelineFeedLoader(paramMMActivity, i, ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.activity).q(as.class)).fou());
      paramMMActivity.setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.j)new b(paramMMActivity, this));
      localObject = ah.aiuX;
      this.AZs = paramMMActivity;
      this.tagViewActionCallback = ((com.tencent.mm.view.k)new g(this));
      this.AZH = new com.tencent.mm.plugin.finder.model.j(new epc());
      this.msgNotifyData = new com.tencent.mm.plugin.finder.model.h();
      AppMethodBeat.o(362886);
      return;
    }
  }
  
  private static final void a(RecyclerView.LayoutManager paramLayoutManager, kotlin.g.a.a parama)
  {
    AppMethodBeat.i(362896);
    ((StaggeredGridLayoutManager)paramLayoutManager).bo(0, 0);
    if (parama != null) {
      parama.invoke();
    }
    AppMethodBeat.o(362896);
  }
  
  private static final void autoFlingToRefresh$lambda-6(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, boolean paramBoolean)
  {
    AppMethodBeat.i(362903);
    s.u(paramRefreshLoadMoreLayout, "$rlLayout");
    paramRefreshLoadMoreLayout.bR(paramBoolean, false);
    AppMethodBeat.o(362903);
  }
  
  public final void a(bd.b paramb)
  {
    AppMethodBeat.i(363047);
    s.u(paramb, "callback");
    s.u(paramb, "<set-?>");
    this.AZD = paramb;
    ecG().ae((ArrayList)this.AZs.getDataListJustForAdapter());
    this.AZs.register((com.tencent.mm.view.k)paramb.aNL());
    this.AZB.register(this.tagViewActionCallback);
    this.AZj.UV(4).GKv.size();
    BaseFeedLoader.requestInit$default((BaseFeedLoader)this.AZs, false, 1, null);
    this.AZs.Bje = ((kotlin.g.a.b)new c(this));
    ecG().getRecyclerView().a((RecyclerView.l)new d(this));
    this.qmO = ((IListener)new FinderTimelineMachinePresenter.onAttach.3(this, com.tencent.mm.app.f.hfK));
    paramb = this.qmO;
    if (paramb != null) {
      paramb.alive();
    }
    AppMethodBeat.o(363047);
  }
  
  public final void aR(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(363051);
    RecyclerView.LayoutManager localLayoutManager = ecG().getRecyclerView().getLayoutManager();
    if ((localLayoutManager instanceof StaggeredGridLayoutManager))
    {
      ((StaggeredGridLayoutManager)localLayoutManager).bo(0, 0);
      ecG().getRecyclerView().post(new be..ExternalSyntheticLambda0(localLayoutManager, parama));
    }
    AppMethodBeat.o(363051);
  }
  
  public final bd.b ecG()
  {
    AppMethodBeat.i(363009);
    bd.b localb = this.AZD;
    if (localb != null)
    {
      AppMethodBeat.o(363009);
      return localb;
    }
    s.bIx("viewCallback");
    AppMethodBeat.o(363009);
    return null;
  }
  
  public final void ecH()
  {
    AppMethodBeat.i(363060);
    if (this.AZF != null)
    {
      Object localObject1 = new epc();
      ((epc)localObject1).abtn = new LinkedList();
      Object localObject2 = this.AZF;
      s.checkNotNull(localObject2);
      localObject2 = ((auk)localObject2).ZEO;
      s.s(localObject2, "tagsData!!.categoryInfo");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        auj localauj = (auj)((Iterator)localObject2).next();
        bxv localbxv = new bxv();
        localbxv.topic = localauj.HIH;
        ((epc)localObject1).abtn.add(localbxv);
      }
      this.AZH.a((epc)localObject1);
      com.tencent.mm.view.recyclerview.i.a((com.tencent.mm.view.recyclerview.i)ecG().ecF(), this.AZH.hashCode());
      localObject1 = ecG().getRootView();
      localObject2 = FinderTagView.GCE;
      localObject1 = ((View)localObject1).findViewById(FinderTagView.flo());
      if (localObject1 != null) {
        ((ViewGroup)ecG().getRootView()).removeView((View)localObject1);
      }
      com.tencent.mm.view.recyclerview.i.a((com.tencent.mm.view.recyclerview.i)ecG().ecF(), (i.b)this.AZH);
    }
    AppMethodBeat.o(363060);
  }
  
  public final List<i.b> getHeaderInfo()
  {
    AppMethodBeat.i(363037);
    Object localObject1 = new LinkedList();
    int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcq, 0);
    int j = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcs, 0);
    int k = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adct, 0);
    int m = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcu, 0);
    com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcv, 0);
    int n = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcw, 0);
    this.msgNotifyData.count = (i + j + k + m + n);
    com.tencent.mm.plugin.finder.model.h localh = this.msgNotifyData;
    localh.commentCount = i;
    localh.ECm = n;
    localh.likeCount = (j + k + m);
    localh = this.msgNotifyData;
    Object localObject2 = com.tencent.mm.kernel.h.baE().ban().get(at.a.adcx, "");
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(363037);
      throw ((Throwable)localObject1);
    }
    localh.setAvatar((String)localObject2);
    ((LinkedList)localObject1).add(this.msgNotifyData);
    ((LinkedList)localObject1).add(this.AZE);
    ((LinkedList)localObject1).add(this.AZH);
    localObject1 = (List)localObject1;
    AppMethodBeat.o(363037);
    return localObject1;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(363066);
    this.AZs.unregister((com.tencent.mm.view.k)ecG().aNL());
    IListener localIListener = this.qmO;
    if (localIListener != null) {
      localIListener.dead();
    }
    AppMethodBeat.o(363066);
  }
  
  public final void onLoadMore()
  {
    AppMethodBeat.i(363026);
    if (this.AZG != null)
    {
      Log.d("Finder.TimelineMachinePresenter", s.X("loadMore category feed:", this.AZG));
      FinderFeedRelTimelineLoader localFinderFeedRelTimelineLoader = this.AZB;
      Object localObject = this.AZG;
      if (localObject == null) {}
      for (localObject = null;; localObject = ((bxv)localObject).topic)
      {
        localFinderFeedRelTimelineLoader.kDf = ((String)localObject);
        this.AZB.BfR = 1;
        BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)this.AZB, false, 1, null);
        AppMethodBeat.o(363026);
        return;
      }
    }
    Log.d("Finder.TimelineMachinePresenter", "loadMore tl feed:");
    BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)this.AZs, false, 1, null);
    AppMethodBeat.o(363026);
  }
  
  public final void onRefresh()
  {
    AppMethodBeat.i(363012);
    if (this.AZG != null)
    {
      Log.d("Finder.TimelineMachinePresenter", s.X("refresh category feed:", this.AZG));
      FinderFeedRelTimelineLoader localFinderFeedRelTimelineLoader = this.AZB;
      Object localObject = this.AZG;
      if (localObject == null) {}
      for (localObject = null;; localObject = ((bxv)localObject).topic)
      {
        localFinderFeedRelTimelineLoader.kDf = ((String)localObject);
        this.AZB.BfR = 1;
        this.AZB.requestRefresh();
        AppMethodBeat.o(363012);
        return;
      }
    }
    Log.d("Finder.TimelineMachinePresenter", "refresh tl feed:");
    this.AZs.requestRefresh();
    AppMethodBeat.o(363012);
  }
  
  public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(363018);
    s.u(paramd, "reason");
    if (paramd.agJv <= 0)
    {
      paramd = ecG().aNL();
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      paramd.e(com.tencent.mm.plugin.finder.storage.d.eRF(), (kotlin.g.a.a)be.e.AZK);
    }
    AppMethodBeat.o(363018);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$feedLoader$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    b(FinderTimelineFeedLoader paramFinderTimelineFeedLoader, be parambe) {}
    
    private static final void b(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(363847);
      ((StaggeredGridLayoutManager)paramLayoutManager).bo(paramInt1, paramInt2);
      AppMethodBeat.o(363847);
    }
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(363862);
      Log.i(this.AZu.getTAG(), "[initData] canTimelineRefresh=" + be.g(jdField_this) + ", incrementCount=" + paramInt);
      if (be.g(jdField_this))
      {
        localObject = jdField_this;
        if (paramInt <= 0) {}
        for (boolean bool = true;; bool = false)
        {
          be.a((be)localObject, bool);
          AppMethodBeat.o(363862);
          return;
        }
      }
      Object localObject = be.d(jdField_this).UV(4);
      paramInt = ((d.a)localObject).GKx;
      int i = ((d.a)localObject).GKy;
      be.a(jdField_this, i);
      Log.i(this.AZu.getTAG(), "[initData] canTimelineRefresh " + be.g(jdField_this) + " lastPos=" + paramInt + " fromTopPixel=" + i);
      RecyclerView.LayoutManager localLayoutManager = jdField_this.ecG().getRecyclerView().getLayoutManager();
      be localbe = jdField_this;
      i.a locala = (i.a)be.h(jdField_this).GKl.get(Integer.valueOf(4));
      localObject = locala;
      if (locala == null) {
        localObject = new i.a();
      }
      be.a(localbe, ((i.a)localObject).GLr);
      jdField_this.ecH();
      if ((localLayoutManager instanceof StaggeredGridLayoutManager))
      {
        ((StaggeredGridLayoutManager)localLayoutManager).bo(paramInt, i);
        jdField_this.ecG().getRecyclerView().post(new be.b..ExternalSyntheticLambda0(localLayoutManager, paramInt, i));
      }
      AppMethodBeat.o(363862);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    c(be parambe)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.l
  {
    d(be parambe) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(363724);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(363724);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(363719);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = this.AZI;
      be.a(paramRecyclerView, be.b(paramRecyclerView) - paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(363719);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    public f(be parambe)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements com.tencent.mm.view.k
  {
    g(be parambe) {}
    
    private WxRecyclerAdapter<?> getAdapter()
    {
      AppMethodBeat.i(363737);
      WxRecyclerAdapter localWxRecyclerAdapter = this.AZI.ecG().ecF();
      AppMethodBeat.o(363737);
      return localWxRecyclerAdapter;
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(363746);
      int i = be.e(this.AZI).getSize();
      be.e(this.AZI).getDataListJustForAdapter().clear();
      onItemRangeRemoved(0, i);
      be.e(this.AZI).getDataListJustForAdapter().addAll((Collection)be.f(this.AZI).getDataListJustForAdapter());
      onItemRangeInserted(0, be.f(this.AZI).getSize());
      AppMethodBeat.o(363746);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(363750);
      Object localObject = this.AZI.ecG();
      WxRecyclerAdapter localWxRecyclerAdapter;
      if (localObject != null)
      {
        localObject = ((bd.b)localObject).aNL();
        if (localObject != null)
        {
          localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {
            break label61;
          }
        }
      }
      label61:
      for (int i = 0;; i = localWxRecyclerAdapter.agOb.size())
      {
        ((RefreshLoadMoreLayout)localObject).onItemRangeChanged(i + paramInt1, paramInt2);
        AppMethodBeat.o(363750);
        return;
      }
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(363755);
      Object localObject = this.AZI.ecG();
      WxRecyclerAdapter localWxRecyclerAdapter;
      if (localObject != null)
      {
        localObject = ((bd.b)localObject).aNL();
        if (localObject != null)
        {
          localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {
            break label64;
          }
        }
      }
      label64:
      for (int i = 0;; i = localWxRecyclerAdapter.agOb.size())
      {
        ((RefreshLoadMoreLayout)localObject).onItemRangeChanged(i + paramInt1, paramInt2, paramObject);
        AppMethodBeat.o(363755);
        return;
      }
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(363761);
      Object localObject = this.AZI.ecG();
      WxRecyclerAdapter localWxRecyclerAdapter;
      if (localObject != null)
      {
        localObject = ((bd.b)localObject).aNL();
        if (localObject != null)
        {
          localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {
            break label61;
          }
        }
      }
      label61:
      for (int i = 0;; i = localWxRecyclerAdapter.agOb.size())
      {
        ((RefreshLoadMoreLayout)localObject).onItemRangeInserted(i + paramInt1, paramInt2);
        AppMethodBeat.o(363761);
        return;
      }
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(363766);
      Object localObject = this.AZI.ecG();
      WxRecyclerAdapter localWxRecyclerAdapter;
      if (localObject != null)
      {
        localObject = ((bd.b)localObject).aNL();
        if (localObject != null)
        {
          localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {
            break label61;
          }
        }
      }
      label61:
      for (int i = 0;; i = localWxRecyclerAdapter.agOb.size())
      {
        ((RefreshLoadMoreLayout)localObject).onItemRangeRemoved(i + paramInt1, paramInt2);
        AppMethodBeat.o(363766);
        return;
      }
    }
    
    public final void onPreFinishLoadMore(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(363782);
      s.u(paramd, "reason");
      this.AZI.ecG().aNL().onPreFinishLoadMore(paramd);
      AppMethodBeat.o(363782);
    }
    
    public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(363787);
      s.u(paramd, "reason");
      this.AZI.ecG().aNL().onPreFinishLoadMoreSmooth(paramd);
      AppMethodBeat.o(363787);
    }
    
    public final void onPreFinishRefresh(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(363776);
      s.u(paramd, "reason");
      this.AZI.ecG().aNL().onPreFinishRefresh(paramd);
      AppMethodBeat.o(363776);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.be
 * JD-Core Version:    0.7.0.1
 */