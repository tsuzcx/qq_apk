package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.b.a;

final class l$4
  implements DialogInterface.OnClickListener
{
  l$4(l paraml) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(128294);
    paramDialogInterface = new StringBuilder();
    h.aHE();
    paramDialogInterface = paramDialogInterface.append(b.aGR()).append(",").append(getClass().getName()).append(",R200_200,");
    h.aHE();
    a.m(true, b.MN("R200_200") + ",2");
    AppMethodBeat.o(128294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.l.4
 * JD-Core Version:    0.7.0.1
 */