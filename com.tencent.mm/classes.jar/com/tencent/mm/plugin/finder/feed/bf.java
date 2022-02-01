package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.i.b;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;", "parent", "Landroid/view/View;", "fragment", "Landroidx/fragment/app/Fragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;Landroid/view/View;Landroidx/fragment/app/Fragment;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getActivity", "getPresenter", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRootView", "getWxRecyclerAdapter", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "SpacesItemDecoration", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bf
  implements bd.b
{
  public WxRecyclerAdapter<cc> ALE;
  final bd.a AZL;
  final MMActivity AZo;
  private com.tencent.mm.plugin.finder.storage.as AxD;
  final String TAG;
  private final Fragment fragment;
  private final View nma;
  
  public bf(MMActivity paramMMActivity, bd.a parama, View paramView, Fragment paramFragment)
  {
    AppMethodBeat.i(362854);
    this.AZo = paramMMActivity;
    this.AZL = parama;
    this.nma = paramView;
    this.fragment = paramFragment;
    this.TAG = "FinderTimelineMachineContract.ViewCallback";
    this.AxD = ((com.tencent.mm.plugin.finder.storage.as)new ao());
    AppMethodBeat.o(362854);
  }
  
  private WxRecyclerAdapter<cc> getAdapter()
  {
    AppMethodBeat.i(362859);
    WxRecyclerAdapter localWxRecyclerAdapter = this.ALE;
    if (localWxRecyclerAdapter != null)
    {
      AppMethodBeat.o(362859);
      return localWxRecyclerAdapter;
    }
    s.bIx("adapter");
    AppMethodBeat.o(362859);
    return null;
  }
  
  public final RefreshLoadMoreLayout aNL()
  {
    AppMethodBeat.i(362905);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.nma.findViewById(e.e.rl_layout);
    s.s(localRefreshLoadMoreLayout, "parent.rl_layout");
    AppMethodBeat.o(362905);
    return localRefreshLoadMoreLayout;
  }
  
  public final void ae(ArrayList<cc> paramArrayList)
  {
    AppMethodBeat.i(362877);
    s.u(paramArrayList, "data");
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.nma.findViewById(e.e.rl_layout);
    Object localObject1 = MMApplicationContext.getContext().getResources();
    localRefreshLoadMoreLayout.setLimitTopRequest((int)((Resources)localObject1).getDimension(e.c.finder_timeline_refresh_height) - (int)((Resources)localObject1).getDimension(e.c.Edge_12A));
    localRefreshLoadMoreLayout.setRefreshTargetY((int)((Resources)localObject1).getDimension(e.c.Edge_7A) - (int)((Resources)localObject1).getDimension(e.c.finder_timeline_refresh_height));
    localRefreshLoadMoreLayout.setDamping(1.85F);
    localObject1 = localRefreshLoadMoreLayout.getRecyclerView();
    ((RecyclerView)localObject1).setRecycledViewPool(this.AxD.j(this.AZo));
    Object localObject2 = new WxRecyclerAdapter(this.AxD.au((b)new a(this)), paramArrayList);
    s.u(localObject2, "<set-?>");
    this.ALE = ((WxRecyclerAdapter)localObject2);
    localObject2 = this.AxD;
    Object localObject3 = this.nma.getContext();
    s.s(localObject3, "parent.context");
    ((RecyclerView)localObject1).setLayoutManager(((com.tencent.mm.plugin.finder.storage.as)localObject2).fT((Context)localObject3));
    ((RecyclerView)localObject1).a(this.AxD.getItemDecoration());
    localObject2 = ((Iterable)this.AZL.getHeaderInfo()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (i.b)((Iterator)localObject2).next();
      i.a((i)getAdapter(), (i.b)localObject3);
    }
    getAdapter().agOe = ((i.c)new b(paramArrayList, this));
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)getAdapter());
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    localRefreshLoadMoreLayout.setActionCallback((RefreshLoadMoreLayout.b)new c(this));
    paramArrayList = k.aeZF;
    paramArrayList = ((com.tencent.mm.plugin.finder.viewmodel.component.as)k.d((AppCompatActivity)this.AZo).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).Vo(4);
    if (paramArrayList != null) {
      paramArrayList.o(localRefreshLoadMoreLayout.getRecyclerView());
    }
    AppMethodBeat.o(362877);
  }
  
  public final WxRecyclerAdapter<cc> ecF()
  {
    AppMethodBeat.i(362888);
    WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
    AppMethodBeat.o(362888);
    return localWxRecyclerAdapter;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(362883);
    RecyclerView localRecyclerView = ((RefreshLoadMoreLayout)this.nma.findViewById(e.e.rl_layout)).getRecyclerView();
    AppMethodBeat.o(362883);
    return localRecyclerView;
  }
  
  public final View getRootView()
  {
    return this.nma;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<Integer, com.tencent.mm.view.recyclerview.f<?>>
  {
    a(bf parambf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements i.c<j>
  {
    b(ArrayList<cc> paramArrayList, bf parambf) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$initView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RefreshLoadMoreLayout.b
  {
    c(bf parambf) {}
    
    public final void IH(int paramInt)
    {
      AppMethodBeat.i(362762);
      super.IH(paramInt);
      this.AZM.AZL.onRefresh();
      AppMethodBeat.o(362762);
    }
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(362780);
      s.u(paramd, "reason");
      super.a(paramd);
      AppMethodBeat.o(362780);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(362769);
      s.u(paramd, "reason");
      super.onRefreshEnd(paramd);
      this.AZM.AZL.onRefreshEnd(paramd);
      AppMethodBeat.o(362769);
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(362775);
      super.qI(paramInt);
      this.AZM.AZL.onLoadMore();
      AppMethodBeat.o(362775);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.bf
 * JD-Core Version:    0.7.0.1
 */