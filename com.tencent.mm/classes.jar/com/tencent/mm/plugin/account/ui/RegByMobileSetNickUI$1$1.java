package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;

final class RegByMobileSetNickUI$1$1
  implements DialogInterface.OnCancelListener
{
  RegByMobileSetNickUI$1$1(RegByMobileSetNickUI.1 param1, u paramu) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(125428);
    g.Rc().a(this.gIC);
    AppMethodBeat.o(125428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSetNickUI.1.1
 * JD-Core Version:    0.7.0.1
 */