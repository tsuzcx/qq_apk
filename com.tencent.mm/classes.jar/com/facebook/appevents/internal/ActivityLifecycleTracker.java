package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.facebook.appevents.codeless.ViewIndexer;
import com.facebook.appevents.codeless.ViewIndexingTrigger;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

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
    AppMethodBeat.i(72159);
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
    AppMethodBeat.o(72159);
  }
  
  private static void cancelCurrentTask()
  {
    AppMethodBeat.i(72153);
    synchronized (currentFutureLock)
    {
      if (currentFuture != null) {
        currentFuture.cancel(false);
      }
      currentFuture = null;
      AppMethodBeat.o(72153);
      return;
    }
  }
  
  public static void checkCodelessSession(String paramString)
  {
    AppMethodBeat.i(72154);
    if (isCheckingSession.booleanValue())
    {
      AppMethodBeat.o(72154);
      return;
    }
    isCheckingSession = Boolean.TRUE;
    FacebookSdk.getExecutor().execute(new ActivityLifecycleTracker.6(paramString));
    AppMethodBeat.o(72154);
  }
  
  public static String getCurrentDeviceSessionID()
  {
    AppMethodBeat.i(72155);
    if (deviceSessionID == null) {
      deviceSessionID = UUID.randomUUID().toString();
    }
    String str = deviceSessionID;
    AppMethodBeat.o(72155);
    return str;
  }
  
  public static UUID getCurrentSessionGuid()
  {
    AppMethodBeat.i(72148);
    if (currentSession != null)
    {
      UUID localUUID = currentSession.getSessionId();
      AppMethodBeat.o(72148);
      return localUUID;
    }
    AppMethodBeat.o(72148);
    return null;
  }
  
  public static boolean getIsAppIndexingEnabled()
  {
    AppMethodBeat.i(72156);
    boolean bool = isAppIndexingEnabled.booleanValue();
    AppMethodBeat.o(72156);
    return bool;
  }
  
  private static int getSessionTimeoutInSeconds()
  {
    AppMethodBeat.i(72152);
    FetchedAppSettings localFetchedAppSettings = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
    if (localFetchedAppSettings == null)
    {
      i = Constants.getDefaultAppEventsSessionTimeoutInSeconds();
      AppMethodBeat.o(72152);
      return i;
    }
    int i = localFetchedAppSettings.getSessionTimeoutInSeconds();
    AppMethodBeat.o(72152);
    return i;
  }
  
  public static boolean isTracking()
  {
    AppMethodBeat.i(72147);
    boolean bool = tracking.get();
    AppMethodBeat.o(72147);
    return bool;
  }
  
  public static void onActivityCreated(Activity paramActivity)
  {
    AppMethodBeat.i(72149);
    System.currentTimeMillis();
    paramActivity.getApplicationContext();
    Utility.getActivityName(paramActivity);
    SourceApplicationInfo.Factory.create(paramActivity);
    paramActivity = new ActivityLifecycleTracker.2();
    singleThreadExecutor.execute(paramActivity);
    AppMethodBeat.o(72149);
  }
  
  private static void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(72151);
    if (foregroundActivityCount.decrementAndGet() < 0) {
      foregroundActivityCount.set(0);
    }
    cancelCurrentTask();
    long l = System.currentTimeMillis();
    String str = Utility.getActivityName(paramActivity);
    codelessMatcher.remove(paramActivity);
    paramActivity = new ActivityLifecycleTracker.5(l, str);
    singleThreadExecutor.execute(paramActivity);
    if (viewIndexer != null) {
      viewIndexer.unschedule();
    }
    if (sensorManager != null) {
      sensorManager.unregisterListener(viewIndexingTrigger);
    }
    AppMethodBeat.o(72151);
  }
  
  public static void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(72150);
    foregroundActivityCount.incrementAndGet();
    cancelCurrentTask();
    long l = System.currentTimeMillis();
    currentActivityAppearTime = l;
    Object localObject1 = Utility.getActivityName(paramActivity);
    codelessMatcher.add(paramActivity);
    localObject1 = new ActivityLifecycleTracker.3(l, (String)localObject1);
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
        AppMethodBeat.o(72150);
        return;
      }
      localObject2 = sensorManager.getDefaultSensor(1);
      viewIndexer = new ViewIndexer(paramActivity);
      viewIndexingTrigger.setOnShakeListener(new ActivityLifecycleTracker.4(localFetchedAppSettings, (String)localObject1));
      sensorManager.registerListener(viewIndexingTrigger, (Sensor)localObject2, 2);
      if ((localFetchedAppSettings != null) && (localFetchedAppSettings.getCodelessEventsEnabled())) {
        viewIndexer.schedule();
      }
    }
    AppMethodBeat.o(72150);
  }
  
  public static void startTracking(Application paramApplication, String paramString)
  {
    AppMethodBeat.i(72146);
    if (!tracking.compareAndSet(false, true))
    {
      AppMethodBeat.o(72146);
      return;
    }
    appId = paramString;
    paramApplication.registerActivityLifecycleCallbacks(new ActivityLifecycleTracker.1());
    AppMethodBeat.o(72146);
  }
  
  public static void updateAppIndexing(Boolean paramBoolean)
  {
    isAppIndexingEnabled = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.appevents.internal.ActivityLifecycleTracker
 * JD-Core Version:    0.7.0.1
 */