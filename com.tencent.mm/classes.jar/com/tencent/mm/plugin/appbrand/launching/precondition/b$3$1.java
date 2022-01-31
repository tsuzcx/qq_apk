package com.tencent.mm.plugin.appbrand.launching.precondition;

import com.tencent.mm.model.gdpr.a;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f;
import com.tencent.mm.plugin.appbrand.launching.c.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

final class b$3$1
  implements c.a
{
  b$3$1(b.3 param3) {}
  
  public final void c(final AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    if (this.gMv.gMr.isFinishing()) {
      return;
    }
    if (paramAppBrandInitConfigWC == null)
    {
      f.b(this.gMv.gMu.appId, this.gMv.gMu.fPq, this.gMv.gMu.gMm);
      this.gMv.gMr.finish();
      return;
    }
    this.gMv.gMu.a(paramAppBrandInitConfigWC);
    b.a(this.gMv.gMr, paramAppBrandInitConfigWC);
    paramAppBrandStatObject = new Runnable()
    {
      public final void run()
      {
        b.3.1.this.gMv.gMr.d(paramAppBrandInitConfigWC, b.3.1.this.gMv.gMu.gMm);
      }
    };
    if (c.IO())
    {
      c.a(this.gMv.gMr.getBaseContext(), a.dYt, paramAppBrandInitConfigWC.appId, new b.3.1.2(this, paramAppBrandStatObject));
      return;
    }
    if (!this.gMv.gMr.b(paramAppBrandInitConfigWC))
    {
      paramAppBrandStatObject.run();
      return;
    }
    b.a(this.gMv.gMr, paramAppBrandStatObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.b.3.1
 * JD-Core Version:    0.7.0.1
 */