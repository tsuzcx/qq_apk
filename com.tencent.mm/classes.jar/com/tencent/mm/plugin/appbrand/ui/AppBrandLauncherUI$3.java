package com.tencent.mm.plugin.appbrand.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.sdk.platformtools.ah;

final class AppBrandLauncherUI$3
  implements MenuItem.OnMenuItemClickListener
{
  AppBrandLauncherUI$3(AppBrandLauncherUI paramAppBrandLauncherUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(132973);
    ((m)g.E(m.class)).a(ah.getContext(), new AppBrandLauncherUI.3.1(this));
    AppMethodBeat.o(132973);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.3
 * JD-Core Version:    0.7.0.1
 */