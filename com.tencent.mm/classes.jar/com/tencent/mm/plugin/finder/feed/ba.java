package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.plugin.finder.storage.p;
import com.tencent.mm.plugin.finder.storage.p.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;Landroid/view/View;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/FinderLbsConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/FinderLbsConfig;)V", "getActivity", "getPresenter", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "initView", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ba
  implements ay.b<c>
{
  final ay.a<c> ALh;
  final MMActivity AZo;
  private p AZp;
  private final View nma;
  
  public ba(MMActivity paramMMActivity, ay.a<c> parama, View paramView)
  {
    AppMethodBeat.i(362907);
    this.AZo = paramMMActivity;
    this.ALh = parama;
    this.nma = paramView;
    this.AZp = new p(this.AZo);
    AppMethodBeat.o(362907);
  }
  
  public final RefreshLoadMoreLayout aNL()
  {
    AppMethodBeat.i(362931);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.nma.findViewById(e.e.rl_layout);
    AppMethodBeat.o(362931);
    return localRefreshLoadMoreLayout;
  }
  
  public final void ae(ArrayList<c> paramArrayList)
  {
    AppMethodBeat.i(362916);
    kotlin.g.b.s.u(paramArrayList, "data");
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.nma.findViewById(e.e.rl_layout);
    Object localObject1 = MMApplicationContext.getContext().getResources();
    localRefreshLoadMoreLayout.setLimitTopRequest((int)((Resources)localObject1).getDimension(e.c.finder_timeline_refresh_height) - (int)((Resources)localObject1).getDimension(e.c.Edge_12A));
    localRefreshLoadMoreLayout.setRefreshTargetY((int)((Resources)localObject1).getDimension(e.c.Edge_7A) - (int)((Resources)localObject1).getDimension(e.c.finder_timeline_refresh_height));
    localRefreshLoadMoreLayout.setDamping(1.85F);
    localObject1 = localRefreshLoadMoreLayout.getRecyclerView();
    Object localObject2 = this.nma.getContext();
    kotlin.g.b.s.s(localObject2, "parent.context");
    kotlin.g.b.s.u(localObject2, "context");
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new FinderLinearLayoutManager((Context)localObject2));
    localObject2 = this.nma.getContext();
    kotlin.g.b.s.s(localObject2, "parent.context");
    kotlin.g.b.s.u(localObject2, "context");
    ((RecyclerView)localObject1).a((RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(((Context)localObject2).getResources().getColor(e.b.BW_93)), (int)((Context)localObject2).getResources().getDimension(e.c.feed_divider)));
    localObject2 = this.AZp;
    kotlin.g.a.b localb = (kotlin.g.a.b)new c(this);
    ay.a locala = this.ALh;
    kotlin.g.b.s.u(locala, "presenter");
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)new b(paramArrayList, (g)new p.a(locala, localb, (p)localObject2)));
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    localRefreshLoadMoreLayout.setActionCallback((RefreshLoadMoreLayout.b)new a(this));
    AppMethodBeat.o(362916);
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(362921);
    RecyclerView localRecyclerView = ((RefreshLoadMoreLayout)this.nma.findViewById(e.e.rl_layout)).getRecyclerView();
    AppMethodBeat.o(362921);
    return localRecyclerView;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RefreshLoadMoreLayout.b
  {
    a(ba paramba) {}
    
    public final void IH(int paramInt)
    {
      AppMethodBeat.i(362516);
      super.IH(paramInt);
      this.AZq.ALh.onRefresh();
      AppMethodBeat.o(362516);
    }
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(362543);
      kotlin.g.b.s.u(paramd, "reason");
      super.a(paramd);
      com.tencent.mm.plugin.finder.report.s.a(com.tencent.mm.plugin.finder.report.s.Fqv, 2, false, null, 12);
      AppMethodBeat.o(362543);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(362526);
      kotlin.g.b.s.u(paramd, "reason");
      super.onRefreshEnd(paramd);
      this.AZq.ALh.onRefreshEnd(paramd);
      paramd = com.tencent.mm.plugin.finder.report.s.Fqv;
      k localk = k.aeZF;
      com.tencent.mm.plugin.finder.report.s.a(paramd, 2, false, ((as)k.d((AppCompatActivity)this.AZq.AZo).q(as.class)).fou(), 8);
      AppMethodBeat.o(362526);
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(362534);
      super.qI(paramInt);
      this.AZq.ALh.onLoadMore();
      AppMethodBeat.o(362534);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixViewCallback$initView$adapter$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "onBindFirstBodyViewHolder", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onViewAttachedToWindow", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends WxRecyclerAdapter<c>
  {
    b(ArrayList<c> paramArrayList, g paramg)
    {
      super(paramArrayList);
    }
    
    public final void p(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(362532);
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      AppMethodBeat.o(362532);
    }
    
    public final void v(j paramj)
    {
      AppMethodBeat.i(362524);
      kotlin.g.b.s.u(paramj, "holder");
      super.v(paramj);
      AppMethodBeat.o(362524);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Integer, f<?>>
  {
    c(ba paramba)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ba
 * JD-Core Version:    0.7.0.1
 */