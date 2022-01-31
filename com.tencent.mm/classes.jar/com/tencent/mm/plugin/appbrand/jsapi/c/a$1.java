package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

final class a$1
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(94351);
    if (paramIntent == null)
    {
      ab.i("MicroMsg.BeaconManager", "Receive intent failed");
      AppMethodBeat.o(94351);
      return;
    }
    paramContext = BluetoothAdapter.getDefaultAdapter();
    if (paramContext != null)
    {
      int i = paramContext.getState();
      ab.d("MicroMsg.BeaconManager", "state:%d", new Object[] { Integer.valueOf(i) });
      boolean bool1;
      if (i == 12) {
        bool1 = true;
      }
      while (((a.hFu) && (!bool1)) || ((!a.hFu) && (bool1)))
      {
        paramContext = a.map.values().iterator();
        while (paramContext.hasNext())
        {
          paramIntent = (a.a)paramContext.next();
          if ((paramIntent.isStart()) && (!bool1)) {
            paramIntent.Ez();
          }
          if (paramIntent.hMp != null) {
            paramIntent.hMp.ed(bool1);
          }
        }
        bool1 = bool2;
        if (i == 10) {
          bool1 = bool2;
        }
      }
      a.hFu = bool1;
    }
    AppMethodBeat.o(94351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.a.1
 * JD-Core Version:    0.7.0.1
 */