package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FreeWifiErrorUI$1
  implements MenuItem.OnMenuItemClickListener
{
  FreeWifiErrorUI$1(FreeWifiErrorUI paramFreeWifiErrorUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(20957);
    this.mNp.finish();
    AppMethodBeat.o(20957);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiErrorUI.1
 * JD-Core Version:    0.7.0.1
 */