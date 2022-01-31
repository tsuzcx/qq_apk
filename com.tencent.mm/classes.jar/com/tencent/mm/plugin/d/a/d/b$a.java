package com.tencent.mm.plugin.d.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.c.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import junit.framework.Assert;

final class b$a
  extends a.a
{
  b$a(b paramb) {}
  
  public final void aVU()
  {
    AppMethodBeat.i(18499);
    ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscoverFinished***");
    this.jRm.jRl.clear();
    Assert.assertTrue(b.a(this.jRm, 2, 1, null));
    AppMethodBeat.o(18499);
  }
  
  public final void b(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18502);
    ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onRecv*** sessionId = ".concat(String.valueOf(paramLong)));
    paramArrayOfByte = new b.h(paramLong, paramArrayOfByte);
    Assert.assertTrue(b.a(this.jRm, 1, 1, paramArrayOfByte));
    AppMethodBeat.o(18502);
  }
  
  public final void c(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(18504);
    ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onError*** SessionId = " + paramLong + " errorCode = " + paramInt + " errorInfo = " + paramString);
    paramString = new b.g(paramLong, paramInt, paramString);
    Assert.assertTrue(b.a(this.jRm, 5, 1, paramString));
    AppMethodBeat.o(18504);
  }
  
  public final void dh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(18500);
    b localb = this.jRm;
    int i;
    if (paramString1 == null)
    {
      ab.e("MicroMsg.exdevice.BluetoothSDKManager", "null == aDeviceMac");
      i = 0;
    }
    while (i == 0)
    {
      AppMethodBeat.o(18500);
      return;
      if (localb.jRl.contains(paramString1))
      {
        i = 0;
      }
      else
      {
        localb.jRl.add(paramString1);
        i = 1;
      }
    }
    ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscover*** deviceMac = " + paramString1 + "deviceName = " + paramString2);
    paramString1 = new b.i(paramString1, paramString2, 0, null);
    Assert.assertTrue(b.a(this.jRm, 3, 1, paramString1));
    AppMethodBeat.o(18500);
  }
  
  public final void f(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(18498);
    ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSessionCreate*** sessionID = " + paramLong1 + " deviceID = " + paramLong2);
    b.d locald = new b.d(paramLong1, paramLong2, paramLong3);
    Assert.assertTrue(b.a(this.jRm, 6, 1, locald));
    AppMethodBeat.o(18498);
  }
  
  public final void l(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(18501);
    ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onConnected*** SessionId = " + paramLong + " Connected = " + paramBoolean);
    b.f localf = new b.f(paramLong, paramBoolean);
    Assert.assertTrue(b.a(this.jRm, 4, 1, localf));
    AppMethodBeat.o(18501);
  }
  
  public final void m(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(18503);
    ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSend*** SessionId = " + paramLong + " success = " + paramBoolean);
    b.j localj = new b.j(paramLong, paramBoolean);
    Assert.assertTrue(b.a(this.jRm, 0, 1, localj));
    AppMethodBeat.o(18503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.d.b.a
 * JD-Core Version:    0.7.0.1
 */