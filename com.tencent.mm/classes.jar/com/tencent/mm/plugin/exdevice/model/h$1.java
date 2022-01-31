package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.j.a;
import com.tencent.mm.sdk.platformtools.y;

final class h$1
  extends j.a
{
  h$1(h paramh) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, byte[] paramArrayOfByte)
  {
    y.d(h.TAG, "onScanCallback. messageType=%d, errCode=%d, errMsg=%s, deviceMac=%s, deviceName=%s, rssi=%d, advertisment=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramString3, Integer.valueOf(paramInt3), b.aq(paramArrayOfByte) });
    if (1 == paramInt1) {
      ad.aLW().m(paramString3, paramString2, false);
    }
    for (;;)
    {
      if (ad.aLL().ed(b.BU(paramString2)) != null) {
        y.d(h.TAG, "the founded device hasn't been binded");
      }
      return;
      if (2 == paramInt1) {
        ad.aLW().m(paramString3, paramString2, true);
      } else {
        y.e(h.TAG, "unknown message type %d", new Object[] { Integer.valueOf(paramInt1) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.h.1
 * JD-Core Version:    0.7.0.1
 */