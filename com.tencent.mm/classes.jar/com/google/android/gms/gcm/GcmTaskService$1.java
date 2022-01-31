package com.google.android.gms.gcm;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class GcmTaskService$1
  implements ThreadFactory
{
  private final AtomicInteger zzbgx = new AtomicInteger(1);
  
  GcmTaskService$1(GcmTaskService paramGcmTaskService) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    int i = this.zzbgx.getAndIncrement();
    paramRunnable = new Thread(paramRunnable, 20 + "gcm-task#" + i);
    paramRunnable.setPriority(4);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.gcm.GcmTaskService.1
 * JD-Core Version:    0.7.0.1
 */