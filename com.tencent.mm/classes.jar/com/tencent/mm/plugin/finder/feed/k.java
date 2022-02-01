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
import android.support.v7.widget.RecyclerView.v;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.base.b.a;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTouchMediaPreviewUIC;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.view.HeadFooterLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.d;
import com.tencent.mm.view.recyclerview.d.b;
import d.f;
import d.g.b.u;
import d.g.b.w;
import java.util.ArrayList;
import java.util.Iterator;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;Landroid/view/View;)V", "feedViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getFeedViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "feedViewPool$delegate", "Lkotlin/Lazy;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "getRootView", "getTouchPhotoLayout", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "initView", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "tabType", "", "onBackPressed", "onOverEnd", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "setOnItemClickListener", "listener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "showEmptyView", "Companion", "TimelineAdapter", "plugin-finder_release"})
public final class k
  implements i.b, HeadFooterLayout.b
{
  public static final a qxr;
  public FinderLikeDrawer KMP;
  private final View mZe;
  private RefreshLoadMoreLayout quj;
  private final f qvP;
  private MMProcessBar qxo;
  final MMActivity qxp;
  private final i.a qxq;
  
  static
  {
    AppMethodBeat.i(165939);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(k.class), "feedViewPool", "getFeedViewPool()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;")) };
    qxr = new a((byte)0);
    AppMethodBeat.o(165939);
  }
  
  public k(MMActivity paramMMActivity, i.a parama, View paramView)
  {
    AppMethodBeat.i(198088);
    this.qxp = paramMMActivity;
    this.qxq = parama;
    this.mZe = paramView;
    this.qvP = d.g.E((d.g.a.a)new d(this));
    AppMethodBeat.o(198088);
  }
  
  public final void BH(long paramLong)
  {
    AppMethodBeat.i(198087);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.quj;
    if (localRefreshLoadMoreLayout == null) {
      d.g.b.k.aPZ("rlLayout");
    }
    localRefreshLoadMoreLayout.postDelayed((Runnable)new c(this), paramLong);
    AppMethodBeat.o(198087);
  }
  
  public final boolean CF(int paramInt)
  {
    AppMethodBeat.i(165948);
    ad.i("Finder.TimelineViewCallback", "[onOverEnd] dy=".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(165948);
    return false;
  }
  
  public final TouchMediaPreviewLayout cmo()
  {
    AppMethodBeat.i(165941);
    Object localObject = com.tencent.mm.ui.component.a.LCX;
    localObject = ((FinderTouchMediaPreviewUIC)com.tencent.mm.ui.component.a.s(this.qxp).get(FinderTouchMediaPreviewUIC.class)).fXA();
    AppMethodBeat.o(165941);
    return localObject;
  }
  
  public final RefreshLoadMoreLayout cmp()
  {
    AppMethodBeat.i(165943);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.quj;
    if (localRefreshLoadMoreLayout == null) {
      d.g.b.k.aPZ("rlLayout");
    }
    AppMethodBeat.o(165943);
    return localRefreshLoadMoreLayout;
  }
  
  public final void cms()
  {
    AppMethodBeat.i(165946);
    ad.i("Finder.TimelineViewCallback", "[onOverStop]");
    MMProcessBar localMMProcessBar = this.qxo;
    if (localMMProcessBar == null) {
      d.g.b.k.aPZ("rlProcessBar");
    }
    localMMProcessBar.feL();
    AppMethodBeat.o(165946);
  }
  
  public final void d(ArrayList<BaseFinderFeed> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(198085);
    d.g.b.k.h(paramArrayList, "data");
    Object localObject1 = com.tencent.mm.ui.component.a.LCX;
    localObject1 = (FinderTouchMediaPreviewUIC)com.tencent.mm.ui.component.a.s(this.qxp).get(FinderTouchMediaPreviewUIC.class);
    Object localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (!com.tencent.mm.plugin.finder.storage.b.cpB())
    {
      localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (!com.tencent.mm.plugin.finder.storage.b.cpC()) {}
    }
    else if (((FinderTouchMediaPreviewUIC)localObject1).fXA() == null)
    {
      localObject2 = new TouchMediaPreviewLayout((Context)((FinderTouchMediaPreviewUIC)localObject1).getActivity());
      ((TouchMediaPreviewLayout)localObject2).setId(2131306046);
      localObject3 = ((FinderTouchMediaPreviewUIC)localObject1).getActivity().getWindow();
      d.g.b.k.g(localObject3, "activity.window");
      localObject3 = ((Window)localObject3).getDecorView();
      d.g.b.k.g(localObject3, "activity.window.decorView");
      ((TouchMediaPreviewLayout)localObject2).gr((View)localObject3);
      FinderTouchMediaPreviewUIC.a((FinderTouchMediaPreviewUIC)localObject1);
    }
    localObject1 = this.mZe.findViewById(2131304203);
    d.g.b.k.g(localObject1, "parent.findViewById(R.id.rl_layout)");
    this.quj = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = this.quj;
    if (localObject1 == null) {
      d.g.b.k.aPZ("rlLayout");
    }
    localObject2 = aj.getContext();
    d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
    int i = (int)((Context)localObject2).getResources().getDimension(2131166300);
    localObject2 = aj.getContext();
    d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject1).setLimitTopRequest(i - (int)((Context)localObject2).getResources().getDimension(2131165277));
    localObject1 = this.quj;
    if (localObject1 == null) {
      d.g.b.k.aPZ("rlLayout");
    }
    localObject2 = aj.getContext();
    d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
    i = (int)((Context)localObject2).getResources().getDimension(2131165299);
    localObject2 = aj.getContext();
    d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject1).setRefreshTargetY(i - (int)((Context)localObject2).getResources().getDimension(2131166300));
    localObject1 = this.quj;
    if (localObject1 == null) {
      d.g.b.k.aPZ("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setDamping(1.85F);
    localObject1 = this.mZe.findViewById(2131304204);
    d.g.b.k.g(localObject1, "parent.findViewById<MMPr…ar>(R.id.rl_loading_icon)");
    this.qxo = ((MMProcessBar)localObject1);
    localObject1 = this.qxo;
    if (localObject1 == null) {
      d.g.b.k.aPZ("rlProcessBar");
    }
    ((MMProcessBar)localObject1).setIfVisibleRotate(false);
    localObject1 = FinderLikeDrawer.Lfb;
    localObject1 = (Context)this.qxp;
    localObject2 = this.qxp.getWindow();
    d.g.b.k.g(localObject2, "getActivity().window");
    Object localObject3 = FinderLikeDrawer.Lfb;
    this.KMP = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.fWQ());
    localObject1 = this.quj;
    if (localObject1 == null) {
      d.g.b.k.aPZ("rlLayout");
    }
    localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
    ((RecyclerView)localObject1).setRecycledViewPool((RecyclerView.n)this.qvP.getValue());
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.i)new FinderLayoutManager((byte)0));
    localObject2 = this.qxq.clL();
    if (paramInt == 4) {}
    for (boolean bool = true;; bool = false)
    {
      paramArrayList = new b((com.tencent.mm.view.recyclerview.c)localObject2, paramArrayList, bool);
      localObject2 = ((Iterable)this.qxq.cmm()).iterator();
      while (((Iterator)localObject2).hasNext()) {
        d.a(paramArrayList, (d.b)((Iterator)localObject2).next());
      }
    }
    if (localObject1 == null)
    {
      paramArrayList = new d.v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerView");
      AppMethodBeat.o(198085);
      throw paramArrayList;
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)paramArrayList);
    ((WxRecyclerView)localObject1).setItemAnimator((RecyclerView.f)new com.tencent.mm.plugin.finder.view.animation.c());
    ((RecyclerView)localObject1).setHasFixedSize(true);
    paramArrayList = (WxRecyclerView)localObject1;
    localObject2 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject2, "MMKernel.storage()");
    paramArrayList.setFlingSpeedFactor(((com.tencent.mm.kernel.e)localObject2).afk().getInt(ae.a.LAR, 80));
    ((RecyclerView)localObject1).b((RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(((WxRecyclerView)localObject1).getResources().getColor(2131099679)), (int)((WxRecyclerView)localObject1).getResources().getDimension(2131166294)));
    paramArrayList = this.quj;
    if (paramArrayList == null) {
      d.g.b.k.aPZ("rlLayout");
    }
    paramArrayList.setActionCallback((RefreshLoadMoreLayout.a)new e(this, (RecyclerView)localObject1));
    paramArrayList = com.tencent.mm.ui.component.a.LCX;
    paramArrayList = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.qxp).get(FinderReporterUIC.class)).ahY(this.qxq.epE());
    if (paramArrayList != null)
    {
      localObject1 = this.quj;
      if (localObject1 == null) {
        d.g.b.k.aPZ("rlLayout");
      }
      paramArrayList.v(((RefreshLoadMoreLayout)localObject1).getRecyclerView());
    }
    paramArrayList = this.quj;
    if (paramArrayList == null) {
      d.g.b.k.aPZ("rlLayout");
    }
    paramArrayList.setOverCallback((HeadFooterLayout.b)this);
    AppMethodBeat.o(198085);
  }
  
  public final MMActivity getActivity()
  {
    return this.qxp;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(165942);
    Object localObject = this.quj;
    if (localObject == null) {
      d.g.b.k.aPZ("rlLayout");
    }
    localObject = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
    AppMethodBeat.o(165942);
    return localObject;
  }
  
  public final View getRootView()
  {
    return this.mZe;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(198086);
    FinderLikeDrawer localFinderLikeDrawer = this.KMP;
    if (localFinderLikeDrawer == null) {
      d.g.b.k.aPZ("friendLikeDrawer");
    }
    if (localFinderLikeDrawer.fiQ())
    {
      localFinderLikeDrawer = this.KMP;
      if (localFinderLikeDrawer == null) {
        d.g.b.k.aPZ("friendLikeDrawer");
      }
      localFinderLikeDrawer.csJ();
      AppMethodBeat.o(198086);
      return true;
    }
    AppMethodBeat.o(198086);
    return false;
  }
  
  public final boolean r(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(165947);
    ad.i("Finder.TimelineViewCallback", "[onOverStart] dy=".concat(String.valueOf(paramInt1)));
    MMProcessBar localMMProcessBar = this.qxo;
    if (localMMProcessBar == null) {
      d.g.b.k.aPZ("rlProcessBar");
    }
    float f = paramInt1;
    Context localContext = aj.getContext();
    d.g.b.k.g(localContext, "MMApplicationContext.getContext()");
    localMMProcessBar.rotate(f / (int)localContext.getResources().getDimension(2131165288));
    AppMethodBeat.o(165947);
    return false;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$TimelineAdapter;", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "itemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "needScrollData", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback;Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;Ljava/util/ArrayList;Z)V", "showResult", "_onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "onBindFirstBodyViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
  public final class b<D extends com.tencent.mm.view.recyclerview.a>
    extends WxRecyclerAdapter<D>
  {
    private final ArrayList<D> data;
    private boolean qxs;
    private final com.tencent.mm.view.recyclerview.c qxt;
    
    public b(ArrayList<D> paramArrayList, boolean paramBoolean)
    {
      super(paramBoolean, bool);
      AppMethodBeat.i(198083);
      this.qxt = paramArrayList;
      this.data = paramBoolean;
      AppMethodBeat.o(198083);
    }
    
    public final void b(com.tencent.mm.view.recyclerview.e parame, int paramInt)
    {
      AppMethodBeat.i(178276);
      d.g.b.k.h(parame, "holder");
      super.b(parame, paramInt);
      if (!this.qxs)
      {
        parame = com.tencent.mm.plugin.finder.report.b.qFq;
        com.tencent.mm.plugin.finder.report.b.fQ(k.a(k.this).cmn(), "ShowResult");
        this.qxs = true;
      }
      AppMethodBeat.o(178276);
    }
    
    public final void w(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(198082);
      d.g.b.k.h(paramRecyclerView, "recyclerView");
      AppMethodBeat.o(198082);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(165928);
      k.b(this.qxu).xk(this.qxv);
      k.c(this.qxu).feL();
      AppMethodBeat.o(165928);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<RecyclerView.n>
  {
    d(k paramk)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$3", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"})
  public static final class e
    extends RefreshLoadMoreLayout.a
  {
    private boolean qup = true;
    
    e(RecyclerView paramRecyclerView) {}
    
    public final void CC(int paramInt)
    {
      AppMethodBeat.i(165938);
      if ((this.qup) && (paramInt > 0))
      {
        Object localObject = com.tencent.mm.ui.component.a.LCX;
        localObject = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(k.d(this.qxu)).get(FinderReporterUIC.class)).ahY(k.a(this.qxu).epE());
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.base.e)localObject).fSD().b(this.qrn, 5);
        }
        this.qup = false;
      }
      AppMethodBeat.o(165938);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(165937);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ado());
      d.g.b.k.h(paramc, "reason");
      super.a(paramc);
      ad.i("Finder.TimelineViewCallback", "[onLoadMoreEnd] isHasAnyMore=".concat(String.valueOf(paramc)));
      View localView;
      if ((!paramc.HXq) && (this.qrn.getChildCount() > 0))
      {
        localView = this.qrn.getChildAt(this.qrn.getChildCount() - 1);
        localObject = this.qrn.bu(localView);
        if (localObject == null) {
          break label170;
        }
        localObject = Integer.valueOf(((RecyclerView.v)localObject).lp());
        d.g.b.k.g(localView, "itemView");
        if (localView.getHeight() > 0) {
          if (localObject != null) {
            break label175;
          }
        }
      }
      label170:
      label175:
      while (((Integer)localObject).intValue() != 4)
      {
        if (localObject != null) {
          break label249;
        }
        k.a(this.qxu).a(paramc);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(165937);
        return;
        localObject = null;
        break;
      }
      for (;;)
      {
        int i = b.a.a((com.tencent.mm.plugin.finder.presenter.base.b)this.qxu).getDisplayMetrics().heightPixels - localView.getHeight();
        k.b(this.qxu).setExtraOverScrollFooterDx(i / 3);
        ad.i("Finder.TimelineViewCallback", "extraOverScrollFooterDx=".concat(String.valueOf(i)));
        h.vKh.m(1311L, 2L, 1L);
        break;
        label249:
        if (((Integer)localObject).intValue() != 8) {
          break;
        }
      }
    }
    
    public final void agP(int paramInt)
    {
      AppMethodBeat.i(198084);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ado());
      super.agP(paramInt);
      k.a(this.qxu).requestRefresh();
      this.qrn.setItemAnimator((RecyclerView.f)new com.tencent.mm.plugin.finder.view.animation.c());
      localObject = RefreshLoadMoreLayout.c.HXu;
      if (paramInt == RefreshLoadMoreLayout.c.gay())
      {
        localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
        if (com.tencent.mm.plugin.finder.storage.b.fUw())
        {
          localObject = FinderReporterUIC.Ljl;
          localObject = FinderReporterUIC.a.lB((Context)k.d(this.qxu));
          if (localObject != null)
          {
            com.tencent.mm.plugin.finder.report.b localb = com.tencent.mm.plugin.finder.report.b.qFq;
            com.tencent.mm.plugin.finder.report.b.a(((FinderReporterUIC)localObject).fXs(), 3);
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(198084);
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(165935);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
      d.g.b.k.h(paramc, "reason");
      super.b(paramc);
      k.a(this.qxu).b(paramc);
      this.qrn.postDelayed((Runnable)new a(this), 1000L);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(165935);
    }
    
    public final void bMu()
    {
      AppMethodBeat.i(165936);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bMu();
      k.a(this.qxu).aJq();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(165936);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(k.e parame) {}
      
      public final void run()
      {
        AppMethodBeat.i(165933);
        this.qxx.qrn.setItemAnimator((RecyclerView.f)new android.support.v7.widget.v());
        AppMethodBeat.o(165933);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.k
 * JD-Core Version:    0.7.0.1
 */