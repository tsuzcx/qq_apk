package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.i.r;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

public final class AppBrandPrepareTask
{
  AppBrandPrepareTask.PrepareParams gJm;
  public volatile transient AppBrandPrepareTask.b gJn;
  volatile transient WeakReference<Activity> gJo;
  boolean gJp;
  
  public AppBrandPrepareTask(Activity paramActivity, n paramn)
  {
    AppBrandStatObject localAppBrandStatObject = paramn.aab();
    this.gJm = new AppBrandPrepareTask.PrepareParams();
    this.gJo = new WeakReference(paramActivity);
    AppBrandPrepareTask.PrepareParams.a(this.gJm, paramn.mAppId);
    AppBrandPrepareTask.PrepareParams.a(this.gJm, paramn.fyn.fEL);
    paramActivity = this.gJm;
    if (localAppBrandStatObject == null)
    {
      i = 0;
      AppBrandPrepareTask.PrepareParams.b(paramActivity, i);
      paramActivity = this.gJm;
      if (localAppBrandStatObject != null) {
        break label205;
      }
    }
    label205:
    for (int i = j;; i = localAppBrandStatObject.scene)
    {
      AppBrandPrepareTask.PrepareParams.c(paramActivity, i);
      AppBrandPrepareTask.PrepareParams.b(this.gJm, paramn.aac().fPq);
      AppBrandPrepareTask.PrepareParams.a(this.gJm, paramn.aac().fPr);
      AppBrandPrepareTask.PrepareParams.c(this.gJm, paramn.aac().fJO);
      AppBrandPrepareTask.PrepareParams.a(this.gJm, paramn.ZH());
      AppBrandPrepareTask.PrepareParams.b(this.gJm, paramn.aac().fPD);
      AppBrandPrepareTask.PrepareParams.a(this.gJm, paramn.aac().fPC);
      this.gJp = paramn.ZH();
      return;
      i = localAppBrandStatObject.caB;
      break;
    }
  }
  
  public final void alD()
  {
    if (ai.isMainThread())
    {
      e.post(new AppBrandPrepareTask.1(this), "AppBrandPrepareTask" + this.gJm.toShortString());
      return;
    }
    if (!WxaCommLibRuntimeReader.abO())
    {
      y.i("MicroMsg.AppBrandPrepareTask", "startPrepare(), CommLib not loaded, %s", new Object[] { this.gJm.toShortString() });
      WxaCommLibRuntimeReader.abN();
      r.alA();
    }
    AppBrandPrepareTask.PrepareParams.d(this.gJm, WxaCommLibRuntimeReader.abQ().fEN);
    XIPCInvoker.a("com.tencent.mm", this.gJm, AppBrandPrepareTask.a.class, new AppBrandPrepareTask.2(this));
    y.i("MicroMsg.AppBrandPrepareTask", "[applaunch] startPrepare in appbrand %s, %d", new Object[] { AppBrandPrepareTask.PrepareParams.a(this.gJm), Integer.valueOf(AppBrandPrepareTask.PrepareParams.b(this.gJm)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask
 * JD-Core Version:    0.7.0.1
 */