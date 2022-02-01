package com.facebook.appevents.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.appevents.internal.SourceApplicationInfo
 * JD-Core Version:    0.7.0.1
 */