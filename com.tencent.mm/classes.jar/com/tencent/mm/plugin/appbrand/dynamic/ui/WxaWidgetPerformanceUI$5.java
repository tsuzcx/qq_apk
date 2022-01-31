package com.tencent.mm.plugin.appbrand.dynamic.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class WxaWidgetPerformanceUI$5
  implements MMSwitchBtn.a
{
  WxaWidgetPerformanceUI$5(WxaWidgetPerformanceUI paramWxaWidgetPerformanceUI) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(11020);
    f.a("com.tencent.mm:support", new IPCBoolean(paramBoolean), WxaWidgetPerformanceUI.b.class, null);
    if (paramBoolean)
    {
      c.zM("jsapi_draw_canvas");
      AppMethodBeat.o(11020);
      return;
    }
    c.zN("jsapi_draw_canvas");
    AppMethodBeat.o(11020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI.5
 * JD-Core Version:    0.7.0.1
 */