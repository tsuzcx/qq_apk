package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;

final class RegSetInfoUI$10$1
  implements DialogInterface.OnCancelListener
{
  RegSetInfoUI$10$1(RegSetInfoUI.10 param10, u paramu) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(125515);
    g.Rc().a(this.gGA);
    g.Rc().b(126, this.gJS.gJQ);
    AppMethodBeat.o(125515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.10.1
 * JD-Core Version:    0.7.0.1
 */