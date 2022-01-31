package com.facebook;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.appevents.internal.AppEventsLoggerUtility.GraphAPIActivityType;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.BoltsMeasurementEventListener;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.LockOnGetVariable;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;

public final class FacebookSdk
{
  public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";
  public static final String APPLICATION_NAME_PROPERTY = "com.facebook.sdk.ApplicationName";
  private static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";
  public static final String AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY = "com.facebook.sdk.AutoLogAppEventsEnabled";
  static final String CALLBACK_OFFSET_CHANGED_AFTER_INIT = "The callback request code offset can't be updated once the SDK is initialized. Call FacebookSdk.setCallbackRequestCodeOffset inside your Application.onCreate method";
  static final String CALLBACK_OFFSET_NEGATIVE = "The callback request code offset can't be negative.";
  public static final String CALLBACK_OFFSET_PROPERTY = "com.facebook.sdk.CallbackOffset";
  public static final String CLIENT_TOKEN_PROPERTY = "com.facebook.sdk.ClientToken";
  public static final String CODELESS_DEBUG_LOG_ENABLED_PROPERTY = "com.facebook.sdk.CodelessDebugLogEnabled";
  private static final int DEFAULT_CALLBACK_REQUEST_CODE_OFFSET = 64206;
  private static final int DEFAULT_CORE_POOL_SIZE = 5;
  private static final int DEFAULT_KEEP_ALIVE = 1;
  private static final int DEFAULT_MAXIMUM_POOL_SIZE = 128;
  private static final ThreadFactory DEFAULT_THREAD_FACTORY;
  private static final BlockingQueue<Runnable> DEFAULT_WORK_QUEUE;
  private static final String FACEBOOK_COM = "facebook.com";
  private static final Object LOCK;
  private static final int MAX_REQUEST_CODE_RANGE = 100;
  private static final String PUBLISH_ACTIVITY_PATH = "%s/activities";
  private static final String TAG;
  public static final String WEB_DIALOG_THEME = "com.facebook.sdk.WebDialogTheme";
  private static volatile String appClientToken;
  private static Context applicationContext;
  private static volatile String applicationId;
  private static volatile String applicationName;
  private static volatile Boolean autoLogAppEventsEnabled;
  private static LockOnGetVariable<File> cacheDir;
  private static int callbackRequestCodeOffset;
  private static volatile Boolean codelessDebugLogEnabled;
  private static Executor executor;
  private static volatile String facebookDomain;
  private static String graphApiVersion;
  private static volatile boolean isDebugEnabled;
  private static boolean isLegacyTokenUpgradeSupported;
  private static final HashSet<LoggingBehavior> loggingBehaviors;
  private static AtomicLong onProgressThreshold;
  private static Boolean sdkInitialized;
  
  static
  {
    AppMethodBeat.i(71638);
    TAG = FacebookSdk.class.getCanonicalName();
    loggingBehaviors = new HashSet(Arrays.asList(new LoggingBehavior[] { LoggingBehavior.DEVELOPER_ERRORS }));
    facebookDomain = "facebook.com";
    onProgressThreshold = new AtomicLong(65536L);
    isDebugEnabled = false;
    isLegacyTokenUpgradeSupported = false;
    callbackRequestCodeOffset = 64206;
    LOCK = new Object();
    graphApiVersion = ServerProtocol.getDefaultAPIVersion();
    DEFAULT_WORK_QUEUE = new LinkedBlockingQueue(10);
    DEFAULT_THREAD_FACTORY = new FacebookSdk.1();
    sdkInitialized = Boolean.FALSE;
    AppMethodBeat.o(71638);
  }
  
  public static void addLoggingBehavior(LoggingBehavior paramLoggingBehavior)
  {
    AppMethodBeat.i(71611);
    synchronized (loggingBehaviors)
    {
      loggingBehaviors.add(paramLoggingBehavior);
      updateGraphDebugBehavior();
      AppMethodBeat.o(71611);
      return;
    }
  }
  
