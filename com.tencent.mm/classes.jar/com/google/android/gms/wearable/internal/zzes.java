package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Map;

final class zzes<T>
  extends zzgm<Status>
{
  private WeakReference<Map<T, zzhk<T>>> zzec;
  private WeakReference<T> zzed;
  
  zzes(Map<T, zzhk<T>> paramMap, T paramT, BaseImplementation.ResultHolder<Status> paramResultHolder)
  {
    super(paramResultHolder);
    AppMethodBeat.i(71283);
    this.zzec = new WeakReference(paramMap);
    this.zzed = new WeakReference(paramT);
    AppMethodBeat.o(71283);
  }
  
  public final void zza(Status paramStatus)
  {
    AppMethodBeat.i(71284);
    Map localMap = (Map)this.zzec.get();
    Object localObject = this.zzed.get();
    if ((!paramStatus.getStatus().isSuccess()) && (localMap != null) && (localObject != null)) {}
    try
    {
      localObject = (zzhk)localMap.remove(localObject);
      if (localObject != null) {
        ((zzhk)localObject).clear();
      }
      zza(paramStatus);
      AppMethodBeat.o(71284);
      return;
    }
    finally
    {
      AppMethodBeat.o(71284);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzes
 * JD-Core Version:    0.7.0.1
 */