package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;

final class RegByMobileRegAIOUI$13
  implements DialogInterface.OnClickListener
{
  RegByMobileRegAIOUI$13(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(196924);
    paramDialogInterface = new StringBuilder();
    g.aAf();
    paramDialogInterface = paramDialogInterface.append(com.tencent.mm.kernel.a.azt()).append(",").append(this.kqp.getClass().getName()).append(",RE200_200,");
    g.aAf();
    com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("RE200_200") + ",2");
    com.tencent.mm.plugin.b.a.bwV("RE200_100");
    AppMethodBeat.o(196924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.13
 * JD-Core Version:    0.7.0.1
 */