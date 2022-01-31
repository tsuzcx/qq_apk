package com.tencent.mm.plugin.appbrand.v.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class b$a
  extends BroadcastReceiver
{
  private b$a(b paramb) {}
  
  public final void onReceive(Context arg1, Intent paramIntent)
  {
    synchronized (this.hlR.hlP)
    {
      this.hlR.hlO = paramIntent;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.a.b.a
 * JD-Core Version:    0.7.0.1
 */