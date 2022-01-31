package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;

final class FindMContactIntroUI$10
  implements DialogInterface.OnCancelListener
{
  FindMContactIntroUI$10(FindMContactIntroUI paramFindMContactIntroUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (FindMContactIntroUI.i(this.fdm) != null)
    {
      g.Dk().b(431, FindMContactIntroUI.i(this.fdm));
      FindMContactIntroUI.j(this.fdm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI.10
 * JD-Core Version:    0.7.0.1
 */