package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.config.e.a;
import com.tencent.mm.plugin.appbrand.config.e.b;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandUI$2
  implements e.a
{
  AppBrandUI$2(AppBrandUI paramAppBrandUI) {}
  
  public final void a(e.b paramb, boolean paramBoolean)
  {
    y.i("MicroMsg.AppBrandUI", "onOrientationChanged");
    if (!paramBoolean) {
      if (paramb != null) {
        break label34;
      }
    }
    label34:
    for (paramb = "null";; paramb = paramb.name())
    {
      y.e("MicroMsg.AppBrandUI", "OnOrientationChanged failure  ret:[%s]", new Object[] { paramb });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUI.2
 * JD-Core Version:    0.7.0.1
 */