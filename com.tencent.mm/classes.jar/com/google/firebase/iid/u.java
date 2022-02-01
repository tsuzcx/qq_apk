package com.google.firebase.iid;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class u
{
  private final BroadcastReceiver.PendingResult dDu;
  private final ScheduledFuture<?> dDv;
  final Intent intent;
  private boolean zzt;
  
  u(Intent paramIntent, BroadcastReceiver.PendingResult paramPendingResult, ScheduledExecutorService paramScheduledExecutorService)
  {
    AppMethodBeat.i(4210);
    this.zzt = false;
    this.intent = paramIntent;
    this.dDu = paramPendingResult;
    this.dDv = paramScheduledExecutorService.schedule(new v(this, paramIntent), 9500L, TimeUnit.MILLISECONDS);
    AppMethodBeat.o(4210);
  }
  
  final void finish()
  {
    try
    {
      AppMethodBeat.i(4211);
      if (!this.zzt)
      {
        this.dDu.finish();
        this.dDv.cancel(false);
        this.zzt = true;
      }
      AppMethodBeat.o(4211);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.iid.u
 * JD-Core Version:    0.7.0.1
 */