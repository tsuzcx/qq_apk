package com.facebook.appevents;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.webkit.WebView;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.BundleJSONConverter;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppEventsLogger
{
  public static final String ACTION_APP_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_FLUSHED";
  public static final String APP_EVENTS_EXTRA_FLUSH_RESULT = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";
  public static final String APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";
  private static final String APP_EVENT_NAME_PUSH_OPENED = "fb_mobile_push_opened";
  public static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
  private static final String APP_EVENT_PUSH_PARAMETER_ACTION = "fb_push_action";
  private static final String APP_EVENT_PUSH_PARAMETER_CAMPAIGN = "fb_push_campaign";
  private static final int APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS = 86400;
  private static final int FLUSH_APP_SESSION_INFO_IN_SECONDS = 30;
  private static final String PUSH_PAYLOAD_CAMPAIGN_KEY = "campaign";
  private static final String PUSH_PAYLOAD_KEY = "fb_push_payload";
  private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";
  private static final String TAG;
  private static String anonymousAppDeviceGUID;
  private static ScheduledThreadPoolExecutor backgroundExecutor;
  private static AppEventsLogger.FlushBehavior flushBehavior;
  private static boolean isActivateAppEventRequested;
  private static boolean isOpenedByAppLink;
  private static String pushNotificationsRegistrationId;
  private static String sourceApplication;
  private static Object staticLock;
  private final AccessTokenAppIdPair accessTokenAppId;
  private final String contextName;
  
  static
  {
    AppMethodBeat.i(17419);
    TAG = AppEventsLogger.class.getCanonicalName();
    flushBehavior = AppEventsLogger.FlushBehavior.AUTO;
    staticLock = new Object();
    AppMethodBeat.o(17419);
  }
  
  private AppEventsLogger(Context paramContext, String paramString, AccessToken paramAccessToken)
  {
    this(Utility.getActivityName(paramContext), paramString, paramAccessToken);
    AppMethodBeat.i(17405);
    AppMethodBeat.o(17405);
  }
  
  protected AppEventsLogger(String paramString1, String paramString2, AccessToken paramAccessToken)
  {
    AppMethodBeat.i(17406);
    Validate.sdkInitialized();
    this.contextName = paramString1;
    paramString1 = paramAccessToken;
    if (paramAccessToken == null) {
      paramString1 = AccessToken.getCurrentAccessToken();
    }
    if ((AccessToken.isCurrentAccessTokenActive()) && ((paramString2 == null) || (paramString2.equals(paramString1.getApplicationId())))) {}
    for (this.accessTokenAppId = new AccessTokenAppIdPair(paramString1);; this.accessTokenAppId = new AccessTokenAppIdPair(null, paramString1))
    {
      initializeTimersIfNeeded();
      AppMethodBeat.o(17406);
      return;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = Utility.getMetadataApplicationId(FacebookSdk.getApplicationContext());
      }
    }
  }
  
  public static void activateApp(Application paramApplication)
  {
    AppMethodBeat.i(17364);
    activateApp(paramApplication, null);
    AppMethodBeat.o(17364);
  }
  
  public static void activateApp(Application paramApplication, String paramString)
  {
    AppMethodBeat.i(17365);
    if (!FacebookSdk.isInitialized())
    {
      paramApplication = new FacebookException("The Facebook sdk must be initialized before calling activateApp");
      AppMethodBeat.o(17365);
      throw paramApplication;
    }
    AnalyticsUserIDStore.initStore();
    UserDataStore.initStore();
    String str = paramString;
    if (paramString == null) {
      str = FacebookSdk.getApplicationId();
    }
    FacebookSdk.publishInstallAsync(paramApplication, str);
    ActivityLifecycleTracker.startTracking(paramApplication, str);
    AppMethodBeat.o(17365);
  }
  
  @Deprecated
  public static void activateApp(Context paramContext)
  {
    AppMethodBeat.i(17366);
    if (ActivityLifecycleTracker.isTracking())
    {
      AppMethodBeat.o(17366);
      return;
    }
    FacebookSdk.sdkInitialize(paramContext);
    activateApp(paramContext, Utility.getMetadataApplicationId(paramContext));
    AppMethodBeat.o(17366);
  }
  
  @Deprecated
  public static void activateApp(Context paramContext, String paramString)
  {
    AppMethodBeat.i(17367);
    if (ActivityLifecycleTracker.isTracking())
    {
      AppMethodBeat.o(17367);
      return;
    }
    if ((paramContext == null) || (paramString == null))
    {
      paramContext = new IllegalArgumentException("Both context and applicationId must be non-null");
      AppMethodBeat.o(17367);
      throw paramContext;
    }
    AnalyticsUserIDStore.initStore();
    UserDataStore.initStore();
    if ((paramContext instanceof Activity)) {
      setSourceApplication((Activity)paramContext);
    }
    for (;;)
    {
      FacebookSdk.publishInstallAsync(paramContext, paramString);
      paramContext = new AppEventsLogger(paramContext, paramString, null);
      final long l = System.currentTimeMillis();
      paramString = getSourceApplication();
      backgroundExecutor.execute(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(17342);
          AppEventsLogger.access$000(this.val$logger, l, this.val$sourceApplicationInfo);
          AppMethodBeat.o(17342);
        }
      });
      AppMethodBeat.o(17367);
      return;
      resetSourceApplication();
      Utility.logd(AppEventsLogger.class.getName(), "To set source application the context of activateApp must be an instance of Activity");
    }
  }
  
  public static void augmentWebView(WebView paramWebView, Context paramContext)
  {
    int j = 0;
    AppMethodBeat.i(17393);
    String[] arrayOfString = Build.VERSION.RELEASE.split("\\.");
    if (arrayOfString.length > 0) {}
    for (int i = Integer.parseInt(arrayOfString[0]);; i = 0)
    {
      if (arrayOfString.length > 1) {
        j = Integer.parseInt(arrayOfString[1]);
      }
      if ((Build.VERSION.SDK_INT >= 17) && (i >= 4) && ((i != 4) || (j > 1))) {
        break;
      }
      Logger.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "augmentWebView is only available for Android SDK version >= 17 on devices running Android >= 4.2");
      AppMethodBeat.o(17393);
      return;
    }
    paramWebView.addJavascriptInterface(new FacebookSDKJSInterface(paramContext), "fbmq_" + FacebookSdk.getApplicationId());
    AppMethodBeat.o(17393);
  }
  
  public static void clearUserData()
  {
    AppMethodBeat.i(17400);
    UserDataStore.setUserDataAndHash(null);
    AppMethodBeat.o(17400);
  }
  
  public static void clearUserID()
  {
    AppMethodBeat.i(17396);
    AnalyticsUserIDStore.setUserID(null);
    AppMethodBeat.o(17396);
  }
  
  @Deprecated
  public static void deactivateApp(Context paramContext)
  {
    AppMethodBeat.i(17368);
    if (ActivityLifecycleTracker.isTracking())
    {
      AppMethodBeat.o(17368);
      return;
    }
    deactivateApp(paramContext, Utility.getMetadataApplicationId(paramContext));
    AppMethodBeat.o(17368);
  }
  
  @Deprecated
  public static void deactivateApp(Context paramContext, String paramString)
  {
    AppMethodBeat.i(17369);
    if (ActivityLifecycleTracker.isTracking())
    {
      AppMethodBeat.o(17369);
      return;
    }
    if ((paramContext == null) || (paramString == null))
    {
      paramContext = new IllegalArgumentException("Both context and applicationId must be non-null");
      AppMethodBeat.o(17369);
      throw paramContext;
    }
    resetSourceApplication();
    paramContext = new AppEventsLogger(paramContext, paramString, null);
    final long l = System.currentTimeMillis();
    backgroundExecutor.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(17343);
        AppEventsLogger.access$100(this.val$logger, l);
        AppMethodBeat.o(17343);
      }
    });
    AppMethodBeat.o(17369);
  }
  
  static void eagerFlush()
  {
    AppMethodBeat.i(17411);
    if (getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
      AppEventQueue.flush(FlushReason.EAGER_FLUSHING_EVENT);
    }
    AppMethodBeat.o(17411);
  }
  
  static Executor getAnalyticsExecutor()
  {
    AppMethodBeat.i(17415);
    if (backgroundExecutor == null) {
      initializeTimersIfNeeded();
    }
    ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = backgroundExecutor;
    AppMethodBeat.o(17415);
    return localScheduledThreadPoolExecutor;
  }
  
  public static String getAnonymousAppDeviceGUID(Context paramContext)
  {
    AppMethodBeat.i(17416);
    if (anonymousAppDeviceGUID == null) {}
    synchronized (staticLock)
    {
      if (anonymousAppDeviceGUID == null)
      {
        String str = paramContext.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("anonymousAppDeviceGUID", null);
        anonymousAppDeviceGUID = str;
        if (str == null)
        {
          anonymousAppDeviceGUID = "XZ" + UUID.randomUUID().toString();
          paramContext.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("anonymousAppDeviceGUID", anonymousAppDeviceGUID).apply();
        }
      }
      paramContext = anonymousAppDeviceGUID;
      AppMethodBeat.o(17416);
      return paramContext;
    }
  }
  
  public static AppEventsLogger.FlushBehavior getFlushBehavior()
  {
    synchronized (staticLock)
    {
      AppEventsLogger.FlushBehavior localFlushBehavior = flushBehavior;
      return localFlushBehavior;
    }
  }
  
  static String getPushNotificationsRegistrationId()
  {
    synchronized (staticLock)
    {
      String str = pushNotificationsRegistrationId;
      return str;
    }
  }
  
  static String getSourceApplication()
  {
    AppMethodBeat.i(17414);
    String str = "Unclassified";
    if (isOpenedByAppLink) {
      str = "Applink";
    }
    if (sourceApplication != null)
    {
      str = str + "(" + sourceApplication + ")";
      AppMethodBeat.o(17414);
      return str;
    }
    AppMethodBeat.o(17414);
    return str;
  }
  
  public static String getUserData()
  {
    AppMethodBeat.i(17399);
    String str = UserDataStore.getHashedUserData();
    AppMethodBeat.o(17399);
    return str;
  }
  
  public static String getUserID()
  {
    AppMethodBeat.i(17395);
    String str = AnalyticsUserIDStore.getUserID();
    AppMethodBeat.o(17395);
    return str;
  }
  
  public static void initializeLib(Context paramContext, String paramString)
  {
    AppMethodBeat.i(17372);
    if (!FacebookSdk.getAutoLogAppEventsEnabled())
    {
      AppMethodBeat.o(17372);
      return;
    }
    paramContext = new AppEventsLogger(paramContext, paramString, null);
    backgroundExecutor.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(17344);
        Bundle localBundle = new Bundle();
        try
        {
          Class.forName("com.facebook.core.Core");
          localBundle.putInt("core_lib_included", 1);
          try
          {
            label27:
            Class.forName("com.facebook.login.Login");
            localBundle.putInt("login_lib_included", 1);
            try
            {
              label40:
              Class.forName("com.facebook.share.Share");
              localBundle.putInt("share_lib_included", 1);
              try
              {
                label53:
                Class.forName("com.facebook.places.Places");
                localBundle.putInt("places_lib_included", 1);
                try
                {
                  label66:
                  Class.forName("com.facebook.messenger.Messenger");
                  localBundle.putInt("messenger_lib_included", 1);
                  try
                  {
                    label79:
                    Class.forName("com.facebook.applinks.AppLinks");
                    localBundle.putInt("applinks_lib_included", 1);
                    try
                    {
                      label92:
                      Class.forName("com.facebook.marketing.Marketing");
                      localBundle.putInt("marketing_lib_included", 1);
                      try
                      {
                        label105:
                        Class.forName("com.facebook.all.All");
                        localBundle.putInt("all_lib_included", 1);
                        try
                        {
                          label118:
                          Class.forName("com.android.billingclient.api.BillingClient");
                          localBundle.putInt("billing_client_lib_included", 1);
                          try
                          {
                            label131:
                            Class.forName("com.android.vending.billing.IInAppBillingService");
                            localBundle.putInt("billing_service_lib_included", 1);
                            label144:
                            this.val$logger.logSdkEvent("fb_sdk_initialize", null, localBundle);
                            AppMethodBeat.o(17344);
                            return;
                          }
                          catch (ClassNotFoundException localClassNotFoundException1)
                          {
                            break label144;
                          }
                        }
                        catch (ClassNotFoundException localClassNotFoundException2)
                        {
                          break label131;
                        }
                      }
                      catch (ClassNotFoundException localClassNotFoundException3)
                      {
                        break label118;
                      }
                    }
                    catch (ClassNotFoundException localClassNotFoundException4)
                    {
                      break label105;
                    }
                  }
                  catch (ClassNotFoundException localClassNotFoundException5)
                  {
                    break label92;
                  }
                }
                catch (ClassNotFoundException localClassNotFoundException6)
                {
                  break label79;
                }
              }
              catch (ClassNotFoundException localClassNotFoundException7)
              {
                break label66;
              }
            }
            catch (ClassNotFoundException localClassNotFoundException8)
            {
              break label53;
            }
          }
          catch (ClassNotFoundException localClassNotFoundException9)
          {
            break label40;
          }
        }
        catch (ClassNotFoundException localClassNotFoundException10)
        {
          break label27;
        }
      }
    });
    AppMethodBeat.o(17372);
  }
  
  private static void initializeTimersIfNeeded()
  {
    AppMethodBeat.i(17407);
    synchronized (staticLock)
    {
      if (backgroundExecutor != null)
      {
        AppMethodBeat.o(17407);
        return;
      }
      backgroundExecutor = new ScheduledThreadPoolExecutor(1);
      ??? = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(17346);
          Object localObject = new HashSet();
          Iterator localIterator = AppEventQueue.getKeySet().iterator();
          while (localIterator.hasNext()) {
            ((Set)localObject).add(((AccessTokenAppIdPair)localIterator.next()).getApplicationId());
          }
          localObject = ((Set)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            FetchedAppSettingsManager.queryAppSettings((String)((Iterator)localObject).next(), true);
          }
          AppMethodBeat.o(17346);
        }
      };
      backgroundExecutor.scheduleAtFixedRate((Runnable)???, 0L, 86400L, TimeUnit.SECONDS);
      AppMethodBeat.o(17407);
      return;
    }
  }
  
  private void logAppSessionResumeEvent(long paramLong, String paramString)
  {
    AppMethodBeat.i(17370);
    PersistedAppSessionInfo.onResume(FacebookSdk.getApplicationContext(), this.accessTokenAppId, this, paramLong, paramString);
    AppMethodBeat.o(17370);
  }
  
  private void logAppSessionSuspendEvent(long paramLong)
  {
    AppMethodBeat.i(17371);
    PersistedAppSessionInfo.onSuspend(FacebookSdk.getApplicationContext(), this.accessTokenAppId, this, paramLong);
    AppMethodBeat.o(17371);
  }
  
  private static void logEvent(AppEvent paramAppEvent, AccessTokenAppIdPair paramAccessTokenAppIdPair)
  {
    AppMethodBeat.i(17410);
    AppEventQueue.add(paramAccessTokenAppIdPair, paramAppEvent);
    if ((!paramAppEvent.getIsImplicit()) && (!isActivateAppEventRequested))
    {
      if (paramAppEvent.getName().equals("fb_mobile_activate_app"))
      {
        isActivateAppEventRequested = true;
        AppMethodBeat.o(17410);
        return;
      }
      Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
    }
    AppMethodBeat.o(17410);
  }
  
  private void logEvent(String paramString, Double paramDouble, Bundle paramBundle, boolean paramBoolean, UUID paramUUID)
  {
    AppMethodBeat.i(17409);
    try
    {
      logEvent(new AppEvent(this.contextName, paramString, paramDouble, paramBundle, paramBoolean, paramUUID), this.accessTokenAppId);
      AppMethodBeat.o(17409);
      return;
    }
    catch (JSONException paramString)
    {
      Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", new Object[] { paramString.toString() });
      AppMethodBeat.o(17409);
      return;
    }
    catch (FacebookException paramString)
    {
      Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Invalid app event: %s", new Object[] { paramString.toString() });
      AppMethodBeat.o(17409);
    }
  }
  
  private void logPurchase(BigDecimal paramBigDecimal, Currency paramCurrency, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(17385);
    if (paramBigDecimal == null)
    {
      notifyDeveloperError("purchaseAmount cannot be null");
      AppMethodBeat.o(17385);
      return;
    }
    if (paramCurrency == null)
    {
      notifyDeveloperError("currency cannot be null");
      AppMethodBeat.o(17385);
      return;
    }
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    for (;;)
    {
      paramBundle.putString("fb_currency", paramCurrency.getCurrencyCode());
      logEvent("fb_mobile_purchase", Double.valueOf(paramBigDecimal.doubleValue()), paramBundle, paramBoolean, ActivityLifecycleTracker.getCurrentSessionGuid());
      eagerFlush();
      AppMethodBeat.o(17385);
      return;
    }
  }
  
  public static AppEventsLogger newLogger(Context paramContext)
  {
    AppMethodBeat.i(17373);
    paramContext = new AppEventsLogger(paramContext, null, null);
    AppMethodBeat.o(17373);
    return paramContext;
  }
  
  public static AppEventsLogger newLogger(Context paramContext, AccessToken paramAccessToken)
  {
    AppMethodBeat.i(17374);
    paramContext = new AppEventsLogger(paramContext, null, paramAccessToken);
    AppMethodBeat.o(17374);
    return paramContext;
  }
  
  public static AppEventsLogger newLogger(Context paramContext, String paramString)
  {
    AppMethodBeat.i(17376);
    paramContext = new AppEventsLogger(paramContext, paramString, null);
    AppMethodBeat.o(17376);
    return paramContext;
  }
  
  public static AppEventsLogger newLogger(Context paramContext, String paramString, AccessToken paramAccessToken)
  {
    AppMethodBeat.i(17375);
    paramContext = new AppEventsLogger(paramContext, paramString, paramAccessToken);
    AppMethodBeat.o(17375);
    return paramContext;
  }
  
  private static void notifyDeveloperError(String paramString)
  {
    AppMethodBeat.i(17412);
    Logger.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", paramString);
    AppMethodBeat.o(17412);
  }
  
  public static void onContextStop()
  {
    AppMethodBeat.i(17390);
    AppEventQueue.persistToDisk();
    AppMethodBeat.o(17390);
  }
  
  static void resetSourceApplication()
  {
    sourceApplication = null;
    isOpenedByAppLink = false;
  }
  
  public static void setFlushBehavior(AppEventsLogger.FlushBehavior paramFlushBehavior)
  {
    synchronized (staticLock)
    {
      flushBehavior = paramFlushBehavior;
      return;
    }
  }
  
  public static void setPushNotificationsRegistrationId(String paramString)
  {
    AppMethodBeat.i(17392);
    synchronized (staticLock)
    {
      if (!Utility.stringsEqualOrEmpty(pushNotificationsRegistrationId, paramString))
      {
        pushNotificationsRegistrationId = paramString;
        paramString = newLogger(FacebookSdk.getApplicationContext());
        paramString.logEvent("fb_mobile_obtain_push_token");
        if (getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
          paramString.flush();
        }
      }
      AppMethodBeat.o(17392);
      return;
    }
  }
  
  private static void setSourceApplication(Activity paramActivity)
  {
    AppMethodBeat.i(17413);
    Object localObject = paramActivity.getCallingActivity();
    if (localObject != null)
    {
      localObject = ((ComponentName)localObject).getPackageName();
      if (((String)localObject).equals(paramActivity.getPackageName()))
      {
        resetSourceApplication();
        AppMethodBeat.o(17413);
        return;
      }
      sourceApplication = (String)localObject;
    }
    paramActivity = paramActivity.getIntent();
    if ((paramActivity == null) || (paramActivity.getBooleanExtra("_fbSourceApplicationHasBeenSet", false)))
    {
      resetSourceApplication();
      AppMethodBeat.o(17413);
      return;
    }
    localObject = paramActivity.getBundleExtra("al_applink_data");
    if (localObject == null)
    {
      resetSourceApplication();
      AppMethodBeat.o(17413);
      return;
    }
    isOpenedByAppLink = true;
    localObject = ((Bundle)localObject).getBundle("referer_app_link");
    if (localObject == null)
    {
      sourceApplication = null;
      AppMethodBeat.o(17413);
      return;
    }
    sourceApplication = ((Bundle)localObject).getString("package");
    paramActivity.putExtra("_fbSourceApplicationHasBeenSet", true);
    AppMethodBeat.o(17413);
  }
  
  static void setSourceApplication(String paramString, boolean paramBoolean)
  {
    sourceApplication = paramString;
    isOpenedByAppLink = paramBoolean;
  }
  
  @Deprecated
  public static void setUserData(Bundle paramBundle)
  {
    AppMethodBeat.i(17397);
    UserDataStore.setUserDataAndHash(paramBundle);
    AppMethodBeat.o(17397);
  }
  
  public static void setUserData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    AppMethodBeat.i(17398);
    UserDataStore.setUserDataAndHash(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10);
    AppMethodBeat.o(17398);
  }
  
  public static void setUserID(String paramString)
  {
    AppMethodBeat.i(17394);
    AnalyticsUserIDStore.setUserID(paramString);
    AppMethodBeat.o(17394);
  }
  
  public static void updateUserProperties(Bundle paramBundle, GraphRequest.Callback paramCallback)
  {
    AppMethodBeat.i(17401);
    updateUserProperties(paramBundle, FacebookSdk.getApplicationId(), paramCallback);
    AppMethodBeat.o(17401);
  }
  
  public static void updateUserProperties(Bundle paramBundle, final String paramString, final GraphRequest.Callback paramCallback)
  {
    AppMethodBeat.i(17402);
    getAnalyticsExecutor().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(17345);
        Object localObject2 = AppEventsLogger.getUserID();
        if ((localObject2 == null) || (((String)localObject2).isEmpty()))
        {
          Logger.log(LoggingBehavior.APP_EVENTS, AppEventsLogger.TAG, "AppEventsLogger userID cannot be null or empty");
          AppMethodBeat.o(17345);
          return;
        }
        Object localObject1 = new Bundle();
        ((Bundle)localObject1).putString("user_unique_id", (String)localObject2);
        ((Bundle)localObject1).putBundle("custom_data", this.val$parameters);
        localObject2 = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
        if ((localObject2 != null) && (((AttributionIdentifiers)localObject2).getAndroidAdvertiserId() != null)) {
          ((Bundle)localObject1).putString("advertiser_id", ((AttributionIdentifiers)localObject2).getAndroidAdvertiserId());
        }
        localObject2 = new Bundle();
        try
        {
          localObject1 = BundleJSONConverter.convertToJSON((Bundle)localObject1);
          JSONArray localJSONArray = new JSONArray();
          localJSONArray.put(localObject1);
          ((Bundle)localObject2).putString("data", localJSONArray.toString());
          localObject1 = new GraphRequest(AccessToken.getCurrentAccessToken(), String.format(Locale.US, "%s/user_properties", new Object[] { paramString }), (Bundle)localObject2, HttpMethod.POST, paramCallback);
          ((GraphRequest)localObject1).setSkipClientToken(true);
          ((GraphRequest)localObject1).executeAsync();
          AppMethodBeat.o(17345);
          return;
        }
        catch (JSONException localJSONException)
        {
          FacebookException localFacebookException = new FacebookException("Failed to construct request", localJSONException);
          AppMethodBeat.o(17345);
          throw localFacebookException;
        }
      }
    });
    AppMethodBeat.o(17402);
  }
  
  public void flush()
  {
    AppMethodBeat.i(17389);
    AppEventQueue.flush(FlushReason.EXPLICIT);
    AppMethodBeat.o(17389);
  }
  
  public String getApplicationId()
  {
    AppMethodBeat.i(17404);
    String str = this.accessTokenAppId.getApplicationId();
    AppMethodBeat.o(17404);
    return str;
  }
  
  public boolean isValidForAccessToken(AccessToken paramAccessToken)
  {
    AppMethodBeat.i(17391);
    paramAccessToken = new AccessTokenAppIdPair(paramAccessToken);
    boolean bool = this.accessTokenAppId.equals(paramAccessToken);
    AppMethodBeat.o(17391);
    return bool;
  }
  
  public void logEvent(String paramString)
  {
    AppMethodBeat.i(17377);
    logEvent(paramString, null);
    AppMethodBeat.o(17377);
  }
  
  public void logEvent(String paramString, double paramDouble)
  {
    AppMethodBeat.i(17378);
    logEvent(paramString, paramDouble, null);
    AppMethodBeat.o(17378);
  }
  
  public void logEvent(String paramString, double paramDouble, Bundle paramBundle)
  {
    AppMethodBeat.i(17380);
    logEvent(paramString, Double.valueOf(paramDouble), paramBundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
    AppMethodBeat.o(17380);
  }
  
  public void logEvent(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(17379);
    logEvent(paramString, null, paramBundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
    AppMethodBeat.o(17379);
  }
  
  protected void logEventImplicitly(String paramString, BigDecimal paramBigDecimal, Currency paramCurrency, Bundle paramBundle)
  {
    AppMethodBeat.i(17408);
    logEvent(paramString, Double.valueOf(paramBigDecimal.doubleValue()), paramBundle, true, ActivityLifecycleTracker.getCurrentSessionGuid());
    AppMethodBeat.o(17408);
  }
  
  public void logProductItem(String paramString1, AppEventsLogger.ProductAvailability paramProductAvailability, AppEventsLogger.ProductCondition paramProductCondition, String paramString2, String paramString3, String paramString4, String paramString5, BigDecimal paramBigDecimal, Currency paramCurrency, String paramString6, String paramString7, String paramString8, Bundle paramBundle)
  {
    AppMethodBeat.i(17388);
    if (paramString1 == null)
    {
      notifyDeveloperError("itemID cannot be null");
      AppMethodBeat.o(17388);
      return;
    }
    if (paramProductAvailability == null)
    {
      notifyDeveloperError("availability cannot be null");
      AppMethodBeat.o(17388);
      return;
    }
    if (paramProductCondition == null)
    {
      notifyDeveloperError("condition cannot be null");
      AppMethodBeat.o(17388);
      return;
    }
    if (paramString2 == null)
    {
      notifyDeveloperError("description cannot be null");
      AppMethodBeat.o(17388);
      return;
    }
    if (paramString3 == null)
    {
      notifyDeveloperError("imageLink cannot be null");
      AppMethodBeat.o(17388);
      return;
    }
    if (paramString4 == null)
    {
      notifyDeveloperError("link cannot be null");
      AppMethodBeat.o(17388);
      return;
    }
    if (paramString5 == null)
    {
      notifyDeveloperError("title cannot be null");
      AppMethodBeat.o(17388);
      return;
    }
    if (paramBigDecimal == null)
    {
      notifyDeveloperError("priceAmount cannot be null");
      AppMethodBeat.o(17388);
      return;
    }
    if (paramCurrency == null)
    {
      notifyDeveloperError("currency cannot be null");
      AppMethodBeat.o(17388);
      return;
    }
    if ((paramString6 == null) && (paramString7 == null) && (paramString8 == null))
    {
      notifyDeveloperError("Either gtin, mpn or brand is required");
      AppMethodBeat.o(17388);
      return;
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("fb_product_item_id", paramString1);
    localBundle.putString("fb_product_availability", paramProductAvailability.name());
    localBundle.putString("fb_product_condition", paramProductCondition.name());
    localBundle.putString("fb_product_description", paramString2);
    localBundle.putString("fb_product_image_link", paramString3);
    localBundle.putString("fb_product_link", paramString4);
    localBundle.putString("fb_product_title", paramString5);
    localBundle.putString("fb_product_price_amount", paramBigDecimal.setScale(3, 4).toString());
    localBundle.putString("fb_product_price_currency", paramCurrency.getCurrencyCode());
    if (paramString6 != null) {
      localBundle.putString("fb_product_gtin", paramString6);
    }
    if (paramString7 != null) {
      localBundle.putString("fb_product_mpn", paramString7);
    }
    if (paramString8 != null) {
      localBundle.putString("fb_product_brand", paramString8);
    }
    logEvent("fb_mobile_catalog_update", localBundle);
    eagerFlush();
    AppMethodBeat.o(17388);
  }
  
  public void logPurchase(BigDecimal paramBigDecimal, Currency paramCurrency)
  {
    AppMethodBeat.i(17381);
    AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled();
    logPurchase(paramBigDecimal, paramCurrency, null, false);
    AppMethodBeat.o(17381);
  }
  
  public void logPurchase(BigDecimal paramBigDecimal, Currency paramCurrency, Bundle paramBundle)
  {
    AppMethodBeat.i(17382);
    AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled();
    logPurchase(paramBigDecimal, paramCurrency, paramBundle, false);
    AppMethodBeat.o(17382);
  }
  
  @Deprecated
  public void logPurchaseImplicitly(BigDecimal paramBigDecimal, Currency paramCurrency, Bundle paramBundle)
  {
    AppMethodBeat.i(17383);
    if (AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled())
    {
      new StringBuilder().append("Function logPurchaseImplicitly() is deprecated and your purchase events cannot be logged with this function. ").append("Auto-logging of in-app purchase has been enabled in the SDK, so you don't have to manually log purchases");
      AppMethodBeat.o(17383);
      return;
    }
    new StringBuilder().append("Function logPurchaseImplicitly() is deprecated and your purchase events cannot be logged with this function. ").append("Please use logPurchase() function instead.");
    AppMethodBeat.o(17383);
  }
  
  protected void logPurchaseImplicitlyInternal(BigDecimal paramBigDecimal, Currency paramCurrency, Bundle paramBundle)
  {
    AppMethodBeat.i(17384);
    logPurchase(paramBigDecimal, paramCurrency, paramBundle, true);
    AppMethodBeat.o(17384);
  }
  
  public void logPushNotificationOpen(Bundle paramBundle)
  {
    AppMethodBeat.i(17386);
    logPushNotificationOpen(paramBundle, null);
    AppMethodBeat.o(17386);
  }
  
  public void logPushNotificationOpen(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(17387);
    localBundle = null;
    try
    {
      paramBundle = paramBundle.getString("fb_push_payload");
      boolean bool = Utility.isNullOrEmpty(paramBundle);
      if (bool)
      {
        AppMethodBeat.o(17387);
        return;
      }
      paramBundle = new JSONObject(paramBundle).getString("campaign");
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        paramBundle = localBundle;
      }
    }
    if (paramBundle == null)
    {
      Logger.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "Malformed payload specified for logging a push notification open.");
      AppMethodBeat.o(17387);
      return;
    }
    localBundle = new Bundle();
    localBundle.putString("fb_push_campaign", paramBundle);
    if (paramString != null) {
      localBundle.putString("fb_push_action", paramString);
    }
    logEvent("fb_mobile_push_opened", localBundle);
    AppMethodBeat.o(17387);
  }
  
  public void logSdkEvent(String paramString, Double paramDouble, Bundle paramBundle)
  {
    AppMethodBeat.i(17403);
    logEvent(paramString, paramDouble, paramBundle, true, ActivityLifecycleTracker.getCurrentSessionGuid());
    AppMethodBeat.o(17403);
  }
  
  static class PersistedAppSessionInfo
  {
    private static final String PERSISTED_SESSION_INFO_FILENAME = "AppEventsLogger.persistedsessioninfo";
    private static final Runnable appSessionInfoFlushRunnable;
    private static Map<AccessTokenAppIdPair, FacebookTimeSpentData> appSessionInfoMap;
    private static boolean hasChanges;
    private static boolean isLoaded;
    private static final Object staticLock;
    
    static
    {
      AppMethodBeat.i(17357);
      staticLock = new Object();
      hasChanges = false;
      isLoaded = false;
      appSessionInfoFlushRunnable = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(17350);
          AppEventsLogger.PersistedAppSessionInfo.saveAppSessionInformation(FacebookSdk.getApplicationContext());
          AppMethodBeat.o(17350);
        }
      };
      AppMethodBeat.o(17357);
    }
    
    private static FacebookTimeSpentData getTimeSpentData(Context paramContext, AccessTokenAppIdPair paramAccessTokenAppIdPair)
    {
      AppMethodBeat.i(17355);
      restoreAppSessionInformation(paramContext);
      FacebookTimeSpentData localFacebookTimeSpentData = (FacebookTimeSpentData)appSessionInfoMap.get(paramAccessTokenAppIdPair);
      paramContext = localFacebookTimeSpentData;
      if (localFacebookTimeSpentData == null)
      {
        paramContext = new FacebookTimeSpentData();
        appSessionInfoMap.put(paramAccessTokenAppIdPair, paramContext);
      }
      AppMethodBeat.o(17355);
      return paramContext;
    }
    
    static void onResume(Context paramContext, AccessTokenAppIdPair paramAccessTokenAppIdPair, AppEventsLogger paramAppEventsLogger, long paramLong, String paramString)
    {
      AppMethodBeat.i(17353);
      synchronized (staticLock)
      {
        getTimeSpentData(paramContext, paramAccessTokenAppIdPair).onResume(paramAppEventsLogger, paramLong, paramString);
        onTimeSpentDataUpdate();
        AppMethodBeat.o(17353);
        return;
      }
    }
    
    static void onSuspend(Context paramContext, AccessTokenAppIdPair paramAccessTokenAppIdPair, AppEventsLogger paramAppEventsLogger, long paramLong)
    {
      AppMethodBeat.i(17354);
      synchronized (staticLock)
      {
        getTimeSpentData(paramContext, paramAccessTokenAppIdPair).onSuspend(paramAppEventsLogger, paramLong);
        onTimeSpentDataUpdate();
        AppMethodBeat.o(17354);
        return;
      }
    }
    
    private static void onTimeSpentDataUpdate()
    {
      AppMethodBeat.i(17356);
      if (!hasChanges)
      {
        hasChanges = true;
        AppEventsLogger.backgroundExecutor.schedule(appSessionInfoFlushRunnable, 30L, TimeUnit.SECONDS);
      }
      AppMethodBeat.o(17356);
    }
    
    /* Error */
    private static void restoreAppSessionInformation(Context paramContext)
    {
      // Byte code:
      //   0: sipush 17351
      //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aconst_null
      //   7: astore_3
      //   8: getstatic 36	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:staticLock	Ljava/lang/Object;
      //   11: astore 4
      //   13: aload 4
      //   15: monitorenter
      //   16: getstatic 40	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
      //   19: istore_1
      //   20: iload_1
      //   21: ifne +72 -> 93
      //   24: new 107	java/io/ObjectInputStream
      //   27: dup
      //   28: aload_0
      //   29: ldc 13
      //   31: invokevirtual 113	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
      //   34: invokespecial 116	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
      //   37: astore_2
      //   38: aload_2
      //   39: invokevirtual 120	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
      //   42: checkcast 122	java/util/HashMap
      //   45: putstatic 55	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
      //   48: getstatic 128	com/facebook/LoggingBehavior:APP_EVENTS	Lcom/facebook/LoggingBehavior;
      //   51: ldc 130
      //   53: ldc 132
      //   55: invokestatic 138	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
      //   58: aload_2
      //   59: invokestatic 144	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
      //   62: aload_0
      //   63: ldc 13
      //   65: invokevirtual 148	android/content/Context:deleteFile	(Ljava/lang/String;)Z
      //   68: pop
      //   69: getstatic 55	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
      //   72: ifnonnull +13 -> 85
      //   75: new 122	java/util/HashMap
      //   78: dup
      //   79: invokespecial 149	java/util/HashMap:<init>	()V
      //   82: putstatic 55	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
      //   85: iconst_1
      //   86: putstatic 40	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
      //   89: iconst_0
      //   90: putstatic 38	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
      //   93: aload 4
      //   95: monitorexit
      //   96: sipush 17351
      //   99: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   102: return
      //   103: astore_2
      //   104: aload_3
      //   105: astore_2
      //   106: aload_2
      //   107: invokestatic 144	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
      //   110: aload_0
      //   111: ldc 13
      //   113: invokevirtual 148	android/content/Context:deleteFile	(Ljava/lang/String;)Z
      //   116: pop
      //   117: getstatic 55	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
      //   120: ifnonnull +13 -> 133
      //   123: new 122	java/util/HashMap
      //   126: dup
      //   127: invokespecial 149	java/util/HashMap:<init>	()V
      //   130: putstatic 55	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
      //   133: iconst_1
      //   134: putstatic 40	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
      //   137: iconst_0
      //   138: putstatic 38	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
      //   141: goto -48 -> 93
      //   144: astore_0
      //   145: aload 4
      //   147: monitorexit
      //   148: sipush 17351
      //   151: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   154: aload_0
      //   155: athrow
      //   156: astore_3
      //   157: aconst_null
      //   158: astore_2
      //   159: invokestatic 153	com/facebook/appevents/AppEventsLogger:access$200	()Ljava/lang/String;
      //   162: pop
      //   163: new 155	java/lang/StringBuilder
      //   166: dup
      //   167: ldc 157
      //   169: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   172: aload_3
      //   173: invokevirtual 163	java/lang/Exception:toString	()Ljava/lang/String;
      //   176: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   179: pop
      //   180: aload_2
      //   181: invokestatic 144	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
      //   184: aload_0
      //   185: ldc 13
      //   187: invokevirtual 148	android/content/Context:deleteFile	(Ljava/lang/String;)Z
      //   190: pop
      //   191: getstatic 55	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
      //   194: ifnonnull +13 -> 207
      //   197: new 122	java/util/HashMap
      //   200: dup
      //   201: invokespecial 149	java/util/HashMap:<init>	()V
      //   204: putstatic 55	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
      //   207: iconst_1
      //   208: putstatic 40	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
      //   211: iconst_0
      //   212: putstatic 38	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
      //   215: goto -122 -> 93
      //   218: aload_2
      //   219: invokestatic 144	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
      //   222: aload_0
      //   223: ldc 13
      //   225: invokevirtual 148	android/content/Context:deleteFile	(Ljava/lang/String;)Z
      //   228: pop
      //   229: getstatic 55	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
      //   232: ifnonnull +13 -> 245
      //   235: new 122	java/util/HashMap
      //   238: dup
      //   239: invokespecial 149	java/util/HashMap:<init>	()V
      //   242: putstatic 55	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
      //   245: iconst_1
      //   246: putstatic 40	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
      //   249: iconst_0
      //   250: putstatic 38	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
      //   253: sipush 17351
      //   256: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   259: aload_3
      //   260: athrow
      //   261: astore_3
      //   262: goto -44 -> 218
      //   265: astore_3
      //   266: goto -48 -> 218
      //   269: astore_3
      //   270: goto -111 -> 159
      //   273: astore_3
      //   274: goto -168 -> 106
      //   277: astore_3
      //   278: aconst_null
      //   279: astore_2
      //   280: goto -62 -> 218
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	283	0	paramContext	Context
      //   19	2	1	bool	boolean
      //   37	22	2	localObjectInputStream	java.io.ObjectInputStream
      //   103	1	2	localFileNotFoundException1	java.io.FileNotFoundException
      //   105	175	2	localObject1	Object
      //   7	98	3	localObject2	Object
      //   156	104	3	localException1	java.lang.Exception
      //   261	1	3	localObject3	Object
      //   265	1	3	localObject4	Object
      //   269	1	3	localException2	java.lang.Exception
      //   273	1	3	localFileNotFoundException2	java.io.FileNotFoundException
      //   277	1	3	localObject5	Object
      //   11	135	4	localObject6	Object
      // Exception table:
      //   from	to	target	type
      //   24	38	103	java/io/FileNotFoundException
      //   16	20	144	finally
      //   58	85	144	finally
      //   85	93	144	finally
      //   93	96	144	finally
      //   106	133	144	finally
      //   133	141	144	finally
      //   145	148	144	finally
      //   180	207	144	finally
      //   207	215	144	finally
      //   218	245	144	finally
      //   245	261	144	finally
      //   24	38	156	java/lang/Exception
      //   38	58	261	finally
      //   159	180	265	finally
      //   38	58	269	java/lang/Exception
      //   38	58	273	java/io/FileNotFoundException
      //   24	38	277	finally
    }
    
    /* Error */
    static void saveAppSessionInformation(Context paramContext)
    {
      // Byte code:
      //   0: sipush 17352
      //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: getstatic 36	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:staticLock	Ljava/lang/Object;
      //   9: astore 4
      //   11: aload 4
      //   13: monitorenter
      //   14: getstatic 38	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
      //   17: istore_1
      //   18: iload_1
      //   19: ifeq +56 -> 75
      //   22: new 170	java/io/ObjectOutputStream
      //   25: dup
      //   26: new 172	java/io/BufferedOutputStream
      //   29: dup
      //   30: aload_0
      //   31: ldc 13
      //   33: iconst_0
      //   34: invokevirtual 176	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
      //   37: invokespecial 179	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   40: invokespecial 180	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   43: astore_2
      //   44: aload_2
      //   45: astore_0
      //   46: aload_2
      //   47: getstatic 55	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
      //   50: invokevirtual 184	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
      //   53: aload_2
      //   54: astore_0
      //   55: iconst_0
      //   56: putstatic 38	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
      //   59: aload_2
      //   60: astore_0
      //   61: getstatic 128	com/facebook/LoggingBehavior:APP_EVENTS	Lcom/facebook/LoggingBehavior;
      //   64: ldc 130
      //   66: ldc 186
      //   68: invokestatic 138	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
      //   71: aload_2
      //   72: invokestatic 144	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
      //   75: aload 4
      //   77: monitorexit
      //   78: sipush 17352
      //   81: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   84: return
      //   85: astore_3
      //   86: aconst_null
      //   87: astore_2
      //   88: aload_2
      //   89: astore_0
      //   90: invokestatic 153	com/facebook/appevents/AppEventsLogger:access$200	()Ljava/lang/String;
      //   93: pop
      //   94: aload_2
      //   95: astore_0
      //   96: new 155	java/lang/StringBuilder
      //   99: dup
      //   100: ldc 188
      //   102: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   105: aload_3
      //   106: invokevirtual 163	java/lang/Exception:toString	()Ljava/lang/String;
      //   109: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   112: pop
      //   113: aload_2
      //   114: invokestatic 144	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
      //   117: goto -42 -> 75
      //   120: astore_0
      //   121: aload 4
      //   123: monitorexit
      //   124: sipush 17352
      //   127: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   130: aload_0
      //   131: athrow
      //   132: astore_2
      //   133: aconst_null
      //   134: astore_0
      //   135: aload_0
      //   136: invokestatic 144	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
      //   139: sipush 17352
      //   142: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   145: aload_2
      //   146: athrow
      //   147: astore_2
      //   148: goto -13 -> 135
      //   151: astore_3
      //   152: goto -64 -> 88
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	155	0	paramContext	Context
      //   17	2	1	bool	boolean
      //   43	71	2	localObjectOutputStream	java.io.ObjectOutputStream
      //   132	14	2	localObject1	Object
      //   147	1	2	localObject2	Object
      //   85	21	3	localException1	java.lang.Exception
      //   151	1	3	localException2	java.lang.Exception
      //   9	113	4	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   22	44	85	java/lang/Exception
      //   14	18	120	finally
      //   71	75	120	finally
      //   75	78	120	finally
      //   113	117	120	finally
      //   121	124	120	finally
      //   135	147	120	finally
      //   22	44	132	finally
      //   46	53	147	finally
      //   55	59	147	finally
      //   61	71	147	finally
      //   90	94	147	finally
      //   96	113	147	finally
      //   46	53	151	java/lang/Exception
      //   55	59	151	java/lang/Exception
      //   61	71	151	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.appevents.AppEventsLogger
 * JD-Core Version:    0.7.0.1
 */