package com.tencent.mm.plugin.appbrand.dynamic.ui;

import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class WxaWidgetPerformanceUI$6
  implements MMSwitchBtn.a
{
  WxaWidgetPerformanceUI$6(WxaWidgetPerformanceUI paramWxaWidgetPerformanceUI) {}
  
  public final void cr(boolean paramBoolean)
  {
    f.a("com.tencent.mm:support", new IPCBoolean(paramBoolean), WxaWidgetPerformanceUI.c.class, null);
    if (paramBoolean)
    {
      c.rW("widget_launch");
      return;
    }
    c.rX("widget_launch");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI.6
 * JD-Core Version:    0.7.0.1
 */