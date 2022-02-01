package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.ab.e;
import com.tencent.mm.plugin.appbrand.ab.g;
import com.tencent.mm.plugin.appbrand.ai;
import com.tencent.mm.plugin.appbrand.al;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.m;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.wxa_container.BaseAppBrandUIClipped.a;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.m.a.c.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.b;

@com.tencent.mm.ui.base.a(1)
public class AppBrandPluginUI
  extends AppBrandUI
{
  private boolean bzq()
  {
    AppMethodBeat.i(48677);
    if (this.mRuntimeContainer == null) {}
    for (AppBrandRuntime localAppBrandRuntime = null;; localAppBrandRuntime = this.mRuntimeContainer.getActiveRuntime())
    {
      boolean bool = g.am(localAppBrandRuntime);
      AppMethodBeat.o(48677);
      return bool;
    }
  }
  
  private boolean bzr()
  {
    AppMethodBeat.i(162169);
    try
    {
      ActivityManager.RunningTaskInfo localRunningTaskInfo = bt.aJ(this, getTaskId());
      if ((localRunningTaskInfo == null) || (localRunningTaskInfo.baseActivity == null)) {
        break label143;
      }
      if (localRunningTaskInfo.baseActivity.equals(getComponentName()))
      {
        ad.i("MicroMsg.AppBrandPluginUI", "shouldKeepPluginUIOpaque return true, task.baseActivity=self, keep PluginUI opaque");
        AppMethodBeat.o(162169);
        return true;
      }
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.AppBrandPluginUI", "shouldKeepPluginUIOpaque return false, get e=%s", new Object[] { localException });
      AppMethodBeat.o(162169);
      return false;
    }
    int i = 0;
    while (i < 2)
    {
      String str2 = new String[] { "WXBizEntryActivity", "AppBrandLaunchProxyUI" }[i];
      if (localException.baseActivity.getShortClassName().endsWith(str2))
      {
        ad.i("MicroMsg.AppBrandPluginUI", "shouldKeepPluginUIOpaque return true, task.baseActivity=[%s], keep PluginUI opaque", new Object[] { str2 });
        AppMethodBeat.o(162169);
        return true;
      }
      i += 1;
    }
    label143:
    if ((localException != null) && (localException.baseActivity != null)) {}
    for (String str1 = localException.baseActivity.getShortClassName();; str1 = "null")
    {
      ad.i("MicroMsg.AppBrandPluginUI", "shouldKeepPluginUIOpaque return false, task.baseActivity=[%s]", new Object[] { str1 });
      AppMethodBeat.o(162169);
      return false;
    }
  }
  
  final void M(Intent paramIntent)
  {
    AppMethodBeat.i(48680);
    super.overridePendingTransition(this.mOd.mOe, this.mOd.mOf);
    AppMethodBeat.o(48680);
  }
  
  protected final void N(Intent paramIntent)
  {
    AppMethodBeat.i(48683);
    super.N(paramIntent);
    if (this.mRuntimeContainer == null) {}
    for (paramIntent = null;; paramIntent = this.mRuntimeContainer.getActiveRuntime())
    {
      if (AppBrandRuntimeWCAccessible.F(paramIntent))
      {
        paramIntent.jwY = true;
        paramIntent.jwX = new al()
        {
          public final void rG(int paramAnonymousInt)
          {
            AppMethodBeat.i(48673);
            if (1 == paramAnonymousInt)
            {
              ad.i("MicroMsg.AppBrandPluginUI", "load convertActivityToTranslucent");
              b.a(AppBrandPluginUI.this, null);
            }
            AppMethodBeat.o(48673);
          }
        };
      }
      AppMethodBeat.o(48683);
      return;
    }
  }
  
  protected final void h(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(48679);
    if (m.a(this, paramAppBrandInitConfigWC, paramAppBrandStatObject))
    {
      b.a(this, null);
      ad.i("MicroMsg.AppBrandPluginUI", "init convertActivityToTranslucent");
      AppMethodBeat.o(48679);
      return;
    }
    if (com.tencent.mm.plugin.appbrand.utils.a.UY(this.jXA))
    {
      super.overridePendingTransition(0, 0);
      AppMethodBeat.o(48679);
      return;
    }
    if (bzq())
    {
      e.b(this, paramAppBrandInitConfigWC);
      AppMethodBeat.o(48679);
      return;
    }
    super.overridePendingTransition(this.mOd.mOe, this.mOd.mOf);
    AppMethodBeat.o(48679);
  }
  
  public void initActivityCloseAnimation()
  {
    AppMethodBeat.i(48681);
    super.overridePendingTransition(this.mOd.mOg, this.mOd.mOh);
    AppMethodBeat.o(48681);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48674);
    super.onCreate(paramBundle);
    paramBundle = c.vCY;
    c.api("ui_create");
    AppMethodBeat.o(48674);
  }
  
  public void onEnterAnimationComplete()
  {
    AppBrandRuntime localAppBrandRuntime = null;
    AppMethodBeat.i(48678);
    super.onEnterAnimationComplete();
    if (bzr())
    {
      if (this.mRuntimeContainer == null) {}
      for (;;)
      {
        if (localAppBrandRuntime != null) {
          localAppBrandRuntime.jwY = false;
        }
        AppMethodBeat.o(48678);
        return;
        localAppBrandRuntime = this.mRuntimeContainer.getActiveRuntime();
      }
    }
    ad.i("MicroMsg.AppBrandPluginUI", "onEnterAnimationComplete convert PluginUI to translucent");
    b.a(this, null);
    ad.i("MicroMsg.AppBrandPluginUI", "onEnter convertActivityToTranslucent");
    AppMethodBeat.o(48678);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(48676);
    super.onPause();
    if (bzq()) {
      f.e(false, true, true);
    }
    AppMethodBeat.o(48676);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(48675);
    super.onResume();
    if (bzq())
    {
      s.a(getWindow(), true, false);
      f.e(true, true, true);
    }
    AppMethodBeat.o(48675);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI
 * JD-Core Version:    0.7.0.1
 */