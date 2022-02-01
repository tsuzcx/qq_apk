package com.tencent.mm.plugin.finder.nearby.video;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.viewmodel.a;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "(Lcom/tencent/mm/ui/MMFragmentActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "autoFlingFlag", "", "getAutoFlingFlag", "()Z", "setAutoFlingFlag", "(Z)V", "hasPermissionWhenPause", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "presenter", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoPresenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback;", "getLayoutId", "", "onActionbarClick", "", "onActionbarDoubleClick", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinished", "onPause", "onPermissionOk", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder-nearby_release"})
public final class d
  extends UIComponent
{
  public static final a zJS;
  private final a xSM;
  NearbyVideoPresenter zJO;
  private e zJP;
  private boolean zJQ;
  private boolean zJR;
  
  static
  {
    AppMethodBeat.i(201934);
    zJS = new a((byte)0);
    AppMethodBeat.o(201934);
  }
  
  public d(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(201932);
    paramFragment = g.Xox;
    paramFragment = g.bD(PluginFinder.class).i(a.class);
    p.j(paramFragment, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.xSM = ((a)paramFragment);
    this.zJQ = true;
    this.zJR = true;
    AppMethodBeat.o(201932);
  }
  
  public d(MMFragmentActivity paramMMFragmentActivity)
  {
    super((AppCompatActivity)paramMMFragmentActivity);
    AppMethodBeat.i(201927);
    paramMMFragmentActivity = g.Xox;
    paramMMFragmentActivity = g.bD(PluginFinder.class).i(a.class);
    p.j(paramMMFragmentActivity, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.xSM = ((a)paramMMFragmentActivity);
    this.zJQ = true;
    this.zJR = true;
    AppMethodBeat.o(201927);
  }
  
  private final void dME()
  {
    AppMethodBeat.i(201922);
    if (this.zJR)
    {
      this.zJR = false;
      Object localObject = this.zJO;
      if (localObject != null) {
        ((NearbyVideoPresenter)localObject).autoFlingToRefresh(100L, false);
      }
      localObject = n.zWF;
      n.al((Context)getActivity(), 5);
    }
    AppMethodBeat.o(201922);
  }
  
  public final int getLayoutId()
  {
    return f.e.zDo;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(201912);
    if ((paramInt1 == 501) && (paramInt2 == -1) && (paramIntent != null))
    {
      NearbyVideoPresenter localNearbyVideoPresenter = this.zJO;
      if (localNearbyVideoPresenter != null)
      {
        localNearbyVideoPresenter.refreshRV(paramIntent);
        AppMethodBeat.o(201912);
        return;
      }
    }
    AppMethodBeat.o(201912);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(201895);
    super.onCreate(paramBundle);
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(201895);
      throw paramBundle;
    }
    paramBundle = new NearbyVideoPresenter((MMActivity)paramBundle);
    this.zJO = paramBundle;
    Object localObject = getActivity();
    if (localObject == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(201895);
      throw paramBundle;
    }
    localObject = (MMActivity)localObject;
    Fragment localFragment = getFragment();
    if (localFragment == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment");
      AppMethodBeat.o(201895);
      throw paramBundle;
    }
    localObject = new e((MMActivity)localObject, (AbsNearByFragment)localFragment, (a.a)paramBundle, getRootView());
    paramBundle.onAttach((a.b)localObject);
    this.zJP = ((e)localObject);
    AppMethodBeat.o(201895);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(201910);
    super.onDestroy();
    NearbyVideoPresenter localNearbyVideoPresenter = this.zJO;
    if (localNearbyVideoPresenter != null) {
      localNearbyVideoPresenter.onDetach();
    }
    j.a(j.zVy);
    AppMethodBeat.o(201910);
  }
  
  public final void onFinished()
  {
    AppMethodBeat.i(201907);
    super.onFinished();
    NearbyVideoPresenter localNearbyVideoPresenter = this.zJO;
    if (localNearbyVideoPresenter != null)
    {
      localNearbyVideoPresenter.onFinishing();
      AppMethodBeat.o(201907);
      return;
    }
    AppMethodBeat.o(201907);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(201897);
    super.onPause();
    Log.i("Finder.TimelineLbsUIC", "onPause");
    this.zJQ = a.ejZ();
    AppMethodBeat.o(201897);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(201917);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    if (paramInt == 79)
    {
      if (paramArrayOfInt[0] == 0)
      {
        dME();
        AppMethodBeat.o(201917);
        return;
      }
      paramArrayOfString = n.zWF;
      n.al((Context)getActivity(), 3);
    }
    AppMethodBeat.o(201917);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(201896);
    super.onResume();
    Log.i("Finder.TimelineLbsUIC", "onResume");
    if ((!this.zJQ) && (a.ejZ())) {
      dME();
    }
    AppMethodBeat.o(201896);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(201903);
    Log.i("Finder.TimelineLbsUIC", "onUserVisibleFocused");
    super.onUserVisibleFocused();
    Object localObject = g.Xox;
    ((as)g.bD(PluginFinder.class).i(as.class)).Q((kotlin.g.a.b)d.b.zJT);
    localObject = g.Xox;
    g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class);
    localObject = this.zJO;
    if (localObject != null) {
      ((NearbyVideoPresenter)localObject).onUserVisibleFocused();
    }
    this.xSM.cKK();
    AppMethodBeat.o(201903);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(201905);
    Log.i("Finder.TimelineLbsUIC", "onUserVisibleUnFocused");
    super.onUserVisibleUnFocused();
    NearbyVideoPresenter localNearbyVideoPresenter = this.zJO;
    if (localNearbyVideoPresenter != null)
    {
      localNearbyVideoPresenter.onUserVisibleUnFocused();
      AppMethodBeat.o(201905);
      return;
    }
    AppMethodBeat.o(201905);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoUIC$Companion;", "", "()V", "REQUEST_STREAM_CODE", "", "TAG", "", "plugin-finder-nearby_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.video.d
 * JD-Core Version:    0.7.0.1
 */