package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.ui.base.h;

final class ExdeviceDeviceProfileUI$4
  implements Runnable
{
  ExdeviceDeviceProfileUI$4(ExdeviceDeviceProfileUI paramExdeviceDeviceProfileUI) {}
  
  public final void run()
  {
    ExdeviceDeviceProfileUI localExdeviceDeviceProfileUI = this.jDf;
    this.jDf.getString(R.l.app_tip);
    new am(new ExdeviceDeviceProfileUI.4.1(this, h.b(localExdeviceDeviceProfileUI, this.jDf.getString(R.l.exdevice_bound), false, null)), false).S(1000L, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.4
 * JD-Core Version:    0.7.0.1
 */