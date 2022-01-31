package com.facebook.appevents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.d;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class AppEventQueue
{
  private static final int FLUSH_PERIOD_IN_SECONDS = 15;
  private static final int NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER = 100;
  private static final String TAG;
  private static volatile AppEventCollection appEventCollection;
  private static final Runnable flushRunnable;
  private static ScheduledFuture scheduledFuture;
  private static final ScheduledExecutorService singleThreadExecutor;
  
  static
  {
    AppMethodBeat.i(71899);
    TAG = AppEventQueue.class.getName();
    appEventCollection = new AppEventCollection();
    singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
    flushRunnable = new AppEventQueue.1();
    AppMethodBeat.o(71899);
  }
  
  public static void add(AccessTokenAppIdPair paramAccessTokenAppIdPair, AppEvent paramAppEvent)
  {
    AppMethodBeat.i(71892);
    singleThreadExecutor.execute(new AppEventQueue.4(paramAccessTokenAppIdPair, paramAppEvent));
    AppMethodBeat.o(71892);
  }
  
  private static GraphRequest buildRequestForSession(AccessTokenAppIdPair paramAccessTokenAppIdPair, SessionEventsState paramSessionEventsState, boolean paramBoolean, FlushStatistics paramFlushStatistics)
  {
    AppMethodBeat.i(71896);
    Object localObject1 = paramAccessTokenAppIdPair.getApplicationId();
    FetchedAppSettings localFetchedAppSettings = FetchedAppSettingsManager.queryAppSettings((String)localObject1, false);
    GraphRequest localGraphRequest = GraphRequest.newPostRequest(null, String.format("%s/activities", new Object[] { localObject1 }), null, null);
    Object localObject2 = localGraphRequest.getParameters();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    ((Bundle)localObject1).putString("access_token", paramAccessTokenAppIdPair.getAccessTokenString());
    localObject2 = AppEventsLogger.getPushNotificationsRegistrationId();
    if (localObject2 != null) {
      ((Bundle)localObject1).putString("device_token", (String)localObject2);
    }
    localGraphRequest.setParameters((Bundle)localObject1);
    if (localFetchedAppSettings != null) {}
    for (boolean bool = localFetchedAppSettings.supportsImplicitLogging();; bool = false)
    {
      int i = paramSessionEventsState.populateRequest(localGraphRequest, FacebookSdk.getApplicationContext(), bool, paramBoolean);
      if (i == 0)
      {
        AppMethodBeat.o(71896);
        return null;
      }
      paramFlushStatistics.numEvents = (i + paramFlushStatistics.numEvents);
      localGraphRequest.setCallback(new AppEventQueue.5(paramAccessTokenAppIdPair, localGraphRequest, paramSessionEventsState, paramFlushStatistics));
      AppMethodBeat.o(71896);
      return localGraphRequest;
    }
  }
  
  public static void flush(FlushReason paramFlushReason)
  {
    AppMethodBeat.i(71891);
    singleThreadExecutor.execute(new AppEventQueue.3(paramFlushReason));
    AppMethodBeat.o(71891);
  }
  
  static void flushAndWait(FlushReason paramFlushReason)
  {
    AppMethodBeat.i(71894);
    Object localObject = AppEventStore.readAndClearStore();
    appEventCollection.addPersistedEvents((PersistedEvents)localObject);
    try
    {
      paramFlushReason = sendEventsToServer(paramFlushReason, appEventCollection);
      if (paramFlushReason != null)
      {
        localObject = new Intent("com.facebook.sdk.APP_EVENTS_FLUSHED");
        ((Intent)localObject).putExtra("com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED", paramFlushReason.numEvents);
        ((Intent)localObject).putExtra("com.facebook.sdk.APP_EVENTS_FLUSH_RESULT", paramFlushReason.result);
        d.R(FacebookSdk.getApplicationContext()).c((Intent)localObject);
      }
      AppMethodBeat.o(71894);
      return;
    }
    catch (Exception paramFlushReason)
    {
      AppMethodBeat.o(71894);
    }
  }
  
  public static Set<AccessTokenAppIdPair> getKeySet()
  {
    AppMethodBeat.i(71893);
    Set localSet = appEventCollection.keySet();
    AppMethodBeat.o(71893);
    return localSet;
  }
  
  private static void handleResponse(AccessTokenAppIdPair paramAccessTokenAppIdPair, GraphRequest paramGraphRequest, GraphResponse paramGraphResponse, SessionEventsState paramSessionEventsState, FlushStatistics paramFlushStatistics)
  {
    AppMethodBeat.i(71897);
    FacebookRequestError localFacebookRequestError = paramGraphResponse.getError();
    String str1 = "Success";
    Object localObject = FlushResult.SUCCESS;
    if (localFacebookRequestError != null) {
      if (localFacebookRequestError.getErrorCode() == -1) {
        str1 = "Failed: No Connectivity";
      }
    }
    String str2;
    for (paramGraphResponse = FlushResult.NO_CONNECTIVITY;; paramGraphResponse = str2) {
      for (;;)
      {
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.APP_EVENTS)) {
          localObject = (String)paramGraphRequest.getTag();
        }
        try
        {
          localObject = new JSONArray((String)localObject).toString(2);
          Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", new Object[] { paramGraphRequest.getGraphObject().toString(), str1, localObject });
          if (localFacebookRequestError != null)
          {
            bool = true;
            paramSessionEventsState.clearInFlightAndStats(bool);
            if (paramGraphResponse == FlushResult.NO_CONNECTIVITY) {
              FacebookSdk.getExecutor().execute(new AppEventQueue.6(paramAccessTokenAppIdPair, paramSessionEventsState));
            }
            if ((paramGraphResponse != FlushResult.SUCCESS) && (paramFlushStatistics.result != FlushResult.NO_CONNECTIVITY)) {
              paramFlushStatistics.result = paramGraphResponse;
            }
            AppMethodBeat.o(71897);
            return;
            str1 = String.format("Failed:\n  Response: %s\n  Error %s", new Object[] { paramGraphResponse.toString(), localFacebookRequestError.toString() });
            paramGraphResponse = FlushResult.SERVER_ERROR;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            str2 = "<Can't encode events for debug logging>";
            continue;
            boolean bool = false;
          }
        }
      }
    }
  }
  
  public static void persistToDisk()
  {
    AppMethodBeat.i(71890);
    singleThreadExecutor.execute(new AppEventQueue.2());
    AppMethodBeat.o(71890);
  }
  
  private static FlushStatistics sendEventsToServer(FlushReason paramFlushReason, AppEventCollection paramAppEventCollection)
  {
    AppMethodBeat.i(71895);
    FlushStatistics localFlushStatistics = new FlushStatistics();
    boolean bool = FacebookSdk.getLimitEventAndDataUsage(FacebookSdk.getApplicationContext());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramAppEventCollection.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (AccessTokenAppIdPair)localIterator.next();
      localObject = buildRequestForSession((AccessTokenAppIdPair)localObject, paramAppEventCollection.get((AccessTokenAppIdPair)localObject), bool, localFlushStatistics);
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    if (localArrayList.size() > 0)
    {
      Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flushing %d events due to %s.", new Object[] { Integer.valueOf(localFlushStatistics.numEvents), paramFlushReason.toString() });
      paramFlushReason = localArrayList.iterator();
      while (paramFlushReason.hasNext()) {
        ((GraphRequest)paramFlushReason.next()).executeAndWait();
      }
      AppMethodBeat.o(71895);
      return localFlushStatistics;
    }
    AppMethodBeat.o(71895);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.appevents.AppEventQueue
 * JD-Core Version:    0.7.0.1
 */