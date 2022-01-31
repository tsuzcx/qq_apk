package com.facebook.appevents.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ActivityLifecycleTracker$3
  implements Runnable
{
  ActivityLifecycleTracker$3(long paramLong, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(72141);
    if (ActivityLifecycleTracker.access$200() == null)
    {
      ActivityLifecycleTracker.access$202(new SessionInfo(Long.valueOf(this.val$currentTime), null));
      SessionLogger.logActivateApp(this.val$activityName, null, ActivityLifecycleTracker.access$300());
    }
    for (;;)
    {
      ActivityLifecycleTracker.access$200().setSessionLastEventTime(Long.valueOf(this.val$currentTime));
      ActivityLifecycleTracker.access$200().writeSessionToDisk();
      AppMethodBeat.o(72141);
      return;
      if (ActivityLifecycleTracker.access$200().getSessionLastEventTime() != null)
      {
        long l = this.val$currentTime - ActivityLifecycleTracker.access$200().getSessionLastEventTime().longValue();
        if (l > ActivityLifecycleTracker.access$400() * 1000)
        {
          SessionLogger.logDeactivateApp(this.val$activityName, ActivityLifecycleTracker.access$200(), ActivityLifecycleTracker.access$300());
          SessionLogger.logActivateApp(this.val$activityName, null, ActivityLifecycleTracker.access$300());
          ActivityLifecycleTracker.access$202(new SessionInfo(Long.valueOf(this.val$currentTime), null));
        }
        else if (l > 1000L)
        {
          ActivityLifecycleTracker.access$200().incrementInterruptionCount();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.appevents.internal.ActivityLifecycleTracker.3
 * JD-Core Version:    0.7.0.1
 */