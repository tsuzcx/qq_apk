package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ActivityLifecycleTracker$1
  implements Application.ActivityLifecycleCallbacks
{
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72133);
    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.access$000(), "onActivityCreated");
    AppEventUtility.assertIsMainThread();
    ActivityLifecycleTracker.onActivityCreated(paramActivity);
    AppMethodBeat.o(72133);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(72139);
    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.access$000(), "onActivityDestroyed");
    AppMethodBeat.o(72139);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(72136);
    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.access$000(), "onActivityPaused");
    AppEventUtility.assertIsMainThread();
    ActivityLifecycleTracker.access$100(paramActivity);
    AppMethodBeat.o(72136);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(72135);
    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.access$000(), "onActivityResumed");
    AppEventUtility.assertIsMainThread();
    ActivityLifecycleTracker.onActivityResumed(paramActivity);
    AppMethodBeat.o(72135);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72138);
    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.access$000(), "onActivitySaveInstanceState");
    AppMethodBeat.o(72138);
  }
  
  public final void onActivityStarted(Activity paramActivity)
  {
    AppMethodBeat.i(72134);
    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.access$000(), "onActivityStarted");
    AppMethodBeat.o(72134);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(72137);
    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.access$000(), "onActivityStopped");
    AppEventsLogger.onContextStop();
    AppMethodBeat.o(72137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.appevents.internal.ActivityLifecycleTracker.1
 * JD-Core Version:    0.7.0.1
 */