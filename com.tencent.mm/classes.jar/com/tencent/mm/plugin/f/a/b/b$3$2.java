package com.tencent.mm.plugin.f.a.b;

import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Iterator;

final class b$3$2
  implements Runnable
{
  b$3$2(b.3 param3) {}
  
  public final void run()
  {
    if (!this.hUe.hUb.hTY.isEmpty())
    {
      Iterator localIterator = this.hUe.hUb.hTY.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        y.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", new Object[] { localLong });
        if (this.hUe.hUb.hTT != null) {
          this.hUe.hUb.hTT.i(localLong.longValue(), false);
        }
      }
      this.hUe.hUb.hTY.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.b.3.2
 * JD-Core Version:    0.7.0.1
 */