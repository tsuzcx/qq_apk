package com.google.android.gms.tasks;

class zze$1
  implements Runnable
{
  zze$1(zze paramzze, Task paramTask) {}
  
  public void run()
  {
    synchronized (zze.zza(this.zzbND))
    {
      if (zze.zzb(this.zzbND) != null) {
        zze.zzb(this.zzbND).onSuccess(this.zzbNv.getResult());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.tasks.zze.1
 * JD-Core Version:    0.7.0.1
 */