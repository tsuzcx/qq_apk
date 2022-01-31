package com.google.android.gms.tasks;

class zzc$1
  implements Runnable
{
  zzc$1(zzc paramzzc, Task paramTask) {}
  
  public void run()
  {
    synchronized (zzc.zza(this.zzbNz))
    {
      if (zzc.zzb(this.zzbNz) != null) {
        zzc.zzb(this.zzbNz).onComplete(this.zzbNv);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.tasks.zzc.1
 * JD-Core Version:    0.7.0.1
 */