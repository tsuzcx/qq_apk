package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class j$3
  implements DialogInterface.OnClickListener
{
  j$3(j paramj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(26024);
    Log.i("MicroMsg.TalkUIController", "user choose end this call because isNotFree");
    j.b(this.yzT);
    AppMethodBeat.o(26024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.j.3
 * JD-Core Version:    0.7.0.1
 */