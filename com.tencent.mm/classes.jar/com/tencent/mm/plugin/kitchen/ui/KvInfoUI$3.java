package com.tencent.mm.plugin.kitchen.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.k;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class KvInfoUI$3
  implements MMSwitchBtn.a
{
  KvInfoUI$3(KvInfoUI paramKvInfoUI) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(153028);
    k.dyU().pR(paramBoolean);
    AppMethodBeat.o(153028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.kitchen.ui.KvInfoUI.3
 * JD-Core Version:    0.7.0.1
 */