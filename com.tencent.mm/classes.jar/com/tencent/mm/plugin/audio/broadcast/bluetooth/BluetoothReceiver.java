package com.tencent.mm.plugin.audio.broadcast.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Set;

@m
public class BluetoothReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(263791);
    if ((paramContext == null) || (paramIntent == null) || (Util.isNullOrNil(paramIntent.getAction())))
    {
      AppMethodBeat.o(263791);
      return;
    }
    paramContext = BluetoothAdapter.getDefaultAdapter();
    if (paramContext == null)
    {
      Log.d("MicroMsg.BluetoothReceiver", "getDefaultAdapter == null");
      AppMethodBeat.o(263791);
      return;
    }
    Log.i("MicroMsg.BluetoothReceiver", "dkbt action :" + paramIntent.getAction());
    try
    {
      i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
      if ((i == 1) || (i == 0))
      {
        paramContext = paramContext.getBondedDevices();
        if ((paramContext == null) || (paramContext.size() == 0))
        {
          Log.d("MicroMsg.BluetoothReceiver", "getBondedDevices == null");
          AppMethodBeat.o(263791);
          return;
        }
      }
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.BluetoothReceiver", "%s", new Object[] { Util.stackTraceToString(paramContext) });
      paramContext = paramIntent.getAction();
      if (Util.isNullOrNil(paramContext))
      {
        AppMethodBeat.o(263791);
        return;
      }
      switch (paramContext.hashCode())
      {
      }
    }
    int i = -1;
    label222:
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(263791);
      return;
      if (!paramContext.equals("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) {
        break;
      }
      i = 0;
      break label222;
      if (!paramContext.equals("android.media.ACTION_SCO_AUDIO_STATE_UPDATED")) {
        break;
      }
      i = 1;
      break label222;
      if (!paramContext.equals("android.bluetooth.headset.profile.action.ACTIVE_DEVICE_CHANGED")) {
        break;
      }
      i = 2;
      break label222;
      if (!paramContext.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
        break;
      }
      i = 3;
      break label222;
      if (!paramContext.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
        break;
      }
      i = 4;
      break label222;
      if (!paramContext.equals("android.bluetooth.device.action.ACL_DISCONNECTED")) {
        break;
      }
      i = 5;
      break label222;
      a.X(paramIntent);
      AppMethodBeat.o(263791);
      return;
      a.Y(paramIntent);
      AppMethodBeat.o(263791);
      return;
      a.Z(paramIntent);
      AppMethodBeat.o(263791);
      return;
      a.aa(paramIntent);
      AppMethodBeat.o(263791);
      return;
      a.ab(paramIntent);
      AppMethodBeat.o(263791);
      return;
      a.ac(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.broadcast.bluetooth.BluetoothReceiver
 * JD-Core Version:    0.7.0.1
 */