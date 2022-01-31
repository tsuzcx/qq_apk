package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$4
  implements DialogInterface.OnClickListener
{
  c$4(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(73980);
    paramDialogInterface.dismiss();
    if (this.mwj != null) {
      this.mwj.onClick(paramDialogInterface, -1);
    }
    AppMethodBeat.o(73980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c.4
 * JD-Core Version:    0.7.0.1
 */