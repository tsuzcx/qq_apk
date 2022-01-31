package com.tencent.mm.plugin.appbrand.dynamic.ui;

import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class WxaWidgetPerformanceUI$5
  implements MMSwitchBtn.a
{
  WxaWidgetPerformanceUI$5(WxaWidgetPerformanceUI paramWxaWidgetPerformanceUI) {}
  
  public final void cr(boolean paramBoolean)
  {
    f.a("com.tencent.mm:support", new IPCBoolean(paramBoolean), WxaWidgetPerformanceUI.b.class, null);
    if (paramBoolean)
    {
      c.rW("jsapi_draw_canvas");
      return;
    }
    c.rX("jsapi_draw_canvas");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI.5
 * JD-Core Version:    0.7.0.1
 */