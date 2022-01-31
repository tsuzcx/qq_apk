package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;

final class RegByMobileRegAIOUI$10
  implements DialogInterface.OnClickListener
{
  RegByMobileRegAIOUI$10(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(152594);
    paramDialogInterface = new StringBuilder();
    g.RJ();
    paramDialogInterface = paramDialogInterface.append(com.tencent.mm.kernel.a.QX()).append(",").append(this.gIh.getClass().getName()).append(",RE200_200,");
    g.RJ();
    com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("RE200_200") + ",2");
    com.tencent.mm.plugin.b.a.xD("RE200_100");
    AppMethodBeat.o(152594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.10
 * JD-Core Version:    0.7.0.1
 */