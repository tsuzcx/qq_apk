package com.tencent.mm.plugin.appbrand.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandLauncherUI$2
  implements MenuItem.OnMenuItemClickListener
{
  AppBrandLauncherUI$2(AppBrandLauncherUI paramAppBrandLauncherUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(132971);
    this.iML.onBackPressed();
    AppMethodBeat.o(132971);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.2
 * JD-Core Version:    0.7.0.1
 */