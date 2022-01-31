package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.b.a;

final class RegByEmailUI$4
  implements DialogInterface.OnClickListener
{
  RegByEmailUI$4(RegByEmailUI paramRegByEmailUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125304);
    this.gHH.finish();
    a.xD("L2_signup");
    paramDialogInterface = new Intent(this.gHH, LoginPasswordUI.class);
    paramDialogInterface.putExtra("email_address", RegByEmailUI.g(this.gHH));
    this.gHH.startActivity(paramDialogInterface);
    AppMethodBeat.o(125304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByEmailUI.4
 * JD-Core Version:    0.7.0.1
 */