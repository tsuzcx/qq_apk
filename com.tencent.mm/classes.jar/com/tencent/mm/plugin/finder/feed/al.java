package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.plugin.finder.storage.n;
import com.tencent.mm.plugin.finder.storage.n.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;Landroid/view/View;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/FinderLbsConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/FinderLbsConfig;)V", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-finder_release"})
public final class al
  implements aj.b<c>
{
  private final View hVd;
  final aj.a<c> tEK;
  private n tRk;
  final MMActivity tRl;
  
  public al(MMActivity paramMMActivity, aj.a<c> parama, View paramView)
  {
    AppMethodBeat.i(244231);
    this.tRl = paramMMActivity;
    this.tEK = parama;
    this.hVd = paramView;
    this.tRk = new n(this.tRl);
    AppMethodBeat.o(244231);
  }
  
  public final void ab(final ArrayList<c> paramArrayList)
  {
    AppMethodBeat.i(244228);
    p.h(paramArrayList, "data");
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.hVd.findViewById(2131307118);
    Object localObject1 = MMApplicationContext.getContext();
    p.g(localObject1, "MMApplicationContext.getContext()");
    localObject1 = ((Context)localObject1).getResources();
    localRefreshLoadMoreLayout.setLimitTopRequest((int)((Resources)localObject1).getDimension(2131166379) - (int)((Resources)localObject1).getDimension(2131165281));
    localRefreshLoadMoreLayout.setRefreshTargetY((int)((Resources)localObject1).getDimension(2131165310) - (int)((Resources)localObject1).getDimension(2131166379));
    localRefreshLoadMoreLayout.setDamping(1.85F);
    localObject1 = localRefreshLoadMoreLayout.getRecyclerView();
    Object localObject2 = this.hVd.getContext();
    p.g(localObject2, "parent.context");
    p.h(localObject2, "context");
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new FinderLinearLayoutManager((Context)localObject2));
    localObject2 = this.hVd.getContext();
    p.g(localObject2, "parent.context");
    p.h(localObject2, "context");
    ((RecyclerView)localObject1).b((RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(((Context)localObject2).getResources().getColor(2131099689)), (int)((Context)localObject2).getResources().getDimension(2131166341)));
    localObject2 = this.tRk;
    kotlin.g.a.b localb = (kotlin.g.a.b)new c(this);
    aj.a locala = this.tEK;
    p.h(locala, "presenter");
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)new b(this, paramArrayList, (f)new n.a((n)localObject2, locala, localb), paramArrayList));
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    localRefreshLoadMoreLayout.setActionCallback((RefreshLoadMoreLayout.a)new a(this));
    AppMethodBeat.o(244228);
  }
  
  public final RefreshLoadMoreLayout dcQ()
  {
    AppMethodBeat.i(244230);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.hVd.findViewById(2131307118);
    AppMethodBeat.o(244230);
    return localRefreshLoadMoreLayout;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(244229);
    RecyclerView localRecyclerView = ((RefreshLoadMoreLayout)this.hVd.findViewById(2131307118)).getRecyclerView();
    AppMethodBeat.o(244229);
    return localRecyclerView;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class a
    extends RefreshLoadMoreLayout.a
  {
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(244218);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      super.ED(paramInt);
      this.tRm.tEK.onRefresh();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(244218);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(244221);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      super.a(paramc);
      com.tencent.mm.plugin.finder.report.h.a(com.tencent.mm.plugin.finder.report.h.veu, 2, false, null, 12);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(244221);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(244220);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cxo();
      this.tRm.tEK.onLoadMore();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(244220);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(244219);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramc, "reason");
      super.onRefreshEnd(paramc);
      this.tRm.tEK.onRefreshEnd(paramc);
      paramc = com.tencent.mm.plugin.finder.report.h.veu;
      localObject = com.tencent.mm.ui.component.a.PRN;
      com.tencent.mm.plugin.finder.report.h.a(paramc, 2, false, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.tRm.tRl).get(FinderReporterUIC.class)).dIx(), 8);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(244219);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$adapter$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "onBindFirstBodyViewHolder", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onViewAttachedToWindow", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static final class b
    extends WxRecyclerAdapter<c>
  {
    b(ArrayList paramArrayList1, f paramf, ArrayList paramArrayList2)
    {
      super(localArrayList);
    }
    
    public final void n(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(244224);
      p.h(paramRecyclerView, "recyclerView");
      AppMethodBeat.o(244224);
    }
    
    public final void n(com.tencent.mm.view.recyclerview.h paramh)
    {
      AppMethodBeat.i(244222);
      p.h(paramh, "holder");
      super.n(paramh);
      AppMethodBeat.o(244222);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<Integer, e<?>>
  {
    c(al paramal)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.al
 * JD-Core Version:    0.7.0.1
 */