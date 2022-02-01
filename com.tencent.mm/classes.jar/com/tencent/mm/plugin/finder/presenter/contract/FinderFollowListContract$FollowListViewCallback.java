package com.tencent.mm.plugin.finder.presenter.contract;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.plugin.finder.cgi.bb.a;
import com.tencent.mm.plugin.finder.model.af;
import com.tencent.mm.plugin.finder.model.ag;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.search.i;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.HeadFooterLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.g.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListPresent;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contentView", "Landroid/view/View;", "presenter", "isFromTeenModeSettingPage", "", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListPresent;Z)V", "MENU_ID_UNFOLLOW", "", "TAG", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "emptyTip", "Landroid/widget/TextView;", "mHellScrollListener", "com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$mHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$mHellScrollListener$1;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "addScrollListener", "", "getActivity", "getPresenter", "initView", "onOverEnd", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "refreshList", "isDown", "startIndex", "increaseCount", "refreshTitle", "removeScrollListener", "showPopupMenu", "finderContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "anchor", "plugin-finder_release"})
public final class FinderFollowListContract$FollowListViewCallback
  implements com.tencent.mm.plugin.finder.presenter.base.c<FinderFollowListContract.FollowListPresent>, HeadFooterLayout.b
{
  private final String TAG;
  public final MMActivity activity;
  public final View contentView;
  public TextView hRM;
  public RecyclerView hak;
  public com.tencent.mm.ui.widget.b.a pqr;
  public WxRecyclerAdapter<af> tFp;
  public RefreshLoadMoreLayout tLS;
  public MMProcessBar tSY;
  private final int tzW;
  public final mHellScrollListener.1 uWK;
  public final FinderFollowListContract.FollowListPresent uWL;
  private final boolean uWM;
  
  public FinderFollowListContract$FollowListViewCallback(MMActivity paramMMActivity, View paramView, FinderFollowListContract.FollowListPresent paramFollowListPresent, boolean paramBoolean)
  {
    AppMethodBeat.i(249747);
    this.activity = paramMMActivity;
    this.contentView = paramView;
    this.uWL = paramFollowListPresent;
    this.uWM = paramBoolean;
    this.TAG = ("Finder.FinderFollowListContract.FollowListViewCallback." + hashCode());
    this.tzW = 1001;
    this.uWK = new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(249738);
        b localb = new b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$mHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$mHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(249738);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(249737);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousRecyclerView);
        ((b)localObject).pH(paramAnonymousInt1);
        ((b)localObject).pH(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$mHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((b)localObject).axR());
        p.h(paramAnonymousRecyclerView, "recyclerView");
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        localObject = k.vkd;
        k.b(paramAnonymousRecyclerView, s.p.voz, "12", com.tencent.mm.plugin.finder.report.live.c.vje);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$mHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(249737);
      }
    };
    AppMethodBeat.o(249747);
  }
  
  public final boolean IJ(int paramInt)
  {
    AppMethodBeat.i(249746);
    Log.i(this.TAG, "[onOverEnd] dy=".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(249746);
    return false;
  }
  
  public final void ddr()
  {
    AppMethodBeat.i(249744);
    Log.i(this.TAG, "[onOverStop]");
    MMProcessBar localMMProcessBar = this.tSY;
    if (localMMProcessBar == null) {
      p.btv("rlProcessBar");
    }
    localMMProcessBar.gYP();
    AppMethodBeat.o(249744);
  }
  
  public final void dlR()
  {
    AppMethodBeat.i(249743);
    Object localObject = com.tencent.mm.kernel.g.aAh();
    p.g(localObject, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.e)localObject).azQ().getInt(ar.a.OlA, 0);
    this.activity.setMMTitle(c.a.a(this).getString(2131760317, new Object[] { Integer.valueOf(i) }));
    if (i == 0)
    {
      localObject = this.hRM;
      if (localObject == null) {
        p.btv("emptyTip");
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.hRM;
      if (localObject == null) {
        p.btv("emptyTip");
      }
      ((TextView)localObject).setText((CharSequence)this.activity.getString(2131759778));
      AppMethodBeat.o(249743);
      return;
    }
    localObject = this.hRM;
    if (localObject == null) {
      p.btv("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    AppMethodBeat.o(249743);
  }
  
  public final void f(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(249741);
    if ((paramInt1 >= 0) && (paramInt2 > 0))
    {
      localObject = this.tFp;
      if (localObject != null) {
        ((WxRecyclerAdapter)localObject).as(paramInt1, paramInt2);
      }
    }
    while (paramBoolean)
    {
      localObject = new RefreshLoadMoreLayout.c(0);
      ((RefreshLoadMoreLayout.c)localObject).Rmj = this.uWL.hasMore;
      ((RefreshLoadMoreLayout.c)localObject).Rmk = paramInt2;
      if (((RefreshLoadMoreLayout.c)localObject).Rmk > 0) {
        ((RefreshLoadMoreLayout.c)localObject).jLE = false;
      }
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.tLS;
      if (localRefreshLoadMoreLayout == null) {
        p.btv("rlLayout");
      }
      localRefreshLoadMoreLayout.onPreFinishLoadMoreSmooth((RefreshLoadMoreLayout.c)localObject);
      AppMethodBeat.o(249741);
      return;
      localObject = this.tFp;
      if (localObject != null) {
        ((WxRecyclerAdapter)localObject).notifyDataSetChanged();
      }
    }
    Object localObject = this.tLS;
    if (localObject == null) {
      p.btv("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).apS(0);
    if (!this.uWL.hasMore)
    {
      localObject = this.tLS;
      if (localObject == null) {
        p.btv("rlLayout");
      }
      RefreshLoadMoreLayout.e((RefreshLoadMoreLayout)localObject);
    }
    AppMethodBeat.o(249741);
  }
  
  public final boolean u(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(249745);
    Log.i(this.TAG, "[onOverStart] dy=".concat(String.valueOf(paramInt1)));
    MMProcessBar localMMProcessBar = this.tSY;
    if (localMMProcessBar == null) {
      p.btv("rlProcessBar");
    }
    float f = paramInt1;
    Context localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    localMMProcessBar.rotate(f / (int)localContext.getResources().getDimension(2131165295));
    AppMethodBeat.o(249745);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract.FollowListViewCallback
 * JD-Core Version:    0.7.0.1
 */