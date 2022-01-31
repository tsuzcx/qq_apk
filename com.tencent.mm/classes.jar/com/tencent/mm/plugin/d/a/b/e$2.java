package com.tencent.mm.plugin.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

final class e$2
  extends f.a
{
  e$2(e parame) {}
  
  public final void a(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    AppMethodBeat.i(18406);
    String str2 = b.jw(paramLong1);
    if (paramBoolean) {}
    for (String str1 = "true";; str1 = "false")
    {
      ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onConnected. mac = %s, connected = %s", new Object[] { str2, str1 });
      this.jOA.N(new e.2.1(this, paramLong1, paramBoolean, paramLong2));
      ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "session size = %d", new Object[] { Integer.valueOf(this.jOA.jNO.size()) });
      AppMethodBeat.o(18406);
      return;
    }
  }
  
  public final void b(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18407);
    ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onRecv. mac = %s", new Object[] { b.jw(paramLong) });
    if (this.jOA.jOw != null)
    {
      this.jOA.jOw.b(paramLong, paramArrayOfByte);
      AppMethodBeat.o(18407);
      return;
    }
    ab.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no BLEManagerCallback");
    AppMethodBeat.o(18407);
  }
  
  public final void m(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(18408);
    String str2 = b.jw(paramLong);
    if (paramBoolean) {}
    for (String str1 = "true";; str1 = "false")
    {
      ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onSend. mac = %s, success = %s", new Object[] { str2, str1 });
      if (this.jOA.jOw != null) {
        this.jOA.jOw.m(paramLong, paramBoolean);
      }
      AppMethodBeat.o(18408);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.e.2
 * JD-Core Version:    0.7.0.1
 */