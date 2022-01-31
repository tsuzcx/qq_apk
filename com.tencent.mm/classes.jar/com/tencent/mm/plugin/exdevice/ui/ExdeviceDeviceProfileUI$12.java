package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.f;

final class ExdeviceDeviceProfileUI$12
  implements Runnable
{
  ExdeviceDeviceProfileUI$12(ExdeviceDeviceProfileUI paramExdeviceDeviceProfileUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(19949);
    ExdeviceDeviceProfileUI.a(this.lMD, true);
    ExdeviceDeviceProfileUI.f(this.lMD);
    this.lMD.getPreferenceScreen().notifyDataSetChanged();
    AppMethodBeat.o(19949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.12
 * JD-Core Version:    0.7.0.1
 */