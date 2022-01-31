package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public class zzadb
  implements Executor
{
  private final Handler mHandler;
  
  public zzadb(Looper paramLooper)
  {
    this.mHandler = new Handler(paramLooper);
  }
  
  public void execute(Runnable paramRunnable)
  {
    this.mHandler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzadb
 * JD-Core Version:    0.7.0.1
 */