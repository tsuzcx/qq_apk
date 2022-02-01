package c.t.m.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class h
{
  public static boolean a = true;
  private static final Lock b = new ReentrantLock();
  private static a c = null;
  
  public static a a(Context paramContext, String paramString1, String paramString2, String paramString3)
    throws l
  {
    ax.b("AccessSchedulerManager", "creatAccessScheduler...context:" + paramContext + ",appId:" + paramString1 + ",channelId:" + paramString2 + ",uuid:" + paramString3);
    if ((paramContext == null) || (ay.a(paramString1))) {
      throw new l("AccessScheduler init illegal Argument[appId=" + paramString1 + ",context=" + paramContext + "]");
    }
    b.lock();
    for (;;)
    {
      try
      {
        if (c == null)
        {
          String str;
          if (!ay.a(paramString3))
          {
            str = paramString3;
            if (!paramString3.toLowerCase().contains("test")) {}
          }
          else
          {
            SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("Access_Preferences", 0);
            str = paramString3;
            if (localSharedPreferences != null)
            {
              paramString3 = localSharedPreferences.getString("test_uuid", "");
              str = paramString3;
              if (ay.a(paramString3))
              {
                str = ay.a(paramContext) + "_" + ay.b(paramContext);
                localSharedPreferences.edit().putString("test_uuid", str).commit();
              }
            }
          }
          paramString3 = paramString2;
          if (ay.a(paramString2)) {
            paramString3 = "test_channelId";
          }
          o.a(paramContext, paramString1, paramString3, str);
          aw.a(paramContext);
          c = new e(paramString1, paramString3, str);
          new Thread((Runnable)c).start();
          return c;
        }
        paramContext = (e)c;
        if ((paramContext.a.equals(paramString1)) && (paramContext.b.equals(paramString2)) && (paramContext.c.equals(paramString3)))
        {
          i = 1;
          if (i != 0) {
            continue;
          }
          paramContext = (e)c;
          throw new l("AccessScheduler [" + paramContext.a + "," + paramContext.c + "] is already in used");
        }
      }
      finally
      {
        b.unlock();
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.h
 * JD-Core Version:    0.7.0.1
 */