package com.tencent.mm.plugin.g.a.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  final a vyb;
  public final BroadcastReceiver vyc;
  
  public a(a parama)
  {
    AppMethodBeat.i(22608);
    this.vyc = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(22607);
        if (paramAnonymousIntent == null)
        {
          Log.e("McroMsg.exdevice.BluetoohtStateMonitor", "null == intent");
          AppMethodBeat.o(22607);
          return;
        }
        if (paramAnonymousIntent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED"))
        {
          Log.i("McroMsg.exdevice.BluetoohtStateMonitor", "onReceive, action = " + paramAnonymousIntent.getAction());
          int i = paramAnonymousIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
          if ((10 == i) || (12 == i)) {
            a.this.vyb.GQ(i);
          }
        }
        AppMethodBeat.o(22607);
      }
    };
    Log.i("McroMsg.exdevice.BluetoohtStateMonitor", "register BluetoothState receiver");
    this.vyb = parama;
    parama = new IntentFilter();
    parama.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    MMApplicationContext.getContext().registerReceiver(this.vyc, parama);
    AppMethodBeat.o(22608);
  }
  
  public static abstract interface a
  {
    public abstract void GQ(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.d.a
 * JD-Core Version:    0.7.0.1
 */