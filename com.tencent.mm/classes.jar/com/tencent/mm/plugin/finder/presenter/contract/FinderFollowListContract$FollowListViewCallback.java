package com.tencent.mm.plugin.finder.presenter.contract;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.cgi.af.a;
import com.tencent.mm.plugin.finder.convert.z;
import com.tencent.mm.plugin.finder.model.u;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.search.h;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.HeadFooterLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d.c;
import com.tencent.mm.view.recyclerview.d.d;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListPresent;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contentView", "Landroid/view/View;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListPresent;)V", "MENU_ID_UNFOLLOW", "", "TAG", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "emptyTip", "Landroid/widget/TextView;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "getActivity", "getPresenter", "initView", "", "onOverEnd", "", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "refreshList", "isDown", "startIndex", "increaseCount", "refreshTitle", "showPopupMenu", "finderContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "anchor", "plugin-finder_release"})
public final class FinderFollowListContract$FollowListViewCallback
  implements com.tencent.mm.plugin.finder.presenter.base.c<FinderFollowListContract.FollowListPresent>, HeadFooterLayout.b
{
  private final String TAG;
  public final MMActivity activity;
  public final View contentView;
  public TextView gYR;
  public RecyclerView gpr;
  public com.tencent.mm.ui.widget.b.a ofu;
  private final int rUN;
  public WxRecyclerAdapter<u> rXV;
  public RefreshLoadMoreLayout scj;
  public MMProcessBar siX;
  public final FinderFollowListContract.FollowListPresent swa;
  
  public FinderFollowListContract$FollowListViewCallback(MMActivity paramMMActivity, View paramView, FinderFollowListContract.FollowListPresent paramFollowListPresent)
  {
    AppMethodBeat.i(203679);
    this.activity = paramMMActivity;
    this.contentView = paramView;
    this.swa = paramFollowListPresent;
    this.TAG = ("Finder.FinderFollowListContract.FollowListViewCallback." + hashCode());
    this.rUN = 1001;
    AppMethodBeat.o(203679);
  }
  
  public final boolean EN(int paramInt)
  {
    AppMethodBeat.i(203678);
    ae.i(this.TAG, "[onOverEnd] dy=".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(203678);
    return false;
  }
  
  public final void cDB()
  {
    AppMethodBeat.i(203676);
    ae.i(this.TAG, "[onOverStop]");
    MMProcessBar localMMProcessBar = this.siX;
    if (localMMProcessBar == null) {
      p.bdF("rlProcessBar");
    }
    localMMProcessBar.fPN();
    AppMethodBeat.o(203676);
  }
  
  public final void cEW()
  {
    AppMethodBeat.i(203675);
    Object localObject = com.tencent.mm.kernel.g.ajR();
    p.g(localObject, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.e)localObject).ajA().getInt(am.a.Jcx, 0);
    this.activity.setMMTitle(c.a.a(this).getString(2131759273, new Object[] { Integer.valueOf(i) }));
    if (i == 0)
    {
      localObject = this.gYR;
      if (localObject == null) {
        p.bdF("emptyTip");
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.gYR;
      if (localObject == null) {
        p.bdF("emptyTip");
      }
      ((TextView)localObject).setText((CharSequence)this.activity.getString(2131759229));
      AppMethodBeat.o(203675);
      return;
    }
    localObject = this.gYR;
    if (localObject == null) {
      p.bdF("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    AppMethodBeat.o(203675);
  }
  
  public final void f(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203673);
    if ((paramInt1 >= 0) && (paramInt2 > 0))
    {
      localObject = this.rXV;
      if (localObject != null) {
        ((WxRecyclerAdapter)localObject).ar(paramInt1, paramInt2);
      }
    }
    while (paramBoolean)
    {
      localObject = new RefreshLoadMoreLayout.c(0);
      ((RefreshLoadMoreLayout.c)localObject).LNT = this.swa.hasMore;
      ((RefreshLoadMoreLayout.c)localObject).LNU = paramInt2;
      if (((RefreshLoadMoreLayout.c)localObject).LNU > 0) {
        ((RefreshLoadMoreLayout.c)localObject).iOP = false;
      }
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.scj;
      if (localRefreshLoadMoreLayout == null) {
        p.bdF("rlLayout");
      }
      localRefreshLoadMoreLayout.d((RefreshLoadMoreLayout.c)localObject);
      AppMethodBeat.o(203673);
      return;
      localObject = this.rXV;
      if (localObject != null) {
        ((WxRecyclerAdapter)localObject).notifyDataSetChanged();
      }
    }
    Object localObject = this.scj;
    if (localObject == null) {
      p.bdF("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).agH(0);
    if (!this.swa.hasMore)
    {
      localObject = this.scj;
      if (localObject == null) {
        p.bdF("rlLayout");
      }
      RefreshLoadMoreLayout.f((RefreshLoadMoreLayout)localObject);
    }
    AppMethodBeat.o(203673);
  }
  
  public final MMActivity getActivity()
  {
    return this.activity;
  }
  
  public final boolean r(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(203677);
    ae.i(this.TAG, "[onOverStart] dy=".concat(String.valueOf(paramInt1)));
    MMProcessBar localMMProcessBar = this.siX;
    if (localMMProcessBar == null) {
      p.bdF("rlProcessBar");
    }
    float f = paramInt1;
    Context localContext = ak.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    localMMProcessBar.rotate(f / (int)localContext.getResources().getDimension(2131165288));
    AppMethodBeat.o(203677);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract.FollowListViewCallback
 * JD-Core Version:    0.7.0.1
 */