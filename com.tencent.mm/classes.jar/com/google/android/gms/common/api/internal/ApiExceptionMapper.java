package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public class ApiExceptionMapper
  implements StatusExceptionMapper
{
  public Exception getException(Status paramStatus)
  {
    AppMethodBeat.i(60563);
    paramStatus = ApiExceptionUtil.fromStatus(paramStatus);
    AppMethodBeat.o(60563);
    return paramStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.ApiExceptionMapper
 * JD-Core Version:    0.7.0.1
 */