package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.platformtools.y;

final class g$8
  implements Runnable
{
  g$8(g paramg) {}
  
  public final void run()
  {
    y.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "releaseWCLanDeviceLib...");
    Java2CExDevice.releaseWCLanDeviceLib();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.g.8
 * JD-Core Version:    0.7.0.1
 */