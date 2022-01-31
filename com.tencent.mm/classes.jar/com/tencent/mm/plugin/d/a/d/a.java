package com.tencent.mm.plugin.d.a.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
{
  final a.a jRf;
  public final BroadcastReceiver jRg;
  
  public a(a.a parama)
  {
    AppMethodBeat.i(18497);
    this.jRg = new a.1(this);
    ab.i("McroMsg.exdevice.BluetoohtStateMonitor", "register BluetoothState receiver");
    this.jRf = parama;
    parama = new IntentFilter();
    parama.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    ah.getContext().registerReceiver(this.jRg, parama);
    AppMethodBeat.o(18497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.d.a
 * JD-Core Version:    0.7.0.1
 */