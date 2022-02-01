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
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class AppBrandGuideUI$a
  implements Application.ActivityLifecycleCallbacks, f
{
  public boolean mBB = false;
  String mBC;
  
  public static Application bzf()
  {
    AppMethodBeat.i(48614);
    Application localApplication = (Application)aj.getContext().getApplicationContext();
    AppMethodBeat.o(48614);
    return localApplication;
  }
  
  public final void UL(String paramString)
  {
    this.mBB = true;
    this.mBC = paramString;
  }
  
  public final void bB(String paramString, int paramInt)
  {
    this.mBB = false;
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if ((paramActivity instanceof AppBrandGuideUI)) {
      this.mBB = false;
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(48615);
    if (((paramActivity instanceof AppBrandGuideUI)) || ((paramActivity instanceof AppBrandLauncherUI))) {
      this.mBB = false;
    }
    Object localObject;
    int i;
    if ((g.ajx()) && (this.mBB))
    {
      localObject = bt.aJ(paramActivity, paramActivity.getTaskId());
      if ((localObject != null) && (((ActivityManager.RunningTaskInfo)localObject).baseActivity != null)) {
        break label145;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        this.mBB = false;
        localObject = new Intent(paramActivity, AppBrandGuideUI.class);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/appbrand/ui/AppBrandGuideUI$AppBrandGuideController", "onActivityResumed", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.a
 * JD-Core Version:    0.7.0.1
 */