package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzcd
  implements Runnable
{
  zzcd(zzcc paramzzcc, LifecycleCallback paramLifecycleCallback, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(89514);
    LifecycleCallback localLifecycleCallback;
    if (zzcc.zza(this.zzly) > 0)
    {
      localLifecycleCallback = this.zzle;
      if (zzcc.zzb(this.zzly) == null) {
        break label128;
      }
    }
    label128:
    for (Bundle localBundle = zzcc.zzb(this.zzly).getBundle(this.zzlf);; localBundle = null)
    {
      localLifecycleCallback.onCreate(localBundle);
      if (zzcc.zza(this.zzly) >= 2) {
        this.zzle.onStart();
      }
      if (zzcc.zza(this.zzly) >= 3) {
        this.zzle.onResume();
      }
      if (zzcc.zza(this.zzly) >= 4) {
        this.zzle.onStop();
      }
      if (zzcc.zza(this.zzly) >= 5) {
        this.zzle.onDestroy();
      }
      AppMethodBeat.o(89514);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzcd
 * JD-Core Version:    0.7.0.1
 */