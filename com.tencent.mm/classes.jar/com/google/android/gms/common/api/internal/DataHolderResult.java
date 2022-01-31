package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public class DataHolderResult
  implements Releasable, Result
{
  @KeepForSdk
  protected final DataHolder mDataHolder;
  @KeepForSdk
  protected final Status mStatus;
  
  @KeepForSdk
  protected DataHolderResult(DataHolder paramDataHolder)
  {
    this(paramDataHolder, new Status(paramDataHolder.getStatusCode()));
    AppMethodBeat.i(60568);
    AppMethodBeat.o(60568);
  }
  
  @KeepForSdk
  protected DataHolderResult(DataHolder paramDataHolder, Status paramStatus)
  {
    this.mStatus = paramStatus;
    this.mDataHolder = paramDataHolder;
  }
  
  @KeepForSdk
  public Status getStatus()
  {
    return this.mStatus;
  }
  
  @KeepForSdk
  public void release()
  {
    AppMethodBeat.i(60569);
    if (this.mDataHolder != null) {
      this.mDataHolder.close();
    }
    AppMethodBeat.o(60569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.DataHolderResult
 * JD-Core Version:    0.7.0.1
 */