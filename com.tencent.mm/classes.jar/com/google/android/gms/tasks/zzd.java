package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzd
  implements Runnable
{
  zzd(zzc paramzzc, Task paramTask) {}
  
  public final void run()
  {
    AppMethodBeat.i(57383);
    if (this.zzafn.isCanceled())
    {
      zzc.zza(this.zzafo).zzdp();
      AppMethodBeat.o(57383);
      return;
    }
    try
    {
      Object localObject = zzc.zzb(this.zzafo).then(this.zzafn);
      zzc.zza(this.zzafo).setResult(localObject);
      AppMethodBeat.o(57383);
      return;
    }
    catch (RuntimeExecutionException localRuntimeExecutionException)
    {
      if ((localRuntimeExecutionException.getCause() instanceof Exception))
      {
        zzc.zza(this.zzafo).setException((Exception)localRuntimeExecutionException.getCause());
        AppMethodBeat.o(57383);
        return;
      }
      zzc.zza(this.zzafo).setException(localRuntimeExecutionException);
      AppMethodBeat.o(57383);
      return;
    }
    catch (Exception localException)
    {
      zzc.zza(this.zzafo).setException(localException);
      AppMethodBeat.o(57383);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tasks.zzd
 * JD-Core Version:    0.7.0.1
 */