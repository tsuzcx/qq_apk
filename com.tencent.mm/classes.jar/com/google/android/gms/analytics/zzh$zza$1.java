package com.google.android.gms.analytics;

import android.util.Log;
import java.util.concurrent.FutureTask;

class zzh$zza$1
  extends FutureTask<T>
{
  zzh$zza$1(zzh.zza paramzza, Runnable paramRunnable, Object paramObject)
  {
    super(paramRunnable, paramObject);
  }
  
  protected void setException(Throwable paramThrowable)
  {
    Object localObject = zzh.zzb(this.zzacp.zzaco);
    if (localObject != null) {
      ((Thread.UncaughtExceptionHandler)localObject).uncaughtException(Thread.currentThread(), paramThrowable);
    }
    for (;;)
    {
      super.setException(paramThrowable);
      return;
      if (Log.isLoggable("GAv4", 6))
      {
        localObject = String.valueOf(paramThrowable);
        new StringBuilder(String.valueOf(localObject).length() + 37).append("MeasurementExecutor: job failed with ").append((String)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.analytics.zzh.zza.1
 * JD-Core Version:    0.7.0.1
 */