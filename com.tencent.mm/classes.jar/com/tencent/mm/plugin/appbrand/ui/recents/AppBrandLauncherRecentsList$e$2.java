package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandLauncherRecentsList$e$2
  implements Runnable
{
  AppBrandLauncherRecentsList$e$2(AppBrandLauncherRecentsList.e parame, AppBrandRecentTaskInfo paramAppBrandRecentTaskInfo, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(133385);
    if (!this.iTN.hcd)
    {
      i = ((s)g.w(s.class)).aH(this.iTN.cmx, this.iTN.gXd);
      if (i == -2)
      {
        this.iTM.iTl.runOnUiThread(new AppBrandLauncherRecentsList.e.2.1(this));
        AppMethodBeat.o(133385);
        return;
      }
      if (i == -1)
      {
        ab.e("MicroMsg.AppBrandLauncherRecentsList", "addStarApp, username %s, type %d, fatal", new Object[] { this.iTN.cmx, Integer.valueOf(this.iTN.gXd) });
        AppMethodBeat.o(133385);
        return;
      }
    }
    for (int i = 6;; i = 7)
    {
      h.a(this.iTN, i, this.iTO, this.iTP);
      AppMethodBeat.o(133385);
      return;
      ((s)g.w(s.class)).j(this.iTN.cmx, this.iTN.gXd, true);
      if ((!AppBrandLauncherRecentsList.i(this.iTM.iTl)) && (AppBrandLauncherRecentsList.n(this.iTM.iTl))) {
        g.auK().a(this.iTN.cmx, this.iTN.gXd, false, 0, 2, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.e.2
 * JD-Core Version:    0.7.0.1
 */