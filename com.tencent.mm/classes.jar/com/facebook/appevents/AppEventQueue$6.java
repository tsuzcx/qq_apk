package com.facebook.appevents;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppEventQueue$6
  implements Runnable
{
  AppEventQueue$6(AccessTokenAppIdPair paramAccessTokenAppIdPair, SessionEventsState paramSessionEventsState) {}
  
  public final void run()
  {
    AppMethodBeat.i(71889);
    AppEventStore.persistEvents(this.val$accessTokenAppId, this.val$appEvents);
    AppMethodBeat.o(71889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.appevents.AppEventQueue.6
 * JD-Core Version:    0.7.0.1
 */