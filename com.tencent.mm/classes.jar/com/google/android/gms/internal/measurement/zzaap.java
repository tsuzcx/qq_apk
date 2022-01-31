package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaap<T>
  implements zzaav<T>
{
  private final zzaal zzbtk;
  private final zzabj<?, ?> zzbtl;
  private final boolean zzbtm;
  private final zzzj<?> zzbtn;
  
  private zzaap(zzabj<?, ?> paramzzabj, zzzj<?> paramzzzj, zzaal paramzzaal)
  {
    AppMethodBeat.i(3348);
    this.zzbtl = paramzzabj;
    this.zzbtm = paramzzzj.zza(paramzzaal);
    this.zzbtn = paramzzzj;
    this.zzbtk = paramzzaal;
    AppMethodBeat.o(3348);
  }
  
  static <T> zzaap<T> zza(zzabj<?, ?> paramzzabj, zzzj<?> paramzzzj, zzaal paramzzaal)
  {
    AppMethodBeat.i(3349);
    paramzzabj = new zzaap(paramzzabj, paramzzzj, paramzzaal);
    AppMethodBeat.o(3349);
    return paramzzabj;
  }
  
  public final boolean equals(T paramT1, T paramT2)
  {
    AppMethodBeat.i(3350);
    if (!this.zzbtl.zzu(paramT1).equals(this.zzbtl.zzu(paramT2)))
    {
      AppMethodBeat.o(3350);
      return false;
    }
    if (this.zzbtm)
    {
      boolean bool = this.zzbtn.zzs(paramT1).equals(this.zzbtn.zzs(paramT2));
      AppMethodBeat.o(3350);
      return bool;
    }
    AppMethodBeat.o(3350);
    return true;
  }
  
  public final int hashCode(T paramT)
  {
    AppMethodBeat.i(3351);
    int j = this.zzbtl.zzu(paramT).hashCode();
    int i = j;
    if (this.zzbtm) {
      i = j * 53 + this.zzbtn.zzs(paramT).hashCode();
    }
    AppMethodBeat.o(3351);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzaap
 * JD-Core Version:    0.7.0.1
 */