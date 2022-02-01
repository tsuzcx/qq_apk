package com.tencent.mm.plugin.finder.megavideo.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h.c;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "rootView", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;)V", "VIEW_TYPE_FOOTER", "", "VIEW_TYPE_HEADER", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "finderManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getFinderManager", "()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "setFinderManager", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", "headerview", "getHeaderview", "()Landroid/view/View;", "setHeaderview", "(Landroid/view/View;)V", "present", "getPresent", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "setPresent", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getRootView", "getAdapter", "getEmptyView", "getHeaderView", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/content/Context;", "getPresenter", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "initView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "onItemClick", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "onItemDelete", "onViewPrepared", "refreshWhenEnter", "", "showEmptyView", "showEmptyViewInternal", "emptyView", "plugin-finder_release"})
public abstract class a$b
  implements c<a.a>
{
  private final MMActivity iXq;
  private final View oFW;
  private WxRecyclerAdapter<?> xnR;
  public RefreshLoadMoreLayout xvJ;
  private final int xvY;
  private final int xvZ;
  public RecyclerView.LayoutManager xwb;
  private View xwc;
  public a.a zxi;
  
  public a$b(MMActivity paramMMActivity, View paramView)
  {
    this.iXq = paramMMActivity;
    this.oFW = paramView;
    paramMMActivity = this.oFW.findViewById(b.f.rl_layout);
    p.j(paramMMActivity, "rootView.findViewById(R.id.rl_layout)");
    this.xvJ = ((RefreshLoadMoreLayout)paramMMActivity);
    this.xvZ = -1;
  }
  
  public final void a(a.a parama)
  {
    p.k(parama, "<set-?>");
    this.zxi = parama;
  }
  
  public final void ab(final ArrayList<bu> paramArrayList)
  {
    p.k(paramArrayList, "data");
    Object localObject1 = this.xvJ.getRecyclerView();
    Object localObject2 = (Context)this.iXq;
    p.k(localObject2, "context");
    this.xwb = ((RecyclerView.LayoutManager)new FinderLinearLayoutManager((Context)localObject2));
    localObject2 = this.xwb;
    if (localObject2 == null) {
      p.bGy("finderManager");
    }
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)localObject2);
    this.xnR = ((WxRecyclerAdapter)new a(this, paramArrayList, dJS().dsu(), paramArrayList));
    paramArrayList = this.xnR;
    if (paramArrayList == null) {
      p.bGy("adapter");
    }
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)paramArrayList);
    paramArrayList = (Drawable)new ColorDrawable(c.a.a(this).getColor(b.c.FG_3));
    int i = (int)c.a.a(this).getDimension(b.d.feed_detail_divider);
    localObject2 = new int[4];
    localObject2[0] = c.a.a(this).getDimensionPixelOffset(b.d.Edge_A);
    ((RecyclerView)localObject1).b((RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b(paramArrayList, i, (int[])localObject2));
    paramArrayList = this.xnR;
    if (paramArrayList == null) {
      p.bGy("adapter");
    }
    paramArrayList.YSn = ((h.c)new b(this));
    this.xwc = null;
    if (this.xwc != null)
    {
      paramArrayList = this.xnR;
      if (paramArrayList == null) {
        p.bGy("adapter");
      }
      if (paramArrayList != null)
      {
        localObject1 = this.xwc;
        if (localObject1 == null) {
          p.iCn();
        }
        com.tencent.mm.view.recyclerview.h.a(paramArrayList, (View)localObject1, this.xvY);
      }
    }
    this.xvJ.setActionCallback((RefreshLoadMoreLayout.a)new c(this));
    dsm();
  }
  
  public abstract void b(RecyclerView.a<?> parama, View paramView, int paramInt);
  
  public void bTY()
  {
    View localView = getEmptyView();
    if (localView != null)
    {
      localView.setVisibility(0);
      Object localObject = this.xvJ;
      if (localObject != null) {
        ((RefreshLoadMoreLayout)localObject).setVisibility(8);
      }
      localObject = (TextView)localView.findViewById(b.f.empty_tip);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = localView.findViewById(b.f.progress);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localView = localView.findViewById(b.f.retry_tip);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
  }
  
  public final a.a dJR()
  {
    a.a locala = this.zxi;
    if (locala == null) {
      p.bGy("present");
    }
    return locala;
  }
  
  public final a.a dJS()
  {
    a.a locala = this.zxi;
    if (locala == null) {
      p.bGy("present");
    }
    return locala;
  }
  
  public final MMActivity dlC()
  {
    return this.iXq;
  }
  
  public abstract void dsL();
  
  public void dsm()
  {
    d.a(d.aJa(), (kotlin.g.a.b)new d(this));
  }
  
  public final WxRecyclerAdapter<?> getAdapter()
  {
    WxRecyclerAdapter localWxRecyclerAdapter = this.xnR;
    if (localWxRecyclerAdapter == null) {
      p.bGy("adapter");
    }
    return localWxRecyclerAdapter;
  }
  
  public abstract View getEmptyView();
  
  public final View getRootView()
  {
    return this.oFW;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onBindFirstBodyViewHolder", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "payloads", "", "", "plugin-finder_release"})
  public static final class a
    extends WxRecyclerAdapter<bu>
  {
    a(ArrayList paramArrayList1, f paramf, ArrayList paramArrayList2)
    {
      super(localArrayList);
    }
    
    public final void l(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(292291);
      p.k(paramRecyclerView, "recyclerView");
      AppMethodBeat.o(292291);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class b
    implements h.c<com.tencent.mm.view.recyclerview.i>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"})
  public static final class c
    extends RefreshLoadMoreLayout.a
  {
    private boolean xvR = true;
    
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(279037);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt);
      a.c("com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      super.Ie(paramInt);
      if (this.zxj.dJS().zxg.getSize() == 0)
      {
        localObject = this.zxj.getEmptyView();
        if (localObject != null)
        {
          ((View)localObject).setVisibility(0);
          RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.zxj.xvJ;
          if (localRefreshLoadMoreLayout != null) {
            localRefreshLoadMoreLayout.setVisibility(8);
          }
          localObject = ((View)localObject).findViewById(b.f.progress);
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
        }
      }
      com.tencent.e.h.ZvG.be((Runnable)new b(this));
      a.a(this, "com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(279037);
    }
    
    public final void Mw(int paramInt)
    {
      if ((this.xvR) && (paramInt > 0)) {
        this.xvR = false;
      }
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(279039);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      a.c("com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      p.k(paramc, "reason");
      super.a(paramc);
      a.a(this, "com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(279039);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(279038);
      a.b("com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cKQ();
      com.tencent.e.h.ZvG.be((Runnable)new a(this));
      a.a(this, "com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(279038);
    }
    
    public final void onRefreshEnd(final RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(279036);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramc);
      a.c("com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramc, "reason");
      super.onRefreshEnd(paramc);
      View localView = this.zxj.getEmptyView();
      int i;
      if (localView != null)
      {
        RecyclerView.a locala = this.zxj.xvJ.getRecyclerView().getAdapter();
        localObject = locala;
        if (!(locala instanceof WxRecyclerAdapter)) {
          localObject = null;
        }
        localObject = (WxRecyclerAdapter)localObject;
        if (paramc.YND == -1) {
          break label170;
        }
        if (localObject == null) {
          break label138;
        }
        i = ((com.tencent.mm.view.recyclerview.h)localObject).ihV();
        if (i > 0) {
          break label143;
        }
        this.zxj.bTY();
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(279036);
        return;
        label138:
        i = 0;
        break;
        label143:
        localView.setVisibility(8);
        paramc = this.zxj.xvJ;
        if (paramc != null)
        {
          paramc.setVisibility(0);
          continue;
          label170:
          localView.setVisibility(0);
          localObject = this.zxj.xvJ;
          if (localObject != null) {
            ((RefreshLoadMoreLayout)localObject).setVisibility(8);
          }
          localObject = (TextView)localView.findViewById(b.f.empty_tip);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(8);
          }
          localObject = (TextView)localView.findViewById(b.f.retry_tip);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
          localObject = localView.findViewById(b.f.progress);
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
          localObject = localView.findViewById(b.f.retry_tip);
          if (localObject != null) {
            ((View)localObject).setOnClickListener((View.OnClickListener)new c(localView, this, paramc));
          }
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(a.b.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(286101);
        this.zxk.zxj.dJR().byN();
        AppMethodBeat.o(286101);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(a.b.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(277443);
        this.zxk.zxj.dJR().requestRefresh();
        AppMethodBeat.o(277443);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4$onRefreshEnd$1$1"})
    static final class c
      implements View.OnClickListener
    {
      c(View paramView, a.b.c paramc, RefreshLoadMoreLayout.c paramc1) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(285011);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        a.c("com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4$onRefreshEnd$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        p.j(paramView, "it");
        paramView.setVisibility(8);
        paramView = this.xkv.findViewById(b.f.progress);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        com.tencent.e.h.ZvG.be((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(274958);
            this.zxl.zxk.zxj.dJR().requestRefresh();
            AppMethodBeat.o(274958);
          }
        });
        a.a(this, "com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4$onRefreshEnd$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(285011);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<Void, x>
  {
    d(a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.a.b
 * JD-Core Version:    0.7.0.1
 */