package com.tencent.mm.plugin.finder.nearby.live.square.page;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.nearby.live.b.a;
import com.tencent.mm.plugin.finder.nearby.live.b.b;
import com.tencent.mm.plugin.finder.nearby.trace.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/page/NearbyLiveSquareTabUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "isForceNightMode", "", "liveFriendsCallback", "Lcom/tencent/mm/plugin/finder/nearby/live/square/page/NearbyLiveSquareTabViewCallback;", "liveFriendsPresenter", "Lcom/tencent/mm/plugin/finder/nearby/live/square/page/NearbyLiveSquareTabPresenter;", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getLayoutId", "", "getTabInfo", "onActionbarClick", "", "onActionbarDoubleClick", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStart", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder-nearby_release"})
public final class c
  extends UIComponent
{
  public static final a zGF;
  private boolean xnL;
  private bcz zDU;
  b zGD;
  private d zGE;
  
  static
  {
    AppMethodBeat.i(201676);
    zGF = new a((byte)0);
    AppMethodBeat.o(201676);
  }
  
  public c(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(201674);
    AppMethodBeat.o(201674);
  }
  
  public final int getLayoutId()
  {
    return f.e.zDk;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(201673);
    p.k(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    d locald = this.zGE;
    if (locald == null) {
      p.bGy("liveFriendsCallback");
    }
    locald.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(201673);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(201647);
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if ((paramBundle != null) && (paramBundle.getInt("key_use_dark_style", 1) == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      this.xnL = bool;
      paramBundle = getArguments();
      if (paramBundle != null)
      {
        localObject1 = paramBundle.getString("key_by_pass");
        paramBundle = (Bundle)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        paramBundle = "";
      }
      p.j(paramBundle, "getArguments()?.getStrin…tionUI.KEY_BY_PASS) ?: \"\"");
      localObject1 = getArguments();
      if (localObject1 == null) {
        break label341;
      }
      localObject1 = ((Bundle)localObject1).getByteArray("nearby_live_square_tab_info_key");
      if (localObject1 == null) {
        break label341;
      }
      localObject1 = new bcz().parseFrom((byte[])localObject1);
      if (localObject1 != null) {
        break;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveTabInfo");
      AppMethodBeat.o(201647);
      throw paramBundle;
    }
    Object localObject1 = (bcz)localObject1;
    this.zDU = ((bcz)localObject1);
    localObject1 = getArguments();
    if (localObject1 != null)
    {
      bool = ((Bundle)localObject1).getBoolean("nearby_live_target_auto_refresh_params_key", false);
      label153:
      localObject1 = getArguments();
      if (localObject1 == null) {
        break label351;
      }
      localObject1 = ((Bundle)localObject1).getByteArray("nearby_live_target_last_buffer_params_key");
      label169:
      localObject3 = new StringBuilder("onCreate(), tab:");
      localObject2 = this.zDU;
      if (localObject2 == null) {
        break label356;
      }
    }
    label341:
    label351:
    label356:
    for (Object localObject2 = ((bcz)localObject2).SOb;; localObject2 = null)
    {
      Log.i("NearbyLiveSquareTabUIC", (String)localObject2 + " targetPageForceRefreshFlag:" + bool + " targetTabPageLastBuffer:" + localObject1);
      localObject2 = com.tencent.mm.plugin.finder.nearby.trace.c.zJD;
      com.tencent.mm.plugin.finder.nearby.trace.c.dMD().aGV("livePageOnCreate");
      localObject2 = getFragment();
      if (localObject2 != null)
      {
        localObject3 = g.Xox;
        localObject3 = ((aj)g.h((Fragment)localObject2).i(aj.class)).ekY();
        localObject2 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject2 = g.Xox;
        localObject2 = ((aj)g.b(getActivity()).i(aj.class)).ekY();
      }
      localObject3 = getActivity();
      if (localObject3 != null) {
        break label362;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(201647);
      throw paramBundle;
      localObject1 = null;
      break;
      bool = false;
      break label153;
      localObject1 = null;
      break label169;
    }
    label362:
    Object localObject3 = (MMActivity)localObject3;
    Object localObject4 = getFragment();
    if (localObject4 == null) {
      p.iCn();
    }
    this.zGD = new b((MMActivity)localObject3, (Fragment)localObject4, (bid)localObject2, this.zDU, paramBundle);
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(201647);
      throw paramBundle;
    }
    paramBundle = (MMActivity)paramBundle;
    localObject3 = getFragment();
    if (localObject3 == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment");
      AppMethodBeat.o(201647);
      throw paramBundle;
    }
    localObject3 = (AbsNearByFragment)localObject3;
    localObject4 = this.zGD;
    if (localObject4 == null) {
      p.bGy("liveFriendsPresenter");
    }
    this.zGE = new d(paramBundle, (AbsNearByFragment)localObject3, (b.a)localObject4, getRootView(), (bid)localObject2, this.xnL);
    localObject2 = this.zGD;
    if (localObject2 == null) {
      p.bGy("liveFriendsPresenter");
    }
    paramBundle = this.zGE;
    if (paramBundle == null) {
      p.bGy("liveFriendsCallback");
    }
    localObject3 = (b.b)paramBundle;
    if (localObject1 != null) {}
    for (paramBundle = new com.tencent.mm.cd.b((byte[])localObject1);; paramBundle = null)
    {
      ((b)localObject2).a((b.b)localObject3, bool, paramBundle);
      AppMethodBeat.o(201647);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(201672);
    super.onDestroy();
    StringBuilder localStringBuilder = new StringBuilder("onDestroy() tab:");
    Object localObject = this.zDU;
    if (localObject != null) {}
    for (localObject = ((bcz)localObject).SOb;; localObject = null)
    {
      Log.i("NearbyLiveSquareTabUIC", (String)localObject);
      localObject = this.zGD;
      if (localObject == null) {
        p.bGy("liveFriendsPresenter");
      }
      if (localObject != null) {
        ((b)localObject).onFinishing();
      }
      localObject = this.zGD;
      if (localObject == null) {
        p.bGy("liveFriendsPresenter");
      }
      if (localObject == null) {
        break;
      }
      ((b)localObject).onDetach();
      AppMethodBeat.o(201672);
      return;
    }
    AppMethodBeat.o(201672);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(201661);
    super.onPause();
    StringBuilder localStringBuilder = new StringBuilder("onPause() tab:");
    Object localObject = this.zDU;
    if (localObject != null) {}
    for (localObject = ((bcz)localObject).SOb;; localObject = null)
    {
      Log.i("NearbyLiveSquareTabUIC", (String)localObject);
      localObject = k.yBj;
      localObject = this.zGE;
      if (localObject == null) {
        p.bGy("liveFriendsCallback");
      }
      k.a(((d)localObject).getRecyclerView(), s.t.yGN, "80", com.tencent.mm.plugin.finder.live.report.c.yAj, -100, -100);
      AppMethodBeat.o(201661);
      return;
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(201656);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    b localb = this.zGD;
    if (localb == null) {
      p.bGy("liveFriendsPresenter");
    }
    localb.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(201656);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(201654);
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder("onResume() tab:");
    Object localObject = this.zDU;
    if (localObject != null) {}
    for (localObject = ((bcz)localObject).SOb;; localObject = null)
    {
      Log.i("NearbyLiveSquareTabUIC", (String)localObject);
      localObject = k.yBj;
      localObject = this.zGE;
      if (localObject == null) {
        p.bGy("liveFriendsCallback");
      }
      k.a(((d)localObject).getRecyclerView(), s.t.yGN, "80", com.tencent.mm.plugin.finder.live.report.c.yAi, -100, -100);
      AppMethodBeat.o(201654);
      return;
    }
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(201650);
    super.onStart();
    StringBuilder localStringBuilder = new StringBuilder("onStart() tab:");
    Object localObject = this.zDU;
    if (localObject != null) {}
    for (localObject = ((bcz)localObject).SOb;; localObject = null)
    {
      Log.i("NearbyLiveSquareTabUIC", (String)localObject);
      localObject = this.zGD;
      if (localObject == null) {
        p.bGy("liveFriendsPresenter");
      }
      ((b)localObject).onStart();
      AppMethodBeat.o(201650);
      return;
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(201663);
    super.onStop();
    StringBuilder localStringBuilder = new StringBuilder("onStop() tab:");
    Object localObject = this.zDU;
    if (localObject != null) {}
    for (localObject = ((bcz)localObject).SOb;; localObject = null)
    {
      Log.i("NearbyLiveSquareTabUIC", (String)localObject);
      localObject = this.zGD;
      if (localObject == null) {
        p.bGy("liveFriendsPresenter");
      }
      ((b)localObject).onStop();
      AppMethodBeat.o(201663);
      return;
    }
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(201667);
    super.onUserVisibleFocused();
    StringBuilder localStringBuilder = new StringBuilder("onUserVisibleFocused() tab:");
    Object localObject = this.zDU;
    if (localObject != null) {}
    for (localObject = ((bcz)localObject).SOb;; localObject = null)
    {
      Log.i("NearbyLiveSquareTabUIC", (String)localObject);
      localObject = g.Xox;
      ((as)g.bD(PluginFinder.class).i(as.class)).Q((kotlin.g.a.b)c.b.zGG);
      localObject = this.zGD;
      if (localObject == null) {
        p.bGy("liveFriendsPresenter");
      }
      if (localObject == null) {
        break;
      }
      ((b)localObject).onUserVisibleFocused();
      AppMethodBeat.o(201667);
      return;
    }
    AppMethodBeat.o(201667);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(201669);
    super.onUserVisibleUnFocused();
    StringBuilder localStringBuilder = new StringBuilder("onUserVisibleUnFocused() tab:");
    Object localObject = this.zDU;
    if (localObject != null) {}
    for (localObject = ((bcz)localObject).SOb;; localObject = null)
    {
      Log.i("NearbyLiveSquareTabUIC", (String)localObject);
      localObject = this.zGD;
      if (localObject == null) {
        p.bGy("liveFriendsPresenter");
      }
      if (localObject == null) {
        break;
      }
      ((b)localObject).onUserVisibleUnFocused();
      AppMethodBeat.o(201669);
      return;
    }
    AppMethodBeat.o(201669);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/page/NearbyLiveSquareTabUIC$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.page.c
 * JD-Core Version:    0.7.0.1
 */