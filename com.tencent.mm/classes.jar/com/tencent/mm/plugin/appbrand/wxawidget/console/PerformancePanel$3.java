package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class PerformancePanel$3
  implements MMSwitchBtn.a
{
  PerformancePanel$3(PerformancePanel paramPerformancePanel, View paramView) {}
  
  public final void cr(boolean paramBoolean)
  {
    f.a("com.tencent.mm:support", new IPCBoolean(paramBoolean), PerformancePanel.d.class, null);
    c.cK(paramBoolean);
    this.fXD.setEnabled(paramBoolean);
    this.hEE.fXy.setEnabled(paramBoolean);
    this.hEE.fXz.setEnabled(paramBoolean);
    this.hEE.fXA.setEnabled(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel.3
 * JD-Core Version:    0.7.0.1
 */