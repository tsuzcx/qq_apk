package com.tencent.mm.plugin.appbrand.ui;

import a.l;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class AppBrandLauncherFolderUI$c
  implements Runnable
{
  AppBrandLauncherFolderUI$c(AppBrandLauncherFolderUI paramAppBrandLauncherFolderUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(134990);
    Fragment localFragment = this.iME.getSupportFragmentManager().findFragmentById(16908290);
    Object localObject = localFragment;
    if (!(localFragment instanceof AppBrandLauncherUI.Fragment)) {
      localObject = null;
    }
    localObject = (AppBrandLauncherUI.Fragment)localObject;
    if (localObject != null)
    {
      ((AppBrandLauncherUI.Fragment)localObject).aMd();
      AppMethodBeat.o(134990);
      return;
    }
    AppMethodBeat.o(134990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI.c
 * JD-Core Version:    0.7.0.1
 */