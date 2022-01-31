package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import android.util.Base64;
import com.tencent.mm.h.a.ea;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class e$37
  implements aa.a
{
  e$37(e parame) {}
  
  public final void a(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    y.i("MicroMsg.exdevice.ExdeviceEventManager", "OnScanDevice %s", new Object[] { paramString });
    if (paramArrayOfByte == null) {
      y.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, isCompleted=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    }
    for (;;)
    {
      ea localea = new ea();
      localea.bKA.bKs = paramArrayOfByte;
      localea.bKA.bwK = paramString;
      localea.bKA.aES = paramBoolean;
      a.udP.a(localea, Looper.getMainLooper());
      return;
      y.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, base64(broadcastData)=%s, isCompleted=%s", new Object[] { paramString, Base64.encodeToString(paramArrayOfByte, 0), Boolean.valueOf(paramBoolean) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.e.37
 * JD-Core Version:    0.7.0.1
 */