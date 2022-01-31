package com.tencent.mm.plugin.f.a.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class e$5
  implements Runnable
{
  public e$5(e parame, long paramLong) {}
  
  public final void run()
  {
    f localf = (f)this.hUG.hTU.remove(Long.valueOf(this.hUK));
    if (localf != null)
    {
      y.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------close------, mac=%s, name=%s", new Object[] { b.ee(localf.mSessionId), localf.gof.getName() });
      if (!localf.mHandler.sendMessage(localf.mHandler.obtainMessage(2))) {
        y.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(2) });
      }
      this.hUG.hUE.put(Long.valueOf(this.hUK), Boolean.valueOf(true));
      return;
    }
    y.w("MicroMsg.exdevice.BluetoothLESimpleManager", "session not found! maybe ui don't handle session disconnect event correctly.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.e.5
 * JD-Core Version:    0.7.0.1
 */