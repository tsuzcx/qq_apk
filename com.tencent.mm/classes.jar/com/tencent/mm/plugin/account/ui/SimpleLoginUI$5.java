package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;

final class SimpleLoginUI$5
  implements DialogInterface.OnCancelListener
{
  SimpleLoginUI$5(SimpleLoginUI paramSimpleLoginUI, com.tencent.mm.modelsimple.t paramt) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128762);
    h.aGY().a(this.ndz);
    AppMethodBeat.o(128762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SimpleLoginUI.5
 * JD-Core Version:    0.7.0.1
 */