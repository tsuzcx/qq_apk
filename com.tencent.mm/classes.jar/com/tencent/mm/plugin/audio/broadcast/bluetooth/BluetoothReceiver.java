package com.tencent.mm.plugin.audio.broadcast.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Set;

@k
@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class BluetoothReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(199815);
    if ((paramContext == null) || (paramIntent == null) || (bt.isNullOrNil(paramIntent.getAction())))
    {
      AppMethodBeat.o(199815);
      return;
    }
    paramContext = BluetoothAdapter.getDefaultAdapter();
    if (paramContext == null)
    {
      ad.d("MicroMsg.BluetoothReceiver", "getDefaultAdapter == null");
      AppMethodBeat.o(199815);
      return;
    }
    ad.i("MicroMsg.BluetoothReceiver", "dkbt action :" + paramIntent.getAction());
    try
    {
      i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
      if ((i == 1) || (i == 0))
      {
        paramContext = paramContext.getBondedDevices();
        if ((paramContext == null) || (paramContext.size() == 0))
        {
          ad.d("MicroMsg.BluetoothReceiver", "getBondedDevices == null");
          AppMethodBeat.o(199815);
          return;
        }
      }
    }
    catch (Exception paramContext)
    {
      ad.e("MicroMsg.BluetoothReceiver", "%s", new Object[] { bt.n(paramContext) });
      paramContext = paramIntent.getAction();
      if (bt.isNullOrNil(paramContext))
      {
        AppMethodBeat.o(199815);
        return;
      }
      switch (paramContext.hashCode())
      {
      }
    }
    int i = -1;
    label214:
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(199815);
      return;
      if (!paramContext.equals("android.media.ACTION_SCO_AUDIO_STATE_UPDATED")) {
        break;
      }
      i = 0;
      break label214;
      if (!paramContext.equals("android.bluetooth.headset.profile.action.ACTIVE_DEVICE_CHANGED")) {
        break;
      }
      i = 1;
      break label214;
      if (!paramContext.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
        break;
      }
      i = 2;
      break label214;
      if (!paramContext.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
        break;
      }
      i = 3;
      break label214;
      if (!paramContext.equals("android.bluetooth.device.action.ACL_DISCONNECTED")) {
        break;
      }
      i = 4;
      break label214;
      a.W(paramIntent);
      AppMethodBeat.o(199815);
      return;
      a.X(paramIntent);
      AppMethodBeat.o(199815);
      return;
      a.Y(paramIntent);
      AppMethodBeat.o(199815);
      return;
      a.Z(paramIntent);
      AppMethodBeat.o(199815);
      return;
      a.aa(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.broadcast.bluetooth.BluetoothReceiver
 * JD-Core Version:    0.7.0.1
 */