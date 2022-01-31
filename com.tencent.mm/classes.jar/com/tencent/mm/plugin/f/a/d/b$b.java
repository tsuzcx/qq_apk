package com.tencent.mm.plugin.f.a.d;

import com.tencent.mm.plugin.f.a.b.b.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import junit.framework.Assert;

final class b$b
  extends b.a
{
  b$b(b paramb) {}
  
  public final void a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.exdevice.BluetoothSDKManager", "---BLE onDiscover---, %s, %s", new Object[] { paramString1, paramString2 });
    paramString1 = new b.i(paramString1, paramString2, paramInt, paramArrayOfByte);
    Assert.assertTrue(b.a(this.hXt, 3, 0, paramString1));
  }
  
  public final void awr()
  {
    y.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onDiscoverFinished***");
    this.hXt.hXs.clear();
    Assert.assertTrue(b.a(this.hXt, 2, 0, null));
  }
  
  public final void b(long paramLong, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onRecv*** sessionId = " + paramLong);
    paramArrayOfByte = new b.h(paramLong, paramArrayOfByte);
    Assert.assertTrue(b.a(this.hXt, 1, 0, paramArrayOfByte));
  }
  
  public final void e(long paramLong1, long paramLong2, long paramLong3)
  {
    y.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSessionCreate*** sessionID = " + paramLong1 + " deviceID = " + paramLong2);
    b.d locald = new b.d(paramLong1, paramLong2, paramLong3);
    Assert.assertTrue(b.a(this.hXt, 6, 0, locald));
  }
  
  public final void i(long paramLong, boolean paramBoolean)
  {
    y.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onConnected*** SessionId = " + paramLong + " Connected = " + paramBoolean);
    b.f localf = new b.f(paramLong, paramBoolean);
    Assert.assertTrue(b.a(this.hXt, 4, 0, localf));
  }
  
  public final void j(long paramLong, boolean paramBoolean)
  {
    y.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSend*** SessionId = " + paramLong + " success = " + paramBoolean);
    b.j localj = new b.j(paramLong, paramBoolean);
    Assert.assertTrue(b.a(this.hXt, 0, 0, localj));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.d.b.b
 * JD-Core Version:    0.7.0.1
 */