package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.m;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.event.recyclerview.FinderRecyclerView;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.HeadFooterLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.StickTopLoadingLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.RefreshLoadMoreLayout.d.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.i.b;
import com.tencent.mm.view.recyclerview.m;
import com.tencent.mm.view.recyclerview.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "parent", "Landroid/view/View;", "fragment", "Landroidx/fragment/app/Fragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;Landroid/view/View;Landroidx/fragment/app/Fragment;)V", "actionBarOverlayUIC", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC;", "getActionBarOverlayUIC", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC;", "actionBarOverlayUIC$delegate", "Lkotlin/Lazy;", "actionHeight", "", "getActionHeight", "()I", "actionHeight$delegate", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "fullFeedViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getFullFeedViewPool", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "fullFeedViewPool$delegate", "isFirstShowShareFeed", "", "isFromShareToTimeline", "()Z", "isFromShareToTimeline$delegate", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "rlProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "statusHeight", "getStatusHeight", "statusHeight$delegate", "tabType", "topBarHeight", "getTopBarHeight", "topBarHeight$delegate", "topLoadingOffsetLimit", "", "getTopLoadingOffsetLimit", "()F", "topLoadingOffsetLimit$delegate", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "isHideLoading", "getActivity", "getPresenter", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRefreshLoadMoreLayout", "getRootView", "initView", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "isShareToTimeline", "onBackPressed", "onOverEnd", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "setOnItemClickListener", "listener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "showEmptyView", "showProgress", "isShow", "Companion", "TimelineAdapter", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bh
  implements aw.b, HeadFooterLayout.b
{
  public static final a BaN;
  private final aw.a AIY;
  private final kotlin.j AIn;
  public FinderLikeDrawer ATA;
  final MMActivity AZo;
  private final kotlin.j BaO;
  private MMProcessBar BaP;
  private final kotlin.j BaQ;
  private final kotlin.j BaR;
  private final kotlin.j BaS;
  private final kotlin.j BaT;
  private boolean BaU;
  private final kotlin.j BaV;
  private final kotlin.j Baa;
  private final Fragment fragment;
  private int hJx;
  private final View nma;
  
  static
  {
    AppMethodBeat.i(165939);
    BaN = new a((byte)0);
    AppMethodBeat.o(165939);
  }
  
  public bh(MMActivity paramMMActivity, aw.a parama, View paramView, Fragment paramFragment)
  {
    AppMethodBeat.i(362807);
    this.AZo = paramMMActivity;
    this.AIY = parama;
    this.nma = paramView;
    this.fragment = paramFragment;
    this.BaO = kotlin.k.cm((kotlin.g.a.a)new k(this));
    this.BaQ = kotlin.k.cm((kotlin.g.a.a)new l(this));
    this.BaR = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.AIn = kotlin.k.cm((kotlin.g.a.a)new m(this));
    this.BaS = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.BaT = kotlin.k.cm((kotlin.g.a.a)new n(this));
    this.Baa = kotlin.k.cm((kotlin.g.a.a)new j(this));
    this.BaV = kotlin.k.cm((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(362807);
  }
  
  private static final void a(bh parambh, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(362853);
    s.u(parambh, "this$0");
    parambh.getRlLayout().bR(paramBoolean1, paramBoolean2);
    parambh = parambh.BaP;
    if (parambh != null) {
      parambh.jEP();
    }
    AppMethodBeat.o(362853);
  }
  
  private FinderLikeDrawer ebF()
  {
    AppMethodBeat.i(362822);
    FinderLikeDrawer localFinderLikeDrawer = this.ATA;
    if (localFinderLikeDrawer != null)
    {
      AppMethodBeat.o(362822);
      return localFinderLikeDrawer;
    }
    s.bIx("friendLikeDrawer");
    AppMethodBeat.o(362822);
    return null;
  }
  
  private final boolean ecJ()
  {
    AppMethodBeat.i(362839);
    boolean bool = ((Boolean)this.Baa.getValue()).booleanValue();
    AppMethodBeat.o(362839);
    return bool;
  }
  
  private final int ecW()
  {
    AppMethodBeat.i(362828);
    int i = ((Number)this.BaQ.getValue()).intValue();
    AppMethodBeat.o(362828);
    return i;
  }
  
  private final int ecX()
  {
    AppMethodBeat.i(362834);
    int i = ((Number)this.BaR.getValue()).intValue();
    AppMethodBeat.o(362834);
    return i;
  }
  
  private final boolean ecY()
  {
    AppMethodBeat.i(362845);
    if ((ecJ()) && (this.hJx == 4) && (!this.BaU))
    {
      AppMethodBeat.o(362845);
      return true;
    }
    AppMethodBeat.o(362845);
    return false;
  }
  
  private final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(362815);
    Object localObject = this.BaO.getValue();
    s.s(localObject, "<get-rlLayout>(...)");
    localObject = (RefreshLoadMoreLayout)localObject;
    AppMethodBeat.o(362815);
    return localObject;
  }
  
  public final boolean NK(int paramInt)
  {
    AppMethodBeat.i(165948);
    AppMethodBeat.o(165948);
    return false;
  }
  
  public final RefreshLoadMoreLayout aNL()
  {
    AppMethodBeat.i(165943);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = getRlLayout();
    AppMethodBeat.o(165943);
    return localRefreshLoadMoreLayout;
  }
  
  public final void c(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(362980);
    if (paramLong <= 0L)
    {
      getRlLayout().bR(paramBoolean1, paramBoolean2);
      MMProcessBar localMMProcessBar = this.BaP;
      if (localMMProcessBar != null)
      {
        localMMProcessBar.jEP();
        AppMethodBeat.o(362980);
      }
    }
    else
    {
      getRlLayout().postDelayed(new bh..ExternalSyntheticLambda0(this, paramBoolean1, paramBoolean2), paramLong);
    }
    AppMethodBeat.o(362980);
  }
  
  public final void ecZ()
  {
    AppMethodBeat.i(165946);
    Log.i("Finder.TimelineViewCallback", "[onOverStop]");
    MMProcessBar localMMProcessBar = this.BaP;
    if (localMMProcessBar != null) {
      localMMProcessBar.jEP();
    }
    AppMethodBeat.o(165946);
  }
  
  public final void f(ArrayList<cc> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(362957);
    s.u(paramArrayList, "data");
    this.hJx = paramInt;
    Object localObject1 = FinderLikeDrawer.GAf;
    localObject1 = (Context)this.AZo;
    Object localObject2 = this.AZo.getWindow();
    s.s(localObject2, "getActivity().window");
    Object localObject3 = FinderLikeDrawer.GAf;
    localObject1 = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.fkM());
    s.u(localObject1, "<set-?>");
    this.ATA = ((FinderLikeDrawer)localObject1);
    localObject1 = getRlLayout().getRecyclerView();
    localObject2 = (RefreshLoadMoreLayout.StickTopLoadingLayout)this.nma.findViewById(e.e.full_top_loading_layout);
    ((RefreshLoadMoreLayout.StickTopLoadingLayout)localObject2).setPadding(0, ecW() + ecX() / 2, 0, 0);
    ((RefreshLoadMoreLayout.StickTopLoadingLayout)localObject2).setActionCallback((RefreshLoadMoreLayout.b)new f(this));
    ((RefreshLoadMoreLayout.StickTopLoadingLayout)localObject2).setOnScrollCallback((kotlin.g.a.b)new g(this));
    getRlLayout().setStickTopLoadingLayout((RefreshLoadMoreLayout.StickTopLoadingLayout)localObject2);
    int i = (int)this.nma.getResources().getDimension(e.c.finder_timeline_refresh_height);
    int j = (int)((Number)this.BaT.getValue()).floatValue();
    getRlLayout().setLimitTopRequest(i - j);
    getRlLayout().setRefreshTargetY(j - i);
    getRlLayout().setDamping(1.6F);
    ((RecyclerView)localObject1).setRecycledViewPool((RecyclerView.m)this.BaV.getValue());
    localObject2 = new FinderLinearLayoutManager((Context)this.AZo);
    ((FinderLinearLayoutManager)localObject2).GGx = 25.0F;
    ((FinderLinearLayoutManager)localObject2).xwJ = 100;
    ((FinderLinearLayoutManager)localObject2).setItemPrefetchEnabled(false);
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)localObject2);
    if ((localObject1 instanceof FinderRecyclerView)) {
      ((FinderRecyclerView)localObject1).a((LinearLayoutManager)localObject2);
    }
    localObject2 = this.AIY.dUK();
    if (paramInt == 4) {}
    for (boolean bool = true;; bool = false)
    {
      paramArrayList = new b((g)localObject2, paramArrayList, bool);
      paramArrayList.agOS = ((com.tencent.mm.view.recyclerview.o)new h(paramInt));
      localObject2 = ((Iterable)this.AIY.getHeaderInfo()).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (i.b)((Iterator)localObject2).next();
        i.a((i)paramArrayList, (i.b)localObject3);
      }
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)paramArrayList);
    ((RecyclerView)localObject1).setHasFixedSize(true);
    paramArrayList = (WxRecyclerView)localObject1;
    localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    paramArrayList.setFlingSpeedFactor(((Number)com.tencent.mm.plugin.finder.storage.d.eSP().bmg()).intValue());
    new com.tencent.mm.plugin.finder.ui.e().a((RecyclerView)localObject1);
    if (!ecY())
    {
      ((WxRecyclerView)localObject1).setItemAnimator((RecyclerView.f)new com.tencent.mm.plugin.finder.view.animation.e());
      getRlLayout().setActionCallback((RefreshLoadMoreLayout.b)new i(this, (RecyclerView)localObject1));
      paramArrayList = com.tencent.mm.ui.component.k.aeZF;
      paramArrayList = ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.AZo).q(as.class)).Vq(this.AIY.getTabType());
      if (paramArrayList != null) {
        paramArrayList.o(getRlLayout().getRecyclerView());
      }
      getRlLayout().setOverCallback((HeadFooterLayout.b)this);
      paramArrayList = com.tencent.mm.plugin.finder.report.o.FpJ;
      com.tencent.mm.plugin.finder.report.o.au(getRlLayout().getLoadMoreFooter(), paramInt);
      paramArrayList = com.tencent.mm.plugin.finder.report.o.FpJ;
      paramArrayList = getRlLayout().getStickTopLoadingLayout();
      if (paramArrayList != null) {
        break label655;
      }
    }
    label655:
    for (paramArrayList = null;; paramArrayList = paramArrayList.getProgressBar())
    {
      com.tencent.mm.plugin.finder.report.o.e((View)paramArrayList, paramInt, true);
      AppMethodBeat.o(362957);
      return;
      ((WxRecyclerView)localObject1).setItemAnimator((RecyclerView.f)new androidx.recyclerview.widget.f());
      break;
    }
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(362930);
    RecyclerView localRecyclerView = getRlLayout().getRecyclerView();
    AppMethodBeat.o(362930);
    return localRecyclerView;
  }
  
  public final View getRootView()
  {
    return this.nma;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(362965);
    if (ebF().fkp())
    {
      ebF().fdh();
      AppMethodBeat.o(362965);
      return true;
    }
    AppMethodBeat.o(362965);
    return false;
  }
  
  public final void pZ(boolean paramBoolean)
  {
    AppMethodBeat.i(362973);
    View localView = this.nma.findViewById(e.e.feed_progress);
    if (localView != null)
    {
      if (paramBoolean)
      {
        localView.setVisibility(0);
        AppMethodBeat.o(362973);
        return;
      }
      localView.setVisibility(8);
    }
    AppMethodBeat.o(362973);
  }
  
  public final boolean v(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(165947);
    MMProcessBar localMMProcessBar = this.BaP;
    if (localMMProcessBar != null) {
      if ((localMMProcessBar.bCz == null) || (localMMProcessBar.bCz.hasEnded()) || (!localMMProcessBar.bCz.hasStarted())) {
        break label88;
      }
    }
    label88:
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      if (paramInt2 != 0) {
        localMMProcessBar.jEO();
      }
      localMMProcessBar.ed(paramInt1 / (int)MMApplicationContext.getContext().getResources().getDimension(e.c.Edge_26A));
      AppMethodBeat.o(165947);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$TimelineAdapter;", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "itemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "needScrollData", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback;Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;Ljava/util/ArrayList;Z)V", "showResult", "_onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "onBindFirstBodyViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "throwBindViewHolderException", "", "e", "Ljava/lang/Exception;", "payloads", "", "", "throwCreateViewHolderException", "type", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b<D extends com.tencent.mm.view.recyclerview.a>
    extends WxRecyclerAdapter<D>
  {
    private final g AKf;
    private boolean BaW;
    private final ArrayList<D> data;
    
    public b(ArrayList<D> paramArrayList, boolean paramBoolean)
    {
      super(paramBoolean, bool);
      AppMethodBeat.i(363198);
      this.AKf = paramArrayList;
      this.data = paramBoolean;
      AppMethodBeat.o(363198);
    }
    
    public final String c(Exception paramException, int paramInt)
    {
      AppMethodBeat.i(363216);
      s.u(paramException, "e");
      paramException = super.c(paramException, paramInt);
      AppMethodBeat.o(363216);
      return paramException;
    }
    
    public final void e(com.tencent.mm.view.recyclerview.j paramj, int paramInt)
    {
      AppMethodBeat.i(178276);
      s.u(paramj, "holder");
      super.e(paramj, paramInt);
      if (!this.BaW)
      {
        paramj = z.FrZ;
        z.id(bh.b(bh.this).bys(), "ShowResult");
        this.BaW = true;
      }
      AppMethodBeat.o(178276);
    }
    
    public final void p(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(363211);
      s.u(paramRecyclerView, "recyclerView");
      AppMethodBeat.o(363211);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.viewmodel.component.e>
  {
    c(bh parambh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Integer>
  {
    d(bh parambh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<RecyclerView.m>
  {
    e(bh parambh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onRefreshEnd", "", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends RefreshLoadMoreLayout.b
  {
    f(bh parambh) {}
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(363323);
      s.u(paramd, "reason");
      super.onRefreshEnd(paramd);
      Object localObject;
      if (paramd.agJv <= 0)
      {
        localObject = paramd.agJt;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label89;
        }
      }
      label89:
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          localObject = bh.a(this.BaX);
          if (localObject != null) {
            com.tencent.mm.plugin.finder.viewmodel.component.e.a((com.tencent.mm.plugin.finder.viewmodel.component.e)localObject, paramd.agJt);
          }
        }
        paramd = bh.a(this.BaX);
        if (paramd != null) {
          paramd.fnd();
        }
        AppMethodBeat.o(363323);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "offset", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<Float, ah>
  {
    g(bh parambh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$3", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements com.tencent.mm.view.recyclerview.o
  {
    h(int paramInt) {}
    
    public final void a(RecyclerView paramRecyclerView, m paramm)
    {
      AppMethodBeat.i(363266);
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramm, "data");
      paramRecyclerView = com.tencent.mm.ui.component.k.aeZF;
      paramRecyclerView = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.h.class);
      s.s(paramRecyclerView, "UICProvider.of(PluginFin…reamUnreadVM::class.java)");
      paramRecyclerView = (com.tencent.mm.plugin.finder.viewmodel.h)paramRecyclerView;
      if (this.AEa == 4)
      {
        Object localObject1 = (Iterable)paramm.agOC;
        paramm = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          if ((((n)localObject2).agOG instanceof BaseFinderFeed)) {
            paramm.add(localObject2);
          }
        }
        localObject1 = (Iterable)paramm;
        paramm = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramm.add((BaseFinderFeed)((n)((Iterator)localObject1).next()).agOG);
        }
        paramRecyclerView.L(19, (List)paramm);
      }
      AppMethodBeat.o(363266);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$6", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "loadMoreType", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    extends RefreshLoadMoreLayout.b
  {
    private boolean ATC = true;
    
    i(bh parambh, RecyclerView paramRecyclerView) {}
    
    private static final void u(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(363253);
      s.u(paramRecyclerView, "$recyclerView");
      int i = 0;
      int k = paramRecyclerView.getChildCount();
      if (k > 0) {}
      for (;;)
      {
        int j = i + 1;
        paramRecyclerView.getChildAt(i).setTranslationY(0.0F);
        if (j >= k)
        {
          paramRecyclerView.setItemAnimator((RecyclerView.f)new androidx.recyclerview.widget.f());
          AppMethodBeat.o(363253);
          return;
        }
        i = j;
      }
    }
    
    private static final void v(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(363259);
      s.u(paramRecyclerView, "$recyclerView");
      int i = 0;
      int k = paramRecyclerView.getChildCount();
      if (k > 0) {}
      for (;;)
      {
        int j = i + 1;
        paramRecyclerView.getChildAt(i).setTranslationY(0.0F);
        if (j >= k)
        {
          paramRecyclerView.setItemAnimator((RecyclerView.f)new androidx.recyclerview.widget.f());
          AppMethodBeat.o(363259);
          return;
        }
        i = j;
      }
    }
    
    public final void IH(int paramInt)
    {
      AppMethodBeat.i(363276);
      super.IH(paramInt);
      bh.b(this.BaX).requestRefresh();
      if (!bh.c(this.BaX)) {
        this.AJl.setItemAnimator((RecyclerView.f)new com.tencent.mm.plugin.finder.view.animation.e());
      }
      Object localObject = RefreshLoadMoreLayout.d.agJr;
      if (paramInt == RefreshLoadMoreLayout.d.jMK())
      {
        localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eSi().bmg()).intValue() == 1)
        {
          localObject = as.GSQ;
          localObject = as.a.hu((Context)bh.d(this.BaX));
          if (localObject != null)
          {
            z localz = z.FrZ;
            z.b(((as)localObject).fou(), 3);
          }
        }
      }
      AppMethodBeat.o(363276);
    }
    
    public final void ND(int paramInt)
    {
      AppMethodBeat.i(363326);
      if ((this.ATC) && (paramInt > 0))
      {
        Object localObject = com.tencent.mm.ui.component.k.aeZF;
        localObject = ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)bh.d(this.BaX)).q(as.class)).Vq(bh.b(this.BaX).getTabType());
        if (localObject != null)
        {
          RecyclerView localRecyclerView = this.AJl;
          ((com.tencent.mm.plugin.finder.event.base.f)localObject).dYJ().onScrollStateChanged(localRecyclerView, 5);
        }
        this.ATC = false;
      }
      AppMethodBeat.o(363326);
    }
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(363315);
      s.u(paramd, "reason");
      super.a(paramd);
      Log.i("Finder.TimelineViewCallback", s.X("[onLoadMoreEnd] isHasAnyMore=", paramd));
      View localView;
      Object localObject;
      if ((!paramd.agJu) && (this.AJl.getChildCount() > 0))
      {
        localView = this.AJl.getChildAt(this.AJl.getChildCount() - 1);
        localObject = this.AJl.by(localView);
        if (localObject != null) {
          break label113;
        }
        localObject = null;
        if (localView.getHeight() > 0) {
          if (localObject != null) {
            break label124;
          }
        }
      }
      label113:
      label124:
      while (((Integer)localObject).intValue() != 4)
      {
        if (localObject != null) {
          break label211;
        }
        bh.b(this.BaX).a(paramd);
        AppMethodBeat.o(363315);
        return;
        localObject = Integer.valueOf(((RecyclerView.v)localObject).caO);
        break;
      }
      for (;;)
      {
        localObject = (aw.b)this.BaX;
        s.u(localObject, "this");
        int i = c.a.a((c)localObject).getDisplayMetrics().heightPixels - localView.getHeight();
        bh.f(this.BaX).setExtraOverScrollFooterDx(i / 3);
        Log.i("Finder.TimelineViewCallback", s.X("extraOverScrollFooterDx=", Integer.valueOf(i)));
        com.tencent.mm.plugin.report.service.h.OAn.p(1311L, 2L, 1L);
        break;
        label211:
        if (((Integer)localObject).intValue() != 8) {
          break;
        }
      }
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(363284);
      s.u(paramd, "reason");
      super.onRefreshEnd(paramd);
      bh.b(this.BaX).onRefreshEnd(paramd);
      if (!bh.c(this.BaX)) {
        this.AJl.postDelayed(new bh.i..ExternalSyntheticLambda1(this.AJl), 1000L);
      }
      for (;;)
      {
        this.AJl.postDelayed(new bh.i..ExternalSyntheticLambda0(this.AJl), 1000L);
        if (bh.b(this.BaX).getTabType() == 1) {
          ((ce)com.tencent.mm.kernel.h.ax(ce.class)).b(this.AJl, q.w.DwO, q.n.DtA.scene, com.tencent.mm.plugin.finder.live.report.d.Dnh);
        }
        AppMethodBeat.o(363284);
        return;
        bh.e(this.BaX);
      }
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(363290);
      super.qI(paramInt);
      aw.a locala = bh.b(this.BaX);
      RefreshLoadMoreLayout.d.a locala1 = RefreshLoadMoreLayout.d.agJr;
      if (paramInt == RefreshLoadMoreLayout.d.jML()) {}
      for (boolean bool = true;; bool = false)
      {
        locala.oi(bool);
        AppMethodBeat.o(363290);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    j(bh parambh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<RefreshLoadMoreLayout>
  {
    k(bh parambh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<Integer>
  {
    l(bh parambh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<Integer>
  {
    m(bh parambh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<Float>
  {
    n(bh parambh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.bh
 * JD-Core Version:    0.7.0.1
 */