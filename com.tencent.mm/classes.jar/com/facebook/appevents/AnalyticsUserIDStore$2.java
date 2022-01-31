package com.facebook.appevents;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

final class AnalyticsUserIDStore$2
  implements Runnable
{
  AnalyticsUserIDStore$2(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(71858);
    AnalyticsUserIDStore.access$100().writeLock().lock();
    try
    {
      AnalyticsUserIDStore.access$202(this.val$id);
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
      localEditor.putString("com.facebook.appevents.AnalyticsUserIDStore.userID", AnalyticsUserIDStore.access$200());
      localEditor.apply();
      return;
    }
    finally
    {
      AnalyticsUserIDStore.access$100().writeLock().unlock();
      AppMethodBeat.o(71858);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.appevents.AnalyticsUserIDStore.2
 * JD-Core Version:    0.7.0.1
 */