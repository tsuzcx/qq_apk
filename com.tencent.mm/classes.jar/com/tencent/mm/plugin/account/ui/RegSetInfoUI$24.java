package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.b.a;

final class RegSetInfoUI$24
  implements DialogInterface.OnClickListener
{
  RegSetInfoUI$24(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a.qj("R400_100_signup");
    paramDialogInterface = new Intent(this.fso, LoginUI.class);
    paramDialogInterface.addFlags(67108864);
    this.fso.startActivity(paramDialogInterface);
    this.fso.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.24
 * JD-Core Version:    0.7.0.1
 */