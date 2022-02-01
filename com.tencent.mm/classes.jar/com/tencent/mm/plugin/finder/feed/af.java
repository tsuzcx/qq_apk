package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.l.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.p;
import d.g.b.q;
import d.z;
import java.util.ArrayList;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;Landroid/view/View;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/FinderLbsConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/FinderLbsConfig;)V", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-finder_release"})
public final class af
  implements ad.b<com.tencent.mm.plugin.finder.model.c>
{
  private final View gZw;
  private com.tencent.mm.plugin.finder.storage.l rYx;
  final MMActivity rYy;
  final ad.a<com.tencent.mm.plugin.finder.model.c> rYz;
  
  public af(MMActivity paramMMActivity, ad.a<com.tencent.mm.plugin.finder.model.c> parama, View paramView)
  {
    AppMethodBeat.i(202099);
    this.rYy = paramMMActivity;
    this.rYz = parama;
    this.gZw = paramView;
    this.rYx = new com.tencent.mm.plugin.finder.storage.l();
    AppMethodBeat.o(202099);
  }
  
  public final void U(final ArrayList<com.tencent.mm.plugin.finder.model.c> paramArrayList)
  {
    AppMethodBeat.i(202096);
    p.h(paramArrayList, "data");
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.gZw.findViewById(2131304203);
    Object localObject = aj.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    localRefreshLoadMoreLayout.setLimitTopRequest((int)((Resources)localObject).getDimension(2131166300) - (int)((Resources)localObject).getDimension(2131165277));
    localRefreshLoadMoreLayout.setRefreshTargetY((int)((Resources)localObject).getDimension(2131165299) - (int)((Resources)localObject).getDimension(2131166300));
    localRefreshLoadMoreLayout.setDamping(1.85F);
    localObject = localRefreshLoadMoreLayout.getRecyclerView();
    Context localContext = this.gZw.getContext();
    p.g(localContext, "parent.context");
    p.h(localContext, "context");
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.i)new FinderLayoutManager((byte)0));
    localContext = this.gZw.getContext();
    p.g(localContext, "parent.context");
    p.h(localContext, "context");
    ((RecyclerView)localObject).b((RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(localContext.getResources().getColor(2131099679)), (int)localContext.getResources().getDimension(2131166294)));
    ((RecyclerView)localObject).setAdapter((RecyclerView.a)new b(this, paramArrayList, (com.tencent.mm.view.recyclerview.c)new l.a(this.rYx, (d.g.a.b)new c(this)), paramArrayList));
    ((RecyclerView)localObject).setHasFixedSize(true);
    ((RecyclerView)localObject).setItemViewCacheSize(4);
    localRefreshLoadMoreLayout.setActionCallback((RefreshLoadMoreLayout.a)new a(this));
    AppMethodBeat.o(202096);
  }
  
  public final RefreshLoadMoreLayout cBD()
  {
    AppMethodBeat.i(202098);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.gZw.findViewById(2131304203);
    p.g(localRefreshLoadMoreLayout, "parent.rl_layout");
    AppMethodBeat.o(202098);
    return localRefreshLoadMoreLayout;
  }
  
  public final MMActivity getActivity()
  {
    return this.rYy;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(202097);
    RecyclerView localRecyclerView = ((RefreshLoadMoreLayout)this.gZw.findViewById(2131304203)).getRecyclerView();
    AppMethodBeat.o(202097);
    return localRecyclerView;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class a
    extends RefreshLoadMoreLayout.a
  {
    public final void AM(int paramInt)
    {
      AppMethodBeat.i(202086);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahq());
      super.AM(paramInt);
      this.rYA.rYz.ctS();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(202086);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202089);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      p.h(paramc, "reason");
      super.a(paramc);
      paramc = com.tencent.mm.plugin.finder.report.e.snY;
      com.tencent.mm.plugin.finder.report.e.ae(2, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(202089);
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202087);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      p.h(paramc, "reason");
      super.b(paramc);
      this.rYA.rYz.b(paramc);
      paramc = com.tencent.mm.plugin.finder.report.e.snY;
      com.tencent.mm.plugin.finder.report.e.ae(2, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(202087);
    }
    
    public final void bYl()
    {
      AppMethodBeat.i(202088);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bYl();
      this.rYA.rYz.Zt();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(202088);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$adapter$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "onBindFirstBodyViewHolder", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onViewAttachedToWindow", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static final class b
    extends WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.c>
  {
    b(ArrayList paramArrayList1, com.tencent.mm.view.recyclerview.c paramc, ArrayList paramArrayList2)
    {
      super(localArrayList);
    }
    
    public final void f(com.tencent.mm.view.recyclerview.e parame)
    {
      AppMethodBeat.i(202090);
      p.h(parame, "holder");
      super.f(parame);
      AppMethodBeat.o(202090);
    }
    
    public final void t(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(202092);
      p.h(paramRecyclerView, "recyclerView");
      AppMethodBeat.o(202092);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.b<Integer, com.tencent.mm.view.recyclerview.b<?>>
  {
    c(af paramaf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.af
 * JD-Core Version:    0.7.0.1
 */