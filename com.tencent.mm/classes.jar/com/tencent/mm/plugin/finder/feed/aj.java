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
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.n;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.c;
import com.tencent.mm.view.recyclerview.d;
import com.tencent.mm.view.recyclerview.d.c;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;Landroid/view/View;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-finder_release"})
public final class aj
  implements ad.b<am>
{
  private final View hcj;
  private com.tencent.mm.plugin.finder.storage.z scB;
  final MMActivity shk;
  final ad.a<am> shl;
  
  public aj(MMActivity paramMMActivity, ad.a<am> parama, View paramView)
  {
    AppMethodBeat.i(202618);
    this.shk = paramMMActivity;
    this.shl = parama;
    this.hcj = paramView;
    this.scB = ((com.tencent.mm.plugin.finder.storage.z)new n());
    AppMethodBeat.o(202618);
  }
  
  public final void U(final ArrayList<am> paramArrayList)
  {
    AppMethodBeat.i(202615);
    p.h(paramArrayList, "data");
    final RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.hcj.findViewById(2131304203);
    Object localObject1 = ak.getContext();
    p.g(localObject1, "MMApplicationContext.getContext()");
    localObject1 = ((Context)localObject1).getResources();
    localRefreshLoadMoreLayout.setLimitTopRequest((int)((Resources)localObject1).getDimension(2131166300) - (int)((Resources)localObject1).getDimension(2131165277));
    localRefreshLoadMoreLayout.setRefreshTargetY((int)((Resources)localObject1).getDimension(2131165299) - (int)((Resources)localObject1).getDimension(2131166300));
    localRefreshLoadMoreLayout.setDamping(1.85F);
    localObject1 = localRefreshLoadMoreLayout.getRecyclerView();
    Object localObject2 = this.scB;
    Context localContext = this.hcj.getContext();
    p.g(localContext, "parent.context");
    ((RecyclerView)localObject1).setLayoutManager(((com.tencent.mm.plugin.finder.storage.z)localObject2).eP(localContext));
    ((RecyclerView)localObject1).b(this.scB.getItemDecoration());
    ((RecyclerView)localObject1).setRecycledViewPool(this.scB.f(this.shk));
    localObject2 = ((RecyclerView)localObject1).getItemAnimator();
    if (localObject2 != null) {
      ((RecyclerView.f)localObject2).lt();
    }
    localObject2 = new c(this, paramArrayList, this.scB.B((d.g.a.b)new d(this)), paramArrayList);
    ((d)localObject2).LRY = ((d.c)new a(this, paramArrayList, localRefreshLoadMoreLayout));
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    if (localObject1 == null)
    {
      paramArrayList = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerView");
      AppMethodBeat.o(202615);
      throw paramArrayList;
    }
    paramArrayList = (WxRecyclerView)localObject1;
    localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
    paramArrayList.setFlingSpeedFactor(((Number)com.tencent.mm.plugin.finder.storage.b.cJk().value()).intValue());
    localRefreshLoadMoreLayout.setActionCallback((RefreshLoadMoreLayout.a)new b(this));
    paramArrayList = com.tencent.mm.ui.component.a.KEX;
    paramArrayList = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.shk).get(FinderReporterUIC.class));
    if (paramArrayList != null)
    {
      paramArrayList.s((RecyclerView)localObject1);
      AppMethodBeat.o(202615);
      return;
    }
    AppMethodBeat.o(202615);
  }
  
  public final RefreshLoadMoreLayout cDp()
  {
    AppMethodBeat.i(202617);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.hcj.findViewById(2131304203);
    p.g(localRefreshLoadMoreLayout, "parent.rl_layout");
    AppMethodBeat.o(202617);
    return localRefreshLoadMoreLayout;
  }
  
  public final MMActivity getActivity()
  {
    return this.shk;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(202616);
    RecyclerView localRecyclerView = ((RefreshLoadMoreLayout)this.hcj.findViewById(2131304203)).getRecyclerView();
    AppMethodBeat.o(202616);
    return localRecyclerView;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class a
    implements d.c<e>
  {
    a(ArrayList paramArrayList, RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class b
    extends RefreshLoadMoreLayout.a
  {
    public final void AY(int paramInt)
    {
      AppMethodBeat.i(202606);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      super.AY(paramInt);
      this.shB.shl.cvt();
      localObject = RefreshLoadMoreLayout.c.LOa;
      if (paramInt == RefreshLoadMoreLayout.c.fUB())
      {
        localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (((Number)com.tencent.mm.plugin.finder.storage.b.cIR().value()).intValue() == 1)
        {
          localObject = FinderReporterUIC.tnG;
          localObject = FinderReporterUIC.a.fc((Context)this.shB.shk);
          if (localObject != null)
          {
            i locali = i.syT;
            i.a(((FinderReporterUIC)localObject).cQZ(), 3);
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(202606);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202609);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      p.h(paramc, "reason");
      super.a(paramc);
      paramc = com.tencent.mm.plugin.finder.report.f.syc;
      com.tencent.mm.plugin.finder.report.f.ah(2, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(202609);
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202607);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      p.h(paramc, "reason");
      super.b(paramc);
      this.shB.shl.b(paramc);
      paramc = com.tencent.mm.plugin.finder.report.f.syc;
      com.tencent.mm.plugin.finder.report.f.ah(2, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(202607);
    }
    
    public final void bZA()
    {
      AppMethodBeat.i(202608);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bZA();
      this.shB.shl.ZC();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(202608);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$adapter$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onViewAttachedToWindow", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static final class c
    extends WxRecyclerAdapter<am>
  {
    c(ArrayList paramArrayList1, c paramc, ArrayList paramArrayList2)
    {
      super(localArrayList);
    }
    
    public final void f(e parame)
    {
      AppMethodBeat.i(202610);
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
        AppMethodBeat.o(202610);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.aj
 * JD-Core Version:    0.7.0.1
 */