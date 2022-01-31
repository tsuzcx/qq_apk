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
    AppMethodBeat.i(13566);
    l.dx(false);
    paramDialogInterface = new StringBuilder();
    g.RJ();
    paramDialogInterface = paramDialogInterface.append(com.tencent.mm.kernel.a.QX()).append(",").append(this.guR.getClass().getName()).append(",R300_200_phone,");
    g.RJ();
    com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("R300_200_phone") + ",2");
    FindMContactAlertUI.d(this.guR);
    AppMethodBeat.o(13566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI.4
 * JD-Core Version:    0.7.0.1
 */