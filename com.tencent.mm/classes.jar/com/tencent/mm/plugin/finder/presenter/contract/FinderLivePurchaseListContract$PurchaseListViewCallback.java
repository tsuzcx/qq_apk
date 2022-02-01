package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.k;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLivePurchaseListContract$PurchaseListViewCallback;", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLivePurchaseListContract$PurchaseListPresenter;", "rootView", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLivePurchaseListContract$PurchaseListPresenter;Landroid/view/View;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "emptyView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getEmptyView", "()Landroid/widget/TextView;", "setEmptyView", "(Landroid/widget/TextView;)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLivePurchaseListContract$PurchaseListPresenter;", "progressView", "Landroid/widget/ProgressBar;", "getProgressView", "()Landroid/widget/ProgressBar;", "setProgressView", "(Landroid/widget/ProgressBar;)V", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getProxyRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setProxyRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "rfLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRfLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRfLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getRootView", "()Landroid/view/View;", "initView", "", "resfreshTitle", "count", "", "showEmptyView", "show", "", "showProgress", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLivePurchaseListContract$PurchaseListViewCallback
{
  k ATF;
  WxRecyclerView AZd;
  RefreshLoadMoreLayout BwD;
  final FinderLivePurchaseListContract.PurchaseListPresenter EYw;
  private ProgressBar EYx;
  final MMActivity activity;
  TextView njO;
  private final View rootView;
  
  public FinderLivePurchaseListContract$PurchaseListViewCallback(MMActivity paramMMActivity, FinderLivePurchaseListContract.PurchaseListPresenter paramPurchaseListPresenter, View paramView)
  {
    AppMethodBeat.i(343642);
    this.activity = paramMMActivity;
    this.EYw = paramPurchaseListPresenter;
    this.rootView = paramView;
    this.BwD = ((RefreshLoadMoreLayout)this.rootView.findViewById(e.e.finder_live_purchase_rf));
    this.AZd = ((WxRecyclerView)this.rootView.findViewById(e.e.finder_live_purchase_recycler_view));
    this.EYx = ((ProgressBar)this.rootView.findViewById(e.e.purchase_list_progress));
    this.njO = ((TextView)this.rootView.findViewById(e.e.empty_tip));
    this.ATF = ((k)new k()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(343846);
        this.EYy.BwD.onChanged();
        AppMethodBeat.o(343846);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(343854);
        this.EYy.BwD.onItemRangeChanged(this.EYy.EYw.getAdapter().agOb.size() + paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(343854);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(343858);
        this.EYy.BwD.onItemRangeChanged(this.EYy.EYw.getAdapter().agOb.size() + paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
        AppMethodBeat.o(343858);
      }
      
      public final void onItemRangeInserted(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(343864);
        this.EYy.BwD.onItemRangeInserted(this.EYy.EYw.getAdapter().agOb.size() + paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(343864);
      }
      
      public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(343871);
        this.EYy.BwD.onItemRangeRemoved(this.EYy.EYw.getAdapter().agOb.size() + paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(343871);
      }
      
      public final void onPreFinishLoadMore(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(343835);
        s.u(paramAnonymousd, "reason");
        this.EYy.BwD.onPreFinishLoadMore(paramAnonymousd);
        AppMethodBeat.o(343835);
      }
      
      public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(343842);
        s.u(paramAnonymousd, "reason");
        this.EYy.BwD.onPreFinishLoadMoreSmooth(paramAnonymousd);
        AppMethodBeat.o(343842);
      }
      
      public final void onPreFinishRefresh(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(343827);
        s.u(paramAnonymousd, "reason");
        this.EYy.BwD.onPreFinishRefresh(paramAnonymousd);
        AppMethodBeat.o(343827);
      }
    });
    AppMethodBeat.o(343642);
  }
  
  private static final void b(PurchaseListViewCallback paramPurchaseListViewCallback)
  {
    AppMethodBeat.i(343647);
    s.u(paramPurchaseListViewCallback, "this$0");
    paramPurchaseListViewCallback.EYw.CNJ.requestRefresh();
    AppMethodBeat.o(343647);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(343660);
    WxRecyclerView localWxRecyclerView = this.AZd;
    localWxRecyclerView.getRootView().getContext();
    localWxRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    localWxRecyclerView.setAdapter((RecyclerView.a)this.EYw.getAdapter());
    localWxRecyclerView.a((RecyclerView.h)new RecyclerView.h()
    {
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss)
      {
        AppMethodBeat.i(343641);
        s.u(paramAnonymousRect, "outRect");
        s.u(paramAnonymousView, "view");
        s.u(paramAnonymousRecyclerView, "parent");
        s.u(paramAnonymouss, "state");
        paramAnonymousRect.left = 0;
        paramAnonymousRect.right = 0;
        paramAnonymousRect.top = 0;
        paramAnonymousRect.bottom = this.EYy.activity.getResources().getDimensionPixelOffset(e.c.Edge_2A);
        AppMethodBeat.o(343641);
      }
    });
    this.BwD.setActionCallback((RefreshLoadMoreLayout.b)new RefreshLoadMoreLayout.b()
    {
      private static final void c(FinderLivePurchaseListContract.PurchaseListViewCallback paramAnonymousPurchaseListViewCallback)
      {
        AppMethodBeat.i(343492);
        s.u(paramAnonymousPurchaseListViewCallback, "this$0");
        paramAnonymousPurchaseListViewCallback.AZd.setItemAnimator((RecyclerView.f)new f());
        AppMethodBeat.o(343492);
      }
      
      public final void IH(int paramAnonymousInt)
      {
        AppMethodBeat.i(343504);
        super.IH(paramAnonymousInt);
        this.EYy.EYw.CNJ.requestRefresh();
        this.EYy.AZd.setItemAnimator((RecyclerView.f)((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).bUj());
        AppMethodBeat.o(343504);
      }
      
      public final void a(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(343523);
        s.u(paramAnonymousd, "reason");
        super.a(paramAnonymousd);
        this.EYy.pZ(false);
        AppMethodBeat.o(343523);
      }
      
      public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(343513);
        s.u(paramAnonymousd, "reason");
        super.onRefreshEnd(paramAnonymousd);
        paramAnonymousd = this.EYy.BwD;
        s.s(paramAnonymousd, "rfLayout");
        RefreshLoadMoreLayout.c(paramAnonymousd);
        this.EYy.AZd.postDelayed(new FinderLivePurchaseListContract.PurchaseListViewCallback.initView.2..ExternalSyntheticLambda0(this.EYy), 1000L);
        this.EYy.pZ(false);
        AppMethodBeat.o(343513);
      }
      
      public final void qI(int paramAnonymousInt)
      {
        AppMethodBeat.i(343518);
        super.qI(paramAnonymousInt);
        BaseFeedLoader.requestLoadMore$default(this.EYy.EYw.CNJ, false, 1, null);
        AppMethodBeat.o(343518);
      }
    });
    pZ(true);
    this.rootView.postDelayed(new FinderLivePurchaseListContract.PurchaseListViewCallback..ExternalSyntheticLambda0(this), 300L);
    AppMethodBeat.o(343660);
  }
  
  public final void pZ(boolean paramBoolean)
  {
    AppMethodBeat.i(343663);
    ProgressBar localProgressBar = this.EYx;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localProgressBar.setVisibility(i);
      AppMethodBeat.o(343663);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLivePurchaseListContract.PurchaseListViewCallback
 * JD-Core Version:    0.7.0.1
 */