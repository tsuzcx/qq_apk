package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.ah.a;
import com.tencent.mm.plugin.appbrand.appusage.q;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.appusage.y;
import com.tencent.mm.plugin.appbrand.appusage.y.c;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.protocal.protobuf.bdr;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

final class AppBrandLauncherRecentsList$11
  implements Runnable
{
  AppBrandLauncherRecentsList$11(AppBrandLauncherRecentsList paramAppBrandLauncherRecentsList) {}
  
  public final void run()
  {
    Object localObject3 = null;
    AppMethodBeat.i(49063);
    final ArrayList localArrayList = AppBrandLauncherRecentsList.m(this.lId).A(com.tencent.mm.plugin.appbrand.app.j.aOI().iVr.mT(9223372036854775807L));
    AppBrandLauncherRecentsList.t(this.lId);
    int m = this.lId.mScene;
    String str = this.lId.lzN;
    Object localObject1;
    Object localObject2;
    int i;
    if ((localArrayList == null) || (localArrayList.size() <= 0))
    {
      localObject1 = null;
      localObject2 = "";
      bdr localbdr = q.aRN();
      if (localbdr == null) {
        break label346;
      }
      i = localbdr.msf;
      localObject2 = localbdr.DBc;
    }
    for (;;)
    {
      h.a(m, "", (String)localObject1, i, (String)localObject2, str);
      if (AppBrandLauncherRecentsList.i(this.lId)) {
        localObject1 = new ArrayList(0);
      }
      for (;;)
      {
        this.lId.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(49062);
            AppBrandLauncherRecentsList.u(AppBrandLauncherRecentsList.11.this.lId);
            AppBrandLauncherRecentsList.a(AppBrandLauncherRecentsList.11.this.lId, this.lIj, localArrayList, false);
            AppMethodBeat.o(49062);
          }
        });
        com.tencent.mm.plugin.appbrand.appusage.j.aRE().a(AppBrandLauncherRecentsList.j(this.lId).get(), true, AppBrandLauncherRecentsList.v(this.lId), AppBrandLauncherRecentsList.w(this.lId), AppBrandLauncherRecentsList.x(this.lId));
        AppBrandLauncherRecentsList.y(this.lId).set(true);
        AppMethodBeat.o(49063);
        return;
        localObject1 = new StringBuilder();
        i = 0;
        int k;
        for (int j = 0; i < localArrayList.size(); j = k)
        {
          localObject2 = localArrayList.get(i);
          k = j;
          if ((localObject2 instanceof AppBrandRecentTaskInfo))
          {
            localObject2 = (AppBrandRecentTaskInfo)localObject2;
            k = j + 1;
            ((StringBuilder)localObject1).append(((AppBrandRecentTaskInfo)localObject2).appId);
            if ((k == 20) || (k >= localArrayList.size())) {
              break;
            }
            ((StringBuilder)localObject1).append(":#:");
          }
          i += 1;
        }
        localObject1 = ((StringBuilder)localObject1).toString();
        break;
        localObject1 = localObject3;
        if (AppBrandLauncherRecentsList.n(this.lId)) {
          localObject1 = ((u)com.tencent.mm.plugin.appbrand.app.j.T(u.class)).a(ah.a.iVM);
        }
      }
      label346:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.11
 * JD-Core Version:    0.7.0.1
 */