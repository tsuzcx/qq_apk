package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

final class zzac
  implements OnCompleteListener<TResult>
{
  zzac(zzaa paramzzaa, TaskCompletionSource paramTaskCompletionSource) {}
  
  public final void onComplete(Task<TResult> paramTask)
  {
    AppMethodBeat.i(11176);
    zzaa.zzb(this.zzgz).remove(this.zzha);
    AppMethodBeat.o(11176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzac
 * JD-Core Version:    0.7.0.1
 */