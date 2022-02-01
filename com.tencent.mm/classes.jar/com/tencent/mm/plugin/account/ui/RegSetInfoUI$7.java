package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.v;

final class RegSetInfoUI$7
  implements DialogInterface.OnCancelListener
{
  RegSetInfoUI$7(RegSetInfoUI paramRegSetInfoUI, v paramv) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128673);
    h.aGY().a(this.njB);
    h.aGY().b(126, this.njA);
    AppMethodBeat.o(128673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.7
 * JD-Core Version:    0.7.0.1
 */