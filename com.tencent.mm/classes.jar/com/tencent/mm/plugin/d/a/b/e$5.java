package com.tencent.mm.plugin.d.a.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;

public final class e$5
  implements Runnable
{
  public e$5(e parame, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(18411);
    f localf = (f)this.jOA.jNO.remove(Long.valueOf(this.jOE));
    if (localf != null)
    {
      ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------close------, mac=%s, name=%s", new Object[] { b.jw(localf.mSessionId), localf.hIc.getName() });
      if (!localf.mHandler.sendMessage(localf.mHandler.obtainMessage(2))) {
        ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(2) });
      }
      this.jOA.jOy.put(Long.valueOf(this.jOE), Boolean.TRUE);
      AppMethodBeat.o(18411);
      return;
    }
    ab.w("MicroMsg.exdevice.BluetoothLESimpleManager", "session not found! maybe ui don't handle session disconnect event correctly.");
    AppMethodBeat.o(18411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.e.5
 * JD-Core Version:    0.7.0.1
 */