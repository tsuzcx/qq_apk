package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

final class a$2
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(94166);
    if (paramIntent == null)
    {
      ab.i("MicroMsg.Ble.BleManager", "Receive intent failed");
      AppMethodBeat.o(94166);
      return;
    }
    paramContext = BluetoothAdapter.getDefaultAdapter();
    if (paramContext != null)
    {
      int i = paramContext.getState();
      ab.d("MicroMsg.Ble.BleManager", "state:%d", new Object[] { Integer.valueOf(i) });
      boolean bool1;
      if (i == 12) {
        bool1 = true;
      }
      while (((a.hFu) && (!bool1)) || ((!a.hFu) && (bool1)))
      {
        paramContext = a.awf().values().iterator();
        while (paramContext.hasNext())
        {
          paramIntent = (b)paramContext.next();
          if (paramIntent.hFx != null) {
            paramIntent.hFx.ed(bool1);
          }
        }
        bool1 = bool2;
        if (i == 10) {
          bool1 = bool2;
        }
      }
      a.hFu = bool1;
    }
    AppMethodBeat.o(94166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.2
 * JD-Core Version:    0.7.0.1
 */