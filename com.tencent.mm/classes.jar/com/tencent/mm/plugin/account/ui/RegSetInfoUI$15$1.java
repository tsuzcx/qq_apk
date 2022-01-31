package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ad;

final class RegSetInfoUI$15$1
  implements DialogInterface.OnCancelListener
{
  RegSetInfoUI$15$1(RegSetInfoUI.15 param15, ad paramad) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(125521);
    g.Rc().a(this.gJT);
    g.Rc().b(429, this.gJU.gJQ);
    AppMethodBeat.o(125521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.15.1
 * JD-Core Version:    0.7.0.1
 */