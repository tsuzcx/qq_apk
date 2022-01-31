package com.tencent.mm.plugin.hp.tinker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

final class a$2
  extends BroadcastReceiver
{
  a$2(a parama, Runnable paramRunnable) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (paramIntent = ""; "android.intent.action.SCREEN_OFF".equals(paramIntent); paramIntent = paramIntent.getAction())
    {
      com.tencent.tinker.lib.f.a.i("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch screen off now, send message now", new Object[0]);
      this.lnm.handler.postDelayed(this.val$runnable, this.lnn);
      return;
    }
    com.tencent.tinker.lib.f.a.i("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch screen on, remove pending runnable and receive", new Object[0]);
    this.lnm.handler.removeCallbacks(this.val$runnable);
    paramContext.unregisterReceiver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.a.2
 * JD-Core Version:    0.7.0.1
 */