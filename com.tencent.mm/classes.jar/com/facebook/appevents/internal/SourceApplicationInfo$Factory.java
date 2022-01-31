package com.facebook.appevents.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SourceApplicationInfo$Factory
{
  public static SourceApplicationInfo create(Activity paramActivity)
  {
    boolean bool2 = false;
    AppMethodBeat.i(72224);
    Object localObject1 = "";
    Object localObject2 = paramActivity.getCallingActivity();
    if (localObject2 != null)
    {
      localObject2 = ((ComponentName)localObject2).getPackageName();
      localObject1 = localObject2;
      if (((String)localObject2).equals(paramActivity.getPackageName()))
      {
        AppMethodBeat.o(72224);
        return null;
      }
    }
    localObject2 = paramActivity.getIntent();
    paramActivity = (Activity)localObject1;
    boolean bool1 = bool2;
    if (localObject2 != null)
    {
      paramActivity = (Activity)localObject1;
      bool1 = bool2;
      if (!((Intent)localObject2).getBooleanExtra("_fbSourceApplicationHasBeenSet", false))
      {
        ((Intent)localObject2).putExtra("_fbSourceApplicationHasBeenSet", true);
        Bundle localBundle = ((Intent)localObject2).getBundleExtra("al_applink_data");
        paramActivity = (Activity)localObject1;
        bool1 = bool2;
        if (localBundle != null)
        {
          paramActivity = localBundle.getBundle("referer_app_link");
          if (paramActivity == null) {
            break label155;
          }
          paramActivity = paramActivity.getString("package");
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      ((Intent)localObject2).putExtra("_fbSourceApplicationHasBeenSet", true);
      paramActivity = new SourceApplicationInfo(paramActivity, bool1, null);
      AppMethodBeat.o(72224);
      return paramActivity;
      label155:
      bool1 = true;
      paramActivity = (Activity)localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.appevents.internal.SourceApplicationInfo.Factory
 * JD-Core Version:    0.7.0.1
 */