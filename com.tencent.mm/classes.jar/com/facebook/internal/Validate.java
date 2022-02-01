package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Looper;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdkNotInitializedException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class Validate
{
  private static final String CONTENT_PROVIDER_BASE = "com.facebook.app.FacebookContentProvider";
  private static final String CONTENT_PROVIDER_NOT_FOUND_REASON = "A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.";
  private static final String CUSTOM_TAB_REDIRECT_ACTIVITY_NOT_FOUND_REASON = "FacebookActivity is declared incorrectly in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";
  private static final String FACEBOOK_ACTIVITY_NOT_FOUND_REASON = "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";
  private static final String NO_INTERNET_PERMISSION_REASON = "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.";
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(18029);
    TAG = Validate.class.getName();
    AppMethodBeat.o(18029);
  }
  
  public static void checkCustomTabRedirectActivity(Context paramContext)
  {
    AppMethodBeat.i(18025);
    checkCustomTabRedirectActivity(paramContext, true);
    AppMethodBeat.o(18025);
  }
  
  public static void checkCustomTabRedirectActivity(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(18026);
    if ((!hasCustomTabRedirectActivity(paramContext)) && (paramBoolean))
    {
      paramContext = new IllegalStateException("FacebookActivity is declared incorrectly in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
      AppMethodBeat.o(18026);
      throw paramContext;
    }
    AppMethodBeat.o(18026);
  }
  
  public static void containsNoNullOrEmpty(Collection<String> paramCollection, String paramString)
  {
    AppMethodBeat.i(18008);
    notNull(paramCollection, paramString);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      String str = (String)paramCollection.next();
      if (str == null)
      {
        paramCollection = new NullPointerException("Container '" + paramString + "' cannot contain null values");
        AppMethodBeat.o(18008);
        throw paramCollection;
      }
      if (str.length() == 0)
      {
        paramCollection = new IllegalArgumentException("Container '" + paramString + "' cannot contain empty values");
        AppMethodBeat.o(18008);
        throw paramCollection;
      }
    }
    AppMethodBeat.o(18008);
  }
  
  public static <T> void containsNoNulls(Collection<T> paramCollection, String paramString)
  {
    AppMethodBeat.i(18007);
    notNull(paramCollection, paramString);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (paramCollection.next() == null)
      {
        paramCollection = new NullPointerException("Container '" + paramString + "' cannot contain null values");
        AppMethodBeat.o(18007);
        throw paramCollection;
      }
    }
    AppMethodBeat.o(18007);
  }
  
  public static String hasAppID()
  {
    AppMethodBeat.i(18014);
    Object localObject = FacebookSdk.getApplicationId();
    if (localObject == null)
    {
      localObject = new IllegalStateException("No App ID found, please set the App ID.");
      AppMethodBeat.o(18014);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(18014);
    return localObject;
  }
  
  public static boolean hasBluetoothPermission(Context paramContext)
  {
    AppMethodBeat.i(18021);
    if ((hasPermission(paramContext, "android.permission.BLUETOOTH")) && (hasPermission(paramContext, "android.permission.BLUETOOTH_ADMIN")))
    {
      AppMethodBeat.o(18021);
      return true;
    }
    AppMethodBeat.o(18021);
    return false;
  }
  
  public static boolean hasChangeWifiStatePermission(Context paramContext)
  {
    AppMethodBeat.i(18019);
    boolean bool = hasPermission(paramContext, "android.permission.CHANGE_WIFI_STATE");
    AppMethodBeat.o(18019);
    return bool;
  }
  
  public static String hasClientToken()
  {
    AppMethodBeat.i(18015);
    Object localObject = FacebookSdk.getClientToken();
    if (localObject == null)
    {
      localObject = new IllegalStateException("No Client Token found, please set the Client Token.");
      AppMethodBeat.o(18015);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(18015);
    return localObject;
  }
  
  public static void hasContentProvider(Context paramContext)
  {
    AppMethodBeat.i(18028);
    notNull(paramContext, "context");
    String str = hasAppID();
    paramContext = paramContext.getPackageManager();
    if (paramContext != null)
    {
      str = "com.facebook.app.FacebookContentProvider".concat(String.valueOf(str));
      if (paramContext.resolveContentProvider(str, 0) == null)
      {
        paramContext = new IllegalStateException(String.format("A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.", new Object[] { str }));
        AppMethodBeat.o(18028);
        throw paramContext;
      }
    }
    AppMethodBeat.o(18028);
  }
  
  public static boolean hasCustomTabRedirectActivity(Context paramContext)
  {
    AppMethodBeat.i(18027);
    notNull(paramContext, "context");
    Object localObject2 = paramContext.getPackageManager();
    Object localObject1 = null;
    if (localObject2 != null)
    {
      localObject1 = new Intent();
      ((Intent)localObject1).setAction("android.intent.action.VIEW");
      ((Intent)localObject1).addCategory("android.intent.category.DEFAULT");
      ((Intent)localObject1).addCategory("android.intent.category.BROWSABLE");
      ((Intent)localObject1).setData(Uri.parse("fb" + FacebookSdk.getApplicationId() + "://authorize"));
      localObject1 = ((PackageManager)localObject2).queryIntentActivities((Intent)localObject1, 64);
    }
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      for (bool = false;; bool = true)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label167;
        }
        localObject2 = ((ResolveInfo)((Iterator)localObject1).next()).activityInfo;
        if ((!((ActivityInfo)localObject2).name.equals("com.facebook.CustomTabActivity")) || (!((ActivityInfo)localObject2).packageName.equals(paramContext.getPackageName()))) {
          break;
        }
      }
      AppMethodBeat.o(18027);
      return false;
    }
    boolean bool = false;
    label167:
    AppMethodBeat.o(18027);
    return bool;
  }
  
  public static void hasFacebookActivity(Context paramContext)
  {
    AppMethodBeat.i(18023);
    hasFacebookActivity(paramContext, true);
    AppMethodBeat.o(18023);
  }
  
  public static void hasFacebookActivity(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(18024);
    notNull(paramContext, "context");
    PackageManager localPackageManager = paramContext.getPackageManager();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localPackageManager != null) {
      paramContext = new ComponentName(paramContext, "com.facebook.FacebookActivity");
    }
    try
    {
      localObject1 = localPackageManager.getActivityInfo(paramContext, 1);
      if ((localObject1 == null) && (paramBoolean))
      {
        paramContext = new IllegalStateException("FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
        AppMethodBeat.o(18024);
        throw paramContext;
      }
      AppMethodBeat.o(18024);
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
  }
  
  public static void hasInternetPermissions(Context paramContext)
  {
    AppMethodBeat.i(18016);
    hasInternetPermissions(paramContext, true);
    AppMethodBeat.o(18016);
  }
  
  public static void hasInternetPermissions(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(18017);
    notNull(paramContext, "context");
    if ((paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) && (paramBoolean))
    {
      paramContext = new IllegalStateException("No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
      AppMethodBeat.o(18017);
      throw paramContext;
    }
    AppMethodBeat.o(18017);
  }
  
  public static boolean hasLocationPermission(Context paramContext)
  {
    AppMethodBeat.i(18020);
    if ((hasPermission(paramContext, "android.permission.ACCESS_COARSE_LOCATION")) || (hasPermission(paramContext, "android.permission.ACCESS_FINE_LOCATION")))
    {
      AppMethodBeat.o(18020);
      return true;
    }
    AppMethodBeat.o(18020);
    return false;
  }
  
  public static boolean hasPermission(Context paramContext, String paramString)
  {
    AppMethodBeat.i(18022);
    if (paramContext.checkCallingOrSelfPermission(paramString) == 0)
    {
      AppMethodBeat.o(18022);
      return true;
    }
    AppMethodBeat.o(18022);
    return false;
  }
  
  public static boolean hasWiFiPermission(Context paramContext)
  {
    AppMethodBeat.i(18018);
    boolean bool = hasPermission(paramContext, "android.permission.ACCESS_WIFI_STATE");
    AppMethodBeat.o(18018);
    return bool;
  }
  
  public static <T> void notEmpty(Collection<T> paramCollection, String paramString)
  {
    AppMethodBeat.i(18006);
    if (paramCollection.isEmpty())
    {
      paramCollection = new IllegalArgumentException("Container '" + paramString + "' cannot be empty");
      AppMethodBeat.o(18006);
      throw paramCollection;
    }
    AppMethodBeat.o(18006);
  }
  
  public static <T> void notEmptyAndContainsNoNulls(Collection<T> paramCollection, String paramString)
  {
    AppMethodBeat.i(18009);
    containsNoNulls(paramCollection, paramString);
    notEmpty(paramCollection, paramString);
    AppMethodBeat.o(18009);
  }
  
  public static void notNull(Object paramObject, String paramString)
  {
    AppMethodBeat.i(18005);
    if (paramObject == null)
    {
      paramObject = new NullPointerException("Argument '" + paramString + "' cannot be null");
      AppMethodBeat.o(18005);
      throw paramObject;
    }
    AppMethodBeat.o(18005);
  }
  
  public static void notNullOrEmpty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(18011);
    if (Utility.isNullOrEmpty(paramString1))
    {
      paramString1 = new IllegalArgumentException("Argument '" + paramString2 + "' cannot be null or empty");
      AppMethodBeat.o(18011);
      throw paramString1;
    }
    AppMethodBeat.o(18011);
  }
  
  public static void oneOf(Object paramObject, String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(18012);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramVarArgs[i];
      if (localObject != null)
      {
        if (localObject.equals(paramObject)) {
          AppMethodBeat.o(18012);
        }
      }
      else if (paramObject == null)
      {
        AppMethodBeat.o(18012);
        return;
      }
      i += 1;
    }
    paramObject = new IllegalArgumentException("Argument '" + paramString + "' was not one of the allowed values");
    AppMethodBeat.o(18012);
    throw paramObject;
  }
  
  public static void runningOnUiThread()
  {
    AppMethodBeat.i(18010);
    if (!Looper.getMainLooper().equals(Looper.myLooper()))
    {
      FacebookException localFacebookException = new FacebookException("This method should be called from the UI thread");
      AppMethodBeat.o(18010);
      throw localFacebookException;
    }
    AppMethodBeat.o(18010);
  }
  
  public static void sdkInitialized()
  {
    AppMethodBeat.i(18013);
    if (!FacebookSdk.isInitialized())
    {
      FacebookSdkNotInitializedException localFacebookSdkNotInitializedException = new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
      AppMethodBeat.o(18013);
      throw localFacebookSdkNotInitializedException;
    }
    AppMethodBeat.o(18013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.internal.Validate
 * JD-Core Version:    0.7.0.1
 */