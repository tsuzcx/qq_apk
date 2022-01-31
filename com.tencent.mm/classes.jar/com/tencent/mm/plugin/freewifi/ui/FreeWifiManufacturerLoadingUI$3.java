package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FreeWifiManufacturerLoadingUI$3
  implements MenuItem.OnMenuItemClickListener
{
  FreeWifiManufacturerLoadingUI$3(FreeWifiManufacturerLoadingUI paramFreeWifiManufacturerLoadingUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(21011);
    this.mOf.finish();
    AppMethodBeat.o(21011);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI.3
 * JD-Core Version:    0.7.0.1
 */