package com.google.android.gms.wearable.internal;

public final class zzac
  extends zzbt.zza
{
  private zzr zzbUi;
  private zzad zzbUm;
  private final Object zzrJ = new Object();
  
  public final void zzE(int paramInt1, int paramInt2)
  {
    synchronized (this.zzrJ)
    {
      zzad localzzad = this.zzbUm;
      zzr localzzr = new zzr(paramInt1, paramInt2);
      this.zzbUi = localzzr;
      if (localzzad != null) {
        localzzad.zzb(localzzr);
      }
      return;
    }
  }
  
  public final void zza(zzad paramzzad)
  {
    synchronized (this.zzrJ)
    {
      this.zzbUm = ((zzad)com.google.android.gms.common.internal.zzac.zzw(paramzzad));
      zzr localzzr = this.zzbUi;
      if (localzzr != null) {
        paramzzad.zzb(localzzr);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzac
 * JD-Core Version:    0.7.0.1
 */