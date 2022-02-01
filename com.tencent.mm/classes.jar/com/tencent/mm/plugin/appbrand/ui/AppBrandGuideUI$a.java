package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class AppBrandGuideUI$a
  implements Application.ActivityLifecycleCallbacks, f
{
  public boolean nTE = false;
  String nTF;
  
  public static Application bWY()
  {
    AppMethodBeat.i(48614);
    Application localApplication = (Application)MMApplicationContext.getContext().getApplicationContext();
    AppMethodBeat.o(48614);
    return localApplication;
  }
  
  public final void afr(String paramString)
  {
    this.nTE = true;
    this.nTF = paramString;
  }
  
  public final void bJ(String paramString, int paramInt)
  {
    this.nTE = false;
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if ((paramActivity instanceof AppBrandGuideUI)) {
      this.nTE = false;
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(48615);
    if (((paramActivity instanceof AppBrandGuideUI)) || ((paramActivity instanceof AppBrandLauncherUI))) {
      this.nTE = false;
    }
    Object localObject;
    int i;
    if ((g.aAc()) && (this.nTE))
    {
      localObject = Util.getCurrentTaskInfo(paramActivity, paramActivity.getTaskId());
      if ((localObject != null) && (((ActivityManager.RunningTaskInfo)localObject).baseActivity != null)) {
        break label145;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        this.nTE = false;
        localObject = new Intent(paramActivity, AppBrandGuideUI.class);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/appbrand/ui/AppBrandGuideUI$AppBrandGuideController", "onActivityResumed", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/appbrand/ui/AppBrandGuideUI$AppBrandGuideController", "onActivityResumed", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(48615);
      return;
      label145:
      if ((!((ActivityManager.RunningTaskInfo)localObject).baseActivity.getClassName().endsWith(".LauncherUI")) && (((ActivityManager.RunningTaskInfo)localObject).baseActivity.getClassName().contains(".AppBrandUI"))) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.a
 * JD-Core Version:    0.7.0.1
 */