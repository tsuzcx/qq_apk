package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.u;

final class SimpleLoginUI$6
  implements DialogInterface.OnCancelListener
{
  SimpleLoginUI$6(SimpleLoginUI paramSimpleLoginUI, u paramu) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128762);
    h.aZW().a(this.pZE);
    AppMethodBeat.o(128762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SimpleLoginUI.6
 * JD-Core Version:    0.7.0.1
 */