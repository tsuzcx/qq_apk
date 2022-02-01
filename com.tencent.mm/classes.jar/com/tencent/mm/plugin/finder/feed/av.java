package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;Landroid/view/View;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "filterLiveItemClick", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "feed", "position", "", "getActivity", "getPresenter", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "initView", "", "plugin-finder_release"})
public final class av
  implements ar.b<bu>
{
  final String TAG;
  private final View kJC;
  final MMActivity xCd;
  final ar.a<bu> xnm;
  private ak xwa;
  
  public av(MMActivity paramMMActivity, ar.a<bu> parama, View paramView)
  {
    AppMethodBeat.i(268483);
    this.xCd = paramMMActivity;
    this.xnm = parama;
    this.kJC = paramView;
    this.TAG = "FinderTimelineLbsContract";
    this.xwa = ((ak)new com.tencent.mm.plugin.finder.storage.q(this.xCd));
    AppMethodBeat.o(268483);
  }
  
  public final void ab(final ArrayList<bu> paramArrayList)
  {
    AppMethodBeat.i(268478);
    p.k(paramArrayList, "data");
    final RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.kJC.findViewById(b.f.rl_layout);
    Object localObject1 = MMApplicationContext.getContext();
    p.j(localObject1, "MMApplicationContext.getContext()");
    localObject1 = ((Context)localObject1).getResources();
    localRefreshLoadMoreLayout.setLimitTopRequest((int)((Resources)localObject1).getDimension(b.d.finder_timeline_refresh_height) - (int)((Resources)localObject1).getDimension(b.d.Edge_12A));
    localRefreshLoadMoreLayout.setRefreshTargetY((int)((Resources)localObject1).getDimension(b.d.Edge_7A) - (int)((Resources)localObject1).getDimension(b.d.finder_timeline_refresh_height));
    localRefreshLoadMoreLayout.setDamping(1.85F);
    localObject1 = localRefreshLoadMoreLayout.getRecyclerView();
    Object localObject2 = this.xwa;
    Context localContext = this.kJC.getContext();
    p.j(localContext, "parent.context");
    ((RecyclerView)localObject1).setLayoutManager(((ak)localObject2).eW(localContext));
    ((RecyclerView)localObject1).b(this.xwa.getItemDecoration());
    ((RecyclerView)localObject1).setRecycledViewPool(this.xwa.g(this.xCd));
    localObject2 = ((RecyclerView)localObject1).getItemAnimator();
    if (localObject2 != null) {
      ((RecyclerView.f)localObject2).n(0L);
    }
    localObject2 = new c(this, paramArrayList, this.xwa.O((kotlin.g.a.b)new d(this)), paramArrayList);
    ((h)localObject2).YSn = ((h.c)new a(this, paramArrayList, localRefreshLoadMoreLayout));
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(4);
    if (localObject1 == null)
    {
      paramArrayList = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerView");
      AppMethodBeat.o(268478);
      throw paramArrayList;
    }
    paramArrayList = (WxRecyclerView)localObject1;
    localObject2 = d.AjH;
    paramArrayList.setFlingSpeedFactor(((Number)d.dUr().aSr()).intValue());
    localRefreshLoadMoreLayout.setActionCallback((RefreshLoadMoreLayout.a)new b(this));
    paramArrayList = g.Xox;
    paramArrayList = aj.d((aj)g.b((AppCompatActivity)this.xCd).i(aj.class));
    if (paramArrayList != null)
    {
      paramArrayList.k((RecyclerView)localObject1);
      AppMethodBeat.o(268478);
      return;
    }
    AppMethodBeat.o(268478);
  }
  
  public final RefreshLoadMoreLayout dtq()
  {
    AppMethodBeat.i(268480);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.kJC.findViewById(b.f.rl_layout);
    p.j(localRefreshLoadMoreLayout, "parent.rl_layout");
    AppMethodBeat.o(268480);
    return localRefreshLoadMoreLayout;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(268479);
    RecyclerView localRecyclerView = ((RefreshLoadMoreLayout)this.kJC.findViewById(b.f.rl_layout)).getRecyclerView();
    AppMethodBeat.o(268479);
    return localRecyclerView;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class a
    implements h.c<i>
  {
    a(ArrayList paramArrayList, RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.b<bu, Boolean>
    {
      public static final a xCu;
      
      static
      {
        AppMethodBeat.i(281849);
        xCu = new a();
        AppMethodBeat.o(281849);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class b
    extends RefreshLoadMoreLayout.a
  {
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(229050);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      super.Ie(paramInt);
      this.xCt.xnm.onRefresh();
      localObject = RefreshLoadMoreLayout.c.YNO;
      if (paramInt == RefreshLoadMoreLayout.c.ihw())
      {
        localObject = d.AjH;
        if (((Number)d.dTQ().aSr()).intValue() == 1)
        {
          localObject = aj.Bnu;
          localObject = aj.a.fZ((Context)this.xCt.xCd);
          if (localObject != null)
          {
            n localn = n.zWF;
            n.b(((aj)localObject).ekY(), 3);
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(229050);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(229058);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      p.k(paramc, "reason");
      super.a(paramc);
      j.a(j.zVy, 2, false, null, 12);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(229058);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(229053);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cKQ();
      this.xCt.xnm.onLoadMore();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(229053);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(229052);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramc, "reason");
      super.onRefreshEnd(paramc);
      this.xCt.xnm.onRefreshEnd(paramc);
      paramc = j.zVy;
      localObject = g.Xox;
      j.a(paramc, 2, false, ((aj)g.b((AppCompatActivity)this.xCt.xCd).i(aj.class)).ekY(), 8);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(229052);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$adapter$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onViewAttachedToWindow", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static final class c
    extends WxRecyclerAdapter<bu>
  {
    c(ArrayList paramArrayList1, com.tencent.mm.view.recyclerview.f paramf, ArrayList paramArrayList2)
    {
      super(localArrayList);
    }
    
    public final void p(i parami)
    {
      AppMethodBeat.i(280270);
      p.k(parami, "holder");
      super.p(parami);
      Object localObject = parami.amk;
      p.j(localObject, "holder.itemView");
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
        if ((parami.mg() != -1) && (parami.mg() != 2003)) {
          break label79;
        }
      }
      label79:
      for (boolean bool = true;; bool = false)
      {
        ((StaggeredGridLayoutManager.LayoutParams)localObject).aA(bool);
        AppMethodBeat.o(280270);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, e<?>>
  {
    d(av paramav)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.av
 * JD-Core Version:    0.7.0.1
 */