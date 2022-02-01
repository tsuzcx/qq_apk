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
    AppMethodBeat.i(224318);
    paramDialogInterface = new StringBuilder();
    g.ajP();
    paramDialogInterface = paramDialogInterface.append(com.tencent.mm.kernel.a.ajd()).append(",").append(this.jsc.getClass().getName()).append(",RE200_200,");
    g.ajP();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.xB("RE200_200") + ",2");
    com.tencent.mm.plugin.b.a.KB("RE200_100");
    AppMethodBeat.o(224318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.13
 * JD-Core Version:    0.7.0.1
 */