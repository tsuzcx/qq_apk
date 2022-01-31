package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WxaWidgetPerformanceUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WxaWidgetPerformanceUI$1(WxaWidgetPerformanceUI paramWxaWidgetPerformanceUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(11016);
    this.hrb.finish();
    AppMethodBeat.o(11016);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI.1
 * JD-Core Version:    0.7.0.1
 */