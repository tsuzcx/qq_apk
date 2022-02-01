package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class StatusCallback
  extends IStatusCallback.Stub
{
  private final BaseImplementation.ResultHolder<Status> mResultHolder;
  
  public StatusCallback(BaseImplementation.ResultHolder<Status> paramResultHolder)
  {
    this.mResultHolder = paramResultHolder;
  }
  
  public void onResult(Status paramStatus)
  {
    AppMethodBeat.i(11154);
    this.mResultHolder.setResult(paramStatus);
    AppMethodBeat.o(11154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.StatusCallback
 * JD-Core Version:    0.7.0.1
 */