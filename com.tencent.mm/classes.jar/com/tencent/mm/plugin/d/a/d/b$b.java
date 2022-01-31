package com.tencent.mm.plugin.d.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import junit.framework.Assert;

final class b$b
  extends b.a
{
  b$b(b paramb) {}
  
  public final void a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18507);
    ab.d("MicroMsg.exdevice.BluetoothSDKManager", "---BLE onDiscover---, %s, %s", new Object[] { paramString1, paramString2 });
    paramString1 = new b.i(paramString1, paramString2, paramInt, paramArrayOfByte);
    Assert.assertTrue(b.a(this.jRm, 3, 0, paramString1));
    AppMethodBeat.o(18507);
  }
  
  public final void aVU()
  {
    AppMethodBeat.i(18506);
    ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onDiscoverFinished***");
    this.jRm.jRl.clear();
    Assert.assertTrue(b.a(this.jRm, 2, 0, null));
    AppMethodBeat.o(18506);
  }
  
  public final void b(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18509);
    ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onRecv*** sessionId = ".concat(String.valueOf(paramLong)));
    paramArrayOfByte = new b.h(paramLong, paramArrayOfByte);
    Assert.assertTrue(b.a(this.jRm, 1, 0, paramArrayOfByte));
    AppMethodBeat.o(18509);
  }
  
  public final void f(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(18505);
    ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSessionCreate*** sessionID = " + paramLong1 + " deviceID = " + paramLong2);
    b.d locald = new b.d(paramLong1, paramLong2, paramLong3);
    Assert.assertTrue(b.a(this.jRm, 6, 0, locald));
    AppMethodBeat.o(18505);
  }
  
  public final void l(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(18508);
    ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onConnected*** SessionId = " + paramLong + " Connected = " + paramBoolean);
    b.f localf = new b.f(paramLong, paramBoolean);
    Assert.assertTrue(b.a(this.jRm, 4, 0, localf));
    AppMethodBeat.o(18508);
  }
  
  public final void m(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(18510);
    ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSend*** SessionId = " + paramLong + " success = " + paramBoolean);
    b.j localj = new b.j(paramLong, paramBoolean);
    Assert.assertTrue(b.a(this.jRm, 0, 0, localj));
    AppMethodBeat.o(18510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.d.b.b
 * JD-Core Version:    0.7.0.1
 */