package com.facebook.appevents;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
    AppMethodBeat.i(17300);
    TAG = AnalyticsUserIDStore.class.getSimpleName();
    lock = new ReentrantReadWriteLock();
    initialized = false;
    AppMethodBeat.o(17300);
  }
  
  public static String getUserID()
  {
    AppMethodBeat.i(17297);
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
      AppMethodBeat.o(17297);
    }
  }
  
  private static void initAndWait()
  {
    AppMethodBeat.i(17298);
    if (initialized)
    {
      AppMethodBeat.o(17298);
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
      AppMethodBeat.o(17298);
    }
  }
  
  public static void initStore()
  {
    AppMethodBeat.i(17295);
    if (initialized)
    {
      AppMethodBeat.o(17295);
      return;
    }
    AppEventsLogger.getAnalyticsExecutor().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(17293);
        AnalyticsUserIDStore.access$000();
        AppMethodBeat.o(17293);
      }
    });
    AppMethodBeat.o(17295);
  }
  
  public static void setUserID(String paramString)
  {
    AppMethodBeat.i(17296);
    AppEventUtility.assertIsNotMainThread();
    if (!initialized) {
      initAndWait();
    }
    AppEventsLogger.getAnalyticsExecutor().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(17294);
        AnalyticsUserIDStore.lock.writeLock().lock();
        try
        {
          AnalyticsUserIDStore.access$202(this.val$id);
          SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
          localEditor.putString("com.facebook.appevents.AnalyticsUserIDStore.userID", AnalyticsUserIDStore.userID);
          localEditor.apply();
          return;
        }
        finally
        {
          AnalyticsUserIDStore.lock.writeLock().unlock();
          AppMethodBeat.o(17294);
        }
      }
    });
    AppMethodBeat.o(17296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.appevents.AnalyticsUserIDStore
 * JD-Core Version:    0.7.0.1
 */