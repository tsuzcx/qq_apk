package com.facebook;

import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FacebookSdk$2
  implements FetchedAppSettingsManager.FetchedAppSettingsCallback
{
  public final void onError() {}
  
  public final void onSuccess(FetchedAppSettings paramFetchedAppSettings)
  {
    AppMethodBeat.i(71599);
    FetchedAppGateKeepersManager.loadAppGateKeepersAsync();
    AppMethodBeat.o(71599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.FacebookSdk.2
 * JD-Core Version:    0.7.0.1
 */