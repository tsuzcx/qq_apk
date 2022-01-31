package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.friend.a.l;

final class FindMContactAlertUI$5
  implements DialogInterface.OnClickListener
{
  FindMContactAlertUI$5(FindMContactAlertUI paramFindMContactAlertUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(13567);
    l.dx(true);
    FindMContactAlertUI.e(this.guR);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(13567);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI.5
 * JD-Core Version:    0.7.0.1
 */