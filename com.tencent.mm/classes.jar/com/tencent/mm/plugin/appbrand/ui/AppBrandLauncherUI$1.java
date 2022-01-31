package com.tencent.mm.plugin.appbrand.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandLauncherUI$1
  implements Runnable
{
  AppBrandLauncherUI$1(AppBrandLauncherUI paramAppBrandLauncherUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(132970);
    if ((this.iML.activityHasDestroyed()) || (this.iML.isFinishing()))
    {
      AppMethodBeat.o(132970);
      return;
    }
    Fragment localFragment = AppBrandLauncherUI.a(this.iML).findFragmentById(16908290);
    if ((localFragment == null) || (!(localFragment instanceof AppBrandLauncherUI.Fragment)))
    {
      AppMethodBeat.o(132970);
      return;
    }
    ((AppBrandLauncherUI.Fragment)localFragment).aMd();
    AppMethodBeat.o(132970);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.1
 * JD-Core Version:    0.7.0.1
 */