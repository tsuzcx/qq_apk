package com.tencent.mm.plugin.appbrand.dynamic.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.collector.f;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class WxaWidgetPerformanceUI$7
  implements MMSwitchBtn.a
{
  WxaWidgetPerformanceUI$7(WxaWidgetPerformanceUI paramWxaWidgetPerformanceUI) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(11022);
    f.dP(paramBoolean);
    AppMethodBeat.o(11022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI.7
 * JD-Core Version:    0.7.0.1
 */