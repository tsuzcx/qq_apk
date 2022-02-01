package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;

final class h$1$2
  implements DialogInterface.OnClickListener
{
  h$1$2(h.1 param1, b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(46114);
    paramDialogInterface.dismiss();
    this.jrW.aA(Integer.valueOf(0));
    AppMethodBeat.o(46114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.h.1.2
 * JD-Core Version:    0.7.0.1
 */