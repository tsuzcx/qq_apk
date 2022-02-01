package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.ah;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.g.b;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;", "parent", "Landroid/view/View;", "fragment", "Landroid/support/v4/app/Fragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;Landroid/view/View;Landroid/support/v4/app/Fragment;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRootView", "getWxRecyclerAdapter", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "SpacesItemDecoration", "plugin-finder_release"})
public final class as
  implements aq.b
{
  final String TAG;
  private final Fragment fragment;
  private final View hVd;
  public WxRecyclerAdapter<bo> tFp;
  private al tMj;
  final aq.a tRT;
  final MMActivity tRl;
  
  public as(MMActivity paramMMActivity, aq.a parama, View paramView, Fragment paramFragment)
  {
    AppMethodBeat.i(244341);
    this.tRl = paramMMActivity;
    this.tRT = parama;
    this.hVd = paramView;
    this.fragment = paramFragment;
    this.TAG = "FinderTimelineMachineContract.ViewCallback";
    this.tMj = ((al)new ah());
    AppMethodBeat.o(244341);
  }
  
  public final void ab(final ArrayList<bo> paramArrayList)
  {
    AppMethodBeat.i(244337);
    p.h(paramArrayList, "data");
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.hVd.findViewById(2131307118);
    Object localObject1 = MMApplicationContext.getContext();
    p.g(localObject1, "MMApplicationContext.getContext()");
    localObject1 = ((Context)localObject1).getResources();
    localRefreshLoadMoreLayout.setLimitTopRequest((int)((Resources)localObject1).getDimension(2131166379) - (int)((Resources)localObject1).getDimension(2131165281));
    localRefreshLoadMoreLayout.setRefreshTargetY((int)((Resources)localObject1).getDimension(2131165310) - (int)((Resources)localObject1).getDimension(2131166379));
    localRefreshLoadMoreLayout.setDamping(1.85F);
    localObject1 = localRefreshLoadMoreLayout.getRecyclerView();
    ((RecyclerView)localObject1).setRecycledViewPool(this.tMj.f(this.tRl));
    this.tFp = new WxRecyclerAdapter(this.tMj.G((kotlin.g.a.b)new a(this)), paramArrayList);
    Object localObject2 = this.tMj;
    Object localObject3 = this.hVd.getContext();
    p.g(localObject3, "parent.context");
    ((RecyclerView)localObject1).setLayoutManager(((al)localObject2).eS((Context)localObject3));
    ((RecyclerView)localObject1).b(this.tMj.getItemDecoration());
    localObject2 = ((Iterable)this.tRT.getHeaderInfo()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (g.b)((Iterator)localObject2).next();
      WxRecyclerAdapter localWxRecyclerAdapter = this.tFp;
      if (localWxRecyclerAdapter == null) {
        p.btv("adapter");
      }
      g.a(localWxRecyclerAdapter, (g.b)localObject3);
    }
    localObject2 = this.tFp;
    if (localObject2 == null) {
      p.btv("adapter");
    }
    ((g)localObject2).RqP = ((g.c)new b(this, paramArrayList));
    paramArrayList = this.tFp;
    if (paramArrayList == null) {
      p.btv("adapter");
    }
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)paramArrayList);
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    localRefreshLoadMoreLayout.setActionCallback((RefreshLoadMoreLayout.a)new c(this));
    paramArrayList = com.tencent.mm.ui.component.a.PRN;
    paramArrayList = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.tRl).get(FinderReporterUIC.class)).MC(4);
    if (paramArrayList != null)
    {
      paramArrayList.m(localRefreshLoadMoreLayout.getRecyclerView());
      AppMethodBeat.o(244337);
      return;
    }
    AppMethodBeat.o(244337);
  }
  
  public final RefreshLoadMoreLayout dcQ()
  {
    AppMethodBeat.i(244340);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.hVd.findViewById(2131307118);
    p.g(localRefreshLoadMoreLayout, "parent.rl_layout");
    AppMethodBeat.o(244340);
    return localRefreshLoadMoreLayout;
  }
  
  public final WxRecyclerAdapter<bo> dcT()
  {
    AppMethodBeat.i(244339);
    WxRecyclerAdapter localWxRecyclerAdapter = this.tFp;
    if (localWxRecyclerAdapter == null) {
      p.btv("adapter");
    }
    AppMethodBeat.o(244339);
    return localWxRecyclerAdapter;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(244338);
    RecyclerView localRecyclerView = ((RefreshLoadMoreLayout)this.hVd.findViewById(2131307118)).getRecyclerView();
    AppMethodBeat.o(244338);
    return localRecyclerView;
  }
  
  public final View getRootView()
  {
    return this.hVd;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<Integer, e<?>>
  {
    a(as paramas)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class b
    implements g.c<h>
  {
    b(ArrayList paramArrayList) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class c
    extends RefreshLoadMoreLayout.a
  {
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(244333);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      super.ED(paramInt);
      this.tRU.tRT.onRefresh();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(244333);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(244336);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(244336);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(244335);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cxo();
      this.tRU.tRT.onLoadMore();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(244335);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(244334);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      super.onRefreshEnd(paramc);
      this.tRU.tRT.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(244334);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.as
 * JD-Core Version:    0.7.0.1
 */