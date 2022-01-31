package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class j$3
  implements DialogInterface.OnClickListener
{
  j$3(j paramj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(22401);
    ab.i("MicroMsg.TalkUIController", "user choose end this call because isNotFree");
    j.b(this.nXs);
    AppMethodBeat.o(22401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.j.3
 * JD-Core Version:    0.7.0.1
 */