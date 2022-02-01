package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.af.e;
import com.tencent.mm.plugin.appbrand.af.g;
import com.tencent.mm.plugin.appbrand.ak;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.CloseWhenClickEmptyAreaConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.a;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.m;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.wxa_container.BaseAppBrandUIClipped.a;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;

@a(1)
public class AppBrandPluginUI
  extends AppBrandUI
{
  private void bXj()
  {
    AppMethodBeat.i(227628);
    if (bXk())
    {
      y.a(getWindow(), true, false);
      f.e(true, true, true);
      com.tencent.mm.ui.base.b.a(this, null);
    }
    AppMethodBeat.o(227628);
  }
  
  private boolean bXk()
  {
    AppMethodBeat.i(48677);
    if (this.mRuntimeContainer == null) {}
    for (AppBrandRuntime localAppBrandRuntime = null;; localAppBrandRuntime = this.mRuntimeContainer.getActiveRuntime())
    {
      boolean bool = g.an(localAppBrandRuntime);
      AppMethodBeat.o(48677);
      return bool;
    }
  }
  
  private boolean bXl()
  {
    AppMethodBeat.i(162169);
    if (bXk())
    {
      AppMethodBeat.o(162169);
      return false;
    }
    if (this.mRuntimeContainer == null) {}
    for (Object localObject = null; ((localObject instanceof q)) && (((q)localObject).bsC().kHM); localObject = this.mRuntimeContainer.getActiveRuntime())
    {
      AppMethodBeat.o(162169);
      return true;
    }
    try
    {
      localObject = Util.getCurrentTaskInfo(this, getTaskId());
      if ((localObject == null) || (((ActivityManager.RunningTaskInfo)localObject).baseActivity == null)) {
        break label206;
      }
      if (((ActivityManager.RunningTaskInfo)localObject).baseActivity.equals(getComponentName()))
      {
        Log.i("MicroMsg.AppBrandPluginUI", "shouldKeepPluginUIOpaque return true, task.baseActivity=self, keep PluginUI opaque");
        AppMethodBeat.o(162169);
        return true;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.AppBrandPluginUI", "shouldKeepPluginUIOpaque return false, get e=%s", new Object[] { localException });
      AppMethodBeat.o(162169);
      return false;
    }
    int i = 0;
    while (i < 2)
    {
      String str2 = new String[] { "WXBizEntryActivity", "AppBrandLaunchProxyUI" }[i];
      if (localException.baseActivity.getShortClassName().endsWith(str2))
      {
        Log.i("MicroMsg.AppBrandPluginUI", "shouldKeepPluginUIOpaque return true, task.baseActivity=[%s], keep PluginUI opaque", new Object[] { str2 });
        AppMethodBeat.o(162169);
        return true;
      }
      i += 1;
    }
    label206:
    if ((localException != null) && (localException.baseActivity != null)) {}
    for (String str1 = localException.baseActivity.getShortClassName();; str1 = "null")
    {
      Log.i("MicroMsg.AppBrandPluginUI", "shouldKeepPluginUIOpaque return false, task.baseActivity=[%s]", new Object[] { str1 });
      AppMethodBeat.o(162169);
      return false;
    }
  }
  
  final void M(Intent paramIntent)
  {
    AppMethodBeat.i(48680);
    AppBrandInitConfigWC localAppBrandInitConfigWC;
    try
    {
      localAppBrandInitConfigWC = (AppBrandInitConfigWC)paramIntent.getParcelableExtra("key_appbrand_init_config");
      paramIntent = (AppBrandStatObject)paramIntent.getParcelableExtra("key_appbrand_stat_object");
      if ((localAppBrandInitConfigWC == null) || (paramIntent == null))
      {
        AppMethodBeat.o(48680);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandPluginUI", paramIntent, "resumeAnim caught exception", new Object[0]);
      AppMethodBeat.o(48680);
      return;
    }
    h(localAppBrandInitConfigWC, paramIntent);
    AppMethodBeat.o(48680);
  }
  
  protected final void N(Intent paramIntent)
  {
    AppMethodBeat.i(48683);
    super.N(paramIntent);
    if (this.mRuntimeContainer == null) {}
    for (paramIntent = null;; paramIntent = this.mRuntimeContainer.getActiveRuntime())
    {
      if ((paramIntent != null) && ((AppBrandRuntimeWCAccessible.D(paramIntent)) || (((AppBrandInitConfigWC)paramIntent.OU()).kHL.isEnable())))
      {
        paramIntent.gs(true);
        paramIntent.kAM = new ap()
        {
          public final void vC(int paramAnonymousInt)
          {
            AppMethodBeat.i(48673);
            if (1 == paramAnonymousInt)
            {
              Log.i("MicroMsg.AppBrandPluginUI", "load convertActivityToTranslucent");
              com.tencent.mm.ui.base.b.a(AppBrandPluginUI.this, null);
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
      com.tencent.mm.ui.base.b.a(this, null);
      Log.i("MicroMsg.AppBrandPluginUI", "init convertActivityToTranslucent");
      AppMethodBeat.o(48679);
      return;
    }
    AppBrandInitConfigWC localAppBrandInitConfigWC = bsC();
    if (com.tencent.mm.plugin.appbrand.utils.b.afF(this.ldT))
    {
      super.overridePendingTransition(0, 0);
      AppMethodBeat.o(48679);
      return;
    }
    if (bXk())
    {
      e.b(this, paramAppBrandInitConfigWC);
      AppMethodBeat.o(48679);
      return;
    }
    if (paramAppBrandInitConfigWC.kHL.isEnable())
    {
      if (paramAppBrandInitConfigWC.kHL.lfn == HalfScreenConfig.a.lft)
      {
        overridePendingTransition(2130772009, 0);
        AppMethodBeat.o(48679);
        return;
      }
      super.overridePendingTransition(this.ogk.ogm, 0);
      AppMethodBeat.o(48679);
      return;
    }
    if ((localAppBrandInitConfigWC != null) && (localAppBrandInitConfigWC.leg))
    {
      super.h(paramAppBrandInitConfigWC, paramAppBrandStatObject);
      AppMethodBeat.o(48679);
      return;
    }
    if ((localAppBrandInitConfigWC.lei) && (!localAppBrandInitConfigWC.ldN))
    {
      super.h(paramAppBrandInitConfigWC, paramAppBrandStatObject);
      AppMethodBeat.o(48679);
      return;
    }
    super.overridePendingTransition(this.ogk.ogm, this.ogk.ogn);
    AppMethodBeat.o(48679);
  }
  
  public void initActivityCloseAnimation()
  {
    AppMethodBeat.i(48681);
    Object localObject = bZi();
    if ((localObject != null) && (((HalfScreenConfig)localObject).isEnable()))
    {
      if ((((HalfScreenConfig)localObject).lfn == HalfScreenConfig.a.lft) || (((HalfScreenConfig)localObject).lfq.lfD == HalfScreenConfig.a.lft))
      {
        overridePendingTransition(0, 2130772007);
        AppMethodBeat.o(48681);
        return;
      }
      super.overridePendingTransition(0, this.ogk.ogp);
      AppMethodBeat.o(48681);
      return;
    }
    localObject = bsC();
    if ((localObject != null) && (((AppBrandInitConfigWC)localObject).leg))
    {
      overridePendingTransition(2130772006, 2130772007);
      AppMethodBeat.o(48681);
      return;
    }
    if ((((AppBrandInitConfigWC)localObject).lei) && (!((AppBrandInitConfigWC)localObject).ldN))
    {
      overridePendingTransition(2130772006, 2130772007);
      AppMethodBeat.o(48681);
      return;
    }
    super.overridePendingTransition(this.ogk.ogo, this.ogk.ogp);
    AppMethodBeat.o(48681);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48674);
    super.onCreate(paramBundle);
    AppMethodBeat.o(48674);
  }
  
  public void onEnterAnimationComplete()
  {
    AppBrandRuntime localAppBrandRuntime = null;
    AppMethodBeat.i(48678);
    super.onEnterAnimationComplete();
    if (bXl())
    {
      if (this.mRuntimeContainer == null) {}
      for (;;)
      {
        if (localAppBrandRuntime != null) {
          localAppBrandRuntime.gs(false);
        }
        AppMethodBeat.o(48678);
        return;
        localAppBrandRuntime = this.mRuntimeContainer.getActiveRuntime();
      }
    }
    Log.i("MicroMsg.AppBrandPluginUI", "onEnterAnimationComplete convert PluginUI to translucent");
    com.tencent.mm.ui.base.b.a(this, null);
    Log.i("MicroMsg.AppBrandPluginUI", "onEnter convertActivityToTranslucent");
    AppMethodBeat.o(48678);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(48676);
    super.onPause();
    if (bXk()) {
      f.e(false, true, true);
    }
    AppMethodBeat.o(48676);
  }
  
  public void onPostCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(227627);
    super.onPostCreate(paramBundle);
    bXj();
    AppMethodBeat.o(227627);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(48675);
    super.onResume();
    bXj();
    AppMethodBeat.o(48675);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI
 * JD-Core Version:    0.7.0.1
 */