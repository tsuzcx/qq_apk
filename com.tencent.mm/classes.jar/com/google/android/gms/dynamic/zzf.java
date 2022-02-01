package com.google.android.gms.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzf
  implements DeferredLifecycleHelper.zza
{
  zzf(DeferredLifecycleHelper paramDeferredLifecycleHelper) {}
  
  public final int getState()
  {
    return 4;
  }
  
  public final void zza(LifecycleDelegate paramLifecycleDelegate)
  {
    AppMethodBeat.i(12132);
    DeferredLifecycleHelper.zzb(this.zzabg).onStart();
    AppMethodBeat.o(12132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.dynamic.zzf
 * JD-Core Version:    0.7.0.1
 */