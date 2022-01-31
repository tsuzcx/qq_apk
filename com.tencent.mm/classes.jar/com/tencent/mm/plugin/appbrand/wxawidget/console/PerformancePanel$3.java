package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class PerformancePanel$3
  implements MMSwitchBtn.a
{
  PerformancePanel$3(PerformancePanel paramPerformancePanel, View paramView) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(11175);
    f.a("com.tencent.mm:support", new IPCBoolean(paramBoolean), PerformancePanel.d.class, null);
    c.dO(paramBoolean);
    this.hrd.setEnabled(paramBoolean);
    this.jxR.hqY.setEnabled(paramBoolean);
    this.jxR.hqZ.setEnabled(paramBoolean);
    this.jxR.hra.setEnabled(paramBoolean);
    AppMethodBeat.o(11175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel.3
 * JD-Core Version:    0.7.0.1
 */