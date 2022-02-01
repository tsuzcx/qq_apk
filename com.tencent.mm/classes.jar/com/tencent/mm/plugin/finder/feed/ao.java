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
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTouchMediaPreviewUIC;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
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
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;Landroid/view/View;)V", "feedViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getFeedViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "feedViewPool$delegate", "Lkotlin/Lazy;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "getRootView", "getTouchPhotoLayout", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "initView", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "tabType", "", "onBackPressed", "onOverEnd", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "setOnItemClickListener", "listener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "showEmptyView", "Companion", "TimelineAdapter", "plugin-finder_release"})
public final class ao
  implements ac.b, HeadFooterLayout.b
{
  public static final a sak;
  private final View gZw;
  private RefreshLoadMoreLayout rTF;
  public FinderLikeDrawer rTI;
  private final d.f rWT;
  final MMActivity rYy;
  private MMProcessBar sai;
  private final ac.a saj;
  
  static
  {
    AppMethodBeat.i(165939);
    sak = new a((byte)0);
    AppMethodBeat.o(165939);
  }
  
  public ao(MMActivity paramMMActivity, ac.a parama, View paramView)
  {
    AppMethodBeat.i(202260);
    this.rYy = paramMMActivity;
    this.saj = parama;
    this.gZw = paramView;
    this.rWT = d.g.O((d.g.a.a)new d(this));
    AppMethodBeat.o(202260);
  }
  
  public final boolean EA(int paramInt)
  {
    AppMethodBeat.i(165948);
    AppMethodBeat.o(165948);
    return false;
  }
  
  public final void c(ArrayList<al> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(202257);
    p.h(paramArrayList, "data");
    Object localObject1 = com.tencent.mm.ui.component.a.KiD;
    localObject1 = (FinderTouchMediaPreviewUIC)com.tencent.mm.ui.component.a.s(this.rYy).get(FinderTouchMediaPreviewUIC.class);
    Object localObject2 = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (!com.tencent.mm.plugin.finder.storage.b.cFT())
    {
      localObject2 = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (!com.tencent.mm.plugin.finder.storage.b.cFU()) {}
    }
    else if (((FinderTouchMediaPreviewUIC)localObject1).cOC() == null)
    {
      localObject2 = new TouchMediaPreviewLayout((Context)((FinderTouchMediaPreviewUIC)localObject1).getActivity());
      ((TouchMediaPreviewLayout)localObject2).setId(2131306046);
      localObject3 = ((FinderTouchMediaPreviewUIC)localObject1).getActivity().getWindow();
      p.g(localObject3, "activity.window");
      localObject3 = ((Window)localObject3).getDecorView();
      p.g(localObject3, "activity.window.decorView");
      ((TouchMediaPreviewLayout)localObject2).gX((View)localObject3);
      FinderTouchMediaPreviewUIC.a((FinderTouchMediaPreviewUIC)localObject1);
    }
    localObject1 = this.gZw.findViewById(2131304203);
    p.g(localObject1, "parent.findViewById(R.id.rl_layout)");
    this.rTF = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = this.rTF;
    if (localObject1 == null) {
      p.bcb("rlLayout");
    }
    localObject2 = aj.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    int i = (int)((Context)localObject2).getResources().getDimension(2131166300);
    localObject2 = aj.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject1).setLimitTopRequest(i - (int)((Context)localObject2).getResources().getDimension(2131165277));
    localObject1 = this.rTF;
    if (localObject1 == null) {
      p.bcb("rlLayout");
    }
    localObject2 = aj.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    i = (int)((Context)localObject2).getResources().getDimension(2131165299);
    localObject2 = aj.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject1).setRefreshTargetY(i - (int)((Context)localObject2).getResources().getDimension(2131166300));
    localObject1 = this.rTF;
    if (localObject1 == null) {
      p.bcb("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setDamping(1.85F);
    localObject1 = this.gZw.findViewById(2131304204);
    p.g(localObject1, "parent.findViewById<MMPr…ar>(R.id.rl_loading_icon)");
    this.sai = ((MMProcessBar)localObject1);
    localObject1 = this.sai;
    if (localObject1 == null) {
      p.bcb("rlProcessBar");
    }
    ((MMProcessBar)localObject1).setIfVisibleRotate(false);
    localObject1 = FinderLikeDrawer.sUO;
    localObject1 = (Context)this.rYy;
    localObject2 = this.rYy.getWindow();
    p.g(localObject2, "getActivity().window");
    Object localObject3 = FinderLikeDrawer.sUO;
    this.rTI = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.cNt());
    localObject1 = this.rTF;
    if (localObject1 == null) {
      p.bcb("rlLayout");
    }
    localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
    ((RecyclerView)localObject1).setRecycledViewPool((RecyclerView.n)this.rWT.getValue());
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.i)new FinderLayoutManager((byte)0));
    localObject2 = this.saj.cAE();
    if (paramInt == 4) {}
    for (boolean bool = true;; bool = false)
    {
      paramArrayList = new b((com.tencent.mm.view.recyclerview.c)localObject2, paramArrayList, bool);
      paramArrayList.LvV = ((i)new e(paramInt));
      localObject2 = ((Iterable)this.saj.cBx()).iterator();
      while (((Iterator)localObject2).hasNext()) {
        com.tencent.mm.view.recyclerview.d.a(paramArrayList, (d.b)((Iterator)localObject2).next());
      }
    }
    if (localObject1 == null)
    {
      paramArrayList = new d.v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerView");
      AppMethodBeat.o(202257);
      throw paramArrayList;
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)paramArrayList);
    ((WxRecyclerView)localObject1).setItemAnimator((RecyclerView.f)new com.tencent.mm.plugin.finder.view.animation.d());
    ((RecyclerView)localObject1).setHasFixedSize(true);
    paramArrayList = (WxRecyclerView)localObject1;
    localObject2 = com.tencent.mm.plugin.finder.storage.b.sxa;
    paramArrayList.setFlingSpeedFactor(((Number)com.tencent.mm.plugin.finder.storage.b.cHl().value()).intValue());
    ((RecyclerView)localObject1).b((RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(((WxRecyclerView)localObject1).getResources().getColor(2131099679)), (int)((WxRecyclerView)localObject1).getResources().getDimension(2131166294)));
    paramArrayList = this.rTF;
    if (paramArrayList == null) {
      p.bcb("rlLayout");
    }
    paramArrayList.setActionCallback((RefreshLoadMoreLayout.a)new f(this, (RecyclerView)localObject1));
    paramArrayList = com.tencent.mm.ui.component.a.KiD;
    paramArrayList = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.rYy).get(FinderReporterUIC.class)).Gx(this.saj.cBz());
    if (paramArrayList != null)
    {
      localObject1 = this.rTF;
      if (localObject1 == null) {
        p.bcb("rlLayout");
      }
      paramArrayList.s(((RefreshLoadMoreLayout)localObject1).getRecyclerView());
    }
    paramArrayList = this.rTF;
    if (paramArrayList == null) {
      p.bcb("rlLayout");
    }
    paramArrayList.setOverCallback((HeadFooterLayout.b)this);
    AppMethodBeat.o(202257);
  }
  
  public final TouchMediaPreviewLayout cBB()
  {
    AppMethodBeat.i(165941);
    Object localObject = com.tencent.mm.ui.component.a.KiD;
    localObject = ((FinderTouchMediaPreviewUIC)com.tencent.mm.ui.component.a.s(this.rYy).get(FinderTouchMediaPreviewUIC.class)).cOC();
    AppMethodBeat.o(165941);
    return localObject;
  }
  
  public final void cBC()
  {
    AppMethodBeat.i(202259);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.rTF;
    if (localRefreshLoadMoreLayout == null) {
      p.bcb("rlLayout");
    }
    localRefreshLoadMoreLayout.postDelayed((Runnable)new c(this), 150L);
    AppMethodBeat.o(202259);
  }
  
  public final RefreshLoadMoreLayout cBD()
  {
    AppMethodBeat.i(165943);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.rTF;
    if (localRefreshLoadMoreLayout == null) {
      p.bcb("rlLayout");
    }
    AppMethodBeat.o(165943);
    return localRefreshLoadMoreLayout;
  }
  
  public final void cBP()
  {
    AppMethodBeat.i(165946);
    ad.i("Finder.TimelineViewCallback", "[onOverStop]");
    MMProcessBar localMMProcessBar = this.sai;
    if (localMMProcessBar == null) {
      p.bcb("rlProcessBar");
    }
    localMMProcessBar.fLt();
    AppMethodBeat.o(165946);
  }
  
  public final MMActivity getActivity()
  {
    return this.rYy;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(165942);
    Object localObject = this.rTF;
    if (localObject == null) {
      p.bcb("rlLayout");
    }
    localObject = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
    AppMethodBeat.o(165942);
    return localObject;
  }
  
  public final View getRootView()
  {
    return this.gZw;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(202258);
    FinderLikeDrawer localFinderLikeDrawer = this.rTI;
    if (localFinderLikeDrawer == null) {
      p.bcb("friendLikeDrawer");
    }
    if (localFinderLikeDrawer.cMZ())
    {
      localFinderLikeDrawer = this.rTI;
      if (localFinderLikeDrawer == null) {
        p.bcb("friendLikeDrawer");
      }
      localFinderLikeDrawer.cMY();
      AppMethodBeat.o(202258);
      return true;
    }
    AppMethodBeat.o(202258);
    return false;
  }
  
  public final boolean r(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(165947);
    MMProcessBar localMMProcessBar = this.sai;
    if (localMMProcessBar == null) {
      p.bcb("rlProcessBar");
    }
    float f = paramInt1;
    Context localContext = aj.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    localMMProcessBar.rotate(f / (int)localContext.getResources().getDimension(2131165288));
    AppMethodBeat.o(165947);
    return false;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$TimelineAdapter;", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "itemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "needScrollData", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback;Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;Ljava/util/ArrayList;Z)V", "showResult", "_onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "onBindFirstBodyViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "throwBindViewHolderException", "", "e", "Ljava/lang/Exception;", "payloads", "", "", "throwCreateViewHolderException", "type", "plugin-finder_release"})
  public final class b<D extends com.tencent.mm.view.recyclerview.a>
    extends WxRecyclerAdapter<D>
  {
    private final ArrayList<D> data;
    private boolean sal;
    private final com.tencent.mm.view.recyclerview.c sam;
    
    public b(ArrayList<D> paramArrayList, boolean paramBoolean)
    {
      super(paramBoolean, bool);
      AppMethodBeat.i(202249);
      this.sam = paramArrayList;
      this.data = paramBoolean;
      AppMethodBeat.o(202249);
    }
    
    public final void a(e parame, int paramInt)
    {
      AppMethodBeat.i(178276);
      p.h(parame, "holder");
      super.a(parame, paramInt);
      if (!this.sal)
      {
        parame = com.tencent.mm.plugin.finder.report.h.soM;
        com.tencent.mm.plugin.finder.report.h.gn(ao.a(ao.this).cnI(), "ShowResult");
        this.sal = true;
      }
      AppMethodBeat.o(178276);
    }
    
    public final String c(Exception paramException, int paramInt)
    {
      AppMethodBeat.i(202247);
      p.h(paramException, "e");
      paramException = super.c(paramException, paramInt);
      AppMethodBeat.o(202247);
      return paramException;
    }
    
    public final void t(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(202246);
      p.h(paramRecyclerView, "recyclerView");
      AppMethodBeat.o(202246);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(ao paramao) {}
    
    public final void run()
    {
      AppMethodBeat.i(165928);
      ao.c(this.san).zg(this.rYk);
      ao.d(this.san).fLt();
      AppMethodBeat.o(165928);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<RecyclerView.n>
  {
    d(ao paramao)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "plugin-finder_release"})
  public static final class e
    implements i
  {
    e(int paramInt) {}
    
    public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.g paramg)
    {
      AppMethodBeat.i(202250);
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramg, "data");
      paramRecyclerView = com.tencent.mm.ui.component.a.KiD;
      paramRecyclerView = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTabStreamUnreadVM.class);
      p.g(paramRecyclerView, "UICProvider.of(PluginFin…reamUnreadVM::class.java)");
      paramRecyclerView = (FinderTabStreamUnreadVM)paramRecyclerView;
      if (this.sao == 4)
      {
        Object localObject1 = (Iterable)paramg.LvH;
        paramg = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        Object localObject2;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          if ((((com.tencent.mm.view.recyclerview.h)localObject2).LvK instanceof BaseFinderFeed)) {
            paramg.add(localObject2);
          }
        }
        localObject1 = (Iterable)paramg;
        paramg = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((com.tencent.mm.view.recyclerview.h)((Iterator)localObject1).next()).LvK;
          if (localObject2 == null)
          {
            paramRecyclerView = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
            AppMethodBeat.o(202250);
            throw paramRecyclerView;
          }
          paramg.add((BaseFinderFeed)localObject2);
        }
        paramRecyclerView.j(19, (List)paramg);
      }
      AppMethodBeat.o(202250);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"})
  public static final class f
    extends RefreshLoadMoreLayout.a
  {
    private boolean rTM = true;
    
    f(RecyclerView paramRecyclerView) {}
    
    public final void AM(int paramInt)
    {
      AppMethodBeat.i(202252);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      super.AM(paramInt);
      ao.a(this.san).requestRefresh();
      this.rOk.setItemAnimator((RecyclerView.f)new com.tencent.mm.plugin.finder.view.animation.d());
      localObject = RefreshLoadMoreLayout.c.Lrp;
      if (paramInt == RefreshLoadMoreLayout.c.fQf())
      {
        localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
        if (((Number)com.tencent.mm.plugin.finder.storage.b.cGS().value()).intValue() == 1)
        {
          localObject = FinderReporterUIC.tcM;
          localObject = FinderReporterUIC.a.eY((Context)ao.b(this.san));
          if (localObject != null)
          {
            com.tencent.mm.plugin.finder.report.h localh = com.tencent.mm.plugin.finder.report.h.soM;
            com.tencent.mm.plugin.finder.report.h.a(((FinderReporterUIC)localObject).cOu(), 3);
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(202252);
    }
    
    public final void Ex(int paramInt)
    {
      AppMethodBeat.i(202256);
      if ((this.rTM) && (paramInt > 0))
      {
        Object localObject = com.tencent.mm.ui.component.a.KiD;
        localObject = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(ao.b(this.san)).get(FinderReporterUIC.class)).Gx(ao.a(this.san).cBz());
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.base.f)localObject).czz().b(this.rOk, 5);
        }
        this.rTM = false;
      }
      AppMethodBeat.o(202256);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202255);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      p.h(paramc, "reason");
      super.a(paramc);
      ad.i("Finder.TimelineViewCallback", "[onLoadMoreEnd] isHasAnyMore=".concat(String.valueOf(paramc)));
      View localView;
      if ((!paramc.Lri) && (this.rOk.getChildCount() > 0))
      {
        localView = this.rOk.getChildAt(this.rOk.getChildCount() - 1);
        localObject = this.rOk.bu(localView);
        if (localObject == null) {
          break label171;
        }
        localObject = Integer.valueOf(((RecyclerView.w)localObject).lQ());
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
        ao.a(this.san).a(paramc);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(202255);
        return;
        localObject = null;
        break;
      }
      for (;;)
      {
        int i = c.a.a((com.tencent.mm.plugin.finder.presenter.base.c)this.san).getDisplayMetrics().heightPixels - localView.getHeight();
        ao.c(this.san).setExtraOverScrollFooterDx(i / 3);
        ad.i("Finder.TimelineViewCallback", "extraOverScrollFooterDx=".concat(String.valueOf(i)));
        com.tencent.mm.plugin.report.service.g.yhR.n(1311L, 2L, 1L);
        break;
        label251:
        if (((Integer)localObject).intValue() != 8) {
          break;
        }
      }
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202253);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      p.h(paramc, "reason");
      super.b(paramc);
      ao.a(this.san).b(paramc);
      this.rOk.postDelayed((Runnable)new a(this), 1000L);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(202253);
    }
    
    public final void bYl()
    {
      AppMethodBeat.i(202254);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bYl();
      ao.a(this.san).aTt();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(202254);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ao.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(202251);
        this.sap.rOk.setItemAnimator((RecyclerView.f)new android.support.v7.widget.v());
        AppMethodBeat.o(202251);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ao
 * JD-Core Version:    0.7.0.1
 */