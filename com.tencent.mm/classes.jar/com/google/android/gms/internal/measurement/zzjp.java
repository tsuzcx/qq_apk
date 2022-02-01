package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

class zzjp
  extends zzhg
  implements zzec
{
  protected final zzjr zzajp;
  
  zzjp(zzjr paramzzjr)
  {
    super(paramzzjr.zzla());
    AppMethodBeat.i(1951);
    Preconditions.checkNotNull(paramzzjr);
    this.zzajp = paramzzjr;
    AppMethodBeat.o(1951);
  }
  
  public zzeb zziw()
  {
    AppMethodBeat.i(1953);
    zzeb localzzeb = this.zzajp.zziw();
    AppMethodBeat.o(1953);
    return localzzeb;
  }
  
  public zzei zzix()
  {
    AppMethodBeat.i(1952);
    zzei localzzei = this.zzajp.zzix();
    AppMethodBeat.o(1952);
    return localzzei;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzjp
 * JD-Core Version:    0.7.0.1
 */