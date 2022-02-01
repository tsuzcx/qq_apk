package com.facebook.appevents.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;

class SourceApplicationInfo
{
  private static final String CALL_APPLICATION_PACKAGE_KEY = "com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage";
  private static final String OPENED_BY_APP_LINK_KEY = "com.facebook.appevents.SourceApplicationInfo.openedByApplink";
  private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";
  private String callingApplicationPackage;
  private boolean openedByAppLink;
  
  private SourceApplicationInfo(String paramString, boolean paramBoolean)
  {
    this.callingApplicationPackage = paramString;
    this.openedByAppLink = paramBoolean;
  }
  
  public static void clearSavedSourceApplicationInfoFromDisk()
  {
    AppMethodBeat.i(17662);
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
    localEditor.remove("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage");
    localEditor.remove("com.facebook.appevents.SourceApplicationInfo.openedByApplink");
    localEditor.apply();
    AppMethodBeat.o(17662);
  }
  
  public static SourceApplicationInfo getStoredSourceApplicatioInfo()
  {
    AppMethodBeat.i(17661);
    Object localObject = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
    if (!((SharedPreferences)localObject).contains("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage"))
    {
      AppMethodBeat.o(17661);
      return null;
    }
    localObject = new SourceApplicationInfo(((SharedPreferences)localObject).getString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", null), ((SharedPreferences)localObject).getBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", false));
    AppMethodBeat.o(17661);
    return localObject;
  }
  
  public String getCallingApplicationPackage()
  {
    return this.callingApplicationPackage;
  }
  
  public boolean isOpenedByAppLink()
  {
    return this.openedByAppLink;
  }
  
  public String toString()
  {
    AppMethodBeat.i(17663);
    String str = "Unclassified";
    if (this.openedByAppLink) {
      str = "Applink";
    }
    if (this.callingApplicationPackage != null)
    {
      str = str + "(" + this.callingApplicationPackage + ")";
      AppMethodBeat.o(17663);
      return str;
    }
    AppMethodBeat.o(17663);
    return str;
  }
  
  public void writeSourceApplicationInfoToDisk()
  {
    AppMethodBeat.i(17664);
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
    localEditor.putString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", this.callingApplicationPackage);
    localEditor.putBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", this.openedByAppLink);
    localEditor.apply();
    AppMethodBeat.o(17664);
  }
  
  public static class Factory
  {
    public static SourceApplicationInfo create(Activity paramActivity)
    {
      boolean bool2 = false;
      AppMethodBeat.i(17660);
      Object localObject1 = "";
      Object localObject2 = paramActivity.getCallingActivity();
      if (localObject2 != null)
      {
        localObject2 = ((ComponentName)localObject2).getPackageName();
        localObject1 = localObject2;
        if (((String)localObject2).equals(paramActivity.getPackageName()))
        {
          AppMethodBeat.o(17660);
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
              break label158;
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
        AppMethodBeat.o(17660);
        return paramActivity;
        label158:
        bool1 = true;
        paramActivity = (Activity)localObject1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.appevents.internal.SourceApplicationInfo
 * JD-Core Version:    0.7.0.1
 */