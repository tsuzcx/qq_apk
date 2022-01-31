package com.tencent.mm.plugin.appbrand.dynamic.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.b;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class WxaWidgetSettingsUI$3
  implements MMSwitchBtn.a
{
  WxaWidgetSettingsUI$3(WxaWidgetSettingsUI paramWxaWidgetSettingsUI) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(11032);
    DebuggerInfo localDebuggerInfo2 = b.Bg(this.hre.appId);
    DebuggerInfo localDebuggerInfo1 = localDebuggerInfo2;
    if (localDebuggerInfo2 == null)
    {
      localDebuggerInfo1 = new DebuggerInfo();
      b.a(this.hre.appId, localDebuggerInfo1);
    }
    localDebuggerInfo1.hox = paramBoolean;
    AppMethodBeat.o(11032);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetSettingsUI.3
 * JD-Core Version:    0.7.0.1
 */