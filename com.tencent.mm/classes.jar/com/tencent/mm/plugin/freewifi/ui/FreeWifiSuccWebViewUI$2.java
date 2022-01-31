package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FreeWifiSuccWebViewUI$2
  implements MenuItem.OnMenuItemClickListener
{
  FreeWifiSuccWebViewUI$2(FreeWifiSuccWebViewUI paramFreeWifiSuccWebViewUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(21098);
    this.mOO.finish();
    FreeWifiSuccWebViewUI.a(this.mOO);
    AppMethodBeat.o(21098);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccWebViewUI.2
 * JD-Core Version:    0.7.0.1
 */