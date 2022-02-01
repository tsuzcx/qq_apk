package com.facebook.appevents.codeless;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.codeless.internal.UnityReflection;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewIndexer
{
  private static final String APP_VERSION_PARAM = "app_version";
  private static final String PLATFORM_PARAM = "platform";
  private static final String REQUEST_TYPE = "request_type";
  private static final String SUCCESS = "success";
  private static final String TAG;
  private static final String TREE_PARAM = "tree";
  private WeakReference<Activity> activityReference;
  private Timer indexingTimer;
  private String previousDigest;
  private final Handler uiThreadHandler;
  
  static
  {
    AppMethodBeat.i(17525);
    TAG = ViewIndexer.class.getCanonicalName();
    AppMethodBeat.o(17525);
  }
  
  public ViewIndexer(Activity paramActivity)
  {
    AppMethodBeat.i(17518);
    this.activityReference = new WeakReference(paramActivity);
    this.previousDigest = null;
    this.uiThreadHandler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(17518);
  }
  
  public static GraphRequest buildAppIndexingRequest(String paramString1, AccessToken paramAccessToken, String paramString2, String paramString3)
  {
    AppMethodBeat.i(17523);
    if (paramString1 == null)
    {
      AppMethodBeat.o(17523);
      return null;
    }
    GraphRequest localGraphRequest = GraphRequest.newPostRequest(paramAccessToken, String.format(Locale.US, "%s/app_indexing", new Object[] { paramString2 }), null, null);
    paramString2 = localGraphRequest.getParameters();
    paramAccessToken = paramString2;
    if (paramString2 == null) {
      paramAccessToken = new Bundle();
    }
    paramAccessToken.putString("tree", paramString1);
    paramAccessToken.putString("app_version", AppEventUtility.getAppVersion());
    paramAccessToken.putString("platform", "android");
    paramAccessToken.putString("request_type", paramString3);
    if (paramString3.equals("app_indexing")) {
      paramAccessToken.putString("device_session_id", ActivityLifecycleTracker.getCurrentDeviceSessionID());
    }
    localGraphRequest.setParameters(paramAccessToken);
    localGraphRequest.setCallback(new GraphRequest.Callback()
    {
      public final void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        AppMethodBeat.i(17514);
        Logger.log(LoggingBehavior.APP_EVENTS, ViewIndexer.TAG, "App index sent to FB!");
        AppMethodBeat.o(17514);
      }
    });
    AppMethodBeat.o(17523);
    return localGraphRequest;
  }
  
  private void sendToServer(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(17522);
    FacebookSdk.getExecutor().execute(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(17513);
        Object localObject1 = FacebookSdk.getApplicationId();
        String str = Utility.md5hash(paramString1);
        Object localObject2 = AccessToken.getCurrentAccessToken();
        if ((str != null) && (str.equals(ViewIndexer.this.previousDigest)))
        {
          AppMethodBeat.o(17513);
          return;
        }
        localObject1 = ViewIndexer.buildAppIndexingRequest(paramString1, (AccessToken)localObject2, (String)localObject1, "app_indexing");
        if (localObject1 != null)
        {
          localObject1 = ((GraphRequest)localObject1).executeAndWait();
          try
          {
            localObject2 = ((GraphResponse)localObject1).getJSONObject();
            if (localObject2 == null) {
              break label157;
            }
            if ((((JSONObject)localObject2).has("success")) && (((JSONObject)localObject2).getString("success") == "true"))
            {
              Logger.log(LoggingBehavior.APP_EVENTS, ViewIndexer.TAG, "Successfully send UI component tree to server");
              ViewIndexer.access$402(ViewIndexer.this, str);
            }
            if (!((JSONObject)localObject2).has("is_app_indexing_enabled")) {
              break label178;
            }
            ActivityLifecycleTracker.updateAppIndexing(Boolean.valueOf(((JSONObject)localObject2).getBoolean("is_app_indexing_enabled")));
            AppMethodBeat.o(17513);
            return;
          }
          catch (JSONException localJSONException) {}
        }
        else
        {
          AppMethodBeat.o(17513);
          return;
        }
        label157:
        new StringBuilder("Error sending UI component tree to Facebook: ").append(((GraphResponse)localObject1).getError());
        label178:
        AppMethodBeat.o(17513);
      }
    });
    AppMethodBeat.o(17522);
  }
  
  public void schedule()
  {
    AppMethodBeat.i(17519);
    Object localObject = (Activity)this.activityReference.get();
    if (localObject == null)
    {
      AppMethodBeat.o(17519);
      return;
    }
    final String str = localObject.getClass().getSimpleName();
    FacebookSdk.getApplicationId();
    localObject = new TimerTask()
    {
      public void run()
      {
        AppMethodBeat.i(17511);
        try
        {
          View localView = this.val$activity.getWindow().getDecorView().getRootView();
          boolean bool = ActivityLifecycleTracker.getIsAppIndexingEnabled();
          if (!bool)
          {
            AppMethodBeat.o(17511);
            return;
          }
          if (InternalSettings.isUnityApp())
          {
            UnityReflection.captureViewHierarchy();
            AppMethodBeat.o(17511);
            return;
          }
          Object localObject = new FutureTask(new ViewIndexer.ScreenshotTaker(localView));
          ViewIndexer.this.uiThreadHandler.post((Runnable)localObject);
          try
          {
            localObject = (String)((FutureTask)localObject).get(1L, TimeUnit.SECONDS);
            localJSONObject = new JSONObject();
          }
          catch (Exception localException1)
          {
            try
            {
              JSONObject localJSONObject;
              localJSONObject.put("screenname", str);
              localJSONObject.put("screenshot", localObject);
              localObject = new JSONArray();
              ((JSONArray)localObject).put(ViewHierarchy.getDictionaryOfView(localView));
              localJSONObject.put("view", localObject);
              label147:
              localObject = localJSONObject.toString();
              ViewIndexer.access$200(ViewIndexer.this, (String)localObject, str);
              AppMethodBeat.o(17511);
              return;
              localException1 = localException1;
              String str = "";
            }
            catch (JSONException localJSONException)
            {
              break label147;
            }
          }
          return;
        }
        catch (Exception localException2)
        {
          AppMethodBeat.o(17511);
        }
      }
    };
    FacebookSdk.getExecutor().execute(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(17512);
        try
        {
          if (ViewIndexer.this.indexingTimer != null) {
            ViewIndexer.this.indexingTimer.cancel();
          }
          ViewIndexer.access$402(ViewIndexer.this, null);
          ViewIndexer.access$302(ViewIndexer.this, new Timer());
          ViewIndexer.this.indexingTimer.scheduleAtFixedRate(this.val$indexingTask, 0L, 1000L);
          AppMethodBeat.o(17512);
          return;
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(17512);
        }
      }
    });
    AppMethodBeat.o(17519);
  }
  
  public void sendToServerUnity(String paramString)
  {
    AppMethodBeat.i(17521);
    Object localObject = (Activity)this.activityReference.get();
    if (localObject != null) {}
    for (localObject = localObject.getClass().getSimpleName();; localObject = "")
    {
      sendToServer(paramString, (String)localObject);
      AppMethodBeat.o(17521);
      return;
    }
  }
  
  public void unschedule()
  {
    AppMethodBeat.i(17520);
    if ((Activity)this.activityReference.get() == null)
    {
      AppMethodBeat.o(17520);
      return;
    }
    if (this.indexingTimer != null) {
      try
      {
        this.indexingTimer.cancel();
        this.indexingTimer = null;
        AppMethodBeat.o(17520);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(17520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.appevents.codeless.ViewIndexer
 * JD-Core Version:    0.7.0.1
 */