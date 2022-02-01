package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.v;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.report.live.s.j;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderActionBarOverlayUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.HeadFooterLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.StickTopLoadingLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "parent", "Landroid/view/View;", "fragment", "Landroid/support/v4/app/Fragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;Landroid/view/View;Landroid/support/v4/app/Fragment;)V", "actionBarOverlayUIC", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC;", "getActionBarOverlayUIC", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC;", "actionBarOverlayUIC$delegate", "Lkotlin/Lazy;", "actionHeight", "", "getActionHeight", "()I", "actionHeight$delegate", "feedViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getFeedViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "feedViewPool$delegate", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "fullFeedViewPool", "getFullFeedViewPool", "fullFeedViewPool$delegate", "isEnableFullScreenEnjoy", "", "()Z", "isEnableFullScreenEnjoy$delegate", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "rlProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "statusHeight", "getStatusHeight", "statusHeight$delegate", "tabType", "topBarHeight", "getTopBarHeight", "topBarHeight$delegate", "topLoadingOffsetLimit", "", "getTopLoadingOffsetLimit", "()F", "topLoadingOffsetLimit$delegate", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "getRootView", "initView", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "onBackPressed", "onOverEnd", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "setOnItemClickListener", "listener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "showEmptyView", "Companion", "TimelineAdapter", "plugin-finder_release"})
public final class au
  implements ai.b, HeadFooterLayout.b
{
  public static final a tTg;
  private int dLS;
  private final Fragment fragment;
  private final View hVd;
  public FinderLikeDrawer tLV;
  private final kotlin.f tLX;
  private final kotlin.f tPX;
  final MMActivity tRl;
  private final kotlin.f tSX;
  private MMProcessBar tSY;
  private final kotlin.f tSZ;
  private final kotlin.f tTa;
  private final kotlin.f tTb;
  private final kotlin.f tTc;
  private final kotlin.f tTd;
  private final kotlin.f tTe;
  private final ai.a tTf;
  
  static
  {
    AppMethodBeat.i(165939);
    tTg = new a((byte)0);
    AppMethodBeat.o(165939);
  }
  
  public au(MMActivity paramMMActivity, ai.a parama, View paramView, Fragment paramFragment)
  {
    AppMethodBeat.i(244430);
    this.tRl = paramMMActivity;
    this.tTf = parama;
    this.hVd = paramView;
    this.fragment = paramFragment;
    this.tSX = kotlin.g.ah((kotlin.g.a.a)new m(this));
    this.tSZ = kotlin.g.ah((kotlin.g.a.a)new n(this));
    this.tTa = kotlin.g.ah((kotlin.g.a.a)new d(this));
    this.tTb = kotlin.g.ah((kotlin.g.a.a)new o(this));
    this.tTc = kotlin.g.ah((kotlin.g.a.a)new c(this));
    this.tTd = kotlin.g.ah((kotlin.g.a.a)new p(this));
    this.tLX = kotlin.g.ah((kotlin.g.a.a)new l(this));
    this.tPX = kotlin.g.ah((kotlin.g.a.a)new f(this));
    this.tTe = kotlin.g.ah((kotlin.g.a.a)new g(this));
    AppMethodBeat.o(244430);
  }
  
  private final boolean dck()
  {
    AppMethodBeat.i(244426);
    boolean bool = ((Boolean)this.tLX.getValue()).booleanValue();
    AppMethodBeat.o(244426);
    return bool;
  }
  
  private final int ddp()
  {
    AppMethodBeat.i(244424);
    int i = ((Number)this.tSZ.getValue()).intValue();
    AppMethodBeat.o(244424);
    return i;
  }
  
  private final int ddq()
  {
    AppMethodBeat.i(244425);
    int i = ((Number)this.tTa.getValue()).intValue();
    AppMethodBeat.o(244425);
    return i;
  }
  
  private final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(244423);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.tSX.getValue();
    AppMethodBeat.o(244423);
    return localRefreshLoadMoreLayout;
  }
  
  public final boolean IJ(int paramInt)
  {
    AppMethodBeat.i(165948);
    AppMethodBeat.o(165948);
    return false;
  }
  
  public final void c(ArrayList<bo> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(244427);
    p.h(paramArrayList, "data");
    this.dLS = paramInt;
    Object localObject1 = FinderLikeDrawer.wnm;
    localObject1 = (Context)this.tRl;
    Object localObject2 = this.tRl.getWindow();
    p.g(localObject2, "getActivity().window");
    Object localObject3 = FinderLikeDrawer.wnm;
    this.tLV = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.dGP());
    localObject1 = getRlLayout().getRecyclerView();
    if (dck())
    {
      localObject2 = (RefreshLoadMoreLayout.StickTopLoadingLayout)this.hVd.findViewById(2131301840);
      p.g(localObject2, "stickTopLoadingLayout");
      localObject3 = ((RefreshLoadMoreLayout.StickTopLoadingLayout)localObject2).getLayoutParams();
      if (localObject3 == null)
      {
        paramArrayList = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(244427);
        throw paramArrayList;
      }
      ((FrameLayout.LayoutParams)localObject3).topMargin = (ddp() + ddq() / 2);
      ((RefreshLoadMoreLayout.StickTopLoadingLayout)localObject2).setActionCallback((RefreshLoadMoreLayout.a)new h(this));
      ((RefreshLoadMoreLayout.StickTopLoadingLayout)localObject2).setOnScrollCallback((kotlin.g.a.b)new i(this));
      getRlLayout().setStickTopLoadingLayout((RefreshLoadMoreLayout.StickTopLoadingLayout)localObject2);
      int i = (int)this.hVd.getResources().getDimension(2131166379);
      int j = (int)((Number)this.tTd.getValue()).floatValue();
      getRlLayout().setLimitTopRequest(i - j);
      getRlLayout().setRefreshTargetY(j - i);
      getRlLayout().setDamping(1.6F);
      ((RecyclerView)localObject1).setRecycledViewPool((RecyclerView.m)this.tTe.getValue());
      localObject2 = new FinderLinearLayoutManager((Context)this.tRl);
      if (dck()) {
        ((FinderLinearLayoutManager)localObject2).wsx = 40.0F;
      }
      localObject3 = y.vXH;
      ((FinderLinearLayoutManager)localObject2).setItemPrefetchEnabled(y.isAllHomeTabEnableFullScreenEnjoy());
      ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)localObject2);
      localObject2 = this.tTf.dce();
      if (paramInt != 4) {
        break label547;
      }
    }
    label547:
    for (boolean bool = true;; bool = false)
    {
      paramArrayList = new b((com.tencent.mm.view.recyclerview.f)localObject2, paramArrayList, bool);
      paramArrayList.RrA = ((com.tencent.mm.view.recyclerview.l)new j(paramInt));
      localObject2 = ((Iterable)this.tTf.getHeaderInfo()).iterator();
      while (((Iterator)localObject2).hasNext()) {
        com.tencent.mm.view.recyclerview.g.a(paramArrayList, (g.b)((Iterator)localObject2).next());
      }
      this.tSY = ((MMProcessBar)this.hVd.findViewById(2131307120));
      getRlLayout().setLimitTopRequest((int)this.hVd.getResources().getDimension(2131166379) - (int)this.hVd.getResources().getDimension(2131165281));
      getRlLayout().setRefreshTargetY((int)this.hVd.getResources().getDimension(2131165310) - (int)this.hVd.getResources().getDimension(2131166379));
      ((RecyclerView)localObject1).setRecycledViewPool((RecyclerView.m)this.tPX.getValue());
      getRlLayout().setDamping(1.85F);
      break;
    }
    if (localObject1 == null)
    {
      paramArrayList = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerView");
      AppMethodBeat.o(244427);
      throw paramArrayList;
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)paramArrayList);
    ((RecyclerView)localObject1).setHasFixedSize(true);
    paramArrayList = (WxRecyclerView)localObject1;
    localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
    paramArrayList.setFlingSpeedFactor(((Number)com.tencent.mm.plugin.finder.storage.c.dsZ().value()).intValue());
    ((RecyclerView)localObject1).setItemViewCacheSize(3);
    if (dck()) {
      new com.tencent.mm.plugin.finder.ui.e().f((RecyclerView)localObject1);
    }
    ((WxRecyclerView)localObject1).setItemAnimator((RecyclerView.f)new com.tencent.mm.plugin.finder.view.animation.e());
    if (!dck()) {
      ((RecyclerView)localObject1).b((RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(((WxRecyclerView)localObject1).getResources().getColor(2131099689)), (int)((WxRecyclerView)localObject1).getResources().getDimension(2131166341)));
    }
    getRlLayout().setActionCallback((RefreshLoadMoreLayout.a)new k(this, (RecyclerView)localObject1));
    paramArrayList = com.tencent.mm.ui.component.a.PRN;
    paramArrayList = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.tRl).get(FinderReporterUIC.class)).ME(this.tTf.getTabType());
    if (paramArrayList != null) {
      paramArrayList.m(getRlLayout().getRecyclerView());
    }
    getRlLayout().setOverCallback((HeadFooterLayout.b)this);
    AppMethodBeat.o(244427);
  }
  
  public final void dcP()
  {
    AppMethodBeat.i(244429);
    getRlLayout().postDelayed((Runnable)new e(this), 150L);
    AppMethodBeat.o(244429);
  }
  
  public final RefreshLoadMoreLayout dcQ()
  {
    AppMethodBeat.i(165943);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = getRlLayout();
    AppMethodBeat.o(165943);
    return localRefreshLoadMoreLayout;
  }
  
  public final void ddr()
  {
    AppMethodBeat.i(165946);
    Log.i("Finder.TimelineViewCallback", "[onOverStop]");
    MMProcessBar localMMProcessBar = this.tSY;
    if (localMMProcessBar != null)
    {
      localMMProcessBar.gYP();
      AppMethodBeat.o(165946);
      return;
    }
    AppMethodBeat.o(165946);
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(165942);
    RecyclerView localRecyclerView = getRlLayout().getRecyclerView();
    AppMethodBeat.o(165942);
    return localRecyclerView;
  }
  
  public final View getRootView()
  {
    return this.hVd;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(244428);
    FinderLikeDrawer localFinderLikeDrawer = this.tLV;
    if (localFinderLikeDrawer == null) {
      p.btv("friendLikeDrawer");
    }
    if (localFinderLikeDrawer.dGs())
    {
      localFinderLikeDrawer = this.tLV;
      if (localFinderLikeDrawer == null) {
        p.btv("friendLikeDrawer");
      }
      localFinderLikeDrawer.dGr();
      AppMethodBeat.o(244428);
      return true;
    }
    AppMethodBeat.o(244428);
    return false;
  }
  
  public final boolean u(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(165947);
    MMProcessBar localMMProcessBar = this.tSY;
    if (localMMProcessBar != null)
    {
      if (localMMProcessBar.gYQ()) {
        localMMProcessBar.gYO();
      }
      float f = paramInt1;
      Context localContext = MMApplicationContext.getContext();
      p.g(localContext, "MMApplicationContext.getContext()");
      localMMProcessBar.rotate(f / (int)localContext.getResources().getDimension(2131165295));
    }
    AppMethodBeat.o(165947);
    return false;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$TimelineAdapter;", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "itemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "needScrollData", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback;Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;Ljava/util/ArrayList;Z)V", "showResult", "_onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "onBindFirstBodyViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "throwBindViewHolderException", "", "e", "Ljava/lang/Exception;", "payloads", "", "", "throwCreateViewHolderException", "type", "plugin-finder_release"})
  public final class b<D extends com.tencent.mm.view.recyclerview.a>
    extends WxRecyclerAdapter<D>
  {
    private final ArrayList<D> data;
    private final com.tencent.mm.view.recyclerview.f tDm;
    private boolean tTh;
    
    public b(ArrayList<D> paramArrayList, boolean paramBoolean)
    {
      super(paramBoolean, bool);
      AppMethodBeat.i(244402);
      this.tDm = paramArrayList;
      this.data = paramBoolean;
      AppMethodBeat.o(244402);
    }
    
    public final void a(com.tencent.mm.view.recyclerview.h paramh, int paramInt)
    {
      AppMethodBeat.i(178276);
      p.h(paramh, "holder");
      super.a(paramh, paramInt);
      if (!this.tTh)
      {
        paramh = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.gS(au.a(au.this).cND(), "ShowResult");
        this.tTh = true;
      }
      AppMethodBeat.o(178276);
    }
    
    public final String c(Exception paramException, int paramInt)
    {
      AppMethodBeat.i(244400);
      p.h(paramException, "e");
      paramException = super.c(paramException, paramInt);
      AppMethodBeat.o(244400);
      return paramException;
    }
    
    public final void n(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(244399);
      p.h(paramRecyclerView, "recyclerView");
      AppMethodBeat.o(244399);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<FinderActionBarOverlayUIC>
  {
    c(au paramau)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<Integer>
  {
    d(au paramau)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(au paramau) {}
    
    public final void run()
    {
      AppMethodBeat.i(165928);
      au.d(this.tTi).DD(this.$isSilence);
      MMProcessBar localMMProcessBar = au.e(this.tTi);
      if (localMMProcessBar != null)
      {
        localMMProcessBar.gYP();
        AppMethodBeat.o(165928);
        return;
      }
      AppMethodBeat.o(165928);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<RecyclerView.m>
  {
    f(au paramau)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<RecyclerView.m>
  {
    g(au paramau)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onRefreshEnd", "", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class h
    extends RefreshLoadMoreLayout.a
  {
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(244407);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      super.ED(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(244407);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(244409);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(244409);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(244408);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cxo();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(244408);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(244406);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramc, "reason");
      super.onRefreshEnd(paramc);
      if (paramc.Rmk <= 0)
      {
        localObject = paramc.Rmi;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label114;
        }
      }
      label114:
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          localObject = au.b(this.tTi);
          if (localObject != null) {
            FinderActionBarOverlayUIC.a((FinderActionBarOverlayUIC)localObject, paramc.Rmi);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(244406);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "offset", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.b<Float, x>
  {
    i(au paramau)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "plugin-finder_release"})
  public static final class j
    implements com.tencent.mm.view.recyclerview.l
  {
    j(int paramInt) {}
    
    public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj)
    {
      AppMethodBeat.i(244411);
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramj, "data");
      paramRecyclerView = com.tencent.mm.ui.component.a.PRN;
      paramRecyclerView = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTabStreamUnreadVM.class);
      p.g(paramRecyclerView, "UICProvider.of(PluginFin…reamUnreadVM::class.java)");
      paramRecyclerView = (FinderTabStreamUnreadVM)paramRecyclerView;
      if (this.tTj == 4)
      {
        Object localObject1 = (Iterable)paramj.Rrl;
        paramj = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        Object localObject2;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          if ((((com.tencent.mm.view.recyclerview.k)localObject2).Rrp instanceof BaseFinderFeed)) {
            paramj.add(localObject2);
          }
        }
        localObject1 = (Iterable)paramj;
        paramj = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((com.tencent.mm.view.recyclerview.k)((Iterator)localObject1).next()).Rrp;
          if (localObject2 == null)
          {
            paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
            AppMethodBeat.o(244411);
            throw paramRecyclerView;
          }
          paramj.add((BaseFinderFeed)localObject2);
        }
        paramRecyclerView.o(19, (List)paramj);
      }
      AppMethodBeat.o(244411);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$7", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"})
  public static final class k
    extends RefreshLoadMoreLayout.a
  {
    private boolean tMa = true;
    
    k(RecyclerView paramRecyclerView) {}
    
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(244413);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$7", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      super.ED(paramInt);
      au.a(this.tTi).requestRefresh();
      this.tDJ.setItemAnimator((RecyclerView.f)new com.tencent.mm.plugin.finder.view.animation.e());
      localObject = RefreshLoadMoreLayout.c.Rms;
      if (paramInt == RefreshLoadMoreLayout.c.hfX())
      {
        localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (((Number)com.tencent.mm.plugin.finder.storage.c.dsx().value()).intValue() == 1)
        {
          localObject = FinderReporterUIC.wzC;
          localObject = FinderReporterUIC.a.fH((Context)au.c(this.tTi));
          if (localObject != null)
          {
            com.tencent.mm.plugin.finder.report.k localk = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a(((FinderReporterUIC)localObject).dIx(), 3);
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$7", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(244413);
    }
    
    public final void IF(int paramInt)
    {
      AppMethodBeat.i(244417);
      if ((this.tMa) && (paramInt > 0))
      {
        Object localObject = com.tencent.mm.ui.component.a.PRN;
        localObject = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)au.c(this.tTi)).get(FinderReporterUIC.class)).ME(au.a(this.tTi).getTabType());
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.base.f)localObject).dap().onScrollStateChanged(this.tDJ, 5);
        }
        this.tMa = false;
      }
      AppMethodBeat.o(244417);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(244416);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$7", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramc, "reason");
      super.a(paramc);
      Log.i("Finder.TimelineViewCallback", "[onLoadMoreEnd] isHasAnyMore=".concat(String.valueOf(paramc)));
      View localView;
      if ((!paramc.Rmj) && (this.tDJ.getChildCount() > 0))
      {
        localView = this.tDJ.getChildAt(this.tDJ.getChildCount() - 1);
        localObject = this.tDJ.bu(localView);
        if (localObject == null) {
          break label171;
        }
        localObject = Integer.valueOf(((RecyclerView.v)localObject).lU());
        p.g(localView, "itemView");
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
        au.a(this.tTi).a(paramc);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$7", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(244416);
        return;
        localObject = null;
        break;
      }
      for (;;)
      {
        int i = c.a.a((com.tencent.mm.plugin.finder.presenter.base.c)this.tTi).getDisplayMetrics().heightPixels - localView.getHeight();
        au.d(this.tTi).setExtraOverScrollFooterDx(i / 3);
        Log.i("Finder.TimelineViewCallback", "extraOverScrollFooterDx=".concat(String.valueOf(i)));
        com.tencent.mm.plugin.report.service.h.CyF.n(1311L, 2L, 1L);
        break;
        label251:
        if (((Integer)localObject).intValue() != 8) {
          break;
        }
      }
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(244415);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$7", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cxo();
      au.a(this.tTi).boE();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$7", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(244415);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(244414);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$7", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      super.onRefreshEnd(paramc);
      au.a(this.tTi).onRefreshEnd(paramc);
      this.tDJ.postDelayed((Runnable)new a(this), 1000L);
      switch (au.a(this.tTi).getTabType())
      {
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$7", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(244414);
        return;
        paramc = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.b(this.tDJ, s.p.voz, s.j.vnU.scene, com.tencent.mm.plugin.finder.report.live.c.vjh);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(au.k paramk) {}
      
      public final void run()
      {
        AppMethodBeat.i(244412);
        this.tTk.tDJ.setItemAnimator((RecyclerView.f)new v());
        AppMethodBeat.o(244412);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    l(au paramau)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<RefreshLoadMoreLayout>
  {
    m(au paramau)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<Integer>
  {
    n(au paramau)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<Integer>
  {
    o(au paramau)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<Float>
  {
    p(au paramau)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.au
 * JD-Core Version:    0.7.0.1
 */