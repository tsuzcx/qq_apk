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
import androidx.core.content.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.HashMap;

public class a
{
  private static final Object bpX;
  private static TypedValue bpY;
  private static final Object sLock;
  
  static
  {
    AppMethodBeat.i(195605);
    sLock = new Object();
    bpX = new Object();
    AppMethodBeat.o(195605);
  }
  
  public static <T> T a(Context paramContext, Class<T> paramClass)
  {
    AppMethodBeat.i(195599);
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramContext = d.a(paramContext, paramClass);
      AppMethodBeat.o(195599);
      return paramContext;
    }
    if (Build.VERSION.SDK_INT >= 23) {}
    for (paramClass = d.b(paramContext, paramClass); paramClass != null; paramClass = (String)f.bpZ.get(paramClass))
    {
      paramContext = paramContext.getSystemService(paramClass);
      AppMethodBeat.o(195599);
      return paramContext;
    }
    AppMethodBeat.o(195599);
    return null;
  }
  
  public static void a(Context paramContext, Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(195517);
    if (Build.VERSION.SDK_INT >= 16)
    {
      a.a.a(paramContext, paramIntent, paramBundle);
      AppMethodBeat.o(195517);
      return;
    }
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "androidx/core/content/ContextCompat", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "androidx/core/content/ContextCompat", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(195517);
  }
  
  public static boolean a(Context paramContext, Intent[] paramArrayOfIntent)
  {
    AppMethodBeat.i(195504);
    if (Build.VERSION.SDK_INT >= 16) {
      a.a.a(paramContext, paramArrayOfIntent, null);
    }
    for (;;)
    {
      AppMethodBeat.o(195504);
      return true;
      paramArrayOfIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramArrayOfIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramArrayOfIntent.aYi(), "androidx/core/content/ContextCompat", "startActivities", "(Landroid/content/Context;[Landroid/content/Intent;Landroid/os/Bundle;)Z", "Undefined", "startActivities", "([Landroid/content/Intent;)V");
      paramContext.startActivities((Intent[])paramArrayOfIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "androidx/core/content/ContextCompat", "startActivities", "(Landroid/content/Context;[Landroid/content/Intent;Landroid/os/Bundle;)Z", "Undefined", "startActivities", "([Landroid/content/Intent;)V");
    }
  }
  
  public static File[] aa(Context paramContext)
  {
    AppMethodBeat.i(195527);
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramContext = b.g(paramContext, null);
      AppMethodBeat.o(195527);
      return paramContext;
    }
    paramContext = paramContext.getExternalFilesDir(null);
    AppMethodBeat.o(195527);
    return new File[] { paramContext };
  }
  
  public static File[] ab(Context paramContext)
  {
    AppMethodBeat.i(195537);
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramContext = b.ab(paramContext);
      AppMethodBeat.o(195537);
      return paramContext;
    }
    paramContext = paramContext.getExternalCacheDir();
    AppMethodBeat.o(195537);
    return new File[] { paramContext };
  }
  
  public static File ac(Context paramContext)
  {
    AppMethodBeat.i(195573);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramContext = c.ac(paramContext);
      AppMethodBeat.o(195573);
      return paramContext;
    }
    paramContext = k(new File(paramContext.getApplicationInfo().dataDir, "no_backup"));
    AppMethodBeat.o(195573);
    return paramContext;
  }
  
  public static boolean ad(Context paramContext)
  {
    AppMethodBeat.i(195589);
    if (Build.VERSION.SDK_INT >= 24)
    {
      boolean bool = e.ad(paramContext);
      AppMethodBeat.o(195589);
      return bool;
    }
    AppMethodBeat.o(195589);
    return false;
  }
  
  public static int checkSelfPermission(Context paramContext, String paramString)
  {
    AppMethodBeat.i(195566);
    if (paramString == null)
    {
      paramContext = new IllegalArgumentException("permission is null");
      AppMethodBeat.o(195566);
      throw paramContext;
    }
    int i = paramContext.checkPermission(paramString, Process.myPid(), Process.myUid());
    AppMethodBeat.o(195566);
    return i;
  }
  
  private static File k(File paramFile)
  {
    AppMethodBeat.i(195581);
    synchronized (bpX)
    {
      if (!paramFile.exists())
      {
        if (paramFile.mkdirs())
        {
          AppMethodBeat.o(195581);
          return paramFile;
        }
        new StringBuilder("Unable to create files subdir ").append(paramFile.getPath());
      }
      AppMethodBeat.o(195581);
      return paramFile;
    }
  }
  
  public static ColorStateList l(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(195554);
    paramContext = f.c(paramContext.getResources(), paramInt, paramContext.getTheme());
    AppMethodBeat.o(195554);
    return paramContext;
  }
  
  public static Drawable m(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(195547);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramContext = c.m(paramContext, paramInt);
      AppMethodBeat.o(195547);
      return paramContext;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramContext = paramContext.getResources().getDrawable(paramInt);
      AppMethodBeat.o(195547);
      return paramContext;
    }
    synchronized (sLock)
    {
      if (bpY == null) {
        bpY = new TypedValue();
      }
      paramContext.getResources().getValue(paramInt, bpY, true);
      paramInt = bpY.resourceId;
      paramContext = paramContext.getResources().getDrawable(paramInt);
      AppMethodBeat.o(195547);
      return paramContext;
    }
  }
  
  public static int w(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(195561);
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramInt = d.w(paramContext, paramInt);
      AppMethodBeat.o(195561);
      return paramInt;
    }
    paramInt = paramContext.getResources().getColor(paramInt);
    AppMethodBeat.o(195561);
    return paramInt;
  }
  
  static final class b
  {
    static File[] ab(Context paramContext)
    {
      AppMethodBeat.i(195505);
      paramContext = paramContext.getExternalCacheDirs();
      AppMethodBeat.o(195505);
      return paramContext;
    }
    
    static File[] ae(Context paramContext)
    {
      AppMethodBeat.i(195524);
      paramContext = paramContext.getObbDirs();
      AppMethodBeat.o(195524);
      return paramContext;
    }
    
    static File[] g(Context paramContext, String paramString)
    {
      AppMethodBeat.i(195514);
      paramContext = paramContext.getExternalFilesDirs(paramString);
      AppMethodBeat.o(195514);
      return paramContext;
    }
  }
  
  static final class c
  {
    static File ac(Context paramContext)
    {
      AppMethodBeat.i(195542);
      paramContext = paramContext.getNoBackupFilesDir();
      AppMethodBeat.o(195542);
      return paramContext;
    }
    
    static File af(Context paramContext)
    {
      AppMethodBeat.i(195550);
      paramContext = paramContext.getCodeCacheDir();
      AppMethodBeat.o(195550);
      return paramContext;
    }
    
    static Drawable m(Context paramContext, int paramInt)
    {
      AppMethodBeat.i(195530);
      paramContext = paramContext.getDrawable(paramInt);
      AppMethodBeat.o(195530);
      return paramContext;
    }
  }
  
  static final class d
  {
    static <T> T a(Context paramContext, Class<T> paramClass)
    {
      AppMethodBeat.i(195543);
      paramContext = paramContext.getSystemService(paramClass);
      AppMethodBeat.o(195543);
      return paramContext;
    }
    
    static String b(Context paramContext, Class<?> paramClass)
    {
      AppMethodBeat.i(195552);
      paramContext = paramContext.getSystemServiceName(paramClass);
      AppMethodBeat.o(195552);
      return paramContext;
    }
    
    static ColorStateList l(Context paramContext, int paramInt)
    {
      AppMethodBeat.i(195525);
      paramContext = paramContext.getColorStateList(paramInt);
      AppMethodBeat.o(195525);
      return paramContext;
    }
    
    static int w(Context paramContext, int paramInt)
    {
      AppMethodBeat.i(195534);
      paramInt = paramContext.getColor(paramInt);
      AppMethodBeat.o(195534);
      return paramInt;
    }
  }
  
  static final class e
  {
    static boolean ad(Context paramContext)
    {
      AppMethodBeat.i(195644);
      boolean bool = paramContext.isDeviceProtectedStorage();
      AppMethodBeat.o(195644);
      return bool;
    }
    
    static File ag(Context paramContext)
    {
      AppMethodBeat.i(195625);
      paramContext = paramContext.getDataDir();
      AppMethodBeat.o(195625);
      return paramContext;
    }
    
    static Context ah(Context paramContext)
    {
      AppMethodBeat.i(195633);
      paramContext = paramContext.createDeviceProtectedStorageContext();
      AppMethodBeat.o(195633);
      return paramContext;
    }
  }
  
  static final class f
  {
    static final HashMap<Class<?>, String> bpZ;
    
    static
    {
      AppMethodBeat.i(195546);
      bpZ = new HashMap();
      if (Build.VERSION.SDK_INT >= 22)
      {
        bpZ.put(SubscriptionManager.class, "telephony_subscription_service");
        bpZ.put(UsageStatsManager.class, "usagestats");
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        bpZ.put(AppWidgetManager.class, "appwidget");
        bpZ.put(BatteryManager.class, "batterymanager");
        bpZ.put(CameraManager.class, "camera");
        bpZ.put(JobScheduler.class, "jobscheduler");
        bpZ.put(LauncherApps.class, "launcherapps");
        bpZ.put(MediaProjectionManager.class, "media_projection");
        bpZ.put(MediaSessionManager.class, "media_session");
        bpZ.put(RestrictionsManager.class, "restrictions");
        bpZ.put(TelecomManager.class, "telecom");
        bpZ.put(TvInputManager.class, "tv_input");
      }
      if (Build.VERSION.SDK_INT >= 19)
      {
        bpZ.put(AppOpsManager.class, "appops");
        bpZ.put(CaptioningManager.class, "captioning");
        bpZ.put(ConsumerIrManager.class, "consumer_ir");
        bpZ.put(PrintManager.class, "print");
      }
      if (Build.VERSION.SDK_INT >= 18) {
        bpZ.put(BluetoothManager.class, "bluetooth");
      }
      if (Build.VERSION.SDK_INT >= 17)
      {
        bpZ.put(DisplayManager.class, "display");
        bpZ.put(UserManager.class, "user");
      }
      if (Build.VERSION.SDK_INT >= 16)
      {
        bpZ.put(InputManager.class, "input");
        bpZ.put(MediaRouter.class, "media_router");
        bpZ.put(NsdManager.class, "servicediscovery");
      }
      bpZ.put(AccessibilityManager.class, "accessibility");
      bpZ.put(AccountManager.class, "account");
      bpZ.put(ActivityManager.class, "activity");
      bpZ.put(AlarmManager.class, "alarm");
      bpZ.put(AudioManager.class, "audio");
      bpZ.put(ClipboardManager.class, "clipboard");
      bpZ.put(ConnectivityManager.class, "connectivity");
      bpZ.put(DevicePolicyManager.class, "device_policy");
      bpZ.put(DownloadManager.class, "download");
      bpZ.put(DropBoxManager.class, "dropbox");
      bpZ.put(InputMethodManager.class, "input_method");
      bpZ.put(KeyguardManager.class, "keyguard");
      bpZ.put(LayoutInflater.class, "layout_inflater");
      bpZ.put(LocationManager.class, "location");
      bpZ.put(NfcManager.class, "nfc");
      bpZ.put(NotificationManager.class, "notification");
      bpZ.put(PowerManager.class, "power");
      bpZ.put(SearchManager.class, "search");
      bpZ.put(SensorManager.class, "sensor");
      bpZ.put(StorageManager.class, "storage");
      bpZ.put(TelephonyManager.class, "phone");
      bpZ.put(TextServicesManager.class, "textservices");
      bpZ.put(UiModeManager.class, "uimode");
      bpZ.put(UsbManager.class, "usb");
      bpZ.put(Vibrator.class, "vibrator");
      bpZ.put(WallpaperManager.class, "wallpaper");
      bpZ.put(WifiP2pManager.class, "wifip2p");
      bpZ.put(WifiManager.class, "wifi");
      bpZ.put(WindowManager.class, "window");
      AppMethodBeat.o(195546);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.content.a
 * JD-Core Version:    0.7.0.1
 */