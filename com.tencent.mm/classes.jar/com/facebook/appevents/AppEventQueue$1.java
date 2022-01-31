package com.facebook.appevents;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppEventQueue$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(71884);
    AppEventQueue.access$002(null);
    if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
      AppEventQueue.flushAndWait(FlushReason.TIMER);
    }
    AppMethodBeat.o(71884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.appevents.AppEventQueue.1
 * JD-Core Version:    0.7.0.1
 */