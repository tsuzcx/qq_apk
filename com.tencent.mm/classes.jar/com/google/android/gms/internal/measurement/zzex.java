package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

@VisibleForTesting
public final class zzex<V>
{
  private final zzws<V> zzaid;
  private final String zzny;
  
  private zzex(String paramString, zzws<V> paramzzws)
  {
    AppMethodBeat.i(1274);
    Preconditions.checkNotNull(paramzzws);
    this.zzaid = paramzzws;
    this.zzny = paramString;
    AppMethodBeat.o(1274);
  }
  
  static zzex<Double> zza(String paramString, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(1279);
    paramString = new zzex(paramString, zzew.zzig().zzb(paramString, -3.0D));
    AppMethodBeat.o(1279);
    return paramString;
  }
  
  static zzex<Long> zzb(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(1277);
    paramString = new zzex(paramString, zzew.zzig().zze(paramString, paramLong1));
    AppMethodBeat.o(1277);
    return paramString;
  }
  
  static zzex<Boolean> zzb(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(1275);
    paramString = new zzex(paramString, zzew.zzig().zzf(paramString, paramBoolean1));
    AppMethodBeat.o(1275);
    return paramString;
  }
  
  static zzex<Integer> zzc(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(1278);
    paramString = new zzex(paramString, zzew.zzig().zzd(paramString, paramInt1));
    AppMethodBeat.o(1278);
    return paramString;
  }
  
  static zzex<String> zzd(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(1276);
    paramString1 = new zzex(paramString1, zzew.zzig().zzv(paramString1, paramString2));
    AppMethodBeat.o(1276);
    return paramString1;
  }
  
  public final V get()
  {
    AppMethodBeat.i(1280);
    Object localObject = this.zzaid.get();
    AppMethodBeat.o(1280);
    return localObject;
  }
  
  public final V get(V paramV)
  {
    AppMethodBeat.i(1281);
    if (paramV != null)
    {
      AppMethodBeat.o(1281);
      return paramV;
    }
    paramV = this.zzaid.get();
    AppMethodBeat.o(1281);
    return paramV;
  }
  
  public final String getKey()
  {
    return this.zzny;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzex
 * JD-Core Version:    0.7.0.1
 */