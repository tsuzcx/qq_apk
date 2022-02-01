package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;

final class k$4
  implements DialogInterface.OnClickListener
{
  k$4(k paramk) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(128294);
    paramDialogInterface = new StringBuilder();
    g.agP();
    paramDialogInterface = paramDialogInterface.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_200,");
    g.agP();
    com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("R200_200") + ",2");
    AppMethodBeat.o(128294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.k.4
 * JD-Core Version:    0.7.0.1
 */