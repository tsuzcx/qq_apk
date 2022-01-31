package com.google.android.gms.tasks;

class zza$1
  implements Runnable
{
  zza$1(zza paramzza, Task paramTask) {}
  
  public void run()
  {
    try
    {
      Object localObject = zza.zza(this.zzbNw).then(this.zzbNv);
      zza.zzb(this.zzbNw).setResult(localObject);
      return;
    }
    catch (RuntimeExecutionException localRuntimeExecutionException)
    {
      if ((localRuntimeExecutionException.getCause() instanceof Exception))
      {
        zza.zzb(this.zzbNw).setException((Exception)localRuntimeExecutionException.getCause());
        return;
      }
      zza.zzb(this.zzbNw).setException(localRuntimeExecutionException);
      return;
    }
    catch (Exception localException)
    {
      zza.zzb(this.zzbNw).setException(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.tasks.zza.1
 * JD-Core Version:    0.7.0.1
 */