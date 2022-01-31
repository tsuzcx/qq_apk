package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public class zzc
  extends Thread
{
  private static final boolean DEBUG = zzt.DEBUG;
  private final BlockingQueue<zzl<?>> zzg;
  private final BlockingQueue<zzl<?>> zzh;
  private final zzb zzi;
  private final zzo zzj;
  private volatile boolean zzk = false;
  
  public zzc(BlockingQueue<zzl<?>> paramBlockingQueue1, BlockingQueue<zzl<?>> paramBlockingQueue2, zzb paramzzb, zzo paramzzo)
  {
    this.zzg = paramBlockingQueue1;
    this.zzh = paramBlockingQueue2;
    this.zzi = paramzzb;
    this.zzj = paramzzo;
  }
  
  public void quit()
  {
    this.zzk = true;
    interrupt();
  }
  
  public void run()
  {
    if (DEBUG) {
      zzt.zza("start new dispatcher", new Object[0]);
    }
    Process.setThreadPriority(10);
    this.zzi.initialize();
    for (;;)
    {
      zzb.zza localzza;
      try
      {
        zzl localzzl = (zzl)this.zzg.take();
        localzzl.zzc("cache-queue-take");
        localzza = this.zzi.zza(localzzl.zzg());
        if (localzza != null) {
          break label94;
        }
        localzzl.zzc("cache-miss");
        this.zzh.put(localzzl);
        continue;
        if (!this.zzk) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException) {}
      return;
      label94:
      if (localzza.zza())
      {
        localInterruptedException.zzc("cache-hit-expired");
        localInterruptedException.zza(localzza);
        this.zzh.put(localInterruptedException);
      }
      else
      {
        localInterruptedException.zzc("cache-hit");
        zzn localzzn = localInterruptedException.zza(new zzj(localzza.data, localzza.zzf));
        localInterruptedException.zzc("cache-hit-parsed");
        if (!localzza.zzb())
        {
          this.zzj.zza(localInterruptedException, localzzn);
        }
        else
        {
          localInterruptedException.zzc("cache-hit-refresh-needed");
          localInterruptedException.zza(localzza);
          localzzn.zzah = true;
          this.zzj.zza(localInterruptedException, localzzn, new zzc.1(this, localInterruptedException));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzc
 * JD-Core Version:    0.7.0.1
 */