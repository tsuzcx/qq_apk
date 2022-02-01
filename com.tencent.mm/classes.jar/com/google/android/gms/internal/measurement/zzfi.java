package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzfi
{
  private final int priority;
  private final boolean zzajd;
  private final boolean zzaje;
  
  zzfi(zzfg paramzzfg, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.priority = paramInt;
    this.zzajd = paramBoolean1;
    this.zzaje = paramBoolean2;
  }
  
  public final void log(String paramString)
  {
    AppMethodBeat.i(1423);
    this.zzajc.zza(this.priority, this.zzajd, this.zzaje, paramString, null, null, null);
    AppMethodBeat.o(1423);
  }
  
  public final void zzd(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(1426);
    this.zzajc.zza(this.priority, this.zzajd, this.zzaje, paramString, paramObject1, paramObject2, paramObject3);
    AppMethodBeat.o(1426);
  }
  
  public final void zze(String paramString, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(1425);
    this.zzajc.zza(this.priority, this.zzajd, this.zzaje, paramString, paramObject1, paramObject2, null);
    AppMethodBeat.o(1425);
  }
  
  public final void zzg(String paramString, Object paramObject)
  {
    AppMethodBeat.i(1424);
    this.zzajc.zza(this.priority, this.zzajd, this.zzaje, paramString, paramObject, null, null);
    AppMethodBeat.o(1424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfi
 * JD-Core Version:    0.7.0.1
 */