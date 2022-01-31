package com.google.android.gms.tasks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class Tasks$zza
  implements Tasks.zzb
{
  private final CountDownLatch zztj = new CountDownLatch(1);
  
  public final void await()
  {
    this.zztj.await();
  }
  
  public final boolean await(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.zztj.await(paramLong, paramTimeUnit);
  }
  
  public final void onFailure(Exception paramException)
  {
    this.zztj.countDown();
  }
  
  public final void onSuccess(Object paramObject)
  {
    this.zztj.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.tasks.Tasks.zza
 * JD-Core Version:    0.7.0.1
 */