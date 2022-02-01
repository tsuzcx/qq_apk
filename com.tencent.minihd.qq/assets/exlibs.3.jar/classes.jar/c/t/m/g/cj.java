package c.t.m.g;

import android.util.Log;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.map.geolocation.internal.TencentLog;

public final class cj
{
  public static final boolean a = ;
  
  public static void a() {}
  
  private static void a(String paramString1, int paramInt, String paramString2)
  {
    TencentLog localTencentLog = TencentExtraKeys.getTencentLog();
    if ((localTencentLog != null) && (paramString2 != null)) {
      localTencentLog.println(paramString1, paramInt, paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (a) {
      a(paramString1, 4, paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a) {
      a(paramString1, 6, paramString2 + " exception: " + Log.getStackTraceString(paramThrowable));
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (a) {
      a(paramString1, 6, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.cj
 * JD-Core Version:    0.7.0.1
 */