package com.facebook.appevents;

import android.os.Bundle;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.Locale;

class FacebookTimeSpentData
  implements Serializable
{
  private static final long APP_ACTIVATE_SUPPRESSION_PERIOD_IN_MILLISECONDS = 300000L;
  private static final long FIRST_TIME_LOAD_RESUME_TIME = -1L;
  private static final long[] INACTIVE_SECONDS_QUANTA;
  private static final long INTERRUPTION_THRESHOLD_MILLISECONDS = 1000L;
  private static final long NUM_MILLISECONDS_IDLE_TO_BE_NEW_SESSION = 60000L;
  private static final String TAG;
  private static final long serialVersionUID = 1L;
  private String firstOpenSourceApplication;
  private int interruptionCount;
  private boolean isAppActive;
  private boolean isWarmLaunch;
  private long lastActivateEventLoggedTime;
  private long lastResumeTime;
  private long lastSuspendTime;
  private long millisecondsSpentInSession;
  
  static
  {
    AppMethodBeat.i(71997);
    TAG = FacebookTimeSpentData.class.getCanonicalName();
    INACTIVE_SECONDS_QUANTA = new long[] { 300000L, 900000L, 1800000L, 3600000L, 21600000L, 43200000L, 86400000L, 172800000L, 259200000L, 604800000L, 1209600000L, 1814400000L, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L };
    AppMethodBeat.o(71997);
  }
  
  FacebookTimeSpentData()
  {
    AppMethodBeat.i(71991);
    resetSession();
    AppMethodBeat.o(71991);
  }
  
  private FacebookTimeSpentData(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    AppMethodBeat.i(71990);
    resetSession();
    this.lastResumeTime = paramLong1;
    this.lastSuspendTime = paramLong2;
    this.millisecondsSpentInSession = paramLong3;
    this.interruptionCount = paramInt;
    AppMethodBeat.o(71990);
  }
  
  private FacebookTimeSpentData(long paramLong1, long paramLong2, long paramLong3, int paramInt, String paramString)
  {
    AppMethodBeat.i(71992);
    resetSession();
    this.lastResumeTime = paramLong1;
    this.lastSuspendTime = paramLong2;
    this.millisecondsSpentInSession = paramLong3;
    this.interruptionCount = paramInt;
    this.firstOpenSourceApplication = paramString;
    AppMethodBeat.o(71992);
  }
  
  private static int getQuantaIndex(long paramLong)
  {
    int i = 0;
    while ((i < INACTIVE_SECONDS_QUANTA.length) && (INACTIVE_SECONDS_QUANTA[i] < paramLong)) {
      i += 1;
    }
    return i;
  }
  
  private boolean isColdLaunch()
  {
    if (!this.isWarmLaunch) {}
    for (boolean bool = true;; bool = false)
    {
      this.isWarmLaunch = true;
      return bool;
    }
  }
  
  private void logAppDeactivatedEvent(AppEventsLogger paramAppEventsLogger, long paramLong)
  {
    AppMethodBeat.i(71996);
    Bundle localBundle = new Bundle();
    localBundle.putInt("fb_mobile_app_interruptions", this.interruptionCount);
    localBundle.putString("fb_mobile_time_between_sessions", String.format(Locale.ROOT, "session_quanta_%d", new Object[] { Integer.valueOf(getQuantaIndex(paramLong)) }));
    localBundle.putString("fb_mobile_launch_source", this.firstOpenSourceApplication);
    paramAppEventsLogger.logEvent("fb_mobile_deactivate_app", this.millisecondsSpentInSession / 1000L, localBundle);
    resetSession();
    AppMethodBeat.o(71996);
  }
  
  private void resetSession()
  {
    this.isAppActive = false;
    this.lastResumeTime = -1L;
    this.lastSuspendTime = -1L;
    this.interruptionCount = 0;
    this.millisecondsSpentInSession = 0L;
  }
  
  private boolean wasSuspendedEver()
  {
    return this.lastSuspendTime != -1L;
  }
  
  private Object writeReplace()
  {
    AppMethodBeat.i(71993);
    FacebookTimeSpentData.SerializationProxyV2 localSerializationProxyV2 = new FacebookTimeSpentData.SerializationProxyV2(this.lastResumeTime, this.lastSuspendTime, this.millisecondsSpentInSession, this.interruptionCount, this.firstOpenSourceApplication);
    AppMethodBeat.o(71993);
    return localSerializationProxyV2;
  }
  
  void onResume(AppEventsLogger paramAppEventsLogger, long paramLong, String paramString)
  {
    long l2 = 0L;
    AppMethodBeat.i(71995);
    if ((isColdLaunch()) || (paramLong - this.lastActivateEventLoggedTime > 300000L))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("fb_mobile_launch_source", paramString);
      paramAppEventsLogger.logEvent("fb_mobile_activate_app", localBundle);
      this.lastActivateEventLoggedTime = paramLong;
      if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
        paramAppEventsLogger.flush();
      }
    }
    if (this.isAppActive)
    {
      Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Resume for active app");
      AppMethodBeat.o(71995);
      return;
    }
    long l1;
    if (wasSuspendedEver())
    {
      l1 = paramLong - this.lastSuspendTime;
      if (l1 >= 0L) {
        break label206;
      }
      Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
      l1 = l2;
    }
    label206:
    for (;;)
    {
      if (l1 > 60000L) {
        logAppDeactivatedEvent(paramAppEventsLogger, l1);
      }
      for (;;)
      {
        if (this.interruptionCount == 0) {
          this.firstOpenSourceApplication = paramString;
        }
        this.lastResumeTime = paramLong;
        this.isAppActive = true;
        AppMethodBeat.o(71995);
        return;
        l1 = 0L;
        break;
        if (l1 > 1000L) {
          this.interruptionCount += 1;
        }
      }
    }
  }
  
  void onSuspend(AppEventsLogger paramAppEventsLogger, long paramLong)
  {
    long l1 = 0L;
    AppMethodBeat.i(71994);
    if (!this.isAppActive)
    {
      Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Suspend for inactive app");
      AppMethodBeat.o(71994);
      return;
    }
    long l2 = paramLong - this.lastResumeTime;
    if (l2 < 0L) {
      Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
    }
    for (;;)
    {
      this.millisecondsSpentInSession = (l1 + this.millisecondsSpentInSession);
      this.lastSuspendTime = paramLong;
      this.isAppActive = false;
      AppMethodBeat.o(71994);
      return;
      l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.appevents.FacebookTimeSpentData
 * JD-Core Version:    0.7.0.1
 */