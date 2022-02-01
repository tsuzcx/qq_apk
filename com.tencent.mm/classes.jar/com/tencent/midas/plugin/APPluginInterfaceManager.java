package com.tencent.midas.plugin;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.data.APPluginReportManager;
import java.lang.reflect.Method;

public class APPluginInterfaceManager
{
  public static final String TAG = "APPluginInterfaceManager";
  
  /* Error */
  private static Class<?> getObjectClass(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 18
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: invokestatic 30	com/tencent/midas/plugin/APPluginInstallerAndUpdater:getInstallPath	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   10: invokevirtual 36	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   13: astore_3
    //   14: getstatic 42	com/tencent/midas/plugin/APPluginStatic:sPackageInfoMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   17: aload_3
    //   18: invokevirtual 48	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 50	android/content/pm/PackageInfo
    //   24: ifnonnull +40 -> 64
    //   27: aload_0
    //   28: aload_3
    //   29: iconst_1
    //   30: invokestatic 56	com/tencent/midas/plugin/APApkFileParser:getPackageInfo	(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   33: astore 4
    //   35: aload 4
    //   37: ifnonnull +17 -> 54
    //   40: ldc 18
    //   42: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aconst_null
    //   46: areturn
    //   47: astore_3
    //   48: ldc 61
    //   50: astore_3
    //   51: goto -37 -> 14
    //   54: getstatic 42	com/tencent/midas/plugin/APPluginStatic:sPackageInfoMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   57: aload_3
    //   58: aload 4
    //   60: invokevirtual 65	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   63: pop
    //   64: aload_0
    //   65: aload_1
    //   66: aload_3
    //   67: invokestatic 71	com/tencent/midas/plugin/APPluginLoader:getOrCreateClassLoaderByPath	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ldalvik/system/DexClassLoader;
    //   70: aload_2
    //   71: invokevirtual 77	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   74: astore_0
    //   75: ldc 18
    //   77: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload_0
    //   81: areturn
    //   82: astore_0
    //   83: aconst_null
    //   84: astore_0
    //   85: goto -10 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramContext	Context
    //   0	88	1	paramString1	String
    //   0	88	2	paramString2	String
    //   0	88	3	paramString3	String
    //   33	26	4	localPackageInfo	android.content.pm.PackageInfo
    // Exception table:
    //   from	to	target	type
    //   5	14	47	java/lang/Exception
    //   14	35	82	java/lang/Exception
    //   54	64	82	java/lang/Exception
    //   64	75	82	java/lang/Exception
  }
  
  private static Class<?>[] getParamsType(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(193207);
    Object localObject = null;
    if (paramArrayOfObject != null)
    {
      int j = paramArrayOfObject.length;
      Class[] arrayOfClass = new Class[j];
      int i = 0;
      localObject = arrayOfClass;
      if (i < j)
      {
        if (paramArrayOfObject[i] != null)
        {
          if (!Activity.class.isAssignableFrom(paramArrayOfObject[i].getClass())) {
            break label63;
          }
          arrayOfClass[i] = Activity.class;
        }
        for (;;)
        {
          i += 1;
          break;
          label63:
          arrayOfClass[i] = paramArrayOfObject[i].getClass();
        }
      }
    }
    AppMethodBeat.o(193207);
    return localObject;
  }
  
