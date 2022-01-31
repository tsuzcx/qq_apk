package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;

public abstract class zzaan<L>
  implements zzabh.zzc<L>
{
  private final DataHolder zzaBi;
  
  protected zzaan(DataHolder paramDataHolder)
  {
    this.zzaBi = paramDataHolder;
  }
  
  protected abstract void zza(L paramL, DataHolder paramDataHolder);
  
  public final void zzs(L paramL)
  {
    zza(paramL, this.zzaBi);
  }
  
  public void zzwc()
  {
    if (this.zzaBi != null) {
      this.zzaBi.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzaan
 * JD-Core Version:    0.7.0.1
 */