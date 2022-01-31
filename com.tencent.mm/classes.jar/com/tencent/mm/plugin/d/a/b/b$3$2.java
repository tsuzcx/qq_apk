package com.tencent.mm.plugin.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import java.util.Iterator;

final class b$3$2
  implements Runnable
{
  b$3$2(b.3 param3) {}
  
  public final void run()
  {
    AppMethodBeat.i(18367);
    if (!this.jNY.jNV.jNS.isEmpty())
    {
      Iterator localIterator = this.jNY.jNV.jNS.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        ab.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", new Object[] { localLong });
        if (this.jNY.jNV.jNN != null) {
          this.jNY.jNV.jNN.l(localLong.longValue(), false);
        }
      }
      this.jNY.jNV.jNS.clear();
    }
    AppMethodBeat.o(18367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.b.3.2
 * JD-Core Version:    0.7.0.1
 */