package com.tencent.mm.plugin.ipcall.ui;

import android.os.Message;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class IPCallRechargeUI$3
  extends ah
{
  IPCallRechargeUI$3(IPCallRechargeUI paramIPCallRechargeUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      y.w("MicroMsg.IPCallRechargeUI", "unknow message, cannt handle.");
      return;
    }
    this.lxJ.lxF.setVisibility(0);
    IPCallRechargeUI.k(this.lxJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.3
 * JD-Core Version:    0.7.0.1
 */