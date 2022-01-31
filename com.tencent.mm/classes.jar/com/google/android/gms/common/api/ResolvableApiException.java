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
    AppMethodBeat.i(89446);
    PendingIntent localPendingIntent = this.mStatus.getResolution();
    AppMethodBeat.o(89446);
    return localPendingIntent;
  }
  
  public void startResolutionForResult(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(89445);
    this.mStatus.startResolutionForResult(paramActivity, paramInt);
    AppMethodBeat.o(89445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.ResolvableApiException
 * JD-Core Version:    0.7.0.1
 */