package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExdeviceConnectedRouterActivateStateUI$1$1
  implements Runnable
{
  ExdeviceConnectedRouterActivateStateUI$1$1(ExdeviceConnectedRouterActivateStateUI.1 param1, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(19917);
    if ((this.val$errCode == 0) && ((this.val$errType == 0) || (this.val$errType == 4)))
    {
      this.lMr.lMq.vc(2);
      AppMethodBeat.o(19917);
      return;
    }
    if (this.val$errType == 4)
    {
      if (this.val$errCode == 90000)
      {
        this.lMr.lMq.vc(3);
        AppMethodBeat.o(19917);
        return;
      }
      this.lMr.lMq.vc(5);
      AppMethodBeat.o(19917);
      return;
    }
    this.lMr.lMq.vc(4);
    AppMethodBeat.o(19917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectedRouterActivateStateUI.1.1
 * JD-Core Version:    0.7.0.1
 */