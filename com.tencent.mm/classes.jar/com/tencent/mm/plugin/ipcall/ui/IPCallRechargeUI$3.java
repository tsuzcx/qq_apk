package com.tencent.mm.plugin.ipcall.ui;

import android.os.Message;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class IPCallRechargeUI$3
  extends MMHandler
{
  IPCallRechargeUI$3(IPCallRechargeUI paramIPCallRechargeUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(25873);
    switch (paramMessage.what)
    {
    default: 
      Log.w("MicroMsg.IPCallRechargeUI", "unknow message, cannt handle.");
      AppMethodBeat.o(25873);
      return;
    }
    this.JOI.JOE.setVisibility(0);
    IPCallRechargeUI.k(this.JOI);
    AppMethodBeat.o(25873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.3
 * JD-Core Version:    0.7.0.1
 */