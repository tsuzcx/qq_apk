package com.google.android.gms.analytics;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class zzh$zza
  extends ThreadPoolExecutor
{
  public zzh$zza(zzh paramzzh)
  {
    super(1, 1, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue());
    setThreadFactory(new zzh.zzb(null));
    allowCoreThreadTimeOut(true);
  }
  
  protected <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT)
  {
    return new zzh.zza.1(this, paramRunnable, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.analytics.zzh.zza
 * JD-Core Version:    0.7.0.1
 */