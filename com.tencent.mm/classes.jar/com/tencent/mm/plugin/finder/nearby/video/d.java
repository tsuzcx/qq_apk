package com.tencent.mm.plugin.finder.nearby.video;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.be;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "(Lcom/tencent/mm/ui/MMFragmentActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "autoFlingFlag", "", "getAutoFlingFlag", "()Z", "setAutoFlingFlag", "(Z)V", "hasPermissionWhenPause", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "presenter", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoPresenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoViewCallback;", "getLayoutId", "", "onActionbarClick", "", "onActionbarDoubleClick", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinished", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends UIComponent
{
  public static final a ERN;
  private final com.tencent.mm.plugin.finder.viewmodel.b Bsp;
  NearbyVideoPresenter ERO;
  private e ERP;
  private boolean ERQ;
  private boolean ERR;
  
  static
  {
    AppMethodBeat.i(340144);
    ERN = new a((byte)0);
    AppMethodBeat.o(340144);
  }
  
  public d(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(340137);
    paramFragment = k.aeZF;
    paramFragment = k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class);
    kotlin.g.b.s.s(paramFragment, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.Bsp = ((com.tencent.mm.plugin.finder.viewmodel.b)paramFragment);
    this.ERQ = true;
    this.ERR = true;
    AppMethodBeat.o(340137);
  }
  
  public d(MMFragmentActivity paramMMFragmentActivity)
  {
    super((AppCompatActivity)paramMMFragmentActivity);
    AppMethodBeat.i(340124);
    paramMMFragmentActivity = k.aeZF;
    paramMMFragmentActivity = k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class);
    kotlin.g.b.s.s(paramMMFragmentActivity, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.Bsp = ((com.tencent.mm.plugin.finder.viewmodel.b)paramMMFragmentActivity);
    this.ERQ = true;
    this.ERR = true;
    AppMethodBeat.o(340124);
  }
  
  public final int getLayoutId()
  {
    return f.e.EHh;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(340217);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(340217);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        Object localObject = this.ERO;
        if (localObject != null)
        {
          ((NearbyVideoPresenter)localObject).refreshRV(paramIntent);
          AppMethodBeat.o(340217);
          return;
          if (paramInt2 == -1)
          {
            paramIntent = this.ERP;
            if (paramIntent != null)
            {
              paramInt1 = paramIntent.ERV;
              if (paramInt1 != -1)
              {
                localObject = this.ERO;
                if (localObject != null)
                {
                  localObject = ((NearbyVideoPresenter)localObject).getFeedLoader();
                  if (localObject != null)
                  {
                    localObject = ((NearbyVideoFeedLoader)localObject).getDataListJustForAdapter();
                    if (localObject != null) {
                      ((DataBuffer)localObject).remove(paramInt1);
                    }
                  }
                }
                paramIntent = paramIntent.getRecyclerView().getAdapter();
                if (paramIntent != null) {
                  paramIntent.fX(paramInt1);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(340225);
    kotlin.g.b.s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    if (aw.ato())
    {
      paramConfiguration = this.ERP;
      if (paramConfiguration != null)
      {
        paramConfiguration = paramConfiguration.getRecyclerView();
        if (paramConfiguration != null)
        {
          paramConfiguration = paramConfiguration.getAdapter();
          if (paramConfiguration != null) {
            paramConfiguration.bZE.notifyChanged();
          }
        }
      }
    }
    AppMethodBeat.o(340225);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(340162);
    super.onCreate(paramBundle);
    paramBundle = getFragment();
    if (paramBundle == null) {}
    MMActivity localMMActivity;
    Fragment localFragment;
    for (paramBundle = null;; paramBundle = ((as)k.y(paramBundle).q(as.class)).fou())
    {
      localObject = paramBundle;
      if (paramBundle == null)
      {
        paramBundle = k.aeZF;
        localObject = ((as)k.d(getActivity()).q(as.class)).fou();
      }
      paramBundle = new NearbyVideoPresenter((MMActivity)getActivity());
      this.ERO = paramBundle;
      localMMActivity = (MMActivity)getActivity();
      localFragment = getFragment();
      if (localFragment != null) {
        break;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment");
      AppMethodBeat.o(340162);
      throw paramBundle;
      localObject = k.aeZF;
    }
    Object localObject = new e((bui)localObject, localMMActivity, (AbsNearByFragment)localFragment, (a.a)paramBundle, getRootView());
    paramBundle.onAttach((a.b)localObject);
    paramBundle = ah.aiuX;
    this.ERP = ((e)localObject);
    AppMethodBeat.o(340162);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(340208);
    super.onDestroy();
    NearbyVideoPresenter localNearbyVideoPresenter = this.ERO;
    if (localNearbyVideoPresenter != null) {
      localNearbyVideoPresenter.onDetach();
    }
    com.tencent.mm.plugin.finder.report.s.a(com.tencent.mm.plugin.finder.report.s.Fqv);
    AppMethodBeat.o(340208);
  }
  
  public final void onFinished()
  {
    AppMethodBeat.i(340201);
    super.onFinished();
    NearbyVideoPresenter localNearbyVideoPresenter = this.ERO;
    if (localNearbyVideoPresenter != null) {
      localNearbyVideoPresenter.onFinishing();
    }
    AppMethodBeat.o(340201);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(340174);
    super.onPause();
    Log.i("Finder.TimelineLbsUIC", "onPause");
    NearbyVideoPresenter localNearbyVideoPresenter = this.ERO;
    if (localNearbyVideoPresenter != null) {
      localNearbyVideoPresenter.onPause();
    }
    this.ERQ = this.Bsp.dUi();
    AppMethodBeat.o(340174);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(340220);
    kotlin.g.b.s.u(paramArrayOfString, "permissions");
    kotlin.g.b.s.u(paramArrayOfInt, "grantResults");
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    NearbyVideoPresenter localNearbyVideoPresenter = this.ERO;
    if (localNearbyVideoPresenter != null) {
      localNearbyVideoPresenter.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(340220);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(340169);
    super.onResume();
    Log.i("Finder.TimelineLbsUIC", "onResume");
    NearbyVideoPresenter localNearbyVideoPresenter = this.ERO;
    if (localNearbyVideoPresenter != null) {
      localNearbyVideoPresenter.onResume();
    }
    AppMethodBeat.o(340169);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(340182);
    Log.i("Finder.TimelineLbsUIC", "onUserVisibleFocused");
    super.onUserVisibleFocused();
    Object localObject = k.aeZF;
    ((be)k.cn(PluginFinder.class).q(be.class)).aw((kotlin.g.a.b)d.b.ERS);
    localObject = this.ERO;
    if (localObject != null) {
      ((NearbyVideoPresenter)localObject).onUserVisibleFocused();
    }
    this.Bsp.pH(false);
    AppMethodBeat.o(340182);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(340193);
    Log.i("Finder.TimelineLbsUIC", "onUserVisibleUnFocused");
    super.onUserVisibleUnFocused();
    NearbyVideoPresenter localNearbyVideoPresenter = this.ERO;
    if (localNearbyVideoPresenter != null) {
      localNearbyVideoPresenter.onUserVisibleUnFocused();
    }
    AppMethodBeat.o(340193);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoUIC$Companion;", "", "()V", "REQUEST_STREAM_CODE", "", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.video.d
 * JD-Core Version:    0.7.0.1
 */