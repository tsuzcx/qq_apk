package c.t.m.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public final class o
{
  private static Context a = null;
  private static String b = "";
  private static String c = "null";
  private static int d = 0;
  private static String e = "";
  private static String f = "";
  private static String g = "1.1.4.022";
  
  public static Context a()
  {
    return a;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    a = paramContext.getApplicationContext();
    b = paramString1;
    e = paramString3;
    f = paramString2;
    g = "1.1.4.022";
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      c = paramContext.versionName;
      d = paramContext.versionCode;
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static String b()
  {
    return b;
  }
  
  public static String c()
  {
    return c;
  }
  
  public static int d()
  {
    return d;
  }
  
  public static String e()
  {
    return e;
  }
  
  public static String f()
  {
    return g;
  }
  
  public static String g()
  {
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     c.t.m.g.o
 * JD-Core Version:    0.7.0.1
 */