package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.b;

final class VerifyQQUI$3$1
  implements DialogInterface.OnCancelListener
{
  VerifyQQUI$3$1(VerifyQQUI.3 param3, b paramb) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(13779);
    g.Rc().a(this.gwB);
    AppMethodBeat.o(13779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.VerifyQQUI.3.1
 * JD-Core Version:    0.7.0.1
 */