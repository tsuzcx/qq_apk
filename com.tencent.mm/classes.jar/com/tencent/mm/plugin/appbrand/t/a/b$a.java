package com.tencent.mm.plugin.appbrand.t.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class b$a
  extends BroadcastReceiver
{
  private b$a(b paramb) {}
  
  public final void onReceive(Context arg1, Intent paramIntent)
  {
    synchronized (this.iYs.iYq)
    {
      this.iYs.iYp = paramIntent;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.a.b.a
 * JD-Core Version:    0.7.0.1
 */