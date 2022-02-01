package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzl
{
  private final int zzet;
  private final ConnectionResult zzeu;
  
  zzl(ConnectionResult paramConnectionResult, int paramInt)
  {
    AppMethodBeat.i(11431);
    Preconditions.checkNotNull(paramConnectionResult);
    this.zzeu = paramConnectionResult;
    this.zzet = paramInt;
    AppMethodBeat.o(11431);
  }
  
  final ConnectionResult getConnectionResult()
  {
    return this.zzeu;
  }
  
  final int zzu()
  {
    return this.zzet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzl
 * JD-Core Version:    0.7.0.1
 */