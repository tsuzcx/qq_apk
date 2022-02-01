package com.google.android.gms.common.stats;

import android.content.ComponentName;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class LoggingConstants
{
  public static final String ALARM_LOG_FILE_NAME = ".alarms";
  public static final String CONNECTION_LOG_FILE_NAME = ".service_connections";
  public static final String EXTRA_LOG_EVENT = "com.google.android.gms.common.stats.EXTRA_LOG_EVENT";
  public static final String EXTRA_WAKE_LOCK_KEY = "WAKE_LOCK_KEY";
  public static int IGNORE_INTRA_PROCESS = 0;
  public static int LOG_CLOSE_EVENTS = 0;
  public static final String LOG_FILE_PREFIX = "stats";
  public static int LOG_LEVEL_OFF = 0;
  public static int LOG_MEM_INFO = 0;
  public static int LOG_OPEN_EVENTS = 0;
  public static int LOG_TOO_LONG_EVENTS = 0;
  public static int LOG_VERBOSE = 0;
  public static int LOG_WAKEFUL_ALARMS = 0;
  public static final ComponentName STATS_SERVICE_COMPONENT_NAME;
  public static final String WAKE_LOCK_LOG_FILE_NAME = ".wakelocks";
  
  static
  {
    AppMethodBeat.i(4982);
    STATS_SERVICE_COMPONENT_NAME = new ComponentName("com.google.android.gms", "com.google.android.gms.common.stats.GmsCoreStatsService");
    LOG_LEVEL_OFF = 0;
    LOG_TOO_LONG_EVENTS = 1;
    LOG_OPEN_EVENTS = 2;
    LOG_CLOSE_EVENTS = 4;
    LOG_VERBOSE = 8;
    IGNORE_INTRA_PROCESS = 16;
    LOG_MEM_INFO = 32;
    LOG_WAKEFUL_ALARMS = 1;
    AppMethodBeat.o(4982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.stats.LoggingConstants
 * JD-Core Version:    0.7.0.1
 */