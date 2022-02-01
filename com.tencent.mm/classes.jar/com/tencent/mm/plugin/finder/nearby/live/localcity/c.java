package com.tencent.mm.plugin.finder.nearby.live.localcity;

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
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/localcity/NearbyLocalCityUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "liveFriendsCallback", "Lcom/tencent/mm/plugin/finder/nearby/live/localcity/NearbyLiveLocalCityViewCallback;", "liveFriendsPresenter", "Lcom/tencent/mm/plugin/finder/nearby/live/localcity/NearbyLiveLocalCityPresenter;", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getLayoutId", "", "getTabInfo", "onActionbarClick", "", "onActionbarDoubleClick", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder-nearby_release"})
public final class c
  extends UIComponent
{
  public static final a zFb;
  private bcz zDU;
  a zEZ;
  private b zFa;
  
  static
  {
    AppMethodBeat.i(201886);
    zFb = new a((byte)0);
    AppMethodBeat.o(201886);
  }
  
  public c(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(201885);
    AppMethodBeat.o(201885);
  }
  
  public final int getLayoutId()
  {
    return f.e.zDk;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(201884);
    p.k(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    b localb = this.zFa;
    if (localb == null) {
      p.bGy("liveFriendsCallback");
    }
    localb.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(201884);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(201859);
    super.onCreate(paramBundle);
    this.zDU = new bcz();
    paramBundle = this.zDU;
    if (paramBundle != null) {
      paramBundle.SOb = "同城直播";
    }
    paramBundle = this.zDU;
    if (paramBundle != null) {
      paramBundle.SOa = 88889;
    }
    Object localObject1 = new StringBuilder("onCreate(), tab:");
    paramBundle = this.zDU;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.SOb;; paramBundle = null)
    {
      Log.i("NearbyLiveSquareTabUIC", paramBundle);
      paramBundle = com.tencent.mm.plugin.finder.nearby.trace.c.zJD;
      com.tencent.mm.plugin.finder.nearby.trace.c.dMD().aGV("livePageOnCreate");
      paramBundle = getFragment();
      if (paramBundle != null)
      {
        localObject1 = g.Xox;
        localObject1 = ((aj)g.h(paramBundle).i(aj.class)).ekY();
        paramBundle = (Bundle)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        paramBundle = g.Xox;
        paramBundle = ((aj)g.b(getActivity()).i(aj.class)).ekY();
      }
      localObject1 = getActivity();
      if (localObject1 != null) {
        break;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(201859);
      throw paramBundle;
    }
    localObject1 = (MMActivity)localObject1;
    Object localObject2 = getFragment();
    if (localObject2 == null) {
      p.iCn();
    }
    this.zEZ = new a((MMActivity)localObject1, (Fragment)localObject2, paramBundle, this.zDU);
    localObject1 = getActivity();
    if (localObject1 == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(201859);
      throw paramBundle;
    }
    localObject1 = (MMActivity)localObject1;
    localObject2 = getFragment();
    if (localObject2 == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment");
      AppMethodBeat.o(201859);
      throw paramBundle;
    }
    localObject2 = (AbsNearByFragment)localObject2;
    a locala = this.zEZ;
    if (locala == null) {
      p.bGy("liveFriendsPresenter");
    }
    this.zFa = new b((MMActivity)localObject1, (AbsNearByFragment)localObject2, (b.a)locala, getRootView(), paramBundle);
    paramBundle = this.zEZ;
    if (paramBundle == null) {
      p.bGy("liveFriendsPresenter");
    }
    localObject1 = this.zFa;
    if (localObject1 == null) {
      p.bGy("liveFriendsCallback");
    }
    paramBundle.a((b.b)localObject1);
    AppMethodBeat.o(201859);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(201881);
    super.onDestroy();
    StringBuilder localStringBuilder = new StringBuilder("onDestroy() tab:");
    Object localObject = this.zDU;
    if (localObject != null) {}
    for (localObject = ((bcz)localObject).SOb;; localObject = null)
    {
      Log.i("NearbyLiveSquareTabUIC", (String)localObject);
      localObject = this.zEZ;
      if (localObject == null) {
        p.bGy("liveFriendsPresenter");
      }
      if (localObject != null) {
        ((a)localObject).onFinishing();
      }
      localObject = this.zEZ;
      if (localObject == null) {
        p.bGy("liveFriendsPresenter");
      }
      if (localObject == null) {
        break;
      }
      ((a)localObject).onDetach();
      AppMethodBeat.o(201881);
      return;
    }
    AppMethodBeat.o(201881);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(201866);
    super.onPause();
    Object localObject = k.yBj;
    localObject = this.zFa;
    if (localObject == null) {
      p.bGy("liveFriendsCallback");
    }
    k.a(((b)localObject).getRecyclerView(), s.t.yGN, "80", com.tencent.mm.plugin.finder.live.report.c.yAj, -100, -100);
    AppMethodBeat.o(201866);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(201863);
    super.onResume();
    Object localObject = k.yBj;
    localObject = this.zFa;
    if (localObject == null) {
      p.bGy("liveFriendsCallback");
    }
    k.a(((b)localObject).getRecyclerView(), s.t.yGN, "80", com.tencent.mm.plugin.finder.live.report.c.yAi, -100, -100);
    AppMethodBeat.o(201863);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(201862);
    super.onStart();
    StringBuilder localStringBuilder = new StringBuilder("onStart() tab:");
    Object localObject = this.zDU;
    if (localObject != null) {}
    for (localObject = ((bcz)localObject).SOb;; localObject = null)
    {
      Log.i("NearbyLiveSquareTabUIC", (String)localObject);
      localObject = this.zEZ;
      if (localObject == null) {
        p.bGy("liveFriendsPresenter");
      }
      ((a)localObject).onStart();
      AppMethodBeat.o(201862);
      return;
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(201870);
    super.onStop();
    StringBuilder localStringBuilder = new StringBuilder("onStop() tab:");
    Object localObject = this.zDU;
    if (localObject != null) {}
    for (localObject = ((bcz)localObject).SOb;; localObject = null)
    {
      Log.i("NearbyLiveSquareTabUIC", (String)localObject);
      localObject = this.zEZ;
      if (localObject == null) {
        p.bGy("liveFriendsPresenter");
      }
      ((a)localObject).onStop();
      AppMethodBeat.o(201870);
      return;
    }
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(201873);
    super.onUserVisibleFocused();
    StringBuilder localStringBuilder = new StringBuilder("onUserVisibleFocused() tab:");
    Object localObject = this.zDU;
    if (localObject != null) {}
    for (localObject = ((bcz)localObject).SOb;; localObject = null)
    {
      Log.i("NearbyLiveSquareTabUIC", (String)localObject);
      localObject = g.Xox;
      ((as)g.bD(PluginFinder.class).i(as.class)).Q((kotlin.g.a.b)c.b.zFc);
      localObject = this.zEZ;
      if (localObject == null) {
        p.bGy("liveFriendsPresenter");
      }
      if (localObject == null) {
        break;
      }
      ((a)localObject).onUserVisibleFocused();
      AppMethodBeat.o(201873);
      return;
    }
    AppMethodBeat.o(201873);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(201877);
    super.onUserVisibleUnFocused();
    StringBuilder localStringBuilder = new StringBuilder("onUserVisibleUnFocused() tab:");
    Object localObject = this.zDU;
    if (localObject != null) {}
    for (localObject = ((bcz)localObject).SOb;; localObject = null)
    {
      Log.i("NearbyLiveSquareTabUIC", (String)localObject);
      localObject = this.zEZ;
      if (localObject == null) {
        p.bGy("liveFriendsPresenter");
      }
      if (localObject == null) {
        break;
      }
      ((a)localObject).onUserVisibleUnFocused();
      AppMethodBeat.o(201877);
      return;
    }
    AppMethodBeat.o(201877);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/localcity/NearbyLocalCityUIC$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.localcity.c
 * JD-Core Version:    0.7.0.1
 */