  public static void clearLoggingBehaviors()
  {
    AppMethodBeat.i(71613);
    synchronized (loggingBehaviors)
    {
      loggingBehaviors.clear();
      AppMethodBeat.o(71613);
      return;
    }
  }
  
  public static Context getApplicationContext()
  {
    AppMethodBeat.i(71617);
    Validate.sdkInitialized();
    Context localContext = applicationContext;
    AppMethodBeat.o(71617);
    return localContext;
  }
  
  public static String getApplicationId()
  {
    AppMethodBeat.i(71628);
    Validate.sdkInitialized();
    String str = applicationId;
    AppMethodBeat.o(71628);
    return str;
  }
  
  public static String getApplicationName()
  {
    AppMethodBeat.i(71629);
    Validate.sdkInitialized();
    String str = applicationName;
    AppMethodBeat.o(71629);
    return str;
  }
  
  public static String getApplicationSignature(Context paramContext)
  {
    AppMethodBeat.i(71627);
    Validate.sdkInitialized();
    if (paramContext == null)
    {
      AppMethodBeat.o(71627);
      return null;
    }
    Object localObject = paramContext.getPackageManager();
    if (localObject == null)
    {
      AppMethodBeat.o(71627);
      return null;
    }
    paramContext = paramContext.getPackageName();
    try
    {
      paramContext = ((PackageManager)localObject).getPackageInfo(paramContext, 64);
      localObject = paramContext.signatures;
      if ((localObject == null) || (localObject.length == 0))
      {
        AppMethodBeat.o(71627);
        return null;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(71627);
      return null;
    }
    try
    {
      localObject = MessageDigest.getInstance("SHA-1");
      ((MessageDigest)localObject).update(paramContext.signatures[0].toByteArray());
      paramContext = Base64.encodeToString(((MessageDigest)localObject).digest(), 9);
      AppMethodBeat.o(71627);
      return paramContext;
    }
    catch (NoSuchAlgorithmException paramContext)
    {
      AppMethodBeat.o(71627);
    }
    return null;
  }
  
  public static boolean getAutoLogAppEventsEnabled()
  {
    AppMethodBeat.i(71631);
    Validate.sdkInitialized();
    boolean bool = autoLogAppEventsEnabled.booleanValue();
    AppMethodBeat.o(71631);
    return bool;
  }
  
  public static File getCacheDir()
  {
    AppMethodBeat.i(71635);
    Validate.sdkInitialized();
    File localFile = (File)cacheDir.getValue();
    AppMethodBeat.o(71635);
    return localFile;
  }
  
  public static int getCallbackRequestCodeOffset()
  {
    AppMethodBeat.i(71637);
    Validate.sdkInitialized();
    int i = callbackRequestCodeOffset;
    AppMethodBeat.o(71637);
    return i;
  }
  
  public static String getClientToken()
  {
    AppMethodBeat.i(71630);
    Validate.sdkInitialized();
    String str = appClientToken;
    AppMethodBeat.o(71630);
    return str;
  }
  
  public static boolean getCodelessDebugLogEnabled()
  {
    AppMethodBeat.i(71633);
    Validate.sdkInitialized();
    boolean bool = codelessDebugLogEnabled.booleanValue();
    AppMethodBeat.o(71633);
    return bool;
  }
  
  public static Executor getExecutor()
  {
    synchronized (LOCK)
    {
      if (executor == null) {
        executor = AsyncTask.THREAD_POOL_EXECUTOR;
      }
      return executor;
    }
  }
  
  public static String getFacebookDomain()
  {
    return facebookDomain;
  }
  
  public static String getGraphApiVersion()
  {
    AppMethodBeat.i(71619);
    Utility.logd(TAG, String.format("getGraphApiVersion: %s", new Object[] { graphApiVersion }));
    String str = graphApiVersion;
    AppMethodBeat.o(71619);
    return str;
  }
  
  public static boolean getLimitEventAndDataUsage(Context paramContext)
  {
    AppMethodBeat.i(71622);
    Validate.sdkInitialized();
    boolean bool = paramContext.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
    AppMethodBeat.o(71622);
    return bool;
  }
  
  public static Set<LoggingBehavior> getLoggingBehaviors()
  {
    AppMethodBeat.i(71610);
    synchronized (loggingBehaviors)
    {
      Set localSet = Collections.unmodifiableSet(new HashSet(loggingBehaviors));
      AppMethodBeat.o(71610);
      return localSet;
    }
  }
  
  public static long getOnProgressThreshold()
  {
    AppMethodBeat.i(71624);
    Validate.sdkInitialized();
    long l = onProgressThreshold.get();
    AppMethodBeat.o(71624);
    return l;
  }
  
  public static String getSdkVersion()
  {
    return "4.38.1";
  }
  
  public static boolean isDebugEnabled()
  {
    return isDebugEnabled;
  }
  
  public static boolean isFacebookRequestCode(int paramInt)
  {
    return (paramInt >= callbackRequestCodeOffset) && (paramInt < callbackRequestCodeOffset + 100);
  }
  
  public static boolean isInitialized()
  {
    try
    {
      AppMethodBeat.i(71609);
      boolean bool = sdkInitialized.booleanValue();
      AppMethodBeat.o(71609);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean isLegacyTokenUpgradeSupported()
  {
    return isLegacyTokenUpgradeSupported;
  }
  
  public static boolean isLoggingBehaviorEnabled(LoggingBehavior paramLoggingBehavior)
  {
    AppMethodBeat.i(71614);
    synchronized (loggingBehaviors)
    {
      if ((isDebugEnabled()) && (loggingBehaviors.contains(paramLoggingBehavior)))
      {
        bool = true;
        AppMethodBeat.o(71614);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  static void loadDefaultsFromMetadata(Context paramContext)
  {
    AppMethodBeat.i(71626);
    if (paramContext == null)
    {
      AppMethodBeat.o(71626);
      return;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if ((paramContext == null) || (paramContext.metaData == null))
      {
        AppMethodBeat.o(71626);
        return;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(71626);
      return;
    }
    Object localObject;
    if (applicationId == null)
    {
      localObject = paramContext.metaData.get("com.facebook.sdk.ApplicationId");
      if (!(localObject instanceof String)) {
        break label226;
      }
      localObject = (String)localObject;
      if (!((String)localObject).toLowerCase(Locale.ROOT).startsWith("fb")) {
        break label219;
      }
      applicationId = ((String)localObject).substring(2);
    }
    label219:
    label226:
    while (!(localObject instanceof Integer)) {
      for (;;)
      {
        if (applicationName == null) {
          applicationName = paramContext.metaData.getString("com.facebook.sdk.ApplicationName");
        }
        if (appClientToken == null) {
          appClientToken = paramContext.metaData.getString("com.facebook.sdk.ClientToken");
        }
        if (callbackRequestCodeOffset == 64206) {
          callbackRequestCodeOffset = paramContext.metaData.getInt("com.facebook.sdk.CallbackOffset", 64206);
        }
        if (autoLogAppEventsEnabled == null) {
          autoLogAppEventsEnabled = Boolean.valueOf(paramContext.metaData.getBoolean("com.facebook.sdk.AutoLogAppEventsEnabled", true));
        }
        if (codelessDebugLogEnabled == null) {
          codelessDebugLogEnabled = Boolean.valueOf(paramContext.metaData.getBoolean("com.facebook.sdk.CodelessDebugLogEnabled", false));
        }
        AppMethodBeat.o(71626);
        return;
        applicationId = (String)localObject;
      }
    }
    paramContext = new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
    AppMethodBeat.o(71626);
    throw paramContext;
  }
  
  static void publishInstallAndWaitForResponse(Context paramContext, String paramString)
  {
    AppMethodBeat.i(71621);
    if ((paramContext == null) || (paramString == null)) {
      try
      {
        paramContext = new IllegalArgumentException("Both context and applicationId must be non-null");
        AppMethodBeat.o(71621);
        throw paramContext;
      }
      catch (Exception paramContext)
      {
        Utility.logd("Facebook-publish", paramContext);
        AppMethodBeat.o(71621);
        return;
      }
    }
    AttributionIdentifiers localAttributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(paramContext);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
    String str = paramString + "ping";
    long l = localSharedPreferences.getLong(str, 0L);
    try
    {
      paramContext = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.MOBILE_INSTALL_EVENT, localAttributionIdentifiers, AppEventsLogger.getAnonymousAppDeviceGUID(paramContext), getLimitEventAndDataUsage(paramContext), paramContext);
      paramContext = GraphRequest.newPostRequest(null, String.format("%s/activities", new Object[] { paramString }), paramContext, null);
      if (l == 0L)
      {
        paramContext.executeAndWait();
        paramContext = localSharedPreferences.edit();
        paramContext.putLong(str, System.currentTimeMillis());
        paramContext.apply();
      }
      AppMethodBeat.o(71621);
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext = new FacebookException("An error occurred while publishing install.", paramContext);
      AppMethodBeat.o(71621);
      throw paramContext;
    }
  }
  
  public static void publishInstallAsync(Context paramContext, String paramString)
  {
    AppMethodBeat.i(71620);
    paramContext = paramContext.getApplicationContext();
    getExecutor().execute(new FacebookSdk.5(paramContext, paramString));
    AppMethodBeat.o(71620);
  }
  
  public static void removeLoggingBehavior(LoggingBehavior paramLoggingBehavior)
  {
    AppMethodBeat.i(71612);
    synchronized (loggingBehaviors)
    {
      loggingBehaviors.remove(paramLoggingBehavior);
      AppMethodBeat.o(71612);
      return;
    }
  }
  
  @Deprecated
  public static void sdkInitialize(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(71607);
      sdkInitialize(paramContext, null);
      AppMethodBeat.o(71607);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  @Deprecated
  public static void sdkInitialize(Context paramContext, int paramInt)
  {
    try
    {
      AppMethodBeat.i(71605);
      sdkInitialize(paramContext, paramInt, null);
      AppMethodBeat.o(71605);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  @Deprecated
  public static void sdkInitialize(Context paramContext, int paramInt, InitializeCallback paramInitializeCallback)
  {
    try
    {
      AppMethodBeat.i(71606);
      if ((sdkInitialized.booleanValue()) && (paramInt != callbackRequestCodeOffset))
      {
        paramContext = new FacebookException("The callback request code offset can't be updated once the SDK is initialized. Call FacebookSdk.setCallbackRequestCodeOffset inside your Application.onCreate method");
        AppMethodBeat.o(71606);
        throw paramContext;
      }
    }
    finally {}
    if (paramInt < 0)
    {
      paramContext = new FacebookException("The callback request code offset can't be negative.");
      AppMethodBeat.o(71606);
      throw paramContext;
    }
    callbackRequestCodeOffset = paramInt;
    sdkInitialize(paramContext, paramInitializeCallback);
    AppMethodBeat.o(71606);
  }
  
  @Deprecated
  public static void sdkInitialize(Context paramContext, InitializeCallback paramInitializeCallback)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(71608);
        if (sdkInitialized.booleanValue())
        {
          if (paramInitializeCallback != null) {
            paramInitializeCallback.onInitialized();
          }
          AppMethodBeat.o(71608);
          return;
        }
        Validate.notNull(paramContext, "applicationContext");
        Validate.hasFacebookActivity(paramContext, false);
        Validate.hasInternetPermissions(paramContext, false);
        Context localContext = paramContext.getApplicationContext();
        applicationContext = localContext;
        loadDefaultsFromMetadata(localContext);
        if (Utility.isNullOrEmpty(applicationId))
        {
          paramContext = new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
          AppMethodBeat.o(71608);
          throw paramContext;
        }
      }
      finally {}
      if (((applicationContext instanceof Application)) && (autoLogAppEventsEnabled.booleanValue())) {
        ActivityLifecycleTracker.startTracking((Application)applicationContext, applicationId);
      }
      sdkInitialized = Boolean.TRUE;
      FetchedAppSettingsManager.getAppSettingsAsync(new FacebookSdk.2());
      NativeProtocol.updateAllAvailableProtocolVersionsAsync();
      BoltsMeasurementEventListener.getInstance(applicationContext);
      cacheDir = new LockOnGetVariable(new FacebookSdk.3());
      paramContext = new FutureTask(new FacebookSdk.4(paramInitializeCallback, paramContext));
      getExecutor().execute(paramContext);
      AppMethodBeat.o(71608);
    }
  }
  
  public static void setApplicationId(String paramString)
  {
    applicationId = paramString;
  }
  
  public static void setApplicationName(String paramString)
  {
    applicationName = paramString;
  }
  
  public static void setAutoLogAppEventsEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(71632);
    autoLogAppEventsEnabled = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(71632);
  }
  
  public static void setCacheDir(File paramFile)
  {
    AppMethodBeat.i(71636);
    cacheDir = new LockOnGetVariable(paramFile);
    AppMethodBeat.o(71636);
  }
  
  public static void setClientToken(String paramString)
  {
    appClientToken = paramString;
  }
  
  public static void setCodelessDebugLogEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(71634);
    codelessDebugLogEnabled = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(71634);
  }
  
  public static void setExecutor(Executor paramExecutor)
  {
    AppMethodBeat.i(71616);
    Validate.notNull(paramExecutor, "executor");
    synchronized (LOCK)
    {
      executor = paramExecutor;
      AppMethodBeat.o(71616);
      return;
    }
  }
  
  public static void setFacebookDomain(String paramString)
  {
    facebookDomain = paramString;
  }
  
  public static void setGraphApiVersion(String paramString)
  {
    AppMethodBeat.i(71618);
    if ((!Utility.isNullOrEmpty(paramString)) && (!graphApiVersion.equals(paramString))) {
      graphApiVersion = paramString;
    }
    AppMethodBeat.o(71618);
  }
  
  public static void setIsDebugEnabled(boolean paramBoolean)
  {
    isDebugEnabled = paramBoolean;
  }
  
  public static void setLegacyTokenUpgradeSupported(boolean paramBoolean)
  {
    isLegacyTokenUpgradeSupported = paramBoolean;
  }
  
  public static void setLimitEventAndDataUsage(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(71623);
    paramContext.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putBoolean("limitEventUsage", paramBoolean).apply();
    AppMethodBeat.o(71623);
  }
  
  public static void setOnProgressThreshold(long paramLong)
  {
    AppMethodBeat.i(71625);
    onProgressThreshold.set(paramLong);
    AppMethodBeat.o(71625);
  }
  
  private static void updateGraphDebugBehavior()
  {
    AppMethodBeat.i(71615);
    if ((loggingBehaviors.contains(LoggingBehavior.GRAPH_API_DEBUG_INFO)) && (!loggingBehaviors.contains(LoggingBehavior.GRAPH_API_DEBUG_WARNING))) {
      loggingBehaviors.add(LoggingBehavior.GRAPH_API_DEBUG_WARNING);
    }
    AppMethodBeat.o(71615);
  }
  
  public static abstract interface InitializeCallback
  {
    public abstract void onInitialized();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.FacebookSdk
 * JD-Core Version:    0.7.0.1
 */