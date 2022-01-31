package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.a;

final class BindLinkedInUI$11
  implements DialogInterface.OnCancelListener
{
  BindLinkedInUI$11(BindLinkedInUI paramBindLinkedInUI, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(13398);
    g.Rc().a(this.gtk);
    AppMethodBeat.o(13398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.11
 * JD-Core Version:    0.7.0.1
 */