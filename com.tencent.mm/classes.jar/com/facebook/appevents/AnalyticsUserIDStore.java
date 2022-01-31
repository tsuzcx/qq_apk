package com.facebook.appevents;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AppEventUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

class AnalyticsUserIDStore
{
  private static final String ANALYTICS_USER_ID_KEY = "com.facebook.appevents.AnalyticsUserIDStore.userID";
  private static final String TAG;
  private static volatile boolean initialized;
  private static ReentrantReadWriteLock lock;
  private static String userID;
  
  static
  {
    AppMethodBeat.i(71864);
    TAG = AnalyticsUserIDStore.class.getSimpleName();
    lock = new ReentrantReadWriteLock();
    initialized = false;
    AppMethodBeat.o(71864);
  }
  
  public static String getUserID()
  {
    AppMethodBeat.i(71861);
    if (!initialized) {
      initAndWait();
    }
    lock.readLock().lock();
    try
    {
      String str = userID;
      return str;
    }
    finally
    {
      lock.readLock().unlock();
      AppMethodBeat.o(71861);
    }
  }
  
  private static void initAndWait()
  {
    AppMethodBeat.i(71862);
    if (initialized)
    {
      AppMethodBeat.o(71862);
      return;
    }
    lock.writeLock().lock();
    try
    {
      boolean bool = initialized;
      if (bool) {
        return;
      }
      userID = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).getString("com.facebook.appevents.AnalyticsUserIDStore.userID", null);
      initialized = true;
      return;
    }
    finally
    {
      lock.writeLock().unlock();
      AppMethodBeat.o(71862);
    }
  }
  
  public static void initStore()
  {
    AppMethodBeat.i(71859);
    if (initialized)
    {
      AppMethodBeat.o(71859);
      return;
    }
    AppEventsLogger.getAnalyticsExecutor().execute(new AnalyticsUserIDStore.1());
    AppMethodBeat.o(71859);
  }
  
  public static void setUserID(String paramString)
  {
    AppMethodBeat.i(71860);
    AppEventUtility.assertIsNotMainThread();
    if (!initialized) {
      initAndWait();
    }
    AppEventsLogger.getAnalyticsExecutor().execute(new AnalyticsUserIDStore.2(paramString));
    AppMethodBeat.o(71860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.appevents.AnalyticsUserIDStore
 * JD-Core Version:    0.7.0.1
 */