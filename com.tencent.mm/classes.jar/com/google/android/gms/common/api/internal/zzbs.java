package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbs
  implements Runnable
{
  zzbs(zzbr paramzzbr, LifecycleCallback paramLifecycleCallback, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(4521);
    LifecycleCallback localLifecycleCallback;
    if (zzbr.zza(this.zzlg) > 0)
    {
      localLifecycleCallback = this.zzle;
      if (zzbr.zzb(this.zzlg) == null) {
        break label130;
      }
    }
    label130:
    for (Bundle localBundle = zzbr.zzb(this.zzlg).getBundle(this.zzlf);; localBundle = null)
    {
      localLifecycleCallback.onCreate(localBundle);
      if (zzbr.zza(this.zzlg) >= 2) {
        this.zzle.onStart();
      }
      if (zzbr.zza(this.zzlg) >= 3) {
        this.zzle.onResume();
      }
      if (zzbr.zza(this.zzlg) >= 4) {
        this.zzle.onStop();
      }
      if (zzbr.zza(this.zzlg) >= 5) {
        this.zzle.onDestroy();
      }
      AppMethodBeat.o(4521);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzbs
 * JD-Core Version:    0.7.0.1
 */