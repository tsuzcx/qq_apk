package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;

final class FindMContactAlertUI$10
  implements DialogInterface.OnCancelListener
{
  FindMContactAlertUI$10(FindMContactAlertUI paramFindMContactAlertUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (FindMContactAlertUI.h(this.fdg) != null)
    {
      g.Dk().b(431, FindMContactAlertUI.h(this.fdg));
      FindMContactAlertUI.i(this.fdg);
      FindMContactAlertUI.j(this.fdg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI.10
 * JD-Core Version:    0.7.0.1
 */