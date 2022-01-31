package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class BindLinkedInUI$3
  implements MMSwitchBtn.a
{
  BindLinkedInUI$3(BindLinkedInUI paramBindLinkedInUI) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(13389);
    BindLinkedInUI.a(this.gtf, paramBoolean, true);
    AppMethodBeat.o(13389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.3
 * JD-Core Version:    0.7.0.1
 */