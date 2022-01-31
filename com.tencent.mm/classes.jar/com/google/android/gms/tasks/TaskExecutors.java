package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class TaskExecutors
{
  public static final Executor MAIN_THREAD = new zza();
  static final Executor zzbNH = new TaskExecutors.1();
  
  private static final class zza
    implements Executor
  {
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    
    public final void execute(Runnable paramRunnable)
    {
      this.mHandler.post(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.tasks.TaskExecutors
 * JD-Core Version:    0.7.0.1
 */