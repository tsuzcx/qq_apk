package com.tencent.mm.plugin.finder.feed;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.feed.model.y.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.q;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.c;
import com.tencent.mm.view.recyclerview.d;
import com.tencent.mm.view.recyclerview.d.c;
import d.g.b.k;
import java.util.ArrayList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;Landroid/view/View;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-finder_release"})
public final class ag
  implements ac.b<BaseFinderFeed>
{
  private com.tencent.mm.plugin.finder.storage.v KMT;
  final ac.a<BaseFinderFeed> KOt;
  private final View mZe;
  final MMActivity qxp;
  
  public ag(MMActivity paramMMActivity, ac.a<BaseFinderFeed> parama, View paramView)
  {
    AppMethodBeat.i(198006);
    this.qxp = paramMMActivity;
    this.KOt = parama;
    this.mZe = paramView;
    this.KMT = ((com.tencent.mm.plugin.finder.storage.v)new q());
    AppMethodBeat.o(198006);
  }
  
  public final void N(final ArrayList<BaseFinderFeed> paramArrayList)
  {
    AppMethodBeat.i(198003);
    k.h(paramArrayList, "data");
    final RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.mZe.findViewById(2131304203);
    Object localObject1 = aj.getContext();
    k.g(localObject1, "MMApplicationContext.getContext()");
    localObject1 = ((Context)localObject1).getResources();
    localRefreshLoadMoreLayout.setLimitTopRequest((int)((Resources)localObject1).getDimension(2131166300) - (int)((Resources)localObject1).getDimension(2131165277));
    localRefreshLoadMoreLayout.setRefreshTargetY((int)((Resources)localObject1).getDimension(2131165299) - (int)((Resources)localObject1).getDimension(2131166300));
    localRefreshLoadMoreLayout.setDamping(1.85F);
    localObject1 = localRefreshLoadMoreLayout.getRecyclerView();
    Object localObject2 = this.KMT;
    Context localContext = this.mZe.getContext();
    k.g(localContext, "parent.context");
    ((RecyclerView)localObject1).setLayoutManager(((com.tencent.mm.plugin.finder.storage.v)localObject2).lw(localContext));
    ((RecyclerView)localObject1).b(this.KMT.getItemDecoration());
    ((RecyclerView)localObject1).setRecycledViewPool(this.KMT.f(this.qxp));
    localObject2 = ((RecyclerView)localObject1).getItemAnimator();
    if (localObject2 != null) {
      ((RecyclerView.f)localObject2).kT();
    }
    localObject2 = new c(this, paramArrayList, this.KMT.H((d.g.a.b)new d(this)), paramArrayList);
    ((d)localObject2).Ibo = ((d.c)new a(this, paramArrayList, localRefreshLoadMoreLayout));
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    if (localObject1 == null)
    {
      paramArrayList = new d.v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerView");
      AppMethodBeat.o(198003);
      throw paramArrayList;
    }
    paramArrayList = (WxRecyclerView)localObject1;
    localObject2 = g.afB();
    k.g(localObject2, "MMKernel.storage()");
    paramArrayList.setFlingSpeedFactor(((com.tencent.mm.kernel.e)localObject2).afk().getInt(ae.a.LAR, 80));
    localRefreshLoadMoreLayout.setActionCallback((RefreshLoadMoreLayout.a)new b(this));
    paramArrayList = com.tencent.mm.ui.component.a.LCX;
    paramArrayList = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.qxp).get(FinderReporterUIC.class));
    if (paramArrayList != null)
    {
      paramArrayList.v((RecyclerView)localObject1);
      AppMethodBeat.o(198003);
      return;
    }
    AppMethodBeat.o(198003);
  }
  
  public final RefreshLoadMoreLayout cmp()
  {
    AppMethodBeat.i(198005);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.mZe.findViewById(2131304203);
    k.g(localRefreshLoadMoreLayout, "parent.rl_layout");
    AppMethodBeat.o(198005);
    return localRefreshLoadMoreLayout;
  }
  
  public final MMActivity getActivity()
  {
    return this.qxp;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(198004);
    RecyclerView localRecyclerView = ((RefreshLoadMoreLayout)this.mZe.findViewById(2131304203)).getRecyclerView();
    AppMethodBeat.o(198004);
    return localRecyclerView;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "plugin-finder_release"})
  public static final class a
    implements d.c
  {
    a(ArrayList paramArrayList, RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
    
    public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
    {
      AppMethodBeat.i(197993);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).be(parama);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).be(paramView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$1", "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", "onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ado());
      k.h(parama, "adapter");
      k.h(paramView, "view");
      int i = ((WxRecyclerAdapter)parama).Ibl.size();
      if (paramInt < i)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$1", "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", "onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
        AppMethodBeat.o(197993);
        return;
      }
      parama = paramArrayList.get(paramInt - i);
      k.g(parama, "data[position - headCount]");
      parama = (BaseFinderFeed)parama;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("KEY_CLICK_FEED_POSITION", paramInt - i);
      long l = System.currentTimeMillis();
      Object localObject2 = g.afB();
      k.g(localObject2, "MMKernel.storage()");
      localObject2 = ((com.tencent.mm.kernel.e)localObject2).afk();
      Object localObject3 = i.qTa;
      localObject2 = ((ab)localObject2).get(i.ahH(2), "");
      if (localObject2 == null)
      {
        parama = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(197993);
        throw parama;
      }
      localObject2 = com.tencent.mm.bx.b.cd(bt.aGd((String)localObject2));
      localObject3 = com.tencent.mm.plugin.finder.feed.model.y.KQe;
      y.a.a(l, (List)paramArrayList, (com.tencent.mm.bx.b)localObject2);
      ((Intent)localObject1).putExtra("KEY_CACHE_ID", l);
      ((Intent)localObject1).putExtra("KEY_UI_TITLE", "");
      ((Intent)localObject1).putExtra("KEY_SAVE_RESULT", true);
      localObject2 = FinderReporterUIC.Ljl;
      localObject2 = paramView.getContext();
      k.g(localObject2, "view.context");
      FinderReporterUIC.a.a((Context)localObject2, (Intent)localObject1, 0L, 0, false, 124);
      localObject2 = com.tencent.mm.plugin.finder.utils.a.qSb;
      com.tencent.mm.plugin.finder.utils.a.c((Activity)this.KOE.qxp, (Intent)localObject1);
      localObject1 = FinderReporterUIC.Ljl;
      paramView = paramView.getContext();
      k.g(paramView, "view.context");
      paramView = FinderReporterUIC.a.lB(paramView);
      if (paramView != null)
      {
        paramView = paramView.fXs();
        if (paramView != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.report.b.qFq;
          com.tencent.mm.plugin.finder.report.b.a(paramView, parama.bMs(), localRefreshLoadMoreLayout.getRecyclerView());
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$1", "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", "onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
      AppMethodBeat.o(197993);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class b
    extends RefreshLoadMoreLayout.a
  {
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(197997);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
      k.h(paramc, "reason");
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(197997);
    }
    
    public final void agP(int paramInt)
    {
      AppMethodBeat.i(197994);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ado());
      super.agP(paramInt);
      this.KOE.KOt.cgG();
      localObject = RefreshLoadMoreLayout.c.HXu;
      if (paramInt == RefreshLoadMoreLayout.c.gay())
      {
        localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
        if (com.tencent.mm.plugin.finder.storage.b.fUw())
        {
          localObject = FinderReporterUIC.Ljl;
          localObject = FinderReporterUIC.a.lB((Context)this.KOE.qxp);
          if (localObject != null)
          {
            com.tencent.mm.plugin.finder.report.b localb = com.tencent.mm.plugin.finder.report.b.qFq;
            com.tencent.mm.plugin.finder.report.b.a(((FinderReporterUIC)localObject).fXs(), 3);
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(197994);
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(197995);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
      k.h(paramc, "reason");
      super.b(paramc);
      this.KOE.KOt.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(197995);
    }
    
    public final void bMu()
    {
      AppMethodBeat.i(197996);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bMu();
      this.KOE.KOt.Wc();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(197996);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$adapter$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onViewAttachedToWindow", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static final class c
    extends WxRecyclerAdapter<BaseFinderFeed>
  {
    c(ArrayList paramArrayList1, c paramc, ArrayList paramArrayList2)
    {
      super(localArrayList);
    }
    
    public final void e(com.tencent.mm.view.recyclerview.e parame)
    {
      AppMethodBeat.i(197998);
      k.h(parame, "holder");
      super.e(parame);
      Object localObject = parame.arI;
      k.g(localObject, "holder.itemView");
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
        if (parame.lp() != -1) {
          break label69;
        }
      }
      label69:
      for (boolean bool = true;; bool = false)
      {
        ((StaggeredGridLayoutManager.LayoutParams)localObject).aE(bool);
        AppMethodBeat.o(197998);
        return;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<Integer, com.tencent.mm.view.recyclerview.b<?>>
  {
    d(ag paramag)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ag
 * JD-Core Version:    0.7.0.1
 */