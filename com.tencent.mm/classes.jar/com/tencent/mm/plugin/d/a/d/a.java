package com.tencent.mm.plugin.d.a.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class a
{
  final a nst;
  public final BroadcastReceiver nsu;
  
  public a(a parama)
  {
    AppMethodBeat.i(22608);
    this.nsu = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(22607);
        if (paramAnonymousIntent == null)
        {
          ac.e("McroMsg.exdevice.BluetoohtStateMonitor", "null == intent");
          AppMethodBeat.o(22607);
          return;
        }
        if (paramAnonymousIntent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED"))
        {
          ac.i("McroMsg.exdevice.BluetoohtStateMonitor", "onReceive, action = " + paramAnonymousIntent.getAction());
          int i = paramAnonymousIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
          if ((10 == i) || (12 == i)) {
            a.this.nst.yn(i);
          }
        }
        AppMethodBeat.o(22607);
      }
    };
    ac.i("McroMsg.exdevice.BluetoohtStateMonitor", "register BluetoothState receiver");
    this.nst = parama;
    parama = new IntentFilter();
    parama.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    ai.getContext().registerReceiver(this.nsu, parama);
    AppMethodBeat.o(22608);
  }
  
  public static abstract interface a
  {
    public abstract void yn(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.d.a
 * JD-Core Version:    0.7.0.1
 */