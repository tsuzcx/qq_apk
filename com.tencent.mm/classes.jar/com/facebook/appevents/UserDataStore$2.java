package com.facebook.appevents;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

final class UserDataStore$2
  implements Runnable
{
  UserDataStore$2(Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(72027);
    UserDataStore.access$100().writeLock().lock();
    try
    {
      UserDataStore.access$202(UserDataStore.access$300(this.val$ud));
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
      localEditor.putString("com.facebook.appevents.UserDataStore.userData", UserDataStore.access$200());
      localEditor.apply();
      return;
    }
    finally
    {
      UserDataStore.access$100().writeLock().unlock();
      AppMethodBeat.o(72027);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.appevents.UserDataStore.2
 * JD-Core Version:    0.7.0.1
 */