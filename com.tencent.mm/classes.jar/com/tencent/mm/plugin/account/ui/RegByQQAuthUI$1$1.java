package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;

final class RegByQQAuthUI$1$1
  implements DialogInterface.OnCancelListener
{
  RegByQQAuthUI$1$1(RegByQQAuthUI.1 param1, u paramu) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(125498);
    g.Rc().a(this.gJo);
    AppMethodBeat.o(125498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByQQAuthUI.1.1
 * JD-Core Version:    0.7.0.1
 */