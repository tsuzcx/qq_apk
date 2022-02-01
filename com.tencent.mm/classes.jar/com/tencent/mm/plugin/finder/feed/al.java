package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hr;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e.a;
import com.tencent.mm.plugin.finder.model.i;
import com.tencent.mm.plugin.finder.view.FinderTagView;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.all;
import com.tencent.mm.protocal.protobuf.alm;
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "canTimelineRefresh", "", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "headerSearchData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderSearchData;", "headerTagsData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "getHeaderTagsData", "()Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "setHeaderTagsData", "(Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;)V", "msgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "relFeedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "selectedTag", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tagsCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM;", "tagsData", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "findFirstPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "initDataFromCache", "forceCache", "refreshHeader", "initTagHeader", "notifyChanged", "rv", "itemId", "onActionbarClick", "onAttach", "callback", "onCategoryLoadMore", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onUserVisibleFocused", "refreshMsgNotify", "refreshOnCategoryClick", "removeTagFlowView", "scrollToTop", "endCallBack", "Lkotlin/Function0;", "Companion", "plugin-finder_release"})
public final class al
  implements ak.a
{
  public static final b rYY;
  private final MMActivity activity;
  private c<hr> rVT;
  public final FinderTimelineFeedLoader rYC;
  private final com.tencent.mm.plugin.finder.model.g rYD;
  private final FinderFeedRelTimelineLoader rYR;
  public final FinderTagCacheVM rYS;
  public ak.b rYT;
  private final com.tencent.mm.plugin.finder.model.h rYU;
  public alm rYV;
  private asg rYW;
  private i rYX;
  public final FinderHomeTabStateVM rYa;
  private final boolean rYb;
  public int rYc;
  private com.tencent.mm.view.d rYg;
  
  static
  {
    AppMethodBeat.i(202187);
    rYY = new b((byte)0);
    AppMethodBeat.o(202187);
  }
  
  public al(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(202186);
    this.activity = paramMMActivity;
    paramMMActivity = com.tencent.mm.plugin.finder.feed.model.internal.e.scW;
    int i = e.a.ED(4).value;
    paramMMActivity = com.tencent.mm.ui.component.a.KiD;
    this.rYR = new FinderFeedRelTimelineLoader(0L, "", 4, null, i, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.activity).get(FinderReporterUIC.class)).cOu(), 8);
    paramMMActivity = com.tencent.mm.ui.component.a.KiD;
    paramMMActivity = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    p.g(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.rYa = ((FinderHomeTabStateVM)paramMMActivity);
    paramMMActivity = com.tencent.mm.ui.component.a.KiD;
    paramMMActivity = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTagCacheVM.class);
    p.g(paramMMActivity, "UICProvider.of(PluginFin…erTagCacheVM::class.java)");
    this.rYS = ((FinderTagCacheVM)paramMMActivity);
    this.rYb = this.rYa.Gg(4);
    this.rYU = new com.tencent.mm.plugin.finder.model.h();
    paramMMActivity = com.tencent.mm.plugin.finder.feed.model.internal.e.scW;
    paramMMActivity = e.a.ED(4);
    if (this.rYb) {}
    for (i = 0;; i = 1)
    {
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KiD;
      paramMMActivity = new FinderTimelineFeedLoader(paramMMActivity, i, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.activity).get(FinderReporterUIC.class)).cOu());
      paramMMActivity.setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.h)new a(paramMMActivity, this));
      this.rYC = paramMMActivity;
      this.rYg = ((com.tencent.mm.view.d)new j(this));
      this.rYX = new i(new cta());
      this.rYD = new com.tencent.mm.plugin.finder.model.g();
      AppMethodBeat.o(202186);
      return;
    }
  }
  
  public final void Zt()
  {
    AppMethodBeat.i(202179);
    if (this.rYW != null)
    {
      ad.d("Finder.TimelineMachinePresenter", "loadMore category feed:" + this.rYW);
      FinderFeedRelTimelineLoader localFinderFeedRelTimelineLoader = this.rYR;
      Object localObject = this.rYW;
      if (localObject != null) {}
      for (localObject = ((asg)localObject).dzZ;; localObject = null)
      {
        localFinderFeedRelTimelineLoader.category = ((String)localObject);
        this.rYR.rHP = 1;
        this.rYR.requestLoadMore();
        AppMethodBeat.o(202179);
        return;
      }
    }
    ad.d("Finder.TimelineMachinePresenter", "loadMore tl feed:");
    this.rYC.requestLoadMore();
    AppMethodBeat.o(202179);
  }
  
  public final void a(ak.b paramb)
  {
    AppMethodBeat.i(202181);
    p.h(paramb, "callback");
    this.rYT = paramb;
    ak.b localb = this.rYT;
    if (localb == null) {
      p.bcb("viewCallback");
    }
    localb.U((ArrayList)this.rYC.getDataListJustForAdapter());
    this.rYC.register((com.tencent.mm.view.d)paramb.cBD());
    this.rYR.register(this.rYg);
    this.rYa.Gi(4).sZm.size();
    BaseFeedLoader.requestInit$default(this.rYC, false, 1, null);
    this.rYC.sbS = ((d.g.a.b)new d(this));
    paramb = this.rYT;
    if (paramb == null) {
      p.bcb("viewCallback");
    }
    paramb.getRecyclerView().a((RecyclerView.m)new e(this));
    this.rVT = ((c)new f(this));
    com.tencent.mm.sdk.b.a.IbL.b(this.rVT);
    AppMethodBeat.o(202181);
  }
  
  public final void b(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202178);
    p.h(paramc, "reason");
    if (paramc.Lrj <= 0)
    {
      paramc = this.rYT;
      if (paramc == null) {
        p.bcb("viewCallback");
      }
      paramc = paramc.cBD();
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
      paramc.b(com.tencent.mm.plugin.finder.storage.b.cGv(), (d.g.a.a)al.g.rZd);
    }
    AppMethodBeat.o(202178);
  }
  
  public final ak.b cBH()
  {
    AppMethodBeat.i(202176);
    ak.b localb = this.rYT;
    if (localb == null) {
      p.bcb("viewCallback");
    }
    AppMethodBeat.o(202176);
    return localb;
  }
  
  public final void cBI()
  {
    AppMethodBeat.i(202184);
    if (this.rYV != null)
    {
      Object localObject1 = new cta();
      ((cta)localObject1).Hlo = new LinkedList();
      Object localObject2 = this.rYV;
      if (localObject2 == null) {
        p.gfZ();
      }
      localObject2 = ((alm)localObject2).Glm;
      p.g(localObject2, "tagsData!!.categoryInfo");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        all localall = (all)((Iterator)localObject2).next();
        asg localasg = new asg();
        localasg.dzZ = localall.tHQ;
        ((cta)localObject1).Hlo.add(localasg);
      }
      this.rYX.a((cta)localObject1);
      localObject1 = this.rYT;
      if (localObject1 == null) {
        p.bcb("viewCallback");
      }
      com.tencent.mm.view.recyclerview.d.a(((ak.b)localObject1).cBG(), this.rYX.hashCode());
      localObject1 = this.rYT;
      if (localObject1 == null) {
        p.bcb("viewCallback");
      }
      localObject1 = ((ak.b)localObject1).getRootView();
      localObject2 = FinderTagView.sVS;
      localObject1 = ((View)localObject1).findViewById(FinderTagView.cNB());
      if (localObject1 != null)
      {
        localObject2 = this.rYT;
        if (localObject2 == null) {
          p.bcb("viewCallback");
        }
        localObject2 = ((ak.b)localObject2).getRootView();
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(202184);
          throw ((Throwable)localObject1);
        }
        ((ViewGroup)localObject2).removeView((View)localObject1);
      }
      localObject1 = this.rYT;
      if (localObject1 == null) {
        p.bcb("viewCallback");
      }
      com.tencent.mm.view.recyclerview.d.a(((ak.b)localObject1).cBG(), (d.b)this.rYX);
    }
    AppMethodBeat.o(202184);
  }
  
  public final List<d.b> cBx()
  {
    AppMethodBeat.i(202180);
    Object localObject1 = new LinkedList();
    Object localObject2 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject2, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.e)localObject2).ajl().getInt(com.tencent.mm.storage.al.a.IHC, 0);
    localObject2 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject2, "MMKernel.storage()");
    int j = ((com.tencent.mm.kernel.e)localObject2).ajl().getInt(com.tencent.mm.storage.al.a.IHD, 0);
    localObject2 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject2, "MMKernel.storage()");
    int k = ((com.tencent.mm.kernel.e)localObject2).ajl().getInt(com.tencent.mm.storage.al.a.IHE, 0);
    localObject2 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject2, "MMKernel.storage()");
    int m = ((com.tencent.mm.kernel.e)localObject2).ajl().getInt(com.tencent.mm.storage.al.a.IHF, 0);
    localObject2 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject2, "MMKernel.storage()");
    int n = ((com.tencent.mm.kernel.e)localObject2).ajl().getInt(com.tencent.mm.storage.al.a.IHG, 0);
    this.rYD.count = (i + j + k + m + n);
    localObject2 = this.rYD;
    Object localObject3 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject3, "MMKernel.storage()");
    localObject3 = ((com.tencent.mm.kernel.e)localObject3).ajl().get(com.tencent.mm.storage.al.a.IHH, "");
    if (localObject3 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(202180);
      throw ((Throwable)localObject1);
    }
    ((com.tencent.mm.plugin.finder.model.g)localObject2).setAvatar((String)localObject3);
    ((LinkedList)localObject1).add(this.rYD);
    ((LinkedList)localObject1).add(this.rYU);
    ((LinkedList)localObject1).add(this.rYX);
    localObject1 = (List)localObject1;
    AppMethodBeat.o(202180);
    return localObject1;
  }
  
  public final void ctS()
  {
    AppMethodBeat.i(202177);
    if (this.rYW != null)
    {
      ad.d("Finder.TimelineMachinePresenter", "refresh category feed:" + this.rYW);
      FinderFeedRelTimelineLoader localFinderFeedRelTimelineLoader = this.rYR;
      Object localObject = this.rYW;
      if (localObject != null) {}
      for (localObject = ((asg)localObject).dzZ;; localObject = null)
      {
        localFinderFeedRelTimelineLoader.category = ((String)localObject);
        this.rYR.rHP = 1;
        this.rYR.requestRefresh();
        AppMethodBeat.o(202177);
        return;
      }
    }
    ad.d("Finder.TimelineMachinePresenter", "refresh tl feed:");
    this.rYC.requestRefresh();
    AppMethodBeat.o(202177);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(202185);
    FinderTimelineFeedLoader localFinderTimelineFeedLoader = this.rYC;
    ak.b localb = this.rYT;
    if (localb == null) {
      p.bcb("viewCallback");
    }
    localFinderTimelineFeedLoader.unregister((com.tencent.mm.view.d)localb.cBD());
    com.tencent.mm.sdk.b.a.IbL.d(this.rVT);
    AppMethodBeat.o(202185);
  }
  
  public final void z(final d.g.a.a<z> parama)
  {
    AppMethodBeat.i(202183);
    Object localObject = this.rYT;
    if (localObject == null) {
      p.bcb("viewCallback");
    }
    localObject = ((ak.b)localObject).getRecyclerView().getLayoutManager();
    if ((localObject instanceof StaggeredGridLayoutManager))
    {
      ((StaggeredGridLayoutManager)localObject).ag(0, 0);
      ak.b localb = this.rYT;
      if (localb == null) {
        p.bcb("viewCallback");
      }
      localb.getRecyclerView().post((Runnable)new i((RecyclerView.i)localObject, parama));
    }
    AppMethodBeat.o(202183);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$feedLoader$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.plugin.finder.feed.model.internal.h
  {
    a(FinderTimelineFeedLoader paramFinderTimelineFeedLoader, al paramal) {}
    
    public final void call(final int paramInt)
    {
      AppMethodBeat.i(202156);
      ad.i(this.rYF.getTAG(), "[initData] canTimelineRefresh=" + al.g(jdField_this) + ", incrementCount=" + paramInt);
      if (al.g(jdField_this))
      {
        localObject = jdField_this;
        if (paramInt <= 0) {}
        for (boolean bool = true;; bool = false)
        {
          al.a((al)localObject, bool);
          AppMethodBeat.o(202156);
          return;
        }
      }
      Object localObject = al.d(jdField_this).Gi(4);
      paramInt = ((FinderHomeTabStateVM.a)localObject).sZo;
      final int i = ((FinderHomeTabStateVM.a)localObject).sZp;
      al.a(jdField_this, i);
      ad.i(this.rYF.getTAG(), "[initData] canTimelineRefresh " + al.g(jdField_this) + " lastPos=" + paramInt + " fromTopPixel=" + i);
      RecyclerView.i locali = jdField_this.cBH().getRecyclerView().getLayoutManager();
      al localal = jdField_this;
      FinderTagCacheVM.a locala = (FinderTagCacheVM.a)al.h(jdField_this).sZf.get(Integer.valueOf(4));
      localObject = locala;
      if (locala == null) {
        localObject = new FinderTagCacheVM.a();
      }
      al.a(localal, ((FinderTagCacheVM.a)localObject).taz);
      jdField_this.cBI();
      if ((locali instanceof StaggeredGridLayoutManager))
      {
        ((StaggeredGridLayoutManager)locali).ag(paramInt, i);
        jdField_this.cBH().getRecyclerView().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(202155);
            ((StaggeredGridLayoutManager)this.rYo).ag(paramInt, i);
            AppMethodBeat.o(202155);
          }
        });
      }
      AppMethodBeat.o(202156);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(202157);
      this.rYj.zg(this.rYk);
      AppMethodBeat.o(202157);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<IResponse<com.tencent.mm.plugin.finder.model.al>, z>
  {
    d(al paramal)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class e
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202159);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt1);
      localb.mr(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
      p.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = this.rYZ;
      al.a(paramRecyclerView, al.b(paramRecyclerView) - paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(202159);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(202160);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
      super.b(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(202160);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$3", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class f
    extends c<hr>
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$3$callback$1$1"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(al.f paramf, hr paramhr)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class h
    extends q
    implements d.g.a.a<z>
  {
    public h(al paramal)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(RecyclerView.i parami, d.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(202168);
      ((StaggeredGridLayoutManager)this.rYo).ag(0, 0);
      d.g.a.a locala = parama;
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(202168);
        return;
      }
      AppMethodBeat.o(202168);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class j
    implements com.tencent.mm.view.d
  {
    private WxRecyclerAdapter<?> getAdapter()
    {
      AppMethodBeat.i(202169);
      WxRecyclerAdapter localWxRecyclerAdapter = this.rYZ.cBH().cBG();
      AppMethodBeat.o(202169);
      return localWxRecyclerAdapter;
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202172);
      Object localObject = this.rYZ.cBH();
      if (localObject != null)
      {
        localObject = ((ak.b)localObject).cBD();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.Lvi.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).au(i + paramInt1, paramInt2);
            AppMethodBeat.o(202172);
            return;
          }
        }
      }
      AppMethodBeat.o(202172);
    }
    
    public final void av(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202173);
      Object localObject = this.rYZ.cBH();
      if (localObject != null)
      {
        localObject = ((ak.b)localObject).cBD();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.Lvi.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).av(i + paramInt1, paramInt2);
            AppMethodBeat.o(202173);
            return;
          }
        }
      }
      AppMethodBeat.o(202173);
    }
    
    public final void c(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202174);
      p.h(paramc, "reason");
      this.rYZ.cBH().cBD().c(paramc);
      AppMethodBeat.o(202174);
    }
    
    public final void d(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202175);
      p.h(paramc, "reason");
      this.rYZ.cBH().cBD().d(paramc);
      AppMethodBeat.o(202175);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(202171);
      Object localObject = this.rYZ.cBH();
      if (localObject != null)
      {
        localObject = ((ak.b)localObject).cBD();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.Lvi.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).f(i + paramInt1, paramInt2, paramObject);
            AppMethodBeat.o(202171);
            return;
          }
        }
      }
      AppMethodBeat.o(202171);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(202170);
      int i = al.e(this.rYZ).getSize();
      al.e(this.rYZ).getDataListJustForAdapter().clear();
      av(0, i);
      al.e(this.rYZ).getDataListJustForAdapter().addAll((Collection)al.f(this.rYZ).getDataListJustForAdapter());
      au(0, al.f(this.rYZ).getSize());
      AppMethodBeat.o(202170);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.al
 * JD-Core Version:    0.7.0.1
 */