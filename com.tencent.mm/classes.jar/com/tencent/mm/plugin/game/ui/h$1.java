package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$1
  implements DialogInterface.OnClickListener
{
  h$1(h paramh) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(111799);
    h.a(this.nwE);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(111799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.h.1
 * JD-Core Version:    0.7.0.1
 */