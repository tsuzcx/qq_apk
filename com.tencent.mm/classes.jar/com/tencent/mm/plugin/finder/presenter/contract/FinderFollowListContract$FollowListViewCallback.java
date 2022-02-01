package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.an;
import com.tencent.mm.plugin.finder.convert.aq;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.model.ah;
import com.tencent.mm.plugin.finder.model.ai;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.search.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.HeadFooterLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.h.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListPresent;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contentView", "Landroid/view/View;", "presenter", "isFromTeenModeSettingPage", "", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListPresent;Z)V", "MENU_ID_UNFOLLOW", "", "TAG", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "emptyTip", "Landroid/widget/TextView;", "mHellScrollListener", "com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$mHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$mHellScrollListener$1;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "addScrollListener", "", "getActivity", "getPresenter", "initView", "onOverEnd", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "refreshList", "isDown", "startIndex", "increaseCount", "refreshTitle", "removeScrollListener", "showPopupMenu", "data", "anchor", "plugin-finder_release"})
public final class FinderFollowListContract$FollowListViewCallback
  implements com.tencent.mm.plugin.finder.presenter.base.c<FinderFollowListContract.FollowListPresent>, HeadFooterLayout.b
{
  private final String TAG;
  public final MMActivity activity;
  public final View contentView;
  public RecyclerView jLl;
  public TextView kGj;
  public com.tencent.mm.ui.widget.b.a szq;
  public MMProcessBar xDP;
  private final int xhI;
  public WxRecyclerAdapter<ah> xnR;
  public RefreshLoadMoreLayout xvJ;
  public final mHellScrollListener.1 zMY;
  public final FinderFollowListContract.FollowListPresent zMZ;
  private final boolean zNa;
  
  public FinderFollowListContract$FollowListViewCallback(MMActivity paramMMActivity, View paramView, FinderFollowListContract.FollowListPresent paramFollowListPresent, boolean paramBoolean)
  {
    AppMethodBeat.i(284209);
    this.activity = paramMMActivity;
    this.contentView = paramView;
    this.zMZ = paramFollowListPresent;
    this.zNa = paramBoolean;
    this.TAG = ("Finder.FinderFollowListContract.FollowListViewCallback." + hashCode());
    this.xhI = 1001;
    this.zMY = new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(274273);
        b localb = new b();
        localb.bn(paramAnonymousRecyclerView);
        localb.sg(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$mHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$mHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(274273);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(274272);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousRecyclerView);
        ((b)localObject).sg(paramAnonymousInt1);
        ((b)localObject).sg(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$mHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((b)localObject).aFi());
        p.k(paramAnonymousRecyclerView, "recyclerView");
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        localObject = k.yBj;
        k.b(paramAnonymousRecyclerView, s.t.yGM, "12", com.tencent.mm.plugin.finder.live.report.c.yAh);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$mHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(274272);
      }
    };
    AppMethodBeat.o(284209);
  }
  
  public final boolean MB(int paramInt)
  {
    AppMethodBeat.i(284208);
    Log.i(this.TAG, "[onOverEnd] dy=".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(284208);
    return false;
  }
  
  public final void dMV()
  {
    AppMethodBeat.i(284205);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.f)localObject).aHp().getInt(ar.a.VAv, 0);
    this.activity.setMMTitle(c.a.a(this).getString(b.j.finder_my_follow_contact_number, new Object[] { Integer.valueOf(i) }));
    if (i == 0)
    {
      localObject = this.kGj;
      if (localObject == null) {
        p.bGy("emptyTip");
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.kGj;
      if (localObject == null) {
        p.bGy("emptyTip");
      }
      ((TextView)localObject).setText((CharSequence)this.activity.getString(b.j.finder_follow_contact_empty_tip));
      AppMethodBeat.o(284205);
      return;
    }
    localObject = this.kGj;
    if (localObject == null) {
      p.bGy("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    AppMethodBeat.o(284205);
  }
  
  public final void dtZ()
  {
    AppMethodBeat.i(284206);
    Log.i(this.TAG, "[onOverStop]");
    MMProcessBar localMMProcessBar = this.xDP;
    if (localMMProcessBar == null) {
      p.bGy("rlProcessBar");
    }
    localMMProcessBar.hZH();
    AppMethodBeat.o(284206);
  }
  
  public final void i(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(284202);
    if ((paramInt1 >= 0) && (paramInt2 > 0))
    {
      localObject = this.xnR;
      if (localObject != null) {
        ((WxRecyclerAdapter)localObject).aG(paramInt1, paramInt2);
      }
    }
    while (paramBoolean)
    {
      localObject = new RefreshLoadMoreLayout.c(0);
      ((RefreshLoadMoreLayout.c)localObject).YNF = this.zMZ.hasMore;
      ((RefreshLoadMoreLayout.c)localObject).YNG = paramInt2;
      if (((RefreshLoadMoreLayout.c)localObject).YNG > 0) {
        ((RefreshLoadMoreLayout.c)localObject).mCI = false;
      }
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.xvJ;
      if (localRefreshLoadMoreLayout == null) {
        p.bGy("rlLayout");
      }
      localRefreshLoadMoreLayout.onPreFinishLoadMoreSmooth((RefreshLoadMoreLayout.c)localObject);
      AppMethodBeat.o(284202);
      return;
      localObject = this.xnR;
      if (localObject != null) {
        ((WxRecyclerAdapter)localObject).notifyDataSetChanged();
      }
    }
    Object localObject = this.xvJ;
    if (localObject == null) {
      p.bGy("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).azr(0);
    if (!this.zMZ.hasMore)
    {
      localObject = this.xvJ;
      if (localObject == null) {
        p.bGy("rlLayout");
      }
      RefreshLoadMoreLayout.e((RefreshLoadMoreLayout)localObject);
    }
    AppMethodBeat.o(284202);
  }
  
  public final boolean v(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(284207);
    Log.i(this.TAG, "[onOverStart] dy=".concat(String.valueOf(paramInt1)));
    MMProcessBar localMMProcessBar = this.xDP;
    if (localMMProcessBar == null) {
      p.bGy("rlProcessBar");
    }
    float f = paramInt1;
    Context localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    localMMProcessBar.cQ(f / (int)localContext.getResources().getDimension(b.d.Edge_26A));
    AppMethodBeat.o(284207);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract.FollowListViewCallback
 * JD-Core Version:    0.7.0.1
 */