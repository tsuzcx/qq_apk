package com.tencent.mm.plugin.appbrand.ui;

import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.os.Bundle;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.p;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.av;
import com.tencent.mm.plugin.appbrand.ba.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.a;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.m;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.wxa_container.AppBrandContainerFragmentActivity.a;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.weishi.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.b;

@a(1)
public class AppBrandPluginUI
  extends AppBrandUI
{
  public int ubA = -1;
  public int ubB = -1;
  private IListener<p> ubC;
  
  private void cLa()
  {
    AppMethodBeat.i(322453);
    if (cLb())
    {
      ae.a(getWindow(), true, false);
      com.tencent.mm.plugin.ball.f.f.d(true, true, true);
      b.a(this, null);
    }
    AppMethodBeat.o(322453);
  }
  
  private boolean cLb()
  {
    AppMethodBeat.i(48677);
    if (this.mRuntimeContainer == null) {}
    for (AppBrandRuntime localAppBrandRuntime = null;; localAppBrandRuntime = this.mRuntimeContainer.getActiveRuntime())
    {
      boolean bool = h.aD(localAppBrandRuntime);
      AppMethodBeat.o(48677);
      return bool;
    }
  }
  
  private boolean cLc()
  {
    AppMethodBeat.i(162169);
    if (cLb())
    {
      AppMethodBeat.o(162169);
      return false;
    }
    Object localObject;
    if (this.mRuntimeContainer == null) {
      localObject = null;
    }
    while ((localObject instanceof w))
    {
      localObject = ((w)localObject).getInitConfig();
      if (((AppBrandInitConfigWC)localObject).aqE() == z.raX)
      {
        AppMethodBeat.o(162169);
        return true;
        localObject = this.mRuntimeContainer.getActiveRuntime();
      }
      else if (((AppBrandInitConfigWC)localObject).aqE() == z.raW)
      {
        AppMethodBeat.o(162169);
        return false;
      }
    }
    try
    {
      localObject = Util.getCurrentTaskInfo(this, getTaskId());
      if ((localObject == null) || (((ActivityManager.RunningTaskInfo)localObject).baseActivity == null)) {
        break label228;
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
    label228:
    if ((localException != null) && (localException.baseActivity != null)) {}
    for (String str1 = localException.baseActivity.getShortClassName();; str1 = "null")
    {
      Log.i("MicroMsg.AppBrandPluginUI", "shouldKeepPluginUIOpaque return false, task.baseActivity=[%s]", new Object[] { str1 });
      AppMethodBeat.o(162169);
      return false;
    }
  }
  
  protected final void aA(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(322500);
    if ((paramAppBrandRuntime != null) && ((AppBrandRuntimeWCAccessible.G(paramAppBrandRuntime)) || (((AppBrandInitConfigWC)paramAppBrandRuntime.asH()).qAT.isEnable())))
    {
      if (!((AppBrandInitConfigWC)paramAppBrandRuntime.asH()).epe) {
        break label116;
      }
      paramAppBrandRuntime.hV(false);
    }
    for (paramAppBrandRuntime.qsI = null;; paramAppBrandRuntime.qsI = new av()
        {
          public final void yW(int paramAnonymousInt)
          {
            AppMethodBeat.i(321985);
            if (1 == paramAnonymousInt)
            {
              Log.i("MicroMsg.AppBrandPluginUI", "load convertActivityToTranslucent");
              b.a(AppBrandPluginUI.this, null);
            }
            AppMethodBeat.o(321985);
          }
        })
    {
      if ((paramAppBrandRuntime instanceof w))
      {
        paramAppBrandRuntime = ((w)paramAppBrandRuntime).getInitConfig();
        if ((y.raT == paramAppBrandRuntime.aqG()) && (!cLc()))
        {
          Log.i("MicroMsg.AppBrandPluginUI", "onRuntimeLoaded, appId:%s, disableEnterAnimation && !keepOpaque, convertActivityToTranslucent", new Object[] { paramAppBrandRuntime.appId });
          b.a(this, null);
        }
      }
      AppMethodBeat.o(322500);
      return;
      label116:
      paramAppBrandRuntime.hV(true);
    }
  }
  
  public final boolean ccf()
  {
    return false;
  }
  
  protected final void e(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(48679);
    if (m.a(this, paramAppBrandInitConfigWC, paramAppBrandStatObject))
    {
      b.a(this, null);
      Log.i("MicroMsg.AppBrandPluginUI", "init convertActivityToTranslucent");
      AppMethodBeat.o(48679);
      return;
    }
    if (y.raT == paramAppBrandInitConfigWC.aqG())
    {
      super.overridePendingTransition(0, 0);
      AppMethodBeat.o(48679);
      return;
    }
    AppBrandInitConfigWC localAppBrandInitConfigWC = getInitConfig();
    if (com.tencent.mm.plugin.appbrand.utils.f.agB(paramAppBrandInitConfigWC.qYj))
    {
      super.overridePendingTransition(0, 0);
      AppMethodBeat.o(48679);
      return;
    }
    if (cLb())
    {
      com.tencent.mm.plugin.appbrand.weishi.f.c(this, paramAppBrandInitConfigWC);
      AppMethodBeat.o(48679);
      return;
    }
    if (paramAppBrandInitConfigWC.qAT.isEnable())
    {
      if (paramAppBrandInitConfigWC.qAT.ez(this) == HalfScreenConfig.a.rae)
      {
        overridePendingTransition(ba.a.appbrand_ui_push_open_enter, 0);
        AppMethodBeat.o(48679);
        return;
      }
      super.overridePendingTransition(this.upS.upU, 0);
      AppMethodBeat.o(48679);
      return;
    }
    if ((localAppBrandInitConfigWC != null) && (localAppBrandInitConfigWC.qYv))
    {
      super.e(paramAppBrandInitConfigWC, paramAppBrandStatObject);
      AppMethodBeat.o(48679);
      return;
    }
    if ((localAppBrandInitConfigWC.qYx) && (!localAppBrandInitConfigWC.qYd))
    {
      super.e(paramAppBrandInitConfigWC, paramAppBrandStatObject);
      AppMethodBeat.o(48679);
      return;
    }
    if (y.raQ != localAppBrandInitConfigWC.aqG())
    {
      t.ueR.a(this, localAppBrandInitConfigWC);
      AppMethodBeat.o(48679);
      return;
    }
    super.overridePendingTransition(this.upS.upU, this.upS.upV);
    AppMethodBeat.o(48679);
  }
  
  protected final void k(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(322496);
    HalfScreenConfig localHalfScreenConfig;
    if (paramAppBrandInitConfigWC == null) {
      localHalfScreenConfig = null;
    }
    while ((localHalfScreenConfig != null) && (localHalfScreenConfig.isEnable())) {
      if ((this.ubA != -1) && (this.ubB != -1))
      {
        overridePendingTransition(this.ubB, this.ubA);
        this.ubA = -1;
        this.ubB = -1;
        AppMethodBeat.o(322496);
        return;
        localHalfScreenConfig = paramAppBrandInitConfigWC.qAT;
      }
      else
      {
        if (localHalfScreenConfig.ez(this) == HalfScreenConfig.a.rae)
        {
          overridePendingTransition(0, ba.a.appbrand_ui_push_close_exit);
          AppMethodBeat.o(322496);
          return;
        }
        super.overridePendingTransition(0, this.upS.upX);
        AppMethodBeat.o(322496);
        return;
      }
    }
    if ((paramAppBrandInitConfigWC == null) || (y.raT == paramAppBrandInitConfigWC.aqH()))
    {
      super.overridePendingTransition(0, 0);
      AppMethodBeat.o(322496);
      return;
    }
    if (paramAppBrandInitConfigWC.qYv)
    {
      overridePendingTransition(ba.a.appbrand_ui_push_close_enter, ba.a.appbrand_ui_push_close_exit);
      AppMethodBeat.o(322496);
      return;
    }
    if ((paramAppBrandInitConfigWC.qYx) && (!paramAppBrandInitConfigWC.qYd))
    {
      overridePendingTransition(ba.a.appbrand_ui_push_close_enter, ba.a.appbrand_ui_push_close_exit);
      AppMethodBeat.o(322496);
      return;
    }
    if (y.raQ != paramAppBrandInitConfigWC.aqH())
    {
      t.ueR.b(this, paramAppBrandInitConfigWC);
      AppMethodBeat.o(322496);
      return;
    }
    super.overridePendingTransition(this.upS.upW, this.upS.upX);
    AppMethodBeat.o(322496);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48674);
    super.onCreate(paramBundle);
    this.ubC = new IListener(com.tencent.mm.app.f.hfK) {};
    this.ubC.alive();
    AppMethodBeat.o(48674);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(322501);
    super.onDestroy();
    this.ubC.dead();
    AppMethodBeat.o(322501);
  }
  
  public void onEnterAnimationComplete()
  {
    AppBrandRuntime localAppBrandRuntime = null;
    AppMethodBeat.i(48678);
    super.onEnterAnimationComplete();
    if (cLc())
    {
      if (this.mRuntimeContainer == null) {}
      for (;;)
      {
        if (localAppBrandRuntime != null) {
          localAppBrandRuntime.hV(false);
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
    if (cLb()) {
      com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    }
    AppMethodBeat.o(48676);
  }
  
  public void onPostCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(322472);
    super.onPostCreate(paramBundle);
    cLa();
    AppMethodBeat.o(322472);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(48675);
    super.onResume();
    cLa();
    AppMethodBeat.o(48675);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI
 * JD-Core Version:    0.7.0.1
 */