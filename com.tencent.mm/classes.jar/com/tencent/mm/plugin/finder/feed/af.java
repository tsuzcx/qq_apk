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
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.p;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.ai;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;", "parent", "Landroid/view/View;", "fragment", "Landroid/support/v4/app/Fragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;Landroid/view/View;Landroid/support/v4/app/Fragment;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRootView", "getWxRecyclerAdapter", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "SpacesItemDecoration", "plugin-finder_release"})
public final class af
  implements ad.b
{
  private final Fragment fragment;
  private final View gFM;
  public WxRecyclerAdapter<BaseFinderFeed> rfX;
  private r rgm;
  final ad.a rkH;
  final MMActivity rka;
  
  public af(MMActivity paramMMActivity, ad.a parama, View paramView, Fragment paramFragment)
  {
    AppMethodBeat.i(201949);
    this.rka = paramMMActivity;
    this.rkH = parama;
    this.gFM = paramView;
    this.fragment = paramFragment;
    this.rgm = ((r)new p());
    AppMethodBeat.o(201949);
  }
  
  public final void U(final ArrayList<BaseFinderFeed> paramArrayList)
  {
    AppMethodBeat.i(201945);
    k.h(paramArrayList, "data");
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.gFM.findViewById(2131304203);
    Object localObject1 = ai.getContext();
    k.g(localObject1, "MMApplicationContext.getContext()");
    localObject1 = ((Context)localObject1).getResources();
    localRefreshLoadMoreLayout.setLimitTopRequest((int)((Resources)localObject1).getDimension(2131166300) - (int)((Resources)localObject1).getDimension(2131165277));
    localRefreshLoadMoreLayout.setRefreshTargetY((int)((Resources)localObject1).getDimension(2131165299) - (int)((Resources)localObject1).getDimension(2131166300));
    localRefreshLoadMoreLayout.setDamping(1.85F);
    localObject1 = localRefreshLoadMoreLayout.getRecyclerView();
    ((RecyclerView)localObject1).setRecycledViewPool(this.rgm.e(this.rka));
    this.rfX = new WxRecyclerAdapter(this.rgm.A((d.g.a.b)new a(this)), paramArrayList);
    Object localObject2 = this.rgm;
    Object localObject3 = this.gFM.getContext();
    k.g(localObject3, "parent.context");
    ((RecyclerView)localObject1).setLayoutManager(((r)localObject2).eL((Context)localObject3));
    ((RecyclerView)localObject1).b(this.rgm.getItemDecoration());
    localObject2 = ((Iterable)this.rkH.cvf()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (d.b)((Iterator)localObject2).next();
      WxRecyclerAdapter localWxRecyclerAdapter = this.rfX;
      if (localWxRecyclerAdapter == null) {
        k.aVY("adapter");
      }
      d.a(localWxRecyclerAdapter, (d.b)localObject3);
    }
    localObject2 = this.rfX;
    if (localObject2 == null) {
      k.aVY("adapter");
    }
    ((d)localObject2).JCe = ((d.c)new b(this, paramArrayList));
    paramArrayList = this.rfX;
    if (paramArrayList == null) {
      k.aVY("adapter");
    }
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)paramArrayList);
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    localRefreshLoadMoreLayout.setActionCallback((RefreshLoadMoreLayout.a)new c(this));
    paramArrayList = com.tencent.mm.ui.component.a.IrY;
    paramArrayList = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q(this.rka).get(FinderReporterUIC.class)).Ff(4);
    if (paramArrayList != null)
    {
      paramArrayList.s(localRefreshLoadMoreLayout.getRecyclerView());
      AppMethodBeat.o(201945);
      return;
    }
    AppMethodBeat.o(201945);
  }
  
  public final RefreshLoadMoreLayout cvl()
  {
    AppMethodBeat.i(201948);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.gFM.findViewById(2131304203);
    k.g(localRefreshLoadMoreLayout, "parent.rl_layout");
    AppMethodBeat.o(201948);
    return localRefreshLoadMoreLayout;
  }
  
  public final WxRecyclerAdapter<BaseFinderFeed> cvo()
  {
    AppMethodBeat.i(201947);
    WxRecyclerAdapter localWxRecyclerAdapter = this.rfX;
    if (localWxRecyclerAdapter == null) {
      k.aVY("adapter");
    }
    AppMethodBeat.o(201947);
    return localWxRecyclerAdapter;
  }
  
  public final MMActivity getActivity()
  {
    return this.rka;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(201946);
    RecyclerView localRecyclerView = ((RefreshLoadMoreLayout)this.gFM.findViewById(2131304203)).getRecyclerView();
    AppMethodBeat.o(201946);
    return localRecyclerView;
  }
  
  public final View getRootView()
  {
    return this.gFM;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<Integer, com.tencent.mm.view.recyclerview.b<?>>
  {
    a(af paramaf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "plugin-finder_release"})
  public static final class b
    implements d.c
  {
    b(ArrayList paramArrayList) {}
    
    public final void b(RecyclerView.a<?> parama, View paramView, int paramInt)
    {
      AppMethodBeat.i(201940);
      k.h(parama, "adapter");
      k.h(paramView, "view");
      int i = ((WxRecyclerAdapter)parama).JCb.size();
      if (paramInt < i)
      {
        AppMethodBeat.o(201940);
        return;
      }
      parama = paramArrayList.get(paramInt - i);
      k.g(parama, "data[position - headCount]");
      paramView = (BaseFinderFeed)parama;
      parama = new Intent();
      parama.putExtra("FEED_ID", paramView.feedObject.getId());
      paramView = FinderReporterUIC.seQ;
      FinderReporterUIC.a.a((Context)this.rkI.rka, parama, 0L, 0, false, 124);
      paramView = com.tencent.mm.plugin.finder.utils.a.rOv;
      com.tencent.mm.plugin.finder.utils.a.S((Context)this.rkI.rka, parama);
      AppMethodBeat.o(201940);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class c
    extends RefreshLoadMoreLayout.a
  {
    public final void Ad(int paramInt)
    {
      AppMethodBeat.i(201941);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aeE());
      super.Ad(paramInt);
      this.rkI.rkH.con();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(201941);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201944);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      k.h(paramc, "reason");
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(201944);
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201942);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      k.h(paramc, "reason");
      super.b(paramc);
      this.rkI.rkH.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(201942);
    }
    
    public final void bTG()
    {
      AppMethodBeat.i(201943);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bTG();
      this.rkI.rkH.Xa();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(201943);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.af
 * JD-Core Version:    0.7.0.1
 */