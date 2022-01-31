package com.tencent.mm.plugin.bottle.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class BottleWizardStep1$5
  implements DialogInterface.OnClickListener
{
  BottleWizardStep1$5(BottleWizardStep1 paramBottleWizardStep1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.hZK.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleWizardStep1.5
 * JD-Core Version:    0.7.0.1
 */