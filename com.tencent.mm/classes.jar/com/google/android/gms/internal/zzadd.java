package com.google.android.gms.internal;

import android.os.Process;

class zzadd
  implements Runnable
{
  private final int mPriority;
  private final Runnable zzw;
  
  public zzadd(Runnable paramRunnable, int paramInt)
  {
    this.zzw = paramRunnable;
    this.mPriority = paramInt;
  }
  
  public void run()
  {
    Process.setThreadPriority(this.mPriority);
    this.zzw.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.zzadd
 * JD-Core Version:    0.7.0.1
 */