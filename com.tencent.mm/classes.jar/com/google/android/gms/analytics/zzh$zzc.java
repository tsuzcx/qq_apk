package com.google.android.gms.analytics;

import android.os.Process;

class zzh$zzc
  extends Thread
{
  zzh$zzc(Runnable paramRunnable, String paramString)
  {
    super(paramRunnable, paramString);
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    super.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.analytics.zzh.zzc
 * JD-Core Version:    0.7.0.1
 */