package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f;
import com.tencent.mm.sdk.platformtools.Log;

final class BakOperatingUI$7
  implements DialogInterface.OnClickListener
{
  BakOperatingUI$7(BakOperatingUI paramBakOperatingUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(21995);
    paramDialogInterface = a.cWU().cWV();
    if (paramDialogInterface.vfe == 1)
    {
      paramDialogInterface.vfa.resume();
      AppMethodBeat.o(21995);
      return;
    }
    if (paramDialogInterface.vfe == 6)
    {
      paramDialogInterface.vfb.resume();
      AppMethodBeat.o(21995);
      return;
    }
    Log.e("MicroMsg.BakPcProcessMgr", "cancel in error state, %d", new Object[] { Integer.valueOf(paramDialogInterface.vfe) });
    AppMethodBeat.o(21995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.7
 * JD-Core Version:    0.7.0.1
 */