package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.ag;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import com.tencent.mm.view.recyclerview.h.b;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;", "parent", "Landroid/view/View;", "fragment", "Landroidx/fragment/app/Fragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;Landroid/view/View;Landroidx/fragment/app/Fragment;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getActivity", "getPresenter", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRootView", "getWxRecyclerAdapter", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "SpacesItemDecoration", "plugin-finder_release"})
public final class ay
  implements aw.b
{
  final String TAG;
  private final Fragment fragment;
  private final View kJC;
  final aw.a xCL;
  final MMActivity xCd;
  public WxRecyclerAdapter<bu> xnR;
  private ak xwa;
  
  public ay(MMActivity paramMMActivity, aw.a parama, View paramView, Fragment paramFragment)
  {
    AppMethodBeat.i(281829);
    this.xCd = paramMMActivity;
    this.xCL = parama;
    this.kJC = paramView;
    this.fragment = paramFragment;
    this.TAG = "FinderTimelineMachineContract.ViewCallback";
    this.xwa = ((ak)new ag());
    AppMethodBeat.o(281829);
  }
  
  public final void ab(final ArrayList<bu> paramArrayList)
  {
    AppMethodBeat.i(281825);
    p.k(paramArrayList, "data");
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.kJC.findViewById(b.f.rl_layout);
    Object localObject1 = MMApplicationContext.getContext();
    p.j(localObject1, "MMApplicationContext.getContext()");
    localObject1 = ((Context)localObject1).getResources();
    localRefreshLoadMoreLayout.setLimitTopRequest((int)((Resources)localObject1).getDimension(b.d.finder_timeline_refresh_height) - (int)((Resources)localObject1).getDimension(b.d.Edge_12A));
    localRefreshLoadMoreLayout.setRefreshTargetY((int)((Resources)localObject1).getDimension(b.d.Edge_7A) - (int)((Resources)localObject1).getDimension(b.d.finder_timeline_refresh_height));
    localRefreshLoadMoreLayout.setDamping(1.85F);
    localObject1 = localRefreshLoadMoreLayout.getRecyclerView();
    ((RecyclerView)localObject1).setRecycledViewPool(this.xwa.g(this.xCd));
    this.xnR = new WxRecyclerAdapter(this.xwa.O((kotlin.g.a.b)new a(this)), paramArrayList);
    Object localObject2 = this.xwa;
    Object localObject3 = this.kJC.getContext();
    p.j(localObject3, "parent.context");
    ((RecyclerView)localObject1).setLayoutManager(((ak)localObject2).eW((Context)localObject3));
    ((RecyclerView)localObject1).b(this.xwa.getItemDecoration());
    localObject2 = ((Iterable)this.xCL.getHeaderInfo()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (h.b)((Iterator)localObject2).next();
      WxRecyclerAdapter localWxRecyclerAdapter = this.xnR;
      if (localWxRecyclerAdapter == null) {
        p.bGy("adapter");
      }
      h.a(localWxRecyclerAdapter, (h.b)localObject3);
    }
    localObject2 = this.xnR;
    if (localObject2 == null) {
      p.bGy("adapter");
    }
    ((h)localObject2).YSn = ((h.c)new b(this, paramArrayList));
    paramArrayList = this.xnR;
    if (paramArrayList == null) {
      p.bGy("adapter");
    }
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)paramArrayList);
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    localRefreshLoadMoreLayout.setActionCallback((RefreshLoadMoreLayout.a)new c(this));
    paramArrayList = g.Xox;
    paramArrayList = ((aj)g.b((AppCompatActivity)this.xCd).i(aj.class)).RW(4);
    if (paramArrayList != null)
    {
      paramArrayList.k(localRefreshLoadMoreLayout.getRecyclerView());
      AppMethodBeat.o(281825);
      return;
    }
    AppMethodBeat.o(281825);
  }
  
  public final RefreshLoadMoreLayout dtq()
  {
    AppMethodBeat.i(281828);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.kJC.findViewById(b.f.rl_layout);
    p.j(localRefreshLoadMoreLayout, "parent.rl_layout");
    AppMethodBeat.o(281828);
    return localRefreshLoadMoreLayout;
  }
  
  public final WxRecyclerAdapter<bu> dtv()
  {
    AppMethodBeat.i(281827);
    WxRecyclerAdapter localWxRecyclerAdapter = this.xnR;
    if (localWxRecyclerAdapter == null) {
      p.bGy("adapter");
    }
    AppMethodBeat.o(281827);
    return localWxRecyclerAdapter;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(281826);
    RecyclerView localRecyclerView = ((RefreshLoadMoreLayout)this.kJC.findViewById(b.f.rl_layout)).getRecyclerView();
    AppMethodBeat.o(281826);
    return localRecyclerView;
  }
  
  public final View getRootView()
  {
    return this.kJC;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<Integer, e<?>>
  {
    a(ay paramay)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class b
    implements h.c<i>
  {
    b(ArrayList paramArrayList) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class c
    extends RefreshLoadMoreLayout.a
  {
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(280559);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      a.c("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      super.Ie(paramInt);
      this.xCM.xCL.onRefresh();
      a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(280559);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(280562);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      a.c("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      p.k(paramc, "reason");
      super.a(paramc);
      a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(280562);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(280561);
      a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cKQ();
      this.xCM.xCL.onLoadMore();
      a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(280561);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(280560);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      a.c("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      p.k(paramc, "reason");
      super.onRefreshEnd(paramc);
      this.xCM.xCL.onRefreshEnd(paramc);
      a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(280560);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ay
 * JD-Core Version:    0.7.0.1
 */