package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.n;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.ag.e;
import com.tencent.mm.plugin.appbrand.ag.g;
import com.tencent.mm.plugin.appbrand.ak;
import com.tencent.mm.plugin.appbrand.aq;
import com.tencent.mm.plugin.appbrand.au.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.a;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.m;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.ui.wxa_container.AppBrandContainerFragmentActivity.a;
import com.tencent.mm.plugin.appbrand.utils.d;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.b;

@a(1)
public class AppBrandPluginUI
  extends AppBrandUI
{
  public static int qVS = -1;
  public static int qVT = -1;
  private IListener<n> qVU;
  
  private void cjN()
  {
    AppMethodBeat.i(246625);
    if (cjO())
    {
      x.a(getWindow(), true, false);
      f.d(true, true, true);
      b.a(this, null);
    }
    AppMethodBeat.o(246625);
  }
  
  private boolean cjO()
  {
    AppMethodBeat.i(48677);
    if (this.mRuntimeContainer == null) {}
    for (AppBrandRuntime localAppBrandRuntime = null;; localAppBrandRuntime = this.mRuntimeContainer.getActiveRuntime())
    {
      boolean bool = g.ap(localAppBrandRuntime);
      AppMethodBeat.o(48677);
      return bool;
    }
  }
  
  private boolean cjP()
  {
    AppMethodBeat.i(162169);
    if (cjO())
    {
      AppMethodBeat.o(162169);
      return false;
    }
    if (this.mRuntimeContainer == null) {}
    for (Object localObject = null; ((localObject instanceof t)) && (((t)localObject).bDy().nBF); localObject = this.mRuntimeContainer.getActiveRuntime())
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
  
  protected final void am(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(246638);
    if ((paramAppBrandRuntime != null) && ((AppBrandRuntimeWCAccessible.E(paramAppBrandRuntime)) || (((AppBrandInitConfigWC)paramAppBrandRuntime.Sq()).nBE.isEnable())))
    {
      paramAppBrandRuntime.he(true);
      paramAppBrandRuntime.ntY = new aq()
      {
        public final void yN(int paramAnonymousInt)
        {
          AppMethodBeat.i(281046);
          if (1 == paramAnonymousInt)
          {
            Log.i("MicroMsg.AppBrandPluginUI", "load convertActivityToTranslucent");
            b.a(AppBrandPluginUI.this, null);
          }
          AppMethodBeat.o(281046);
        }
      };
    }
    AppMethodBeat.o(246638);
  }
  
  protected final void g(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(48679);
    if (m.a(this, paramAppBrandInitConfigWC, paramAppBrandStatObject))
    {
      b.a(this, null);
      Log.i("MicroMsg.AppBrandPluginUI", "init convertActivityToTranslucent");
      AppMethodBeat.o(48679);
      return;
    }
    AppBrandInitConfigWC localAppBrandInitConfigWC = bDy();
    if (d.anh(paramAppBrandInitConfigWC.nYh))
    {
      super.overridePendingTransition(0, 0);
      AppMethodBeat.o(48679);
      return;
    }
    if (cjO())
    {
      e.b(this, paramAppBrandInitConfigWC);
      AppMethodBeat.o(48679);
      return;
    }
    if (paramAppBrandInitConfigWC.nBE.isEnable())
    {
      if (paramAppBrandInitConfigWC.nBE.nZz == HalfScreenConfig.a.nZL)
      {
        overridePendingTransition(au.a.appbrand_ui_push_open_enter, 0);
        AppMethodBeat.o(48679);
        return;
      }
      super.overridePendingTransition(this.rhW.rhY, 0);
      AppMethodBeat.o(48679);
      return;
    }
    if ((localAppBrandInitConfigWC != null) && (localAppBrandInitConfigWC.nYu))
    {
      super.g(paramAppBrandInitConfigWC, paramAppBrandStatObject);
      AppMethodBeat.o(48679);
      return;
    }
    if ((localAppBrandInitConfigWC.nYw) && (!localAppBrandInitConfigWC.nYb))
    {
      super.g(paramAppBrandInitConfigWC, paramAppBrandStatObject);
      AppMethodBeat.o(48679);
      return;
    }
    super.overridePendingTransition(this.rhW.rhY, this.rhW.rhZ);
    AppMethodBeat.o(48679);
  }
  
  public void initActivityCloseAnimation()
  {
    AppMethodBeat.i(48681);
    Object localObject = ckf();
    if ((localObject != null) && (((HalfScreenConfig)localObject).isEnable()))
    {
      if ((qVS != -1) && (qVT != -1))
      {
        overridePendingTransition(qVT, qVS);
        qVS = -1;
        qVT = -1;
        AppMethodBeat.o(48681);
        return;
      }
      if (((HalfScreenConfig)localObject).nZz == HalfScreenConfig.a.nZL)
      {
        overridePendingTransition(0, au.a.appbrand_ui_push_close_exit);
        AppMethodBeat.o(48681);
        return;
      }
      super.overridePendingTransition(0, this.rhW.rib);
      AppMethodBeat.o(48681);
      return;
    }
    localObject = bDy();
    if ((localObject != null) && (((AppBrandInitConfigWC)localObject).nYu))
    {
      overridePendingTransition(au.a.appbrand_ui_push_close_enter, au.a.appbrand_ui_push_close_exit);
      AppMethodBeat.o(48681);
      return;
    }
    if ((((AppBrandInitConfigWC)localObject).nYw) && (!((AppBrandInitConfigWC)localObject).nYb))
    {
      overridePendingTransition(au.a.appbrand_ui_push_close_enter, au.a.appbrand_ui_push_close_exit);
      AppMethodBeat.o(48681);
      return;
    }
    super.overridePendingTransition(this.rhW.ria, this.rhW.rib);
    AppMethodBeat.o(48681);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48674);
    super.onCreate(paramBundle);
    this.qVU = new AppBrandPluginUI.1(this);
    EventCenter.instance.add(this.qVU);
    AppMethodBeat.o(48674);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(246639);
    super.onDestroy();
    EventCenter.instance.removeListener(this.qVU);
    AppMethodBeat.o(246639);
  }
  
  public void onEnterAnimationComplete()
  {
    AppBrandRuntime localAppBrandRuntime = null;
    AppMethodBeat.i(48678);
    super.onEnterAnimationComplete();
    if (cjP())
    {
      if (this.mRuntimeContainer == null) {}
      for (;;)
      {
        if (localAppBrandRuntime != null) {
          localAppBrandRuntime.he(false);
        }
        AppMethodBeat.o(48678);
        return;
        localAppBrandRuntime = this.mRuntimeContainer.getActiveRuntime();
      }
    }
    Log.i("MicroMsg.AppBrandPluginUI", "onEnterAnimationComplete convert PluginUI to translucent");
    b.a(this, null);
    Log.i("MicroMsg.AppBrandPluginUI", "onEnter convertActivityToTranslucent");
    AppMethodBeat.o(48678);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(48676);
    super.onPause();
    if (cjO()) {
      f.d(false, true, true);
    }
    AppMethodBeat.o(48676);
  }
  
  public void onPostCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(246624);
    super.onPostCreate(paramBundle);
    cjN();
    AppMethodBeat.o(246624);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(48675);
    super.onResume();
    cjN();
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