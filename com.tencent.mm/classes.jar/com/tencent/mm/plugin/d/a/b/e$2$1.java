package com.tencent.mm.plugin.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

final class e$2$1
  implements Runnable
{
  e$2$1(e.2 param2, long paramLong1, boolean paramBoolean, long paramLong2) {}
  
  public final void run()
  {
    AppMethodBeat.i(18405);
    f localf = (f)this.jOD.jOA.jNO.get(Long.valueOf(this.hdy));
    Boolean localBoolean = Boolean.FALSE;
    if (!this.jOB) {}
    for (int i = 1; (localf != null) || (i != 0); i = 0)
    {
      if (this.jOD.jOA.jOw != null)
      {
        this.jOD.jOA.jOw.a(this.hdy, this.jOB, this.jOC);
        if (i != 0) {
          ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnected, mBLEManagerCallback callback mac=%s", new Object[] { b.jw(this.hdy) });
        }
      }
      if (i == 0) {
        break label214;
      }
      ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "remove seesion(mac=%s)", new Object[] { b.jw(this.hdy) });
      this.jOD.jOA.jNO.remove(Long.valueOf(this.hdy));
      this.jOD.jOA.jOy.remove(Long.valueOf(this.hdy));
      AppMethodBeat.o(18405);
      return;
    }
    ab.e("MicroMsg.exdevice.BluetoothLESimpleManager", "no seesion(mac=%s) found", new Object[] { b.jw(this.hdy) });
    label214:
    AppMethodBeat.o(18405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.e.2.1
 * JD-Core Version:    0.7.0.1
 */