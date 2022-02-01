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
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.finder.api.g;
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
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.aj;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListPresent;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"})
public final class FinderFollowListUIC
  extends UIComponent
{
  private static final String sCt = "followList.fp";
  public static final a tby;
  private final FinderFollowListContract.FollowListPresent smj;
  
  static
  {
    AppMethodBeat.i(205552);
    tby = new a((byte)0);
    sCt = "followList.fp";
    AppMethodBeat.o(205552);
  }
  
  public FinderFollowListUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(205551);
    this.smj = new FinderFollowListContract.FollowListPresent();
    AppMethodBeat.o(205551);
  }
  
  public final int getLayoutId()
  {
    return 2131496391;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(205549);
    super.onCreate(paramBundle);
    paramBundle = new FinderFollowListContract.FollowListViewCallback(getActivity(), getRootView(), this.smj);
    this.smj.a(paramBundle);
    Object localObject = paramBundle.contentView.findViewById(2131304203);
    p.g(localObject, "contentView.findViewById(R.id.rl_layout)");
    paramBundle.rTF = ((RefreshLoadMoreLayout)localObject);
    localObject = paramBundle.rTF;
    if (localObject == null) {
      p.bcb("rlLayout");
    }
    Context localContext = aj.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    int i = (int)localContext.getResources().getDimension(2131166300);
    localContext = aj.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject).setLimitTopRequest(i - (int)localContext.getResources().getDimension(2131165277));
    localObject = paramBundle.rTF;
    if (localObject == null) {
      p.bcb("rlLayout");
    }
    localContext = aj.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    i = (int)localContext.getResources().getDimension(2131165299);
    localContext = aj.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject).setRefreshTargetY(i - (int)localContext.getResources().getDimension(2131166300));
    localObject = paramBundle.rTF;
    if (localObject == null) {
      p.bcb("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).setDamping(1.85F);
    localObject = paramBundle.contentView.findViewById(2131304204);
    p.g(localObject, "contentView.findViewById…ar>(R.id.rl_loading_icon)");
    paramBundle.sai = ((MMProcessBar)localObject);
    localObject = paramBundle.rTF;
    if (localObject == null) {
      p.bcb("rlLayout");
    }
    paramBundle.gmV = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
    localObject = paramBundle.gmV;
    if (localObject == null) {
      p.bcb("recyclerView");
    }
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    paramBundle.rPu = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new FinderFollowListContract.FollowListViewCallback.initView.1(), paramBundle.smj.jfg, true);
    localObject = paramBundle.gmV;
    if (localObject == null) {
      p.bcb("recyclerView");
    }
    ((RecyclerView)localObject).setAdapter((RecyclerView.a)paramBundle.rPu);
    localObject = paramBundle.rPu;
    if (localObject == null) {
      p.gfZ();
    }
    ((d)localObject).Lvl = ((d.c)new FinderFollowListContract.FollowListViewCallback.initView.2(paramBundle));
    localObject = paramBundle.rPu;
    if (localObject == null) {
      p.gfZ();
    }
    ((d)localObject).Lvk = ((d.d)new FinderFollowListContract.FollowListViewCallback.initView.3(paramBundle));
    localObject = paramBundle.rTF;
    if (localObject == null) {
      p.bcb("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).setOverCallback((HeadFooterLayout.b)paramBundle);
    localObject = paramBundle.rTF;
    if (localObject == null) {
      p.bcb("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).setActionCallback((RefreshLoadMoreLayout.a)new FinderFollowListContract.FollowListViewCallback.initView.4(paramBundle));
    localObject = paramBundle.contentView.findViewById(2131299472);
    p.g(localObject, "contentView.findViewById<TextView>(R.id.empty_tip)");
    paramBundle.gWe = ((TextView)localObject);
    paramBundle.cDe();
    paramBundle.nZK = new a((Context)paramBundle.activity);
    paramBundle.activity.setBackBtn((MenuItem.OnMenuItemClickListener)new FinderFollowListContract.FollowListViewCallback.initView.5(paramBundle));
    localObject = paramBundle.smj;
    com.tencent.mm.ad.c.b(com.tencent.mm.ad.c.a(com.tencent.mm.ad.c.akP(), (d.g.a.b)new FinderFollowListContract.FollowListPresent.loadStart.1((FinderFollowListContract.FollowListPresent)localObject)), (d.g.a.b)new FinderFollowListContract.FollowListPresent.loadStart.2((FinderFollowListContract.FollowListPresent)localObject));
    ((FinderFollowListContract.FollowListPresent)localObject).lX(false);
    localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (com.tencent.mm.plugin.finder.storage.b.cFM()) {
      paramBundle.activity.addIconOptionMenu(0, 2131690649, (MenuItem.OnMenuItemClickListener)new FinderFollowListContract.FollowListViewCallback.initView.6(paramBundle));
    }
    AppMethodBeat.o(205549);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(205550);
    super.onDestroy();
    this.smj.onDetach();
    AppMethodBeat.o(205550);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListUIC$Companion;", "", "()V", "FIRST_PAGE_FILE_NAME", "", "getFIRST_PAGE_FILE_NAME", "()Ljava/lang/String;", "transformToLocalContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "fcontact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "plugin-finder_release"})
  public static final class a
  {
    public static g d(FinderContact paramFinderContact)
    {
      AppMethodBeat.i(205548);
      p.h(paramFinderContact, "fcontact");
      g localg = new g();
      String str2 = paramFinderContact.username;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localg.setUsername(str1);
      str2 = paramFinderContact.headUrl;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localg.ahb(str1);
      str2 = paramFinderContact.nickname;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localg.sT(str1);
      localg.field_version = paramFinderContact.seq;
      str2 = paramFinderContact.signature;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localg.field_signature = str1;
      localg.field_follow_Flag = paramFinderContact.followFlag;
      str2 = paramFinderContact.nickname;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localg.field_pyInitial = f.IM(str1);
      localg.field_followTime = paramFinderContact.followTime;
      str2 = paramFinderContact.coverImgUrl;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localg.field_coverImg = str1;
      localg.field_spamStatus = paramFinderContact.spamStatus;
      localg.field_authInfo = paramFinderContact.authInfo;
      localg.field_extInfo = paramFinderContact.extInfo;
      localg.field_extFlag = paramFinderContact.extFlag;
      AppMethodBeat.o(205548);
      return localg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderFollowListUIC
 * JD-Core Version:    0.7.0.1
 */