package com.google.android.gms.iid;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zzg
{
  final Intent intent;
  private final BroadcastReceiver.PendingResult zzbe;
  private boolean zzbf;
  private final ScheduledFuture<?> zzbg;
  
  zzg(Intent paramIntent, BroadcastReceiver.PendingResult paramPendingResult, ScheduledExecutorService paramScheduledExecutorService)
  {
    AppMethodBeat.i(57564);
    this.zzbf = false;
    this.intent = paramIntent;
    this.zzbe = paramPendingResult;
    this.zzbg = paramScheduledExecutorService.schedule(new zzh(this, paramIntent), 9500L, TimeUnit.MILLISECONDS);
    AppMethodBeat.o(57564);
  }
  
  final void finish()
  {
    try
    {
      AppMethodBeat.i(57565);
      if (!this.zzbf)
      {
        this.zzbe.finish();
        this.zzbg.cancel(false);
        this.zzbf = true;
      }
      AppMethodBeat.o(57565);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.iid.zzg
 * JD-Core Version:    0.7.0.1
 */