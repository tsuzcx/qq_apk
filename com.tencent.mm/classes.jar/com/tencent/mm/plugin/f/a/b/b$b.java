package com.tencent.mm.plugin.f.a.b;

import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class b$b
  implements Runnable
{
  private long hUf = 0L;
  private long hUg = 0L;
  
  public b$b(b paramb, long paramLong1, long paramLong2)
  {
    this.hUf = paramLong1;
    this.hUg = paramLong2;
  }
  
  public final void run()
  {
    b localb = this.hUb;
    long l = this.hUf;
    d locald1 = new d(l, localb.ze, localb);
    String str = String.valueOf(locald1.mSessionId);
    y.i("MicroMsg.exdevice.BluetoothLEManager", "BluetoothLESession hashCode = %d, macAddr = %d, mapKey = %s", new Object[] { Integer.valueOf(locald1.hashCode()), Long.valueOf(l), str });
    d locald2 = (d)localb.hTU.remove(str);
    if (locald2 != null) {
      locald2.close();
    }
    localb.hTU.put(str, locald1);
    l = locald1.mSessionId;
    if (this.hUb.hTT != null) {
      this.hUb.hTT.e(l, this.hUf, this.hUg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.b.b
 * JD-Core Version:    0.7.0.1
 */