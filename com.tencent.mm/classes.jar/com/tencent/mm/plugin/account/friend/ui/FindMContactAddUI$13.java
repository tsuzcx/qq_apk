package com.tencent.mm.plugin.account.friend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMWizardActivity;

final class FindMContactAddUI$13
  implements DialogInterface.OnClickListener
{
  FindMContactAddUI$13(FindMContactAddUI paramFindMContactAddUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(108525);
    if ((FindMContactAddUI.k(this.gzd) != null) && (FindMContactAddUI.k(this.gzd).contains("2")))
    {
      paramDialogInterface = new Intent(this.gzd, FindMContactInviteUI.class);
      paramDialogInterface.putExtra("regsetinfo_ticket", FindMContactAddUI.l(this.gzd));
      paramDialogInterface.putExtra("login_type", FindMContactAddUI.m(this.gzd));
      paramDialogInterface.putExtra("regsetinfo_NextStyle", FindMContactAddUI.e(this.gzd));
      MMWizardActivity.J(this.gzd, paramDialogInterface);
      AppMethodBeat.o(108525);
      return;
    }
    FindMContactAddUI.n(this.gzd);
    AppMethodBeat.o(108525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI.13
 * JD-Core Version:    0.7.0.1
 */