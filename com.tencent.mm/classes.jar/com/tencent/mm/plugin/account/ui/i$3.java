package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.b.a;

final class i$3
  implements DialogInterface.OnClickListener
{
  i$3(i parami) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(128265);
    paramDialogInterface = new StringBuilder();
    h.aHE();
    paramDialogInterface = paramDialogInterface.append(b.aGR()).append(",").append(getClass().getName()).append(",F200_200,");
    h.aHE();
    a.m(true, b.MN("F200_200") + ",2");
    AppMethodBeat.o(128265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.i.3
 * JD-Core Version:    0.7.0.1
 */