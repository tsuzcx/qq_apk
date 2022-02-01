package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.platformtools.ac;

final class g$8
  implements Runnable
{
  g$8(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(23326);
    ac.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "releaseWCLanDeviceLib...");
    Java2CExDevice.releaseWCLanDeviceLib();
    AppMethodBeat.o(23326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.g.8
 * JD-Core Version:    0.7.0.1
 */