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
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.plugin.finder.storage.i.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.c;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.y;
import java.util.ArrayList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;Landroid/view/View;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/FinderLbsConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/FinderLbsConfig;)V", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-finder_release"})
public final class aa
  implements y.b<com.tencent.mm.plugin.finder.model.b>
{
  private final View gFM;
  private i rjZ;
  final MMActivity rka;
  final y.a<com.tencent.mm.plugin.finder.model.b> rkb;
  
  public aa(MMActivity paramMMActivity, y.a<com.tencent.mm.plugin.finder.model.b> parama, View paramView)
  {
    AppMethodBeat.i(201852);
    this.rka = paramMMActivity;
    this.rkb = parama;
    this.gFM = paramView;
    this.rjZ = new i();
    AppMethodBeat.o(201852);
  }
  
  public final void U(final ArrayList<com.tencent.mm.plugin.finder.model.b> paramArrayList)
  {
    AppMethodBeat.i(201849);
    k.h(paramArrayList, "data");
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.gFM.findViewById(2131304203);
    Object localObject = ai.getContext();
    k.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    localRefreshLoadMoreLayout.setLimitTopRequest((int)((Resources)localObject).getDimension(2131166300) - (int)((Resources)localObject).getDimension(2131165277));
    localRefreshLoadMoreLayout.setRefreshTargetY((int)((Resources)localObject).getDimension(2131165299) - (int)((Resources)localObject).getDimension(2131166300));
    localRefreshLoadMoreLayout.setDamping(1.85F);
    localObject = localRefreshLoadMoreLayout.getRecyclerView();
    Context localContext = this.gFM.getContext();
    k.g(localContext, "parent.context");
    k.h(localContext, "context");
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.i)new FinderLayoutManager((byte)0));
    localContext = this.gFM.getContext();
    k.g(localContext, "parent.context");
    k.h(localContext, "context");
    ((RecyclerView)localObject).b((RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(localContext.getResources().getColor(2131099679)), (int)localContext.getResources().getDimension(2131166294)));
    ((RecyclerView)localObject).setAdapter((RecyclerView.a)new b(this, paramArrayList, (c)new i.a(this.rjZ, (d.g.a.b)new c(this)), paramArrayList));
    ((RecyclerView)localObject).setHasFixedSize(true);
    ((RecyclerView)localObject).setItemViewCacheSize(4);
    localRefreshLoadMoreLayout.setActionCallback((RefreshLoadMoreLayout.a)new a(this));
    AppMethodBeat.o(201849);
  }
  
  public final RefreshLoadMoreLayout cvl()
  {
    AppMethodBeat.i(201851);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.gFM.findViewById(2131304203);
    k.g(localRefreshLoadMoreLayout, "parent.rl_layout");
    AppMethodBeat.o(201851);
    return localRefreshLoadMoreLayout;
  }
  
  public final MMActivity getActivity()
  {
    return this.rka;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(201850);
    RecyclerView localRecyclerView = ((RefreshLoadMoreLayout)this.gFM.findViewById(2131304203)).getRecyclerView();
    AppMethodBeat.o(201850);
    return localRecyclerView;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class a
    extends RefreshLoadMoreLayout.a
  {
    public final void Ad(int paramInt)
    {
      AppMethodBeat.i(201839);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aeE());
      super.Ad(paramInt);
      this.rkc.rkb.con();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(201839);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201842);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      k.h(paramc, "reason");
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(201842);
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201840);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      k.h(paramc, "reason");
      super.b(paramc);
      this.rkc.rkb.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(201840);
    }
    
    public final void bTG()
    {
      AppMethodBeat.i(201841);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bTG();
      this.rkc.rkb.Xa();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(201841);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$adapter$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "onBindFirstBodyViewHolder", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onViewAttachedToWindow", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static final class b
    extends WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.b>
  {
    b(ArrayList paramArrayList1, c paramc, ArrayList paramArrayList2)
    {
      super(localArrayList);
    }
    
    public final void e(e parame)
    {
      AppMethodBeat.i(201843);
      k.h(parame, "holder");
      super.e(parame);
      AppMethodBeat.o(201843);
    }
    
    public final void t(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(201845);
      k.h(paramRecyclerView, "recyclerView");
      AppMethodBeat.o(201845);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b<Integer, com.tencent.mm.view.recyclerview.b<?>>
  {
    c(aa paramaa)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.aa
 * JD-Core Version:    0.7.0.1
 */