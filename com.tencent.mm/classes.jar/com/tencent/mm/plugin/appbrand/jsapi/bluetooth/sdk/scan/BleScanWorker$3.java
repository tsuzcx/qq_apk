package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.atomic.AtomicBoolean;

public final class BleScanWorker$3
  extends BroadcastReceiver
{
  public BleScanWorker$3(a parama) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      y.i("MicroMsg.Ble.BleScanWorker", "Receive intent failed");
    }
    int i;
    do
    {
      do
      {
        return;
        paramContext = BluetoothAdapter.getDefaultAdapter();
      } while (paramContext == null);
      i = paramContext.getState();
      y.d("MicroMsg.Ble.BleScanWorker", "state:%d", new Object[] { Integer.valueOf(i) });
    } while ((i == 12) || (i == 11) || ((i != 10) && (i != 13)));
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleScanWorker", "bluetooth is disable, stop scan", new Object[0]);
    this.gnp.gnk.set(false);
    this.gnp.aiw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.BleScanWorker.3
 * JD-Core Version:    0.7.0.1
 */