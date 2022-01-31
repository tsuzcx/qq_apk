package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class ExdeviceManageDeviceUI$a$6
  implements Runnable
{
  ExdeviceManageDeviceUI$a$6(ExdeviceManageDeviceUI.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(19987);
    ExdeviceManageDeviceUI.a.a(this.lNf).remove(ExdeviceManageDeviceUI.a.d(this.lNf));
    this.lNf.notifyDataSetChanged();
    ExdeviceManageDeviceUI.a.a(this.lNf, -1);
    AppMethodBeat.o(19987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI.a.6
 * JD-Core Version:    0.7.0.1
 */