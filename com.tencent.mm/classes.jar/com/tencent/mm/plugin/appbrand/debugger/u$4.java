package com.tencent.mm.plugin.appbrand.debugger;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class u$4
  implements DialogInterface.OnClickListener
{
  u$4(u paramu) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(101919);
    if (u.d(this.hmM) != null) {
      u.d(this.hmM).azc();
    }
    AppMethodBeat.o(101919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.u.4
 * JD-Core Version:    0.7.0.1
 */