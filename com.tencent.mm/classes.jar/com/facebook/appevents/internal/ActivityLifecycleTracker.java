package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.facebook.appevents.codeless.ViewIndexer;
import com.facebook.appevents.codeless.ViewIndexingTrigger;
import com.facebook.appevents.codeless.ViewIndexingTrigger.OnShakeListener;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

public class ActivityLifecycleTracker
{
  private static final String INCORRECT_IMPL_WARNING = "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method";
  private static final long INTERRUPTION_THRESHOLD_MILLISECONDS = 1000L;
  private static final String TAG;
  private static String appId;
  private static final CodelessMatcher codelessMatcher;
  private static long currentActivityAppearTime;
  private static volatile ScheduledFuture currentFuture;
  private static final Object currentFutureLock;
  private static volatile SessionInfo currentSession;
  private static String deviceSessionID;
  private static AtomicInteger foregroundActivityCount;
  private static Boolean isAppIndexingEnabled;
  private static volatile Boolean isCheckingSession;
  private static SensorManager sensorManager;
  private static final ScheduledExecutorService singleThreadExecutor;
  private static AtomicBoolean tracking;
  private static ViewIndexer viewIndexer;
  private static final ViewIndexingTrigger viewIndexingTrigger;
  
  static
  {
    AppMethodBeat.i(17595);
    TAG = ActivityLifecycleTracker.class.getCanonicalName();
    singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
    currentFutureLock = new Object();
    foregroundActivityCount = new AtomicInteger(0);
    tracking = new AtomicBoolean(false);
    codelessMatcher = new CodelessMatcher();
    viewIndexingTrigger = new ViewIndexingTrigger();
    deviceSessionID = null;
    isAppIndexingEnabled = Boolean.FALSE;
    isCheckingSession = Boolean.FALSE;
    AppMethodBeat.o(17595);
  }
  
  private static void cancelCurrentTask()
  {
    AppMethodBeat.i(17589);
    synchronized (currentFutureLock)
    {
      if (currentFuture != null) {
        currentFuture.cancel(false);
      }
      currentFuture = null;
      AppMethodBeat.o(17589);
      return;
    }
  }
  
