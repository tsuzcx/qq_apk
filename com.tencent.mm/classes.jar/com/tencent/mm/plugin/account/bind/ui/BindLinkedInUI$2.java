package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class BindLinkedInUI$2
  implements MMSwitchBtn.a
{
  BindLinkedInUI$2(BindLinkedInUI paramBindLinkedInUI) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(13388);
    BindLinkedInUI.a(this.gtf, paramBoolean, false);
    AppMethodBeat.o(13388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.2
 * JD-Core Version:    0.7.0.1
 */