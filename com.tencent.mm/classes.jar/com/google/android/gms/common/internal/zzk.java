package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzk
  implements PendingResultUtil.StatusConverter
{
  public final ApiException convert(Status paramStatus)
  {
    AppMethodBeat.i(11899);
    paramStatus = ApiExceptionUtil.fromStatus(paramStatus);
    AppMethodBeat.o(11899);
    return paramStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzk
 * JD-Core Version:    0.7.0.1
 */