package com.tencent.mm.plugin.ipcall.ui;

import android.os.Message;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class IPCallRechargeUI$3
  extends ak
{
  IPCallRechargeUI$3(IPCallRechargeUI paramIPCallRechargeUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(22253);
    switch (paramMessage.what)
    {
    default: 
      ab.w("MicroMsg.IPCallRechargeUI", "unknow message, cannt handle.");
      AppMethodBeat.o(22253);
      return;
    }
    this.nUW.nUS.setVisibility(0);
    IPCallRechargeUI.k(this.nUW);
    AppMethodBeat.o(22253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.3
 * JD-Core Version:    0.7.0.1
 */