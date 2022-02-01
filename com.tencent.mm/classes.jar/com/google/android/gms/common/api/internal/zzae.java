package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzae
{
  private final zzh<?> zzhc;
  private final TaskCompletionSource<Boolean> zzhd;
  
  public zzae(zzh<?> paramzzh)
  {
    AppMethodBeat.i(11185);
    this.zzhd = new TaskCompletionSource();
    this.zzhc = paramzzh;
    AppMethodBeat.o(11185);
  }
  
  public final TaskCompletionSource<Boolean> zzao()
  {
    return this.zzhd;
  }
  
  public final zzh<?> zzm()
  {
    return this.zzhc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzae
 * JD-Core Version:    0.7.0.1
 */