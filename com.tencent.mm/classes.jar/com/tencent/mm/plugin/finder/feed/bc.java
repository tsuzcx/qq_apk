package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;Landroid/view/View;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "filterLiveItemClick", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "feed", "position", "", "getActivity", "getPresenter", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "initView", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bc
  implements ay.b<cc>
{
  final ay.a<cc> ALh;
  final MMActivity AZo;
  private com.tencent.mm.plugin.finder.storage.as AxD;
  final String TAG;
  private final View nma;
  
  public bc(MMActivity paramMMActivity, ay.a<cc> parama, View paramView)
  {
    AppMethodBeat.i(362844);
    this.AZo = paramMMActivity;
    this.ALh = parama;
    this.nma = paramView;
    this.TAG = "FinderTimelineLbsContract";
    this.AxD = ((com.tencent.mm.plugin.finder.storage.as)new r(this.AZo));
    AppMethodBeat.o(362844);
  }
  
  public final RefreshLoadMoreLayout aNL()
  {
    AppMethodBeat.i(362878);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.nma.findViewById(e.e.rl_layout);
    kotlin.g.b.s.s(localRefreshLoadMoreLayout, "parent.rl_layout");
    AppMethodBeat.o(362878);
    return localRefreshLoadMoreLayout;
  }
  
  public final void ae(ArrayList<cc> paramArrayList)
  {
    AppMethodBeat.i(362858);
    kotlin.g.b.s.u(paramArrayList, "data");
    final RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.nma.findViewById(e.e.rl_layout);
    Object localObject1 = MMApplicationContext.getContext().getResources();
    localRefreshLoadMoreLayout.setLimitTopRequest((int)((Resources)localObject1).getDimension(e.c.finder_timeline_refresh_height) - (int)((Resources)localObject1).getDimension(e.c.Edge_12A));
    localRefreshLoadMoreLayout.setRefreshTargetY((int)((Resources)localObject1).getDimension(e.c.Edge_7A) - (int)((Resources)localObject1).getDimension(e.c.finder_timeline_refresh_height));
    localRefreshLoadMoreLayout.setDamping(1.85F);
    localObject1 = localRefreshLoadMoreLayout.getRecyclerView();
    Object localObject2 = this.AxD;
    Context localContext = this.nma.getContext();
    kotlin.g.b.s.s(localContext, "parent.context");
    ((RecyclerView)localObject1).setLayoutManager(((com.tencent.mm.plugin.finder.storage.as)localObject2).fT(localContext));
    ((RecyclerView)localObject1).a(this.AxD.getItemDecoration());
    ((RecyclerView)localObject1).setRecycledViewPool(this.AxD.j(this.AZo));
    localObject2 = ((RecyclerView)localObject1).getItemAnimator();
    if (localObject2 != null) {
      ((RecyclerView.f)localObject2).bZL = 0L;
    }
    localObject2 = new c(paramArrayList, this.AxD.au((kotlin.g.a.b)new d(this)));
    ((i)localObject2).agOe = ((i.c)new a(paramArrayList, this, localRefreshLoadMoreLayout));
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    paramArrayList = (WxRecyclerView)localObject1;
    localObject2 = d.FAy;
    paramArrayList.setFlingSpeedFactor(((Number)d.eSP().bmg()).intValue());
    localRefreshLoadMoreLayout.setActionCallback((RefreshLoadMoreLayout.b)new b(this));
    paramArrayList = k.aeZF;
    paramArrayList = k.d((AppCompatActivity)this.AZo).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class);
    kotlin.g.b.s.s(paramArrayList, "UICProvider.of(getActivi…rReporterUIC::class.java)");
    paramArrayList = com.tencent.mm.plugin.finder.viewmodel.component.as.b((com.tencent.mm.plugin.finder.viewmodel.component.as)paramArrayList);
    if (paramArrayList != null) {
      paramArrayList.o((RecyclerView)localObject1);
    }
    AppMethodBeat.o(362858);
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(362866);
    RecyclerView localRecyclerView = ((RefreshLoadMoreLayout)this.nma.findViewById(e.e.rl_layout)).getRecyclerView();
    AppMethodBeat.o(362866);
    return localRecyclerView;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements i.c<j>
  {
    a(ArrayList<cc> paramArrayList, bc parambc, RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RefreshLoadMoreLayout.b
  {
    b(bc parambc) {}
    
    public final void IH(int paramInt)
    {
      AppMethodBeat.i(363796);
      super.IH(paramInt);
      this.AZx.ALh.onRefresh();
      Object localObject = RefreshLoadMoreLayout.d.agJr;
      if (paramInt == RefreshLoadMoreLayout.d.jMK())
      {
        localObject = d.FAy;
        if (((Number)d.eSi().bmg()).intValue() == 1)
        {
          localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
          localObject = as.a.hu((Context)this.AZx.AZo);
          if (localObject != null)
          {
            z localz = z.FrZ;
            z.b(((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject).fou(), 3);
          }
        }
      }
      AppMethodBeat.o(363796);
    }
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(363817);
      kotlin.g.b.s.u(paramd, "reason");
      super.a(paramd);
      com.tencent.mm.plugin.finder.report.s.a(com.tencent.mm.plugin.finder.report.s.Fqv, 2, false, null, 12);
      AppMethodBeat.o(363817);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(363804);
      kotlin.g.b.s.u(paramd, "reason");
      super.onRefreshEnd(paramd);
      this.AZx.ALh.onRefreshEnd(paramd);
      paramd = com.tencent.mm.plugin.finder.report.s.Fqv;
      k localk = k.aeZF;
      com.tencent.mm.plugin.finder.report.s.a(paramd, 2, false, ((com.tencent.mm.plugin.finder.viewmodel.component.as)k.d((AppCompatActivity)this.AZx.AZo).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou(), 8);
      AppMethodBeat.o(363804);
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(363810);
      super.qI(paramInt);
      this.AZx.ALh.onLoadMore();
      AppMethodBeat.o(363810);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$adapter$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onViewAttachedToWindow", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends WxRecyclerAdapter<cc>
  {
    c(ArrayList<cc> paramArrayList, g paramg)
    {
      super(paramArrayList);
    }
    
    public final void v(j paramj)
    {
      AppMethodBeat.i(363831);
      kotlin.g.b.s.u(paramj, "holder");
      super.v(paramj);
      Object localObject = paramj.caK.getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
        if ((paramj.caO != -1) && (paramj.caO != 2003)) {
          break label71;
        }
      }
      label71:
      for (boolean bool = true;; bool = false)
      {
        ((StaggeredGridLayoutManager.LayoutParams)localObject).cbB = bool;
        AppMethodBeat.o(363831);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<Integer, com.tencent.mm.view.recyclerview.f<?>>
  {
    d(bc parambc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.bc
 * JD-Core Version:    0.7.0.1
 */