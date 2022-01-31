package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class AASelectContactUI$4$2
  implements DialogInterface.OnClickListener
{
  AASelectContactUI$4$2(AASelectContactUI.4 param4) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(40753);
    this.gpX.gpV.finish();
    h.qsU.e(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(10) });
    AppMethodBeat.o(40753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AASelectContactUI.4.2
 * JD-Core Version:    0.7.0.1
 */