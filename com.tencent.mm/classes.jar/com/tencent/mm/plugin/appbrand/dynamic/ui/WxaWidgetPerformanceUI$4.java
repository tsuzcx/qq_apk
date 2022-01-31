package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.view.View;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class WxaWidgetPerformanceUI$4
  implements MMSwitchBtn.a
{
  WxaWidgetPerformanceUI$4(WxaWidgetPerformanceUI paramWxaWidgetPerformanceUI, View paramView) {}
  
  public final void cr(boolean paramBoolean)
  {
    f.a("com.tencent.mm:support", new IPCBoolean(paramBoolean), WxaWidgetPerformanceUI.d.class, null);
    c.cK(paramBoolean);
    this.fXD.setEnabled(paramBoolean);
    this.fXB.fXy.setEnabled(paramBoolean);
    this.fXB.fXz.setEnabled(paramBoolean);
    this.fXB.fXA.setEnabled(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI.4
 * JD-Core Version:    0.7.0.1
 */