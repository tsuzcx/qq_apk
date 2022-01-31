package com.tencent.mm.plugin.appbrand.widget.desktop;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.appbrand.widget.recentview.b;
import com.tencent.mm.sdk.platformtools.bo;

final class AppBrandDesktopView$4
  implements Runnable
{
  AppBrandDesktopView$4(AppBrandDesktopView paramAppBrandDesktopView, LocalUsageInfo paramLocalUsageInfo, AppBrandStatObject paramAppBrandStatObject, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(143653);
    AppBrandDesktopView.c(this.jfg, 13);
    ((j)g.E(j.class)).a(this.jfg.getContext(), this.jfi.username, null, this.jfi.hcr, -1, null, this.jfj);
    if ((AppBrandDesktopView.c(this.jfg) != null) && (!bo.isNullOrNil(this.jfi.appId)))
    {
      if (this.bHS == 1)
      {
        AppBrandDesktopView.c(this.jfg).bD(this.jfi.appId, this.lU - AppBrandDesktopView.g(this.jfg) + 1);
        AppMethodBeat.o(143653);
        return;
      }
      AppBrandDesktopView.c(this.jfg).bC(this.jfi.appId, this.lU + 1);
    }
    AppMethodBeat.o(143653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.4
 * JD-Core Version:    0.7.0.1
 */