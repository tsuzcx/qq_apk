package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WxaWidgetDebugUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WxaWidgetDebugUI$1(WxaWidgetDebugUI paramWxaWidgetDebugUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(11010);
    this.hqW.finish();
    AppMethodBeat.o(11010);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI.1
 * JD-Core Version:    0.7.0.1
 */