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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.finder.cgi.ae;
import com.tencent.mm.plugin.finder.cgi.ae.a;
import com.tencent.mm.plugin.finder.convert.z;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.plugin.finder.model.u;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.search.h;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListPresent;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contentView", "Landroid/view/View;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListPresent;)V", "MENU_ID_UNFOLLOW", "", "TAG", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "emptyTip", "Landroid/widget/TextView;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "getActivity", "getPresenter", "initView", "", "onOverEnd", "", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "refreshList", "isDown", "startIndex", "increaseCount", "refreshTitle", "showPopupMenu", "finderContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "anchor", "plugin-finder_release"})
public final class FinderFollowListContract$FollowListViewCallback
  implements com.tencent.mm.plugin.finder.presenter.base.c<FinderFollowListContract.FollowListPresent>, HeadFooterLayout.b
{
  private final String TAG;
  public final MMActivity activity;
  public final View contentView;
  public TextView gWe;
  public RecyclerView gmV;
  public com.tencent.mm.ui.widget.b.a nZK;
  private final int rMA;
  public WxRecyclerAdapter<t> rPu;
  public RefreshLoadMoreLayout rTF;
  public MMProcessBar sai;
  public final FinderFollowListContract.FollowListPresent smj;
  
  public FinderFollowListContract$FollowListViewCallback(MMActivity paramMMActivity, View paramView, FinderFollowListContract.FollowListPresent paramFollowListPresent)
  {
    AppMethodBeat.i(203138);
    this.activity = paramMMActivity;
    this.contentView = paramView;
    this.smj = paramFollowListPresent;
    this.TAG = ("Finder.FinderFollowListContract.FollowListViewCallback." + hashCode());
    this.rMA = 1001;
    AppMethodBeat.o(203138);
  }
  
  public final boolean EA(int paramInt)
  {
    AppMethodBeat.i(203137);
    ad.i(this.TAG, "[onOverEnd] dy=".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(203137);
    return false;
  }
  
  public final void cBP()
  {
    AppMethodBeat.i(203135);
    ad.i(this.TAG, "[onOverStop]");
    MMProcessBar localMMProcessBar = this.sai;
    if (localMMProcessBar == null) {
      p.bcb("rlProcessBar");
    }
    localMMProcessBar.fLt();
    AppMethodBeat.o(203135);
  }
  
  public final void cDe()
  {
    AppMethodBeat.i(203134);
    Object localObject = com.tencent.mm.kernel.g.ajC();
    p.g(localObject, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.e)localObject).ajl().getInt(al.a.IHU, 0);
    this.activity.setMMTitle(c.a.a(this).getString(2131759273, new Object[] { Integer.valueOf(i) }));
    if (i == 0)
    {
      localObject = this.gWe;
      if (localObject == null) {
        p.bcb("emptyTip");
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.gWe;
      if (localObject == null) {
        p.bcb("emptyTip");
      }
      ((TextView)localObject).setText((CharSequence)this.activity.getString(2131759229));
      AppMethodBeat.o(203134);
      return;
    }
    localObject = this.gWe;
    if (localObject == null) {
      p.bcb("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    AppMethodBeat.o(203134);
  }
  
  public final void f(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203132);
    if ((paramInt1 >= 0) && (paramInt2 > 0))
    {
      localObject = this.rPu;
      if (localObject != null) {
        ((WxRecyclerAdapter)localObject).ar(paramInt1, paramInt2);
      }
    }
    while (paramBoolean)
    {
      localObject = new RefreshLoadMoreLayout.c(0);
      ((RefreshLoadMoreLayout.c)localObject).Lri = this.smj.hasMore;
      ((RefreshLoadMoreLayout.c)localObject).Lrj = paramInt2;
      if (((RefreshLoadMoreLayout.c)localObject).Lrj > 0) {
        ((RefreshLoadMoreLayout.c)localObject).iLW = false;
      }
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.rTF;
      if (localRefreshLoadMoreLayout == null) {
        p.bcb("rlLayout");
      }
      localRefreshLoadMoreLayout.d((RefreshLoadMoreLayout.c)localObject);
      AppMethodBeat.o(203132);
      return;
      localObject = this.rPu;
      if (localObject != null) {
        ((WxRecyclerAdapter)localObject).notifyDataSetChanged();
      }
    }
    Object localObject = this.rTF;
    if (localObject == null) {
      p.bcb("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).afY(0);
    if (!this.smj.hasMore)
    {
      localObject = this.rTF;
      if (localObject == null) {
        p.bcb("rlLayout");
      }
      RefreshLoadMoreLayout.f((RefreshLoadMoreLayout)localObject);
    }
    AppMethodBeat.o(203132);
  }
  
  public final MMActivity getActivity()
  {
    return this.activity;
  }
  
  public final boolean r(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(203136);
    ad.i(this.TAG, "[onOverStart] dy=".concat(String.valueOf(paramInt1)));
    MMProcessBar localMMProcessBar = this.sai;
    if (localMMProcessBar == null) {
      p.bcb("rlProcessBar");
    }
    float f = paramInt1;
    Context localContext = aj.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    localMMProcessBar.rotate(f / (int)localContext.getResources().getDimension(2131165288));
    AppMethodBeat.o(203136);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract.FollowListViewCallback
 * JD-Core Version:    0.7.0.1
 */