package com.tencent.mm.plugin.dbbackup;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

final class DBRecoveryUI$1
  implements DialogInterface.OnClickListener
{
  DBRecoveryUI$1(DBRecoveryUI paramDBRecoveryUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (DBRecoveryUI.a(this.iMK) != 0)
    {
      DBRecoveryUI.b(this.iMK).setVisibility(0);
      DBRecoveryUI.c(this.iMK).setVisibility(8);
      return;
    }
    d.aFz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.DBRecoveryUI.1
 * JD-Core Version:    0.7.0.1
 */