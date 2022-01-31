package com.tencent.mm.plugin.exdevice.ui;

import java.util.List;

final class ExdeviceManageDeviceUI$a$6
  implements Runnable
{
  ExdeviceManageDeviceUI$a$6(ExdeviceManageDeviceUI.a parama) {}
  
  public final void run()
  {
    ExdeviceManageDeviceUI.a.a(this.jDH).remove(ExdeviceManageDeviceUI.a.d(this.jDH));
    this.jDH.notifyDataSetChanged();
    ExdeviceManageDeviceUI.a.a(this.jDH, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI.a.6
 * JD-Core Version:    0.7.0.1
 */