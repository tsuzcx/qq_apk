package com.facebook.appevents;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppEventsLogger$1
  implements Runnable
{
  AppEventsLogger$1(AppEventsLogger paramAppEventsLogger, long paramLong, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(71906);
    AppEventsLogger.access$000(this.val$logger, this.val$eventTime, this.val$sourceApplicationInfo);
    AppMethodBeat.o(71906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.appevents.AppEventsLogger.1
 * JD-Core Version:    0.7.0.1
 */