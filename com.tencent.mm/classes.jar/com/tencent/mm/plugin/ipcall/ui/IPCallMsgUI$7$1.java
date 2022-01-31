package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.sdk.platformtools.y;

final class IPCallMsgUI$7$1
  implements Runnable
{
  IPCallMsgUI$7$1(IPCallMsgUI.7 param7) {}
  
  public final void run()
  {
    synchronized (IPCallMsgUI.b(this.lwJ.lwI))
    {
      y.v("MicroMsg.IPCallMsgUI", "comment notify");
      IPCallMsgUI.b(this.lwJ.lwI).a(null, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.7.1
 * JD-Core Version:    0.7.0.1
 */