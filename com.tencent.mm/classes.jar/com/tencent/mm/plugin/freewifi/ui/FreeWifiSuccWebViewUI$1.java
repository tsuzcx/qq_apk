package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FreeWifiSuccWebViewUI$1
  implements MenuItem.OnMenuItemClickListener
{
  FreeWifiSuccWebViewUI$1(FreeWifiSuccWebViewUI paramFreeWifiSuccWebViewUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(21097);
    this.mOO.finish();
    FreeWifiSuccWebViewUI.a(this.mOO);
    AppMethodBeat.o(21097);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccWebViewUI.1
 * JD-Core Version:    0.7.0.1
 */