package com.google.android.gms.common.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class Batch$Builder
{
  private List<PendingResult<?>> zzci;
  private GoogleApiClient zzcj;
  
  public Batch$Builder(GoogleApiClient paramGoogleApiClient)
  {
    AppMethodBeat.i(60483);
    this.zzci = new ArrayList();
    this.zzcj = paramGoogleApiClient;
    AppMethodBeat.o(60483);
  }
  
  public final <R extends Result> BatchResultToken<R> add(PendingResult<R> paramPendingResult)
  {
    AppMethodBeat.i(60484);
    BatchResultToken localBatchResultToken = new BatchResultToken(this.zzci.size());
    this.zzci.add(paramPendingResult);
    AppMethodBeat.o(60484);
    return localBatchResultToken;
  }
  
  public final Batch build()
  {
    AppMethodBeat.i(60485);
    Batch localBatch = new Batch(this.zzci, this.zzcj, null);
    AppMethodBeat.o(60485);
    return localBatch;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.Batch.Builder
 * JD-Core Version:    0.7.0.1
 */