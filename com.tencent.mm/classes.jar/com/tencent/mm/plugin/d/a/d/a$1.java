package com.tencent.mm.plugin.d.a.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  extends BroadcastReceiver
{
  a$1(a parama) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(18496);
    if (paramIntent == null)
    {
      ab.e("McroMsg.exdevice.BluetoohtStateMonitor", "null == intent");
      AppMethodBeat.o(18496);
      return;
    }
    if (paramIntent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED"))
    {
      ab.i("McroMsg.exdevice.BluetoohtStateMonitor", "onReceive, action = " + paramIntent.getAction());
      int i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
      if ((10 == i) || (12 == i)) {
        this.jRh.jRf.rP(i);
      }
    }
    AppMethodBeat.o(18496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.d.a.1
 * JD-Core Version:    0.7.0.1
 */