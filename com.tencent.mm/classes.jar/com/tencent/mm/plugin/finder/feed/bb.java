package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ef;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.g.a;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.q;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.v;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.finder.viewmodel.d.a;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", "canTimelineRefresh", "", "emptyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "isEmptyLocation", "isRequestingLbs", "()Z", "setRequestingLbs", "(Z)V", "msgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "checkEmptyHeader", "r", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "findFirstPosition", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "notifyChanged", "rv", "itemId", "onActionbarClick", "isDouble", "onAttach", "callback", "onClickReport", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLbsCardActionReportStruct;", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "feedIndex", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "onUserVisibleFocused", "refreshMsgNotify", "refreshRV", "data", "Landroid/content/Intent;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bb
  implements ay.a<cc>
{
  public static final a AZr;
  private final FinderHomeTabFragment AZg;
  public ay.b<cc> AZi;
  public final com.tencent.mm.plugin.finder.viewmodel.d AZj;
  public final FinderTimelineFeedLoader AZs;
  public final MMActivity activity;
  private final boolean canTimelineRefresh;
  private com.tencent.mm.plugin.finder.model.g emptyData;
  public boolean isEmptyLocation;
  boolean isRequestingLbs;
  private final com.tencent.mm.plugin.finder.model.h msgNotifyData;
  private com.tencent.mm.view.k tagViewActionCallback;
  public int totalDy;
  
  static
  {
    AppMethodBeat.i(362952);
    AZr = new a((byte)0);
    AppMethodBeat.o(362952);
  }
  
  public bb(MMActivity paramMMActivity, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(362873);
    this.activity = paramMMActivity;
    this.AZg = paramFinderHomeTabFragment;
    paramMMActivity = com.tencent.mm.ui.component.k.aeZF;
    paramMMActivity = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class);
    kotlin.g.b.s.s(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.AZj = ((com.tencent.mm.plugin.finder.viewmodel.d)paramMMActivity);
    this.canTimelineRefresh = this.AZj.Rp(2);
    paramMMActivity = com.tencent.mm.plugin.finder.feed.model.internal.g.Bkb;
    paramMMActivity = g.a.Od(2);
    if (this.canTimelineRefresh) {}
    for (int i = 0;; i = 1)
    {
      paramFinderHomeTabFragment = com.tencent.mm.ui.component.k.aeZF;
      paramMMActivity = new FinderTimelineFeedLoader(paramMMActivity, i, ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.activity).q(as.class)).fou());
      paramMMActivity.setInitDone((j)new c(paramMMActivity, this));
      paramFinderHomeTabFragment = ah.aiuX;
      this.AZs = paramMMActivity;
      this.tagViewActionCallback = ((com.tencent.mm.view.k)new k(this));
      this.emptyData = new com.tencent.mm.plugin.finder.model.g();
      this.msgNotifyData = new com.tencent.mm.plugin.finder.model.h();
      AppMethodBeat.o(362873);
      return;
    }
  }
  
  private static final void a(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, boolean paramBoolean)
  {
    AppMethodBeat.i(362894);
    paramRefreshLoadMoreLayout.bR(paramBoolean, false);
    AppMethodBeat.o(362894);
  }
  
  private final void checkEmptyHeader(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(362880);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(paramd, this));
    AppMethodBeat.o(362880);
  }
  
  public static int findFirstPosition(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(362885);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    int i;
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      int[] arrayOfInt = new int[2];
      ((StaggeredGridLayoutManager)paramRecyclerView).n(arrayOfInt);
      i = arrayOfInt[1];
      AppMethodBeat.o(362885);
      return i;
    }
    if ((paramRecyclerView instanceof LinearLayoutManager))
    {
      i = ((LinearLayoutManager)paramRecyclerView).Ju();
      AppMethodBeat.o(362885);
      return i;
    }
    AppMethodBeat.o(362885);
    return 0;
  }
  
  public final void a(ef paramef, q paramq, int paramInt)
  {
    AppMethodBeat.i(363027);
    kotlin.g.b.s.u(paramef, "struct");
    kotlin.g.b.s.u(paramq, "lbsItem");
    AppMethodBeat.o(363027);
  }
  
  public final void a(ay.b<cc> paramb)
  {
    AppMethodBeat.i(363000);
    kotlin.g.b.s.u(paramb, "callback");
    kotlin.g.b.s.u(paramb, "<set-?>");
    this.AZi = paramb;
    ecE().ae((ArrayList)this.AZs.getDataListJustForAdapter());
    this.AZs.register(this.tagViewActionCallback);
    paramb = v.GgU;
    if (v.eot())
    {
      this.AZj.UV(2).GKv.size();
      BaseFeedLoader.requestInit$default((BaseFeedLoader)this.AZs, false, 1, null);
      paramb = ecE().getRecyclerView();
      if (paramb != null)
      {
        paramb.a((RecyclerView.l)new d(this));
        AppMethodBeat.o(363000);
      }
    }
    else
    {
      paramb = new RefreshLoadMoreLayout.d(0);
      paramb.agJs = -2;
      ah localah = ah.aiuX;
      checkEmptyHeader(paramb);
    }
    AppMethodBeat.o(363000);
  }
  
  public final ay.b<cc> ecE()
  {
    AppMethodBeat.i(362968);
    ay.b localb = this.AZi;
    if (localb != null)
    {
      AppMethodBeat.o(362968);
      return localb;
    }
    kotlin.g.b.s.bIx("viewCallback");
    AppMethodBeat.o(362968);
    return null;
  }
  
  public final void nx(long paramLong)
  {
    AppMethodBeat.i(363006);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = ecE().aNL();
    if (localRefreshLoadMoreLayout != null) {
      localRefreshLoadMoreLayout.postDelayed(new bb..ExternalSyntheticLambda0(localRefreshLoadMoreLayout, false), paramLong);
    }
    AppMethodBeat.o(363006);
  }
  
  public final void onActionbarClick(boolean paramBoolean)
  {
    AppMethodBeat.i(363015);
    Object localObject1 = ecE().getRecyclerView();
    if (localObject1 == null)
    {
      AppMethodBeat.o(363015);
      return;
    }
    int i = findFirstPosition((RecyclerView)localObject1);
    Log.i("Finder.TimelineLbsPresenter", "[onActionbarClick] position=" + i + " isDouble=" + paramBoolean);
    Object localObject2;
    if (i <= 12)
    {
      localObject2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      if (!paramBoolean) {
        break label296;
      }
      if (i > 12) {
        break label286;
      }
      nx(20L);
    }
    for (;;)
    {
      localObject1 = as.GSQ;
      localObject1 = as.a.hu((Context)this.activity);
      if (localObject1 == null) {
        break label328;
      }
      localObject2 = z.FrZ;
      z.b(((as)localObject1).fou(), 5);
      AppMethodBeat.o(363015);
      return;
      localObject2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      break;
      label286:
      nx(600L);
    }
    label296:
    localObject1 = as.GSQ;
    localObject1 = as.a.hu((Context)this.activity);
    if (localObject1 != null)
    {
      localObject2 = z.FrZ;
      z.b(((as)localObject1).fou(), 1);
    }
    label328:
    AppMethodBeat.o(363015);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(363019);
    this.AZs.unregister(this.tagViewActionCallback);
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    ((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).UT(2);
    AppMethodBeat.o(363019);
  }
  
  public final void onLoadMore()
  {
    AppMethodBeat.i(362990);
    BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)this.AZs, false, 1, null);
    AppMethodBeat.o(362990);
  }
  
  public final void onRefresh()
  {
    AppMethodBeat.i(362975);
    v localv = v.GgU;
    v.a((kotlin.g.a.a)new e(this), (kotlin.g.a.a)new f(this), (kotlin.g.a.a)new g(this));
    AppMethodBeat.o(362975);
  }
  
  public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(362984);
    kotlin.g.b.s.u(paramd, "reason");
    if (paramd.agJv <= 0)
    {
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = ecE().aNL();
      if (localRefreshLoadMoreLayout != null)
      {
        com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
        localRefreshLoadMoreLayout.e(com.tencent.mm.plugin.finder.storage.d.eRF(), (kotlin.g.a.a)bb.h.AZv);
      }
    }
    checkEmptyHeader(paramd);
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().TL("finder_tl_nearby_tab");
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().hH("finder_tl_nearby_tab", "onRefreshEnd");
    ((ce)com.tencent.mm.kernel.h.ax(ce.class)).b(null, q.w.DwO, q.n.DtB.scene, com.tencent.mm.plugin.finder.live.report.d.Dnh);
    AppMethodBeat.o(362984);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(RefreshLoadMoreLayout.d<Object> paramd, bb parambb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$feedLoader$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements j
  {
    c(FinderTimelineFeedLoader paramFinderTimelineFeedLoader, bb parambb) {}
    
    private static final void c(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(363641);
      ((StaggeredGridLayoutManager)paramLayoutManager).bo(paramInt1, paramInt2);
      AppMethodBeat.o(363641);
    }
    
    private static final void call$lambda-0()
    {
      AppMethodBeat.i(363633);
      com.tencent.mm.plugin.finder.report.s locals = com.tencent.mm.plugin.finder.report.s.Fqv;
      com.tencent.mm.plugin.finder.report.s.Ss(2);
      AppMethodBeat.o(363633);
    }
    
    private static final void call$lambda-2()
    {
      AppMethodBeat.i(363647);
      com.tencent.mm.plugin.finder.report.s locals = com.tencent.mm.plugin.finder.report.s.Fqv;
      com.tencent.mm.plugin.finder.report.s.eMO();
      AppMethodBeat.o(363647);
    }
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(363676);
      Log.i(this.AZu.getTAG(), "[initData] canTimelineRefresh=" + bb.f(jdField_this) + ", incrementCount=" + paramInt);
      if (bb.f(jdField_this))
      {
        jdField_this.nx(0L);
        localObject = jdField_this.ecE().aNL();
        if (localObject != null) {
          ((RefreshLoadMoreLayout)localObject).post(bb.c..ExternalSyntheticLambda2.INSTANCE);
        }
        localObject = jdField_this.ecE().aNL();
        if (localObject != null) {
          ((RefreshLoadMoreLayout)localObject).post(bb.c..ExternalSyntheticLambda1.INSTANCE);
        }
        AppMethodBeat.o(363676);
        return;
      }
      Object localObject = bb.g(jdField_this).UV(2);
      paramInt = ((d.a)localObject).GKx;
      int i = ((d.a)localObject).GKy;
      Log.i(this.AZu.getTAG(), "[initData] canTimelineRefresh " + bb.f(jdField_this) + " lastPos=" + paramInt + " fromTopPixel=" + i);
      localObject = jdField_this.ecE().getRecyclerView();
      if (localObject == null) {}
      for (localObject = null;; localObject = ((RecyclerView)localObject).getLayoutManager())
      {
        bb.a(jdField_this, i);
        if (!(localObject instanceof StaggeredGridLayoutManager)) {
          break;
        }
        ((StaggeredGridLayoutManager)localObject).bo(paramInt, i);
        RecyclerView localRecyclerView = jdField_this.ecE().getRecyclerView();
        if (localRecyclerView == null) {
          break;
        }
        localRecyclerView.post(new bb.c..ExternalSyntheticLambda0((RecyclerView.LayoutManager)localObject, paramInt, i));
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.l
  {
    d(bb parambb) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(363637);
      b localb = new b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(363637);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(363630);
      Object localObject = new b();
      ((b)localObject).cH(paramRecyclerView);
      ((b)localObject).sc(paramInt1);
      ((b)localObject).sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((b)localObject).aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = this.AZt;
      bb.a((bb)localObject, bb.b((bb)localObject) - paramInt2);
      ((ce)com.tencent.mm.kernel.h.ax(ce.class)).b(paramRecyclerView, q.w.DwO, q.n.DtB.scene, com.tencent.mm.plugin.finder.live.report.d.Dne);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(363630);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(bb parambb)
    {
      super();
    }
    
    private static final void h(bb parambb)
    {
      AppMethodBeat.i(362911);
      kotlin.g.b.s.u(parambb, "this$0");
      RefreshLoadMoreLayout.d locald = new RefreshLoadMoreLayout.d(0);
      locald.agJs = -2;
      parambb = parambb.ecE().aNL();
      if (parambb != null) {
        parambb.k(locald);
      }
      AppMethodBeat.o(362911);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(bb parambb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(bb parambb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    public i(bb parambb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements com.tencent.mm.view.k
  {
    k(bb parambb) {}
    
    private WxRecyclerAdapter<?> getAdapter()
    {
      AppMethodBeat.i(362928);
      Object localObject = this.AZt.ecE();
      if (localObject == null) {
        localObject = null;
      }
      while ((localObject instanceof WxRecyclerAdapter))
      {
        localObject = (WxRecyclerAdapter)localObject;
        AppMethodBeat.o(362928);
        return localObject;
        localObject = ((ay.b)localObject).getRecyclerView();
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = ((RecyclerView)localObject).getAdapter();
        }
      }
      AppMethodBeat.o(362928);
      return null;
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(362936);
      Object localObject = this.AZt.ecE();
      if (localObject != null)
      {
        localObject = ((ay.b)localObject).aNL();
        if (localObject != null) {
          ((RefreshLoadMoreLayout)localObject).onChanged();
        }
      }
      AppMethodBeat.o(362936);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(362941);
      Object localObject = this.AZt.ecE();
      WxRecyclerAdapter localWxRecyclerAdapter;
      if (localObject != null)
      {
        localObject = ((ay.b)localObject).aNL();
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
        AppMethodBeat.o(362941);
        return;
      }
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(362947);
      Object localObject = this.AZt.ecE();
      WxRecyclerAdapter localWxRecyclerAdapter;
      if (localObject != null)
      {
        localObject = ((ay.b)localObject).aNL();
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
        AppMethodBeat.o(362947);
        return;
      }
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(362954);
      Object localObject = this.AZt.ecE();
      WxRecyclerAdapter localWxRecyclerAdapter;
      if (localObject != null)
      {
        localObject = ((ay.b)localObject).aNL();
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
        AppMethodBeat.o(362954);
        return;
      }
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(362964);
      Object localObject = this.AZt.ecE();
      WxRecyclerAdapter localWxRecyclerAdapter;
      if (localObject != null)
      {
        localObject = ((ay.b)localObject).aNL();
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
        AppMethodBeat.o(362964);
        return;
      }
    }
    
    public final void onPreFinishLoadMore(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(362978);
      kotlin.g.b.s.u(paramd, "reason");
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.AZt.ecE().aNL();
      if (localRefreshLoadMoreLayout != null) {
        localRefreshLoadMoreLayout.onPreFinishLoadMore(paramd);
      }
      AppMethodBeat.o(362978);
    }
    
    public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(362985);
      kotlin.g.b.s.u(paramd, "reason");
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.AZt.ecE().aNL();
      if (localRefreshLoadMoreLayout != null) {
        localRefreshLoadMoreLayout.onPreFinishLoadMoreSmooth(paramd);
      }
      AppMethodBeat.o(362985);
    }
    
    public final void onPreFinishRefresh(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(362972);
      kotlin.g.b.s.u(paramd, "reason");
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.AZt.ecE().aNL();
      if (localRefreshLoadMoreLayout != null) {
        localRefreshLoadMoreLayout.onPreFinishRefresh(paramd);
      }
      AppMethodBeat.o(362972);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.bb
 * JD-Core Version:    0.7.0.1
 */