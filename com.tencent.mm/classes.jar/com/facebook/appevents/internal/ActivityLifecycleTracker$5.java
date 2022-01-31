package com.facebook.appevents.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

final class ActivityLifecycleTracker$5
  implements Runnable
{
  ActivityLifecycleTracker$5(long paramLong, String paramString) {}
  
  public final void run()
  {
    long l1 = 0L;
    AppMethodBeat.i(72144);
    if (ActivityLifecycleTracker.access$200() == null) {
      ActivityLifecycleTracker.access$202(new SessionInfo(Long.valueOf(this.val$currentTime), null));
    }
    ActivityLifecycleTracker.access$200().setSessionLastEventTime(Long.valueOf(this.val$currentTime));
    ActivityLifecycleTracker.5.1 local1;
    if (ActivityLifecycleTracker.access$500().get() <= 0) {
      local1 = new ActivityLifecycleTracker.5.1(this);
    }
    synchronized (ActivityLifecycleTracker.access$600())
    {
      ActivityLifecycleTracker.access$702(ActivityLifecycleTracker.access$800().schedule(local1, ActivityLifecycleTracker.access$400(), TimeUnit.SECONDS));
      long l2 = ActivityLifecycleTracker.access$900();
      if (l2 > 0L) {
        l1 = (this.val$currentTime - l2) / 1000L;
      }
      AutomaticAnalyticsLogger.logActivityTimeSpentEvent(this.val$activityName, l1);
      ActivityLifecycleTracker.access$200().writeSessionToDisk();
      AppMethodBeat.o(72144);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.appevents.internal.ActivityLifecycleTracker.5
 * JD-Core Version:    0.7.0.1
 */