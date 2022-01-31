package com.google.android.gms.internal;

class zzf$zza
  implements Runnable
{
  private final zzl zzu;
  private final zzn zzv;
  private final Runnable zzw;
  
  public zzf$zza(zzf paramzzf, zzl paramzzl, zzn paramzzn, Runnable paramRunnable)
  {
    this.zzu = paramzzl;
    this.zzv = paramzzn;
    this.zzw = paramRunnable;
  }
  
  public void run()
  {
    if (this.zzv.isSuccess())
    {
      this.zzu.zza(this.zzv.result);
      if (!this.zzv.zzah) {
        break label77;
      }
      this.zzu.zzc("intermediate-response");
    }
    for (;;)
    {
      if (this.zzw != null) {
        this.zzw.run();
      }
      return;
      this.zzu.zzc(this.zzv.zzag);
      break;
      label77:
      this.zzu.zzd("done");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzf.zza
 * JD-Core Version:    0.7.0.1
 */