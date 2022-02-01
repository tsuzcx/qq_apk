package com.tencent.mm.plugin.finder.megavideo.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.g.c;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "rootView", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;)V", "VIEW_TYPE_FOOTER", "", "VIEW_TYPE_HEADER", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "finderManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getFinderManager", "()Landroid/support/v7/widget/RecyclerView$LayoutManager;", "setFinderManager", "(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V", "headerview", "getHeaderview", "()Landroid/view/View;", "setHeaderview", "(Landroid/view/View;)V", "present", "getPresent", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "setPresent", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getRootView", "getAdapter", "getEmptyView", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/content/Context;", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "initView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "onItemClick", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "onItemDelete", "onViewPrepared", "refreshWhenEnter", "", "showEmptyView", "showEmptyViewInternal", "emptyView", "plugin-finder_release"})
public abstract class a$b
  implements c<a.a>
{
  final MMActivity gte;
  final View lJI;
  private WxRecyclerAdapter<?> tFp;
  public RefreshLoadMoreLayout tLS;
  private final int tMh;
  private final int tMi;
  public RecyclerView.LayoutManager tMk;
  private View tMl;
  public a.a uLH;
  
  public a$b(MMActivity paramMMActivity, View paramView)
  {
    this.gte = paramMMActivity;
    this.lJI = paramView;
    paramMMActivity = this.lJI.findViewById(2131307118);
    p.g(paramMMActivity, "rootView.findViewById(R.id.rl_layout)");
    this.tLS = ((RefreshLoadMoreLayout)paramMMActivity);
    this.tMi = -1;
  }
  
  public final void a(a.a parama)
  {
    p.h(parama, "<set-?>");
    this.uLH = parama;
  }
  
  public final void ab(final ArrayList<bo> paramArrayList)
  {
    p.h(paramArrayList, "data");
    Object localObject1 = this.tLS.getRecyclerView();
    Object localObject2 = (Context)this.gte;
    p.h(localObject2, "context");
    this.tMk = ((RecyclerView.LayoutManager)new FinderLinearLayoutManager((Context)localObject2));
    localObject2 = this.tMk;
    if (localObject2 == null) {
      p.btv("finderManager");
    }
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)localObject2);
    this.tFp = ((WxRecyclerAdapter)new a(this, paramArrayList, dkn().dce(), paramArrayList));
    paramArrayList = this.tFp;
    if (paramArrayList == null) {
      p.btv("adapter");
    }
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)paramArrayList);
    paramArrayList = (Drawable)new ColorDrawable(c.a.a(this).getColor(2131099750));
    int i = (int)c.a.a(this).getDimension(2131166339);
    localObject2 = new int[4];
    localObject2[0] = c.a.a(this).getDimensionPixelOffset(2131165314);
    ((RecyclerView)localObject1).b((RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b(paramArrayList, i, (int[])localObject2));
    paramArrayList = this.tFp;
    if (paramArrayList == null) {
      p.btv("adapter");
    }
    paramArrayList.RqP = ((g.c)new b(this));
    this.tMl = null;
    if (this.tMl != null)
    {
      paramArrayList = this.tFp;
      if (paramArrayList == null) {
        p.btv("adapter");
      }
      if (paramArrayList != null)
      {
        localObject1 = this.tMl;
        if (localObject1 == null) {
          p.hyc();
        }
        g.a(paramArrayList, (View)localObject1, this.tMh);
      }
    }
    this.tLS.setActionCallback((RefreshLoadMoreLayout.a)new c(this));
    dbY();
  }
  
  public abstract void b(RecyclerView.a<?> parama, View paramView, int paramInt);
  
  public void bIo()
  {
    View localView = getEmptyView();
    if (localView != null)
    {
      localView.setVisibility(0);
      Object localObject = this.tLS;
      if (localObject != null) {
        ((RefreshLoadMoreLayout)localObject).setVisibility(8);
      }
      localObject = (TextView)localView.findViewById(2131300101);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = localView.findViewById(2131306281);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localView = localView.findViewById(2131307047);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
  }
  
  public void dbY()
  {
    d.a(d.aBx(), (kotlin.g.a.b)new d(this));
  }
  
  public abstract void dcv();
  
  public final a.a dkm()
  {
    a.a locala = this.uLH;
    if (locala == null) {
      p.btv("present");
    }
    return locala;
  }
  
  public final a.a dkn()
  {
    a.a locala = this.uLH;
    if (locala == null) {
      p.btv("present");
    }
    return locala;
  }
  
  public final WxRecyclerAdapter<?> getAdapter()
  {
    WxRecyclerAdapter localWxRecyclerAdapter = this.tFp;
    if (localWxRecyclerAdapter == null) {
      p.btv("adapter");
    }
    return localWxRecyclerAdapter;
  }
  
  public abstract View getEmptyView();
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onBindFirstBodyViewHolder", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "payloads", "", "", "plugin-finder_release"})
  public static final class a
    extends WxRecyclerAdapter<bo>
  {
    a(ArrayList paramArrayList1, f paramf, ArrayList paramArrayList2)
    {
      super(localArrayList);
    }
    
    public final void n(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(248470);
      p.h(paramRecyclerView, "recyclerView");
      AppMethodBeat.o(248470);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class b
    implements g.c<com.tencent.mm.view.recyclerview.h>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"})
  public static final class c
    extends RefreshLoadMoreLayout.a
  {
    private boolean tMa = true;
    
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(248478);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt);
      a.b("com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      super.ED(paramInt);
      if (this.uLI.dkn().uLF.getSize() == 0)
      {
        localObject = this.uLI.getEmptyView();
        if (localObject != null)
        {
          ((View)localObject).setVisibility(0);
          RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.uLI.tLS;
          if (localRefreshLoadMoreLayout != null) {
            localRefreshLoadMoreLayout.setVisibility(8);
          }
          localObject = ((View)localObject).findViewById(2131306281);
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
        }
      }
      com.tencent.f.h.RTc.aX((Runnable)new b(this));
      a.a(this, "com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(248478);
    }
    
    public final void IF(int paramInt)
    {
      if ((this.tMa) && (paramInt > 0)) {
        this.tMa = false;
      }
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(248480);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      a.b("com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      super.a(paramc);
      a.a(this, "com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(248480);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(248479);
      a.b("com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cxo();
      com.tencent.f.h.RTc.aX((Runnable)new a(this));
      a.a(this, "com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(248479);
    }
    
    public final void onRefreshEnd(final RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(248477);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramc);
      a.b("com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramc, "reason");
      super.onRefreshEnd(paramc);
      View localView = this.uLI.getEmptyView();
      int i;
      if (localView != null)
      {
        RecyclerView.a locala = this.uLI.tLS.getRecyclerView().getAdapter();
        localObject = locala;
        if (!(locala instanceof WxRecyclerAdapter)) {
          localObject = null;
        }
        localObject = (WxRecyclerAdapter)localObject;
        if (paramc.Rmh == -1) {
          break label170;
        }
        if (localObject == null) {
          break label138;
        }
        i = ((g)localObject).hgt();
        if (i > 0) {
          break label143;
        }
        this.uLI.bIo();
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(248477);
        return;
        label138:
        i = 0;
        break;
        label143:
        localView.setVisibility(8);
        paramc = this.uLI.tLS;
        if (paramc != null)
        {
          paramc.setVisibility(0);
          continue;
          label170:
          localView.setVisibility(0);
          localObject = this.uLI.tLS;
          if (localObject != null) {
            ((RefreshLoadMoreLayout)localObject).setVisibility(8);
          }
          localObject = (TextView)localView.findViewById(2131300101);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(8);
          }
          localObject = (TextView)localView.findViewById(2131307047);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
          localObject = localView.findViewById(2131306281);
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
          localObject = localView.findViewById(2131307047);
          if (localObject != null) {
            ((View)localObject).setOnClickListener((View.OnClickListener)new c(localView, this, paramc));
          }
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(a.b.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(248473);
        this.uLJ.uLI.dkm().boE();
        AppMethodBeat.o(248473);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(a.b.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(248474);
        this.uLJ.uLI.dkm().requestRefresh();
        AppMethodBeat.o(248474);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4$onRefreshEnd$1$1"})
    static final class c
      implements View.OnClickListener
    {
      c(View paramView, a.b.c paramc, RefreshLoadMoreLayout.c paramc1) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(248476);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        a.b("com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4$onRefreshEnd$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        p.g(paramView, "it");
        paramView.setVisibility(8);
        paramView = this.tCl.findViewById(2131306281);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        com.tencent.f.h.RTc.aX((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(248475);
            this.uLK.uLJ.uLI.dkm().requestRefresh();
            AppMethodBeat.o(248475);
          }
        });
        a.a(this, "com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4$onRefreshEnd$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(248476);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke"})
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