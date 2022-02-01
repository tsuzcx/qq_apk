package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CancellationTokenSource
{
  private final zza zzafj;
  
  public CancellationTokenSource()
  {
    AppMethodBeat.i(13338);
    this.zzafj = new zza();
    AppMethodBeat.o(13338);
  }
  
  public void cancel()
  {
    AppMethodBeat.i(13339);
    this.zzafj.cancel();
    AppMethodBeat.o(13339);
  }
  
  public CancellationToken getToken()
  {
    return this.zzafj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.tasks.CancellationTokenSource
 * JD-Core Version:    0.7.0.1
 */