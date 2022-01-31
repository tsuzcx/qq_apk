package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzac;

public final class zzsw$zza<V>
{
  private final V zzaga;
  private final zzaca<V> zzagb;
  
  private zzsw$zza(zzaca<V> paramzzaca, V paramV)
  {
    zzac.zzw(paramzzaca);
    this.zzagb = paramzzaca;
    this.zzaga = paramV;
  }
  
  static zza<Float> zza(String paramString, float paramFloat)
  {
    return zza(paramString, paramFloat, paramFloat);
  }
  
  static zza<Float> zza(String paramString, float paramFloat1, float paramFloat2)
  {
    return new zza(zzaca.zza(paramString, Float.valueOf(paramFloat2)), Float.valueOf(paramFloat1));
  }
  
  static zza<Integer> zza(String paramString, int paramInt1, int paramInt2)
  {
    return new zza(zzaca.zza(paramString, Integer.valueOf(paramInt2)), Integer.valueOf(paramInt1));
  }
  
  static zza<Long> zza(String paramString, long paramLong1, long paramLong2)
  {
    return new zza(zzaca.zza(paramString, Long.valueOf(paramLong2)), Long.valueOf(paramLong1));
  }
  
  static zza<Boolean> zza(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new zza(zzaca.zzj(paramString, paramBoolean2), Boolean.valueOf(paramBoolean1));
  }
  
  static zza<Long> zzb(String paramString, long paramLong)
  {
    return zza(paramString, paramLong, paramLong);
  }
  
  static zza<String> zzd(String paramString1, String paramString2, String paramString3)
  {
    return new zza(zzaca.zzB(paramString1, paramString3), paramString2);
  }
  
  static zza<Integer> zze(String paramString, int paramInt)
  {
    return zza(paramString, paramInt, paramInt);
  }
  
  static zza<Boolean> zzf(String paramString, boolean paramBoolean)
  {
    return zza(paramString, paramBoolean, paramBoolean);
  }
  
  static zza<String> zzr(String paramString1, String paramString2)
  {
    return zzd(paramString1, paramString2, paramString2);
  }
  
  public final V get()
  {
    return this.zzaga;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzsw.zza
 * JD-Core Version:    0.7.0.1
 */