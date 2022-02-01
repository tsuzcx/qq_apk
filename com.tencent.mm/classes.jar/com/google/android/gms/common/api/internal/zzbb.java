package com.google.android.gms.common.api.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class zzbb
  extends GooglePlayServicesUpdatedReceiver.Callback
{
  private WeakReference<zzav> zziy;
  
  zzbb(zzav paramzzav)
  {
    AppMethodBeat.i(11306);
    this.zziy = new WeakReference(paramzzav);
    AppMethodBeat.o(11306);
  }
  
  public final void zzv()
  {
    AppMethodBeat.i(11307);
    zzav localzzav = (zzav)this.zziy.get();
    if (localzzav == null)
    {
      AppMethodBeat.o(11307);
      return;
    }
    zzav.zza(localzzav);
    AppMethodBeat.o(11307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzbb
 * JD-Core Version:    0.7.0.1
 */