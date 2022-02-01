package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class Batch
  extends BasePendingResult<BatchResult>
{
  private final Object mLock;
  private int zzcd;
  private boolean zzce;
  private boolean zzcf;
  private final PendingResult<?>[] zzcg;
  
  private Batch(List<PendingResult<?>> paramList, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
    AppMethodBeat.i(10978);
    this.mLock = new Object();
    this.zzcd = paramList.size();
    this.zzcg = new PendingResult[this.zzcd];
    if (paramList.isEmpty())
    {
      setResult(new BatchResult(Status.RESULT_SUCCESS, this.zzcg));
      AppMethodBeat.o(10978);
      return;
    }
    int i = 0;
    while (i < paramList.size())
    {
      paramGoogleApiClient = (PendingResult)paramList.get(i);
      this.zzcg[i] = paramGoogleApiClient;
      paramGoogleApiClient.addStatusListener(new zza(this));
      i += 1;
    }
    AppMethodBeat.o(10978);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(10979);
    super.cancel();
    PendingResult[] arrayOfPendingResult = this.zzcg;
    int j = arrayOfPendingResult.length;
    int i = 0;
    while (i < j)
    {
      arrayOfPendingResult[i].cancel();
      i += 1;
    }
    AppMethodBeat.o(10979);
  }
  
  public final BatchResult createFailedResult(Status paramStatus)
  {
    AppMethodBeat.i(10980);
    paramStatus = new BatchResult(paramStatus, this.zzcg);
    AppMethodBeat.o(10980);
    return paramStatus;
  }
  
  public static final class Builder
  {
    private List<PendingResult<?>> zzci;
    private GoogleApiClient zzcj;
    
    public Builder(GoogleApiClient paramGoogleApiClient)
    {
      AppMethodBeat.i(10975);
      this.zzci = new ArrayList();
      this.zzcj = paramGoogleApiClient;
      AppMethodBeat.o(10975);
    }
    
    public final <R extends Result> BatchResultToken<R> add(PendingResult<R> paramPendingResult)
    {
      AppMethodBeat.i(10976);
      BatchResultToken localBatchResultToken = new BatchResultToken(this.zzci.size());
      this.zzci.add(paramPendingResult);
      AppMethodBeat.o(10976);
      return localBatchResultToken;
    }
    
    public final Batch build()
    {
      AppMethodBeat.i(10977);
      Batch localBatch = new Batch(this.zzci, this.zzcj, null);
      AppMethodBeat.o(10977);
      return localBatch;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.api.Batch
 * JD-Core Version:    0.7.0.1
 */