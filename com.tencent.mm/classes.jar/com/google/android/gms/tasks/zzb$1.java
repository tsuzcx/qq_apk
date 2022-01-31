package com.google.android.gms.tasks;

class zzb$1
  implements Runnable
{
  zzb$1(zzb paramzzb, Task paramTask) {}
  
  public void run()
  {
    try
    {
      Task localTask = (Task)zzb.zza(this.zzbNx).then(this.zzbNv);
      if (localTask == null)
      {
        this.zzbNx.onFailure(new NullPointerException("Continuation returned null"));
        return;
      }
    }
    catch (RuntimeExecutionException localRuntimeExecutionException)
    {
      if ((localRuntimeExecutionException.getCause() instanceof Exception))
      {
        zzb.zzb(this.zzbNx).setException((Exception)localRuntimeExecutionException.getCause());
        return;
      }
      zzb.zzb(this.zzbNx).setException(localRuntimeExecutionException);
      return;
    }
    catch (Exception localException)
    {
      zzb.zzb(this.zzbNx).setException(localException);
      return;
    }
    localException.addOnSuccessListener(TaskExecutors.zzbNH, this.zzbNx);
    localException.addOnFailureListener(TaskExecutors.zzbNH, this.zzbNx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.tasks.zzb.1
 * JD-Core Version:    0.7.0.1
 */