package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.h.c;
import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandLauncherRecentsList$13
  implements Runnable
{
  AppBrandLauncherRecentsList$13(AppBrandLauncherRecentsList paramAppBrandLauncherRecentsList, m paramm1, m paramm2) {}
  
  public final void run()
  {
    AppMethodBeat.i(133346);
    Object localObject = c.a(new n(this.iTu, this.iTv), false);
    AppBrandLauncherRecentsList.a.a(AppBrandLauncherRecentsList.e(this.iTl));
    localObject = new AppBrandLauncherRecentsList.13.1(this, (c.b)localObject);
    AppBrandLauncherRecentsList.e(this.iTl).sendMessage(AppBrandLauncherRecentsList.e(this.iTl).obtainMessage(1, localObject));
    AppMethodBeat.o(133346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.13
 * JD-Core Version:    0.7.0.1
 */