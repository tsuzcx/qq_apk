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
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTouchMediaPreviewUIC;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
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
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;Landroid/view/View;)V", "feedViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getFeedViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "feedViewPool$delegate", "Lkotlin/Lazy;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "getRootView", "getTouchPhotoLayout", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "initView", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "tabType", "", "onBackPressed", "onOverEnd", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "setOnItemClickListener", "listener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "showEmptyView", "Companion", "TimelineAdapter", "plugin-finder_release"})
public final class ao
  implements ac.b, HeadFooterLayout.b
{
  public static final ao.a siZ;
  private final View hcj;
  private RefreshLoadMoreLayout scj;
  public FinderLikeDrawer scm;
  private final d.f sfE;
  final MMActivity shk;
  private MMProcessBar siX;
  private final ac.a siY;
  
  static
  {
    AppMethodBeat.i(165939);
    siZ = new ao.a((byte)0);
    AppMethodBeat.o(165939);
  }
  
  public ao(MMActivity paramMMActivity, ac.a parama, View paramView)
  {
    AppMethodBeat.i(202725);
    this.shk = paramMMActivity;
    this.siY = parama;
    this.hcj = paramView;
    this.sfE = d.g.O((d.g.a.a)new d(this));
    AppMethodBeat.o(202725);
  }
  
  public final boolean EN(int paramInt)
  {
    AppMethodBeat.i(165948);
    AppMethodBeat.o(165948);
    return false;
  }
  
  public final void c(ArrayList<am> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(202722);
    p.h(paramArrayList, "data");
    Object localObject1 = com.tencent.mm.ui.component.a.KEX;
    localObject1 = (FinderTouchMediaPreviewUIC)com.tencent.mm.ui.component.a.s(this.shk).get(FinderTouchMediaPreviewUIC.class);
    Object localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (!com.tencent.mm.plugin.finder.storage.b.cHQ())
    {
      localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (!com.tencent.mm.plugin.finder.storage.b.cHR()) {}
    }
    else if (((FinderTouchMediaPreviewUIC)localObject1).cRh() == null)
    {
      localObject2 = new TouchMediaPreviewLayout((Context)((FinderTouchMediaPreviewUIC)localObject1).getActivity());
      ((TouchMediaPreviewLayout)localObject2).setId(2131306046);
      localObject3 = ((FinderTouchMediaPreviewUIC)localObject1).getActivity().getWindow();
      p.g(localObject3, "activity.window");
      localObject3 = ((Window)localObject3).getDecorView();
      p.g(localObject3, "activity.window.decorView");
      ((TouchMediaPreviewLayout)localObject2).hc((View)localObject3);
      FinderTouchMediaPreviewUIC.a((FinderTouchMediaPreviewUIC)localObject1);
    }
    localObject1 = this.hcj.findViewById(2131304203);
    p.g(localObject1, "parent.findViewById(R.id.rl_layout)");
    this.scj = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = this.scj;
    if (localObject1 == null) {
      p.bdF("rlLayout");
    }
    localObject2 = ak.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    int i = (int)((Context)localObject2).getResources().getDimension(2131166300);
    localObject2 = ak.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject1).setLimitTopRequest(i - (int)((Context)localObject2).getResources().getDimension(2131165277));
    localObject1 = this.scj;
    if (localObject1 == null) {
      p.bdF("rlLayout");
    }
    localObject2 = ak.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    i = (int)((Context)localObject2).getResources().getDimension(2131165299);
    localObject2 = ak.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject1).setRefreshTargetY(i - (int)((Context)localObject2).getResources().getDimension(2131166300));
    localObject1 = this.scj;
    if (localObject1 == null) {
      p.bdF("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setDamping(1.85F);
    localObject1 = this.hcj.findViewById(2131304204);
    p.g(localObject1, "parent.findViewById<MMPr…ar>(R.id.rl_loading_icon)");
    this.siX = ((MMProcessBar)localObject1);
    localObject1 = this.siX;
    if (localObject1 == null) {
      p.bdF("rlProcessBar");
    }
    ((MMProcessBar)localObject1).setIfVisibleRotate(false);
    localObject1 = FinderLikeDrawer.tgd;
    localObject1 = (Context)this.shk;
    localObject2 = this.shk.getWindow();
    p.g(localObject2, "getActivity().window");
    Object localObject3 = FinderLikeDrawer.tgd;
    this.scm = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.cQd());
    localObject1 = this.scj;
    if (localObject1 == null) {
      p.bdF("rlLayout");
    }
    localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
    ((RecyclerView)localObject1).setRecycledViewPool((RecyclerView.n)this.sfE.getValue());
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.i)new FinderLayoutManager((byte)0));
    localObject2 = this.siY.cCq();
    if (paramInt == 4) {}
    for (boolean bool = true;; bool = false)
    {
      paramArrayList = new b((com.tencent.mm.view.recyclerview.c)localObject2, paramArrayList, bool);
      paramArrayList.LSI = ((com.tencent.mm.view.recyclerview.i)new ao.e(paramInt));
      localObject2 = ((Iterable)this.siY.cDj()).iterator();
      while (((Iterator)localObject2).hasNext()) {
        com.tencent.mm.view.recyclerview.d.a(paramArrayList, (d.b)((Iterator)localObject2).next());
      }
    }
    if (localObject1 == null)
    {
      paramArrayList = new d.v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerView");
      AppMethodBeat.o(202722);
      throw paramArrayList;
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)paramArrayList);
    ((WxRecyclerView)localObject1).setItemAnimator((RecyclerView.f)new com.tencent.mm.plugin.finder.view.animation.d());
    ((RecyclerView)localObject1).setHasFixedSize(true);
    paramArrayList = (WxRecyclerView)localObject1;
    localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
    paramArrayList.setFlingSpeedFactor(((Number)com.tencent.mm.plugin.finder.storage.b.cJk().value()).intValue());
    ((RecyclerView)localObject1).b((RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(((WxRecyclerView)localObject1).getResources().getColor(2131099679)), (int)((WxRecyclerView)localObject1).getResources().getDimension(2131166294)));
    paramArrayList = this.scj;
    if (paramArrayList == null) {
      p.bdF("rlLayout");
    }
    paramArrayList.setActionCallback((RefreshLoadMoreLayout.a)new f(this, (RecyclerView)localObject1));
    paramArrayList = com.tencent.mm.ui.component.a.KEX;
    paramArrayList = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.shk).get(FinderReporterUIC.class)).GU(this.siY.cDl());
    if (paramArrayList != null)
    {
      localObject1 = this.scj;
      if (localObject1 == null) {
        p.bdF("rlLayout");
      }
      paramArrayList.s(((RefreshLoadMoreLayout)localObject1).getRecyclerView());
    }
    paramArrayList = this.scj;
    if (paramArrayList == null) {
      p.bdF("rlLayout");
    }
    paramArrayList.setOverCallback((HeadFooterLayout.b)this);
    AppMethodBeat.o(202722);
  }
  
  public final void cDB()
  {
    AppMethodBeat.i(165946);
    ae.i("Finder.TimelineViewCallback", "[onOverStop]");
    MMProcessBar localMMProcessBar = this.siX;
    if (localMMProcessBar == null) {
      p.bdF("rlProcessBar");
    }
    localMMProcessBar.fPN();
    AppMethodBeat.o(165946);
  }
  
  public final TouchMediaPreviewLayout cDn()
  {
    AppMethodBeat.i(165941);
    Object localObject = com.tencent.mm.ui.component.a.KEX;
    localObject = ((FinderTouchMediaPreviewUIC)com.tencent.mm.ui.component.a.s(this.shk).get(FinderTouchMediaPreviewUIC.class)).cRh();
    AppMethodBeat.o(165941);
    return localObject;
  }
  
  public final void cDo()
  {
    AppMethodBeat.i(202724);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.scj;
    if (localRefreshLoadMoreLayout == null) {
      p.bdF("rlLayout");
    }
    localRefreshLoadMoreLayout.postDelayed((Runnable)new c(this), 150L);
    AppMethodBeat.o(202724);
  }
  
  public final RefreshLoadMoreLayout cDp()
  {
    AppMethodBeat.i(165943);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.scj;
    if (localRefreshLoadMoreLayout == null) {
      p.bdF("rlLayout");
    }
    AppMethodBeat.o(165943);
    return localRefreshLoadMoreLayout;
  }
  
  public final MMActivity getActivity()
  {
    return this.shk;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(165942);
    Object localObject = this.scj;
    if (localObject == null) {
      p.bdF("rlLayout");
    }
    localObject = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
    AppMethodBeat.o(165942);
    return localObject;
  }
  
  public final View getRootView()
  {
    return this.hcj;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(202723);
    FinderLikeDrawer localFinderLikeDrawer = this.scm;
    if (localFinderLikeDrawer == null) {
      p.bdF("friendLikeDrawer");
    }
    if (localFinderLikeDrawer.cPI())
    {
      localFinderLikeDrawer = this.scm;
      if (localFinderLikeDrawer == null) {
        p.bdF("friendLikeDrawer");
      }
      localFinderLikeDrawer.cPH();
      AppMethodBeat.o(202723);
      return true;
    }
    AppMethodBeat.o(202723);
    return false;
  }
  
  public final boolean r(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(165947);
    MMProcessBar localMMProcessBar = this.siX;
    if (localMMProcessBar == null) {
      p.bdF("rlProcessBar");
    }
    float f = paramInt1;
    Context localContext = ak.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    localMMProcessBar.rotate(f / (int)localContext.getResources().getDimension(2131165288));
    AppMethodBeat.o(165947);
    return false;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$TimelineAdapter;", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "itemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "needScrollData", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback;Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;Ljava/util/ArrayList;Z)V", "showResult", "_onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "onBindFirstBodyViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "throwBindViewHolderException", "", "e", "Ljava/lang/Exception;", "payloads", "", "", "throwCreateViewHolderException", "type", "plugin-finder_release"})
  public final class b<D extends com.tencent.mm.view.recyclerview.a>
    extends WxRecyclerAdapter<D>
  {
    private final ArrayList<D> data;
    private boolean sja;
    private final com.tencent.mm.view.recyclerview.c sjb;
    
    public b(ArrayList<D> paramArrayList, boolean paramBoolean)
    {
      super(paramBoolean, bool);
      AppMethodBeat.i(202714);
      this.sjb = paramArrayList;
      this.data = paramBoolean;
      AppMethodBeat.o(202714);
    }
    
    public final void a(e parame, int paramInt)
    {
      AppMethodBeat.i(178276);
      p.h(parame, "holder");
      super.a(parame, paramInt);
      if (!this.sja)
      {
        parame = com.tencent.mm.plugin.finder.report.i.syT;
        com.tencent.mm.plugin.finder.report.i.gs(ao.a(ao.this).cpk(), "ShowResult");
        this.sja = true;
      }
      AppMethodBeat.o(178276);
    }
    
    public final String c(Exception paramException, int paramInt)
    {
      AppMethodBeat.i(202712);
      p.h(paramException, "e");
      paramException = super.c(paramException, paramInt);
      AppMethodBeat.o(202712);
      return paramException;
    }
    
    public final void t(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(202711);
      p.h(paramRecyclerView, "recyclerView");
      AppMethodBeat.o(202711);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(ao paramao) {}
    
    public final void run()
    {
      AppMethodBeat.i(165928);
      ao.c(this.sjc).zu(this.sgW);
      ao.d(this.sjc).fPN();
      AppMethodBeat.o(165928);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<RecyclerView.n>
  {
    d(ao paramao)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"})
  public static final class f
    extends RefreshLoadMoreLayout.a
  {
    private boolean scq = true;
    
    f(RecyclerView paramRecyclerView) {}
    
    public final void AY(int paramInt)
    {
      AppMethodBeat.i(202717);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      super.AY(paramInt);
      ao.a(this.sjc).requestRefresh();
      this.rWI.setItemAnimator((RecyclerView.f)new com.tencent.mm.plugin.finder.view.animation.d());
      localObject = RefreshLoadMoreLayout.c.LOa;
      if (paramInt == RefreshLoadMoreLayout.c.fUB())
      {
        localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (((Number)com.tencent.mm.plugin.finder.storage.b.cIR().value()).intValue() == 1)
        {
          localObject = FinderReporterUIC.tnG;
          localObject = FinderReporterUIC.a.fc((Context)ao.b(this.sjc));
          if (localObject != null)
          {
            com.tencent.mm.plugin.finder.report.i locali = com.tencent.mm.plugin.finder.report.i.syT;
            com.tencent.mm.plugin.finder.report.i.a(((FinderReporterUIC)localObject).cQZ(), 3);
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(202717);
    }
    
    public final void EK(int paramInt)
    {
      AppMethodBeat.i(202721);
      if ((this.scq) && (paramInt > 0))
      {
        Object localObject = com.tencent.mm.ui.component.a.KEX;
        localObject = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(ao.b(this.sjc)).get(FinderReporterUIC.class)).GU(ao.a(this.sjc).cDl());
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.base.f)localObject).cBd().b(this.rWI, 5);
        }
        this.scq = false;
      }
      AppMethodBeat.o(202721);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202720);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      p.h(paramc, "reason");
      super.a(paramc);
      ae.i("Finder.TimelineViewCallback", "[onLoadMoreEnd] isHasAnyMore=".concat(String.valueOf(paramc)));
      View localView;
      if ((!paramc.LNT) && (this.rWI.getChildCount() > 0))
      {
        localView = this.rWI.getChildAt(this.rWI.getChildCount() - 1);
        localObject = this.rWI.bu(localView);
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
        ao.a(this.sjc).a(paramc);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(202720);
        return;
        localObject = null;
        break;
      }
      for (;;)
      {
        int i = c.a.a((com.tencent.mm.plugin.finder.presenter.base.c)this.sjc).getDisplayMetrics().heightPixels - localView.getHeight();
        ao.c(this.sjc).setExtraOverScrollFooterDx(i / 3);
        ae.i("Finder.TimelineViewCallback", "extraOverScrollFooterDx=".concat(String.valueOf(i)));
        com.tencent.mm.plugin.report.service.g.yxI.n(1311L, 2L, 1L);
        break;
        label251:
        if (((Integer)localObject).intValue() != 8) {
          break;
        }
      }
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202718);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      p.h(paramc, "reason");
      super.b(paramc);
      ao.a(this.sjc).b(paramc);
      this.rWI.postDelayed((Runnable)new a(this), 1000L);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(202718);
    }
    
    public final void bZA()
    {
      AppMethodBeat.i(202719);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bZA();
      ao.a(this.sjc).aTS();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(202719);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ao.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(202716);
        this.sje.rWI.setItemAnimator((RecyclerView.f)new android.support.v7.widget.v());
        AppMethodBeat.o(202716);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ao
 * JD-Core Version:    0.7.0.1
 */