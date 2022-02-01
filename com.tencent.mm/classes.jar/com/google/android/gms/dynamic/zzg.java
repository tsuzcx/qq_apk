package com.google.android.gms.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzg
  implements DeferredLifecycleHelper.zza
{
  zzg(DeferredLifecycleHelper paramDeferredLifecycleHelper) {}
  
  public final int getState()
  {
    return 5;
  }
  
  public final void zza(LifecycleDelegate paramLifecycleDelegate)
  {
    AppMethodBeat.i(12133);
    DeferredLifecycleHelper.zzb(this.zzabg).onResume();
    AppMethodBeat.o(12133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.gms.dynamic.zzg
 * JD-Core Version:    0.7.0.1
 */