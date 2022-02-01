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
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.aj;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;", "parent", "Landroid/view/View;", "fragment", "Landroid/support/v4/app/Fragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;Landroid/view/View;Landroid/support/v4/app/Fragment;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRootView", "getWxRecyclerAdapter", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "SpacesItemDecoration", "plugin-finder_release"})
public final class am
  implements ak.b
{
  private final Fragment fragment;
  private final View gZw;
  public WxRecyclerAdapter<al> rPu;
  private z rTX;
  final MMActivity rYy;
  final ak.a rZg;
  
  public am(MMActivity paramMMActivity, ak.a parama, View paramView, Fragment paramFragment)
  {
    AppMethodBeat.i(202200);
    this.rYy = paramMMActivity;
    this.rZg = parama;
    this.gZw = paramView;
    this.fragment = paramFragment;
    this.rTX = ((z)new x());
    AppMethodBeat.o(202200);
  }
  
  public final void U(final ArrayList<al> paramArrayList)
  {
    AppMethodBeat.i(202196);
    p.h(paramArrayList, "data");
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.gZw.findViewById(2131304203);
    Object localObject1 = aj.getContext();
    p.g(localObject1, "MMApplicationContext.getContext()");
    localObject1 = ((Context)localObject1).getResources();
    localRefreshLoadMoreLayout.setLimitTopRequest((int)((Resources)localObject1).getDimension(2131166300) - (int)((Resources)localObject1).getDimension(2131165277));
    localRefreshLoadMoreLayout.setRefreshTargetY((int)((Resources)localObject1).getDimension(2131165299) - (int)((Resources)localObject1).getDimension(2131166300));
    localRefreshLoadMoreLayout.setDamping(1.85F);
    localObject1 = localRefreshLoadMoreLayout.getRecyclerView();
    ((RecyclerView)localObject1).setRecycledViewPool(this.rTX.f(this.rYy));
    this.rPu = new WxRecyclerAdapter(this.rTX.B((d.g.a.b)new a(this)), paramArrayList);
    Object localObject2 = this.rTX;
    Object localObject3 = this.gZw.getContext();
    p.g(localObject3, "parent.context");
    ((RecyclerView)localObject1).setLayoutManager(((z)localObject2).eL((Context)localObject3));
    ((RecyclerView)localObject1).b(this.rTX.getItemDecoration());
    localObject2 = ((Iterable)this.rZg.cBx()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (d.b)((Iterator)localObject2).next();
      WxRecyclerAdapter localWxRecyclerAdapter = this.rPu;
      if (localWxRecyclerAdapter == null) {
        p.bcb("adapter");
      }
      d.a(localWxRecyclerAdapter, (d.b)localObject3);
    }
    localObject2 = this.rPu;
    if (localObject2 == null) {
      p.bcb("adapter");
    }
    ((d)localObject2).Lvl = ((d.c)new b(this, paramArrayList));
    paramArrayList = this.rPu;
    if (paramArrayList == null) {
      p.bcb("adapter");
    }
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)paramArrayList);
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    localRefreshLoadMoreLayout.setActionCallback((RefreshLoadMoreLayout.a)new c(this));
    paramArrayList = com.tencent.mm.ui.component.a.KiD;
    paramArrayList = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.rYy).get(FinderReporterUIC.class)).Gv(4);
    if (paramArrayList != null)
    {
      paramArrayList.s(localRefreshLoadMoreLayout.getRecyclerView());
      AppMethodBeat.o(202196);
      return;
    }
    AppMethodBeat.o(202196);
  }
  
  public final RefreshLoadMoreLayout cBD()
  {
    AppMethodBeat.i(202199);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.gZw.findViewById(2131304203);
    p.g(localRefreshLoadMoreLayout, "parent.rl_layout");
    AppMethodBeat.o(202199);
    return localRefreshLoadMoreLayout;
  }
  
  public final WxRecyclerAdapter<al> cBG()
  {
    AppMethodBeat.i(202198);
    WxRecyclerAdapter localWxRecyclerAdapter = this.rPu;
    if (localWxRecyclerAdapter == null) {
      p.bcb("adapter");
    }
    AppMethodBeat.o(202198);
    return localWxRecyclerAdapter;
  }
  
  public final MMActivity getActivity()
  {
    return this.rYy;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(202197);
    RecyclerView localRecyclerView = ((RefreshLoadMoreLayout)this.gZw.findViewById(2131304203)).getRecyclerView();
    AppMethodBeat.o(202197);
    return localRecyclerView;
  }
  
  public final View getRootView()
  {
    return this.gZw;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.b<Integer, com.tencent.mm.view.recyclerview.b<?>>
  {
    a(am paramam)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class b
    implements d.c<e>
  {
    b(ArrayList paramArrayList) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class c
    extends RefreshLoadMoreLayout.a
  {
    public final void AM(int paramInt)
    {
      AppMethodBeat.i(202192);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahq());
      super.AM(paramInt);
      this.rZh.rZg.ctS();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(202192);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202195);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      p.h(paramc, "reason");
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(202195);
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202193);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      p.h(paramc, "reason");
      super.b(paramc);
      this.rZh.rZg.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(202193);
    }
    
    public final void bYl()
    {
      AppMethodBeat.i(202194);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bYl();
      this.rZh.rZg.Zt();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(202194);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.am
 * JD-Core Version:    0.7.0.1
 */