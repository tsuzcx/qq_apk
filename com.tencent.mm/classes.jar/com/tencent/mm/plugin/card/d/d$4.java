package com.tencent.mm.plugin.card.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$4
  implements DialogInterface.OnClickListener
{
  d$4(d.b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(88829);
    paramDialogInterface.dismiss();
    this.kCh.bei();
    AppMethodBeat.o(88829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.d.4
 * JD-Core Version:    0.7.0.1
 */