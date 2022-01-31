package com.tencent.mm.plugin.appbrand.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandProfileUI$1
  implements MenuItem.OnMenuItemClickListener
{
  AppBrandProfileUI$1(AppBrandProfileUI paramAppBrandProfileUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(133025);
    this.iOj.onBackPressed();
    AppMethodBeat.o(133025);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.1
 * JD-Core Version:    0.7.0.1
 */