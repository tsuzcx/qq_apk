package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.ui.MMWizardActivity;

final class BindMContactIntroUI$26
  implements DialogInterface.OnClickListener
{
  BindMContactIntroUI$26(BindMContactIntroUI paramBindMContactIntroUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    MMWizardActivity.C(this.fbF, new Intent(this.fbF, BindMContactStatusUI.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.26
 * JD-Core Version:    0.7.0.1
 */