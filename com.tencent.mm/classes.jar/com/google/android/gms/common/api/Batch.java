package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(60486);
    this.mLock = new Object();
    this.zzcd = paramList.size();
    this.zzcg = new PendingResult[this.zzcd];
    if (paramList.isEmpty())
    {
      setResult(new BatchResult(Status.RESULT_SUCCESS, this.zzcg));
      AppMethodBeat.o(60486);
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
    AppMethodBeat.o(60486);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(60487);
    super.cancel();
    PendingResult[] arrayOfPendingResult = this.zzcg;
    int j = arrayOfPendingResult.length;
    int i = 0;
    while (i < j)
    {
      arrayOfPendingResult[i].cancel();
      i += 1;
    }
    AppMethodBeat.o(60487);
  }
  
  public final BatchResult createFailedResult(Status paramStatus)
  {
    AppMethodBeat.i(60488);
    paramStatus = new BatchResult(paramStatus, this.zzcg);
    AppMethodBeat.o(60488);
    return paramStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.api.Batch
 * JD-Core Version:    0.7.0.1
 */