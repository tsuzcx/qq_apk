package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WidgetConsoleUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WidgetConsoleUI$1(WidgetConsoleUI paramWidgetConsoleUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(11002);
    this.hqS.finish();
    AppMethodBeat.o(11002);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WidgetConsoleUI.1
 * JD-Core Version:    0.7.0.1
 */