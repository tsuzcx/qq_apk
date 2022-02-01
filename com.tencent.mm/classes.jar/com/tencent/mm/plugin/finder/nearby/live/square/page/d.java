package com.tencent.mm.plugin.finder.nearby.live.square.page;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.nearby.live.b.a;
import com.tencent.mm.plugin.finder.nearby.live.b.b;
import com.tencent.mm.plugin.finder.nearby.live.f;
import com.tencent.mm.plugin.finder.nearby.trace.a;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.be;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/page/NearbyLiveSquareTabUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "isForceNightMode", "", "liveFriendsCallback", "Lcom/tencent/mm/plugin/finder/nearby/live/square/page/NearbyLiveSquareTabViewCallback;", "liveFriendsPresenter", "Lcom/tencent/mm/plugin/finder/nearby/live/square/page/NearbyLiveSquareTabPresenter;", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getLayoutId", "", "getTabInfo", "onActionbarClick", "", "onActionbarDoubleClick", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStart", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends UIComponent
{
  public static final a ELX;
  private boolean ALp;
  private bnn EIq;
  c ELY;
  private e ELZ;
  
  static
  {
    AppMethodBeat.i(341305);
    ELX = new a((byte)0);
    AppMethodBeat.o(341305);
  }
  
  public d(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(341300);
    AppMethodBeat.o(341300);
  }
  
  public final int getLayoutId()
  {
    return f.e.EHd;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(341380);
    s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    e locale2 = this.ELZ;
    e locale1 = locale2;
    if (locale2 == null)
    {
      s.bIx("liveFriendsCallback");
      locale1 = null;
    }
    locale1.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(341380);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(341325);
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    boolean bool;
    label49:
    label60:
    label76:
    Object localObject2;
    label88:
    Object localObject3;
    if ((paramBundle != null) && (paramBundle.getInt("key_use_dark_style", 1) == 1))
    {
      bool = true;
      this.ALp = bool;
      paramBundle = getArguments();
      if (paramBundle != null) {
        break label277;
      }
      paramBundle = "";
      localObject1 = getArguments();
      if (localObject1 != null) {
        break label296;
      }
      localObject1 = null;
      this.EIq = ((bnn)localObject1);
      localObject1 = getArguments();
      if (localObject1 != null) {
        break label353;
      }
      bool = false;
      localObject1 = getArguments();
      if (localObject1 != null) {
        break label365;
      }
      localObject2 = null;
      localObject3 = new StringBuilder("onCreate(), tab:");
      localObject1 = this.EIq;
      if (localObject1 != null) {
        break label377;
      }
      localObject1 = null;
      label110:
      Log.i("NearbyLiveSquareTabUIC", localObject1 + " targetPageForceRefreshFlag:" + bool + " targetTabPageLastBuffer:" + localObject2);
      localObject1 = com.tencent.mm.plugin.finder.nearby.trace.c.ERD;
      com.tencent.mm.plugin.finder.nearby.trace.c.eGR().aDn("livePageOnCreate");
      localObject1 = getFragment();
      if (localObject1 != null) {
        break label385;
      }
    }
    Object localObject4;
    for (Object localObject1 = null;; localObject1 = ((as)k.y((Fragment)localObject1).q(as.class)).fou())
    {
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = k.aeZF;
        localObject3 = ((as)k.d(getActivity()).q(as.class)).fou();
      }
      localObject1 = (MMActivity)getActivity();
      localObject4 = getFragment();
      s.checkNotNull(localObject4);
      this.ELY = new c((MMActivity)localObject1, (Fragment)localObject4, (bui)localObject3, this.EIq, paramBundle);
      localObject4 = (MMActivity)getActivity();
      paramBundle = getFragment();
      if (paramBundle != null) {
        break label409;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment");
      AppMethodBeat.o(341325);
      throw paramBundle;
      bool = false;
      break;
      label277:
      localObject1 = paramBundle.getString("key_by_pass");
      paramBundle = (Bundle)localObject1;
      if (localObject1 != null) {
        break label49;
      }
      paramBundle = "";
      break label49;
      label296:
      localObject1 = ((Bundle)localObject1).getByteArray("nearby_live_square_tab_info_key");
      if (localObject1 == null)
      {
        localObject1 = null;
        break label60;
      }
      localObject1 = new bnn().parseFrom((byte[])localObject1);
      if (localObject1 == null)
      {
        paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveTabInfo");
        AppMethodBeat.o(341325);
        throw paramBundle;
      }
      localObject1 = (bnn)localObject1;
      break label60;
      label353:
      bool = ((Bundle)localObject1).getBoolean("nearby_live_target_auto_refresh_params_key", false);
      break label76;
      label365:
      localObject2 = ((Bundle)localObject1).getByteArray("nearby_live_target_last_buffer_params_key");
      break label88;
      label377:
      localObject1 = ((bnn)localObject1).ZWa;
      break label110;
      label385:
      localObject3 = k.aeZF;
    }
    label409:
    AbsNearByFragment localAbsNearByFragment = (AbsNearByFragment)paramBundle;
    localObject1 = this.ELY;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      s.bIx("liveFriendsPresenter");
      paramBundle = null;
    }
    this.ELZ = new e((MMActivity)localObject4, localAbsNearByFragment, (b.a)paramBundle, getRootView(), (bui)localObject3, this.ALp, this.EIq);
    paramBundle = this.ELY;
    if (paramBundle == null)
    {
      s.bIx("liveFriendsPresenter");
      paramBundle = null;
      localObject3 = this.ELZ;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("liveFriendsCallback");
        localObject1 = null;
      }
      localObject3 = (b.b)localObject1;
      if (localObject2 != null) {
        break label535;
      }
    }
    label535:
    for (localObject1 = null;; localObject1 = new com.tencent.mm.bx.b((byte[])localObject2))
    {
      paramBundle.a((b.b)localObject3, bool, (com.tencent.mm.bx.b)localObject1);
      AppMethodBeat.o(341325);
      return;
      break;
    }
  }
  
  public final void onDestroy()
  {
    Object localObject2 = null;
    AppMethodBeat.i(341375);
    super.onDestroy();
    Object localObject1 = this.EIq;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("NearbyLiveSquareTabUIC", s.X("onDestroy() tab:", localObject1));
      c localc = this.ELY;
      localObject1 = localc;
      if (localc == null)
      {
        s.bIx("liveFriendsPresenter");
        localObject1 = null;
      }
      ((c)localObject1).onFinishing();
      localObject1 = this.ELY;
      if (localObject1 != null) {
        break label94;
      }
      s.bIx("liveFriendsPresenter");
      localObject1 = localObject2;
    }
    label94:
    for (;;)
    {
      ((c)localObject1).onDetach();
      AppMethodBeat.o(341375);
      return;
      localObject1 = ((bnn)localObject1).ZWa;
      break;
    }
  }
  
  public final void onPause()
  {
    Object localObject2 = null;
    AppMethodBeat.i(341347);
    super.onPause();
    Object localObject1 = this.EIq;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("NearbyLiveSquareTabUIC", s.X("onPause() tab:", localObject1));
      c localc = this.ELY;
      localObject1 = localc;
      if (localc == null)
      {
        s.bIx("liveFriendsPresenter");
        localObject1 = null;
      }
      ((c)localObject1).onStop();
      localObject1 = j.Dob;
      localObject1 = this.ELZ;
      if (localObject1 != null) {
        break label116;
      }
      s.bIx("liveFriendsCallback");
      localObject1 = localObject2;
    }
    label116:
    for (;;)
    {
      j.a((RecyclerView)((f)localObject1).getRecyclerView(), q.w.DwP, "80", com.tencent.mm.plugin.finder.live.report.d.Dng, -100, -100);
      AppMethodBeat.o(341347);
      return;
      localObject1 = ((bnn)localObject1).ZWa;
      break;
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(341340);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    c localc2 = this.ELY;
    c localc1 = localc2;
    if (localc2 == null)
    {
      s.bIx("liveFriendsPresenter");
      localc1 = null;
    }
    localc1.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(341340);
  }
  
  public final void onResume()
  {
    Object localObject2 = null;
    AppMethodBeat.i(341336);
    super.onResume();
    Object localObject1 = this.EIq;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("NearbyLiveSquareTabUIC", s.X("onResume() tab:", localObject1));
      c localc = this.ELY;
      localObject1 = localc;
      if (localc == null)
      {
        s.bIx("liveFriendsPresenter");
        localObject1 = null;
      }
      ((c)localObject1).onStart();
      localObject1 = j.Dob;
      localObject1 = this.ELZ;
      if (localObject1 != null) {
        break label116;
      }
      s.bIx("liveFriendsCallback");
      localObject1 = localObject2;
    }
    label116:
    for (;;)
    {
      j.a((RecyclerView)((f)localObject1).getRecyclerView(), q.w.DwP, "80", com.tencent.mm.plugin.finder.live.report.d.Dnf, -100, -100);
      AppMethodBeat.o(341336);
      return;
      localObject1 = ((bnn)localObject1).ZWa;
      break;
    }
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(341330);
    super.onStart();
    Object localObject = this.EIq;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((bnn)localObject).ZWa)
    {
      Log.i("NearbyLiveSquareTabUIC", s.X("onStart() tab:", localObject));
      AppMethodBeat.o(341330);
      return;
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(341354);
    super.onStop();
    Object localObject = this.EIq;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((bnn)localObject).ZWa)
    {
      Log.i("NearbyLiveSquareTabUIC", s.X("onStop() tab:", localObject));
      AppMethodBeat.o(341354);
      return;
    }
  }
  
  public final void onUserVisibleFocused()
  {
    Object localObject2 = null;
    AppMethodBeat.i(341365);
    super.onUserVisibleFocused();
    Object localObject1 = this.EIq;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("NearbyLiveSquareTabUIC", s.X("onUserVisibleFocused() tab:", localObject1));
      localObject1 = k.aeZF;
      ((be)k.cn(PluginFinder.class).q(be.class)).aw((kotlin.g.a.b)d.b.EMa);
      localObject1 = this.ELY;
      if (localObject1 != null) {
        break label99;
      }
      s.bIx("liveFriendsPresenter");
      localObject1 = localObject2;
    }
    label99:
    for (;;)
    {
      ((c)localObject1).onUserVisibleFocused();
      AppMethodBeat.o(341365);
      return;
      localObject1 = ((bnn)localObject1).ZWa;
      break;
    }
  }
  
  public final void onUserVisibleUnFocused()
  {
    Object localObject2 = null;
    AppMethodBeat.i(341371);
    super.onUserVisibleUnFocused();
    Object localObject1 = this.EIq;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("NearbyLiveSquareTabUIC", s.X("onUserVisibleUnFocused() tab:", localObject1));
      localObject1 = this.ELY;
      if (localObject1 != null) {
        break label71;
      }
      s.bIx("liveFriendsPresenter");
      localObject1 = localObject2;
    }
    label71:
    for (;;)
    {
      ((c)localObject1).onUserVisibleUnFocused();
      AppMethodBeat.o(341371);
      return;
      localObject1 = ((bnn)localObject1).ZWa;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/page/NearbyLiveSquareTabUIC$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.page.d
 * JD-Core Version:    0.7.0.1
 */