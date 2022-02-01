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
    AppMethodBeat.i(128688);
    if (RegSetInfoUI.I(this.jqJ) == 2)
    {
      paramDialogInterface = new Intent(this.jqJ, MobileInputUI.class);
      paramDialogInterface.putExtra("mobile_input_purpose", 2);
    }
    for (;;)
    {
      paramDialogInterface.addFlags(67108864);
      RegSetInfoUI localRegSetInfoUI = this.jqJ;
      paramDialogInterface = new com.tencent.mm.hellhoundlib.b.a().bc(paramDialogInterface);
      com.tencent.mm.hellhoundlib.a.a.a(localRegSetInfoUI, paramDialogInterface.ahp(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$28", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localRegSetInfoUI.startActivity((Intent)paramDialogInterface.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(localRegSetInfoUI, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$28", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.jqJ.finish();
      AppMethodBeat.o(128688);
      return;
      paramDialogInterface = new Intent(this.jqJ, RegByMobileRegAIOUI.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.21
 * JD-Core Version:    0.7.0.1
 */