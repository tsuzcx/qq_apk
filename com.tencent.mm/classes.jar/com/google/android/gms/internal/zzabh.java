package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.zzac;

public final class zzabh<L>
{
  private volatile L mListener;
  private final zzabh.zza zzaCX;
  private final zzabh.zzb<L> zzaCY;
  
  zzabh(Looper paramLooper, L paramL, String paramString)
  {
    this.zzaCX = new zzabh.zza(this, paramLooper);
    this.mListener = zzac.zzb(paramL, "Listener must not be null");
    this.zzaCY = new zzabh.zzb(paramL, zzac.zzdr(paramString));
  }
  
  public final void clear()
  {
    this.mListener = null;
  }
  
  public final void zza(zzc<? super L> paramzzc)
  {
    zzac.zzb(paramzzc, "Notifier must not be null");
    paramzzc = this.zzaCX.obtainMessage(1, paramzzc);
    this.zzaCX.sendMessage(paramzzc);
  }
  
  final void zzb(zzc<? super L> paramzzc)
  {
    Object localObject = this.mListener;
    if (localObject == null)
    {
      paramzzc.zzwc();
      return;
    }
    try
    {
      paramzzc.zzs(localObject);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramzzc.zzwc();
      throw localRuntimeException;
    }
  }
  
  public final boolean zztK()
  {
    return this.mListener != null;
  }
  
  public final zzabh.zzb<L> zzwW()
  {
    return this.zzaCY;
  }
  
  public static abstract interface zzc<L>
  {
    public abstract void zzs(L paramL);
    
    public abstract void zzwc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzabh
 * JD-Core Version:    0.7.0.1
 */