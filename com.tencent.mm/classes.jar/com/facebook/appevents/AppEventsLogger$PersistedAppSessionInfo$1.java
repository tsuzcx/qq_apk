package com.facebook.appevents;

import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppEventsLogger$PersistedAppSessionInfo$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(71914);
    AppEventsLogger.PersistedAppSessionInfo.saveAppSessionInformation(FacebookSdk.getApplicationContext());
    AppMethodBeat.o(71914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.appevents.AppEventsLogger.PersistedAppSessionInfo.1
 * JD-Core Version:    0.7.0.1
 */