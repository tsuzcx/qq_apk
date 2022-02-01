package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.g.c;
import java.util.ArrayList;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;Landroid/view/View;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "filterLiveItemClick", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "feed", "position", "", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "initView", "", "plugin-finder_release"})
public final class ap
  implements aj.b<bo>
{
  final String TAG;
  private final View hVd;
  final aj.a<bo> tEK;
  private al tMj;
  final MMActivity tRl;
  
  public ap(MMActivity paramMMActivity, aj.a<bo> parama, View paramView)
  {
    AppMethodBeat.i(244293);
    this.tRl = paramMMActivity;
    this.tEK = parama;
    this.hVd = paramView;
    this.TAG = "FinderTimelineLbsContract";
    this.tMj = ((al)new com.tencent.mm.plugin.finder.storage.p(this.tRl));
    AppMethodBeat.o(244293);
  }
  
  public final void ab(final ArrayList<bo> paramArrayList)
  {
    AppMethodBeat.i(244290);
    kotlin.g.b.p.h(paramArrayList, "data");
    final RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.hVd.findViewById(2131307118);
    Object localObject1 = MMApplicationContext.getContext();
    kotlin.g.b.p.g(localObject1, "MMApplicationContext.getContext()");
    localObject1 = ((Context)localObject1).getResources();
    localRefreshLoadMoreLayout.setLimitTopRequest((int)((Resources)localObject1).getDimension(2131166379) - (int)((Resources)localObject1).getDimension(2131165281));
    localRefreshLoadMoreLayout.setRefreshTargetY((int)((Resources)localObject1).getDimension(2131165310) - (int)((Resources)localObject1).getDimension(2131166379));
    localRefreshLoadMoreLayout.setDamping(1.85F);
    localObject1 = localRefreshLoadMoreLayout.getRecyclerView();
    Object localObject2 = this.tMj;
    Context localContext = this.hVd.getContext();
    kotlin.g.b.p.g(localContext, "parent.context");
    ((RecyclerView)localObject1).setLayoutManager(((al)localObject2).eS(localContext));
    ((RecyclerView)localObject1).b(this.tMj.getItemDecoration());
    ((RecyclerView)localObject1).setRecycledViewPool(this.tMj.f(this.tRl));
    localObject2 = ((RecyclerView)localObject1).getItemAnimator();
    if (localObject2 != null) {
      ((RecyclerView.f)localObject2).lB();
    }
    localObject2 = new c(this, paramArrayList, this.tMj.G((kotlin.g.a.b)new d(this)), paramArrayList);
    ((g)localObject2).RqP = ((g.c)new a(this, paramArrayList, localRefreshLoadMoreLayout));
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    if (localObject1 == null)
    {
      paramArrayList = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerView");
      AppMethodBeat.o(244290);
      throw paramArrayList;
    }
    paramArrayList = (WxRecyclerView)localObject1;
    localObject2 = c.vCb;
    paramArrayList.setFlingSpeedFactor(((Number)c.dsZ().value()).intValue());
    localRefreshLoadMoreLayout.setActionCallback((RefreshLoadMoreLayout.a)new b(this));
    paramArrayList = com.tencent.mm.ui.component.a.PRN;
    paramArrayList = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.tRl).get(FinderReporterUIC.class));
    if (paramArrayList != null)
    {
      paramArrayList.m((RecyclerView)localObject1);
      AppMethodBeat.o(244290);
      return;
    }
    AppMethodBeat.o(244290);
  }
  
  public final RefreshLoadMoreLayout dcQ()
  {
    AppMethodBeat.i(244292);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.hVd.findViewById(2131307118);
    kotlin.g.b.p.g(localRefreshLoadMoreLayout, "parent.rl_layout");
    AppMethodBeat.o(244292);
    return localRefreshLoadMoreLayout;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(244291);
    RecyclerView localRecyclerView = ((RefreshLoadMoreLayout)this.hVd.findViewById(2131307118)).getRecyclerView();
    AppMethodBeat.o(244291);
    return localRecyclerView;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class a
    implements g.c<com.tencent.mm.view.recyclerview.h>
  {
    a(ArrayList paramArrayList, RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class b
    extends RefreshLoadMoreLayout.a
  {
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(244281);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      super.ED(paramInt);
      this.tRB.tEK.onRefresh();
      localObject = RefreshLoadMoreLayout.c.Rms;
      if (paramInt == RefreshLoadMoreLayout.c.hfX())
      {
        localObject = c.vCb;
        if (((Number)c.dsx().value()).intValue() == 1)
        {
          localObject = FinderReporterUIC.wzC;
          localObject = FinderReporterUIC.a.fH((Context)this.tRB.tRl);
          if (localObject != null)
          {
            k localk = k.vfA;
            k.a(((FinderReporterUIC)localObject).dIx(), 3);
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(244281);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(244284);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      kotlin.g.b.p.h(paramc, "reason");
      super.a(paramc);
      com.tencent.mm.plugin.finder.report.h.a(com.tencent.mm.plugin.finder.report.h.veu, 2, false, null, 12);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(244284);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(244283);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cxo();
      this.tRB.tEK.onLoadMore();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(244283);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(244282);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      kotlin.g.b.p.h(paramc, "reason");
      super.onRefreshEnd(paramc);
      this.tRB.tEK.onRefreshEnd(paramc);
      paramc = com.tencent.mm.plugin.finder.report.h.veu;
      localObject = com.tencent.mm.ui.component.a.PRN;
      com.tencent.mm.plugin.finder.report.h.a(paramc, 2, false, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.tRB.tRl).get(FinderReporterUIC.class)).dIx(), 8);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(244282);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$adapter$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onViewAttachedToWindow", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static final class c
    extends WxRecyclerAdapter<bo>
  {
    c(ArrayList paramArrayList1, com.tencent.mm.view.recyclerview.f paramf, ArrayList paramArrayList2)
    {
      super(localArrayList);
    }
    
    public final void n(com.tencent.mm.view.recyclerview.h paramh)
    {
      AppMethodBeat.i(244285);
      kotlin.g.b.p.h(paramh, "holder");
      super.n(paramh);
      Object localObject = paramh.aus;
      kotlin.g.b.p.g(localObject, "holder.itemView");
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
        if ((paramh.lU() != -1) && (paramh.lU() != 2003)) {
          break label79;
        }
      }
      label79:
      for (boolean bool = true;; bool = false)
      {
        ((StaggeredGridLayoutManager.LayoutParams)localObject).aC(bool);
        AppMethodBeat.o(244285);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<Integer, e<?>>
  {
    d(ap paramap)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ap
 * JD-Core Version:    0.7.0.1
 */