package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.proguard.n;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class b
{
  public static boolean a;
  public static List<a> b = new ArrayList();
  public static boolean c;
  private static p d;
  private static boolean e;
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean, BuglyStrategy paramBuglyStrategy)
  {
    Context localContext;
    com.tencent.bugly.crashreport.common.info.a locala1;
    com.tencent.bugly.crashreport.common.strategy.a locala;
    n localn;
    int i;
    label295:
    do
    {
      for (;;)
      {
        try
        {
          if (e)
          {
            x.d("[init] initial Multi-times, ignore this.", new Object[0]);
            return;
          }
          if (paramContext == null)
          {
            Log.w(x.b, "[init] context is null, check it.");
            continue;
          }
          if (paramString != null) {
            break;
          }
        }
        finally {}
        Log.e(x.b, "init arg 'crashReportAppID' should not be null!");
      }
      e = true;
      if (paramBoolean)
      {
        c = true;
        x.c = true;
        x.d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
        x.e("--------------------------------------------------------------------------------------------", new Object[0]);
        x.d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
        x.d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
        x.d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
        x.d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
        x.e("--------------------------------------------------------------------------------------------", new Object[0]);
        x.b("[init] Open debug mode of Bugly.", new Object[0]);
      }
      x.a("[init] Bugly version: v%s", new Object[] { "2.8.1" });
      x.a(" crash report start initializing...", new Object[0]);
      x.b("[init] Bugly start initializing...", new Object[0]);
      x.a("[init] Bugly complete version: v%s", new Object[] { "2.8.1" });
      localContext = z.a(paramContext);
      locala1 = com.tencent.bugly.crashreport.common.info.a.a(localContext);
      locala1.s();
      y.a(localContext);
      d = p.a(localContext, b);
      u.a(localContext);
      locala = com.tencent.bugly.crashreport.common.strategy.a.a(localContext, b);
      localn = n.a(localContext);
      paramContext = locala1.q;
      locala1.getClass();
      if ((paramContext == null) || (!paramContext.contains("bugly"))) {
        break;
      }
      i = 1;
    } while (i != 0);
    locala1.a(paramString);
    x.a("[param] Set APP ID:%s", new Object[] { paramString });
    if (paramBuglyStrategy != null)
    {
      paramContext = paramBuglyStrategy.getAppVersion();
      if (!TextUtils.isEmpty(paramContext))
      {
        if (paramContext.length() <= 100) {
          break label888;
        }
        paramString = paramContext.substring(0, 100);
        x.d("appVersion %s length is over limit %d substring to %s", new Object[] { paramContext, Integer.valueOf(100), paramString });
        paramContext = paramString;
      }
    }
    label842:
    label879:
    label882:
    label885:
    label888:
    for (;;)
    {
      for (;;)
      {
        locala1.l = paramContext;
        x.a("[param] Set App version: %s", new Object[] { paramBuglyStrategy.getAppVersion() });
        try
        {
          if (paramBuglyStrategy.isReplaceOldChannel())
          {
            paramContext = paramBuglyStrategy.getAppChannel();
            if (!TextUtils.isEmpty(paramContext))
            {
              if (paramContext.length() <= 100) {
                break label885;
              }
              paramString = paramContext.substring(0, 100);
              x.d("appChannel %s length is over limit %d substring to %s", new Object[] { paramContext, Integer.valueOf(100), paramString });
              paramContext = paramString;
              d.a(556, "app_channel", paramContext.getBytes(), null, false);
              locala1.n = paramContext;
            }
            x.a("[param] Set App channel: %s", new Object[] { locala1.n });
            paramContext = paramBuglyStrategy.getAppPackageName();
            if (!TextUtils.isEmpty(paramContext))
            {
              if (paramContext.length() <= 100) {
                break label882;
              }
              paramString = paramContext.substring(0, 100);
              x.d("appPackageName %s length is over limit %d substring to %s", new Object[] { paramContext, Integer.valueOf(100), paramString });
              paramContext = paramString;
              locala1.c = paramContext;
              x.a("[param] Set App package: %s", new Object[] { paramBuglyStrategy.getAppPackageName() });
            }
            paramContext = paramBuglyStrategy.getDeviceID();
            if (paramContext != null)
            {
              if (paramContext.length() <= 100) {
                break label879;
              }
              paramString = paramContext.substring(0, 100);
              x.d("deviceId %s length is over limit %d substring to %s", new Object[] { paramContext, Integer.valueOf(100), paramString });
              paramContext = paramString;
              locala1.c(paramContext);
              x.a("[param] Set device ID: %s", new Object[] { paramContext });
            }
            locala1.f = paramBuglyStrategy.isUploadProcess();
            y.a = paramBuglyStrategy.isBuglyLogUpload();
            com.tencent.bugly.crashreport.biz.b.a(localContext, paramBuglyStrategy);
            i = 0;
            int j = b.size();
            if (i >= j) {
              break label842;
            }
          }
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            try
            {
              if (localn.a(((a)b.get(i)).id)) {
                ((a)b.get(i)).init(localContext, paramBoolean, paramBuglyStrategy);
              }
              i += 1;
              continue;
              i = 0;
              break label295;
              paramContext = d.a(556, null, true);
              if (paramContext == null) {
                continue;
              }
              paramContext = (byte[])paramContext.get("app_channel");
              if (paramContext == null) {
                continue;
              }
              locala1.n = new String(paramContext);
              continue;
              paramContext = paramContext;
              if (!c) {
                continue;
              }
              paramContext.printStackTrace();
            }
            catch (Throwable paramContext)
            {
              if (x.a(paramContext)) {
                continue;
              }
              paramContext.printStackTrace();
              continue;
            }
            if (paramBuglyStrategy != null) {}
            for (long l = paramBuglyStrategy.getAppReportDelay();; l = 0L)
            {
              locala.a(l);
              x.b("[init] Bugly initialization finished.", new Object[0]);
              break;
            }
            continue;
          }
        }
      }
    }
  }
  
  public static void a(a parama)
  {
    try
    {
      if (!b.contains(parama)) {
        b.add(parama);
      }
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.bugly.b
 * JD-Core Version:    0.7.0.1
 */