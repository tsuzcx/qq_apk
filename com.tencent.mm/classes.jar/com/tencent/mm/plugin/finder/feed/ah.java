package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.w;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTouchMediaPreviewUIC;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.view.HeadFooterLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.d.b;
import com.tencent.mm.view.recyclerview.i;
import d.a.j;
import d.g.b.u;
import d.g.b.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;Landroid/view/View;)V", "feedViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getFeedViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "feedViewPool$delegate", "Lkotlin/Lazy;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "getRootView", "getTouchPhotoLayout", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "initView", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "tabType", "", "onBackPressed", "onOverEnd", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "setOnItemClickListener", "listener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "showEmptyView", "Companion", "TimelineAdapter", "plugin-finder_release"})
public final class ah
  implements x.b, HeadFooterLayout.b
{
  public static final ah.a rlC;
  private final View gFM;
  private RefreshLoadMoreLayout rfT;
  public FinderLikeDrawer rfW;
  private final d.f riG;
  final MMActivity rka;
  private MMProcessBar rlA;
  private final x.a rlB;
  
  static
  {
    AppMethodBeat.i(165939);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(ah.class), "feedViewPool", "getFeedViewPool()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;")) };
    rlC = new ah.a((byte)0);
    AppMethodBeat.o(165939);
  }
  
  public ah(MMActivity paramMMActivity, x.a parama, View paramView)
  {
    AppMethodBeat.i(201996);
    this.rka = paramMMActivity;
    this.rlB = parama;
    this.gFM = paramView;
    this.riG = d.g.K((d.g.a.a)new d(this));
    AppMethodBeat.o(201996);
  }
  
  public final boolean DH(int paramInt)
  {
    AppMethodBeat.i(165948);
    ac.i("Finder.TimelineViewCallback", "[onOverEnd] dy=".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(165948);
    return false;
  }
  
  public final void c(ArrayList<BaseFinderFeed> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(201993);
    d.g.b.k.h(paramArrayList, "data");
    Object localObject1 = com.tencent.mm.ui.component.a.IrY;
    localObject1 = (FinderTouchMediaPreviewUIC)com.tencent.mm.ui.component.a.q(this.rka).get(FinderTouchMediaPreviewUIC.class);
    Object localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (!com.tencent.mm.plugin.finder.storage.b.cyY())
    {
      localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (!com.tencent.mm.plugin.finder.storage.b.cyZ()) {}
    }
    else if (((FinderTouchMediaPreviewUIC)localObject1).cGj() == null)
    {
      localObject2 = new TouchMediaPreviewLayout((Context)((FinderTouchMediaPreviewUIC)localObject1).getActivity());
      ((TouchMediaPreviewLayout)localObject2).setId(2131306046);
      localObject3 = ((FinderTouchMediaPreviewUIC)localObject1).getActivity().getWindow();
      d.g.b.k.g(localObject3, "activity.window");
      localObject3 = ((Window)localObject3).getDecorView();
      d.g.b.k.g(localObject3, "activity.window.decorView");
      ((TouchMediaPreviewLayout)localObject2).gG((View)localObject3);
      FinderTouchMediaPreviewUIC.a((FinderTouchMediaPreviewUIC)localObject1);
    }
    localObject1 = this.gFM.findViewById(2131304203);
    d.g.b.k.g(localObject1, "parent.findViewById(R.id.rl_layout)");
    this.rfT = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = this.rfT;
    if (localObject1 == null) {
      d.g.b.k.aVY("rlLayout");
    }
    localObject2 = ai.getContext();
    d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
    int i = (int)((Context)localObject2).getResources().getDimension(2131166300);
    localObject2 = ai.getContext();
    d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject1).setLimitTopRequest(i - (int)((Context)localObject2).getResources().getDimension(2131165277));
    localObject1 = this.rfT;
    if (localObject1 == null) {
      d.g.b.k.aVY("rlLayout");
    }
    localObject2 = ai.getContext();
    d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
    i = (int)((Context)localObject2).getResources().getDimension(2131165299);
    localObject2 = ai.getContext();
    d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject1).setRefreshTargetY(i - (int)((Context)localObject2).getResources().getDimension(2131166300));
    localObject1 = this.rfT;
    if (localObject1 == null) {
      d.g.b.k.aVY("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setDamping(1.85F);
    localObject1 = this.gFM.findViewById(2131304204);
    d.g.b.k.g(localObject1, "parent.findViewById<MMPr…ar>(R.id.rl_loading_icon)");
    this.rlA = ((MMProcessBar)localObject1);
    localObject1 = this.rlA;
    if (localObject1 == null) {
      d.g.b.k.aVY("rlProcessBar");
    }
    ((MMProcessBar)localObject1).setIfVisibleRotate(false);
    localObject1 = FinderLikeDrawer.rXU;
    localObject1 = (Context)this.rka;
    localObject2 = this.rka.getWindow();
    d.g.b.k.g(localObject2, "getActivity().window");
    Object localObject3 = FinderLikeDrawer.rXU;
    this.rfW = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.cEZ());
    localObject1 = this.rfT;
    if (localObject1 == null) {
      d.g.b.k.aVY("rlLayout");
    }
    localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
    ((RecyclerView)localObject1).setRecycledViewPool((RecyclerView.n)this.riG.getValue());
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.i)new FinderLayoutManager((byte)0));
    localObject2 = this.rlB.cut();
    if (paramInt == 4) {}
    for (boolean bool = true;; bool = false)
    {
      paramArrayList = new b((com.tencent.mm.view.recyclerview.c)localObject2, paramArrayList, bool);
      paramArrayList.JCP = ((i)new e(paramInt));
      localObject2 = ((Iterable)this.rlB.cvf()).iterator();
      while (((Iterator)localObject2).hasNext()) {
        com.tencent.mm.view.recyclerview.d.a(paramArrayList, (d.b)((Iterator)localObject2).next());
      }
    }
    if (localObject1 == null)
    {
      paramArrayList = new d.v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerView");
      AppMethodBeat.o(201993);
      throw paramArrayList;
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)paramArrayList);
    ((WxRecyclerView)localObject1).setItemAnimator((RecyclerView.f)new com.tencent.mm.plugin.finder.view.animation.c());
    ((RecyclerView)localObject1).setHasFixedSize(true);
    paramArrayList = (WxRecyclerView)localObject1;
    localObject2 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject2, "MMKernel.storage()");
    paramArrayList.setFlingSpeedFactor(((com.tencent.mm.kernel.e)localObject2).agA().getInt(com.tencent.mm.storage.ah.a.GUx, 80));
    ((RecyclerView)localObject1).b((RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(((WxRecyclerView)localObject1).getResources().getColor(2131099679)), (int)((WxRecyclerView)localObject1).getResources().getDimension(2131166294)));
    paramArrayList = this.rfT;
    if (paramArrayList == null) {
      d.g.b.k.aVY("rlLayout");
    }
    paramArrayList.setActionCallback((RefreshLoadMoreLayout.a)new f(this, (RecyclerView)localObject1));
    paramArrayList = com.tencent.mm.ui.component.a.IrY;
    paramArrayList = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q(this.rka).get(FinderReporterUIC.class)).Fh(this.rlB.cvi());
    if (paramArrayList != null)
    {
      localObject1 = this.rfT;
      if (localObject1 == null) {
        d.g.b.k.aVY("rlLayout");
      }
      paramArrayList.s(((RefreshLoadMoreLayout)localObject1).getRecyclerView());
    }
    paramArrayList = this.rfT;
    if (paramArrayList == null) {
      d.g.b.k.aVY("rlLayout");
    }
    paramArrayList.setOverCallback((HeadFooterLayout.b)this);
    AppMethodBeat.o(201993);
  }
  
  public final TouchMediaPreviewLayout cvk()
  {
    AppMethodBeat.i(165941);
    Object localObject = com.tencent.mm.ui.component.a.IrY;
    localObject = ((FinderTouchMediaPreviewUIC)com.tencent.mm.ui.component.a.q(this.rka).get(FinderTouchMediaPreviewUIC.class)).cGj();
    AppMethodBeat.o(165941);
    return localObject;
  }
  
  public final RefreshLoadMoreLayout cvl()
  {
    AppMethodBeat.i(165943);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.rfT;
    if (localRefreshLoadMoreLayout == null) {
      d.g.b.k.aVY("rlLayout");
    }
    AppMethodBeat.o(165943);
    return localRefreshLoadMoreLayout;
  }
  
  public final void cvv()
  {
    AppMethodBeat.i(165946);
    ac.i("Finder.TimelineViewCallback", "[onOverStop]");
    MMProcessBar localMMProcessBar = this.rlA;
    if (localMMProcessBar == null) {
      d.g.b.k.aVY("rlProcessBar");
    }
    localMMProcessBar.fuG();
    AppMethodBeat.o(165946);
  }
  
  public final MMActivity getActivity()
  {
    return this.rka;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(165942);
    Object localObject = this.rfT;
    if (localObject == null) {
      d.g.b.k.aVY("rlLayout");
    }
    localObject = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
    AppMethodBeat.o(165942);
    return localObject;
  }
  
  public final View getRootView()
  {
    return this.gFM;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(201994);
    FinderLikeDrawer localFinderLikeDrawer = this.rfW;
    if (localFinderLikeDrawer == null) {
      d.g.b.k.aVY("friendLikeDrawer");
    }
    if (localFinderLikeDrawer.cEG())
    {
      localFinderLikeDrawer = this.rfW;
      if (localFinderLikeDrawer == null) {
        d.g.b.k.aVY("friendLikeDrawer");
      }
      localFinderLikeDrawer.cEF();
      AppMethodBeat.o(201994);
      return true;
    }
    AppMethodBeat.o(201994);
    return false;
  }
  
  public final boolean r(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(165947);
    ac.i("Finder.TimelineViewCallback", "[onOverStart] dy=".concat(String.valueOf(paramInt1)));
    MMProcessBar localMMProcessBar = this.rlA;
    if (localMMProcessBar == null) {
      d.g.b.k.aVY("rlProcessBar");
    }
    float f = paramInt1;
    Context localContext = ai.getContext();
    d.g.b.k.g(localContext, "MMApplicationContext.getContext()");
    localMMProcessBar.rotate(f / (int)localContext.getResources().getDimension(2131165288));
    AppMethodBeat.o(165947);
    return false;
  }
  
  public final void uh(long paramLong)
  {
    AppMethodBeat.i(201995);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.rfT;
    if (localRefreshLoadMoreLayout == null) {
      d.g.b.k.aVY("rlLayout");
    }
    localRefreshLoadMoreLayout.postDelayed((Runnable)new c(this), paramLong);
    AppMethodBeat.o(201995);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$TimelineAdapter;", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "itemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "needScrollData", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback;Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;Ljava/util/ArrayList;Z)V", "showResult", "_onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "onBindFirstBodyViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
  public final class b<D extends com.tencent.mm.view.recyclerview.a>
    extends WxRecyclerAdapter<D>
  {
    private final ArrayList<D> data;
    private boolean rlD;
    private final com.tencent.mm.view.recyclerview.c rlE;
    
    public b(ArrayList<D> paramArrayList, boolean paramBoolean)
    {
      super(paramBoolean, bool);
      AppMethodBeat.i(201985);
      this.rlE = paramArrayList;
      this.data = paramBoolean;
      AppMethodBeat.o(201985);
    }
    
    public final void b(com.tencent.mm.view.recyclerview.e parame, int paramInt)
    {
      AppMethodBeat.i(178276);
      d.g.b.k.h(parame, "holder");
      super.b(parame, paramInt);
      if (!this.rlD)
      {
        parame = com.tencent.mm.plugin.finder.report.d.rxr;
        com.tencent.mm.plugin.finder.report.d.ge(ah.a(ah.this).cvh(), "ShowResult");
        this.rlD = true;
      }
      AppMethodBeat.o(178276);
    }
    
    public final void t(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(201984);
      d.g.b.k.h(paramRecyclerView, "recyclerView");
      AppMethodBeat.o(201984);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(ah paramah) {}
    
    public final void run()
    {
      AppMethodBeat.i(165928);
      ah.c(this.rlF).yt(this.rjM);
      ah.d(this.rlF).fuG();
      AppMethodBeat.o(165928);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<RecyclerView.n>
  {
    d(ah paramah)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "plugin-finder_release"})
  public static final class e
    implements i
  {
    e(int paramInt) {}
    
    public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.g paramg)
    {
      AppMethodBeat.i(201986);
      d.g.b.k.h(paramRecyclerView, "recyclerView");
      d.g.b.k.h(paramg, "data");
      paramRecyclerView = com.tencent.mm.ui.component.a.IrY;
      paramRecyclerView = com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderTabStreamUnreadVM.class);
      d.g.b.k.g(paramRecyclerView, "UICProvider.of(PluginFin…reamUnreadVM::class.java)");
      paramRecyclerView = (FinderTabStreamUnreadVM)paramRecyclerView;
      if (this.rbP == 4)
      {
        Object localObject1 = (Iterable)paramg.JCB;
        paramg = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        Object localObject2;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          if ((((com.tencent.mm.view.recyclerview.h)localObject2).JCE instanceof BaseFinderFeed)) {
            paramg.add(localObject2);
          }
        }
        localObject1 = (Iterable)paramg;
        paramg = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((com.tencent.mm.view.recyclerview.h)((Iterator)localObject1).next()).JCE;
          if (localObject2 == null)
          {
            paramRecyclerView = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
            AppMethodBeat.o(201986);
            throw paramRecyclerView;
          }
          paramg.add((BaseFinderFeed)localObject2);
        }
        paramRecyclerView.i(19, (List)paramg);
      }
      AppMethodBeat.o(201986);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"})
  public static final class f
    extends RefreshLoadMoreLayout.a
  {
    private boolean rgb = true;
    
    f(RecyclerView paramRecyclerView) {}
    
    public final void Ad(int paramInt)
    {
      AppMethodBeat.i(201988);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aeE());
      super.Ad(paramInt);
      ah.a(this.rlF).requestRefresh();
      this.rbu.setItemAnimator((RecyclerView.f)new com.tencent.mm.plugin.finder.view.animation.c());
      localObject = RefreshLoadMoreLayout.c.Jyi;
      if (paramInt == RefreshLoadMoreLayout.c.fyW())
      {
        localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
        if (com.tencent.mm.plugin.finder.storage.b.czT())
        {
          localObject = FinderReporterUIC.seQ;
          localObject = FinderReporterUIC.a.eV((Context)ah.b(this.rlF));
          if (localObject != null)
          {
            com.tencent.mm.plugin.finder.report.d locald = com.tencent.mm.plugin.finder.report.d.rxr;
            com.tencent.mm.plugin.finder.report.d.a(((FinderReporterUIC)localObject).cGb(), 3);
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(201988);
    }
    
    public final void DE(int paramInt)
    {
      AppMethodBeat.i(201992);
      if ((this.rgb) && (paramInt > 0))
      {
        Object localObject = com.tencent.mm.ui.component.a.IrY;
        localObject = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q(ah.b(this.rlF)).get(FinderReporterUIC.class)).Fh(ah.a(this.rlF).cvi());
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.base.f)localObject).ctt().b(this.rbu, 5);
        }
        this.rgb = false;
      }
      AppMethodBeat.o(201992);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201991);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aeE());
      d.g.b.k.h(paramc, "reason");
      super.a(paramc);
      ac.i("Finder.TimelineViewCallback", "[onLoadMoreEnd] isHasAnyMore=".concat(String.valueOf(paramc)));
      View localView;
      if ((!paramc.Jyb) && (this.rbu.getChildCount() > 0))
      {
        localView = this.rbu.getChildAt(this.rbu.getChildCount() - 1);
        localObject = this.rbu.bu(localView);
        if (localObject == null) {
          break label171;
        }
        localObject = Integer.valueOf(((RecyclerView.w)localObject).ly());
        d.g.b.k.g(localView, "itemView");
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
        ah.a(this.rlF).a(paramc);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(201991);
        return;
        localObject = null;
        break;
      }
      for (;;)
      {
        int i = c.a.a((com.tencent.mm.plugin.finder.presenter.base.c)this.rlF).getDisplayMetrics().heightPixels - localView.getHeight();
        ah.c(this.rlF).setExtraOverScrollFooterDx(i / 3);
        ac.i("Finder.TimelineViewCallback", "extraOverScrollFooterDx=".concat(String.valueOf(i)));
        com.tencent.mm.plugin.report.service.h.wUl.n(1311L, 2L, 1L);
        break;
        label251:
        if (((Integer)localObject).intValue() != 8) {
          break;
        }
      }
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201989);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      d.g.b.k.h(paramc, "reason");
      super.b(paramc);
      ah.a(this.rlF).b(paramc);
      this.rbu.postDelayed((Runnable)new a(this), 1000L);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(201989);
    }
    
    public final void bTG()
    {
      AppMethodBeat.i(201990);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bTG();
      ah.a(this.rlF).aQh();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(201990);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ah.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(201987);
        this.rlG.rbu.setItemAnimator((RecyclerView.f)new android.support.v7.widget.v());
        AppMethodBeat.o(201987);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ah
 * JD-Core Version:    0.7.0.1
 */