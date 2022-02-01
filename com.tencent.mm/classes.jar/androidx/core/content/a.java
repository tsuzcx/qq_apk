package androidx.core.content;

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
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.HashMap;

public class a
{
  private static TypedValue JU;
  private static final Object sLock;
  
  static
  {
    AppMethodBeat.i(250535);
    sLock = new Object();
    AppMethodBeat.o(250535);
  }
  
  public static File[] P(Context paramContext)
  {
    AppMethodBeat.i(250517);
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramContext = paramContext.getExternalFilesDirs(null);
      AppMethodBeat.o(250517);
      return paramContext;
    }
    paramContext = paramContext.getExternalFilesDir(null);
    AppMethodBeat.o(250517);
    return new File[] { paramContext };
  }
  
  public static File[] Q(Context paramContext)
  {
    AppMethodBeat.i(250518);
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramContext = paramContext.getExternalCacheDirs();
      AppMethodBeat.o(250518);
      return paramContext;
    }
    paramContext = paramContext.getExternalCacheDir();
    AppMethodBeat.o(250518);
    return new File[] { paramContext };
  }
  
  public static File R(Context paramContext)
  {
    AppMethodBeat.i(250529);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramContext = paramContext.getNoBackupFilesDir();
      AppMethodBeat.o(250529);
      return paramContext;
    }
    paramContext = k(new File(paramContext.getApplicationInfo().dataDir, "no_backup"));
    AppMethodBeat.o(250529);
    return paramContext;
  }
  
  public static boolean S(Context paramContext)
  {
    AppMethodBeat.i(250532);
    if (Build.VERSION.SDK_INT >= 24)
    {
      boolean bool = paramContext.isDeviceProtectedStorage();
      AppMethodBeat.o(250532);
      return bool;
    }
    AppMethodBeat.o(250532);
    return false;
  }
  
  public static <T> T a(Context paramContext, Class<T> paramClass)
  {
    AppMethodBeat.i(250534);
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramContext = paramContext.getSystemService(paramClass);
      AppMethodBeat.o(250534);
      return paramContext;
    }
    if (Build.VERSION.SDK_INT >= 23) {}
    for (paramClass = paramContext.getSystemServiceName(paramClass); paramClass != null; paramClass = (String)a.JV.get(paramClass))
    {
      paramContext = paramContext.getSystemService(paramClass);
      AppMethodBeat.o(250534);
      return paramContext;
    }
    AppMethodBeat.o(250534);
    return null;
  }
  
  public static void a(Context paramContext, Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(250516);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramBundle).bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "androidx/core/content/ContextCompat", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0), (Bundle)paramIntent.sf(1));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "androidx/core/content/ContextCompat", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      AppMethodBeat.o(250516);
      return;
    }
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "androidx/core/content/ContextCompat", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "androidx/core/content/ContextCompat", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(250516);
  }
  
  public static boolean a(Context paramContext, Intent[] paramArrayOfIntent)
  {
    AppMethodBeat.i(250514);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramArrayOfIntent = new com.tencent.mm.hellhoundlib.b.a().bm(null).bm(paramArrayOfIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramArrayOfIntent.aFh(), "androidx/core/content/ContextCompat", "startActivities", "(Landroid/content/Context;[Landroid/content/Intent;Landroid/os/Bundle;)Z", "Undefined", "startActivities", "([Landroid/content/Intent;Landroid/os/Bundle;)V");
      paramContext.startActivities((Intent[])paramArrayOfIntent.sf(0), (Bundle)paramArrayOfIntent.sf(1));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "androidx/core/content/ContextCompat", "startActivities", "(Landroid/content/Context;[Landroid/content/Intent;Landroid/os/Bundle;)Z", "Undefined", "startActivities", "([Landroid/content/Intent;Landroid/os/Bundle;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(250514);
      return true;
      paramArrayOfIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramArrayOfIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramArrayOfIntent.aFh(), "androidx/core/content/ContextCompat", "startActivities", "(Landroid/content/Context;[Landroid/content/Intent;Landroid/os/Bundle;)Z", "Undefined", "startActivities", "([Landroid/content/Intent;)V");
      paramContext.startActivities((Intent[])paramArrayOfIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "androidx/core/content/ContextCompat", "startActivities", "(Landroid/content/Context;[Landroid/content/Intent;Landroid/os/Bundle;)Z", "Undefined", "startActivities", "([Landroid/content/Intent;)V");
    }
  }
  
  public static int checkSelfPermission(Context paramContext, String paramString)
  {
    AppMethodBeat.i(250527);
    if (paramString == null)
    {
      paramContext = new IllegalArgumentException("permission is null");
      AppMethodBeat.o(250527);
      throw paramContext;
    }
    int i = paramContext.checkPermission(paramString, Process.myPid(), Process.myUid());
    AppMethodBeat.o(250527);
    return i;
  }
  
  private static File k(File paramFile)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(250531);
        if ((!paramFile.exists()) && (!paramFile.mkdirs()))
        {
          if (paramFile.exists())
          {
            AppMethodBeat.o(250531);
            return paramFile;
          }
          new StringBuilder("Unable to create files subdir ").append(paramFile.getPath());
          paramFile = null;
          AppMethodBeat.o(250531);
          continue;
        }
        AppMethodBeat.o(250531);
      }
      finally {}
    }
  }
  
  public static ColorStateList l(Context paramContext, @androidx.annotation.a int paramInt)
  {
    AppMethodBeat.i(250522);
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramContext = paramContext.getColorStateList(paramInt);
      AppMethodBeat.o(250522);
      return paramContext;
    }
    paramContext = paramContext.getResources().getColorStateList(paramInt);
    AppMethodBeat.o(250522);
    return paramContext;
  }
  
  public static Drawable m(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(250519);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramContext = paramContext.getDrawable(paramInt);
      AppMethodBeat.o(250519);
      return paramContext;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramContext = paramContext.getResources().getDrawable(paramInt);
      AppMethodBeat.o(250519);
      return paramContext;
    }
    synchronized (sLock)
    {
      if (JU == null) {
        JU = new TypedValue();
      }
      paramContext.getResources().getValue(paramInt, JU, true);
      paramInt = JU.resourceId;
      paramContext = paramContext.getResources().getDrawable(paramInt);
      AppMethodBeat.o(250519);
      return paramContext;
    }
  }
  
  public static int w(Context paramContext, @androidx.annotation.a int paramInt)
  {
    AppMethodBeat.i(250525);
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramInt = paramContext.getColor(paramInt);
      AppMethodBeat.o(250525);
      return paramInt;
    }
    paramInt = paramContext.getResources().getColor(paramInt);
    AppMethodBeat.o(250525);
    return paramInt;
  }
  
  static final class a
  {
    static final HashMap<Class<?>, String> JV;
    
    static
    {
      AppMethodBeat.i(250499);
      JV = new HashMap();
      if (Build.VERSION.SDK_INT >= 22)
      {
        JV.put(SubscriptionManager.class, "telephony_subscription_service");
        JV.put(UsageStatsManager.class, "usagestats");
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        JV.put(AppWidgetManager.class, "appwidget");
        JV.put(BatteryManager.class, "batterymanager");
        JV.put(CameraManager.class, "camera");
        JV.put(JobScheduler.class, "jobscheduler");
        JV.put(LauncherApps.class, "launcherapps");
        JV.put(MediaProjectionManager.class, "media_projection");
        JV.put(MediaSessionManager.class, "media_session");
        JV.put(RestrictionsManager.class, "restrictions");
        JV.put(TelecomManager.class, "telecom");
        JV.put(TvInputManager.class, "tv_input");
      }
      if (Build.VERSION.SDK_INT >= 19)
      {
        JV.put(AppOpsManager.class, "appops");
        JV.put(CaptioningManager.class, "captioning");
        JV.put(ConsumerIrManager.class, "consumer_ir");
        JV.put(PrintManager.class, "print");
      }
      if (Build.VERSION.SDK_INT >= 18) {
        JV.put(BluetoothManager.class, "bluetooth");
      }
      if (Build.VERSION.SDK_INT >= 17)
      {
        JV.put(DisplayManager.class, "display");
        JV.put(UserManager.class, "user");
      }
      if (Build.VERSION.SDK_INT >= 16)
      {
        JV.put(InputManager.class, "input");
        JV.put(MediaRouter.class, "media_router");
        JV.put(NsdManager.class, "servicediscovery");
      }
      JV.put(AccessibilityManager.class, "accessibility");
      JV.put(AccountManager.class, "account");
      JV.put(ActivityManager.class, "activity");
      JV.put(AlarmManager.class, "alarm");
      JV.put(AudioManager.class, "audio");
      JV.put(ClipboardManager.class, "clipboard");
      JV.put(ConnectivityManager.class, "connectivity");
      JV.put(DevicePolicyManager.class, "device_policy");
      JV.put(DownloadManager.class, "download");
      JV.put(DropBoxManager.class, "dropbox");
      JV.put(InputMethodManager.class, "input_method");
      JV.put(KeyguardManager.class, "keyguard");
      JV.put(LayoutInflater.class, "layout_inflater");
      JV.put(LocationManager.class, "location");
      JV.put(NfcManager.class, "nfc");
      JV.put(NotificationManager.class, "notification");
      JV.put(PowerManager.class, "power");
      JV.put(SearchManager.class, "search");
      JV.put(SensorManager.class, "sensor");
      JV.put(StorageManager.class, "storage");
      JV.put(TelephonyManager.class, "phone");
      JV.put(TextServicesManager.class, "textservices");
      JV.put(UiModeManager.class, "uimode");
      JV.put(UsbManager.class, "usb");
      JV.put(Vibrator.class, "vibrator");
      JV.put(WallpaperManager.class, "wallpaper");
      JV.put(WifiP2pManager.class, "wifip2p");
      JV.put(WifiManager.class, "wifi");
      JV.put(WindowManager.class, "window");
      AppMethodBeat.o(250499);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.content.a
 * JD-Core Version:    0.7.0.1
 */