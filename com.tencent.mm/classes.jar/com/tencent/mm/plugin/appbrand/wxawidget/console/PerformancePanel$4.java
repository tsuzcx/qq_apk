package com.tencent.mm.plugin.appbrand.wxawidget.console;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class PerformancePanel$4
  implements MMSwitchBtn.a
{
  PerformancePanel$4(PerformancePanel paramPerformancePanel) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(11176);
    f.a("com.tencent.mm:support", new IPCBoolean(paramBoolean), PerformancePanel.b.class, null);
    if (paramBoolean)
    {
      c.zM("jsapi_draw_canvas");
      AppMethodBeat.o(11176);
      return;
    }
    c.zN("jsapi_draw_canvas");
    AppMethodBeat.o(11176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel.4
 * JD-Core Version:    0.7.0.1
 */