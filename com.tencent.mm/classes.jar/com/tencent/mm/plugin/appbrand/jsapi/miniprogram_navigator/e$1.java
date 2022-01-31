package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.plugin.appbrand.appcache.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask.a;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.w;

final class e$1
  implements AppBrandPreInitTask.a
{
  e$1(e.b paramb, String paramString1, String paramString2, AppBrandStatObject paramAppBrandStatObject, long paramLong, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, d paramd, int paramInt) {}
  
  public final void a(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    if (paramAppBrandInitConfigWC == null)
    {
      if (this.gwZ != null) {
        this.gwZ.dp(false);
      }
      f.b(this.val$appId, this.dlh, this.gxa);
      return;
    }
    if (this.gwZ != null) {
      this.gwZ.dp(true);
    }
    paramAppBrandInitConfigWC.startTime = this.gxb;
    paramAppBrandInitConfigWC.fPq = a.qQ(this.dlh);
    paramAppBrandInitConfigWC.fPr.a(this.gxc);
    com.tencent.mm.plugin.appbrand.g.a(this.gwW.getAppId(), g.c.fyf);
    if (paramAppBrandInitConfigWC.ZH())
    {
      com.tencent.mm.plugin.appbrand.launching.precondition.g.gMF.a(this.gwW.getContext(), null, this.val$appId, paramAppBrandInitConfigWC.fPq, this.gwI, -1, this.gxa, this.gxc, null);
      return;
    }
    if (this.gwW.getRuntime().ZH())
    {
      e.a(this.gwW.getRuntime(), paramAppBrandInitConfigWC, paramAppBrandStatObject);
      return;
    }
    if ((this.gwW.getRuntime() instanceof n))
    {
      paramAppBrandStatObject = (n)this.gwW.getRuntime();
      AppBrandStatObject localAppBrandStatObject = this.gxa;
      ((k)paramAppBrandStatObject.fyl).a(paramAppBrandStatObject, paramAppBrandInitConfigWC, localAppBrandStatObject);
      return;
    }
    paramAppBrandStatObject = this.gwW.getRuntime();
    paramAppBrandStatObject.fyl.a(paramAppBrandStatObject, paramAppBrandInitConfigWC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e.1
 * JD-Core Version:    0.7.0.1
 */