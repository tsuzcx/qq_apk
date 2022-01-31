package com.tencent.mm.plugin.account.friend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.ui.MMWizardActivity;

final class FindMContactAddUI$13
  implements DialogInterface.OnClickListener
{
  FindMContactAddUI$13(FindMContactAddUI paramFindMContactAddUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((FindMContactAddUI.k(this.fhv) != null) && (FindMContactAddUI.k(this.fhv).contains("2")))
    {
      paramDialogInterface = new Intent(this.fhv, FindMContactInviteUI.class);
      paramDialogInterface.putExtra("regsetinfo_ticket", FindMContactAddUI.l(this.fhv));
      paramDialogInterface.putExtra("login_type", FindMContactAddUI.m(this.fhv));
      paramDialogInterface.putExtra("regsetinfo_NextStyle", FindMContactAddUI.e(this.fhv));
      MMWizardActivity.C(this.fhv, paramDialogInterface);
      return;
    }
    FindMContactAddUI.n(this.fhv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI.13
 * JD-Core Version:    0.7.0.1
 */