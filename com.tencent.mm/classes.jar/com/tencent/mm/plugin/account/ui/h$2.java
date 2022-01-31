package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;

final class h$2
  implements DialogInterface.OnClickListener
{
  h$2(h paramh) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125086);
    h.a(this.gFu);
    paramDialogInterface = new StringBuilder();
    g.RJ();
    paramDialogInterface = paramDialogInterface.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",F200_200,");
    g.RJ();
    com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("F200_200") + ",2");
    AppMethodBeat.o(125086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.h.2
 * JD-Core Version:    0.7.0.1
 */