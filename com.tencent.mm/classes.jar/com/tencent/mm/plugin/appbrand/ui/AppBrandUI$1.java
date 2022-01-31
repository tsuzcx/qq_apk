package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.b.e;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.k;

final class AppBrandUI$1
  extends e
{
  AppBrandUI$1(AppBrandUI paramAppBrandUI, Activity paramActivity)
  {
    super(paramActivity);
  }
  
  protected final void acD()
  {
    i locali = AppBrandUI.a(this.hep).ZV();
    if (locali == null) {
      return;
    }
    g.a(locali.mAppId, g.c.fyd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUI.1
 * JD-Core Version:    0.7.0.1
 */