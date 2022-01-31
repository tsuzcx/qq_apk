package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class ContactsSyncUI$2
  implements DialogInterface.OnClickListener
{
  ContactsSyncUI$2(ContactsSyncUI paramContactsSyncUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.flj.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ContactsSyncUI.2
 * JD-Core Version:    0.7.0.1
 */