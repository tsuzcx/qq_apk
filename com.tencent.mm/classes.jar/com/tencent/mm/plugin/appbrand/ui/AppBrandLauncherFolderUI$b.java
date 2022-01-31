package com.tencent.mm.plugin.appbrand.ui;

import a.l;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class AppBrandLauncherFolderUI$b
  implements MenuItem.OnMenuItemClickListener
{
  AppBrandLauncherFolderUI$b(AppBrandLauncherFolderUI paramAppBrandLauncherFolderUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(134989);
    this.iME.finish();
    AppMethodBeat.o(134989);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI.b
 * JD-Core Version:    0.7.0.1
 */