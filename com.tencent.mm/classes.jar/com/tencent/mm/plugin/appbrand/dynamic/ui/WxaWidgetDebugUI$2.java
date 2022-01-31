package com.tencent.mm.plugin.appbrand.dynamic.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.a.a;
import com.tencent.mm.plugin.appbrand.widget.l;
import com.tencent.mm.plugin.appbrand.widget.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class WxaWidgetDebugUI$2
  implements MMSwitchBtn.a
{
  WxaWidgetDebugUI$2(WxaWidgetDebugUI paramWxaWidgetDebugUI) {}
  
  public final void cr(boolean paramBoolean)
  {
    this.fXw.fXv.field_openDebug = paramBoolean;
    m localm = ((a)g.r(a.class)).aaW();
    l locall = this.fXw.fXv;
    if ((locall != null) && (!bk.bl(locall.field_appId)))
    {
      locall.field_appIdHash = locall.field_appId.hashCode();
      localm.a(locall);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI.2
 * JD-Core Version:    0.7.0.1
 */