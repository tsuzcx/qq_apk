package c.t.m.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.tencent.map.geolocation.TencentLocation;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class cg
  implements Thread.UncaughtExceptionHandler
{
  private static final String a = TencentLocation.class.getPackage().getName();
  private final Context b;
  private final String c;
  private final String d;
  private final Thread.UncaughtExceptionHandler e;
  
  private cg(Context paramContext, String paramString1, String paramString2)
  {
    this.b = paramContext;
    this.c = paramString1;
    this.d = paramString2;
    this.e = Thread.getDefaultUncaughtExceptionHandler();
  }
  
  private static String a(Context paramContext, Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      Object localObject1 = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      StringBuilder localStringBuilder = new StringBuilder("SDK_V3.1.10_Errlog|");
      localStringBuilder.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date())).append("|");
      localObject2 = (TelephonyManager)paramContext.getSystemService("phone");
      if (localObject2 != null)
      {
        localObject2 = ((TelephonyManager)localObject2).getDeviceId();
        localStringBuilder.append((String)localObject2).append("|");
        localStringBuilder.append("3.1.10|");
        localStringBuilder.append("165965-qq|");
        localStringBuilder.append(paramContext.getPackageName()).append("|");
        localStringBuilder.append(((PackageInfo)localObject1).versionName).append("|");
        localStringBuilder.append(((PackageInfo)localObject1).versionCode).append("|");
        localStringBuilder.append(Build.VERSION.RELEASE).append("|");
        localStringBuilder.append(Build.MODEL).append("|");
        localStringBuilder.append("android-").append(Build.VERSION.SDK_INT).append("|");
        localStringBuilder.append(paramThread.getClass().getName()).append("|");
        localStringBuilder.append("ExceptionClass:").append(paramThrowable.getClass()).append("|");
        localStringBuilder.append("ExceptionMessage:").append(paramThrowable.getMessage()).append("|");
        localStringBuilder.append("ExceptionDetails:");
        localObject1 = new StringWriter();
        paramThread = new PrintWriter((Writer)localObject1);
        paramThrowable.printStackTrace(paramThread);
        localObject1 = localObject1.toString().replaceAll("\r|\n", "__");
        paramThread.close();
        localStringBuilder.append((String)localObject1);
        if ((paramThrowable instanceof LinkageError))
        {
          localStringBuilder.append("|").append(Build.CPU_ABI).append(",").append(Build.CPU_ABI2).append("|");
          paramContext = paramContext.getDir("lib", 0);
          if ((paramContext != null) && (paramContext.isDirectory())) {
            localStringBuilder.append(Arrays.toString(paramContext.list()));
          }
        }
        return localStringBuilder.toString();
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        PackageInfo localPackageInfo = new PackageInfo();
        continue;
        Object localObject2 = "";
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    Object localObject = Thread.getDefaultUncaughtExceptionHandler();
    if (localObject != null) {
      cj.a("UNHANDLED_EXCEPTION", "current handler class=" + localObject.getClass().getName());
    }
    if (!(localObject instanceof cg))
    {
      localObject = new File(paramContext.getDir("txsdklog", 0), "raw");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      Thread.setDefaultUncaughtExceptionHandler(new cg(paramContext, ((File)localObject).getAbsolutePath(), "http://moon.sinaapp.com/andr/uploadlog"));
    }
  }
  
  private static boolean a(Throwable paramThrowable)
  {
    Throwable localThrowable = paramThrowable;
    if (paramThrowable == null) {
      return false;
    }
    for (;;)
    {
      localThrowable = localThrowable.getCause();
      if (localThrowable == null) {
        break;
      }
      paramThrowable = localThrowable.getStackTrace();
      int j = paramThrowable.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramThrowable[i];
        if (("TencentLocation".equals(localObject.getFileName())) || (localObject.getClassName().contains(a))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Object localObject;
    if ((paramThrowable instanceof cm))
    {
      if (bf.a(this.b).a("so").a(null) == null) {
        paramThrowable.initCause(new RuntimeException("PluginLoadSo load failed"));
      }
    }
    else if (a(paramThrowable))
    {
      localObject = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss_", Locale.ENGLISH).format(new Date()) + (int)(Math.random() * 10000.0D);
      localObject = (String)localObject + ".stacktrace";
      String str = a(this.b, paramThread, paramThrowable);
      if (this.d != null) {
        localObject = ch.a(bf.a(this.b), "http://lstest.map.qq.com/stat", str, this.c + "/" + (String)localObject);
      }
    }
    try
    {
      ((CountDownLatch)localObject).await(30L, TimeUnit.SECONDS);
      this.e.uncaughtException(paramThread, paramThrowable);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.cg
 * JD-Core Version:    0.7.0.1
 */