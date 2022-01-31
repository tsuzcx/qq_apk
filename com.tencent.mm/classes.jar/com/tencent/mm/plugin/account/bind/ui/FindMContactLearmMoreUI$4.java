package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;

final class FindMContactLearmMoreUI$4
  implements DialogInterface.OnCancelListener
{
  FindMContactLearmMoreUI$4(FindMContactLearmMoreUI paramFindMContactLearmMoreUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (FindMContactLearmMoreUI.e(this.fdq) != null)
    {
      g.Dk().b(431, FindMContactLearmMoreUI.e(this.fdq));
      FindMContactLearmMoreUI.f(this.fdq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI.4
 * JD-Core Version:    0.7.0.1
 */