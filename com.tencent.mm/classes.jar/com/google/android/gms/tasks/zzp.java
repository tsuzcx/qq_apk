package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;

final class zzp
  implements Runnable
{
  zzp(zzo paramzzo, Task paramTask) {}
  
  public final void run()
  {
    AppMethodBeat.i(13406);
    try
    {
      Task localTask = zzo.zza(this.zzafz).then(this.zzafn.getResult());
      if (localTask == null)
      {
        this.zzafz.onFailure(new NullPointerException("Continuation returned null"));
        AppMethodBeat.o(13406);
        return;
      }
    }
    catch (RuntimeExecutionException localRuntimeExecutionException)
    {
      if ((localRuntimeExecutionException.getCause() instanceof Exception))
      {
        this.zzafz.onFailure((Exception)localRuntimeExecutionException.getCause());
        AppMethodBeat.o(13406);
        return;
      }
      this.zzafz.onFailure(localRuntimeExecutionException);
      AppMethodBeat.o(13406);
      return;
    }
    catch (CancellationException localCancellationException)
    {
      this.zzafz.onCanceled();
      AppMethodBeat.o(13406);
      return;
    }
    catch (Exception localException)
    {
      this.zzafz.onFailure(localException);
      AppMethodBeat.o(13406);
      return;
    }
    localException.addOnSuccessListener(TaskExecutors.zzagd, this.zzafz);
    localException.addOnFailureListener(TaskExecutors.zzagd, this.zzafz);
    localException.addOnCanceledListener(TaskExecutors.zzagd, this.zzafz);
    AppMethodBeat.o(13406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tasks.zzp
 * JD-Core Version:    0.7.0.1
 */