package android.support.v4.content;

import android.accessibilityservice.AccessibilityService;
import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.RestrictionsManager;
import android.content.pm.ApplicationInfo;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import java.io.File;
import java.util.HashMap;

public class b
{
  private static TypedValue IX;
  private static final Object sLock = new Object();
  
  public static File[] S(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramContext.getExternalFilesDirs(null);
    }
    return new File[] { paramContext.getExternalFilesDir(null) };
  }
  
  public static File[] T(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramContext.getExternalCacheDirs();
    }
    return new File[] { paramContext.getExternalCacheDir() };
  }
  
  public static File U(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramContext.getNoBackupFilesDir();
    }
    return n(new File(paramContext.getApplicationInfo().dataDir, "no_backup"));
  }
  
  public static boolean V(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return paramContext.isDeviceProtectedStorage();
    }
    return false;
  }
  
  public static <T> T a(Context paramContext, Class<T> paramClass)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getSystemService(paramClass);
    }
    if (Build.VERSION.SDK_INT >= 23) {}
    for (paramClass = paramContext.getSystemServiceName(paramClass); paramClass != null; paramClass = (String)a.IY.get(paramClass)) {
      return paramContext.getSystemService(paramClass);
    }
    return null;
  }
  
  public static boolean a(Context paramContext, Intent[] paramArrayOfIntent)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramArrayOfIntent = new com.tencent.mm.hellhoundlib.b.a().bl(null).bl(paramArrayOfIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramArrayOfIntent.axQ(), "android/support/v4/content/ContextCompat", "startActivities", "(Landroid/content/Context;[Landroid/content/Intent;Landroid/os/Bundle;)Z", "Undefined", "startActivities", "([Landroid/content/Intent;Landroid/os/Bundle;)V");
      paramContext.startActivities((Intent[])paramArrayOfIntent.pG(0), (Bundle)paramArrayOfIntent.pG(1));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "android/support/v4/content/ContextCompat", "startActivities", "(Landroid/content/Context;[Landroid/content/Intent;Landroid/os/Bundle;)Z", "Undefined", "startActivities", "([Landroid/content/Intent;Landroid/os/Bundle;)V");
      return true;
    }
    paramArrayOfIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramArrayOfIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramArrayOfIntent.axQ(), "android/support/v4/content/ContextCompat", "startActivities", "(Landroid/content/Context;[Landroid/content/Intent;Landroid/os/Bundle;)Z", "Undefined", "startActivities", "([Landroid/content/Intent;)V");
    paramContext.startActivities((Intent[])paramArrayOfIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "android/support/v4/content/ContextCompat", "startActivities", "(Landroid/content/Context;[Landroid/content/Intent;Landroid/os/Bundle;)Z", "Undefined", "startActivities", "([Landroid/content/Intent;)V");
    return true;
  }
  
  public static int checkSelfPermission(Context paramContext, String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("permission is null");
    }
    return paramContext.checkPermission(paramString, Process.myPid(), Process.myUid());
  }
  
  public static Drawable l(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramContext.getDrawable(paramInt);
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return paramContext.getResources().getDrawable(paramInt);
    }
    synchronized (sLock)
    {
      if (IX == null) {
        IX = new TypedValue();
      }
      paramContext.getResources().getValue(paramInt, IX, true);
      paramInt = IX.resourceId;
      return paramContext.getResources().getDrawable(paramInt);
    }
  }
  
  public static ColorStateList m(Context paramContext, @android.support.annotation.a int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getColorStateList(paramInt);
    }
    return paramContext.getResources().getColorStateList(paramInt);
  }
  
  public static int n(Context paramContext, @android.support.annotation.a int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getColor(paramInt);
    }
    return paramContext.getResources().getColor(paramInt);
  }
  
  /* Error */
  private static File n(File paramFile)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: astore_2
    //   5: aload_0
    //   6: invokevirtual 213	java/io/File:exists	()Z
    //   9: ifne +23 -> 32
    //   12: aload_0
    //   13: astore_2
    //   14: aload_0
    //   15: invokevirtual 216	java/io/File:mkdirs	()Z
    //   18: ifne +14 -> 32
    //   21: aload_0
    //   22: invokevirtual 213	java/io/File:exists	()Z
    //   25: istore_1
    //   26: iload_1
    //   27: ifeq +10 -> 37
    //   30: aload_0
    //   31: astore_2
    //   32: ldc 2
    //   34: monitorexit
    //   35: aload_2
    //   36: areturn
    //   37: new 218	java/lang/StringBuilder
    //   40: dup
    //   41: ldc 220
    //   43: invokespecial 221	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: aload_0
    //   47: invokevirtual 225	java/io/File:getPath	()Ljava/lang/String;
    //   50: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aconst_null
    //   55: astore_2
    //   56: goto -24 -> 32
    //   59: astore_0
    //   60: ldc 2
    //   62: monitorexit
    //   63: aload_0
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramFile	File
    //   25	2	1	bool	boolean
    //   4	52	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   5	12	59	finally
    //   14	26	59	finally
    //   37	54	59	finally
  }
  
  public static void startActivity(Context paramContext, Intent paramIntent, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramBundle).bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "android/support/v4/content/ContextCompat", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0), (Bundle)paramIntent.pG(1));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "android/support/v4/content/ContextCompat", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      return;
    }
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "android/support/v4/content/ContextCompat", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "android/support/v4/content/ContextCompat", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
  
  static final class a
  {
    static final HashMap<Class<?>, String> IY = new HashMap();
    
    static
    {
      if (Build.VERSION.SDK_INT > 22)
      {
        IY.put(SubscriptionManager.class, "telephony_subscription_service");
        IY.put(UsageStatsManager.class, "usagestats");
      }
      if (Build.VERSION.SDK_INT > 21)
      {
        IY.put(AppWidgetManager.class, "appwidget");
        IY.put(BatteryManager.class, "batterymanager");
        IY.put(CameraManager.class, "camera");
        IY.put(JobScheduler.class, "jobscheduler");
        IY.put(LauncherApps.class, "launcherapps");
        IY.put(MediaProjectionManager.class, "media_projection");
        IY.put(MediaSessionManager.class, "media_session");
        IY.put(RestrictionsManager.class, "restrictions");
        IY.put(TelecomManager.class, "telecom");
        IY.put(TvInputManager.class, "tv_input");
      }
      if (Build.VERSION.SDK_INT > 19)
      {
        IY.put(AppOpsManager.class, "appops");
        IY.put(CaptioningManager.class, "captioning");
        IY.put(ConsumerIrManager.class, "consumer_ir");
        IY.put(PrintManager.class, "print");
      }
      if (Build.VERSION.SDK_INT > 18) {
        IY.put(BluetoothManager.class, "bluetooth");
      }
      if (Build.VERSION.SDK_INT > 17)
      {
        IY.put(DisplayManager.class, "display");
        IY.put(UserManager.class, "user");
      }
      if (Build.VERSION.SDK_INT > 16)
      {
        IY.put(InputManager.class, "input");
        IY.put(MediaRouter.class, "media_router");
        IY.put(NsdManager.class, "servicediscovery");
      }
      IY.put(AccessibilityService.class, "accessibility");
      IY.put(AccountManager.class, "account");
      IY.put(ActivityManager.class, "activity");
      IY.put(AlarmManager.class, "alarm");
      IY.put(AudioManager.class, "audio");
      IY.put(ClipboardManager.class, "clipboard");
      IY.put(ConnectivityManager.class, "connectivity");
      IY.put(DevicePolicyManager.class, "device_policy");
      IY.put(DownloadManager.class, "download");
      IY.put(DropBoxManager.class, "dropbox");
      IY.put(InputMethodManager.class, "input_method");
      IY.put(KeyguardManager.class, "keyguard");
      IY.put(LayoutInflater.class, "layout_inflater");
      IY.put(LocationManager.class, "location");
      IY.put(NfcManager.class, "nfc");
      IY.put(NotificationManager.class, "notification");
      IY.put(PowerManager.class, "power");
      IY.put(SearchManager.class, "search");
      IY.put(SensorManager.class, "sensor");
      IY.put(StorageManager.class, "storage");
      IY.put(TelephonyManager.class, "phone");
      IY.put(TextServicesManager.class, "textservices");
      IY.put(UiModeManager.class, "uimode");
      IY.put(UsbManager.class, "usb");
      IY.put(Vibrator.class, "vibrator");
      IY.put(WallpaperManager.class, "wallpaper");
      IY.put(WifiP2pManager.class, "wifip2p");
      IY.put(WifiManager.class, "wifi");
      IY.put(WindowManager.class, "window");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.content.b
 * JD-Core Version:    0.7.0.1
 */