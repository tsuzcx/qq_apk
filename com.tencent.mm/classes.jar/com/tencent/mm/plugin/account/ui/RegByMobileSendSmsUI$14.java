package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.modelfriend.a;

final class RegByMobileSendSmsUI$14
  implements DialogInterface.OnClickListener
{
  RegByMobileSendSmsUI$14(RegByMobileSendSmsUI paramRegByMobileSendSmsUI, a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125410);
    RegByMobileSendSmsUI.a(this.gIu, this.gIw.getUsername(), this.gIw.agw());
    RegByMobileSendSmsUI.f(this.gIu).cXw = RegByMobileSendSmsUI.e(this.gIu);
    RegByMobileSendSmsUI.f(this.gIu).cRH = 8L;
    RegByMobileSendSmsUI.f(this.gIu).ake();
    AppMethodBeat.o(125410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.14
 * JD-Core Version:    0.7.0.1
 */