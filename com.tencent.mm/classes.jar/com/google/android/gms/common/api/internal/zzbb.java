package com.google.android.gms.common.api.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class zzbb
  extends GooglePlayServicesUpdatedReceiver.Callback
{
  private WeakReference<zzav> zziy;
  
  zzbb(zzav paramzzav)
  {
    AppMethodBeat.i(60814);
    this.zziy = new WeakReference(paramzzav);
    AppMethodBeat.o(60814);
  }
  
  public final void zzv()
  {
    AppMethodBeat.i(60815);
    zzav localzzav = (zzav)this.zziy.get();
    if (localzzav == null)
    {
      AppMethodBeat.o(60815);
      return;
    }
    zzav.zza(localzzav);
    AppMethodBeat.o(60815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzbb
 * JD-Core Version:    0.7.0.1
 */