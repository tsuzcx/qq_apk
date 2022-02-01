package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.l;

final class FindMContactAlertUI$4
  implements DialogInterface.OnClickListener
{
  FindMContactAlertUI$4(FindMContactAlertUI paramFindMContactAlertUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(109990);
    l.fn(false);
    paramDialogInterface = new StringBuilder();
    g.agP();
    paramDialogInterface = paramDialogInterface.append(com.tencent.mm.kernel.a.agc()).append(",").append(this.iHY.getClass().getName()).append(",R300_200_phone,");
    g.agP();
    com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("R300_200_phone") + ",2");
    FindMContactAlertUI.d(this.iHY);
    AppMethodBeat.o(109990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI.4
 * JD-Core Version:    0.7.0.1
 */