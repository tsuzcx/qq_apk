package com.tencent.mm.plugin.appbrand.dynamic.ui;

import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.b;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class WxaWidgetSettingsUI$2
  implements MMSwitchBtn.a
{
  WxaWidgetSettingsUI$2(WxaWidgetSettingsUI paramWxaWidgetSettingsUI) {}
  
  public final void cr(boolean paramBoolean)
  {
    DebuggerInfo localDebuggerInfo2 = b.te(this.fXE.appId);
    DebuggerInfo localDebuggerInfo1 = localDebuggerInfo2;
    if (localDebuggerInfo2 == null)
    {
      localDebuggerInfo1 = new DebuggerInfo();
      b.a(this.fXE.appId, localDebuggerInfo1);
    }
    localDebuggerInfo1.fUX = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetSettingsUI.2
 * JD-Core Version:    0.7.0.1
 */