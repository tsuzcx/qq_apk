package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class FetchedAppSettingsManager$3
  implements Runnable
{
  FetchedAppSettingsManager$3(FetchedAppSettingsManager.FetchedAppSettingsCallback paramFetchedAppSettingsCallback, FetchedAppSettings paramFetchedAppSettings) {}
  
  public final void run()
  {
    AppMethodBeat.i(72306);
    this.val$callback.onSuccess(this.val$appSettings);
    AppMethodBeat.o(72306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.internal.FetchedAppSettingsManager.3
 * JD-Core Version:    0.7.0.1
 */