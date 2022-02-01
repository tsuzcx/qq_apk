package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.concurrent.atomic.AtomicBoolean;

public final class BleScanWorker$3
  extends BroadcastReceiver
{
  public BleScanWorker$3(a parama) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(144600);
    if (paramIntent == null)
    {
      ac.i(this.kla.cgL, "Receive intent failed");
      AppMethodBeat.o(144600);
      return;
    }
    paramContext = BluetoothAdapter.getDefaultAdapter();
    if (paramContext != null)
    {
      int i = paramContext.getState();
      ac.d(this.kla.cgL, "state:%d", new Object[] { Integer.valueOf(i) });
      if ((i != 12) && (i != 11) && ((i == 10) || (i == 13)))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.kla.cgL, "bluetooth is disable, stop scan", new Object[0]);
        this.kla.kkW.set(false);
        this.kla.bfN();
      }
    }
    AppMethodBeat.o(144600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.BleScanWorker.3
 * JD-Core Version:    0.7.0.1
 */