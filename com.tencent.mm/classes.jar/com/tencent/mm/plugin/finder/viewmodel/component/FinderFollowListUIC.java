package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract.FollowListPresent;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract.FollowListPresent.loadStart.1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract.FollowListPresent.loadStart.2;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract.FollowListViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract.FollowListViewCallback.initView.1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract.FollowListViewCallback.initView.2;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract.FollowListViewCallback.initView.3;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract.FollowListViewCallback.initView.4;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract.FollowListViewCallback.initView.5;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract.FollowListViewCallback.initView.6;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.mm.view.HeadFooterLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d;
import com.tencent.mm.view.recyclerview.d.c;
import com.tencent.mm.view.recyclerview.d.d;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListPresent;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"})
public final class FinderFollowListUIC
  extends UIComponent
{
  private static final String sNs = "followList.fp";
  public static final FinderFollowListUIC.a tmn;
  private final FinderFollowListContract.FollowListPresent swa;
  
  static
  {
    AppMethodBeat.i(206162);
    tmn = new FinderFollowListUIC.a((byte)0);
    sNs = "followList.fp";
    AppMethodBeat.o(206162);
  }
  
  public FinderFollowListUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(206161);
    this.swa = new FinderFollowListContract.FollowListPresent();
    AppMethodBeat.o(206161);
  }
  
  public final int getLayoutId()
  {
    return 2131496391;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(206159);
    super.onCreate(paramBundle);
    paramBundle = new FinderFollowListContract.FollowListViewCallback(getActivity(), getRootView(), this.swa);
    this.swa.a(paramBundle);
    Object localObject = paramBundle.contentView.findViewById(2131304203);
    p.g(localObject, "contentView.findViewById(R.id.rl_layout)");
    paramBundle.scj = ((RefreshLoadMoreLayout)localObject);
    localObject = paramBundle.scj;
    if (localObject == null) {
      p.bdF("rlLayout");
    }
    Context localContext = ak.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    int i = (int)localContext.getResources().getDimension(2131166300);
    localContext = ak.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject).setLimitTopRequest(i - (int)localContext.getResources().getDimension(2131165277));
    localObject = paramBundle.scj;
    if (localObject == null) {
      p.bdF("rlLayout");
    }
    localContext = ak.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    i = (int)localContext.getResources().getDimension(2131165299);
    localContext = ak.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject).setRefreshTargetY(i - (int)localContext.getResources().getDimension(2131166300));
    localObject = paramBundle.scj;
    if (localObject == null) {
      p.bdF("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).setDamping(1.85F);
    localObject = paramBundle.contentView.findViewById(2131304204);
    p.g(localObject, "contentView.findViewById…ar>(R.id.rl_loading_icon)");
    paramBundle.siX = ((MMProcessBar)localObject);
    localObject = paramBundle.scj;
    if (localObject == null) {
      p.bdF("rlLayout");
    }
    paramBundle.gpr = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
    localObject = paramBundle.gpr;
    if (localObject == null) {
      p.bdF("recyclerView");
    }
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    paramBundle.rXV = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new FinderFollowListContract.FollowListViewCallback.initView.1(), paramBundle.swa.jhZ, true);
    localObject = paramBundle.gpr;
    if (localObject == null) {
      p.bdF("recyclerView");
    }
    ((RecyclerView)localObject).setAdapter((RecyclerView.a)paramBundle.rXV);
    localObject = paramBundle.rXV;
    if (localObject == null) {
      p.gkB();
    }
    ((d)localObject).LRY = ((d.c)new FinderFollowListContract.FollowListViewCallback.initView.2(paramBundle));
    localObject = paramBundle.rXV;
    if (localObject == null) {
      p.gkB();
    }
    ((d)localObject).LRX = ((d.d)new FinderFollowListContract.FollowListViewCallback.initView.3(paramBundle));
    localObject = paramBundle.scj;
    if (localObject == null) {
      p.bdF("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).setOverCallback((HeadFooterLayout.b)paramBundle);
    localObject = paramBundle.scj;
    if (localObject == null) {
      p.bdF("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).setActionCallback((RefreshLoadMoreLayout.a)new FinderFollowListContract.FollowListViewCallback.initView.4(paramBundle));
    localObject = paramBundle.contentView.findViewById(2131299472);
    p.g(localObject, "contentView.findViewById<TextView>(R.id.empty_tip)");
    paramBundle.gYR = ((TextView)localObject);
    paramBundle.cEW();
    paramBundle.ofu = new a((Context)paramBundle.activity);
    paramBundle.activity.setBackBtn((MenuItem.OnMenuItemClickListener)new FinderFollowListContract.FollowListViewCallback.initView.5(paramBundle));
    localObject = paramBundle.swa;
    com.tencent.mm.ac.c.b(com.tencent.mm.ac.c.a(com.tencent.mm.ac.c.ale(), (d.g.a.b)new FinderFollowListContract.FollowListPresent.loadStart.1((FinderFollowListContract.FollowListPresent)localObject)), (d.g.a.b)new FinderFollowListContract.FollowListPresent.loadStart.2((FinderFollowListContract.FollowListPresent)localObject));
    ((FinderFollowListContract.FollowListPresent)localObject).lY(false);
    localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (com.tencent.mm.plugin.finder.storage.b.cHJ()) {
      paramBundle.activity.addIconOptionMenu(0, 2131690649, (MenuItem.OnMenuItemClickListener)new FinderFollowListContract.FollowListViewCallback.initView.6(paramBundle));
    }
    AppMethodBeat.o(206159);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(206160);
    super.onDestroy();
    this.swa.onDetach();
    AppMethodBeat.o(206160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderFollowListUIC
 * JD-Core Version:    0.7.0.1
 */