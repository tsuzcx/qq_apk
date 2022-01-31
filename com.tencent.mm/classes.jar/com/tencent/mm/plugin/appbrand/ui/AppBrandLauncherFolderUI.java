package com.tencent.mm.plugin.appbrand.ui;

import a.f.b.j;
import a.l;
import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.appbrand.ui.collection.CollectionFolderActivityContext;
import com.tencent.mm.plugin.appbrand.ui.launcher.FolderActivityContextWithLifecycle;
import com.tencent.mm.plugin.appbrand.ui.launcher.a;
import com.tencent.mm.plugin.appbrand.ui.recents.RecentsFolderActivityContext;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.base.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/appbrand/ui/launcher/IFolderActivityContext;", "()V", "mFolderContextImpl", "Lcom/tencent/mm/plugin/appbrand/ui/launcher/FolderActivityContextWithLifecycle;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "finish", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showListPage", "showList", "Companion", "plugin-appbrand-integration_release"})
@i
public final class AppBrandLauncherFolderUI
  extends MMActivity
  implements a
{
  public static final AppBrandLauncherFolderUI.a iMD;
  private FolderActivityContextWithLifecycle iMC;
  
  static
  {
    AppMethodBeat.i(134994);
    iMD = new AppBrandLauncherFolderUI.a((byte)0);
    AppMethodBeat.o(134994);
  }
  
  public static final void n(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(134995);
    AppBrandLauncherFolderUI.a.n(paramContext, paramIntent);
    AppMethodBeat.o(134995);
  }
  
  public static final void o(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(134996);
    AppBrandLauncherFolderUI.a.o(paramContext, paramIntent);
    AppMethodBeat.o(134996);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(134993);
    if (isFinishing())
    {
      AppMethodBeat.o(134993);
      return false;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(134993);
    return bool;
  }
  
  public final void eP(boolean paramBoolean)
  {
    AppMethodBeat.i(134992);
    FolderActivityContextWithLifecycle localFolderActivityContextWithLifecycle = this.iMC;
    if (localFolderActivityContextWithLifecycle != null)
    {
      localFolderActivityContextWithLifecycle.eP(paramBoolean);
      AppMethodBeat.o(134992);
      return;
    }
    AppMethodBeat.o(134992);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(143985);
    if ((isFinishing()) || (isDestroyed()))
    {
      AppMethodBeat.o(143985);
      return;
    }
    super.finish();
    AppMethodBeat.o(143985);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(134991);
    super.onCreate(paramBundle);
    if (getIntent() == null)
    {
      finish();
      AppMethodBeat.o(134991);
      return;
    }
    if (b.ax(getClass())) {
      super.overridePendingTransition(MMFragmentActivity.a.zbX, MMFragmentActivity.a.zbY);
    }
    int i = getIntent().getIntExtra("KEY_MODE", 0);
    switch (i)
    {
    default: 
      ab.e("MicroMsg.AppBrandLauncherFolderUI", "onCreate with invalid mode(" + i + ')');
      finish();
      setActionbarColor(-855310);
      getContentView().setBackgroundColor(getActionbarColor());
      setBackBtn((MenuItem.OnMenuItemClickListener)new AppBrandLauncherFolderUI.b(this));
      setTitleBarDoubleClickListener((Runnable)new AppBrandLauncherFolderUI.c(this));
      paramBundle = getLifecycle();
      FolderActivityContextWithLifecycle localFolderActivityContextWithLifecycle = this.iMC;
      if (localFolderActivityContextWithLifecycle == null) {
        j.ebi();
      }
      paramBundle.addObserver((LifecycleObserver)localFolderActivityContextWithLifecycle);
      AppMethodBeat.o(134991);
      return;
    }
    for (paramBundle = (FolderActivityContextWithLifecycle)new RecentsFolderActivityContext((MMActivity)this);; paramBundle = (FolderActivityContextWithLifecycle)new CollectionFolderActivityContext((MMActivity)this))
    {
      this.iMC = paramBundle;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI
 * JD-Core Version:    0.7.0.1
 */