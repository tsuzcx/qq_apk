package com.tencent.mm.plugin.bottle.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class BottleBeachUI$6
  implements DialogInterface.OnClickListener
{
  BottleBeachUI$6(BottleBeachUI paramBottleBeachUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.hZb.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleBeachUI.6
 * JD-Core Version:    0.7.0.1
 */