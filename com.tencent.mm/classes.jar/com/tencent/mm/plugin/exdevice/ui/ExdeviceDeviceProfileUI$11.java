package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.f;

final class ExdeviceDeviceProfileUI$11
  implements Runnable
{
  ExdeviceDeviceProfileUI$11(ExdeviceDeviceProfileUI paramExdeviceDeviceProfileUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(19948);
    ExdeviceDeviceProfileUI.a(this.lMD, true);
    ExdeviceDeviceProfileUI.f(this.lMD);
    this.lMD.getPreferenceScreen().notifyDataSetChanged();
    AppMethodBeat.o(19948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.11
 * JD-Core Version:    0.7.0.1
 */