package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.v;

final class RegSetInfoUI$10$1
  implements DialogInterface.OnCancelListener
{
  RegSetInfoUI$10$1(RegSetInfoUI.10 param10, v paramv) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128676);
    h.aGY().a(this.ngm);
    h.aGY().b(126, this.njC.njA);
    AppMethodBeat.o(128676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.10.1
 * JD-Core Version:    0.7.0.1
 */