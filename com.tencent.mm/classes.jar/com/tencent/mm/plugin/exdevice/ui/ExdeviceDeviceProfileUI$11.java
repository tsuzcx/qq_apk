package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.f;

final class ExdeviceDeviceProfileUI$11
  implements Runnable
{
  ExdeviceDeviceProfileUI$11(ExdeviceDeviceProfileUI paramExdeviceDeviceProfileUI) {}
  
  public final void run()
  {
    ExdeviceDeviceProfileUI.a(this.jDf, true);
    ExdeviceDeviceProfileUI.f(this.jDf);
    this.jDf.vdd.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.11
 * JD-Core Version:    0.7.0.1
 */