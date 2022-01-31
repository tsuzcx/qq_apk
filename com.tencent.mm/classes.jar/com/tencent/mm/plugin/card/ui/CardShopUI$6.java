package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class CardShopUI$6
  implements DialogInterface.OnClickListener
{
  CardShopUI$6(CardShopUI paramCardShopUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.iwP.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardShopUI.6
 * JD-Core Version:    0.7.0.1
 */