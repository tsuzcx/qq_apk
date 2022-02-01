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
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d.c;
import d.g.b.k;
import d.y;
import java.util.ArrayList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class n
{
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getProxyRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setProxyRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "keep", "p0", "loadInitData", "loadMoreData", "onAttach", "callback", "onBackPressed", "", "onDetach", "onUIPause", "onUIResume", "requestRefresh", "plugin-finder_release"})
  public static abstract class a
    implements com.tencent.mm.plugin.finder.presenter.base.a<n.b>, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
  {
    public n.b KMQ;
    final MMActivity imP;
    private com.tencent.mm.view.d qvO;
    final BaseFinderFeedLoader qvo;
    
    public a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
    {
      this.imP = paramMMActivity;
      this.qvo = paramBaseFinderFeedLoader;
      this.qvO = ((com.tencent.mm.view.d)new com.tencent.mm.view.d()
      {
        public final void at(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(197627);
          Object localObject1 = this.KMR.KMQ;
          if (localObject1 != null)
          {
            localObject1 = (com.tencent.mm.view.d)((n.b)localObject1).quj;
            if (localObject1 != null)
            {
              Object localObject2 = this.KMR.KMQ;
              if (localObject2 != null)
              {
                localObject2 = ((n.b)localObject2).getAdapter();
                if (localObject2 == null) {}
              }
              for (int i = ((com.tencent.mm.view.recyclerview.d)localObject2).Ibl.size();; i = 0)
              {
                ((com.tencent.mm.view.d)localObject1).at(i + paramAnonymousInt1, paramAnonymousInt2);
                AppMethodBeat.o(197627);
                return;
              }
            }
          }
          AppMethodBeat.o(197627);
        }
        
        public final void au(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(197628);
          Object localObject1 = this.KMR.KMQ;
          Object localObject2;
          if (localObject1 != null)
          {
            localObject1 = (com.tencent.mm.view.d)((n.b)localObject1).quj;
            if (localObject1 != null)
            {
              localObject2 = this.KMR.KMQ;
              if (localObject2 == null) {
                break label105;
              }
              localObject2 = ((n.b)localObject2).getAdapter();
              if (localObject2 == null) {
                break label105;
              }
            }
          }
          label105:
          for (int i = ((com.tencent.mm.view.recyclerview.d)localObject2).Ibl.size();; i = 0)
          {
            ((com.tencent.mm.view.d)localObject1).au(i + paramAnonymousInt1, paramAnonymousInt2);
            localObject1 = this.KMR.KMQ;
            if (localObject1 == null) {
              break;
            }
            ((n.b)localObject1).fTg();
            AppMethodBeat.o(197628);
            return;
          }
          AppMethodBeat.o(197628);
        }
        
        public final void c(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(197624);
          k.h(paramAnonymousc, "reason");
          Object localObject = this.KMR.KMQ;
          if (localObject != null)
          {
            localObject = (com.tencent.mm.view.d)((n.b)localObject).quj;
            if (localObject != null)
            {
              ((com.tencent.mm.view.d)localObject).c(paramAnonymousc);
              AppMethodBeat.o(197624);
              return;
            }
          }
          AppMethodBeat.o(197624);
        }
        
        public final void d(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(197623);
          k.h(paramAnonymousc, "reason");
          Object localObject = this.KMR.KMQ;
          if (localObject != null)
          {
            localObject = (com.tencent.mm.view.d)((n.b)localObject).quj;
            if (localObject != null)
            {
              ((com.tencent.mm.view.d)localObject).d(paramAnonymousc);
              AppMethodBeat.o(197623);
              return;
            }
          }
          AppMethodBeat.o(197623);
        }
        
        public final void f(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          AppMethodBeat.i(197626);
          Object localObject1 = this.KMR.KMQ;
          if (localObject1 != null)
          {
            localObject1 = (com.tencent.mm.view.d)((n.b)localObject1).quj;
            if (localObject1 != null)
            {
              Object localObject2 = this.KMR.KMQ;
              if (localObject2 != null)
              {
                localObject2 = ((n.b)localObject2).getAdapter();
                if (localObject2 == null) {}
              }
              for (int i = ((com.tencent.mm.view.recyclerview.d)localObject2).Ibl.size();; i = 0)
              {
                ((com.tencent.mm.view.d)localObject1).f(i + paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
                AppMethodBeat.o(197626);
                return;
              }
            }
          }
          AppMethodBeat.o(197626);
        }
        
        public final void onChanged()
        {
          AppMethodBeat.i(197625);
          Object localObject = this.KMR.KMQ;
          if (localObject != null)
          {
            localObject = (com.tencent.mm.view.d)((n.b)localObject).quj;
            if (localObject != null)
            {
              ((com.tencent.mm.view.d)localObject).onChanged();
              AppMethodBeat.o(197625);
              return;
            }
          }
          AppMethodBeat.o(197625);
        }
      });
    }
    
    public void a(n.b paramb)
    {
      k.h(paramb, "callback");
      this.KMQ = paramb;
      this.qvo.register(this.qvO, this.imP);
      clJ();
    }
    
    public abstract void aJq();
    
    public abstract void clJ();
    
    public abstract com.tencent.mm.view.recyclerview.c clL();
    
    public void fTa() {}
    
    public void keep(com.tencent.mm.vending.e.a parama) {}
    
    public void onDetach()
    {
      this.qvo.unregister(this.qvO, this.imP);
    }
    
    public abstract void requestRefresh();
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "VIEW_TYPE_FOOTER", "VIEW_TYPE_HEADER", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getCommentSafeMode", "()Z", "getCommentScene", "()I", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "finderManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getFinderManager", "()Landroid/support/v7/widget/RecyclerView$LayoutManager;", "setFinderManager", "(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "headerview", "Landroid/view/View;", "getHeaderview", "()Landroid/view/View;", "setHeaderview", "(Landroid/view/View;)V", "present", "getPresent", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "setPresent", "(Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getScene", "spanCount", "getSpanCount", "setSpanCount", "(I)V", "getAdapter", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/content/Context;", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getTitleStringId", "initView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "onGridItemClick", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "onViewPrepared", "refreshWhenEnter", "requestLoadMore", "plugin-finder_release"})
  public static abstract class b
    implements com.tencent.mm.plugin.finder.presenter.base.b<n.a>
  {
    public FinderLikeDrawer KMP;
    public n.a KMS;
    private v KMT;
    public RecyclerView.i KMU;
    public View KMV;
    private final String TAG;
    int aqI;
    final MMActivity imP;
    private final int qqE;
    public RefreshLoadMoreLayout quj;
    WxRecyclerAdapter<?> qul;
    private final boolean quo;
    final int qxJ;
    final int qxK;
    private final int scene;
    
    public b(MMActivity paramMMActivity, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.imP = paramMMActivity;
      this.scene = paramInt1;
      this.qqE = paramInt2;
      this.quo = paramBoolean;
      this.TAG = "Finder.FinderBaseGridFeedUIContract.ViewCallback";
      this.aqI = 3;
      paramMMActivity = this.imP.findViewById(2131304203);
      k.g(paramMMActivity, "context.findViewById(R.id.rl_layout)");
      this.quj = ((RefreshLoadMoreLayout)paramMMActivity);
      this.qxK = -1;
      this.KMT = ((v)new t());
      this.KMV = null;
    }
    
    public final void N(final ArrayList<BaseFinderFeed> paramArrayList)
    {
      k.h(paramArrayList, "data");
      RecyclerView localRecyclerView = this.quj.getRecyclerView();
      this.KMU = lw((Context)this.imP);
      Object localObject = FinderLikeDrawer.Lfb;
      localObject = (Context)this.imP;
      Window localWindow = this.imP.getWindow();
      k.g(localWindow, "context.window");
      FinderLikeDrawer.a locala = FinderLikeDrawer.Lfb;
      this.KMP = FinderLikeDrawer.a.a((Context)localObject, localWindow, FinderLikeDrawer.fWQ());
      localObject = this.KMU;
      if (localObject == null) {
        k.aPZ("finderManager");
      }
      localRecyclerView.setLayoutManager((RecyclerView.i)localObject);
      this.qul = ((WxRecyclerAdapter)new a(this, paramArrayList, fTb().clL(), paramArrayList));
      paramArrayList = this.qul;
      if (paramArrayList == null) {
        k.aPZ("adapter");
      }
      localRecyclerView.setAdapter((RecyclerView.a)paramArrayList);
      localRecyclerView.b(getItemDecoration());
      paramArrayList = this.qul;
      if (paramArrayList == null) {
        k.aPZ("adapter");
      }
      paramArrayList.Ibo = ((d.c)new b(this));
      if (this.KMV != null)
      {
        paramArrayList = this.qul;
        if (paramArrayList == null) {
          k.aPZ("adapter");
        }
        if (paramArrayList != null)
        {
          localObject = this.KMV;
          if (localObject == null) {
            k.fvU();
          }
          com.tencent.mm.view.recyclerview.d.a(paramArrayList, (View)localObject, this.qxJ);
        }
      }
      this.quj.setActionCallback((RefreshLoadMoreLayout.a)new c(this));
      paramArrayList = com.tencent.mm.ui.component.a.LCX;
      paramArrayList = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.imP).get(FinderReporterUIC.class));
      if (paramArrayList != null) {
        paramArrayList.v(localRecyclerView);
      }
      com.tencent.mm.ad.c.a(com.tencent.mm.ad.c.agM(), (d.g.a.b)new d(this));
    }
    
    public final void a(n.a parama)
    {
      k.h(parama, "<set-?>");
      this.KMS = parama;
    }
    
    public abstract void c(RecyclerView.a<?> parama, View paramView, int paramInt);
    
    public final n.a fTb()
    {
      n.a locala = this.KMS;
      if (locala == null) {
        k.aPZ("present");
      }
      return locala;
    }
    
    public final n.a fTc()
    {
      n.a locala = this.KMS;
      if (locala == null) {
        k.aPZ("present");
      }
      return locala;
    }
    
    public final FinderLikeDrawer fTd()
    {
      FinderLikeDrawer localFinderLikeDrawer = this.KMP;
      if (localFinderLikeDrawer == null) {
        k.aPZ("friendLikeDrawer");
      }
      return localFinderLikeDrawer;
    }
    
    public v fTe()
    {
      return this.KMT;
    }
    
    public boolean fTf()
    {
      return true;
    }
    
    public abstract void fTg();
    
    public final WxRecyclerAdapter<?> getAdapter()
    {
      WxRecyclerAdapter localWxRecyclerAdapter = this.qul;
      if (localWxRecyclerAdapter == null) {
        k.aPZ("adapter");
      }
      return localWxRecyclerAdapter;
    }
    
    public abstract View getEmptyView();
    
    public abstract RecyclerView.h getItemDecoration();
    
    public abstract String h(RefreshLoadMoreLayout.c<Object> paramc);
    
    public abstract String i(RefreshLoadMoreLayout.c<Object> paramc);
    
    public abstract RecyclerView.i lw(Context paramContext);
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onBindFirstBodyViewHolder", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onViewAttachedToWindow", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
    public static final class a
      extends WxRecyclerAdapter<BaseFinderFeed>
    {
      a(ArrayList paramArrayList1, com.tencent.mm.view.recyclerview.c paramc, ArrayList paramArrayList2)
      {
        super(localArrayList);
      }
      
      public final void e(com.tencent.mm.view.recyclerview.e parame)
      {
        AppMethodBeat.i(197629);
        k.h(parame, "holder");
        super.e(parame);
        Object localObject = parame.arI;
        k.g(localObject, "holder.itemView");
        localObject = ((View)localObject).getLayoutParams();
        if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
        {
          localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
          if ((parame.lp() != this.KMW.qxJ) && (parame.lp() != this.KMW.qxK)) {
            break label89;
          }
        }
        label89:
        for (boolean bool = true;; bool = false)
        {
          ((StaggeredGridLayoutManager.LayoutParams)localObject).aE(bool);
          AppMethodBeat.o(197629);
          return;
        }
      }
      
      public final void w(RecyclerView paramRecyclerView)
      {
        AppMethodBeat.i(197631);
        k.h(paramRecyclerView, "recyclerView");
        Object localObject = FinderReporterUIC.Ljl;
        localObject = FinderReporterUIC.a.lB((Context)this.KMW.imP);
        if (localObject != null)
        {
          localObject = FinderReporterUIC.d((FinderReporterUIC)localObject);
          if (localObject != null)
          {
            ((com.tencent.mm.plugin.finder.event.base.e)localObject).fSD().b(paramRecyclerView, 5);
            AppMethodBeat.o(197631);
            return;
          }
        }
        AppMethodBeat.o(197631);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "plugin-finder_release"})
    public static final class b
      implements d.c
    {
      public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
      {
        AppMethodBeat.i(197632);
        k.h(parama, "adapter");
        k.h(paramView, "view");
        this.KMW.c(parama, paramView, paramInt);
        AppMethodBeat.o(197632);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$3", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"})
    public static final class c
      extends RefreshLoadMoreLayout.a
    {
      private boolean qup = true;
      
      public final void CC(int paramInt)
      {
        if ((this.qup) && (paramInt > 0)) {
          this.qup = false;
        }
      }
      
      public final void a(RefreshLoadMoreLayout.c<Object> paramc)
      {
        AppMethodBeat.i(197640);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramc);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
        k.h(paramc, "reason");
        super.a(paramc);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(197640);
      }
      
      public final void agP(int paramInt)
      {
        AppMethodBeat.i(197638);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).lT(paramInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ado());
        super.agP(paramInt);
        if (this.KMW.fTb().qvo.getSize() == 0)
        {
          localObject1 = this.KMW.getEmptyView();
          if (localObject1 != null)
          {
            ((View)localObject1).setVisibility(0);
            Object localObject2 = this.KMW.qul;
            if (localObject2 == null) {
              k.aPZ("adapter");
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
        h.Iye.aP((Runnable)new b(this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
        AppMethodBeat.o(197638);
      }
      
      public final void b(final RefreshLoadMoreLayout.c<Object> paramc)
      {
        AppMethodBeat.i(197637);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).be(paramc);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ado());
        k.h(paramc, "reason");
        super.b(paramc);
        View localView = this.KMW.getEmptyView();
        Object localObject2;
        int i;
        if (localView != null)
        {
          localObject2 = this.KMW.quj.getRecyclerView().getAdapter();
          localObject1 = localObject2;
          if (!(localObject2 instanceof WxRecyclerAdapter)) {
            localObject1 = null;
          }
          localObject1 = (WxRecyclerAdapter)localObject1;
          if (paramc.HXo == -1) {
            break label328;
          }
          if (localObject1 == null) {
            break label211;
          }
          i = ((com.tencent.mm.view.recyclerview.d)localObject1).fjd();
          if (i > 0) {
            break label216;
          }
          localView.setVisibility(0);
          paramc = this.KMW.quj;
          if (paramc != null) {
            paramc.setVisibility(8);
          }
          paramc = (TextView)localView.findViewById(2131299472);
          if (paramc != null) {
            paramc.setVisibility(0);
          }
          paramc = localView.findViewById(2131303515);
          if (paramc != null) {
            paramc.setVisibility(8);
          }
          paramc = localView.findViewById(2131304150);
          if (paramc != null) {
            paramc.setVisibility(8);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
          AppMethodBeat.o(197637);
          return;
          label211:
          i = 0;
          break;
          label216:
          localView.setVisibility(8);
          localObject2 = this.KMW.KMV;
          if (localObject2 != null)
          {
            localView = ((View)localObject2).findViewById(2131305902);
            k.g(localView, "findViewById<TextView>(R.id.title)");
            ((TextView)localView).setText((CharSequence)this.KMW.h(paramc));
            localObject2 = ((View)localObject2).findViewById(2131298996);
            k.g(localObject2, "findViewById<TextView>(R.id.desc)");
            ((TextView)localObject2).setText((CharSequence)this.KMW.i(paramc));
          }
          if (localObject1 != null)
          {
            paramc = ((WxRecyclerAdapter)localObject1).getRecyclerView();
            if (paramc != null)
            {
              paramc.setVisibility(0);
              continue;
              label328:
              localView.setVisibility(0);
              localObject1 = this.KMW.quj;
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
      
      public final void bMu()
      {
        AppMethodBeat.i(197639);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
        super.bMu();
        h.Iye.aP((Runnable)new a(this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(197639);
      }
      
      @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
      static final class a
        implements Runnable
      {
        a(n.b.c paramc) {}
        
        public final void run()
        {
          AppMethodBeat.i(197633);
          this.KMY.KMW.fTc().aJq();
          AppMethodBeat.o(197633);
        }
      }
      
      @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
      static final class b
        implements Runnable
      {
        b(n.b.c paramc) {}
        
        public final void run()
        {
          AppMethodBeat.i(197634);
          this.KMY.KMW.fTc().requestRefresh();
          AppMethodBeat.o(197634);
        }
      }
      
      @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$3$onRefreshEnd$1$2"})
      static final class c
        implements View.OnClickListener
      {
        c(View paramView, n.b.c paramc, RefreshLoadMoreLayout.c paramc1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(197636);
          k.g(paramView, "it");
          paramView.setVisibility(8);
          paramView = this.Hzm.findViewById(2131303515);
          if (paramView != null) {
            paramView.setVisibility(0);
          }
          h.Iye.aP((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(197635);
              this.KNa.KMY.KMW.fTc().requestRefresh();
              AppMethodBeat.o(197635);
            }
          });
          AppMethodBeat.o(197636);
        }
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke"})
    static final class d
      extends d.g.b.l
      implements d.g.a.b<Void, y>
    {
      d(n.b paramb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.n
 * JD-Core Version:    0.7.0.1
 */