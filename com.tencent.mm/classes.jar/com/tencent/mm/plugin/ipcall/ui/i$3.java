package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class i$3
  implements DialogInterface.OnClickListener
{
  i$3(i parami) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(26024);
    Log.i("MicroMsg.TalkUIController", "user choose end this call because isNotFree");
    i.b(this.JQT);
    AppMethodBeat.o(26024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.i.3
 * JD-Core Version:    0.7.0.1
 */