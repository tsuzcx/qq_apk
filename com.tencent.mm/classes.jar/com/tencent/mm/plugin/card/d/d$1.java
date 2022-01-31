package com.tencent.mm.plugin.card.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$1
  implements DialogInterface.OnClickListener
{
  d$1(d.b paramb, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(88826);
    paramDialogInterface.dismiss();
    this.kCh.baI();
    AppMethodBeat.o(88826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.d.1
 * JD-Core Version:    0.7.0.1
 */