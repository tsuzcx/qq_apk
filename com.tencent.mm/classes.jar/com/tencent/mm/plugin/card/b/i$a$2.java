package com.tencent.mm.plugin.card.b;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Map;

final class i$a$2
  extends BroadcastReceiver
{
  i$a$2(i.a parama) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(87704);
    if (paramIntent == null)
    {
      ab.i("MicroMsg.CardLbsOrBluetooth", "Receive intent failed");
      AppMethodBeat.o(87704);
      return;
    }
    paramContext = BluetoothAdapter.getDefaultAdapter();
    if (paramContext != null)
    {
      int i = paramContext.getState();
      ab.d("MicroMsg.CardLbsOrBluetooth", "state:%d", new Object[] { Integer.valueOf(i) });
      if (i == 12)
      {
        this.klO.klJ = true;
        al.p(this.klO.klM, this.klO.klL);
        AppMethodBeat.o(87704);
        return;
      }
      if (i == 10)
      {
        al.ae(this.klO.klM);
        this.klO.klJ = false;
        this.klO.klK.clear();
      }
    }
    AppMethodBeat.o(87704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.i.a.2
 * JD-Core Version:    0.7.0.1
 */