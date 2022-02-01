package sm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.securemodule.impl.AppInfo;
import com.tencent.securemodule.impl.SecureService;
import com.tencent.securemodule.ui.TransparentActivity;

public class ay
{
  public static void a(Context paramContext)
  {
    a(paramContext, 17301628, "QQ安全登录扫描中...", "QQ安全登录扫描中...", "");
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    String str = "危险！QQ安全登录发现" + paramInt + "个病毒";
    a(paramContext, 17301642, str, str, "");
  }
  
  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    Notification localNotification = new Notification();
    localNotification.icon = paramInt;
    localNotification.when = System.currentTimeMillis();
    localNotification.flags = 16;
    localNotification.defaults = 4;
    localNotification.tickerText = paramString1;
    localNotification.setLatestEventInfo(paramContext, paramString2, paramString3, PendingIntent.getActivity(paramContext, 0, new Intent(), 134217728));
    paramContext = (NotificationManager)paramContext.getSystemService("notification");
    paramContext.cancel(1);
    paramContext.notify(1, localNotification);
    paramContext.cancel(1);
  }
  
  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, PendingIntent paramPendingIntent)
  {
    Notification localNotification = new Notification();
    localNotification.icon = paramInt;
    localNotification.when = System.currentTimeMillis();
    localNotification.flags = 16;
    localNotification.defaults = 4;
    localNotification.tickerText = paramString1;
    localNotification.setLatestEventInfo(paramContext, paramString2, paramString3, paramPendingIntent);
    paramContext = (NotificationManager)paramContext.getSystemService("notification");
    paramContext.cancel(2);
    paramContext.notify(2, localNotification);
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    Notification localNotification = new Notification();
    localNotification.icon = 17301633;
    localNotification.when = System.currentTimeMillis();
    localNotification.flags = 16;
    localNotification.defaults = 4;
    PendingIntent localPendingIntent = PendingIntent.getActivity(paramContext, 0, new Intent(), 134217728);
    String str = "";
    if (paramBundle != null)
    {
      long l1 = paramBundle.getLong("key_total");
      long l2 = paramBundle.getLong("key_completed");
      int i = paramBundle.getInt("key_progress");
      paramBundle = new StringBuffer();
      paramBundle.append("下载：");
      paramBundle.append(az.a(paramContext, l2));
      paramBundle.append("/");
      paramBundle.append(az.a(paramContext, l1));
      paramBundle.append("    " + i + "%");
      str = paramBundle.toString();
    }
    localNotification.setLatestEventInfo(paramContext, "腾讯手机管家", str, localPendingIntent);
    ((NotificationManager)paramContext.getSystemService("notification")).notify(2, localNotification);
  }
  
  public static void a(Context paramContext, AppInfo paramAppInfo)
  {
    Notification localNotification = new Notification();
    localNotification.icon = 17301642;
    localNotification.when = System.currentTimeMillis();
    localNotification.flags = 16;
    localNotification.defaults = 4;
    String str = paramAppInfo.getPkgName();
    Object localObject = new Intent();
    ((Intent)localObject).setClass(paramContext, TransparentActivity.class);
    ((Intent)localObject).setAction("1000041");
    ((Intent)localObject).putExtra("data", paramAppInfo);
    localObject = PendingIntent.getActivity(paramContext, 0, (Intent)localObject, 134217728);
    localNotification.setLatestEventInfo(paramContext, "QQ安全登录发现病毒", "“" + paramAppInfo.getSoftName() + "应用”已被病毒感染", (PendingIntent)localObject);
    ((NotificationManager)paramContext.getSystemService("notification")).notify(str.hashCode() + 1, localNotification);
  }
  
  public static void b(Context paramContext)
  {
    a(paramContext, 17301628, "QQ安全登录扫描正常，请放心使用", "QQ安全登录扫描正常，请放心使用", "");
  }
  
  public static void b(Context paramContext, Bundle paramBundle)
  {
    d(paramContext);
  }
  
  public static void c(Context paramContext)
  {
    a(paramContext, 17301642, "QQ安全登录扫描联网超时，无法判断风险", "QQ安全登录扫描联网超时，无法判断风险", "");
  }
  
  public static void d(Context paramContext)
  {
    ((NotificationManager)paramContext.getSystemService("notification")).cancel(2);
  }
  
  public static void e(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, SecureService.class);
    localIntent.setAction("1000011");
    a(paramContext, 17301642, "腾讯手机管家下载失败", "腾讯手机管家下载失败", "点击继续下载？", PendingIntent.getService(paramContext, 0, localIntent, 134217728));
  }
  
  public static void f(Context paramContext)
  {
    Toast.makeText(paramContext, "开始下载手机管家", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     sm.ay
 * JD-Core Version:    0.7.0.1
 */