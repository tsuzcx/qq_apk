package com.tencent.mm.plugin.appbrand.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.v.c;
import com.tencent.mm.sdk.platformtools.ai;

final class f$1
  extends BroadcastReceiver
{
  f$1(f paramf) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())) {
      return;
    }
    c.DS().O(new f.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.f.1
 * JD-Core Version:    0.7.0.1
 */