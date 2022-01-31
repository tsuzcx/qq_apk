package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.s.b;
import android.support.v4.app.s.c;
import android.support.v4.content.b;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.iid.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

final class c
{
  private static c bgK;
  private final Context bfj;
  private Bundle bgL;
  private Method bgM;
  private Method bgN;
  private final AtomicInteger bgO;
  
  private c(Context paramContext)
  {
    AppMethodBeat.i(77221);
    this.bgO = new AtomicInteger((int)SystemClock.elapsedRealtime());
    this.bfj = paramContext.getApplicationContext();
    AppMethodBeat.o(77221);
  }
  
  @TargetApi(26)
  private final Notification a(CharSequence paramCharSequence, String paramString1, int paramInt, Integer paramInteger, Uri paramUri, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, String paramString2)
  {
    AppMethodBeat.i(77223);
    Notification.Builder localBuilder = new Notification.Builder(this.bfj).setAutoCancel(true).setSmallIcon(paramInt);
    if (!TextUtils.isEmpty(paramCharSequence)) {
      localBuilder.setContentTitle(paramCharSequence);
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      localBuilder.setContentText(paramString1);
      localBuilder.setStyle(new Notification.BigTextStyle().bigText(paramString1));
    }
    if (paramInteger != null) {
      localBuilder.setColor(paramInteger.intValue());
    }
    if (paramUri != null) {
      localBuilder.setSound(paramUri);
    }
    if (paramPendingIntent1 != null) {
      localBuilder.setContentIntent(paramPendingIntent1);
    }
    if (paramPendingIntent2 != null) {
      localBuilder.setDeleteIntent(paramPendingIntent2);
    }
    if (paramString2 != null)
    {
      if (this.bgM == null) {
        this.bgM = bd("setChannelId");
      }
      if (this.bgM == null) {
        this.bgM = bd("setChannel");
      }
      if (this.bgM == null) {}
    }
    try
    {
      this.bgM.invoke(localBuilder, new Object[] { paramString2 });
      label189:
      paramCharSequence = localBuilder.build();
      AppMethodBeat.o(77223);
      return paramCharSequence;
    }
    catch (IllegalArgumentException paramCharSequence)
    {
      break label189;
    }
    catch (SecurityException paramCharSequence)
    {
      break label189;
    }
    catch (InvocationTargetException paramCharSequence)
    {
      break label189;
    }
    catch (IllegalAccessException paramCharSequence)
    {
      break label189;
    }
  }
  
