package com.google.android.gms.internal;

import java.util.concurrent.BlockingQueue;

class zzc$1
  implements Runnable
{
  zzc$1(zzc paramzzc, zzl paramzzl) {}
  
  public void run()
  {
    try
    {
      zzc.zza(this.zzm).put(this.zzl);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzc.1
 * JD-Core Version:    0.7.0.1
 */