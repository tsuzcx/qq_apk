package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class j$6
  implements DialogInterface.OnClickListener
{
  j$6(j paramj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(22404);
    this.nXs.nXh.finish();
    this.nXs.nXh = null;
    AppMethodBeat.o(22404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.j.6
 * JD-Core Version:    0.7.0.1
 */