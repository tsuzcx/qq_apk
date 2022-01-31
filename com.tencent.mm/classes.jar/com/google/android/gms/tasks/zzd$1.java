package com.google.android.gms.tasks;

class zzd$1
  implements Runnable
{
  zzd$1(zzd paramzzd, Task paramTask) {}
  
  public void run()
  {
    synchronized (zzd.zza(this.zzbNB))
    {
      if (zzd.zzb(this.zzbNB) != null) {
        zzd.zzb(this.zzbNB).onFailure(this.zzbNv.getException());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.tasks.zzd.1
 * JD-Core Version:    0.7.0.1
 */