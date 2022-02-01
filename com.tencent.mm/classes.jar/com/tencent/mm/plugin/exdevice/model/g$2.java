package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.fj;
import com.tencent.mm.sdk.platformtools.Log;

final class g$2
  implements af.a
{
  g$2(g paramg) {}
  
  public final void a(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(274665);
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "OnScanDevice %s", new Object[] { paramString });
    if (paramArrayOfByte == null) {
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, isCompleted=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    }
    for (;;)
    {
      fj localfj = new fj();
      localfj.hFD.hFv = paramArrayOfByte;
      localfj.hFD.hEl = paramString;
      localfj.hFD.cVt = paramBoolean;
      localfj.asyncPublish(Looper.getMainLooper());
      AppMethodBeat.o(274665);
      return;
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, base64(broadcastData)=%s, isCompleted=%s", new Object[] { paramString, Base64.encodeToString(paramArrayOfByte, 0), Boolean.valueOf(paramBoolean) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.g.2
 * JD-Core Version:    0.7.0.1
 */