package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Map;

final class zzet<T>
  extends zzgm<Status>
{
  private WeakReference<Map<T, zzhk<T>>> zzec;
  private WeakReference<T> zzed;
  
  zzet(Map<T, zzhk<T>> paramMap, T paramT, BaseImplementation.ResultHolder<Status> paramResultHolder)
  {
    super(paramResultHolder);
    AppMethodBeat.i(101268);
    this.zzec = new WeakReference(paramMap);
    this.zzed = new WeakReference(paramT);
    AppMethodBeat.o(101268);
  }
  
  public final void zza(Status paramStatus)
  {
    AppMethodBeat.i(101269);
    Map localMap = (Map)this.zzec.get();
    Object localObject = this.zzed.get();
    if ((paramStatus.getStatus().getStatusCode() == 4002) && (localMap != null) && (localObject != null)) {}
    try
    {
      localObject = (zzhk)localMap.remove(localObject);
      if (localObject != null) {
        ((zzhk)localObject).clear();
      }
      zza(paramStatus);
      AppMethodBeat.o(101269);
      return;
    }
    finally
    {
      AppMethodBeat.o(101269);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzet
 * JD-Core Version:    0.7.0.1
 */