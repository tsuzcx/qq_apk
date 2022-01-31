package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class FindMContactAlertUI$10
  implements DialogInterface.OnCancelListener
{
  FindMContactAlertUI$10(FindMContactAlertUI paramFindMContactAlertUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(13572);
    if (FindMContactAlertUI.h(this.guR) != null)
    {
      g.Rc().b(431, FindMContactAlertUI.h(this.guR));
      FindMContactAlertUI.i(this.guR);
      FindMContactAlertUI.j(this.guR);
    }
    AppMethodBeat.o(13572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI.10
 * JD-Core Version:    0.7.0.1
 */