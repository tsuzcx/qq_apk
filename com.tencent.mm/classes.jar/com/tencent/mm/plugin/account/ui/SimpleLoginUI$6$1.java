package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;

final class SimpleLoginUI$6$1
  implements DialogInterface.OnCancelListener
{
  SimpleLoginUI$6$1(SimpleLoginUI.6 param6, s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128763);
    g.agi().a(this.iRy);
    AppMethodBeat.o(128763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SimpleLoginUI.6.1
 * JD-Core Version:    0.7.0.1
 */