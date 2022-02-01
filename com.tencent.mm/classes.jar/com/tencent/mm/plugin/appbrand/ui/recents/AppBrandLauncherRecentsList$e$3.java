package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.t;
import com.tencent.mm.plugin.appbrand.report.m;

final class AppBrandLauncherRecentsList$e$3
  implements Runnable
{
  AppBrandLauncherRecentsList$e$3(AppBrandLauncherRecentsList.e parame, AppBrandRecentTaskInfo paramAppBrandRecentTaskInfo, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(49108);
    ((t)n.ag(t.class)).o(this.una.hzi, this.una.eul, true);
    m.a(this.una, 7, this.unb, this.unc);
    AppMethodBeat.o(49108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.e.3
 * JD-Core Version:    0.7.0.1
 */