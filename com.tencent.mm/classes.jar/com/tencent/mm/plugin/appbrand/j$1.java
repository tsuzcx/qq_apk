package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.widget.input.m;

final class j$1
  implements Runnable
{
  j$1(j paramj, i parami, AppBrandInitConfig paramAppBrandInitConfig) {}
  
  public final void run()
  {
    m.u(this.fzc.fyk);
    if (this.fza == null) {
      this.fzc.ZX();
    }
    i locali = this.fzc.qD(this.fzb.appId);
    if (locali == null)
    {
      locali = this.fzc.ZU();
      this.fzc.a(this.fza, locali, this.fzb);
      locali.Zw();
      return;
    }
    this.fzc.b(this.fza, locali, this.fzb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.1
 * JD-Core Version:    0.7.0.1
 */