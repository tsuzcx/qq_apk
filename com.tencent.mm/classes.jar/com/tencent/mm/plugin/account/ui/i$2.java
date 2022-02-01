package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;

final class i$2
  implements DialogInterface.OnClickListener
{
  i$2(i parami) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(128264);
    i.a(this.knp);
    paramDialogInterface = new StringBuilder();
    g.aAf();
    paramDialogInterface = paramDialogInterface.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",F200_200,");
    g.aAf();
    com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("F200_200") + ",2");
    AppMethodBeat.o(128264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.i.2
 * JD-Core Version:    0.7.0.1
 */