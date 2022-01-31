package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

final class a$2
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = false;
    if (paramIntent == null) {
      y.i("MicroMsg.Ble.BleManager", "Receive intent failed");
    }
    do
    {
      return;
      paramContext = BluetoothAdapter.getDefaultAdapter();
    } while (paramContext == null);
    int i = paramContext.getState();
    y.d("MicroMsg.Ble.BleManager", "state:%d", new Object[] { Integer.valueOf(i) });
    boolean bool1;
    if (i == 12) {
      bool1 = true;
    }
    while (((a.glv) && (!bool1)) || ((!a.glv) && (bool1)))
    {
      paramContext = a.aco().values().iterator();
      while (paramContext.hasNext())
      {
        paramIntent = (b)paramContext.next();
        if (paramIntent.gly != null) {
          paramIntent.gly.cZ(bool1);
        }
      }
      bool1 = bool2;
      if (i == 10) {
        bool1 = bool2;
      }
    }
    a.glv = bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.2
 * JD-Core Version:    0.7.0.1
 */