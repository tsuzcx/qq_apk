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
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.storage.x;
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
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "VIEW_TYPE_FOOTER", "VIEW_TYPE_HEADER", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getCommentSafeMode", "()Z", "getCommentScene", "()I", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "finderManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getFinderManager", "()Landroid/support/v7/widget/RecyclerView$LayoutManager;", "setFinderManager", "(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "headerview", "Landroid/view/View;", "getHeaderview", "()Landroid/view/View;", "setHeaderview", "(Landroid/view/View;)V", "present", "getPresent", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "setPresent", "(Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getScene", "spanCount", "getSpanCount", "setSpanCount", "(I)V", "getAdapter", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/content/Context;", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getTitleStringId", "initView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "onGridItemClick", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "onItemDelete", "onViewPrepared", "otherFullSpan", "refreshWhenEnter", "requestLoadMore", "showEmptyView", "showEmptyViewInternal", "emptyView", "plugin-finder_release"})
public abstract class b$b
  implements com.tencent.mm.plugin.finder.presenter.base.c<b.a>
{
  private final String TAG;
  int atv;
  final MMActivity fLP;
  private WxRecyclerAdapter<?> rPu;
  private final int rTD;
  public RefreshLoadMoreLayout rTF;
  public FinderLikeDrawer rTI;
  private final boolean rTL;
  public b.a rTU;
  final int rTV;
  final int rTW;
  private com.tencent.mm.plugin.finder.storage.z rTX;
  public RecyclerView.i rTY;
  public View rTZ;
  private final int scene;
  
  public b$b(MMActivity paramMMActivity, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.fLP = paramMMActivity;
    this.scene = paramInt1;
    this.rTD = paramInt2;
    this.rTL = paramBoolean;
    this.TAG = "Finder.FinderBaseGridFeedUIContract.ViewCallback";
    this.atv = 3;
    paramMMActivity = this.fLP.findViewById(2131304203);
    p.g(paramMMActivity, "context.findViewById(R.id.rl_layout)");
    this.rTF = ((RefreshLoadMoreLayout)paramMMActivity);
    this.rTW = -1;
    this.rTX = ((com.tencent.mm.plugin.finder.storage.z)new x());
  }
  
  public final void U(final ArrayList<al> paramArrayList)
  {
    p.h(paramArrayList, "data");
    RecyclerView localRecyclerView = this.rTF.getRecyclerView();
    this.rTY = eL((Context)this.fLP);
    Object localObject = FinderLikeDrawer.sUO;
    localObject = (Context)this.fLP;
    Window localWindow = this.fLP.getWindow();
    p.g(localWindow, "context.window");
    FinderLikeDrawer.a locala = FinderLikeDrawer.sUO;
    this.rTI = FinderLikeDrawer.a.a((Context)localObject, localWindow, FinderLikeDrawer.cNt());
    localObject = this.rTY;
    if (localObject == null) {
      p.bcb("finderManager");
    }
    localRecyclerView.setLayoutManager((RecyclerView.i)localObject);
    this.rPu = ((WxRecyclerAdapter)new a(this, paramArrayList, cAP().cAE(), paramArrayList));
    paramArrayList = this.rPu;
    if (paramArrayList == null) {
      p.bcb("adapter");
    }
    localRecyclerView.setAdapter((RecyclerView.a)paramArrayList);
    localRecyclerView.b(getItemDecoration());
    paramArrayList = this.rPu;
    if (paramArrayList == null) {
      p.bcb("adapter");
    }
    paramArrayList.Lvl = ((d.c)new b(this));
    this.rTZ = getHeaderView();
    if (this.rTZ != null)
    {
      paramArrayList = this.rPu;
      if (paramArrayList == null) {
        p.bcb("adapter");
      }
      if (paramArrayList != null)
      {
        localObject = this.rTZ;
        if (localObject == null) {
          p.gfZ();
        }
        d.a(paramArrayList, (View)localObject, this.rTV);
      }
    }
    this.rTF.setActionCallback((RefreshLoadMoreLayout.a)new c(this));
    paramArrayList = com.tencent.mm.ui.component.a.KiD;
    paramArrayList = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.fLP).get(FinderReporterUIC.class));
    if (paramArrayList != null) {
      paramArrayList.s(localRecyclerView);
    }
    com.tencent.mm.ad.c.a(com.tencent.mm.ad.c.akP(), (d.g.a.b)new d(this));
  }
  
  public abstract void a(RecyclerView.a<?> parama, View paramView, int paramInt);
  
  public final void a(b.a parama)
  {
    p.h(parama, "<set-?>");
    this.rTU = parama;
  }
  
  public void bmg()
  {
    View localView = getEmptyView();
    if (localView != null)
    {
      localView.setVisibility(0);
      Object localObject = this.rTF;
      if (localObject != null) {
        ((RefreshLoadMoreLayout)localObject).setVisibility(8);
      }
      localObject = (TextView)localView.findViewById(2131299472);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = localView.findViewById(2131303515);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localView = localView.findViewById(2131304150);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
  }
  
  public final FinderLikeDrawer cAJ()
  {
    FinderLikeDrawer localFinderLikeDrawer = this.rTI;
    if (localFinderLikeDrawer == null) {
      p.bcb("friendLikeDrawer");
    }
    return localFinderLikeDrawer;
  }
  
  public final b.a cAP()
  {
    b.a locala = this.rTU;
    if (locala == null) {
      p.bcb("present");
    }
    return locala;
  }
  
  public final b.a cAQ()
  {
    b.a locala = this.rTU;
    if (locala == null) {
      p.bcb("present");
    }
    return locala;
  }
  
  public com.tencent.mm.plugin.finder.storage.z cAR()
  {
    return this.rTX;
  }
  
  public boolean cAS()
  {
    return true;
  }
  
  public abstract void cAT();
  
  public boolean d(e parame)
  {
    p.h(parame, "holder");
    return false;
  }
  
  public abstract String e(RefreshLoadMoreLayout.c<Object> paramc);
  
  public void e(e parame)
  {
    p.h(parame, "holder");
  }
  
  public abstract RecyclerView.i eL(Context paramContext);
  
  public abstract String f(RefreshLoadMoreLayout.c<Object> paramc);
  
  public final WxRecyclerAdapter<?> getAdapter()
  {
    WxRecyclerAdapter localWxRecyclerAdapter = this.rPu;
    if (localWxRecyclerAdapter == null) {
      p.bcb("adapter");
    }
    return localWxRecyclerAdapter;
  }
  
  public abstract View getEmptyView();
  
  public abstract View getHeaderView();
  
  public abstract RecyclerView.h getItemDecoration();
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onBindFirstBodyViewHolder", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "payloads", "", "", "onViewAttachedToWindow", "plugin-finder_release"})
  public static final class a
    extends WxRecyclerAdapter<al>
  {
    a(ArrayList paramArrayList1, com.tencent.mm.view.recyclerview.c paramc, ArrayList paramArrayList2)
    {
      super(localArrayList);
    }
    
    public final void f(e parame)
    {
      AppMethodBeat.i(201691);
      p.h(parame, "holder");
      super.f(parame);
      Object localObject = parame.auu;
      p.g(localObject, "holder.itemView");
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        if ((parame.lQ() == this.rUa.rTV) || (parame.lQ() == this.rUa.rTW))
        {
          ((StaggeredGridLayoutManager.LayoutParams)localObject).aE(true);
          AppMethodBeat.o(201691);
          return;
        }
        if (this.rUa.d(parame)) {
          ((StaggeredGridLayoutManager.LayoutParams)localObject).aE(true);
        }
      }
      AppMethodBeat.o(201691);
    }
    
    public final void t(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(201693);
      p.h(paramRecyclerView, "recyclerView");
      Object localObject = FinderReporterUIC.tcM;
      localObject = FinderReporterUIC.a.eY((Context)this.rUa.fLP);
      if (localObject != null)
      {
        localObject = FinderReporterUIC.d((FinderReporterUIC)localObject);
        if (localObject != null)
        {
          ((f)localObject).czz().b(paramRecyclerView, 5);
          AppMethodBeat.o(201693);
          return;
        }
      }
      AppMethodBeat.o(201693);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class b
    implements d.c<e>
  {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"})
  public static final class c
    extends RefreshLoadMoreLayout.a
  {
    private boolean rTM = true;
    
    public final void AM(int paramInt)
    {
      AppMethodBeat.i(201701);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      super.AM(paramInt);
      if (this.rUa.cAP().rTS.getSize() == 0)
      {
        localObject = this.rUa.getEmptyView();
        if (localObject != null)
        {
          ((View)localObject).setVisibility(0);
          RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.rUa.rTF;
          if (localRefreshLoadMoreLayout != null) {
            localRefreshLoadMoreLayout.setVisibility(8);
          }
          localObject = ((View)localObject).findViewById(2131303515);
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
        }
      }
      h.LTJ.aR((Runnable)new b(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(201701);
    }
    
    public final void Ex(int paramInt)
    {
      if ((this.rTM) && (paramInt > 0)) {
        this.rTM = false;
      }
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201703);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      p.h(paramc, "reason");
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(201703);
    }
    
    public final void b(final RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201700);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
      p.h(paramc, "reason");
      super.b(paramc);
      View localView = this.rUa.getEmptyView();
      Object localObject2;
      int i;
      if (localView != null)
      {
        localObject2 = this.rUa.rTF.getRecyclerView().getAdapter();
        localObject1 = localObject2;
        if (!(localObject2 instanceof WxRecyclerAdapter)) {
          localObject1 = null;
        }
        localObject1 = (WxRecyclerAdapter)localObject1;
        if (paramc.Lrg == -1) {
          break label243;
        }
        if (localObject1 == null) {
          break label138;
        }
        i = ((d)localObject1).fQA();
        if (i > 0) {
          break label143;
        }
        this.rUa.bmg();
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(201700);
        return;
        label138:
        i = 0;
        break;
        label143:
        localView.setVisibility(8);
        localObject1 = this.rUa.rTZ;
        if (localObject1 != null)
        {
          localObject2 = (TextView)((View)localObject1).findViewById(2131305902);
          if (localObject2 != null) {
            ((TextView)localObject2).setText((CharSequence)this.rUa.e(paramc));
          }
          localObject1 = (TextView)((View)localObject1).findViewById(2131298996);
          if (localObject1 != null) {
            ((TextView)localObject1).setText((CharSequence)this.rUa.f(paramc));
          }
        }
        paramc = this.rUa.rTF;
        if (paramc != null)
        {
          paramc.setVisibility(0);
          continue;
          label243:
          localView.setVisibility(0);
          localObject1 = this.rUa.rTF;
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
    
    public final void bYl()
    {
      AppMethodBeat.i(201702);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.bYl();
      h.LTJ.aR((Runnable)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(201702);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(b.b.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(201696);
        this.rUc.rUa.cAQ().aTt();
        AppMethodBeat.o(201696);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(b.b.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(201697);
        this.rUc.rUa.cAQ().requestRefresh();
        AppMethodBeat.o(201697);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4$onRefreshEnd$1$2"})
    static final class c
      implements View.OnClickListener
    {
      c(View paramView, b.b.c paramc, RefreshLoadMoreLayout.c paramc1) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(201699);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4$onRefreshEnd$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        p.g(paramView, "it");
        paramView.setVisibility(8);
        paramView = this.rUd.findViewById(2131303515);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        h.LTJ.aR((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(201698);
            this.rUf.rUc.rUa.cAQ().requestRefresh();
            AppMethodBeat.o(201698);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4$onRefreshEnd$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201699);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<Void, d.z>
  {
    d(b.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.b.b
 * JD-Core Version:    0.7.0.1
 */