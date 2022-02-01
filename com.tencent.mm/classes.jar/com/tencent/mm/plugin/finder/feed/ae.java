package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c.a;
import com.tencent.mm.plugin.finder.feed.model.m;
import com.tencent.mm.plugin.finder.feed.model.x;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.h;
import com.tencent.mm.plugin.finder.view.FinderTagView;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.aiv;
import com.tencent.mm.protocal.protobuf.aiw;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.cnx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ah.a;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "canTimelineRefresh", "", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "headerSearchData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderSearchData;", "headerTagsData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "getHeaderTagsData", "()Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "setHeaderTagsData", "(Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;)V", "msgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "relFeedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "selectedTag", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tagsCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM;", "tagsData", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "findFirstPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "initDataFromCache", "forceCache", "refreshHeader", "initTagHeader", "notifyChanged", "rv", "itemId", "onActionbarClick", "onAttach", "callback", "onCategoryLoadMore", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onUserVisibleFocused", "refreshMsgNotify", "refreshOnCategoryClick", "removeTagFlowView", "scrollToTop", "endCallBack", "Lkotlin/Function0;", "Companion", "plugin-finder_release"})
public final class ae
  implements ad.a
{
  public static final ae.a rkx;
  private final MMActivity activity;
  private com.tencent.mm.sdk.b.c<hk> rhM;
  public final FinderHomeTabStateVM rjC;
  private final boolean rjD;
  public int rjE;
  private com.tencent.mm.view.d rjI;
  public final m rke;
  private final com.tencent.mm.plugin.finder.model.f rkf;
  private final com.tencent.mm.plugin.finder.feed.model.e rkq;
  public final FinderTagCacheVM rkr;
  public ad.b rks;
  private final com.tencent.mm.plugin.finder.model.g rkt;
  public aiw rku;
  private aop rkv;
  private h rkw;
  
  static
  {
    AppMethodBeat.i(201936);
    rkx = new ae.a((byte)0);
    AppMethodBeat.o(201936);
  }
  
  public ae(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(201935);
    this.activity = paramMMActivity;
    paramMMActivity = com.tencent.mm.plugin.finder.feed.model.internal.c.roo;
    int i = c.a.DJ(4).value;
    paramMMActivity = com.tencent.mm.ui.component.a.IrY;
    this.rkq = new com.tencent.mm.plugin.finder.feed.model.e(0L, 4, null, i, ((FinderReporterUIC)com.tencent.mm.ui.component.a.q(this.activity).get(FinderReporterUIC.class)).cGb(), 4);
    paramMMActivity = com.tencent.mm.ui.component.a.IrY;
    paramMMActivity = com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class);
    k.g(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.rjC = ((FinderHomeTabStateVM)paramMMActivity);
    paramMMActivity = com.tencent.mm.ui.component.a.IrY;
    paramMMActivity = com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderTagCacheVM.class);
    k.g(paramMMActivity, "UICProvider.of(PluginFin…erTagCacheVM::class.java)");
    this.rkr = ((FinderTagCacheVM)paramMMActivity);
    this.rjD = this.rjC.ES(4);
    this.rkt = new com.tencent.mm.plugin.finder.model.g();
    paramMMActivity = com.tencent.mm.plugin.finder.feed.model.internal.c.roo;
    paramMMActivity = c.a.DJ(4);
    if (this.rjD) {}
    for (i = 0;; i = 1)
    {
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.IrY;
      this.rke = new m(paramMMActivity, i, ((FinderReporterUIC)com.tencent.mm.ui.component.a.q(this.activity).get(FinderReporterUIC.class)).cGb());
      this.rjI = ((com.tencent.mm.view.d)new j(this));
      this.rkw = new h(new cnx());
      this.rkf = new com.tencent.mm.plugin.finder.model.f();
      AppMethodBeat.o(201935);
      return;
    }
  }
  
  public final void Xa()
  {
    AppMethodBeat.i(201928);
    if (this.rkv != null)
    {
      ac.d("Finder.TimelineMachinePresenter", "loadMore category feed:" + this.rkv);
      com.tencent.mm.plugin.finder.feed.model.e locale = this.rkq;
      Object localObject = this.rkv;
      if (localObject != null) {}
      for (localObject = ((aop)localObject).dol;; localObject = null)
      {
        locale.category = ((String)localObject);
        this.rkq.rmK = 1;
        this.rkq.requestLoadMore();
        AppMethodBeat.o(201928);
        return;
      }
    }
    ac.d("Finder.TimelineMachinePresenter", "loadMore tl feed:");
    this.rke.requestLoadMore();
    AppMethodBeat.o(201928);
  }
  
  public final void a(ad.b paramb)
  {
    AppMethodBeat.i(201930);
    k.h(paramb, "callback");
    this.rks = paramb;
    ad.b localb = this.rks;
    if (localb == null) {
      k.aVY("viewCallback");
    }
    localb.U((ArrayList)this.rke.getDataListJustForAdapter());
    this.rke.register((com.tencent.mm.view.d)paramb.cvl(), this.activity);
    this.rkq.register(this.rjI, this.activity);
    final int i = this.rjC.EU(4).sbU.size();
    this.rke.initData((com.tencent.mm.plugin.finder.feed.model.internal.g)new x(i, false, (com.tencent.mm.plugin.finder.feed.model.internal.f)new c(this, i)), true);
    this.rke.rni = ((d.g.a.b)new d(this));
    paramb = this.rks;
    if (paramb == null) {
      k.aVY("viewCallback");
    }
    paramb.getRecyclerView().a((RecyclerView.m)new e(this));
    this.rhM = ((com.tencent.mm.sdk.b.c)new f(this));
    com.tencent.mm.sdk.b.a.GpY.b(this.rhM);
    AppMethodBeat.o(201930);
  }
  
  public final void b(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(201927);
    k.h(paramc, "reason");
    if (paramc.Jyc <= 0)
    {
      paramc = this.rks;
      if (paramc == null) {
        k.aVY("viewCallback");
      }
      paramc = paramc.cvl();
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      paramc.b(com.tencent.mm.plugin.finder.storage.b.czS(), (d.g.a.a)ae.g.rkE);
    }
    AppMethodBeat.o(201927);
  }
  
  public final void con()
  {
    AppMethodBeat.i(201926);
    if (this.rkv != null)
    {
      ac.d("Finder.TimelineMachinePresenter", "refresh category feed:" + this.rkv);
      com.tencent.mm.plugin.finder.feed.model.e locale = this.rkq;
      Object localObject = this.rkv;
      if (localObject != null) {}
      for (localObject = ((aop)localObject).dol;; localObject = null)
      {
        locale.category = ((String)localObject);
        this.rkq.rmK = 1;
        this.rkq.requestRefresh();
        AppMethodBeat.o(201926);
        return;
      }
    }
    ac.d("Finder.TimelineMachinePresenter", "refresh tl feed:");
    this.rke.requestRefresh();
    AppMethodBeat.o(201926);
  }
  
  public final List<d.b> cvf()
  {
    AppMethodBeat.i(201929);
    Object localObject1 = new LinkedList();
    Object localObject2 = com.tencent.mm.kernel.g.agR();
    k.g(localObject2, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.e)localObject2).agA().getInt(ah.a.GUV, 0);
    localObject2 = com.tencent.mm.kernel.g.agR();
    k.g(localObject2, "MMKernel.storage()");
    int j = ((com.tencent.mm.kernel.e)localObject2).agA().getInt(ah.a.GUW, 0);
    localObject2 = com.tencent.mm.kernel.g.agR();
    k.g(localObject2, "MMKernel.storage()");
    int k = ((com.tencent.mm.kernel.e)localObject2).agA().getInt(ah.a.GUX, 0);
    localObject2 = com.tencent.mm.kernel.g.agR();
    k.g(localObject2, "MMKernel.storage()");
    int m = ((com.tencent.mm.kernel.e)localObject2).agA().getInt(ah.a.GUY, 0);
    this.rkf.count = (i + j + k + m);
    localObject2 = this.rkf;
    Object localObject3 = com.tencent.mm.kernel.g.agR();
    k.g(localObject3, "MMKernel.storage()");
    localObject3 = ((com.tencent.mm.kernel.e)localObject3).agA().get(ah.a.GUZ, "");
    if (localObject3 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(201929);
      throw ((Throwable)localObject1);
    }
    ((com.tencent.mm.plugin.finder.model.f)localObject2).setAvatar((String)localObject3);
    ((LinkedList)localObject1).add(this.rkf);
    ((LinkedList)localObject1).add(this.rkt);
    ((LinkedList)localObject1).add(this.rkw);
    localObject1 = (List)localObject1;
    AppMethodBeat.o(201929);
    return localObject1;
  }
  
  public final ad.b cvp()
  {
    AppMethodBeat.i(201925);
    ad.b localb = this.rks;
    if (localb == null) {
      k.aVY("viewCallback");
    }
    AppMethodBeat.o(201925);
    return localb;
  }
  
  public final void cvq()
  {
    AppMethodBeat.i(201933);
    if (this.rku != null)
    {
      Object localObject1 = new cnx();
      ((cnx)localObject1).FBb = new LinkedList();
      Object localObject2 = this.rku;
      if (localObject2 == null) {
        k.fOy();
      }
      localObject2 = ((aiw)localObject2).EDC;
      k.g(localObject2, "tagsData!!.categoryInfo");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        aiv localaiv = (aiv)((Iterator)localObject2).next();
        aop localaop = new aop();
        localaop.dol = localaiv.sLh;
        ((cnx)localObject1).FBb.add(localaop);
      }
      this.rkw.a((cnx)localObject1);
      localObject1 = this.rks;
      if (localObject1 == null) {
        k.aVY("viewCallback");
      }
      com.tencent.mm.view.recyclerview.d.a(((ad.b)localObject1).cvo(), this.rkw.hashCode());
      localObject1 = this.rks;
      if (localObject1 == null) {
        k.aVY("viewCallback");
      }
      localObject1 = ((ad.b)localObject1).getRootView();
      localObject2 = FinderTagView.rYW;
      localObject1 = ((View)localObject1).findViewById(FinderTagView.cFh());
      if (localObject1 != null)
      {
        localObject2 = this.rks;
        if (localObject2 == null) {
          k.aVY("viewCallback");
        }
        localObject2 = ((ad.b)localObject2).getRootView();
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(201933);
          throw ((Throwable)localObject1);
        }
        ((ViewGroup)localObject2).removeView((View)localObject1);
      }
      localObject1 = this.rks;
      if (localObject1 == null) {
        k.aVY("viewCallback");
      }
      com.tencent.mm.view.recyclerview.d.a(((ad.b)localObject1).cvo(), (d.b)this.rkw);
    }
    AppMethodBeat.o(201933);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(201934);
    m localm = this.rke;
    ad.b localb = this.rks;
    if (localb == null) {
      k.aVY("viewCallback");
    }
    localm.unregister((com.tencent.mm.view.d)localb.cvl(), this.activity);
    com.tencent.mm.sdk.b.a.GpY.d(this.rhM);
    AppMethodBeat.o(201934);
  }
  
  public final void v(final d.g.a.a<y> parama)
  {
    AppMethodBeat.i(201932);
    Object localObject = this.rks;
    if (localObject == null) {
      k.aVY("viewCallback");
    }
    localObject = ((ad.b)localObject).getRecyclerView().getLayoutManager();
    if ((localObject instanceof StaggeredGridLayoutManager))
    {
      ((StaggeredGridLayoutManager)localObject).af(0, 0);
      ad.b localb = this.rks;
      if (localb == null) {
        k.aVY("viewCallback");
      }
      localb.getRecyclerView().post((Runnable)new i((RecyclerView.i)localObject, parama));
    }
    AppMethodBeat.o(201932);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(201904);
      this.rjL.yt(this.rjM);
      AppMethodBeat.o(201904);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$initDataFromCache$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class c
    implements com.tencent.mm.plugin.finder.feed.model.internal.f
  {
    c(boolean paramBoolean1, boolean paramBoolean2) {}
    
    public final void call(final int paramInt)
    {
      boolean bool = false;
      AppMethodBeat.i(201906);
      ac.i("Finder.TimelineMachinePresenter", "[initData] canTimelineRefresh=" + ae.g(this.rky) + ", incrementCount=" + paramInt);
      if ((!this.rkz) && (ae.g(this.rky)))
      {
        localObject = this.rky;
        if (paramInt <= 0) {
          bool = true;
        }
        ae.a((ae)localObject, bool);
        AppMethodBeat.o(201906);
        return;
      }
      Object localObject = ae.d(this.rky).EU(4);
      if (this.rkz)
      {
        paramInt = 0;
        if (!this.rkz) {
          break label330;
        }
      }
      label330:
      for (final int i = 0;; i = ((FinderHomeTabStateVM.a)localObject).sbX)
      {
        ae.a(this.rky, i);
        ac.i("Finder.TimelineMachinePresenter", "[initData] canTimelineRefresh " + ae.g(this.rky) + " lastPos=" + paramInt + " fromTopPixel=" + i + " initCount=:" + i);
        RecyclerView.i locali = this.rky.cvp().getRecyclerView().getLayoutManager();
        if (this.rkA)
        {
          ae localae = this.rky;
          FinderTagCacheVM.a locala = (FinderTagCacheVM.a)ae.h(this.rky).sbP.get(Integer.valueOf(4));
          localObject = locala;
          if (locala == null) {
            localObject = new FinderTagCacheVM.a();
          }
          ae.a(localae, ((FinderTagCacheVM.a)localObject).scY);
          this.rky.cvq();
        }
        if ((locali instanceof StaggeredGridLayoutManager))
        {
          ((StaggeredGridLayoutManager)locali).af(paramInt, i);
          this.rky.cvp().getRecyclerView().post((Runnable)new a(locali, paramInt, i));
        }
        AppMethodBeat.o(201906);
        return;
        paramInt = ((FinderHomeTabStateVM.a)localObject).sbW;
        break;
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(RecyclerView.i parami, int paramInt1, int paramInt2) {}
      
      public final void run()
      {
        AppMethodBeat.i(201905);
        ((StaggeredGridLayoutManager)this.rjQ).af(paramInt, i);
        AppMethodBeat.o(201905);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<IResponse<BaseFinderFeed>, y>
  {
    d(ae paramae)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class e
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201908);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt1);
      localb.lS(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
      k.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = this.rky;
      ae.a(paramRecyclerView, ae.b(paramRecyclerView) - paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(201908);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(201909);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
      super.b(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(201909);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$3", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class f
    extends com.tencent.mm.sdk.b.c<hk>
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$3$callback$1$1"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(ae.f paramf, hk paramhk)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public h(ae paramae)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(RecyclerView.i parami, d.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(201917);
      ((StaggeredGridLayoutManager)this.rjQ).af(0, 0);
      d.g.a.a locala = parama;
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(201917);
        return;
      }
      AppMethodBeat.o(201917);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class j
    implements com.tencent.mm.view.d
  {
    private WxRecyclerAdapter<?> getAdapter()
    {
      AppMethodBeat.i(201918);
      WxRecyclerAdapter localWxRecyclerAdapter = this.rky.cvp().cvo();
      AppMethodBeat.o(201918);
      return localWxRecyclerAdapter;
    }
    
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201921);
      Object localObject = this.rky.cvp();
      if (localObject != null)
      {
        localObject = ((ad.b)localObject).cvl();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.JCb.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).at(i + paramInt1, paramInt2);
            AppMethodBeat.o(201921);
            return;
          }
        }
      }
      AppMethodBeat.o(201921);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201922);
      Object localObject = this.rky.cvp();
      if (localObject != null)
      {
        localObject = ((ad.b)localObject).cvl();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.JCb.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).au(i + paramInt1, paramInt2);
            AppMethodBeat.o(201922);
            return;
          }
        }
      }
      AppMethodBeat.o(201922);
    }
    
    public final void c(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201923);
      k.h(paramc, "reason");
      this.rky.cvp().cvl().c(paramc);
      AppMethodBeat.o(201923);
    }
    
    public final void d(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201924);
      k.h(paramc, "reason");
      this.rky.cvp().cvl().d(paramc);
      AppMethodBeat.o(201924);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(201920);
      Object localObject = this.rky.cvp();
      if (localObject != null)
      {
        localObject = ((ad.b)localObject).cvl();
        if (localObject != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
          if (localWxRecyclerAdapter != null) {}
          for (int i = localWxRecyclerAdapter.JCb.size();; i = 0)
          {
            ((RefreshLoadMoreLayout)localObject).f(i + paramInt1, paramInt2, paramObject);
            AppMethodBeat.o(201920);
            return;
          }
        }
      }
      AppMethodBeat.o(201920);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(201919);
      int i = ae.e(this.rky).getSize();
      ae.e(this.rky).getDataListJustForAdapter().clear();
      au(0, i);
      ae.e(this.rky).getDataListJustForAdapter().addAll((Collection)ae.f(this.rky).getDataListJustForAdapter());
      at(0, ae.f(this.rky).getSize());
      AppMethodBeat.o(201919);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ae
 * JD-Core Version:    0.7.0.1
 */