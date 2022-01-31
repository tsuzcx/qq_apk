package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.JgClassChecked;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Set;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class BluetoothReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null) || (bk.bl(paramIntent.getAction()))) {}
    int i;
    do
    {
      do
      {
        do
        {
          return;
          paramContext = BluetoothAdapter.getDefaultAdapter();
          if (paramContext == null)
          {
            y.d("MicroMsg.BluetoothReceiver", "getDefaultAdapter == null");
            return;
          }
          paramContext = paramContext.getBondedDevices();
          if ((paramContext == null) || (paramContext.size() == 0))
          {
            y.d("MicroMsg.BluetoothReceiver", "getBondedDevices == null");
            return;
          }
        } while (bk.bl(paramIntent.getAction()));
        y.d("MicroMsg.BluetoothReceiver", "dkbt action :" + paramIntent.getAction());
      } while (!au.DK());
      try
      {
        i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
        y.d("MicroMsg.BluetoothReceiver", "dkbt  action :" + paramIntent.getAction() + " state:" + i + " isBluetoothScoOn :" + au.Hy().yn() + " " + au.Hy().yr());
        if (paramIntent.getAction().equalsIgnoreCase("android.media.SCO_AUDIO_STATE_CHANGED"))
        {
          y.d("MicroMsg.BluetoothReceiver", "just STATE_CHANGED not real STATE_UPDATED" + paramIntent.getAction());
          return;
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          y.e("MicroMsg.BluetoothReceiver", "%s", new Object[] { bk.j(paramContext) });
          i = 0;
        }
        if (i == 1)
        {
          y.d("MicroMsg.BluetoothReceiver", "sco connected!");
          paramContext = au.Hy();
          y.i("MicroMsg.MMAudioManager", "dkbt bluetoothStartSucc %s", new Object[] { paramContext.yr() });
          f.dul = true;
          paramContext.gp(1);
          return;
        }
      }
    } while (i != 0);
    y.d("MicroMsg.BluetoothReceiver", "sco disconnected!getStopBluetoothInBR = %s", new Object[] { Integer.valueOf(q.dyn.dwL) });
    if (q.dyn.dwL == 1) {
      au.Hy().yl();
    }
    au.Hy().yj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.BluetoothReceiver
 * JD-Core Version:    0.7.0.1
 */