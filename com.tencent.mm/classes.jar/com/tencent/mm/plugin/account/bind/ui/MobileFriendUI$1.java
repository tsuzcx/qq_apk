package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class MobileFriendUI$1
  implements DialogInterface.OnClickListener
{
  MobileFriendUI$1(MobileFriendUI paramMobileFriendUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.fes.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    this.fes.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.1
 * JD-Core Version:    0.7.0.1
 */