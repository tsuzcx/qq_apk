package com.tencent.mm.plugin.f.a.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  final a.a hXm;
  public final BroadcastReceiver hXn = new a.1(this);
  
  public a(a.a parama)
  {
    y.i("McroMsg.exdevice.BluetoohtStateMonitor", "register BluetoothState receiver");
    this.hXm = parama;
    parama = new IntentFilter();
    parama.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    ae.getContext().registerReceiver(this.hXn, parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.d.a
 * JD-Core Version:    0.7.0.1
 */