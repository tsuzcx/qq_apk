package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f;
import com.tencent.mm.sdk.platformtools.ab;

final class BakOperatingUI$7
  implements DialogInterface.OnClickListener
{
  BakOperatingUI$7(BakOperatingUI paramBakOperatingUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(17939);
    paramDialogInterface = a.aUU().aUV();
    if (paramDialogInterface.jHH == 1)
    {
      paramDialogInterface.jHD.resume();
      AppMethodBeat.o(17939);
      return;
    }
    if (paramDialogInterface.jHH == 6)
    {
      paramDialogInterface.jHE.resume();
      AppMethodBeat.o(17939);
      return;
    }
    ab.e("MicroMsg.BakPcProcessMgr", "cancel in error state, %d", new Object[] { Integer.valueOf(paramDialogInterface.jHH) });
    AppMethodBeat.o(17939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.7
 * JD-Core Version:    0.7.0.1
 */