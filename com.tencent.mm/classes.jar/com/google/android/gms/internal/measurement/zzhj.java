package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

@VisibleForTesting
public final class zzhj
  extends zzjw
{
  final Context zzqx;
  
  @VisibleForTesting
  public zzhj(Context paramContext)
  {
    AppMethodBeat.i(69148);
    Preconditions.checkNotNull(paramContext);
    paramContext = paramContext.getApplicationContext();
    Preconditions.checkNotNull(paramContext);
    this.zzqx = paramContext;
    AppMethodBeat.o(69148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzhj
 * JD-Core Version:    0.7.0.1
 */