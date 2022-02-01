package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzf
  implements Runnable
{
  zzf(zze paramzze, Task paramTask) {}
  
  public final void run()
  {
    AppMethodBeat.i(13388);
    try
    {
      Task localTask = (Task)zze.zza(this.zzafp).then(this.zzafn);
      if (localTask == null)
      {
        this.zzafp.onFailure(new NullPointerException("Continuation returned null"));
        AppMethodBeat.o(13388);
        return;
      }
    }
    catch (RuntimeExecutionException localRuntimeExecutionException)
    {
      if ((localRuntimeExecutionException.getCause() instanceof Exception))
      {
        zze.zzb(this.zzafp).setException((Exception)localRuntimeExecutionException.getCause());
        AppMethodBeat.o(13388);
        return;
      }
      zze.zzb(this.zzafp).setException(localRuntimeExecutionException);
      AppMethodBeat.o(13388);
      return;
    }
    catch (Exception localException)
    {
      zze.zzb(this.zzafp).setException(localException);
      AppMethodBeat.o(13388);
      return;
    }
    localException.addOnSuccessListener(TaskExecutors.zzagd, this.zzafp);
    localException.addOnFailureListener(TaskExecutors.zzagd, this.zzafp);
    localException.addOnCanceledListener(TaskExecutors.zzagd, this.zzafp);
    AppMethodBeat.o(13388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.tasks.zzf
 * JD-Core Version:    0.7.0.1
 */