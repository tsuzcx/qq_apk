package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

class zzgm<T>
  extends zza
{
  private BaseImplementation.ResultHolder<T> zzet;
  
  public zzgm(BaseImplementation.ResultHolder<T> paramResultHolder)
  {
    this.zzet = paramResultHolder;
  }
  
  public final void zza(T paramT)
  {
    AppMethodBeat.i(71374);
    BaseImplementation.ResultHolder localResultHolder = this.zzet;
    if (localResultHolder != null)
    {
      localResultHolder.setResult(paramT);
      this.zzet = null;
    }
    AppMethodBeat.o(71374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgm
 * JD-Core Version:    0.7.0.1
 */