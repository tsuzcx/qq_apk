package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DataHolderResult
  implements Releasable, Result
{
  protected final DataHolder mDataHolder;
  protected final Status mStatus;
  
  protected DataHolderResult(DataHolder paramDataHolder)
  {
    this(paramDataHolder, new Status(paramDataHolder.getStatusCode()));
    AppMethodBeat.i(11060);
    AppMethodBeat.o(11060);
  }
  
  protected DataHolderResult(DataHolder paramDataHolder, Status paramStatus)
  {
    this.mStatus = paramStatus;
    this.mDataHolder = paramDataHolder;
  }
  
  public Status getStatus()
  {
    return this.mStatus;
  }
  
  public void release()
  {
    AppMethodBeat.i(11061);
    if (this.mDataHolder != null) {
      this.mDataHolder.close();
    }
    AppMethodBeat.o(11061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.DataHolderResult
 * JD-Core Version:    0.7.0.1
 */