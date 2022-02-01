package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.m;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.event.recyclerview.FinderRecyclerView;
import com.tencent.mm.plugin.finder.live.report.s.l;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.HeadFooterLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.StickTopLoadingLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.h.b;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "parent", "Landroid/view/View;", "fragment", "Landroidx/fragment/app/Fragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;Landroid/view/View;Landroidx/fragment/app/Fragment;)V", "actionBarOverlayUIC", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC;", "getActionBarOverlayUIC", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC;", "actionBarOverlayUIC$delegate", "Lkotlin/Lazy;", "actionHeight", "", "getActionHeight", "()I", "actionHeight$delegate", "feedViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getFeedViewPool", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "feedViewPool$delegate", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "fullFeedViewPool", "getFullFeedViewPool", "fullFeedViewPool$delegate", "isEnableFullScreenEnjoy", "", "()Z", "isEnableFullScreenEnjoy$delegate", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "rlProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "statusHeight", "getStatusHeight", "statusHeight$delegate", "tabType", "topBarHeight", "getTopBarHeight", "topBarHeight$delegate", "topLoadingOffsetLimit", "", "getTopLoadingOffsetLimit", "()F", "topLoadingOffsetLimit$delegate", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "getActivity", "getPresenter", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRefreshLoadMoreLayout", "getRootView", "initView", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "onBackPressed", "onOverEnd", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "setOnItemClickListener", "listener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "showEmptyView", "Companion", "TimelineAdapter", "plugin-finder_release"})
public final class ba
  implements ap.b, HeadFooterLayout.b
{
  public static final a xDW;
  private int fEH;
  private final Fragment fragment;
  private final View kJC;
  private final kotlin.f xAN;
  final MMActivity xCd;
  private final kotlin.f xDO;
  private MMProcessBar xDP;
  private final kotlin.f xDQ;
  private final kotlin.f xDR;
  private final kotlin.f xDS;
  private final kotlin.f xDT;
  private final kotlin.f xDU;
  private final ap.a xDV;
  private final kotlin.f xju;
  public FinderLikeDrawer xvM;
  private final kotlin.f xvO;
  
  static
  {
    AppMethodBeat.i(165939);
    xDW = new a((byte)0);
    AppMethodBeat.o(165939);
  }
  
  public ba(MMActivity paramMMActivity, ap.a parama, View paramView, Fragment paramFragment)
  {
    AppMethodBeat.i(285039);
    this.xCd = paramMMActivity;
    this.xDV = parama;
    this.kJC = paramView;
    this.fragment = paramFragment;
    this.xDO = kotlin.g.ar((kotlin.g.a.a)new m(this));
    this.xDQ = kotlin.g.ar((kotlin.g.a.a)new n(this));
    this.xDR = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.xju = kotlin.g.ar((kotlin.g.a.a)new o(this));
    this.xDS = kotlin.g.ar((kotlin.g.a.a)new c(this));
    this.xDT = kotlin.g.ar((kotlin.g.a.a)new p(this));
    this.xvO = kotlin.g.ar((kotlin.g.a.a)new l(this));
    this.xAN = kotlin.g.ar((kotlin.g.a.a)new f(this));
    this.xDU = kotlin.g.ar((kotlin.g.a.a)new g(this));
    AppMethodBeat.o(285039);
  }
  
  private final boolean dsA()
  {
    AppMethodBeat.i(285034);
    boolean bool = ((Boolean)this.xvO.getValue()).booleanValue();
    AppMethodBeat.o(285034);
    return bool;
  }
  
  private final int dtX()
  {
    AppMethodBeat.i(285032);
    int i = ((Number)this.xDQ.getValue()).intValue();
    AppMethodBeat.o(285032);
    return i;
  }
  
  private final int dtY()
  {
    AppMethodBeat.i(285033);
    int i = ((Number)this.xDR.getValue()).intValue();
    AppMethodBeat.o(285033);
    return i;
  }
  
  private final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(285031);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.xDO.getValue();
    AppMethodBeat.o(285031);
    return localRefreshLoadMoreLayout;
  }
  
  public final boolean MB(int paramInt)
  {
    AppMethodBeat.i(165948);
    AppMethodBeat.o(165948);
    return false;
  }
  
  public final void c(ArrayList<bu> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(285036);
    p.k(paramArrayList, "data");
    this.fEH = paramInt;
    Object localObject1 = FinderLikeDrawer.AYs;
    localObject1 = (Context)this.xCd;
    Object localObject2 = this.xCd.getWindow();
    p.j(localObject2, "getActivity().window");
    Object localObject3 = FinderLikeDrawer.AYs;
    this.xvM = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.eiO());
    localObject1 = getRlLayout().getRecyclerView();
    if (dsA())
    {
      localObject2 = (RefreshLoadMoreLayout.StickTopLoadingLayout)this.kJC.findViewById(b.f.full_top_loading_layout);
      ((RefreshLoadMoreLayout.StickTopLoadingLayout)localObject2).setPadding(0, dtX() + dtY() / 2, 0, 0);
      ((RefreshLoadMoreLayout.StickTopLoadingLayout)localObject2).setActionCallback((RefreshLoadMoreLayout.a)new h(this));
      ((RefreshLoadMoreLayout.StickTopLoadingLayout)localObject2).setOnScrollCallback((kotlin.g.a.b)new i(this));
      getRlLayout().setStickTopLoadingLayout((RefreshLoadMoreLayout.StickTopLoadingLayout)localObject2);
      int i = (int)this.kJC.getResources().getDimension(b.d.finder_timeline_refresh_height);
      int j = (int)((Number)this.xDT.getValue()).floatValue();
      getRlLayout().setLimitTopRequest(i - j);
      getRlLayout().setRefreshTargetY(j - i);
      getRlLayout().setDamping(1.6F);
      ((RecyclerView)localObject1).setRecycledViewPool((RecyclerView.m)this.xDU.getValue());
      localObject2 = new FinderLinearLayoutManager((Context)this.xCd);
      if (dsA())
      {
        ((FinderLinearLayoutManager)localObject2).BdV = 25.0F;
        ((FinderLinearLayoutManager)localObject2).uqm = 100;
      }
      localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      ((FinderLinearLayoutManager)localObject2).setItemPrefetchEnabled(com.tencent.mm.plugin.finder.utils.aj.isAllHomeTabEnableFullScreenEnjoy());
      ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)localObject2);
      if ((localObject1 instanceof FinderRecyclerView)) {
        ((FinderRecyclerView)localObject1).a((LinearLayoutManager)localObject2);
      }
      localObject2 = this.xDV.dsu();
      if (paramInt != 4) {
        break label536;
      }
    }
    label536:
    for (boolean bool = true;; bool = false)
    {
      paramArrayList = new b((com.tencent.mm.view.recyclerview.f)localObject2, paramArrayList, bool);
      paramArrayList.YTa = ((m)new j(paramInt));
      localObject2 = ((Iterable)this.xDV.getHeaderInfo()).iterator();
      while (((Iterator)localObject2).hasNext()) {
        com.tencent.mm.view.recyclerview.h.a(paramArrayList, (h.b)((Iterator)localObject2).next());
      }
      this.xDP = ((MMProcessBar)this.kJC.findViewById(b.f.rl_loading_icon));
      getRlLayout().setLimitTopRequest((int)this.kJC.getResources().getDimension(b.d.finder_timeline_refresh_height) - (int)this.kJC.getResources().getDimension(b.d.Edge_12A));
      getRlLayout().setRefreshTargetY((int)this.kJC.getResources().getDimension(b.d.Edge_7A) - (int)this.kJC.getResources().getDimension(b.d.finder_timeline_refresh_height));
      ((RecyclerView)localObject1).setRecycledViewPool((RecyclerView.m)this.xAN.getValue());
      getRlLayout().setDamping(1.85F);
      break;
    }
    if (localObject1 == null)
    {
      paramArrayList = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerView");
      AppMethodBeat.o(285036);
      throw paramArrayList;
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)paramArrayList);
    ((RecyclerView)localObject1).setHasFixedSize(true);
    paramArrayList = (WxRecyclerView)localObject1;
    localObject2 = d.AjH;
    paramArrayList.setFlingSpeedFactor(((Number)d.dUr().aSr()).intValue());
    if (dsA())
    {
      ((RecyclerView)localObject1).setItemViewCacheSize(1);
      new com.tencent.mm.plugin.finder.ui.e().a((RecyclerView)localObject1);
    }
    ((WxRecyclerView)localObject1).setItemAnimator((RecyclerView.f)new com.tencent.mm.plugin.finder.view.animation.e());
    if (!dsA()) {
      ((RecyclerView)localObject1).b((RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(((WxRecyclerView)localObject1).getResources().getColor(b.c.BW_93)), (int)((WxRecyclerView)localObject1).getResources().getDimension(b.d.feed_divider)));
    }
    getRlLayout().setActionCallback((RefreshLoadMoreLayout.a)new k(this, (RecyclerView)localObject1));
    paramArrayList = com.tencent.mm.ui.component.g.Xox;
    paramArrayList = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.xCd).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).RY(this.xDV.getTabType());
    if (paramArrayList != null) {
      paramArrayList.k(getRlLayout().getRecyclerView());
    }
    getRlLayout().setOverCallback((HeadFooterLayout.b)this);
    AppMethodBeat.o(285036);
  }
  
  public final void dtZ()
  {
    AppMethodBeat.i(165946);
    Log.i("Finder.TimelineViewCallback", "[onOverStop]");
    MMProcessBar localMMProcessBar = this.xDP;
    if (localMMProcessBar != null)
    {
      localMMProcessBar.hZH();
      AppMethodBeat.o(165946);
      return;
    }
    AppMethodBeat.o(165946);
  }
  
  public final void dtp()
  {
    AppMethodBeat.i(285038);
    getRlLayout().postDelayed((Runnable)new e(this), 150L);
    AppMethodBeat.o(285038);
  }
  
  public final RefreshLoadMoreLayout dtq()
  {
    AppMethodBeat.i(165943);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = getRlLayout();
    AppMethodBeat.o(165943);
    return localRefreshLoadMoreLayout;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(285035);
    RecyclerView localRecyclerView = getRlLayout().getRecyclerView();
    AppMethodBeat.o(285035);
    return localRecyclerView;
  }
  
  public final View getRootView()
  {
    return this.kJC;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(285037);
    FinderLikeDrawer localFinderLikeDrawer = this.xvM;
    if (localFinderLikeDrawer == null) {
      p.bGy("friendLikeDrawer");
    }
    if (localFinderLikeDrawer.eis())
    {
      localFinderLikeDrawer = this.xvM;
      if (localFinderLikeDrawer == null) {
        p.bGy("friendLikeDrawer");
      }
      localFinderLikeDrawer.eir();
      AppMethodBeat.o(285037);
      return true;
    }
    AppMethodBeat.o(285037);
    return false;
  }
  
  public final boolean v(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(165947);
    MMProcessBar localMMProcessBar = this.xDP;
    if (localMMProcessBar != null)
    {
      if (localMMProcessBar.hZI()) {
        localMMProcessBar.hZG();
      }
      float f = paramInt1;
      Context localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      localMMProcessBar.cQ(f / (int)localContext.getResources().getDimension(b.d.Edge_26A));
    }
    AppMethodBeat.o(165947);
    return false;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$TimelineAdapter;", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "itemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "needScrollData", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback;Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;Ljava/util/ArrayList;Z)V", "showResult", "_onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "onBindFirstBodyViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "throwBindViewHolderException", "", "e", "Ljava/lang/Exception;", "payloads", "", "", "throwCreateViewHolderException", "type", "plugin-finder_release"})
  public final class b<D extends com.tencent.mm.view.recyclerview.a>
    extends WxRecyclerAdapter<D>
  {
    private final ArrayList<D> data;
    private boolean xDX;
    private final com.tencent.mm.view.recyclerview.f xlM;
    
    public b(ArrayList<D> paramArrayList, boolean paramBoolean)
    {
      super(paramBoolean, bool);
      AppMethodBeat.i(285484);
      this.xlM = paramArrayList;
      this.data = paramBoolean;
      AppMethodBeat.o(285484);
    }
    
    public final void b(i parami, int paramInt)
    {
      AppMethodBeat.i(178276);
      p.k(parami, "holder");
      super.b(parami, paramInt);
      if (!this.xDX)
      {
        parami = n.zWF;
        n.hj(ba.a(ba.this).dcv(), "ShowResult");
        this.xDX = true;
      }
      AppMethodBeat.o(178276);
    }
    
    public final String c(Exception paramException, int paramInt)
    {
      AppMethodBeat.i(285482);
      p.k(paramException, "e");
      paramException = super.c(paramException, paramInt);
      AppMethodBeat.o(285482);
      return paramException;
    }
    
    public final void l(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(285481);
      p.k(paramRecyclerView, "recyclerView");
      AppMethodBeat.o(285481);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.viewmodel.component.e>
  {
    c(ba paramba)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<Integer>
  {
    d(ba paramba)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(ba paramba) {}
    
    public final void run()
    {
      AppMethodBeat.i(165928);
      ba.d(this.xDY).Id(this.$isSilence);
      MMProcessBar localMMProcessBar = ba.e(this.xDY);
      if (localMMProcessBar != null)
      {
        localMMProcessBar.hZH();
        AppMethodBeat.o(165928);
        return;
      }
      AppMethodBeat.o(165928);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<RecyclerView.m>
  {
    f(ba paramba)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<RecyclerView.m>
  {
    g(ba paramba)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onRefreshEnd", "", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class h
    extends RefreshLoadMoreLayout.a
  {
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(285709);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      super.Ie(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(285709);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(285711);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(285711);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(285710);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cKQ();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(285710);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(285708);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramc, "reason");
      super.onRefreshEnd(paramc);
      if (paramc.YNG <= 0)
      {
        localObject = paramc.YNE;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label130;
        }
      }
      label130:
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          localObject = ba.b(this.xDY);
          if (localObject != null) {
            com.tencent.mm.plugin.finder.viewmodel.component.e.a((com.tencent.mm.plugin.finder.viewmodel.component.e)localObject, paramc.YNE);
          }
        }
        paramc = ba.b(this.xDY);
        if (paramc != null) {
          paramc.ekm();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(285708);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "offset", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.b<Float, x>
  {
    i(ba paramba)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$3", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "plugin-finder_release"})
  public static final class j
    implements m
  {
    j(int paramInt) {}
    
    public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.k paramk)
    {
      AppMethodBeat.i(286168);
      p.k(paramRecyclerView, "recyclerView");
      p.k(paramk, "data");
      paramRecyclerView = com.tencent.mm.ui.component.g.Xox;
      paramRecyclerView = com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.f.class);
      p.j(paramRecyclerView, "UICProvider.of(PluginFin…reamUnreadVM::class.java)");
      paramRecyclerView = (com.tencent.mm.plugin.finder.viewmodel.f)paramRecyclerView;
      if (this.xeP == 4)
      {
        Object localObject1 = (Iterable)paramk.YSL;
        paramk = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        Object localObject2;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          if ((((com.tencent.mm.view.recyclerview.l)localObject2).YSP instanceof BaseFinderFeed)) {
            paramk.add(localObject2);
          }
        }
        localObject1 = (Iterable)paramk;
        paramk = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((com.tencent.mm.view.recyclerview.l)((Iterator)localObject1).next()).YSP;
          if (localObject2 == null)
          {
            paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
            AppMethodBeat.o(286168);
            throw paramRecyclerView;
          }
          paramk.add((BaseFinderFeed)localObject2);
        }
        paramRecyclerView.r(19, (List)paramk);
      }
      AppMethodBeat.o(286168);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$6", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"})
  public static final class k
    extends RefreshLoadMoreLayout.a
  {
    private boolean xvR = true;
    
    k(RecyclerView paramRecyclerView) {}
    
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(277165);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$6", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      super.Ie(paramInt);
      ba.a(this.xDY).requestRefresh();
      this.xmk.setItemAnimator((RecyclerView.f)new com.tencent.mm.plugin.finder.view.animation.e());
      localObject = RefreshLoadMoreLayout.c.YNO;
      if (paramInt == RefreshLoadMoreLayout.c.ihw())
      {
        localObject = d.AjH;
        if (((Number)d.dTQ().aSr()).intValue() == 1)
        {
          localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          localObject = aj.a.fZ((Context)ba.c(this.xDY));
          if (localObject != null)
          {
            n localn = n.zWF;
            n.b(((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject).ekY(), 3);
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$6", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(277165);
    }
    
    public final void Mw(int paramInt)
    {
      AppMethodBeat.i(277169);
      if ((this.xvR) && (paramInt > 0))
      {
        Object localObject = com.tencent.mm.ui.component.g.Xox;
        localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)ba.c(this.xDY)).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).RY(ba.a(this.xDY).getTabType());
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.base.f)localObject).dqn().onScrollStateChanged(this.xmk, 5);
        }
        this.xvR = false;
      }
      AppMethodBeat.o(277169);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(277168);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$6", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramc, "reason");
      super.a(paramc);
      Log.i("Finder.TimelineViewCallback", "[onLoadMoreEnd] isHasAnyMore=".concat(String.valueOf(paramc)));
      View localView;
      if ((!paramc.YNF) && (this.xmk.getChildCount() > 0))
      {
        localView = this.xmk.getChildAt(this.xmk.getChildCount() - 1);
        localObject = this.xmk.bf(localView);
        if (localObject == null) {
          break label171;
        }
        localObject = Integer.valueOf(((RecyclerView.v)localObject).mg());
        p.j(localView, "itemView");
        if (localView.getHeight() > 0) {
          if (localObject != null) {
            break label176;
          }
        }
      }
      label171:
      label176:
      while (((Integer)localObject).intValue() != 4)
      {
        if (localObject != null) {
          break label251;
        }
        ba.a(this.xDY).a(paramc);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$6", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(277168);
        return;
        localObject = null;
        break;
      }
      for (;;)
      {
        int i = c.a.a((com.tencent.mm.plugin.finder.presenter.base.c)this.xDY).getDisplayMetrics().heightPixels - localView.getHeight();
        ba.d(this.xDY).setExtraOverScrollFooterDx(i / 3);
        Log.i("Finder.TimelineViewCallback", "extraOverScrollFooterDx=".concat(String.valueOf(i)));
        com.tencent.mm.plugin.report.service.h.IzE.p(1311L, 2L, 1L);
        break;
        label251:
        if (((Integer)localObject).intValue() != 8) {
          break;
        }
      }
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(277167);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$6", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cKQ();
      ba.a(this.xDY).byN();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$6", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(277167);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(277166);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$6", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      p.k(paramc, "reason");
      super.onRefreshEnd(paramc);
      ba.a(this.xDY).onRefreshEnd(paramc);
      this.xmk.postDelayed((Runnable)new a(this), 1000L);
      switch (ba.a(this.xDY).getTabType())
      {
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$6", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(277166);
        return;
        paramc = com.tencent.mm.plugin.finder.live.report.k.yBj;
        com.tencent.mm.plugin.finder.live.report.k.b(this.xmk, s.t.yGM, s.l.yFW.scene, com.tencent.mm.plugin.finder.live.report.c.yAk);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ba.k paramk) {}
      
      public final void run()
      {
        AppMethodBeat.i(274706);
        this.xDZ.xmk.setItemAnimator((RecyclerView.f)new androidx.recyclerview.widget.g());
        AppMethodBeat.o(274706);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    l(ba paramba)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<RefreshLoadMoreLayout>
  {
    m(ba paramba)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<Integer>
  {
    n(ba paramba)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<Integer>
  {
    o(ba paramba)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<Float>
  {
    p(ba paramba)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ba
 * JD-Core Version:    0.7.0.1
 */