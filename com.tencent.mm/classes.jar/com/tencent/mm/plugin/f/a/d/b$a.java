package com.tencent.mm.plugin.f.a.d;

import com.tencent.mm.plugin.f.a.c.a.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import junit.framework.Assert;

final class b$a
  extends a.a
{
  b$a(b paramb) {}
  
  public final void awr()
  {
    y.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscoverFinished***");
    this.hXt.hXs.clear();
    Assert.assertTrue(b.a(this.hXt, 2, 1, null));
  }
  
  public final void b(long paramLong, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onRecv*** sessionId = " + paramLong);
    paramArrayOfByte = new b.h(paramLong, paramArrayOfByte);
    Assert.assertTrue(b.a(this.hXt, 1, 1, paramArrayOfByte));
  }
  
  public final void c(long paramLong, int paramInt, String paramString)
  {
    y.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onError*** SessionId = " + paramLong + " errorCode = " + paramInt + " errorInfo = " + paramString);
    paramString = new b.g(paramLong, paramInt, paramString);
    Assert.assertTrue(b.a(this.hXt, 5, 1, paramString));
  }
  
  public final void co(String paramString1, String paramString2)
  {
    b localb = this.hXt;
    int i;
    if (paramString1 == null)
    {
      y.e("MicroMsg.exdevice.BluetoothSDKManager", "null == aDeviceMac");
      i = 0;
    }
    while (i == 0)
    {
      return;
      if (localb.hXs.contains(paramString1))
      {
        i = 0;
      }
      else
      {
        localb.hXs.add(paramString1);
        i = 1;
      }
    }
    y.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscover*** deviceMac = " + paramString1 + "deviceName = " + paramString2);
    paramString1 = new b.i(paramString1, paramString2, 0, null);
    Assert.assertTrue(b.a(this.hXt, 3, 1, paramString1));
  }
  
  public final void e(long paramLong1, long paramLong2, long paramLong3)
  {
    y.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSessionCreate*** sessionID = " + paramLong1 + " deviceID = " + paramLong2);
    b.d locald = new b.d(paramLong1, paramLong2, paramLong3);
    Assert.assertTrue(b.a(this.hXt, 6, 1, locald));
  }
  
  public final void i(long paramLong, boolean paramBoolean)
  {
    y.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onConnected*** SessionId = " + paramLong + " Connected = " + paramBoolean);
    b.f localf = new b.f(paramLong, paramBoolean);
    Assert.assertTrue(b.a(this.hXt, 4, 1, localf));
  }
  
  public final void j(long paramLong, boolean paramBoolean)
  {
    y.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSend*** SessionId = " + paramLong + " success = " + paramBoolean);
    b.j localj = new b.j(paramLong, paramBoolean);
    Assert.assertTrue(b.a(this.hXt, 0, 1, localj));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.d.b.a
 * JD-Core Version:    0.7.0.1
 */