package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class RegSetInfoUI$21
  implements DialogInterface.OnClickListener
{
  RegSetInfoUI$21(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (RegSetInfoUI.H(this.fso) == 2)
    {
      paramDialogInterface = new Intent(this.fso, MobileInputUI.class);
      paramDialogInterface.putExtra("mobile_input_purpose", 2);
    }
    for (;;)
    {
      paramDialogInterface.addFlags(67108864);
      this.fso.startActivity(paramDialogInterface);
      this.fso.finish();
      return;
      paramDialogInterface = new Intent(this.fso, RegByMobileRegAIOUI.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.21
 * JD-Core Version:    0.7.0.1
 */