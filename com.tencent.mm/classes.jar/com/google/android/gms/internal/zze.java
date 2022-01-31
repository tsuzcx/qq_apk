package com.google.android.gms.internal;

public class zze
  implements zzp
{
  private int zzn;
  private int zzo;
  private final int zzp;
  private final float zzq;
  
  public zze()
  {
    this(2500, 1, 1.0F);
  }
  
  public zze(int paramInt1, int paramInt2, float paramFloat)
  {
    this.zzn = paramInt1;
    this.zzp = paramInt2;
    this.zzq = paramFloat;
  }
  
  public void zza(zzs paramzzs)
  {
    this.zzo += 1;
    this.zzn = ((int)(this.zzn + this.zzn * this.zzq));
    if (!zze()) {
      throw paramzzs;
    }
  }
  
  public int zzc()
  {
    return this.zzn;
  }
  
  public int zzd()
  {
    return this.zzo;
  }
  
  protected boolean zze()
  {
    return this.zzo <= this.zzp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zze
 * JD-Core Version:    0.7.0.1
 */