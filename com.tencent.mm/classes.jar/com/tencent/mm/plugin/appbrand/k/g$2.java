package com.tencent.mm.plugin.appbrand.k;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$2
  implements DialogInterface.OnCancelListener
{
  g$2(g paramg, String paramString) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(102152);
    paramDialogInterface.dismiss();
    g.a(this.isb, this.bEK, a.d.irP);
    AppMethodBeat.o(102152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.g.2
 * JD-Core Version:    0.7.0.1
 */