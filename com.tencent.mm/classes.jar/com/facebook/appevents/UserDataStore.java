package com.facebook.appevents;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AppEventUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import org.json.JSONException;
import org.json.JSONObject;

public class UserDataStore
{
  public static final String CITY = "ct";
  public static final String COUNTRY = "country";
  public static final String DATE_OF_BIRTH = "db";
  public static final String EMAIL = "em";
  public static final String FIRST_NAME = "fn";
  public static final String GENDER = "ge";
  public static final String LAST_NAME = "ln";
  public static final String PHONE = "ph";
  public static final String STATE = "st";
  private static final String TAG;
  private static final String USER_DATA_KEY = "com.facebook.appevents.UserDataStore.userData";
  public static final String ZIP = "zp";
  private static String hashedUserData;
  private static volatile boolean initialized;
  private static ReentrantReadWriteLock lock;
  
  static
  {
    AppMethodBeat.i(17475);
    TAG = UserDataStore.class.getSimpleName();
    lock = new ReentrantReadWriteLock();
    initialized = false;
    AppMethodBeat.o(17475);
  }
  
  private static String encryptData(String paramString)
  {
    AppMethodBeat.i(17470);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(17470);
      return null;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
      localMessageDigest.update(paramString.getBytes());
      paramString = AppEventUtility.bytesToHex(localMessageDigest.digest());
      AppMethodBeat.o(17470);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      AppMethodBeat.o(17470);
    }
    return null;
  }
  
  public static String getHashedUserData()
  {
    AppMethodBeat.i(17467);
    if (!initialized) {
      initAndWait();
    }
    lock.readLock().lock();
    try
    {
      String str = hashedUserData;
      return str;
    }
    finally
    {
      lock.readLock().unlock();
      AppMethodBeat.o(17467);
    }
  }
  
  private static String hashUserData(Bundle paramBundle)
  {
    AppMethodBeat.i(17469);
    if (paramBundle == null)
    {
      AppMethodBeat.o(17469);
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramBundle.keySet().iterator();
    for (;;)
    {
      String str1;
      if (localIterator.hasNext()) {
        str1 = (String)localIterator.next();
      }
      try
      {
        String str2 = paramBundle.get(str1).toString();
        if (maybeSHA256Hashed(str2))
        {
          localJSONObject.put(str1, str2.toLowerCase());
          continue;
        }
        str2 = encryptData(normalizeData(str1, paramBundle.get(str1).toString()));
        if (str2 == null) {
          continue;
        }
        localJSONObject.put(str1, str2);
      }
      catch (JSONException localJSONException) {}
      paramBundle = localJSONObject.toString();
      AppMethodBeat.o(17469);
      return paramBundle;
    }
  }
  
  private static void initAndWait()
  {
    AppMethodBeat.i(17468);
    if (initialized)
    {
      AppMethodBeat.o(17468);
      return;
    }
    lock.writeLock().lock();
    try
    {
      boolean bool = initialized;
      if (bool) {
        return;
      }
      hashedUserData = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).getString("com.facebook.appevents.UserDataStore.userData", null);
      initialized = true;
      return;
    }
    finally
    {
      lock.writeLock().unlock();
      AppMethodBeat.o(17468);
    }
  }
  
  public static void initStore()
  {
    AppMethodBeat.i(17464);
    if (initialized)
    {
      AppMethodBeat.o(17464);
      return;
    }
    AppEventsLogger.getAnalyticsExecutor().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(17462);
        UserDataStore.access$000();
        AppMethodBeat.o(17462);
      }
    });
    AppMethodBeat.o(17464);
  }
  
  private static boolean maybeSHA256Hashed(String paramString)
  {
    AppMethodBeat.i(17472);
    boolean bool = paramString.matches("[A-Fa-f0-9]{64}");
    AppMethodBeat.o(17472);
    return bool;
  }
  
  private static String normalizeData(String paramString1, String paramString2)
  {
    AppMethodBeat.i(17471);
    String str = "";
    int i = -1;
    switch (paramString1.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        paramString1 = str;
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(17471);
      return paramString1;
      if (!paramString1.equals("em")) {
        break;
      }
      i = 0;
      break;
      if (!paramString1.equals("fn")) {
        break;
      }
      i = 1;
      break;
      if (!paramString1.equals("ln")) {
        break;
      }
      i = 2;
      break;
      if (!paramString1.equals("ct")) {
        break;
      }
      i = 3;
      break;
      if (!paramString1.equals("st")) {
        break;
      }
      i = 4;
      break;
      if (!paramString1.equals("country")) {
        break;
      }
      i = 5;
      break;
      if (!paramString1.equals("ph")) {
        break;
      }
      i = 6;
      break;
      if (!paramString1.equals("ge")) {
        break;
      }
      i = 7;
      break;
      paramString1 = paramString2.trim().toLowerCase();
      continue;
      paramString1 = paramString2.trim().replaceAll("[^0-9]", "");
      continue;
      paramString1 = paramString2.trim().toLowerCase();
      if (paramString1.length() > 0) {
        paramString1 = paramString1.substring(0, 1);
      } else {
        paramString1 = "";
      }
    }
  }
  
  public static void setUserDataAndHash(Bundle paramBundle)
  {
    AppMethodBeat.i(17465);
    if (!initialized) {
      initAndWait();
    }
    AppEventsLogger.getAnalyticsExecutor().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(17463);
        UserDataStore.lock.writeLock().lock();
        try
        {
          UserDataStore.access$202(UserDataStore.access$300(this.val$ud));
          SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
          localEditor.putString("com.facebook.appevents.UserDataStore.userData", UserDataStore.hashedUserData);
          localEditor.apply();
          return;
        }
        finally
        {
          UserDataStore.lock.writeLock().unlock();
          AppMethodBeat.o(17463);
        }
      }
    });
    AppMethodBeat.o(17465);
  }
  
  public static void setUserDataAndHash(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    AppMethodBeat.i(17466);
    Bundle localBundle = new Bundle();
    if (paramString1 != null) {
      localBundle.putString("em", paramString1);
    }
    if (paramString2 != null) {
      localBundle.putString("fn", paramString2);
    }
    if (paramString3 != null) {
      localBundle.putString("ln", paramString3);
    }
    if (paramString4 != null) {
      localBundle.putString("ph", paramString4);
    }
    if (paramString5 != null) {
      localBundle.putString("db", paramString5);
    }
    if (paramString6 != null) {
      localBundle.putString("ge", paramString6);
    }
    if (paramString7 != null) {
      localBundle.putString("ct", paramString7);
    }
    if (paramString8 != null) {
      localBundle.putString("st", paramString8);
    }
    if (paramString9 != null) {
      localBundle.putString("zp", paramString9);
    }
    if (paramString10 != null) {
      localBundle.putString("country", paramString10);
    }
    setUserDataAndHash(localBundle);
    AppMethodBeat.o(17466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.appevents.UserDataStore
 * JD-Core Version:    0.7.0.1
 */