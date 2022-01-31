package com.tencent.mm.plugin.hp.tinker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$2
  extends BroadcastReceiver
{
  a$2(a parama, Runnable paramRunnable) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(90625);
    if (paramIntent == null) {}
    for (paramIntent = ""; "android.intent.action.SCREEN_OFF".equals(paramIntent); paramIntent = paramIntent.getAction())
    {
      com.tencent.tinker.lib.f.a.i("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch screen off now, send message now", new Object[0]);
      this.nKD.handler.postDelayed(this.val$runnable, this.nKE);
      AppMethodBeat.o(90625);
      return;
    }
    com.tencent.tinker.lib.f.a.i("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch screen on, remove pending runnable and receive", new Object[0]);
    this.nKD.handler.removeCallbacks(this.val$runnable);
    paramContext.unregisterReceiver(this);
    AppMethodBeat.o(90625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.a.2
 * JD-Core Version:    0.7.0.1
 */