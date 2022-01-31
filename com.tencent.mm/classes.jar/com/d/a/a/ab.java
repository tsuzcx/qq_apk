package com.d.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Handler;

final class ab
  extends c
{
  private static ab bcb;
  WifiManager aVR;
  private final BroadcastReceiver bcc = new ab.1(this);
  private final IntentFilter bcd = new IntentFilter("android.net.wifi.SCAN_RESULTS");
  private ac bce;
  private long bcf = 10000L;
  
  private boolean isAvailable()
  {
    return this.aVR != null;
  }
  
  static ab pF()
  {
    if (bcb == null) {
      bcb = new ab();
    }
    return bcb;
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    if (!isAvailable()) {
      return;
    }
    paramContext.registerReceiver(this.bcc, this.bcd, null, paramHandler);
    this.bcf = parama.aVM;
    parama = this.aVR;
    if (paramHandler != null) {}
    for (;;)
    {
      this.bce = new ac(parama, paramHandler);
      this.bce.i(this.bcf, 0L);
      return;
      paramHandler = new Handler(paramContext.getMainLooper());
    }
  }
  
  final void a(Handler paramHandler, d.a parama)
  {
    if (parama != null) {}
    for (;;)
    {
      try
      {
        super.a(paramHandler, parama);
        return;
      }
      finally {}
      parama = new d.a(10000L);
    }
  }
  
  final void aa(Context paramContext)
  {
    this.aVR = ((WifiManager)paramContext.getSystemService("wifi"));
  }
  
  final void ab(Context paramContext)
  {
    if (!isAvailable()) {
      return;
    }
    paramContext.unregisterReceiver(this.bcc);
    this.bce.stop();
  }
  
  final void oX() {}
  
  final void oY()
  {
    if ((!isAvailable()) || (!this.isRunning) || (this.bcf >= 90000L)) {
      return;
    }
    this.bce.i(90000L, 0L);
  }
  
  final void oZ()
  {
    if ((!isAvailable()) || (!this.isRunning) || (this.bcf >= 90000L)) {
      return;
    }
    this.bce.i(this.bcf, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.d.a.a.ab
 * JD-Core Version:    0.7.0.1
 */