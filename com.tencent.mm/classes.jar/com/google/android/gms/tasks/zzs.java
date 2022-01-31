package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzs
  implements OnTokenCanceledListener
{
  zzs(TaskCompletionSource paramTaskCompletionSource) {}
  
  public final void onCanceled()
  {
    AppMethodBeat.i(57411);
    TaskCompletionSource.zza(this.zzagc).zzdp();
    AppMethodBeat.o(57411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tasks.zzs
 * JD-Core Version:    0.7.0.1
 */