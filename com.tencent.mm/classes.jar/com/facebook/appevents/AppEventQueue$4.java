package com.facebook.appevents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

final class AppEventQueue$4
  implements Runnable
{
  AppEventQueue$4(AccessTokenAppIdPair paramAccessTokenAppIdPair, AppEvent paramAppEvent) {}
  
  public final void run()
  {
    AppMethodBeat.i(71887);
    AppEventQueue.access$100().addEvent(this.val$accessTokenAppId, this.val$appEvent);
    if ((AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) && (AppEventQueue.access$100().getEventCount() > 100))
    {
      AppEventQueue.flushAndWait(FlushReason.EVENT_THRESHOLD);
      AppMethodBeat.o(71887);
      return;
    }
    if (AppEventQueue.access$000() == null) {
      AppEventQueue.access$002(AppEventQueue.access$300().schedule(AppEventQueue.access$200(), 15L, TimeUnit.SECONDS));
    }
    AppMethodBeat.o(71887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.appevents.AppEventQueue.4
 * JD-Core Version:    0.7.0.1
 */