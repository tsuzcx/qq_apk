package com.tencent.mm.plugin.appbrand.wxawidget.console;

import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class PerformancePanel$5
  implements MMSwitchBtn.a
{
  PerformancePanel$5(PerformancePanel paramPerformancePanel) {}
  
  public final void cr(boolean paramBoolean)
  {
    f.a("com.tencent.mm:support", new IPCBoolean(paramBoolean), PerformancePanel.c.class, null);
    if (paramBoolean)
    {
      c.rW("widget_launch");
      return;
    }
    c.rX("widget_launch");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel.5
 * JD-Core Version:    0.7.0.1
 */