  public static void checkCodelessSession(String paramString)
  {
    AppMethodBeat.i(17590);
    if (isCheckingSession.booleanValue())
    {
      AppMethodBeat.o(17590);
      return;
    }
    isCheckingSession = Boolean.TRUE;
    FacebookSdk.getExecutor().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(17581);
        GraphRequest localGraphRequest = GraphRequest.newPostRequest(null, String.format(Locale.US, "%s/app_indexing_session", new Object[] { this.val$applicationId }), null, null);
        Object localObject2 = localGraphRequest.getParameters();
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new Bundle();
        }
        AttributionIdentifiers localAttributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
        JSONArray localJSONArray = new JSONArray();
        label111:
        boolean bool;
        if (Build.MODEL != null)
        {
          localObject2 = Build.MODEL;
          localJSONArray.put(localObject2);
          if ((localAttributionIdentifiers == null) || (localAttributionIdentifiers.getAndroidAdvertiserId() == null)) {
            break label274;
          }
          localJSONArray.put(localAttributionIdentifiers.getAndroidAdvertiserId());
          localJSONArray.put("0");
          if (!AppEventUtility.isEmulator()) {
            break label285;
          }
          localObject2 = "1";
          label128:
          localJSONArray.put(localObject2);
          localObject2 = Utility.getCurrentLocale();
          localJSONArray.put(((Locale)localObject2).getLanguage() + "_" + ((Locale)localObject2).getCountry());
          localObject2 = localJSONArray.toString();
          ((Bundle)localObject1).putString("device_session_id", ActivityLifecycleTracker.getCurrentDeviceSessionID());
          ((Bundle)localObject1).putString("extinfo", (String)localObject2);
          localGraphRequest.setParameters((Bundle)localObject1);
          if (localGraphRequest != null)
          {
            localObject1 = localGraphRequest.executeAndWait().getJSONObject();
            if ((localObject1 == null) || (!((JSONObject)localObject1).optBoolean("is_app_indexing_enabled", false))) {
              break label291;
            }
            bool = true;
            label232:
            ActivityLifecycleTracker.access$1002(Boolean.valueOf(bool));
            if (ActivityLifecycleTracker.isAppIndexingEnabled.booleanValue()) {
              break label296;
            }
            ActivityLifecycleTracker.access$1102(null);
          }
        }
        for (;;)
        {
          ActivityLifecycleTracker.access$1302(Boolean.FALSE);
          AppMethodBeat.o(17581);
          return;
          localObject2 = "";
          break;
          label274:
          localJSONArray.put("");
          break label111;
          label285:
          localObject2 = "0";
          break label128;
          label291:
          bool = false;
          break label232;
          label296:
          ActivityLifecycleTracker.viewIndexer.schedule();
        }
      }
    });
    AppMethodBeat.o(17590);
  }
  
  public static String getCurrentDeviceSessionID()
  {
    AppMethodBeat.i(17591);
    if (deviceSessionID == null) {
      deviceSessionID = UUID.randomUUID().toString();
    }
    String str = deviceSessionID;
    AppMethodBeat.o(17591);
    return str;
  }
  
  public static UUID getCurrentSessionGuid()
  {
    AppMethodBeat.i(17584);
    if (currentSession != null)
    {
      UUID localUUID = currentSession.getSessionId();
      AppMethodBeat.o(17584);
      return localUUID;
    }
    AppMethodBeat.o(17584);
    return null;
  }
  
  public static boolean getIsAppIndexingEnabled()
  {
    AppMethodBeat.i(17592);
    boolean bool = isAppIndexingEnabled.booleanValue();
    AppMethodBeat.o(17592);
    return bool;
  }
  
  private static int getSessionTimeoutInSeconds()
  {
    AppMethodBeat.i(17588);
    FetchedAppSettings localFetchedAppSettings = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
    if (localFetchedAppSettings == null)
    {
      i = Constants.getDefaultAppEventsSessionTimeoutInSeconds();
      AppMethodBeat.o(17588);
      return i;
    }
    int i = localFetchedAppSettings.getSessionTimeoutInSeconds();
    AppMethodBeat.o(17588);
    return i;
  }
  
  public static boolean isTracking()
  {
    AppMethodBeat.i(17583);
    boolean bool = tracking.get();
    AppMethodBeat.o(17583);
    return bool;
  }
  
  public static void onActivityCreated(Activity paramActivity)
  {
    AppMethodBeat.i(17585);
    System.currentTimeMillis();
    paramActivity.getApplicationContext();
    Utility.getActivityName(paramActivity);
    SourceApplicationInfo.Factory.create(paramActivity);
    paramActivity = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(17576);
        if (ActivityLifecycleTracker.currentSession == null) {
          ActivityLifecycleTracker.access$202(SessionInfo.getStoredSessionInfo());
        }
        AppMethodBeat.o(17576);
      }
    };
    singleThreadExecutor.execute(paramActivity);
    AppMethodBeat.o(17585);
  }
  
  private static void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(17587);
    if (foregroundActivityCount.decrementAndGet() < 0) {
      foregroundActivityCount.set(0);
    }
    cancelCurrentTask();
    long l = System.currentTimeMillis();
    String str = Utility.getActivityName(paramActivity);
    codelessMatcher.remove(paramActivity);
    paramActivity = new Runnable()
    {
      public final void run()
      {
        long l1 = 0L;
        AppMethodBeat.i(17580);
        if (ActivityLifecycleTracker.currentSession == null) {
          ActivityLifecycleTracker.access$202(new SessionInfo(Long.valueOf(this.val$currentTime), null));
        }
        ActivityLifecycleTracker.currentSession.setSessionLastEventTime(Long.valueOf(this.val$currentTime));
        Runnable local1;
        if (ActivityLifecycleTracker.foregroundActivityCount.get() <= 0) {
          local1 = new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(17579);
              if (ActivityLifecycleTracker.foregroundActivityCount.get() <= 0)
              {
                SessionLogger.logDeactivateApp(ActivityLifecycleTracker.5.this.val$activityName, ActivityLifecycleTracker.currentSession, ActivityLifecycleTracker.appId);
                SessionInfo.clearSavedSessionFromDisk();
                ActivityLifecycleTracker.access$202(null);
              }
              synchronized (ActivityLifecycleTracker.currentFutureLock)
              {
                ActivityLifecycleTracker.access$702(null);
                AppMethodBeat.o(17579);
                return;
              }
            }
          };
        }
        synchronized (ActivityLifecycleTracker.currentFutureLock)
        {
          ActivityLifecycleTracker.access$702(ActivityLifecycleTracker.singleThreadExecutor.schedule(local1, ActivityLifecycleTracker.access$400(), TimeUnit.SECONDS));
          long l2 = ActivityLifecycleTracker.currentActivityAppearTime;
          if (l2 > 0L) {
            l1 = (this.val$currentTime - l2) / 1000L;
          }
          AutomaticAnalyticsLogger.logActivityTimeSpentEvent(this.val$activityName, l1);
          ActivityLifecycleTracker.currentSession.writeSessionToDisk();
          AppMethodBeat.o(17580);
          return;
        }
      }
    };
    singleThreadExecutor.execute(paramActivity);
    if (viewIndexer != null) {
      viewIndexer.unschedule();
    }
    if (sensorManager != null) {
      sensorManager.unregisterListener(viewIndexingTrigger);
    }
    AppMethodBeat.o(17587);
  }
  
  public static void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(17586);
    foregroundActivityCount.incrementAndGet();
    cancelCurrentTask();
    long l = System.currentTimeMillis();
    currentActivityAppearTime = l;
    Object localObject1 = Utility.getActivityName(paramActivity);
    codelessMatcher.add(paramActivity);
    localObject1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(17577);
        if (ActivityLifecycleTracker.currentSession == null)
        {
          ActivityLifecycleTracker.access$202(new SessionInfo(Long.valueOf(this.val$currentTime), null));
          SessionLogger.logActivateApp(this.val$activityName, null, ActivityLifecycleTracker.appId);
        }
        for (;;)
        {
          ActivityLifecycleTracker.currentSession.setSessionLastEventTime(Long.valueOf(this.val$currentTime));
          ActivityLifecycleTracker.currentSession.writeSessionToDisk();
          AppMethodBeat.o(17577);
          return;
          if (ActivityLifecycleTracker.currentSession.getSessionLastEventTime() != null)
          {
            long l = this.val$currentTime - ActivityLifecycleTracker.currentSession.getSessionLastEventTime().longValue();
            if (l > ActivityLifecycleTracker.access$400() * 1000)
            {
              SessionLogger.logDeactivateApp(this.val$activityName, ActivityLifecycleTracker.currentSession, ActivityLifecycleTracker.appId);
              SessionLogger.logActivateApp(this.val$activityName, null, ActivityLifecycleTracker.appId);
              ActivityLifecycleTracker.access$202(new SessionInfo(Long.valueOf(this.val$currentTime), null));
            }
            else if (l > 1000L)
            {
              ActivityLifecycleTracker.currentSession.incrementInterruptionCount();
            }
          }
        }
      }
    };
    singleThreadExecutor.execute((Runnable)localObject1);
    Object localObject2 = paramActivity.getApplicationContext();
    localObject1 = FacebookSdk.getApplicationId();
    FetchedAppSettings localFetchedAppSettings = FetchedAppSettingsManager.getAppSettingsWithoutQuery((String)localObject1);
    if ((localFetchedAppSettings != null) && (localFetchedAppSettings.getCodelessSetupEnabled()))
    {
      localObject2 = (SensorManager)((Context)localObject2).getSystemService("sensor");
      sensorManager = (SensorManager)localObject2;
      if (localObject2 == null)
      {
        AppMethodBeat.o(17586);
        return;
      }
      localObject2 = sensorManager.getDefaultSensor(1);
      viewIndexer = new ViewIndexer(paramActivity);
      viewIndexingTrigger.setOnShakeListener(new ViewIndexingTrigger.OnShakeListener()
      {
        public final void onShake()
        {
          AppMethodBeat.i(17578);
          if ((this.val$appSettings != null) && (this.val$appSettings.getCodelessEventsEnabled())) {
            ActivityLifecycleTracker.checkCodelessSession(this.val$appId);
          }
          AppMethodBeat.o(17578);
        }
      });
      sensorManager.registerListener(viewIndexingTrigger, (Sensor)localObject2, 2);
      if ((localFetchedAppSettings != null) && (localFetchedAppSettings.getCodelessEventsEnabled())) {
        viewIndexer.schedule();
      }
    }
    AppMethodBeat.o(17586);
  }
  
  public static void startTracking(Application paramApplication, String paramString)
  {
    AppMethodBeat.i(17582);
    if (!tracking.compareAndSet(false, true))
    {
      AppMethodBeat.o(17582);
      return;
    }
    appId = paramString;
    paramApplication.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks()
    {
      public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(17569);
        Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityCreated");
        AppEventUtility.assertIsMainThread();
        ActivityLifecycleTracker.onActivityCreated(paramAnonymousActivity);
        AppMethodBeat.o(17569);
      }
      
      public final void onActivityDestroyed(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(17575);
        Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityDestroyed");
        AppMethodBeat.o(17575);
      }
      
      public final void onActivityPaused(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(17572);
        Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityPaused");
        AppEventUtility.assertIsMainThread();
        ActivityLifecycleTracker.access$100(paramAnonymousActivity);
        AppMethodBeat.o(17572);
      }
      
      public final void onActivityResumed(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(17571);
        Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityResumed");
        AppEventUtility.assertIsMainThread();
        ActivityLifecycleTracker.onActivityResumed(paramAnonymousActivity);
        AppMethodBeat.o(17571);
      }
      
      public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(17574);
        Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivitySaveInstanceState");
        AppMethodBeat.o(17574);
      }
      
      public final void onActivityStarted(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(17570);
        Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityStarted");
        AppMethodBeat.o(17570);
      }
      
      public final void onActivityStopped(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(17573);
        Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityStopped");
        AppEventsLogger.onContextStop();
        AppMethodBeat.o(17573);
      }
    });
    AppMethodBeat.o(17582);
  }
  
  public static void updateAppIndexing(Boolean paramBoolean)
  {
    isAppIndexingEnabled = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.appevents.internal.ActivityLifecycleTracker
 * JD-Core Version:    0.7.0.1
 */