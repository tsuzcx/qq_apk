package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallTalkUI$1
  implements Runnable
{
  IPCallTalkUI$1(IPCallTalkUI paramIPCallTalkUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(25981);
    Intent localIntent = new Intent();
    this.uUM.setResult(-1, localIntent);
    this.uUM.finish();
    AppMethodBeat.o(25981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI.1
 * JD-Core Version:    0.7.0.1
 */