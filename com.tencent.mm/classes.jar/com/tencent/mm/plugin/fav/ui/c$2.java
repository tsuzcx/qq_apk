package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$2
  implements DialogInterface.OnClickListener
{
  c$2(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(73978);
    if (this.mwi != null) {
      this.mwi.onClick(paramDialogInterface, -1);
    }
    AppMethodBeat.o(73978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c.2
 * JD-Core Version:    0.7.0.1
 */