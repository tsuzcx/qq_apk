package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.input.m;

final class k$1
  implements Runnable
{
  k$1(k paramk, i parami, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject) {}
  
  public final void run()
  {
    m.u(this.fzi.fyk);
    if (this.fza == null) {
      this.fzi.ZX();
    }
    n localn = (n)this.fzi.qD(this.fzg.appId);
    this.fzg.fPE = this.fzh;
    if (localn == null)
    {
      localn = (n)this.fzi.ZU();
      this.fzi.a(this.fza, localn, this.fzg);
      localn.Zw();
    }
    for (;;)
    {
      if (localn.Zx() != null) {
        localn.fyD = true;
      }
      return;
      if (this.fza == localn)
      {
        this.fzi.b(null, localn, this.fzg);
        this.fzi.onResume();
      }
      else
      {
        this.fzi.b(this.fza, localn, this.fzg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.1
 * JD-Core Version:    0.7.0.1
 */