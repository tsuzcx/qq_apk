package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;

final class h$3
  implements DialogInterface.OnClickListener
{
  h$3(h paramh) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(128265);
    paramDialogInterface = new StringBuilder();
    g.ajA();
    paramDialogInterface = paramDialogInterface.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",F200_200,");
    g.ajA();
    com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("F200_200") + ",2");
    AppMethodBeat.o(128265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.h.3
 * JD-Core Version:    0.7.0.1
 */