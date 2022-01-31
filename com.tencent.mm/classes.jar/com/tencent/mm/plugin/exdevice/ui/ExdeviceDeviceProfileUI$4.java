package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.h;

final class ExdeviceDeviceProfileUI$4
  implements Runnable
{
  ExdeviceDeviceProfileUI$4(ExdeviceDeviceProfileUI paramExdeviceDeviceProfileUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(19939);
    ExdeviceDeviceProfileUI localExdeviceDeviceProfileUI = this.lMD;
    this.lMD.getString(2131297087);
    new ap(new ExdeviceDeviceProfileUI.4.1(this, h.b(localExdeviceDeviceProfileUI, this.lMD.getString(2131299365), false, null)), false).ag(1000L, 1000L);
    AppMethodBeat.o(19939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.4
 * JD-Core Version:    0.7.0.1
 */