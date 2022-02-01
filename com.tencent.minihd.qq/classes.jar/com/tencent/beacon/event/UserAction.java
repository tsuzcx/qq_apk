package com.tencent.beacon.event;

import android.content.Context;
import com.tencent.beacon.a.g;
import com.tencent.beacon.a.h;
import com.tencent.beacon.upload.UploadHandleListener;
import java.util.List;
import java.util.Map;

public class UserAction
{
  protected static Map<String, String> a = null;
  private static Context b = null;
  private static String c = "";
  private static String d = "10000";
  
  private static void a(Context paramContext, UploadHandleListener paramUploadHandleListener, boolean paramBoolean, long paramLong)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.c(" the context is null! init beacon sdk failed!", new Object[0]);
      return;
    }
    Context localContext = paramContext.getApplicationContext();
    if (localContext != null) {}
    for (b = localContext;; b = paramContext)
    {
      if (paramLong > 0L)
      {
        long l = paramLong;
        if (paramLong > 10000L) {
          l = 10000L;
        }
        com.tencent.beacon.a.b.d.a(l);
      }
      paramContext = n.a(b, paramBoolean);
      n.a(b, true, paramContext, paramUploadHandleListener, null);
      com.tencent.beacon.b.d.a(b, paramContext);
      return;
    }
  }
  
  public static void clearAppTotalConsume(Context paramContext)
  {
    h.e(paramContext.getApplicationContext());
  }
  
  public static void clearSDKTotalConsume(Context paramContext)
  {
    h.d(paramContext.getApplicationContext());
  }
  
  public static void closeUseInfoEvent()
  {
    n localn = n.d();
    if (localn != null) {
      localn.f();
    }
  }
  
  public static void doUploadRecords()
  {
    n.c(false);
  }
  
  public static long getAppTotalConsume(Context paramContext, boolean paramBoolean)
  {
    paramContext = h.c(paramContext.getApplicationContext());
    if (paramContext != null)
    {
      if (paramBoolean) {
        return paramContext.e;
      }
      return paramContext.d + paramContext.e;
    }
    return -1L;
  }
  
  public static String getCloudParas(String paramString)
  {
    String str = null;
    Map localMap = com.tencent.beacon.a.b.e.a().d();
    if (localMap != null) {
      str = (String)localMap.get(paramString);
    }
    return str;
  }
  
  public static String getGatewayIP()
  {
    com.tencent.beacon.a.e locale = com.tencent.beacon.a.e.m();
    if (locale != null) {
      return locale.g();
    }
    return "unknown";
  }
  
  public static String getQIMEI()
    throws Exception
  {
    if ((b == null) || (n.d() == null))
    {
      com.tencent.beacon.d.a.d("please initUserAction first!", new Object[0]);
      throw new RuntimeException("please initUserAction first!");
    }
    if (n.d().j() <= 0)
    {
      com.tencent.beacon.d.a.d("call this function getQIMEI untimely!", new Object[0]);
      return "";
    }
    return com.tencent.beacon.b.a.a(b).a();
  }
  
  public static String getQQ()
  {
    return c;
  }
  
  public static long getSDKTotalConsume(Context paramContext, boolean paramBoolean)
  {
    paramContext = h.b(paramContext.getApplicationContext());
    if (paramContext != null)
    {
      if (paramBoolean) {
        return paramContext.e;
      }
      return paramContext.d + paramContext.e;
    }
    return -1L;
  }
  
  public static String getSDKVersion()
  {
    return "1.8.5";
  }
  
  public static e getUserActionRuntimeStrategy()
  {
    try
    {
      e locale = n.d().i();
      return locale;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public static String getUserID()
  {
    return d;
  }
  
  @Deprecated
  public static boolean heartbeatEvent()
  {
    com.tencent.beacon.d.a.c(" heartbeatEvent is Deprecated !", new Object[0]);
    return true;
  }
  
  public static void initUserAction(Context paramContext)
  {
    a(paramContext, null, true, 0L);
  }
  
  public static void initUserAction(Context paramContext, boolean paramBoolean)
  {
    a(paramContext, null, paramBoolean, 0L);
  }
  
  public static void initUserAction(Context paramContext, boolean paramBoolean, long paramLong)
  {
    a(paramContext, null, paramBoolean, paramLong);
  }
  
  public static void initUserAction(Context paramContext, boolean paramBoolean, long paramLong, UploadHandleListener paramUploadHandleListener)
  {
    a(paramContext, paramUploadHandleListener, paramBoolean, paramLong);
  }
  
  public static boolean loginEvent(boolean paramBoolean, long paramLong, Map<String, String> paramMap)
  {
    return n.a("rqd_wgLogin", paramBoolean, paramLong, 0L, paramMap, true);
  }
  
  public static void onAppExited() {}
  
  public static boolean onMergeUserAction(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2, c... paramVarArgs)
  {
    if ((paramString == null) || ("".equals(paramString.trim()))) {
      com.tencent.beacon.d.a.c("param eventName is null or \"\", please check it, return false! ", new Object[0]);
    }
    while (g.b(paramString) == null) {
      return false;
    }
    return n.a(paramString, paramBoolean1, paramLong1, paramLong2, paramBoolean2, paramVarArgs);
  }
  
  public static boolean onUserAction(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2)
  {
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      com.tencent.beacon.d.a.c("param eventName is null or \"\", please check it, return false! ", new Object[0]);
      return false;
    }
    paramString = g.b(paramString);
    if (paramString == null) {
      return false;
    }
    return n.a(paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2);
  }
  
  public static void setAdditionalInfo(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() <= 10)) {
      a = paramMap;
    }
  }
  
  public static void setAppKey(Context paramContext, String paramString)
    throws Exception
  {
    com.tencent.beacon.d.a.a(" setAppKey:" + paramString, new Object[0]);
    if (paramContext == null) {
      com.tencent.beacon.d.a.c(" the context is null! setAppKey failed!", new Object[0]);
    }
    label111:
    label117:
    for (;;)
    {
      return;
      Context localContext = paramContext.getApplicationContext();
      if (localContext != null)
      {
        b = localContext;
        if ((paramString == null) || (paramString.trim().length() <= 0) || (paramString.trim().length() >= 20)) {
          break;
        }
        paramContext = com.tencent.beacon.a.e.m();
        if (paramContext != null) {
          break label111;
        }
        com.tencent.beacon.a.e.a(b);
        paramContext = com.tencent.beacon.a.e.m();
      }
      for (;;)
      {
        if (paramContext == null) {
          break label117;
        }
        paramContext.d(paramString);
        return;
        b = paramContext;
        break;
        paramContext.d(paramString);
      }
    }
    com.tencent.beacon.d.a.c(" setAppKey: appkey is null or not available!", new Object[0]);
    throw new RuntimeException("appkey is null or not available! please check it!");
  }
  
  @Deprecated
  public static void setAutoLaunchEventUsable(boolean paramBoolean) {}
  
  public static void setChannelID(String paramString)
  {
    com.tencent.beacon.a.e locale2 = com.tencent.beacon.a.e.m();
    com.tencent.beacon.a.e locale1 = locale2;
    if (locale2 == null)
    {
      com.tencent.beacon.a.e.a(b);
      locale1 = com.tencent.beacon.a.e.m();
    }
    if (locale1 == null)
    {
      com.tencent.beacon.d.a.d("please set the channelID after call initUserAction!", new Object[0]);
      return;
    }
    locale1.c(g.d(paramString));
  }
  
  public static void setInitChannelPath(Context paramContext, String paramString)
    throws Exception
  {
    if (b == null)
    {
      com.tencent.beacon.a.a.a(paramContext.getApplicationContext(), paramString);
      return;
    }
    com.tencent.beacon.d.a.d("please set the channel path before call initUserAction!", new Object[0]);
    throw new RuntimeException("please set the channel path before call initUserAction!");
  }
  
  public static void setLogAble(boolean paramBoolean1, boolean paramBoolean2)
  {
    com.tencent.beacon.d.a.a = paramBoolean1;
    com.tencent.beacon.d.a.b = paramBoolean2;
  }
  
  @Deprecated
  public static void setNetSpeedMonitorUsable(boolean paramBoolean)
  {
    com.tencent.beacon.d.a.c(" SpeedMonitorModule is Deprecated !", new Object[0]);
  }
  
  public static void setQQ(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (Long.parseLong(paramString) > 10000L) {
          c = paramString;
        }
        return;
      }
      catch (Exception paramString)
      {
        com.tencent.beacon.d.a.c(" setQQ: set qq is not available !", new Object[0]);
        return;
      }
    }
    com.tencent.beacon.d.a.c(" setQQ: set qq is null !", new Object[0]);
  }
  
  public static void setUploadMode(boolean paramBoolean)
  {
    n localn = n.d();
    if (localn != null)
    {
      localn.b(paramBoolean);
      return;
    }
    com.tencent.beacon.d.a.c(" UserActionRecord.getInstance is null, please initUserAction first!", new Object[0]);
  }
  
  public static void setUserActionUsable(boolean paramBoolean)
  {
    n localn = n.d();
    if (localn != null)
    {
      localn.a(paramBoolean);
      return;
    }
    com.tencent.beacon.d.a.c(" UserActionRecord.getInstance is null, please initUserAction first!", new Object[0]);
  }
  
  public static void setUserID(String paramString)
  {
    com.tencent.beacon.d.a.a(" setUserID:" + paramString, new Object[0]);
    if ((paramString != null) && (paramString.trim().length() > 0) && (!"10000".equals(paramString)) && (!"10000".equals(g.c(paramString)))) {
      d = paramString;
    }
  }
  
  public static boolean testSpeedDomain(List<String> paramList)
  {
    n localn = n.d();
    if (localn != null) {
      return localn.b(paramList);
    }
    return false;
  }
  
  public static boolean testSpeedIp(List<String> paramList)
  {
    n localn = n.d();
    if (localn != null) {
      return localn.a(paramList);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.beacon.event.UserAction
 * JD-Core Version:    0.7.0.1
 */