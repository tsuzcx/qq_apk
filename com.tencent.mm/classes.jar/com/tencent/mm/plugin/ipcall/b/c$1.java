package com.tencent.mm.plugin.ipcall.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$1
  implements DialogInterface.OnClickListener
{
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(22467);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(22467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.b.c.1
 * JD-Core Version:    0.7.0.1
 */