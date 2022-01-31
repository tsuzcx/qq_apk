package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f;

final class BakOperatingUI$6
  implements DialogInterface.OnClickListener
{
  BakOperatingUI$6(BakOperatingUI paramBakOperatingUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = a.avr().avs();
    paramDialogInterface.hOb.cancel();
    paramDialogInterface.hOc.cancel();
    if ((paramDialogInterface.hOf == 1) || (paramDialogInterface.hOj == 2)) {
      e.nO(4);
    }
    for (;;)
    {
      a.avr().avs().hOi = -1;
      paramDialogInterface = a.avr().avt();
      paramDialogInterface.hNN += 1;
      BakOperatingUI.b(this.hPc);
      BakOperatingUI.g(this.hPc);
      return;
      if ((paramDialogInterface.hOf == 6) || (paramDialogInterface.hOj == 4) || (paramDialogInterface.hOj == 6)) {
        e.nO(7);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.6
 * JD-Core Version:    0.7.0.1
 */