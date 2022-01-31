package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

final class Tasks$1
  implements Runnable
{
  Tasks$1(zzh paramzzh, Callable paramCallable) {}
  
  public final void run()
  {
    try
    {
      this.zzbNM.setResult(this.zzXy.call());
      return;
    }
    catch (Exception localException)
    {
      this.zzbNM.setException(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.tasks.Tasks.1
 * JD-Core Version:    0.7.0.1
 */