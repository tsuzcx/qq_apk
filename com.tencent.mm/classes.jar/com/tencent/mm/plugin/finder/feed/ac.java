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
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.feed.model.j;
import com.tencent.mm.plugin.finder.feed.model.j.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.c;
import com.tencent.mm.view.recyclerview.d.c;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;Landroid/view/View;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-finder_release"})
public final class ac
  implements y.b<BaseFinderFeed>
{
  private final View gFM;
  private r rgm;
  final MMActivity rka;
  final y.a<BaseFinderFeed> rkb;
  
  public ac(MMActivity paramMMActivity, y.a<BaseFinderFeed> parama, View paramView)
  {
    AppMethodBeat.i(201903);
    this.rka = paramMMActivity;
    this.rkb = parama;
    this.gFM = paramView;
    this.rgm = ((r)new com.tencent.mm.plugin.finder.storage.k());
    AppMethodBeat.o(201903);
  }
  
  public final void U(final ArrayList<BaseFinderFeed> paramArrayList)
  {
    AppMethodBeat.i(201900);
    d.g.b.k.h(paramArrayList, "data");
    final RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.gFM.findViewById(2131304203);
    Object localObject1 = ai.getContext();
    d.g.b.k.g(localObject1, "MMApplicationContext.getContext()");
    localObject1 = ((Context)localObject1).getResources();
    localRefreshLoadMoreLayout.setLimitTopRequest((int)((Resources)localObject1).getDimension(2131166300) - (int)((Resources)localObject1).getDimension(2131165277));
    localRefreshLoadMoreLayout.setRefreshTargetY((int)((Resources)localObject1).getDimension(2131165299) - (int)((Resources)localObject1).getDimension(2131166300));
    localRefreshLoadMoreLayout.setDamping(1.85F);
    localObject1 = localRefreshLoadMoreLayout.getRecyclerView();
    Object localObject2 = this.rgm;
    Context localContext = this.gFM.getContext();
    d.g.b.k.g(localContext, "parent.context");
    ((RecyclerView)localObject1).setLayoutManager(((r)localObject2).eL(localContext));
    ((RecyclerView)localObject1).b(this.rgm.getItemDecoration());
    ((RecyclerView)localObject1).setRecycledViewPool(this.rgm.e(this.rka));
    localObject2 = ((RecyclerView)localObject1).getItemAnimator();
    if (localObject2 != null) {
      ((RecyclerView.f)localObject2).lb();
    }
    localObject2 = new c(this, paramArrayList, this.rgm.A((d.g.a.b)new d(this)), paramArrayList);
    ((com.tencent.mm.view.recyclerview.d)localObject2).JCe = ((d.c)new a(this, paramArrayList, localRefreshLoadMoreLayout));
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    if (localObject1 == null)
    {
      paramArrayList = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerView");
      AppMethodBeat.o(201900);
      throw paramArrayList;
    }
    paramArrayList = (WxRecyclerView)localObject1;
    localObject2 = g.agR();
    d.g.b.k.g(localObject2, "MMKernel.storage()");
    paramArrayList.setFlingSpeedFactor(((com.tencent.mm.kernel.e)localObject2).agA().getInt(ah.a.GUx, 80));
    localRefreshLoadMoreLayout.setActionCallback((RefreshLoadMoreLayout.a)new b(this));
    paramArrayList = com.tencent.mm.ui.component.a.IrY;
    paramArrayList = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.q(this.rka).get(FinderReporterUIC.class));
    if (paramArrayList != null)
    {
      paramArrayList.s((RecyclerView)localObject1);
      AppMethodBeat.o(201900);
      return;
    }
    AppMethodBeat.o(201900);
  }
  
  public final RefreshLoadMoreLayout cvl()
  {
    AppMethodBeat.i(201902);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.gFM.findViewById(2131304203);
    d.g.b.k.g(localRefreshLoadMoreLayout, "parent.rl_layout");
    AppMethodBeat.o(201902);
    return localRefreshLoadMoreLayout;
  }
  
  public final MMActivity getActivity()
  {
    return this.rka;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(201901);
    RecyclerView localRecyclerView = ((RefreshLoadMoreLayout)this.gFM.findViewById(2131304203)).getRecyclerView();
    AppMethodBeat.o(201901);
    return localRecyclerView;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "plugin-finder_release"})
  public static final class a
    implements d.c
  {
    a(ArrayList paramArrayList, RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
    
    public final void b(RecyclerView.a<?> parama, View paramView, int paramInt)
    {
      AppMethodBeat.i(201890);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bb(parama);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bb(paramView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$1", "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", "onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aeE());
      d.g.b.k.h(parama, "adapter");
      d.g.b.k.h(paramView, "view");
      int i = ((WxRecyclerAdapter)parama).JCb.size();
      if (paramInt < i)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$1", "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", "onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
        AppMethodBeat.o(201890);
        return;
      }
      parama = paramArrayList.get(paramInt - i);
      d.g.b.k.g(parama, "data[position - headCount]");
      parama = (BaseFinderFeed)parama;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("KEY_CLICK_FEED_POSITION", paramInt - i);
      long l = System.currentTimeMillis();
      Object localObject2 = g.agR();
      d.g.b.k.g(localObject2, "MMKernel.storage()");
      localObject2 = ((com.tencent.mm.kernel.e)localObject2).agA();
      Object localObject3 = n.rPN;
      localObject2 = ((ae)localObject2).get(n.EI(2), "");
      if (localObject2 == null)
      {
        parama = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(201890);
        throw parama;
      }
      localObject2 = com.tencent.mm.bw.b.cc(bs.aLu((String)localObject2));
      localObject3 = j.rmZ;
      j.a.a(l, (List)paramArrayList, (com.tencent.mm.bw.b)localObject2);
      ((Intent)localObject1).putExtra("KEY_CACHE_ID", l);
      ((Intent)localObject1).putExtra("KEY_UI_TITLE", "");
      ((Intent)localObject1).putExtra("KEY_SAVE_RESULT", true);
      localObject2 = FinderReporterUIC.seQ;
      localObject2 = paramView.getContext();
      d.g.b.k.g(localObject2, "view.context");
      FinderReporterUIC.a.a((Context)localObject2, (Intent)localObject1, 0L, 0, false, 124);
      localObject2 = com.tencent.mm.plugin.finder.utils.a.rOv;
      com.tencent.mm.plugin.finder.utils.a.b((Activity)this.rko.rka, (Intent)localObject1);
      localObject1 = FinderReporterUIC.seQ;
      paramView = paramView.getContext();
      d.g.b.k.g(paramView, "view.context");
      paramView = FinderReporterUIC.a.eV(paramView);
      if (paramView != null)
      {
        paramView = paramView.cGb();
        if (paramView != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.report.d.rxr;
          com.tencent.mm.plugin.finder.report.d.a(paramView, parama.lx(), localRefreshLoadMoreLayout.getRecyclerView());
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$1", "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", "onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
      AppMethodBeat.o(201890);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class b
    extends RefreshLoadMoreLayout.a
  {
    public final void Ad(int paramInt)
    {
      AppMethodBeat.i(201891);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aeE());
      super.Ad(paramInt);
      this.rko.rkb.con();
      localObject = RefreshLoadMoreLayout.c.Jyi;
      if (paramInt == RefreshLoadMoreLayout.c.fyW())
      {
        localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
        if (com.tencent.mm.plugin.finder.storage.b.czT())
        {
          localObject = FinderReporterUIC.seQ;
          localObject = FinderReporterUIC.a.eV((Context)this.rko.rka);
          if (localObject != null)
          {
            com.tencent.mm.plugin.finder.report.d locald = com.tencent.mm.plugin.finder.report.d.rxr;
            com.tencent.mm.plugin.finder.report.d.a(((FinderReporterUIC)localObject).cGb(), 3);
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(201891);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201894);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      d.g.b.k.h(paramc, "reason");
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(201894);
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201892);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      d.g.b.k.h(paramc, "reason");
      super.b(paramc);
      this.rko.rkb.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(201892);
    }
    
    public final void bTG()
    {
      AppMethodBeat.i(201893);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bTG();
      this.rko.rkb.Xa();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(201893);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$adapter$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onViewAttachedToWindow", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static final class c
    extends WxRecyclerAdapter<BaseFinderFeed>
  {
    c(ArrayList paramArrayList1, c paramc, ArrayList paramArrayList2)
    {
      super(localArrayList);
    }
    
    public final void e(com.tencent.mm.view.recyclerview.e parame)
    {
      AppMethodBeat.i(201895);
      d.g.b.k.h(parame, "holder");
      super.e(parame);
      Object localObject = parame.asD;
      d.g.b.k.g(localObject, "holder.itemView");
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
        if (parame.ly() != -1) {
          break label69;
        }
      }
      label69:
      for (boolean bool = true;; bool = false)
      {
        ((StaggeredGridLayoutManager.LayoutParams)localObject).aE(bool);
        AppMethodBeat.o(201895);
        return;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<Integer, com.tencent.mm.view.recyclerview.b<?>>
  {
    d(ac paramac)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ac
 * JD-Core Version:    0.7.0.1
 */