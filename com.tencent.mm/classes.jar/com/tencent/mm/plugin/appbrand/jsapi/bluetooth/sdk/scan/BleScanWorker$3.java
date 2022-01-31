package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.atomic.AtomicBoolean;

public final class BleScanWorker$3
  extends BroadcastReceiver
{
  public BleScanWorker$3(a parama) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(94288);
    if (paramIntent == null)
    {
      ab.i("MicroMsg.Ble.BleScanWorker", "Receive intent failed");
      AppMethodBeat.o(94288);
      return;
    }
    paramContext = BluetoothAdapter.getDefaultAdapter();
    if (paramContext != null)
    {
      int i = paramContext.getState();
      ab.d("MicroMsg.Ble.BleScanWorker", "state:%d", new Object[] { Integer.valueOf(i) });
      if ((i != 12) && (i != 11) && ((i == 10) || (i == 13)))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleScanWorker", "bluetooth is disable, stop scan", new Object[0]);
        this.hHn.hHj.set(false);
        this.hHn.aCr();
      }
    }
    AppMethodBeat.o(94288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.BleScanWorker.3
 * JD-Core Version:    0.7.0.1
 */