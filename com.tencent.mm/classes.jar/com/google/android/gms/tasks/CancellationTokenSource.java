package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CancellationTokenSource
{
  private final zza zzafj;
  
  public CancellationTokenSource()
  {
    AppMethodBeat.i(57339);
    this.zzafj = new zza();
    AppMethodBeat.o(57339);
  }
  
  public void cancel()
  {
    AppMethodBeat.i(57340);
    this.zzafj.cancel();
    AppMethodBeat.o(57340);
  }
  
  public CancellationToken getToken()
  {
    return this.zzafj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tasks.CancellationTokenSource
 * JD-Core Version:    0.7.0.1
 */