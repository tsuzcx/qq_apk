package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ApiExceptionUtil
{
  public static ApiException fromConnectionResult(ConnectionResult paramConnectionResult)
  {
    AppMethodBeat.i(11791);
    paramConnectionResult = fromStatus(new Status(paramConnectionResult.getErrorCode(), paramConnectionResult.getErrorMessage(), paramConnectionResult.getResolution()));
    AppMethodBeat.o(11791);
    return paramConnectionResult;
  }
  
  public static ApiException fromStatus(Status paramStatus)
  {
    AppMethodBeat.i(11790);
    if (paramStatus.hasResolution())
    {
      paramStatus = new ResolvableApiException(paramStatus);
      AppMethodBeat.o(11790);
      return paramStatus;
    }
    paramStatus = new ApiException(paramStatus);
    AppMethodBeat.o(11790);
    return paramStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.ApiExceptionUtil
 * JD-Core Version:    0.7.0.1
 */