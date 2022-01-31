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
import com.facebook.GraphRequest.Callback;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
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
    AppMethodBeat.i(71983);
    TAG = AppEventsLogger.class.getCanonicalName();
    flushBehavior = AppEventsLogger.FlushBehavior.AUTO;
    staticLock = new Object();
    AppMethodBeat.o(71983);
  }
  
  private AppEventsLogger(Context paramContext, String paramString, AccessToken paramAccessToken)
  {
    this(Utility.getActivityName(paramContext), paramString, paramAccessToken);
    AppMethodBeat.i(71969);
    AppMethodBeat.o(71969);
  }
  
  protected AppEventsLogger(String paramString1, String paramString2, AccessToken paramAccessToken)
  {
    AppMethodBeat.i(71970);
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
      AppMethodBeat.o(71970);
      return;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = Utility.getMetadataApplicationId(FacebookSdk.getApplicationContext());
      }
    }
  }
  
  public static void activateApp(Application paramApplication)
  {
    AppMethodBeat.i(71928);
    activateApp(paramApplication, null);
    AppMethodBeat.o(71928);
  }
  
  public static void activateApp(Application paramApplication, String paramString)
  {
    AppMethodBeat.i(71929);
    if (!FacebookSdk.isInitialized())
    {
      paramApplication = new FacebookException("The Facebook sdk must be initialized before calling activateApp");
      AppMethodBeat.o(71929);
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
    AppMethodBeat.o(71929);
  }
  
  @Deprecated
  public static void activateApp(Context paramContext)
  {
    AppMethodBeat.i(71930);
    if (ActivityLifecycleTracker.isTracking())
    {
      AppMethodBeat.o(71930);
      return;
    }
    FacebookSdk.sdkInitialize(paramContext);
    activateApp(paramContext, Utility.getMetadataApplicationId(paramContext));
    AppMethodBeat.o(71930);
  }
  
  @Deprecated
  public static void activateApp(Context paramContext, String paramString)
  {
    AppMethodBeat.i(71931);
    if (ActivityLifecycleTracker.isTracking())
    {
      AppMethodBeat.o(71931);
      return;
    }
    if ((paramContext == null) || (paramString == null))
    {
      paramContext = new IllegalArgumentException("Both context and applicationId must be non-null");
      AppMethodBeat.o(71931);
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
      long l = System.currentTimeMillis();
      paramString = getSourceApplication();
      backgroundExecutor.execute(new AppEventsLogger.1(paramContext, l, paramString));
      AppMethodBeat.o(71931);
      return;
      resetSourceApplication();
      Utility.logd(AppEventsLogger.class.getName(), "To set source application the context of activateApp must be an instance of Activity");
    }
  }
  
  public static void augmentWebView(WebView paramWebView, Context paramContext)
  {
    int j = 0;
    AppMethodBeat.i(71957);
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
      AppMethodBeat.o(71957);
      return;
    }
    paramWebView.addJavascriptInterface(new FacebookSDKJSInterface(paramContext), "fbmq_" + FacebookSdk.getApplicationId());
    AppMethodBeat.o(71957);
  }
  
  public static void clearUserData()
  {
    AppMethodBeat.i(71964);
    UserDataStore.setUserDataAndHash(null);
    AppMethodBeat.o(71964);
  }
  
  public static void clearUserID()
  {
    AppMethodBeat.i(71960);
    AnalyticsUserIDStore.setUserID(null);
    AppMethodBeat.o(71960);
  }
  
  @Deprecated
  public static void deactivateApp(Context paramContext)
  {
    AppMethodBeat.i(71932);
    if (ActivityLifecycleTracker.isTracking())
    {
      AppMethodBeat.o(71932);
      return;
    }
    deactivateApp(paramContext, Utility.getMetadataApplicationId(paramContext));
    AppMethodBeat.o(71932);
  }
  
  @Deprecated
  public static void deactivateApp(Context paramContext, String paramString)
  {
    AppMethodBeat.i(71933);
    if (ActivityLifecycleTracker.isTracking())
    {
      AppMethodBeat.o(71933);
      return;
    }
    if ((paramContext == null) || (paramString == null))
    {
      paramContext = new IllegalArgumentException("Both context and applicationId must be non-null");
      AppMethodBeat.o(71933);
      throw paramContext;
    }
    resetSourceApplication();
    paramContext = new AppEventsLogger(paramContext, paramString, null);
    long l = System.currentTimeMillis();
    backgroundExecutor.execute(new AppEventsLogger.2(paramContext, l));
    AppMethodBeat.o(71933);
  }
  
  static void eagerFlush()
  {
    AppMethodBeat.i(71975);
    if (getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
      AppEventQueue.flush(FlushReason.EAGER_FLUSHING_EVENT);
    }
    AppMethodBeat.o(71975);
  }
  
  static Executor getAnalyticsExecutor()
  {
    AppMethodBeat.i(71979);
    if (backgroundExecutor == null) {
      initializeTimersIfNeeded();
    }
    ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = backgroundExecutor;
    AppMethodBeat.o(71979);
    return localScheduledThreadPoolExecutor;
  }
  
  public static String getAnonymousAppDeviceGUID(Context paramContext)
  {
    AppMethodBeat.i(71980);
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
      AppMethodBeat.o(71980);
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
    AppMethodBeat.i(71978);
    String str = "Unclassified";
    if (isOpenedByAppLink) {
      str = "Applink";
    }
    if (sourceApplication != null)
    {
      str = str + "(" + sourceApplication + ")";
      AppMethodBeat.o(71978);
      return str;
    }
    AppMethodBeat.o(71978);
    return str;
  }
  
  public static String getUserData()
  {
    AppMethodBeat.i(71963);
    String str = UserDataStore.getHashedUserData();
    AppMethodBeat.o(71963);
    return str;
  }
  
  public static String getUserID()
  {
    AppMethodBeat.i(71959);
    String str = AnalyticsUserIDStore.getUserID();
    AppMethodBeat.o(71959);
    return str;
  }
  
  public static void initializeLib(Context paramContext, String paramString)
  {
    AppMethodBeat.i(71936);
    if (!FacebookSdk.getAutoLogAppEventsEnabled())
    {
      AppMethodBeat.o(71936);
      return;
    }
    paramContext = new AppEventsLogger(paramContext, paramString, null);
    backgroundExecutor.execute(new AppEventsLogger.3(paramContext));
    AppMethodBeat.o(71936);
  }
  
  private static void initializeTimersIfNeeded()
  {
    AppMethodBeat.i(71971);
    synchronized (staticLock)
    {
      if (backgroundExecutor != null)
      {
        AppMethodBeat.o(71971);
        return;
      }
      backgroundExecutor = new ScheduledThreadPoolExecutor(1);
      ??? = new AppEventsLogger.5();
      backgroundExecutor.scheduleAtFixedRate((Runnable)???, 0L, 86400L, TimeUnit.SECONDS);
      AppMethodBeat.o(71971);
      return;
    }
  }
  
  private void logAppSessionResumeEvent(long paramLong, String paramString)
  {
    AppMethodBeat.i(71934);
    AppEventsLogger.PersistedAppSessionInfo.onResume(FacebookSdk.getApplicationContext(), this.accessTokenAppId, this, paramLong, paramString);
    AppMethodBeat.o(71934);
  }
  
  private void logAppSessionSuspendEvent(long paramLong)
  {
    AppMethodBeat.i(71935);
    AppEventsLogger.PersistedAppSessionInfo.onSuspend(FacebookSdk.getApplicationContext(), this.accessTokenAppId, this, paramLong);
    AppMethodBeat.o(71935);
  }
  
  private static void logEvent(AppEvent paramAppEvent, AccessTokenAppIdPair paramAccessTokenAppIdPair)
  {
    AppMethodBeat.i(71974);
    AppEventQueue.add(paramAccessTokenAppIdPair, paramAppEvent);
    if ((!paramAppEvent.getIsImplicit()) && (!isActivateAppEventRequested))
    {
      if (paramAppEvent.getName().equals("fb_mobile_activate_app"))
      {
        isActivateAppEventRequested = true;
        AppMethodBeat.o(71974);
        return;
      }
      Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
    }
    AppMethodBeat.o(71974);
  }
  
  private void logEvent(String paramString, Double paramDouble, Bundle paramBundle, boolean paramBoolean, UUID paramUUID)
  {
    AppMethodBeat.i(71973);
    try
    {
      logEvent(new AppEvent(this.contextName, paramString, paramDouble, paramBundle, paramBoolean, paramUUID), this.accessTokenAppId);
      AppMethodBeat.o(71973);
      return;
    }
    catch (JSONException paramString)
    {
      Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", new Object[] { paramString.toString() });
      AppMethodBeat.o(71973);
      return;
    }
    catch (FacebookException paramString)
    {
      Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Invalid app event: %s", new Object[] { paramString.toString() });
      AppMethodBeat.o(71973);
    }
  }
  
  private void logPurchase(BigDecimal paramBigDecimal, Currency paramCurrency, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(71949);
    if (paramBigDecimal == null)
    {
      notifyDeveloperError("purchaseAmount cannot be null");
      AppMethodBeat.o(71949);
      return;
    }
    if (paramCurrency == null)
    {
      notifyDeveloperError("currency cannot be null");
      AppMethodBeat.o(71949);
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
      AppMethodBeat.o(71949);
      return;
    }
  }
  
  public static AppEventsLogger newLogger(Context paramContext)
  {
    AppMethodBeat.i(71937);
    paramContext = new AppEventsLogger(paramContext, null, null);
    AppMethodBeat.o(71937);
    return paramContext;
  }
  
  public static AppEventsLogger newLogger(Context paramContext, AccessToken paramAccessToken)
  {
    AppMethodBeat.i(71938);
    paramContext = new AppEventsLogger(paramContext, null, paramAccessToken);
    AppMethodBeat.o(71938);
    return paramContext;
  }
  
  public static AppEventsLogger newLogger(Context paramContext, String paramString)
  {
    AppMethodBeat.i(71940);
    paramContext = new AppEventsLogger(paramContext, paramString, null);
    AppMethodBeat.o(71940);
    return paramContext;
  }
  
  public static AppEventsLogger newLogger(Context paramContext, String paramString, AccessToken paramAccessToken)
  {
    AppMethodBeat.i(71939);
    paramContext = new AppEventsLogger(paramContext, paramString, paramAccessToken);
    AppMethodBeat.o(71939);
    return paramContext;
  }
  
  private static void notifyDeveloperError(String paramString)
  {
    AppMethodBeat.i(71976);
    Logger.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", paramString);
    AppMethodBeat.o(71976);
  }
  
  public static void onContextStop()
  {
    AppMethodBeat.i(71954);
    AppEventQueue.persistToDisk();
    AppMethodBeat.o(71954);
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
    AppMethodBeat.i(71956);
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
      AppMethodBeat.o(71956);
      return;
    }
  }
  
  private static void setSourceApplication(Activity paramActivity)
  {
    AppMethodBeat.i(71977);
    Object localObject = paramActivity.getCallingActivity();
    if (localObject != null)
    {
      localObject = ((ComponentName)localObject).getPackageName();
      if (((String)localObject).equals(paramActivity.getPackageName()))
      {
        resetSourceApplication();
        AppMethodBeat.o(71977);
        return;
      }
      sourceApplication = (String)localObject;
    }
    paramActivity = paramActivity.getIntent();
    if ((paramActivity == null) || (paramActivity.getBooleanExtra("_fbSourceApplicationHasBeenSet", false)))
    {
      resetSourceApplication();
      AppMethodBeat.o(71977);
      return;
    }
    localObject = paramActivity.getBundleExtra("al_applink_data");
    if (localObject == null)
    {
      resetSourceApplication();
      AppMethodBeat.o(71977);
      return;
    }
    isOpenedByAppLink = true;
    localObject = ((Bundle)localObject).getBundle("referer_app_link");
    if (localObject == null)
    {
      sourceApplication = null;
      AppMethodBeat.o(71977);
      return;
    }
    sourceApplication = ((Bundle)localObject).getString("package");
    paramActivity.putExtra("_fbSourceApplicationHasBeenSet", true);
    AppMethodBeat.o(71977);
  }
  
  static void setSourceApplication(String paramString, boolean paramBoolean)
  {
    sourceApplication = paramString;
    isOpenedByAppLink = paramBoolean;
  }
  
  @Deprecated
  public static void setUserData(Bundle paramBundle)
  {
    AppMethodBeat.i(71961);
    UserDataStore.setUserDataAndHash(paramBundle);
    AppMethodBeat.o(71961);
  }
  
  public static void setUserData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    AppMethodBeat.i(71962);
    UserDataStore.setUserDataAndHash(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10);
    AppMethodBeat.o(71962);
  }
  
  public static void setUserID(String paramString)
  {
    AppMethodBeat.i(71958);
    AnalyticsUserIDStore.setUserID(paramString);
    AppMethodBeat.o(71958);
  }
  
  public static void updateUserProperties(Bundle paramBundle, GraphRequest.Callback paramCallback)
  {
    AppMethodBeat.i(71965);
    updateUserProperties(paramBundle, FacebookSdk.getApplicationId(), paramCallback);
    AppMethodBeat.o(71965);
  }
  
  public static void updateUserProperties(Bundle paramBundle, String paramString, GraphRequest.Callback paramCallback)
  {
    AppMethodBeat.i(71966);
    getAnalyticsExecutor().execute(new AppEventsLogger.4(paramBundle, paramString, paramCallback));
    AppMethodBeat.o(71966);
  }
  
  public void flush()
  {
    AppMethodBeat.i(71953);
    AppEventQueue.flush(FlushReason.EXPLICIT);
    AppMethodBeat.o(71953);
  }
  
  public String getApplicationId()
  {
    AppMethodBeat.i(71968);
    String str = this.accessTokenAppId.getApplicationId();
    AppMethodBeat.o(71968);
    return str;
  }
  
  public boolean isValidForAccessToken(AccessToken paramAccessToken)
  {
    AppMethodBeat.i(71955);
    paramAccessToken = new AccessTokenAppIdPair(paramAccessToken);
    boolean bool = this.accessTokenAppId.equals(paramAccessToken);
    AppMethodBeat.o(71955);
    return bool;
  }
  
  public void logEvent(String paramString)
  {
    AppMethodBeat.i(71941);
    logEvent(paramString, null);
    AppMethodBeat.o(71941);
  }
  
  public void logEvent(String paramString, double paramDouble)
  {
    AppMethodBeat.i(71942);
    logEvent(paramString, paramDouble, null);
    AppMethodBeat.o(71942);
  }
  
  public void logEvent(String paramString, double paramDouble, Bundle paramBundle)
  {
    AppMethodBeat.i(71944);
    logEvent(paramString, Double.valueOf(paramDouble), paramBundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
    AppMethodBeat.o(71944);
  }
  
  public void logEvent(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(71943);
    logEvent(paramString, null, paramBundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
    AppMethodBeat.o(71943);
  }
  
  protected void logEventImplicitly(String paramString, BigDecimal paramBigDecimal, Currency paramCurrency, Bundle paramBundle)
  {
    AppMethodBeat.i(71972);
    logEvent(paramString, Double.valueOf(paramBigDecimal.doubleValue()), paramBundle, true, ActivityLifecycleTracker.getCurrentSessionGuid());
    AppMethodBeat.o(71972);
  }
  
  public void logProductItem(String paramString1, AppEventsLogger.ProductAvailability paramProductAvailability, AppEventsLogger.ProductCondition paramProductCondition, String paramString2, String paramString3, String paramString4, String paramString5, BigDecimal paramBigDecimal, Currency paramCurrency, String paramString6, String paramString7, String paramString8, Bundle paramBundle)
  {
    AppMethodBeat.i(71952);
    if (paramString1 == null)
    {
      notifyDeveloperError("itemID cannot be null");
      AppMethodBeat.o(71952);
      return;
    }
    if (paramProductAvailability == null)
    {
      notifyDeveloperError("availability cannot be null");
      AppMethodBeat.o(71952);
      return;
    }
    if (paramProductCondition == null)
    {
      notifyDeveloperError("condition cannot be null");
      AppMethodBeat.o(71952);
      return;
    }
    if (paramString2 == null)
    {
      notifyDeveloperError("description cannot be null");
      AppMethodBeat.o(71952);
      return;
    }
    if (paramString3 == null)
    {
      notifyDeveloperError("imageLink cannot be null");
      AppMethodBeat.o(71952);
      return;
    }
    if (paramString4 == null)
    {
      notifyDeveloperError("link cannot be null");
      AppMethodBeat.o(71952);
      return;
    }
    if (paramString5 == null)
    {
      notifyDeveloperError("title cannot be null");
      AppMethodBeat.o(71952);
      return;
    }
    if (paramBigDecimal == null)
    {
      notifyDeveloperError("priceAmount cannot be null");
      AppMethodBeat.o(71952);
      return;
    }
    if (paramCurrency == null)
    {
      notifyDeveloperError("currency cannot be null");
      AppMethodBeat.o(71952);
      return;
    }
    if ((paramString6 == null) && (paramString7 == null) && (paramString8 == null))
    {
      notifyDeveloperError("Either gtin, mpn or brand is required");
      AppMethodBeat.o(71952);
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
    AppMethodBeat.o(71952);
  }
  
  public void logPurchase(BigDecimal paramBigDecimal, Currency paramCurrency)
  {
    AppMethodBeat.i(71945);
    AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled();
    logPurchase(paramBigDecimal, paramCurrency, null, false);
    AppMethodBeat.o(71945);
  }
  
  public void logPurchase(BigDecimal paramBigDecimal, Currency paramCurrency, Bundle paramBundle)
  {
    AppMethodBeat.i(71946);
    AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled();
    logPurchase(paramBigDecimal, paramCurrency, paramBundle, false);
    AppMethodBeat.o(71946);
  }
  
  @Deprecated
  public void logPurchaseImplicitly(BigDecimal paramBigDecimal, Currency paramCurrency, Bundle paramBundle)
  {
    AppMethodBeat.i(71947);
    if (AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled())
    {
      new StringBuilder().append("Function logPurchaseImplicitly() is deprecated and your purchase events cannot be logged with this function. ").append("Auto-logging of in-app purchase has been enabled in the SDK, so you don't have to manually log purchases");
      AppMethodBeat.o(71947);
      return;
    }
    new StringBuilder().append("Function logPurchaseImplicitly() is deprecated and your purchase events cannot be logged with this function. ").append("Please use logPurchase() function instead.");
    AppMethodBeat.o(71947);
  }
  
  protected void logPurchaseImplicitlyInternal(BigDecimal paramBigDecimal, Currency paramCurrency, Bundle paramBundle)
  {
    AppMethodBeat.i(71948);
    logPurchase(paramBigDecimal, paramCurrency, paramBundle, true);
    AppMethodBeat.o(71948);
  }
  
  public void logPushNotificationOpen(Bundle paramBundle)
  {
    AppMethodBeat.i(71950);
    logPushNotificationOpen(paramBundle, null);
    AppMethodBeat.o(71950);
  }
  
  public void logPushNotificationOpen(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(71951);
    localBundle = null;
    try
    {
      paramBundle = paramBundle.getString("fb_push_payload");
      boolean bool = Utility.isNullOrEmpty(paramBundle);
      if (bool)
      {
        AppMethodBeat.o(71951);
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
      AppMethodBeat.o(71951);
      return;
    }
    localBundle = new Bundle();
    localBundle.putString("fb_push_campaign", paramBundle);
    if (paramString != null) {
      localBundle.putString("fb_push_action", paramString);
    }
    logEvent("fb_mobile_push_opened", localBundle);
    AppMethodBeat.o(71951);
  }
  
  public void logSdkEvent(String paramString, Double paramDouble, Bundle paramBundle)
  {
    AppMethodBeat.i(71967);
    logEvent(paramString, paramDouble, paramBundle, true, ActivityLifecycleTracker.getCurrentSessionGuid());
    AppMethodBeat.o(71967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.appevents.AppEventsLogger
 * JD-Core Version:    0.7.0.1
 */