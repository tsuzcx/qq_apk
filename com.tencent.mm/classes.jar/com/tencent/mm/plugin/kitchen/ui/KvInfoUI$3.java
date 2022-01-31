package com.tencent.mm.plugin.kitchen.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.report.service.e;
import com.tencent.mm.plugin.report.service.j;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class KvInfoUI$3
  implements MMSwitchBtn.a
{
  KvInfoUI$3(KvInfoUI paramKvInfoUI) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(114443);
    j localj = j.chT();
    localj.qrC = paramBoolean;
    e.ky(localj.qrC);
    a.ky(localj.qrC);
    AppMethodBeat.o(114443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.kitchen.ui.KvInfoUI.3
 * JD-Core Version:    0.7.0.1
 */