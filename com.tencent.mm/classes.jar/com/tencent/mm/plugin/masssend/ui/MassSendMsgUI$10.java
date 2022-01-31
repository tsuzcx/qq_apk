package com.tencent.mm.plugin.masssend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class MassSendMsgUI$10
  implements DialogInterface.OnClickListener
{
  MassSendMsgUI$10(MassSendMsgUI paramMassSendMsgUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.mbI.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.10
 * JD-Core Version:    0.7.0.1
 */