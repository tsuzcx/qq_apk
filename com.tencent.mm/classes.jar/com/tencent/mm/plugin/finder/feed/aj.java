package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.n;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.c;
import com.tencent.mm.view.recyclerview.d;
import com.tencent.mm.view.recyclerview.d.c;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;Landroid/view/View;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-finder_release"})
public final class aj
  implements ad.b<al>
{
  private final View gZw;
  private com.tencent.mm.plugin.finder.storage.z rTX;
  final MMActivity rYy;
  final ad.a<al> rYz;
  
  public aj(MMActivity paramMMActivity, ad.a<al> parama, View paramView)
  {
    AppMethodBeat.i(202154);
    this.rYy = paramMMActivity;
    this.rYz = parama;
    this.gZw = paramView;
    this.rTX = ((com.tencent.mm.plugin.finder.storage.z)new n());
    AppMethodBeat.o(202154);
  }
  
  public final void U(final ArrayList<al> paramArrayList)
  {
    AppMethodBeat.i(202151);
    p.h(paramArrayList, "data");
    final RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.gZw.findViewById(2131304203);
    Object localObject1 = com.tencent.mm.sdk.platformtools.aj.getContext();
    p.g(localObject1, "MMApplicationContext.getContext()");
    localObject1 = ((Context)localObject1).getResources();
    localRefreshLoadMoreLayout.setLimitTopRequest((int)((Resources)localObject1).getDimension(2131166300) - (int)((Resources)localObject1).getDimension(2131165277));
    localRefreshLoadMoreLayout.setRefreshTargetY((int)((Resources)localObject1).getDimension(2131165299) - (int)((Resources)localObject1).getDimension(2131166300));
    localRefreshLoadMoreLayout.setDamping(1.85F);
    localObject1 = localRefreshLoadMoreLayout.getRecyclerView();
    Object localObject2 = this.rTX;
    Context localContext = this.gZw.getContext();
    p.g(localContext, "parent.context");
    ((RecyclerView)localObject1).setLayoutManager(((com.tencent.mm.plugin.finder.storage.z)localObject2).eL(localContext));
    ((RecyclerView)localObject1).b(this.rTX.getItemDecoration());
    ((RecyclerView)localObject1).setRecycledViewPool(this.rTX.f(this.rYy));
    localObject2 = ((RecyclerView)localObject1).getItemAnimator();
    if (localObject2 != null) {
      ((RecyclerView.f)localObject2).lt();
    }
    localObject2 = new c(this, paramArrayList, this.rTX.B((d.g.a.b)new d(this)), paramArrayList);
    ((d)localObject2).Lvl = ((d.c)new a(this, paramArrayList, localRefreshLoadMoreLayout));
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    if (localObject1 == null)
    {
      paramArrayList = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerView");
      AppMethodBeat.o(202151);
      throw paramArrayList;
    }
    paramArrayList = (WxRecyclerView)localObject1;
    localObject2 = com.tencent.mm.plugin.finder.storage.b.sxa;
    paramArrayList.setFlingSpeedFactor(((Number)com.tencent.mm.plugin.finder.storage.b.cHl().value()).intValue());
    localRefreshLoadMoreLayout.setActionCallback((RefreshLoadMoreLayout.a)new b(this));
    paramArrayList = com.tencent.mm.ui.component.a.KiD;
    paramArrayList = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.rYy).get(FinderReporterUIC.class));
    if (paramArrayList != null)
    {
      paramArrayList.s((RecyclerView)localObject1);
      AppMethodBeat.o(202151);
      return;
    }
    AppMethodBeat.o(202151);
  }
  
  public final RefreshLoadMoreLayout cBD()
  {
    AppMethodBeat.i(202153);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.gZw.findViewById(2131304203);
    p.g(localRefreshLoadMoreLayout, "parent.rl_layout");
    AppMethodBeat.o(202153);
    return localRefreshLoadMoreLayout;
  }
  
  public final MMActivity getActivity()
  {
    return this.rYy;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(202152);
    RecyclerView localRecyclerView = ((RefreshLoadMoreLayout)this.gZw.findViewById(2131304203)).getRecyclerView();
    AppMethodBeat.o(202152);
    return localRecyclerView;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class a
    implements d.c<com.tencent.mm.view.recyclerview.e>
  {
    a(ArrayList paramArrayList, RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class b
    extends RefreshLoadMoreLayout.a
  {
    public final void AM(int paramInt)
    {
      AppMethodBeat.i(202142);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      super.AM(paramInt);
      this.rYP.rYz.ctS();
      localObject = RefreshLoadMoreLayout.c.Lrp;
      if (paramInt == RefreshLoadMoreLayout.c.fQf())
      {
        localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
        if (((Number)com.tencent.mm.plugin.finder.storage.b.cGS().value()).intValue() == 1)
        {
          localObject = FinderReporterUIC.tcM;
          localObject = FinderReporterUIC.a.eY((Context)this.rYP.rYy);
          if (localObject != null)
          {
            h localh = h.soM;
            h.a(((FinderReporterUIC)localObject).cOu(), 3);
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(202142);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202145);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      p.h(paramc, "reason");
      super.a(paramc);
      paramc = com.tencent.mm.plugin.finder.report.e.snY;
      com.tencent.mm.plugin.finder.report.e.ae(2, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(202145);
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202143);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      p.h(paramc, "reason");
      super.b(paramc);
      this.rYP.rYz.b(paramc);
      paramc = com.tencent.mm.plugin.finder.report.e.snY;
      com.tencent.mm.plugin.finder.report.e.ae(2, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(202143);
    }
    
    public final void bYl()
    {
      AppMethodBeat.i(202144);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bYl();
      this.rYP.rYz.Zt();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(202144);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$adapter$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onViewAttachedToWindow", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static final class c
    extends WxRecyclerAdapter<al>
  {
    c(ArrayList paramArrayList1, c paramc, ArrayList paramArrayList2)
    {
      super(localArrayList);
    }
    
    public final void f(com.tencent.mm.view.recyclerview.e parame)
    {
      AppMethodBeat.i(202146);
      p.h(parame, "holder");
      super.f(parame);
      Object localObject = parame.auu;
      p.g(localObject, "holder.itemView");
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
        if (parame.lQ() != -1) {
          break label69;
        }
      }
      label69:
      for (boolean bool = true;; bool = false)
      {
        ((StaggeredGridLayoutManager.LayoutParams)localObject).aE(bool);
        AppMethodBeat.o(202146);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<Integer, com.tencent.mm.view.recyclerview.b<?>>
  {
    d(aj paramaj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.aj
 * JD-Core Version:    0.7.0.1
 */