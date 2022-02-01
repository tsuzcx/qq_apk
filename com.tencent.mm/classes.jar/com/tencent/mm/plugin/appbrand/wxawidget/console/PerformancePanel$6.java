package com.tencent.mm.plugin.appbrand.wxawidget.console;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.collector.f;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class PerformancePanel$6
  implements MMSwitchBtn.a
{
  PerformancePanel$6(PerformancePanel paramPerformancePanel) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(121664);
    f.hF(paramBoolean);
    AppMethodBeat.o(121664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel.6
 * JD-Core Version:    0.7.0.1
 */