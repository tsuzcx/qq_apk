package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzb
  implements DeferredLifecycleHelper.zza
{
  zzb(DeferredLifecycleHelper paramDeferredLifecycleHelper, Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2) {}
  
  public final int getState()
  {
    return 0;
  }
  
  public final void zza(LifecycleDelegate paramLifecycleDelegate)
  {
    AppMethodBeat.i(61636);
    DeferredLifecycleHelper.zzb(this.zzabg).onInflate(this.val$activity, this.zzabh, this.zzabi);
    AppMethodBeat.o(61636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.dynamic.zzb
 * JD-Core Version:    0.7.0.1
 */