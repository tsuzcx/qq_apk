package com.tencent.mm.plugin.card.b;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class i$a$2
  extends BroadcastReceiver
{
  i$a$2(i.a parama) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      y.i("MicroMsg.CardLbsOrBluetooth", "Receive intent failed");
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
      y.d("MicroMsg.CardLbsOrBluetooth", "state:%d", new Object[] { Integer.valueOf(i) });
      if (i == 12)
      {
        this.ikQ.ikL = true;
        ai.l(this.ikQ.ikO, this.ikQ.ikN);
        return;
      }
    } while (i != 10);
    ai.S(this.ikQ.ikO);
    this.ikQ.ikL = false;
    this.ikQ.ikM.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.i.a.2
 * JD-Core Version:    0.7.0.1
 */