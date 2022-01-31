package com.tencent.mm.plugin.f.a.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  extends BroadcastReceiver
{
  a$1(a parama) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      y.e("McroMsg.exdevice.BluetoohtStateMonitor", "null == intent");
    }
    int i;
    do
    {
      do
      {
        return;
      } while (!paramIntent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED"));
      y.i("McroMsg.exdevice.BluetoohtStateMonitor", "onReceive, action = " + paramIntent.getAction());
      i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
    } while ((10 != i) && (12 != i));
    this.hXo.hXm.ob(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.d.a.1
 * JD-Core Version:    0.7.0.1
 */