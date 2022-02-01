package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$2
  implements DialogInterface.OnClickListener
{
  e$2(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(106671);
    if (this.qLU != null) {
      this.qLU.onClick(paramDialogInterface, -1);
    }
    AppMethodBeat.o(106671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.2
 * JD-Core Version:    0.7.0.1
 */