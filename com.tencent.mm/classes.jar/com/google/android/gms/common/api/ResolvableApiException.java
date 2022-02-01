package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ResolvableApiException
  extends ApiException
{
  public ResolvableApiException(Status paramStatus)
  {
    super(paramStatus);
  }
  
  public PendingIntent getResolution()
  {
    AppMethodBeat.i(4468);
    PendingIntent localPendingIntent = this.mStatus.getResolution();
    AppMethodBeat.o(4468);
    return localPendingIntent;
  }
  
  public void startResolutionForResult(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(4467);
    this.mStatus.startResolutionForResult(paramActivity, paramInt);
    AppMethodBeat.o(4467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.ResolvableApiException
 * JD-Core Version:    0.7.0.1
 */