package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.z;

final class FindMContactAlertUI$4
  implements DialogInterface.OnClickListener
{
  FindMContactAlertUI$4(FindMContactAlertUI paramFindMContactAlertUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    g.DP().Dz().o(12322, Boolean.valueOf(false));
    paramDialogInterface = new StringBuilder();
    g.DN();
    paramDialogInterface = paramDialogInterface.append(com.tencent.mm.kernel.a.Df()).append(",").append(this.fdg.getClass().getName()).append(",R300_200_phone,");
    g.DN();
    com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("R300_200_phone") + ",2");
    FindMContactAlertUI.d(this.fdg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI.4
 * JD-Core Version:    0.7.0.1
 */