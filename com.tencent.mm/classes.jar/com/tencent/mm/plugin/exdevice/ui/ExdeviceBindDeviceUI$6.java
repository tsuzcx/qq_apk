package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;

final class ExdeviceBindDeviceUI$6
  implements Runnable
{
  ExdeviceBindDeviceUI$6(ExdeviceBindDeviceUI paramExdeviceBindDeviceUI) {}
  
  public final void run()
  {
    Java2CExDevice.stopScanWCLanDevice();
    Java2CExDevice.releaseWCLanDeviceLib();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.6
 * JD-Core Version:    0.7.0.1
 */