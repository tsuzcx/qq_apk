package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.live.report.c;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.t;
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
import com.tencent.mm.plugin.findersdk.a.ae;
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
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.h.d;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "isFromTeenModeSettingPage", "", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListPresent;", "getLayoutId", "", "initDataFromIntent", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class w
  extends UIComponent
{
  public static final a Bkt;
  private static final String zNg = "followList.fp";
  private final FinderFollowListContract.FollowListPresent zMZ;
  private boolean zNa;
  
  static
  {
    AppMethodBeat.i(224443);
    Bkt = new a((byte)0);
    zNg = "followList.fp";
    AppMethodBeat.o(224443);
  }
  
  public w(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(224441);
    this.zMZ = new FinderFollowListContract.FollowListPresent();
    AppMethodBeat.o(224441);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_follow_list_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(224435);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle != null) {}
    for (paramBundle = Boolean.valueOf(paramBundle.getBooleanExtra("from_teen_mode_setting_page", false));; paramBundle = null)
    {
      this.zNa = paramBundle.booleanValue();
      Log.i("Finder.FinderFollowListUIC", "initDataFromIntent, isFromTeenModeSettingPage:" + this.zNa);
      paramBundle = getActivity();
      if (paramBundle != null) {
        break;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(224435);
      throw paramBundle;
    }
    paramBundle = new FinderFollowListContract.FollowListViewCallback((MMActivity)paramBundle, getRootView(), this.zMZ, this.zNa);
    this.zMZ.a(paramBundle);
    Object localObject = paramBundle.contentView.findViewById(b.f.rl_layout);
    p.j(localObject, "contentView.findViewById(R.id.rl_layout)");
    paramBundle.xvJ = ((RefreshLoadMoreLayout)localObject);
    localObject = paramBundle.xvJ;
    if (localObject == null) {
      p.bGy("rlLayout");
    }
    Context localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    int i = (int)localContext.getResources().getDimension(b.d.finder_timeline_refresh_height);
    localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject).setLimitTopRequest(i - (int)localContext.getResources().getDimension(b.d.Edge_12A));
    localObject = paramBundle.xvJ;
    if (localObject == null) {
      p.bGy("rlLayout");
    }
    localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    i = (int)localContext.getResources().getDimension(b.d.Edge_7A);
    localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject).setRefreshTargetY(i - (int)localContext.getResources().getDimension(b.d.finder_timeline_refresh_height));
    localObject = paramBundle.xvJ;
    if (localObject == null) {
      p.bGy("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).setDamping(1.85F);
    localObject = paramBundle.contentView.findViewById(b.f.rl_loading_icon);
    p.j(localObject, "contentView.findViewById…ar>(R.id.rl_loading_icon)");
    paramBundle.xDP = ((MMProcessBar)localObject);
    localObject = paramBundle.xvJ;
    if (localObject == null) {
      p.bGy("rlLayout");
    }
    paramBundle.jLl = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
    localObject = paramBundle.jLl;
    if (localObject == null) {
      p.bGy("recyclerView");
    }
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramBundle.xnR = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new FinderFollowListContract.FollowListViewCallback.initView.1(paramBundle), paramBundle.zMZ.mXB, true);
    localObject = paramBundle.jLl;
    if (localObject == null) {
      p.bGy("recyclerView");
    }
    ((RecyclerView)localObject).setAdapter((RecyclerView.a)paramBundle.xnR);
    localObject = paramBundle.xnR;
    if (localObject == null) {
      p.iCn();
    }
    ((com.tencent.mm.view.recyclerview.h)localObject).YSn = ((h.c)new FinderFollowListContract.FollowListViewCallback.initView.2(paramBundle));
    localObject = paramBundle.xnR;
    if (localObject == null) {
      p.iCn();
    }
    ((com.tencent.mm.view.recyclerview.h)localObject).YSm = ((h.d)new FinderFollowListContract.FollowListViewCallback.initView.3(paramBundle));
    localObject = paramBundle.xvJ;
    if (localObject == null) {
      p.bGy("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).setOverCallback((HeadFooterLayout.b)paramBundle);
    localObject = paramBundle.xvJ;
    if (localObject == null) {
      p.bGy("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).setActionCallback((RefreshLoadMoreLayout.a)new FinderFollowListContract.FollowListViewCallback.initView.4(paramBundle));
    localObject = paramBundle.contentView.findViewById(b.f.empty_tip);
    p.j(localObject, "contentView.findViewById<TextView>(R.id.empty_tip)");
    paramBundle.kGj = ((TextView)localObject);
    paramBundle.dMV();
    paramBundle.szq = new a((Context)paramBundle.activity);
    paramBundle.activity.setBackBtn((MenuItem.OnMenuItemClickListener)new FinderFollowListContract.FollowListViewCallback.initView.5(paramBundle));
    localObject = paramBundle.zMZ;
    com.tencent.mm.ae.d.b(com.tencent.mm.ae.d.a(com.tencent.mm.ae.d.aJa(), (b)new FinderFollowListContract.FollowListPresent.loadStart.1((FinderFollowListContract.FollowListPresent)localObject)), (b)new FinderFollowListContract.FollowListPresent.loadStart.2((FinderFollowListContract.FollowListPresent)localObject));
    ((FinderFollowListContract.FollowListPresent)localObject).pY(false);
    localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (com.tencent.mm.plugin.finder.storage.d.dSI())
    {
      localObject = com.tencent.mm.kernel.h.ae(ae.class);
      p.j(localObject, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if (!((ae)localObject).dYT()) {
        paramBundle.activity.addIconOptionMenu(0, b.i.icons_outlined_search, (MenuItem.OnMenuItemClickListener)new FinderFollowListContract.FollowListViewCallback.initView.6(paramBundle));
      }
    }
    localObject = paramBundle.jLl;
    if (localObject == null) {
      p.bGy("recyclerView");
    }
    ((RecyclerView)localObject).a((RecyclerView.l)paramBundle.zMY);
    AppMethodBeat.o(224435);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(224436);
    super.onDestroy();
    this.zMZ.onDetach();
    AppMethodBeat.o(224436);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(224440);
    super.onPause();
    k localk = k.yBj;
    k.b(null, s.t.yGM, "12", c.yAj);
    AppMethodBeat.o(224440);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(224438);
    super.onResume();
    k localk = k.yBj;
    k.b(null, s.t.yGM, "12", c.yAi);
    AppMethodBeat.o(224438);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListUIC$Companion;", "", "()V", "FIRST_PAGE_FILE_NAME", "", "getFIRST_PAGE_FILE_NAME", "()Ljava/lang/String;", "TAG", "transformToLocalContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "fcontact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "plugin-finder_release"})
  public static final class a
  {
    public static i g(FinderContact paramFinderContact)
    {
      AppMethodBeat.i(291707);
      p.k(paramFinderContact, "fcontact");
      i locali = new i();
      String str2 = paramFinderContact.username;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      locali.setUsername(str1);
      str2 = paramFinderContact.headUrl;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      locali.aAS(str1);
      str2 = paramFinderContact.nickname;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      locali.setNickname(str1);
      locali.field_version = paramFinderContact.seq;
      str2 = paramFinderContact.signature;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      locali.field_signature = str1;
      locali.field_follow_Flag = paramFinderContact.followFlag;
      str2 = paramFinderContact.nickname;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      locali.field_pyInitial = com.tencent.mm.platformtools.f.ZK(str1);
      locali.field_followTime = paramFinderContact.followTime;
      str2 = paramFinderContact.coverImgUrl;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      locali.field_coverImg = str1;
      locali.field_spamStatus = paramFinderContact.spamStatus;
      locali.field_authInfo = paramFinderContact.authInfo;
      locali.field_extInfo = paramFinderContact.extInfo;
      locali.field_extFlag = paramFinderContact.extFlag;
      locali.field_liveCoverImg = paramFinderContact.liveCoverImgUrl;
      locali.field_liveStatus = paramFinderContact.liveStatus;
      locali.field_v5username = paramFinderContact.wx_username_v5;
      AppMethodBeat.o(291707);
      return locali;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.w
 * JD-Core Version:    0.7.0.1
 */