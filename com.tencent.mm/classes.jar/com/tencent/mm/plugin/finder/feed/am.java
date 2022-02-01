package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d;
import com.tencent.mm.view.recyclerview.d.b;
import com.tencent.mm.view.recyclerview.d.c;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;", "parent", "Landroid/view/View;", "fragment", "Landroid/support/v4/app/Fragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;Landroid/view/View;Landroid/support/v4/app/Fragment;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRootView", "getWxRecyclerAdapter", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "SpacesItemDecoration", "plugin-finder_release"})
public final class am
  implements ak.b
{
  private final Fragment fragment;
  private final View hcj;
  public WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.am> rXV;
  private z scB;
  final ak.a shS;
  final MMActivity shk;
  
  public am(MMActivity paramMMActivity, ak.a parama, View paramView, Fragment paramFragment)
  {
    AppMethodBeat.i(202664);
    this.shk = paramMMActivity;
    this.shS = parama;
    this.hcj = paramView;
    this.fragment = paramFragment;
    this.scB = ((z)new x());
    AppMethodBeat.o(202664);
  }
  
  public final void U(final ArrayList<com.tencent.mm.plugin.finder.model.am> paramArrayList)
  {
    AppMethodBeat.i(202660);
    p.h(paramArrayList, "data");
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.hcj.findViewById(2131304203);
    Object localObject1 = ak.getContext();
    p.g(localObject1, "MMApplicationContext.getContext()");
    localObject1 = ((Context)localObject1).getResources();
    localRefreshLoadMoreLayout.setLimitTopRequest((int)((Resources)localObject1).getDimension(2131166300) - (int)((Resources)localObject1).getDimension(2131165277));
    localRefreshLoadMoreLayout.setRefreshTargetY((int)((Resources)localObject1).getDimension(2131165299) - (int)((Resources)localObject1).getDimension(2131166300));
    localRefreshLoadMoreLayout.setDamping(1.85F);
    localObject1 = localRefreshLoadMoreLayout.getRecyclerView();
    ((RecyclerView)localObject1).setRecycledViewPool(this.scB.f(this.shk));
    this.rXV = new WxRecyclerAdapter(this.scB.B((d.g.a.b)new a(this)), paramArrayList);
    Object localObject2 = this.scB;
    Object localObject3 = this.hcj.getContext();
    p.g(localObject3, "parent.context");
    ((RecyclerView)localObject1).setLayoutManager(((z)localObject2).eP((Context)localObject3));
    ((RecyclerView)localObject1).b(this.scB.getItemDecoration());
    localObject2 = ((Iterable)this.shS.cDj()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (d.b)((Iterator)localObject2).next();
      WxRecyclerAdapter localWxRecyclerAdapter = this.rXV;
      if (localWxRecyclerAdapter == null) {
        p.bdF("adapter");
      }
      d.a(localWxRecyclerAdapter, (d.b)localObject3);
    }
    localObject2 = this.rXV;
    if (localObject2 == null) {
      p.bdF("adapter");
    }
    ((d)localObject2).LRY = ((d.c)new b(this, paramArrayList));
    paramArrayList = this.rXV;
    if (paramArrayList == null) {
      p.bdF("adapter");
    }
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)paramArrayList);
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    localRefreshLoadMoreLayout.setActionCallback((RefreshLoadMoreLayout.a)new c(this));
    paramArrayList = com.tencent.mm.ui.component.a.KEX;
    paramArrayList = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.shk).get(FinderReporterUIC.class)).GS(4);
    if (paramArrayList != null)
    {
      paramArrayList.s(localRefreshLoadMoreLayout.getRecyclerView());
      AppMethodBeat.o(202660);
      return;
    }
    AppMethodBeat.o(202660);
  }
  
  public final RefreshLoadMoreLayout cDp()
  {
    AppMethodBeat.i(202663);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.hcj.findViewById(2131304203);
    p.g(localRefreshLoadMoreLayout, "parent.rl_layout");
    AppMethodBeat.o(202663);
    return localRefreshLoadMoreLayout;
  }
  
  public final WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.am> cDs()
  {
    AppMethodBeat.i(202662);
    WxRecyclerAdapter localWxRecyclerAdapter = this.rXV;
    if (localWxRecyclerAdapter == null) {
      p.bdF("adapter");
    }
    AppMethodBeat.o(202662);
    return localWxRecyclerAdapter;
  }
  
  public final MMActivity getActivity()
  {
    return this.shk;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(202661);
    RecyclerView localRecyclerView = ((RefreshLoadMoreLayout)this.hcj.findViewById(2131304203)).getRecyclerView();
    AppMethodBeat.o(202661);
    return localRecyclerView;
  }
  
  public final View getRootView()
  {
    return this.hcj;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.b<Integer, com.tencent.mm.view.recyclerview.b<?>>
  {
    a(am paramam)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class b
    implements d.c<e>
  {
    b(ArrayList paramArrayList) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class c
    extends RefreshLoadMoreLayout.a
  {
    public final void AY(int paramInt)
    {
      AppMethodBeat.i(202656);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahF());
      super.AY(paramInt);
      this.shT.shS.cvt();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(202656);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202659);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      p.h(paramc, "reason");
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(202659);
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202657);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      p.h(paramc, "reason");
      super.b(paramc);
      this.shT.shS.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(202657);
    }
    
    public final void bZA()
    {
      AppMethodBeat.i(202658);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bZA();
      this.shT.shS.ZC();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(202658);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.am
 * JD-Core Version:    0.7.0.1
 */