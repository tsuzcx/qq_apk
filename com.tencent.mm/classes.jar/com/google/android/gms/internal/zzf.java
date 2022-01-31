package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

public class zzf
  implements zzo
{
  private final Executor zzr;
  
  public zzf(Handler paramHandler)
  {
    this.zzr = new zzf.1(this, paramHandler);
  }
  
  public void zza(zzl<?> paramzzl, zzn<?> paramzzn)
  {
    zza(paramzzl, paramzzn, null);
  }
  
  public void zza(zzl<?> paramzzl, zzn<?> paramzzn, Runnable paramRunnable)
  {
    paramzzl.zzr();
    paramzzl.zzc("post-response");
    this.zzr.execute(new zzf.zza(this, paramzzl, paramzzn, paramRunnable));
  }
  
  public void zza(zzl<?> paramzzl, zzs paramzzs)
  {
    paramzzl.zzc("post-error");
    paramzzs = zzn.zzd(paramzzs);
    this.zzr.execute(new zzf.zza(this, paramzzl, paramzzs, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzf
 * JD-Core Version:    0.7.0.1
 */