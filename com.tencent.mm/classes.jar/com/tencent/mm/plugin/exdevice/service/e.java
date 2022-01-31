package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.h.a.dr;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.d;
import com.tencent.mm.plugin.exdevice.model.d.4;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  extends q.a
{
  private static e jyZ = new e();
  
  public static e aMd()
  {
    return jyZ;
  }
  
  public final void a(double paramDouble1, int paramInt1, int paramInt2, byte[] paramArrayOfByte, double paramDouble2, int paramInt3, String paramString)
  {
    y.d("MicroMsg.exdevice.ExdeviceIBeaconManager", "onRangdingCallback, distance = %f, major = %d, minor = %d, uuid = %s, rssi = %f,aMac = %s,txPower = %d", new Object[] { Double.valueOf(paramDouble1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), b.aq(paramArrayOfByte), Double.valueOf(paramDouble2), paramString, Integer.valueOf(paramInt3) });
    dr localdr = new dr();
    String str = b.aq(paramArrayOfByte);
    paramArrayOfByte = str;
    if (str.length() >= 32) {
      paramArrayOfByte = str.substring(0, 8) + "-" + str.substring(8, 12) + "-" + str.substring(12, 16) + "-" + str.substring(16, 20) + "-" + str.substring(20);
    }
    localdr.bKh.bKf = paramArrayOfByte;
    localdr.bKh.bKk = paramDouble1;
    localdr.bKh.bKi = paramInt1;
    localdr.bKh.bKj = paramInt2;
    localdr.bKh.bKl = paramDouble2;
    localdr.bKh.bKm = paramString;
    localdr.bKh.bKn = paramInt3;
    a.udP.m(localdr);
  }
  
  public final boolean av(String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.exdevice.ExdeviceIBeaconManager", "ranging, uuid = %s, op = %s", new Object[] { paramString, String.valueOf(paramBoolean) });
    if (paramString == null)
    {
      y.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "uuid is null");
      return false;
    }
    if (u.aMn().jtr == null)
    {
      y.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "MMExDeviceCore.getTaskQueue().getDispatcher() is null !!!now retry invoke doTaskAfterServiceStarted!");
      d locald = ad.aLS();
      paramString = new e.1(this, paramString, paramBoolean);
      y.d("MicroMsg.exdevice.ExdeviceConnectManager", "doTaskAfterServiceStarted");
      if (locald.jtw == null)
      {
        locald.jtw = new c();
        locald.jtw.jyW = new d.4(locald, paramString);
        locald.jtw.da(ae.getContext());
        return false;
      }
      locald.jtw.I(paramString);
      return false;
    }
    return u.aMn().jtr.a(paramString, paramBoolean, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.e
 * JD-Core Version:    0.7.0.1
 */