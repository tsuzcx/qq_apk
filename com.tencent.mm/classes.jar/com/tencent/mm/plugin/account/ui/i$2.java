package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.b.a;

final class i$2
  implements DialogInterface.OnClickListener
{
  i$2(i parami) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(128264);
    i.a(this.qcp);
    paramDialogInterface = new StringBuilder();
    h.baC();
    paramDialogInterface = paramDialogInterface.append(b.aZR()).append(",").append(getClass().getName()).append(",F200_200,");
    h.baC();
    a.z(true, b.Fw("F200_200") + ",2");
    AppMethodBeat.o(128264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.i.2
 * JD-Core Version:    0.7.0.1
 */