package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;

final class ExdeviceDeviceProfileUI$2
  implements Runnable
{
  ExdeviceDeviceProfileUI$2(ExdeviceDeviceProfileUI paramExdeviceDeviceProfileUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(19935);
    if ((ExdeviceDeviceProfileUI.g(this.lMD) != null) && (ExdeviceDeviceProfileUI.g(this.lMD).isShowing())) {
      ExdeviceDeviceProfileUI.g(this.lMD).dismiss();
    }
    if ((ExdeviceDeviceProfileUI.h(this.lMD) != null) && (ExdeviceDeviceProfileUI.h(this.lMD).isShowing())) {
      ExdeviceDeviceProfileUI.h(this.lMD).dismiss();
    }
    AppMethodBeat.o(19935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.2
 * JD-Core Version:    0.7.0.1
 */