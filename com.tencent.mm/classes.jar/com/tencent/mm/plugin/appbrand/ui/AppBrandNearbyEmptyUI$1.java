package com.tencent.mm.plugin.appbrand.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandNearbyEmptyUI$1
  implements MenuItem.OnMenuItemClickListener
{
  AppBrandNearbyEmptyUI$1(AppBrandNearbyEmptyUI paramAppBrandNearbyEmptyUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(132992);
    this.iMX.onBackPressed();
    AppMethodBeat.o(132992);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyEmptyUI.1
 * JD-Core Version:    0.7.0.1
 */