package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d;
import com.tencent.mm.view.recyclerview.d.b;
import com.tencent.mm.view.recyclerview.d.c;
import d.g.b.k;
import java.util.ArrayList;
import java.util.Iterator;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;", "parent", "Landroid/view/View;", "fragment", "Landroid/support/v4/app/Fragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;Landroid/view/View;Landroid/support/v4/app/Fragment;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRootView", "getWxRecyclerAdapter", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "SpacesItemDecoration", "plugin-finder_release"})
public final class aj
  implements ah.b
{
  private v KMT;
  final ah.a KOW;
  private final Fragment fragment;
  private final View mZe;
  public WxRecyclerAdapter<BaseFinderFeed> qul;
  final MMActivity qxp;
  
  public aj(MMActivity paramMMActivity, ah.a parama, View paramView, Fragment paramFragment)
  {
    AppMethodBeat.i(198052);
    this.qxp = paramMMActivity;
    this.KOW = parama;
    this.mZe = paramView;
    this.fragment = paramFragment;
    this.KMT = ((v)new t());
    AppMethodBeat.o(198052);
  }
  
  public final void N(final ArrayList<BaseFinderFeed> paramArrayList)
  {
    AppMethodBeat.i(198048);
    k.h(paramArrayList, "data");
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.mZe.findViewById(2131304203);
    Object localObject1 = com.tencent.mm.sdk.platformtools.aj.getContext();
    k.g(localObject1, "MMApplicationContext.getContext()");
    localObject1 = ((Context)localObject1).getResources();
    localRefreshLoadMoreLayout.setLimitTopRequest((int)((Resources)localObject1).getDimension(2131166300) - (int)((Resources)localObject1).getDimension(2131165277));
    localRefreshLoadMoreLayout.setRefreshTargetY((int)((Resources)localObject1).getDimension(2131165299) - (int)((Resources)localObject1).getDimension(2131166300));
    localRefreshLoadMoreLayout.setDamping(1.85F);
    localObject1 = localRefreshLoadMoreLayout.getRecyclerView();
    ((RecyclerView)localObject1).setRecycledViewPool(this.KMT.f(this.qxp));
    this.qul = new WxRecyclerAdapter(this.KMT.H((d.g.a.b)new a(this)), paramArrayList);
    Object localObject2 = this.KMT;
    Object localObject3 = this.mZe.getContext();
    k.g(localObject3, "parent.context");
    ((RecyclerView)localObject1).setLayoutManager(((v)localObject2).lw((Context)localObject3));
    ((RecyclerView)localObject1).b(this.KMT.getItemDecoration());
    localObject2 = ((Iterable)this.KOW.cmm()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (d.b)((Iterator)localObject2).next();
      WxRecyclerAdapter localWxRecyclerAdapter = this.qul;
      if (localWxRecyclerAdapter == null) {
        k.aPZ("adapter");
      }
      d.a(localWxRecyclerAdapter, (d.b)localObject3);
    }
    localObject2 = this.qul;
    if (localObject2 == null) {
      k.aPZ("adapter");
    }
    ((d)localObject2).Ibo = ((d.c)new b(this, paramArrayList));
    paramArrayList = this.qul;
    if (paramArrayList == null) {
      k.aPZ("adapter");
    }
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)paramArrayList);
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    localRefreshLoadMoreLayout.setActionCallback((RefreshLoadMoreLayout.a)new c(this));
    paramArrayList = com.tencent.mm.ui.component.a.LCX;
    paramArrayList = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.qxp).get(FinderReporterUIC.class)).ahX(4);
    if (paramArrayList != null)
    {
      paramArrayList.v(localRefreshLoadMoreLayout.getRecyclerView());
      AppMethodBeat.o(198048);
      return;
    }
    AppMethodBeat.o(198048);
  }
  
  public final RefreshLoadMoreLayout cmp()
  {
    AppMethodBeat.i(198051);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.mZe.findViewById(2131304203);
    k.g(localRefreshLoadMoreLayout, "parent.rl_layout");
    AppMethodBeat.o(198051);
    return localRefreshLoadMoreLayout;
  }
  
  public final WxRecyclerAdapter<BaseFinderFeed> fTr()
  {
    AppMethodBeat.i(198050);
    WxRecyclerAdapter localWxRecyclerAdapter = this.qul;
    if (localWxRecyclerAdapter == null) {
      k.aPZ("adapter");
    }
    AppMethodBeat.o(198050);
    return localWxRecyclerAdapter;
  }
  
  public final MMActivity getActivity()
  {
    return this.qxp;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(198049);
    RecyclerView localRecyclerView = ((RefreshLoadMoreLayout)this.mZe.findViewById(2131304203)).getRecyclerView();
    AppMethodBeat.o(198049);
    return localRecyclerView;
  }
  
  public final View getRootView()
  {
    return this.mZe;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<Integer, com.tencent.mm.view.recyclerview.b<?>>
  {
    a(aj paramaj)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "plugin-finder_release"})
  public static final class b
    implements d.c
  {
    b(ArrayList paramArrayList) {}
    
    public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
    {
      AppMethodBeat.i(198043);
      k.h(parama, "adapter");
      k.h(paramView, "view");
      int i = ((WxRecyclerAdapter)parama).Ibl.size();
      if (paramInt < i)
      {
        AppMethodBeat.o(198043);
        return;
      }
      parama = paramArrayList.get(paramInt - i);
      k.g(parama, "data[position - headCount]");
      paramView = (BaseFinderFeed)parama;
      parama = new Intent();
      parama.putExtra("FEED_ID", paramView.feedObject.getId());
      paramView = FinderReporterUIC.Ljl;
      FinderReporterUIC.a.a((Context)this.KOX.qxp, parama, 0L, 0, false, 124);
      paramView = com.tencent.mm.plugin.finder.utils.a.qSb;
      com.tencent.mm.plugin.finder.utils.a.aj((Context)this.KOX.qxp, parama);
      AppMethodBeat.o(198043);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class c
    extends RefreshLoadMoreLayout.a
  {
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(198047);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
      k.h(paramc, "reason");
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(198047);
    }
    
    public final void agP(int paramInt)
    {
      AppMethodBeat.i(198044);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ado());
      super.agP(paramInt);
      this.KOX.KOW.cgG();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(198044);
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(198045);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
      k.h(paramc, "reason");
      super.b(paramc);
      this.KOX.KOW.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(198045);
    }
    
    public final void bMu()
    {
      AppMethodBeat.i(198046);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bMu();
      this.KOX.KOW.Wc();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(198046);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.aj
 * JD-Core Version:    0.7.0.1
 */