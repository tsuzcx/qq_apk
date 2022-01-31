package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.ui.base.p;

final class ExdeviceDeviceProfileUI$4$1
  implements ap.a
{
  ExdeviceDeviceProfileUI$4$1(ExdeviceDeviceProfileUI.4 param4, p paramp) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(19938);
    this.lMF.lMD.runOnUiThread(new ExdeviceDeviceProfileUI.4.1.1(this));
    AppMethodBeat.o(19938);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.4.1
 * JD-Core Version:    0.7.0.1
 */