package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.platformtools.y;

final class ExdeviceWCLanSDKUtil$5
  implements Runnable
{
  ExdeviceWCLanSDKUtil$5(ExdeviceWCLanSDKUtil paramExdeviceWCLanSDKUtil) {}
  
  public final void run()
  {
    y.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "releaseWCLanDeviceLib...");
    Java2CExDevice.releaseWCLanDeviceLib();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil.5
 * JD-Core Version:    0.7.0.1
 */