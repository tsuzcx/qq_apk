package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public class BluetoothStateReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(15837);
    ab.d("MicroMsg.BluetoothStateReceiver", "BluetoothStateReceiver.onReceive()");
    paramContext = BluetoothAdapter.getDefaultAdapter();
    if (paramContext != null)
    {
      if (paramContext.getState() != 12) {
        break label81;
      }
      h.qsU.e(11921, new Object[] { Integer.valueOf(1) });
    }
    for (;;)
    {
      ab.e("MicroMsg.BluetoothStateReceiver", "[oneliang]bluetoothAdapter state:" + paramContext.getState());
      AppMethodBeat.o(15837);
      return;
      label81:
      if (paramContext.getState() == 10) {
        h.qsU.e(11921, new Object[] { Integer.valueOf(0) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.booter.BluetoothStateReceiver
 * JD-Core Version:    0.7.0.1
 */