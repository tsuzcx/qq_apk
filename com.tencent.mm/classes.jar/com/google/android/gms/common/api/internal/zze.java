package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class zze
  extends zzc<Void>
{
  private final RegisterListenerMethod<Api.AnyClient, ?> zzdw;
  private final UnregisterListenerMethod<Api.AnyClient, ?> zzdx;
  
  public zze(zzbv paramzzbv, TaskCompletionSource<Void> paramTaskCompletionSource)
  {
    super(3, paramTaskCompletionSource);
    this.zzdw = paramzzbv.zzlt;
    this.zzdx = paramzzbv.zzlu;
  }
  
  public final void zzb(GoogleApiManager.zza<?> paramzza)
  {
    AppMethodBeat.i(11397);
    this.zzdw.registerListener(paramzza.zzae(), this.zzdu);
    if (this.zzdw.getListenerKey() != null) {
      paramzza.zzbn().put(this.zzdw.getListenerKey(), new zzbv(this.zzdw, this.zzdx));
    }
    AppMethodBeat.o(11397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zze
 * JD-Core Version:    0.7.0.1
 */