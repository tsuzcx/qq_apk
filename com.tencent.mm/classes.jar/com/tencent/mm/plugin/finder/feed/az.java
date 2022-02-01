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
import com.tencent.mm.autogen.mmdata.rpt.ef;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.g;
import com.tencent.mm.plugin.finder.report.au;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.q;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.v;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.finder.viewmodel.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", "canTimelineRefresh", "", "emptyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;)V", "isEmptyLocation", "isRequestingLbs", "()Z", "setRequestingLbs", "(Z)V", "refreshTime", "", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "isSilence", "checkEmptyHeader", "r", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "findFirstPosition", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "onActionbarClick", "isDouble", "onAttach", "callback", "onClickReport", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLbsCardActionReportStruct;", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "feedIndex", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "onUserVisibleFocused", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class az
  implements ay.a<com.tencent.mm.plugin.finder.model.c>
{
  public static final a AZf;
  private final FinderHomeTabFragment AZg;
  public FinderLbsLoader AZh;
  public ay.b<com.tencent.mm.plugin.finder.model.c> AZi;
  public final com.tencent.mm.plugin.finder.viewmodel.d AZj;
  private long AZk;
  public final MMActivity activity;
  private final boolean canTimelineRefresh;
  private g emptyData;
  public boolean isEmptyLocation;
  boolean isRequestingLbs;
  private com.tencent.mm.view.k tagViewActionCallback;
  public int totalDy;
  
  static
  {
    AppMethodBeat.i(363017);
    AZf = new a((byte)0);
    AppMethodBeat.o(363017);
  }
  
  public az(MMActivity paramMMActivity, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(362934);
    this.activity = paramMMActivity;
    this.AZg = paramFinderHomeTabFragment;
    paramMMActivity = com.tencent.mm.ui.component.k.aeZF;
    paramMMActivity = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class);
    s.s(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.AZj = ((com.tencent.mm.plugin.finder.viewmodel.d)paramMMActivity);
    this.canTimelineRefresh = this.AZj.Rp(1000);
    this.AZk = -1L;
    this.emptyData = new g();
    this.tagViewActionCallback = ((com.tencent.mm.view.k)new k(this));
    AppMethodBeat.o(362934);
  }
  
  private static final void a(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, boolean paramBoolean)
  {
    AppMethodBeat.i(362961);
    paramRefreshLoadMoreLayout.bR(paramBoolean, false);
    AppMethodBeat.o(362961);
  }
  
  private final void checkEmptyHeader(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(362945);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(paramd, this));
    AppMethodBeat.o(362945);
  }
  
  public static int findFirstPosition(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(362940);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    int i;
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      int[] arrayOfInt = new int[2];
      ((StaggeredGridLayoutManager)paramRecyclerView).n(arrayOfInt);
      i = arrayOfInt[1];
      AppMethodBeat.o(362940);
      return i;
    }
    if ((paramRecyclerView instanceof LinearLayoutManager))
    {
      i = ((LinearLayoutManager)paramRecyclerView).Ju();
      AppMethodBeat.o(362940);
      return i;
    }
    AppMethodBeat.o(362940);
    return 0;
  }
  
  public final void a(ef paramef, q paramq, int paramInt)
  {
    AppMethodBeat.i(363110);
    s.u(paramef, "struct");
    s.u(paramq, "lbsItem");
    Object localObject = as.GSQ;
    localObject = as.a.hu((Context)this.activity);
    if (localObject == null) {}
    for (localObject = null;; localObject = as.a((as)localObject))
    {
      if ((localObject instanceof au))
      {
        paramef.iCA = this.AZk;
        localObject = (au)localObject;
        s.u(paramef, "struct");
        s.u(paramq, "lbsItem");
        paramef = (ef)au.a((com.tencent.mm.plugin.report.a)((au)localObject).b((com.tencent.mm.plugin.report.a)paramef), paramq);
        if ((paramInt >= 0) && (paramInt < paramq.FKS.size()))
        {
          paramef.iBT = paramInt;
          localObject = (com.tencent.mm.plugin.report.a)paramef;
          paramq = paramq.FKS.get(paramInt);
          s.s(paramq, "lbsItem.feedList[feedIndex]");
          au.a((com.tencent.mm.plugin.report.a)localObject, (BaseFinderFeed)paramq);
        }
        paramef.bMH();
      }
      AppMethodBeat.o(363110);
      return;
    }
  }
  
  public final void a(ay.b<com.tencent.mm.plugin.finder.model.c> paramb)
  {
    AppMethodBeat.i(363068);
    s.u(paramb, "callback");
    this.AZk = cn.bDw();
    s.u(paramb, "<set-?>");
    this.AZi = paramb;
    paramb = com.tencent.mm.ui.component.k.aeZF;
    paramb = new FinderLbsLoader(((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.activity).q(as.class)).fou());
    paramb.setInitDone((j)new c(paramb, this));
    paramb.fetchEndCallback = ((kotlin.g.a.b)new d(this));
    ah localah = ah.aiuX;
    s.u(paramb, "<set-?>");
    this.AZh = paramb;
    ecE().ae((ArrayList)ecD().getDataListJustForAdapter());
    ecD().register(this.tagViewActionCallback);
    paramb = v.GgU;
    if (v.eot())
    {
      this.AZj.UV(1000).GKw.size();
      ecD().requestInit(false);
      paramb = ecE().getRecyclerView();
      if (paramb != null) {
        paramb.a((RecyclerView.l)new e(this));
      }
    }
    for (;;)
    {
      paramb = ecE().getRecyclerView();
      if (paramb != null) {
        com.tencent.mm.view.recyclerview.c.a(paramb, (com.tencent.mm.view.recyclerview.d)new f(this));
      }
      AppMethodBeat.o(363068);
      return;
      paramb = new RefreshLoadMoreLayout.d(0);
      paramb.agJs = -2;
      localah = ah.aiuX;
      checkEmptyHeader(paramb);
    }
  }
  
  public final FinderLbsLoader ecD()
  {
    AppMethodBeat.i(363029);
    FinderLbsLoader localFinderLbsLoader = this.AZh;
    if (localFinderLbsLoader != null)
    {
      AppMethodBeat.o(363029);
      return localFinderLbsLoader;
    }
    s.bIx("feedLoader");
    AppMethodBeat.o(363029);
    return null;
  }
  
  public final ay.b<com.tencent.mm.plugin.finder.model.c> ecE()
  {
    AppMethodBeat.i(363038);
    ay.b localb = this.AZi;
    if (localb != null)
    {
      AppMethodBeat.o(363038);
      return localb;
    }
    s.bIx("viewCallback");
    AppMethodBeat.o(363038);
    return null;
  }
  
  public final void nx(long paramLong)
  {
    AppMethodBeat.i(363077);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = ecE().aNL();
    if (localRefreshLoadMoreLayout != null) {
      localRefreshLoadMoreLayout.postDelayed(new az..ExternalSyntheticLambda0(localRefreshLoadMoreLayout, false), paramLong);
    }
    AppMethodBeat.o(363077);
  }
  
  public final void onActionbarClick(boolean paramBoolean)
  {
    AppMethodBeat.i(363092);
    Object localObject1 = ecE().getRecyclerView();
    if (localObject1 == null)
    {
      AppMethodBeat.o(363092);
      return;
    }
    int i = findFirstPosition((RecyclerView)localObject1);
    Log.i("Finder.FinderTimelineLbsMixPresenter", "[onActionbarClick] position=" + i + " isDouble=" + paramBoolean);
    Object localObject2;
    if (i <= 12)
    {
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
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
      AppMethodBeat.o(363092);
      return;
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
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
    AppMethodBeat.o(363092);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(363101);
    ecD().unregister(this.tagViewActionCallback);
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    ((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).UT(1000);
    AppMethodBeat.o(363101);
  }
  
  public final void onLoadMore()
  {
    AppMethodBeat.i(363058);
    BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)ecD(), false, 1, null);
    AppMethodBeat.o(363058);
  }
  
  public final void onRefresh()
  {
    AppMethodBeat.i(363045);
    v localv = v.GgU;
    v.a((kotlin.g.a.a)new g(this), (kotlin.g.a.a)new h(this), (kotlin.g.a.a)new i(this));
    AppMethodBeat.o(363045);
  }
  
  public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(363053);
    s.u(paramd, "reason");
    this.AZk = cn.bDw();
    RefreshLoadMoreLayout localRefreshLoadMoreLayout;
    Object localObject;
    if (paramd.agJv <= 0)
    {
      localRefreshLoadMoreLayout = ecE().aNL();
      if (localRefreshLoadMoreLayout != null)
      {
        localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
        localRefreshLoadMoreLayout.e(com.tencent.mm.plugin.finder.storage.d.eRF(), (kotlin.g.a.a)az.j.AZn);
      }
    }
    if (paramd.agJu)
    {
      localRefreshLoadMoreLayout = ecE().aNL();
      if ((localRefreshLoadMoreLayout == null) || (localRefreshLoadMoreLayout.agJe)) {
        break label217;
      }
      i = 1;
      if (i != 0)
      {
        localRefreshLoadMoreLayout = ecE().aNL();
        if (localRefreshLoadMoreLayout != null) {
          localRefreshLoadMoreLayout.setHasBottomMore(true);
        }
      }
      localRefreshLoadMoreLayout = ecE().aNL();
      if ((localRefreshLoadMoreLayout == null) || (localRefreshLoadMoreLayout.getEnableLoadMore())) {
        break label222;
      }
    }
    label217:
    label222:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localRefreshLoadMoreLayout = ecE().aNL();
        if (localRefreshLoadMoreLayout != null) {
          localRefreshLoadMoreLayout.setEnableLoadMore(true);
        }
        localRefreshLoadMoreLayout = ecE().aNL();
        if (localRefreshLoadMoreLayout != null)
        {
          localObject = af.mU((Context)this.activity).inflate(e.f.load_more_footer, null);
          s.s(localObject, "getInflater(activity).in…t.load_more_footer, null)");
          localRefreshLoadMoreLayout.setLoadMoreFooter((View)localObject);
        }
      }
      checkEmptyHeader(paramd);
      AppMethodBeat.o(363053);
      return;
      i = 0;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(RefreshLoadMoreLayout.d<Object> paramd, az paramaz)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements j
  {
    c(FinderLbsLoader paramFinderLbsLoader, az paramaz) {}
    
    private static final void b(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(362392);
      ((StaggeredGridLayoutManager)paramLayoutManager).bo(paramInt1, paramInt2);
      AppMethodBeat.o(362392);
    }
    
    public final void call(int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(362405);
      Log.i(this.AZm.getTAG(), "[initData] canTimelineRefresh=" + az.g(jdField_this) + ", incrementCount=" + paramInt);
      Object localObject3;
      if (az.g(jdField_this))
      {
        jdField_this.nx(0L);
        if (paramInt <= 0)
        {
          localObject3 = jdField_this;
          localObject1 = localObject2;
          if (az.g(jdField_this)) {
            localObject1 = new RefreshLoadMoreLayout.d(0);
          }
          az.a((az)localObject3, (RefreshLoadMoreLayout.d)localObject1);
        }
        AppMethodBeat.o(362405);
        return;
      }
      Object localObject1 = az.h(jdField_this).UV(1000);
      int i = ((d.a)localObject1).GKx;
      int j = ((d.a)localObject1).GKy;
      Log.i(this.AZm.getTAG(), "[initData] canTimelineRefresh " + az.g(jdField_this) + " lastPos=" + i + " fromTopPixel=" + j);
      localObject1 = jdField_this.ecE().getRecyclerView();
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((RecyclerView)localObject1).getLayoutManager())
      {
        az.a(jdField_this, j);
        if (!(localObject1 instanceof StaggeredGridLayoutManager)) {
          break;
        }
        ((StaggeredGridLayoutManager)localObject1).bo(i, j);
        localObject3 = jdField_this.ecE().getRecyclerView();
        if (localObject3 == null) {
          break;
        }
        ((RecyclerView)localObject3).post(new az.c..ExternalSyntheticLambda0((RecyclerView.LayoutManager)localObject1, i, j));
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<IResponse<com.tencent.mm.plugin.finder.model.c>, ah>
  {
    d(az paramaz)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends RecyclerView.l
  {
    e(az paramaz) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(362383);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(362383);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(362377);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = this.AZl;
      az.a(paramRecyclerView, az.c(paramRecyclerView) - paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(362377);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$4", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecordListener;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "onExposeTimeRecorded", "", "recordsSet", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends com.tencent.mm.view.recyclerview.d<com.tencent.mm.view.recyclerview.a>
  {
    f(az paramaz) {}
    
    public final void s(Set<com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a>> paramSet)
    {
      AppMethodBeat.i(362425);
      s.u(paramSet, "recordsSet");
      Log.i("Finder.FinderTimelineLbsMixPresenter", s.X("onExposeTimeRecorded: size = ", Integer.valueOf(paramSet.size())));
      Object localObject1 = as.GSQ;
      localObject1 = as.a.hu((Context)az.b(this.AZl));
      if (localObject1 == null) {
        localObject1 = null;
      }
      while ((localObject1 instanceof au))
      {
        Object localObject2 = (Iterable)paramSet;
        paramSet = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = ((Iterator)localObject2).next();
            if ((((com.tencent.mm.view.recyclerview.b)localObject3).agNK instanceof com.tencent.mm.plugin.finder.model.c))
            {
              paramSet.add(localObject3);
              continue;
              localObject1 = as.a((as)localObject1);
              break;
            }
          }
        }
        paramSet = (List)paramSet;
        localObject2 = this.AZl;
        ((au)localObject1).e(paramSet, az.d((az)localObject2));
      }
      AppMethodBeat.o(362425);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(az paramaz)
    {
      super();
    }
    
    private static final void i(az paramaz)
    {
      AppMethodBeat.i(362410);
      s.u(paramaz, "this$0");
      RefreshLoadMoreLayout.d locald = new RefreshLoadMoreLayout.d(0);
      locald.agJs = -2;
      paramaz = paramaz.ecE().aNL();
      if (paramaz != null) {
        paramaz.k(locald);
      }
      AppMethodBeat.o(362410);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(az paramaz)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(az paramaz)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements com.tencent.mm.view.k
  {
    k(az paramaz) {}
    
    private WxRecyclerAdapter<?> getAdapter()
    {
      AppMethodBeat.i(362428);
      Object localObject = this.AZl.ecE().getRecyclerView();
      if (localObject == null) {}
      for (localObject = null; (localObject instanceof WxRecyclerAdapter); localObject = ((RecyclerView)localObject).getAdapter())
      {
        localObject = (WxRecyclerAdapter)localObject;
        AppMethodBeat.o(362428);
        return localObject;
      }
      AppMethodBeat.o(362428);
      return null;
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(362431);
      Object localObject = this.AZl.ecE();
      if (localObject != null)
      {
        localObject = ((ay.b)localObject).aNL();
        if (localObject != null) {
          ((RefreshLoadMoreLayout)localObject).onChanged();
        }
      }
      az.a(this.AZl);
      AppMethodBeat.o(362431);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(362437);
      Object localObject = this.AZl.ecE();
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
        AppMethodBeat.o(362437);
        return;
      }
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(362443);
      Object localObject = this.AZl.ecE();
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
        AppMethodBeat.o(362443);
        return;
      }
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(362449);
      Object localObject = this.AZl.ecE();
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
        AppMethodBeat.o(362449);
        return;
      }
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(362454);
      Object localObject = this.AZl.ecE();
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
        AppMethodBeat.o(362454);
        return;
      }
    }
    
    public final void onPreFinishLoadMore(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(362466);
      s.u(paramd, "reason");
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.AZl.ecE().aNL();
      if (localRefreshLoadMoreLayout != null) {
        localRefreshLoadMoreLayout.onPreFinishLoadMore(paramd);
      }
      AppMethodBeat.o(362466);
    }
    
    public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(362471);
      s.u(paramd, "reason");
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.AZl.ecE().aNL();
      if (localRefreshLoadMoreLayout != null) {
        localRefreshLoadMoreLayout.onPreFinishLoadMoreSmooth(paramd);
      }
      AppMethodBeat.o(362471);
    }
    
    public final void onPreFinishRefresh(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(362461);
      s.u(paramd, "reason");
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.AZl.ecE().aNL();
      if (localRefreshLoadMoreLayout != null) {
        localRefreshLoadMoreLayout.onPreFinishRefresh(paramd);
      }
      AppMethodBeat.o(362461);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.az
 * JD-Core Version:    0.7.0.1
 */