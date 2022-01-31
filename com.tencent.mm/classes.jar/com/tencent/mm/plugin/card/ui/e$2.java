package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$2
  implements DialogInterface.OnClickListener
{
  e$2(e parame) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(88336);
    paramDialogInterface.dismiss();
    if (this.ktX.ktT != null) {
      this.ktX.ktT.bds();
    }
    AppMethodBeat.o(88336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.e.2
 * JD-Core Version:    0.7.0.1
 */