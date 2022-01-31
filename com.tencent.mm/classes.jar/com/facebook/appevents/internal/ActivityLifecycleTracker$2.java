package com.facebook.appevents.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ActivityLifecycleTracker$2
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(72140);
    if (ActivityLifecycleTracker.access$200() == null) {
      ActivityLifecycleTracker.access$202(SessionInfo.getStoredSessionInfo());
    }
    AppMethodBeat.o(72140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.appevents.internal.ActivityLifecycleTracker.2
 * JD-Core Version:    0.7.0.1
 */