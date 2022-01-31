package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class LaunchAAByPersonAmountSelectUI$6$2
  implements DialogInterface.OnClickListener
{
  LaunchAAByPersonAmountSelectUI$6$2(LaunchAAByPersonAmountSelectUI.6 param6) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(40794);
    h.qsU.e(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(10) });
    AppMethodBeat.o(40794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.6.2
 * JD-Core Version:    0.7.0.1
 */