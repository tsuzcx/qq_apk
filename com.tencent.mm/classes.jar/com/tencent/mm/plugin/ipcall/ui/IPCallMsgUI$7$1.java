package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class IPCallMsgUI$7$1
  implements Runnable
{
  IPCallMsgUI$7$1(IPCallMsgUI.7 param7) {}
  
  public final void run()
  {
    AppMethodBeat.i(22192);
    synchronized (IPCallMsgUI.b(this.nTW.nTV))
    {
      ab.v("MicroMsg.IPCallMsgUI", "comment notify");
      IPCallMsgUI.b(this.nTW.nTV).a(null, null);
      AppMethodBeat.o(22192);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.7.1
 * JD-Core Version:    0.7.0.1
 */