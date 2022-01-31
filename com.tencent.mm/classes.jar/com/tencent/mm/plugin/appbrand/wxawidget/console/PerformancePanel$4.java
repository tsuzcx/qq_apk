package com.tencent.mm.plugin.appbrand.wxawidget.console;

import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class PerformancePanel$4
  implements MMSwitchBtn.a
{
  PerformancePanel$4(PerformancePanel paramPerformancePanel) {}
  
  public final void cr(boolean paramBoolean)
  {
    f.a("com.tencent.mm:support", new IPCBoolean(paramBoolean), PerformancePanel.b.class, null);
    if (paramBoolean)
    {
      c.rW("jsapi_draw_canvas");
      return;
    }
    c.rX("jsapi_draw_canvas");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel.4
 * JD-Core Version:    0.7.0.1
 */