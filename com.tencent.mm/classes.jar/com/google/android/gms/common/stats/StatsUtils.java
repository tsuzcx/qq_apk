package com.google.android.gms.common.stats;

import android.content.AbstractThreadedSyncAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class StatsUtils
{
  public static String getEventKey(AbstractThreadedSyncAdapter paramAbstractThreadedSyncAdapter, String paramString)
  {
    AppMethodBeat.i(4994);
    String str = String.valueOf(String.valueOf(Process.myPid() << 32 | System.identityHashCode(paramAbstractThreadedSyncAdapter)));
    paramAbstractThreadedSyncAdapter = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramAbstractThreadedSyncAdapter = "";
    }
    paramAbstractThreadedSyncAdapter = String.valueOf(paramAbstractThreadedSyncAdapter);
    if (paramAbstractThreadedSyncAdapter.length() != 0)
    {
      paramAbstractThreadedSyncAdapter = str.concat(paramAbstractThreadedSyncAdapter);
      AppMethodBeat.o(4994);
      return paramAbstractThreadedSyncAdapter;
    }
    paramAbstractThreadedSyncAdapter = new String(str);
    AppMethodBeat.o(4994);
    return paramAbstractThreadedSyncAdapter;
  }
  
  public static String getEventKey(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(4992);
    long l1 = System.identityHashCode(paramContext);
    long l2 = System.identityHashCode(paramIntent);
    AppMethodBeat.o(4992);
    return String.valueOf(l1 << 32 | l2);
  }
  
  public static String getEventKey(PowerManager.WakeLock paramWakeLock, String paramString)
  {
    AppMethodBeat.i(4993);
    String str = String.valueOf(String.valueOf(Process.myPid() << 32 | System.identityHashCode(paramWakeLock)));
    paramWakeLock = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramWakeLock = "";
    }
    paramWakeLock = String.valueOf(paramWakeLock);
    if (paramWakeLock.length() != 0)
    {
      paramWakeLock = str.concat(paramWakeLock);
      AppMethodBeat.o(4993);
      return paramWakeLock;
    }
    paramWakeLock = new String(str);
    AppMethodBeat.o(4993);
    return paramWakeLock;
  }
  
  public static boolean isLoggingEnabled()
  {
    AppMethodBeat.i(4991);
    StatisticalEventTrackerProvider.StatisticalEventTracker localStatisticalEventTracker = StatisticalEventTrackerProvider.getImpl();
    if ((localStatisticalEventTracker != null) && (localStatisticalEventTracker.isEnabled()) && ((zza(Integer.valueOf(localStatisticalEventTracker.getLogLevel(3)))) || (zza(Integer.valueOf(localStatisticalEventTracker.getLogLevel(2)))) || (zza(Integer.valueOf(localStatisticalEventTracker.getLogLevel(1))))))
    {
      AppMethodBeat.o(4991);
      return true;
    }
    AppMethodBeat.o(4991);
    return false;
  }
  
  public static boolean isTimeOutEvent(StatsEvent paramStatsEvent)
  {
    AppMethodBeat.i(4995);
    switch (paramStatsEvent.getEventType())
    {
    default: 
      AppMethodBeat.o(4995);
      return false;
    }
    AppMethodBeat.o(4995);
    return true;
  }
  
  private static boolean zza(Integer paramInteger)
  {
    AppMethodBeat.i(4990);
    if (!paramInteger.equals(Integer.valueOf(LoggingConstants.LOG_LEVEL_OFF)))
    {
      AppMethodBeat.o(4990);
      return true;
    }
    AppMethodBeat.o(4990);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.stats.StatsUtils
 * JD-Core Version:    0.7.0.1
 */