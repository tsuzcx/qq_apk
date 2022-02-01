package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.p;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d;
import com.tencent.mm.view.recyclerview.d.c;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.y;
import java.util.ArrayList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "VIEW_TYPE_FOOTER", "VIEW_TYPE_HEADER", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getCommentSafeMode", "()Z", "getCommentScene", "()I", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "finderManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getFinderManager", "()Landroid/support/v7/widget/RecyclerView$LayoutManager;", "setFinderManager", "(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "headerview", "Landroid/view/View;", "getHeaderview", "()Landroid/view/View;", "setHeaderview", "(Landroid/view/View;)V", "present", "getPresent", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "setPresent", "(Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getScene", "spanCount", "getSpanCount", "setSpanCount", "(I)V", "getAdapter", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/content/Context;", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getTitleStringId", "initView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "onGridItemClick", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "onViewPrepared", "refreshWhenEnter", "requestLoadMore", "showEmptyView", "showEmptyViewInternal", "emptyView", "plugin-finder_release"})
public abstract class c$b
  implements com.tencent.mm.plugin.finder.presenter.base.c<c.a>
{
  private final String TAG;
  int arE;
  final MMActivity iMV;
  private final int rfR;
  public RefreshLoadMoreLayout rfT;
  public FinderLikeDrawer rfW;
  WxRecyclerAdapter<?> rfX;
  private final boolean rga;
  public c.a rgj;
  final int rgk;
  final int rgl;
  private r rgm;
  public RecyclerView.i rgn;
  public View rgo;
  private final int scene;
  
  public c$b(MMActivity paramMMActivity, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.iMV = paramMMActivity;
    this.scene = paramInt1;
    this.rfR = paramInt2;
    this.rga = paramBoolean;
    this.TAG = "Finder.FinderBaseGridFeedUIContract.ViewCallback";
    this.arE = 3;
    paramMMActivity = this.iMV.findViewById(2131304203);
    k.g(paramMMActivity, "context.findViewById(R.id.rl_layout)");
    this.rfT = ((RefreshLoadMoreLayout)paramMMActivity);
    this.rgl = -1;
    this.rgm = ((r)new p());
    this.rgo = null;
  }
  
  public final void U(final ArrayList<BaseFinderFeed> paramArrayList)
  {
    k.h(paramArrayList, "data");
    RecyclerView localRecyclerView = this.rfT.getRecyclerView();
    this.rgn = eL((Context)this.iMV);
    Object localObject = FinderLikeDrawer.rXU;
    localObject = (Context)this.iMV;
    Window localWindow = this.iMV.getWindow();
    k.g(localWindow, "context.window");
    FinderLikeDrawer.a locala = FinderLikeDrawer.rXU;
    this.rfW = FinderLikeDrawer.a.a((Context)localObject, localWindow, FinderLikeDrawer.cEZ());
    localObject = this.rgn;
    if (localObject == null) {
      k.aVY("finderManager");
    }
    localRecyclerView.setLayoutManager((RecyclerView.i)localObject);
    this.rfX = ((WxRecyclerAdapter)new a(this, paramArrayList, cuC().cut(), paramArrayList));
    paramArrayList = this.rfX;
    if (paramArrayList == null) {
      k.aVY("adapter");
    }
    localRecyclerView.setAdapter((RecyclerView.a)paramArrayList);
    localRecyclerView.b(getItemDecoration());
    paramArrayList = this.rfX;
    if (paramArrayList == null) {
      k.aVY("adapter");
    }
    paramArrayList.JCe = ((d.c)new b(this));
    if (this.rgo != null)
    {
      paramArrayList = this.rfX;
      if (paramArrayList == null) {
        k.aVY("adapter");
      }
      if (paramArrayList != null)
      {
        localObject = this.rgo;
        if (localObject == null) {
          k.fOy();
        }
        d.a(paramArrayList, (View)localObject, this.rgk);
      }
    }
    this.rfT.setActionCallback((RefreshLoadMoreLayout.a)new c(this));
    paramArrayList = com.tencent.mm.ui.component.a.IrY;
    paramArrayList = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.q(this.iMV).get(FinderReporterUIC.class));
    if (paramArrayList != null) {
      paramArrayList.s(localRecyclerView);
    }
    com.tencent.mm.ac.c.a(com.tencent.mm.ac.c.aid(), (d.g.a.b)new d(this));
  }
  
  public abstract void a(RecyclerView.a<?> parama, View paramView, int paramInt);
  
  public final void a(c.a parama)
  {
    k.h(parama, "<set-?>");
    this.rgj = parama;
  }
  
  public final c.a cuC()
  {
    c.a locala = this.rgj;
    if (locala == null) {
      k.aVY("present");
    }
    return locala;
  }
  
  public final c.a cuD()
  {
    c.a locala = this.rgj;
    if (locala == null) {
      k.aVY("present");
    }
    return locala;
  }
  
  public final FinderLikeDrawer cuE()
  {
    FinderLikeDrawer localFinderLikeDrawer = this.rfW;
    if (localFinderLikeDrawer == null) {
      k.aVY("friendLikeDrawer");
    }
    return localFinderLikeDrawer;
  }
  
  public r cuF()
  {
    return this.rgm;
  }
  
  public boolean cuG()
  {
    return true;
  }
  
  public abstract void cuH();
  
  public final void dX(View paramView)
  {
    paramView.setVisibility(0);
    Object localObject = this.rfT;
    if (localObject != null) {
      ((RefreshLoadMoreLayout)localObject).setVisibility(8);
    }
    localObject = (TextView)paramView.findViewById(2131299472);
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = paramView.findViewById(2131303515);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    paramView = paramView.findViewById(2131304150);
    if (paramView != null) {
      paramView.setVisibility(8);
    }
  }
  
  public abstract String e(RefreshLoadMoreLayout.c<Object> paramc);
  
  public abstract RecyclerView.i eL(Context paramContext);
  
  public abstract String f(RefreshLoadMoreLayout.c<Object> paramc);
  
  public final WxRecyclerAdapter<?> getAdapter()
  {
    WxRecyclerAdapter localWxRecyclerAdapter = this.rfX;
    if (localWxRecyclerAdapter == null) {
      k.aVY("adapter");
    }
    return localWxRecyclerAdapter;
  }
  
  public abstract View getEmptyView();
  
  public abstract RecyclerView.h getItemDecoration();
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onBindFirstBodyViewHolder", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onViewAttachedToWindow", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static final class a
    extends WxRecyclerAdapter<BaseFinderFeed>
  {
    a(ArrayList paramArrayList1, com.tencent.mm.view.recyclerview.c paramc, ArrayList paramArrayList2)
    {
      super(localArrayList);
    }
    
    public final void e(e parame)
    {
      AppMethodBeat.i(201526);
      k.h(parame, "holder");
      super.e(parame);
      Object localObject = parame.asD;
      k.g(localObject, "holder.itemView");
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
        if ((parame.ly() != this.rgp.rgk) && (parame.ly() != this.rgp.rgl)) {
          break label89;
        }
      }
      label89:
      for (boolean bool = true;; bool = false)
      {
        ((StaggeredGridLayoutManager.LayoutParams)localObject).aE(bool);
        AppMethodBeat.o(201526);
        return;
      }
    }
    
    public final void t(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(201528);
      k.h(paramRecyclerView, "recyclerView");
      Object localObject = FinderReporterUIC.seQ;
      localObject = FinderReporterUIC.a.eV((Context)this.rgp.iMV);
      if (localObject != null)
      {
        localObject = FinderReporterUIC.d((FinderReporterUIC)localObject);
        if (localObject != null)
        {
          ((f)localObject).ctt().b(paramRecyclerView, 5);
          AppMethodBeat.o(201528);
          return;
        }
      }
      AppMethodBeat.o(201528);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "plugin-finder_release"})
  public static final class b
    implements d.c
  {
    public final void b(RecyclerView.a<?> parama, View paramView, int paramInt)
    {
      AppMethodBeat.i(201529);
      k.h(parama, "adapter");
      k.h(paramView, "view");
      this.rgp.a(parama, paramView, paramInt);
      AppMethodBeat.o(201529);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$3", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"})
  public static final class c
    extends RefreshLoadMoreLayout.a
  {
    private boolean rgb = true;
    
    public final void Ad(int paramInt)
    {
      AppMethodBeat.i(201535);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aeE());
      super.Ad(paramInt);
      if (this.rgp.cuC().rgh.getSize() == 0)
      {
        localObject1 = this.rgp.getEmptyView();
        if (localObject1 != null)
        {
          ((View)localObject1).setVisibility(0);
          Object localObject2 = this.rgp.rfX;
          if (localObject2 == null) {
            k.aVY("adapter");
          }
          if (localObject2 != null)
          {
            localObject2 = ((WxRecyclerAdapter)localObject2).getRecyclerView();
            if (localObject2 != null) {
              ((RecyclerView)localObject2).setVisibility(8);
            }
          }
          localObject1 = ((View)localObject1).findViewById(2131303515);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(0);
          }
        }
      }
      h.JZN.aS((Runnable)new b(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(201535);
    }
    
    public final void DE(int paramInt)
    {
      if ((this.rgb) && (paramInt > 0)) {
        this.rgb = false;
      }
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201537);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      k.h(paramc, "reason");
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(201537);
    }
    
    public final void b(final RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201534);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aeE());
      k.h(paramc, "reason");
      super.b(paramc);
      View localView = this.rgp.getEmptyView();
      Object localObject2;
      int i;
      if (localView != null)
      {
        localObject2 = this.rgp.rfT.getRecyclerView().getAdapter();
        localObject1 = localObject2;
        if (!(localObject2 instanceof WxRecyclerAdapter)) {
          localObject1 = null;
        }
        localObject1 = (WxRecyclerAdapter)localObject1;
        if (paramc.JxZ == -1) {
          break label257;
        }
        if (localObject1 == null) {
          break label140;
        }
        i = ((d)localObject1).fzq();
        if (i > 0) {
          break label145;
        }
        this.rgp.dX(localView);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(201534);
        return;
        label140:
        i = 0;
        break;
        label145:
        localView.setVisibility(8);
        localObject2 = this.rgp.rgo;
        if (localObject2 != null)
        {
          localView = ((View)localObject2).findViewById(2131305902);
          k.g(localView, "findViewById<TextView>(R.id.title)");
          ((TextView)localView).setText((CharSequence)this.rgp.e(paramc));
          localObject2 = ((View)localObject2).findViewById(2131298996);
          k.g(localObject2, "findViewById<TextView>(R.id.desc)");
          ((TextView)localObject2).setText((CharSequence)this.rgp.f(paramc));
        }
        if (localObject1 != null)
        {
          paramc = ((WxRecyclerAdapter)localObject1).getRecyclerView();
          if (paramc != null)
          {
            paramc.setVisibility(0);
            continue;
            label257:
            localView.setVisibility(0);
            localObject1 = this.rgp.rfT;
            if (localObject1 != null) {
              ((RefreshLoadMoreLayout)localObject1).setVisibility(8);
            }
            localObject1 = (TextView)localView.findViewById(2131299472);
            if (localObject1 != null) {
              ((TextView)localObject1).setVisibility(8);
            }
            localObject1 = (TextView)localView.findViewById(2131304150);
            if (localObject1 != null) {
              ((TextView)localObject1).setVisibility(0);
            }
            localObject1 = localView.findViewById(2131303515);
            if (localObject1 != null) {
              ((View)localObject1).setVisibility(8);
            }
            localObject1 = localView.findViewById(2131304150);
            if (localObject1 != null) {
              ((View)localObject1).setOnClickListener((View.OnClickListener)new c(localView, this, paramc));
            }
          }
        }
      }
    }
    
    public final void bTG()
    {
      AppMethodBeat.i(201536);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bTG();
      h.JZN.aS((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(201536);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(c.b.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(201530);
        this.rgr.rgp.cuD().aQh();
        AppMethodBeat.o(201530);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(c.b.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(201531);
        this.rgr.rgp.cuD().requestRefresh();
        AppMethodBeat.o(201531);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$3$onRefreshEnd$1$2"})
    static final class c
      implements View.OnClickListener
    {
      c(View paramView, c.b.c paramc, RefreshLoadMoreLayout.c paramc1) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(201533);
        k.g(paramView, "it");
        paramView.setVisibility(8);
        paramView = this.rgs.findViewById(2131303515);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        h.JZN.aS((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(201532);
            this.rgu.rgr.rgp.cuD().requestRefresh();
            AppMethodBeat.o(201532);
          }
        });
        AppMethodBeat.o(201533);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<Void, y>
  {
    d(c.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.c.b
 * JD-Core Version:    0.7.0.1
 */