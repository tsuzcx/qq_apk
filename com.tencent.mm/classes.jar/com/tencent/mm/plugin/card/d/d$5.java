package com.tencent.mm.plugin.card.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$5
  implements DialogInterface.OnClickListener
{
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(88830);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(88830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.d.5
 * JD-Core Version:    0.7.0.1
 */