package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;

final class SimpleLoginUI$5
  implements DialogInterface.OnCancelListener
{
  SimpleLoginUI$5(SimpleLoginUI paramSimpleLoginUI, s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(125600);
    g.Rc().a(this.gDI);
    AppMethodBeat.o(125600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SimpleLoginUI.5
 * JD-Core Version:    0.7.0.1
 */