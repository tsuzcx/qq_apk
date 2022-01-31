package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.report.h;

final class AppBrandLauncherRecentsList$e$3
  implements Runnable
{
  AppBrandLauncherRecentsList$e$3(AppBrandLauncherRecentsList.e parame, AppBrandRecentTaskInfo paramAppBrandRecentTaskInfo, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(133386);
    ((s)g.w(s.class)).j(this.iTN.cmx, this.iTN.gXd, true);
    h.a(this.iTN, 7, this.iTO, this.iTP);
    AppMethodBeat.o(133386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.e.3
 * JD-Core Version:    0.7.0.1
 */