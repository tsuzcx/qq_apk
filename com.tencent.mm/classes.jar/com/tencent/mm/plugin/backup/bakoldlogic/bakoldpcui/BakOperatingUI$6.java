package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(17938);
    paramDialogInterface = a.aUU().aUV();
    paramDialogInterface.jHD.cancel();
    paramDialogInterface.jHE.cancel();
    if ((paramDialogInterface.jHH == 1) || (paramDialogInterface.jHL == 2)) {
      e.rC(4);
    }
    for (;;)
    {
      a.aUU().aUV().jHK = -1;
      paramDialogInterface = a.aUU().aUW();
      paramDialogInterface.jHp += 1;
      BakOperatingUI.b(this.jIE);
      BakOperatingUI.g(this.jIE);
      AppMethodBeat.o(17938);
      return;
      if ((paramDialogInterface.jHH == 6) || (paramDialogInterface.jHL == 4) || (paramDialogInterface.jHL == 6)) {
        e.rC(7);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.6
 * JD-Core Version:    0.7.0.1
 */