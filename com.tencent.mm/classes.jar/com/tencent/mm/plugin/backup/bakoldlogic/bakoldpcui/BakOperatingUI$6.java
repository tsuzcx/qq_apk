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
    AppMethodBeat.i(21994);
    paramDialogInterface = a.cWU().cWV();
    paramDialogInterface.vfa.cancel();
    paramDialogInterface.vfb.cancel();
    if ((paramDialogInterface.vfe == 1) || (paramDialogInterface.vfi == 2)) {
      e.Fx(4);
    }
    for (;;)
    {
      a.cWU().cWV().vfh = -1;
      paramDialogInterface = a.cWU().cWW();
      paramDialogInterface.veM += 1;
      BakOperatingUI.b(this.vfY);
      BakOperatingUI.g(this.vfY);
      AppMethodBeat.o(21994);
      return;
      if ((paramDialogInterface.vfe == 6) || (paramDialogInterface.vfi == 4) || (paramDialogInterface.vfi == 6)) {
        e.Fx(7);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.6
 * JD-Core Version:    0.7.0.1
 */