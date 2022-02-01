package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
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
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.mm.view.HeadFooterLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.g.d;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "isFromTeenModeSettingPage", "", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListPresent;", "getLayoutId", "", "initDataFromIntent", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class FinderFollowListUIC
  extends UIComponent
{
  private static final String uWR = "followList.fp";
  public static final a wwp;
  private final FinderFollowListContract.FollowListPresent uWL;
  private boolean uWM;
  
  static
  {
    AppMethodBeat.i(255533);
    wwp = new a((byte)0);
    uWR = "followList.fp";
    AppMethodBeat.o(255533);
  }
  
  public FinderFollowListUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255532);
    this.uWL = new FinderFollowListContract.FollowListPresent();
    AppMethodBeat.o(255532);
  }
  
  public final int getLayoutId()
  {
    return 2131494317;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255528);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle != null) {}
    for (paramBundle = Boolean.valueOf(paramBundle.getBooleanExtra("from_teen_mode_setting_page", false));; paramBundle = null)
    {
      this.uWM = paramBundle.booleanValue();
      Log.i("Finder.FinderFollowListUIC", "initDataFromIntent, isFromTeenModeSettingPage:" + this.uWM);
      paramBundle = getActivity();
      if (paramBundle != null) {
        break;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255528);
      throw paramBundle;
    }
    paramBundle = new FinderFollowListContract.FollowListViewCallback((MMActivity)paramBundle, getRootView(), this.uWL, this.uWM);
    this.uWL.a(paramBundle);
    Object localObject = paramBundle.contentView.findViewById(2131307118);
    p.g(localObject, "contentView.findViewById(R.id.rl_layout)");
    paramBundle.tLS = ((RefreshLoadMoreLayout)localObject);
    localObject = paramBundle.tLS;
    if (localObject == null) {
      p.btv("rlLayout");
    }
    Context localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    int i = (int)localContext.getResources().getDimension(2131166379);
    localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject).setLimitTopRequest(i - (int)localContext.getResources().getDimension(2131165281));
    localObject = paramBundle.tLS;
    if (localObject == null) {
      p.btv("rlLayout");
    }
    localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    i = (int)localContext.getResources().getDimension(2131165310);
    localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject).setRefreshTargetY(i - (int)localContext.getResources().getDimension(2131166379));
    localObject = paramBundle.tLS;
    if (localObject == null) {
      p.btv("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).setDamping(1.85F);
    localObject = paramBundle.contentView.findViewById(2131307120);
    p.g(localObject, "contentView.findViewById…ar>(R.id.rl_loading_icon)");
    paramBundle.tSY = ((MMProcessBar)localObject);
    localObject = paramBundle.tLS;
    if (localObject == null) {
      p.btv("rlLayout");
    }
    paramBundle.hak = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
    localObject = paramBundle.hak;
    if (localObject == null) {
      p.btv("recyclerView");
    }
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramBundle.tFp = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new FinderFollowListContract.FollowListViewCallback.initView.1(paramBundle), paramBundle.uWL.kgc, true);
    localObject = paramBundle.hak;
    if (localObject == null) {
      p.btv("recyclerView");
    }
    ((RecyclerView)localObject).setAdapter((RecyclerView.a)paramBundle.tFp);
    localObject = paramBundle.tFp;
    if (localObject == null) {
      p.hyc();
    }
    ((com.tencent.mm.view.recyclerview.g)localObject).RqP = ((g.c)new FinderFollowListContract.FollowListViewCallback.initView.2(paramBundle));
    localObject = paramBundle.tFp;
    if (localObject == null) {
      p.hyc();
    }
    ((com.tencent.mm.view.recyclerview.g)localObject).RqO = ((g.d)new FinderFollowListContract.FollowListViewCallback.initView.3(paramBundle));
    localObject = paramBundle.tLS;
    if (localObject == null) {
      p.btv("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).setOverCallback((HeadFooterLayout.b)paramBundle);
    localObject = paramBundle.tLS;
    if (localObject == null) {
      p.btv("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).setActionCallback((RefreshLoadMoreLayout.a)new FinderFollowListContract.FollowListViewCallback.initView.4(paramBundle));
    localObject = paramBundle.contentView.findViewById(2131300101);
    p.g(localObject, "contentView.findViewById<TextView>(R.id.empty_tip)");
    paramBundle.hRM = ((TextView)localObject);
    paramBundle.dlR();
    paramBundle.pqr = new a((Context)paramBundle.activity);
    paramBundle.activity.setBackBtn((MenuItem.OnMenuItemClickListener)new FinderFollowListContract.FollowListViewCallback.initView.5(paramBundle));
    localObject = paramBundle.uWL;
    d.b(d.a(d.aBx(), (b)new FinderFollowListContract.FollowListPresent.loadStart.1((FinderFollowListContract.FollowListPresent)localObject)), (b)new FinderFollowListContract.FollowListPresent.loadStart.2((FinderFollowListContract.FollowListPresent)localObject));
    ((FinderFollowListContract.FollowListPresent)localObject).nO(false);
    localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (com.tencent.mm.plugin.finder.storage.c.drt())
    {
      localObject = com.tencent.mm.kernel.g.af(ad.class);
      p.g(localObject, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if (!((ad)localObject).dxX()) {
        paramBundle.activity.addIconOptionMenu(0, 2131690901, (MenuItem.OnMenuItemClickListener)new FinderFollowListContract.FollowListViewCallback.initView.6(paramBundle));
      }
    }
    localObject = paramBundle.hak;
    if (localObject == null) {
      p.btv("recyclerView");
    }
    ((RecyclerView)localObject).a((RecyclerView.l)paramBundle.uWK);
    AppMethodBeat.o(255528);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(255529);
    super.onDestroy();
    this.uWL.onDetach();
    AppMethodBeat.o(255529);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(255531);
    super.onPause();
    k localk = k.vkd;
    k.b(null, s.p.voz, "12", com.tencent.mm.plugin.finder.report.live.c.vjg);
    AppMethodBeat.o(255531);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(255530);
    super.onResume();
    k localk = k.vkd;
    k.b(null, s.p.voz, "12", com.tencent.mm.plugin.finder.report.live.c.vjf);
    AppMethodBeat.o(255530);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListUIC$Companion;", "", "()V", "FIRST_PAGE_FILE_NAME", "", "getFIRST_PAGE_FILE_NAME", "()Ljava/lang/String;", "TAG", "transformToLocalContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "fcontact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "plugin-finder_release"})
  public static final class a
  {
    public static com.tencent.mm.plugin.finder.api.g f(FinderContact paramFinderContact)
    {
      AppMethodBeat.i(255527);
      p.h(paramFinderContact, "fcontact");
      com.tencent.mm.plugin.finder.api.g localg = new com.tencent.mm.plugin.finder.api.g();
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
      localg.asL(str1);
      str2 = paramFinderContact.nickname;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localg.setNickname(str1);
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
      localg.field_pyInitial = com.tencent.mm.platformtools.f.Si(str1);
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
      localg.field_liveCoverImg = paramFinderContact.liveCoverImgUrl;
      localg.field_liveStatus = paramFinderContact.liveStatus;
      AppMethodBeat.o(255527);
      return localg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderFollowListUIC
 * JD-Core Version:    0.7.0.1
 */