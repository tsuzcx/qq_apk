package com.tencent.mm.plugin.finder.nearby.video;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "(Lcom/tencent/mm/ui/MMFragmentActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "autoFlingFlag", "", "getAutoFlingFlag", "()Z", "setAutoFlingFlag", "(Z)V", "hasPermissionWhenPause", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "presenter", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoPresenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback;", "getLayoutId", "", "onActionbarClick", "", "onActionbarDoubleClick", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinished", "onPause", "onPermissionOk", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"})
public final class NearbyVideoUIC
  extends UIComponent
{
  public static final a uTF;
  NearbyVideoPresenter uTB;
  private d uTC;
  private boolean uTD;
  private boolean uTE;
  private final FinderGlobalLocationVM udf;
  
  static
  {
    AppMethodBeat.i(249478);
    uTF = new a((byte)0);
    AppMethodBeat.o(249478);
  }
  
  public NearbyVideoUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(249477);
    paramFragment = a.PRN;
    paramFragment = a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    p.g(paramFragment, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.udf = ((FinderGlobalLocationVM)paramFragment);
    this.uTD = true;
    this.uTE = true;
    AppMethodBeat.o(249477);
  }
  
  public NearbyVideoUIC(MMFragmentActivity paramMMFragmentActivity)
  {
    super((AppCompatActivity)paramMMFragmentActivity);
    AppMethodBeat.i(249476);
    paramMMFragmentActivity = a.PRN;
    paramMMFragmentActivity = a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    p.g(paramMMFragmentActivity, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.udf = ((FinderGlobalLocationVM)paramMMFragmentActivity);
    this.uTD = true;
    this.uTE = true;
    AppMethodBeat.o(249476);
  }
  
  private final void dlD()
  {
    AppMethodBeat.i(249475);
    if (this.uTE)
    {
      this.uTE = false;
      Object localObject = this.uTB;
      if (localObject != null) {
        ((NearbyVideoPresenter)localObject).autoFlingToRefresh(100L, false);
      }
      localObject = k.vfA;
      k.ac((Context)getActivity(), 5);
    }
    AppMethodBeat.o(249475);
  }
  
  public final int getLayoutId()
  {
    return 2131495835;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(249473);
    if ((paramInt1 == 501) && (paramInt2 == -1) && (paramIntent != null))
    {
      NearbyVideoPresenter localNearbyVideoPresenter = this.uTB;
      if (localNearbyVideoPresenter != null)
      {
        localNearbyVideoPresenter.refreshRV(paramIntent);
        AppMethodBeat.o(249473);
        return;
      }
    }
    AppMethodBeat.o(249473);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(249466);
    super.onCreate(paramBundle);
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(249466);
      throw paramBundle;
    }
    paramBundle = new NearbyVideoPresenter((MMActivity)paramBundle);
    this.uTB = paramBundle;
    Object localObject = getActivity();
    if (localObject == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(249466);
      throw paramBundle;
    }
    localObject = (MMActivity)localObject;
    Fragment localFragment = getFragment();
    if (localFragment == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment");
      AppMethodBeat.o(249466);
      throw paramBundle;
    }
    localObject = new d((MMActivity)localObject, (AbsNearByFragment)localFragment, (a.a)paramBundle, getRootView());
    paramBundle.onAttach((a.b)localObject);
    this.uTC = ((d)localObject);
    AppMethodBeat.o(249466);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(249472);
    super.onDestroy();
    NearbyVideoPresenter localNearbyVideoPresenter = this.uTB;
    if (localNearbyVideoPresenter != null) {
      localNearbyVideoPresenter.onDetach();
    }
    h.a(h.veu);
    AppMethodBeat.o(249472);
  }
  
  public final void onFinished()
  {
    AppMethodBeat.i(249471);
    super.onFinished();
    NearbyVideoPresenter localNearbyVideoPresenter = this.uTB;
    if (localNearbyVideoPresenter != null)
    {
      localNearbyVideoPresenter.onFinishing();
      AppMethodBeat.o(249471);
      return;
    }
    AppMethodBeat.o(249471);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(249468);
    super.onPause();
    Log.i("Finder.TimelineLbsUIC", "onPause");
    this.uTD = FinderGlobalLocationVM.dHO();
    AppMethodBeat.o(249468);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(249474);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    if (paramInt == 79)
    {
      if (paramArrayOfInt[0] == 0)
      {
        dlD();
        AppMethodBeat.o(249474);
        return;
      }
      paramArrayOfString = k.vfA;
      k.ac((Context)getActivity(), 3);
    }
    AppMethodBeat.o(249474);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(249467);
    super.onResume();
    Log.i("Finder.TimelineLbsUIC", "onResume");
    if ((!this.uTD) && (FinderGlobalLocationVM.dHO())) {
      dlD();
    }
    AppMethodBeat.o(249467);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(249469);
    Log.i("Finder.TimelineLbsUIC", "onUserVisibleFocused");
    super.onUserVisibleFocused();
    Object localObject = a.PRN;
    ((FinderVideoRecycler)a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).J((b)NearbyVideoUIC.b.uTG);
    localObject = a.PRN;
    a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    localObject = this.uTB;
    if (localObject != null) {
      ((NearbyVideoPresenter)localObject).onUserVisibleFocused();
    }
    this.udf.cxh();
    AppMethodBeat.o(249469);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(249470);
    Log.i("Finder.TimelineLbsUIC", "onUserVisibleUnFocused");
    super.onUserVisibleUnFocused();
    NearbyVideoPresenter localNearbyVideoPresenter = this.uTB;
    if (localNearbyVideoPresenter != null)
    {
      localNearbyVideoPresenter.onUserVisibleUnFocused();
      AppMethodBeat.o(249470);
      return;
    }
    AppMethodBeat.o(249470);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoUIC$Companion;", "", "()V", "REQUEST_STREAM_CODE", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.video.NearbyVideoUIC
 * JD-Core Version:    0.7.0.1
 */