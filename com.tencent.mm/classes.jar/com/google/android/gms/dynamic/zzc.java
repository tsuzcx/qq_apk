package com.google.android.gms.dynamic;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzc
  implements DeferredLifecycleHelper.zza
{
  zzc(DeferredLifecycleHelper paramDeferredLifecycleHelper, Bundle paramBundle) {}
  
  public final int getState()
  {
    return 1;
  }
  
  public final void zza(LifecycleDelegate paramLifecycleDelegate)
  {
    AppMethodBeat.i(12129);
    DeferredLifecycleHelper.zzb(this.zzabg).onCreate(this.zzabi);
    AppMethodBeat.o(12129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.dynamic.zzc
 * JD-Core Version:    0.7.0.1
 */