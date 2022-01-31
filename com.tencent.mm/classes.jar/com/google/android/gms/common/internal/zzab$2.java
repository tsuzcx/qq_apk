package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

final class zzab$2
  implements PendingResult.zza
{
  zzab$2(PendingResult paramPendingResult, TaskCompletionSource paramTaskCompletionSource, zzab.zza paramzza, zzab.zzb paramzzb) {}
  
  public final void zzy(Status paramStatus)
  {
    if (paramStatus.isSuccess())
    {
      paramStatus = this.zzaGx.await(0L, TimeUnit.MILLISECONDS);
      this.zzaGy.setResult(this.zzaGz.zzf(paramStatus));
      return;
    }
    this.zzaGy.setException(this.zzaGA.zzH(paramStatus));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzab.2
 * JD-Core Version:    0.7.0.1
 */