  public static Object initPluginInterface(Context paramContext, String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(193206);
    APLog.d("APPluginInterfaceManager", "Call into initPluginInterface  plugin = " + paramString1 + " interfaceClass = " + paramString2 + " methodName = " + paramString3 + " " + java.lang.Thread.currentThread().getStackTrace()[3].toString());
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      APLog.i("APPLuginProxyActivity", "initPluginInterface objClass param is null");
      AppMethodBeat.o(193206);
      return null;
    }
    paramString2 = getObjectClass(paramContext, paramString1, paramString2, paramString3);
    if (paramString2 == null)
    {
      APPluginReportManager.getInstance().insertData("timename.launchpay", "sdk.loadapk_fail", paramString1, "objClassIsNull");
      if (APMidasPayHelper.MED_DISTRIBUTE_PAY.equals(paramString3))
      {
        APLog.d("APPluginInterfaceManager", "initPluginInterface objClass is null, current method name = " + paramString3 + " we need to jump to pure h5 pay!");
        APPluginUtils.showLaunchPluginFail(paramContext.getApplicationContext(), "", true);
      }
      for (;;)
      {
        APPluginStatic.removeAll();
        APPluginInstallerAndUpdater.unInstallPlugin(paramContext);
        AppMethodBeat.o(193206);
        return null;
        APLog.d("APPluginInterfaceManager", "initPluginInterface objClass is null, current method name = " + paramString3 + " no need to jump to pure h5 pay!");
        APPluginUtils.showLaunchPluginFail(paramContext.getApplicationContext(), "", false);
      }
    }
    paramContext = paramString2.getMethod(paramString3, getParamsType(paramArrayOfObject));
    paramContext.setAccessible(true);
    long l1 = System.currentTimeMillis();
    paramString1 = paramContext.invoke(paramString2, paramArrayOfObject);
    long l2 = System.currentTimeMillis();
    APLog.i("APPLuginProxyActivity", "initPluginInterface method=" + paramContext + " obj=" + paramString1 + " time=" + (l2 - l1));
    AppMethodBeat.o(193206);
    return paramString1;
  }
  
  public static Object initPluginInterface(Context paramContext, String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
  {
    int i = 0;
    AppMethodBeat.i(193209);
    APLog.i("APPLuginProxyActivity", "initPluginInterface2 pluginName=".concat(String.valueOf(paramString1)));
    APLog.i("APPLuginProxyActivity", "initPluginInterface2 interfaceClass=".concat(String.valueOf(paramString2)));
    APLog.i("APPLuginProxyActivity", "initPluginInterface2 methodName=".concat(String.valueOf(paramString3)));
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      APLog.i("APPLuginProxyActivity", "initPluginInterface2 objClass param is null");
      AppMethodBeat.o(193209);
      return null;
    }
    paramString2 = getObjectClass(paramContext, paramString1, paramString2, paramString3);
    if (paramString2 == null)
    {
      APLog.i("APPLuginProxyActivity", "initPluginInterface2 objClass is null");
      APPluginReportManager.getInstance().insertData("timename.launchpay", "sdk.loadapk_fail", paramString1, "objClassIsNull");
      APPluginUtils.showLaunchPluginFail(paramContext.getApplicationContext(), "", false);
      APPluginStatic.removeAll();
      APPluginInstallerAndUpdater.unInstallPlugin(paramContext);
      AppMethodBeat.o(193209);
      return null;
    }
    APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod Name:".concat(String.valueOf(paramString3)));
    APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod objClass:".concat(String.valueOf(paramString2)));
    while (i < paramArrayOfClass.length)
    {
      APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod paraTypes:" + paramArrayOfClass[i]);
      i += 1;
    }
    paramContext = paramString2.getMethod(paramString3, paramArrayOfClass);
    APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod method:".concat(String.valueOf(paramContext)));
    paramContext.setAccessible(true);
    paramContext = paramContext.invoke(paramString2, paramArrayOfObject);
    APLog.i("APPLuginProxyActivity", "initPluginInterface2 obj=".concat(String.valueOf(paramContext)));
    AppMethodBeat.o(193209);
    return paramContext;
  }
  
  public static Object initPluginInterface2(Context paramContext, String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    int i = 0;
    AppMethodBeat.i(193208);
    APLog.i("APPLuginProxyActivity", "initPluginInterface2 pluginName=".concat(String.valueOf(paramString1)));
    APLog.i("APPLuginProxyActivity", "initPluginInterface2 interfaceClass=".concat(String.valueOf(paramString2)));
    APLog.i("APPLuginProxyActivity", "initPluginInterface2 methodName=".concat(String.valueOf(paramString3)));
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      APLog.i("APPLuginProxyActivity", "initPluginInterface2 objClass param is null");
      AppMethodBeat.o(193208);
      return null;
    }
    paramString2 = getObjectClass(paramContext, paramString1, paramString2, paramString3);
    if (paramString2 == null)
    {
      APLog.i("APPLuginProxyActivity", "initPluginInterface2 objClass is null");
      APPluginReportManager.getInstance().insertData("timename.launchpay", "sdk.loadapk_fail", paramString1, "objClassIsNull");
      APPluginUtils.showLaunchPluginFail(paramContext.getApplicationContext(), "", false);
      APPluginStatic.removeAll();
      APPluginInstallerAndUpdater.unInstallPlugin(paramContext);
      AppMethodBeat.o(193208);
      return null;
    }
    paramContext = new Class[3];
    paramContext[0] = paramArrayOfObject[0].getClass();
    paramContext[1] = paramArrayOfObject[1].getClass();
    paramContext[2] = paramArrayOfObject[2].getClass();
    APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod Name:".concat(String.valueOf(paramString3)));
    APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod objClass:".concat(String.valueOf(paramString2)));
    while (i < 3)
    {
      APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod paraTypes:" + paramContext[i]);
      i += 1;
    }
    paramContext = paramString2.getMethod(paramString3, paramContext);
    APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod method:".concat(String.valueOf(paramContext)));
    paramContext.setAccessible(true);
    paramContext = paramContext.invoke(paramString2, paramArrayOfObject);
    APLog.i("APPLuginProxyActivity", "initPluginInterface2 obj=".concat(String.valueOf(paramContext)));
    AppMethodBeat.o(193208);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.plugin.APPluginInterfaceManager
 * JD-Core Version:    0.7.0.1
 */