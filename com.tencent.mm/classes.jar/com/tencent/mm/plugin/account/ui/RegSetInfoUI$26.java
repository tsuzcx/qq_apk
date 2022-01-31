package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.b.a;

final class RegSetInfoUI$26
  implements DialogInterface.OnClickListener
{
  RegSetInfoUI$26(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125532);
    a.xD("R500_100");
    paramDialogInterface = new Intent(this.gJQ, RegByEmailUI.class);
    paramDialogInterface.addFlags(67108864);
    this.gJQ.startActivity(paramDialogInterface);
    this.gJQ.finish();
    AppMethodBeat.o(125532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.26
 * JD-Core Version:    0.7.0.1
 */