  static c ak(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(77218);
      if (bgK == null) {
        bgK = new c(paramContext);
      }
      paramContext = bgK;
      AppMethodBeat.o(77218);
      return paramContext;
    }
    finally {}
  }
  
  private static void b(Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(77229);
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((str.startsWith("google.c.a.")) || (str.equals("from"))) {
        paramIntent.putExtra(str, paramBundle.getString(str));
      }
    }
    AppMethodBeat.o(77229);
  }
  
  @TargetApi(26)
  private static Method bd(String paramString)
  {
    AppMethodBeat.i(77224);
    try
    {
      paramString = Notification.Builder.class.getMethod(paramString, new Class[] { String.class });
      AppMethodBeat.o(77224);
      return paramString;
    }
    catch (SecurityException paramString)
    {
      AppMethodBeat.o(77224);
      return null;
    }
    catch (NoSuchMethodException paramString)
    {
      label29:
      break label29;
    }
  }
  
  private final Integer be(String paramString)
  {
    AppMethodBeat.i(77227);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(77227);
      return null;
    }
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        i = Color.parseColor(paramString);
        AppMethodBeat.o(77227);
        return Integer.valueOf(i);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        new StringBuilder(String.valueOf(paramString).length() + 54).append("Color ").append(paramString).append(" not valid. Notification will use default color.");
      }
    }
    int i = sj().getInt("com.google.firebase.messaging.default_notification_color", 0);
    if (i != 0) {
      try
      {
        i = b.m(this.bfj, i);
        AppMethodBeat.o(77227);
        return Integer.valueOf(i);
      }
      catch (Resources.NotFoundException paramString) {}
    }
    AppMethodBeat.o(77227);
    return null;
  }
  
  static String d(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(77219);
    String str2 = paramBundle.getString(paramString);
    String str1 = str2;
    if (str2 == null) {
      str1 = paramBundle.getString(paramString.replace("gcm.n.", "gcm.notification."));
    }
    AppMethodBeat.o(77219);
    return str1;
  }
  
  private static Object[] e(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(77220);
    String str = String.valueOf(paramString);
    Object localObject = String.valueOf("_loc_args");
    if (((String)localObject).length() != 0) {}
    for (str = str.concat((String)localObject);; str = new String(str))
    {
      str = d(paramBundle, str);
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      AppMethodBeat.o(77220);
      return null;
    }
    try
    {
      paramBundle = new JSONArray(str);
      localObject = new String[paramBundle.length()];
      int i = 0;
      while (i < localObject.length)
      {
        localObject[i] = paramBundle.opt(i);
        i += 1;
      }
      AppMethodBeat.o(77220);
      return localObject;
    }
    catch (JSONException paramBundle)
    {
      paramBundle = String.valueOf(paramString);
      paramString = String.valueOf("_loc_args");
      if (paramString.length() == 0) {}
    }
    for (paramBundle = paramBundle.concat(paramString);; paramBundle = new String(paramBundle))
    {
      paramBundle = paramBundle.substring(6);
      new StringBuilder(String.valueOf(paramBundle).length() + 41 + String.valueOf(str).length()).append("Malformed ").append(paramBundle).append(": ").append(str).append("  Default value will be used.");
      AppMethodBeat.o(77220);
      return null;
    }
  }
  
  @TargetApi(26)
  private final boolean eM(int paramInt)
  {
    AppMethodBeat.i(77226);
    if (Build.VERSION.SDK_INT != 26)
    {
      AppMethodBeat.o(77226);
      return true;
    }
    try
    {
      if ((this.bfj.getResources().getDrawable(paramInt, null) instanceof AdaptiveIconDrawable))
      {
        new StringBuilder(77).append("Adaptive icons cannot be used in notifications. Ignoring icon id: ").append(paramInt);
        AppMethodBeat.o(77226);
        return false;
      }
      AppMethodBeat.o(77226);
      return true;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      AppMethodBeat.o(77226);
    }
    return false;
  }
  
  private final Bundle sj()
  {
    AppMethodBeat.i(77230);
    if (this.bgL != null)
    {
      localObject = this.bgL;
      AppMethodBeat.o(77230);
      return localObject;
    }
    Object localObject = null;
    try
    {
      ApplicationInfo localApplicationInfo = this.bfj.getPackageManager().getApplicationInfo(this.bfj.getPackageName(), 128);
      localObject = localApplicationInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label51:
      break label51;
    }
    if ((localObject != null) && (((ApplicationInfo)localObject).metaData != null))
    {
      this.bgL = ((ApplicationInfo)localObject).metaData;
      localObject = this.bgL;
      AppMethodBeat.o(77230);
      return localObject;
    }
    localObject = Bundle.EMPTY;
    AppMethodBeat.o(77230);
    return localObject;
  }
  
  private final String zzd(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(77225);
    String str = d(paramBundle, paramString);
    if (!TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(77225);
      return str;
    }
    str = String.valueOf(paramString);
    Object localObject = String.valueOf("_loc_key");
    if (((String)localObject).length() != 0) {}
    for (str = str.concat((String)localObject);; str = new String(str))
    {
      str = d(paramBundle, str);
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      AppMethodBeat.o(77225);
      return null;
    }
    localObject = this.bfj.getResources();
    int i = ((Resources)localObject).getIdentifier(str, "string", this.bfj.getPackageName());
    if (i == 0)
    {
      paramBundle = String.valueOf(paramString);
      paramString = String.valueOf("_loc_key");
      if (paramString.length() != 0) {}
      for (paramBundle = paramBundle.concat(paramString);; paramBundle = new String(paramBundle))
      {
        paramBundle = paramBundle.substring(6);
        new StringBuilder(String.valueOf(paramBundle).length() + 49 + String.valueOf(str).length()).append(paramBundle).append(" resource not found: ").append(str).append(" Default value will be used.");
        AppMethodBeat.o(77225);
        return null;
      }
    }
    paramBundle = e(paramBundle, paramString);
    if (paramBundle == null)
    {
      paramBundle = ((Resources)localObject).getString(i);
      AppMethodBeat.o(77225);
      return paramBundle;
    }
    try
    {
      paramString = ((Resources)localObject).getString(i, paramBundle);
      AppMethodBeat.o(77225);
      return paramString;
    }
    catch (MissingFormatArgumentException paramString)
    {
      paramBundle = Arrays.toString(paramBundle);
      new StringBuilder(String.valueOf(str).length() + 58 + String.valueOf(paramBundle).length()).append("Missing format argument for ").append(str).append(": ").append(paramBundle).append(" Default value will be used.");
      AppMethodBeat.o(77225);
    }
    return null;
  }
  
  @TargetApi(26)
  private final String zzn(String paramString)
  {
    AppMethodBeat.i(77228);
    if (!PlatformVersion.isAtLeastO())
    {
      AppMethodBeat.o(77228);
      return null;
    }
    NotificationManager localNotificationManager = (NotificationManager)this.bfj.getSystemService(NotificationManager.class);
    try
    {
      if (this.bgN == null) {
        this.bgN = localNotificationManager.getClass().getMethod("getNotificationChannel", new Class[] { String.class });
      }
      Object localObject;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = this.bgN.invoke(localNotificationManager, new Object[] { paramString });
        if (localObject != null)
        {
          AppMethodBeat.o(77228);
          return paramString;
        }
        new StringBuilder(String.valueOf(paramString).length() + 122).append("Notification Channel requested (").append(paramString).append(") has not been created by the app. Manifest configuration, or default, value will be used.");
      }
      paramString = sj().getString("com.google.firebase.messaging.default_notification_channel_id");
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = this.bgN.invoke(localNotificationManager, new Object[] { paramString });
        if (localObject != null)
        {
          AppMethodBeat.o(77228);
          return paramString;
        }
      }
      if (this.bgN.invoke(localNotificationManager, new Object[] { "fcm_fallback_notification_channel" }) == null)
      {
        paramString = Class.forName("android.app.NotificationChannel");
        localObject = paramString.getConstructor(new Class[] { String.class, CharSequence.class, Integer.TYPE }).newInstance(new Object[] { "fcm_fallback_notification_channel", this.bfj.getString(2131296283), Integer.valueOf(3) });
        localNotificationManager.getClass().getMethod("createNotificationChannel", new Class[] { paramString }).invoke(localNotificationManager, new Object[] { localObject });
      }
      AppMethodBeat.o(77228);
      return "fcm_fallback_notification_channel";
    }
    catch (LinkageError paramString)
    {
      AppMethodBeat.o(77228);
      return null;
    }
    catch (IllegalArgumentException paramString)
    {
      break label310;
    }
    catch (SecurityException paramString)
    {
      break label310;
    }
    catch (ClassNotFoundException paramString)
    {
      break label310;
    }
    catch (IllegalAccessException paramString)
    {
      break label310;
    }
    catch (NoSuchMethodException paramString)
    {
      break label310;
    }
    catch (InvocationTargetException paramString)
    {
      break label310;
    }
    catch (InstantiationException paramString)
    {
      label310:
      break label310;
    }
  }
  
  final boolean k(Bundle paramBundle)
  {
    Object localObject4 = null;
    AppMethodBeat.i(77222);
    if ("1".equals(d(paramBundle, "gcm.n.noui")))
    {
      AppMethodBeat.o(77222);
      return true;
    }
    int i;
    Object localObject2;
    if (!((KeyguardManager)this.bfj.getSystemService("keyguard")).inKeyguardRestrictedInputMode())
    {
      if (!PlatformVersion.isAtLeastLollipop()) {
        SystemClock.sleep(10L);
      }
      i = Process.myPid();
      localObject1 = ((ActivityManager)this.bfj.getSystemService("activity")).getRunningAppProcesses();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
            if (((ActivityManager.RunningAppProcessInfo)localObject2).pid == i) {
              if (((ActivityManager.RunningAppProcessInfo)localObject2).importance == 100) {
                i = 1;
              }
            }
          }
        }
      }
    }
    while (i != 0)
    {
      AppMethodBeat.o(77222);
      return false;
      i = 0;
      continue;
      i = 0;
    }
    Object localObject1 = zzd(paramBundle, "gcm.n.title");
    Object localObject3 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject3 = this.bfj.getApplicationInfo().loadLabel(this.bfj.getPackageManager());
    }
    String str1 = zzd(paramBundle, "gcm.n.body");
    localObject1 = d(paramBundle, "gcm.n.icon");
    Integer localInteger;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = this.bfj.getResources();
      i = ((Resources)localObject2).getIdentifier((String)localObject1, "drawable", this.bfj.getPackageName());
      if ((i != 0) && (eM(i)))
      {
        localInteger = be(d(paramBundle, "gcm.n.color"));
        localObject2 = d(paramBundle, "gcm.n.sound2");
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = d(paramBundle, "gcm.n.sound");
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label742;
        }
        localObject1 = null;
        label326:
        localObject2 = d(paramBundle, "gcm.n.click_action");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label856;
        }
        localObject2 = new Intent((String)localObject2);
        ((Intent)localObject2).setPackage(this.bfj.getPackageName());
        ((Intent)localObject2).setFlags(268435456);
        label376:
        if (localObject2 != null) {
          break label974;
        }
        localObject2 = null;
        label384:
        if (!FirebaseMessagingService.j(paramBundle)) {
          break label1230;
        }
        localObject4 = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN");
        b((Intent)localObject4, paramBundle);
        ((Intent)localObject4).putExtra("pending_intent", (Parcelable)localObject2);
        localObject2 = o.a(this.bfj, this.bgO.incrementAndGet(), (Intent)localObject4);
        localObject4 = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
        b((Intent)localObject4, paramBundle);
        localObject4 = o.a(this.bfj, this.bgO.incrementAndGet(), (Intent)localObject4);
      }
    }
    label952:
    label1230:
    for (;;)
    {
      if ((PlatformVersion.isAtLeastO()) && (this.bfj.getApplicationInfo().targetSdkVersion > 25)) {}
      label742:
      Object localObject5;
      for (localObject1 = a((CharSequence)localObject3, str1, i, localInteger, (Uri)localObject1, (PendingIntent)localObject2, (PendingIntent)localObject4, zzn(d(paramBundle, "gcm.n.android_channel_id")));; localObject1 = ((s.c)localObject5).build())
      {
        localObject2 = d(paramBundle, "gcm.n.tag");
        Log.isLoggable("FirebaseMessaging", 3);
        localObject3 = (NotificationManager)this.bfj.getSystemService("notification");
        paramBundle = (Bundle)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          long l = SystemClock.uptimeMillis();
          paramBundle = 37 + "FCM-Notification:" + l;
        }
        ((NotificationManager)localObject3).notify(paramBundle, 0, (Notification)localObject1);
        AppMethodBeat.o(77222);
        return true;
        int j = ((Resources)localObject2).getIdentifier((String)localObject1, "mipmap", this.bfj.getPackageName());
        if (j != 0)
        {
          i = j;
          if (eM(j)) {
            break;
          }
        }
        new StringBuilder(String.valueOf(localObject1).length() + 61).append("Icon resource ").append((String)localObject1).append(" not found. Notification will use default icon.");
        j = sj().getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (j != 0)
        {
          i = j;
          if (eM(j)) {}
        }
        else
        {
          i = this.bfj.getApplicationInfo().icon;
        }
        if (i != 0)
        {
          j = i;
          if (eM(i)) {}
        }
        else
        {
          j = 17301651;
        }
        i = j;
        break;
        if ((!"default".equals(localObject1)) && (this.bfj.getResources().getIdentifier((String)localObject1, "raw", this.bfj.getPackageName()) != 0))
        {
          localObject2 = this.bfj.getPackageName();
          localObject1 = Uri.parse(String.valueOf(localObject2).length() + 24 + String.valueOf(localObject1).length() + "android.resource://" + (String)localObject2 + "/raw/" + (String)localObject1);
          break label326;
        }
        localObject1 = RingtoneManager.getDefaultUri(2);
        break label326;
        label856:
        localObject5 = d(paramBundle, "gcm.n.link_android");
        localObject2 = localObject5;
        if (TextUtils.isEmpty((CharSequence)localObject5)) {
          localObject2 = d(paramBundle, "gcm.n.link");
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
        for (localObject2 = Uri.parse((String)localObject2);; localObject2 = null)
        {
          if (localObject2 == null) {
            break label952;
          }
          localObject5 = new Intent("android.intent.action.VIEW");
          ((Intent)localObject5).setPackage(this.bfj.getPackageName());
          ((Intent)localObject5).setData((Uri)localObject2);
          localObject2 = localObject5;
          break;
        }
        localObject2 = this.bfj.getPackageManager().getLaunchIntentForPackage(this.bfj.getPackageName());
        break label376;
        label974:
        ((Intent)localObject2).addFlags(67108864);
        localObject5 = new Bundle(paramBundle);
        FirebaseMessagingService.i((Bundle)localObject5);
        ((Intent)localObject2).putExtras((Bundle)localObject5);
        localObject5 = ((Bundle)localObject5).keySet().iterator();
        while (((Iterator)localObject5).hasNext())
        {
          String str2 = (String)((Iterator)localObject5).next();
          if ((str2.startsWith("gcm.n.")) || (str2.startsWith("gcm.notification."))) {
            ((Intent)localObject2).removeExtra(str2);
          }
        }
        localObject2 = PendingIntent.getActivity(this.bfj, this.bgO.incrementAndGet(), (Intent)localObject2, 1073741824);
        break label384;
        localObject5 = new s.c(this.bfj).z(true).Y(i);
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          ((s.c)localObject5).e((CharSequence)localObject3);
        }
        if (!TextUtils.isEmpty(str1))
        {
          ((s.c)localObject5).f(str1);
          ((s.c)localObject5).a(new s.b().d(str1));
        }
        if (localInteger != null) {
          ((s.c)localObject5).mColor = localInteger.intValue();
        }
        if (localObject1 != null) {
          ((s.c)localObject5).b((Uri)localObject1);
        }
        if (localObject2 != null) {
          ((s.c)localObject5).ya = ((PendingIntent)localObject2);
        }
        if (localObject4 != null) {
          ((s.c)localObject5).a((PendingIntent)localObject4);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.messaging.c
 * JD-Core Version:    0.7.0.1
 */