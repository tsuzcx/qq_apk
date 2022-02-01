package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;

final class i$1$2
  implements DialogInterface.OnClickListener
{
  i$1$2(i.1 param1, b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(46114);
    paramDialogInterface.dismiss();
    this.ltB.invoke(Integer.valueOf(0));
    AppMethodBeat.o(46114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.i.1.2
 * JD-Core Version:    0.7.0.1
 */