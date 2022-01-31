package com.facebook.appevents.codeless;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import com.facebook.appevents.codeless.internal.UnityReflection;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.internal.InternalSettings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.TimerTask;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ViewIndexer$1
  extends TimerTask
{
  ViewIndexer$1(ViewIndexer paramViewIndexer, Activity paramActivity, String paramString) {}
  
  public void run()
  {
    AppMethodBeat.i(72075);
    try
    {
      View localView = this.val$activity.getWindow().getDecorView().getRootView();
      boolean bool = ActivityLifecycleTracker.getIsAppIndexingEnabled();
      if (!bool)
      {
        AppMethodBeat.o(72075);
        return;
      }
      if (InternalSettings.isUnityApp())
      {
        UnityReflection.captureViewHierarchy();
        AppMethodBeat.o(72075);
        return;
      }
      Object localObject = new FutureTask(new ViewIndexer.ScreenshotTaker(localView));
      ViewIndexer.access$000(this.this$0).post((Runnable)localObject);
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
          localJSONObject.put("screenname", this.val$activityName);
          localJSONObject.put("screenshot", localObject);
          localObject = new JSONArray();
          ((JSONArray)localObject).put(ViewHierarchy.getDictionaryOfView(localView));
          localJSONObject.put("view", localObject);
          localObject = localJSONObject.toString();
          ViewIndexer.access$200(this.this$0, (String)localObject, this.val$activityName);
          AppMethodBeat.o(72075);
          return;
          localException1 = localException1;
          ViewIndexer.access$100();
          String str = "";
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ViewIndexer.access$100();
          }
        }
      }
      return;
    }
    catch (Exception localException2)
    {
      ViewIndexer.access$100();
      AppMethodBeat.o(72075);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.appevents.codeless.ViewIndexer.1
 * JD-Core Version:    0.7.0.1
 */