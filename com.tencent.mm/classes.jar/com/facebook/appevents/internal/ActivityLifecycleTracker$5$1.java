package com.facebook.appevents.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;

class ActivityLifecycleTracker$5$1
  implements Runnable
{
  ActivityLifecycleTracker$5$1(ActivityLifecycleTracker.5 param5) {}
  
  public void run()
  {
    AppMethodBeat.i(72143);
    if (ActivityLifecycleTracker.access$500().get() <= 0)
    {
      SessionLogger.logDeactivateApp(this.this$0.val$activityName, ActivityLifecycleTracker.access$200(), ActivityLifecycleTracker.access$300());
      SessionInfo.clearSavedSessionFromDisk();
      ActivityLifecycleTracker.access$202(null);
    }
    synchronized (ActivityLifecycleTracker.access$600())
    {
      ActivityLifecycleTracker.access$702(null);
      AppMethodBeat.o(72143);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.appevents.internal.ActivityLifecycleTracker.5.1
 * JD-Core Version:    0.7.0.1
 */