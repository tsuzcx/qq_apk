package com.tencent.mm.plugin.finder.nearby.live.localcity;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.live.report.d;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.nearby.live.b.a;
import com.tencent.mm.plugin.finder.nearby.live.b.b;
import com.tencent.mm.plugin.finder.nearby.live.f;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/localcity/NearbyLocalCityUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "liveFriendsCallback", "Lcom/tencent/mm/plugin/finder/nearby/live/localcity/NearbyLiveLocalCityViewCallback;", "liveFriendsPresenter", "Lcom/tencent/mm/plugin/finder/nearby/live/localcity/NearbyLiveLocalCityPresenter;", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getLayoutId", "", "getTabInfo", "onActionbarClick", "", "onActionbarDoubleClick", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends UIComponent
{
  public static final a EJN;
  private bnn EIq;
  a EJO;
  private b EJP;
  
  static
  {
    AppMethodBeat.i(340837);
    EJN = new a((byte)0);
    AppMethodBeat.o(340837);
  }
  
  public c(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(340832);
    AppMethodBeat.o(340832);
  }
  
  public final int getLayoutId()
  {
    return f.e.EHd;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(340903);
    s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    b localb2 = this.EJP;
    b localb1 = localb2;
    if (localb2 == null)
    {
      s.bIx("liveFriendsCallback");
      localb1 = null;
    }
    localb1.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(340903);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(340852);
    super.onCreate(paramBundle);
    this.EIq = new bnn();
    paramBundle = this.EIq;
    if (paramBundle != null) {
      paramBundle.ZWa = "同城直播";
    }
    paramBundle = this.EIq;
    if (paramBundle != null) {
      paramBundle.ZVZ = 88889;
    }
    paramBundle = this.EIq;
    if (paramBundle == null)
    {
      paramBundle = null;
      Log.i("NearbyLiveSquareTabUIC", s.X("onCreate(), tab:", paramBundle));
      paramBundle = com.tencent.mm.plugin.finder.nearby.trace.c.ERD;
      com.tencent.mm.plugin.finder.nearby.trace.c.eGR().aDn("livePageOnCreate");
      paramBundle = getFragment();
      if (paramBundle != null) {
        break label203;
      }
    }
    Object localObject1;
    MMActivity localMMActivity;
    for (paramBundle = null;; paramBundle = ((as)k.y(paramBundle).q(as.class)).fou())
    {
      localObject1 = paramBundle;
      if (paramBundle == null)
      {
        paramBundle = k.aeZF;
        localObject1 = ((as)k.d(getActivity()).q(as.class)).fou();
      }
      paramBundle = (MMActivity)getActivity();
      localObject2 = getFragment();
      s.checkNotNull(localObject2);
      this.EJO = new a(paramBundle, (Fragment)localObject2, (bui)localObject1, this.EIq);
      localMMActivity = (MMActivity)getActivity();
      paramBundle = getFragment();
      if (paramBundle != null) {
        break label226;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment");
      AppMethodBeat.o(340852);
      throw paramBundle;
      paramBundle = paramBundle.ZWa;
      break;
      label203:
      localObject1 = k.aeZF;
    }
    label226:
    AbsNearByFragment localAbsNearByFragment = (AbsNearByFragment)paramBundle;
    Object localObject2 = this.EJO;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      s.bIx("liveFriendsPresenter");
      paramBundle = null;
    }
    this.EJP = new b(localMMActivity, localAbsNearByFragment, (b.a)paramBundle, getRootView(), (bui)localObject1, this.EIq);
    paramBundle = this.EJO;
    if (paramBundle == null)
    {
      s.bIx("liveFriendsPresenter");
      paramBundle = null;
    }
    for (;;)
    {
      localObject2 = this.EJP;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("liveFriendsCallback");
        localObject1 = null;
      }
      paramBundle.b((b.b)localObject1);
      AppMethodBeat.o(340852);
      return;
    }
  }
  
  public final void onDestroy()
  {
    Object localObject2 = null;
    AppMethodBeat.i(340895);
    super.onDestroy();
    Object localObject1 = this.EIq;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("NearbyLiveSquareTabUIC", s.X("onDestroy() tab:", localObject1));
      a locala = this.EJO;
      localObject1 = locala;
      if (locala == null)
      {
        s.bIx("liveFriendsPresenter");
        localObject1 = null;
      }
      ((a)localObject1).onFinishing();
      localObject1 = this.EJO;
      if (localObject1 != null) {
        break label89;
      }
      s.bIx("liveFriendsPresenter");
      localObject1 = localObject2;
    }
    label89:
    for (;;)
    {
      ((a)localObject1).onDetach();
      AppMethodBeat.o(340895);
      return;
      localObject1 = ((bnn)localObject1).ZWa;
      break;
    }
  }
  
  public final void onPause()
  {
    Object localObject2 = null;
    AppMethodBeat.i(340873);
    super.onPause();
    a locala = this.EJO;
    Object localObject1 = locala;
    if (locala == null)
    {
      s.bIx("liveFriendsPresenter");
      localObject1 = null;
    }
    ((a)localObject1).onStop();
    localObject1 = j.Dob;
    localObject1 = this.EJP;
    if (localObject1 == null)
    {
      s.bIx("liveFriendsCallback");
      localObject1 = localObject2;
    }
    for (;;)
    {
      j.a((RecyclerView)((f)localObject1).getRecyclerView(), q.w.DwP, "80", d.Dng, -100, -100);
      AppMethodBeat.o(340873);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(340865);
    super.onResume();
    Object localObject = j.Dob;
    b localb = this.EJP;
    localObject = localb;
    if (localb == null)
    {
      s.bIx("liveFriendsCallback");
      localObject = null;
    }
    j.a((RecyclerView)((f)localObject).getRecyclerView(), q.w.DwP, "80", d.Dnf, -100, -100);
    AppMethodBeat.o(340865);
  }
  
  public final void onStart()
  {
    Object localObject2 = null;
    AppMethodBeat.i(340856);
    super.onStart();
    Object localObject1 = this.EIq;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("NearbyLiveSquareTabUIC", s.X("onStart() tab:", localObject1));
      localObject1 = this.EJO;
      if (localObject1 != null) {
        break label70;
      }
      s.bIx("liveFriendsPresenter");
      localObject1 = localObject2;
    }
    label70:
    for (;;)
    {
      ((a)localObject1).onStart();
      AppMethodBeat.o(340856);
      return;
      localObject1 = ((bnn)localObject1).ZWa;
      break;
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(340876);
    super.onStop();
    Object localObject = this.EIq;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((bnn)localObject).ZWa)
    {
      Log.i("NearbyLiveSquareTabUIC", s.X("onStop() tab:", localObject));
      AppMethodBeat.o(340876);
      return;
    }
  }
  
  public final void onUserVisibleFocused()
  {
    Object localObject2 = null;
    AppMethodBeat.i(340883);
    super.onUserVisibleFocused();
    Object localObject1 = this.EIq;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("NearbyLiveSquareTabUIC", s.X("onUserVisibleFocused() tab:", localObject1));
      localObject1 = k.aeZF;
      ((be)k.cn(PluginFinder.class).q(be.class)).aw((kotlin.g.a.b)c.b.EJQ);
      localObject1 = this.EJO;
      if (localObject1 != null) {
        break label98;
      }
      s.bIx("liveFriendsPresenter");
      localObject1 = localObject2;
    }
    label98:
    for (;;)
    {
      ((a)localObject1).onUserVisibleFocused();
      AppMethodBeat.o(340883);
      return;
      localObject1 = ((bnn)localObject1).ZWa;
      break;
    }
  }
  
  public final void onUserVisibleUnFocused()
  {
    Object localObject2 = null;
    AppMethodBeat.i(340889);
    super.onUserVisibleUnFocused();
    Object localObject1 = this.EIq;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("NearbyLiveSquareTabUIC", s.X("onUserVisibleUnFocused() tab:", localObject1));
      localObject1 = this.EJO;
      if (localObject1 != null) {
        break label70;
      }
      s.bIx("liveFriendsPresenter");
      localObject1 = localObject2;
    }
    label70:
    for (;;)
    {
      ((a)localObject1).onUserVisibleUnFocused();
      AppMethodBeat.o(340889);
      return;
      localObject1 = ((bnn)localObject1).ZWa;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/localcity/NearbyLocalCityUIC$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.localcity.c
 * JD-Core Version:    0.7.0.1
 */