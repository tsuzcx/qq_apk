package com.tencent.mm.plugin.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class b$b
  implements Runnable
{
  private long jNZ = 0L;
  private long jOa = 0L;
  
  public b$b(b paramb, long paramLong1, long paramLong2)
  {
    this.jNZ = paramLong1;
    this.jOa = paramLong2;
  }
  
  public final void run()
  {
    AppMethodBeat.i(18370);
    b localb = this.jNV;
    long l = this.jNZ;
    d locald1 = new d(l, localb.zF, localb);
    String str = String.valueOf(locald1.mSessionId);
    ab.i("MicroMsg.exdevice.BluetoothLEManager", "BluetoothLESession hashCode = %d, macAddr = %d, mapKey = %s", new Object[] { Integer.valueOf(locald1.hashCode()), Long.valueOf(l), str });
    d locald2 = (d)localb.jNO.remove(str);
    if (locald2 != null) {
      locald2.close();
    }
    localb.jNO.put(str, locald1);
    l = locald1.mSessionId;
    if (this.jNV.jNN != null) {
      this.jNV.jNN.f(l, this.jNZ, this.jOa);
    }
    AppMethodBeat.o(18370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.b.b
 * JD-Core Version:    0.7.0.1
 */