package com.tencent.mm.plugin.appbrand.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.sdk.platformtools.ae;

final class AppBrandLauncherUI$3
  implements MenuItem.OnMenuItemClickListener
{
  AppBrandLauncherUI$3(AppBrandLauncherUI paramAppBrandLauncherUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    ((m)g.r(m.class)).a(ae.getContext(), new AppBrandLauncherUI.3.1(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.3
 * JD-Core Version:    0.7.0.1
 */