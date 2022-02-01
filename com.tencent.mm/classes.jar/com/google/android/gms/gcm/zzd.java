package com.google.android.gms.gcm;

import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.f.d;
import com.google.android.gms.common.util.PlatformVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.MissingFormatArgumentException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

final class zzd
{
  static zzd zzj;
  private final Context zzk;
  private String zzl;
  private final AtomicInteger zzm;
  
  private zzd(Context paramContext)
  {
    AppMethodBeat.i(3699);
    this.zzm = new AtomicInteger((int)SystemClock.elapsedRealtime());
    this.zzk = paramContext.getApplicationContext();
    AppMethodBeat.o(3699);
  }
  
  static zzd zzd(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(3697);
      if (zzj == null) {
        zzj = new zzd(paramContext);
      }
      paramContext = zzj;
      AppMethodBeat.o(3697);
      return paramContext;
    }
    finally {}
  }
  
  static String zzd(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(3698);
    String str2 = paramBundle.getString(paramString);
    String str1 = str2;
    if (str2 == null) {
      str1 = paramBundle.getString(paramString.replace("gcm.n.", "gcm.notification."));
    }
    AppMethodBeat.o(3698);
    return str1;
  }
  
  private final Bundle zze()
  {
    AppMethodBeat.i(3702);
    Object localObject = null;
    try
    {
      ApplicationInfo localApplicationInfo = this.zzk.getPackageManager().getApplicationInfo(this.zzk.getPackageName(), 128);
      localObject = localApplicationInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label31:
      break label31;
    }
    if ((localObject != null) && (((ApplicationInfo)localObject).metaData != null))
    {
      localObject = ((ApplicationInfo)localObject).metaData;
      AppMethodBeat.o(3702);
      return localObject;
    }
    localObject = Bundle.EMPTY;
    AppMethodBeat.o(3702);
    return localObject;
  }
  
  private final String zze(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(3701);
    String str1 = zzd(paramBundle, paramString);
    if (!TextUtils.isEmpty(str1))
    {
      AppMethodBeat.o(3701);
      return str1;
    }
    str1 = String.valueOf(paramString);
    String str2 = String.valueOf("_loc_key");
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1))
    {
      str2 = zzd(paramBundle, str1);
      if (!TextUtils.isEmpty(str2)) {
        break;
      }
      AppMethodBeat.o(3701);
      return null;
    }
    Resources localResources = this.zzk.getResources();
    int j = localResources.getIdentifier(str2, "string", this.zzk.getPackageName());
    if (j == 0)
    {
      paramBundle = String.valueOf(paramString);
      paramString = String.valueOf("_loc_key");
      if (paramString.length() != 0) {}
      for (paramBundle = paramBundle.concat(paramString);; paramBundle = new String(paramBundle))
      {
        paramBundle = paramBundle.substring(6);
        new StringBuilder(String.valueOf(paramBundle).length() + 49 + String.valueOf(str2).length()).append(paramBundle).append(" resource not found: ").append(str2).append(" Default value will be used.");
        AppMethodBeat.o(3701);
        return null;
      }
    }
    str1 = String.valueOf(paramString);
    Object localObject = String.valueOf("_loc_args");
    if (((String)localObject).length() != 0) {}
    for (str1 = str1.concat((String)localObject);; str1 = new String(str1))
    {
      str1 = zzd(paramBundle, str1);
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
      paramBundle = localResources.getString(j);
      AppMethodBeat.o(3701);
      return paramBundle;
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
      AppMethodBeat.o(3701);
      return paramBundle;
    }
    catch (JSONException paramBundle)
    {
      paramBundle = String.valueOf(paramString);
      paramString = String.valueOf("_loc_args");
      if (paramString.length() != 0) {}
      for (paramBundle = paramBundle.concat(paramString);; paramBundle = new String(paramBundle))
      {
        paramBundle = paramBundle.substring(6);
        new StringBuilder(String.valueOf(paramBundle).length() + 41 + String.valueOf(str1).length()).append("Malformed ").append(paramBundle).append(": ").append(str1).append("  Default value will be used.");
        AppMethodBeat.o(3701);
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
  
  final boolean zze(Bundle paramBundle)
  {
    Object localObject5 = null;
    AppMethodBeat.i(3700);
    Object localObject3 = zze(paramBundle, "gcm.n.title");
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject3 = this.zzk.getApplicationInfo().loadLabel(this.zzk.getPackageManager());
    }
    label774:
    for (;;)
    {
      String str1 = zze(paramBundle, "gcm.n.body");
      Object localObject1 = zzd(paramBundle, "gcm.n.icon");
      Object localObject2;
      int i;
      String str2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = this.zzk.getResources();
        i = ((Resources)localObject2).getIdentifier((String)localObject1, "drawable", this.zzk.getPackageName());
        if (i != 0)
        {
          str2 = zzd(paramBundle, "gcm.n.color");
          localObject1 = zzd(paramBundle, "gcm.n.sound2");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label344;
          }
          localObject2 = null;
          label127:
          localObject1 = zzd(paramBundle, "gcm.n.click_action");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label458;
          }
          localObject1 = new Intent((String)localObject1);
          ((Intent)localObject1).setPackage(this.zzk.getPackageName());
          ((Intent)localObject1).setFlags(268435456);
        }
      }
      label525:
      label1068:
      for (;;)
      {
        Object localObject4 = new Bundle(paramBundle);
        GcmListenerService.zzd((Bundle)localObject4);
        ((Intent)localObject1).putExtras((Bundle)localObject4);
        localObject4 = ((Bundle)localObject4).keySet().iterator();
        for (;;)
        {
          if (((Iterator)localObject4).hasNext())
          {
            String str3 = (String)((Iterator)localObject4).next();
            if ((str3.startsWith("gcm.n.")) || (str3.startsWith("gcm.notification.")))
            {
              ((Intent)localObject1).removeExtra(str3);
              continue;
              i = ((Resources)localObject2).getIdentifier((String)localObject1, "mipmap", this.zzk.getPackageName());
              if (i != 0) {
                break;
              }
              new StringBuilder(String.valueOf(localObject1).length() + 57).append("Icon resource ").append((String)localObject1).append(" not found. Notification will use app icon.");
              int j = this.zzk.getApplicationInfo().icon;
              i = j;
              if (j == 0) {
                i = 17301651;
              }
              break;
              label344:
              if ((!"default".equals(localObject1)) && (this.zzk.getResources().getIdentifier((String)localObject1, "raw", this.zzk.getPackageName()) != 0))
              {
                localObject2 = this.zzk.getPackageName();
                localObject2 = Uri.parse(String.valueOf(localObject2).length() + 24 + String.valueOf(localObject1).length() + "android.resource://" + (String)localObject2 + "/raw/" + (String)localObject1);
                break label127;
              }
              localObject2 = RingtoneManager.getDefaultUri(2);
              break label127;
              label458:
              localObject1 = this.zzk.getPackageManager().getLaunchIntentForPackage(this.zzk.getPackageName());
              if (localObject1 != null) {
                break label1068;
              }
              localObject4 = null;
              if ((!PlatformVersion.isAtLeastO()) || (this.zzk.getApplicationInfo().targetSdkVersion < 26)) {
                break label960;
              }
              localObject1 = zzd(paramBundle, "gcm.n.android_channel_id");
              if (PlatformVersion.isAtLeastO()) {
                break label774;
              }
              localObject1 = localObject5;
              localObject5 = new Notification.Builder(this.zzk).setAutoCancel(true).setSmallIcon(i);
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                ((Notification.Builder)localObject5).setContentTitle((CharSequence)localObject3);
              }
              if (!TextUtils.isEmpty(str1))
              {
                ((Notification.Builder)localObject5).setContentText(str1);
                ((Notification.Builder)localObject5).setStyle(new Notification.BigTextStyle().bigText(str1));
              }
              if (!TextUtils.isEmpty(str2)) {
                ((Notification.Builder)localObject5).setColor(Color.parseColor(str2));
              }
              if (localObject2 != null) {
                ((Notification.Builder)localObject5).setSound((Uri)localObject2);
              }
              if (localObject4 != null) {
                ((Notification.Builder)localObject5).setContentIntent((PendingIntent)localObject4);
              }
              if (localObject1 != null) {
                ((Notification.Builder)localObject5).setChannelId((String)localObject1);
              }
            }
          }
        }
        for (localObject1 = ((Notification.Builder)localObject5).build();; localObject1 = ((f.d)localObject1).DA())
        {
          localObject2 = zzd(paramBundle, "gcm.n.tag");
          Log.isLoggable("GcmNotification", 3);
          localObject3 = (NotificationManager)this.zzk.getSystemService("notification");
          paramBundle = (Bundle)localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            long l = SystemClock.uptimeMillis();
            paramBundle = 37 + "GCM-Notification:" + l;
          }
          ((NotificationManager)localObject3).notify(paramBundle, 0, (Notification)localObject1);
          AppMethodBeat.o(3700);
          return true;
          localObject4 = PendingIntent.getActivity(this.zzk, this.zzm.getAndIncrement(), (Intent)localObject1, 1073741824);
          break;
          localObject5 = (NotificationManager)this.zzk.getSystemService(NotificationManager.class);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (((NotificationManager)localObject5).getNotificationChannel((String)localObject1) != null) {
              break label525;
            }
            new StringBuilder(String.valueOf(localObject1).length() + 122).append("Notification Channel requested (").append((String)localObject1).append(") has not been created by the app. Manifest configuration, or default, value will be used.");
          }
          if (this.zzl != null)
          {
            localObject1 = this.zzl;
            break label525;
          }
          this.zzl = zze().getString("com.google.android.gms.gcm.default_notification_channel_id");
          if ((!TextUtils.isEmpty(this.zzl)) && (((NotificationManager)localObject5).getNotificationChannel(this.zzl) != null))
          {
            localObject1 = this.zzl;
            break label525;
          }
          if (((NotificationManager)localObject5).getNotificationChannel("fcm_fallback_notification_channel") == null) {
            ((NotificationManager)localObject5).createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", this.zzk.getString(R.string.gcm_fallback_notification_channel_label), 3));
          }
          this.zzl = "fcm_fallback_notification_channel";
          localObject1 = this.zzl;
          break label525;
          label960:
          localObject1 = new f.d(this.zzk).aC(true).eb(i);
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            ((f.d)localObject1).l((CharSequence)localObject3);
          }
          if (!TextUtils.isEmpty(str1)) {
            ((f.d)localObject1).m(str1);
          }
          if (!TextUtils.isEmpty(str2)) {
            ((f.d)localObject1).ec(Color.parseColor(str2));
          }
          if (localObject2 != null) {
            ((f.d)localObject1).d((Uri)localObject2);
          }
          if (localObject4 != null) {
            ((f.d)localObject1).a((PendingIntent)localObject4);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.gcm.zzd
 * JD-Core Version:    0.7.0.1
 */