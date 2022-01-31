package com.google.android.gms.gcm;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.x.c;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

class zza
{
  static zza zzbgq;
  private final Context mContext;
  
  private zza(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }
  
  static boolean zzE(Bundle paramBundle)
  {
    return ("1".equals(zzf(paramBundle, "gcm.n.e"))) || (zzf(paramBundle, "gcm.n.icon") != null);
  }
  
  static void zzF(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      String str3 = paramBundle.getString(str2);
      str1 = str2;
      if (str2.startsWith("gcm.notification.")) {
        str1 = str2.replace("gcm.notification.", "gcm.n.");
      }
      if (str1.startsWith("gcm.n."))
      {
        if (!"gcm.n.e".equals(str1)) {
          localBundle.putString(str1.substring(6), str3);
        }
        localIterator.remove();
      }
    }
    String str1 = localBundle.getString("sound2");
    if (str1 != null)
    {
      localBundle.remove("sound2");
      localBundle.putString("sound", str1);
    }
    if (!localBundle.isEmpty()) {
      paramBundle.putBundle("notification", localBundle);
    }
  }
  
  private int zzGP()
  {
    return (int)SystemClock.uptimeMillis();
  }
  
  private Notification zzH(Bundle paramBundle)
  {
    String str1 = zzg(paramBundle, "gcm.n.title");
    String str2 = zzg(paramBundle, "gcm.n.body");
    int i = zzeB(zzf(paramBundle, "gcm.n.icon"));
    String str3 = zzf(paramBundle, "gcm.n.color");
    Uri localUri = zzeC(zzf(paramBundle, "gcm.n.sound2"));
    paramBundle = zzI(paramBundle);
    x.c localc = new x.c(this.mContext, (byte)0).z(true).ah(i);
    if (!TextUtils.isEmpty(str1)) {
      localc.c(str1);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str2)) {
        localc.d(str2);
      }
      if (!TextUtils.isEmpty(str3)) {
        localc.mColor = Color.parseColor(str3);
      }
      if (localUri != null) {
        localc.b(localUri);
      }
      if (paramBundle != null) {
        localc.xz = paramBundle;
      }
      return localc.build();
      localc.c(this.mContext.getApplicationInfo().loadLabel(this.mContext.getPackageManager()));
    }
  }
  
  private PendingIntent zzI(Bundle paramBundle)
  {
    Object localObject = zzf(paramBundle, "gcm.n.click_action");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new Intent((String)localObject);
      ((Intent)localObject).setPackage(this.mContext.getPackageName());
      ((Intent)localObject).setFlags(268435456);
    }
    label155:
    for (;;)
    {
      paramBundle = new Bundle(paramBundle);
      GcmListenerService.zzD(paramBundle);
      ((Intent)localObject).putExtras(paramBundle);
      paramBundle = paramBundle.keySet().iterator();
      while (paramBundle.hasNext())
      {
        String str = (String)paramBundle.next();
        if ((str.startsWith("gcm.n.")) || (str.startsWith("gcm.notification.")))
        {
          ((Intent)localObject).removeExtra(str);
          continue;
          localObject = this.mContext.getPackageManager().getLaunchIntentForPackage(this.mContext.getPackageName());
          if (localObject != null) {
            break label155;
          }
          return null;
        }
      }
      return PendingIntent.getActivity(this.mContext, zzGP(), (Intent)localObject, 1073741824);
    }
  }
  
  private void zza(String paramString, Notification paramNotification)
  {
    Log.isLoggable("GcmNotification", 3);
    NotificationManager localNotificationManager = (NotificationManager)this.mContext.getSystemService("notification");
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      long l = SystemClock.uptimeMillis();
      str = 37 + "GCM-Notification:" + l;
    }
    localNotificationManager.notify(str, 0, paramNotification);
  }
  
  static zza zzbt(Context paramContext)
  {
    try
    {
      if (zzbgq == null) {
        zzbgq = new zza(paramContext);
      }
      paramContext = zzbgq;
      return paramContext;
    }
    finally {}
  }
  
  static boolean zzbu(Context paramContext)
  {
    if (((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
      return false;
    }
    int i = Process.myPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == i) {
          return localRunningAppProcessInfo.importance == 100;
        }
      }
    }
    return false;
  }
  
  private String zzeA(String paramString)
  {
    return paramString.substring(6);
  }
  
  private int zzeB(String paramString)
  {
    Resources localResources;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      localResources = this.mContext.getResources();
      i = localResources.getIdentifier(paramString, "drawable", this.mContext.getPackageName());
      if (i == 0) {}
    }
    int j;
    do
    {
      do
      {
        return i;
        j = localResources.getIdentifier(paramString, "mipmap", this.mContext.getPackageName());
        i = j;
      } while (j != 0);
      new StringBuilder(String.valueOf(paramString).length() + 57).append("Icon resource ").append(paramString).append(" not found. Notification will use app icon.");
      j = this.mContext.getApplicationInfo().icon;
      i = j;
    } while (j != 0);
    return 17301651;
  }
  
  private Uri zzeC(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ((!"default".equals(paramString)) && (this.mContext.getResources().getIdentifier(paramString, "raw", this.mContext.getPackageName()) != 0))
    {
      String str1 = String.valueOf("android.resource://");
      String str2 = String.valueOf(this.mContext.getPackageName());
      return Uri.parse(String.valueOf(str1).length() + 5 + String.valueOf(str2).length() + String.valueOf(paramString).length() + str1 + str2 + "/raw/" + paramString);
    }
    return RingtoneManager.getDefaultUri(2);
  }
  
  static String zzf(Bundle paramBundle, String paramString)
  {
    String str2 = paramBundle.getString(paramString);
    String str1 = str2;
    if (str2 == null) {
      str1 = paramBundle.getString(paramString.replace("gcm.n.", "gcm.notification."));
    }
    return str1;
  }
  
  private String zzg(Bundle paramBundle, String paramString)
  {
    String str1 = zzf(paramBundle, paramString);
    if (!TextUtils.isEmpty(str1)) {
      return str1;
    }
    str1 = String.valueOf(paramString);
    String str2 = String.valueOf("_loc_key");
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1))
    {
      str2 = zzf(paramBundle, str1);
      if (!TextUtils.isEmpty(str2)) {
        break;
      }
      return null;
    }
    Resources localResources = this.mContext.getResources();
    int j = localResources.getIdentifier(str2, "string", this.mContext.getPackageName());
    if (j == 0)
    {
      paramBundle = String.valueOf(paramString);
      paramString = String.valueOf("_loc_key");
      if (paramString.length() != 0) {}
      for (paramBundle = paramBundle.concat(paramString);; paramBundle = new String(paramBundle))
      {
        paramBundle = String.valueOf(zzeA(paramBundle));
        new StringBuilder(String.valueOf(paramBundle).length() + 49 + String.valueOf(str2).length()).append(paramBundle).append(" resource not found: ").append(str2).append(" Default value will be used.");
        return null;
      }
    }
    str1 = String.valueOf(paramString);
    Object localObject = String.valueOf("_loc_args");
    if (((String)localObject).length() != 0) {}
    for (str1 = str1.concat((String)localObject);; str1 = new String(str1))
    {
      str1 = zzf(paramBundle, str1);
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
      return localResources.getString(j);
    }
    try
    {
      paramBundle = new JSONArray(str1);
      localObject = new String[paramBundle.length()];
      int i = 0;
      while (i < localObject.length)
      {
        localObject[i] = paramBundle.opt(i);
        i += 1;
      }
      paramBundle = localResources.getString(j, (Object[])localObject);
      return paramBundle;
    }
    catch (JSONException paramBundle)
    {
      paramBundle = String.valueOf(paramString);
      paramString = String.valueOf("_loc_args");
      if (paramString.length() != 0) {}
      for (paramBundle = paramBundle.concat(paramString);; paramBundle = new String(paramBundle))
      {
        paramBundle = String.valueOf(zzeA(paramBundle));
        new StringBuilder(String.valueOf(paramBundle).length() + 41 + String.valueOf(str1).length()).append("Malformed ").append(paramBundle).append(": ").append(str1).append("  Default value will be used.");
        return null;
      }
    }
    catch (MissingFormatArgumentException paramBundle)
    {
      for (;;)
      {
        new StringBuilder(String.valueOf(str2).length() + 58 + String.valueOf(str1).length()).append("Missing format argument for ").append(str2).append(": ").append(str1).append(" Default value will be used.");
      }
    }
  }
  
  boolean zzG(Bundle paramBundle)
  {
    Notification localNotification = zzH(paramBundle);
    zza(zzf(paramBundle, "gcm.n.tag"), localNotification);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.gcm.zza
 * JD-Core Version:    0.7.0.1
 */