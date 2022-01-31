package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class WxaWidgetPerformanceUI$4
  implements MMSwitchBtn.a
{
  WxaWidgetPerformanceUI$4(WxaWidgetPerformanceUI paramWxaWidgetPerformanceUI, View paramView) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(11019);
    f.a("com.tencent.mm:support", new IPCBoolean(paramBoolean), WxaWidgetPerformanceUI.d.class, null);
    c.dO(paramBoolean);
    this.hrd.setEnabled(paramBoolean);
    this.hrb.hqY.setEnabled(paramBoolean);
    this.hrb.hqZ.setEnabled(paramBoolean);
    this.hrb.hra.setEnabled(paramBoolean);
    AppMethodBeat.o(11019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI.4
 * JD-Core Version:    0.7.0.1
 */