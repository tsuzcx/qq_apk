package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;

final class ExdeviceConnectWifiUI$6
  implements Runnable
{
  ExdeviceConnectWifiUI$6(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(19878);
    if ((ExdeviceConnectWifiUI.g(this.lLW) != null) && (ExdeviceConnectWifiUI.g(this.lLW).isShowing())) {
      ExdeviceConnectWifiUI.g(this.lLW).dismiss();
    }
    AppMethodBeat.o(19878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.6
 * JD-Core Version:    0.7.0.1
 */