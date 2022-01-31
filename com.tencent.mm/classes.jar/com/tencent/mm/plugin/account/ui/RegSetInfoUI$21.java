package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RegSetInfoUI$21
  implements DialogInterface.OnClickListener
{
  RegSetInfoUI$21(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125527);
    if (RegSetInfoUI.I(this.gJQ) == 2)
    {
      paramDialogInterface = new Intent(this.gJQ, MobileInputUI.class);
      paramDialogInterface.putExtra("mobile_input_purpose", 2);
    }
    for (;;)
    {
      paramDialogInterface.addFlags(67108864);
      this.gJQ.startActivity(paramDialogInterface);
      this.gJQ.finish();
      AppMethodBeat.o(125527);
      return;
      paramDialogInterface = new Intent(this.gJQ, RegByMobileRegAIOUI.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.21
 * JD-Core Version:    0.7.0.1
 */