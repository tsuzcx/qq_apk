package com.google.android.gms.internal;

public class zzn<T>
{
  public final T result;
  public final zzb.zza zzaf;
  public final zzs zzag;
  public boolean zzah = false;
  
  private zzn(zzs paramzzs)
  {
    this.result = null;
    this.zzaf = null;
    this.zzag = paramzzs;
  }
  
  private zzn(T paramT, zzb.zza paramzza)
  {
    this.result = paramT;
    this.zzaf = paramzza;
    this.zzag = null;
  }
  
  public static <T> zzn<T> zza(T paramT, zzb.zza paramzza)
  {
    return new zzn(paramT, paramzza);
  }
  
  public static <T> zzn<T> zzd(zzs paramzzs)
  {
    return new zzn(paramzzs);
  }
  
  public boolean isSuccess()
  {
    return this.zzag == null;
  }
  
  public static abstract interface zzb<T>
  {
    public abstract void zzb(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzn
 * JD-Core Version:    0.7.0.1
 */