package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.storage.z;

final class FindMContactAlertUI$1
  implements DialogInterface.OnClickListener
{
  FindMContactAlertUI$1(FindMContactAlertUI paramFindMContactAlertUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    g.DP().Dz().o(12322, Boolean.valueOf(true));
    com.tencent.mm.plugin.b.a.qj("R200_100");
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("mobile_input_purpose", 4);
    paramDialogInterface.putExtra("regsetinfo_ticket", FindMContactAlertUI.a(this.fdg));
    paramDialogInterface.putExtra("regsetinfo_NextStep", FindMContactAlertUI.b(this.fdg));
    paramDialogInterface.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.c(this.fdg));
    com.tencent.mm.plugin.account.a.a.eUR.a(this.fdg, paramDialogInterface);
    com.tencent.mm.plugin.b.a.qj("R300_300_phone");
    paramDialogInterface = new StringBuilder();
    g.DN();
    paramDialogInterface = paramDialogInterface.append(com.tencent.mm.kernel.a.Df()).append(",").append(this.fdg.getClass().getName()).append(",R300_200_phone,");
    g.DN();
    com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("R300_200_phone") + ",2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI.1
 * JD-Core Version:    0.7.0.1
 */